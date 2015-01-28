package com.pabloc6.sheepdating;

import android.app.Application;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Pablo on 27/1/2015.
 */
public class MyApplication extends Application {

//    private ParseObject testObject;

    @Override
    public void onCreate() {
        super.onCreate();


        Log.d("DEBUG->", "Hello application");

        // Enable Local Datastore.
//        Parse.enableLocalDatastore(this);
//
//        Parse.initialize(this, "X55sojly2gvwQ6L5AmAhTWUMxjtFtpuSBf1RZZOR", "B4EuuDXZBaBTnDg8KBEDsjqWVRfrwPNkhetETKMk");
//
////        ParseObject testObject = new ParseObject("SheepTable");
//        testObject = new ParseObject("SheepTable");

       /* testObject.put("name", "Eitan");
        testObject.put("age", "55");
        testObject.saveInBackground();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("SheepTable");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
                Log.d("DEBUG->", "Found " + parseObjects.size() + " records");
            }
        });*/
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d("DEBUG->", "Goodbye application");
    }
}
