package com.example.t.mymoviestory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.t.mymoviestory.KobisMovieJSONParsing.DailyBoxOfficeProperty;
import com.example.t.mymoviestory.KobisMovieJSONParsing.DailyBoxOfficeResult;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by T on 2015-12-01.
 */
public class MovieBoxOfficeActivity extends AppCompatActivity {

    String[] spinnerItems = {"일간", "주간"};
    Spinner boxOfficeSpinner;

    // 일간 박스오피스 아이템을 배치시킬 RecyclerView
    RecyclerView boxOfficeRecyclerView;

    // 일간 박스오피스 하나의 뷰들을 컨트롤 할 Adapter
    MovieBoxOfficeAdapter movieBoxOfficeAdapter;

    // 일간 박스오피스 객체를 담을 ArrayList
    ArrayList<DailyBoxOfficeProperty> dailyBoxOfficePropertyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boxoffice_layout);

        boxOfficeSpinner = (Spinner) findViewById(R.id.boxoffice_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerItems);
        boxOfficeSpinner.setAdapter(adapter);
        boxOfficeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinnerItems[position].equals("일간")) {

                } else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        boxOfficeRecyclerView = (RecyclerView) findViewById(R.id.boxoffice_recyclerview);

        // 어제 날짜 구하기
        Calendar calendar1 = new GregorianCalendar();
        calendar1.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String yesterday = sdf.format(calendar1.getTime());
        Log.e("어제 날짜>>", yesterday);
        // 박스오피스 Top 10 파싱
        new BoxOfficeTask().execute(yesterday);
    }

    private class BoxOfficeTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dailyBoxOfficePropertyList = new ArrayList<DailyBoxOfficeProperty>();
        }

        @Override
        protected String doInBackground(String... params) {
            String requestURL = String.format(MyMovieConstant.KOBIS_DAILY_URL, params[0]);
            try {
                URL url = new URL(requestURL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("Accept", "application/json");
                int responseCode = con.getResponseCode();
                Log.e("responseCode>>", responseCode + "");
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n\r");
                    }
                    return sb.toString();
                }
            } catch (MalformedURLException e) {
                Log.e("MalformedURLException!", e.toString());
            } catch (IOException e) {
                Log.e("IOException!", e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                Log.e("s >>", s);
                Gson gson = new Gson();
                DailyBoxOfficeResult result = gson.fromJson(s, DailyBoxOfficeResult.class);
                Log.e("파싱된 결과 갯수 >>", result.dailyBoxOffice.dailyBoxOfficeProperties.size()+"");
                for (DailyBoxOfficeProperty boxOfficeProperty : result.dailyBoxOffice.dailyBoxOfficeProperties) {
                    dailyBoxOfficePropertyList.add(boxOfficeProperty);
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MovieBoxOfficeActivity.this, LinearLayoutManager.VERTICAL, false);
                boxOfficeRecyclerView.setLayoutManager(linearLayoutManager);
                movieBoxOfficeAdapter = new MovieBoxOfficeAdapter(dailyBoxOfficePropertyList);
                boxOfficeRecyclerView.setAdapter(movieBoxOfficeAdapter);
                movieBoxOfficeAdapter.notifyDataSetChanged();
            } else {
                Log.e("onPostExecute()에서 에러!", "s == null 입니다.");
            }
        }
    }

}
