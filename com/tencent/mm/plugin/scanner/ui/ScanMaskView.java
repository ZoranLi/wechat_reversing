package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.compatible.util.d;

public class ScanMaskView extends View {
    private Paint fu;
    float paA = 0.0f;
    float paB = 0.0f;
    private Paint paC;
    ValueAnimator paD = null;
    private Bitmap paa = null;
    private Bitmap pab = null;
    private Bitmap pac = null;
    private Bitmap pad = null;
    int pae = 0;
    int paf = 0;
    private boolean pag = false;
    private Rect pah = new Rect();
    private Rect pai = new Rect();
    private Rect paj = new Rect();
    private Rect pak = new Rect();
    private Rect pal = new Rect();
    private Rect pam = new Rect();
    private Rect pan = new Rect();
    private Rect pao = new Rect();
    private Rect pap = new Rect();
    private Path paq = new Path();
    Rect par;
    private PorterDuffXfermode pas;
    private int pat = R.e.aVG;
    private long pau = 0;
    boolean pav = false;
    Rect paw;
    private final long pax = 200;
    float pay = 0.0f;
    float paz = 0.0f;

    public ScanMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScanMaskView(Context context, Rect rect) {
        super(context);
        this.par = rect;
        getDrawingRect(this.pah);
        this.fu = new Paint();
        this.paa = a.decodeResource(getResources(), R.g.bjn);
        this.pab = a.decodeResource(getResources(), R.g.bjo);
        this.pac = a.decodeResource(getResources(), R.g.bjp);
        this.pad = a.decodeResource(getResources(), R.g.bjq);
        this.pae = this.paa.getWidth();
        this.paf = this.paa.getHeight();
        this.paC = new Paint();
        this.pas = new PorterDuffXfermode(Mode.CLEAR);
    }

    public final void aYL() {
        this.pag = true;
        if (this.paa != null) {
            this.paa.recycle();
            this.paa = null;
        }
        if (this.pab != null) {
            this.pab.recycle();
            this.pab = null;
        }
        if (this.pac != null) {
            this.pac.recycle();
            this.pac = null;
        }
        if (this.pad != null) {
            this.pad.recycle();
            this.pad = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.par != null && !this.pag) {
            System.currentTimeMillis();
            System.currentTimeMillis();
            int save = canvas.save();
            this.fu.reset();
            if (d.ep(18)) {
                this.pam.left = 0;
                this.pam.top = this.par.top;
                this.pam.right = this.par.left;
                this.pam.bottom = this.par.bottom;
                this.pan.left = this.par.left;
                this.pan.top = 0;
                this.pan.right = this.par.right;
                this.pan.bottom = this.par.top;
                this.pao.left = this.par.right;
                this.pao.top = this.par.top;
                this.pao.right = getWidth();
                this.pao.bottom = this.par.bottom;
                this.pap.left = this.par.left;
                this.pap.top = this.par.bottom;
                this.pap.right = this.par.right;
                this.pap.bottom = getHeight();
                this.pai.left = 0;
                this.pai.top = 0;
                this.pai.right = this.par.left;
                this.pai.bottom = this.par.top;
                this.paj.left = this.par.right;
                this.paj.top = 0;
                this.paj.right = getWidth();
                this.paj.bottom = this.par.top;
                this.pak.left = 0;
                this.pak.top = this.par.bottom;
                this.pak.right = this.par.left;
                this.pak.bottom = getHeight();
                this.pal.left = this.par.right;
                this.pal.top = this.par.bottom;
                this.pal.right = getWidth();
                this.pal.bottom = getHeight();
                canvas.save();
                canvas.clipRect(this.pam, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pan, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pao, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pap, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pai, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.paj, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pak, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pal, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pat));
                canvas.restore();
            } else {
                canvas.clipRect(this.par, Op.DIFFERENCE);
                canvas.drawColor(getResources().getColor(this.pat));
            }
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.restoreToCount(save);
            this.fu.reset();
            this.fu.setStyle(Style.STROKE);
            this.fu.setStrokeWidth(1.0f);
            this.fu.setColor(-3355444);
            this.fu.setAntiAlias(true);
            canvas.drawRect(this.par, this.fu);
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.drawBitmap(this.paa, (float) this.par.left, (float) this.par.top, this.paC);
            canvas.drawBitmap(this.pab, (float) (this.par.right - this.pae), (float) this.par.top, this.paC);
            canvas.drawBitmap(this.pac, (float) this.par.left, (float) (this.par.bottom - this.paf), this.paC);
            canvas.drawBitmap(this.pad, (float) (this.par.right - this.pae), (float) (this.par.bottom - this.paf), this.paC);
            System.currentTimeMillis();
            super.onDraw(canvas);
            System.currentTimeMillis();
        }
    }
}
