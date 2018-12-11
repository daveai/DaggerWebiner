package com.qnet.rxjavawebiner.root;

import android.app.Application;

import com.google.gson.Gson;
import com.qnet.rxjavawebiner.githubapi.GitHubAPIService;

import retrofit2.Retrofit;

public class App extends Application {

    GitHubAPIService gitHubAPIService;

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public GitHubAPIService getGitHubService(){

        return appComponent.getGitHubAPIService();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
