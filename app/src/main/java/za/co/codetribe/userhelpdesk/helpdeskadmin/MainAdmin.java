package za.co.codetribe.userhelpdesk.helpdeskadmin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
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

import za.co.codetribe.userhelpdesk.R;

public class MainAdmin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        String administratorDTO = getIntent().getExtras().getString("AdminDTO");
        String companyDTO = getIntent().getExtras().getString("CompanyDTO");



        try {

            JSONObject objAdmin = new JSONObject(administratorDTO);
            JSONObject objCompany = new JSONObject(companyDTO);

            Log.d("My App", objAdmin.toString());
            Log.d("My App", objCompany.toString());

            TextView profileName = (TextView) findViewById(R.id.txtProfileName);
            profileName.setText(objAdmin.getString("firstName").toString() + " " + objAdmin.getString("lastName").toString());

            TextView profileEmail = (TextView) findViewById(R.id.txtProfileEmail);
            profileEmail.setText("Email.....");

        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + t + "\"");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        String administratorDTO = getIntent().getExtras().getString("AdminDTO");
        String companyDTO = getIntent().getExtras().getString("CompanyDTO");

        try {

            JSONObject objAdmin = new JSONObject(administratorDTO);
            JSONObject objCompany = new JSONObject(companyDTO);

            Log.d("My App", objAdmin.toString());
            Log.d("My App", objCompany.toString());

            TextView profileName = (TextView) findViewById(R.id.txtProfileName);
            profileName.setText(objAdmin.getString("firstName").toString() + " " + objAdmin.getString("lastName").toString());

            TextView profileEmail = (TextView) findViewById(R.id.txtProfileEmail);
            profileEmail.setText(objAdmin.getString("email").toString());

        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + t + "\"");

        }
        return true;
    }
}
