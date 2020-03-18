package gpnu.sw.gra.ticket.service;

import gpnu.sw.gra.ticket.dto.QueryObj;
import gpnu.sw.gra.ticket.dto.base.AppResult;
import gpnu.sw.gra.ticket.pojo.Passenger;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.pojo.TicketInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public interface TrainService {

    public AppResult checked(TUser user);

    public AppResult login(TUser user, HttpServletRequest req, HttpServletResponse res);

    public AppResult getPassengers(String token);

    public List<TicketInfo> queryTicket(QueryObj queryObj);

    public Map<String,String> stationNameInfo();

}
