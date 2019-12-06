package com.lisn.transformerslayout.holder;

import android.view.View;

/**
 * Author: LiShan
 * Time: 2019-12-06
 * Description:
 */
public interface TransformersHolderCreator<T> {
    Holder<T> createHolder(View itemView);
    int getLayoutId();
}
