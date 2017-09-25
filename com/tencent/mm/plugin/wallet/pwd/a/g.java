package com.tencent.mm.plugin.wallet.pwd.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.wallet_core.ui.e;

public final class g {

    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ Context val$context;

        public AnonymousClass1(Context context) {
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            e.m(this.val$context, m.btO().buL().field_find_passwd_url, false);
            if (this.val$context instanceof Activity) {
                ((Activity) this.val$context).finish();
            }
        }
    }

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ boolean rAK = true;
        final /* synthetic */ Context val$context;

        public AnonymousClass2(boolean z, Context context) {
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.rAK && (this.val$context instanceof Activity)) {
                ((Activity) this.val$context).finish();
            }
        }
    }
}
