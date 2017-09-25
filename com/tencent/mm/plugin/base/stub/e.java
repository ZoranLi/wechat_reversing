package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.URLDecoder;

public final class e {

    static class AnonymousClass1 implements com.tencent.mm.y.e {
        final /* synthetic */ Runnable jPm;
        final /* synthetic */ Activity nJ;

        AnonymousClass1(Activity activity, Runnable runnable) {
            this.nJ = activity;
            this.jPm = runnable;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ap.vd().b(1200, (com.tencent.mm.y.e) this);
            w.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", ((ah) kVar).Jy());
                try {
                    Uri parse = Uri.parse(((ah) kVar).Jy());
                    if (parse == null) {
                        w.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
                        e.t(this.nJ);
                        return;
                    }
                    String queryParameter = parse.getQueryParameter("result");
                    if (queryParameter != null) {
                        w.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", URLDecoder.decode(queryParameter));
                        b bxVar = new bx();
                        bxVar.fFn.activity = this.nJ;
                        bxVar.fFn.fDK = queryParameter;
                        bxVar.fFn.fFo = 19;
                        bxVar.fFn.fFr = 3;
                        bxVar.fFn.fFs = parse.getQueryParameter("appid");
                        bxVar.fFn.fFu = this.nJ.getIntent().getBundleExtra("_stat_obj");
                        a.urY.m(bxVar);
                        if (this.jPm != null) {
                            this.jPm.run();
                        }
                        af.f(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 jPn;

                            {
                                this.jPn = r1;
                            }

                            public final void run() {
                                this.jPn.nJ.finish();
                            }
                        }, 100);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    w.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", e);
                    e.t(this.nJ);
                    return;
                }
            }
            w.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
            e.t(this.nJ);
        }
    }

    public static void t(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName(ab.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        intent.putExtra("showShare", false);
        ab.getContext().startActivity(intent);
        if (activity != null) {
            activity.finish();
        }
    }
}
