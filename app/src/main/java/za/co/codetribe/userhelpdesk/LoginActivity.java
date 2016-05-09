package za.co.codetribe.userhelpdesk;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import za.co.codetribe.userhelpdesk.helpdeskadmin.MainAdmin;
import za.co.codetribe.userhelpdesk.utils.Constants;
import za.co.codetribe.userhelpdesk.utils.HelpOkHttp;

public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.input_email) EditText emailText;
    @Bind(R.id.input_password) EditText passwordText;
    @Bind(R.id.btn_login) Button loginButton;
    TextView signupLink;


    Handler handler = new Handler(Looper.getMainLooper());


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
        final String password = passwordText.getText().toString();

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

        final String json_pay = json_payload;

        final HelpOkHttp helpOkHttp = new HelpOkHttp();

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {


                try
                {
                    //Log.i("Ygritte", Constants.helpDeskUrl);
                    //Log.i("Ygritte", json_pay);

                    String res = helpOkHttp.post(Constants.helpDeskUrl+"?JSON="+json_pay, json_pay);
                    /*
                    * {"administratoDTO":
                    *     {"administratorID":1,"firstName":"Tshego","lastName":"Masilo","email":"tshego.masilo@absa.co.za","telephoneNo":"0128406110","cellNo":"0839586412","password":"Password","companyID":1,"activeFlag":false}
                    *     ,"companyDTO":{"companyID":1,"companyName":"ABSA","email":"info@absa.co.za","telephoneNo":"0117028965","activeFlag":true}
                    *     ,"statusCode":100,
                    *     "message":"Administrator has login successfully",
                    *     "requestType":0}
                    * */
                    JSONObject jsonObject = new JSONObject(res);
                    Log.i("Ygritte", res);


                    JSONObject administrator = jsonObject.getJSONObject("administratoDTO");
                    JSONObject company  = jsonObject.getJSONObject("companyDTO");
                    String first_name = administrator.getString("firstName");
                    // JSONObject administratorJsonObject = jsonObject.getJSONObject()
                    String statusCode = jsonObject.getString("statusCode");
                    //String TelephoneNo = jsonObject.getJSONObject("administratoDTO").getString("telephoneNo");
                    String message = jsonObject.getString("message");
                    if (statusCode == "0")
                    {

                        showToast("Login Failed");

                    }
                    else
                    {
                        showToast("Login Success "+statusCode+" My Name is : "+first_name);




                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent intent = new Intent (LoginActivity.this, MainAdmin.class);
                                startActivity(intent);
                            }
                        },1000);




                    }
                    //String breakPoint = jsonObject.ge
                    //ResponseDTO dto = new ResponseDTO(res);
                    //Your code goes here
                    Log.i("Tshego ;)",res);




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

    public void showToast(final String toast)
    {
        runOnUiThread(new Runnable() {
            public void run()
            {
                Toast.makeText(LoginActivity.this, toast, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void navigateActivity()
    {
        runOnUiThread(new Runnable() {
            public void run()
            {
               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
