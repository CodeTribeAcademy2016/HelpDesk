package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 5/23/2016.
 */
public class CompanyDTO implements Serializable{

    private Integer companyID;
    private String companyName;
    private String email;
    private String telephoneNo;
    private Boolean activeFlag;
    private List<AdministratorDTO> administratorList;
    private List<ClientDTO> clientList;
    private List<TechnicianDTO> technicianList;

    public  CompanyDTO()
    {

    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<AdministratorDTO> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<AdministratorDTO> administratorList) {
        this.administratorList = administratorList;
    }

    public List<ClientDTO> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientDTO> clientList) {
        this.clientList = clientList;
    }

    public List<TechnicianDTO> getTechnicianList() {
        return technicianList;
    }

    public void setTechnicianList(List<TechnicianDTO> technicianList) {
        this.technicianList = technicianList;
    }
}
