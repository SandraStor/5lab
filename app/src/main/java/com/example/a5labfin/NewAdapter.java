package com.example.a5labfin;

import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NewAdapter extends ArrayAdapter<Order> {
    private Context mContext;
    private int mResource;
    private ArrayList<Order> orders;
    public NewAdapter(Context context, int resource, ArrayList<Order> orders) {
        super(context, resource, orders);
        mContext = context;
        mResource = resource;
        this.orders=orders;
    }
    @Override
    public Order getItem(int position) {
        return orders.get(position);
    }
    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Order order = orders.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        TextView companyName = (TextView) convertView.findViewById(R.id.companyName);
        TextView packageType = (TextView) convertView.findViewById(R.id.packageType);
        TextView initialAddress = (TextView) convertView.findViewById(R.id.initialAddress);
        TextView destinationAddress = (TextView) convertView.findViewById(R.id.destinationAddress);
        TextView packagePrice = (TextView) convertView.findViewById(R.id.packagePrice);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

        companyName.setText(order.getCompany());
        packageType.setText(order.getTypeOfPack());
        initialAddress.setText(order.getSourceAddress());
        destinationAddress.setText(order.getDestinationAddress());
        packagePrice.setText(order.getPrice());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if (isChecked) {
                    Order.total += Integer.parseInt(order.getPrice());
                } else {
                    Order.total -= Integer.parseInt(order.getPrice());
                }
            }

        });

        return convertView;
    }
}