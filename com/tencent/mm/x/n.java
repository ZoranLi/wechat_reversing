package com.tencent.mm.x;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import java.util.HashMap;

public class n implements am {
    private static HashMap<Integer, c> gJr;
    private i hrS;
    private d hrT;
    private c hrU;
    private g hrV;
    private String hrW;
    private aj hrX = new aj(h.vL().nJF.getLooper(), new a(this) {
        final /* synthetic */ n hrY;

        {
            this.hrY = r1;
        }

        public final boolean oQ() {
            if (!h.vG().uV() || n.Bl() == null) {
                w.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(h.vG().uV()), n.Bl());
            } else {
                if (((Boolean) h.vI().vr().get(90113, Boolean.valueOf(false))).booleanValue()) {
                    n.BA();
                    n.BB();
                }
                h.vI().vr().set(90113, Boolean.valueOf(false));
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|upAssetsHandler";
        }
    }, false);

    public static n Bx() {
        return (n) l.o(n.class);
    }

    public static i Bm() {
        h.vG().uQ();
        if (Bx().hrS == null) {
            Bx().hrS = new i(h.vI().gYg);
        }
        return Bx().hrS;
    }

    public static d Bl() {
        h.vG().uQ();
        if (Bx().hrT == null) {
            Bx().hrT = new d();
        }
        return Bx().hrT;
    }

    public static g By() {
        h.vG().uQ();
        if (Bx().hrV == null) {
            Bx().hrV = new g(h.vI().gYg);
        }
        return Bx().hrV;
    }

    public static c Bz() {
        h.vG().uQ();
        if (Bx().hrU == null) {
            Bx().hrU = new c();
        }
        return Bx().hrU;
    }

    public final void onAccountRelease() {
        this.hrX.KH();
        if (Bx().hrT != null) {
            d.reset();
        }
        e eVar = Bx().hrU;
        if (eVar != null) {
            h.vd().b(123, eVar);
        }
        i iVar = Bx().hrS;
        if (iVar != null) {
            iVar.hrE.clear();
        }
        if (this.hrW != null) {
            FileOp.kc(this.hrW);
            this.hrW = null;
        }
    }

    public final void eD(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return i.gUx;
            }
        });
        gJr.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return g.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void aM(boolean z) {
        FileOp.kl(h.vI().gYf + "sfs");
        this.hrW = com.tencent.mm.plugin.g.a.ZW();
        FileOp.a(this.hrW, null, new Builder().setDBDirectory(h.vI().cachePath + "sfs").setStoragePath(b.xr()).setName("avatar"));
        if (z) {
            w.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            h.vI().vr().set(90113, Boolean.valueOf(true));
            try {
                String xL = m.xL();
                d Bl = Bl();
                d.s(xL, false);
                d.s(xL, true);
                Bl.c(xL, null);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SubCoreAvatar", e, "Failed to refresh avatar.", new Object[0]);
            }
        }
        this.hrX.v(10000, 10000);
    }

    static Context getContext() {
        return ab.getContext();
    }

    public static void BA() {
        try {
            Context context = ab.getContext();
            for (String str : d.hrb.keySet()) {
                int intValue;
                if (d.hrb.containsKey(str)) {
                    intValue = ((Integer) d.hrb.get(str)).intValue();
                } else {
                    intValue = 0;
                }
                if (intValue != 0) {
                    w.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    Bl().d(str, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), intValue));
                }
            }
        } catch (Throwable e) {
            w.e("MicroMsg.SubCoreAvatar", "exception:%s", bg.g(e));
        }
    }

    public final void aN(boolean z) {
        if (this.hrW != null) {
            FileOp.kc(this.hrW);
            this.hrW = com.tencent.mm.plugin.g.a.ZW();
            FileOp.a(this.hrW, null, new Builder().setDBDirectory(h.vI().cachePath + "sfs").setStoragePath(b.xr()).setName("avatar"));
        }
    }

    public static boolean BB() {
        if (bg.b((Boolean) h.vI().vr().get(59, null), false)) {
            return true;
        }
        boolean z;
        Bl();
        String r = d.r(m.xL(), false);
        if (FileOp.aO(r) || FileOp.aO(r + ".bm")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        r = m.xL();
        if (bg.mA(r)) {
            return false;
        }
        Bitmap hq = d.b.hq(b.xb() + "user_" + g.n(r.getBytes()) + ".png");
        if (hq == null || hq.isRecycled()) {
            return false;
        }
        return Bl().d(r, hq);
    }
}
