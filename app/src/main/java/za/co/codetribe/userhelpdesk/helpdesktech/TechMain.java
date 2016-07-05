package za.co.codetribe.userhelpdesk.helpdesktech;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import za.co.codetribe.userhelpdesk.Profile;
import za.co.codetribe.userhelpdesk.R;
import za.co.codetribe.userhelpdesk.helpdeskadmin.MainAdmin;
import za.co.codetribe.userhelpdesk.helpdesktech.adapter.ViewPagerAdapter;

public class TechMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;


    String jsonString;

    ListView list;
    String string ="2013-04-26 08:34:55.705";
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    String[] itemname ={
            "Ticket No : 123",
            "Ticket No : 45367",
            "Ticket No : 129088"
    };

    Integer[] imgid={
            R.drawable.faulty_air_con,
            R.drawable.faulty_monitor,
            R.drawable.electrical_faulty_plug,

    };
    String[] Status ={
            "Customer Unavailable",
            "Waiting for third party",
            "Work in progress"
    };
    String[] loggedDate ={
            "2016-03-14 08:34:55",
            "2016-03-15 13:17:00",
            "2016-03-17 10:00:00"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_main);



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

        Intent intent = getIntent();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid, Status,loggedDate);


       /* list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 0) {
                    Intent int0 = new Intent(getApplicationContext(), CallDetails.class);
                    startActivity(int0);
                }

                else if (position == 1) {
                    Intent int1 = new Intent(getApplicationContext(), CallDetails.class);
                    startActivity(int1);
                }
                else if (position == 2) {
                    Intent int2 = new Intent(getApplicationContext(), CallDetails.class);
                    startActivity(int2);
                }

                else if (position == 3) {
                    Intent int3 = new Intent(getApplicationContext(),CallDetails.class);
                    startActivity(int3);
                }
            }
        });*/


        View header = navigationView.getHeaderView(0);

        TextView name = (TextView) header.findViewById(R.id.txtProfileName);
        TextView email = (TextView) header.findViewById(R.id.txtProfileEmail);

        if (intent.getExtras() != null) {
            jsonString = intent.getStringExtra("jsonObject");
        }

        try {
            JSONObject jObj = new JSONObject(jsonString);
            name.setText(jObj.getJSONObject("technicianDTO").getString("firstName") + " " + jObj.getJSONObject("technicianDTO").getString("lastName"));
            email.setText(jObj.getJSONObject("technicianDTO").getString("email"));
        } catch (Exception e) {

        }
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
        getMenuInflater().inflate(R.menu.tech_main, menu);
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
            Intent intent = getIntent();
            intent = new Intent(TechMain.this, TechProfile.class);
            //final String jsonString = intent.getStringExtra("jsonObject");
            if ( jsonString !=null ) {
                intent.putExtra("jsonObject", jsonString.toString());
            }
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
