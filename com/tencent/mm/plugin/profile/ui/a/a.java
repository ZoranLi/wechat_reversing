package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a implements e {
    public Activity fPi;
    public p lXp;
    public com.tencent.mm.plugin.profile.a.a owx;
    public aj owy = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ a owz;

        {
            this.owz = r1;
        }

        public final boolean oQ() {
            if (!this.owz.fPi.isFinishing()) {
                a aVar = this.owz;
                Context context = this.owz.fPi;
                this.owz.fPi.getString(R.l.dIO);
                aVar.lXp = g.a(context, this.owz.fPi.getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 owA;

                    {
                        this.owA = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(this.owA.owz.owx);
                        this.owA.owz.lXp = null;
                    }
                });
            }
            return false;
        }
    }, false);

    public a(Activity activity) {
        this.fPi = activity;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ap.vd().b(cf.CTRL_INDEX, this);
        com.tencent.mm.plugin.profile.a.a aVar = (com.tencent.mm.plugin.profile.a.a) kVar;
        if (i == 0 && i2 == 0) {
            CI(aVar.getURL());
            return;
        }
        if (i != 4) {
            w.e("MicroMsg.ViewTWeibo", "view weibo failed: " + i + ", " + i2);
        }
        CI("http://t.qq.com/" + aVar.osr);
    }

    private void CI(String str) {
        this.owy.KH();
        if (this.lXp != null) {
            this.lXp.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("title", this.fPi.getString(R.l.ear));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        d.b(this.fPi, "webview", ".ui.tools.WebViewUI", intent);
    }
}
