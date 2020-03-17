package gpnu.sw.gra.ticket.pojo;

/**
 * @Auther:S
 * @Date:20/3/16
 */

/*
*     "secretStr": "Kuy7BD2QsjYuq8YxOQJTKXVjWNu0exZd5jiGQyk0SN1bEfOSeRnl3XElOAC6A0tCAKEZ1PI7XEw6%0ANFoZ9nQbX%2Bq0cgnebSHK7o5Y1wuA%2BZixF%2FoywgTk628sTQUyQ4edtHCUK3Vm55jXEtrS%2BzWHisg9%0AbFRkEOQBJjJ%2F6ThgpaBe43%2BA035Mld2xvzrAJhacUBvE6l2QBtzfxSH%2Bc3%2Bw1yZhLEfeU7YRPfiR%0AABqvNndoXaUebuMXUkTtu9G0L%2Bj902yBSuwtr7g0YVUbhAfMF56UIANkkQ6PUmyr6NYb%2F6Y%3D",
            "train_no": "6j000D74190I",
            "车次": "D7419",
            "query_from_station_name": "PEQ",
            "query_to_station_name": "IOQ",
            "train_location": "Q7",
            "stationTrainCode": "D7419",
            "商务/特等座": "",
            "一等座": "有",
            "二等座": "有",
            "动卧": "",
            "硬卧": "",
            "软座": "",
            "硬座": "",
            "无座": "无",
            "备注": "预订"
* */

public class TicketInfo {
    private String SecretStr;
    private String TrainNo;
    private String Number;
    private String QryFrm;
    private String QryTo;
    private String TrainLocation;
    private String StationTrainCode;
    private String SpecialOrBusiness;
    private String FirstClass;
    private String SecondClass;
    private String DogWo;
    private String HardBerth;
    private String SoftBerth;
    private String NoBerth;
    private String comment;

    public String getSecretStr() {
        return SecretStr;
    }

    public void setSecretStr(String secretStr) {
        SecretStr = secretStr;
    }

    public String getTrainNo() {
        return TrainNo;
    }

    public void setTrainNo(String trainNo) {
        TrainNo = trainNo;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getQryFrm() {
        return QryFrm;
    }

    public void setQryFrm(String qryFrm) {
        QryFrm = qryFrm;
    }

    public String getQryTo() {
        return QryTo;
    }

    public void setQryTo(String qryTo) {
        QryTo = qryTo;
    }

    public String getTrainLocation() {
        return TrainLocation;
    }

    public void setTrainLocation(String trainLocation) {
        TrainLocation = trainLocation;
    }

    public String getStationTrainCode() {
        return StationTrainCode;
    }

    public void setStationTrainCode(String stationTrainCode) {
        StationTrainCode = stationTrainCode;
    }

    public String getSpecialOrBusiness() {
        return SpecialOrBusiness;
    }

    public void setSpecialOrBusiness(String specialOrBusiness) {
        SpecialOrBusiness = specialOrBusiness;
    }

    public String getFirstClass() {
        return FirstClass;
    }

    public void setFirstClass(String firstClass) {
        FirstClass = firstClass;
    }

    public String getSecondClass() {
        return SecondClass;
    }

    public void setSecondClass(String secondClass) {
        SecondClass = secondClass;
    }

    public String getDogWo() {
        return DogWo;
    }

    public void setDogWo(String dogWo) {
        DogWo = dogWo;
    }

    public String getHardBerth() {
        return HardBerth;
    }

    public void setHardBerth(String hardBerth) {
        HardBerth = hardBerth;
    }

    public String getSoftBerth() {
        return SoftBerth;
    }

    public void setSoftBerth(String softBerth) {
        SoftBerth = softBerth;
    }

    public String getNoBerth() {
        return NoBerth;
    }

    public void setNoBerth(String noBerth) {
        NoBerth = noBerth;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "SecretStr='" + SecretStr + '\'' +
                ", TrainNo='" + TrainNo + '\'' +
                ", Number='" + Number + '\'' +
                ", QryFrm='" + QryFrm + '\'' +
                ", QryTo='" + QryTo + '\'' +
                ", TrainLocation='" + TrainLocation + '\'' +
                ", StationTrainCode='" + StationTrainCode + '\'' +
                ", SpecialOrBusiness='" + SpecialOrBusiness + '\'' +
                ", FirstClass='" + FirstClass + '\'' +
                ", SecondClass='" + SecondClass + '\'' +
                ", DogWo='" + DogWo + '\'' +
                ", HardBerth='" + HardBerth + '\'' +
                ", SoftBerth='" + SoftBerth + '\'' +
                ", NoBerth='" + NoBerth + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
