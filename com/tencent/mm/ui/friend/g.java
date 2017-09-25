package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g implements e {
    private Context context;
    private ProgressDialog koS;
    public String sLW = "";
    public a whE;
    private boolean whF = true;

    public interface a {
        void k(boolean z, String str);
    }

    public g(Context context, a aVar) {
        this.context = context;
        this.whE = aVar;
        this.whF = true;
    }

    public g(Context context, a aVar, byte b) {
        this.context = context;
        this.whE = aVar;
        this.whF = false;
    }

    public final void r(int[] iArr) {
        ap.vd().a(116, (e) this);
        final k acVar = new ac(iArr);
        ap.vd().a(acVar, 0);
        if (this.whF) {
            Context context = this.context;
            this.context.getString(R.l.ete);
            this.koS = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.etc), true, new OnCancelListener(this) {
                final /* synthetic */ g whH;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(acVar);
                    this.whH.whE.k(false, this.whH.sLW);
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 116) {
            if (this.koS != null) {
                this.koS.dismiss();
                this.koS = null;
            }
            ap.vd().b(116, (e) this);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
                if (this.whF) {
                    com.tencent.mm.ui.base.g.a(this.context, R.l.etb, R.l.dIO, new OnClickListener(this) {
                        final /* synthetic */ g whH;

                        {
                            this.whH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.whH.whE.k(true, this.whH.sLW);
                        }
                    });
                    return;
                } else {
                    this.whE.k(true, this.sLW);
                    return;
                }
            }
            w.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
            this.whE.k(false, this.sLW);
        }
    }
}
