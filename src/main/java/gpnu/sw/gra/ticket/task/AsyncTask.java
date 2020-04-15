package gpnu.sw.gra.ticket.task;

import gpnu.sw.gra.ticket.dto.base.AppResult;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.service.TUserService;
import gpnu.sw.gra.ticket.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther:S
 * @Date:20/4/14
 */

@Component
public class AsyncTask {

    @Autowired
    TUserService tUserService;

    @Autowired
    TrainService trainService;


    @Async
    public void login(int aid, String key,HttpServletRequest req, HttpServletResponse res){
        System.out.println("后台任务启动....");
        TUser user=tUserService.findTUserfindAid(aid);
        AppResult ar=trainService.login(user,req,res,key);
        System.out.println("后台任务执行结果: "+ar.toString());
    }
}
