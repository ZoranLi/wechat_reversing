package com.tencent.mapsdk.rastercore.tile;

import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;

final /* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[MapSource.values().length];

    static {
        try {
            a[MapSource.BING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[MapSource.TENCENT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[MapSource.SATELLITE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
