package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;

public final class c implements i {
    private b rPe = new b(this) {
        final /* synthetic */ c rPf;

        {
            this.rPf = r1;
        }

        public final Bitmap ms(String str) {
            return d.decodeFile(str, null);
        }
    };
    private String url;

    public c(String str) {
        this.url = str;
    }

    public final String Nm() {
        return com.tencent.mm.plugin.wallet_core.c.b.CA(this.url);
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
            if (bitmap == null || bitmap.getNinePatchChunk() == null) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.c.b.CA(this.url), false);
                } catch (IOException e) {
                    try {
                        File file = new File(com.tencent.mm.plugin.wallet_core.c.b.buI());
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        w.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                        d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.c.b.CA(this.url), false);
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
                        w.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                    }
                }
            } else {
                w.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
                FileOp.p(str, com.tencent.mm.plugin.wallet_core.c.b.CA(this.url));
                return bitmap;
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

    public final b Nl() {
        return this.rPe;
    }
}
