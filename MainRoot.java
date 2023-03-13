package com.example.retrofit_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainRoot extends AppCompatActivity {
Button getPostBtn,getCommentBtn,postPostBtn,putBtn,patchBtn,deleteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_root);

        getPostBtn = findViewById(R.id.getPostBtn);
        getCommentBtn = findViewById(R.id.getCommentBtn);
        postPostBtn = findViewById(R.id.postPostBtn);
        putBtn = findViewById(R.id.putBtn);
        patchBtn = findViewById(R.id.patchBtn);
        deleteBtn = findViewById(R.id.deleteBtn);


        getPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoot.this,MainActivity.class);
                i.putExtra("data","getPost");
                startActivity(i);
            }
        });
        getCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoot.this,Comments_Page.class);
                i.putExtra("data","getComment");
                startActivity(i);
            }
        });

        postPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoot.this,MainActivity.class);
                i.putExtra("data","post");
                startActivity(i);
            }
        });
        putBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoot.this,MainActivity.class);
                i.putExtra("data","put");
                startActivity(i);
            }
        });

        patchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoot.this,MainActivity.class);
                i.putExtra("data","patch");
                startActivity(i);
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoot.this,MainActivity.class);
                i.putExtra("data","delete");
                startActivity(i);
            }
        });


    }
}