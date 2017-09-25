package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.e;

public final class f {
    private e mapContext;
    public c xbo;

    public f(e eVar) {
        this.mapContext = eVar;
        this.xbo = eVar.b();
    }

    private LatLng f(Point point) {
        return this.xbo.a(point.x, point.y);
    }

    public final VisibleRegion cgd() {
        int width = this.mapContext.c().getWidth();
        int height = this.mapContext.c().getHeight();
        LatLng f = f(new Point(0, 0));
        LatLng f2 = f(new Point(width, 0));
        LatLng f3 = f(new Point(0, height));
        LatLng f4 = f(new Point(width, height));
        return new VisibleRegion(f3, f4, f, f2, LatLngBounds.builder().include(f3).include(f4).include(f).include(f2).build());
    }
}
