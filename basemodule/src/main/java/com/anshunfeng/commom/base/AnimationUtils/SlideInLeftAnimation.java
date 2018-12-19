package com.anshunfeng.commom.base.AnimationUtils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by Administrator on 2016/4/25.
 */
public class SlideInLeftAnimation extends BaseAnimation {


    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[] {
                ObjectAnimator.ofFloat(view, "translationX", -view.getRootView().getWidth(), 0)
        };
    }
}
