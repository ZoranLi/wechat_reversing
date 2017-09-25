package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.g;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.Map;

public final class d extends k implements j {
    protected static int cCn = 7;
    private int errCode;
    private int errType;
    private String fPf;
    private e gUD;
    private int hKf;
    private com.tencent.mm.compatible.util.g.a hKg;
    private StringBuilder hKh;
    private long hKi;
    public boolean hKj;
    private aj hqQ;

    public static class a implements p {
        private final com.tencent.mm.protocal.w.a hKm;
        private final b hKn;
        private final boolean hKo;
        int uin;

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

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hKn;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }

        public final com.tencent.mm.protocal.k.d BG() {
            this.hKm.sZv = com.tencent.mm.compatible.d.p.rB();
            this.hKm.sZu = com.tencent.mm.protocal.d.DEVICE_TYPE;
            this.hKm.sZt = com.tencent.mm.protocal.d.sYN;
            this.hKm.dj(this.uin);
            return this.hKm;
        }

        public final boolean BH() {
            return false;
        }

        public final int BD() {
            return 0;
        }
    }

    public d() {
        this.errType = 0;
        this.errCode = 0;
        this.fPf = "";
        this.hKf = 0;
        this.hKh = new StringBuilder();
        this.hKi = -1;
        this.hKj = false;
        w.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", Integer.valueOf(hashCode()), bg.bJZ());
        this.hKg = new com.tencent.mm.compatible.util.g.a();
        this.hKh.append("stack:" + bg.bJZ() + " time:" + bg.Ny());
    }

    public d(final b bVar, int i, long j) {
        this();
        this.hKf = i;
        this.hKi = j;
        w.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.hqQ = new aj(z.MR(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ d hKl;

            public final boolean oQ() {
                this.hKl.hKj = true;
                int i = 0;
                this.hKl.a(-1, 0, i, "", new a(bVar), null);
                return false;
            }
        }, false);
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
        return 138;
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.gUD = eVar2;
        this.hKh.append(" lastd:" + this.hsE + " dotime:" + bg.Ny() + " net:" + am.getNetType(ab.getContext()));
        String str = "MicroMsg.NetPushSync";
        String str2 = "doScene[%d] selector:%d pusher:%b ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(cCn);
        if (this.hqQ != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        if (this.hqQ != null) {
            c(eVar);
            this.hqQ.v(0, 0);
            this.hqQ = null;
            return -1;
        }
        p aVar = new a();
        aVar.uin = z.MO().ieq.uH();
        ant com_tencent_mm_protocal_c_ant = ((com.tencent.mm.protocal.w.a) aVar.BG()).tac;
        com_tencent_mm_protocal_c_ant.toa = cCn;
        com_tencent_mm_protocal_c_ant.tob = n.G(bg.PT(ab.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", "")));
        com_tencent_mm_protocal_c_ant.tdM = 1;
        com_tencent_mm_protocal_c_ant.tSS = new lv();
        com_tencent_mm_protocal_c_ant.thD = com.tencent.mm.protocal.d.DEVICE_TYPE;
        return a(eVar, aVar, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (pVar == null || pVar.getType() != 138) {
            int i4;
            String str2 = "MicroMsg.NetPushSync";
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
        Object obj;
        this.hKh.append(" endtime:" + bg.Ny());
        w.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.hKj), Long.valueOf(this.hKg.se()), this.hKh);
        if (i2 == 4 && i3 == -2006) {
            i2 = 0;
            i3 = 0;
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 == 0 && i3 == 0) {
            String str4;
            String str5;
            byte[] PT;
            int size;
            int i5;
            b bVar = (b) pVar.zg();
            if (obj == null) {
                byte[] a = n.a(((com.tencent.mm.protocal.w.a) pVar.BG()).tac.tob);
                str4 = "MicroMsg.NetPushSync";
                str5 = "dkpush req Key : %d[%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(a == null ? -1 : a.length);
                objArr2[1] = bg.bl(a);
                w.d(str4, str5, objArr2);
                if (bg.bm(a)) {
                    PT = bg.PT(ab.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                    w.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", Integer.valueOf(PT.length), bg.bl(PT));
                } else {
                    PT = a;
                }
                a = n.a(bVar.tad.tob);
                PT = ad.g(PT, a);
                if (PT == null || PT.length <= 0) {
                    w.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
                    PT = a;
                }
                bVar.tad.tob = n.G(PT);
                size = (bVar.tad.toe == null || bVar.tad.toe.jNe == null) ? 0 : bVar.tad.toe.jNe.size();
                w.i("MicroMsg.NetPushSync", "newMsgSize:%d", Integer.valueOf(size));
                str4 = "MicroMsg.NetPushSync";
                str5 = "newMsgSize:%d, mergeKey: %d[%s]";
                objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(size);
                objArr2[1] = Integer.valueOf(PT == null ? -1 : PT.length);
                objArr2[2] = bg.bl(PT);
                w.d(str4, str5, objArr2);
            }
            Iterator it = bVar.tad.toe.jNe.iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                lu luVar = (lu) it.next();
                if (luVar.tsa == 5) {
                    PT = n.a(luVar.tsb);
                    try {
                        bu buVar = new bu();
                        buVar.aD(PT);
                        str3 = "MicroMsg.NetPushSync";
                        str4 = "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d";
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = Integer.valueOf(buVar.mtd);
                        objArr3[1] = buVar.tfd.tZr;
                        objArr3[2] = Long.valueOf(buVar.tfk);
                        objArr3[3] = Integer.valueOf(buVar.tfj == null ? 0 : buVar.tfj.length());
                        objArr3[4] = Integer.valueOf(buVar.tff.tZr == null ? 0 : buVar.tff.tZr.length());
                        w.i(str3, str4, objArr3);
                        i5 = buVar.mtd;
                        str3 = buVar.tfd.tZr;
                        str4 = buVar.tff.tZr;
                        if (i5 == 50) {
                            w.i("MicroMsg.NetPushSync", "hit voip");
                            obj = 1;
                        } else {
                            if (bg.mA(str4) || bg.mA(str3)) {
                                w.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
                            } else if (i5 == 9998 && str3.equalsIgnoreCase("weixin")) {
                                w.i("MicroMsg.NetPushSync", "hit ipxx");
                                obj = 1;
                            } else if (i5 == CdnLogic.MediaType_FAVORITE_VIDEO && str4.contains("revokemsg")) {
                                w.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                obj = 1;
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                        } else {
                            long j = buVar.tfk;
                            str5 = buVar.tfd.tZr;
                            str2 = buVar.tfj;
                            int i6 = buVar.mtd;
                            if (bg.mA(str2)) {
                                w.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
                            } else {
                                PString pString = new PString();
                                PString pString2 = new PString();
                                str2 = bg.PX(str2);
                                int indexOf = str2.indexOf("<pushcontent");
                                if (indexOf > 0) {
                                    str2 = str2.substring(indexOf);
                                }
                                Map q = bh.q(str2, "pushcontent");
                                if (q == null) {
                                    w.e("MicroMsg.NetPushSync", "inval xml");
                                } else {
                                    pString.value = (String) q.get(".pushcontent.$content");
                                    pString2.value = (String) q.get(".pushcontent.$nickname");
                                }
                                PluginZero pluginZero = (PluginZero) h.j(PluginZero.class);
                                if (pluginZero.sAS != null) {
                                    pluginZero.sAS.a(j, str5, pString2.value, pString.value, (com.tencent.mm.compatible.util.e.hgu + g.n(("mm" + z.MO().ieq.uH()).getBytes())) + "/avatar/", i6);
                                }
                            }
                            if ((buVar.mtd == CdnLogic.MediaType_FAVORITE_VIDEO ? 1 : null) != null) {
                                w.i("MicroMsg.NetPushSync", "need remove pushContent");
                                buVar.tfj = null;
                                luVar.tsb = n.G(buVar.toByteArray());
                            }
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.NetPushSync", e, "", new Object[0]);
                    }
                }
            }
            try {
                PT = bVar.tad.toByteArray();
                size = z.MO().ieq.uH();
                str4 = f.dM(size);
                int cU = f.cU(str4) + 1;
                String str6 = str4 + "/syncResp.bin" + cU;
                byte[] b = com.tencent.mm.a.k.b(PT, g.n((com.tencent.mm.compatible.d.p.rA() + size).getBytes()).getBytes());
                w.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", Integer.valueOf(cU), Integer.valueOf(PT.length), Integer.valueOf(b.length), str6, f.v(PT), f.v(b), f.v(str3.getBytes()));
                if (bg.bm(b)) {
                    w.e("MicroMsg.NotifySyncMgr", "encry failed");
                } else {
                    i5 = com.tencent.mm.a.e.b(str6, b, b.length);
                    boolean aO = com.tencent.mm.a.e.aO(str6);
                    if (i5 == 0 && aO) {
                        PT = String.valueOf(cU).getBytes();
                        com.tencent.mm.a.e.b(str4 + "/syncResp.ini", PT, PT.length);
                    } else {
                        w.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", Integer.valueOf(i5), Boolean.valueOf(aO));
                    }
                }
            } catch (Throwable e2) {
                w.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", e2);
                w.printErrStackTrace("MicroMsg.NetPushSync", e2, "", new Object[0]);
            }
            w.d("MicroMsg.NetPushSync", "onRespHandled sync");
            ab.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bg.bo(n.a(bVar.tad.tob))).commit();
            w.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", Integer.valueOf(this.hKf));
            if (obj2 == null) {
                obj = ((bVar.tad.tlZ & cCn) == 0 || super.BJ()) ? null : 1;
                w.i("MicroMsg.NetPushSync", "continue flag=" + bVar.tad.tlZ + ", selector=" + cCn + ", limit reach=" + super.BJ());
                if (obj != null) {
                    a(this.hsD, this.gUD);
                    if (obj2 != null) {
                        CoreService.pT();
                        return;
                    }
                    return;
                }
            }
            if ((this.hKf & 1) > 0) {
                w.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
                new h(this.hKi, n.a(bVar.tad.tob), z.MO().ieq.uH()).a(z.MO(), new e(this) {
                    final /* synthetic */ d hKl;

                    {
                        this.hKl = r1;
                    }

                    public final void a(int i, int i2, String str, k kVar) {
                        w.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        kVar.hsJ = true;
                    }
                });
            }
            this.gUD.a(this.errType, this.errCode, this.fPf, this);
            if (obj2 != null) {
                CoreService.pT();
                return;
            }
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
