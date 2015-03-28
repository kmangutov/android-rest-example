package com.kmangutov.restexample.presenters;

import com.kmangutov.restexample.models.Comment;
import com.kmangutov.restexample.models.Post;
import com.kmangutov.restexample.services.ForumService;
import com.kmangutov.restexample.views.DetailActivity;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by kmangutov on 3/26/15.
 */
public class DetailPresenter {

    DetailActivity mView;
    ForumService mForum;

    public DetailPresenter(DetailActivity activity, ForumService forum) {

        mView = activity;
        mForum = forum;
    }

    public void loadPost() {

        mForum.getApi()
                .getPost(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Post post) {

                        mView.displayPost(post);
                    }
                });
    }

    public void loadComments() {

        mForum.getApi()
                .getComments(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Comment>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Comment> comments) {

                        mView.displayComments(comments);
                    }
                });
    }
}
