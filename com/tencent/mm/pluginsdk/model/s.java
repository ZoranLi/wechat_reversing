package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.s.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public final class s implements i {
    private boolean fKh;
    private long hYL = 0;
    private long hYM = 0;
    private String oCY;
    private boolean sCL;
    private int type;
    private String url;

    public static final class a {
        public int h;
        public int w;
        public int x;
        public int y;

        public final String toString() {
            return String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[]{Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w)});
        }
    }

    public s(String str, int i, String str2, boolean z) {
        this.url = str;
        this.type = i;
        this.oCY = str2;
        this.fKh = z;
    }

    public static String n(String str, int i, String str2) {
        if (!h.vG().uV()) {
            return "";
        }
        return String.format("%s/ReaderApp_%d%s_%s", new Object[]{b.xb(), Integer.valueOf(i), str2, g.n(str.getBytes())});
    }

    public final String Nm() {
        return n(this.url, this.type, this.oCY);
    }

    public final String Nn() {
        if (p.Ha()) {
            return p.jE(this.url);
        }
        return this.url;
    }

    public final String No() {
        return this.url;
    }

    public final String Np() {
        return this.url + this.oCY;
    }

    public final boolean Nq() {
        return false;
    }

    public final boolean Nr() {
        return this.fKh;
    }

    public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
        int i = 100;
        if (com.tencent.mm.platformtools.i.a.NET == aVar) {
            DisplayMetrics displayMetrics;
            int i2;
            String str2 = this.oCY;
            a aVar2 = new a();
            Context context = ab.getContext();
            if (context != null) {
                Resources resources = context.getResources();
                if (resources != null) {
                    displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics == null) {
                        if ("@T".equals(str2)) {
                            i = (int) (50.0f * displayMetrics.density);
                            i2 = i;
                        } else {
                            i2 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                            i = (int) (167.0f * displayMetrics.density);
                        }
                    } else if ("@T".equals(str2)) {
                        i2 = 100;
                    } else {
                        i2 = Integer.MAX_VALUE;
                        i = 334;
                    }
                    aVar2.w = i2;
                    aVar2.h = i;
                    w.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
                    bitmap = d.a(bitmap, aVar2.w, aVar2.h, true);
                    w.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", Nm());
                    d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
                }
            }
            displayMetrics = null;
            if (displayMetrics == null) {
                if ("@T".equals(str2)) {
                    i2 = 100;
                } else {
                    i2 = Integer.MAX_VALUE;
                    i = 334;
                }
            } else if ("@T".equals(str2)) {
                i = (int) (50.0f * displayMetrics.density);
                i2 = i;
            } else {
                i2 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                i = (int) (167.0f * displayMetrics.density);
            }
            aVar2.w = i2;
            aVar2.h = i;
            w.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
            bitmap = d.a(bitmap, aVar2.w, aVar2.h, true);
            try {
                w.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", Nm());
                d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", e, "", new Object[0]);
                w.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", this.url);
            }
        }
        return bitmap;
    }

    public final void Nt() {
        this.hYL = bg.Nz();
        if (this.sCL) {
            w.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
            com.tencent.mm.plugin.report.service.g.oUh.a(86, 0, 1, false);
        }
    }

    public final void F(String str, boolean z) {
        this.hYM = bg.Nz();
        Object obj = null;
        if (p.Ha() && !bg.mA(str) && p.jF(Nn()) && str.equals("image/webp")) {
            obj = 1;
        }
        if (!this.sCL) {
            return;
        }
        if (z) {
            long j = this.hYM - this.hYL;
            w.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", Long.valueOf(j));
            com.tencent.mm.plugin.report.service.g.oUh.a(86, 4, j, false);
            if (obj != null) {
                w.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
                com.tencent.mm.plugin.report.service.g.oUh.a(86, 17, j, false);
                com.tencent.mm.plugin.report.service.g.oUh.a(86, 13, 1, false);
                return;
            }
            return;
        }
        w.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        com.tencent.mm.plugin.report.service.g.oUh.a(86, 2, 1, false);
        if (obj != null) {
            w.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
            com.tencent.mm.plugin.report.service.g.oUh.a(86, 15, 1, false);
        }
    }

    public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        if (aVar == com.tencent.mm.platformtools.i.a.NET && this.sCL && p.Ha() && !bg.mA(str) && p.jF(Nn()) && str.equals("image/webp")) {
            w.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
            com.tencent.mm.plugin.report.service.g.oUh.a(86, 14, 1, false);
        }
    }

    public final Bitmap Ns() {
        return BitmapFactory.decodeResource(ab.getContext().getResources(), f.bhP);
    }

    public final i.b Nl() {
        return null;
    }
}
