package com.cookandroid.project_99;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class HotandIce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hot_ice);

        String title1;
        String desc1;
        Drawable icon;

        TextView test1= (TextView)findViewById(R.id.textView1);
        TextView test2= (TextView)findViewById(R.id.textView2);

        Intent intent = getIntent();

        title1 = intent.getStringExtra("title2");
        desc1 = intent.getStringExtra("desc2");

        test1.setText(title1);
        test2.setText(desc1);

        Button buybt = (Button) findViewById(R.id.basketgo); //  다시 Buy.xml로 돌아가기
        buybt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"담아짐", Toast.LENGTH_SHORT).show();
            }
        });


    }
}



///
//                  Intent intent = getIntent();
//
//
//
//                  sub_text = intent.getStringExtra("문자");
//
//
//
//                  sub_number = intent.getIntExtra("숫자", 0);

//                  System.out.println("문자 테스트 :" + sub_text);
//
//
//
//                  System.out.println("숫자 테스트 :" + sub_number);
//출처: https://haruple.tistory.com/170 [하루플스토리:티스토리]