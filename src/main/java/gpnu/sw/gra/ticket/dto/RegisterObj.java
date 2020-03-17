package gpnu.sw.gra.ticket.dto;

import gpnu.sw.gra.ticket.pojo.TUser;

/**
 * @Auther:S
 * @Date:20/3/16
 */
public class RegisterObj extends TUser {

    private int id;
    private String appUsername;
    private String appPassword;
    private boolean fast;

    public boolean isFast() {
        return fast;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getAppUsername() {
        return appUsername;
    }

    public void setAppUsername(String appUsername) {
        this.appUsername = appUsername;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    @Override
    public String toString() {
        return "RegisterObj{" +
                "id=" + id +
                ", appUsername='" + appUsername + '\'' +
                ", appPassword='" + appPassword + '\'' +
                ", fast=" + fast +
                '}';
    }
}
