package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao implements t, e {
    private static ao sEu;
    public String lang;
    public int sEA = 0;
    public long sEB;
    public boolean sEv = false;
    public boolean sEw = false;
    private List<String> sEx = new LinkedList();
    public long sEy;
    private final int sEz = 20;

    private ao() {
    }

    public static ao bDn() {
        if (sEu == null) {
            sEu = new ao();
        }
        return sEu;
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (ap.zb()) {
            this.sEv = false;
            w.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (wVar == null) {
                w.e("MicroMsg.SuggestionAppListLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (wVar.getType()) {
                    case 4:
                        w.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", Integer.valueOf(((abq) ((ag) wVar).ldw.hsk.hsr).tHo));
                        LinkedList linkedList = r13.sDS;
                        if (linkedList == null || linkedList.size() <= 0) {
                            w.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                            return;
                        } else if (ab.getContext() == null || a.aRv() == null) {
                            w.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                            return;
                        } else {
                            f fVar;
                            LinkedList linkedList2 = new LinkedList();
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                fVar = (f) it.next();
                                String str2 = "MicroMsg.SuggestionAppListLogic";
                                String str3 = "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = fVar.field_appName;
                                objArr[1] = fVar.field_packageName;
                                objArr[2] = fVar.field_signature;
                                objArr[3] = fVar.gfk;
                                objArr[4] = Boolean.valueOf(fVar.gfj != null);
                                w.d(str2, str3, objArr);
                                linkedList2.add(fVar.field_appId);
                            }
                            a.aRv().Z(linkedList2);
                            List<f> dy = g.dy(ab.getContext());
                            if (dy.size() > 0) {
                                i aRt = a.aRv().aRt();
                                for (f fVar2 : dy) {
                                    if (fVar2.field_appId != null) {
                                        Object obj;
                                        Iterator it2 = linkedList.iterator();
                                        while (it2.hasNext()) {
                                            fVar = (f) it2.next();
                                            if (fVar.field_appId != null && fVar2.field_appId.equals(fVar.field_appId)) {
                                                obj = 1;
                                                if (obj != null) {
                                                    if (g.a(ab.getContext(), fVar2)) {
                                                        fVar2.field_status = 4;
                                                    } else {
                                                        fVar2.field_status = 1;
                                                    }
                                                    aRt.a(fVar2, new String[0]);
                                                }
                                            }
                                        }
                                        obj = null;
                                        if (obj != null) {
                                            if (g.a(ab.getContext(), fVar2)) {
                                                fVar2.field_status = 4;
                                            } else {
                                                fVar2.field_status = 1;
                                            }
                                            aRt.a(fVar2, new String[0]);
                                        }
                                    }
                                }
                            }
                            ap.yY();
                            c.vr().setLong(352275, System.currentTimeMillis());
                            this.sEy = System.currentTimeMillis();
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    public final void dA(Context context) {
        if (!ap.zb() || context == null) {
            return;
        }
        if (this.sEw) {
            w.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            return;
        }
        this.sEw = true;
        if (this.lang == null) {
            this.lang = v.d(context.getSharedPreferences(ab.bIX(), 0));
        }
        w.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
        cx(this.lang, this.sEA);
    }

    public static void cx(String str, int i) {
        w.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", Integer.valueOf(i), str);
        ap.vd().a(new af(i, str), 0);
    }

    public final void reset() {
        w.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
        ap.yY();
        c.vr().setLong(352276, 0);
        this.sEB = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (ap.zb()) {
            this.sEw = false;
            if (kVar == null) {
                w.e("MicroMsg.SuggestionAppListLogic", "scene == null");
                this.sEA = 0;
                this.sEx.clear();
                return;
            } else if (i == 0 && i2 == 0) {
                w.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                af afVar = (af) kVar;
                ajz com_tencent_mm_protocal_c_ajz = (afVar.gUA == null || afVar.gUA.hsk.hsr == null) ? null : (ajz) afVar.gUA.hsk.hsr;
                if (com_tencent_mm_protocal_c_ajz == null) {
                    w.e("MicroMsg.SuggestionAppListLogic", "resp == null");
                    this.sEA = 0;
                    this.sEx.clear();
                    return;
                } else if (com_tencent_mm_protocal_c_ajz.tNB == null || com_tencent_mm_protocal_c_ajz.tNB.size() <= 0) {
                    w.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                    a(a.aRv().aRt(), this.sEx);
                    this.sEA = 0;
                    this.sEx.clear();
                    ap.yY();
                    c.vr().setLong(352276, System.currentTimeMillis());
                    this.sEB = System.currentTimeMillis();
                    return;
                } else {
                    w.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", Integer.valueOf(this.sEA), Integer.valueOf(com_tencent_mm_protocal_c_ajz.tNB.size()));
                    i aRt = a.aRv().aRt();
                    List linkedList = new LinkedList();
                    Iterator it = com_tencent_mm_protocal_c_ajz.tNB.iterator();
                    while (it.hasNext()) {
                        aka com_tencent_mm_protocal_c_aka = (aka) it.next();
                        w.v("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", com_tencent_mm_protocal_c_aka.tpM, Integer.valueOf(com_tencent_mm_protocal_c_aka.tNG), Integer.valueOf(com_tencent_mm_protocal_c_aka.tNK), Integer.valueOf(com_tencent_mm_protocal_c_aka.tNJ), Integer.valueOf(com_tencent_mm_protocal_c_aka.tNH), com_tencent_mm_protocal_c_aka.fTO);
                        if (!bg.mA(com_tencent_mm_protocal_c_aka.fTO)) {
                            if (f.sDg.equals(com_tencent_mm_protocal_c_aka.fTO)) {
                                com_tencent_mm_protocal_c_aka.tNH = (com_tencent_mm_protocal_c_aka.tNH ^ 253) ^ -1;
                                w.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", Integer.valueOf(com_tencent_mm_protocal_c_aka.tNH));
                            }
                            this.sEx.add(com_tencent_mm_protocal_c_aka.fTO);
                            f aJ = g.aJ(com_tencent_mm_protocal_c_aka.fTO, true);
                            if (aJ != null) {
                                Object obj = aJ.field_serviceAppInfoFlag != com_tencent_mm_protocal_c_aka.tNH ? 1 : aJ.field_serviceAppType != com_tencent_mm_protocal_c_aka.tNG ? 1 : aJ.gfx != com_tencent_mm_protocal_c_aka.tNJ ? 1 : aJ.field_serviceShowFlag != com_tencent_mm_protocal_c_aka.tNK ? 1 : !bg.mz(aJ.field_appName).equals(bg.mz(com_tencent_mm_protocal_c_aka.tpM)) ? 1 : !bg.mz(aJ.field_appName_en).equals(bg.mz(com_tencent_mm_protocal_c_aka.tNC)) ? 1 : !bg.mz(aJ.field_appName_tw).equals(bg.mz(com_tencent_mm_protocal_c_aka.tND)) ? 1 : !bg.mz(aJ.field_appName_hk).equals(bg.mz(com_tencent_mm_protocal_c_aka.tNO)) ? 1 : !bg.mz(aJ.gfv).equals(bg.mz(com_tencent_mm_protocal_c_aka.tNF)) ? 1 : !bg.mz(aJ.gfu).equals(bg.mz(com_tencent_mm_protocal_c_aka.tNE)) ? 1 : !bg.mz(aJ.gfw).equals(bg.mz(com_tencent_mm_protocal_c_aka.tNI)) ? 1 : null;
                                if (obj != null) {
                                    String str2 = aJ.gfv;
                                    String str3 = aJ.gfu;
                                    a(aJ, com_tencent_mm_protocal_c_aka);
                                    boolean a = aRt.a(aJ, new String[0]);
                                    if (!bg.mz(str2).equals(bg.mz(com_tencent_mm_protocal_c_aka.tNF))) {
                                        w.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bg.mz(com_tencent_mm_protocal_c_aka.tNF));
                                        an.aRp().cu(aJ.field_appId, 5);
                                    }
                                    if (!bg.mz(str3).equals(bg.mz(com_tencent_mm_protocal_c_aka.tNE))) {
                                        w.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bg.mz(com_tencent_mm_protocal_c_aka.tNE));
                                        an.aRp().cu(aJ.field_appId, 4);
                                    }
                                    w.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", com_tencent_mm_protocal_c_aka.fTO, Boolean.valueOf(a));
                                }
                            } else {
                                aJ = new f();
                                aJ.field_appId = com_tencent_mm_protocal_c_aka.fTO;
                                a(aJ, com_tencent_mm_protocal_c_aka);
                                boolean l = aRt.l(aJ);
                                w.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", com_tencent_mm_protocal_c_aka.fTO, Boolean.valueOf(l));
                            }
                            if (bg.mA(aJ.field_openId)) {
                                linkedList.add(com_tencent_mm_protocal_c_aka.fTO);
                            }
                        }
                    }
                    if (linkedList.size() > 0) {
                        w.d("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", Integer.valueOf(linkedList.size()));
                        an.aRs().bQ(linkedList);
                    }
                    if (com_tencent_mm_protocal_c_ajz.tNB.size() == 20) {
                        this.sEA += 20;
                        cx(this.lang, this.sEA);
                    } else {
                        a(aRt, this.sEx);
                        this.sEA = 0;
                        this.sEx.clear();
                    }
                    ap.yY();
                    c.vr().setLong(352276, System.currentTimeMillis());
                    this.sEB = System.currentTimeMillis();
                    return;
                }
            } else {
                w.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                this.sEA = 0;
                this.sEx.clear();
                return;
            }
        }
        w.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
        this.sEA = 0;
        this.sEx.clear();
    }

    private static void a(i iVar, List<String> list) {
        if (iVar != null && list != null && list.size() > 0) {
            w.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
            List<f> arrayList = new ArrayList();
            if (a.aRv() == null) {
                w.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            } else {
                Cursor aRu = a.aRv().aRu();
                if (aRu != null) {
                    while (aRu.moveToNext()) {
                        f fVar = new f();
                        fVar.b(aRu);
                        if (!bg.mA(fVar.field_openId)) {
                            arrayList.add(fVar);
                        }
                    }
                    aRu.close();
                }
            }
            w.d("MicroMsg.SuggestionAppListLogic", "oldList %d", Integer.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                for (f fVar2 : arrayList) {
                    if (fVar2.field_appId != null) {
                        int i;
                        for (String equals : list) {
                            if (fVar2.field_appId.equals(equals)) {
                                i = 1;
                                break;
                            }
                        }
                        i = 0;
                        if (i == 0) {
                            boolean b = iVar.b(fVar2, new String[0]);
                            w.d("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", fVar2.field_appId, Boolean.valueOf(b));
                        }
                    }
                }
            }
        }
    }

    private static void a(f fVar, aka com_tencent_mm_protocal_c_aka) {
        fVar.field_appName = com_tencent_mm_protocal_c_aka.tpM;
        fVar.field_appName_en = com_tencent_mm_protocal_c_aka.tNC;
        fVar.field_appName_tw = com_tencent_mm_protocal_c_aka.tND;
        fVar.field_appName_hk = com_tencent_mm_protocal_c_aka.tNO;
        fVar.gfu = com_tencent_mm_protocal_c_aka.tNE;
        fVar.gey = true;
        fVar.gfv = com_tencent_mm_protocal_c_aka.tNF;
        fVar.gey = true;
        fVar.gfw = com_tencent_mm_protocal_c_aka.tNI;
        fVar.gey = true;
        fVar.field_serviceAppInfoFlag = com_tencent_mm_protocal_c_aka.tNH;
        fVar.field_serviceAppType = com_tencent_mm_protocal_c_aka.tNG;
        fVar.gfx = com_tencent_mm_protocal_c_aka.tNJ;
        fVar.gey = true;
        fVar.field_serviceShowFlag = com_tencent_mm_protocal_c_aka.tNK;
    }
}
