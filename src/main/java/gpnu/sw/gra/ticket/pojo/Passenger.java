package gpnu.sw.gra.ticket.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther:S
 * @Date:20/3/15
 *  "passenger_name": "邱致琳",
 *             "sex_code": "F",
 *             "sex_name": "女",
 *             "born_date": "2020-01-12 00:00:00",
 *             "country_code": "CN",
 *             "passenger_id_type_code": "1",
 *             "passenger_id_type_name": "中国居民身份证",
 *             "passenger_id_no": "3607***********220",
 *             "passenger_type": "1",
 *             "passenger_flag": "0",
 *             "passenger_type_name": "成人",
 *             "mobile_no": "15902037946",
 *             "phone_no": "",
 *             "email": "",
 *             "address": "",
 *             "postalcode": "",
 *             "first_letter": "QZL",
 *             "recordCount": "6",
 *             "total_times": "99",
 *             "index_id": "1",
 *             "allEncStr": "98dd518828376f4ed6bb045483d42c5006e0c6ce11e61af74eb1120b2fd6e23eac43bb8c6c8f2095261719d69630bf2b4748d411229501ff0338e6ba06ae03d2",
 *             "isAdult": "Y",
 *             "isYongThan10": "N",
 *             "isYongThan14": "N",
 *             "isOldThan60": "N",
 *             "if_receive": "N",
 *             "is_active": "N",
 *             "is_buy_ticket": "Y",
 *             "last_time": "20200112",
 *             "mobile_check_time": "",
 *             "email_active_time": "",
 *             "last_update_time": "",
 *             "passenger_uuid": "5a6940c681e52f13aff2c80f8026ec3ab993c8e01faacd70d4084e717523c899",
 *             "gat_born_date": "",
 *             "gat_valid_date_start": "",
 *             "gat_valid_date_end": "",
 *             "gat_version": ""
 */


public class Passenger implements Serializable,Comparable{
    private String passengerName;
    private boolean isBoy;
    private Date bornDate;
    private String countryCode;
    private String passengerIdTypeName;
    private String passengerIdNo;
    private String mobileNo;
    private String email;
    private int indexId;
    private String allEncStr;
    private boolean adult;
    private boolean yongThan10;
    private boolean yongThan14;
    private boolean oldThan60;
    private String passengerUuid;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public boolean isBoy() {
        return isBoy;
    }

    public void setBoy(boolean boy) {
        isBoy = boy;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPassengerIdTypeName() {
        return passengerIdTypeName;
    }

    public void setPassengerIdTypeName(String passengerIdTypeName) {
        this.passengerIdTypeName = passengerIdTypeName;
    }

    public String getPassengerIdNo() {
        return passengerIdNo;
    }

    public void setPassengerIdNo(String passengerIdNo) {
        this.passengerIdNo = passengerIdNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIndexId() {
        return indexId;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }

    public String getAllEncStr() {
        return allEncStr;
    }

    public void setAllEncStr(String allEncStr) {
        this.allEncStr = allEncStr;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isYongThan10() {
        return yongThan10;
    }

    public void setYongThan10(boolean yongThan10) {
        this.yongThan10 = yongThan10;
    }

    public boolean isYongThan14() {
        return yongThan14;
    }

    public void setYongThan14(boolean yongThan14) {
        this.yongThan14 = yongThan14;
    }

    public boolean isOldThan60() {
        return oldThan60;
    }

    public void setOldThan60(boolean oldThan60) {
        this.oldThan60 = oldThan60;
    }

    public String getPassengerUuid() {
        return passengerUuid;
    }

    public void setPassengerUuid(String passengerUuid) {
        this.passengerUuid = passengerUuid;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerName='" + passengerName + '\'' +
                ", isBoy=" + isBoy +
                ", bornDate=" + bornDate +
                ", countryCode='" + countryCode + '\'' +
                ", passengerIdTypeName='" + passengerIdTypeName + '\'' +
                ", passengerIdNo='" + passengerIdNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                ", indexId=" + indexId +
                ", allEncStr='" + allEncStr + '\'' +
                ", adult=" + adult +
                ", yongThan10=" + yongThan10 +
                ", yongThan14=" + yongThan14 +
                ", oldThan60=" + oldThan60 +
                ", passengerUuid='" + passengerUuid + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.indexId-((Passenger)o).indexId;
    }
}
