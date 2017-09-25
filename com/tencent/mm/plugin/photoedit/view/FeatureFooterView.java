package com.tencent.mm.plugin.photoedit.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.photoedit.c.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;

public class FeatureFooterView extends View implements d {
    private static final int oof = com.tencent.mm.plugin.photoedit.g.a.ad(7.0f);
    private static final int ooh = com.tencent.mm.plugin.photoedit.g.a.ad(8.0f);
    private static final int[] ooi = new int[]{-1, -707825, -17592, -5376, -3997905, -16535286, -14298369, -15172610, -16762936, -7054596, -26113, -169583, -449092};
    private int CI = -1;
    private float aed = -1.0f;
    private TextPaint gm;
    private int ntF = -1;
    private Bitmap onA;
    private Bitmap onB;
    private Bitmap onC;
    private boolean onD;
    private boolean onE;
    private boolean onF;
    private boolean onG;
    private boolean onH;
    private TextPaint onI;
    private Bitmap onJ;
    private Bitmap onK;
    private Bitmap onL;
    private Bitmap onM;
    private int onN = -1;
    private int onO = -1;
    private int onP = -1;
    public a onQ;
    private Rect onR = new Rect();
    private Paint onS;
    private b onT = b.DEFAULE;
    private b onU = b.DEFAULE;
    private int[] onV = new int[5];
    private RectF[] onW = new RectF[6];
    private RectF[] onX = new RectF[5];
    private final float onY = getResources().getDimension(R.f.aZP);
    private final float onZ = getResources().getDimension(R.f.aZr);
    private Bitmap onf;
    private Bitmap ong;
    private Bitmap onh;
    private Bitmap oni;
    private Bitmap onj;
    private Bitmap onk;
    private Bitmap onl;
    private Bitmap onm;
    private Bitmap onn;
    private Bitmap ono;
    private Bitmap onp;
    private Bitmap onq;
    private Bitmap onr;
    private Bitmap ons;
    private boolean ont;
    private boolean onu;
    private boolean onv;
    private boolean onw;
    private boolean onx;
    private boolean ony;
    private Bitmap onz;
    private float ooa = getResources().getDimension(R.f.aZk);
    private final float oob = getResources().getDimension(R.f.baS);
    private float ooc;
    private Paint ood = new Paint();
    private Path ooe = new Path();
    private float oog;
    private float ooj;
    private float ook;
    private float ool;
    private float oom;
    private Bitmap oon;
    private Bitmap ooo;
    public ImageView oop;
    private Paint ooq = new Paint();
    boolean oor = false;
    public com.tencent.mm.plugin.photoedit.view.SelectColorBar.a oos;
    int oot = 221;
    private boolean oou = false;

    public interface a {
        void a(b bVar);

        void a(b bVar, int i);

        void b(b bVar, int i);

        boolean b(b bVar);
    }

    public enum b {
        DOODLE,
        TEXT,
        EMOJI,
        MOSAIC,
        CROP,
        DEFAULE
    }

