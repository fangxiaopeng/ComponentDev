package com.fxp.module_common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.fxp.module_common.R;

/**
 * Title:       GlideUtil
 * <p>
 * Package:     com.fxp.module_common.utils
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/13 上午11:19
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/13    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class GlideUtil {

    public static void setCircleView(final Context context, String photoUrl, final ImageView targetView) {
        Glide.with(context).load(photoUrl).asBitmap().placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).centerCrop().diskCacheStrategy(DiskCacheStrategy.RESULT).
                into(new BitmapImageViewTarget(targetView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        targetView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    public static void setCircleView(final Context context, int photoUrl, final ImageView targetView) {
        Glide.with(context).load(photoUrl).asBitmap().placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).centerCrop().diskCacheStrategy(DiskCacheStrategy.RESULT).
                into(new BitmapImageViewTarget(targetView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        targetView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

}
