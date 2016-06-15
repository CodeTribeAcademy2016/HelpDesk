package za.co.codetribe.userhelpdesk.helpdesktech;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


import org.json.JSONObject;

import za.co.codetribe.userhelpdesk.R;

public class TechProfile extends AppCompatActivity {

    String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView FullName = (TextView) findViewById(R.id.pName);
        TextView Email = (TextView) findViewById(R.id.pEmail);
        TextView TelNo = (TextView) findViewById(R.id.pTelNo);
        TextView CellNo = (TextView) findViewById(R.id.pCellNo);
        TextView Role = (TextView) findViewById(R.id.pRole);

        Intent intent = getIntent();
        jsonString = intent.getStringExtra("jsonObject");

        try {
            JSONObject jObj = new JSONObject(jsonString);
            String dbFullName, dbEmail, dbTelNo, dbCellNo, dbRole;

            dbFullName = jObj.getJSONObject("technicianDTO").getString("firstName") + " " + jObj.getJSONObject("technicianDTO").getString("lastName");
            dbEmail = jObj.getJSONObject("technicianDTO").getString("email");
            dbTelNo = jObj.getJSONObject("technicianDTO").getString("telephoneNo");
            dbCellNo = jObj.getJSONObject("technicianDTO").getString("cellNo");
            dbRole = jObj.getJSONObject("technicianDTO").getString("role");

            if (dbFullName.toString() == "")
            {
                FullName.setText("Please edit your full name.");
            }
            else if(dbTelNo.toString() == "")
            {
                TelNo.setText("Please edit your Telephone No.");
            }
            else if(dbCellNo.toString() == "")
            {
                CellNo.setText("Please edit your cell Number");
            }
            else
            {
                FullName.setText(dbFullName.toString());
                Email.setText(dbEmail.toString());
                TelNo.setText(dbTelNo.toString());
                CellNo.setText(dbCellNo.toString());
                Role.setText(dbRole.toString());
            }


        } catch (Exception e) {

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(TechProfile.this, TechUpdateProfile.class);
                intent1.putExtra("jsonObject",jsonString);
                startActivity(intent1);

            }
        });
    }

}
