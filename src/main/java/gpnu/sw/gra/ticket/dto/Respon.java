package gpnu.sw.gra.ticket.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */

public class Respon implements Serializable {

    private Map<String,String>cookies;
    private Map<String,String>req_cookies;
    private Map<String,String>rep;
    private Map<String,String>req_args;

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public Map<String, String> getReq_cookies() {
        return req_cookies;
    }

    public void setReq_cookies(Map<String, String> req_cookies) {
        this.req_cookies = req_cookies;
    }

    public Map<String, String> getRep() {
        return rep;
    }

    public void setRep(Map<String, String> rep) {
        this.rep = rep;
    }

    public Map<String, String> getReq_args() {
        return req_args;
    }

    public void setReq_args(Map<String, String> req_args) {
        this.req_args = req_args;
    }

    @Override
    public String toString() {
        return "Respon{" +
                "cookies=" + cookies +
                ", req_cookies=" + req_cookies +
                ", rep=" + rep +
                ", req_args=" + req_args +
                '}';
    }
}
