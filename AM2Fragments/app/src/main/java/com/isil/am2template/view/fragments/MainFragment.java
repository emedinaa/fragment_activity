package com.isil.am2template.view.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.isil.am2template.R;
import com.isil.am2template.view.OnFragmentListener;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="MainActivityFragment" ;

    private String mParam1;
    private String mParam2;
    private View rlayBg;

    private OnFragmentListener mListener;
    public MainFragment() {
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.fragment_main, container, false);
        rlayBg= v.findViewById(R.id.rlayBg);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.v(TAG, "rlayContainer "+rlayBg);
    }

    public void hello()
    {
        Log.v(TAG, "hello");
        Toast.makeText(getActivity(), "Hola Main Fragment ", Toast.LENGTH_LONG).show();
    }

    public void connected(boolean status)
    {
        if(status)
        {
            Log.v(TAG, "status connected");
            rlayBg.setBackgroundColor(Color.GREEN);
        }else
        {
            Log.v(TAG, "status lost");
            rlayBg.setBackgroundColor(Color.RED);
        };

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
