package gpnu.sw.gra.ticket.util;

import gpnu.sw.gra.ticket.dto.RegisterObj;
import gpnu.sw.gra.ticket.pojo.AppUser;
import gpnu.sw.gra.ticket.pojo.TUser;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public class DepartUtil {

    public static TUser getTUser(RegisterObj obj){
        if(obj.isFast()){
            return null;
        }
        TUser user=new TUser();
        user.setUsername(obj.getUsername());
        user.setPassword(obj.getPassword());
        user.setEmail(obj.getEmail());
        user.setEpassword(obj.getEpassword());
        return user;
    }

    public static AppUser getAppUser(RegisterObj obj){
        AppUser user=new AppUser();

        user.setUsername(obj.getAppUsername());
        user.setPassword(obj.getAppPassword());

        return user;
    }
}
