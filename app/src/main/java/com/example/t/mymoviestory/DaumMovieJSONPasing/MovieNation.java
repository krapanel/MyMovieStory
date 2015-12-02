package com.example.t.mymoviestory.DaumMovieJSONPasing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieNation implements JSONParsing  {

    public String content; // 제작 국가
    public String link; // 참조링크 (안쓸거야)

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        content = jsonObject.getString("content");
        link = jsonObject.getString("link");
    }
}
