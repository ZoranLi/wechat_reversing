package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.c.h;
import com.tencent.mapsdk.rastercore.d.a;

public final class b {
    public static a a(LatLngBounds latLngBounds, int i) {
        return new a(a.a(latLngBounds, 0, 0, i));
    }

    public static a az(float f) {
        com.tencent.mapsdk.rastercore.c.a hVar = new h();
        hVar.a(f);
        return new a(hVar);
    }
}
