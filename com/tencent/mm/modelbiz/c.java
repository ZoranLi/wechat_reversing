package com.tencent.mm.modelbiz;

import android.os.Looper;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.e;

public final class c extends i<b> implements e {
    public static final String[] gUx = new String[]{i.a(b.gTP, "BizEnterprise")};
    private com.tencent.mm.sdk.e.e gUz;
    private final k<a, a> hug = new k<a, a>(this) {
        final /* synthetic */ c huh;

        {
            this.huh = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((a) obj2);
        }
    };

    public interface a {

        public static class a {
            public int hui;
            public String huj;
            public b huk;
        }

        public enum b {
            ;

            static {
                hul = 1;
                hum = 2;
                hun = 3;
                huo = new int[]{hul, hum, hun};
            }
        }

        void a(a aVar);
    }

    public c(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, b.gTP, "BizEnterprise", null);
        this.gUz = eVar;
        eVar.eE("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        h.vH().gXC.a(1343, (e) this);
        h.vH().gXC.a(1228, (e) this);
    }

    public final void a(a aVar, Looper looper) {
        this.hug.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hug != null) {
            this.hug.remove(aVar);
        }
    }

    public final b hC(String str) {
        if (bg.mA(str)) {
            return null;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_userName = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        a(str, null);
        return null;
    }

    private b hD(String str) {
        b hC = hC(str);
        if (hC != null) {
            return hC;
        }
        hC = new b();
        hC.field_userName = str;
        hC.field_qyUin = 0;
        hC.field_userUin = 0;
        hC.field_userFlag = 0;
        hC.field_wwExposeTimes = 0;
        hC.field_wwMaxExposeTimes = 0;
        hC.field_wwUserVid = 0;
        hC.field_wwCorpId = 0;
        return hC;
    }

    public final int hE(String str) {
        b hC = hC(str);
        if (hC == null) {
            return 0;
        }
        return hC.field_qyUin;
    }

    public final boolean gR(String str) {
        boolean z = false;
        if (!bg.mA(str)) {
            com.tencent.mm.sdk.e.c bVar = new b();
            bVar.field_userName = str;
            z = super.a(bVar, "userName");
            if (z) {
                a aVar = new a();
                aVar.huj = str;
                aVar.hui = b.hum;
                aVar.huk = bVar;
                this.hug.by(aVar);
                this.hug.doNotify();
            }
        }
        return z;
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean z;
        int i;
        boolean b = super.b((com.tencent.mm.sdk.e.c) bVar);
        int i2 = b.hul;
        if (b) {
            int i3 = i2;
            z = b;
            i = i3;
        } else {
            b = super.a(bVar);
            z = b;
            i = b.hun;
        }
        if (!z) {
            return z;
        }
        a aVar = new a();
        aVar.huj = bVar.field_userName;
        aVar.hui = i;
        aVar.huk = bVar;
        this.hug.by(aVar);
        this.hug.doNotify();
        return z;
    }

    private boolean a(gy gyVar) {
        b hD = hD(gyVar.tkL);
        hD.field_userName = gyVar.tkL;
        hD.field_qyUin = gyVar.tkV;
        hD.field_userUin = gyVar.tkW;
        hD.field_wwMaxExposeTimes = gyVar.tkY;
        hD.field_wwUserVid = gyVar.tkZ;
        hD.field_wwCorpId = gyVar.tla;
        if (gyVar.tkZ == 0 && gyVar.tla == 0 && gyVar.tkV != 0) {
            hD.field_wwUserVid = (long) gyVar.tkW;
            hD.field_wwCorpId = (long) gyVar.tkV;
        }
        gyVar.tkX &= -9;
        hD.field_userFlag = gyVar.tkX | (hD.field_userFlag & 8);
        return a(hD);
    }

    public static boolean a(String str, e eVar) {
        if (bg.mA(str)) {
            return false;
        }
        int i;
        if (e.ib(str)) {
            i = 1;
        } else if (!e.ia(str)) {
            return false;
        } else {
            i = 2;
        }
        return h.vH().gXC.a(new q(str, i, eVar), 0);
    }

    public static v a(String str, boolean z, e eVar) {
        gy gyVar = new gy();
        gyVar.tkL = str;
        gyVar.tkX = z ? 1 : 0;
        gyVar.tkV = 0;
        com.tencent.mm.y.k vVar = new v(gyVar, eVar);
        return h.vH().gXC.a(vVar, 0) ? vVar : null;
    }

    public final void hF(String str) {
        b hD = hD(str);
        if (hD.field_wwExposeTimes < hD.field_wwMaxExposeTimes) {
            hD.field_wwExposeTimes++;
            a(hD);
        }
    }

    public static void a(v vVar) {
        h.vH().gXC.c(vVar);
        vVar.data = null;
    }

    public final boolean hG(String str) {
        b hC = hC(str);
        return (hC == null || (hC.field_userFlag & 1) == 0) ? false : true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        int i3 = -1;
        if (i == 0 && i2 == 0) {
            e eVar;
            if (kVar instanceof q) {
                q qVar = (q) kVar;
                vl vlVar = (qVar.gUA == null || qVar.gUA.hsk.hsr == null) ? null : (vl) qVar.gUA.hsk.hsr;
                if (vlVar != null && vlVar.tkR != null && vlVar.tkR.ret == 0 && vlVar.tCN != null) {
                    if (!a(vlVar.tCN)) {
                        i2 = -1;
                    }
                    eVar = (e) qVar.data;
                    if (eVar != null) {
                        eVar.a(i, i2, str, kVar);
                    }
                } else {
                    return;
                }
            }
            if (kVar instanceof v) {
                v vVar = (v) kVar;
                ayt com_tencent_mm_protocal_c_ayt = (vVar.gUA == null || vVar.gUA.hsk.hsr == null) ? null : (ayt) vVar.gUA.hsk.hsr;
                if (com_tencent_mm_protocal_c_ayt != null && com_tencent_mm_protocal_c_ayt.tkR != null && com_tencent_mm_protocal_c_ayt.tkR.ret == 0 && com_tencent_mm_protocal_c_ayt.tCN != null) {
                    if (a(com_tencent_mm_protocal_c_ayt.tCN)) {
                        i3 = i2;
                    }
                    eVar = (e) vVar.data;
                    if (eVar != null) {
                        eVar.a(i, i3, str, kVar);
                    }
                }
            }
        }
    }
}
