package com.example.t.mymoviestory.KobisMovieJSONParsing;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-12-01.
 */
public class WeeklyBoxOffice implements JSONParsing {

    @SerializedName("boxofficeType")
    public String WeeklyBoxOffice; // 주간 박스오피스
    public String showRange; // 조회 기간
    public WeeklyBoxOfficeList weeklyBoxOfficeList; // 조회 결과 리스트 (10개)

   @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
       WeeklyBoxOffice = jsonObject.getString("boxofficeType");
       showRange = jsonObject.getString("showRange");
       weeklyBoxOfficeList = new WeeklyBoxOfficeList();
       JSONObject jWeeklyBoxOfficeList = jsonObject.getJSONObject("weeklyBoxOfficeList");
       weeklyBoxOfficeList.parsing(jWeeklyBoxOfficeList);
    }
}
