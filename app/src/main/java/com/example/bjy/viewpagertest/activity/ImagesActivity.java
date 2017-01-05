package com.example.bjy.viewpagertest.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bjy.viewpagertest.R;
import com.example.bjy.viewpagertest.adapter.ImagesAdapter;
import com.example.bjy.viewpagertest.view.ImageViewPager;

import java.util.ArrayList;

/**
 * Created by bjy on 2017/1/5.
 */

public class ImagesActivity extends AppCompatActivity implements ImageViewPager.onTouchListener999{
    private ImageViewPager vpImages;
    private ArrayList<View> images;
    private ImagesAdapter imagesAdapter;
    private int[] imageIds = {R.drawable.f22,R.drawable.f35,R.drawable.su35,R.drawable.su27};
    private String[] texts = {"F-22","F-35","SU-35","SU-27"};
    private Handler handler;
    private Runnable runnable;
    private int timeCount = 5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        handler = new Handler();
        images = new ArrayList<>();
        for (int i=0;i<4;i++){
            View view  = View.inflate(this,R.layout.image1,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.img);
            TextView tv = (TextView) view.findViewById(R.id.tv);
//            final TextView tvTime = (TextView) view.findViewById(R.id.tv_time);
//            tvTime.setText(5+"");
//            Runnable timeRunnable = new Runnable() {
//                @Override
//                public void run() {
//                    timeCount--;
//                    tvTime.setText(timeCount+"");
//                }
//            };
//            tvTime.postDelayed(timeRunnable,1000);
            imageView.setBackgroundResource(imageIds[i]);
            tv.setText(texts[i]);
            images.add(view);
        }
        imagesAdapter = new ImagesAdapter(images);

        vpImages = (ImageViewPager) findViewById(R.id.vp_imgs);
        vpImages.setOffscreenPageLimit(4);
        vpImages.setListener999(this);
        vpImages.setAdapter(imagesAdapter);

        vpImages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                vpImages.getChildAt(position);
//                final TextView tvTime = (TextView) vpImages.getChildAt(position).findViewById(R.id.tv_time);
//                timeCount = 5;
//                tvTime.setText(timeCount+"");
//                Runnable timeRunnable = new Runnable() {
//                    @Override
//                    public void run() {
//                        timeCount--;
//                        tvTime.setText(timeCount+"");
//                        tvTime.postDelayed(this,1000);
//                    }
//                };
//                tvTime.postDelayed(timeRunnable,1000);
            }

            @Override
            public void onPageSelected(int position) {
//                final TextView tvTime = (TextView) images.get(position).findViewById(R.id.tv_time);
                final TextView tvTime = (TextView) vpImages.getChildAt(position).findViewById(R.id.tv_time);
                timeCount = 5;
                tvTime.setText(timeCount+"");
                Runnable timeRunnable = new Runnable() {
                    @Override
                    public void run() {
                        timeCount--;
                        tvTime.setText(timeCount+"");
                        tvTime.postDelayed(this,1000);
                        if (timeCount==1)
                            tvTime.removeCallbacks(this);
                    }
                };
                tvTime.postDelayed(timeRunnable,1000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        runnable = new Runnable() {
            @Override
            public void run() {
                if (vpImages.getCurrentItem()<3)
                    vpImages.setCurrentItem(vpImages.getCurrentItem()+1);
                else
                    vpImages.setCurrentItem(0);
                handler.postDelayed(this,5000);
            }
        };
        handler.postDelayed(runnable,5000);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (vpImages.getCurrentItem()<3)
//                    vpImages.setCurrentItem(vpImages.getCurrentItem()+1);
//                else
//                    vpImages.setCurrentItem(0);
//                handler.postDelayed(this,5000);
//            }
//        }, 5000);
    }

    @Override
    public void stop() {
        handler.removeCallbacks(runnable);
    }

    @Override
    public void run() {
        handler.postDelayed(runnable,5000);
    }
}
