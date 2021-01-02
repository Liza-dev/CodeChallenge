package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model.CommitModel;
import com.example.myapplication.ui.adapter.CommitListAdapter;
import com.example.myapplication.ui.base.BaseActivity;
import com.example.myapplication.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel> {
    ActivityMainBinding binding;
    MainViewModel mainViewModel;
    private CommitListAdapter adapter;

    @NonNull
    @Override
    protected MainViewModel createViewModel() {
        //MainViewModelFactory factory = new MainViewModelFactory(CommitModel.class);
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        mainViewModel = ViewModelProviders.of(this, getDefaultViewModelProviderFactory()).get(MainViewModel.class);
        mainViewModel.loadCommitLocal();
        mainViewModel.getCommit().observe(this, new CommitObserver());
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // you can use getContext() instead of "this"
        binding.commitList.setLayoutManager(layoutManager);
        adapter = new CommitListAdapter(MainActivity.this);
        binding.commitList.setAdapter(adapter);

    }

    private class CommitObserver implements Observer<List<CommitModel>> {
        @Override
        public void onChanged(List<CommitModel> commitModels) {
            if (commitModels == null) return;
            adapter.setItems(commitModels);
        }
    }
}