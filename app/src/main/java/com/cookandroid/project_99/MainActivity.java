package com.cookandroid.project_99;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFinish = (Button) findViewById(R.id.button1); // 주문하기 버튼
        btnFinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy.class);
                startActivity(intent);
            }
        });

        Button goGame = (Button) findViewById(R.id.button2); // 게임하러가기 버튼
        goGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PuzzleGameMain.class);
                startActivity(intent);
            }
        });

        Button buylist = (Button) findViewById(R.id.button3); // 주문하기 버튼
        buylist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyList.class);
                startActivity(intent);
            }
        });

    }



}