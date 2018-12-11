package com.qnet.rxjavawebiner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<String> dataset;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.repo_list_item,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.repoTitle.setText(dataset.get(i));
        myViewHolder.repoSubTitle.setText(dataset.get(i));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView repoTitle;
        public TextView repoSubTitle;

        public MyViewHolder(View view) {
            super(view);
            repoTitle = view.findViewById(R.id.repotitle);
            repoSubTitle = view.findViewById(R.id.reposubtitle);
        }
    }

    public MyAdapter(List<String> dataset) {
        this.dataset = dataset;
    }
}
