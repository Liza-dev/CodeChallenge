package com.example.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.model.CommitModel;
import com.example.myapplication.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseViewModel {
    private MutableLiveData<List<CommitModel>> commitModelMutableLiveData = new MutableLiveData<>();
    private CommitModel commitModel;

//    public MainViewModel(CommitModel commitModel) {
//        this.commitModel = commitModel;
//    }

  public MutableLiveData<List<CommitModel>> getCommit() {
        return commitModelMutableLiveData;
    }

    public void loadCommitNetworkData() {
        //call api
        setMovies(createLocalList());
    }

    public void loadCommitLocal() {
        //load local data
        setMovies(createLocalList());
    }

    private void setMovies(List<CommitModel> localList) {
        this.commitModelMutableLiveData.postValue(localList);
    }

    private List<CommitModel> createLocalList() {
        String name = "Person";
        String message = "initial Commit";
        String name1 = "Person 1";
        String message1 = "first Commit";
        String name2 = "Person";
        String message2 = "second Commit";

        List<CommitModel> commitModels = new ArrayList<>();

        CommitModel c1=new CommitModel(name,message);
        commitModels.add(c1);

        CommitModel c2=new CommitModel(name1,message1);
        commitModels.add(c2);

        CommitModel c3=new CommitModel(name2,message2);
        commitModels.add(c3);



        return commitModels;
    }

}


