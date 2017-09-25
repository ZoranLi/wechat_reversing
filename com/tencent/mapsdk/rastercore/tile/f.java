package com.tencent.mapsdk.rastercore.tile;

import android.os.Handler;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.b.c;

public final class f {
    private boolean a = false;
    private com.tencent.mapsdk.rastercore.e.a.f b;
    public e c;
    public Handler d = new Handler();
    private a e;
    private float f = 0.0f;

    class a implements Runnable {
        private boolean a = true;
        private int b = 60000;
        private /* synthetic */ f c;

        public a(f fVar, int i) {
            this.c = fVar;
        }

        public final void a(boolean z) {
            this.a = false;
        }

        public final void run() {
            this.c.c.a(false, false);
            if (this.a) {
                this.c.d.postDelayed(this, (long) this.b);
            }
        }
    }

    public f(e eVar) {
        this.c = eVar;
    }

    public final void a(boolean z) {
        if (!z || !this.a || this.b == null) {
            if (z) {
                TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
                tileOverlayOptions.tileProvider(c.a(this.c, MapSource.TRAFFIC)).diskCacheEnabled(false).visible(true).zIndex(0.0f);
                this.b = this.c.g().a(tileOverlayOptions);
                this.e = new a(this, 60000);
                this.d.post(this.e);
            } else if (this.b != null) {
                this.b.b();
                this.b = null;
                this.e.a(false);
                this.d.removeCallbacks(this.e);
                this.e = null;
            } else {
                return;
            }
            this.a = z;
        }
    }

    public final boolean a() {
        return this.a;
    }
}
