package gpnu.sw.gra.ticket.service.impl;

import gpnu.sw.gra.ticket.common.UrlAll;
import gpnu.sw.gra.ticket.dto.QueryObj;
import gpnu.sw.gra.ticket.pojo.Passenger;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.pojo.TicketInfo;
import gpnu.sw.gra.ticket.service.TrainService;
import gpnu.sw.gra.ticket.util.HttpClientUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */

@Service
public class TrainServiceImpl implements TrainService {

    private static final String pre=UrlAll.PRE.getName();

    private Map<String,String> toMap(TUser user){
        Map<String,String>params=new HashMap<>();
        if(user==null){
            return params;
        }
        params.put("username",user.getUsername());
        params.put("password",user.getPassword());
        return params;
    }


    @Override
    public String checked(TUser user) {
        String url= pre+UrlAll.CECK.getName();
        Map<String,String>param=toMap(user);
        String result=HttpClientUtil.doPost(url,param);
        System.out.println(result);
        return result;
    }

    @Override
    public String login(TUser user) {
        return null;
    }

    @Override
    public List<Passenger> getPassengers(String token) {
        return null;
    }

    @Override
    public List<TicketInfo> queryTicket(QueryObj queryObj) {
        return null;
    }

    @Override
    public Map<String, String> stationNameInfo() {
        return null;
    }
}
