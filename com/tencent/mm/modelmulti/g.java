package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class g extends k implements j {
    public e gUD;
    public final Queue<a> hDH = new LinkedList();
    f hGt = null;
    public boolean hKd = false;
    public com.tencent.mm.compatible.util.g.a hKg;
    private StringBuilder hKh = new StringBuilder();
    final ann hKr = new ann();
    public int hKs = 0;
    public boolean hKt = false;
    public int hKu = 0;
    public int hKv = 0;
    private final aj hqQ = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ g hKw;

        {
            this.hKw = r1;
        }

        public final boolean oQ() {
            float f = 1.0f;
            if (!h.vG().uV() || com.tencent.mm.kernel.a.uP()) {
                w.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
                return false;
            } else if (this.hKw.hKd) {
                w.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", Integer.valueOf(this.hKw.hashCode()));
                return false;
            } else if (this.hKw.hDH.isEmpty()) {
                w.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
                return false;
            } else {
                boolean z;
                w.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", Integer.valueOf(this.hKw.hashCode()), Long.valueOf(this.hKw.hKg.se()), Integer.valueOf(this.hKw.hDH.size()), Integer.valueOf(this.hKw.hKs), Boolean.valueOf(this.hKw.hKt), Integer.valueOf(this.hKw.hKv), Integer.valueOf(this.hKw.hKu));
                h.vJ();
                long cs = h.vI().gYg.cs(Thread.currentThread().getId());
                c cVar = new c();
                cVar.aX("NetSceneInit");
                int i = this.hKw.hKt ? 40 : 10;
                int i2 = 0;
                while (i2 < i) {
                    final a aVar = (a) this.hKw.hDH.peek();
                    if (aVar.hKA != Integer.MAX_VALUE) {
                        LinkedList linkedList = aVar.hKz.tSu;
                        if (linkedList != null && linkedList.size() > aVar.hDU) {
                            linkedList.size();
                            if (cVar.a((lu) linkedList.get(aVar.hDU), true)) {
                                aVar.hDU++;
                                g gVar = this.hKw;
                                gVar.hKv++;
                                i2++;
                            }
                        }
                        this.hKw.hDH.poll();
                        h.vJ();
                        h.vI().vr().set(8197, bg.bo(n.a(aVar.hKz.tSq)));
                        h.vJ();
                        h.vI().vr().set(8198, bg.bo(n.a(aVar.hKz.tSr)));
                        h.vJ();
                        h.vI().vr().set(16, Integer.valueOf(0));
                        h.vJ();
                        h.vI().vr().set(8196, Long.valueOf((long) aVar.hKz.tSs));
                        h.vJ();
                        h.vI().vr().jY(true);
                        z = true;
                        break;
                    }
                    boolean z2;
                    String str = "in Queue tail , resp should be null";
                    if (aVar.hKz == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Assert.assertTrue(str, z2);
                    h.vJ();
                    String str2 = (String) h.vI().vr().get(8198, null);
                    h.vJ();
                    h.vI().vr().set(8195, str2);
                    ab.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", str2).commit();
                    h.vJ();
                    h.vI().vr().set(8197, "");
                    h.vJ();
                    h.vI().vr().set(8198, "");
                    h.vJ();
                    h.vI().vr().set(15, Integer.valueOf(1));
                    h.vJ();
                    h.vI().vr().jY(true);
                    w.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", Integer.valueOf(this.hKw.hashCode()), Long.valueOf(this.hKw.hKg.se()), Integer.valueOf(this.hKw.hKs), Integer.valueOf(this.hKw.hKu), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                    h.vL().D(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 hKy;

                        public final void run() {
                            this.hKy.hKw.gUD.a(aVar.errType, aVar.errCode, aVar.fPf, this.hKy.hKw);
                        }
                    });
                    z = false;
                }
                z = true;
                cVar.aY("NetSceneInit");
                h.vJ();
                h.vI().gYg.aD(cs);
                k kVar = this.hKw;
                if (kVar.hGt == null) {
                    w.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
                } else {
                    int i3 = kVar.hKs > 50 ? 50 : kVar.hKs;
                    if (kVar.hKt) {
                        float f2 = ((float) kVar.hKv) / ((float) kVar.hKu);
                        if (f2 > 1.0f) {
                            f2 = 1.0f;
                        }
                        f = f2;
                        i = (int) ((((float) (100 - i3)) * f2) + ((float) i3));
                    } else {
                        i = i3;
                    }
                    w.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", Integer.valueOf(kVar.hKv), Integer.valueOf(kVar.hKu), Float.valueOf(f), Integer.valueOf(i3));
                    kVar.hGt.a(i, 100, kVar);
                }
                return z;
            }
        }
    }, true);
    private int retryCount = 3;

    class a {
        int errCode;
        int errType;
        String fPf;
        int hDU = 0;
        int hKA = 0;
        final /* synthetic */ g hKw;
        ano hKz;

        a(g gVar) {
            this.hKw = gVar;
        }
    }

    public static class b extends i {
        private final com.tencent.mm.protocal.v.a hKB = new com.tencent.mm.protocal.v.a();
        private final com.tencent.mm.protocal.v.b hKC = new com.tencent.mm.protocal.v.b();

        protected final d zf() {
            return this.hKB;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hKC;
        }

        public final int getType() {
            return com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newinit";
        }
    }

    public g(f fVar) {
        w.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", Integer.valueOf(hashCode()), bg.bJZ());
        this.hKh.append("stack:" + bg.bJZ() + " time:" + bg.Ny());
        this.hGt = fVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hKg = new com.tencent.mm.compatible.util.g.a();
        this.gUD = eVar2;
        ann com_tencent_mm_protocal_c_ann = this.hKr;
        h.vJ();
        com_tencent_mm_protocal_c_ann.jNj = (String) h.vI().vr().get(2, null);
        Assert.assertTrue("by DK: req.UserName is null", !bg.mA(this.hKr.jNj));
        this.hKr.leO = v.bIN();
        return a(eVar, null, null);
    }

    private int a(com.tencent.mm.network.e eVar, avw com_tencent_mm_protocal_c_avw, avw com_tencent_mm_protocal_c_avw2) {
        this.hKh.append(" lastd:" + this.hsE + " dotime:" + bg.Ny() + " net:" + am.getNetType(ab.getContext()));
        p bVar = new b();
        if (com_tencent_mm_protocal_c_avw == null) {
            h.vJ();
            com_tencent_mm_protocal_c_avw = n.G(bg.PT(bg.mz((String) h.vI().vr().get(8197, null))));
        }
        if (com_tencent_mm_protocal_c_avw2 == null) {
            h.vJ();
            com_tencent_mm_protocal_c_avw2 = n.G(bg.PT(bg.mz((String) h.vI().vr().get(8198, null))));
        }
        h.vJ();
        if (bg.f((Integer) h.vI().vr().get(16, null)) == 0 || (com_tencent_mm_protocal_c_avw != null && com_tencent_mm_protocal_c_avw.tZn > 0)) {
            h.vJ();
            if (bg.mz((String) h.vI().vr().get(8195, null)).length() <= 0) {
                bVar.BG().sZw = 3;
            } else {
                bVar.BG().sZw = 4;
            }
        } else {
            bVar.BG().sZw = 7;
        }
        this.hKr.tSq = com_tencent_mm_protocal_c_avw;
        this.hKr.tSr = com_tencent_mm_protocal_c_avw2;
        ((com.tencent.mm.protocal.v.a) bVar.BG()).taa = this.hKr;
        w.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", Integer.valueOf(hashCode()), Long.valueOf(this.hKg.se()), Integer.valueOf(this.hKs), this.hKr.jNj, this.hKr.leO, Integer.valueOf(bVar.BG().sZw), bg.bo(n.a(com_tencent_mm_protocal_c_avw)), bg.bo(n.a(com_tencent_mm_protocal_c_avw2)));
        this.hKs++;
        return a(eVar, bVar, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.hKh.append(" endtime:" + bg.Ny());
        w.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i));
        if (i2 == 4 && i3 == -100) {
            w.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.hKd = true;
            this.gUD.a(i2, i3, str, this);
        } else if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -17)) {
            ano com_tencent_mm_protocal_c_ano = ((com.tencent.mm.protocal.v.b) pVar.zg()).tab;
            this.hKu += com_tencent_mm_protocal_c_ano.tSt;
            w.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.hKg.se()), Integer.valueOf(this.hKu), Integer.valueOf(this.hKs), Integer.valueOf(com_tencent_mm_protocal_c_ano.tlZ));
            a(this.hKs - 1, i2, i3, str, com_tencent_mm_protocal_c_ano);
            if ((com_tencent_mm_protocal_c_ano.tlZ & 7) == 0 || super.BJ()) {
                w.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", Integer.valueOf(hashCode()), Long.valueOf(this.hKg.se()), Integer.valueOf(this.hKs));
                this.hKt = true;
                a(Integer.MAX_VALUE, 0, 0, "", null);
            } else if (a(this.hsD, com_tencent_mm_protocal_c_ano.tSq, com_tencent_mm_protocal_c_ano.tSr) == -1) {
                w.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
                a(Integer.MAX_VALUE, 3, -1, "", null);
            }
        } else {
            w.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (this.retryCount > 0) {
                this.retryCount--;
                if (a(this.hsD, null, null) != -1) {
                    return;
                }
            }
            this.hKd = true;
            this.gUD.a(3, -1, "", this);
        }
    }

    public final boolean BI() {
        return true;
    }

    protected final void cancel() {
        w.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", bg.bJZ());
        super.cancel();
        this.hKd = true;
    }

    private void a(int i, int i2, int i3, String str, ano com_tencent_mm_protocal_c_ano) {
        a aVar = new a(this);
        aVar.hKA = i;
        aVar.errCode = i3;
        aVar.errType = i2;
        aVar.fPf = str;
        aVar.hKz = com_tencent_mm_protocal_c_ano;
        this.hDH.add(aVar);
        if (this.hqQ.bJq()) {
            this.hqQ.v(50, 50);
        }
    }

    public final String getInfo() {
        return this.hKh.toString();
    }

    protected final int ub() {
        return 500;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final boolean BJ() {
        return super.BJ();
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX;
    }
}
