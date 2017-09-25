package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.mm.e.a.gp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.g;

public final class a {
    private Dialog ita = null;
    private Context mContext;
    public a ryW = null;

    public interface a {
        void c(boolean z, String str, String str2);
    }

    public a(Context context, a aVar) {
        this.mContext = context;
        this.ryW = aVar;
    }

    public final void release() {
        this.ryW = null;
        this.mContext = null;
    }

    public final void a(boolean z, int i, String str) {
        final b gpVar = new gp();
        gpVar.fLQ = null;
        gpVar.fLP.fLR = z;
        if (z && (this.ita == null || !(this.ita == null || this.ita.isShowing()))) {
            if (this.ita != null) {
                this.ita.dismiss();
            }
            this.ita = g.a(this.mContext, false, new OnCancelListener(this) {
                final /* synthetic */ a ryY;

                {
                    this.ryY = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.ryY.bsK();
                }
            });
        }
        gpVar.fLP.fLS = i;
        gpVar.fLP.fLT = str;
        gpVar.nFq = new Runnable(this) {
            final /* synthetic */ a ryY;

            public final void run() {
                w.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
                gp.b bVar = gpVar.fLQ;
                if (bVar != null && bVar.fHO) {
                    w.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
                    this.ryY.bsK();
                    if (this.ryY.ryW != null) {
                        this.ryY.ryW.c(bVar.fHO, bVar.fLU, bVar.fLV);
                    }
                } else if (bVar == null || bVar.fHO) {
                    w.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
                } else {
                    this.ryY.bsK();
                    if (this.ryY.ryW != null) {
                        this.ryY.ryW.c(bVar.fHO, bVar.fLU, bVar.fLV);
                    }
                    w.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.a(gpVar, Looper.getMainLooper());
    }

    public final void bsK() {
        if (this.ita != null) {
            this.ita.dismiss();
            this.ita = null;
        }
    }
}
