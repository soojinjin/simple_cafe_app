package com.cookandroid.project_99;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherData  {private String weather = "", tmperature = "";

        public void lookUpWeather(String base_Date, String base_Time, String nx, String ny) throws IOException, JSONException {

            String baseTime = timeChange(base_Time);
            String type = "json";

            String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
            String serviceKey = "%2BTW1MU6x2aY7jJ1dssgvSmNFh9uKFH23l0NRzm%2F5ftcxRyZxRH88f%2BEC5FamM%2FgCMq9ICBlE0PtT%2FbHq2Oy7nQ%3D%3D";

            StringBuilder urlBuilder = new StringBuilder(apiUrl);
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(base_Date, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode(base_Time, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8"));

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response Code: "+ conn.getResponseCode());
            Log.i("Response Code : ", String.valueOf(conn.getResponseCode()));

            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            String result = sb.toString();

            JSONObject jsonObj_1 = new JSONObject(result);
            String response = jsonObj_1.getString("response");

            JSONObject jsonObj_2 = new JSONObject(response);
            String body = jsonObj_2.getString("body");

            JSONObject jsonObj_3 = new JSONObject(body);
            String items = jsonObj_3.getString("items");

            JSONObject jsonObj_4 = new JSONObject(items);
            JSONArray jsonArray = jsonObj_4.getJSONArray("item");

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObj_4 = jsonArray.getJSONObject(i);
                String fcstValue = jsonObj_4.getString("fcstValue");
                String category = jsonObj_4.getString("category");

                if (category.equals("SKY")) {
                    if (fcstValue.equals("1")) { // 1 == 맑음
                        weather = "1";
                    } else if (fcstValue.equals("2")) { // 2 == 비옴
                        weather = "2";
                    } else if (fcstValue.equals("3")) { // 3 == 구름이 많음
                        weather = "3";
                    } else if (fcstValue.equals("4")) { // 4 == 흐림
                        weather = "4";
                    }
                }

                if (category.equals("TMP")) {
                    tmperature = fcstValue;
                }

                Log.i("지금 날씨는", weather + tmperature);
            }
        }
        public String return_weather() {
            Log.i("리턴 직전 날씨 ",weather);
            return weather;
        }
        public String return_tmp() {
            Log.i("리턴 직전 기온 ", tmperature);
            return tmperature;
        }

        public String timeChange(String time)
        {
            switch(time) {

                case "0200":
                case "0300":
                case "0400":
                    time = "0200";
                    break;
                case "0500":
                case "0600":
                case "0700":
                    time = "0500";
                    break;
                case "0800":
                case "0900":
                case "1000":
                    time = "0800";
                    break;
                case "1100":
                case "1200":
                case "1300":
                    time = "1100";
                    break;
                case "1400":
                case "1500":
                case "1600":
                    time = "1400";
                    break;
                case "1700":
                case "1800":
                case "1900":
                    time = "1700";
                    break;
                case "2000":
                case "2100":
                case "2200":
                    time = "2000";
                    break;
                default:
                    time = "2300";
            }
            return time;
        }

}