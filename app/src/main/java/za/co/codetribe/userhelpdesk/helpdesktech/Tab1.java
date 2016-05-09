package za.co.codetribe.userhelpdesk.helpdesktech;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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

        Button btnViewContacts = (Button) v.findViewById(R.id.btnView);
        btnViewContacts.setOnClickListener(new View.OnClickListener() {
            /*@Override
            public void onClick(View v) {
               Intent intent = new Intent(getContext(),Login.class);
                startActivity(intent);
            }*/        @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "View Contacts", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder bilder = new AlertDialog.Builder(getContext());
                bilder.setMessage("CLIENT INFORMATION "
                        +"\n"
                        +"\nFull Name: Jones Magadani, "
                        +"\nCompany Name: MLab "
                        +"\nEmail Address: jones@gmail.com"
                        +"\nContact Number: 0734327616"
                        +"\n"
                        +"\nADMINISTRATION INFORMATION "
                        +"\n"
                        +"\nFull Name: Fhatuwani Mufamadi, "
                        +"\nCompany Name: Innovation Hub "
                        +"\nEmail Address: fhatuwani.mufamadi@gmail.com"
                        +"\nContact Number: 0715058032");
                bilder.setTitle("Contacts");
                bilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = bilder.create();
                dialog.show();
            }
        });

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
