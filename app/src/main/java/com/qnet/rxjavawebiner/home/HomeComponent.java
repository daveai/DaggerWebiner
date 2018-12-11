package com.qnet.rxjavawebiner.home;

import com.qnet.rxjavawebiner.MyAdapter;
import com.qnet.rxjavawebiner.di.ActivityScope;
import com.qnet.rxjavawebiner.root.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {MyAdapterModule.class}, dependencies = {AppComponent.class})
@ActivityScope
public interface HomeComponent {
    //MyAdapter getMyAdapter();
    void inject(HomeActivity target);
}
