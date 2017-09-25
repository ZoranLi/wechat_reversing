package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.y;
import java.lang.reflect.Method;
import java.util.Map;

public class MMWebView extends WebView {
    public boolean gRU;
    private OnTouchListener rlX;
    protected boolean wwR;
    public boolean wwS;
    private boolean wwT;
    public ViewGroup wwU;

    public static class a {
        public static MMWebView fi(Context context) {
            boolean z = true;
            MMWebView.fh(context);
            MMWebView mMWebView = new MMWebView(context);
            mMWebView.gRU = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.wwS = z;
            return mMWebView;
        }

        public static MMWebView fj(Context context) {
            MMWebView.fh(context);
            MMWebView mMWebView = new MMWebView(context);
            mMWebView.gRU = true;
            mMWebView.wwS = mMWebView.getX5WebViewExtension() != null;
            mMWebView.wwR = true;
            return mMWebView;
        }

        public static MMWebView i(Activity activity, int i) {
            boolean z = true;
            MMWebView.fh(activity);
            MMWebView mMWebView = (MMWebView) activity.findViewById(i);
            mMWebView.gRU = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.wwS = z;
            return mMWebView;
        }
    }

    private class b {
        final /* synthetic */ MMWebView wwV;

        public b(MMWebView mMWebView) {
            this.wwV = mMWebView;
        }
    }

    private class c {
        final /* synthetic */ MMWebView wwV;

        public c(MMWebView mMWebView) {
            this.wwV = mMWebView;
        }
    }

    public MMWebView(Context context) {
        this(context, null);
    }

    public MMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRU = false;
        this.wwR = false;
        this.wwS = false;
        this.wwT = false;
        caG();
    }

    public void loadData(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
    }

    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @TargetApi(11)
    public final void caG() {
        try {
            if (VERSION.SDK_INT >= 11) {
                super.removeJavascriptInterface("searchBoxJavaBridge_");
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", e.getMessage());
        }
    }

    public final void caH() {
        if (VERSION.SDK_INT >= 5) {
            c cVar = new c(this);
            setScrollbarFadingEnabled(true);
            setScrollBarStyle(0);
            return;
        }
        b bVar = new b(this);
        setScrollBarStyle(0);
    }

    public void switchNightMode(boolean z) {
        w.d("MicroMsg.MMWebView", "[cpan] swithc mode.");
        setDayOrNight(!z);
    }

    public void evaluateJavascript(String str, y<String> yVar) {
        if (!bg.mA(str)) {
            int i;
            if (d.eo(19) || getX5WebViewExtension() != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                super.evaluateJavascript(str, yVar);
            } else if (!this.wwR || !a(this, str)) {
                try {
                    if (!str.startsWith("javascript:")) {
                        str = "javascript:" + str;
                    }
                    super.loadUrl(str);
                } catch (Exception e) {
                    w.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", e.getMessage());
                }
            }
        }
    }

    private static boolean a(MMWebView mMWebView, String str) {
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(mMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
            Method declaredMethod = obj.getClass().getDeclaredMethod("sendMessage", new Class[]{Message.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{Message.obtain(null, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, str)});
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", e);
            return false;
        }
    }

    public final void caI() {
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMWebView wwV;

            {
                this.wwV = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                    case 2:
                        this.wwV.wwU.requestDisallowInterceptTouchEvent(true);
                        break;
                    case 1:
                    case 3:
                        this.wwV.wwU.requestDisallowInterceptTouchEvent(false);
                        break;
                    default:
                        this.wwV.wwU.requestDisallowInterceptTouchEvent(true);
                        break;
                }
                if (this.wwV.rlX != null) {
                    return this.wwV.rlX.onTouch(view, motionEvent);
                }
                return false;
            }
        });
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.rlX = onTouchListener;
    }

    @TargetApi(9)
    public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean super_overScrollBy = super.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        if (i4 < 0 || (i4 == 0 && i2 < 0)) {
            this.wwT = true;
        }
        return super_overScrollBy;
    }

    public final boolean J(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean super_onTouchEvent = super.super_onTouchEvent(motionEvent);
        switch (action & 255) {
            case 0:
                this.wwT = false;
                break;
            case 2:
                if (this.wwU != null) {
                    if (!this.wwT) {
                        this.wwU.requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                    this.wwU.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        if (!super_onTouchEvent) {
            return super_onTouchEvent;
        }
        if (this.wwT) {
            return false;
        }
        return true;
    }

    @TargetApi(9)
    public final void c(int i, int i2, boolean z, boolean z2) {
        super.super_onOverScrolled(i, i2, z, z2);
    }

    public final boolean K(MotionEvent motionEvent) {
        return super.super_dispatchTouchEvent(motionEvent);
    }

    public final boolean L(MotionEvent motionEvent) {
        return super.super_onInterceptTouchEvent(motionEvent);
    }

    @TargetApi(9)
    public final void caJ() {
        super.super_computeScroll();
    }

    public final void v(int i, int i2, int i3, int i4) {
        super.super_onScrollChanged(i, i2, i3, i4);
    }

    public static void fh(Context context) {
        boolean z;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        w.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", sharedPreferences.getString("tbs_webview_disable", "0"), sharedPreferences.getString("tbs_webview_min_sdk_version", null), sharedPreferences.getString("tbs_webview_max_sdk_version", null));
        if ("1".equals(sharedPreferences.getString("tbs_webview_disable", "0"))) {
            int i = bg.getInt(r4, 0);
            int i2 = bg.getInt(r0, 0);
            int i3 = VERSION.SDK_INT;
            if (i3 >= i && (i3 <= i2 || i2 == 0)) {
                w.i("MicroMsg.MMWebView", "in selection, disable x5");
                z = false;
                w.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", Boolean.valueOf(z));
                if (!z) {
                    QbSdk.forceSysWebView();
                }
            }
        }
        z = true;
        w.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", Boolean.valueOf(z));
        if (!z) {
            QbSdk.forceSysWebView();
        }
    }
}
