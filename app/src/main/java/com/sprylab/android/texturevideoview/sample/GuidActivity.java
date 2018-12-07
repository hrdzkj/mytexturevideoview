package com.sprylab.android.texturevideoview.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sprylab.android.sample.texturevideoview.R;

/**
 * Created by LiuYi on 2018/12/6.
 */
public class GuidActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guid);
        findViewById(R.id.toCameraTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuidActivity.this,CameraTestActivity.class));
            }
        });

        findViewById(R.id.toVideoView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuidActivity.this,TextureVideoViewActivity.class));
            }
        });
    }
}
