package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mm.booter.f;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import junit.framework.Assert;

public final class l extends k implements j {
    protected static int cCn = 7;
    private static boolean hKT = false;
    private static int hKW = 0;
    public String TAG;
    private int errCode;
    private int errType;
    private String fPf;
    private e gUD;
    public s hKS;
    private boolean hKU;
    private aj hKV;
    public int hKX;
    private boolean hKY;
    public String hKZ;
    public boolean hKd;
    private int hKf;
    private com.tencent.mm.compatible.util.g.a hKg;
    private long hKi;
    public boolean hKj;
    public b hLa;
    public long hLb;
    private aj hqQ;

    public static class a extends i {
        private final com.tencent.mm.protocal.w.a hKm;
        private final b hKn;
        private final boolean hKo;

        public a() {
            this.hKm = new com.tencent.mm.protocal.w.a();
            this.hKn = new b();
            this.hKo = false;
        }

        public a(b bVar) {
            this.hKm = new com.tencent.mm.protocal.w.a();
            this.hKn = bVar;
            this.hKo = true;
        }

        public final d zf() {
            return this.hKm;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hKn;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }
    }

    public l(int i) {
        this.TAG = "MicroMsg.NetSceneSync";
        this.errType = 0;
        this.errCode = 0;
        this.fPf = "";
        this.hKS = null;
        this.hKU = false;
        this.hKf = 0;
        this.hqQ = null;
        this.hKV = null;
        this.hKi = -1;
        this.hKj = false;
        this.hKY = false;
        this.hKd = false;
        this.hKZ = "";
        this.hLa = null;
        this.hLb = 0;
        this.TAG += "[" + hashCode() + "]";
        w.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", Integer.valueOf(i), bg.bJZ());
        this.hKZ = ah.bJn();
        this.hKg = new com.tencent.mm.compatible.util.g.a();
        if (this.hKS == null) {
            this.hKS = new s();
        }
        this.hKS.hMM = i;
        h.vJ();
        if (h.vI() != null && h.vG().uV()) {
            h.vJ();
            if (!(h.vI().vr() == null || com.tencent.mm.kernel.a.uP())) {
                h.vJ();
                long a = bg.a((Long) h.vI().vr().get(8196, null), 0);
                if (a != 0) {
                    h.vJ();
                    h.vI().vr().set(8196, Long.valueOf(0));
                    int i2 = (int) (a | ((long) cCn));
                    cCn = i2;
                    cCn = i2 & 95;
                }
            }
        }
        if (i == 1) {
            hKT = true;
        }
        if (i == 1010) {
            cCn |= 16;
            hKT = true;
            this.hKX = 7;
        } else if (i == 1011) {
            cCn |= 64;
            hKT = true;
            this.hKX = 7;
        } else if (i == 3) {
            cCn |= 262144;
            hKT = true;
            this.hKX = 3;
            w.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", Integer.valueOf(i), Integer.valueOf(cCn), Integer.valueOf(this.hKX));
        } else {
            this.hKX = i;
        }
        if (hKW == 0) {
            Ht();
        }
    }

