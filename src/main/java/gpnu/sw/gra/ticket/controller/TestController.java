package gpnu.sw.gra.ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:S
 * @Date:20/3/12
 */

@Controller
public class TestController {


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        String msg="hello word";
        System.out.println("hello");
        return "index";
    }
}
