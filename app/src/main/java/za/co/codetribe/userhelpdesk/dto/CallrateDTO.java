package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;

/**
 * Created by User on 5/23/2016.
 */
public class CallrateDTO implements Serializable{

    private Integer callRateID;
    private String userFeedback;
    private Integer callLogId;

    public  CallrateDTO()
    {
    }

    public Integer getCallRateID() {
        return callRateID;
    }

    public void setCallRateID(Integer callRateID) {
        this.callRateID = callRateID;
    }

    public String getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }

    public Integer getCallLogId() {
        return callLogId;
    }

    public void setCallLogId(Integer callLogId) {
        this.callLogId = callLogId;
    }

}
