package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o implements e {
    public Context context;
    public p lXp;
    private aj owy = new aj(new a(this) {
        final /* synthetic */ o sNz;

        {
            this.sNz = r1;
        }

        public final boolean oQ() {
            o oVar = this.sNz;
            Context context = this.sNz.context;
            this.sNz.context.getString(R.l.dIO);
            oVar.lXp = g.a(context, this.sNz.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass1 sNA;

                {
                    this.sNA = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(this.sNA.sNz.pcR);
                    this.sNA.sNz.lXp = null;
                }
            });
            return false;
        }
    }, false);
    public l pcR;
    private String sNy;

    public o(Context context) {
        this.context = context;
    }

    public final void MU(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            return;
        }
        this.sNy = str;
        ap.yY();
        String str2 = (String) c.vr().get(46, null);
        ap.yY();
        w.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", str2, bg.mz((String) c.vr().get(72, null)));
        if (bg.mA(str2) && bg.mA(r1)) {
            MV(str);
            return;
        }
        ap.vd().a(233, (e) this);
        this.pcR = new l(com.tencent.mm.a.o.aY(str), (int) System.currentTimeMillis());
        ap.vd().a(this.pcR, 0);
        this.owy.v(3000, 3000);
    }

    private void MV(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.context.getString(R.l.dZh, new Object[]{str}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.owy.KH();
        if (this.lXp != null) {
            this.lXp.dismiss();
        }
        ap.vd().b(233, (e) this);
        if (i == 0 && i2 == 0) {
            l lVar = (l) kVar;
            String IQ = lVar.IQ();
            if (IQ == null || IQ.length() == 0) {
                MV(this.sNy);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", IQ);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("geta8key_session_id", lVar.IY());
            d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            return;
        }
        w.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        MV(this.sNy);
    }
}
