package com.example.t.mymoviestory.KobisMovieJSONParsing;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-12-01.
 */
public class WeeklyBoxOfficeResult implements JSONParsing {

    @SerializedName("boxOfficeResult")
    public WeeklyBoxOffice weeklyBoxOffice;

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        weeklyBoxOffice = new WeeklyBoxOffice();
        JSONObject jBoxOfficeResult = jsonObject.getJSONObject("boxOfficeResult");
        weeklyBoxOffice.parsing(jBoxOfficeResult);

    }
}
