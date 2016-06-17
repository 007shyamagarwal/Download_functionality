package com.example.htl.downloadpaper;


import okhttp3.ResponseBody;
import retrofit.Callback;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by htl on 14/6/16.
 */



public interface RetrofitInterface {

    @GET
    @Streaming
    Call<ResponseBody> downloadFileWithDynamicUrlSync(
            @Url String fileUrl);


    @retrofit.http.GET("/gmr/papers.php")
    void downloadFile1(
            Callback<DocumentBean> response);

    @GET("gmr/Upload/papers/{imagepath}")
    @Streaming
    Call<ResponseBody> downloadFile1(@Path("imagepath") String  imagepath);


}