    public FeatureFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        int i = 0;
        this.gm = new TextPaint();
        this.gm.setTextSize(getResources().getDimension(R.f.aZq));
        this.gm.setColor(-1);
        this.gm.setStyle(Style.FILL);
        this.gm.setDither(true);
        this.gm.setAntiAlias(true);
        this.gm.setFlags(FileUtils.S_IWUSR);
        this.onI = new TextPaint(this.gm);
        this.onI.setTextSize(this.oob);
        this.onI.setColor(-7829368);
        this.onr = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dAg));
        this.onp = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dzn));
        this.ons = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dAh));
        this.onq = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dzo));
        this.onz = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dzP));
        this.onA = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dzO));
        this.onB = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dvt));
        this.onC = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dvs));
        this.onf = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dwB));
        this.ong = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dwA));
        this.onh = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dzT));
        this.oni = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dzS));
        this.onj = BitmapFactory.decodeResource(getResources(), R.g.beS);
        this.onk = BitmapFactory.decodeResource(getResources(), R.g.beR);
        this.onl = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dxL));
        this.onm = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dxK));
        this.onn = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dwo));
        this.ono = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.dwn));
        this.onK = BitmapFactory.decodeResource(getResources(), R.g.bhi);
        this.onJ = BitmapFactory.decodeResource(getResources(), R.g.bhh);
        this.onL = BitmapFactory.decodeResource(getResources(), R.g.bhk);
        this.onM = BitmapFactory.decodeResource(getResources(), R.g.bhj);
        this.onV[0] = getResources().getColor(R.e.aTD);
        this.onV[1] = getResources().getColor(R.e.aTC);
        this.onV[2] = getResources().getColor(R.e.aTE);
        this.onV[3] = getResources().getColor(R.e.aTB);
        this.onV[4] = getResources().getColor(R.e.aTA);
        for (int i2 = 0; i2 < this.onW.length; i2++) {
            this.onW[i2] = new RectF();
        }
        this.onS = new Paint();
        this.onS.setStyle(Style.FILL);
        this.onS.setAntiAlias(true);
        this.onS.setColor(getResources().getColor(R.e.aTz));
        this.onS.setStrokeWidth(1.0f);
        while (i < this.onX.length) {
            this.onX[i] = new RectF();
            i++;
        }
        this.ood.setAntiAlias(true);
        this.ood.setStyle(Style.STROKE);
        this.ood.setStrokeWidth((float) oof);
        this.oon = com.tencent.mm.sdk.platformtools.d.t(getResources().getDrawable(R.k.csq));
        this.ooo = this.oon.copy(Config.ARGB_8888, true);
        this.ooq.setStyle(Style.FILL);
    }

    protected void onMeasure(int i, int i2) {
        int dimension;
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        if (aSN()) {
            dimension = (int) getResources().getDimension(R.f.aZQ);
            if (this.onT == b.CROP) {
                dimension = (int) (getResources().getDimension(R.f.aZR) + this.onZ);
            }
        } else {
            dimension = (int) getResources().getDimension(R.f.aZR);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(dimension, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.onR = new Rect(i, i2, i3, i4);
            this.ooc = getResources().getDimension(R.f.aZR) / 2.0f;
            this.ooj = (((((float) this.onR.width()) - (this.onY * 2.0f)) - ((((((((float) this.onR.width()) - (this.onY * 2.0f)) - ((float) this.onf.getWidth())) - ((float) this.onn.getWidth())) * 1.0f) / 4.0f) - ((float) this.onr.getWidth()))) - ((float) this.onr.getWidth())) - 12.0f;
            this.ook = this.ooj / ((float) ooi.length);
            this.oog = (this.ook / 2.0f) - 3.0f;
            this.ool = this.onY;
            this.oom = ((getResources().getDimension(R.f.aZO) * 1.0f) / 2.0f) - ((float) (oof / 2));
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        float f;
        float f2;
        float height;
        float dimension;
        super.onDraw(canvas);
        long currentTimeMillis = System.currentTimeMillis();
        for (RectF empty : this.onW) {
            empty.setEmpty();
        }
        for (RectF empty2 : this.onX) {
            empty2.setEmpty();
        }
        if (this.onT == b.CROP) {
            canvas.save();
            canvas.clipRect(0, (int) this.onZ, this.onR.right, this.onR.bottom);
            canvas.drawColor(getResources().getColor(R.e.aTR));
            canvas.restore();
        } else {
            canvas.drawColor(getResources().getColor(R.e.aTR));
        }
        if (aSN()) {
            if (this.onT == b.DOODLE) {
                canvas.drawLine(0.0f, getResources().getDimension(R.f.aZO), (float) this.onR.right, getResources().getDimension(R.f.aZO), this.onS);
                this.ood.setStyle(Style.STROKE);
                canvas.saveLayer(0.0f, 0.0f, (float) this.onR.width(), (float) this.onR.height(), null, 31);
                canvas.drawColor(0, Mode.CLEAR);
                this.ood.setStrokeCap(Cap.BUTT);
                for (i = 0; i < ooi.length; i++) {
                    this.ooe.reset();
                    this.ooe.moveTo(this.ool + (this.ook * ((float) i)), this.oom);
                    this.ooe.lineTo(this.ool + (this.ook * ((float) (i + 1))), this.oom);
                    this.ood.setColor(ooi[i]);
                    canvas.drawPath(this.ooe, this.ood);
                }
                this.ood.setColor(ooi[0]);
                this.ood.setStrokeCap(Cap.ROUND);
                this.ood.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                this.ooe.reset();
                this.ooe.moveTo(this.ool + (this.ook / 3.0f), this.oom);
                this.ooe.lineTo((this.ool + (this.ook * ((float) ooi.length))) - (this.ook / 3.0f), this.oom);
                canvas.drawPath(this.ooe, this.ood);
                canvas.restore();
                this.ood.setXfermode(null);
                if (this.CI == -1) {
                    this.CI = 1;
                    this.aed = rc(this.CI);
                }
                f = this.oom;
                this.ood.setColor(ooi[0]);
                this.ood.setStyle(Style.FILL);
                canvas.drawRoundRect(new RectF(this.aed - (this.ook / 4.0f), f - (this.ook / 1.9f), this.aed + (this.ook / 4.0f), (this.ook / 1.9f) + f), 25.0f, 25.0f, this.ood);
                this.ood.setColor(ooi[this.CI]);
                canvas.drawRoundRect(new RectF((this.aed - (this.ook / 4.0f)) + 3.0f, (f - (this.ook / 1.9f)) + 3.0f, (this.aed + (this.ook / 4.0f)) - 3.0f, (f + (this.ook / 1.9f)) - 3.0f), 25.0f, 25.0f, this.ood);
                this.ood.setStyle(Style.STROKE);
                if (this.oos != null) {
                    this.oos.qZ(this.ood.getColor());
                }
                l(canvas);
            } else if (this.onT == b.MOSAIC) {
                k(canvas);
            } else {
                if (this.onT == b.CROP && this.onD) {
                    f = ((getResources().getDimension(R.f.aZR) / 2.0f) - ((float) (this.onC.getHeight() / 2))) + this.onZ;
                    f2 = this.onY;
                    height = (this.onZ / 2.0f) - ((float) (this.onq.getHeight() / 2));
                    if (this.onF) {
                        canvas.drawBitmap(this.onq, f2, height, null);
                    } else {
                        canvas.drawBitmap(this.onp, f2, height, null);
                    }
                    if (this.onE) {
                        canvas.drawBitmap(this.onz, (((float) this.onR.right) - f2) - ((float) this.onC.getWidth()), f, null);
                    } else {
                        canvas.drawBitmap(this.onA, (((float) this.onR.right) - f2) - ((float) this.onC.getWidth()), f, null);
                    }
                    if (this.onG) {
                        canvas.drawBitmap(this.onB, f2, f, null);
                    } else {
                        canvas.drawBitmap(this.onC, f2, f, null);
                    }
                    f = getResources().getDimension(R.f.aZq) * 2.0f;
                    dimension = (((getResources().getDimension(R.f.aZq) - 8.0f) / 2.0f) + (getResources().getDimension(R.f.aZR) / 2.0f)) + this.onZ;
                    this.gm.setAlpha(255);
                    if (this.onH) {
                        this.gm.setColor(-1);
                        canvas.drawText(getResources().getString(R.l.eaU), ((float) this.onR.centerX()) - (f / 2.0f), dimension, this.gm);
                    } else if (aSL()) {
                        this.gm.setColor(getResources().getColor(R.e.aWu));
                        canvas.drawText(getResources().getString(R.l.eaU), ((float) this.onR.centerX()) - (f / 2.0f), dimension, this.gm);
                    } else {
                        this.gm.setColor(-1);
                        this.gm.setAlpha(100);
                        canvas.drawText(getResources().getString(R.l.eaU), ((float) this.onR.centerX()) - (f / 2.0f), dimension, this.gm);
                    }
                    f = ((float) (this.onz.getWidth() / 2)) + f2;
                    dimension = ((((float) this.onR.height()) - this.onZ) / 2.0f) + this.onZ;
                    this.onW[0].set(f - this.ooc, dimension - this.ooc, f + this.ooc, this.ooc + dimension);
                    f = (float) this.onR.centerX();
                    this.onW[1].set(f - this.ooc, dimension - this.ooc, f + this.ooc, this.ooc + dimension);
                    f = (((float) this.onR.right) - f2) - ((float) (this.onC.getWidth() / 2));
                    this.onW[2].set(f - this.ooc, dimension - this.ooc, f + this.ooc, dimension + this.ooc);
                    f = ((float) (this.onr.getWidth() / 2)) + f2;
                    f2 = ((float) (this.onr.getHeight() / 2)) + height;
                    this.onW[3].set(f - this.ooc, f2 - this.ooc, f + this.ooc, f2 + this.ooc);
                }
                w.d("MicroMsg.FeatureFooterView", "cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
        f2 = this.onY;
        f = aSN() ? (getResources().getDimension(R.f.aZO) + (getResources().getDimension(R.f.aZR) / 2.0f)) - ((float) (this.onf.getHeight() / 2)) : (getResources().getDimension(R.f.aZR) / 2.0f) - ((float) (this.onf.getHeight() / 2));
        height = (1.0f * (((((float) this.onR.width()) - (this.onY * 2.0f)) - ((float) this.onf.getWidth())) - ((float) this.onn.getWidth()))) / 4.0f;
        if (this.onT == b.DOODLE) {
            canvas.drawBitmap(this.ong, f2, f, null);
        } else {
            canvas.drawBitmap(this.onf, f2, f, null);
        }
        f2 += (float) (this.ong.getWidth() / 2);
        dimension = ((float) (this.ong.getHeight() / 2)) + f;
        this.onX[0].set(f2 - this.ooc, dimension - this.ooc, f2 + this.ooc, dimension + this.ooc);
        f2 = ((this.onY + ((float) this.onf.getWidth())) + height) - ((float) this.oni.getWidth());
        if (this.onT == b.EMOJI && this.onv) {
            canvas.drawBitmap(this.onk, f2, f, null);
        } else {
            canvas.drawBitmap(this.onj, f2, f, null);
        }
        dimension = ((float) (this.onk.getWidth() / 2)) + f2;
        float height2 = ((float) (this.onk.getHeight() / 2)) + f;
        this.onX[1].set(dimension - this.ooc, height2 - this.ooc, dimension + this.ooc, height2 + this.ooc);
        f2 += ((float) (this.onk.getWidth() / 2)) + height;
        if (this.onT == b.TEXT && this.onu) {
            canvas.drawBitmap(this.oni, f2, f, null);
        } else {
            canvas.drawBitmap(this.onh, f2, f, null);
        }
        dimension = ((float) (this.onh.getWidth() / 2)) + f2;
        height2 = ((float) (this.onh.getHeight() / 2)) + f;
        this.onX[2].set(dimension - this.ooc, height2 - this.ooc, dimension + this.ooc, height2 + this.ooc);
        f2 += height + ((float) (this.onm.getWidth() / 2));
        if (this.onT == b.MOSAIC) {
            canvas.drawBitmap(this.onm, f2, f, null);
        } else {
            canvas.drawBitmap(this.onl, f2, f, null);
        }
        f2 += (float) (this.onl.getWidth() / 2);
        height = ((float) (this.onl.getHeight() / 2)) + f;
        this.onX[3].set(f2 - this.ooc, height - this.ooc, f2 + this.ooc, height + this.ooc);
        f2 = (((float) this.onR.width()) - this.onY) - ((float) this.ono.getWidth());
        if (this.onT == b.CROP) {
            canvas.drawBitmap(this.ono, f2, f, null);
        } else {
            canvas.drawBitmap(this.onn, f2, f, null);
        }
        f2 += (float) (this.ono.getWidth() / 2);
        f += (float) (this.ono.getHeight() / 2);
        this.onX[4].set(f2 - this.ooc, f - this.ooc, f2 + this.ooc, f + this.ooc);
        w.d("MicroMsg.FeatureFooterView", "cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int i2;
        switch (motionEvent.getAction()) {
            case 0:
                i2 = 0;
                while (i2 < this.onW.length) {
                    if (this.onW[i2].contains(motionEvent.getX(), motionEvent.getY())) {
                        this.onO = i2;
                        if (this.onT == b.DOODLE || this.onT == b.MOSAIC) {
                            if (i2 == this.onW.length - 1) {
                                this.ont = true;
                            } else {
                                this.ont = false;
                                if (this.onT == b.MOSAIC) {
                                    this.onP = i2;
                                } else {
                                    this.onN = i2;
                                }
                            }
                            while (i < this.onX.length) {
                                if (this.onX[i].contains(motionEvent.getX(), motionEvent.getY())) {
                                    this.ntF = i;
                                    switch (this.ntF) {
                                        case 0:
                                            this.onw = true;
                                            break;
                                        case 1:
                                            this.onv = true;
                                            break;
                                        case 2:
                                            this.onu = true;
                                            break;
                                        case 3:
                                            this.onx = true;
                                            break;
                                        case 4:
                                            this.ony = true;
                                            break;
                                    }
                                    postInvalidate();
                                    break;
                                }
                                i++;
                            }
                            postInvalidate();
                        } else {
                            if (this.onT == b.CROP) {
                                if (this.onO == 0) {
                                    this.onG = true;
                                } else if (this.onO == 1) {
                                    this.onH = true;
                                } else if (this.onO == 2) {
                                    this.onE = true;
                                } else if (this.onO == 3) {
                                    this.onF = true;
                                }
                            }
                            while (i < this.onX.length) {
                                if (this.onX[i].contains(motionEvent.getX(), motionEvent.getY())) {
                                    i++;
                                } else {
                                    this.ntF = i;
                                    switch (this.ntF) {
                                        case 0:
                                            this.onw = true;
                                            break;
                                        case 1:
                                            this.onv = true;
                                            break;
                                        case 2:
                                            this.onu = true;
                                            break;
                                        case 3:
                                            this.onx = true;
                                            break;
                                        case 4:
                                            this.ony = true;
                                            break;
                                    }
                                    postInvalidate();
                                }
                            }
                            postInvalidate();
                        }
                    } else {
                        i2++;
                    }
                }
                while (i < this.onX.length) {
                    if (this.onX[i].contains(motionEvent.getX(), motionEvent.getY())) {
                        this.ntF = i;
                        switch (this.ntF) {
                            case 0:
                                this.onw = true;
                                break;
                            case 1:
                                this.onv = true;
                                break;
                            case 2:
                                this.onu = true;
                                break;
                            case 3:
                                this.onx = true;
                                break;
                            case 4:
                                this.ony = true;
                                break;
                        }
                        postInvalidate();
                    } else {
                        i++;
                    }
                }
                postInvalidate();
                break;
            case 1:
            case 3:
                ValueAnimator ofFloat;
                i2 = 0;
                while (i2 < this.onX.length) {
                    if (this.onX[i2].contains(motionEvent.getX(), motionEvent.getY())) {
                        if (this.onw && i2 == 0) {
                            if (this.onT == b.DOODLE) {
                                this.onT = b.DEFAULE;
                                this.onU = b.DEFAULE;
                            } else {
                                if (this.onN == -1) {
                                    this.onN = 1;
                                }
                                this.onT = b.DOODLE;
                            }
                        } else if (this.onx && i2 == 3) {
                            if (this.onT == b.MOSAIC) {
                                this.onT = b.DEFAULE;
                                this.onU = b.DEFAULE;
                            } else {
                                if (this.onP == -1) {
                                    this.onP = 0;
                                }
                                this.onT = b.MOSAIC;
                            }
                        } else if (this.ony && i2 == 4) {
                            this.onT = b.CROP;
                            this.onD = true;
                        }
                        if (this.onQ != null) {
                            if (this.onv && i2 == 1) {
                                this.onQ.b(b.EMOJI, i2);
                            } else if (this.onu && i2 == 2) {
                                this.onQ.b(b.TEXT, i2);
                            } else {
                                this.onQ.b(this.onT, i2);
                            }
                        }
                        i2 = 0;
                        while (i2 < this.onW.length) {
                            if (!this.onW[i2].contains(motionEvent.getX(), motionEvent.getY()) && this.onQ != null) {
                                if (i2 == this.onW.length - 1) {
                                    if (aSL()) {
                                        this.onQ.a(this.onT);
                                    }
                                } else if (!(i2 == 1 && this.onT == b.CROP && !aSL())) {
                                    this.onQ.a(this.onT, i2);
                                }
                                if (this.onT == b.CROP && (i2 == 0 || i2 == 2)) {
                                    this.onD = false;
                                    this.onT = this.onU;
                                    if (this.onT == b.DOODLE) {
                                        this.onQ.b(this.onT, 0);
                                    } else if (this.onT == b.MOSAIC) {
                                        this.onQ.b(this.onT, 3);
                                    }
                                }
                                if (this.onT == b.DOODLE && this.oor) {
                                    ofFloat = ValueAnimator.ofFloat(new float[]{this.aed, rc(ae(this.aed))});
                                    ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
                                        final /* synthetic */ FeatureFooterView oov;

                                        {
                                            this.oov = r1;
                                        }

                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            this.oov.aed = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                            this.oov.aSM();
                                            this.oov.postInvalidate();
                                        }
                                    });
                                    ofFloat.addListener(new AnimatorListener(this) {
                                        final /* synthetic */ FeatureFooterView oov;

                                        {
                                            this.oov = r1;
                                        }

                                        public final void onAnimationStart(Animator animator) {
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            this.oov.oop.setVisibility(8);
                                        }

                                        public final void onAnimationCancel(Animator animator) {
                                        }

                                        public final void onAnimationRepeat(Animator animator) {
                                        }
                                    });
                                    ofFloat.setInterpolator(new LinearInterpolator());
                                    ofFloat.start();
                                    this.oor = false;
                                }
                                if (this.onT == b.DOODLE || this.onT == b.MOSAIC) {
                                    this.onU = this.onT;
                                }
                                this.ont = false;
                                this.onE = false;
                                this.onF = false;
                                this.onG = false;
                                this.onH = false;
                                this.onv = false;
                                this.onu = false;
                                this.onx = false;
                                this.onw = false;
                                this.ony = false;
                                requestLayout();
                                postInvalidate();
                                break;
                            }
                            i2++;
                        }
                        ofFloat = ValueAnimator.ofFloat(new float[]{this.aed, rc(ae(this.aed))});
                        ofFloat.addUpdateListener(/* anonymous class already generated */);
                        ofFloat.addListener(/* anonymous class already generated */);
                        ofFloat.setInterpolator(new LinearInterpolator());
                        ofFloat.start();
                        this.oor = false;
                        this.onU = this.onT;
                        this.ont = false;
                        this.onE = false;
                        this.onF = false;
                        this.onG = false;
                        this.onH = false;
                        this.onv = false;
                        this.onu = false;
                        this.onx = false;
                        this.onw = false;
                        this.ony = false;
                        requestLayout();
                        postInvalidate();
                        break;
                    }
                    i2++;
                }
                i2 = 0;
                while (i2 < this.onW.length) {
                    if (!this.onW[i2].contains(motionEvent.getX(), motionEvent.getY())) {
                        break;
                    }
                    i2++;
                }
                ofFloat = ValueAnimator.ofFloat(new float[]{this.aed, rc(ae(this.aed))});
                ofFloat.addUpdateListener(/* anonymous class already generated */);
                ofFloat.addListener(/* anonymous class already generated */);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.start();
                this.oor = false;
                this.onU = this.onT;
                this.ont = false;
                this.onE = false;
                this.onF = false;
                this.onG = false;
                this.onH = false;
                this.onv = false;
                this.onu = false;
                this.onx = false;
                this.onw = false;
                this.ony = false;
                requestLayout();
                postInvalidate();
                break;
            case 2:
                if (this.onT == b.DOODLE && motionEvent.getX() <= this.ool + this.ooj && motionEvent.getX() >= this.ool && motionEvent.getY() >= 0.0f && motionEvent.getY() <= (this.oom * 5.0f) / 2.0f) {
                    this.oor = true;
                    this.aed = motionEvent.getX();
                    aSM();
                    postInvalidate();
                    this.CI = ae(this.aed);
                    if (this.oos != null) {
                        this.oos.qZ(ooi[this.CI]);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public final void ab(float f) {
        int i = 255;
        int i2 = ((((int) (255.0f * f)) * 41) / 255) + ao.CTRL_INDEX;
        if (i2 <= ao.CTRL_INDEX) {
            i2 = ao.CTRL_INDEX;
        }
        w.i("MicroMsg.FeatureFooterView", "distance:%s alpha:%s", new Object[]{Float.valueOf(f), Integer.valueOf(i2)});
        if (i2 > 255) {
            i2 = 255;
        }
        this.oot = i2;
        String str = "MicroMsg.FeatureFooterView";
        String str2 = "[onReach] distance:%s alpha:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Float.valueOf(f);
        if (this.oot <= 255) {
            i = this.oot;
        }
        objArr[1] = Integer.valueOf(i);
        w.d(str, str2, objArr);
    }

    public final void aSu() {
        w.d("MicroMsg.FeatureFooterView", "[onUnReach]");
    }

    public final void azn() {
        w.d("MicroMsg.FeatureFooterView", "[onShow]");
    }

    public final void onHide() {
        w.d("MicroMsg.FeatureFooterView", "[onHide]");
    }

    public final void onRelease() {
        w.d("MicroMsg.FeatureFooterView", "[onRelease]");
    }

    private boolean aSL() {
        return this.onQ.b(this.onT);
    }

    private void aSM() {
        if (this.oop.getVisibility() == 8) {
            this.oop.setVisibility(0);
        }
        this.oop.setX(this.aed - (((float) this.ooo.getWidth()) / 2.0f));
        this.oop.setY(((float) getTop()) - this.ooa);
        this.CI = ae(this.aed);
        this.ooq.setColorFilter(new LightingColorFilter(ooi[this.CI], 1));
        Canvas canvas = new Canvas(this.ooo);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.drawBitmap(this.oon, 0.0f, 0.0f, this.ooq);
        this.oop.setImageBitmap(this.ooo);
    }

    private float rc(int i) {
        return (this.ool + (((float) i) * this.ook)) + (this.ook / 2.0f);
    }

    private int ae(float f) {
        int length = ooi.length - 1;
        int i = 0;
        while (i < ooi.length) {
            if (f >= this.ool + (((float) i) * this.ook) && f < this.ool + (((float) (i + 1)) * this.ook)) {
                break;
            }
            i++;
        }
        i = length;
        if (this.ool > f) {
            return 0;
        }
        return i;
    }

    private void k(Canvas canvas) {
        canvas.drawLine(0.0f, getResources().getDimension(R.f.aZO), (float) this.onR.right, getResources().getDimension(R.f.aZO), this.onS);
        float width = (((float) this.onR.width()) - ((this.onY * 2.0f) + ((float) this.onr.getWidth()))) / 3.0f;
        float dimension = (getResources().getDimension(R.f.aZO) / 2.0f) - ((float) (this.onK.getHeight() / 2));
        if (this.onP == 0) {
            canvas.drawBitmap(this.onJ, width, dimension, null);
            canvas.drawBitmap(this.onL, width * 2.0f, dimension, null);
        } else if (this.onP == 1) {
            canvas.drawBitmap(this.onK, width, dimension, null);
            canvas.drawBitmap(this.onM, width * 2.0f, dimension, null);
        } else {
            canvas.drawBitmap(this.onK, width, dimension, null);
            canvas.drawBitmap(this.onL, width * 2.0f, dimension, null);
        }
        for (RectF empty : this.onW) {
            empty.setEmpty();
        }
        float width2 = ((float) (this.onK.getWidth() / 2)) + width;
        dimension += (float) (this.onK.getHeight() / 2);
        this.onW[0].set(width2 - this.ooc, dimension - this.ooc, width2 + this.ooc, this.ooc + dimension);
        width2 = (2.0f * width) + ((float) (this.onK.getWidth() / 2));
        this.onW[1].set(width2 - this.ooc, dimension - this.ooc, width2 + this.ooc, dimension + this.ooc);
        l(canvas);
    }

    private void l(Canvas canvas) {
        float width = ((1.0f * (((((float) this.onR.width()) - (this.onY * 2.0f)) - ((float) this.onf.getWidth())) - ((float) this.onn.getWidth()))) / 4.0f) - ((float) this.onr.getWidth());
        this.onS.setColor(getResources().getColor(R.e.aTz));
        this.onS.setStrokeWidth(2.0f);
        float dimension = getResources().getDimension(R.f.aZO) / 3.0f;
        canvas.drawLine(((((float) this.onR.right) - this.onY) - ((float) this.onr.getWidth())) - (width / 2.0f), dimension, ((((float) this.onR.right) - this.onY) - ((float) this.onr.getWidth())) - (width / 2.0f), 2.0f * dimension, this.onS);
        width = getResources().getDimension(R.f.aZO);
        if (this.ont && aSL()) {
            canvas.drawBitmap(this.ons, ((float) (this.onR.right - this.ons.getWidth())) - this.onY, (width / 2.0f) - ((float) (this.ons.getHeight() / 2)), null);
        } else if (aSL()) {
            canvas.drawBitmap(this.onr, ((float) (this.onR.right - this.onr.getWidth())) - this.onY, (width / 2.0f) - ((float) (this.onr.getHeight() / 2)), null);
        } else {
            Paint paint = new Paint();
            paint.setAlpha(JsApiSetBackgroundAudioState.CTRL_INDEX);
            canvas.drawBitmap(this.onr, ((float) (this.onR.right - this.onr.getWidth())) - this.onY, (width / 2.0f) - ((float) (this.onr.getHeight() / 2)), paint);
        }
        width = ((float) (this.onR.right - (this.onr.getWidth() / 2))) - this.onY;
        float dimension2 = getResources().getDimension(R.f.aZO) / 2.0f;
        this.onW[this.onW.length - 1].set(width - (this.ooc * 1.3f), dimension2 - (this.ooc * 1.3f), width + (this.ooc * 1.3f), dimension2 + (this.ooc * 1.3f));
    }

    private boolean aSN() {
        if (this.onT == b.CROP || this.onT == b.DOODLE || this.onT == b.MOSAIC) {
            return true;
        }
        return false;
    }
}
