package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class MultiTalkVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] nSc = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    int index;
    private int nMp;
    private int nMq;
    private SurfaceTexture nSd;
    private Paint nSe;
    a nSf = a.None;
    public int position;
    public String username;

    public enum a {
        Avatar,
        Video,
        None
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    private void KC() {
        this.nSe = new Paint();
        this.nSe.setColor(WebView.NIGHT_MODE_COLOR);
        this.nSe.setFilterBitmap(false);
        this.nSe.setTextSize(40.0f);
        setSurfaceTextureListener(this);
    }

    public final synchronized void a(int[] iArr, int i, int i2, int i3, int i4) {
        if (aNA()) {
            o.aNo().a(this, iArr, i, i2, i3, i4);
        }
    }

    public final synchronized void a(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!(this.nSd == null || this.nMp == 0 || this.nMq == 0)) {
                    Canvas lockCanvas = lockCanvas(null);
                    if (lockCanvas == null) {
                        w.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[]{this.username});
                    } else {
                        Matrix matrix = new Matrix();
                        if (i == OpenGlRender.rpJ) {
                            matrix.setRotate(270.0f, (float) (width / 2), (float) (height / 2));
                        } else if (i == OpenGlRender.rpI) {
                            matrix.setRotate(90.0f, (float) (width / 2), (float) (height / 2));
                        }
                        if (i2 == OpenGlRender.rpK) {
                            matrix.postScale(-1.0f, 1.0f);
                            matrix.postTranslate((float) width, 0.0f);
                        }
                        matrix.postScale(((float) lockCanvas.getWidth()) / ((float) height), ((float) lockCanvas.getHeight()) / ((float) width));
                        lockCanvas.drawColor(0, Mode.CLEAR);
                        if (!bitmap.isRecycled()) {
                            lockCanvas.drawBitmap(bitmap, matrix, this.nSe);
                        }
                        try {
                            unlockCanvasAndPost(lockCanvas);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        }
                    }
                }
            }
        }
        w.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
    }

    public final void aNv() {
        if (aNz()) {
            o.aNo().a(this, true);
        }
    }

    public final void aNw() {
        if (!bg.mA(this.username)) {
            w.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[]{this.username, this.nSf.name()});
            this.nSf = a.Avatar;
            aNv();
        }
    }

    public final void aNx() {
        w.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[]{this.username, this.nSf.name()});
        this.nSf = a.Video;
    }

    final void aNy() {
        if (this.nSd != null && this.nMp != 0 && this.nMq != 0) {
            Canvas lockCanvas = lockCanvas(null);
            if (lockCanvas == null) {
                w.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
                return;
            }
            lockCanvas.drawColor(0, Mode.CLEAR);
            lockCanvas.drawColor(-14737113);
            lockCanvas.drawColor(nSc[this.index]);
            try {
                unlockCanvasAndPost(lockCanvas);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawNone unlockCanvasAndPost crash", new Object[0]);
            }
        }
    }

    public final void aiQ() {
        if (aNz()) {
            o.aNo().a(this, false);
        } else if (aNA()) {
            a aVar = (a) o.aNo().nQp.get(this.username);
            Bitmap bitmap = aVar != null ? aVar.nQs : null;
            if (bitmap != null) {
                a(bitmap, aVar.nQa, aVar.angle);
            }
        } else {
            aNy();
        }
    }

    private boolean aNz() {
        return this.nSf == a.Avatar;
    }

    public final boolean aNA() {
        return this.nSf == a.Video;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureAvailable %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        w.i(str, str2, objArr);
        this.nSd = surfaceTexture;
        this.nMp = i;
        this.nMq = i2;
        bSB();
        e.post(new Runnable(this) {
            final /* synthetic */ MultiTalkVideoView nSg;

            {
                this.nSg = r1;
            }

            public final void run() {
                this.nSg.aiQ();
            }
        }, "onSurfaceTextureAvailable_refreshView");
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureSizeChanged %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        w.i(str, str2, objArr);
        this.nMp = i;
        this.nMq = i2;
        e.post(new Runnable(this) {
            final /* synthetic */ MultiTalkVideoView nSg;

            {
                this.nSg = r1;
            }

            public final void run() {
                this.nSg.aiQ();
            }
        }, "onSurfaceTextureSizeChanged_refreshView");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureDestroyed %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        this.nSd = null;
        this.nMq = 0;
        this.nMp = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        w.v(str, str2, objArr);
    }
}
