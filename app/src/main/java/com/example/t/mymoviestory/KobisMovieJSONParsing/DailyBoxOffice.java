package com.example.t.mymoviestory.KobisMovieJSONParsing;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-12-01.
 */
public class DailyBoxOffice implements JSONParsing {

    @SerializedName("boxofficeType")
    public String DailyBoxOffice; // 일별 박스오피스
    public String showRange; // 조회 기간
    @SerializedName("dailyBoxOfficeList")
    public List<DailyBoxOfficeProperty> dailyBoxOfficeProperties; // 조회 결과 리스트 (10개)

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        DailyBoxOffice = jsonObject.getString("boxofficeType");
        showRange = jsonObject.getString("showRange");
        dailyBoxOfficeProperties = new ArrayList<DailyBoxOfficeProperty>();
        JSONArray array = jsonObject.getJSONArray("dailyBoxOfficeList");
        for (int i = 0; i < array.length(); i++) {
            JSONObject jDailyBoxOffice = array.getJSONObject(i);
            DailyBoxOfficeProperty dailyBoxOfficeProperty = new DailyBoxOfficeProperty();
            dailyBoxOfficeProperty.parsing(jDailyBoxOffice);
            dailyBoxOfficeProperties.add(dailyBoxOfficeProperty);
        }
    }
}
