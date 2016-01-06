package com.bytech.younggeeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.bytech.younggeeks.activities.LoginActivity;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends ActionBarActivity {
    ParseUser currentUser = ParseUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (currentUser == null) {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }

    public void saveUser() {

        Log.d("saving User", "WE have entered enemy territory");
        ParseUser user = new ParseUser();
        user.setUsername("samjunior");
        user.setPassword("123455");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    //user has been saved
                } else {
                    Log.d("samjunior", "This is not saved ! an error occured");
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (currentUser != null) {
            menu.removeItem(R.id.action_login);
            menu.findItem(R.id.action_logout).setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_login:
                Log.d("Login Intent ", "Login Intent is now up next");
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
                finish();
                break;
            case R.id.action_logout:
                if (currentUser != null) {
                    ParseUser.logOut();
                    Log.d("Login Intent ", "Login Intent is now up next");
                    Intent loggedOut = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(loggedOut);
                    finish();
                    break;
                }
        }

        return super.onOptionsItemSelected(item);
    }
}
