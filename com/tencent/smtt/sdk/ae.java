package com.tencent.smtt.sdk;

import android.content.Context;

public final class ae {
    public static boolean wXd = false;
    private static boolean wXe = false;
    private static boolean wXf = false;
    private static boolean wXg = false;
    public WebView vsw = null;
    public Object wXh = null;

    public ae(Context context) {
        boolean gH = gH(context);
        wXd = gH;
        if (gH) {
            this.wXh = gI(context);
            if (this.wXh == null) {
                wXd = false;
            }
        }
        if (!wXd) {
            this.vsw = new WebView(context);
            this.vsw.getSettings().setJavaScriptEnabled(true);
        }
    }

    public static boolean gH(Context context) {
        if (wXf) {
            return wXd;
        }
        wXf = true;
        try {
            ac cfb = ac.cfb();
            if (cfb != null && cfb.cfc()) {
                Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canUseX5JsCore", new Class[]{Context.class}, new Object[]{context});
                if (invokeStaticMethod != null && (invokeStaticMethod instanceof Boolean)) {
                    wXd = ((Boolean) invokeStaticMethod).booleanValue();
                }
            }
        } catch (Exception e) {
        }
        return wXd;
    }

    private static Object gI(Context context) {
        try {
            ac cfb = ac.cfb();
            if (cfb != null && cfb.cfc()) {
                return cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createX5JavaBridge", new Class[]{Context.class}, new Object[]{context});
            }
        } catch (Exception e) {
        }
        return null;
    }

    public final void addJavascriptInterface(Object obj, String str) {
        if (obj != null) {
            if (wXd) {
                try {
                    ac cfb = ac.cfb();
                    if (cfb != null && cfb.cfc()) {
                        cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, new Object[]{obj, str, this.wXh});
                    }
                } catch (Exception e) {
                }
            } else if (this.vsw != null) {
                this.vsw.addJavascriptInterface(obj, str);
                this.vsw.loadUrl("about:blank");
            }
        }
    }
}
