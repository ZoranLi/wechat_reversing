package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.smtt.sdk.WebView;

public class a implements b {
    private LatLng a = null;
    private double b = 0.0d;
    private float c = 10.0f;
    private int d = WebView.NIGHT_MODE_COLOR;
    private int e = 0;
    private float f = 0.0f;
    private boolean g = true;
    private boolean h = false;
    private DashPathEffect i = null;
    private DashPathEffect j;
    private String k;
    private e l;
    private com.tencent.mapsdk.rastercore.d.a m;

    public a(e eVar, CircleOptions circleOptions) {
        this.l = eVar;
        this.m = eVar.e();
        this.k = getId();
        this.e = circleOptions.getFillColor();
        this.a = circleOptions.getCenter();
        this.g = circleOptions.isVisible();
        this.c = circleOptions.getStrokeWidth();
        this.f = circleOptions.getZIndex();
        this.d = circleOptions.getStrokeColor();
        this.b = circleOptions.getRadius();
        this.h = circleOptions.getStrokeDash();
        this.i = circleOptions.getStrokeDashPathEffect();
        this.j = new DashPathEffect(new float[]{this.c, this.c}, 0.0f);
    }

    public LatLng a() {
        return this.a;
    }

    public void a(double d) {
        this.b = d;
        this.l.a(false, false);
    }

    public void a(float f) {
        this.c = f;
        this.j = new DashPathEffect(new float[]{this.c, this.c}, 0.0f);
        this.l.a(false, false);
    }

    public void a(int i) {
        this.d = i;
        this.l.a(false, false);
    }

    public void a(DashPathEffect dashPathEffect) {
        this.i = dashPathEffect;
    }

    public void a(LatLng latLng) {
        this.a = latLng;
        this.l.a(false, false);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public double b() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
        this.l.a(false, false);
    }

    public boolean b(LatLng latLng) {
        return this.b >= com.tencent.mapsdk.rastercore.d.a.a(this.a, latLng);
    }

    public float c() {
        return this.c;
    }

    public boolean checkInBounds() {
        return true;
    }

    public int d() {
        return this.d;
    }

    public void destroy() {
        this.a = null;
    }

    public void draw(Canvas canvas) {
        if (a() != null && this.b > 0.0d && isVisible()) {
            float a = this.l.b().a(this.a.getLatitude(), (double) ((float) b()));
            PointF a2 = this.l.b().a(this.a);
            Paint paint = new Paint();
            paint.setColor(e());
            paint.setAntiAlias(true);
            paint.setStyle(Style.FILL);
            canvas.drawCircle(a2.x, a2.y, a, paint);
            if (!com.tencent.mapsdk.rastercore.f.a.a(c(), 0.0f)) {
                if (this.h) {
                    if (this.i == null) {
                        paint.setPathEffect(this.j);
                    } else {
                        paint.setPathEffect(this.i);
                    }
                }
                paint.setColor(d());
                paint.setStyle(Style.STROKE);
                paint.setStrokeWidth(c());
                canvas.drawCircle(a2.x, a2.y, a, paint);
            }
        }
    }

    public int e() {
        return this.e;
    }

    public boolean equalsRemote(b bVar) {
        return equals(bVar) || bVar.getId().equals(getId());
    }

    public boolean f() {
        return this.h;
    }

    public DashPathEffect g() {
        return this.i;
    }

    public String getId() {
        if (this.k == null) {
            this.k = com.tencent.mapsdk.rastercore.d.a.a("Circle");
        }
        return this.k;
    }

    public float getZIndex() {
        return this.f;
    }

    public int hashCodeRemote() {
        return 0;
    }

    public boolean isVisible() {
        return this.g;
    }

    public void remove() {
        this.m.b(getId());
    }

    public void setVisible(boolean z) {
        this.g = z;
        this.l.a(false, false);
    }

    public void setZIndex(float f) {
        this.f = f;
        this.m.c();
        this.l.a(false, false);
    }
}
