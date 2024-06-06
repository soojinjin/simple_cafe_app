package com.cookandroid.project_99;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import org.json.JSONException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class MainMenuHomeFragment extends Fragment { private static final int INTERVAL_TIME = 3800;

    private View view;
    private ViewFlipper viewFlipper;
    private GridView gridView;
    private HomeGridAdapter adapter;
    private ArrayList<ProductBean> data;
    private ProductDBHelper dbHelper;

    Integer images[] = {
            R.drawable.mainimage1,
            R.drawable.mainimage2,
            R.drawable.mainimage3
    };
    ArrayList<Integer> images_list = new ArrayList<Integer>(Arrays.asList(images));
    // 메인. 슬라이드 형식 화면 절반치 광고, 아래에 상품 6개 정도 보여주기
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu_home, container, false);
        viewFlipper = view.findViewById(R.id.imageSlide);

        long mNow = System.currentTimeMillis();
        Date mReDate = new Date(mNow);
        SimpleDateFormat n_date = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat n_time = new SimpleDateFormat("HH00");
        String form_date = n_date.format(mReDate);
        WeatherData weatherData = new WeatherData();
        String form_time = n_time.format(mReDate);
        form_time = weatherData.timeChange(form_time);
        Log.i("Now_Date = ",form_date);
        Log.i("Now_time = ", form_time);

        final String[] weather = {""};
        final String[] temperature = {""};
        String finalForm_time = form_time;

        new Thread() {
            public void run() {
                try { // 현재는 일단 05시로 고정, 나중에는 나오는 시간 계산해서 최대한 가까운 측정가능시간으로 자동설정
                    weatherData.lookUpWeather(form_date, finalForm_time,"63","110");
                    weather[0] = weatherData.return_weather();
                    temperature[0] = weatherData.return_tmp();
                    if(images_list.contains(R.drawable.weatherimage) || images_list.contains(R.drawable.weatherimage2) || images_list.contains(R.drawable.weatherimage3) || images_list.contains(R.drawable.weatherimage4)){
                        Log.i("이미 날씨 정보가 들어가 있음 ", weather[0]);
                    } else {
                        if(weather[0] == "1") {
                            images_list.add(R.drawable.weatherimage3);
                            Log.i("1번 날씨로 변경", weather[0]);
                        } else if (weather[0] == "2") {
                            images_list.add(R.drawable.weatherimage);
                            Log.i("2번 날씨로 변경", weather[0]);
                        } else if (weather[0] == "3") {
                            images_list.add(R.drawable.weatherimage4);
                            Log.i("3번 날씨로 변경", weather[0]);
                        } else if (weather[0] == "4") {
                            images_list.add(R.drawable.weatherimage2);
                            Log.i("4번 날씨로 변경", weather[0]);
                        } else {
                            Log.i("아무것도 안나옴", weather[0]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        images = new Integer[images_list.size()];
        images_list.toArray(images);
        for(int image : images)
            flipperImages(image);

        showProduct();

        return view;
    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(INTERVAL_TIME);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getContext(), R.anim.slide_in_anim);
        viewFlipper.setOutAnimation(getContext(), R.anim.slide_out_anim);
    }

    private void showProduct() {
        dbHelper = ProductDBHelper.getInstance(getContext());
        data = dbHelper.getRandomProduct();

        gridView = view.findViewById(R.id.gridView);
        adapter = new HomeGridAdapter(getContext(), data);
        gridView.setAdapter(adapter);
    }
}