package com.pabloc6.sheepdating;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends ActionBarActivity {

    private static final String TAG = "DEBUG->MainActivity2";
    private ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        final String TAG_LOCAL = TAG + ".onCreate";
        Log.d(TAG_LOCAL, "IN");

        String[] values = {"Dolly", "Parton", "White","Black", "Edna", "Tikva","Maya", "Suzi"};

        // Currently getting data to print from intent
        // TODO
        // Have access to DB from all activities, understand why when declared in App it doesn't
        // work correctly
        //   ArrayList<String> valuesArray = getNames();
//        ArrayList<String> valuesArray = getIntent().getExtras().getStringArrayList("dBase");
        ArrayList<String> valuesArray = getIntent().getExtras().getStringArrayList("sheepNames");

//        Bundle extras = getIntent().getExtras();
//        getStringArrayListExtra("sheepNames");

        myListView = (ListView) findViewById(R.id.lv_show_sheep);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valuesArray);

        //MyAdapter adapter = new MyAdapter(this, 0, values);

        myListView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
}
