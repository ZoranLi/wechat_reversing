package com.tencent.mm.ah;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.h.AnonymousClass6;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.nu;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.d;
import java.util.HashMap;

public class n implements am {
    private static HashMap<Integer, c> gJr;
    private f hHI;
    private h hHJ;
    private b hHK;
    private i hHL = new i();
    private c hHM = null;
    private g hHN = new g();
    private a hHO = null;
    private o hHP = null;
    private com.tencent.mm.sdk.b.c hHQ = new com.tencent.mm.sdk.b.c<nu>(this) {
        final /* synthetic */ n hHU;

        {
            this.hHU = r2;
            this.usg = nu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ce ceVar = ((nu) bVar).fUZ.fCZ;
            h GQ = n.GQ();
            d aj = n.GS().aj(ceVar.field_msgId);
            aj.fM(0);
            n.GS().a(Long.valueOf(aj.hEY), aj);
            int i = aj.GB() ? 1 : 0;
            String m = n.GS().m(aj.hEZ, "", "");
            if (m == null || m.equals("") || !e.aO(m)) {
                w.e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
            } else {
                af.v(new AnonymousClass6(GQ, aj, i));
            }
            return false;
        }
    };
    private a hHR = null;
    private SFSContext hHS = null;
    private SFSContext hHT = null;

    private static synchronized n GP() {
        n nVar;
        synchronized (n.class) {
            nVar = (n) l.o(n.class);
        }
        return nVar;
    }

    public static h GQ() {
        if (GP().hHJ == null) {
            GP().hHJ = new h();
        }
        return GP().hHJ;
    }

    public static b GR() {
        h.vG().uQ();
        if (GP().hHK == null) {
            GP().hHK = new b();
        }
        return GP().hHK;
    }

    public static f GS() {
        h.vG().uQ();
        if (GP().hHI == null) {
            GP().hHI = new f(h.vI().gYg);
        }
        return GP().hHI;
    }

    public static c GT() {
        h.vG().uQ();
        if (GP().hHM == null) {
            GP().hHM = new c();
        }
        return GP().hHM;
    }

    public static a GU() {
        h.vG().uQ();
        if (GP().hHO == null) {
            GP().hHO = new a(Looper.getMainLooper());
        }
        return GP().hHO;
    }

    public static o GV() {
        h.vG().uQ();
        if (GP().hHP == null) {
            GP().hHP = new o();
        }
        return GP().hHP;
    }

    public static a GW() {
        h.vG().uQ();
        if (GP().hHR == null) {
            GP().hHR = a.Hd();
        }
        return GP().hHR;
    }

    public static SFSContext GX() {
        return null;
    }

    public final void onAccountRelease() {
        n GP = GP();
        if (GP.hHJ != null) {
            com.tencent.mm.y.e eVar = GP.hHJ;
            eVar.fBo = 0;
            h.vH().gXC.b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, eVar);
        }
        if (GP.hHO != null) {
            c.a aVar = GP.hHO;
            synchronized (aVar.hEt) {
                aVar.hEt.clear();
                aVar.hEu = 0;
                GT().a(aVar);
            }
            com.tencent.mm.sdk.b.a.urY.c(aVar.hEF);
            com.tencent.mm.sdk.b.a.urY.c(aVar.hEG);
        }
        if (GP.hHM != null) {
            com.tencent.mm.y.e eVar2 = GP.hHM;
            w.i("ModelImage.DownloadImgService", "on detach");
            w.i("ModelImage.DownloadImgService", "cancel all net scene");
            eVar2.hEP = true;
            eVar2.b(eVar2.hEN);
            while (eVar2.hEL.size() > 0) {
                eVar2.b((b) eVar2.hEL.get(0));
            }
            eVar2.Gw();
            h.vH().gXC.b((int) MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, eVar2);
        }
        if (GP.hHP != null) {
            o oVar = GP.hHP;
            w.i("MicroMsg.UrlImageCacheService", "detach");
            oVar.hHV.clear();
            oVar.hHX = true;
        }
        GY();
        d.c.aA(Integer.valueOf(3));
        d.c.aA(Integer.valueOf(23));
        com.tencent.mm.cache.a.a.a("local_cdn_img_cache", null);
        com.tencent.mm.sdk.b.a.urY.c(this.hHQ);
        if (GP.hHR != null) {
            GP.hHR.detach();
            GP.hHR = null;
        }
        if (GP.hHS != null) {
            GP.hHS.release();
            GP.hHS = null;
        }
        if (GP.hHT != null) {
            GP.hHT.release();
            GP.hHT = null;
        }
    }

    public static void GY() {
        f fVar = GP().hHI;
        if (fVar != null) {
            w.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", bg.bJZ());
            fVar.hFF.a(new f.a<String, Bitmap>(fVar) {
                final /* synthetic */ f hFS;

                {
                    this.hFS = r1;
                }
            });
        }
        a aVar = GP().hHR;
        if (aVar != null) {
            aVar.detach();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return f.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(3), this.hHN);
        d.c.a(Integer.valueOf(23), this.hHN);
        com.tencent.mm.cache.a.a.a("local_cdn_img_cache", this.hHL);
        com.tencent.mm.sdk.b.a.urY.b(this.hHQ);
    }

    public final void aN(boolean z) {
    }
}
