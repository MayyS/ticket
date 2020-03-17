package gpnu.sw.gra.ticket.dto;

import java.util.Date;
import java.util.List;

/**
 * @Auther:S
 * @Date:20/3/17
 */

/*
{
        "from":"PEQ",
        "to":"SZQ",
        "fromH":"普宁",
        "seatType":[30],
        "trains":[],
        "dates":["2020-03-22"],
        "numOfPassengers":1,
        "toH":"深圳"
        }

        */
public class QueryObj {
    private String fromH;
    private String toH;
    private List<Date>dates;
    private int numOfPassengers;
    private String from;
    private String to;
    private List<String>trains;
    private List<Integer>seatType;

    public String getFromH() {
        return fromH;
    }

    public void setFromH(String fromH) {
        this.fromH = fromH;
    }

    public String getToH() {
        return toH;
    }

    public void setToH(String toH) {
        this.toH = toH;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<String> getTrains() {
        return trains;
    }

    public void setTrains(List<String> trains) {
        this.trains = trains;
    }

    public List<Integer> getSeatType() {
        return seatType;
    }

    public void setSeatType(List<Integer> seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "QueryObj{" +
                "fromH='" + fromH + '\'' +
                ", toH='" + toH + '\'' +
                ", dates=" + dates +
                ", numOfPassengers=" + numOfPassengers +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", trains=" + trains +
                ", seatType=" + seatType +
                '}';
    }
}
