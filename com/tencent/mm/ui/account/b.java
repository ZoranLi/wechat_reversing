package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;

public abstract class b extends com.tencent.mm.ui.applet.SecurityImage.b {
    public SecurityImage uUx = null;
    public k uXd = null;

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ Context qjf;
        final /* synthetic */ b uXe;

        AnonymousClass1(b bVar, Context context) {
            this.uXe = bVar;
            this.qjf = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            final k a = this.uXe.a(this.uXe.uXd, this.uXe.uUx.bRz());
            ap.vd().a(a, 0);
            Context context = this.qjf;
            this.qjf.getString(R.l.dIO);
            g.a(context, this.qjf.getString(R.l.ewX), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass1 uXf;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(a);
                }
            });
        }
    }

    public abstract k a(k kVar, String str);

    public final void bQI() {
        ap.vd().a(a(this.uXd, ""), 0);
    }
}
