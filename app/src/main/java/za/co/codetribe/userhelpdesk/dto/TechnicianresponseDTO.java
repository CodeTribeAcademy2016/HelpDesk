package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 5/23/2016.
 */
public class TechnicianresponseDTO implements Serializable {

    private Integer technicianResponseID;
    private String comment;
    private Date responseDate;
    private Integer assignmentId;
    private Integer statusId;
    private Integer technicianID;

    public  TechnicianresponseDTO()
    {

    }


    public Integer getTechnicianResponseID() {
        return technicianResponseID;
    }

    public void setTechnicianResponseID(Integer technicianResponseID) {
        this.technicianResponseID = technicianResponseID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(Integer technicianID) {
        this.technicianID = technicianID;
    }

}
