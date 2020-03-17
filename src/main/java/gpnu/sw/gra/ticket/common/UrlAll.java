package gpnu.sw.gra.ticket.common;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public enum UrlAll {
    PRE("http://127.0.0.1:5000/"),
    LOGIN("login"),
    PASSENGERS("getPassengers"),
    QUERYTICKET("queryTicket"),
    STATIONNAMEINFO("stationNameInfo"),
    CECK("login");


    private String name;

    private UrlAll(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
