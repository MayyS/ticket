package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.pojo.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther:S
 * @Date:20/3/17
 */

@Controller
@RequestMapping("/train")
public class TrainController {

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String check(TUser user){

        return "ok!";
    }
}
