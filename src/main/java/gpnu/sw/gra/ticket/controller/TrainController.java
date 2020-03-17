package gpnu.sw.gra.ticket.controller;

import com.sun.deploy.net.HttpUtils;
import gpnu.sw.gra.ticket.common.UrlAll;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.service.TrainService;
import gpnu.sw.gra.ticket.util.HttpClientUtil;
import gpnu.sw.gra.ticket.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */

@Controller
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public String check(TUser user){
        System.out.println("checked User "+user.toString());
        String jsonStr=trainService.checked(user);
        System.out.println(jsonStr);
        Map<String,Object>json= JsonUtil.jsonToMap(jsonStr);
        String txt= ((Map<String,Object>)json.get("rep")).get("username").toString();

        return jsonStr;
    }
}
