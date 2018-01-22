package com.fandy.bitmapdemo.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * 公司:北京同道伟业体育科技有限公司
 * 作者：Shinelon
 * 时间:on 2018/1/22 09:31
 * 说明: bitmap的工机类
 */
public class BitmapUtil {

    /**
     * 等比压缩图片
     *
     * @param resources
     * @param resId
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampleBitmapFromResource(Resources resources, int resId, int reqWidth, int reqHeight) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        //计算等比压缩因子,等比压缩系数
        int inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);
    }

    /**
     * 计算等比压缩因子的方法
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     */
    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        /**
         * 解析出图片资源的宽高
         */
        int width = options.outWidth;
        int height = options.outHeight;
        //当计算出来的等比因子小于一的时候,默认也是按照一去处理
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {//图片的宽高大于指定的宽高,,则需进行缩放
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }


}
