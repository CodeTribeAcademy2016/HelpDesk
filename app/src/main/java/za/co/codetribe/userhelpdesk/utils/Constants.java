package za.co.codetribe.userhelpdesk.utils;

/**
 * Created by User on 4/22/2016.
 */
public class Constants {


    public static String requestType = "requestType";
    public static String email = "email";
    public static String password = "password";
    public static String companyID = "companyID";
    public static String administratorID, assignmentID, callLogID,callRateID,callTypeID,
             clientID, statusID, technicianID,technicianResponseID, userID;

    public static String helpDeskUrl = "http://146.64.85.44:8080/hda/Admin";

    public static String loginRequestType = "104";
    public static String REGISTER_ADMIN = "100";       //Done
    public static final int GET_ADMIN_PROFILE = 101;    //Done
    public static final int ADMIN_PROFILE_UPDATE = 102; //Done
    public static final int GET_ADMIN_LIST = 103;       //Done
    public static final int LOGIN_ADMIN = 104;          //Done
    public static final int DEACTIVATE_ADMINISTRATOR = 105; //Done



    //functions for administator to companies
    public static final int ADD_COMPANY = 110;          //Done
    public static final int DEACTIVATE_COMPANY = 111;   //Done
    public static final int GET_COMPANY_LIST = 112;    //Done
    public static final int UPDATE_COMPANY = 113;       //Done
    public static final int GET_COMPANY_DATA = 114;     //Done


    //functions for administator to calls
    public static final int ADD_CALL_TYPE = 140;          //Done
    public static final int ASSIGN_LOGGED_CALL = 141;     //Done
    public static final int GET_CALL_LOGGED_LIST = 142;   //Done
    public static final int GET_CALL_DETAILS = 144; //Done
    public static final int GET_CALL_CLOSED_RATINGS = 145; //Done
    public static final int GET_ASSIGNED_CALL_BY_TECH_ID = 146; //Done
    public static final int GET_UNASSIGNED_CALL = 147;  //Done
    public static final int ADD_STATUS_LIST = 148;      //Done

    //functions for administator to client
    public static final int ADD_CLIENT = 170;              //Done
    public static final int DEACTIVATE_CLIENT = 171;       //Done
    public static final String GET_CLIENTS_LIST = "172";        //Done
    public static final int GET_CLIENT_DATA = 174;         //Done
    public static final int CLIENT_UPDATE = 175;           //Done
    public static final int GET_USERS_LIST_BY_CLIENTID = 176; //Done


    //functions for administator to Users
    public static final int ADD_TECHNICIAN = 200;          //Done
    public static final int UPDATE_TECHNICIAN = 201;       //Done
    public static final int DEACTIVATE_TECHNICIAN = 202;   //Done
    public static final int GET_USERS_LIST_BY_COMP = 203;          //Done
    public static final int GET_USER_DATA = 207;           //Done
    public static final int GET_USER_BY_EMAIL = 204;       //Done
    public static final int ADD_USER = 205;                //Done
    public static final int DEACTIVATE_USER = 206;         //Done




    //Function for user profile
    public static final int LOGIN_USER = 301;              //Done
    public static final int USER_UPDATE_PROFILE = 302;     //Done

    //Function for user to calls
    public static final int LOG_CALL = 400;             //Majour issue
    public static final int ADD_CALL_RATE = 401;         //Done
    public static final int GET_CALL_HISTORY_LIST = 402; //To be Reviewed
    public static final int GET_NOTIFICATION = 403;
    public static final int GET_CALLTYPELIST = 404;  //Done
    public static final int CANCEL_LOGGED_CALL = 405;

    //Technician Request
    public static final int TECHNICIAN_LOGIN = 500;         //Done
    public static final int GET_ASSIGNED_CALL_LIST = 501;
    public static final int CALL_UPDATE = 502;   //Done
    public static final int CALL_ESCALATION = 503;
    public static final int GET_CALL_BY_TICKET_NUMBER = 504; //Done
    public static final int GET_ASSIGNED_CALL_DATA = 505; //Done
    public static final int GET_STATUS_LIST = 506;  //Done



}
