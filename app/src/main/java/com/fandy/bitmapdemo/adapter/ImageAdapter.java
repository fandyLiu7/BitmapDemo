package com.fandy.bitmapdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fandy.bitmapdemo.R;
import com.fandy.bitmapdemo.customer.ImageLoader;
import com.fandy.bitmapdemo.view.SquareImageView;

import java.util.List;

/**
 * 公司:北京同道伟业体育科技有限公司
 * 作者：Shinelon
 * 时间:on 2018/1/22 15:41
 * 说明:
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private List<String> mUrLst;
    private LayoutInflater mInflater;
    private ImageLoader imageLoader;

    public ImageAdapter(Context context, List<String> mUrLst, ImageLoader imageLoader) {
        this.context = context;
        this.mUrLst = mUrLst;
        mInflater = LayoutInflater.from(context);
        this.imageLoader = imageLoader;
    }

    @Override
    public int getCount() {
        return mUrLst.size();
    }

    @Override
    public String getItem(int position) {
        return mUrLst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_image, parent, false);
            holder = new ViewHolder();
            holder.mImageView = (SquareImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SquareImageView imageView = holder.mImageView;
        String tag = (String) imageView.getTag();
        String url = getItem(position);
        if (!url.equals(tag)) {

        }
        imageView.setTag(url);
        imageLoader.bindBitmap(url, imageView, 100, 100);
        return convertView;
    }

    static class ViewHolder {
        public SquareImageView mImageView;
    }
}
