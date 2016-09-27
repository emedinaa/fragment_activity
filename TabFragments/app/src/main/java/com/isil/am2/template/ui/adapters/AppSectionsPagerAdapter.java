package com.isil.am2.template.ui.adapters;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.isil.am2.template.model.Order;
import com.isil.am2.template.ui.fragments.ATabFragment;
import com.isil.am2.template.ui.fragments.BTabFragment;

/**
 * Created by eduardo on 03/09/16.
 */
public  class AppSectionsPagerAdapter extends FragmentPagerAdapter  {

    public final static int AFRAGMENTINDEX=0;
    public final static  int BFRAGMENTINDEX=1;

    private ATabFragment aTabFragment;
    private BTabFragment bTabFragment;

    public AppSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case AFRAGMENTINDEX:
                aTabFragment= ATabFragment.newInstance(null,null);
                return aTabFragment;
            case BFRAGMENTINDEX:
                bTabFragment =BTabFragment.newInstance(null,null);
                return bTabFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String titile= "";
        switch (position){
            case AFRAGMENTINDEX :
                titile= "Registro de Encargo";
            break;
            case BFRAGMENTINDEX:
                titile= "Entrega de Encargo";
            break;
            default:

        }
        return titile;
    }

    public void updateFragment(Object object,int position){
        switch (position){
            case AFRAGMENTINDEX:
                break;
            case BFRAGMENTINDEX:
                if(bTabFragment!=null){
                    bTabFragment.addOrder((Order) object);
                }
                break;
        }
    }
}