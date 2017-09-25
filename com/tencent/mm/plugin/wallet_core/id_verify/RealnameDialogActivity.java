package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(3)
public class RealnameDialogActivity extends WalletBaseUI {
    private RealnameGuideHelper nuc;
    private int type = 1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("key_realname_guide_helper")) {
            finish();
            return;
        }
        this.nuc = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
        Bundle bundle2 = new Bundle();
        bundle2.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle2.putString("realname_verify_process_jump_activity", ".id_verify.RealnameDialogActivity");
        bundle2.putBoolean("process_finish_stay_orgpage", false);
        if (!this.nuc.a(this, bundle2, new OnClickListener(this) {
            final /* synthetic */ RealnameDialogActivity rCz;

            {
                this.rCz = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.rCz.finish();
            }
        }, true)) {
            finish();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
