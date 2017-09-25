package com.tencent.mm.u;

import android.content.SharedPreferences;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.p;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.protocal.c.afd;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.bmh;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.i.b;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.s;
import com.tencent.mm.y.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class aq extends i implements c {
    private static a hmq = null;
    private final int hmn;
    private final f hmo;
    private final g hmp;

    public interface a {
        void a(f fVar, g gVar);
    }

    public aq(int i) {
        boolean z = i == 702 || i == 701;
        Assert.assertTrue(z);
        this.hmn = i;
        if (i == 702) {
            this.hmo = new com.tencent.mm.protocal.i.a();
            this.hmp = new b();
            return;
        }
        this.hmo = new d();
        this.hmp = new e();
    }

    private p fb(int i) {
        w.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i), Integer.valueOf(hashCode()), bg.bJZ());
        f fVar = (f) BG();
        g gVar = this.hmp;
        SharedPreferences ze = ar.ze();
        w.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(ze.getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.sYN));
        if (ze.getInt("key_auth_update_version", 0) < com.tencent.mm.protocal.d.sYN) {
            fVar.sZw = this.hmn == 702 ? 12 : 16;
            com.tencent.mm.plugin.report.c.oTb.a(148, this.hmn == 702 ? 14 : 13, 1, false);
        } else {
            fVar.sZw = this.hmn == 702 ? 2 : 1;
        }
        ek ekVar = new ek();
        ekVar.tiw = i;
        ekVar.thl = new avw().bb(new byte[0]);
        ekVar.thk = new avw().bb(new byte[0]);
        bmh com_tencent_mm_protocal_c_bmh = new bmh();
        ekVar.tiu = com_tencent_mm_protocal_c_bmh;
        com_tencent_mm_protocal_c_bmh.tjW = "";
        com_tencent_mm_protocal_c_bmh.tjV = "";
        com_tencent_mm_protocal_c_bmh.ulQ = "";
        bpn com_tencent_mm_protocal_c_bpn = new bpn();
        ekVar.tiv = com_tencent_mm_protocal_c_bpn;
        com_tencent_mm_protocal_c_bpn.tHj = "";
        com_tencent_mm_protocal_c_bpn.tHi = "";
        if (h.vG().uV()) {
            String oVar;
            byte[] bArr;
            h.vJ();
            String mz = bg.mz((String) h.vI().vr().get(2, null));
            h.vJ();
            o oVar2 = new o(bg.a((Integer) h.vI().vr().get(9, null), 0));
            if (bg.mA(mz)) {
                oVar = oVar2.toString();
            } else {
                oVar = mz;
            }
            h.vJ();
            byte[] a = h.vG().gXc.a(oVar2.longValue(), "", this.hmn == 701);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]";
            Object[] objArr = new Object[4];
            objArr[0] = oVar;
            objArr[1] = oVar2;
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = a == null ? "null" : bg.Qj(bg.bl(a));
            w.i(str, str2, objArr);
            avw com_tencent_mm_protocal_c_avw = new avw();
            if (bg.bm(a)) {
                bArr = new byte[0];
            } else {
                bArr = a;
            }
            ekVar.tit = com_tencent_mm_protocal_c_avw.bb(bArr);
            if (this.hmn == 702) {
                com.tencent.mm.protocal.i.a aVar = (com.tencent.mm.protocal.i.a) fVar;
                b bVar = (b) gVar;
                du duVar = new du();
                dx dxVar = new dx();
                aVar.sZh.thG = dxVar;
                aVar.sZh.thH = duVar;
                bArr = bg.PT(ze.getString("_auth_key", ""));
                dv dvVar = new dv();
                if (bg.bm(bArr)) {
                    com.tencent.mm.plugin.report.c.oTb.a(148, 16, 1, false);
                    duVar.thf = new avw().bb(new byte[0]);
                } else {
                    duVar.thf = new avw().bb(bArr);
                    try {
                        dvVar.aD(bArr);
                    } catch (Throwable e) {
                        com.tencent.mm.plugin.report.c.oTb.a(148, 15, 1, false);
                        w.printErrStackTrace("MicroMsg.MMReqRespAuth", e, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                    }
                }
                if (dvVar.thE != null) {
                    dxVar.thI = dvVar.thE;
                } else {
                    com.tencent.mm.plugin.report.c.oTb.a(148, 17, 1, false);
                    dxVar.thI = new avw().bb(new byte[0]);
                    w.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
                }
                duVar.thy = ekVar;
                aVar.username = oVar;
                bVar.ieb = oVar;
                return this;
            }
            d dVar = (d) fVar;
            akv com_tencent_mm_protocal_c_akv = new akv();
            akt com_tencent_mm_protocal_c_akt = new akt();
            dVar.sZj.tOB = com_tencent_mm_protocal_c_akv;
            dVar.sZj.tOC = com_tencent_mm_protocal_c_akt;
            com_tencent_mm_protocal_c_akt.tOA = 2;
            com_tencent_mm_protocal_c_akt.thy = ekVar;
            com_tencent_mm_protocal_c_akv.jNj = oVar;
            h.vJ();
            mz = bg.mz((String) h.vI().vr().get(3, null));
            h.vJ();
            com_tencent_mm_protocal_c_akv.tjK = bg.mz((String) h.vI().vr().get(19, null));
            com_tencent_mm_protocal_c_akv.tjU = mz;
            return this;
        }
        w.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        return null;
    }

    public final int zd() {
        if (h.vG().uV()) {
            h.vJ();
            h.vG();
            return com.tencent.mm.kernel.a.uH();
        }
        w.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", bg.bJZ());
        return 0;
    }

    public final p aI(int i, int i2) {
        return new aq(i).fb(i2);
    }

    public static void a(a aVar) {
        hmq = aVar;
    }

    public final void a(f fVar, g gVar, int i, int i2, String str) {
        if (h.vG().uV()) {
            bgf com_tencent_mm_protocal_c_bgf = gVar.sZm;
            w.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                if (hmq != null) {
                    hmq.a(fVar, gVar);
                    return;
                }
                return;
            } else if (i == 4 && i2 == -301) {
                com.tencent.mm.plugin.report.c.oTb.a(148, 18, 1, false);
                w.d("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
                if (com_tencent_mm_protocal_c_bgf == null || com_tencent_mm_protocal_c_bgf.ugA == null) {
                    w.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                    return;
                } else {
                    a(true, gVar.sZm.ugA.tjM, gVar.sZm.ugA.tjN, gVar.sZm.ugA.tjL);
                    return;
                }
            } else {
                return;
            }
        }
        w.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
    }

    public static void a(boolean z, hr hrVar, anh com_tencent_mm_protocal_c_anh, afd com_tencent_mm_protocal_c_afd) {
        String str = "MicroMsg.MMReqRespAuth";
        String str2 = "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hrVar == null ? -1 : hrVar.tlO);
        objArr[2] = Integer.valueOf(hrVar == null ? -1 : hrVar.tlP);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_afd == null ? -1 : com_tencent_mm_protocal_c_afd.jNd);
        objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_anh == null ? -1 : com_tencent_mm_protocal_c_anh.tSg);
        objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_anh == null ? -1 : com_tencent_mm_protocal_c_anh.tSh);
        objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_anh == null ? -1 : com_tencent_mm_protocal_c_anh.tSi);
        objArr[7] = com_tencent_mm_protocal_c_anh == null ? "null" : com_tencent_mm_protocal_c_anh.tSe;
        objArr[8] = com_tencent_mm_protocal_c_anh == null ? "null" : com_tencent_mm_protocal_c_anh.tSf;
        w.i(str, str2, objArr);
        if (com_tencent_mm_protocal_c_afd == null || com_tencent_mm_protocal_c_afd.jNe == null || com_tencent_mm_protocal_c_afd.jNe.size() <= 0) {
            w.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bg.bJZ());
        } else if (com_tencent_mm_protocal_c_afd == null || com_tencent_mm_protocal_c_afd.jNe == null || com_tencent_mm_protocal_c_afd.jNe.size() <= 0) {
            w.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bg.bJZ());
        } else {
            hq hqVar;
            List linkedList = new LinkedList();
            linkedList.clear();
            Iterator it = hrVar.tlS.iterator();
            while (it.hasNext()) {
                hqVar = (hq) it.next();
                str = "";
                if (hqVar.tlN != null) {
                    str = hqVar.tlN.bGX();
                }
                linkedList.add(new n(hqVar.type, hqVar.tlM.bGX(), hqVar.port, str));
                w.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(hqVar.type), Integer.valueOf(hqVar.port), hqVar.tlM.bGX());
            }
            str2 = n.bT(linkedList);
            List linkedList2 = new LinkedList();
            Iterator it2 = hrVar.tlR.iterator();
            while (it2.hasNext()) {
                hqVar = (hq) it2.next();
                str = "";
                if (hqVar.tlN != null) {
                    str = hqVar.tlN.bGX();
                }
                linkedList2.add(new n(hqVar.type, hqVar.tlM.bGX(), hqVar.port, str));
                w.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(hqVar.type), Integer.valueOf(hqVar.port), hqVar.tlM.bGX());
            }
            String bT = n.bT(linkedList2);
            w.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", bT, str2);
            h.vJ();
            h.vI().gXW.set(2, str2);
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("system_config_prefs", 0);
            sharedPreferences.edit().putString("builtin_short_ips", str2).commit();
            h.vJ();
            h.vI().gXW.set(3, bT);
            h.vJ();
            h.vI().gXW.set(6, com_tencent_mm_protocal_c_anh.tSe);
            h.vJ();
            h.vI().gXW.set(7, com_tencent_mm_protocal_c_anh.tSf);
            if (com_tencent_mm_protocal_c_anh.tSi != 0) {
                int i;
                h.vJ();
                s sVar = h.vI().gXW;
                if (com_tencent_mm_protocal_c_anh.tSi > 60) {
                    i = 60;
                } else {
                    i = com_tencent_mm_protocal_c_anh.tSi;
                }
                sVar.set(35, Integer.valueOf(i));
            }
            ac.f((long) com_tencent_mm_protocal_c_anh.tSg, (long) com_tencent_mm_protocal_c_anh.tSj);
            com.tencent.mm.protocal.n.a et = n.et(com_tencent_mm_protocal_c_anh.tSe, com_tencent_mm_protocal_c_anh.tSf);
            String str3 = "";
            String str4 = "";
            String[] strArr = new String[com_tencent_mm_protocal_c_afd.jNe.size()];
            String[] strArr2 = new String[com_tencent_mm_protocal_c_afd.jNe.size()];
            int[] iArr = new int[com_tencent_mm_protocal_c_afd.jNe.size()];
            w.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(com_tencent_mm_protocal_c_afd.jNd));
            Iterator it3 = com_tencent_mm_protocal_c_afd.jNe.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                afc com_tencent_mm_protocal_c_afc = (afc) it3.next();
                w.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", com_tencent_mm_protocal_c_afc.tKr, com_tencent_mm_protocal_c_afc.tKs);
                strArr[i2] = com_tencent_mm_protocal_c_afc.tKr;
                strArr2[i2] = com_tencent_mm_protocal_c_afc.tKs;
                iArr[i2] = com_tencent_mm_protocal_c_afc.tKt;
                i2++;
                if (!(bg.mA(com_tencent_mm_protocal_c_afc.tKr) || bg.mA(com_tencent_mm_protocal_c_afc.tKs))) {
                    if (com_tencent_mm_protocal_c_afc.tKr.equals("short.weixin.qq.com")) {
                        h.vJ();
                        h.vI().gXW.set(24, com_tencent_mm_protocal_c_afc.tKs);
                        str4 = com_tencent_mm_protocal_c_afc.tKs;
                    } else if (com_tencent_mm_protocal_c_afc.tKr.equals("long.weixin.qq.com")) {
                        h.vJ();
                        h.vI().gXW.set(25, com_tencent_mm_protocal_c_afc.tKs);
                        str3 = com_tencent_mm_protocal_c_afc.tKs;
                    } else if (com_tencent_mm_protocal_c_afc.tKr.equals("support.weixin.qq.com") && !bg.mA(com_tencent_mm_protocal_c_afc.tKs)) {
                        sharedPreferences.edit().putString("support.weixin.qq.com", com_tencent_mm_protocal_c_afc.tKs).commit();
                    }
                }
            }
            h.vJ();
            com.tencent.mm.network.e eVar = h.vH().gXC.hsZ;
            if (strArr.length > 0 && eVar != null) {
                eVar.setHostInfo(strArr, strArr2, iArr);
            }
            if (!bg.mA(str3)) {
                h.vJ();
                h.vI().gXW.set(25, str3);
            }
            if (!bg.mA(str4)) {
                h.vJ();
                h.vI().gXW.set(24, str4);
            }
            if (eVar != null) {
                eVar.a(z, str2, bT, et.sZI, et.sZJ, et.sZK, et.sZL, str4, str3);
            }
        }
    }

    public static SharedPreferences ze() {
        return ar.ze();
    }

    protected final k.d zf() {
        return this.hmo;
    }

    public final k.e zg() {
        return this.hmp;
    }

    public final int getType() {
        return this.hmo.zi();
    }

    public final String getUri() {
        return this.hmo.getUri();
    }

    public static int b(p pVar) {
        g gVar = (g) pVar.zg();
        w.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(((f) pVar.BG()).zi()), Integer.valueOf(pVar.hashCode()), Integer.valueOf(gVar.sZo), bg.bJZ());
        if (gVar.sZo != 0) {
            w.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(gVar.sZo));
            return gVar.sZo;
        }
        bgf com_tencent_mm_protocal_c_bgf = gVar.sZm;
        int i = com_tencent_mm_protocal_c_bgf.ugx;
        if ((i & 1) != 0) {
            dr drVar = com_tencent_mm_protocal_c_bgf.ugy;
            w.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(drVar.tht), Integer.valueOf(drVar.ths));
            os osVar = drVar.thd;
            byte[] a = com.tencent.mm.platformtools.n.a(drVar.the);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(osVar.thF.tZn);
            objArr[1] = Integer.valueOf(osVar.tuk);
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = bg.Qj(bg.bl(a));
            w.d(str, str2, objArr);
            byte[] a2 = com.tencent.mm.platformtools.n.a(osVar.thF);
            byte[] bArr = r0.sZl;
            if (bg.bm(a2)) {
                com.tencent.mm.plugin.report.c.oTb.a(148, 24, 1, false);
                w.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                a2 = null;
            } else {
                str2 = "MicroMsg.MMReqRespAuth";
                String str3 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a2.length);
                objArr2[1] = bg.Qj(bg.bl(a2));
                objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                objArr2[3] = bg.Qj(bg.bl(bArr));
                w.d(str2, str3, objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(osVar.tuk, a2, bArr, pByteArray, 0);
                a2 = pByteArray.value;
                str = "MicroMsg.MMReqRespAuth";
                str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.length);
                objArr[2] = bg.Qj(bg.bl(a2));
                w.i(str, str2, objArr);
            }
            gVar.sZn = a2 != null ? a2 : new byte[0];
            if ((r12 & 4) != 0) {
                w.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (bg.bm(a2)) {
                    com.tencent.mm.plugin.report.c.oTb.a(148, 26, 1, false);
                    w.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    gVar.aW(new byte[0]);
                    gVar.sZo = 2;
                } else {
                    a2 = MMProtocalJni.aesDecrypt(a, a2);
                    String str4 = "MicroMsg.MMReqRespAuth";
                    str = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                    objArr3[1] = bg.Qj(bg.bl(a));
                    objArr3[2] = Integer.valueOf(a2 == null ? -1 : a2.length);
                    objArr3[3] = bg.Qj(bg.bl(a2));
                    w.d(str4, str, objArr3);
                    if (bg.bm(a2)) {
                        com.tencent.mm.plugin.report.c.oTb.a(148, 25, 1, false);
                        w.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        gVar.aW(new byte[0]);
                        gVar.sZo = 2;
                    } else {
                        w.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", bg.Qj(bg.bl(a2)));
                        gVar.aW(a2);
                        gVar.sZo = 1;
                    }
                }
            } else {
                com.tencent.mm.plugin.report.c.oTb.a(148, 27, 1, false);
                w.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                gVar.aW(a);
                gVar.sZo = 1;
            }
        } else {
            w.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed");
            gVar.aW(new byte[0]);
            gVar.sZo = 2;
        }
        if ((i & 2) != 0) {
            gVar.ieb = com_tencent_mm_protocal_c_bgf.ugz.jNj;
        } else {
            w.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        return gVar.sZo;
    }
}
