package com.tencent.mm.plugin.game.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class ak implements i {
    protected String mPicUrl;

    public ak(String str) {
        this.mPicUrl = str;
        File file = new File(e.gSB);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final b Nl() {
        return null;
    }

    public final String Nm() {
        return e.gSB + g.n(this.mPicUrl.getBytes());
    }

    public final String Nn() {
        return this.mPicUrl;
    }

    public final String No() {
        return this.mPicUrl.hashCode();
    }

    public final String Np() {
        return this.mPicUrl.hashCode();
    }

    public final boolean Nq() {
        return true;
    }

    public final boolean Nr() {
        return false;
    }

    public final Bitmap Ns() {
        return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.ihI != aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GetGamePicStrategy", e, "", new Object[0]);
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
}
