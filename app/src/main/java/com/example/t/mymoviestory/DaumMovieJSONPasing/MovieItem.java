package com.example.t.mymoviestory.DaumMovieJSONPasing;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-11-30.
 */
public class MovieItem implements JSONParsing {

    /*
    파싱하는 모든 데이터는 content와 link 2개가 넘어온다.
    */
    @SerializedName("genre")
    public List<MovieGenre> genreList; // 장르 리스트(content만 쓰자)
    @SerializedName("actor")
    public List<MovieActor> movieActorList; // 영화 등장인물들 (content만 쓰자. link는 해당 등장인물의 상세정보)
    @SerializedName("open_info")
    public List<MovieOpenInfo> movieOpenInfoList; // 영화 개봉 정보 (개봉일, 관람가, 러닝타임), (content만 쓰자)
    @SerializedName("grades")
    public List<MovieGrade> movieGradeList; // 영화 평점 (content만 쓰자)
    @SerializedName("director")
    public List<MovieDirector> movieDirector; // 감독 (content만 쓰자. link는 감독의 상세정보)
    @SerializedName("nation")
    public List<MovieNation> movieNation; // 제작 국가 (content만 쓰자)
    @SerializedName("res")
    public MovieReservation res; // 영화 예매 정보 링크 (link만 쓰자)
    @SerializedName("trailer")
    public MovieTrailer trailer; // 영화 예고편 영상 (link만 쓰자)
    @SerializedName("photo1")
    public MoviePhoto1 moviePhoto1; // 영화 극중 이미지1 (content만 쓰자)
    @SerializedName("photo2")
    public MoviePhoto2 moviePhoto2; // 영화 극중 이미지2 (content만 쓰자)
    @SerializedName("photo3")
    public MoviePhoto3 moviePhoto3; // 영화 극중 이미지3 (content만 쓰자)
    @SerializedName("photo4")
    public MoviePhoto4 moviePhoto4; // 영화 극중 이미지4 (content만 쓰자)
    @SerializedName("photo5")
    public MoviePhoto5 moviePhoto5; // 영화 극중 이미지5 (content만 쓰자)
    @SerializedName("story")
    public MovieStroy movieStroy; // 영화 줄거리 (content만 쓰자)
    @SerializedName("title")
    public MovieTitle movieTitle; // 영화 제목 (content만 쓰자)
    @SerializedName("audience")
    public MovieAudience movieAudience; // 동원 관객수 (content만 쓰자)
    @SerializedName("thumbnail")
    public MovieThumbnail movieThumbnail; // 영화 썸네일 이미지 (content만 쓰자)

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        genreList = new ArrayList<MovieGenre>();
        JSONArray array = jsonObject.getJSONArray("genre");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jGenre = array.getJSONObject(i);
            MovieGenre genre = new MovieGenre();
            genre.parsing(jGenre);
            genreList.add(genre);
        }

        movieActorList = new ArrayList<MovieActor>();
        JSONArray array2 = jsonObject.getJSONArray("actor");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jActor = array.getJSONObject(i);
            MovieActor actor = new MovieActor();
            actor.parsing(jActor);
            movieActorList.add(actor);
        }

        movieOpenInfoList = new ArrayList<MovieOpenInfo>();
        JSONArray array3 = jsonObject.getJSONArray("open_info");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jOpenInfo = array.getJSONObject(i);
            MovieOpenInfo openInfo = new MovieOpenInfo();
            openInfo.parsing(jOpenInfo);
            movieOpenInfoList.add(openInfo);
        }

        movieGradeList = new ArrayList<MovieGrade>();
        JSONArray array4 = jsonObject.getJSONArray("grades");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jGrade = array.getJSONObject(i);
            MovieGrade grade = new MovieGrade();
            grade.parsing(jGrade);
            movieGradeList.add(grade);
        }

        movieDirector = new ArrayList<MovieDirector>();
        JSONArray array5 = jsonObject.getJSONArray("director");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jDirector = array.getJSONObject(i);
            MovieDirector director = new MovieDirector();
            director.parsing(jDirector);
            movieDirector.add(director);
        }

        movieNation = new ArrayList<MovieNation>();
        JSONArray array6 = jsonObject.getJSONArray("nation");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jNation = array.getJSONObject(i);
            MovieNation nation = new MovieNation();
            nation.parsing(jNation);
            movieNation.add(nation);
        }

        res = new MovieReservation();
        JSONObject jRes = jsonObject.getJSONObject("res");
        res.parsing(jRes);

        trailer = new MovieTrailer();
        JSONObject jTrailer = jsonObject.getJSONObject("trailer");
        trailer.parsing(jTrailer);

        moviePhoto1 = new MoviePhoto1();
        moviePhoto2 = new MoviePhoto2();
        moviePhoto3 = new MoviePhoto3();
        moviePhoto4 = new MoviePhoto4();
        moviePhoto5 = new MoviePhoto5();
        JSONObject jPhoto1 = jsonObject.getJSONObject("photo1");
        JSONObject jPhoto2 = jsonObject.getJSONObject("photo2");
        JSONObject jPhoto3 = jsonObject.getJSONObject("photo3");
        JSONObject jPhoto4 = jsonObject.getJSONObject("photo4");
        JSONObject jPhoto5 = jsonObject.getJSONObject("photo5");
        moviePhoto1.parsing(jPhoto1);
        moviePhoto2.parsing(jPhoto2);
        moviePhoto3.parsing(jPhoto3);
        moviePhoto4.parsing(jPhoto4);
        moviePhoto5.parsing(jPhoto5);

        movieStroy = new MovieStroy();
        JSONObject jStroy = jsonObject.getJSONObject("story");
        movieStroy.parsing(jStroy);

        movieTitle = new MovieTitle();
        JSONObject jTitle = jsonObject.getJSONObject("title");
        movieTitle.parsing(jTitle);

        movieAudience = new MovieAudience();
        JSONObject jAudience = jsonObject.getJSONObject("audience");
        movieAudience.parsing(jAudience);

        movieThumbnail = new MovieThumbnail();
        JSONObject jThumbnail = jsonObject.getJSONObject("thumbnail");
        movieThumbnail.parsing(jThumbnail);

    }
}
