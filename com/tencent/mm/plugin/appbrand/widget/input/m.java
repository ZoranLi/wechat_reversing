package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.e.a;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.input.a.h;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum m {
    ;
    
    public static final Set<String> jtN = null;
    private static final Map<String, WeakReference<x>> jtO = null;
    private static final a<com.tencent.mm.plugin.appbrand.g.m, y> jtP = null;
    public static final Map<String, Integer> jtd = null;

    static {
        Set hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        jtN = Collections.unmodifiableSet(hashSet);
        Map hashMap = new HashMap(3);
        hashMap.put("digit", Integer.valueOf(2));
        hashMap.put("number", Integer.valueOf(0));
        hashMap.put("idcard", Integer.valueOf(1));
        jtd = Collections.unmodifiableMap(hashMap);
        jtO = new HashMap();
        jtP = new a();
    }

    public static void a(MMActivity mMActivity) {
        if (mMActivity != null && mMActivity.getWindow() != null) {
            mMActivity.getWindow().setSoftInputMode(16);
        }
    }

    @TargetApi(20)
    public static void a(MMActivity mMActivity, View view) {
        if (mMActivity != null && mMActivity.getWindow() != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
            mMActivity.getWindow().getDecorView();
            View lVar = new l(mMActivity, view);
            viewGroup.addView(lVar, new LayoutParams(-1, -1));
            if (VERSION.SDK_INT < 20) {
                Point point = new Point();
                mMActivity.getWindowManager().getDefaultDisplay().getSize(point);
                lVar.jtF = point.y - e.ds(mMActivity);
            }
            a.a(mMActivity, viewGroup);
        }
    }

    public static void h(com.tencent.mm.plugin.appbrand.g.m mVar) {
        if (mVar != null) {
            j jVar = new j(mVar);
        }
    }

    public static void a(final String str, final x xVar) {
        if (!bg.mA(str) && xVar != null) {
            d.runOnUiThread(new Runnable() {
                public final void run() {
                    m.jtO.put(str, new WeakReference(xVar));
                }
            });
        }
    }

    static x rm(String str) {
        WeakReference weakReference = (WeakReference) jtO.get(str);
        return weakReference == null ? null : (x) weakReference.get();
    }

    public static void a(final com.tencent.mm.plugin.appbrand.g.m mVar, final String str, final Integer num) {
        if (mVar != null) {
            d.runOnUiThread(new Runnable() {
                public final void run() {
                    y yVar = (y) m.jtP.get(mVar);
                    if (yVar != null) {
                        x rm = m.rm(yVar.Yi());
                        if (rm != null) {
                            rm.b(str, num);
                        }
                    }
                }
            });
        }
    }

    @Deprecated
    public static boolean a(h hVar, String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.AppBrandInputService", "updateInputStyle, inputId is Null Or Nil");
            return false;
        }
        WeakReference weakReference = (WeakReference) jtO.get(str);
        x xVar = weakReference == null ? null : (x) weakReference.get();
        g gVar = xVar instanceof g ? (g) xVar : null;
        if (gVar != null) {
            boolean z;
            if (gVar.jsQ == null || gVar.jsS == null) {
                z = false;
            } else {
                gVar.jsQ.a(hVar);
                if (gVar.jsQ.jwV || (gVar.jsQ.jwZ != null && gVar.jsQ.jwZ.intValue() > 0)) {
                    gVar.jsS.setWillNotDraw(true);
                    gVar.cs(false);
                    gVar.jsS.setWillNotDraw(false);
                    gVar.jsS.invalidate();
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(com.tencent.mm.plugin.appbrand.g.m mVar) {
        return c(mVar, null);
    }

    public static boolean c(com.tencent.mm.plugin.appbrand.g.m mVar, String str) {
        if (bg.mA(str)) {
            y yVar = (y) jtP.get(mVar);
            if (yVar == null) {
                return false;
            }
            str = yVar.Yi();
        }
        if (bg.mA(str)) {
            return false;
        }
        x rm = rm(str);
        return rm != null && rm.Ys();
    }

    public static boolean a(com.tencent.mm.plugin.appbrand.g.m mVar, String str, int i) {
        x rm = rm(str);
        return rm != null && rm.f(mVar) && rm.iK(i);
    }

    public static void j(final com.tencent.mm.plugin.appbrand.g.m mVar) {
        af.v(new Runnable() {
            public final void run() {
                m.i(mVar);
            }
        });
    }

    public static boolean rn(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.AppBrandInputService", "removeInput, inputId is Null Or Nil");
            return false;
        }
        x rm = rm(str);
        if (rm == null || !rm.Yl()) {
            return false;
        }
        return true;
    }

    public static void a(final com.tencent.mm.plugin.appbrand.g.m mVar, final y yVar) {
        if (mVar != null) {
            d.runOnUiThread(new Runnable() {
                public final void run() {
                    m.jtP.put(mVar, yVar);
                }
            });
        }
    }

    static void k(final com.tencent.mm.plugin.appbrand.g.m mVar) {
        if (mVar != null) {
            d.runOnUiThread(new Runnable() {
                public final void run() {
                    m.jtP.remove(mVar);
                }
            });
        }
    }

    static x l(com.tencent.mm.plugin.appbrand.g.m mVar) {
        if (mVar == null) {
            return null;
        }
        y yVar = (y) jtP.get(mVar);
        if (yVar == null) {
            return null;
        }
        if (bg.mA(yVar.Yi())) {
            return null;
        }
        return rm(yVar.Yi());
    }
}
