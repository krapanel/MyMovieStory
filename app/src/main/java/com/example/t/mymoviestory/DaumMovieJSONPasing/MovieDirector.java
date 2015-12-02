package com.example.t.mymoviestory.DaumMovieJSONPasing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieDirector implements JSONParsing {

    public String content; // 감독명명
    public String link; // 참조 링크 (감독 상세정보 링크)

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        content = jsonObject.getString("content");
        link = jsonObject.getString("link");
    }
}
