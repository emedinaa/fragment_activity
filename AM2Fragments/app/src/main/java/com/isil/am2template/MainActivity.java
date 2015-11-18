package com.isil.am2template;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.isil.am2template.view.OnFragmentListener;
import com.isil.am2template.view.fragments.MainFragment;


public class MainActivity extends ActionBarActivity implements OnFragmentListener {

    private MainFragment fragmentA;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager= getSupportFragmentManager();
        fragmentA= (MainFragment)fragmentManager.findFragmentById(R.id.fragmentA);
        if(fragmentA!=null)
        {
            fragmentA.hello();
        }
        app();
    }

    private void app() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkStateReceiver, filter);
    }

    BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if(!noConnectivity) {
                onConnectionFound();
            } else {
                onConnectionLost();
            }
        }
    };


    public void onConnectionLost() {
        Toast.makeText(this, "Connection lost", Toast.LENGTH_LONG).show();
        if(fragmentA!=null)fragmentA.connected(false);
    }

    public void onConnectionFound() {
        Toast.makeText(this, "Connection found", Toast.LENGTH_LONG).show();
        if(fragmentA!=null)fragmentA.connected(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkStateReceiver);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onSendMessage(String msg) {

    }
}
