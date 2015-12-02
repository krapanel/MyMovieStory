package com.example.t.mymoviestory.DaumMovieJSONPasing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieTrailer implements JSONParsing  {
    public String content; // 영화 예고편 이미지
    public String link; // 영화 예고편 동영상 링크

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        content = jsonObject.getString("content");
        link = jsonObject.getString("link");
    }
}
