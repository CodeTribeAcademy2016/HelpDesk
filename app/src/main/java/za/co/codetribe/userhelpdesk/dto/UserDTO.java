package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 5/23/2016.
 */
public class UserDTO implements Serializable{

    private Integer userID;
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNo;
    private String cellNo;
    private String password;
    private Date dateRegistered;
    private boolean activeFlag;
    private List<CalllogDTO> calllogList;
    private Integer clientID;

    public UserDTO()
    {

    }


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<CalllogDTO> getCalllogList() {
        return calllogList;
    }

    public void setCalllogList(List<CalllogDTO> calllogList) {
        this.calllogList = calllogList;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }
}
