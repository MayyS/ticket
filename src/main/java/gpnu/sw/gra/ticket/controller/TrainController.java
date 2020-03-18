package gpnu.sw.gra.ticket.controller;

import com.sun.deploy.net.HttpUtils;
import gpnu.sw.gra.ticket.common.UrlAll;
import gpnu.sw.gra.ticket.dto.base.AppResult;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.service.TrainService;
import gpnu.sw.gra.ticket.util.CookieUtils;
import gpnu.sw.gra.ticket.util.HttpClientUtil;
import gpnu.sw.gra.ticket.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;
    private static final String cookieName="token";

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public AppResult check(TUser user){
        System.out.println("checked User "+user.toString());
        AppResult ar =trainService.checked(user);
        return ar;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AppResult login(TUser user, HttpServletRequest req, HttpServletResponse res){
        AppResult ar=trainService.login(user,req,res);
        return ar;
    }

    @RequestMapping(value = "/getPassengers",method = RequestMethod.GET)
    public AppResult getPassarger(HttpServletRequest req,HttpServletResponse res){
        String token=CookieUtils.getCookieValue(req,cookieName);
        if(token==null){
            token="9a55f852-b159-4188-bc2b-668a16b84832";
        }
        AppResult ar=trainService.getPassengers(token);
        return ar;
    }
}
