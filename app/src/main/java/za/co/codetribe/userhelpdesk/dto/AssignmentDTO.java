package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 5/23/2016.
 */
public class AssignmentDTO implements Serializable {

    private Integer assignmentID;
    private Date dateAssigned;
    private Integer administratorId;
    private Integer callLogId;
    private Integer technicianId;
    private Integer companyId;
    private Date expiryDate;
    private Boolean openFlag;
    private List<TechnicianresponseDTO> technicianresponseList;

    public  AssignmentDTO()
    {

    }

    public Integer getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(Integer assignmentID) {
        this.assignmentID = assignmentID;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(Boolean openFlag) {
        this.openFlag = openFlag;
    }


    public Integer getCallLogId() {
        return callLogId;
    }

    public void setCallLogId(Integer callLogId) {
        this.callLogId = callLogId;
    }

    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }


    public List<TechnicianresponseDTO> getTechnicianresponseList() {
        return technicianresponseList;
    }

    public void setTechnicianresponseList(List<TechnicianresponseDTO> technicianresponseList) {
        this.technicianresponseList = technicianresponseList;
    }

}
