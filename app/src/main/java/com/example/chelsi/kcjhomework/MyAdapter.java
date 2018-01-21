package com.example.chelsi.kcjhomework;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by joannesong on 1/20/18.
 */

public class MyAdapter extends PagerAdapter {
    List<String> firstImages;
    Context context;
    LayoutInflater layoutInflater;

    public MyAdapter(List<String> firstImages, Context context) {
        this.firstImages = firstImages;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return firstImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.card_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.with(context).load(firstImages.get(position)).into(imageView);
        //imageView.setImageResource(firstImages.get(position));
        container.addView(view);
        return view;
    }
}
