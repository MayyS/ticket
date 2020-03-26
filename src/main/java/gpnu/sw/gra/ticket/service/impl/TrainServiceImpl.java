package gpnu.sw.gra.ticket.service.impl;

import gpnu.sw.gra.ticket.common.UrlAll;
import gpnu.sw.gra.ticket.dao.JedisDao;
import gpnu.sw.gra.ticket.myconfig.propertie.AppResultDesc;
import gpnu.sw.gra.ticket.common.MsgTip;
import gpnu.sw.gra.ticket.dto.QueryObj;
import gpnu.sw.gra.ticket.dto.base.AppResult;
import gpnu.sw.gra.ticket.pojo.Passenger;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.pojo.TicketInfo;
import gpnu.sw.gra.ticket.service.TrainService;
import gpnu.sw.gra.ticket.util.CookieUtils;
import gpnu.sw.gra.ticket.util.HttpClientUtil;
import gpnu.sw.gra.ticket.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther:S
 * @Date:20/3/17
 */

@Service
public class TrainServiceImpl implements TrainService {

    private static final int outTime=60*60*24;
    private static final String cookieName="token";
    private static final String pre=UrlAll.PRE.getName();
    private static final String STATINFO_REVERSE="stationInfo_reverse";
    private static final String STATINFO="stationInfo";
    private static final String QUERYSTR="queryStr";


    @Autowired
    private JedisDao jedisDaoImpl;


    private Map<String,String> toMap(TUser user){
        Map<String,String>params=new HashMap<>();
        if(user==null){
            return params;
        }
        params.put("username",user.getUsername());
        params.put("password",user.getPassword());
        return params;
    }


    @Override
    public AppResult checked(TUser user) {
        String url= pre+UrlAll.CECK.getName();
        Map<String,String>param=toMap(user);
        String result=HttpClientUtil.doPost(url,param);
        Map<String,Object>mp= JsonUtil.jsonToMap(result);
        AppResult at=new AppResult();
        mp=(Map<String,Object>)mp.get(AppResultDesc.REP);
        if(mp.size()>0){
            int status=Integer.parseInt(mp.get(AppResultDesc.Rep.STATUS).toString());
            at.setStatus(status);

            String msg;
            if(status!=200){
                msg=mp.get("msg").toString();
            }else{
                msg="您好！"+mp.get("username").toString();
            }
            at.setMsg(msg);
            at.setObj(mp);
        }else{
            at.setStatus(MsgTip.ECHECK.getCode());
            at.setMsg(MsgTip.ECHECK.getMsg());
        }

        return at;
    }

    @Override
    public AppResult login(TUser user, HttpServletRequest req, HttpServletResponse res) {
        AppResult ar=new AppResult();

        //url
        String url=pre+UrlAll.LOGIN.getName();
        //param
        Map<String,String>param=toMap(user);
        //send And return
        String result=HttpClientUtil.doPost(url,param);
        Map<String,Object>mp= JsonUtil.jsonToMap(result);
        Map<String,Object>reps=(Map<String,Object>)mp.get(AppResultDesc.REP);


        if(reps.size()>0&&reps.get(AppResultDesc.Rep.STATUS).toString().equals("200")){
            ar.setStatus(200);
            String key= UUID.randomUUID().toString();
            String vaule=JsonUtil.objectToJson(mp.get(AppResultDesc.REQ_COOKIES));
            jedisDaoImpl.set(key,vaule);
            jedisDaoImpl.expire(key,outTime);
            CookieUtils.setCookie(req,res,cookieName,key,outTime);
            ar.setMsg(MsgTip.LOGIN.getMsg());
            ar.setObj(reps);
        }else{
            ar.setStatus(Integer.valueOf(reps.get(AppResultDesc.Rep.STATUS).toString()));
            ar.setMsg(reps.get("msg").toString());
        }
        return ar;
    }

