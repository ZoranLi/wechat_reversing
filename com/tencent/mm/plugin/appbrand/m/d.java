package com.tencent.mm.plugin.appbrand.m;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.d.g;
import com.tencent.mm.vending.h.h;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class d {
    private static volatile af hta;
    private static final Object jnL = new Object();
    private static final Set<Object> jnM = new HashSet();
    private static final char[] jnN = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] jnO = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};

    public static void XG() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        ab.getContext().sendBroadcast(intent);
    }

    public static <T, L extends List<T>> L d(L l, int i) {
        int i2 = 0;
        if (l == null) {
            return null;
        }
        if (i <= 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "startInclusive %d >= endExclusive %d !!!", new Object[]{Integer.valueOf(0), Integer.valueOf(i)}));
        }
        try {
            List list = (List) l.getClass().newInstance();
            ListIterator listIterator = l.listIterator(0);
            while (listIterator.hasNext()) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    return list;
                }
                list.add(listIterator.next());
                i2 = i3;
            }
            return list;
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandUtil", "createSubList, newInstance of %s, exp = %s", new Object[]{l.getClass().getName(), e});
            return null;
        }
    }

    public static long XH() {
        return bg.Ny();
    }

    public static String e(int i, Object... objArr) {
        return ab.getResources().getString(i, objArr);
    }

    public static <T> T aN(T t) {
        if (t != null) {
            jnM.add(t);
        }
        return t;
    }

    public static void aO(Object obj) {
        if (obj != null) {
            jnM.remove(obj);
        }
    }

    public static void XI() {
        if (hta != null) {
            synchronized (jnL) {
                if (hta != null) {
                    com.tencent.mm.vending.h.g.UC("SubCoreAppBrand#WorkerThread");
                    hta.nJF.quit();
                    hta = null;
                }
            }
        }
    }

    public static af vL() {
        if (hta == null) {
            synchronized (jnL) {
                hta = new af("SubCoreAppBrand#WorkerThread");
                com.tencent.mm.vending.h.g.a("SubCoreAppBrand#WorkerThread", new h(hta.nJF.getLooper(), "SubCoreAppBrand#WorkerThread"));
            }
        }
        return hta;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            af.v(runnable);
        } else {
            runnable.run();
        }
    }

    public static void bD(Context context) {
        if (context instanceof Activity) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{16842936, 16842937});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            ((Activity) context).overridePendingTransition(resourceId, resourceId2);
        }
    }

    public static void bE(Context context) {
        if (context instanceof Activity) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            ((Activity) context).overridePendingTransition(resourceId, resourceId2);
        }
    }

    public static void bF(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(a.uUT, a.uUU);
        }
    }

    public static void r(Map map) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                r((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
    }

    public static String qU(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < jnN.length) {
                String str2 = jnO[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != jnN.length) {
                stringBuffer.append(jnN[i2]);
                i = jnO[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }
}
