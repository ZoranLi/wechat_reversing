package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends Drawable implements Animatable {
    private Resources Cu;
    private int RQ;
    private int aar;
    private final Paint fu = new Paint(6);
    private ae jsW = new ae(Looper.getMainLooper());
    public int kZt = 0;
    private Context mContext;
    private long mJA = 0;
    private final Runnable mJG = new Runnable(this) {
        final /* synthetic */ c mKb;

        {
            this.mKb = r1;
        }

        public final void run() {
        }
    };
    private final Runnable mJH = new Runnable(this) {
        final /* synthetic */ c mKb;

        {
            this.mKb = r1;
        }

        public final void run() {
            if (SystemClock.uptimeMillis() >= this.mKb.mJA) {
                this.mKb.invalidateSelf();
            }
        }
    };
    private volatile boolean mJR = false;
    private int mJS;
    private int mJT;
    private int[] mJU;
    private Bitmap mJV = null;
    private boolean mJW = false;
    public boolean mJX = true;
    private String mJY;
    public int mJZ = 0;
    private float mJp = 1.0f;
    private float mJq = 1.0f;
    private boolean mJr;
    private e mKa;
    private final Rect tZ = new Rect();

    public c(Context context, boolean z, boolean z2, int i, int[] iArr, String str) {
        this.mContext = context;
        this.Cu = this.mContext.getResources();
        this.mJW = false;
        this.mJX = z2;
        this.mJY = str;
        this.mJT = i;
        this.mJU = iArr;
        if (z2) {
            this.mJV = nU(this.mJU[0]);
        } else {
            this.mJV = nU(yi(str));
        }
        this.aar = this.mJV.getWidth();
        this.RQ = this.mJV.getHeight();
        if (this.mJU.length == 3) {
            this.mJS = e.CTRL_INDEX;
        } else {
            this.mJS = 100;
        }
        this.mJZ = 0;
    }

    public final void draw(Canvas canvas) {
        if (this.mJr) {
            this.tZ.set(getBounds());
            this.mJp = ((float) this.tZ.width()) / ((float) this.aar);
            this.mJq = ((float) this.tZ.height()) / ((float) this.RQ);
            this.mJr = false;
        }
        if (this.fu.getShader() == null) {
            canvas.scale(this.mJp, this.mJq);
            if (this.mJW) {
                this.mJV = nU(this.mJT);
                if (this.mJV != null && !this.mJV.isRecycled()) {
                    canvas.drawBitmap(this.mJV, 0.0f, 0.0f, this.fu);
                    return;
                }
                return;
            } else if (this.mJX) {
                w.i("MicroMsg.GIF.MMGIFGameDrawable", "mCurrentIndex:%d mNextInvaliteTime:%d mLoop:%d", Integer.valueOf(this.kZt), Integer.valueOf(this.mJS), Integer.valueOf(this.mJZ));
                this.mJV = nU(this.mJU[this.kZt]);
                if (!(this.mJV == null || this.mJV.isRecycled())) {
                    canvas.drawBitmap(this.mJV, 0.0f, 0.0f, this.fu);
                }
                this.kZt++;
                if (this.mJZ < 3) {
                    if (this.kZt >= this.mJU.length) {
                        this.kZt = 0;
                        this.mJZ++;
                    }
                    d(this.mJH, (long) this.mJS);
                    return;
                }
                this.mJX = false;
                d(this.mJH, (long) this.mJS);
                d(this.mJG, 0);
                return;
            } else {
                this.mJV = nU(yi(this.mJY));
                if (this.mJV != null && !this.mJV.isRecycled()) {
                    canvas.drawBitmap(this.mJV, 0.0f, 0.0f, this.fu);
                    return;
                }
                return;
            }
        }
        w.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
        canvas.drawRect(this.tZ, this.fu);
    }

    private void d(Runnable runnable, long j) {
        this.mJA = SystemClock.uptimeMillis() + j;
        if (this.jsW != null) {
            this.jsW.postDelayed(runnable, j);
        }
    }

    public final int getIntrinsicHeight() {
        return this.RQ;
    }

    public final int getIntrinsicWidth() {
        return this.aar;
    }

    public final void setAlpha(int i) {
        this.fu.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fu.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -2;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mJr = true;
    }

    public final void start() {
        this.mJR = true;
        this.jsW.post(this.mJH);
    }

    public final void stop() {
        this.mJR = false;
    }

    public final boolean isRunning() {
        return this.mJR;
    }

    private Bitmap nU(int i) {
        return BitmapFactory.decodeResource(this.Cu, i);
    }

    private int yi(String str) {
        return this.Cu.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
    }

    protected final void finalize() {
        this.mKa = null;
        super.finalize();
    }
}
