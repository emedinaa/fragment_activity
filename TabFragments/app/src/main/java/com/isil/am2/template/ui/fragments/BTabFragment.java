package com.isil.am2.template.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.isil.am2.template.R;
import com.isil.am2.template.model.Order;
import com.isil.am2.template.ui.OnTabListener;
import com.isil.am2.template.ui.adapters.OrderAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *  interface
 * to handle interaction events.
 * Use the {@link BTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BTabFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnTabListener mListener;
    private List<Order> orders;
    private OrderAdapter orderAdapter;
    private ListView lstOrders;

    public BTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BTabFragment newInstance(String param1, String param2) {
        BTabFragment fragment = new BTabFragment();
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
        View v= inflater.inflate(R.layout.fragment_btab, container, false);
        lstOrders= (ListView)v.findViewById(R.id.lstOrders);
        return v;
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

        Order order= new Order(1, "Primer encargo");
        Order order1= new Order(2, "Segundo encargo");
        Order order2= new Order(3, "Tercer encargo");
        Order order3= new Order(4, "Cuarto encargo");

       orders= new ArrayList<>();
       orders.add(order);
       orders.add(order1);
       orders.add(order2);
       orders.add(order3);
        orderAdapter= new OrderAdapter(orders,getActivity());
        lstOrders.setAdapter(orderAdapter);
    }

    public void addOrder(Order order){
        if(orderAdapter!=null && orders!=null){
            orders.add(order);
            orderAdapter= new OrderAdapter(orders,getActivity());
            lstOrders.setAdapter(orderAdapter);
        }
    }
}
