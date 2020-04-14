package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.common.MsgTip;
import gpnu.sw.gra.ticket.dto.base.AppResult;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.service.AppUserService;
import gpnu.sw.gra.ticket.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */

@Controller
@RequestMapping("/t")
public class TUserController {

    @Autowired
    TUserService tUserService;
    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/getEmail/{openid}",method = RequestMethod.GET)
    @ResponseBody
    public AppResult getEmail(@PathVariable String openid){
        AppResult ar=new AppResult();
        int aid= appUserService.findAidByOpenid(openid);
        TUser user= tUserService.findTUserfindAid(aid);
        if(user==null){
            ar.setMsg(MsgTip.EMODIFYOK.getMsg());
            return ar;
        }
        Map<String,String>map=new HashMap<>();
        map.put("key",String.valueOf(user.getId()));
        map.put("v1",user.getEmail());
        map.put("v2",user.getEpassword());
        ar.setStatus(MsgTip.MODIFYOK.getCode());
        ar.setMsg(MsgTip.MODIFYOK.getMsg());
        ar.setObj(map);
        return ar;
    }
    @RequestMapping(value = "/get/{openid}",method = RequestMethod.GET)
    @ResponseBody
    public AppResult getTuser(@PathVariable("openid") String openid){
        AppResult ar=new AppResult();
        int aid= appUserService.findAidByOpenid(openid);
        TUser user= tUserService.findTUserfindAid(aid);
        if(user==null){
            ar.setStatus(404);
            return ar;
        }
        Map<String,String>map=new HashMap<>();
        map.put("key",String.valueOf(user.getId()));
        map.put("v1",user.getUsername());
        map.put("v2",user.getPassword());
        ar.setStatus(200);
        ar.setObj(map);
        return ar;
    }


    @RequestMapping(value = "/update/",method = RequestMethod.POST)
    @ResponseBody
    public AppResult updateTuser(TUser user){
        AppResult ar=new AppResult();
        int ok=tUserService.updateTUser(user);

        if(ok>0){
            ar.setStatus(200);
            ar.setMsg(MsgTip.MODIFYOK.getMsg());
            return ar;
        }
        return ar;
    }


}
