package com.sushanqiang.statelayoutlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sushanqiang.statelayout.StateLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    StateLayout stateLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateLayout = (StateLayout) this.findViewById(R.id.state_layout);
        //        stateLayout.setUseAnimation(true);
////        stateLayout.setViewSwitchAnimProvider(new FadeScaleViewAnimProvider());
//        stateLayout.setRefreshListener(new StateLayout.OnViewRefreshListener() {
//            @Override
//            public void refreshClick() {
//                Toast.makeText(TestActivity.this, "刷新", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void loginClick() {
//                Toast.makeText(TestActivity.this, "登录", Toast.LENGTH_SHORT).show();
//            }
//        });
        stateLayout.setUseAnimation(true);
        stateLayout.showTimeoutView();
//        stateLayout.setViewSwitchAnimProvider(new FadeScaleViewAnimProvider());
        stateLayout.setRefreshListener(new StateLayout.OnViewRefreshListener() {
            @Override
            public void refreshClick() {
                stateLayout.showLoadingView();
                Toast.makeText( MainActivity.this, "刷新", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void loginClick() {
                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_content).setOnClickListener(this);
        findViewById(R.id.btn_empty).setOnClickListener(this);
        findViewById(R.id.btn_error).setOnClickListener(this);
        findViewById(R.id.btn_loading).setOnClickListener(this);
        findViewById(R.id.btn_time_out).setOnClickListener(this);
        findViewById(R.id.btn_not_network).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_custom).setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_content:
                stateLayout.showContentView();
//                stateLayout.setTipText(StateLayout.EMPTY, "12345");
//                stateLayout.setTipImg(StateLayout.EMPTY, R.mipmap.ic_launcher);
                break;
            case R.id.btn_empty:
                stateLayout.showEmptyView();
//                stateLayout.setTipText(StateLayout.ERROR, "12345");
//                stateLayout.setTipImg(StateLayout.ERROR, R.mipmap.ic_launcher);
                break;
            case R.id.btn_error:
                stateLayout.showErrorView();
                stateLayout.setTipText(StateLayout.ERROR,"请稍后再试哦");
                stateLayout.setTipImg(StateLayout.ERROR, R.mipmap.ic_launcher);
//                stateLayout.setTipText(StateLayout.LOADING, "12345");
                break;
            case R.id.btn_loading:
                stateLayout.showLoadingView();
//                stateLayout.setTipText(StateLayout.TIMEOUT, "12345");
//                stateLayout.setTipImg(StateLayout.TIMEOUT, R.mipmap.ic_launcher);
                break;
            case R.id.btn_time_out:
                stateLayout.showTimeoutView();
//                stateLayout.setTipText(StateLayout.NOT_NETWORK, "12345");
//                stateLayout.setTipImg(StateLayout.NOT_NETWORK, R.mipmap.ic_launcher);
                break;
            case R.id.btn_not_network:
                stateLayout.showNoNetworkView();
                break;
            case R.id.btn_login:
                stateLayout.showLoginView();
                break;

        }
    }
}
