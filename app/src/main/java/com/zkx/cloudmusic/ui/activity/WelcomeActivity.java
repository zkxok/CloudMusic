package com.zkx.cloudmusic.ui.activity;

import android.os.Handler;
import android.view.WindowManager;

import com.zkx.cloudmusic.R;

/**
 * Created by zhangkexin9 on 2018/1/4.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    public int getContentViewResId() {
        return R.layout.activity_welcome_layout;
    }

    @Override
    public void initView() {
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        //秒开
        setTheme(R.style.AppTheme);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //延迟调转到主界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startToActivity(MainActivity.class);
                finish();
            }
        },2000);
    }
}
