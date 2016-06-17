package com.example.htl.downloadpaper;

import android.content.Context;

public class RestClient extends AbstractRestClient {

    private RetrofitInterface DataService;

    public RestClient(Context context) {
        super(context, Constant.BASE_URL);

    }

    @Override
    public void initApi() {
        DataService = restAdapter.create(RetrofitInterface.class);
    }


    public RetrofitInterface getDataService() {
        return DataService;
    }
}
