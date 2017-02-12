package com.gurkhatech.mvppatterntest.githubList.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.model.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githubList.presenter.GithubListPresenter;
import com.gurkhatech.mvppatterntest.githubList.view.modules.DaggerGithubListActivityComponent;
import com.gurkhatech.mvppatterntest.githubList.view.modules.GithubListActivityComponent;
import com.gurkhatech.mvppatterntest.githubList.view.modules.GithubListActivityModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GithubListActivity extends AppCompatActivity implements IGithubListView {

@BindView(R.id.userInput)
EditText userInput;


@BindView(R.id.userList)
RecyclerView userList;

@Inject
GithubUserListAdapter githubUserListAdapter;
GithubListPresenter githubListPresenter = GithubListPresenter.getInstance ( this );

@Inject
LinearLayoutManager linearLayoutManager;
GithubListActivityComponent githubListActivityComponent;


@Override
protected void onCreate ( Bundle savedInstanceState ) {
    super.onCreate ( savedInstanceState );
    setContentView ( R.layout.activity_github_list );
    ButterKnife.bind ( this );

     DaggerGithubListActivityComponent.builder ()
            .githubListActivityModule ( new GithubListActivityModule ( this ) )
            .build ().inject ( this );
    initList ();

}

@Override
protected void onDestroy ( ) {
    super.onDestroy ();
    githubListPresenter.disconnect ();
}

@Override
public void setList ( List < GithubUserDTO > data ) {
    githubUserListAdapter.setData ( data );
}

@OnClick(R.id.search)
@Override
public void triggerSearch ( ) {
    githubListPresenter.searchUser ( userInput.getText ().toString () );
}

@Override
public void initList ( ) {
    // linearLayoutManager = githubListActivityComponent.linearLayoutManager ();
    //githubUserListAdapter = GithubUserListAdapter.getInstance ( Glide.with ( this ) );
    userList.setLayoutManager ( linearLayoutManager );
    userList.setAdapter ( githubUserListAdapter );

}
}
