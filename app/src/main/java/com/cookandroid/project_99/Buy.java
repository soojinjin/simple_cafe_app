package com.cookandroid.project_99;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Buy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);

            ListView listview ;
            ListViewAdapter adapter;

            // Adapter 생성
            adapter = new ListViewAdapter() ;

            // 리스트뷰 참조 및 Adapter달기
            listview = (ListView) findViewById(R.id.listView1);
            listview.setAdapter(adapter);

            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot1),
                    "따뜻한 아메리카노", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice1),
                    "차가운 아메리카노", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot2),
                    "따뜻한 카페라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot2),
                    "따뜻한 카페라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot2),
                    "따뜻한 카페라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot2),
                    "따뜻한 카페라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot2),
                    "따뜻한 카페라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot2),
                    "따뜻한 카페라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hot2),
                    "따뜻한 카페라떼", "1800원") ;



            // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {


                    ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                    String titleStr = item.getTitle() ;
                    String descStr = item.getDesc() ;
                    Drawable iconDrawable = item.getIcon() ;

                }
            });

        Button bt = (Button) findViewById(R.id.basketbt); // 장바구니 버튼
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Basket.class);
                startActivity(intent);
            }
        });

    }
    public void ClickHandler(View view)
    {
        Toast.makeText(this.getApplicationContext(),"장바구니에 담아졌습니다.", Toast.LENGTH_SHORT).show();
    }

}




