package gpnu.sw.gra.ticket.dao;

import gpnu.sw.gra.ticket.pojo.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther:S
 * @Date:20/3/16
 */
@Mapper
@Repository
public interface TUserMapper {

    public TUser selectByAid(int aid);

    public int updateByAId(TUser tUser);

    public int updateById(TUser tUser);

    public int insert(TUser tUser);

    public int insertSelective(TUser user);

    public int deleteByAid(int aid);

}
