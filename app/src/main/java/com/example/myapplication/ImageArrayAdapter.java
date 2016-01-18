package com.example.myapplication;

/**
 * Created by محمد on 18/01/2016.
 */
import java.util.List;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.cache.SimpleImageLoader;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.ui.NetworkImageView;


public class ImageArrayAdapter extends ArrayAdapter<ImageEntry> {
    private SimpleImageLoader mImageLoader;

    public ImageArrayAdapter(Context context, int textViewResourceId, List<ImageEntry> objects, SimpleImageLoader imageLoader) {
        super(context, textViewResourceId, objects);
        mImageLoader = imageLoader;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NetworkImageView image;
        TextView title;
        TextView date;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.news, null);
        }

        image = ViewHolder.get(convertView, R.id.img_thumbnail);
        title = ViewHolder.get(convertView, R.id.text_title);
        date=ViewHolder.get(convertView,R.id.text_date);

        ImageEntry entry = getItem(position);
        if (entry.getThumbnailUrl() != null) {
            image.setImageUrl(entry.getThumbnailUrl(), mImageLoader);
            image.setDefaultImageResId(R.drawable.ic_launcher);
        } else {
            image.setImageResource(R.drawable.ic_launcher);
        }

        title.setText(entry.getTitle());
        date.setText(entry.getDate());
        return convertView;
    }

    public static class ViewHolder {
        @SuppressWarnings("unchecked")
        public static <T extends View> T get(View view, int id) {
            SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
            if (viewHolder == null) {
                viewHolder = new SparseArray<View>();
                view.setTag(viewHolder);
            }
            View childView = viewHolder.get(id);
            if (childView == null) {
                childView = view.findViewById(id);
                viewHolder.put(id, childView);
            }
            return (T) childView;
        }
    }
}