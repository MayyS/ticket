package gpnu.sw.gra.ticket.dao.impl;

import gpnu.sw.gra.ticket.dao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.Map;

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

    public String hget(String k, String field){
        return jedisClients.hget(k,field);
    }

    public Map<String, String> hgetALl(String k){
        return jedisClients.hgetAll(k);
    }

    public Long hset(String k, String field, String val){
        return jedisClients.hset(k,field,val);
    }

    public Long hdel(String k,String field){
        return jedisClients.hdel(k,field);
    }

    public boolean hexist(String k, String field){
        return jedisClients.hexists(k,field);
    }

    @Override
    public String  hset(String k, Map<String, String> v) {
        return jedisClients.hmset(k,v);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedisClients.expire(key,seconds);
    }
}
