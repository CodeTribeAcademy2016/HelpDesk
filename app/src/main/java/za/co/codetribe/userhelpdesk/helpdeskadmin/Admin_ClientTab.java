package za.co.codetribe.userhelpdesk.helpdeskadmin;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import za.co.codetribe.userhelpdesk.R;
import za.co.codetribe.userhelpdesk.dto.AdministratorDTO;
import za.co.codetribe.userhelpdesk.dto.ClientDTO;
import za.co.codetribe.userhelpdesk.dto.CompanyDTO;
import za.co.codetribe.userhelpdesk.helpdeskadmin.AdminAdapter.clientListAdapter;
import za.co.codetribe.userhelpdesk.helpdeskadmin.AdminDataCollection.ClientListInfo;
import za.co.codetribe.userhelpdesk.utils.Constants;
import za.co.codetribe.userhelpdesk.utils.HelpOkHttp;


public class Admin_ClientTab extends Fragment {

    List<ClientDTO> clientList;
    ArrayAdapter<String> clientName;
    CompanyDTO Company;
    AdministratorDTO Administrator;
    ClientDTO clientDTO;
    JSONObject jsonObject;
    JSONArray ClientJsonArray = null;
    ListView listView;
    private static final String TAG_CLIENT = "clientList";
    private RecyclerView recyclerView;
    private clientListAdapter clientListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_admin__client_tab, container, false);

        Intent intent = getActivity().getIntent();
        Administrator =  (AdministratorDTO) intent.getSerializableExtra("administratorDTO");
        Company = (CompanyDTO) intent.getSerializableExtra("companyDTO");

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clients Tab ;)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) v.findViewById(R.id.client_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);



        // specify an adapter (see also next example)
        clientListAdapter = new clientListAdapter(getContext(),getData());
        recyclerView.setAdapter(clientListAdapter);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);



        return v;


    }


    public static List<ClientListInfo> getData()
    {

        /*{"clientList":[{"clientID":1,"clientName":"Pretoria_Branch","location":"Pretoria CBD","clientTelephoneNo":"0127228979","companyID":1},
        {"clientID":2,"clientName":"Rosslyn_Branch","location":"Rosslyn","clientTelephoneNo":"0127228123","companyID":1},
        {"clientID":3,"clientName":"Johannesburg_Branch","location":"Johannesburg CBD","clientTelephoneNo":"0115648200","companyID":1}],
        "statusCode":0,"message":"Client list has been retrieved successfully","requestType":0}
        * */
        List<ClientListInfo> data = new ArrayList<>();

        String[] ClientName ={"Dept I.T","Dept HR","Dept Finance","Dept Consultants"};
        String[] location = {"Cape Town","Bloemfontein","Durban","Pretoria"};
        String[] Telephone = {"0425852997","0145589632","031115666","0125829632"};

        for(int i = 0; i < ClientName.length && i < location.length; i++)
        {
            ClientListInfo current = new ClientListInfo();
            current.setClientName(ClientName[i]);
            current.setLocation(location[i]);
            current.setTelephone(Telephone[i]);
            data.add(current);

        }

        return data;

    }
}
