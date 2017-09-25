package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.rastercore.e.a;

public final class Circle implements IOverlay {
    private final a iCircleDel;

    public Circle(a aVar) {
        this.iCircleDel = aVar;
    }

    public final boolean contains(LatLng latLng) {
        return this.iCircleDel.b(latLng);
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof Circle) ? false : this.iCircleDel.equalsRemote(((Circle) obj).iCircleDel);
    }

    public final LatLng getCenter() {
        return this.iCircleDel.a();
    }

    public final int getFillColor() {
        return this.iCircleDel.e();
    }

    public final String getId() {
        return this.iCircleDel.getId();
    }

    public final double getRadius() {
        return this.iCircleDel.b();
    }

    public final int getStrokeColor() {
        return this.iCircleDel.d();
    }

    public final boolean getStrokeDash() {
        return this.iCircleDel.f();
    }

    public final DashPathEffect getStrokeDashPathEffect() {
        return this.iCircleDel.g();
    }

    public final float getStrokeWidth() {
        return this.iCircleDel.c();
    }

    public final float getZIndex() {
        return this.iCircleDel.getZIndex();
    }

    public final int hashCode() {
        return this.iCircleDel.hashCodeRemote();
    }

    public final boolean isVisible() {
        return this.iCircleDel.isVisible();
    }

    public final void remove() {
        this.iCircleDel.remove();
    }

    public final void setCenter(LatLng latLng) {
        this.iCircleDel.a(latLng);
    }

    public final void setFillColor(int i) {
        this.iCircleDel.b(i);
    }

    public final void setRadius(double d) {
        this.iCircleDel.a(d);
    }

    public final void setStrokeColor(int i) {
        this.iCircleDel.a(i);
    }

    public final void setStrokeDash(boolean z) {
        this.iCircleDel.a(z);
    }

    public final void setStrokeWidth(float f) {
        this.iCircleDel.a(f);
    }

    public final void setVisible(boolean z) {
        this.iCircleDel.setVisible(z);
    }

    public final void setZIndex(float f) {
        this.iCircleDel.setZIndex(f);
    }

    public final void strokeDashPathEffect(DashPathEffect dashPathEffect) {
        this.iCircleDel.a(dashPathEffect);
    }
}
