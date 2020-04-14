package gpnu.sw.gra.ticket.service;

import gpnu.sw.gra.ticket.pojo.AppUser;
import gpnu.sw.gra.ticket.pojo.TUser;

/**
 * @Auther:S
 * @Date:20/3/16
 */
public interface AppUserService {

    public int addAppUserWithTUser(TUser tUser, AppUser appUser);

    public int addAppUser(AppUser user);

    public int updateAppUser(AppUser user);

    public AppUser findAppUserById(AppUser user);

    public int findAidByOpenid(String openid);

    public AppUser findAppUserByPasswordAndUsername(AppUser appUser);

    public boolean existUsername(String username);

    public AppUser findAppUserByOpenid(String openid);

}
