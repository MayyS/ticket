package gpnu.sw.gra.ticket.service;

import gpnu.sw.gra.ticket.dto.QueryObj;
import gpnu.sw.gra.ticket.pojo.Passenger;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.pojo.TicketInfo;

import java.util.List;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public interface TrainService {

    public String checked(TUser user);

    public String login(TUser user);

    public List<Passenger> getPassengers(String token);

    public List<TicketInfo> queryTicket(QueryObj queryObj);

    public Map<String,String> stationNameInfo();

}
