package za.co.codetribe.userhelpdesk.dto;

import java.io.Serializable;

/**
 * Created by User on 5/23/2016.
 */
public class CalltypeDTO implements Serializable {

    private Integer callTypeID;
    private String callType;
    public  CalltypeDTO ()
    {

    }

    public Integer getCallTypeID() {
        return callTypeID;
    }

    public void setCallTypeID(Integer callTypeID) {
        this.callTypeID = callTypeID;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }
}
