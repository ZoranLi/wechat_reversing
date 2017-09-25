package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.e.a.w;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;

@a(3)
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI wkf = null;

    static /* synthetic */ void a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        accountDeletedAlphaAlertUI.finish();
        d.bd(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.uSU.uTo, LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        accountDeletedAlphaAlertUI.uSU.uTo.startActivity(intent);
    }

    public static AccountDeletedAlphaAlertUI bZr() {
        return wkf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        wkf = this;
        com.tencent.mm.sdk.b.a.urY.m(new w());
        ap.hold();
        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(getIntent().getStringExtra("errmsg"));
        if (dn != null) {
            dn.a(this, new OnClickListener(this) {
                final /* synthetic */ AccountDeletedAlphaAlertUI wkg;

                {
                    this.wkg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AccountDeletedAlphaAlertUI.a(this.wkg);
                }
            }, null);
        } else {
            g.a((Context) this, getString(R.l.ezh), null, false, new OnClickListener(this) {
                final /* synthetic */ AccountDeletedAlphaAlertUI wkg;

                {
                    this.wkg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AccountDeletedAlphaAlertUI.a(this.wkg);
                }
            });
        }
    }

    public void onDestroy() {
        if (equals(wkf)) {
            wkf = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
