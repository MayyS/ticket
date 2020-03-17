package gpnu.sw.gra.ticket.service.impl;

import gpnu.sw.gra.ticket.dao.TUserMapper;
import gpnu.sw.gra.ticket.pojo.TUser;
import gpnu.sw.gra.ticket.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:S
 * @Date:20/3/16
 */

@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public int updateTUser(TUser tUser) {
        return 0;
    }

    @Override
    public TUser findTUserfindAid(int aid) {
        return null;
    }

    @Override
    public int addTUser(TUser tUser) {
        return 0;
    }

    @Override
    public int removeTUser(int aid) {
        return 0;
    }
}
