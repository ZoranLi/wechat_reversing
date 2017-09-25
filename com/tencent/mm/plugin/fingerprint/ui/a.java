package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class a extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
        b(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            w.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
            b(activity, FingerPrintAuthUI.class, bundle);
        } else if (activity instanceof FingerPrintAuthUI) {
            d(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        d(activity, new Bundle());
    }

    public final void d(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        w.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
        a(activity, "wallet", ".pwd.ui.WalletPasswordSettingUI", 0, intent, true);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String avB() {
        return "FingerprintAuth";
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ a lOM;

                public final boolean j(Object... objArr) {
                    this.lOM.lHw.putString("pwd", (String) objArr[0]);
                    w.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }
            };
        }
        return super.a(mMActivity, fVar);
    }
}
