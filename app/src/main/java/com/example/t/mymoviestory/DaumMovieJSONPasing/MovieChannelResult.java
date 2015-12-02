package com.example.t.mymoviestory.DaumMovieJSONPasing;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieChannelResult implements JSONParsing {

    @SerializedName("channel")
    public MovieChannel movieChannel;

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        movieChannel = new MovieChannel();
        JSONObject jMovieChannel = jsonObject.getJSONObject("channel");
        movieChannel.parsing(jMovieChannel);
    }
}
