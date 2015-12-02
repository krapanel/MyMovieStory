package com.example.t.mymoviestory.DaumMovieJSONPasing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieGenre implements JSONParsing {

    public String content; // 장르명
    public String link; // 참조 링크

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        content = jsonObject.getString("content");
        link = jsonObject.getString("link");
    }
}
