package com.isil.am2.template.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.isil.am2.template.R;
import com.isil.am2.template.model.Order;

import java.util.List;

/**
 * Created by emedinaa on 08/09/15.
 */
public class OrderAdapter extends BaseAdapter {

    private List<Order> orders;
    private Context context;
    private ListView lstOrders;

    public OrderAdapter(List<Order> contactEntities, Context context) {
        this.orders =contactEntities;
        this.context=context;
    }

    @Override
    public int getCount() {
        return this.orders.size();
    }

    @Override
    public Object getItem(int position) {
        return this.orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Dibujar la celda
        LayoutInflater inflater=LayoutInflater.from(context);
        View container= inflater.inflate(R.layout.row_order, null);
        ImageView imgContact= (ImageView)container.findViewById(R.id.iviOrder);
        TextView tviName= (TextView)container.findViewById(R.id.tviName);

        //Extraer la entidad
        Order order= this.orders.get(position);
        //Asociar la entidad con el XML
        tviName.setText(order.getName());

        return container;
    }
}
