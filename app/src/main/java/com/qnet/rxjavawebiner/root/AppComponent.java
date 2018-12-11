package com.qnet.rxjavawebiner.root;

import com.qnet.rxjavawebiner.di.AppScope;
import com.qnet.rxjavawebiner.githubapi.GitHubAPIService;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@AppScope
public interface AppComponent {
    GitHubAPIService getGitHubAPIService();
}
