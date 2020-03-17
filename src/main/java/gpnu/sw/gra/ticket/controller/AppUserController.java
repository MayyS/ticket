package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.dto.RegisterObj;
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

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(RegisterObj obj){
        System.out.println(obj);
        int idx;
        if(appUserService.existUsername(obj.getAppUsername())){
            return "username exitst";
        }
        AppUser appUser= DepartUtil.getAppUser(obj);
        appUser.setPassword(MD5Util.MD5(appUser.getPassword()));
        System.out.println(appUser);
        if(!obj.isFast()){
            TUser tUser=DepartUtil.getTUser(obj);
            tUser.setPassword(SymmetricEncoder.AESEncode(tUser.getPassword()));
            tUser.setEpassword(SymmetricEncoder.AESEncode(tUser.getEpassword()));
            idx=appUserService.addAppUserWithTUser(tUser,appUser);
            if(idx>=2){
                return "ok";
            }
        }
        idx=appUserService.addAppUser(appUser);
        if(idx>=1){
            return "ok";
        }
        return "fail";
    }

    @RequestMapping(value = "/checkname/{appUsername}",method = RequestMethod.GET)
    @ResponseBody
    public String checkName(@PathVariable("appUsername") String username){
        if(appUserService.existUsername(username)){
            return "change other";
        }
        return "pass ok";
    }

}
