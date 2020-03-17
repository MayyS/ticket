package gpnu.sw.gra.ticket.service.impl;

import gpnu.sw.gra.ticket.dao.AppUserMapper;
import gpnu.sw.gra.ticket.dao.TUserMapper;
import gpnu.sw.gra.ticket.pojo.AppUser;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther:S
 * @Date:20/3/16
 */

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserMapper appUserMapper;

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    @Transactional
    public int addAppUserWithTUser(TUser tUser, AppUser appUser) {
        int idx=appUserMapper.insert(appUser);
        System.out.println(appUser);
        tUser.setAid(appUser.getId());
        idx+=tUserMapper.insert(tUser);
        if(idx<2){
            throw new RuntimeException("addAppUserWithTUser Exception");
        }
        return idx;
    }

    @Override
    public int addAppUser(AppUser user) {
        int idx=0;
        try {
            idx=appUserMapper.insert(user);
        }catch (Exception e){
            e.toString();
            System.out.println("-->");
            e.printStackTrace();
            return idx;
        }
        return idx;

    }

    @Override
    public int updateAppUser(AppUser user) {
        return appUserMapper.updateById(user);
    }

    @Override
    public AppUser findAppUserById(AppUser user) {
        return appUserMapper.selectById(user.getId());
    }

    @Override
    public AppUser findAppUserByPasswordAndUsername(AppUser appUser) {
        List<AppUser>users=appUserMapper.findByNameAndPwd(appUser);
        if(users.size()>0){
            return users.get(0);
        }else{
            return null;
        }
    }

    @Override
    public boolean existUsername(String username) {
        List<AppUser>users=appUserMapper.findByName(username);
        return users.size()>0;
    }
}
