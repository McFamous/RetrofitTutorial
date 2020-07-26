package com.example.retrofittutorial;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<PostModel> postsList;

    public PostsAdapter(List<PostModel> postsList) {
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        PostModel post = postsList.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.post.setText(Html.fromHtml(post.getElementPureHtml(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.post.setText(Html.fromHtml(post.getElementPureHtml()));
        }
        holder.site.setText(post.getSite());
    }

    @Override
    public int getItemCount() {
        if (postsList == null)
            return 0;
        return postsList.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder{
        TextView post;
        TextView site;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            post = itemView.findViewById(R.id.postitem_post);
            site = itemView.findViewById(R.id.postitem_site);
        }
    }
}