package com.tencent.mm.plugin.appbrand.task;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class b {
    private static LinkedList<c> jhP;
    private static c jhQ = new c(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class);

    static {
        LinkedList linkedList = new LinkedList();
        jhP = linkedList;
        linkedList.add(new c(AppBrandUI.class, AppBrandTaskPreloadReceiver.class));
        jhP.add(new c(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class));
        jhP.add(new c(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class));
        jhP.add(new c(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class));
        jhP.add(new c(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class));
    }

    public static void a(Context context, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        c cVar;
        if (appBrandInitConfig.iEH) {
            cVar = jhQ;
        } else {
            cVar = qK(appBrandInitConfig.appId);
            if (cVar == null) {
                cVar = WH();
                a(cVar);
            }
        }
        cVar.a(appBrandInitConfig.appId, appBrandInitConfig.izM, null);
        if (context == null) {
            context = ab.getContext();
        }
        Intent intent = new Intent(context, cVar.jhT);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfig);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
        if ((appBrandStatObject == null ? 0 : appBrandStatObject.scene) == 1023) {
            d.bD(context);
        } else {
            d.bF(context);
        }
    }

    public static void an(String str, int i) {
        c qK = qK(str);
        if (qK != null && ((Integer) qK.jhV.get(str)).intValue() == i && qK.qO(str) != null) {
            qK.qO(str).qH(str);
        }
    }

    public static void ir(int i) {
        Iterator it = WI().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : ((c) it.next()).jhW.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.jhy = a.jhH;
                    appBrandRemoteTaskController.jhz = i;
                    appBrandRemoteTaskController.SL();
                }
            }
        }
    }

    public static void qI(String str) {
        c qK = qK(str);
        if (qK != null && qK.qO(str) != null) {
            qK.qO(str).qH(str);
        }
    }

    public static void WG() {
        if (a.QJ()) {
            WH().wn();
        }
    }

    public static void qJ(String str) {
        final c qL = qL(str);
        if (qL != null) {
            af.f(new Runnable() {
                public final void run() {
                    qL.wn();
                }
            }, 500);
        }
    }

    public static void onNetworkChange() {
        Iterator it = WI().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : ((c) it.next()).jhW.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.jhy = a.jhL;
                    appBrandRemoteTaskController.SL();
                }
            }
        }
    }

    private static c WH() {
        c cVar;
        for (int i = 0; i < jhP.size(); i++) {
            if (((c) jhP.get(i)).jhV.keySet().isEmpty()) {
                cVar = (c) jhP.get(i);
                break;
            }
        }
        cVar = null;
        return cVar != null ? cVar : (c) jhP.getFirst();
    }

    private static c qK(String str) {
        Iterator it = WI().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.jhV.keySet().contains(str)) {
                return cVar;
            }
        }
        return null;
    }

    static c qL(String str) {
        Iterator it = WI().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.jhS.equals(str)) {
                return cVar;
            }
        }
        Assert.assertTrue(false);
        return null;
    }

    static c bf(String str, String str2) {
        Iterator it = WI().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.jhV.keySet().contains(str) && cVar.jhS.equals(str2)) {
                return cVar;
            }
        }
        return null;
    }

    public static boolean qM(String str) {
        c qK = qK(str);
        if (!(qK == null || qK.qO(str) == null)) {
            AppBrandRemoteTaskController qO = qK.qO(str);
            qO.jhy = a.jhK;
            if (qO.SL()) {
                return true;
            }
        }
        return false;
    }

    private static LinkedList<c> WI() {
        LinkedList<c> linkedList = new LinkedList();
        linkedList.addAll(jhP);
        linkedList.add(jhQ);
        return linkedList;
    }

    static void qN(String str) {
        c qK = qK(str);
        if (qK != null) {
            qK.jhV.remove(str);
            qK.jhW.remove(str);
            if (qK.jhV.keySet().isEmpty() && jhP.contains(qK)) {
                jhP.remove(qK);
                jhP.addFirst(qK);
            }
        }
    }

    static void a(c cVar) {
        if (jhP.contains(cVar)) {
            jhP.remove(cVar);
            jhP.addLast(cVar);
        }
    }
}
