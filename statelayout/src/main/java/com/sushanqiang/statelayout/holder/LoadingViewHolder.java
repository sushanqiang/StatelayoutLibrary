package com.sushanqiang.statelayout.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sushanqiang.statelayout.R;


public class LoadingViewHolder extends BaseHolder {
    public FrameLayout frameLayout;
    public LoadingViewHolder(View view) {
        tvTip = (TextView) view.findViewById(R.id.tv_message);
        frameLayout = (FrameLayout) view.findViewById(R.id.loading_layout);
    }
}
