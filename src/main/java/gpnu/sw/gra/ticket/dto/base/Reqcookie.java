package gpnu.sw.gra.ticket.dto.base;

import java.io.Serializable;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public class Reqcookie implements Serializable {

    private String raildeviceid;
    private String RAIL_EXPIRATION;
    private String BIGipServerotn;
    private String BIGipServerpool_passport;
    private String route;
    private String JSESSIONID;
    private String tk;
    private String _passport_session;
    private String uamtk;

    public String getRaildeviceid() {
        return raildeviceid;
    }

    public void setRaildeviceid(String raildeviceid) {
        this.raildeviceid = raildeviceid;
    }

    public String getRAIL_EXPIRATION() {
        return RAIL_EXPIRATION;
    }

    public void setRAIL_EXPIRATION(String RAIL_EXPIRATION) {
        this.RAIL_EXPIRATION = RAIL_EXPIRATION;
    }

    public String getBIGipServerotn() {
        return BIGipServerotn;
    }

    public void setBIGipServerotn(String BIGipServerotn) {
        this.BIGipServerotn = BIGipServerotn;
    }

    public String getBIGipServerpool_passport() {
        return BIGipServerpool_passport;
    }

    public void setBIGipServerpool_passport(String BIGipServerpool_passport) {
        this.BIGipServerpool_passport = BIGipServerpool_passport;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getJSESSIONID() {
        return JSESSIONID;
    }

    public void setJSESSIONID(String JSESSIONID) {
        this.JSESSIONID = JSESSIONID;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String get_passport_session() {
        return _passport_session;
    }

    public void set_passport_session(String _passport_session) {
        this._passport_session = _passport_session;
    }

    public String getUamtk() {
        return uamtk;
    }

    public void setUamtk(String uamtk) {
        this.uamtk = uamtk;
    }

    @Override
    public String toString() {
        return "Reqcookie{" +
                ", RAIL_EXPIRATION='" + RAIL_EXPIRATION + '\'' +
                ", BIGipServerotn='" + BIGipServerotn + '\'' +
                ", BIGipServerpool_passport='" + BIGipServerpool_passport + '\'' +
                ", route='" + route + '\'' +
                ", JSESSIONID='" + JSESSIONID + '\'' +
                ", tk='" + tk + '\'' +
                ", _passport_session='" + _passport_session + '\'' +
                ", uamtk='" + uamtk + '\'' +
                '}';
    }
}
