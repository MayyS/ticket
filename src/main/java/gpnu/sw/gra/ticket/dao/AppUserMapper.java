package gpnu.sw.gra.ticket.dao;

import gpnu.sw.gra.ticket.pojo.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:S
 * @Date:20/3/16
 */

@Mapper
@Repository
public interface AppUserMapper {

    public AppUser selectById(int id);

    public int updateById(AppUser appUser);

    public int insert(AppUser appUser);

    public int insertSelective(AppUser appUser);

    public int deleteById(int id);

    public List<AppUser> findByNameAndPwd(AppUser appUser);

    public List<AppUser>findByName(String username);



}
