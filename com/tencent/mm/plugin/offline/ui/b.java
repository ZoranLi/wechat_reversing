package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.e;

public final class b {

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ Activity nJ;
        final /* synthetic */ String odB;

        AnonymousClass2(String str, Activity activity) {
            this.odB = str;
            this.nJ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.odB);
            d.b(this.nJ, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            e.CM(3);
            dialogInterface.dismiss();
        }
    }

    static class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ Activity nJ;

        AnonymousClass4(Activity activity) {
            this.nJ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.nJ instanceof WalletOfflineCoinPurseUI) {
                ((WalletOfflineCoinPurseUI) this.nJ).oew = false;
            }
            dialogInterface.dismiss();
        }
    }

    public static void a(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(R.l.fkA);
        }
        g.a(activity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
}
