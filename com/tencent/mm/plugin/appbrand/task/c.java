package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedHashMap;

final class c {
    String jhS;
    Class jhT;
    private Class jhU;
    LinkedHashMap<String, Integer> jhV = new LinkedHashMap();
    LinkedHashMap<String, AppBrandRemoteTaskController> jhW = new LinkedHashMap();

    c(Class cls, Class cls2) {
        this.jhS = cls.getName();
        this.jhT = cls;
        this.jhU = cls2;
    }

    final void wn() {
        Intent intent = new Intent();
        intent.setClass(ab.getContext(), this.jhU);
        ab.getContext().sendBroadcast(intent);
    }

    final void a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        this.jhV.put(str, Integer.valueOf(i));
        this.jhW.put(str, appBrandRemoteTaskController);
    }

    final AppBrandRemoteTaskController qO(String str) {
        return (AppBrandRemoteTaskController) this.jhW.get(str);
    }
}
