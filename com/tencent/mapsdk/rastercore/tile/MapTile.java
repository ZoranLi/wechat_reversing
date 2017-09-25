package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.e.a.f;
import com.tencent.mapsdk.rastercore.tile.a.b;
import com.tencent.mapsdk.rastercore.tile.b.c;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MapTile {
    private e a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private PointF f;
    private MapSource g = MapSource.TENCENT;
    private List<a> h = new ArrayList();
    private List<a> i = new ArrayList();

    public enum MapSource {
        TENCENT,
        BING,
        SATELLITE,
        TRAFFIC,
        CUSTOMER
    }

    public MapTile(e eVar, int i, int i2, int i3, int i4, MapSource mapSource, List<f> list) {
        this.a = eVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.g = mapSource;
        a aVar = new a(c.a(this.a, mapSource), this.b, this.c, this.d, this.e, mapSource, b.a(mapSource, this.e));
        if (this.h.size() > 0) {
            this.h.set(0, aVar);
            this.i.set(0, aVar);
        } else {
            this.h.add(aVar);
            this.i.add(aVar);
        }
        if (list != null && !list.isEmpty()) {
            for (f a : list) {
                a(a);
            }
        }
    }

    public final int a() {
        return this.d;
    }

    public final void a(PointF pointF) {
        this.f = pointF;
    }

    public final void a(f fVar) {
        this.h.size();
        a aVar = new a(fVar, this.b, this.c, this.d, this.e);
        this.h.add(aVar);
        this.i.add(aVar);
    }

    public final boolean a(Canvas canvas) {
        if (this.h == null || this.h.size() <= 0) {
            return true;
        }
        Collections.sort(this.i, a.k());
        canvas.save();
        canvas.translate(this.f.x, this.f.y);
        boolean z = true;
        for (a a : this.i) {
            z = a.a(canvas) & z;
        }
        canvas.restore();
        return z;
    }

    public final boolean a(List<a> list) {
        for (a a : list) {
            String a2 = a.a();
            if (a2 != null && a2.contains("BingGrid") && !a2.endsWith(e.u())) {
                return true;
            }
        }
        this.h.clear();
        this.h.addAll(list);
        this.i.clear();
        this.i.addAll(list);
        for (a a3 : this.h) {
            if (a3.f() == null) {
                return true;
            }
        }
        return false;
    }

    public final List<a> b() {
        return new ArrayList(this.h);
    }

    public final void b(f fVar) {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a(fVar)) {
                aVar.h();
                it.remove();
                return;
            }
        }
    }

    public final void c() {
        for (a h : this.h) {
            h.h();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapTile)) {
            return false;
        }
        MapTile mapTile = (MapTile) obj;
        return this.b == mapTile.b && this.c == mapTile.c && this.d == mapTile.d && this.e == mapTile.e;
    }

    public final int hashCode() {
        return ((this.b * 7) + (this.c * 11)) + (this.d * 13);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("MapTile(");
        stringBuilder.append(this.b);
        stringBuilder.append(",");
        stringBuilder.append(this.c);
        stringBuilder.append(",");
        stringBuilder.append(this.d);
        stringBuilder.append(",");
        stringBuilder.append(this.g);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
