package com.example.t.mymoviestory.KobisMovieJSONParsing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 2015-12-01.
 */
public class WeeklyBoxOfficeList implements JSONParsing {
    public String rnum; // 순번
    public String rank; // 일간 박스오피스 랭킹
    public String rankInten; // 전일대비 순위의 증감분
    public String rankOldAndNew; // 랭킹 신규 진입 여부 Old / New
    public String movieNm; // 영화명
    public String openDt; // 개봉일
    public String audiAcc; // 누적관객
    public String scrnAcc; // 스크린수
    public String showCnt; // 상영횟수

    /* 일단 파싱하긴 하지만 안쓰는 속성들 */
    public String movieCd; // 영화 대표코드 (안쓸듯 하다. 보류)
    public String salesAmt; // 조회 날짜일의 매출액 (안쓸거다)
    public String salesShare; // 해당일자 상영작의 매출총액 대비 해당 영화의 매출비율 (안쓸거다)
    public String salesInten; // 전일 대비 매출액 증감분 (안쓸거다)
    public String salesChange; // 전일 대비 매출액 증감 비율 (안쓸거다)
    public String salesAcc; // 누적매출액 (안쓸거다)
    public String audiCnt; // 조회 날짜일의 관객수 (안쓸거다)
    public String audiInten; // 전일 대비 관객수 증감분 (안쓸거다)
    public String audiChange; // 전일 대비 관객수 증감 비율 (안쓸거다)

    @Override
    public void parsing(JSONObject jsonObject) throws JSONException {
        rnum = jsonObject.getString("rnum");
        rank = jsonObject.getString("rank");
        rankInten = jsonObject.getString("rankInten");
        rankOldAndNew = jsonObject.getString("rankOldAndNew");
        movieNm = jsonObject.getString("movieNm");
        openDt = jsonObject.getString("openDt");
        audiAcc = jsonObject.getString("audiAcc");
        scrnAcc = jsonObject.getString("scrnAcc");
        showCnt = jsonObject.getString("showCnt");

        movieCd = jsonObject.getString("movieCd");
        salesAmt = jsonObject.getString("salesAmt");
        salesShare = jsonObject.getString("salesShare");
        salesInten = jsonObject.getString("salesInten");
        salesChange = jsonObject.getString("salesChange");
        salesAcc = jsonObject.getString("salesAcc");
        audiCnt = jsonObject.getString("audiCnt");
        audiInten = jsonObject.getString("audiInten");
        audiChange = jsonObject.getString("audiChange");
    }
}
