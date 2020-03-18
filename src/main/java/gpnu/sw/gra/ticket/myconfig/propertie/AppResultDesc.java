package gpnu.sw.gra.ticket.myconfig.propertie;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @Auther:S
 * @Date:20/3/18
 */

public class AppResultDesc {
    public static final String COOKIES="cookies";

    public static MyCookie cookie;

    public static final String REP="rep";

    public static final String DATA="data";

    public static final String REQ_ARGS="req_args";

    public static final String REQ_COOKIES="req_cookies";

    public static class Rep{
        public static final String STATUS="status";
        public static final String UAMTK="uamtk";
        public static final String USERNAME="username";
    }

    public static class MyCookie{
        public static final String RAIL_EXPIRATION="RAIL_EXPIRATION";
        public static final String RAIL_DEVICEID="RAIL_DEVICEID";
    }
}
