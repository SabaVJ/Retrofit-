package com.example.retrofit_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ApiInterface apiInterface;
Post_Adapter post_adapter;
String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        if (intent.getStringExtra("data") != null){
            data = intent.getStringExtra("data");
            if (!data.isEmpty()){
                if (data.equals("getPost")){
                    setRetrofit();
                }else if (data.equals("post")){
                    setPost();
                }else if (data.equals("put")){
                    putPost();
                }else if (data.equals("patch")){
                    patchData();
                }else if (data.equals("delete")){
                    deletePost();
                }else {
                    test();
                }
            }
        }

    }

    private void deletePost() {
        apiInterface= APIClient_Post.getRetrofitInstance().create(ApiInterface.class);
        Call<Void> call = apiInterface.deletePost(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Failed" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Deleted successfully" + response.code(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void test() {

        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }
    private void putPost() {
        apiInterface = APIClient_Post.getRetrofitInstance().create(ApiInterface.class);
        Call<Post_Model> call = apiInterface.putPost(2,new Post_Model("13","title",null));
        call.enqueue(new Callback<Post_Model>() {
            @Override
            public void onResponse(Call<Post_Model> call, Response<Post_Model> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Response" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post_Model> putList = new ArrayList<>();
                putList.add(response.body());
                post_adapter = new Post_Adapter(MainActivity.this,putList);
                recyclerView.setAdapter(post_adapter);
            }

            @Override
            public void onFailure(Call<Post_Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Response" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setPost() {
        apiInterface = APIClient_Post.getRetrofitInstance().create(ApiInterface.class);
        Call<Post_Model> call = apiInterface.newPost(new Post_Model("18","First title","First body"));
        call.enqueue(new Callback<Post_Model>() {
            @Override
            public void onResponse(Call<Post_Model> call, Response<Post_Model> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Failed" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post_Model> newPost = new ArrayList<>();
                newPost.add(response.body());
                post_adapter = new Post_Adapter(MainActivity.this,newPost);
                recyclerView.setAdapter(post_adapter);
                Toast.makeText(MainActivity.this, response.code() + " Response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Post_Model> call, Throwable t) {
                Toast.makeText(MainActivity.this,  t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void patchData() {
        apiInterface = APIClient_Post.getRetrofitInstance().create(ApiInterface.class);
        Call<Post_Model> call = apiInterface.patchPost(2,new Post_Model("14","Sabarish",null));
        call.enqueue(new Callback<Post_Model>() {
            @Override
            public void onResponse(Call<Post_Model> call, Response<Post_Model> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Response" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Post_Model> put = new ArrayList<>();
                put.add(response.body());
                post_adapter = new Post_Adapter(MainActivity.this,put);
                recyclerView.setAdapter(post_adapter);

            }

            @Override
            public void onFailure(Call<Post_Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Response" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setRetrofit() {
        apiInterface = APIClient_Post.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Post_Model>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<Post_Model>>() {
            @Override
            public void onResponse(Call<List<Post_Model>> call, Response<List<Post_Model>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Failed" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post_Model> getList = response.body();
                post_adapter = new Post_Adapter(MainActivity.this,getList);
                recyclerView.setAdapter(post_adapter);
                Toast.makeText(MainActivity.this, response.code() + " Response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Post_Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}