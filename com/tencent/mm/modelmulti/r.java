package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class r {
    private static Boolean hMn = null;
    private WakerLock gJT = null;
    public Queue<c> hMo = new LinkedList();
    public Queue<c> hMp = new LinkedList();
    public HashMap<c, Long> hMq = new HashMap();
    public c hMr = null;
    public long hMs = 0;

    class a {
        public int hKv = 0;
        aj hMA = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a hMB;

            {
                this.hMB = r1;
            }

            public final boolean oQ() {
                if (h.vG().uV() && !com.tencent.mm.kernel.a.uP()) {
                    h.vJ();
                    if (h.vI() != null) {
                        h.vJ();
                        if (h.vI().vr() != null) {
                            LinkedList linkedList = this.hMB.hMx.toe.jNe;
                            com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                            cVar.aX(this.hMB.hMz);
                            long Nz = bg.Nz();
                            while (this.hMB.hKv < linkedList.size()) {
                                linkedList.size();
                                if (!cVar.a((lu) linkedList.get(this.hMB.hKv), false)) {
                                    com.tencent.mm.plugin.report.c.oTb.a(99, 46, 1, false);
                                }
                                a aVar = this.hMB;
                                aVar.hKv++;
                                w.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", this.hMB.hMz, Long.valueOf(bg.aA(Nz)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.hMB.hKv - 1));
                                if (bg.aA(Nz) >= 500) {
                                    break;
                                }
                            }
                            cVar.aY(this.hMB.hMz);
                            if (this.hMB.hKv < linkedList.size()) {
                                w.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", this.hMB.hMz, Long.valueOf(bg.aA(Nz)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.hMB.hKv - 1));
                                return true;
                            }
                            r.a(this.hMB.hMw, this.hMB.hMx, this.hMB.hMz);
                            this.hMB.hMy.gh(linkedList.size());
                            return false;
                        }
                    }
                }
                Object[] objArr = new Object[4];
                objArr[0] = this.hMB.hMz;
                objArr[1] = Boolean.valueOf(h.vG().uV());
                objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.uP());
                h.vJ();
                objArr[3] = h.vI();
                w.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", objArr);
                this.hMB.hMy.gh(0);
                return false;
            }
        }, true);
        final /* synthetic */ r hMt;
        public boolean hMw = false;
        public anu hMx = null;
        public b hMy = null;
        public c hMz;

        public a(r rVar, c cVar, boolean z, anu com_tencent_mm_protocal_c_anu, b bVar) {
            this.hMt = rVar;
            this.hMy = bVar;
            this.hMz = cVar;
            this.hMw = z;
            this.hMx = com_tencent_mm_protocal_c_anu;
            this.hKv = 0;
            String str = "";
            boolean z2 = (this.hMy == null || this.hMz == null) ? false : true;
            r.assertTrue(str, z2);
            if (this.hMx == null) {
                r.assertTrue("resp Not null", false);
                w.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", this.hMz);
                this.hMy.gh(0);
                return;
            }
            if (h.vG().uV() && !com.tencent.mm.kernel.a.uP()) {
                h.vJ();
                if (h.vI() != null) {
                    h.vJ();
                    if (h.vI().vr() != null) {
                        int i;
                        long j;
                        if (com_tencent_mm_protocal_c_anu.toe == null || com_tencent_mm_protocal_c_anu.toe.jNe == null || com_tencent_mm_protocal_c_anu.toe.jNe.size() <= 0) {
                            i = 0;
                        } else {
                            i = com_tencent_mm_protocal_c_anu.toe.jNe.size();
                        }
                        com.tencent.mm.plugin.report.c.oTb.a(99, (long) bg.f((Integer) com.tencent.mm.plugin.report.c.a(i, new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(bx.CTRL_INDEX), Integer.valueOf(248), Integer.valueOf(bd.CTRL_INDEX), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.d.a.CTRL_INDEX), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.h.CTRL_INDEX)})), 1, false);
                        if (!r.Hu()) {
                            com.tencent.mm.plugin.report.c cVar2 = com.tencent.mm.plugin.report.c.oTb;
                            if (i > 0) {
                                j = 221;
                            } else {
                                j = 218;
                            }
                            cVar2.a(99, j, 1, false);
                        } else if (com.tencent.mm.sdk.a.b.foreground) {
                            com.tencent.mm.plugin.report.c.oTb.a(99, i > 0 ? 219 : 216, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.c.oTb.a(99, i > 0 ? 220 : 217, 1, false);
                        }
                        long j2 = (long) com_tencent_mm_protocal_c_anu.tSV;
                        if (String.valueOf(j2).length() == 10) {
                            j2 *= 1000;
                        }
                        j = System.currentTimeMillis() - j2;
                        long j3 = j / 1000;
                        w.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
                        h.vJ();
                        h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, Long.valueOf(j));
                        h.vJ();
                        h.vG().aF(this.hMx.jNB, this.hMx.tSU);
                        h.vJ();
                        h.vG();
                        com.tencent.mm.kernel.a.eM(this.hMx.jNB);
                        if (this.hMx.toe == null || this.hMx.toe.jNe == null || this.hMx.toe.jNe.size() <= 0) {
                            w.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", this.hMz);
                            r.a(z, this.hMx, this.hMz);
                            this.hMy.gh(0);
                            return;
                        }
                        w.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", this.hMz, Integer.valueOf(this.hMx.toe.jNe.size()), Integer.valueOf(this.hMx.jNB), Integer.valueOf(this.hMx.tSU));
                        this.hMA.v(50, 50);
                        return;
                    }
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = this.hMz;
            objArr[1] = Boolean.valueOf(h.vG().uV());
            objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.uP());
            h.vJ();
            objArr[3] = h.vI();
            w.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", objArr);
            this.hMy.gh(0);
        }
    }

    interface b {
        boolean gh(int i);
    }

    public interface c {
        boolean a(Queue<c> queue);
    }

    class d implements c {
        final /* synthetic */ r hMt;

        d(r rVar) {
            this.hMt = rVar;
        }

        public final boolean a(Queue<c> queue) {
            PInt pInt = new PInt();
            h.vJ();
            h.vG();
            byte[] a = com.tencent.mm.booter.f.a(pInt, com.tencent.mm.kernel.a.uH());
            String str = "MicroMsg.SyncService";
            String str2 = "%s index:%d, buf.len:%d ";
            Object[] objArr = new Object[3];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(pInt.value);
            objArr[2] = Integer.valueOf(a != null ? a.length : -1);
            w.i(str, str2, objArr);
            if (pInt.value == 0 || bg.bm(a)) {
                return false;
            }
            anu com_tencent_mm_protocal_c_anu;
            final int i = pInt.value;
            anu com_tencent_mm_protocal_c_anu2 = null;
            try {
                com.tencent.mm.protocal.w.b bVar = new com.tencent.mm.protocal.w.b();
                bVar.y(a);
                com_tencent_mm_protocal_c_anu = bVar.tad;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(99, 38, 1, false);
                w.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed ", this, Integer.valueOf(i));
                h.vJ();
                h.vG();
                com.tencent.mm.booter.f.ay(i, com.tencent.mm.kernel.a.uH());
                com_tencent_mm_protocal_c_anu = com_tencent_mm_protocal_c_anu2;
            } catch (Error e2) {
                com.tencent.mm.plugin.report.c.oTb.a(99, 39, 1, false);
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                w.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", this, Integer.valueOf(i), Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
                r.assertTrue("LightPush memory error", false);
                com_tencent_mm_protocal_c_anu = com_tencent_mm_protocal_c_anu2;
            }
            if (com_tencent_mm_protocal_c_anu == null) {
                return false;
            }
            com.tencent.mm.plugin.report.c.oTb.a(99, 20, 1, false);
            a aVar = new a(this.hMt, this, true, com_tencent_mm_protocal_c_anu, new b(this) {
                final /* synthetic */ d hMD;

                public final boolean gh(int i) {
                    w.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", this.hMD, Integer.valueOf(i));
                    int i2 = i;
                    h.vJ();
                    h.vG();
                    com.tencent.mm.booter.f.ay(i2, com.tencent.mm.kernel.a.uH());
                    this.hMD.hMt.b(this.hMD);
                    return true;
                }
            });
            return true;
        }

        public final String toString() {
            return "LightPush[" + hashCode() + "]";
        }
    }

    class e extends k implements c, j {
        public int cCn;
        public com.tencent.mm.y.e hME;
        public boolean hMF;
        private boolean hMG = false;
        final /* synthetic */ r hMt;
        private p htt;
        public int scene;

        public final boolean a(Queue<c> queue) {
            String str = "MicroMsg.SyncService";
            String str2 = "%s begin run scene:%s selector:%s isContinue:%s List:%s";
            Object[] objArr = new Object[5];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(this.scene);
            objArr[2] = Integer.valueOf(this.cCn);
            objArr[3] = Boolean.valueOf(this.hMF);
            objArr[4] = queue == null ? "null" : Integer.valueOf(queue.size());
            w.i(str, str2, objArr);
            if (queue != null) {
                if (!(queue == null || queue.isEmpty())) {
                    if (queue.size() >= 5) {
                        com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3590), queue.size() + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                    }
                    com.tencent.mm.plugin.report.c.oTb.a(99, (long) bg.f((Integer) com.tencent.mm.plugin.report.c.a(queue.size(), new int[]{1, 2, 3, 4, 5, 10}, new Integer[]{Integer.valueOf(60), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(64), Integer.valueOf(65), Integer.valueOf(66)})), 1, false);
                }
                boolean z = false;
                boolean z2 = false;
                while (!queue.isEmpty()) {
                    e eVar = (e) queue.poll();
                    this.cCn |= eVar.cCn;
                    if (eVar.scene == 3) {
                        z = true;
                    } else if (eVar.hMF) {
                        z2 = true;
                    }
                    w.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", this, Integer.valueOf(queue.size()), eVar, Integer.valueOf(eVar.scene), Integer.valueOf(eVar.cCn), Boolean.valueOf(eVar.hMF), Boolean.valueOf(z2), Boolean.valueOf(z));
                }
                if (z) {
                    this.scene = 3;
                } else if (z2) {
                    this.scene = 6;
                }
            }
            if (h.vG().uV() && !com.tencent.mm.kernel.a.uP()) {
                h.vJ();
                if (h.vI() != null) {
                    h.vJ();
                    if (h.vI().vr() != null) {
                        h.vJ();
                        long a = bg.a((Long) h.vI().vr().get(8196, null), 0);
                        if (a != 0) {
                            h.vJ();
                            h.vI().vr().set(8196, Long.valueOf(0));
                            this.cCn = (int) (((long) this.cCn) | a);
                            this.cCn &= 95;
                        }
                        int i = this.scene == 3 ? 1 : 0;
                        if (this.scene == 1010) {
                            this.cCn |= 16;
                            this.scene = 7;
                        } else if (this.scene == 1011) {
                            this.cCn |= 64;
                            this.scene = 7;
                        } else if (this.scene == 3) {
                            this.cCn |= 262144;
                            this.scene = 3;
                        }
                        if (this.hMF) {
                            this.scene = 6;
                        }
                        this.htt = new com.tencent.mm.modelmulti.l.a();
                        ant com_tencent_mm_protocal_c_ant = ((com.tencent.mm.protocal.w.a) this.htt.BG()).tac;
                        com_tencent_mm_protocal_c_ant.tST = i;
                        com_tencent_mm_protocal_c_ant.toa = this.cCn;
                        com_tencent_mm_protocal_c_ant.tdM = this.scene;
                        h.vJ();
                        com_tencent_mm_protocal_c_ant.tob = n.G(bg.PT(bg.mz((String) h.vI().vr().get(8195, new byte[0]))));
                        com_tencent_mm_protocal_c_ant.tSS = new lv();
                        com_tencent_mm_protocal_c_ant.thD = com.tencent.mm.protocal.d.DEVICE_TYPE;
                        w.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", this, Long.valueOf(a), Integer.valueOf(com_tencent_mm_protocal_c_ant.tST), Integer.valueOf(com_tencent_mm_protocal_c_ant.toa), Integer.valueOf(this.scene), com_tencent_mm_protocal_c_ant.thD);
                        w.i("MicroMsg.SyncService", "%s Req synckey %s", this, ad.ba(bg.PT(r0)));
                        r.a(this);
                        h.vJ();
                        if (h.vH().gXC.a((k) this, 0)) {
                            return true;
                        }
                        com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                        w.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", this);
                        com.tencent.mm.plugin.report.c.oTb.a(99, 41, 1, false);
                        return false;
                    }
                }
            }
            Object[] objArr2 = new Object[4];
            objArr2[0] = this;
            objArr2[1] = Boolean.valueOf(h.vG().uV());
            objArr2[2] = Boolean.valueOf(com.tencent.mm.kernel.a.uP());
            h.vJ();
            objArr2[3] = h.vI();
            w.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", objArr2);
            return false;
        }

        public final String toString() {
            return "NetSync[" + hashCode() + "]";
        }

        public e(r rVar, int i, int i2, boolean z) {
            this.hMt = rVar;
            this.scene = i;
            this.cCn = i2;
            this.hMF = z;
        }

        public final int getType() {
            return 138;
        }

        public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
            this.hME = eVar2;
            return a(eVar, this.htt, this);
        }

        public final boolean BL() {
            return false;
        }

        public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
            if (pVar == null || pVar.getType() != 138) {
                int i4;
                com.tencent.mm.plugin.report.c.oTb.a(99, 44, 1, false);
                String str2 = "MicroMsg.SyncService";
                String str3 = "%s onGYNetEnd error type:%d";
                Object[] objArr = new Object[2];
                objArr[0] = this;
                if (pVar == null) {
                    i4 = -2;
                } else {
                    i4 = pVar.getType();
                }
                objArr[1] = Integer.valueOf(i4);
                w.e(str2, str3, objArr);
            } else if (this.hMG) {
                w.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", this);
            } else {
                this.hMG = true;
                r.assertTrue("Check rr failed.", pVar == this.htt);
                boolean z = true;
                if (!(i2 == 0 && i3 == 0)) {
                    w.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", this, Integer.valueOf(i2), Integer.valueOf(i3), str, pVar);
                    if (i2 == 4 && i3 == -2006) {
                        w.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", this);
                        com.tencent.mm.plugin.report.c.oTb.a(99, 42, 1, false);
                        z = false;
                    } else {
                        com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3501), this.scene + ";" + i2 + ";" + i3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                        com.tencent.mm.plugin.report.c.oTb.a(99, 43, 1, false);
                        this.hME.a(i2, i3, str, this);
                        this.hMt.b(this);
                        return;
                    }
                }
                final anu com_tencent_mm_protocal_c_anu = ((com.tencent.mm.protocal.w.b) pVar.zg()).tad;
                a aVar = new a(this.hMt, this, z, com_tencent_mm_protocal_c_anu, new b(this) {
                    final /* synthetic */ e hMI;

                    public final boolean gh(int i) {
                        h.vJ();
                        h.vI().vr().set(8196, Long.valueOf((long) com_tencent_mm_protocal_c_anu.tlZ));
                        boolean z = (com_tencent_mm_protocal_c_anu.tlZ & this.hMI.cCn) != 0;
                        w.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s", this.hMI, Integer.valueOf(com_tencent_mm_protocal_c_anu.tlZ), Boolean.valueOf(z), Integer.valueOf(com_tencent_mm_protocal_c_anu.tlZ & 256));
                        if (!(z || (com_tencent_mm_protocal_c_anu.tlZ & 256) == 0)) {
                            com.tencent.mm.sdk.b.a.urY.m(new pi());
                        }
                        if (z) {
                            if (i == 0 && this.hMI.hMF) {
                                w.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", this.hMI);
                            } else {
                                this.hMI.hMt.e(this.hMI.scene, this.hMI.cCn, true);
                            }
                        }
                        this.hMI.hME.a(0, 0, "", this.hMI);
                        this.hMI.hMt.b(this.hMI);
                        return true;
                    }
                });
            }
        }
    }

    class f implements c {
        int hKf;
        long hMJ;
        final /* synthetic */ r hMt;
        anu hMx;

        public f(r rVar, com.tencent.mm.protocal.w.b bVar, int i, long j) {
            this.hMt = rVar;
            this.hMx = bVar == null ? null : bVar.tad;
            this.hMJ = j;
            this.hKf = i;
        }

        public final boolean a(Queue<c> queue) {
            if (this.hMx == null) {
                com.tencent.mm.plugin.report.c.oTb.a(99, 40, 1, false);
                w.e("MicroMsg.SyncService", "%s run resp == null", this);
                return false;
            } else if (10018 == com.tencent.mm.platformtools.r.iiW) {
                w.e("MicroMsg.SyncService", "%s Give up for test", this);
                return false;
            } else {
                a aVar = new a(this.hMt, this, true, this.hMx, new b(this) {
                    final /* synthetic */ f hMK;

                    {
                        this.hMK = r1;
                    }

                    public final boolean gh(int i) {
                        w.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", this.hMK, this.hMK.hMx, Integer.valueOf(this.hMK.hKf), Long.valueOf(this.hMK.hMJ));
                        if ((this.hMK.hKf & 1) > 0) {
                            h.vJ();
                            h.vd().a(new h(this.hMK.hMJ, bg.PT(bg.mz((String) h.vI().vr().get(8195, null)))), 0);
                        }
                        this.hMK.hMt.b(this.hMK);
                        return true;
                    }
                });
                com.tencent.mm.plugin.report.c.oTb.a(99, 21, 1, false);
                return true;
            }
        }

        public final String toString() {
            return "NotifyData[" + hashCode() + "]";
        }
    }

    private static boolean wI() {
        if (com.tencent.mm.kernel.a.uP() || !h.vG().uV()) {
            return false;
        }
        if (hMn != null) {
            return hMn.booleanValue();
        }
        hMn = Boolean.valueOf(true);
        return true;
    }

    public static void assertTrue(String str, boolean z) {
        if (!z) {
            w.e("MicroMsg.SyncService", "ASSERT now msg:%s", str);
            Assert.assertTrue(str, z);
        }
    }

    public final int a(long j, int i, String str) {
        w.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s [%s] ", Boolean.valueOf(wI()), Long.valueOf(j), Integer.valueOf(i), str, bg.bJZ());
        int i2 = 0;
        if ((256 & j) != 0) {
            com.tencent.mm.sdk.b.a.urY.m(new pi());
        }
        long j2 = (-257 & j) & 95;
        if (j2 != 0 && h.vG().uV()) {
            h.vJ();
            if (h.vI().vr() != null) {
                h.vJ();
                h.vI().vr().set(8196, Long.valueOf(j2));
                if (r1) {
                    i2 = e(i, 7, false);
                } else {
                    k lVar = new l(i);
                    i2 = lVar.hashCode();
                    w.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", Integer.valueOf(i2));
                    h.vJ();
                    if (!h.vH().gXC.a(lVar, 0)) {
                        w.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", Integer.valueOf(i2));
                        i2 = 0;
                    }
                }
            }
        }
        if (!bg.mA(str)) {
            com.tencent.mm.sdk.b.b ahVar = new ah();
            ahVar.fDx.type = 3;
            ahVar.fDx.fDz = str;
            com.tencent.mm.sdk.b.a.urY.m(ahVar);
        }
        return i2;
    }

    public final void a(com.tencent.mm.protocal.w.b bVar, int i, long j) {
        w.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s [%s]", Boolean.valueOf(wI()), bVar, Integer.valueOf(i), Long.valueOf(j), bg.bJZ());
        if (wI()) {
            a(new f(this, bVar, i, j));
            return;
        }
        h.vJ();
        h.vH().gXC.a(new l(bVar, i, j), 0);
    }

    public final int gg(int i) {
        w.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", Boolean.valueOf(wI()), Integer.valueOf(i), bg.bJZ());
        if (wI()) {
            return e(i, 7, false);
        }
        k lVar = new l(i);
        h.vJ();
        h.vH().gXC.a(lVar, 0);
        return lVar.hashCode();
    }

    public final int e(int i, int i2, boolean z) {
        c eVar = new e(this, i, i2, z);
        a(eVar);
        return eVar.hashCode();
    }

    public final synchronized void jQ(String str) {
        boolean z = true;
        synchronized (this) {
            w.i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", str, this.gJT, bg.bJZ());
            if (this.gJT == null) {
                this.gJT = new WakerLock(ab.getContext(), new IAutoUnlockCallback(this) {
                    final /* synthetic */ r hMt;

                    {
                        this.hMt = r1;
                    }

                    public final void autoUnlockCallback() {
                        w.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", this.hMt.hMr);
                        c cVar = this.hMt.hMr;
                        if (cVar == null) {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3550), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, 48, 1, false);
                        } else if (cVar instanceof e) {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3551), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, 49, 1, false);
                        } else if (cVar instanceof f) {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3552), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, 50, 1, false);
                        } else if (cVar instanceof d) {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3553), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, 51, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3554), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, 52, 1, false);
                        }
                    }
                });
            }
            String str2 = "lock";
            if (this.gJT.isLocking()) {
                z = false;
            }
            assertTrue(str2, z);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                this.gJT.lock(30000, str);
            }
        }
    }

    public final synchronized void HB() {
        if (this.gJT == null || !this.gJT.isLocking()) {
            String str;
            String str2 = "MicroMsg.SyncService";
            String str3 = "wakeUnlock syncWakerLock locking?:%s foreground:%s";
            Object[] objArr = new Object[2];
            if (this.gJT == null) {
                str = "null";
            } else {
                str = Boolean.valueOf(this.gJT.isLocking());
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground);
            w.w(str2, str3, objArr);
        } else {
            this.gJT.unLock();
        }
    }

    private void a(final c cVar) {
        if (m.Hv()) {
            w.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", cVar);
            return;
        }
        h.vL().D(new Runnable(this) {
            final /* synthetic */ r hMt;

            public final void run() {
                if (cVar != null) {
                    if (cVar instanceof f) {
                        this.hMt.hMp.add(cVar);
                    } else {
                        this.hMt.hMo.add(cVar);
                    }
                }
                this.hMt.b(null);
            }
        });
    }

    public final void b(final c cVar) {
        h.vL().D(new Runnable(this) {
            final /* synthetic */ r hMt;

            public final void run() {
                boolean z = true;
                boolean z2 = false;
                if (com.tencent.mm.kernel.a.uP() || !h.vG().uV()) {
                    w.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
                    return;
                }
                if (cVar != null) {
                    w.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", cVar, this.hMt.hMr, Long.valueOf(bg.aA(this.hMt.hMs)));
                    if (cVar != this.hMt.hMr) {
                        for (c cVar : this.hMt.hMq.keySet()) {
                            c cVar2;
                            w.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", cVar2, Long.valueOf(bg.aA(((Long) this.hMt.hMq.get(cVar2)).longValue())));
                        }
                        long a = bg.a((Long) this.hMt.hMq.remove(cVar), -1);
                        String str = "oldproc timeout, should in timeoutMap:" + cVar;
                        if (a != -1) {
                            z2 = true;
                        }
                        r.assertTrue(str, z2);
                        return;
                    }
                    r.a(cVar, this.hMt.hMs);
                    this.hMt.hMr = null;
                    this.hMt.hMs = 0;
                    this.hMt.HB();
                }
                if (this.hMt.hMr != null) {
                    if (bg.aA(this.hMt.hMs) > 90000) {
                        w.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", this.hMt.hMr, Long.valueOf(bg.aA(this.hMt.hMs)));
                        cVar2 = this.hMt.hMr;
                        if (cVar2 instanceof e) {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3571), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, com.tencent.mm.sdk.a.b.foreground ? 30 : 34, 1, false);
                        } else if (cVar2 instanceof f) {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3572), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, com.tencent.mm.sdk.a.b.foreground ? 31 : 35, 1, false);
                        } else if (cVar2 instanceof d) {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3573), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, com.tencent.mm.sdk.a.b.foreground ? 32 : 36, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.c.oTb.i(11098, Integer.valueOf(3574), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hu());
                            com.tencent.mm.plugin.report.c.oTb.a(99, com.tencent.mm.sdk.a.b.foreground ? 33 : 37, 1, false);
                        }
                        this.hMt.hMq.put(this.hMt.hMr, Long.valueOf(this.hMt.hMs));
                        this.hMt.hMr = null;
                        this.hMt.hMs = 0;
                        this.hMt.HB();
                    } else {
                        w.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", this.hMt.hMr, Long.valueOf(bg.aA(this.hMt.hMs)));
                        return;
                    }
                }
                com.tencent.mm.plugin.zero.b.b bVar = (com.tencent.mm.plugin.zero.b.b) h.h(com.tencent.mm.plugin.zero.b.b.class);
                if (bVar.bCi().zX()) {
                    w.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
                    bVar.bCi().zV();
                } else if (bVar.bCi().zY()) {
                    w.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
                } else {
                    cVar2 = new d(this.hMt);
                    if (cVar2.a(null)) {
                        this.hMt.jQ("LightPush");
                        this.hMt.hMr = cVar2;
                        this.hMt.hMs = bg.Nz();
                        return;
                    }
                    while (!this.hMt.hMp.isEmpty()) {
                        cVar2 = (c) this.hMt.hMp.poll();
                        w.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", Integer.valueOf(this.hMt.hMp.size()), cVar2);
                        if (cVar2 != null && cVar2.a(null)) {
                            this.hMt.jQ("NotifyData");
                            this.hMt.hMr = cVar2;
                            this.hMt.hMs = bg.Nz();
                            return;
                        }
                    }
                    if (!this.hMt.hMo.isEmpty()) {
                        cVar2 = (c) this.hMt.hMo.poll();
                        w.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", Integer.valueOf(this.hMt.hMo.size()), cVar2);
                        if (cVar2 != null && cVar2.a(this.hMt.hMo)) {
                            this.hMt.jQ("NetSync");
                            this.hMt.hMr = cVar2;
                            this.hMt.hMs = bg.Nz();
                            return;
                        }
                    }
                    w.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", this.hMt.hMr, Integer.valueOf(this.hMt.hMo.size()), Integer.valueOf(this.hMt.hMp.size()));
                    String str2 = "";
                    if (!(this.hMt.hMr == null && this.hMt.hMo.isEmpty() && this.hMt.hMp.isEmpty())) {
                        z = false;
                    }
                    r.assertTrue(str2, z);
                }
            }
        });
    }

    public static void a(boolean z, anu com_tencent_mm_protocal_c_anu, c cVar) {
        h.vJ();
        byte[] PT = bg.PT(bg.mz((String) h.vI().vr().get(8195, new byte[0])));
        byte[] a = n.a(com_tencent_mm_protocal_c_anu.tob);
        w.i("MicroMsg.SyncService", "processResp %s synckey req:%s  shouldMerge:%s", cVar, ad.ba(PT), Boolean.valueOf(z));
        w.i("MicroMsg.SyncService", "processResp %s synckey resp:%s", cVar, ad.ba(a));
        if (com_tencent_mm_protocal_c_anu.tob == null || com_tencent_mm_protocal_c_anu.tob.tZn <= 0) {
            com.tencent.mm.plugin.report.c.oTb.a(99, 47, 1, false);
            return;
        }
        if (z) {
            byte[] g = ad.g(PT, a);
            w.i("MicroMsg.SyncService", "processResp %s synckey merge:%s", cVar, ad.ba(g));
            if (g == null || g.length <= 0) {
                g = a;
            }
            com_tencent_mm_protocal_c_anu.tob = n.G(g);
        }
        if (Arrays.equals(PT, n.a(com_tencent_mm_protocal_c_anu.tob))) {
            w.i("MicroMsg.SyncService", "processResp %s  Sync Key Not change, not save", cVar);
            return;
        }
        h.vJ();
        h.vI().vr().set(8195, bg.bo(n.a(com_tencent_mm_protocal_c_anu.tob)));
        ab.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bg.bo(n.a(com_tencent_mm_protocal_c_anu.tob))).commit();
    }

    public static void a(e eVar) {
        com.tencent.mm.plugin.report.c.oTb.a(99, (long) eVar.scene, 1, false);
        com.tencent.mm.plugin.report.c.oTb.a(99, 0, 1, false);
        com.tencent.mm.plugin.report.c.oTb.a(99, com.tencent.mm.sdk.a.b.foreground ? 241 : 242, 1, false);
    }

    public static void a(c cVar, long j) {
        if (cVar != null) {
            com.tencent.mm.plugin.report.c.oTb.a(99, (long) bg.f((Integer) com.tencent.mm.plugin.report.c.a((int) bg.aA(j), new int[]{m.CTRL_INDEX, 500, 800, 1500, 3000, Downloads.MIN_RETYR_AFTER, 10000, 30000, 60000, 90000}, new Integer[]{Integer.valueOf(70), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(75), Integer.valueOf(76), Integer.valueOf(77), Integer.valueOf(78), Integer.valueOf(79), Integer.valueOf(80)})), 1, false);
        }
    }

    public static boolean Hu() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ab.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            com.tencent.mm.plugin.report.c.oTb.a(99, 45, 1, false);
            w.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.valueOf(true), bg.g(e));
            return true;
        }
    }
}
