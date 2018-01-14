package com.zkx.cloudmusic.ui.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zkx.cloudmusic.R;
import com.zkx.cloudmusic.utils.StatusBarCompat;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //默认竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //设置默认状态栏主题颜色
        StatusBarCompat.compat(this, getResources().getColor(R.color.theme_color_primary));
        initView();
        setContentView(getContentViewResId());
    }

    public abstract int getContentViewResId();


    public abstract void initView();
    /**
     * 显示SnackBar
     * @param view
     * @param text
     */
    public void showSnackBar(View view,@NonNull String text){
        Snackbar.make(view,text,Snackbar.LENGTH_SHORT).show();
    }

    public void showSnackBar(View view,int resId){
        Snackbar.make(view,resId,Snackbar.LENGTH_SHORT).show();
    }


    public void startToActivity(Class activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }


}
