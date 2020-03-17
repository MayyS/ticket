package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther:S
 * @Date:20/3/17
 */

@Controller
@RequestMapping("/t")
public class TUserController {

    @Autowired
    TUserService tUserService;


}
