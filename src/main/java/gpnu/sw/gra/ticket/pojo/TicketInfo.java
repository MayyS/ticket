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
    private String secretStr;
    private String trainNo;
    private String number;
    private String qryFrm;
    private String qryTo;
    private String trainLocation;
    private String stationTrainCode;
    private String specialOrBusiness;
    private String firstClass;
    private String secondClass;
    private String dogWo;
    private String hardBerth;
    private String softBerth;
    private String noBerth;
    private String comment;
    private String timeStart;
    private String timeArrival;
    private String timeUsed;

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public String getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(String timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getSecretStr() {
        return secretStr;
    }

    public void setSecretStr(String secretStr) {
        this.secretStr = secretStr;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQryFrm() {
        return qryFrm;
    }

    public void setQryFrm(String qryFrm) {
        this.qryFrm = qryFrm;
    }

    public String getQryTo() {
        return qryTo;
    }

    public void setQryTo(String qryTo) {
        this.qryTo = qryTo;
    }

    public String getTrainLocation() {
        return trainLocation;
    }

    public void setTrainLocation(String trainLocation) {
        this.trainLocation = trainLocation;
    }

    public String getStationTrainCode() {
        return stationTrainCode;
    }

    public void setStationTrainCode(String stationTrainCode) {
        this.stationTrainCode = stationTrainCode;
    }

    public String getSpecialOrBusiness() {
        return specialOrBusiness;
    }

    public void setSpecialOrBusiness(String specialOrBusiness) {
        this.specialOrBusiness = specialOrBusiness;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public String getDogWo() {
        return dogWo;
    }

    public void setDogWo(String dogWo) {
        this.dogWo = dogWo;
    }

    public String getHardBerth() {
        return hardBerth;
    }

    public void setHardBerth(String hardBerth) {
        this.hardBerth = hardBerth;
    }

    public String getSoftBerth() {
        return softBerth;
    }

    public void setSoftBerth(String softBerth) {
        this.softBerth = softBerth;
    }

    public String getNoBerth() {
        return noBerth;
    }

    public void setNoBerth(String noBerth) {
        this.noBerth = noBerth;
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
                "secretStr='" + secretStr + '\'' +
                ", trainNo='" + trainNo + '\'' +
                ", number='" + number + '\'' +
                ", qryFrm='" + qryFrm + '\'' +
                ", qryTo='" + qryTo + '\'' +
                ", trainLocation='" + trainLocation + '\'' +
                ", stationTrainCode='" + stationTrainCode + '\'' +
                ", specialOrBusiness='" + specialOrBusiness + '\'' +
                ", firstClass='" + firstClass + '\'' +
                ", secondClass='" + secondClass + '\'' +
                ", dogWo='" + dogWo + '\'' +
                ", hardBerth='" + hardBerth + '\'' +
                ", softBerth='" + softBerth + '\'' +
                ", noBerth='" + noBerth + '\'' +
                ", comment='" + comment + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeArrival='" + timeArrival + '\'' +
                ", timeUsed='" + timeUsed + '\'' +
                '}';
    }
}
