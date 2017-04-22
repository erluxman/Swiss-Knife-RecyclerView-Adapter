package com.gurkhatech.mvppatterntest.githubUsersList.models;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubUsersList.viewholders.GitHubUserListViewHolder;
import com.gurkhatech.mvppatterntest.utils.lib.OmniAdapter;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubUserDataCopy implements OmniAdapter.IOmniModel {

    @LayoutRes
    private int layoutRes = 0;
    private Class viewHolderClass;
    private int mDefaultLayoutRes;
    private Class mDefaultViewHolder;
    @SerializedName("login")
    private String userName;
    @SerializedName("name")
    private String FullName;
    @SerializedName("html_url")
    private String profileUrl;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("email")
    private String email;
    @SerializedName("repos_url")
    private String repoUrl;

    public GithubUserDataCopy(String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return FullName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public int getLayout() {
        return layoutRes == 0 ? getDefaultLayout() : layoutRes;
    }

    public Class getViewHolder() {
        return viewHolderClass == null ? getDefaultViewHolder() : viewHolderClass;
    }

    @Override
    public void resetToDefault() {
        this.layoutRes = getDefaultLayout();
        this.viewHolderClass = getDefaultViewHolder();
    }

    @Override
    @LayoutRes
    public int getDefaultLayout() {
        return getUserName().length() > 10 ? R.layout.item_github_use_list : R.layout.item_github_use_list_alter;
    }

    @Override
    public Class getDefaultViewHolder() {
        return getUserName().length() > 10 ? GitHubUserListViewHolder.class : GitHubUserListViewHolder.class;
    }

    public void setLayoutRes(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public void setViewHolderClass(Class viewHolderClass) {
        this.viewHolderClass = viewHolderClass;
    }
}
