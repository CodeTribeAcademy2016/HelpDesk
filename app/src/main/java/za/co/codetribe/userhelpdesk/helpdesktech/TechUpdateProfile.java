package za.co.codetribe.userhelpdesk.helpdesktech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import za.co.codetribe.userhelpdesk.R;

public class TechUpdateProfile extends AppCompatActivity {


    String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_update_profile);

        //Edit Texts
        EditText edtName = (EditText) findViewById(R.id.edt_name);
        EditText edtSurname = (EditText)findViewById(R.id.edt_surname);
        TextView txtEmail = (TextView)findViewById(R.id.txtEmail);
        EditText edtCellphone = (EditText)findViewById(R.id.edt_cellphone);
        EditText edtTelephone = (EditText)findViewById(R.id.edt_telephone);
        TextView txtRole = (TextView)findViewById(R.id.edtRole);



        Intent intent = getIntent();
        jsonString = intent.getStringExtra("jsonObject");

        try {

            JSONObject jObj = new JSONObject(jsonString);
            edtName.setText(jObj.getJSONObject("technicianDTO").getString("firstName"));
            edtSurname.setText(jObj.getJSONObject("technicianDTO").getString("lastName"));
            txtEmail.setText(jObj.getJSONObject("technicianDTO").getString("email"));
            edtCellphone.setText(jObj.getJSONObject("technicianDTO").getString("cellNo"));
            edtTelephone.setText(jObj.getJSONObject("technicianDTO").getString("telephoneNo"));
            txtRole.setText(jObj.getJSONObject("technicianDTO").getString("role"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }






    }
}
