package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class by extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setKeepScreenOn";
    public static boolean iPJ = false;
    m iMG;
    WakeLock wakeLock;

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
            mVar.x(i, d("fail:data is null", null));
        } else if (mVar.mContext == null) {
            w.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
            mVar.x(i, d("fail:context is null", null));
        } else {
            boolean optBoolean = jSONObject.optBoolean("keepScreenOn", false);
            iPJ = optBoolean;
            w.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[]{Boolean.valueOf(optBoolean), mVar.ivH});
            this.iMG = mVar;
            if (optBoolean) {
                e.a(mVar.ivH, new b(this) {
                    final /* synthetic */ by iPK;

                    public final void onDestroy() {
                        w.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
                        if (this.iPK.isHeld()) {
                            this.iPK.release();
                        }
                        e.b(mVar.ivH, this);
                    }

                    public final void a(c cVar) {
                        w.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
                        if (this.iPK.isHeld()) {
                            this.iPK.release();
                        }
                    }

                    public final void onResume() {
                        w.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
                        if (by.iPJ) {
                            this.iPK.Ti();
                        }
                    }
                });
                optBoolean = Ti();
            } else if (isHeld()) {
                w.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
                optBoolean = release();
            } else {
                w.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
                mVar.x(i, d("fail:has not set screen", null));
                return;
            }
            if (optBoolean) {
                w.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
                mVar.x(i, d("ok", null));
                return;
            }
            w.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
            mVar.x(i, d("fail", null));
        }
    }

    public final boolean Ti() {
        if (this.iMG.mContext == null) {
            w.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
            return false;
        }
        w.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
        MMActivity mMActivity = (MMActivity) this.iMG.mContext;
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) mMActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
        }
        if (this.wakeLock.isHeld()) {
            w.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
        } else {
            this.wakeLock.acquire();
            w.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
        }
        return true;
    }

    public final boolean release() {
        w.e("MicroMsg.JsApiSetKeepScreenOn", "release");
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            w.e("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
            return false;
        }
        this.wakeLock.release();
        this.wakeLock = null;
        return true;
    }

    public final boolean isHeld() {
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            return false;
        }
        return true;
    }
}
