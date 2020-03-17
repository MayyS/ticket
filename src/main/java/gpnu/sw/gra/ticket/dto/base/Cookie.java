package gpnu.sw.gra.ticket.dto.base;

import java.io.Serializable;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public class Cookie implements Serializable {
    public String RAIL_DEVICEID;
    public String RAIL_EXPIRATION;

    public String getRAIL_DEVICEID() {
        return RAIL_DEVICEID;
    }

    public void setRAIL_DEVICEID(String RAIL_DEVICEID) {
        this.RAIL_DEVICEID = RAIL_DEVICEID;
    }

    public String getRAIL_EXPIRATION() {
        return RAIL_EXPIRATION;
    }

    public void setRAIL_EXPIRATION(String RAIL_EXPIRATION) {
        this.RAIL_EXPIRATION = RAIL_EXPIRATION;
    }
}
