package com.example.ginibykirill.model;

import com.example.ginibykirill.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/raw/8wJzytQX")
    Call<Post> getPost();
}
