package com.anshunfeng.commom.base.AnimationUtils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Danny on 2016/8/16.
 * 用于下拉列表的动画
 */
public class DownAnimation {

    private TranslateAnimation upAnimation;
    private TranslateAnimation downAnimation;
    private View endView;//收起动画结束时需要隐藏的View
    public DownAnimation(){
        if(upAnimation == null){
            upAnimation= new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1);
            upAnimation.setDuration(300);
            upAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    endView.setVisibility(View.GONE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
                    endView.setLayoutParams(params);
                }
            });
        }
        if(downAnimation == null){
            downAnimation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_SELF, -1,
                    Animation.RELATIVE_TO_SELF, 0);
            downAnimation.setDuration(300);
        }
    }
    private View view;
    
    // 收起联动菜单
    public void hideLinkMenu(View view, final View endView) {
        // 为联动菜单设置收起动画
        this.endView = endView;
        view.startAnimation(upAnimation);
    }
    /**
     * 展开类型查找的联动菜单
     */
    public void unfoldSortType(View view){
        // 为联动菜单设置展开动画
        view.startAnimation(downAnimation);
    }
}
