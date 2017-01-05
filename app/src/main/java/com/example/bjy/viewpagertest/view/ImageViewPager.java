package com.example.bjy.viewpagertest.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by bjy on 2017/1/5.
 */

public class ImageViewPager extends ViewPager {
    private onTouchListener999 listener999;
    public ImageViewPager(Context context) {
        super(context);
    }

    public ImageViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                listener999.stop();
                break;
            case MotionEvent.ACTION_UP:
                listener999.run();
                break;
        }
        return super.onTouchEvent(event);
    }

    public interface onTouchListener999{
        void stop();
        void run();
    }

    public void setListener999(onTouchListener999 listener999) {
        this.listener999 = listener999;
    }
}
