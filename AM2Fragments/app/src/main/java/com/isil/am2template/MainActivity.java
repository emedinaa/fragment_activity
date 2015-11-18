package com.isil.am2template;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.isil.am2template.view.OnFragmentListener;
import com.isil.am2template.view.fragments.MainActivityFragment;


public class MainActivity extends ActionBarActivity implements OnFragmentListener {

    private MainActivityFragment fragmentA;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager= getSupportFragmentManager();
        fragmentA= (MainActivityFragment)fragmentManager.findFragmentById(R.id.fragmentA);
        if(fragmentA!=null)
        {
            fragmentA.hello();
        }
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
