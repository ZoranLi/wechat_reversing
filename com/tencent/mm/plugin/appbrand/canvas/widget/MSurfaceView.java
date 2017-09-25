package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView extends SurfaceView implements Callback, a {
    private final b iDs = new b(this);
    private final Set<OnAttachStateChangeListener> iDt = new LinkedHashSet();
    private SurfaceHolder iDu;
    private ae iDv;
    private Runnable iDw = new Runnable(this) {
        final /* synthetic */ MSurfaceView iDx;

        {
            this.iDx = r1;
        }

        public final void run() {
            if (!this.iDx.qx) {
                Canvas lockCanvas = this.iDx.iDu.lockCanvas();
                if (lockCanvas != null) {
                    lockCanvas.drawColor(-1);
                    this.iDx.b(lockCanvas);
                    this.iDx.iDu.unlockCanvasAndPost(lockCanvas);
                }
            }
        }
    };
    private volatile boolean qx;

    public MSurfaceView(Context context) {
        super(context);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iDu = getHolder();
        this.iDu.addCallback(this);
        this.iDu.setFormat(-3);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.iDs.iCP.iDi = paint;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        w.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", new Object[]{Integer.valueOf(hashCode())});
        this.qx = false;
        if (this.iDv == null) {
            HandlerThread cE = e.cE("MSurfaceView#Rending-Thread", -19);
            cE.start();
            this.iDv = new ae(cE.getLooper());
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        w.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", new Object[]{Integer.valueOf(hashCode())});
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        w.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[]{Integer.valueOf(hashCode())});
        this.qx = true;
        this.iDv.getLooper().quit();
        this.iDv = null;
    }

    public void draw(Canvas canvas) {
        w.i("MicroMsg.MSurfaceView", "draw(%s)", new Object[]{Integer.valueOf(hashCode())});
        canvas.drawColor(0, Mode.CLEAR);
        super.draw(canvas);
    }

    public final void Rp() {
        j(new Runnable(this) {
            final /* synthetic */ MSurfaceView iDx;

            {
                this.iDx = r1;
            }

            public final void run() {
                if (!this.iDx.qx) {
                    Canvas lockCanvas = this.iDx.iDu.lockCanvas();
                    if (lockCanvas != null) {
                        lockCanvas.drawColor(-1);
                        this.iDx.b(lockCanvas);
                        this.iDx.iDu.unlockCanvasAndPost(lockCanvas);
                    }
                }
            }
        });
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
        return 667;
    }

    public final int Rs() {
        return 668;
    }

    public final void setStartTime(long j) {
        this.iDs.iCW = j;
    }

    public final void Rt() {
        this.iDs.Rt();
    }
}
