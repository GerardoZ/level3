package com.codecube.level3.rest;

import android.content.Context;


import com.codecube.level3.MainActivity;
import com.codecube.level3.R;
import com.codecube.level3.adapters.UsersAdapter;
import com.codecube.level3.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gerardoz on 14/07/16.
 */
public class UsersRest {
    public static Context c;
    public static List<User> users;


    public static List<User> consultar(){
        Call<List<User>> call;
        String base_url = MainActivity.c.getResources().getString(R.string.domain);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        final UserService service = retrofit.create(UserService.class);
        call = service.getUsers();
        call.enqueue(new Callback<List<User>>(){
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                System.out.println(response.body());
                System.out.println(response.code());
                users = response.body();
                if(users != null){
                    UsersAdapter adapter = new UsersAdapter(MainActivity.c, R.layout.list_item, users);
                    MainActivity.listView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();

            }
        });
        return users;
    }

    public static void delete(int id){
        Call<User> call;
        String base_url = MainActivity.c.getResources().getString(R.string.domain);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        final UserService service = retrofit.create(UserService.class);
        call = service.deleteUser(id);
        call.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.body());
                consultar();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }



    public static User getUserByPosittion(int position) {
        return users.get(position);
    }

    public static List<User> getUsers(){
        return users;
    }
}
