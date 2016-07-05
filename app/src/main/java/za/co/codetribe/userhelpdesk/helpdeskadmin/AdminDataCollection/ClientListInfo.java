package za.co.codetribe.userhelpdesk.helpdeskadmin.AdminDataCollection;

/**
 * Created by User on 6/28/2016.
 */
public class ClientListInfo {

    String clientName,Location,Telephone;

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }
}
