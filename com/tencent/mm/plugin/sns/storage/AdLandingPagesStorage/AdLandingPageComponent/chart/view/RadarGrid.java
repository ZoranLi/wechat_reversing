package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid extends ChartGridView {
    public static final Point qhj = new Point(0, 0);
    private Rect fv = new Rect();
    private Path mU = new Path();
    private int qhe = 4;
    private int qhf = 4;
    private float qhh = 1.0f;
    public c qhi;
    private int qhp = 80;
    private Point qhq = qhj;
    private Spannable[] qhs;
    private List<PointF> qht;

    public RadarGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bfY();
    }

    public RadarGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bfY();
    }

    public RadarGrid(Context context, int i, int i2, float f, Spannable[] spannableArr, c cVar) {
        super(context);
        this.qhh = f;
        this.qhe = i;
        this.qhf = i2;
        this.qhh = f;
        this.qhs = spannableArr;
        this.qhi = cVar;
    }

    private void bfY() {
        setMinimumHeight(JsApiSetBackgroundAudioState.CTRL_INDEX);
        setMinimumWidth(JsApiSetBackgroundAudioState.CTRL_INDEX);
    }

    protected final int bfV() {
        return this.qhp * 2;
    }

    protected final int bfW() {
        return this.qhp * 2;
    }

    private List<PointF> am(float f) {
        List<PointF> arrayList = new ArrayList();
        for (int i = 0; i < this.qhe; i++) {
            PointF pointF = new PointF();
            pointF.set((float) (((double) this.qhq.x) - (((double) (((float) this.qhp) * f)) * Math.sin((((double) (i * 2)) * 3.141592653589793d) / ((double) this.qhe)))), (float) (((double) this.qhq.y) - (((double) (((float) this.qhp) * f)) * Math.cos((((double) (i * 2)) * 3.141592653589793d) / ((double) this.qhe)))));
            arrayList.add(pointF);
        }
        return arrayList;
    }

    public void onDraw(Canvas canvas) {
        int i;
        PointF pointF;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.qhp = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.qhq.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.qhi.qgU != null) {
            width = (int) (((float) width) / 2.0f);
            height = (int) (((float) height) / 2.0f);
            i = (int) (((float) (this.qhp * 2)) + (this.qhi.qgR * 2.0f));
            int width2 = (this.qhi.qgU.getWidth() * i) / this.qhi.qgU.getHeight();
            if (this.qhi.qgU != null) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(this.qhi.qgU, width2, i, false), (float) (width - (width2 >>> 1)), (float) (height - (i >>> 1)), null);
            }
        }
        if (this.qhi.qgB) {
            switch (this.qhi.qgA) {
                case 0:
                    this.qht = am(1.0f);
                    for (width = 0; width < this.qhe; width++) {
                        pointF = (PointF) this.qht.get(width);
                        if (width == 0) {
                            this.mU.moveTo(pointF.x, pointF.y);
                        } else {
                            this.mU.lineTo(pointF.x, pointF.y);
                        }
                    }
                    this.mU.close();
                    if (this.qhi.backgroundColor != 0 && this.qhi.qgU == null) {
                        canvas.drawPath(this.mU, bfZ());
                        break;
                    }
                case 1:
                    canvas.drawCircle((float) this.qhq.x, (float) this.qhq.y, (float) this.qhp, bfZ());
                    break;
            }
        }
        if (this.qhi.qgC) {
            this.qht = am(1.0f);
            for (int i2 = 0; i2 < this.qhe; i2++) {
                pointF = (PointF) this.qht.get(i2);
                float f = (float) this.qhq.x;
                float f2 = (float) this.qhq.y;
                float f3 = pointF.x;
                float f4 = pointF.y;
                Paint paint = new Paint();
                paint.setColor(this.qhi.qgH);
                paint.setStrokeWidth(this.qhi.qgI);
                canvas.drawLine(f, f2, f3, f4, paint);
            }
        }
        if (this.qhi.qgB) {
            switch (this.qhi.qgA) {
                case 0:
                    canvas.drawPath(this.mU, bga());
                    this.mU.reset();
                    for (width = 1; width < this.qhf; width++) {
                        this.qht = am((((float) width) * 1.0f) / ((float) this.qhf));
                        for (i = 0; i < this.qhe; i++) {
                            pointF = (PointF) this.qht.get(i);
                            if (i == 0) {
                                this.mU.moveTo(pointF.x, pointF.y);
                            } else {
                                this.mU.lineTo(pointF.x, pointF.y);
                            }
                            f3 = pointF.x;
                            float f5 = pointF.y;
                            f4 = (float) this.qhi.qgT;
                            paint = new Paint();
                            paint.setColor(this.qhi.qgS);
                            paint.setStyle(Style.FILL);
                            paint.setAntiAlias(true);
                            canvas.drawCircle(f3, f5, f4, paint);
                        }
                        this.mU.close();
                        canvas.drawPath(this.mU, bgb());
                        this.mU.reset();
                    }
                    break;
                case 1:
                    canvas.drawCircle((float) this.qhq.x, (float) this.qhq.y, (float) this.qhp, bga());
                    for (height = 1; height < this.qhf; height++) {
                        canvas.drawCircle((float) this.qhq.x, (float) this.qhq.y, ((float) this.qhp) * ((((float) height) * 1.0f) / ((float) this.qhf)), bgb());
                    }
                    break;
            }
        }
        if (this.qhs != null && this.qhi.qgE) {
            if (this.qhs.length != this.qhe) {
                throw new RuntimeException("Labels array length not matches longitude lines number.");
            }
            int i3 = 0;
            while (i3 < this.qhe) {
                CharSequence charSequence = this.qhs[i3];
                if (!charSequence.equals(null)) {
                    float f6;
                    float f7;
                    if (i3 == 0 || i3 == (this.qhe >>> 1)) {
                        f6 = 0.5f;
                    } else if (i3 <= 0 || i3 >= (this.qhe >>> 1)) {
                        f6 = 1.0f;
                    } else {
                        f6 = 0.0f;
                    }
                    if (i3 == 0) {
                        f7 = this.qhi.qgM;
                    } else if (i3 == (this.qhe >>> 1)) {
                        f7 = -this.qhi.qgM;
                    } else {
                        f7 = 0.0f;
                    }
                    TextPaint textPaint = new TextPaint();
                    textPaint.setColor(this.qhi.qgK);
                    textPaint.setTextSize(this.qhi.qgL);
                    StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, 1000, Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false);
                    f = (float) (((double) (((float) this.qhq.x) - (staticLayout.getLineWidth(0) * f6))) - (((double) (((float) this.qhp) + this.qhi.qgM)) * Math.sin(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.qhe)))));
                    f2 = (float) ((((double) (this.qhq.y - (staticLayout.getHeight() / 2))) - (((double) (((float) this.qhp) + this.qhi.qgM)) * Math.cos(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.qhe))))) - ((double) f7));
                    canvas.save();
                    canvas.translate(f, f2);
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
                i3++;
            }
        }
    }

    private Paint bfZ() {
        Paint paint = new Paint();
        paint.setColor(this.qhi.backgroundColor);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint bga() {
        Paint paint = new Paint();
        c cVar = this.qhi;
        paint.setColor(cVar.qgF == -1 ? cVar.qgG : cVar.qgF);
        paint.setStyle(Style.STROKE);
        cVar = this.qhi;
        paint.setStrokeWidth(cVar.qgJ == -1.0f ? cVar.qgI : cVar.qgJ);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint bgb() {
        Paint paint = new Paint();
        paint.setColor(this.qhi.qgG);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.qhi.qgI);
        paint.setAntiAlias(true);
        return paint;
    }

    public void setBackgroundColor(int i) {
        this.qhi.backgroundColor = i;
        invalidate();
    }
}
