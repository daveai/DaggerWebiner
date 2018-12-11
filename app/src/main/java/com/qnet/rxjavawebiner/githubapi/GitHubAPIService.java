package com.qnet.rxjavawebiner.githubapi;

import com.google.gson.Gson;
import com.qnet.rxjavawebiner.models.GitHubRepoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class GitHubAPIService {
    Gson gson;
    Retrofit retrofit;

    public GitHubAPIService(Gson gson, Retrofit retrofit) {
        this.gson = gson;
        this.retrofit = retrofit;
    }
    public Observable<List<GitHubRepoModel>> getRepoFromRemote(){
        GitHubAPI gitHubAPI = retrofit.create(GitHubAPI.class);
        Observable<List<GitHubRepoModel>> observableRepo = gitHubAPI.getRepoFromRemote();
        return observableRepo;
    }
}
