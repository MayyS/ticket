package gpnu.sw.gra.ticket.controller;

import gpnu.sw.gra.ticket.dao.JedisDao;
import gpnu.sw.gra.ticket.myconfig.JedisClusterConfig;
import gpnu.sw.gra.ticket.myconfig.propertie.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:S
 * @Date:20/3/12
 */

@Controller
public class TestController {

    @Autowired
    private RedisProperties redisProperties;
    @Autowired
    private JedisClusterConfig jedisClusterConfig;

    @Autowired
    private JedisDao jedisDaoImpl;

    @RequestMapping(value = "/r/tets")
    @ResponseBody
    public String getRedisValue(){
        System.out.println(redisProperties.toString());
        System.out.println(jedisClusterConfig.getJedisCluster().getClusterNodes());
        System.out.println(jedisDaoImpl.get("yp"));
        jedisDaoImpl.set("test","tets");
        System.out.println(jedisDaoImpl.get("test"));
        return "ok";
    }


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        String msg="hello word";
        System.out.println("hello");
        return "index";
    }
}
