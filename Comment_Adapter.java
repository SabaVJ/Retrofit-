package com.example.retrofit_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Comment_Adapter extends RecyclerView.Adapter<Comment_Adapter.ViewHolder> {
    Context context;
    List<Comment_Model> comment_list;


    public Comment_Adapter(Context context, List<Comment_Model> comment_list) {
        this.context = context;
        this.comment_list = comment_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_comment,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment_Model modal = comment_list.get(position);

        holder.postId.setText("PostId : " +modal.getPostId());
        holder.id.setText("Id : " +modal.getId());
        holder.name.setText("Name : " +modal.getName());
        holder.email.setText("Email : " +modal.getEmail());
        holder.body.setText("Body : " +modal.getCommentText());


    }

    @Override
    public int getItemCount() {
        return comment_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView postId,id,name,email,body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postId = itemView.findViewById(R.id.postId);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);
        }
    }
}
