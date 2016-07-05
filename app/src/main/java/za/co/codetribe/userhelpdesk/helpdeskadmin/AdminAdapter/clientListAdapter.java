package za.co.codetribe.userhelpdesk.helpdeskadmin.AdminAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import za.co.codetribe.userhelpdesk.R;
import za.co.codetribe.userhelpdesk.helpdeskadmin.AdminDataCollection.ClientListInfo;

/**
 * Created by Tshego Masilo on 6/28/2016.
 */
public class clientListAdapter extends RecyclerView.Adapter<clientListAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<ClientListInfo> data = Collections.emptyList();

    public clientListAdapter(Context context, List<ClientListInfo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.client_custom_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ClientListInfo current = data.get(position);


        holder.clientName.setText(current.getClientName());
        holder.location.setText("Location : "+current.getLocation());
        holder.telNo.setText("Telephone No: "+current.getTelephone());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView clientName,location,telNo;


        public MyViewHolder(View itemView) {
            super(itemView);

            clientName = (TextView) itemView.findViewById(R.id.clientName);
            location = (TextView) itemView.findViewById(R.id.location);
            telNo = (TextView) itemView.findViewById(R.id.telNo);

        }
    }
}
