package com.tencent.tencentmap.mapsdk.map;

import android.view.View;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;

public final class g {
    public static b xbp;
    public com.tencent.mapsdk.rastercore.d.e mapContext;
    com.tencent.mapsdk.rastercore.d.a xbl;
    com.tencent.mapsdk.rastercore.d.c xbo;

    public interface a {
        View d(Marker marker);
    }

    public interface b {
        void collectErrorInfo(String str);
    }

    public interface c {
        void b(Marker marker);
    }

    public interface d {
        void TN();

        void TO();
    }

    public interface e {
        void TM();
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
        boolean c(Marker marker);
    }

    public interface i {
    }

    public interface j {
    }

    public g(com.tencent.mapsdk.rastercore.d.e eVar) {
        this.mapContext = eVar;
        this.xbl = eVar.e();
        this.xbo = eVar.b();
    }

    public final void a(a aVar) {
        a(aVar, 1000);
    }

    final void a(a aVar, long j) {
        if (!this.mapContext.f().k() || j < 0) {
            aVar.xbi.a(false);
        }
        aVar.xbi.a(null);
        aVar.xbi.a(j);
        this.mapContext.c().a(aVar.xbi);
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return new GroundOverlay(this.xbl.a(groundOverlayOptions));
    }

    public final LatLng getMapCenter() {
        return this.xbo.d().getTarget();
    }

    public final int getZoomLevel() {
        return (int) this.xbo.d().getZoom();
    }
}
