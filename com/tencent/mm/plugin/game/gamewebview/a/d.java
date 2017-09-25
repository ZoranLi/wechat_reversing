package com.tencent.mm.plugin.game.gamewebview.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.Window;
import android.webkit.URLUtil;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d {
    private static volatile af hta;
    private static final Object jnL = new Object();
    private static final Set<Object> jnM = new HashSet();

    public static <T> T aN(T t) {
        jnM.add(t);
        return t;
    }

    public static void aO(Object obj) {
        if (obj != null) {
            jnM.remove(obj);
        }
    }

    public static af vL() {
        if (hta == null) {
            synchronized (jnL) {
                hta = new af("SubCoreAppBrand#WorkerThread");
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

    public static boolean xt(String str) {
        return !bg.mA(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static String U(Context context, String str) {
        return s.aZ(context, str) + " GameWebView";
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

    public static String d(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        r(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public static WebViewJSSDKFileItem xu(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.GameWebViewUtil", "get by local id error, local id is null or nil");
            return null;
        } else if (ab.bJb()) {
            return f.bwZ().IS(str);
        } else {
            GWMainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 3;
            Bundle bundle = new Bundle();
            bundle.putString("localId", str);
            commonLogicTask.lHw = bundle;
            GameWebViewMainProcessService.b(commonLogicTask);
            return (WebViewJSSDKFileItem) commonLogicTask.lHw.getParcelable("item");
        }
    }

    public static String xv(String str) {
        String str2 = null;
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                str2 = matcher.group(1);
            }
        } catch (Exception e) {
            w.e("MicroMsg.GameWebViewUtil", "getFileNameFromContentDisposition error " + e.getMessage());
        }
        return str2;
    }

    public static JSONObject pb(String str) {
        if (bg.mA(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            w.e("MicroMsg.GameWebViewUtil", e.getMessage());
            return null;
        }
    }

    public static boolean azg() {
        if (ab.bJb()) {
            return ap.zb();
        }
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 6;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.lHw.getBoolean("has_set_uin", false);
    }

    public static int ab(int i, String str) {
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else {
                i = 1;
            }
        }
        w.i("MicroMsg.GameWebViewUtil", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(i)});
        return i;
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

    public static void bF(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(a.uUT, a.uUU);
        }
    }

    public static void b(Context context, int i, String str) {
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            if (VERSION.SDK_INT >= 23 && !h.sf()) {
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                if ("black".equals(str)) {
                    systemUiVisibility |= 8192;
                } else {
                    systemUiVisibility &= -8193;
                }
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            } else if (VERSION.SDK_INT < 21) {
                return;
            } else {
                if ("black".equals(str)) {
                    i = ((((((int) ((((float) ((i >> 24) & 255)) * 0.78f) + 56.100006f)) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * 0.78f) + 0.0f)) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * 0.78f) + 0.0f)) & 255) << 8)) | ((((int) ((((float) (i & 255)) * 0.78f) + 0.0f)) & 255) << 0);
                }
            }
            window.setStatusBarColor(i);
        }
    }
}
