package com.gurkhatech.mvppatterntest.githubList.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class GithubUserListDTO {

@NonNull
@SerializedName("items")
private List < GithubUserDTO > list = new ArrayList <> ();

@NonNull
List < GithubUserDTO > getList ( ) {
    return this.list;
}
}