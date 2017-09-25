package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public class OpenGlView extends GLSurfaceView {
    private static String TAG = "OpenGlView";
    public boolean qfx;
    public boolean rqb;
    public boolean rqc;
    public int rqd;
    WeakReference<OpenGlRender> rqe;

    public void do(int i, int i2) {
        setLayoutParams(new LayoutParams(i, i2));
    }

    public OpenGlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rqb = false;
        this.rqc = true;
        this.qfx = false;
        this.rqd = 1;
        this.rqd = OpenGlRender.brx();
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        if (this.rqd == 2) {
            setEGLContextFactory(new c());
            setEGLConfigChooser(new b());
        }
    }

    public final void a(OpenGlRender openGlRender) {
        this.rqe = new WeakReference(openGlRender);
        super.setRenderer(openGlRender);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        w.i(TAG, "surfaceCreated");
        super.surfaceCreated(surfaceHolder);
        OpenGlRender openGlRender = (OpenGlRender) this.rqe.get();
        w.i(OpenGlRender.TAG, "surfaceCreated");
        openGlRender.Init(OpenGlRender.brx(), new WeakReference(openGlRender), openGlRender.rpN);
        openGlRender.setParam(openGlRender.rpo, openGlRender.rpp, openGlRender.rpq, openGlRender.rpN);
        openGlRender.setMode(((OpenGlView) openGlRender.rpy.get()).getWidth(), ((OpenGlView) openGlRender.rpy.get()).getHeight(), 0, openGlRender.rpN);
        openGlRender.rpv = true;
        openGlRender.rpr = true;
        openGlRender.requestRender();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        w.i(TAG, "surfaceDestroyed");
        OpenGlRender openGlRender = (OpenGlRender) this.rqe.get();
        w.i(OpenGlRender.TAG, "onSurfaceDestroyed");
        openGlRender.rpr = false;
        openGlRender.Uninit(openGlRender.rpN);
        w.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
        openGlRender.rpm = 0;
        openGlRender.rpw = 0;
        openGlRender.rpx = 0;
        super.surfaceDestroyed(surfaceHolder);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        w.i(TAG, "surfaceChanged, format: %s, w: %s, h: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void dp(int i, int i2) {
    }
}
