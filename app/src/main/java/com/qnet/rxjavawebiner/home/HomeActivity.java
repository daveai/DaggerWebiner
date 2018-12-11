package com.qnet.rxjavawebiner.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qnet.rxjavawebiner.MyAdapter;
import com.qnet.rxjavawebiner.R;
import com.qnet.rxjavawebiner.githubapi.GitHubAPI;
import com.qnet.rxjavawebiner.githubapi.GitHubAPIService;
import com.qnet.rxjavawebiner.models.GitHubRepoModel;
import com.qnet.rxjavawebiner.root.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Inject
    MyAdapter myAdapter;
    List<String> repos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.repoListRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        repos = new ArrayList<>();

        HomeComponent homeComponent = DaggerHomeComponent.builder()
                .myAdapterModule(new MyAdapterModule(repos))
                .appComponent(((App) getApplication()).getAppComponent())
                .build();
        homeComponent.inject(this);


        recyclerView.setAdapter(myAdapter);

        App  app = (App)getApplication();

        GitHubAPIService gitHubAPIService = app.getGitHubService();

        GitHubAPIService gitHubAPIService1 = app.getGitHubService();
        GitHubAPIService gitHubAPIService2 = app.getGitHubService();
        GitHubAPIService gitHubAPIService3 = app.getGitHubService();

        System.out.println("The git hub service 1 has " + gitHubAPIService1);
        System.out.println("The git hub service 2 has " + gitHubAPIService2);
        System.out.println("The git hub service 3 has " + gitHubAPIService3);


        gitHubAPIService.getRepoFromRemote().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitHubRepoModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<GitHubRepoModel> gitHubRepoModels) {
                        for (GitHubRepoModel repo: gitHubRepoModels) {
                            System.out.println(repo.getName());
                            repos.add(repo.getName());
                            myAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
