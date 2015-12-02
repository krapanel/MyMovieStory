package com.example.t.mymoviestory.DaumMovieJSONPasing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieChannel implements JSONParsing {

    public int totalCount; // 검색 결과수
    public String q; // 검색어 (ex: 내부자들)
    public MovieItems movieItems; // 파싱한 영화 데이터

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        totalCount = jsonObject.getInt("totalCount");
        q = jsonObject.getString("q");
        movieItems = new MovieItems();
        JSONObject jMovieItems = jsonObject.getJSONObject("items");
        movieItems.parsing(jMovieItems);
    }
}
