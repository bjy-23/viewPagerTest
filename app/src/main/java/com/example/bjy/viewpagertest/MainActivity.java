package com.example.bjy.viewpagertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bjy.viewpagertest.activity.ImagesActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = (TextView) findViewById(R.id.tv_hello);
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action1();
            }
        });
    }

    public void action1(){
        startActivity(new Intent(this, ImagesActivity.class));
    }
}
