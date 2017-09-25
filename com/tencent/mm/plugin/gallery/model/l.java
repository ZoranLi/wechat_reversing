package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.model.g.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashSet;

public final class l {
    private int iLy = 3;
    HashSet<a> meV = new HashSet();
    public HashSet<b> meW = new HashSet();
    public g meX;
    public int meY = 1;

    public final void nc(int i) {
        this.meY = i;
        ayL();
    }

    private void ayL() {
        w.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[]{Integer.valueOf(this.meY)});
        switch (this.meY) {
            case 1:
                this.meX = new i();
                return;
            case 2:
                this.meX = new n();
                return;
            case 3:
                this.meX = new h();
                return;
            default:
                this.meX = new i();
                return;
        }
    }

    public final void nd(int i) {
        w.i("MicroMsg.MediaQueryService", "setQuerySource, %d, %s", new Object[]{Integer.valueOf(i), bg.bJZ()});
        this.iLy = i;
    }

    public final int ayM() {
        w.i("MicroMsg.MediaQueryService", "getQuerySource, %d, %s", new Object[]{Integer.valueOf(this.iLy), bg.bJZ()});
        return this.iLy;
    }

    public final int ayN() {
        w.i("MicroMsg.MediaQueryService", "getQueryType, %d, %s", new Object[]{Integer.valueOf(this.meY), bg.bJZ()});
        return this.meY;
    }

    public final void a(a aVar) {
        this.meV.add(aVar);
    }

    public final void b(a aVar) {
        this.meV.remove(aVar);
    }

    public final void ayO() {
        if (this.meX == null) {
            w.f("MicroMsg.MediaQueryService", "media query not init, init again");
            ayL();
        }
        c.ayl().u(new Runnable(this) {
            final /* synthetic */ l meZ;

            {
                this.meZ = r1;
            }

            public final void run() {
                ArrayList ayE = this.meZ.meX.ayE();
                l lVar = this.meZ;
                a[] aVarArr = new a[lVar.meV.size()];
                lVar.meV.toArray(aVarArr);
                for (a A : aVarArr) {
                    A.A(ayE);
                }
            }

            public final String toString() {
                return super.toString() + "|queryAlbums";
            }
        });
    }

    public final void e(String str, int i, long j) {
        if (this.meX == null) {
            w.f("MicroMsg.MediaQueryService", "media query not init, init again");
            ayL();
        }
        c.ayl().ayy().removeCallbacksAndMessages(null);
        this.meX.ayF();
        e ayl = c.ayl();
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        ayl.ayy().post(new Runnable(this) {
            final /* synthetic */ l meZ;

            public final void run() {
                this.meZ.meX.a(str2, i2, new c(this) {
                    final /* synthetic */ AnonymousClass2 mfb;

                    {
                        this.mfb = r1;
                    }

                    public final void a(ArrayList<MediaItem> arrayList, long j) {
                        l lVar = this.mfb.meZ;
                        b[] bVarArr = new b[lVar.meW.size()];
                        lVar.meW.toArray(bVarArr);
                        for (b a : bVarArr) {
                            a.a(arrayList, j);
                        }
                    }
                }, j2);
            }

            public final String toString() {
                return super.toString() + "|queryMediaInAlbums";
            }
        });
    }
}
