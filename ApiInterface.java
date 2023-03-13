package com.example.retrofit_task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("posts")
    Call<List<Post_Model>> getPosts();

    @GET("posts/1/comments")
    Call<List<Comment_Model>> getComment();

    @POST("posts")
    Call<Post_Model> newPost(@Body Post_Model post_model);

    @PUT("posts/{id}")
    Call<Post_Model> putPost(@Path("id") int id,@Body Post_Model post_model);

    @PATCH("posts/{id}")
    Call<Post_Model> patchPost(@Path("id") int id,@Body Post_Model post_model);

    @DELETE("posts/{postId}")
    Call<Void> deletePost(@Path("postId") int postId);
}
