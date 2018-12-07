package com.sprylab.android.widget;


import java.io.IOException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;


/**
 * Created by LiuYi on 2018/12/6.
 */
@SuppressLint("NewApi")
public class CameraPreview extends TextureView implements
        TextureView.SurfaceTextureListener {
    private Camera mCamera;
    private TextureView mTextureView;
    public CameraPreview(Context context , Camera camera) {
        super(context);
        mCamera = camera;
        // TODO Auto-generated constructor stub
    }

    //surface 创建成功时候调用 SurfaceTexture可以看做Surface和Texture的组合，是真正渲染的载体。
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width,
                                          int height) {
//        mCamera = Camera.open();
        try {
            mCamera.setPreviewTexture(surface);
            mCamera.startPreview();
        } catch (IOException ioe) {
            // Something bad happened
        }
    }

    //surface 大小发生变化时调用
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width,
                                            int height) {
        // Ignored, Camera does all the work for us
    }

    //surface 被销毁时候调用
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    //surface 更新
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        // Invoked every time there's a new Camera preview frame
    }

}