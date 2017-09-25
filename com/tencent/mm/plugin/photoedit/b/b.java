package com.tencent.mm.plugin.photoedit.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.photoedit.c.a;
import com.tencent.mm.plugin.photoedit.c.c;
import com.tencent.mm.sdk.platformtools.w;

public abstract class b<T extends c> implements OnTouchListener, a {
    public boolean hoD = false;
    public Runnable ojA;
    private com.tencent.mm.plugin.photoedit.c.b ojt;
    public Bitmap oju;
    public Matrix ojv;
    public Rect ojw;
    PointF ojx = new PointF();
    private PointF ojy = new PointF();
    public com.tencent.mm.plugin.photoedit.d.b ojz;
    float[] values = new float[9];

    public abstract a aRO();

    public abstract boolean y(MotionEvent motionEvent);

    public b(com.tencent.mm.plugin.photoedit.c.b bVar) {
        this.ojt = bVar;
    }

    public void a(com.tencent.mm.plugin.photoedit.d.b bVar) {
        w.i("MicroMsg.BaseArtist", "[onAlive] type:%s", new Object[]{aRO()});
        this.hoD = false;
        this.ojz = bVar;
        c aRW = aRW();
        if (aRW != null) {
            aRW.aSi();
            aRW.gf(false);
            return;
        }
        w.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", new Object[]{aRO()});
    }

    public void a(a aVar, a aVar2) {
        w.i("MicroMsg.BaseArtist", "[onChange] fromType:%s toType):%s", new Object[]{aVar, aVar2});
    }

    public void onDestroy() {
        w.i("MicroMsg.BaseArtist", "[onDestroy] type:%s", new Object[]{aRO()});
        if (!(this.oju == null || this.oju.isRecycled())) {
            this.oju.recycle();
        }
        this.ojz = null;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean y = y(motionEvent);
        if (C(motionEvent)) {
            z(motionEvent);
        }
        return y;
    }

    public final Bitmap aRP() {
        if ((this.oju == null || this.oju.isRecycled()) && this.ojz.olf != null) {
            this.oju = Bitmap.createBitmap(this.ojz.olf.getWidth(), this.ojz.olf.getHeight(), Config.ARGB_4444);
        }
        return this.oju;
    }

    public final boolean aRQ() {
        if (!(this.oju == null || this.oju.isRecycled())) {
            this.oju.recycle();
        }
        this.oju = aRW().aSk();
        if (this.oju == null) {
            return false;
        }
        return true;
    }

    public final void b(boolean z, Object... objArr) {
        w.i("MicroMsg.BaseArtist", "[onRefreshDrawCache]  isOverDraw:%s", new Object[]{Boolean.valueOf(z)});
        if (this.hoD) {
            w.w("MicroMsg.BaseArtist", "[onRefreshDrawCache]  isFinish: true");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap aRP = aRP();
        if (!(aRP == null || aRP.isRecycled())) {
            aRW().a(new Canvas(aRP), z, objArr);
            aRW().v(aRP);
        }
        w.d("MicroMsg.BaseArtist", "costTime:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public void f(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.ojw);
        Bitmap aRP = aRP();
        if (aRP != null) {
            canvas.drawBitmap(aRP, 0.0f, 0.0f, null);
        } else {
            w.w("MicroMsg.BaseArtist", "[onDeadDraw] bitmap == null ");
        }
        canvas.restore();
    }

    public final void aRR() {
        if (this.ojz != null) {
            this.ojz.postInvalidate();
        }
    }

    public void aRS() {
        aRW().pop();
        this.ojz.removeCallbacks(this.ojA);
        com.tencent.mm.plugin.photoedit.d.b bVar = this.ojz;
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ b ojB;

            {
                this.ojB = r1;
            }

            public final void run() {
                if (!(this.ojB.oju == null || this.ojB.oju.isRecycled())) {
                    this.ojB.oju.recycle();
                }
                this.ojB.oju = this.ojB.aRW().aSk();
                if (this.ojB.oju == null) {
                    w.w("MicroMsg.BaseArtist", "[unDo] mDrawCacheBitmap is null ");
                }
                this.ojB.ojA = null;
                this.ojB.aRR();
            }
        };
        this.ojA = anonymousClass1;
        bVar.postDelayed(anonymousClass1, 66);
    }

    public boolean aRT() {
        c aRW = aRW();
        if (aRW != null) {
            return aRW.aSl();
        }
        return false;
    }

    public final void aRU() {
        this.ojt.aRU();
    }

    protected final void aRV() {
        this.ojt.c(this.ojt.aSs());
    }

    public final T aRW() {
        return this.ojt.a(aRO());
    }

    public final Bitmap aRX() {
        if (this.ojz != null) {
            return this.ojz.olf;
        }
        return null;
    }

    protected final void z(MotionEvent motionEvent) {
        this.ojx.x = motionEvent.getX(0);
        this.ojx.y = motionEvent.getY(0);
        if (motionEvent.getPointerCount() > 1) {
            this.ojy.x = motionEvent.getX(1);
            this.ojy.y = motionEvent.getY(1);
        }
    }

    protected static int[] A(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (motionEvent.getPointerCount() > 1) {
            iArr[0] = (int) (motionEvent.getX(0) - motionEvent.getX(1));
            iArr[1] = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        }
        return iArr;
    }

    protected static int B(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0;
        }
        int x = (int) (motionEvent.getX(0) - motionEvent.getX(1));
        int y = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        return (int) Math.sqrt((double) ((y * y) + (x * x)));
    }

    protected final boolean C(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            if (Math.abs(this.ojx.x - motionEvent.getX(0)) > 6.0f || Math.abs(this.ojx.y - motionEvent.getY(0)) > 6.0f || Math.abs(this.ojy.x - motionEvent.getX(1)) > 6.0f || Math.abs(this.ojy.y - motionEvent.getY(1)) > 6.0f) {
                return true;
            }
            return false;
        } else if (motionEvent.getPointerCount() != 1) {
            return false;
        } else {
            if (Math.abs(this.ojx.x - motionEvent.getX(0)) > 6.0f || Math.abs(this.ojx.y - motionEvent.getY(0)) > 6.0f) {
                return true;
            }
            return false;
        }
    }

    protected final float[] z(float f, float f2) {
        Matrix matrix = new Matrix(this.ojv);
        this.ojv.invert(matrix);
        float[] fArr = new float[]{f, f2};
        matrix.mapPoints(fArr);
        return fArr;
    }

    protected final float[] A(float f, float f2) {
        float[] fArr = new float[]{f, f2};
        this.ojv.mapPoints(fArr);
        return fArr;
    }

    public final float getScale() {
        float a = a(this.ojv, 3);
        float a2 = a(this.ojv, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float getRotation() {
        return (float) Math.round(Math.atan2((double) a(this.ojv, 1), (double) a(this.ojv, 0)) * 57.29577951308232d);
    }

    public final float a(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }
}
