package com.bawei.library_framework.imgframenet

import android.content.Context
import android.widget.ImageView
import com.bawei.library_framework.framenet.FrameNet
import com.bumptech.glide.Glide

/**
 *作者：王先生
 *时间：2021/12/10 19:05
 *用途：图片单例封装
 */
class ImagesPackaging() {

    @Volatile
    private var imagesPackaging: ImagesPackaging? = null

    fun getInstance(): ImagesPackaging? {
        if (imagesPackaging == null) {
            synchronized(FrameNet::class.java) {
                if (imagesPackaging == null) {
                    imagesPackaging = ImagesPackaging()
                }
            }
        }
        return imagesPackaging
    }
    //正常网络加载图片
    fun PicNormal(context: Context?, url: String?, imageView: ImageView?) {
        Glide.with(context!!).load(url).into(imageView!!)
    }

    //本地图片
    fun Piclity(context: Context?, url: Int, imageView: ImageView?) {
        Glide.with(context!!).load(url).into(imageView!!)
    }

    //圆角图片
    fun PicCrop(context: Context?, url: Int?, imageView: ImageView?) {
        Glide.with(context!!).load(url).circleCrop().into(imageView!!)
    }




}