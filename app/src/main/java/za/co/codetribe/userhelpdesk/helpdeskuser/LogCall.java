package za.co.codetribe.userhelpdesk.helpdeskuser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import za.co.codetribe.userhelpdesk.R;

public class LogCall extends AppCompatActivity {
    Spinner spinner;
    ImageView img;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_call);
        img = (ImageView) findViewById(R.id.add_pic);
        img.setClickable(true);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });


        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> callType = new ArrayList<String>();
        callType.add("Select");
        callType.add("Network Problem");
        callType.add("Desktop Problem");
        callType.add("Software Installation");
        callType.add("Hardware");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, callType);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        img.setImageBitmap(bp);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
