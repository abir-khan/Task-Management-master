package com.example.noor.taskmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noor.taskmanagement.interfaces.ConnectionApi;
import com.example.noor.taskmanagement.model.UserRequest;
import com.example.noor.taskmanagement.preference.SharedPref;
import com.example.noor.taskmanagement.responseModelClass.KraResponseModel;
import com.example.noor.taskmanagement.staticclasses.Functions;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.noor.taskmanagement.staticclasses.Functions.hideDialog;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_SIGNUP = 0;
    //boolean valid = true;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText eTuserId,eTpassword;
    private ImageView headerBackgroundIV;
    Button btLoginButton;


    Context context=this;
    ConnectionApi connectionApi;
    private int loginTryCounter=0;
    private long tryLoginTime = 0;
    private long currentTime = 0;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeGUI();
        handler = new Handler() ;
        tryLoginTime = Long.parseLong( SharedPref.getInstance( context ).getTryLoginTime() );
        currentTime = Calendar.getInstance().getTimeInMillis();

    }

    public void onLoginClick() {

        Log.d(TAG, "Login");
        String username = eTuserId.getText().toString();
        String userId = username;
        String password = eTpassword.getText().toString();
        login(userId,password);
//        btLoginButton.setEnabled(false);
//        Functions.ProgressDialog(this);
//        Functions.showDialog();
    }


    public void onLoginClickBackup() {

        Log.d(TAG, "Login");
        String username = eTuserId.getText().toString();
        String  userId = username;
        String password = eTpassword.getText().toString();
        pref = getSharedPreferences("login.conf", Context.MODE_PRIVATE);
        editor = pref.edit();
        //Username and Password needed to be saved in editor as later I would check in php, if right person trying to authorize php
        editor.putString("username", eTuserId.getText().toString());
        editor.putString("password", eTpassword.getText().toString());
        editor.apply();

        login(userId,password);

        btLoginButton.setEnabled(false);
        // TODO: Implement your own authentication logic here.
    }

    public void initializeGUI(){
        setContentView(R.layout.activity_main);

        headerBackgroundIV =  findViewById(R.id.headerBackgroundLL);
        Drawable dPage_header= getResources().getDrawable(R.drawable.nitol_niloy_group);
        dPage_header.setAlpha(25);



        eTuserId = (EditText) findViewById(R.id.eTuserId);
        eTpassword = (EditText) findViewById(R.id.eTpassword);
        btLoginButton = (Button) findViewById(R.id.loginBtn1);
        btLoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onLoginClick();

            }
        });



    }

    public void startProgressDialog(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the ChatMainActivity
        moveTaskToBack(true);
    }

    public void login(String userID, String password) {
        userID = eTuserId.getText().toString();
        password = eTpassword.getText().toString();

        connectionApi = Functions.getRetrofit().create(ConnectionApi.class);
        Call<KraResponseModel> call = connectionApi.getKraLogin(userID,password);
        Log.e("call",""+call);

        call.enqueue(new Callback<KraResponseModel>() {


            @Override
            public void onResponse(Call<KraResponseModel> call, Response<KraResponseModel> response) {
                int statusCode=response.code();
                Log.e("code1: ",""+statusCode);
                Log.e("response body: ",""+response.errorBody());
                Log.e("error response: ",""+response.code());
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Responsing", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Problem", Toast.LENGTH_SHORT).show();
                }
                if(statusCode==200){

                    Toast.makeText(MainActivity.this, "CodeOk"+statusCode, Toast.LENGTH_SHORT).show();
                    Log.e("code1: ",""+response.body());
                }else if (response.code() == 400) {
                    KraResponseModel user=response.body();
                    Log.e("Error code 400",""+ response.code());
                }
                else{
                    Toast.makeText(MainActivity.this, "Code2: "+statusCode, Toast.LENGTH_SHORT).show();
                }
                Log.e("res: ",""+response.body());
                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<KraResponseModel> call, Throwable t) {
                Log.e(TAG, "Got error : " + t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "Not Working", Toast.LENGTH_SHORT).show();

            }
        });

//        UserRequest loginRequest = new UserRequest();
//        loginRequest.setUserID(userID);
//        loginRequest.setPassword(password);


//        connectionApi = Functions.getRetrofit().create(ConnectionApi.class);
//        KraResponseModel kraResponseModel = new KraResponseModel();
//        Call<KraResponseModel> call = connectionApi.getKraLogin(userID,password);
//
//        call.enqueue(new Callback<KraResponseModel>() {
//            @Override
//            public void onResponse(Call<KraResponseModel> call, Response<KraResponseModel> response) {
//                Log.d("RESPONSE",  "Ok"+response.code());
//                int statusCode=response.code();
//                if(statusCode==200){
//                    KraResponseModel user=response.body();
//                    if(user.getID()!=null) {
//                        SharedPref.getInstance(getApplicationContext()).setUsername(userID);
//                        SharedPref.getInstance(getApplicationContext()).setPassword(password);
//                        Intent in = new Intent(MainActivity.this, UserProfile.class);
//                        SharedPref.getInstance(getApplicationContext()).setLoggedIn("true");
//                        startActivity(in);
//                        finish();
//                        hideDialog();
//                    }else {
//                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
//                        // progressDialog.cancel();
////                        if (progressDialog != null) {
////                            progressDialog.dismiss();
////                        }
//                        hideDialog();
//                        btLoginButton.setEnabled(true);
//                        Log.d("LoginActivity", "On Response: Failed");
//                    }
//                    }
//            }
//
//            @Override
//            public void onFailure(Call<KraResponseModel> call, Throwable t) {
//                hideDialog();
//                btLoginButton.setEnabled(true);
//                Toast.makeText(context, "On Response: Failed", Toast.LENGTH_SHORT).show();
//                Log.d("MainActivity","On Response: Failed");
//
//            }
//        });


    }



}
