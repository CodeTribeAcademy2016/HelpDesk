package za.co.codetribe.userhelpdesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import za.co.codetribe.userhelpdesk.dto.AdministratorDTO;
import za.co.codetribe.userhelpdesk.helpdeskuser.HomeActivity;

public class ProfileUpdate extends AppCompatActivity {

    AdministratorDTO Administrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        Administrator =  (AdministratorDTO) getIntent().getSerializableExtra("administratorDTO");

        EditText name = (EditText) findViewById(R.id.edt_name);
        EditText surname = (EditText) findViewById(R.id.edt_surname);
        EditText telno  = (EditText) findViewById(R.id.edt_tel);
        EditText celno = (EditText) findViewById(R.id.edt_cellphone);

        if(Administrator != null)
        {
            name.setText(Administrator.getFirstName().toString());
            surname.setText(Administrator.getLastName().toString());
            telno.setText(Administrator.getTelephoneNo().toString());
            celno.setText(Administrator.getCellNo().toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_menu, menu);

        MenuItem profile = menu.findItem(R.id.send_profile);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if (id == android.R.id.home)
        {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
