package com.example.kyle.androidtutorial;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(getApplicationContext(),"Creating", Toast.LENGTH_SHORT);
        toast.show();


    }

    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(getApplicationContext(),"On Start", Toast.LENGTH_SHORT);
        toast.show();

    }

    protected void onRestart() {
        super.onRestart();
        Toast toast = Toast.makeText(getApplicationContext(),"On Restart", Toast.LENGTH_SHORT);
        toast.show();

    }


    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(getApplicationContext(),"On Resume", Toast.LENGTH_SHORT);
        toast.show();

    }

    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(getApplicationContext(),"On Stop", Toast.LENGTH_SHORT);
        toast.show();

    }

    protected void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(getApplicationContext(),"Destroying", Toast.LENGTH_SHORT);
        toast.show();

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
}