    @Override
    public AppResult getPassengers(String token) {
        AppResult ar=new AppResult();

        String url=pre+UrlAll.PASSENGERS.getName();

        Map<String,String>param=new HashMap<>();
        String value=jedisDaoImpl.get(token);
        param.put(cookieName,value);


        String result=HttpClientUtil.doPost(url,param);
        Map<String,Object>rmp=JsonUtil.jsonToMap(result);
        int trycn=10;
        while (rmp!=null&&!rmp.get(AppResultDesc.Rep.STATUS).equals(200)&&trycn-->0){
            result=HttpClientUtil.doPost(url,param);
            rmp=JsonUtil.jsonToMap(result);

        }
        List<Passenger>passengers;
        if(trycn>0){
            ar.setMsg(MsgTip.GETPSGER.getMsg());
            //passengers=JsonUtil.jsonToList( rmp.get(AppResultDesc.DATA).toString(),Passenger.class);
            passengers=JsonUtil.jsonToList(rmp.get(AppResultDesc.DATA).toString());

            ar.setObj(passengers);
        }else{
            ar.setMsg(MsgTip.EGETPSGER.getMsg());
        }

        return ar;
    }


    @Override
    public AppResult queryTicket(QueryObj queryObj) {
        AppResult ar=new AppResult();
        queryObj.setFrom(getStationByChinese(queryObj.getFromH()));
        queryObj.setTo(getStationByChinese(queryObj.getToH()));
        String url=pre+UrlAll.QUERYTICKET.getName();
        String v=JsonUtil.objectToJson(queryObj);
        Map<String,String>params=new HashMap<>();
        params.put(QUERYSTR,v);
        String result=HttpClientUtil.doPost(url,params);
        if(result.contains("500 Internal Server Error")){
            ar.setStatus(MsgTip.EQEYTICKET.getCode());
            ar.setMsg(MsgTip.EQEYTICKET.getMsg());
            return ar;
        }
        Map<String,Object>mp=JsonUtil.jsonToMap(result);
        mp=(Map<String, Object>) mp.get(AppResultDesc.REP);
        List<TicketInfo>ticketInfos;
        if(Integer.valueOf(mp.get(AppResultDesc.Rep.STATUS).toString())==200){
            ar.setStatus(MsgTip.QEYTICKET.getCode());
            ticketInfos=JsonUtil.jsonToListOfTicket(mp.get(AppResultDesc.Rep.DATA).toString());
            decode(ticketInfos);
            ar.setObj(ticketInfos);
            ar.setMsg(MsgTip.QUERY.getMsg());
        }else{
            ar.setMsg(MsgTip.EQUERY.getMsg());
        }
        return ar;
    }

    private void decode(List<TicketInfo>list){
        if(list==null||list.size()<=0){
            return;
        }
        String frm,to;
        for (TicketInfo item:list){
            frm=item.getQryFrm();
            to=item.getQryTo();
            item.setQryFrm(getStationByChars(frm));
            item.setQryTo(getStationByChars(to));
        }
    }


    @Override
    public String getStationByChinese(String key) {
        if(!jedisDaoImpl.exists(STATINFO)){
            stationNameInfo();
        }
        String res=jedisDaoImpl.hget(STATINFO,key);
        return res;
    }
    public String getStationByChars(String key) {
        if(!jedisDaoImpl.exists(STATINFO_REVERSE)){
            stationNameInfo();
        }
        String res=jedisDaoImpl.hget(STATINFO_REVERSE,key);
        return res;
    }


    @Override
    public AppResult stationNameInfo() {
        AppResult ar=new AppResult();
        String url=pre+UrlAll.STATIONNAMEINFO.getName();
        Map<String,String>rM;
        if(jedisDaoImpl.exists(STATINFO)){
           rM=jedisDaoImpl.hgetALl(STATINFO);
        }else{
            String result=HttpClientUtil.doGet(url);
            rM=JsonUtil.jsonToStringMap(result,true);
            if(rM.size()>3){
                String flag=jedisDaoImpl.hset(STATINFO_REVERSE,rM);
                System.out.println("flag:"+flag);
            }else{
                ar.setMsg(MsgTip.EGETSTATION.getMsg());
                return ar;
            }
            rM=JsonUtil.jsonToStringMap(result,false);
            if(rM.size()>3){
                String flag=jedisDaoImpl.hset(STATINFO,rM);
                System.out.println("flag:"+flag);
            }else{
                ar.setMsg(MsgTip.EGETSTATION.getMsg());
                return ar;
            }
        }
        ar.setStatus(MsgTip.GETSTATION.getCode());
        ar.setMsg(MsgTip.GETSTATION.getMsg());
        ar.setObj(rM);
        return ar;
    }
}
