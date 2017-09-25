package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.c;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    public final Tile getTile(int i, int i2, int i3, MapSource mapSource, Object... objArr) {
        URL tileUrl = getTileUrl(i, i2, i3, objArr);
        return tileUrl == null ? null : new Tile(i, i2, i3, c.a(tileUrl));
    }

    public abstract URL getTileUrl(int i, int i2, int i3, Object... objArr);
}
