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

    public AppResult login(TUser user, HttpServletRequest req, HttpServletResponse res,String key);

    public AppResult getPassengers(String token);


    public AppResult stationNameInfo();
    public AppResult queryTicket (QueryObj queryObj);

    public String getStationByChinese(String key);

}
