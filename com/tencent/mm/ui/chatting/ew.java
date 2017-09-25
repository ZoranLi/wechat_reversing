package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.bk.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.g.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class ew implements dp {
    private static k<dp, Bundle> vPo = new k<dp, Bundle>() {
        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((dp) obj).ac((Bundle) obj2);
        }
    };
    public Context context;
    public final Map<String, Req> vPr = new HashMap();

    public ew(Context context) {
        this.context = context;
    }

    public static void ad(Bundle bundle) {
        vPo.by(bundle);
        vPo.doNotify();
    }

    public final void ac(Bundle bundle) {
        w.d("MicroMsg.WXAppMessageShower", "handleResp, appid = " + Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid"));
        Resp resp = new Resp(bundle);
        w.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + resp.errCode + ", type = " + resp.getType());
        if (((Req) this.vPr.get(resp.transaction)) == null) {
            w.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + resp.transaction);
        } else {
            this.vPr.remove(resp.transaction);
        }
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        w.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", str, str3);
        final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        a.post(new Runnable(this) {
            final /* synthetic */ ew vPs;

            public final void run() {
                final Req c = g.c(this.vPs.context, wXMediaMessage2, str4);
                g.a(this.vPs.context, str5, str6, c, 0, new c(this) {
                    final /* synthetic */ AnonymousClass2 vPt;

                    public final void ex(boolean z) {
                        if (z) {
                            this.vPt.vPs.vPr.put(c.transaction, c);
                        }
                    }
                }, null);
            }
        });
    }
}
