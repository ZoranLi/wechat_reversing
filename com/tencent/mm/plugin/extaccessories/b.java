package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.mf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.HashMap;

public final class b implements am {
    public String gYf;
    private a lrL;

    public static class a extends c<mf> {
        public a() {
            this.usg = mf.class.getName().hashCode();
        }

        private boolean a(mf mfVar) {
            if (mfVar instanceof mf) {
                w.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
                if (!(mfVar.fTw == null || mfVar.fTw.fTy == null || mfVar.fTw.fTx == null)) {
                    try {
                        new SlookWritingBuddy(mfVar.fTw.fTy).setImageWritingListener(new SubCoreExtAccessories$RegistSpenBuddyEventListener$1(this, mfVar));
                    } catch (Exception e) {
                        w.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[]{e.getMessage()});
                    }
                }
                return true;
            }
            w.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
            return false;
        }
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
        ap.yY();
        this.gYf = com.tencent.mm.u.c.xv();
        File file = new File(this.gYf);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.gYf + "image/spen/");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void aM(boolean z) {
        w.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
        if (this.lrL == null) {
            this.lrL = new a();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.lrL);
        ap.vL().e(new Runnable(this) {
            final /* synthetic */ b lrM;

            {
                this.lrM = r1;
            }

            public final void run() {
                if (ap.zb() && !bg.mA(this.lrM.gYf)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    bg.d(this.lrM.gYf + "image/spen/", "spen_", 259200000);
                    w.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
        }, 5000);
    }

    public final void onAccountRelease() {
        w.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
        if (this.lrL != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.lrL);
        }
    }
}
