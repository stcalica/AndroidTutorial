package com.example.kyle.androidtutorial;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private static final int REQUEST_ENABLE_BT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BluetoothAdapter bluetooth;
        ArrayList<BluetoothDevice> btDeviceList = new ArrayList<BluetoothDevice>();
        TextView title = (TextView) findViewById(R.id.title);

        //Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothDevice.ACTION_UUID);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
//        registerReceiver(FoundRecieverCallback, filter); // Don't forget to unregister during onDestroy
        //ACTION FOUND RECIEVER IS A CALLBACK pasted below for example

        //get bluetooth adapter
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        Toast toastbt = Toast.makeText(getApplicationContext(), "Fetched Adapters" + btAdapter, Toast.LENGTH_SHORT);
        toastbt.show();
        if(btAdapter==null) {
            Toast toastb = Toast.makeText(getApplicationContext(), "Bluetooth Not Supported", Toast.LENGTH_SHORT);
            toastb.show();
        } else {
            if (btAdapter.isEnabled()) {
                Toast toastb = Toast.makeText(getApplicationContext(), "Bluetooth Started Discovery", Toast.LENGTH_SHORT);
                toastb.show();
              // Starting the device discovery
                btAdapter.startDiscovery();
            } else {
                //intent to turn on bluetooth if not enabled
                Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                Toast toastb = Toast.makeText(getApplicationContext(), "Bluetooth Enable Intent", Toast.LENGTH_SHORT);
                toastb.show();
            }
        }

        final Button button = (Button) findViewById(R.id.clickMe);

        button.setOnClickListener( new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   TextView title = (TextView) findViewById(R.id.title);
                   //change text of title
//                   Toast toastb = Toast.makeText(getApplicationContext(),"Button Clicked", Toast.LENGTH_SHORT);
//                   toastb.show();
                   if (title.getText() == "JoyRun"){
                       title.setText("iHopp");
 //                      Toast toastc1 = Toast.makeText(getApplicationContext(),"Changing to iHopp", Toast.LENGTH_SHORT);
//                       toastc1.show();

                   }
                   else{
                       title.setText("JoyRun");
                    //   Toast toastc2 = Toast.makeText(getApplicationContext(),"Changing to JoyRun", Toast.LENGTH_SHORT);
                      // toastc2.show();
                   }

               }
           }


        );//end of onClickListner



    } //end of oncreate

    /* This routine is called when an activity completes.*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
        Toast toastR = Toast.makeText(getApplicationContext(),"OnActivityResult", Toast.LENGTH_SHORT);
        toastR.show();
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
/*
 private final BroadcastReceiver ActionFoundReceiver = new BroadcastReceiver(){
             
            @Override
        public void onReceive(Context context,Intent intent){
             String action=intent.getAction();
             if(BluetoothDevice.ACTION_FOUND.equals(action)){
               BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
               out.append("\n  Device: "+device.getName()+", "+device);
               btDeviceList.add(device);
             }else{
               if(BluetoothDevice.ACTION_UUID.equals(action)){
                 BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                 Parcelable[]uuidExtra=intent.getParcelableArrayExtra(BluetoothDevice.EXTRA_UUID);
                 for(int i=0;i<uuidExtra.length;i++){
                   out.append("\n  Device: "+device.getName()+", "+device+", Service: "+uuidExtra[i].toString());
                 }
               }else{
                 if(BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)){
                   out.append("\nDiscovery Started...");
                 }else{
                   if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                     out.append("\nDiscovery Finished");
                     Iterator<bluetoothdevice>itr=btDeviceList.iterator();
                     while(itr.hasNext()){
                       // Get Services for paired devices
                       BluetoothDevice device=itr.next();
                       out.append("\nGetting Services for "+device.getName()+", "+device);
                       if(!device.fetchUuidsWithSdp()){
                         out.append("\nSDP Failed for "+device.getName());
                       }
                        
                     }
                   }
                 }
               }
              }
            }
 }

 */