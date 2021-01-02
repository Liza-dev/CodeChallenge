package com.example.myapplication.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.databinding.ItemRowBinding;
import com.example.myapplication.model.CommitModel;

import java.util.ArrayList;
import java.util.List;


public class CommitListAdapter extends RecyclerView.Adapter<CommitListAdapter.CommitViewHolder> {
    private List<CommitModel> items;
    private Context context;


    public CommitListAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }

    public void setItems(List<CommitModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public CommitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemRowBinding itemBinding = ItemRowBinding.inflate(layoutInflater, parent, false);
        return new CommitViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(CommitViewHolder holder, int position) {
        CommitModel commitModel = items.get(position);
        holder.bind(commitModel);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private CommitModel getItem(int position) {
        return items.get(position);
    }

    public class CommitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemRowBinding mItemRowBinding;

        CommitViewHolder(ItemRowBinding mItemRowBinding) {
            super(mItemRowBinding.getRoot());
            this.mItemRowBinding = mItemRowBinding;

        }

        void bind(CommitModel commitModel) {
            mItemRowBinding.setCommitModel(commitModel);
            mItemRowBinding.executePendingBindings();

        }

        @Override
        public void onClick(View view) {

        }
    }
}