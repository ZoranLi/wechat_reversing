package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.tencentmap.mapsdk.map.MapView;
import java.util.ArrayList;
import java.util.List;

public final class d extends e {
    private LatLng[] jxR;
    public double[] jxS = new double[1];
    private double jxT;
    private boolean jxU;
    private AnimatorSet jxV;
    public g jxW = new g();

    public d(Marker marker, MapView mapView, long j, LatLng[] latLngArr, boolean z) {
        int i;
        super(marker, j);
        this.jxR = latLngArr;
        mapView.getProjection();
        for (i = 0; i <= 0; i++) {
            this.jxS[0] = a.a(latLngArr[0], latLngArr[1]);
            this.jxT += this.jxS[0];
        }
        List arrayList = new ArrayList();
        for (i = 0; i <= 0; i++) {
            arrayList.add(iY(0));
        }
        this.jyc.playSequentially(arrayList);
        this.jxU = z;
        if (z) {
            ZA();
        }
    }

    protected final ValueAnimator iY(int i) {
        final f c = this.jxW.c(this.jxR[0]);
        final f c2 = this.jxW.c(this.jxR[1]);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((((double) this.mDuration) * this.jxS[0]) / this.jxT));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues(new float[]{(float) this.jxS[0]});
        valueAnimator.addUpdateListener(new AnimatorUpdateListener(this, 0) {
            final /* synthetic */ d jya;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.equals(c2)) {
                    double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
                    double d = c.x + (((c2.x - c.x) * parseDouble) / this.jya.jxS[0]);
                    double d2 = c.y + ((parseDouble * (c2.y - c.y)) / this.jya.jxS[0]);
                    Marker marker = (Marker) this.jya.jyb;
                    g gVar = this.jya.jxW;
                    f fVar = new f(d, d2);
                    marker.setPosition(new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (fVar.y / gVar.jye))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((fVar.x / gVar.jye) - 0.5d) * 360.0d));
                }
            }
        });
        return valueAnimator;
    }

    private void ZA() {
        this.jxV = new AnimatorSet();
        List arrayList = new ArrayList();
        int i = 1;
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (i < this.jxR.length) {
            float f2;
            int i4;
            int i5;
            if (this.jxR[i2].equals(this.jxR[i])) {
                f2 = f;
                i4 = i2;
                i5 = i3;
            } else {
                long j;
                long j2;
                f c = this.jxW.c(this.jxR[i3]);
                f c2 = this.jxW.c(this.jxR[i2]);
                f c3 = this.jxW.c(this.jxR[i]);
                float b = (float) b(c2.x - c.x, c.y - c2.y, c3.x - c2.x, c2.y - c3.y);
                if (b == Float.NaN) {
                    b = 0.0f;
                }
                if (arrayList.size() == 0) {
                    f = ((Marker) this.jyb).getRotation();
                    b = (float) b(0.0d, 1.0d, c3.x - c2.x, c2.y - c3.y);
                    j = 0;
                    j2 = 0;
                } else {
                    j2 = (long) (((((((double) Math.abs(b)) * 3.141592653589793d) * 2.0d) / 180.0d) * ((double) this.mDuration)) / this.jxT);
                    j = bA(i3, i2) - (j2 / 2);
                }
                f2 = f + b;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
                ofFloat.setDuration(j2);
                ofFloat.setStartDelay(j);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ d jya;

                    {
                        this.jya = r1;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((Marker) this.jya.jyb).setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
                    }
                });
                arrayList.add(ofFloat);
                i4 = i;
                i5 = i2;
            }
            i++;
            f = f2;
            i2 = i4;
            i3 = i5;
        }
        this.jxV.playSequentially(arrayList);
    }

    private static double b(double d, double d2, double d3, double d4) {
        double acos = (Math.acos(((d * d3) + (d2 * d4)) / (Math.sqrt((d * d) + (d2 * d2)) * Math.sqrt((d3 * d3) + (d4 * d4)))) * 180.0d) / 3.141592653589793d;
        if ((d * d4) - (d2 * d3) > 0.0d) {
            acos = -acos;
        }
        return (double) ((float) acos);
    }

    private long bA(int i, int i2) {
        double d = 0.0d;
        while (i < i2) {
            d += this.jxS[i];
            i++;
        }
        return (long) ((d * ((double) this.mDuration)) / this.jxT);
    }

    public final void ZB() {
        super.ZB();
        if (this.jxU && this.jxV != null) {
            this.jxV.start();
        }
    }
}
