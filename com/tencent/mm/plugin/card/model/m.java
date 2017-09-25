package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;

public final class m implements i {
    public static final String kfw = (e.hgu + "card");
    public static final String kfx = (kfw + File.separator + SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
    private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
    private String mPicUrl = null;

    public m(String str) {
        this.mPicUrl = str;
    }

    public final b Nl() {
        return null;
    }

    public final String Nm() {
        return String.format("%s/%s", new Object[]{kfw, g.n(this.mPicUrl.getBytes())});
    }

    public static String sw(String str) {
        return String.format("%s/%s", new Object[]{kfw, g.n(str.getBytes())});
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
        return true;
    }

    public final boolean Nr() {
        return false;
    }

    public final Bitmap Ns() {
        w.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
            } catch (IOException e) {
                try {
                    File file = new File(Nm());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    w.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
                    d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", e2, "", new Object[0]);
                    w.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
                }
            }
        }
        w.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", aVar.toString());
        return bitmap;
    }

    public final void Nt() {
    }

    public final void F(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
