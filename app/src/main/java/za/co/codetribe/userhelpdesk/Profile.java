package za.co.codetribe.userhelpdesk;

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
import za.co.codetribe.userhelpdesk.dto.AdministratorDTO;
import za.co.codetribe.userhelpdesk.dto.CompanyDTO;

public class Profile extends AppCompatActivity {
    AdministratorDTO Administrator;
    CompanyDTO Company;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView FullName = (TextView) findViewById(R.id.pName);
        TextView Email = (TextView) findViewById(R.id.pEmail);
        TextView TelNo = (TextView) findViewById(R.id.pTelNo);
        TextView CellNo = (TextView) findViewById(R.id.pCellNo);
        TextView CompanyName = (TextView) findViewById(R.id.pComName);


        /*Intent intent = getIntent();
        final String jsonString = intent.getStringExtra("jsonObject");*/
        Administrator =  (AdministratorDTO) getIntent().getSerializableExtra("administratorDTO");
        Company = (CompanyDTO) getIntent().getSerializableExtra("companyDTO");

        try {
            //JSONObject jObj = new JSONObject(jsonString);
            String dbFullName, dbEmail, dbTelNo, dbCellNo, dbCompanyName;

            /*dbFullName = jObj.getJSONObject("administratoDTO").getString("firstName") + " " + jObj.getJSONObject("administratoDTO").getString("lastName");
            dbEmail = jObj.getJSONObject("administratoDTO").getString("email");
            dbTelNo = jObj.getJSONObject("administratoDTO").getString("telephoneNo");
            dbCellNo = jObj.getJSONObject("administratoDTO").getString("cellNo");*/
            dbFullName = Administrator.getFirstName().toString() + " " + Administrator.getLastName().toString();
            dbEmail = Administrator.getEmail().toString();
            dbTelNo = Administrator.getTelephoneNo().toString();
            dbCellNo = Administrator.getCellNo().toString();
            dbCompanyName = Company.getCompanyName().toString();



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
                CompanyName.setText(dbCompanyName);
            }


        } catch (Exception e) {

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(Profile.this,ProfileUpdate.class);
                if (Administrator != null && Company != null)
                {
                    intent.putExtra("administratorDTO", Administrator);
                    intent.putExtra("companyDTO",Company);
                }
                startActivity(intent);
            }
        });
    }

}
