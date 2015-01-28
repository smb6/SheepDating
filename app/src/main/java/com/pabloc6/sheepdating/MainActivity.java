package com.pabloc6.sheepdating;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    MyApplication app;
    private static final String TAG = "DEBUG->MainActivity";

    private ParseObject testObject;

    private EditText mEnterName;
    private EditText mEnterAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String TAG_LOCAL = TAG + ".onCreate";
        Log.d(TAG_LOCAL, "IN");

//        app = (MyApplication)getApplication();

        findViewById(R.id.b_insert_data).setOnClickListener(this);
        findViewById(R.id.b_view_all).setOnClickListener(this);

        mEnterName = (EditText) findViewById(R.id.et_EnterName);
        mEnterAge = (EditText) findViewById(R.id.et_EnterAge);


        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "X55sojly2gvwQ6L5AmAhTWUMxjtFtpuSBf1RZZOR", "B4EuuDXZBaBTnDg8KBEDsjqWVRfrwPNkhetETKMk");

        testObject = new ParseObject("SheepTable");
        testObject.put("name", "Fux");
        testObject.put("age", "99");
        testObject.saveInBackground();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("SheepTable");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
                Log.d("DEBUG->", "Found " + parseObjects.size() + " records");
            }
        });




      /*  Parse.enableLocalDatastore(this);

        Parse.initialize(this, "X55sojly2gvwQ6L5AmAhTWUMxjtFtpuSBf1RZZOR", "B4EuuDXZBaBTnDg8KBEDsjqWVRfrwPNkhetETKMk");

        ParseObject testObject = new ParseObject("SheepTable");
        testObject.put("name", "Shimon");
        testObject.put("age", "24");
        testObject.saveInBackground();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("SheepTable");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
                Log.d("DEBUG->", "Found " + parseObjects.size() + " records");
            }
        });*/

        /*query.whereEqualTo("name", "Shifra");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        final String TAG_LOCAL = TAG + ".onClick";
        Log.d(TAG_LOCAL, "IN");

        String tmpName = mEnterName.getText().toString();
        String tmpAge = mEnterAge.getText().toString();

        boolean nameIsEmpty = mEnterName.getText().toString().isEmpty();
        boolean ageIsEmpty = mEnterAge.getText().toString().isEmpty();

        if ((v.getId() == R.id.b_insert_data) && !nameIsEmpty && !ageIsEmpty) {
            Log.d(TAG_LOCAL, "b_insert_data");

            testObject.put("name", mEnterName.getText().toString());
            testObject.put("age", mEnterAge.getText().toString());
            testObject.saveInBackground();

            Toast.makeText(getBaseContext(), "Inserted " + tmpName + " " + tmpAge, Toast.LENGTH_LONG).show();

            mEnterName.setText("");
            mEnterAge.setText("");


        } else if (v.getId() == R.id.b_view_all) {
            Log.d(TAG_LOCAL, "b_view_all");
            ParseQuery<ParseObject> query = ParseQuery.getQuery("SheepTable");
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
                    Log.d("DEBUG->", "Found " + parseObjects.size() + " records");
                    Toast.makeText(getBaseContext(), parseObjects.size() + " items in table.", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
//                    List list = parseObjects;
//                    intent.putExtra("list", parseObjects.toArray(List));
//                    startActivity(intent);
                }
            });

        }

    }
}
