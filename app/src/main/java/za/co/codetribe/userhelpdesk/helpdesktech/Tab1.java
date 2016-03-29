package za.co.codetribe.userhelpdesk.helpdesktech;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import za.co.codetribe.userhelpdesk.R;

/**
 * Created by kgundula on 16/03/21.
 */
public class Tab1 extends Fragment {

    private static final String[] statuslist = {"Open", "Acknowledge", "Work in progress","Customer Unavailable","Waiting Third Party","Cancel","Customer Testing","Closed"};
    private static final String[] Technicianlist = {"Elvis Dikgale", "Yolanda","Lazi", "Jabulani"};


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //View v = inflater.inflate(R.layout.tab_1, container, false);

        View v = inflater.inflate(R.layout.tab_1, container, false);
        final Spinner s = (Spinner) v.findViewById(
                R.id.spinnerStatusUpdate);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
                .getActivity().getBaseContext(),
                android.R.layout.simple_spinner_item, statuslist);
        s.setAdapter(adapter);

        //View v1 = inflater.inflate(R.layout.tab_1, container, false);
        final Spinner s1 = (Spinner) v.findViewById(
                R.id.spinnerTechName);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this
                .getActivity().getBaseContext(),
                android.R.layout.simple_spinner_item, Technicianlist);
        s1.setAdapter(adapter1);


        return v;


    }
}
