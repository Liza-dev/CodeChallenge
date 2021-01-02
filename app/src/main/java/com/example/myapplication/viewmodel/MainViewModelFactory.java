package com.example.myapplication.viewmodel;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.model.CommitModel;


public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final CommitModel commitModel;

    public MainViewModelFactory(CommitModel commitModel) {
        this.commitModel = commitModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(commitModel);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
