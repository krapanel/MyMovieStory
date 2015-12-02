package com.example.t.mymoviestory;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

/**
 * Created by T on 2015-11-30.
 */
public class MovieDetailActivity extends AppCompatActivity {

    // 영화 상세정보 탭
    // tab1: 줄거리, tab2: 출연, tab3: 포토, tab4: 평점
    TabHost movieDetailTabs;
    // 툴바 레이아웃
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        movieDetailTabs = (TabHost) findViewById(R.id.movie_detail_tabs);
        movieDetailTabs.setup();
        String[] tabNames = {"줄거리", "출연", "포토", "평점"};
        int[] tabContents = {R.id.tab1, R.id.tab2, R.id.tab3, R.id.tab4};
        for (int i = 0; i < tabNames.length; i++) {
            movieDetailTabs.addTab(movieDetailTabs.newTabSpec("tab"+i).setIndicator(tabNames[i]).setContent(tabContents[i]));
        }

        movieDetailTabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals("tab0")) {

                } else if (tabId.equals("tab1")) {

                } else if (tabId.equals("tab2")) {

                } else {

                }
            }
        });

        hideToolbar();
    }

    // 아래로 스크롤시 툴바 사라지게 하는 메소드
    public void hideToolbar() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("나의 Movie Story");
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

}
