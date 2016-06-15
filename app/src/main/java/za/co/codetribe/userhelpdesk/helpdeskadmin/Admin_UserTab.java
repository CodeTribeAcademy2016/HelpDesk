package za.co.codetribe.userhelpdesk.helpdeskadmin;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import za.co.codetribe.userhelpdesk.R;
import za.co.codetribe.userhelpdesk.utils.Constants;
import za.co.codetribe.userhelpdesk.utils.HelpOkHttp;


public class Admin_UserTab extends Fragment {

    String jsonString;
    JSONObject jObj;
    int companyID;
    String ClinetList[];

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_admin__user_tab, container, false);

        Intent intent = getActivity().getIntent();
        jsonString = intent.getStringExtra("jsonObject");


        try {
            if (jsonString != null) {

                jObj = new JSONObject(jsonString);
            }
            companyID = jObj.getJSONObject("companyDTO").getInt("companyID");
            Log.i("Tshego ", "Company ID : " + companyID + "");




        } catch (Exception e) {

            Log.i("Tshego", e.toString());

        }



        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Fetching client list data by passing administrator company ID
                String json_payload = "";

                try {
                    json_payload = new JSONObject()
                            .put(Constants.companyID,companyID)
                            .put(Constants.requestType,Constants.GET_CLIENTS_LIST)
                            .toString();
                    Log.i("Fab","yoooh"+json_payload);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                final HelpOkHttp helpOkHttp = new HelpOkHttp();

               // Thread thread = new


                final AlertDialog.Builder commentDialog = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View v = inflater.inflate(R.layout.activity_add_user, null);
                commentDialog.setTitle("User Registration");
                commentDialog.setView(v);
                commentDialog.show();

                EditText email = (EditText) v.findViewById(R.id.edtAddUserEmail);
                //Spinner clientName = (EditText) v.findViewById(R.id.edtAddUserEmail);
                Button btnCancel = (Button) v.findViewById(R.id.btn_cancel_userProfile);
                Button btnSaveUser = (Button) v.findViewById(R.id.btn_save_user);

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });

                btnSaveUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });


                //commentDialog.show();
                /*Snackbar.make(view, "User Tab ;)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        return v;


    }


}
