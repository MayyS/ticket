package gpnu.sw.gra.ticket.dao;

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
}
