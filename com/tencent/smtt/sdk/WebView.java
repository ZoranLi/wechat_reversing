package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.a.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.r;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebView extends FrameLayout implements OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    public static boolean mSysWebviewCreated = false;
    private static Context ty = null;
    private static final Lock wWB = new ReentrantLock();
    private static OutputStream wWC = null;
    private static BroadcastReceiver wWL = null;
    private static r wWM = null;
    private static Method wWN = null;
    private static String wWO = null;
    private static Paint wWU = null;
    private static boolean wWV = true;
    private final String DU;
    private WebViewClient ixz;
    private WebChromeClient jeh;
    private Context mContext;
    public ab mWebViewCallbackClient;
    boolean wWD;
    IX5WebViewBase wWE;
    SystemWebView wWF;
    private WebSettings wWG;
    int wWH;
    private boolean wWI;
    private o wWJ;
    private boolean wWK;
    private final int wWP;
    private final int wWQ;
    private final int wWR;
    private final String wWS;
    private final String wWT;
    private Object wWW;
    private OnLongClickListener wWX;

    private static class ConnectivityChangedReceiver extends BroadcastReceiver {
        private ConnectivityChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        int gN = b.gN(context);
                        long currentTimeMillis = System.currentTimeMillis();
                        synchronized (QbSdk.wTp) {
                            if (QbSdk.wTn) {
                                QbSdk.sWifiConnectedTime += currentTimeMillis - QbSdk.wTo;
                            }
                            QbSdk.wTo = currentTimeMillis;
                        }
                        TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.sWifiConnectedTime + " apnType=" + gN);
                        QbSdk.wTn = gN == 3;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult mHitTestResultImpl;
        private android.webkit.WebView.HitTestResult mSysHitTestResult;

        public HitTestResult() {
            this.mSysHitTestResult = null;
            this.mHitTestResultImpl = null;
            this.mSysHitTestResult = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.mSysHitTestResult = null;
            this.mHitTestResultImpl = null;
            this.mSysHitTestResult = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.mSysHitTestResult = null;
            this.mHitTestResultImpl = hitTestResult;
            this.mSysHitTestResult = null;
        }

        public String getExtra() {
            return this.mHitTestResultImpl != null ? this.mHitTestResultImpl.getExtra() : this.mSysHitTestResult != null ? this.mSysHitTestResult.getExtra() : "";
        }

        public int getType() {
            return this.mHitTestResultImpl != null ? this.mHitTestResultImpl.getType() : this.mSysHitTestResult != null ? this.mSysHitTestResult.getType() : 0;
        }

        public void setExtra(String str) {
            if (this.mHitTestResultImpl != null) {
                this.mHitTestResultImpl.setExtra(str);
            }
        }

        public void setType(int i) {
            if (this.mHitTestResultImpl != null) {
                this.mHitTestResultImpl.setType(i);
            }
        }
    }

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    private class SystemWebView extends android.webkit.WebView {
        public SystemWebView(WebView webView, Context context) {
            this(context, null);
        }

        public SystemWebView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            if (!QbSdk.getIsSysWebViewForcedByOuter() || !t.gu(context)) {
                CookieSyncManager.createInstance(WebView.this.mContext).startSync();
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                    declaredMethod.setAccessible(true);
                    ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                    WebView.mSysWebviewCreated = true;
                } catch (Exception e) {
                }
            }
        }

        public void computeScroll() {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.UN();
            } else {
                super.computeScroll();
            }
        }

        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (!WebView.wWV && WebView.wWU != null) {
                    canvas.save();
                    canvas.drawPaint(WebView.wWU);
                    canvas.restore();
                }
            } catch (Throwable th) {
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return WebView.this.mWebViewCallbackClient != null ? WebView.this.mWebViewCallbackClient.t(motionEvent) : super.dispatchTouchEvent(motionEvent);
        }

        public WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                return null;
            }
        }

        public void invalidate() {
            super.invalidate();
            if (WebView.this.mWebViewCallbackClient != null) {
                ab abVar = WebView.this.mWebViewCallbackClient;
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return WebView.this.mWebViewCallbackClient != null ? WebView.this.mWebViewCallbackClient.u(motionEvent) : super.onInterceptTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.b(i, i2, z, z2);
            } else if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            WebView.this.onScrollChanged(i, i2, i3, i4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.s(motionEvent);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return WebView.this.mWebViewCallbackClient != null ? WebView.this.mWebViewCallbackClient.a(i, i2, i3, i4, i5, i6, i7, i8, z) : VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }

        public void setOverScrollMode(int i) {
            try {
                super.setOverScrollMode(i);
            } catch (Exception e) {
            }
        }

        public void super_computeScroll() {
            super.computeScroll();
        }

        public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        public void super_onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        public boolean super_onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }
    }

    public class WebViewTransport {
        private WebView mWebview;

        public synchronized WebView getWebView() {
            return this.mWebview;
        }

        public synchronized void setWebView(WebView webView) {
            this.mWebview = webView;
        }
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.DU = "WebView";
        this.wWD = false;
        this.wWG = null;
        this.mContext = null;
        this.wWH = 0;
        this.wWI = false;
        this.wWJ = null;
        this.wWK = false;
        this.ixz = null;
        this.jeh = null;
        this.wWP = 1;
        this.wWQ = 2;
        this.wWR = 3;
        this.wWS = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.wWT = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.wWW = null;
        this.wWX = null;
        if (QbSdk.getIsSysWebViewForcedByOuter() && t.gu(context)) {
            this.mContext = context;
            this.wWE = null;
            this.wWD = false;
            QbSdk.bv(context, "failed to createTBSWebview!");
            this.wWF = new SystemWebView(context, attributeSet);
            CookieManager.getInstance().n(context, false);
            CookieSyncManager.createInstance(this.mContext).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                mSysWebviewCreated = true;
            } catch (Exception e) {
            }
            CookieManager.getInstance().cdO();
            this.wWF.setFocusableInTouchMode(true);
            addView(this.wWF, new LayoutParams(-1, -1));
            TbsLog.i("WebView", "SystemWebView Created Success! #3");
            TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            i.cec().a(context, 402, new Throwable());
            return;
        }
        if (t.gu(context)) {
            TbsLog.setWriteLogJIT(true);
        } else {
            TbsLog.setWriteLogJIT(false);
        }
        this.wWJ = new o();
        this.wWJ.al("free_ram_begin", a.fC(context));
        this.wWJ.a("init_all", (byte) 1);
        this.wWJ.a("tbslog_init", (byte) 1);
        TbsLog.initIfNeed(context);
        this.wWJ.a("tbslog_init", (byte) 2);
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (wWM == null) {
            wWM = r.ha(context);
        }
        if (wWM.wYC) {
            TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.bv(context, "debug.conf force syswebview!");
        }
        b(context, this.wWJ);
        this.mContext = context;
        if (context != null) {
            ty = context.getApplicationContext();
        }
        if (!this.wWD || QbSdk.wTf) {
            this.wWE = null;
            if (t.gu(this.mContext)) {
                this.wWF = new SystemWebView(context, attributeSet);
            } else {
                this.wWF = new SystemWebView(this, context);
            }
            TbsLog.i("WebView", "SystemWebView Created Success! #2");
            CookieManager.getInstance().n(context, false);
            CookieManager.getInstance().cdO();
            this.wWF.setFocusableInTouchMode(true);
            addView(this.wWF, new LayoutParams(-1, -1));
            setDownloadListener(null);
            gA(context);
            TbsLog.writeLogToDisk();
            p.fS(context);
        } else {
            this.wWJ.a("init_x5_webview", (byte) 1);
            this.wWE = ac.cfb().wXa.gG(context);
            this.wWJ.a("init_x5_webview", (byte) 2);
            if (this.wWE == null || this.wWE.getView() == null) {
                TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.wWE = null;
                this.wWD = false;
                QbSdk.bv(context, "failed to createTBSWebview!");
                b(context, this.wWJ);
                if (t.gu(this.mContext)) {
                    this.wWF = new SystemWebView(context, attributeSet);
                } else {
                    this.wWF = new SystemWebView(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #1");
                CookieManager.getInstance().n(context, false);
                CookieManager.getInstance().cdO();
                this.wWF.setFocusableInTouchMode(true);
                addView(this.wWF, new LayoutParams(-1, -1));
                try {
                    if (VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th) {
                }
                gA(context);
                TbsLog.writeLogToDisk();
                p.fS(context);
                return;
            }
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.wWE.getView().setFocusableInTouchMode(true);
            e(attributeSet);
            addView(this.wWE.getView(), new LayoutParams(-1, -1));
            this.wWE.setDownloadListener(new b(this, null));
            IX5WebViewExtension x5WebViewExtension = this.wWE.getX5WebViewExtension();
            Object invokeStaticMethod = ac.cfb().wXa.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
            x5WebViewExtension.setWebViewClientExtension(new X5ProxyWebViewClientExtension(invokeStaticMethod == null ? null : (IX5WebViewClientExtension) invokeStaticMethod) {
                public void invalidate() {
                }

                public void onScrollChanged(int i, int i2, int i3, int i4) {
                    super.onScrollChanged(i, i2, i3, i4);
                    WebView.this.onScrollChanged(i3, i4, i, i2);
                }
            });
        }
        try {
            if (VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th2) {
        }
        if ("com.tencent.mobileqq".equals(this.mContext.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.mContext.getApplicationInfo().packageName)) {
            d.mb(true);
            if (d.useSoftWare() && VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
        }
        if (this.wWJ != null) {
            this.wWJ.a("load_url_gap", (byte) 1);
        }
        if (this.wWE != null) {
            TbsLog.writeLogToDisk();
            if (!t.gu(context)) {
                int i2 = k.fM(context).wUG.getInt("tbs_decouplecoreversion", 0);
                if (i2 > 0) {
                    p.ceA();
                    if (i2 != p.gb(context) && i2 == p.ceA().gc(context)) {
                        p.ceA().gg(context);
                        return;
                    }
                }
                StringBuilder append = new StringBuilder("webview construction #1 deCoupleCoreVersion is ").append(i2).append(" getTbsCoreShareDecoupleCoreVersion is ");
                p.ceA();
                TbsLog.i("WebView", append.append(p.gb(context)).append(" getTbsCoreInstalledVerInNolock is ").append(p.ceA().gc(context)).toString());
            }
        }
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    private void b(Context context, o oVar) {
        if (QbSdk.wTq && t.gu(context)) {
            m.cey().fR(context);
        }
        if (oVar != null) {
            oVar.a("x5_core_engine_init_sync", (byte) 1);
        }
        ac cfb = ac.cfb();
        cfb.b(context, oVar);
        this.wWD = cfb.cfc();
    }

    private static long ceV() {
        long j;
        synchronized (QbSdk.wTp) {
            if (QbSdk.wTn) {
                QbSdk.sWifiConnectedTime += System.currentTimeMillis() - QbSdk.wTo;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.sWifiConnectedTime);
            }
            j = QbSdk.sWifiConnectedTime / 1000;
            QbSdk.sWifiConnectedTime = 0;
            QbSdk.wTo = System.currentTimeMillis();
        }
        return j;
    }

    static void ceW() {
        new Thread() {
            public final void run() {
                if (WebView.ty == null) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                    return;
                }
                d.mb(true);
                if (d.wTL) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                    return;
                }
                j fL = j.fL(WebView.ty);
                int Vp = fL.Vp("install_status");
                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + Vp);
                if (Vp == 2) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                    d.Vo(String.valueOf(fL.Vq("install_core_ver")));
                    d.cdU();
                    return;
                }
                int Vp2 = fL.Vp("copy_status");
                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + Vp2);
                if (Vp2 == 1) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                    d.Vo(String.valueOf(fL.Vq("copy_core_ver")));
                    d.cdU();
                } else if (!ac.cfb().cfc()) {
                    if (Vp == 3 || Vp2 == 3) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                        d.Vo(String.valueOf(d.cdT()));
                        d.cdU();
                    }
                }
            }
        }.start();
    }

    private boolean dG(View view) {
        if (this.mContext != null && getTbsCoreVersion(this.mContext) > 36200) {
            return false;
        }
        Object a = o.a(this.wWW, "onLongClick", new Class[]{View.class}, view);
        return a != null ? ((Boolean) a).booleanValue() : false;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!ac.cfb().cfc()) {
            o.fl("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    private void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.wWE.getView().setVerticalScrollBarEnabled(false);
                            this.wWE.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.wWE.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.wWE.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!ac.cfb().cfc()) {
            o.fl("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    public static String findAddress(String str) {
        return !ac.cfb().cfc() ? android.webkit.WebView.findAddress(str) : null;
    }

    private void gA(final Context context) {
        if (wWL == null) {
            wWL = new ConnectivityChangedReceiver();
            new Thread() {
                public void run() {
                    try {
                        QbSdk.wTn = b.gN(context) == 3;
                        QbSdk.wTo = System.currentTimeMillis();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        context.getApplicationContext().registerReceiver(WebView.wWL, intentFilter);
                    } catch (Throwable th) {
                    }
                }
            }.start();
        }
    }

    private static boolean gB(Context context) {
        try {
            if (context.getPackageName().indexOf("com.tencent.mobileqq") >= 0) {
                return true;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    private static int gC(Context context) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        int i = -1;
        FileOutputStream b = f.b(context, true, "tbslock.txt");
        if (b != null) {
            FileLock a = f.a(b);
            if (a != null) {
                if (wWB.tryLock()) {
                    FileInputStream fileInputStream2 = null;
                    try {
                        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
                        if (file.exists()) {
                            Properties properties = new Properties();
                            fileInputStream = new FileInputStream(file);
                            try {
                                properties.load(fileInputStream);
                                fileInputStream.close();
                                String property = properties.getProperty("PV");
                                if (property == null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                                    }
                                    wWB.unlock();
                                    f.a(a, b);
                                } else {
                                    i = Integer.parseInt(property);
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e22) {
                                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22.toString());
                                    }
                                    wWB.unlock();
                                    f.a(a, b);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e222) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e222.toString());
                                        }
                                    }
                                    wWB.unlock();
                                    f.a(a, b);
                                    return i;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream2 = fileInputStream;
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e2222) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2222.toString());
                                        }
                                    }
                                    wWB.unlock();
                                    f.a(a, b);
                                    throw th;
                                }
                            }
                        }
                        wWB.unlock();
                        f.a(a, b);
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream = null;
                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        wWB.unlock();
                        f.a(a, b);
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        wWB.unlock();
                        f.a(a, b);
                        throw th;
                    }
                }
                f.a(a, b);
            }
        }
        return i;
    }

    static void gD(Context context) {
        String str;
        int gC = gC(context);
        if (gC != -1) {
            str = "PV=" + String.valueOf(gC + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
        try {
            file.getParentFile().mkdirs();
            if (!(file.isFile() && file.exists())) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(file, false);
            wWC = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            if (wWC != null) {
                wWC.flush();
            }
        } catch (Throwable th) {
        }
    }

    private static void gE(Context context) {
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
        }
    }

    public static String getCrashExtraMessage(Context context) {
        String str = null;
        if (context == null) {
            return "";
        }
        String str2 = "tbs_core_version:" + QbSdk.getTbsVersion(context) + ";tbs_sdk_version:43501" + ";";
        StringBuilder stringBuilder = new StringBuilder();
        d mb = d.mb(true);
        if (mb.wTF == null || QbSdk.wTf) {
            str = "system webview get nothing...";
        } else {
            w wVar = mb.wTF;
            Object invokeStaticMethod = wVar.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = wVar.wWu.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
            }
            if (invokeStaticMethod != null) {
                str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + s.wVX + " ReaderPackVersion=" + s.wVY;
            }
            if (str == null) {
                str = "X5 core get nothing...";
            }
        }
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append(str2);
        if (!t.gu(context) && QbSdk.wTA != null && QbSdk.wTA.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.wTA.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            str = "weapp_id:" + QbSdk.wTA.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";weapp_name:" + QbSdk.wTA.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            stringBuilder.append("\n");
            stringBuilder.append(str);
        }
        return stringBuilder.length() > 8192 ? stringBuilder.substring(stringBuilder.length() - 8192) : stringBuilder.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (ac.cfb().cfc()) {
            return null;
        }
        if (VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) o.fl("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object fl;
        synchronized (WebView.class) {
            fl = !ac.cfb().cfc() ? o.fl("android.webkit.WebView", "getPluginList") : null;
        }
        return fl;
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        ceW();
        return d.mb(true).getTbsNeedReboot();
    }

    public static int getTbsSDKVersion(Context context) {
        return 43501;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            if (z != wWV) {
                wWV = z;
                if (wWU == null) {
                    Paint paint = new Paint();
                    wWU = paint;
                    paint.setColor(NIGHT_MODE_COLOR);
                }
                if (z) {
                    if (wWU.getAlpha() != 255) {
                        wWU.setAlpha(255);
                    }
                } else if (wWU.getAlpha() != NIGHT_MODE_ALPHA) {
                    wWU.setAlpha(NIGHT_MODE_ALPHA);
                }
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                wWN = declaredMethod;
                if (declaredMethod != null) {
                    wWN.setAccessible(true);
                    wWN.invoke(null, new Object[]{Boolean.valueOf(z)});
                }
            } catch (Exception e) {
                TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
            }
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.wWD) {
            this.wWE.addJavascriptInterface(obj, str);
        } else {
            this.wWF.addJavascriptInterface(obj, str);
        }
    }

    public void addView(View view) {
        if (this.wWD) {
            View view2 = this.wWE.getView();
            try {
                Method b = o.b(view2, "addView", View.class);
                b.setAccessible(true);
                b.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.wWF.addView(view);
    }

    public boolean canGoBack() {
        return !this.wWD ? this.wWF.canGoBack() : this.wWE.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.wWD ? this.wWF.canGoBackOrForward(i) : this.wWE.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.wWD ? this.wWF.canGoForward() : this.wWE.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (this.wWD) {
            return this.wWE.canZoomIn();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object c = o.c(this.wWF, "canZoomIn");
        return c == null ? false : ((Boolean) c).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (this.wWD) {
            return this.wWE.canZoomOut();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object c = o.c(this.wWF, "canZoomOut");
        return c == null ? false : ((Boolean) c).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.wWD) {
            return this.wWE.capturePicture();
        }
        Object c = o.c(this.wWF, "capturePicture");
        return c == null ? null : (Picture) c;
    }

    public void clearCache(boolean z) {
        if (this.wWD) {
            this.wWE.clearCache(z);
        } else {
            this.wWF.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.wWD) {
            this.wWE.clearFormData();
        } else {
            this.wWF.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.wWD) {
            this.wWE.clearHistory();
        } else {
            this.wWF.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.wWD) {
            this.wWE.clearMatches();
        } else {
            this.wWF.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.wWD) {
            this.wWE.clearSslPreferences();
        } else {
            this.wWF.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.wWD) {
            this.wWE.clearView();
        } else {
            o.c(this.wWF, "clearView");
        }
    }

    public int computeHorizontalScrollExtent() {
        try {
            Method b;
            if (this.wWD) {
                b = o.b(this.wWE.getView(), "computeHorizontalScrollExtent", new Class[0]);
                b.setAccessible(true);
                return ((Integer) b.invoke(this.wWE.getView(), null)).intValue();
            }
            b = o.b(this.wWF, "computeHorizontalScrollExtent", new Class[0]);
            b.setAccessible(true);
            return ((Integer) b.invoke(this.wWF, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public int computeHorizontalScrollOffset() {
        try {
            Method b;
            if (this.wWD) {
                b = o.b(this.wWE.getView(), "computeHorizontalScrollOffset", new Class[0]);
                b.setAccessible(true);
                return ((Integer) b.invoke(this.wWE.getView(), null)).intValue();
            }
            b = o.b(this.wWF, "computeHorizontalScrollOffset", new Class[0]);
            b.setAccessible(true);
            return ((Integer) b.invoke(this.wWF, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        try {
            if (this.wWD) {
                return ((Integer) o.a(this.wWE.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method b = o.b(this.wWF, "computeHorizontalScrollRange", new Class[0]);
            b.setAccessible(true);
            return ((Integer) b.invoke(this.wWF, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public void computeScroll() {
        if (this.wWD) {
            this.wWE.computeScroll();
        } else {
            this.wWF.computeScroll();
        }
    }

    public int computeVerticalScrollRange() {
        try {
            if (this.wWD) {
                return ((Integer) o.a(this.wWE.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method b = o.b(this.wWF, "computeVerticalScrollRange", new Class[0]);
            b.setAccessible(true);
            return ((Integer) b.invoke(this.wWF, null)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.wWD ? WebBackForwardList.a(this.wWE.copyBackForwardList()) : WebBackForwardList.a(this.wWF.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        Object obj = null;
        if (this.wWD) {
            try {
                return this.wWE.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                return obj;
            }
        } else if (VERSION.SDK_INT < 21) {
            return obj;
        } else {
            return o.a(this.wWF, "createPrintDocumentAdapter", new Class[]{String.class}, str);
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (this.wWD && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
    }

    public void destroy() {
        if (!(this.wWI || this.wWH == 0)) {
            this.wWI = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.wWD) {
                Bundle sdkQBStatisticsInfo = this.wWE.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                int gC = gC(this.mContext);
                if (gC == -1) {
                    gC = this.wWH;
                }
                this.wWH = gC;
                gE(this.mContext);
            }
            com.tencent.smtt.sdk.a.b.a(this.mContext, str, str2, str3, this.wWH, this.wWD, ceV());
            this.wWH = 0;
            this.wWI = false;
        }
        if (this.wWD) {
            this.wWE.destroy();
        } else {
            Object invoke;
            Field declaredField;
            try {
                Class cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", new Class[]{android.webkit.WebView.class});
                method.setAccessible(true);
                invoke = method.invoke(null, new Object[]{this.wWF});
                if (invoke != null) {
                    Field declaredField2 = cls.getDeclaredField("mListBoxDialog");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class cls2 = Class.forName("android.app.Dialog");
                        declaredField = cls2.getDeclaredField("CANCEL");
                        declaredField.setAccessible(true);
                        int intValue = ((Integer) declaredField.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception e) {
            }
            this.wWF.destroy();
            try {
                declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
                if (componentCallbacks != null) {
                    declaredField.set(null, null);
                    declaredField = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField.setAccessible(true);
                    invoke = declaredField.get(null);
                    if (invoke != null) {
                        List list = (List) invoke;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.cdR());
    }

    public void documentHasImages(Message message) {
        if (this.wWD) {
            this.wWE.documentHasImages(message);
        } else {
            this.wWF.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (this.wWD) {
            this.wWE.dumpViewHierarchyWithProperties(bufferedWriter, i);
            return;
        }
        o.a(this.wWF, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
    }

    public void evaluateJavascript(String str, y<String> yVar) {
        Method b;
        if (this.wWD) {
            try {
                b = o.b(this.wWE.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                b.setAccessible(true);
                b.invoke(this.wWE.getView(), new Object[]{str, yVar});
            } catch (Exception e) {
                loadUrl(str);
            }
        } else if (VERSION.SDK_INT >= 19) {
            try {
                b = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                b.setAccessible(true);
                b.invoke(this.wWF, new Object[]{str, yVar});
            } catch (Exception e2) {
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.wWD) {
            return this.wWE.findAll(str);
        }
        Object a = o.a(this.wWF, "findAll", new Class[]{String.class}, str);
        return a == null ? 0 : ((Integer) a).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.wWD) {
            this.wWE.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            o.a(this.wWF, "findAllAsync", new Class[]{String.class}, str);
        }
    }

    public View findHierarchyView(String str, int i) {
        if (this.wWD) {
            return this.wWE.findHierarchyView(str, i);
        }
        return (View) o.a(this.wWF, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (this.wWD) {
            this.wWE.findNext(z);
        } else {
            this.wWF.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.wWD) {
            this.wWE.flingScroll(i, i2);
        } else {
            this.wWF.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.wWD) {
            this.wWE.freeMemory();
        } else {
            o.c(this.wWF, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.wWD ? this.wWF.getCertificate() : this.wWE.getCertificate();
    }

    public int getContentHeight() {
        return !this.wWD ? this.wWF.getContentHeight() : this.wWE.getContentHeight();
    }

    public int getContentWidth() {
        if (this.wWD) {
            return this.wWE.getContentWidth();
        }
        Object c = o.c(this.wWF, "getContentWidth");
        return c == null ? 0 : ((Integer) c).intValue();
    }

    public Bitmap getFavicon() {
        return !this.wWD ? this.wWF.getFavicon() : this.wWE.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.wWD ? new HitTestResult(this.wWF.getHitTestResult()) : new HitTestResult(this.wWE.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.wWD ? this.wWF.getHttpAuthUsernamePassword(str, str2) : this.wWE.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.wWD ? this.wWF.getOriginalUrl() : this.wWE.getOriginalUrl();
    }

    public int getProgress() {
        return !this.wWD ? this.wWF.getProgress() : this.wWE.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        try {
            if (this.wWD) {
                return false;
            }
            if (VERSION.SDK_INT < 26) {
                return false;
            }
            Object c = o.c(this.wWF, "getRendererPriorityWaivedWhenNotVisible");
            return c == null ? false : ((Boolean) c).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        try {
            if (this.wWD) {
                return 0;
            }
            if (VERSION.SDK_INT < 26) {
                return 0;
            }
            Object c = o.c(this.wWF, "getRendererRequestedPriority");
            return c == null ? 0 : ((Integer) c).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (this.wWD) {
            return this.wWE.getScale();
        }
        Object c = o.c(this.wWF, "getScale");
        return c == null ? 0.0f : ((Float) c).floatValue();
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return getView() == null ? 0 : getView().getScrollBarDefaultDelayBeforeFade();
    }

    public int getScrollBarFadeDuration() {
        return getView() == null ? 0 : getView().getScrollBarFadeDuration();
    }

    public int getScrollBarSize() {
        return getView() == null ? 0 : getView().getScrollBarSize();
    }

    public int getScrollBarStyle() {
        return getView() == null ? 0 : getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        if (this.wWG != null) {
            return this.wWG;
        }
        if (this.wWD) {
            WebSettings webSettings = new WebSettings(this.wWE.getSettings());
            this.wWG = webSettings;
            return webSettings;
        }
        webSettings = new WebSettings(this.wWF.getSettings());
        this.wWG = webSettings;
        return webSettings;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        return !this.wWD ? null : this.wWE.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.wWD ? this.wWF.getTitle() : this.wWE.getTitle();
    }

    public String getUrl() {
        return !this.wWD ? this.wWF.getUrl() : this.wWE.getUrl();
    }

    public View getView() {
        return !this.wWD ? this.wWF : this.wWE.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.wWD) {
            return this.wWE.getVisibleTitleHeight();
        }
        Object c = o.c(this.wWF, "getVisibleTitleHeight");
        return c == null ? 0 : ((Integer) c).intValue();
    }

    public WebChromeClient getWebChromeClient() {
        return this.jeh;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        return !this.wWD ? null : this.wWE.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        return this.wWD ? this.wWE.getView().getScrollX() : this.wWF.getScrollX();
    }

    public int getWebScrollY() {
        return this.wWD ? this.wWE.getView().getScrollY() : this.wWF.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.ixz;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        return !this.wWD ? null : this.wWE.getX5WebViewExtension().getWebViewClientExtension();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        return !this.wWD ? null : this.wWE.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        return !this.wWD ? (View) o.c(this.wWF, "getZoomControls") : this.wWE.getZoomControls();
    }

    public void goBack() {
        if (this.wWD) {
            this.wWE.goBack();
        } else {
            this.wWF.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.wWD) {
            this.wWE.goBackOrForward(i);
        } else {
            this.wWF.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.wWD) {
            this.wWE.goForward();
        } else {
            this.wWF.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.wWD) {
            this.wWE.invokeZoomPicker();
        } else {
            this.wWF.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return wWV;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (this.wWD) {
            return this.wWE.isPrivateBrowsingEnable();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object c = o.c(this.wWF, "isPrivateBrowsingEnabled");
        return c == null ? false : ((Boolean) c).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.wWD) {
            this.wWE.loadData(str, str2, str3);
        } else {
            this.wWF.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.wWD) {
            this.wWE.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.wWF.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (!(!this.wWD || this.wWJ == null || this.wWK)) {
            this.wWJ.a("load_url_gap", (byte) 2);
            this.wWJ.a("init_all", (byte) 2);
            this.wWJ.al("free_ram_end", a.fC(this.mContext));
            if (this.wWJ.aL(this.wWE.hashCode(), str)) {
                this.wWK = true;
            }
        }
        if (str != null && !showDebugView(str)) {
            if (this.wWD) {
                this.wWE.loadUrl(str);
            } else {
                this.wWF.loadUrl(str);
            }
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (!(!this.wWD || this.wWJ == null || this.wWK)) {
            this.wWJ.a("load_url_gap", (byte) 2);
            this.wWJ.a("init_all", (byte) 2);
            this.wWJ.al("free_ram_end", a.fC(this.mContext));
            if (this.wWJ.aL(this.wWE.hashCode(), str)) {
                this.wWK = true;
            }
        }
        if (str != null && !showDebugView(str)) {
            if (this.wWD) {
                this.wWE.loadUrl(str, map);
            } else if (VERSION.SDK_INT >= 8) {
                this.wWF.loadUrl(str, map);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (!(this.wWI || this.wWH == 0)) {
            this.wWI = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.wWD) {
                Bundle sdkQBStatisticsInfo = this.wWE.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                int gC = gC(this.mContext);
                if (gC == -1) {
                    gC = this.wWH;
                }
                this.wWH = gC;
                gE(this.mContext);
            }
            com.tencent.smtt.sdk.a.b.a(this.mContext, str, str2, str3, this.wWH, this.wWD, ceV());
            this.wWH = 0;
            this.wWI = false;
        }
        super.onDetachedFromWindow();
    }

    public boolean onLongClick(View view) {
        return this.wWX != null ? !this.wWX.onLongClick(view) ? dG(view) : true : dG(view);
    }

    public void onPause() {
        if (this.wWD) {
            this.wWE.onPause();
        } else {
            o.c(this.wWF, "onPause");
        }
    }

    public void onResume() {
        if (this.wWD) {
            this.wWE.onResume();
        } else {
            o.c(this.wWF, "onResume");
        }
    }

    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && gB(this.mContext) && isHardwareAccelerated() && i > 0 && i2 > 0) {
            getLayerType();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        if (this.mContext == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (wWO == null) {
            wWO = this.mContext.getApplicationInfo().packageName;
        }
        if (wWO == null || !(wWO.equals("com.tencent.mm") || wWO.equals("com.tencent.mobileqq"))) {
            if (!(i == 0 || this.wWI || this.wWH == 0)) {
                this.wWI = true;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (this.wWD) {
                    Bundle sdkQBStatisticsInfo = this.wWE.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString("guid");
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                    int gC = gC(this.mContext);
                    if (gC == -1) {
                        gC = this.wWH;
                    }
                    this.wWH = gC;
                    gE(this.mContext);
                }
                com.tencent.smtt.sdk.a.b.a(this.mContext, str, str2, str3, this.wWH, this.wWD, ceV());
                this.wWH = 0;
                this.wWI = false;
            }
            super.onVisibilityChanged(view, i);
            return;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.wWD ? this.wWF.overlayHorizontalScrollbar() : this.wWE.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.wWD ? this.wWE.overlayVerticalScrollbar() : this.wWF.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.wWD ? this.wWF.pageDown(z) : this.wWE.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.wWD ? this.wWF.pageUp(z) : this.wWE.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.wWD) {
            this.wWE.pauseTimers();
        } else {
            this.wWF.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.wWD) {
            this.wWE.postUrl(str, bArr);
        } else {
            this.wWF.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (this.wWD) {
            this.wWE.refreshPlugins(z);
            return;
        }
        o.a(this.wWF, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void reload() {
        if (this.wWD) {
            this.wWE.reload();
        } else {
            this.wWF.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.wWD) {
            if (VERSION.SDK_INT >= 11) {
                o.a(this.wWF, "removeJavascriptInterface", new Class[]{String.class}, str);
                return;
            }
            this.wWE.removeJavascriptInterface(str);
        }
    }

    public void removeView(View view) {
        if (this.wWD) {
            View view2 = this.wWE.getView();
            try {
                Method b = o.b(view2, "removeView", View.class);
                b.setAccessible(true);
                b.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.wWF.removeView(view);
    }

    public void reportInitPerformance(long j) {
        TbsLog.i("sdkreport", "reportInitPerformance initType is " + j + " isX5Core is " + this.wWD + " isPerformanceDataRecorded" + this.wWK);
        if (this.wWD && this.wWJ != null && !this.wWK) {
            this.wWJ.al("init_type", j);
            if (this.wWJ.aL(this.wWE.hashCode(), getUrl())) {
                this.wWK = true;
            }
        }
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.wWD) {
            View view2 = this.wWE.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view != this) {
                view2 = view;
            }
            return viewGroup.requestChildRectangleOnScreen(view2, rect, z);
        }
        android.webkit.WebView webView = this.wWF;
        if (view == this) {
            view = this.wWF;
        }
        return webView.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.wWD) {
            this.wWE.requestFocusNodeHref(message);
        } else {
            this.wWF.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.wWD) {
            this.wWE.requestImageRef(message);
        } else {
            this.wWF.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.wWD) {
            return this.wWE.restorePicture(bundle, file);
        }
        Object a = o.a(this.wWF, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.wWD ? WebBackForwardList.a(this.wWF.restoreState(bundle)) : WebBackForwardList.a(this.wWE.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.wWD) {
            this.wWE.resumeTimers();
        } else {
            this.wWF.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.wWD) {
            this.wWE.savePassword(str, str2, str3);
            return;
        }
        o.a(this.wWF, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.wWD) {
            return this.wWE.savePicture(bundle, file);
        }
        Object a = o.a(this.wWF, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.wWD ? WebBackForwardList.a(this.wWF.saveState(bundle)) : WebBackForwardList.a(this.wWE.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.wWD) {
            this.wWE.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            o.a(this.wWF, "saveWebArchive", new Class[]{String.class}, str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, y<String> yVar) {
        if (this.wWD) {
            this.wWE.saveWebArchive(str, z, yVar);
        } else if (VERSION.SDK_INT >= 11) {
            o.a(this.wWF, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), yVar);
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.wWD) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
        }
    }

    public void setBackgroundColor(int i) {
        if (this.wWD) {
            this.wWE.setBackgroundColor(i);
        } else {
            this.wWF.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.wWD) {
            this.wWE.setCertificate(sslCertificate);
        } else {
            this.wWF.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.wWD) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.wWD) {
            this.wWE.setDownloadListener(new b(this, downloadListener));
        } else {
            this.wWF.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (downloadListener == null) {
                        c.a(WebView.this.mContext, str, null, null);
                    } else {
                        downloadListener.onDownloadStart(str, str2, str3, str4, j);
                    }
                }
            });
        }
    }

    @TargetApi(16)
    public void setFindListener(final FindListener findListener) {
        if (this.wWD) {
            this.wWE.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.wWF.setFindListener(new android.webkit.WebView.FindListener() {
                public void onFindResultReceived(int i, int i2, boolean z) {
                    findListener.onFindResultReceived(i, i2, z);
                }
            });
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.wWD) {
            this.wWE.setHorizontalScrollbarOverlay(z);
        } else {
            this.wWF.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.wWD) {
            this.wWE.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.wWF.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.wWD) {
            this.wWE.setInitialScale(i);
        } else {
            this.wWF.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.wWD) {
            this.wWE.setMapTrackballToArrowKeys(z);
            return;
        }
        o.a(this.wWF, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void setNetworkAvailable(boolean z) {
        if (this.wWD) {
            this.wWE.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.wWF.setNetworkAvailable(z);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.wWD) {
            View view = this.wWE.getView();
            try {
                if (this.wWW == null) {
                    Method b = o.b(view, "getListenerInfo", new Class[0]);
                    b.setAccessible(true);
                    Object invoke = b.invoke(view, null);
                    Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                    declaredField.setAccessible(true);
                    this.wWW = declaredField.get(invoke);
                }
                this.wWX = onLongClickListener;
                getView().setOnLongClickListener(this);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.wWF.setOnLongClickListener(onLongClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(final PictureListener pictureListener) {
        if (this.wWD) {
            if (pictureListener == null) {
                this.wWE.setPictureListener(null);
            } else {
                this.wWE.setPictureListener(new com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener() {
                    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
                        WebView.this.wWE = iX5WebViewBase;
                        pictureListener.onNewPicture(WebView.this, picture);
                    }

                    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                    }
                });
            }
        } else if (pictureListener == null) {
            this.wWF.setPictureListener(null);
        } else {
            this.wWF.setPictureListener(new android.webkit.WebView.PictureListener() {
                public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                    pictureListener.onNewPicture(WebView.this, picture);
                }
            });
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        try {
            if (!this.wWD && VERSION.SDK_INT >= 26) {
                o.a(this.wWF, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z));
            }
        } catch (Exception e) {
        }
    }

    public void setScrollBarStyle(int i) {
        if (this.wWD) {
            this.wWE.getView().setScrollBarStyle(i);
        } else {
            this.wWF.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.wWD) {
            this.wWE.setVerticalScrollbarOverlay(z);
        } else {
            this.wWF.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.wWE == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.wWE.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() != null) {
            getView().setVisibility(i);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        if (this.wWD) {
            IX5WebViewBase iX5WebViewBase = this.wWE;
            if (webChromeClient != null) {
                IX5WebChromeClient iX5WebChromeClient;
                ad adVar = ac.cfb().wXa;
                if (adVar.wWu == null) {
                    iX5WebChromeClient = null;
                } else {
                    Object invokeStaticMethod = adVar.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
                    iX5WebChromeClient = invokeStaticMethod == null ? null : (IX5WebChromeClient) invokeStaticMethod;
                }
                Object eVar = new e(iX5WebChromeClient, this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(r1);
        } else {
            android.webkit.WebView webView = this.wWF;
            if (webChromeClient != null) {
                webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
            }
            webView.setWebChromeClient(webChromeClient2);
        }
        this.jeh = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.wWD) {
            this.wWE.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(ab abVar) {
        this.mWebViewCallbackClient = abVar;
        if (this.wWD && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        if (this.wWD) {
            IX5WebViewBase iX5WebViewBase = this.wWE;
            if (webViewClient != null) {
                Object invokeStaticMethod = ac.cfb().wXa.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
                Object fVar = new f(invokeStaticMethod == null ? null : (IX5WebViewClient) invokeStaticMethod, this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(r1);
        } else {
            android.webkit.WebView webView = this.wWF;
            if (webViewClient != null) {
                webViewClient2 = new SystemWebViewClient(this, webViewClient);
            }
            webView.setWebViewClient(webViewClient2);
        }
        this.ixz = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.wWD) {
            this.wWE.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            e.gS(this.mContext).a(toLowerCase, this, this.mContext, n.cez().getLooper());
            return true;
        } else if (!toLowerCase.startsWith("http://debugx5.qq.com") || this.wWD) {
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!DOCTYPE html><html><body>");
            stringBuilder.append("<head>");
            stringBuilder.append("<title>无法打开debugx5</title>");
            stringBuilder.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
            stringBuilder.append("</head>");
            stringBuilder.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
            stringBuilder.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
            stringBuilder.append("</body></html>");
            loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", ProtocolPackage.ServerEncoding, null);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.wWD) {
            this.wWE.stopLoading();
        } else {
            this.wWF.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (this.wWD) {
            try {
                o.c(this.wWE.getView(), "super_computeScroll");
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.wWF.super_computeScroll();
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.wWD) {
            return this.wWF.super_dispatchTouchEvent(motionEvent);
        }
        try {
            Object a = o.a(this.wWE.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.wWD) {
            return this.wWF.super_onInterceptTouchEvent(motionEvent);
        }
        try {
            Object a = o.a(this.wWE.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.wWD) {
            try {
                o.a(this.wWE.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.wWF.super_onOverScrolled(i, i2, z, z2);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.wWD) {
            try {
                o.a(this.wWE.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.wWF.super_onScrollChanged(i, i2, i3, i4);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.wWD) {
            return this.wWF.super_onTouchEvent(motionEvent);
        }
        try {
            Object a = o.a(this.wWE.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.wWD) {
            return this.wWF.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        try {
            Object a = o.a(this.wWE.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        if (z != wWV) {
            wWV = z;
            if (z) {
                TbsLog.e("QB_SDK", "deleteNightMode");
                loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
                return;
            }
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!wWV) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        return !this.wWD ? this.wWF.zoomIn() : this.wWE.zoomIn();
    }

    public boolean zoomOut() {
        return !this.wWD ? this.wWF.zoomOut() : this.wWE.zoomOut();
    }
}
