package com.example.myapplication.utils;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;

public class AplClient {
    public static final String BASE_URL = "https://api.github.com/graphql";
    public static final String TAG = "APP";
    private static ApolloClient mApolloClient;

    public static ApolloClient getmApolloClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        mApolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build();


        return mApolloClient;
    }
}
