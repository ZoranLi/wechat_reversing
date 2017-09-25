package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView extends TextureView implements SurfaceTextureListener, a {
    private final b iDs = new b(this);
    private final Set<OnAttachStateChangeListener> iDt = new LinkedHashSet();
    private volatile ae iDv;
    private Runnable iDw = new Runnable(this) {
        final /* synthetic */ MTextureView iDz;

        {
            this.iDz = r1;
        }

        public final void run() {
            if (this.iDz.isAvailable()) {
                Canvas lockCanvas = this.iDz.lockCanvas();
                if (lockCanvas != null) {
                    synchronized (this.iDz.mLock) {
                        this.iDz.iDy = true;
                    }
                    lockCanvas.drawColor(-1);
                    this.iDz.b(lockCanvas);
                    this.iDz.unlockCanvasAndPost(lockCanvas);
                    synchronized (this.iDz.mLock) {
                        this.iDz.iDy = false;
                        this.iDz.mLock.notifyAll();
                    }
                }
            }
        }
    };
    private volatile boolean iDy;
    private volatile Object mLock = new Object();

    public MTextureView(Context context) {
        super(context);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.iDs.iCP.iDi = paint;
    }

    public final void Rp() {
        if (this.iDv != null) {
            this.iDv.removeCallbacks(this.iDw);
            this.iDv.post(this.iDw);
        }
    }

    public final void j(Runnable runnable) {
        if (this.iDv != null) {
            this.iDv.post(runnable);
        }
    }

    public final boolean b(Canvas canvas) {
        return this.iDs.b(canvas);
    }

    public final void d(JSONArray jSONArray) {
        this.iDs.d(jSONArray);
    }

    public final void e(JSONArray jSONArray) {
        this.iDs.e(jSONArray);
    }

    public final void Rq() {
        this.iDs.Rq();
    }

    public final void nU(String str) {
        this.iDs.nU(str);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        if (!this.iDt.contains(onAttachStateChangeListener)) {
            this.iDt.add(onAttachStateChangeListener);
            super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.iDt.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    public final void onPause() {
        this.iDs.onPause();
    }

    public final void onResume() {
        this.iDs.onResume();
    }

    public final boolean isPaused() {
        return this.iDs.iCT;
    }

    public final void nV(String str) {
        this.iDs.iCS = str;
    }

    public final int Rr() {
        return 682;
    }

    public final int Rs() {
        return 683;
    }

    public final void setStartTime(long j) {
        this.iDs.iCW = j;
    }

    public final void Rt() {
        this.iDs.Rt();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        w.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
        if (this.iDv == null) {
            HandlerThread cE = e.cE("MTextureView#Rending-Thread", -19);
            cE.start();
            this.iDv = new ae(cE.getLooper());
        }
        Canvas lockCanvas = lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(-1);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        w.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        w.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
        this.iDv.removeCallbacks(this.iDw);
        this.iDv.getLooper().quit();
        synchronized (this.mLock) {
            if (this.iDy) {
                try {
                    this.mLock.wait(1000);
                } catch (Throwable e) {
                    w.e("MicroMsg.MTextureView", "await error : %s", new Object[]{Log.getStackTraceString(e)});
                }
            }
        }
        this.iDv = null;
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
