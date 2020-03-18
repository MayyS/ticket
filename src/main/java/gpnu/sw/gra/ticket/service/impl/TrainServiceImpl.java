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
            at.setStatus(Integer.parseInt(mp.get(AppResultDesc.Rep.STATUS).toString()));
            at.setMsg(MsgTip.CECKED.getMsg());
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
            ar.setMsg(MsgTip.ELOGIN.getMsg());
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
    public List<TicketInfo> queryTicket(QueryObj queryObj) {
        return null;
    }

    @Override
    public Map<String, String> stationNameInfo() {
        return null;
    }
}
