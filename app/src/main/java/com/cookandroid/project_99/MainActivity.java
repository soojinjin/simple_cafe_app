package com.cookandroid.project_99;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private CustomDialog customDialog;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuGameFragment fragmentGame = new MainMenuGameFragment();
    private MainMenuHomeFragment fragmentHome = new MainMenuHomeFragment();
   // private MainMenuShopFragment fragmentShop = new MainMenuShopFragment();
    private MainMenuProfileFragment fragmentProfile = new MainMenuProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        //다이얼로그 밖의 화면은 흐리게 만들어줌
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);


        customDialog = new CustomDialog(this,"현재 대기 3팀 약 5분 정도 소요될 예정입니다!");
        customDialog.show();





    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.home:
                    transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.game:
                    transaction.replace(R.id.menu_frame_layout, fragmentGame).commitAllowingStateLoss();
                    break;
                case R.id.shop:
                    //transaction.replace(R.id.menu_frame_layout, fragmentShop).commitAllowingStateLoss();
                    Intent intent = new Intent(getApplicationContext(),Menu.class);
                    startActivity(intent);
                    break;
                case R.id.profile:
                    transaction.replace(R.id.menu_frame_layout, fragmentProfile).commitAllowingStateLoss();
                    break;

            }

            return true;
        }
    }

}
