package gpnu.sw.gra.ticket.myconfig.propertie;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther:S
 * @Date:20/3/18
 */

@Component
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.redis.cache")
public class RedisProperties {

    private int expireSecondes;
    private String clusterNodes;
    private int commandTimeOut;

    public int getExpireSecondes() {
        return expireSecondes;
    }

    public void setExpireSecondes(int expireSecondes) {
        this.expireSecondes = expireSecondes;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public int getCommandTimeOut() {
        return commandTimeOut;
    }

    public void setCommandTimeOut(int commandTimeOut) {
        this.commandTimeOut = commandTimeOut;
    }
}
