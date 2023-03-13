package com.example.retrofit_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Comments_Page extends AppCompatActivity {
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    Comment_Adapter comment_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_page);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // get comments method
        setRetrofit();
    }

    private void setRetrofit() {

        apiInterface = ApiClient_Comment.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Comment_Model>> call = apiInterface.getComment();
        call.enqueue(new Callback<List<Comment_Model>>() {
            @Override
            public void onResponse(Call<List<Comment_Model>> call, Response<List<Comment_Model>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Comments_Page.this, "Failed" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Comment_Model> getComment = response.body();
                comment_adapter = new Comment_Adapter(Comments_Page.this,getComment);
                recyclerView.setAdapter(comment_adapter);
                Toast.makeText(Comments_Page.this, response.code() +" Response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Comment_Model>> call, Throwable t) {
                Toast.makeText(Comments_Page.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}