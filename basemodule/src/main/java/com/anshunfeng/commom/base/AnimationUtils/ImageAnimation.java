package com.anshunfeng.commom.base.AnimationUtils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.anshunfeng.young.basemodule.R;

/**
 * Created by yhx-chen on 2017/4/14.
 */
public class ImageAnimation {
    private Animation rotateAnim;//旋转动画
    private static ImageAnimation instance;
    public static ImageAnimation getInstance(){
        if(instance == null){
            instance = new ImageAnimation();
        }
        return instance;
    }

    public void startRotateAnim(Context context, View animView){
        if(animView != null) {
            if(rotateAnim == null) {
//                rotateAnim = AnimationUtils.loadAnimation(context, R.anim.rotate_offsety_animation);
                rotateAnim.setDuration(1000);
                LinearInterpolator lin = new LinearInterpolator();
                rotateAnim.setInterpolator(lin);
            }
            animView.startAnimation(rotateAnim);
        }
    }

    public void stopAnimation(View animView){
        if(rotateAnim != null && animView != null){
            animView.clearAnimation();
//            rotateAnim = null;
        }
    }
}
