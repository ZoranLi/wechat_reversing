package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.e.a.pa;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class a extends b {
    public static void oR(int i) {
        com.tencent.mm.sdk.b.b paVar = new pa();
        paVar.fVY.key = i;
        paVar.fVY.value = 1;
        paVar.fVY.fVZ = true;
        com.tencent.mm.sdk.b.a.urY.m(paVar);
    }

    public final b c(Activity activity, Bundle bundle) {
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        d(activity, bundle);
    }

    public final void c(Activity activity, int i) {
        d(activity, null);
    }

    public final void d(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String avB() {
        return "LuckyFreePwdProcess";
    }

    public final d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ a npG;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof com.tencent.mm.plugin.luckymoney.sns.b.a)) {
                    return false;
                }
                w.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
                if (i == 0 && i2 == 0) {
                    g.bl(this.wEw, this.wEw.getString(R.l.eyb));
                    a.oR(121);
                    this.npG.lHw.putBoolean("is_open_sns_pay", true);
                    this.npG.a(this.wEw, 0, this.npG.lHw);
                    return true;
                }
                g.bl(this.wEw, this.wEw.getString(R.l.eya));
                a.oR(122);
                this.npG.c(this.wEw, 0);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.wEx.a(new com.tencent.mm.plugin.luckymoney.sns.b.a(1, (String) objArr[0], ""), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }
}
