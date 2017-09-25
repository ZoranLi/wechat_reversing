package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class l {
    private static l jaK;
    private Map<Integer, a> jaL = new HashMap();

    private static l Vk() {
        if (jaK == null) {
            synchronized (l.class) {
                if (jaK == null) {
                    jaK = new l();
                }
            }
        }
        return jaK;
    }

    private l() {
        a(new a());
        a(new e());
        a(new MenuDelegate_SendToDesktop());
        a(new f());
        a(new h());
        a(new i());
        a(new MenuDelegate_EnableDebug());
        a(new g());
        a(new d());
        a(new c());
        a(new b());
    }

    public static boolean a(Context context, m mVar, com.tencent.mm.ui.base.l lVar, String str, j jVar) {
        if (jVar == null) {
            return false;
        }
        a aVar = (a) Vk().jaL.get(Integer.valueOf(jVar.id));
        if (aVar == null) {
            return false;
        }
        aVar.a(context, mVar, lVar, str);
        return true;
    }

    public static boolean b(Context context, m mVar, String str, j jVar) {
        if (jVar == null) {
            return false;
        }
        a aVar = (a) Vk().jaL.get(Integer.valueOf(jVar.id));
        if (aVar == null) {
            return false;
        }
        aVar.a(context, mVar, str, jVar);
        return true;
    }

    public static List<j> pO(String str) {
        boolean z = true;
        List<j> linkedList = new LinkedList();
        b(linkedList, k.jay - 1, true);
        b(linkedList, k.jaE - 1, false);
        AppBrandSysConfig mY = b.mY(str);
        boolean z2 = !com.tencent.mm.sdk.a.b.bIu() && (mY == null || mY.iFk.izV == 1);
        b(linkedList, k.jaF - 1, z2);
        b(linkedList, k.jaG - 1, false);
        b(linkedList, k.jaA - 1, false);
        b(linkedList, k.jaC - 1, false);
        b(linkedList, k.jaI - 1, false);
        b(linkedList, k.jaB - 1, false);
        int i = k.jaH - 1;
        if (com.tencent.mm.sdk.a.b.bIu()) {
            z = false;
        }
        b(linkedList, i, z);
        b(linkedList, k.jaD - 1, false);
        return linkedList;
    }

    public static boolean a(List<j> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (j jVar : list) {
            if (jVar != null && jVar.id == i) {
                jVar.jax = z;
                return true;
            }
        }
        return false;
    }

    public static j c(List<j> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (j jVar : list) {
            if (jVar != null && jVar.id == i) {
                return jVar;
            }
        }
        return null;
    }

    private static void b(List<j> list, int i, boolean z) {
        j jVar = new j(i);
        jVar.jax = z;
        list.add(jVar);
    }

    private void a(a aVar) {
        this.jaL.put(Integer.valueOf(aVar.jaM), aVar);
    }
}
