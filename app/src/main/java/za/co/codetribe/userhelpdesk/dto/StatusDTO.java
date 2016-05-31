package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 5/23/2016.
 */
public class StatusDTO implements Serializable{

    private Integer statusID;
    private String statusName;
    private List<TechnicianresponseDTO> technicianresponseList;

    public  StatusDTO()
    {

    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<TechnicianresponseDTO> getTechnicianresponseList() {
        return technicianresponseList;
    }

    public void setTechnicianresponseList(List<TechnicianresponseDTO> technicianresponseList) {
        this.technicianresponseList = technicianresponseList;
    }
}
