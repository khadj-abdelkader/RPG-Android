package com.example.test;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class HttpUtils {

    public static final String URL_REGIONS = "https://geo.api.gouv.fr/regions/";

    private static final AsyncHttpClient httpClient = new AsyncHttpClient();

    public static void get(String url, RequestParams request, AsyncHttpResponseHandler response) {
        httpClient.get(url, request, response);
    }

}
