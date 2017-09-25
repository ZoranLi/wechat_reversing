package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import java.util.Map.Entry;
import java.util.Set;

public class RadarDataLayer extends DataLayerView {
    public static final Point qhj = new Point(0, 0);
    private Path mU = new Path();
    private int qhe = 4;
    private float qhh = 1.0f;
    private a qhk;
    private a qhl;
    private b qhm = new b();
    private ValueAnimator qhn;
    private boolean qho = true;
    private int qhp = 80;
    private Point qhq = qhj;

    public RadarDataLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bfY();
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bfY();
    }

    public RadarDataLayer(Context context, float f, a aVar) {
        super(context);
        this.qhh = f;
        this.qhm = aVar.qgr;
        this.qhe = aVar.size();
        this.qhk = aVar;
        TimeInterpolator timeInterpolator = aVar.qgs;
        long j = aVar.duration;
        if (j > 0) {
            this.qhn = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.qhl = new a();
            this.qhn.setDuration(j);
            this.qhn.setInterpolator(timeInterpolator);
            this.qhn.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ RadarDataLayer qhr;

                {
                    this.qhr = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (Entry entry : this.qhr.qhk.entrySet()) {
                        this.qhr.qhl.put(entry.getKey(), Float.valueOf(((Float) entry.getValue()).floatValue() * floatValue));
                        this.qhr.invalidate();
                    }
                }
            });
        }
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

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.qhp = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.qhq.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.qhk == null) {
            throw new RuntimeException("Error: NullPointerException at data.");
        } else if (this.qhk != null) {
            Set entrySet;
            if (this.qhl == null) {
                entrySet = this.qhk.entrySet();
            } else {
                entrySet = this.qhl.entrySet();
            }
            int i = 0;
            for (Entry entry : r0) {
                float floatValue = (float) (((double) this.qhq.x) - (((double) ((((Float) entry.getValue()).floatValue() / this.qhh) * ((float) this.qhp))) * Math.sin(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.qhe)))));
                float floatValue2 = (float) (((double) this.qhq.y) - (((double) ((((Float) entry.getValue()).floatValue() / this.qhh) * ((float) this.qhp))) * Math.cos(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.qhe)))));
                if (i == 0) {
                    this.mU.moveTo(floatValue, floatValue2);
                } else {
                    this.mU.lineTo(floatValue, floatValue2);
                }
                if (this.qho) {
                    float f = (float) this.qhm.qgz;
                    Paint paint = new Paint();
                    paint.setColor(this.qhm.qgy);
                    canvas.drawCircle(floatValue, floatValue2, f, paint);
                }
                i++;
            }
            this.mU.close();
            Path path = this.mU;
            Paint paint2 = new Paint();
            b bVar = this.qhm;
            paint2.setColor(bVar.qgw == -1 ? bVar.qgu : bVar.qgw);
            paint2.setStyle(Style.FILL);
            paint2.setAntiAlias(true);
            paint2.setAlpha(this.qhm.qgx);
            canvas.drawPath(path, paint2);
            Path path2 = this.mU;
            Paint paint3 = new Paint();
            paint3.setColor(this.qhm.qgu);
            paint3.setStyle(Style.STROKE);
            paint3.setStrokeWidth(this.qhm.qgv);
            paint3.setAntiAlias(true);
            canvas.drawPath(path2, paint3);
            this.mU.reset();
        }
    }
}
