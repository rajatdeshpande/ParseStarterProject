package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class ParseStarterProjectActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */

    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonCreateAccount;
    Button buttonLogout;
    ParseUser user;
    ParseUser currentUser;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        user = new ParseUser();

        currentUser = ParseUser.getCurrentUser();

        buttonCreateAccount.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);

        ParseAnalytics.trackAppOpened(getIntent());


    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.buttonCreateAccount :

                if (editTextPassword.getText().length() > 0 && editTextEmail.getText().length() > 0) {

                    if (currentUser != null) {
                        Toast.makeText(getApplicationContext(), "You are already logged in with username" + currentUser.getEmail(), Toast.LENGTH_SHORT).show();

                    } else {

                        user.setUsername(editTextEmail.getText().toString());
                        user.setPassword(editTextPassword.getText().toString());
                        user.setEmail(editTextEmail.getText().toString());
                        currentUser = ParseUser.getCurrentUser();
                        user.signUpInBackground(new SignUpCallback() {
                            public void done(ParseException e) {
                                if (e == null) {

                                    Toast.makeText(getApplicationContext(), "Created User : " + editTextEmail.getText().toString(), Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getApplicationContext(), "Could not create User : " + editTextEmail.getText().toString(), Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
                break;
            case R.id.buttonLogout :
                if(currentUser != null) {
                    Toast.makeText(getApplicationContext(), "Logging out " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
                    currentUser.logOut();
//                currentUser = ParseUser.getCurrentUser();
                    currentUser = null;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Already Logged out", Toast.LENGTH_SHORT).show();
                }
        }
    }
}


