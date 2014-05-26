package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class LandingPage extends Activity {
    private EditText mTaskInput;
    private ListView mListView;
    private MenuAdapter mAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseAnalytics.trackAppOpened(getIntent());
        ParseObject.registerSubclass(Menu.class);
        setContentView(R.layout.landing_page);
        mTaskInput = (EditText) findViewById(R.id.task_input);
        mListView = (ListView) findViewById(R.id.task_list);
        mAdapter = new MenuAdapter(this, new ArrayList<Menu>());
        mListView.setAdapter(mAdapter);
        updateData();
    }

    public void createTask(View v) {
        if (mTaskInput.getText().length() > 0){
            Task t = new Task();
            t.setDescription(mTaskInput.getText().toString());
            t.setCompleted(false);
            t.saveInBackground();
            t.saveEventually();
            mTaskInput.setText("");
            updateData();
        }
    }

    public void updateData(){
        ParseQuery<Menu> query = ParseQuery.getQuery(Menu.class);
        query.findInBackground(new FindCallback<Menu>() {

            @Override
            public void done(List<Menu> menus, ParseException error) {
                if(menus != null){
                    mAdapter.clear();
                    mAdapter.addAll(menus);

                }
            }
        });




    }


}