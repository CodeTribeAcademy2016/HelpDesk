package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 5/23/2016.
 */
public class AdministratorDTO implements Serializable{


    private Integer administratorID;
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNo;
    private String cellNo;
    private String password;
    private Integer companyID;
    private boolean activeFlag;
    private List<CalllogDTO> calllogList;
    private List<AssignmentDTO> assignmentList;
    private List<TechnicianDTO> technicianList;

    public  AdministratorDTO()
    {

    }


    public Integer getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Integer administratorID) {
        this.administratorID = administratorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public List<CalllogDTO> getCalllogList() {
        return calllogList;
    }

    public void setCalllogList(List<CalllogDTO> calllogList) {
        this.calllogList = calllogList;
    }

    public List<AssignmentDTO> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<AssignmentDTO> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public List<TechnicianDTO> getTechnicianList() {
        return technicianList;
    }

    public void setTechnicianList(List<TechnicianDTO> technicianList) {
        this.technicianList = technicianList;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

}
