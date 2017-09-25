package com.tencent.mapsdk.raster.model;

import android.os.RemoteException;
import com.tencent.mapsdk.rastercore.tile.a.b;

public final class GroundOverlay implements IOverlay {
    private b iGroundOverlayDelegate$14ec2531;

    public GroundOverlay(b bVar) {
        this.iGroundOverlayDelegate$14ec2531 = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GroundOverlay) {
            try {
                throw new RemoteException();
            } catch (RemoteException e) {
            }
        }
        return false;
    }

    public final float getBearing() {
        return this.iGroundOverlayDelegate$14ec2531.e();
    }

    protected final LatLngBounds getBounds() {
        return this.iGroundOverlayDelegate$14ec2531.d();
    }

    protected final float getHeight() {
        return this.iGroundOverlayDelegate$14ec2531.c();
    }

    public final String getId() {
        return this.iGroundOverlayDelegate$14ec2531.getId();
    }

    protected final LatLng getPosition() {
        return this.iGroundOverlayDelegate$14ec2531.a();
    }

    protected final float getTransparency() {
        return this.iGroundOverlayDelegate$14ec2531.f();
    }

    protected final float getWidth() {
        return this.iGroundOverlayDelegate$14ec2531.b();
    }

    public final float getZIndex() {
        return this.iGroundOverlayDelegate$14ec2531.getZIndex();
    }

    public final int hashCode() {
        return this.iGroundOverlayDelegate$14ec2531.hashCode();
    }

    public final boolean isVisible() {
        return this.iGroundOverlayDelegate$14ec2531.isVisible();
    }

    public final void remove() {
        this.iGroundOverlayDelegate$14ec2531.remove();
    }

    public final void setAnchor(float f, float f2) {
        this.iGroundOverlayDelegate$14ec2531.b(f, f2);
    }

    public final void setBearing(float f) {
        this.iGroundOverlayDelegate$14ec2531.b(f);
    }

    protected final void setDimensions(float f) {
        this.iGroundOverlayDelegate$14ec2531.a(f);
    }

    protected final void setDimensions(float f, float f2) {
        this.iGroundOverlayDelegate$14ec2531.a(f, f2);
    }

    protected final void setImage(BitmapDescriptor bitmapDescriptor) {
        this.iGroundOverlayDelegate$14ec2531.a(bitmapDescriptor);
    }

    protected final void setPosition(LatLng latLng) {
        this.iGroundOverlayDelegate$14ec2531.a(latLng);
    }

    protected final void setPositionFromBounds(LatLngBounds latLngBounds) {
        this.iGroundOverlayDelegate$14ec2531.a(latLngBounds);
    }

    protected final void setTransparency(float f) {
        this.iGroundOverlayDelegate$14ec2531.c(f);
    }

    public final void setVisible(boolean z) {
        this.iGroundOverlayDelegate$14ec2531.setVisible(z);
    }

    public final void setZIndex(float f) {
        this.iGroundOverlayDelegate$14ec2531.setZIndex(f);
    }
}
