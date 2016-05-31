package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 5/23/2016.
 */
public class CalllogDTO implements Serializable {

    private Integer callLogID;
    private Date dateLog;
    private Date dateCallClosed;
    private Integer ticketNumber;
    private String url;
    private Integer administratorId;
    private Integer userId;
    private Integer clientId;
    private Integer callTypeId;
    private Integer companyID;
    private Boolean assignedFlag;
    private Boolean cancelFlag;

    private List<AssignmentDTO> assignmentList;
    private List<CallrateDTO> callrateList;

    public CalllogDTO()
    {

    }


    public Integer getCallLogID() {
        return callLogID;
    }

    public void setCallLogID(Integer callLogID) {
        this.callLogID = callLogID;
    }

    public Date getDateLog() {
        return dateLog;
    }

    public void setDateLog(Date dateLog) {
        this.dateLog = dateLog;
    }

    public Date getDateCallClosed() {
        return dateCallClosed;
    }

    public void setDateCallClosed(Date dateCallClosed) {
        this.dateCallClosed = dateCallClosed;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Boolean getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(Boolean cancelFlag) {
        this.cancelFlag = cancelFlag;
    }


    public Integer getCallTypeId() {
        return callTypeId;
    }

    public void setCallTypeId(Integer callTypeId) {
        this.callTypeId = callTypeId;
    }

    public Boolean getAssignedFlag() {
        return assignedFlag;
    }

    public void setAssignedFlag(Boolean assignedFlag) {
        this.assignedFlag = assignedFlag;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }


    public List<AssignmentDTO> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<AssignmentDTO> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public List<CallrateDTO> getCallrateList() {
        return callrateList;
    }

    public void setCallrateList(List<CallrateDTO> callrateList) {
        this.callrateList = callrateList;
    }

}
