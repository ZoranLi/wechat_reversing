package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ht;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends com.tencent.mm.sdk.b.c<ht> implements com.tencent.mm.sdk.f.c {
    private static final String hJz = (e.hgq + "_temp.hp");
    private a mLh = null;

    public c() {
        com.tencent.mm.sdk.f.e.a(this);
        this.usg = ht.class.getName().hashCode();
    }

    public static void yn(String str) {
        w.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[]{str});
        d.yo(str);
    }

    public final void x(Runnable runnable) {
        if (runnable == this.mLh) {
            w.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[]{this.mLh.url, this.mLh.ihX, Boolean.valueOf(this.mLh.hrm)});
            if (this.mLh.hrm) {
                b.nZ(1);
            } else {
                b.nY(1);
                yn(this.mLh.ihX);
            }
            this.mLh = null;
        }
    }

    private boolean a(ht htVar) {
        if (this.mLh != null) {
            w.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
        } else if (1 == htVar.fNn.fEG) {
            d.aDl();
        } else if (htVar.fNn.fNs != null) {
            yn(htVar.fNn.fNs);
        } else {
            b.nX(1);
            if (htVar.fNn.fNq != null) {
                try {
                    byte[] decode = Base64.decode(htVar.fNn.fNq, 0);
                    htVar.fNn.fNq = new String(decode);
                } catch (Error e) {
                }
            }
            if (!bg.mA(htVar.fNn.fNq) && !bg.mA(htVar.fNn.fNr)) {
                w.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[]{htVar.fNn.fNq, htVar.fNn.fNr});
                this.mLh = new a(htVar.fNn.fNq, hJz, htVar.fNn.fNr);
            } else if (!bg.mA(htVar.fNn.fNo)) {
                if (bg.mA(htVar.fNn.fNp)) {
                }
            }
            com.tencent.mm.sdk.f.e.post(this.mLh, "hp_apply_download");
        }
        return false;
    }
}
