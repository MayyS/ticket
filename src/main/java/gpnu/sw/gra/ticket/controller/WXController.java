package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.pojo.AppUser;
import gpnu.sw.gra.ticket.service.AppUserService;
import gpnu.sw.gra.ticket.service.WXService;
import gpnu.sw.gra.ticket.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/26
 */

@RestController
@RequestMapping("/weixin")
public class WXController {


    @Autowired
    private WXService wxServiceImpl;

    @Autowired
    private AppUserService appUserServiceImpl;

    @RequestMapping(value = "/getOpenId",method = RequestMethod.POST)
    public String getOpenId(@RequestBody String code){
        System.out.println(code);
        String res=wxServiceImpl.getOpenId(code);
        Map<String,Object>mp= JsonUtil.jsonToMap(res);
        String openid=mp.get("openid").toString();
        AppUser user =appUserServiceImpl.findAppUserByOpenid(openid);
        Map<String,Object>result=new HashMap<>();
        result.put("openid",openid);
        result.put("user",user);
        String resJson=JsonUtil.objectToJson(result);
        System.out.println(resJson);
        return resJson;
    }

}
