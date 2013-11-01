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

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;

public interface ImageLoadCallBack {

    /**
     * Call back when start loading.
     *
     * @param uri
     * @param config
     */
    void onLoadStarted(String uri, ImageView imageView, BitmapDisplayConfig config);

    /**
     * Call back when bitmap has loaded.
     *
     * @param url
     * @param imageView
     * @param drawable
     * @param config
     */
    void onLoadCompleted(String url, ImageView imageView, Drawable drawable, BitmapDisplayConfig config, ImageLoadFrom from);

    /**
     * Call back when bitmap failed to load.
     *
     * @param url
     * @param imageView
     * @param drawable
     */
    void onLoadFailed(String url, ImageView imageView, Drawable drawable);

}
