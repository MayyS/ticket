package gpnu.sw.gra.ticket.pojo;

/**
 * @Auther:S
 * @Date:20/3/15
 */
public class TUser {

    private int id;
    private int aid;
    private String username;
    private String password;
    private String email;
    private String epassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", epassword='" + epassword + '\'' +
                '}';
    }
}
