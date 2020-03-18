package gpnu.sw.gra.ticket.dao.impl;

import gpnu.sw.gra.ticket.dao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;

/**
 * @Auther:S
 * @Date:20/3/18
 */

@Component
public class JedisDapImpl implements JedisDao {

    @Resource
    private JedisCluster jedisClients;

    @Override
    public Boolean exists(String key) {
        return jedisClients.exists(key);
    }

    @Override
    public Long del(String key) {
        return jedisClients.del(key);
    }

    @Override
    public String set(String key, String vaule) {
        return jedisClients.set(key,vaule);
    }

    @Override
    public String get(String key) {
        return jedisClients.get(key);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedisClients.expire(key,seconds);
    }
}
