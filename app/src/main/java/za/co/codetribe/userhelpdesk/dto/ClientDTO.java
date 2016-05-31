package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 5/23/2016.
 */
public class ClientDTO implements Serializable{

    private Integer clientID;
    private String clientName;
    private String location;
    private String clientTelephoneNo;
    private Integer companyID;
    private List<UserDTO> userList;

    public  ClientDTO()
    {

    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClientTelephoneNo() {
        return clientTelephoneNo;
    }

    public void setClientTelephoneNo(String clientTelephoneNo) {
        this.clientTelephoneNo = clientTelephoneNo;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }


}
