package com.example.a5labfin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Courier courier;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
    }



    public void select(View view){
        TextView total = (TextView) findViewById(R.id.total);
        String tot = "Итог: " + Order.total;
        total.setText(tot);
    }

    public void clear(View view){
        CheckBox checkBox;
        for(int i = 0; i < list.getChildCount(); i++){
            checkBox = (CheckBox)list.getChildAt(i).findViewById(R.id.checkBox);
            checkBox.setChecked(false);
        }
        Order.total = 0;
        TextView total = (TextView) findViewById(R.id.total);
        String tot = "Итог: " + Order.total;
        total.setText(tot);
    }

    public void Filter(View view){
        Order.total = 0;
        TextView total = (TextView) findViewById(R.id.total);
        String tot = "Итог: " + Order.total;
        total.setText(tot);
        CheckBox car = (CheckBox) findViewById(R.id.car);
        CheckBox fragility = (CheckBox) findViewById(R.id.fragility);
        courier = createOrders();
        ArrayList<Order> orders = courier.getOrders();
        if(!car.isChecked()){
            for (int i = 0; i < orders.size(); i++){
                if(orders.get(i).getNeedCar()){
                    orders.remove(i);
                }
            }
        }
        if(!fragility.isChecked()){
            for (int i = 0; i < orders.size(); i++){
                if(orders.get(i).getFrag()){
                    orders.remove(i);
                }
            }
        }
        TextView info = (TextView) findViewById(R.id.Name);
        info.setText(courier.getName());
        NewAdapter adapter = new NewAdapter(this, R.layout.list, orders);
        list.setAdapter(adapter);

    }

    private Courier createOrders() {
        SmallPackage small1 = new SmallPackage();
        small1.setFragility(true);
        small1.setSize();
        small1.setNeedCar();
        SmallPackage small2 = new SmallPackage();
        small2.setFragility(false);
        small2.setSize();
        small2.setNeedCar();


        BigPackage big1 = new BigPackage();
        big1.setFragility(false);
        big1.setSize();
        big1.setNeedCar();
        BigPackage big2 = new BigPackage();
        big2.setFragility(true);
        big2.setSize();
        big2.setNeedCar();


        Document doc1 = new Document();
        doc1.setSize();
        doc1.setFragility(false);
        doc1.setNeedCar();
        Document doc2 = new Document();
        doc2.setSize();
        doc2.setFragility(false);
        doc2.setNeedCar();


        Company company1 = new Company("Читай-город", "Саратов");
        Company company2 = new Company("Полиграфист", "Москва");

        Courier courier = new Courier("Буров Г.В.", "123456");

        courier.addOrder(new Order(company1, small1, "Саратов", "Москва", 8000));
        courier.addOrder(new Order(company1, big1, "Тула", "Волгоград", 20000));
        courier.addOrder(new Order(company1, doc1, "Мичуринск", "Тамбов", 4000));
        courier.addOrder(new Order(company2, small2, "Энгельс", "Тамбов", 7000));
        courier.addOrder(new Order(company2, big2, "Саратов", "Казань", 18000));
        courier.addOrder(new Order(company2, doc2, "Москва", "Саратов", 9000));

        return courier;
    }
}
