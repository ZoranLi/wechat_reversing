package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.f.b.b;
import java.io.InputStream;

public final class a extends Drawable implements b {
    private final Paint fu;
    private ae jsW;
    boolean lp;
    private float mDensity;
    private long mJA;
    private int mJB;
    private boolean mJC;
    int mJD;
    private int mJE;
    e mJF;
    private final Runnable mJG;
    final Runnable mJH;
    private final Runnable mJI;
    final Runnable mJJ;
    private final Runnable mJK;
    private final Runnable mJL;
    boolean mJl;
    private volatile long mJm;
    private AssetFileDescriptor mJn;
    private final int[] mJo;
    private float mJp;
    private float mJq;
    private boolean mJr;
    private int[] mJs;
    private int mJt;
    private int mJu;
    private long mJv;
    private long mJw;
    private long mJx;
    private long mJy;
    private long mJz;
    private final Rect tZ;

    final void d(Runnable runnable, long j) {
        this.mJA = SystemClock.uptimeMillis() + j;
        if (this.jsW != null) {
            this.jsW.postAtTime(runnable, this.mJA);
        }
    }

    public a(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
    }

    public a(String str) {
        this.lp = true;
        this.mJl = false;
        this.mJn = null;
        this.mJo = new int[6];
        this.mJp = 1.0f;
        this.mJq = 1.0f;
        this.tZ = new Rect();
        this.fu = new Paint(6);
        this.mJt = 0;
        this.mJu = -1;
        this.mJv = 0;
        this.mJw = 0;
        this.mJx = 0;
        this.mJy = 0;
        this.mJA = 0;
        this.mJC = false;
        this.mJD = 0;
        this.mJE = 0;
        this.jsW = new ae();
        this.mJG = new Runnable(this) {
            final /* synthetic */ a mJM;

            {
                this.mJM = r1;
            }

            public final void run() {
            }
        };
        this.mJH = new Runnable(this) {
            final /* synthetic */ a mJM;

            {
                this.mJM = r1;
            }

            public final void run() {
                if ((this.mJM.isRunning() || this.mJM.mJu == 0) && SystemClock.uptimeMillis() >= this.mJM.mJA) {
                    this.mJM.mJy = System.currentTimeMillis();
                    this.mJM.invalidateSelf();
                    if (this.mJM.mJF != null) {
                        this.mJM.mJF.invalidate();
                    }
                }
            }
        };
        this.mJI = new Runnable(this) {
            final /* synthetic */ a mJM;

            {
                this.mJM = r1;
            }

            public final void run() {
                MMGIFJNI.restoreRemainder(this.mJM.mJm);
                this.mJM.d(this.mJM.mJH, this.mJM.mJx);
            }
        };
        this.mJJ = new Runnable(this) {
            final /* synthetic */ a mJM;

            {
                this.mJM = r1;
            }

            public final void run() {
                MMGIFJNI.reset(this.mJM.mJm);
            }
        };
        this.mJK = new Runnable(this) {
            final /* synthetic */ a mJM;

            {
                this.mJM = r1;
            }

            public final void run() {
                MMGIFJNI.saveRemainder(this.mJM.mJm);
            }
        };
        this.mJL = new Runnable(this) {
            final /* synthetic */ a mJM;

            {
                this.mJM = r1;
            }

            public final void run() {
                if (this.mJM.mJl) {
                    w.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (this.mJM.mJu + 1 > this.mJM.mJt - 1) {
                    this.mJM.mJu = -1;
                }
                this.mJM.mJu = this.mJM.mJu + 1;
                if (MMGIFJNI.drawFramePixels(this.mJM.mJm, this.mJM.mJs, this.mJM.mJo)) {
                    this.mJM.mJE = this.mJM.mJE + 1;
                }
                this.mJM.mJv = System.currentTimeMillis() - currentTimeMillis;
                if (this.mJM.mJw != 0) {
                    this.mJM.mJx = (this.mJM.mJw - this.mJM.mJv) - this.mJM.mJz;
                    if (this.mJM.mJx < 0) {
                        w.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(this.mJM.mJv), Long.valueOf(this.mJM.mJz), Long.valueOf(this.mJM.mJx), Long.valueOf(this.mJM.mJw), Integer.valueOf(this.mJM.mJo[5]));
                        g.oUh.a(401, 0, 1, false);
                        g.oUh.a(401, 1, Math.abs(this.mJM.mJx), false);
                    }
                }
                this.mJM.d(this.mJM.mJH, this.mJM.mJx > 0 ? this.mJM.mJx : 0);
                if (this.mJM.mJo[2] == 1) {
                    this.mJM.mJw = 5000;
                } else {
                    this.mJM.mJw = (long) this.mJM.mJo[4];
                }
            }
        };
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("file path is null.");
        }
        this.mJm = MMGIFJNI.openByFilePath(str, this.mJo);
        init();
    }

    private a(AssetFileDescriptor assetFileDescriptor) {
        this.lp = true;
        this.mJl = false;
        this.mJn = null;
        this.mJo = new int[6];
        this.mJp = 1.0f;
        this.mJq = 1.0f;
        this.tZ = new Rect();
        this.fu = new Paint(6);
        this.mJt = 0;
        this.mJu = -1;
        this.mJv = 0;
        this.mJw = 0;
        this.mJx = 0;
        this.mJy = 0;
        this.mJA = 0;
        this.mJC = false;
        this.mJD = 0;
        this.mJE = 0;
        this.jsW = new ae();
        this.mJG = /* anonymous class already generated */;
        this.mJH = /* anonymous class already generated */;
        this.mJI = /* anonymous class already generated */;
        this.mJJ = /* anonymous class already generated */;
        this.mJK = /* anonymous class already generated */;
        this.mJL = /* anonymous class already generated */;
        if (assetFileDescriptor == null) {
            throw new NullPointerException("assert file Descriptor is null.");
        }
        this.mJn = assetFileDescriptor;
        this.mJm = MMGIFJNI.openByFileDescroptor(this.mJn.getFileDescriptor(), assetFileDescriptor.getStartOffset(), this.mJo);
        init();
    }

    public a(InputStream inputStream) {
        this.lp = true;
        this.mJl = false;
        this.mJn = null;
        this.mJo = new int[6];
        this.mJp = 1.0f;
        this.mJq = 1.0f;
        this.tZ = new Rect();
        this.fu = new Paint(6);
        this.mJt = 0;
        this.mJu = -1;
        this.mJv = 0;
        this.mJw = 0;
        this.mJx = 0;
        this.mJy = 0;
        this.mJA = 0;
        this.mJC = false;
        this.mJD = 0;
        this.mJE = 0;
        this.jsW = new ae();
        this.mJG = /* anonymous class already generated */;
        this.mJH = /* anonymous class already generated */;
        this.mJI = /* anonymous class already generated */;
        this.mJJ = /* anonymous class already generated */;
        this.mJK = /* anonymous class already generated */;
        this.mJL = /* anonymous class already generated */;
        if (inputStream == null) {
            throw new NullPointerException("input stream is null.");
        }
        this.mJm = MMGIFJNI.openByInputStrem(inputStream, this.mJo);
        init();
    }

    public a(byte[] bArr) {
        this.lp = true;
        this.mJl = false;
        this.mJn = null;
        this.mJo = new int[6];
        this.mJp = 1.0f;
        this.mJq = 1.0f;
        this.tZ = new Rect();
        this.fu = new Paint(6);
        this.mJt = 0;
        this.mJu = -1;
        this.mJv = 0;
        this.mJw = 0;
        this.mJx = 0;
        this.mJy = 0;
        this.mJA = 0;
        this.mJC = false;
        this.mJD = 0;
        this.mJE = 0;
        this.jsW = new ae();
        this.mJG = /* anonymous class already generated */;
        this.mJH = /* anonymous class already generated */;
        this.mJI = /* anonymous class already generated */;
        this.mJJ = /* anonymous class already generated */;
        this.mJK = /* anonymous class already generated */;
        this.mJL = /* anonymous class already generated */;
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        this.mJm = MMGIFJNI.openByByteArray(bArr, this.mJo);
        init();
    }

    private void init() {
        w.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", Long.valueOf(this.mJm));
        this.mJt = this.mJo[2];
        this.mJB = com.tencent.mm.bg.a.T(ab.getContext(), c.kDz);
        if (this.mJo[0] > 1024 || this.mJo[1] > 1024) {
            w.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.mJo[0]), Integer.valueOf(this.mJo[1]));
            this.mJs = new int[(this.mJB * this.mJB)];
            this.mJC = true;
            g.oUh.a(401, 2, 1, false);
            return;
        }
        this.mJs = new int[(this.mJo[0] * this.mJo[1])];
    }

    private float aCU() {
        if (this.mDensity == 0.0f) {
            this.mDensity = com.tencent.mm.bg.a.getDensity(ab.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    public final int getIntrinsicWidth() {
        return (int) (((float) this.mJo[0]) * aCU());
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.mJo[1]) * aCU());
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mJr = true;
    }

    public final void draw(Canvas canvas) {
        if (this.mJr) {
            this.tZ.set(getBounds());
            this.mJp = ((float) this.tZ.width()) / ((float) this.mJo[0]);
            this.mJq = ((float) this.tZ.height()) / ((float) this.mJo[1]);
            this.mJr = false;
        }
        if (this.fu.getShader() == null) {
            if (this.mJy == 0) {
                this.mJy = System.currentTimeMillis();
            }
            canvas.scale(this.mJp, this.mJq);
            int[] iArr = this.mJs;
            if (iArr == null) {
                w.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (iArr.length == this.mJo[0] * this.mJo[1]) {
                canvas.drawBitmap(iArr, 0, this.mJo[0], 0.0f, 0.0f, this.mJo[0], this.mJo[1], true, this.fu);
            } else {
                canvas.drawRGB(cs.CTRL_INDEX, cs.CTRL_INDEX, cs.CTRL_INDEX);
                w.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", Integer.valueOf(iArr.length), Integer.valueOf(this.mJo[0]), Integer.valueOf(this.mJo[1]));
            }
            this.mJz = System.currentTimeMillis() - this.mJy;
            if (this.mJC || this.mJo[2] <= 0) {
                w.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", Integer.valueOf(this.mJo[2]), Integer.valueOf(this.mJo[4]), Boolean.valueOf(this.mJC));
                return;
            }
            if (this.mJo[4] < 0) {
                w.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
            }
            if (this.mJD == 0 || this.mJE <= this.mJD - 1) {
                com.tencent.mm.af.a.a(this.mJL, 0);
                return;
            } else {
                d(this.mJG, 0);
                return;
            }
        }
        w.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.tZ, this.fu);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i) {
        this.fu.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fu.setColorFilter(colorFilter);
    }

    public final boolean isRunning() {
        return this.lp;
    }

    public final void start() {
        this.lp = true;
        com.tencent.mm.af.a.a(this.mJI, 0);
    }

    public final void stop() {
        w.d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.lp = false;
        com.tencent.mm.af.a.a(this.mJK, 300);
    }

    public final void recycle() {
        w.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.mJl = true;
        this.lp = false;
        long j = this.mJm;
        this.mJm = 0;
        MMGIFJNI.recycle(j);
        this.mJs = null;
        if (this.mJn != null) {
            try {
                this.mJn.close();
            } catch (Exception e) {
            }
        }
    }

    protected final void finalize() {
        try {
            recycle();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
