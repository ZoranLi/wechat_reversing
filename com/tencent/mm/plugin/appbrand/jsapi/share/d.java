package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 74;
    public static final String NAME = "shareTimeline";
    private static boolean iVt = false;

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (iVt) {
            iVt = false;
            if (jSONObject != null) {
                AppBrandSysConfig mY = b.mY(mVar.ivH);
                final Context a = a(mVar);
                if (a == null) {
                    mVar.x(i, d("fail", null));
                    return;
                }
                String str;
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        w.i("MicroMsg.JsApiShareTimeline", "%s, %s", new Object[]{str, jSONObject.get(str)});
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.JsApiShareTimeline", e, "", new Object[0]);
                }
                final String optString = jSONObject.optString("path");
                final String str2 = mVar.ivH;
                str = jSONObject.optString("desc");
                String optString2 = jSONObject.optString("title");
                String str3 = mY.fCJ;
                String optString3 = jSONObject.optString("imgUrl");
                String nx = n.nx(mVar.ivH);
                String str4 = mY.iEP;
                w.i("MicroMsg.JsApiShareTimeline", "doSendMessage, title = %s, description = %s ,username = %s , path = %s ,thumbIconUrl = %s", new Object[]{optString2, str, str3, optString, optString3});
                w.i("MicroMsg.JsApiShareTimeline", "doTimeline, errorUrl:[%s]", new Object[]{nx});
                w.i("MicroMsg.JsApiShareTimeline", "doTimeline, init intent");
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", nx);
                intent.putExtra("Ksnsupload_title", optString2);
                intent.putExtra("Ksnsupload_contentattribute", 0);
                if (s.eq(optString3, "http://") || s.eq(optString3, "https://")) {
                    intent.putExtra("Ksnsupload_imgurl", optString3);
                } else {
                    Bitmap g = l.g(mVar.ixr, optString3);
                    byte[] bArr = new byte[0];
                    if (g == null || g.isRecycled()) {
                        w.e("MicroMsg.JsApiShareTimeline", "thumb image is null");
                    } else {
                        w.i("MicroMsg.JsApiShareTimeline", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        g.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    intent.putExtra("Ksnsupload_imgbuf", bArr);
                }
                intent.putExtra("ksnsis_appbrand", true);
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("KsnsUpload_BrandUsername", str3);
                intent.putExtra("KsnsUpload_BrandPath", optString);
                w.d("MicroMsg.JsApiShareTimeline", "report, appId : %s, path: %s", new Object[]{str2, optString});
                str = q.fQ("wxapp_" + str2 + optString);
                q.yC().n(str, true).l("prePublishId", "wxapp_" + str2 + optString);
                intent.putExtra("reportSessionId", str);
                w.i("MicroMsg.JsApiShareTimeline", "doTimeline, start activity");
                if (a instanceof MMActivity) {
                    intent.putExtra("need_result", true);
                    final m mVar2 = mVar;
                    final int i2 = i;
                    a.uSV = new MMActivity.a(this) {
                        final /* synthetic */ d iVu;

                        public final void a(int i, int i2, Intent intent) {
                            if (i != 0) {
                                return;
                            }
                            if (i2 == -1) {
                                g.bl(a, a.getResources().getString(R.l.dIG));
                                d.c(str2, optString, "", 1, i2);
                                w.i("MicroMsg.JsApiShareTimeline", "result is success");
                                mVar2.x(i2, this.iVu.d("success", null));
                                return;
                            }
                            w.i("MicroMsg.JsApiShareTimeline", "result is cancel");
                            mVar2.x(i2, this.iVu.d("cancel", null));
                            d.c(str2, optString, "", 3, i2);
                        }
                    };
                    com.tencent.mm.bb.d.a(a, "sns", ".ui.En_c4f742e5", intent, 0, false);
                    return;
                }
                return;
            }
            w.i("MicroMsg.JsApiShareTimeline", "data is null");
            mVar.x(i, d("fail", null));
            return;
        }
        mVar.x(i, d("fail", null));
    }

    public static void c(String str, String str2, String str3, int i, int i2) {
        com.tencent.mm.plugin.appbrand.report.a.a(str, str2, 3, str3, bg.Ny(), i, i2);
    }

    public static void TU() {
        iVt = true;
    }
}
