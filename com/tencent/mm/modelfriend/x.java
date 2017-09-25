package com.tencent.mm.modelfriend;

import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;

public final class x extends k implements j {
    public e gUD = null;
    public final p htt = new a();

    public static class a extends i {
        private final com.tencent.mm.protocal.t.a hBK = new com.tencent.mm.protocal.t.a();
        private final b hBL = new b();

        protected final d zf() {
            return this.hBK;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hBL;
        }

        public final int getType() {
            return 429;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/getsuggestalias";
        }

        public final int BD() {
            return 1;
        }
    }

    public x(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        com.tencent.mm.protocal.t.a aVar = (com.tencent.mm.protocal.t.a) this.htt.BG();
        aVar.sZX.tHf = str;
        aVar.sZX.tHg = str2;
        aVar.sZX.jOp = str3;
        aVar.sZX.tHh = str4;
        aVar.sZX.tHi = str5;
        aVar.sZX.tHj = str6;
        aVar.sZX.tHk = i;
        aVar.sZX.leO = v.bIN();
        aVar.sZX.thC = ap.uY();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 429;
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.BG().sZA.ver;
            w.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ x hBI;

                public final void run() {
                    new m().a(this.hBI.hsD, new e(this) {
                        final /* synthetic */ AnonymousClass1 hBJ;

                        {
                            this.hBJ = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.hBJ.hBI.a(this.hBJ.hBI.hsD, this.hBJ.hBI.gUD);
                            } else {
                                this.hBJ.hBI.gUD.a(i, i2, "", this.hBJ.hBI);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final byte[] FI() {
        return n.a(((b) this.htt.zg()).sZY.tHl, new byte[0]);
    }

    public final String FJ() {
        return ((b) this.htt.zg()).sZY.tHi;
    }
}
