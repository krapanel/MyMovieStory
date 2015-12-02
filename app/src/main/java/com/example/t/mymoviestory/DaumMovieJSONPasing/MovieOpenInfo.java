package com.example.t.mymoviestory.DaumMovieJSONPasing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieOpenInfo implements JSONParsing  {

    public String content; // 개봉일, 관람가, 러닝타임 3개 들어오는 속성
    public String link; // 참조링크 (안쓸거야)

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        content = jsonObject.getString("content");
        link = jsonObject.getString("link");
    }
}
