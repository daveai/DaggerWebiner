package com.qnet.rxjavawebiner.root;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qnet.rxjavawebiner.di.AppScope;
import com.qnet.rxjavawebiner.githubapi.GitHubAPIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @AppScope
    Gson provideGson(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }

    @Provides
    @AppScope
    Retrofit provideRetrofit(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    @Provides
    @AppScope
    GitHubAPIService provideGitHubAPIService(Gson gson, Retrofit retrofit){
        GitHubAPIService gitHubAPIService = new GitHubAPIService(gson, retrofit);
        return gitHubAPIService;
    }
}
