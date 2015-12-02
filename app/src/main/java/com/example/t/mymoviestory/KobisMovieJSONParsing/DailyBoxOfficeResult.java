package com.example.t.mymoviestory.KobisMovieJSONParsing;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-12-01.
 */
public class DailyBoxOfficeResult implements JSONParsing {

    @SerializedName("boxOfficeResult")
    public DailyBoxOffice dailyBoxOffice;

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        dailyBoxOffice = new DailyBoxOffice();
        JSONObject jBoxOfficeResult = jsonObject.getJSONObject("boxOfficeResult");
        dailyBoxOffice.parsing(jBoxOfficeResult);

    }
}
