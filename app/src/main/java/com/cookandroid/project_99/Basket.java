package com.cookandroid.project_99;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Basket extends AppCompatActivity {
    Button cancel, buy, plus, minus;
    RadioButton radioButton1, radioButton2;
    ListView listView1;
    ImageView imageView;
    RadioGroup radioGroup;
    TextView text_View1, text_View2, text_View3,text_View4, coffee, dessert, beverage;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    ArrayAdapter arrayAdapter;
    DB_Menu2 db_menu;

    String num, num2, name, price, type;;
    Integer result, Count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        cancel = findViewById(R.id.cancel);
        buy = findViewById(R.id.buy);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        //textViews
        text_View1 = findViewById(R.id.text_View1);
        text_View2 = findViewById(R.id.text_View2);
        text_View3 = findViewById(R.id.text_View3);
        text_View4 = findViewById(R.id.text_View4);
        coffee = findViewById(R.id.coffee);
        dessert = findViewById(R.id.dessert);
        beverage = findViewById(R.id.beverage);
        //listViews
        listView1 = findViewById(R.id.listView1);
        //radio
        radioButton1 = findViewById(R.id.radio1);
        radioButton2 = findViewById(R.id.radio2);
        radioGroup = findViewById(R.id.rGroup);
        //imageViews
        imageView = findViewById(R.id.ImageView);
        // arraylist
        arrayList = new ArrayList<>();
        // adapter
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        // setAdapter to listView
        listView1.setAdapter(adapter);

        //get title, price and icon from GridView
        Intent intent =  getIntent();
        text_View1.setText(intent.getStringExtra("title"));
        text_View2.setText(intent.getStringExtra("price"));
        imageView.setImageResource(intent.getIntExtra("icon", 0));

        text_View3.setText(Integer.toString(Count));
        

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuModel clickMenu =  (MenuModel) parent.getItemAtPosition(position);
                db_menu.deleteOne(clickMenu);
                SHow(db_menu);
                Toast.makeText(Basket.this,"Deleted  = " + clickMenu.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        // return  mainActivity
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });

        // add into listView

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = text_View1.getText().toString();
                price = text_View4.getText().toString();

                if(radioButton1.isChecked() == true)
                    type = radioButton1.getText().toString();
                else {
                    type = radioButton2.getText().toString();
                }

                MenuModel  menuModel = new MenuModel(-1,name,Integer.parseInt(price),type);
                db_menu = new DB_Menu2(Basket.this);
                SHow(db_menu);
                // List<MenuModel> everything = db_menu.getEverything();

                DB_Menu2 db_menu = new DB_Menu2(Basket.this);
                boolean success = db_menu.addOne(menuModel);
                Toast.makeText(Basket.this,"Success  = " + success, Toast.LENGTH_SHORT).show();

                // Boolean insert = db_menu.insertData(Integer.toString(index), name, price,type);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --Count;
                text_View3.setText(Integer.toString(Count));
                num = text_View2.getText().toString();
                num2 = text_View4.getText().toString();
                result = Integer.parseInt(num2) - Integer.parseInt(num);
                text_View4.setText(Integer.toString(result));
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++Count;
                text_View3.setText(Integer.toString(Count));
                num = text_View2.getText().toString();
                result = Integer.parseInt(num) * Integer.parseInt(Count.toString());
                text_View4.setText(Integer.toString(result));
            }
        });
    }

    private void SHow(DB_Menu2 db_menu2) {
        arrayAdapter = new ArrayAdapter<MenuModel>(Basket.this, android.R.layout.simple_list_item_1, db_menu2.getEverything());
        listView1.setAdapter(arrayAdapter);
    }
}