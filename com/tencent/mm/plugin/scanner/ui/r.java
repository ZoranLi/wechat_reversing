package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class r implements e {
    public Context context;
    public p lXp;
    aj owy = new aj(new a(this) {
        final /* synthetic */ r pcS;

        {
            this.pcS = r1;
        }

        public final boolean oQ() {
            r rVar = this.pcS;
            Context context = this.pcS.context;
            this.pcS.context.getString(R.l.dIO);
            rVar.lXp = g.a(context, this.pcS.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass1 pcT;

                {
                    this.pcT = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(this.pcT.pcS.pcR);
                    this.pcT.pcS.lXp = null;
                }
            });
            return false;
        }
    }, false);
    public l pcR;
    String url;

    public r(Context context) {
        this.context = context;
    }

    final void bB(String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_session_id", i);
        b.imv.j(intent, this.context);
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.owy.KH();
        if (this.lXp != null) {
            this.lXp.dismiss();
        }
        ap.vd().b(233, this);
        l lVar = (l) kVar;
        if (i == 0 && i2 == 0) {
            String IQ = lVar.IQ();
            if (IQ == null || IQ.length() == 0) {
                bB(this.url, lVar.IY());
                return;
            } else {
                bB(IQ, lVar.IY());
                return;
            }
        }
        w.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        bB(this.url, lVar.IY());
    }
}
