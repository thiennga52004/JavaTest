package Models;

import java.sql.Date;

public class ITRequest {
    private int reqId;
    private String reqName;
    private Date reqDate;
    private String reqEmail;
    private String reqType;
    private String reqDetails;
    public ITRequest(String reqName, Date reqDate,String reqEmail, String reqType, String reqDetails) {
        this.reqName = reqName;
        this.reqDate = reqDate;
        this.reqEmail = reqEmail;
        this.reqType = reqType;
        this.reqDetails = reqDetails;
    }
    public ITRequest(){}

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getReqEmail() {
        return reqEmail;
    }

    public void setReqEmail(String reqEmail) {
        this.reqEmail = reqEmail;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getReqDetails() {
        return reqDetails;
    }

    public void setReqDetails(String reqDetails) {
        this.reqDetails = reqDetails;
    }
}
