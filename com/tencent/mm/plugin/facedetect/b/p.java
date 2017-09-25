package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.afd;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.l;

public abstract class p extends l implements j {
    public static String lvg = null;
    protected e gUD = null;

    abstract void b(int i, int i2, String str, com.tencent.mm.network.p pVar);

    protected abstract anj f(com.tencent.mm.network.p pVar);

    abstract int g(com.tencent.mm.network.e eVar);

    abstract void vE(String str);

    protected static String Fu() {
        return lvg;
    }

    public static void vF(String str) {
        lvg = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (bg.mA(lvg)) {
            return getType();
        }
        w.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[]{lvg});
        vE(lvg);
        return g(eVar);
    }

    public final hr c(com.tencent.mm.network.p pVar) {
        anj f = f(pVar);
        if (f != null) {
            return f.tjM;
        }
        return null;
    }

    public final anh d(com.tencent.mm.network.p pVar) {
        anj f = f(pVar);
        if (f != null) {
            return f.tjN;
        }
        return null;
    }

    public final afd e(com.tencent.mm.network.p pVar) {
        anj f = f(pVar);
        if (f != null) {
            return f.tjL;
        }
        return null;
    }

    public final void BO() {
        if (this.gUD != null) {
            this.gUD.a(3, -1, "", this);
        }
    }

    public final e BP() {
        return this.gUD;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.network.p pVar) {
        w.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == -102) {
            final int i3 = pVar.BG().sZA.ver;
            w.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i3)});
            h.vL().D(new Runnable(this) {
                final /* synthetic */ p lvh;

                public final void run() {
                    new m().a(this.lvh.hsD, new e(this) {
                        final /* synthetic */ AnonymousClass1 lvi;

                        {
                            this.lvi = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                            if (i == 0 && i2 == 0) {
                                this.lvi.lvh.g(this.lvi.lvh.hsD);
                                return;
                            }
                            w.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                            p.lvg = null;
                            this.lvi.lvh.vE(p.Fu());
                            this.lvi.lvh.gUD.a(i, i2, "", this.lvi.lvh);
                        }
                    });
                }
            });
            return;
        }
        b(i, i2, str, pVar);
    }
}
