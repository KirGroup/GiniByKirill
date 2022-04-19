package com.example.ginibykirill.viewModel;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ginibykirill.R;
import com.example.ginibykirill.model.Post;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Post postList;

    public PostsAdapter(Post postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText((Integer)postList.getNumbers().get(position));
    }

    @Override
    public int getItemCount() {
        return postList.getNumbers().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            Log.i("App121212", "tvTitle.getText().toString()");
        }
    }
}
