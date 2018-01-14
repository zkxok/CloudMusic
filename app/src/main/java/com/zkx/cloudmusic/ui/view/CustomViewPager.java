package com.zkx.cloudmusic.ui.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomViewPager extends ViewPager {


    public CustomViewPager(Context context) {
        this(context,null);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    PointF mPointF = new PointF();
    OnSingleTouchListener mOnSingleTouchListener;
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                //获取按下的坐标
                mPointF.x = ev.getX();
                mPointF.y = ev.getY();
                if(this.getChildCount()>1){
                    //通知父控件不进行拦截点击事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(this.getChildCount()>1){
                    //通知父控件不进行拦截点击事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                if(PointF.length(ev.getX()-mPointF.x,ev.getY()-mPointF.y)<5.0f){//是一个点击事件，不算移动
                    //单纯的点击
                    onSingleTouch(this);
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void onSingleTouch(View view) {
        if(mOnSingleTouchListener!=null){
            mOnSingleTouchListener.onSingleTouch();
        }
    }


    public interface OnSingleTouchListener{
        void onSingleTouch();
    }

    public void setOnSingleTouchListener(OnSingleTouchListener onSingleTouchListener){
        mOnSingleTouchListener = onSingleTouchListener;
    }
}