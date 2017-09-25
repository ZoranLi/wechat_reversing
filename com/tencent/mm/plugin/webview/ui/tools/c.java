package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

final class c {
    aj hqQ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c sbf;

        {
            this.sbf = r1;
        }

        public final boolean oQ() {
            if (this.sbf.sbe.isFinishing()) {
                w.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
            } else {
                c cVar = this.sbf;
                Context context = this.sbf.sbe;
                this.sbf.sbe.getString(R.l.dIO);
                cVar.lXp = g.a(context, this.sbf.sbe.getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 sbg;

                    {
                        this.sbg = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        try {
                            dialogInterface.dismiss();
                        } catch (Exception e) {
                            w.e("MicroMsg.OAuthSession", "onCancel, ex = " + e.getMessage());
                        }
                    }
                });
            }
            return false;
        }
    }, false);
    d iYF;
    public p lXp;
    boolean sbb = false;
    boolean sbc = false;
    final a sbd;
    public OAuthUI sbe;

    public interface a {
        void a(c cVar, String str, boolean z);

        void c(boolean z, String str, String str2, String str3);
    }

    private c(OAuthUI oAuthUI, a aVar, d dVar) {
        this.sbe = oAuthUI;
        this.sbd = aVar;
        this.iYF = dVar;
    }

    public static c a(OAuthUI oAuthUI, String str, Req req, a aVar, d dVar) {
        c cVar = new c(oAuthUI, aVar, dVar);
        String str2 = req.scope;
        String str3 = req.state;
        if (cVar.sbb) {
            w.e("MicroMsg.OAuthSession", "already getting");
        } else {
            cVar.sbc = true;
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_appid", str);
            bundle.putString("geta8key_data_scope", str2);
            bundle.putString("geta8key_data_state", str3);
            try {
                cVar.iYF.q(233, bundle);
                cVar.sbb = true;
            } catch (Exception e) {
                w.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + e.getMessage());
            }
            cVar.hqQ.v(3000, 3000);
        }
        return cVar;
    }
}