    public l(final b bVar, int i, long j) {
        this(8);
        this.hKZ = ah.bJn();
        w.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", Long.valueOf(bVar.sZB), Integer.valueOf(i), Long.valueOf(j));
        this.hKf = i;
        this.hKi = j;
        this.hqQ = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ l hLc;

            public final boolean oQ() {
                this.hLc.hKj = true;
                p aVar = new a(bVar);
                c.oTb.a(99, 230, 1, false);
                this.hLc.a(-1, 0, 0, "", aVar, null);
                return false;
            }
        }, false);
        if (hKW == 0) {
            Ht();
        }
    }

    protected final boolean a(k kVar) {
        boolean z = true;
        if (!(kVar instanceof l)) {
            return false;
        }
        l lVar = (l) kVar;
        if (lVar.hKU || !hKT) {
            return false;
        }
        w.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", Long.valueOf(lVar.hsE));
        if (bg.aB(lVar.hsE) <= 360000) {
            z = false;
        }
        if (z) {
            w.i(this.TAG, "summerworker NetSceneSync timeout");
            Runnable findTaskByRunTime = h.vL().bJl().findTaskByRunTime(0);
            if (findTaskByRunTime != null) {
                w.e(this.TAG, "summerworker worker is just blocked by task: " + ae.dump(findTaskByRunTime, false));
                return false;
            }
        }
        return z;
    }

    public final boolean BI() {
        return true;
    }

    protected final int ub() {
        return 100;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final boolean BJ() {
        int i = 1;
        boolean BJ = super.BJ();
        if (BJ) {
            c.oTb.a(99, 228, 1, false);
            c cVar = c.oTb;
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "9999";
            cVar.i(12063, objArr);
        }
        return BJ;
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
        c.oTb.a(99, 229, 1, false);
        this.hKd = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (m.Hv()) {
            hKW = 0;
            w.e(this.TAG, "dkinit never do sync before init done");
            return -1;
        }
        this.gUD = eVar2;
        if (this.hKS == null) {
            this.hKS = new s();
        }
        this.hKS.hML = com.tencent.mm.sdk.a.b.foreground;
        if (this.hKV != null) {
            w.i(this.TAG, "pushSyncRespHandler not null");
            c(eVar);
            this.hKV.v(0, 0);
            return 0;
        } else if (hKW > 0) {
            w.w(this.TAG, "other sync is dealing with resp data :%d", Integer.valueOf(hKW));
            return -1;
        } else if (this.hqQ != null) {
            w.i(this.TAG, "pusher not null");
            c(eVar);
            this.hqQ.v(0, 0);
            return 0;
        } else {
            p aVar = new a();
            ant com_tencent_mm_protocal_c_ant = ((com.tencent.mm.protocal.w.a) aVar.BG()).tac;
            if (this.hKX == 3) {
                com_tencent_mm_protocal_c_ant.tST = 1;
            } else {
                com_tencent_mm_protocal_c_ant.tST = 0;
            }
            this.hKX = this.hKY ? 6 : this.hKX;
            com_tencent_mm_protocal_c_ant.toa = cCn;
            h.vJ();
            com_tencent_mm_protocal_c_ant.tob = n.G(bg.PT(bg.mz((String) h.vI().vr().get(8195, new byte[0]))));
            com_tencent_mm_protocal_c_ant.tdM = this.hKX;
            com_tencent_mm_protocal_c_ant.tSS = new lv();
            com_tencent_mm_protocal_c_ant.thD = com.tencent.mm.protocal.d.DEVICE_TYPE;
            w.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", Integer.valueOf(com_tencent_mm_protocal_c_ant.toa), Integer.valueOf(com_tencent_mm_protocal_c_ant.tdM), ad.ba(r0));
            hKT = false;
            return a(eVar, aVar, this);
        }
    }

    private boolean Ht() {
        PInt pInt = new PInt();
        h.vJ();
        h.vG();
        byte[] a = f.a(pInt, com.tencent.mm.kernel.a.uH());
        String str = this.TAG;
        String str2 = "dealWithRespData index:%d, hashcode:%d, buf.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a != null ? a.length : 0);
        w.i(str, str2, objArr);
        hKW = pInt.value;
        if (pInt.value == 0 || bg.bm(a)) {
            hKW = 0;
            return false;
        }
        b bVar = new b();
        try {
            bVar.y(a);
            final a aVar = new a(bVar);
            this.hKV = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ l hLc;

                public final boolean oQ() {
                    this.hLc.hKj = true;
                    c.oTb.a(99, 231, 1, false);
                    this.hLc.a(-1, 0, 0, "", aVar, null);
                    return false;
                }
            }, false);
            return true;
        } catch (Exception e) {
            c.oTb.a(99, 226, 1, false);
            w.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i = hKW;
            h.vJ();
            h.vG();
            f.ay(i, com.tencent.mm.kernel.a.uH());
            hKW = 0;
            return false;
        } catch (Error e2) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            w.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
            Assert.assertTrue("dealWithRespData error", false);
            return false;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (pVar == null || pVar.getType() != 138) {
            int i4;
            String str2 = this.TAG;
            String str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (pVar == null) {
                i4 = -2;
            } else {
                i4 = pVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            w.e(str2, str3, objArr);
            return;
        }
        boolean z;
        b bVar = (b) pVar.zg();
        str3 = this.TAG;
        String str4 = "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ";
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.hKg.se());
        objArr2[4] = Boolean.valueOf(this.hKj);
        objArr2[5] = Integer.valueOf(bVar.tad.toe == null ? -1 : bVar.tad.toe.jNd);
        objArr2[6] = this.hqQ;
        objArr2[7] = this.hKV;
        w.i(str3, str4, objArr2);
        Object obj = (bVar.tad.toe == null ? -1 : bVar.tad.toe.jNd) > 0 ? 1 : null;
        if (!Hu()) {
            c.oTb.a(99, obj != null ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.a.b.foreground) {
            c.oTb.a(99, obj != null ? 219 : 216, 1, false);
        } else {
            c.oTb.a(99, obj != null ? 220 : 217, 1, false);
        }
        this.hqQ = null;
        this.hKU = true;
        if (i2 == 4 && i3 == -2006) {
            z = true;
            i2 = 0;
            i3 = 0;
            c.oTb.a(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i2 == 0 && i3 == 0) {
            c.oTb.a(99, 233, 1, false);
            byte[] a = n.a(((com.tencent.mm.protocal.w.a) pVar.BG()).tac.tob);
            byte[] a2 = n.a(bVar.tad.tob);
            w.i(this.TAG, "onGYNetEnd replace key:%b req :%s", Boolean.valueOf(z), ad.ba(a));
            w.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", Boolean.valueOf(z), ad.ba(a2));
            if (!z) {
                if (bg.bm(a)) {
                    h.vJ();
                    a = bg.PT(bg.mz((String) h.vI().vr().get(8195, new byte[0])));
                    w.d(this.TAG, "dkpush userinfo key : %d[%s]", Integer.valueOf(a.length), bg.bl(a));
                }
                a = ad.g(a, a2);
                if (a == null || a.length <= 0) {
                    w.w(this.TAG, "merge key failed, use server side instead");
                    a = a2;
                }
                bVar.tad.tob = n.G(a);
            }
            h.vJ();
            h.vG().aF(bVar.tad.jNB, bVar.tad.tSU);
            h.vJ();
            h.vG();
            com.tencent.mm.kernel.a.eM(bVar.tad.jNB);
            Assert.assertTrue(this.hLa == null);
            this.hLa = bVar;
            this.hLb = bg.Nz();
            new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ l hLc;
                private int hLe = 0;
                private long hLf = 0;
                private int hLg = 0;

                {
                    this.hLc = r4;
                }

                public final boolean oQ() {
                    com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                    if (!h.vG().uV()) {
                        w.e(this.hLc.TAG, "syncRespHandler acc is not ready STOP :%s", this.hLc.hLa);
                        this.hLc.hLa = null;
                        return false;
                    } else if (this.hLc.hKd) {
                        cVar.aZ(this.hLc);
                        this.hLc.hLa = null;
                        return false;
                    } else if (this.hLc.hLa == null || this.hLc.hLa.tad.toe == null || this.hLc.hLa.tad.toe.jNe == null) {
                        w.e(this.hLc.TAG, "syncRespHandler CmdList is null! Stop Processing :%s", this.hLc.hLa);
                        cVar.aZ(this.hLc);
                        this.hLc.hLa = null;
                        return false;
                    } else {
                        LinkedList linkedList = this.hLc.hLa.tad.toe.jNe;
                        cVar.aX(this.hLc);
                        this.hLg++;
                        long Nz = bg.Nz();
                        for (int i = 0; i < 5; i++) {
                            if (this.hLe < linkedList.size()) {
                                w.v(this.hLc.TAG, "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", Integer.valueOf(i), Integer.valueOf(this.hLe), Integer.valueOf(linkedList.size()), Integer.valueOf(((lu) linkedList.get(this.hLe)).tsa), Integer.valueOf(((lu) linkedList.get(this.hLe)).tsb.tZn));
                                linkedList.size();
                                if (!cVar.a((lu) linkedList.get(this.hLe), false)) {
                                    w.w(this.hLc.TAG, "DoCmd Failed index:%d", Integer.valueOf(this.hLe));
                                }
                                this.hLe++;
                            }
                            if (this.hLe >= linkedList.size()) {
                                this.hLf += bg.aA(Nz);
                                w.i(this.hLc.TAG, "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", Integer.valueOf(this.hLe), Integer.valueOf(linkedList.size()), Long.valueOf(bg.aA(this.hLc.hLb)), Long.valueOf(this.hLf), Integer.valueOf(this.hLg), this.hLc.hLa);
                                this.hLc.a(this.hLc.hLa);
                                cVar.aY(this.hLc);
                                c.oTb.a(99, (long) bg.f((Integer) c.a((int) this.hLf, new int[]{100, com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX, 1000, 3000}, new Integer[]{Integer.valueOf(240), Integer.valueOf(af.CTRL_BYTE), Integer.valueOf(av.CTRL_BYTE), Integer.valueOf(aw.CTRL_BYTE), Integer.valueOf(JsApiGetSetting.CTRL_INDEX)})), 1, false);
                                c.oTb.a(99, (long) bg.f((Integer) c.a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(bx.CTRL_INDEX), Integer.valueOf(248), Integer.valueOf(bd.CTRL_INDEX), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.d.a.CTRL_INDEX), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.h.CTRL_INDEX)})), 1, false);
                                c.oTb.a(99, com.tencent.mm.sdk.a.b.foreground ? 241 : 242, 1, false);
                                c.oTb.a(99, (long) this.hLc.hKX, 1, false);
                                c.oTb.a(99, 0, 1, false);
                                c cVar2 = c.oTb;
                                Object[] objArr = new Object[8];
                                objArr[0] = Integer.valueOf(linkedList.size());
                                objArr[1] = Long.valueOf(r10);
                                objArr[2] = Integer.valueOf(this.hLc.hKX);
                                objArr[3] = Integer.valueOf(this.hLc.hLa.tad.tlZ);
                                objArr[4] = Long.valueOf(this.hLf);
                                objArr[5] = Integer.valueOf(this.hLg);
                                objArr[6] = this.hLc.hKZ;
                                objArr[7] = Integer.valueOf(com.tencent.mm.sdk.a.b.foreground ? 1 : 2);
                                cVar2.i(12063, objArr);
                                this.hLc.hLa = null;
                                return false;
                            }
                            if (bg.aA(Nz) > 500) {
                                w.d(this.hLc.TAG, "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", Long.valueOf(bg.aA(Nz)), Integer.valueOf(i), Integer.valueOf(this.hLe), this.hLc.hLa);
                                this.hLf += bg.aA(Nz);
                                return true;
                            }
                        }
                        this.hLf += bg.aA(Nz);
                        return true;
                    }
                }
            }, true).v(50, 50);
            return;
        }
        if (this.hLa != null) {
            w.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i2;
            this.errCode = i3;
            this.fPf = str;
            ((b) pVar.zg()).tad.tlZ = 0;
        } else {
            this.gUD.a(i2, i3, str, this);
        }
        c.oTb.a(99, 232, 1, false);
    }

    protected final void a(b bVar) {
        h.vJ();
        h.vI().vr().set(8195, bg.bo(n.a(bVar.tad.tob)));
        ab.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bg.bo(n.a(bVar.tad.tob))).commit();
        h.vJ();
        h.vI().vr().set(8196, Long.valueOf((long) bVar.tad.tlZ));
        boolean z = ((bVar.tad.tlZ & cCn) == 0 || super.BJ()) ? false : true;
        w.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", Boolean.valueOf(z), Integer.valueOf(bVar.tad.tlZ), Integer.valueOf(cCn), Boolean.valueOf(super.BJ()));
        if (!(z || (bVar.tad.tlZ & 256) == 0)) {
            com.tencent.mm.sdk.b.a.urY.m(new pi());
        }
        c.oTb.a(99, z ? 234 : 235, 1, false);
        w.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", Integer.valueOf(bVar.tad.tlZ), Boolean.valueOf(this.hKj), Boolean.valueOf(z), Boolean.valueOf(hKT), Integer.valueOf(this.hKf), Boolean.valueOf(this.hKY), this.hKV);
        if (!this.hKj && z) {
            this.hKY = true;
            a(this.hsD, this.gUD);
        } else if (hKT) {
            w.i(this.TAG, "dkpush new notify pending, sync now");
            if (hKW != 0) {
                r0 = hKW;
                h.vJ();
                h.vG();
                f.ay(r0, com.tencent.mm.kernel.a.uH());
            }
            hKW = 0;
            this.hKV = null;
            hKT = false;
            this.hKY = true;
            a(this.hsD, this.gUD);
        } else if (this.hKV != null) {
            r0 = hKW;
            h.vJ();
            h.vG();
            f.ay(r0, com.tencent.mm.kernel.a.uH());
            this.hKV = null;
            Ht();
            a(this.hsD, this.gUD);
        } else {
            if ((this.hKf & 1) > 0) {
                h.vJ();
                h.vd().a(new h(this.hKi, bg.PT(bg.mz((String) h.vI().vr().get(8195, null)))), 0);
            }
            w.d(this.TAG, "sync or init end: reset selector : now = " + cCn + " default = 7");
            cCn = 7;
            this.gUD.a(this.errType, this.errCode, this.fPf, this);
        }
    }

    private boolean Hu() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ab.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            w.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.valueOf(true), bg.g(e));
            return true;
        }
    }
}
