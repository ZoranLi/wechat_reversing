package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;

public final class f {
    public static int a(m mVar, View view) {
        return (mVar.hashCode() + "#" + System.currentTimeMillis() + "#" + view.hashCode()).hashCode();
    }
}
