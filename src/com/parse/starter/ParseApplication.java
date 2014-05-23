package com.parse.starter;

import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "k2OwLbYllPsx6RKtkj6tcGYl4LNOAIbgZbEuL7bs", "9crV9wI5zyGZD49atZYyI51EOZ9NpqBS0ksONryy");


		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);


	}

}
