package za.co.codetribe.userhelpdesk.helpdesktech;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import za.co.codetribe.userhelpdesk.R;

/**
 * Created by User on 6/13/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] status;
    private final String[] loggedDate;


    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid, String[] status, String[] loggedDate) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.status = status;
        this.loggedDate = loggedDate;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTicketNo);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgUploadedPhoto);
        TextView extratxt = (TextView) rowView.findViewById(R.id.txtDescpription);
        TextView statustxt = (TextView) rowView.findViewById(R.id.txtStatus);
        TextView datetxt = (TextView) rowView.findViewById(R.id.txtDate);


        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);

        statustxt.setText("Status : " + status[position]);
        datetxt.setText("Date Logged : " + loggedDate[position]);
        if (position == 0) {
            extratxt.setText("Description : The Aircon is not swiching on.");
        } else if (position == 1) {
            extratxt.setText("Description : The monitor is not displaying clearly");

        } else if (position == 2) {
            extratxt.setText("Description : Plugs are faulty");

        } else if (position == 3) {

        }
        return rowView;

    }

    ;
}

