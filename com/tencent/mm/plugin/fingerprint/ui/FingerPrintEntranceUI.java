package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public class FingerPrintEntranceUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        w.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
        if (e.avt()) {
            w.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
            w.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
            g.a(this, getResources().getString(R.l.eXe), "", getResources().getString(a.sBC.avc() ? R.l.dPO : R.l.dHT), getString(R.l.dGs), true, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI lPh;

                {
                    this.lPh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
                    a.sBC.bZ(this.lPh);
                    this.lPh.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI lPh;

                {
                    this.lPh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lPh.finish();
                }
            });
            e.avo();
        } else if (e.avn()) {
            z = false;
        } else {
            w.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
            g.a(this, getResources().getString(R.l.eXd), "", getResources().getString(R.l.dPN), getString(R.l.dGs), true, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI lPh;

                {
                    this.lPh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
                    d.w(this.lPh, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                    this.lPh.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FingerPrintEntranceUI lPh;

                {
                    this.lPh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lPh.finish();
                }
            });
            e.avm();
        }
        if (!z) {
            w.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
