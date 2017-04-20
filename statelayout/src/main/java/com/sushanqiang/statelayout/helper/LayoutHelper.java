package com.sushanqiang.statelayout.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.sushanqiang.statelayout.R;
import com.sushanqiang.statelayout.StateLayout;
import com.sushanqiang.statelayout.bean.EmptyItem;
import com.sushanqiang.statelayout.bean.ErrorItem;
import com.sushanqiang.statelayout.bean.LoadingItem;
import com.sushanqiang.statelayout.bean.LoginItem;
import com.sushanqiang.statelayout.bean.NoNetworkItem;
import com.sushanqiang.statelayout.bean.TimeOutItem;
import com.sushanqiang.statelayout.holder.EmptyViewHolder;
import com.sushanqiang.statelayout.holder.ErrorViewHolder;
import com.sushanqiang.statelayout.holder.LoadingViewHolder;
import com.sushanqiang.statelayout.holder.LoginViewHolder;
import com.sushanqiang.statelayout.holder.NoNetworkViewHolder;
import com.sushanqiang.statelayout.holder.TimeOutViewHolder;


/**
 *     desc   : StateLayout帮助类
 */

public class LayoutHelper {

    /**
     * 解析布局中的可选参数
     *
     * @param context
     * @param attrs
     * @param stateLayout
     */
    public static void parseAttr(Context context, AttributeSet attrs, int defStyleAttr,StateLayout stateLayout) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StateLayout, defStyleAttr, 0);
        try {
            int errorImg = a.getResourceId(R.styleable.StateLayout_errorImg, -1);
            String errorText = a.getString(R.styleable.StateLayout_errorText);
            stateLayout.setErrorItem(new ErrorItem(errorImg, errorText));

            int timeOutImg = a.getResourceId(R.styleable.StateLayout_timeOutImg, -1);
            String timeOutText = a.getString(R.styleable.StateLayout_timeOutText);
            stateLayout.setTimeOutItem(new TimeOutItem(timeOutImg, timeOutText));

            int emptyImg = a.getResourceId(R.styleable.StateLayout_emptyImg, -1);
            String emptyText = a.getString(R.styleable.StateLayout_emptyText);
            stateLayout.setEmptyItem(new EmptyItem(emptyImg, emptyText));

            int noNetworkImg = a.getResourceId(R.styleable.StateLayout_noNetworkImg, -1);
            String noNetworkText = a.getString(R.styleable.StateLayout_noNetworkText);
            stateLayout.setNoNetworkItem(new NoNetworkItem(noNetworkImg, noNetworkText));

            int loginImg = a.getResourceId(R.styleable.StateLayout_loginImg, -1);
            String loginText = a.getString(R.styleable.StateLayout_loginText);
            stateLayout.setLoginItem(new LoginItem(loginImg, loginText));

            String loadingText = a.getString(R.styleable.StateLayout_loadingText);
            stateLayout.setLoadingItem(new LoadingItem(loadingText));
//            Log.e("parseAttr ",errorText+timeOutText+emptyText+noNetworkText+loginText+loadingText);
        }catch (Exception e){
            Log.e("parseAttr异常",e.toString());
        }finally {
            a.recycle();
        }
    }

    /**
     * 获取初始的错误View
     *
//     * @param layoutInflater 布局填充器
     * @param item           错误bean
     * @param layout         容器
     * @return 错误View
     */
    public static View getErrorView(LayoutInflater layoutInflater, ErrorItem item,
                                    final StateLayout layout) {
        View view = layoutInflater.inflate(R.layout.layout_error, null);

//        View view = View.inflate(context,R.layout.layout_error, null);
        if (item != null) {
//            tvTip= (TextView) view.findViewById(R.id.tv_message);
            ErrorViewHolder holder = new ErrorViewHolder(view);
            view.setTag(holder);
//            Log.e("view-----getErrorView",view.toString());
            if (!TextUtils.isEmpty(item.getTip())&&holder.tvTip!=null) {
                holder.tvTip.setText(item.getTip());
//                Log.e("view-----getErrorView",holder.tvTip.toString());
            }
            if (item.getResId() != -1&&holder.ivImg!=null) {
                holder.ivImg.setImageResource(item.getResId());
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (layout.getRefreshLListener() != null) {
                        layout.getRefreshLListener().refreshClick();
                    }
                }
            });
        }
        return view;
    }

    /**
     * 获取初始的没有网络View
     *
     * @param layoutInflater 布局填充器
     * @param item           没有网络bean
     * @param layout         容器
     * @return 没有网络View
     */
    public static View getNoNetworkView(LayoutInflater layoutInflater, NoNetworkItem item,
                                        final StateLayout layout) {
        View view = layoutInflater.inflate(R.layout.layout_no_network, null);
        if (item != null) {
            NoNetworkViewHolder holder = new NoNetworkViewHolder(view);
            view.setTag(holder);

            if (!TextUtils.isEmpty(item.getTip())&&holder.tvTip!=null) {
                holder.tvTip.setText(item.getTip());
            }
            if (item.getResId() != -1&&holder.ivImg!=null) {
                holder.ivImg.setImageResource(item.getResId());
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (layout.getRefreshLListener() != null) {
                        layout.getRefreshLListener().refreshClick();
                    }
                }
            });
        }
        return view;
    }

    /**
     * 获取初始的加载View
     *
     * @param layoutInflater 布局填充器
     * @param item           加载bean
     * @return 加载View
     */
    public static View getLoadingView(LayoutInflater layoutInflater, LoadingItem item) {
        View view = layoutInflater.inflate(R.layout.layout_loading, null);
        if (item != null) {
            LoadingViewHolder holder = new LoadingViewHolder(view);
            view.setTag(holder);
            ImageView imageView =new ImageView(view.getContext());
            imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.frame_loading));
            ((AnimationDrawable) imageView.getDrawable()).start();
