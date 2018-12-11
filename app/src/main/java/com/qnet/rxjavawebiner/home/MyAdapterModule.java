package com.qnet.rxjavawebiner.home;

import com.qnet.rxjavawebiner.MyAdapter;
import com.qnet.rxjavawebiner.di.ActivityScope;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class MyAdapterModule {
    List<String> dataset;

    public MyAdapterModule(List<String> dataset) {
        this.dataset = dataset;
    }

    @Provides
    @ActivityScope
    MyAdapter provideMyAdapter(){
        return new MyAdapter(dataset);
    }
}
