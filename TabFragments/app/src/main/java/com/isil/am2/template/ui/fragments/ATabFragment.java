package com.isil.am2.template.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.isil.am2.template.R;
import com.isil.am2.template.model.Order;
import com.isil.am2.template.ui.OnTabListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {@link ATabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ATabFragment extends Fragment  implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnTabListener mListener;
    private String order;

    public ATabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ATabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ATabFragment newInstance(String param1, String param2) {
        ATabFragment fragment = new ATabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atab, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTabListener) {
            mListener = (OnTabListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().findViewById(R.id.btnCreateOrder).setOnClickListener(this);
        ((EditText)(getView().findViewById(R.id.eteOrder))).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    createOrder();
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch ((view.getId())){
            case R.id.btnCreateOrder:
                    createOrder();
                break;
        }
    }

    private void createOrder() {
        String name= ((EditText)(getView().findViewById(R.id.eteOrder))).getText().toString().trim();
        if(name.isEmpty())return;
        Order order= new Order(1,name);
        if(mListener!=null){
            mListener.onAddedOrder(order);
        }

        Toast.makeText(getActivity(),"Orden creada",Toast.LENGTH_SHORT).show();
    }
}
