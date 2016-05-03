package za.co.codetribe.userhelpdesk;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import za.co.codetribe.userhelpdesk.transfer.ResponseDTO;
import za.co.codetribe.userhelpdesk.utils.Constants;
import za.co.codetribe.userhelpdesk.utils.HelpOkHttp;

public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.input_email) EditText emailText;
    @Bind(R.id.input_password) EditText passwordText;
    @Bind(R.id.btn_login) Button loginButton;
    TextView signupLink;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        getSupportActionBar().hide();

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login()
    {

        String user_email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        String json_payload = "";

        try {
            json_payload = new JSONObject()
                    .put(Constants.email, user_email)
                    .put(Constants.password,password)
                    .put(Constants.requestType,Constants.loginRequestType)
                    .toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("Ygritte",json_payload);

        final String json_pay = json_payload;

        final HelpOkHttp helpOkHttp = new HelpOkHttp();
        Log.i("Ygrite", "You know nothing Jon Snow!!");

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Log.i("Ygritte", Constants.helpDeskUrl);
                    Log.i("Ygritte", json_pay);

                    String res = helpOkHttp.post(Constants.helpDeskUrl+"?JSON="+json_pay, json_pay);

                    JSONObject jsonObject = new JSONObject(res);

                    String TelephoneNo = jsonObject.getJSONObject("administratoDTO").getString("telephoneNo");
                    String statusCode = jsonObject.getString("statusCode");
                    //String breakPoint = jsonObject.ge
                    //ResponseDTO dto = new ResponseDTO(res);
                    //Your code goes here
                    Log.i("Tshego u the main man",res);




                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        //System.out.println(response);


       /* if (!validate()) {
            onLoginFailed();
            return;
        }*/
        /*
        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);

        */
    }

    public void onBackPressed() {

        moveTaskToBack(true);
    }

    public void onLoginSuccess() {

        loginButton.setEnabled(true);
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if(email.toLowerCase() == "t") {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if(email.toLowerCase() == "u")
        {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        }else if(email.toLowerCase() == "a")
        {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        }

    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }
}