//
//            ProgressBar progressBar = new ProgressBar(view.getContext());
//            progressBar.setIndeterminateDrawable(view.getResources().getDrawable(R.drawable.bg_loading));
            if (holder.frameLayout!=null)
            holder.frameLayout.addView(imageView);
            if (!TextUtils.isEmpty(item.getTip())&& holder.tvTip!=null) {
                holder.tvTip.setText(item.getTip());
            }
        }
        return view;
    }

    /**
     * 获取初始的超时View
     *
     * @param layoutInflater 布局填充器
     * @param item           超时bean
     * @param layout         容器
     * @return 超时View
     */
    public static View getTimeOutView(LayoutInflater layoutInflater, TimeOutItem item,
                                      final StateLayout layout) {
        View view = layoutInflater.inflate(R.layout.layout_time_out, null);
        if (item != null) {
            TimeOutViewHolder holder = new TimeOutViewHolder(view);
            view.setTag(holder);

            if (!TextUtils.isEmpty(item.getTip())&& holder.tvTip!=null) {
                holder.tvTip.setText(item.getTip());
            }
            if (item.getResId() != -1&& holder.ivImg!=null) {
                holder.ivImg.setImageResource(item.getResId());
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (layout.getRefreshLListener() != null) {
                        layout.getRefreshLListener().refreshClick();
                    }
                }
            });
        }
        return view;
    }

    /**
     * 获取初始的空数据View
     *
     * @param layoutInflater 布局填充器
     * @param item           空数据bean
     * @return 空数据View
     */
    public static View getEmptyView(LayoutInflater layoutInflater, EmptyItem item ,final StateLayout layout) {
        View view = layoutInflater.inflate(R.layout.layout_empty, null);
        if (item != null) {
            EmptyViewHolder holder = new EmptyViewHolder(view);
            view.setTag(holder);
            if (!TextUtils.isEmpty(item.getTip())&& holder.tvTip!=null) {
                holder.tvTip.setText(item.getTip());
            }
            if (item.getResId() != -1&& holder.ivImg!=null) {
                holder.ivImg.setImageResource(item.getResId());
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (layout.getRefreshLListener() != null) {
                        layout.getRefreshLListener().refreshClick();
                    }
                }
            });
        }
        return view;
    }


    /**
     * 获取初始的空数据View
     *
     * @param layoutInflater 布局填充器
     * @param item           空数据bean
     * @return 空数据View
     */
    public static View getLoginView(LayoutInflater layoutInflater, LoginItem item,
                                    final StateLayout layout) {
        View view = layoutInflater.inflate(R.layout.layout_login, null);
        if (item != null) {
            LoginViewHolder holder = new LoginViewHolder(view);
            view.setTag(holder);

            if (!TextUtils.isEmpty(item.getTip())&& holder.tvTip!=null) {
                holder.tvTip.setText(item.getTip());
            }
            if (item.getResId() != -1&& holder.ivImg!=null) {
                holder.ivImg.setImageResource(item.getResId());
            }
            view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (layout.getRefreshLListener() != null) {
                        layout.getRefreshLListener().loginClick();
                    }
                }
            });
        }
        return view;
    }

}
