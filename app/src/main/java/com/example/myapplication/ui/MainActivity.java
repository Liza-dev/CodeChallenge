package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model.CommitModel;
import com.example.myapplication.ui.adapter.CommitListAdapter;
import com.example.myapplication.ui.base.BaseActivity;
import com.example.myapplication.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel> {
    ActivityMainBinding binding;
    @NonNull
    @Override
    protected MainViewModel createViewModel() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.commitList; // In xml we have given id rv_movie_list to RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // you can use getContext() instead of "this"
        recyclerView.setLayoutManager(layoutManager);

        List<CommitModel> list = new ArrayList<>();
        list.add(new CommitModel("EndGame", "Aveneger endgame is awesome movie"));
        list.add(new CommitModel("Infinity wars", "Aveneger infinity wars is super awesome movie"));
        // ...
        CommitListAdapter adapter = new CommitListAdapter(MainActivity.this);
        adapter.setItems(list);
        recyclerView.setAdapter(adapter);
    }
}