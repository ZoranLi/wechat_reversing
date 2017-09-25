package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bg;

public final class o {
    public final j rYn = new j();
    public final SparseArray<Object> rYo = new SparseArray();
    public final SparseArray<Boolean> rYp = new SparseArray();

    private static final class a {
        public static final o rYq = new o();
    }

    public static boolean a(String str, d dVar, int i) {
        o oVar = a.rYq;
        bg.mA(str);
        return false;
    }
}
