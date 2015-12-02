package com.example.t.mymoviestory;

/**
 * Created by T on 2015-12-01.
 */
public class MyMovieConstant {

    // Daum 영화 정보 요청 URL
    // 요청 변수 q: 검색어(영화명)
    public static final String DAUM_URL = "https://apis.daum.net/contents/movie?apikey=4646ca43811413872910e9d03911fa6e&q=%s&output=json";

    // 한국 영화 진흥원 일간 박스오피스 요청 URL
    // 요청 변수 targetDt: 조회를 희망하는 날짜 (형식: yyyyMMdd)
    public static final String KOBIS_DAILY_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=e81a42ae068c57f853b1c5c805e03bbc&targetDt=%s";

    // 한국 영화 진흥원 주간 박스오피스 요청 URL
    // 요청 변수1 targetDt: 조회를 희망하는 날짜 (형식: yyyyMMdd)
    public static final String KOBIS_WEEKLY_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=e81a42ae068c57f853b1c5c805e03bbc&targetDt=%s&weekGb=0";

    // 한국 영화 진흥원 최신 영화 요청 URL
    // 요청 변수 openStartDt: 최근 년도
    public static final String KOBIS_NEW_MOVIE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=430156241533f1d058c603178cc3ca0e&openStartDt=%s";
}
