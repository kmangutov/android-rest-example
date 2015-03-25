package com.kmangutov.restexample.presenters;

import com.kmangutov.restexample.models.Post;
import com.kmangutov.restexample.services.ForumService;
import com.kmangutov.restexample.views.ListActivity;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kmangutov on 3/25/15.
 */
public class ListPresenter {

    ListActivity mView;
    ForumService mForum;

    public ListPresenter(ListActivity view, ForumService forum) {

        mView = view;
        mForum = forum;
    }

    public void loadPosts() {

        mForum.getApi()
                .getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Post> posts) {

                        mView.displayPosts(posts);
                    }
                });
    }
}
