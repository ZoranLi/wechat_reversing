package com.tencent.mm.plugin.appbrand.widget.d;

import com.tencent.mapsdk.raster.model.LatLng;

public final class g {
    public static double jyd = 6378137.0d;
    final double jye = (6.283185307179586d * jyd);

    public final f c(LatLng latLng) {
        double longitude = (latLng.getLongitude() / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.getLatitude()));
        return new f(longitude * this.jye, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.jye);
    }
}
