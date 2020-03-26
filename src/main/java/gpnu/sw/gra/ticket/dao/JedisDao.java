package gpnu.sw.gra.ticket.dao;

import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/18
 */
public interface JedisDao {

    Boolean exists(String key);

    Long del(String key);

    String set(String key, String vaule);

    String get(String key);

    Long expire(String key, int seconds);

    public String hget(String k, String field);

    public Long hset(String k, String field, String val);

    public Long hdel(String k,String field);

    public boolean hexist(String k, String field);

    public String hset(String k,Map<String,String>v);

    public Map<String, String> hgetALl(String k);

}
