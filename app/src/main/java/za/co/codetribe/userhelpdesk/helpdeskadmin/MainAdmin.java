package za.co.codetribe.userhelpdesk.helpdeskadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONObject;

import za.co.codetribe.userhelpdesk.ChangePassword;
import za.co.codetribe.userhelpdesk.LoginActivity;
import za.co.codetribe.userhelpdesk.Profile;
import za.co.codetribe.userhelpdesk.ProfileUpdate;
import za.co.codetribe.userhelpdesk.R;
import za.co.codetribe.userhelpdesk.dto.AdministratorDTO;
import za.co.codetribe.userhelpdesk.dto.CompanyDTO;
import za.co.codetribe.userhelpdesk.helpdeskadmin.AdminAdapter.TabFragment;

public class MainAdmin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    String jsonString;
    AdministratorDTO Administrator;
    CompanyDTO Company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();



        Administrator =  (AdministratorDTO) getIntent().getSerializableExtra("administratorDTO");
        Company = (CompanyDTO) getIntent().getSerializableExtra("companyDTO");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
/*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        TextView name = (TextView) header.findViewById(R.id.txtProfileName);
        TextView email = (TextView) header.findViewById(R.id.txtProfileEmail);



        if(Administrator != null)
        {

            name.setText(Administrator.getFirstName().toString() +" "+ Administrator.getLastName().toString());
            email.setText(Administrator.getEmail().toString());

        }
        /*if (intent.getExtras() != null) {
            jsonString = intent.getStringExtra("jsonObject");
        }

        try {
            JSONObject jObj = new JSONObject(jsonString);
            name.setText(jObj.getJSONObject("administratoDTO").getString("firstName") + " " + jObj.getJSONObject("administratoDTO").getString("lastName"));
            email.setText(jObj.getJSONObject("administratoDTO").getString("email"));
        } catch (Exception e) {

        }*/


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the view profile
            Intent intent = getIntent();
            intent = new Intent(MainAdmin.this, Profile.class);
            if(Administrator != null)
            {
                intent.putExtra("administratorDTO",Administrator);
                intent.putExtra("companyDTO",Company);
            }
            /*final String jsonString = intent.getStringExtra("jsonObject");
            if ( jsonString !=null ) {
                intent.putExtra("jsonObject", jsonString.toString());
            }*/
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {

            // Handle the profile update
            Intent intent = new Intent(MainAdmin.this, ProfileUpdate.class);
            if(Administrator != null)
            {
                intent.putExtra("administratorDTO",Administrator);
                intent.putExtra("companyDTO",Company);
            }
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {

            Intent intent = new Intent(MainAdmin.this, ChangePassword.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {



        } else if (id == R.id.nav_send) {

            Intent intent = new Intent(MainAdmin.this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
