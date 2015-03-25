package com.kmangutov.restexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kmangutov.restexample.R;
import com.kmangutov.restexample.models.Post;

import java.util.ArrayList;

/**
 * Created by kmangutov on 3/25/15.
 */
public class PostsAdapter extends ArrayAdapter<Post> {

    public PostsAdapter(Context ctx, ArrayList<Post> posts) {

        super(ctx, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Post post = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_post_item, parent, false);

        TextView title = (TextView) convertView.findViewById(R.id.textViewItemTitle);
        title.setText(post.title);

        return convertView;
    }
}
