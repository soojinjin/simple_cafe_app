package com.cookandroid.project_99;
//메뉴보여주는 창, 장바구니에 메뉴가 담길때 "담겼습니다." 토스트 버튼 뜨게 하기


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

            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice1),
                    "아메리카노", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice2),
                    "카페라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice3),
                    "바닐라라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice4),
                    "녹차라떼", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice5),
                    "카라멜마끼야또", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice6),
                    "카페모카", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice7),
                    "아샷추", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice8),
                    "아이스티", "1800원") ;
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice9),
                    "레몬에이드", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice10),
                "자몽에이드", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice11),
                "청포도에이드", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice12),
                "딸기에이드", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice13),
                "한라봉에이드", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice14),
                "밀크티", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice15),
                "밀크초코", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice16),
                "딸기라떼", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice17),
                "블랙펄라떼", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice18),
                "딸기요거트스무디", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice19),
                "블루베리요거트스무디", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice20),
                "플레인요거트스무디", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice21),
                "레몬티", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice22),
                "자몽티", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice23),
                "오렌지자몽블랙티", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice24),
                "페퍼민트티", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice25),
                "캐모마일티", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice26),
                "딸기주스", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice27),
                "망고주스", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice28),
                "토마토주스", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice29),
                "우유마카롱", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice30),
                "딸기마카롱", "1800원") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ice31),
                "초코마카롱", "1800원") ;



            // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;
                    String titleStr = item.getTitle() ;
                    String descStr = item.getDesc() ;
                    Drawable iconDrawable = item.getIcon() ;

                    Intent intent = new Intent(Buy.this, HotandIce.class);
                    intent.putExtra("title2", titleStr);
                    intent.putExtra("desc2", descStr);
                    //intent.putExtra("icon", iconDrawable);

                    Intent intent2 = new Intent(getApplicationContext(), HotandIce.class);
                    startActivity(intent2);


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



}




