package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.common.MsgTip;
import gpnu.sw.gra.ticket.dto.RegisterObj;
import gpnu.sw.gra.ticket.dto.base.AppResult;
import gpnu.sw.gra.ticket.pojo.AppUser;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.service.AppUserService;
import gpnu.sw.gra.ticket.service.TUserService;
import gpnu.sw.gra.ticket.util.DepartUtil;
import gpnu.sw.gra.ticket.util.MD5Util;
import gpnu.sw.gra.ticket.util.SymmetricEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.util.PojoUtil;
import sun.security.provider.MD5;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/16
 */

@Controller
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(AppUser appUser){
        System.out.println(appUser);
        AppUser user=appUserService.findAppUserByPasswordAndUsername(appUser);
        if(user!=null){
            return "登陆成功";
        }
        return "登陆失败";
    }

    @RequestMapping(value = "/register/{openid}",method = RequestMethod.GET)
    @ResponseBody
    public AppResult register(RegisterObj obj, @PathVariable("openid") String openid){
        System.out.println(obj);
        AppResult ar=new AppResult();
        int idx;
        if(appUserService.existUsername(obj.getAppUsername())){
            ar.setMsg("用户已经存在");
            return ar;
        }
        AppUser appUser= DepartUtil.getAppUser(obj);
        appUser.setPassword(MD5Util.MD5(appUser.getPassword()));
        appUser.setOpenid(openid);
        System.out.println(appUser);
        if(!obj.isFast()){
            TUser tUser=DepartUtil.getTUser(obj);
            tUser.setPassword(SymmetricEncoder.AESEncode(tUser.getPassword()));
            tUser.setEpassword(SymmetricEncoder.AESEncode(tUser.getEpassword()));
            idx=appUserService.addAppUserWithTUser(tUser,appUser);
            if(idx>=2){
                ar.setStatus(200);
                ar.setMsg("注册成功");
                return ar;
            }
        }
        idx=appUserService.addAppUser(appUser);
        if(idx>=1){
            ar.setStatus(200);
            ar.setMsg("注册成功");
            return  ar;
        }
        ar.setMsg("服务器繁忙");
        return  ar;
    }

    @RequestMapping(value = "/checkname/{appUsername}",method = RequestMethod.GET)
    @ResponseBody
    public AppResult checkName(@PathVariable("appUsername") String username){
        AppResult ar=new AppResult();
        if(appUserService.existUsername(username)){
            ar.setMsg("名字已经存在，请换别的名字");
            return ar;
        }
        ar.setStatus(200);
        ar.setMsg("名字可用");
        return ar;
    }


    @RequestMapping(value = "/appUser/get/{openid}",method = RequestMethod.GET)
    @ResponseBody
    public AppResult getAppUser(@PathVariable("openid") String openid){
        AppResult ar=new AppResult();
        Map<String,String>result=new HashMap<>();
        AppUser user=appUserService.findAppUserByOpenid(openid);
        if(user==null){
            ar.setStatus(404);
            return ar;
        }
        result.put("key",String.valueOf(user.getId()));
        result.put("v1",user.getUsername());
        result.put("v2",user.getPassword());
        ar.setStatus(200);
        ar.setObj(result);
        return ar;
    }
    @RequestMapping(value = "/appUser/update/", method = RequestMethod.POST)
    @ResponseBody
    public AppResult updateAppUser(AppUser user){
        AppResult ar=new AppResult();
        int ok=appUserService.updateAppUser(user);
        if(ok>0){
            ar.setStatus(MsgTip.MODIFYOK.getCode());
            ar.setMsg(MsgTip.MODIFYOK.getMsg());
            return ar;
        }
        return ar;
    }

}
