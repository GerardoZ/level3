package com.codecube.level3.rest;

import com.codecube.level3.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by gerardoz on 14/07/16.
 */
public interface UserService {

    @GET("getUsers")
    Call<List<User>> getUsers();

    @GET("deleteUser/{id}")
    Call<User> deleteUser(@Path("id") int id);
}
