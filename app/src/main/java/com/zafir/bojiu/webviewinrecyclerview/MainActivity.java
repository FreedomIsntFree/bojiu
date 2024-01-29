package com.zafir.bojiu.webviewinrecyclerview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zafir.bojiu.R;
import com.zafir.bojiu.webviewinrecyclerview.slideconflict.SlideConfictActivity;
import com.zafir.bojiu.webviewinrecyclerview.wrapcontent.WrapContentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                try {
                    startActivity(new Intent(this, WrapContentActivity.class));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button2:
                try {
                    startActivity(new Intent(this, SlideConfictActivity.class));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
