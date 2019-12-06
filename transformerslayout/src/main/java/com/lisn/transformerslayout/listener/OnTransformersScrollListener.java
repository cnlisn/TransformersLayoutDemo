package com.lisn.transformerslayout.listener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author: LiShan 
 * Time: 2019-12-06  
 * Description: 
 */
public interface OnTransformersScrollListener {
    void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState);

    void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy);
}
