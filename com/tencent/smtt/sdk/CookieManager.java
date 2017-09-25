package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager wSD;
    ArrayList<b> wSE;
    String wSF;
    int wSG = a.wSJ;
    private boolean wSH = false;
    private boolean wSI = false;

    public enum a {
        ;

        static {
            wSJ = 1;
            wSK = 2;
            wSL = 3;
            wSM = new int[]{wSJ, wSK, wSL};
        }
    }

    class b {
        String url;
        String value;
        int wSN;
        y<Boolean> wSO;
        final /* synthetic */ CookieManager wSP;

        b(CookieManager cookieManager) {
            this.wSP = cookieManager;
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (wSD == null) {
            synchronized (CookieManager.class) {
                if (wSD == null) {
                    wSD = new CookieManager();
                }
            }
        }
        return wSD;
    }

    public static int getROMCookieDBVersion(Context context) {
        return (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).edit();
        edit.putInt("db_version", i);
        edit.commit();
    }

    public boolean acceptCookie() {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            return android.webkit.CookieManager.getInstance().acceptCookie();
        }
        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        ac cfb = ac.cfb();
        Object invokeStaticMethod;
        if (cfb != null && cfb.cfc()) {
            invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : true;
        } else if (VERSION.SDK_INT < 21) {
            booleanValue = true;
        } else {
            invokeStaticMethod = o.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : false;
        }
        return booleanValue;
    }

    final synchronized void cdO() {
        this.wSI = true;
        if (!(this.wSE == null || this.wSE.size() == 0)) {
            ac cfb = ac.cfb();
            Iterator it;
            b bVar;
            if (cfb != null && cfb.cfc()) {
                it = this.wSE.iterator();
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    switch (bVar.wSN) {
                        case 1:
                            setCookie(bVar.url, bVar.value, bVar.wSO);
                            break;
                        case 2:
                            setCookie(bVar.url, bVar.value);
                            break;
                        default:
                            break;
                    }
                }
            }
            it = this.wSE.iterator();
            while (it.hasNext()) {
                bVar = (b) it.next();
                switch (bVar.wSN) {
                    case 1:
                        if (VERSION.SDK_INT < 21) {
                            break;
                        }
                        o.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, bVar.url, bVar.value, bVar.wSO);
                        break;
                    case 2:
                        android.webkit.CookieManager.getInstance().setCookie(bVar.url, bVar.value);
                        break;
                    default:
                        break;
                }
            }
            this.wSE.clear();
        }
    }

    public void flush() {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (VERSION.SDK_INT >= 21) {
            o.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            try {
                return android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Throwable th) {
                return null;
            }
        }
        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public boolean hasCookies() {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            return android.webkit.CookieManager.getInstance().hasCookies();
        }
        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    protected final synchronized void n(Context context, boolean z) {
        int i = 0;
        synchronized (this) {
            if (!(this.wSG == a.wSJ || context == null || !m.cey().bw(context, "cookie_switch.txt") || this.wSH)) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 0;
                TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:true" + ",useX5:" + z);
                if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.wTf) {
                    z = false;
                }
                boolean bw = m.cey().bw(context, "usex5.txt");
                TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + bw + ",useX5:" + z);
                m.cey().n(context, "usex5.txt", z);
                if (bw != z) {
                    int i2;
                    r.gr(context);
                    com.tencent.smtt.sdk.r.b ceD = r.ceD();
                    if (TextUtils.isEmpty(this.wSF)) {
                        ceD.setErrorCode(701);
                        i2 = 0;
                    } else if (p.ceA().ge(context) <= 0 || p.ceA().ge(context) >= 36001) {
                        boolean z2;
                        int fH;
                        if (bw) {
                            fH = g.fH(context);
                            if (fH > 0) {
                                i2 = getROMCookieDBVersion(context);
                                if (i2 <= 0) {
                                    i = i2;
                                    i2 = fH;
                                    z2 = true;
                                } else {
                                    i = i2;
                                    i2 = fH;
                                    z2 = false;
                                }
                            }
                            i2 = fH;
                            z2 = false;
                        } else {
                            fH = g.fH(context);
                            if (fH > 0) {
                                Object bA = p.ceA().bA(context, "cookies_database_version");
                                if (!TextUtils.isEmpty(bA)) {
                                    try {
                                        i = Integer.parseInt(bA);
                                        i2 = fH;
                                        z2 = false;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            i2 = fH;
                            z2 = false;
                        }
                        if (!z2 && (i2 <= 0 || i <= 0)) {
                            ceD.setErrorCode(702);
                        } else if (i >= i2) {
                            ceD.setErrorCode(703);
                        } else {
                            g.a(context, this.wSG, this.wSF, z2);
                            ceD.setErrorCode(704);
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                    ceD.Vw("x5->sys:" + bw + " from:" + i2 + " to:" + i + ",timeused:" + j);
                    r.gr(context).a(com.tencent.smtt.sdk.r.a.TYPE_COOKIE_DB_SWITCH, ceD);
                }
            }
        }
    }

    public void removeAllCookie() {
        if (this.wSE != null) {
            this.wSE.clear();
        }
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
        }
    }

    public void removeAllCookies(y<Boolean> yVar) {
        if (this.wSE != null) {
            this.wSE.clear();
        }
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, yVar);
        } else if (VERSION.SDK_INT >= 21) {
            o.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, yVar);
        }
    }

    public void removeExpiredCookie() {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookie() {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(y<Boolean> yVar) {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, yVar);
        } else if (VERSION.SDK_INT >= 21) {
            o.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, yVar);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } catch (Throwable th) {
            }
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (VERSION.SDK_INT >= 21) {
            o.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, y<Boolean> yVar) {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            if (!ac.cfb().wTI) {
                b bVar = new b(this);
                bVar.wSN = 1;
                bVar.url = str;
                bVar.value = str2;
                bVar.wSO = yVar;
                if (this.wSE == null) {
                    this.wSE = new ArrayList();
                }
                this.wSE.add(bVar);
            }
            if (this.wSI && VERSION.SDK_INT >= 21) {
                o.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, yVar);
            }
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, yVar);
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            if (this.wSI || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!ac.cfb().wTI) {
                b bVar = new b(this);
                bVar.wSN = 2;
                bVar.url = str;
                bVar.value = str2;
                bVar.wSO = null;
                if (this.wSE == null) {
                    this.wSE = new ArrayList();
                }
                this.wSE.add(bVar);
            }
        } else {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        }
    }

    public boolean setCookieCompatialbeMode$4fb4c7d(Context context, int i, String str, boolean z) {
        System.currentTimeMillis();
        if (context == null || !m.cey().bw(context, "cookie_switch.txt")) {
            return false;
        }
        this.wSG = i;
        if (str != null) {
            this.wSF = str;
        }
        if (!(this.wSG == a.wSJ || !z || ac.cfb().wTI)) {
            ac.cfb().b(context, null);
        }
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        boolean z;
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            z = false;
        } else {
            Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
            z = invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
        }
        if (!z) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
    }
}
