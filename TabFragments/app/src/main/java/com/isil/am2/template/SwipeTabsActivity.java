package com.isil.am2.template;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.isil.am2.template.model.Order;
import com.isil.am2.template.ui.OnTabListener;
import com.isil.am2.template.ui.adapters.AppSectionsPagerAdapter;

public class SwipeTabsActivity extends AppCompatActivity implements OnTabListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link android.support.v4.app.FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something you want
                close();
            }
        });

    }

    private void close() {
        finish();
    }

    private void setupViewPager(ViewPager viewPager) {
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAppSectionsPagerAdapter);
    }

    @Override
    public void onAddedOrder(Order order) {
        if(mAppSectionsPagerAdapter!=null){
            mAppSectionsPagerAdapter.updateFragment(order,AppSectionsPagerAdapter.BFRAGMENTINDEX);
        }
    }

}
