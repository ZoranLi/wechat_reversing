package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag extends w {
    private int moU;
    LinkedList<f> sDS;
    private LinkedList<f> sDT;
    private LinkedList<String> sDU;

    public ag(String str, LinkedList<String> linkedList) {
        w.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0" + ", limit = 20, lang = " + str + "installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            w.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", (String) it.next());
        }
        this.moU = 3;
        a aVar = new a();
        aVar.hsm = new abp();
        aVar.hsn = new abq();
        aVar.uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
        aVar.hsl = 409;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        abp com_tencent_mm_protocal_c_abp = (abp) this.ldw.hsj.hsr;
        com_tencent_mm_protocal_c_abp.msx = 3;
        com_tencent_mm_protocal_c_abp.muw = 0;
        com_tencent_mm_protocal_c_abp.mux = 20;
        com_tencent_mm_protocal_c_abp.mtJ = str;
        LinkedList au = au(linkedList);
        com_tencent_mm_protocal_c_abp.tHn = au.size();
        com_tencent_mm_protocal_c_abp.mue = au;
        this.sDS = new LinkedList();
        this.sDT = new LinkedList();
        this.sDU = new LinkedList();
        this.sDU.addAll(linkedList);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            abq com_tencent_mm_protocal_c_abq = (abq) this.ldw.hsk.hsr;
            if (com_tencent_mm_protocal_c_abq == null) {
                w.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
                return;
            }
            w.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", Integer.valueOf(com_tencent_mm_protocal_c_abq.tHo), Integer.valueOf(this.moU));
            i aRt = com.tencent.mm.plugin.w.a.a.a.aRv().aRt();
            b(aRt, com_tencent_mm_protocal_c_abq.tHp);
            a(aRt, com_tencent_mm_protocal_c_abq.mvj);
            return;
        }
        w.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
    }

    private void a(i iVar, LinkedList<aw> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Object obj;
                aw awVar = (aw) it.next();
                f aJ = g.aJ(awVar.msh, true);
                if (aJ != null) {
                    a(aJ, awVar);
                    iVar.a(aJ, new String[0]);
                    obj = aJ;
                } else {
                    aJ = new f();
                    aJ.field_appId = awVar.msh;
                    a(aJ, awVar);
                    iVar.l(aJ);
                    f fVar = aJ;
                }
                this.sDT.add(obj);
            }
        }
    }

    private void b(i iVar, LinkedList<atl> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                atl com_tencent_mm_protocal_c_atl = (atl) it.next();
                if (bg.mA(com_tencent_mm_protocal_c_atl.msh)) {
                    w.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
                } else {
                    Object obj;
                    boolean z = true;
                    boolean z2 = false;
                    f aJ = g.aJ(com_tencent_mm_protocal_c_atl.msh, true);
                    String str;
                    String str2;
                    Object[] objArr;
                    if (aJ != null) {
                        boolean z3;
                        a(aJ, com_tencent_mm_protocal_c_atl);
                        if (this.moU == 3) {
                            aJ.field_status = 5;
                            if (bg.mA(aJ.gfk) || bg.mA(aJ.gfj)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params1, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(aJ.gfk != null);
                                objArr[1] = Boolean.valueOf(aJ.gfj != null);
                                w.e(str, str2, objArr);
                                z2 = false;
                                z3 = false;
                                w.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_atl.msh, Boolean.valueOf(z3), Boolean.valueOf(z2));
                                obj = aJ;
                            }
                        }
                        z3 = iVar.a(aJ, new String[0]);
                        z2 = true;
                        w.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_atl.msh, Boolean.valueOf(z3), Boolean.valueOf(z2));
                        obj = aJ;
                    } else {
                        f fVar;
                        aJ = new f();
                        aJ.field_appId = com_tencent_mm_protocal_c_atl.msh;
                        a(aJ, com_tencent_mm_protocal_c_atl);
                        if (this.moU == 3) {
                            aJ.field_status = 5;
                            if (bg.mA(aJ.gfk) || bg.mA(aJ.gfj)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params2, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(aJ.gfk != null);
                                objArr[1] = Boolean.valueOf(aJ.gfj != null);
                                w.e(str, str2, objArr);
                                z = false;
                                w.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_atl.msh, Boolean.valueOf(z2), Boolean.valueOf(z));
                                fVar = aJ;
                                z2 = z;
                            }
                        }
                        z2 = iVar.l(aJ);
                        w.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", com_tencent_mm_protocal_c_atl.msh, Boolean.valueOf(z2), Boolean.valueOf(z));
                        fVar = aJ;
                        z2 = z;
                    }
                    if (!(!z2 || this.sDU.contains(com_tencent_mm_protocal_c_atl.msh) || this.sDS.contains(obj))) {
                        this.sDS.add(obj);
                    }
                }
            }
        }
    }

    private static LinkedList<avx> au(LinkedList<String> linkedList) {
        LinkedList<avx> linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bg.mA(str)) {
                linkedList2.add(n.mw(str));
            }
        }
        return linkedList2;
    }

    private static void a(f fVar, atl com_tencent_mm_protocal_c_atl) {
        fVar.bD(com_tencent_mm_protocal_c_atl.ted);
        fVar.field_appIconUrl = com_tencent_mm_protocal_c_atl.tee;
        fVar.bC(com_tencent_mm_protocal_c_atl.tXq);
        fVar.field_appName = com_tencent_mm_protocal_c_atl.muS;
        fVar.bE(com_tencent_mm_protocal_c_atl.tef);
        fVar.field_appType = com_tencent_mm_protocal_c_atl.tgZ;
        fVar.bG(com_tencent_mm_protocal_c_atl.msT);
        fVar.field_packageName = com_tencent_mm_protocal_c_atl.teg;
        fVar.bH(com_tencent_mm_protocal_c_atl.teh);
        if (!bg.mA(com_tencent_mm_protocal_c_atl.teh)) {
            w.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", com_tencent_mm_protocal_c_atl.teh, Integer.valueOf(com_tencent_mm_protocal_c_atl.tXA));
            fVar.da(com_tencent_mm_protocal_c_atl.tXA);
        }
        fVar.bI(com_tencent_mm_protocal_c_atl.tXx);
        fVar.bJ(com_tencent_mm_protocal_c_atl.tXy);
        a(fVar, com_tencent_mm_protocal_c_atl.tei);
        if (!bg.mA(fVar.field_appType)) {
            if (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6")) {
                if (!fVar.field_appType.endsWith(",")) {
                    fVar.field_appType += ",";
                }
                fVar.field_appType = "," + fVar.field_appType;
            }
        }
    }

    private static void a(f fVar, bqx com_tencent_mm_protocal_c_bqx) {
        w.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", fVar.field_appId);
        if (com_tencent_mm_protocal_c_bqx != null) {
            fVar.da(com_tencent_mm_protocal_c_bqx.uoT);
            fVar.bM(com_tencent_mm_protocal_c_bqx.tky);
            fVar.bN(com_tencent_mm_protocal_c_bqx.mvX);
            fVar.bK(com_tencent_mm_protocal_c_bqx.uoU);
            fVar.bL(com_tencent_mm_protocal_c_bqx.mvZ);
            fVar.gfq = com_tencent_mm_protocal_c_bqx.mwa;
            fVar.gey = true;
            fVar.db(com_tencent_mm_protocal_c_bqx.mwb);
            w.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bqx.uoT), com_tencent_mm_protocal_c_bqx.tky, com_tencent_mm_protocal_c_bqx.mvX, com_tencent_mm_protocal_c_bqx.uoU, com_tencent_mm_protocal_c_bqx.mvZ, com_tencent_mm_protocal_c_bqx.mwa, Integer.valueOf(com_tencent_mm_protocal_c_bqx.mwb));
        }
    }

    private static void a(f fVar, aw awVar) {
        fVar.bD(awVar.ted);
        fVar.bG(awVar.msT);
        fVar.bE(awVar.tef);
        fVar.field_appName = awVar.muS;
        fVar.field_appIconUrl = awVar.tee;
        fVar.bH(awVar.teh);
        fVar.gfs = awVar.tej;
        fVar.gey = true;
        a(fVar, awVar.tei);
    }

    public final byte[] aBv() {
        try {
            return ((b) this.ldw.BG()).zh();
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
            return null;
        }
    }

    public final void ar(byte[] bArr) {
        if (bArr == null) {
            w.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
            return;
        }
        try {
            this.ldw.hsk.y(bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 4;
    }
}
