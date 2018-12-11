package com.qnet.rxjavawebiner.githubapi;

import com.qnet.rxjavawebiner.models.GitHubRepoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GitHubAPI {
    @GET("repositories")
    Observable<List<GitHubRepoModel>> getRepoFromRemote();
}
