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
public class MovieItems implements JSONParsing {

    @SerializedName("items")
    public List<MovieItem> movieItemList;

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        movieItemList = new ArrayList<MovieItem>();
        JSONArray array = jsonObject.getJSONArray("movieList");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jMovieItem = array.getJSONObject(i);
            MovieItem movieItem = new MovieItem();
            movieItem.parsing(jMovieItem);
            movieItemList.add(movieItem);
        }
    }
}
