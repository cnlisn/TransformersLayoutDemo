package com.lisn.transformerslayout;

import androidx.annotation.ColorInt;
import androidx.annotation.Px;

/**
 * Author: LiShan 
 * Time: 2019-12-06  
 * Description: 
 */
public class TransformersOptions {
    public final int spanCount;
    public final int lines;
    public final int scrollBarWidth;
    public final int scrollBarHeight;
    public final int scrollBarTopMargin;
    public final int scrollBarTrackColor;
    public final int scrollBarThumbColor;
    public final float scrollBarRadius;

    private TransformersOptions(Builder builder) {
        spanCount = builder.spanCount;
        lines = builder.lines;
        scrollBarWidth = builder.scrollBarWidth;
        scrollBarHeight = builder.scrollBarHeight;
        scrollBarTopMargin = builder.scrollBarTopMargin;
        scrollBarTrackColor = builder.scrollBarTrackColor;
        scrollBarThumbColor = builder.scrollBarThumbColor;
        scrollBarRadius = builder.scrollBarRadius;
    }

    public static class Builder{
        private int spanCount;
        private int lines;
        private int scrollBarWidth;
        private int scrollBarHeight;
        private int scrollBarTopMargin;
        private int scrollBarTrackColor;
        private int scrollBarThumbColor;
        private float scrollBarRadius = -1;

        /**
         *
         * @param radius scrollbar圆角，默认高度的一半
         * @return
         */
        public Builder scrollBarRadius(@Px float radius) {
            this.scrollBarRadius = radius;
            return this;
        }

        /**
         *
         * @param color scrollbar轨道颜色色
         * @return
         */
        public Builder scrollBarTrackColor(@ColorInt int color) {
            this.scrollBarTrackColor = color;
            return this;
        }

        /**
         *
         * @param color scrollbar高亮颜色
         * @return
         */
        public Builder scrollBarThumbColor(@ColorInt int color) {
            this.scrollBarThumbColor = color;
            return this;
        }

        /**
         *
         * @param topMargin scrollbar上间距
         * @return
         */
        public Builder scrollBarTopMargin(@Px int topMargin){
            scrollBarTopMargin = topMargin;
            return this;
        }

        /**
         *
         * @param width scrollbar宽度，默认36dp
         * @return
         */
        public Builder scrollBarWidth(@Px int width) {
            this.scrollBarWidth = width;
            return this;
        }

        /**
         *
         * @param height scrollbar高度，默认3dp
         * @return
         */
        public Builder scrollBarHeight(@Px int height) {
            this.scrollBarHeight = height;
            return this;
        }

        /**
         *
         * @param spanCount 每页列数，默认5
         * @return
         */
        public Builder spanCount(int spanCount) {
            this.spanCount = spanCount;
            return this;
        }

        /**
         *
         * @param lines 每页行数默认2
         * @return
         */
        public Builder lines(int lines) {
            this.lines = lines;
            return this;
        }

        public TransformersOptions build(){
            return new TransformersOptions(this);
        }
    }
}
