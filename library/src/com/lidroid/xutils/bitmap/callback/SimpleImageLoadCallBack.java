/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lidroid.xutils.bitmap.callback;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;

import java.lang.reflect.Method;

public class SimpleImageLoadCallBack implements ImageLoadCallBack {

    @Override
    public void onLoadStarted(String uri, ImageView imageView, BitmapDisplayConfig config) {
    }

    @Override
    public void onLoadCompleted(String url, ImageView imageView, Drawable drawable, BitmapDisplayConfig config, ImageLoadFrom from) {
        Animation animation = config.getAnimation();
        if (animation == null) {
            fadeInDisplay(imageView, drawable);
        } else {
            animationDisplay(imageView, drawable, animation);
        }
    }

    @Override
    public void onLoadFailed(String url, ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    private static final ColorDrawable transparentDrawable = new ColorDrawable(android.R.color.transparent);

    private void fadeInDisplay(ImageView imageView, Drawable drawable) {
        final TransitionDrawable td =
                new TransitionDrawable(new Drawable[]{
                        transparentDrawable,
                        drawable
                });
        imageView.setImageDrawable(td);
        td.startTransition(300);
    }

    private void animationDisplay(ImageView imageView, Drawable drawable, Animation animation) {
        imageView.setImageDrawable(drawable);
        try {
            Method cloneMethod = Animation.class.getDeclaredMethod("clone");
            cloneMethod.setAccessible(true);
            imageView.startAnimation((Animation) cloneMethod.invoke(animation));
        } catch (Throwable e) {
            imageView.startAnimation(animation);
        }
    }
}
