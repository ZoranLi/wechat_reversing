package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

@a(3)
public abstract class WalletPreferenceUI extends MMPreference implements c {
    public b wFq = null;
    public f wFr = null;
    public d wFs = null;

    public abstract boolean f(int i, int i2, String str, k kVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.wFr = new f(this, this);
        this.wFr.hn(385);
        this.wFr.hn(1518);
        if (getLayoutId() > 0) {
            e.ccH();
        }
    }

    public final f ccJ() {
        if (this.wFr == null) {
            this.wFr = new f(this, this);
        }
        return this.wFr;
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (!f(i, i2, str, kVar) && i2 != 0) {
            if (bg.mA(str)) {
                str = getString(R.l.ffj);
            }
            g.a(this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ WalletPreferenceUI wFI;

                {
                    this.wFI = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.wFI.finish();
                }
            });
        }
    }

    public void onDestroy() {
        this.wFr.ho(385);
        this.wFr.ho(1518);
        this.wFr = null;
        super.onDestroy();
    }
}
