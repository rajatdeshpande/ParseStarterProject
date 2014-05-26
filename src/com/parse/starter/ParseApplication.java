package com.parse.starter;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ParseApplication extends Application {


    public List<ParseObject> menuParseObjects;
    public List<ParseObject> menuParseObjectsFromLocalDataStore;

    @Override
	public void onCreate() {
		super.onCreate();
        Parse.enableLocalDatastore(this);
		// Add your initialization code here
		Parse.initialize(this, "k2OwLbYllPsx6RKtkj6tcGYl4LNOAIbgZbEuL7bs", "9crV9wI5zyGZD49atZYyI51EOZ9NpqBS0ksONryy");
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);
        getMenuDataFromParse();
	}




    public void getMenuDataFromParse() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> menus, ParseException error) {
                if(menus != null){
                    Log.d("parse_data_fetch", "Retreived " + menus.size() + " Menu Items");
                    Toast.makeText(getApplicationContext(), "Got " + menus.size() + " items", Toast.LENGTH_SHORT);
                    Log.d("Parse Data", menus.get(1).get("item_name").toString());
                    menuParseObjects = menus;
                    ParseObject.pinAllInBackground(menuParseObjects);

                }
            }
        });
    }

    public MenuData getMenuDataForDay(String dayOfWeek) {
        MenuData menuData = new MenuData();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu").fromLocalDatastore();

        query.whereEqualTo("day_of_week", Integer.parseInt(dayOfWeek));

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if(parseObjects != null){
                    Log.d("Parse Local Data Store:", "Retreived " + parseObjects.size() + " Objects from local datastore");
                    putDataInObject(parseObjects);

                }
            }
        });

        if(menuParseObjectsFromLocalDataStore!=null) {

            for (ParseObject a : menuParseObjectsFromLocalDataStore) {

                if (a.get("day_of_week").toString() == dayOfWeek) {
                    Log.d("Experiment", a.get("item_name").toString());
                    menuData.dayOfWeek = a.get("day_of_week").toString();
                    menuData.itemNames.add(a.get("item_name").toString());
                    menuData.itemPrices.add(Integer.parseInt(a.get("item_price").toString()));
                }
            }

        }
        else{
            Log.d("Parse Local DataStore", "Something Went Wrong");
        }

        return menuData;

    }

    private void putDataInObject(List<ParseObject> parseObjects) {

        menuParseObjectsFromLocalDataStore = parseObjects;

    }

}
