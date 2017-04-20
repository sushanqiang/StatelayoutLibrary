package com.sushanqiang.statelayout.anim;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/**
 *     desc   : 渐隐动画
 *     version: 1.0
 */

public class FadeViewAnimProvider implements ViewAnimProvider {

    @Override
    public Animation showAnimation() {
        Animation animation = new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(200);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    @Override
    public Animation hideAnimation() {
        Animation animation = new AlphaAnimation(1.0f,0.0f);
        animation.setDuration(200);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        return animation;
    }

}
