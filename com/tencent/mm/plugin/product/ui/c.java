package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;

public final class c implements i {
    private static final String kfw = (e.hgu + "wallet");
    private String url;

    public c(String str) {
        this.url = str;
    }

    public final b Nl() {
        return null;
    }

    public final String Nm() {
        return CA(this.url);
    }

    public final String Nn() {
        return this.url;
    }

    public final String No() {
        return this.url;
    }

    public final String Np() {
        return this.url;
    }

    public final boolean Nq() {
        return true;
    }

    public final boolean Nr() {
        return false;
    }

    public final Bitmap Ns() {
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.ihH == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, CA(this.url), false);
            } catch (IOException e) {
                try {
                    File file = new File(kfw);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    w.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                    d.a(bitmap, 100, CompressFormat.PNG, CA(this.url), false);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                    w.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                }
            }
        }
        w.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[]{aVar.toString()});
        return bitmap;
    }

    public final void Nt() {
    }

    public final void F(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public static String CA(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{kfw, g.n(str.getBytes())});
    }
}
