package com.tencent.mm.plugin.shake.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public final class b implements i {
    private a ptr = null;
    private String thumburl = "";

    public b(a aVar) {
        this.ptr = aVar;
    }

    public b(String str) {
        this.thumburl = str;
    }

    public final String Nm() {
        if (this.ptr != null && this.ptr.field_thumburl != null) {
            return m.dl(this.ptr.field_thumburl, "@S");
        }
        if (this.thumburl != null) {
            return m.dl(this.thumburl, "@S");
        }
        return "";
    }

    public final String Nn() {
        if (this.ptr == null || this.ptr.field_thumburl == null) {
            return this.thumburl;
        }
        return this.ptr.field_thumburl;
    }

    public final String No() {
        return Nn() + "_tv";
    }

    public final String Np() {
        return Nn() + "_tv";
    }

    public final boolean Nq() {
        return false;
    }

    public final boolean Nr() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, i.a aVar, String str) {
        if (i.a.ihH == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TVImgGetStrategy", e, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Nt() {
    }

    public final void F(String str, boolean z) {
    }

    public final void a(i.a aVar, String str) {
    }

    public final Bitmap Ns() {
        if (ab.getContext() == null) {
            return null;
        }
        return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
    }

    public final com.tencent.mm.platformtools.i.b Nl() {
        return null;
    }
}
