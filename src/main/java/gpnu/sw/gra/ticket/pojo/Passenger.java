package gpnu.sw.gra.ticket.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther:S
 * @Date:20/3/15
 */

public class Passenger implements Serializable {
    private String PassengerName;
    private boolean isBoy;
    private Date BornDate;
    private String CountryCode;
    private String PassengerIdTypeName;
    private String PassengerIdNo;
    private String MobileNo;
    private String Email;
    private int IndexId;
    private String AllEncStr;
    private boolean Adult;
    private boolean YongThan10;
    private boolean YongThan14;
    private boolean OldThan60;
    private String PassengerUuid;

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public boolean isBoy() {
        return isBoy;
    }

    public void setBoy(boolean boy) {
        isBoy = boy;
    }

    public Date getBornDate() {
        return BornDate;
    }

    public void setBornDate(Date bornDate) {
        BornDate = bornDate;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getPassengerIdTypeName() {
        return PassengerIdTypeName;
    }

    public void setPassengerIdTypeName(String passengerIdTypeName) {
        PassengerIdTypeName = passengerIdTypeName;
    }

    public String getPassengerIdNo() {
        return PassengerIdNo;
    }

    public void setPassengerIdNo(String passengerIdNo) {
        PassengerIdNo = passengerIdNo;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getIndexId() {
        return IndexId;
    }

    public void setIndexId(int indexId) {
        IndexId = indexId;
    }

    public String getAllEncStr() {
        return AllEncStr;
    }

    public void setAllEncStr(String allEncStr) {
        AllEncStr = allEncStr;
    }

    public boolean isAdult() {
        return Adult;
    }

    public void setAdult(boolean adult) {
        Adult = adult;
    }

    public boolean isYongThan10() {
        return YongThan10;
    }

    public void setYongThan10(boolean yongThan10) {
        YongThan10 = yongThan10;
    }

    public boolean isYongThan14() {
        return YongThan14;
    }

    public void setYongThan14(boolean yongThan14) {
        YongThan14 = yongThan14;
    }

    public boolean isOldThan60() {
        return OldThan60;
    }

    public void setOldThan60(boolean oldThan60) {
        OldThan60 = oldThan60;
    }

    public String getPassengerUuid() {
        return PassengerUuid;
    }

    public void setPassengerUuid(String passengerUuid) {
        PassengerUuid = passengerUuid;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "PassengerName='" + PassengerName + '\'' +
                ", isBoy=" + isBoy +
                ", BornDate=" + BornDate +
                ", CountryCode='" + CountryCode + '\'' +
                ", PassengerIdTypeName='" + PassengerIdTypeName + '\'' +
                ", PassengerIdNo='" + PassengerIdNo + '\'' +
                ", MobileNo='" + MobileNo + '\'' +
                ", Email='" + Email + '\'' +
                ", IndexId=" + IndexId +
                ", AllEncStr='" + AllEncStr + '\'' +
                ", Adult=" + Adult +
                ", YongThan10=" + YongThan10 +
                ", YongThan14=" + YongThan14 +
                ", OldThan60=" + OldThan60 +
                ", PassengerUuid='" + PassengerUuid + '\'' +
                '}';
    }
}
