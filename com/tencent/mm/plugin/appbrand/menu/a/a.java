package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.menu.j;
import com.tencent.mm.ui.base.l;

public abstract class a {
    public int jaM;

    public abstract void a(Context context, m mVar, l lVar, String str);

    public abstract void a(Context context, m mVar, String str, j jVar);

    public a(int i) {
        this.jaM = i;
    }
}
