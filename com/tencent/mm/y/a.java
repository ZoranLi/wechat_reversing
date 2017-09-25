package com.tencent.mm.y;

import com.tencent.mm.bn.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.g;
import junit.framework.Assert;

public class a<_Resp extends avp> {
    public b gUA;
    public b<_Resp> hrZ = new b(this);
    private e<a<_Resp>> hsa;

    public static class a<T extends avp> {
        public int errCode;
        public int errType;
        public k fGg;
        public String fPf;
        public T fYb;
        public a hsc;

        public static <T extends avp> a<T> a(int i, int i2, String str, T t, k kVar, a aVar) {
            a<T> aVar2 = new a();
            aVar2.errType = i;
            aVar2.errCode = i2;
            aVar2.fPf = str;
            aVar2.fYb = t;
            aVar2.fGg = kVar;
            aVar2.hsc = aVar;
            if (aVar != null) {
                aVar.a(i, i2, str, t, kVar);
            }
            return aVar2;
        }
    }

    private static class b<_Resp extends avp> extends k {
        public e gWW = null;
        public final k hsd = this;
        public b hse;
        public com.tencent.mm.vending.g.b hsf;
        public a hsg;
        private j hsh = new j(this) {
            final /* synthetic */ b hsi;

            {
                this.hsi = r1;
            }

            public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
                com.tencent.mm.vending.g.b bVar = this.hsi.hsf;
                Object[] objArr = new Object[1];
                objArr[0] = a.a(i2, i3, str, (avp) this.hsi.hse.hsk.hsr, this.hsi, this.hsi.hsg);
                g.a(bVar, objArr);
                this.hsi.gWW.a(i2, i3, str, this.hsi.hsd);
                w.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[]{Integer.valueOf(this.hsi.hsd.hashCode()), Integer.valueOf(this.hsi.getType()), Long.valueOf(bg.Nz() - this.hsi.mStartTime), Integer.valueOf(i2), Integer.valueOf(i3), str});
            }
        };
        public final long mStartTime = bg.Nz();

        public b(a aVar) {
            this.hsg = aVar;
        }

        protected final int ub() {
            return 1;
        }

        public final int getType() {
            return this.hse.hsl;
        }

        public final int a(com.tencent.mm.network.e eVar, e eVar2) {
            this.gWW = eVar2;
            int a = a(eVar, this.hse, this.hsh);
            w.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[]{Integer.valueOf(this.hsd.hashCode()), Integer.valueOf(this.hse.hsl), Integer.valueOf(a), Long.valueOf(bg.Nz() - this.mStartTime)});
            if (a < 0) {
                g.a(this.hsf, new Object[]{a.a(3, -1, "", (avp) this.hse.hsk.hsr, this, this.hsg)});
            }
            return a;
        }
    }

    public final synchronized e<a<_Resp>> BC() {
        Assert.assertNotNull("You should set a CommReqResp!", this.gUA);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", u.Cx());
        if (this.hsa == null) {
            this.hsa = new e().b(new com.tencent.mm.vending.g.c.a<a<_Resp>>(this) {
                final /* synthetic */ a hsb;

                {
                    this.hsb = r1;
                }

                public final /* synthetic */ Object call() {
                    com.tencent.mm.vending.g.b cbK = g.cbK();
                    this.hsb.hrZ.hsf = cbK;
                    this.hsb.hrZ.hse = this.hsb.gUA;
                    if (!u.htQ.ve().a(this.hsb.hrZ, 0)) {
                        w.e("MicroMsg.Cgi", "RunCgi doScene failed!");
                        g.a(cbK);
                    }
                    return null;
                }
            });
        }
        return this.hsa;
    }

    public void a(int i, int i2, String str, _Resp _Resp, k kVar) {
    }
}
