package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.pojo.AppUser;
import gpnu.sw.gra.ticket.service.AppUserService;
import gpnu.sw.gra.ticket.service.WXService;
import gpnu.sw.gra.ticket.task.AsyncTask;
import gpnu.sw.gra.ticket.util.CookieUtils;
import gpnu.sw.gra.ticket.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther:S
 * @Date:20/3/26
 */

@RestController
@RequestMapping("/weixin")
public class WXController {

    private static final int outTime=60*60*24;
    private static final String cookieName="token";

    @Autowired
    private WXService wxServiceImpl;

    @Autowired
    private AppUserService appUserServiceImpl;

    @Autowired
    private AsyncTask task;

    @RequestMapping(value = "/getOpenId",method = RequestMethod.POST)
    public String getOpenId(@RequestBody String code, HttpServletRequest req, HttpServletResponse rsp){
        System.out.println(code);
        String key= UUID.randomUUID().toString();
        String res=wxServiceImpl.getOpenId(code);
        Map<String,Object>mp= JsonUtil.jsonToMap(res);
        String openid=mp.get("openid").toString();
        AppUser user =appUserServiceImpl.findAppUserByOpenid(openid);

        Map<String,Object>result=new HashMap<>();
        result.put("openid",openid);
        result.put("user",user);
        String resJson=JsonUtil.objectToJson(result);
        System.out.println(key);
        //将key设置到请求头去
        CookieUtils.setCookie(req,rsp,cookieName,key,outTime);
        System.out.println(resJson);
        task.login(user.getId(),key,req,rsp);
        return resJson;
    }

}
