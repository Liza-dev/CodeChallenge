package com.example.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.model.CommitModel;
import com.example.myapplication.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {


    private MutableLiveData<CommitModel> commitModelMutableLiveData = new MutableLiveData<>();
    private CommitModel commitModel;

    MainViewModel(CommitModel commitModel) {
        this.commitModel = commitModel;
    }

    void loadCommitData() {
        commitModelMutableLiveData.postValue(commitModel);
    }

    MutableLiveData<CommitModel> getCommit() {
        return commitModelMutableLiveData;
    }

}


