package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public final class o implements i {
    private String mPicUrl = null;

    public o(String str) {
        this.mPicUrl = str;
    }

    public final String Nm() {
        return c.aXW().dl(this.mPicUrl, "@S");
    }

    public final String Nn() {
        return this.mPicUrl;
    }

    public final String No() {
        return this.mPicUrl;
    }

    public final String Np() {
        return this.mPicUrl;
    }

    public final boolean Nq() {
        return false;
    }

    public final boolean Nr() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.ihH == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", e, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Nt() {
    }

    public final void F(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final Bitmap Ns() {
        if (ab.getContext() == null) {
            return null;
        }
        return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
    }

    public final b Nl() {
        return null;
    }
}
