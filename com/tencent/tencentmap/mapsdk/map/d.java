package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.rastercore.d.a;

public final class d {
    private boolean xbj = true;
    public MapView xbk;

    public d(MapView mapView) {
        this.xbk = mapView;
    }

    public final void b(GeoPoint geoPoint) {
        this.xbk.getMap().a(new a(a.a(CameraPosition.builder().target(com.tencent.mapsdk.rastercore.f.a.a(geoPoint)).build())), 1000);
    }

    public final void c(GeoPoint geoPoint) {
        g map = this.xbk.getMap();
        float zoomLevel = (float) map.getZoomLevel();
        map.a(new a(a.a(CameraPosition.builder().target(com.tencent.mapsdk.rastercore.f.a.a(geoPoint)).zoom(zoomLevel).build())), 0);
    }

    public final void setZoom(int i) {
        this.xbk.getMap().a(b.az((float) i), 0);
    }
}
