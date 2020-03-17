package gpnu.sw.gra.ticket.service;

import gpnu.sw.gra.ticket.pojo.TUser;

/**
 * @Auther:S
 * @Date:20/3/16
 */
public interface TUserService {

    public int updateTUser(TUser tUser);

    public TUser findTUserfindAid(int aid);

    public int addTUser(TUser tUser);

    public int removeTUser(int aid);

}
