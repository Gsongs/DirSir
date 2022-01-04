package com.bawei.framework.imgframenet;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public
/**
 *作者：王先生
 *时间：2021/12/9 09:54
 *用途：图片单例类
 */
class Image_packaging {
    private volatile static Image_packaging packaging;
    public static Image_packaging getInstance(){
        if (packaging==null){
            synchronized (Image_packaging.class){
                if (packaging==null){
                    packaging = new Image_packaging();
                }
            }
        }
        return packaging;
    }

    //正常图片
    public void PicNormal(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
    //本地图片
    public void Piclity(Context context, int url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
    //圆角图片
    public void PicCrop(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).circleCrop().into(imageView);
    }

}
