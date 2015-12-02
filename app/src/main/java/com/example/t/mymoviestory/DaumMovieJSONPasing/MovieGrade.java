package com.example.t.mymoviestory.DaumMovieJSONPasing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-11-30.
 */
public class MovieGrade implements JSONParsing  {

    public String content; // 평점
    public String link; // 참조 링크 (안쓸거다)

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        content = jsonObject.getString("content");
        link = jsonObject.getString("link");
    }
}
