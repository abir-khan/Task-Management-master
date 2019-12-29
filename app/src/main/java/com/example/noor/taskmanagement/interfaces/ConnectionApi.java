package com.example.noor.taskmanagement.interfaces;

import com.example.noor.taskmanagement.responseModelClass.KraResponseModel;

import java.util.Set;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by HP on 9/6/2017.
 */

public interface ConnectionApi {
    @GET("/NNG.Web/AndroidAppService/Login.asmx/TaskList")
    Call<KraResponseModel> getKraLogin(
            @Query("UserID") String UserID, @Query("Password") String Password);
}
