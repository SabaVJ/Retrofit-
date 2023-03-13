package com.example.retrofit_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Post_Adapter extends RecyclerView.Adapter<Post_Adapter.ViewHolder> {

    public Context context;
    public List<Post_Model> post_list;

    public Post_Adapter(Context context, List<Post_Model> post_list) {
        this.context = context;
        this.post_list = post_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_post,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post_Model model = post_list.get(position);

        holder.userId.setText("Id : "+model.getUserId());
        holder.id.setText("UserId : "+model.getId());
        holder.title.setText("Title : "+model.getTitle());
        holder.body.setText("Body : "+model.getBody());

    }

    @Override
    public int getItemCount() {
        return post_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userId,id,title,body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.titleTxt);
            body = itemView.findViewById(R.id.body);
        }
    }
}
