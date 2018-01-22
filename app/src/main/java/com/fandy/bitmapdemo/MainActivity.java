package com.fandy.bitmapdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import com.fandy.bitmapdemo.adapter.ImageAdapter;
import com.fandy.bitmapdemo.customer.ImageLoader;
import com.fandy.bitmapdemo.utils.Images;

import java.util.Arrays;
import java.util.List;

/**
 * @Company 北京同道伟业体育科技有限公司
 * @date 创建时间:2018/1/22
 * @user
 * @Description Bitmap的高效加载方略学习
 */
public class MainActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*    mImageView = (ImageView) findViewById(R.id.iv);
        Bitmap bitmap = BitmapUtil.decodeSampleBitmapFromResource(getResources(),
                R.mipmap.ic_launcher, DensityUtils.dip2px(this, 100), DensityUtils.dip2px(this, 100));
        mImageView.setImageBitmap(bitmap);*/

        GridView gridView = (GridView) findViewById(R.id.gridView);
        String[] imageUrls = Images.imageUrls;
        List<String> urls = Arrays.asList(imageUrls);
        ImageAdapter adapter = new ImageAdapter(this, urls, new ImageLoader(this));
        gridView.setAdapter(adapter);
    }
}
