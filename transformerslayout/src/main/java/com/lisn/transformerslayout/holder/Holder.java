package com.lisn.transformerslayout.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author: LiShan 
 * Time: 2019-12-06  
 * Description: 
 */
public abstract class Holder<T> extends RecyclerView.ViewHolder {
    public Holder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    protected abstract void initView(View itemView);

    public abstract void bindData(Context context, T data);
}
