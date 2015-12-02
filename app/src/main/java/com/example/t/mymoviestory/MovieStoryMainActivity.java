package com.example.t.mymoviestory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieStoryMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // 영화 추천 탭 레이아웃
    // tab1: 장르로 추천, tab2: 감독으로 추천, tab3: 연령대별 추천
    TabLayout movieRecommandTabs;

    // 영화 추천 뷰 페이저
    // 1page: 장르로 추천, 2page: 감독으로 추천, 3page: 연령대별 추천
    ViewPager movieRecommandPager;

    // 영화 추천 Fragment 어댑터
    MovieRecommandAdapter movieRecommandAdapter;

    // 메인화면 박스오피스 레이아웃
    LinearLayout movieStoryMain;

    // 영화 평가하기 RecyclerView
    RecyclerView movieEstimateRecyclerview;

    // 영화 추천하기 레이아웃
    LinearLayout movieRecommand;

    // 영화 검색 레이아웃
    LinearLayout movieSearch;

    // 설정 레이아웃
    LinearLayout movieSetting;

    // 박스오피스 top3 RecyclerView
    RecyclerView boxOfficeTop3RecyclerView;

    // 최신영화 3개 RecyclerView
    RecyclerView newMovieRecyclerView;

    TextView goDailyBoxOffice;

    // 인텐트 테스트
    ImageView intenttesthaja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_story_main_layout);
        /*
        기본으로 있는 소스 시작
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /*
        // 기본으로 있는 소스 끝
        */

        // 탭이랑 뷰페이저 붙이기
        movieRecommandTabs = (TabLayout) findViewById(R.id.movie_recommand_tabs);
        movieRecommandPager = (ViewPager) findViewById(R.id.movie_recommand_pager);
        movieRecommandAdapter = new MovieRecommandAdapter(getSupportFragmentManager());
        movieRecommandPager.setAdapter(movieRecommandAdapter);
        movieRecommandTabs.setupWithViewPager(movieRecommandPager);

        movieRecommandTabs.removeAllTabs();
        String[] tabName = {"장르로 추천", "감독으로 추천", "연령대별 추천"};
        for (int i = 0; i < tabName.length; i++) {
            movieRecommandTabs.addTab(movieRecommandTabs.newTab().setText(tabName[i]));
        }

        movieStoryMain = (LinearLayout) findViewById(R.id.movie_story_main);
        movieEstimateRecyclerview = (RecyclerView) findViewById(R.id.movie_estimate_recyclerview);
        movieRecommand = (LinearLayout) findViewById(R.id.movie_recommand);
        movieSearch = (LinearLayout) findViewById(R.id.movie_search);
        movieSetting = (LinearLayout) findViewById(R.id.movie_setting);
        // Visibility 기본 셋팅
        movieStoryMain.setVisibility(View.VISIBLE);
        movieEstimateRecyclerview.setVisibility(View.GONE);
        movieRecommand.setVisibility(View.GONE);
        movieSearch.setVisibility(View.GONE);
        movieSetting.setVisibility(View.GONE);


        // 인텐트 테스트 하자
        intenttesthaja = (ImageView) findViewById(R.id.intenttesthaja);
        intenttesthaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieStoryMainActivity.this, MovieDetailActivity.class);
                startActivity(intent);
            }
        });

        goDailyBoxOffice = (TextView) findViewById(R.id.go_daily_box_office);
        goDailyBoxOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDailyBoxOffice();
            }
        });

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.movie_main) {
            Log.e("메인을", "클릭했다");
            movieStoryMain.setVisibility(View.VISIBLE);
            movieEstimateRecyclerview.setVisibility(View.GONE);
            movieRecommand.setVisibility(View.GONE);
            movieSearch.setVisibility(View.GONE);
            movieSetting.setVisibility(View.GONE);
        } else if (id == R.id.movie_estimate) {
            Log.e("평가하기를", "클릭했다");
            movieStoryMain.setVisibility(View.GONE);
            movieEstimateRecyclerview.setVisibility(View.VISIBLE);
            movieRecommand.setVisibility(View.GONE);
            movieSearch.setVisibility(View.GONE);
            movieSetting.setVisibility(View.GONE);
        } else if (id == R.id.movie_recommand) {
            Log.e("추천받기를", "클릭했다");
            movieStoryMain.setVisibility(View.GONE);
            movieEstimateRecyclerview.setVisibility(View.GONE);
            movieRecommand.setVisibility(View.VISIBLE);
            movieSearch.setVisibility(View.GONE);
            movieSetting.setVisibility(View.GONE);
        } else if (id == R.id.movie_ranking) {
            goDailyBoxOffice();
            Log.e("박스오피스 랭킹을", "클릭했다");
        } else if (id == R.id.movie_new) {
            Log.e("최신 영화 보기를", "클릭했다");
        } else if (id == R.id.movie_search) {
            Log.e("영화 검색을", "클릭했다");
            movieStoryMain.setVisibility(View.GONE);
            movieEstimateRecyclerview.setVisibility(View.GONE);
            movieRecommand.setVisibility(View.GONE);
            movieSearch.setVisibility(View.VISIBLE);
            movieSetting.setVisibility(View.GONE);
        } else if (id == R.id.movie_setting) {
            Log.e("세팅을", "클릭했다");
            movieStoryMain.setVisibility(View.GONE);
            movieEstimateRecyclerview.setVisibility(View.GONE);
            movieRecommand.setVisibility(View.GONE);
            movieSearch.setVisibility(View.GONE);
            movieSetting.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // 일간 박스오피스로 이동
    public void goDailyBoxOffice() {
        Intent intent = new Intent(MovieStoryMainActivity.this, MovieBoxOfficeActivity.class);
        startActivity(intent);
    }
}
