package com.cookandroid.project_99;
//장바구니 목록 등, 장바구니에 담긴 것이 없으면 버튼을 눌렀을 때 "담긴 것이 없습니다"라고 토스트버튼 뜨게 하기.

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Basket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listView2);
        listview.setAdapter(adapter);




        Button bt = (Button) findViewById(R.id.returnbt); // 다시 장바구니로 돌아가기
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy.class);
                startActivity(intent);

            }
        });
        //String titleStr = item.getTitle() ;
        //                    String descStr = item.getDesc() ;
        //                    Drawable iconDrawable = item.getIcon() ;
    }
}
