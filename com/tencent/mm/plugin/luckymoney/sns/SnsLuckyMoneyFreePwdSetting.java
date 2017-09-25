package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.pa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.y.k;

public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected f jid;
    protected CheckBoxPreference npH;

    private static void oR(int i) {
        b paVar = new pa();
        paVar.fVY.key = i;
        paVar.fVY.value = 1;
        paVar.fVY.fVZ = true;
        a.urY.m(paVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        oR(116);
    }

    protected final void KC() {
        this.jid = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyFreePwdSetting npI;

            {
                this.npI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.npI.finish();
                return false;
            }
        });
        zi(R.l.exE);
        this.npH = (CheckBoxPreference) this.jid.Td("open_sns_pay_pref");
        aIg();
    }

    protected void onResume() {
        aIg();
        super.onResume();
    }

    private void aIg() {
        boolean z = true;
        if (com.tencent.mm.plugin.luckymoney.sns.c.a.aIj() != 1) {
            z = false;
        }
        this.npH.vqm = z;
        this.hgx.edit().putBoolean("open_sns_pay_pref", z).commit();
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.c.a.aIk())) {
            w.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
            this.npH.setTitle(R.l.exD);
        } else {
            w.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.c.a.aIk());
            this.npH.setTitle(com.tencent.mm.plugin.luckymoney.sns.c.a.aIk());
        }
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.c.a.aIl())) {
            w.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
            this.npH.setSummary(R.l.exC);
        } else {
            w.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.c.a.aIl());
            this.npH.setSummary(com.tencent.mm.plugin.luckymoney.sns.c.a.aIl());
        }
        this.jid.notifyDataSetChanged();
    }

    private void fw(boolean z) {
        this.hgx.edit().putBoolean("open_sns_pay_pref", z).commit();
        this.npH.vqm = z;
        this.jid.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final boolean f(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.sns.b.a) {
            w.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (i != 0 || i2 != 0) {
                oR(119);
                w.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                aIg();
            } else if (((com.tencent.mm.plugin.luckymoney.sns.b.a) kVar).nqh == 1) {
                w.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                oR(119);
                fw(true);
            } else {
                fw(false);
                oR(118);
                w.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        return false;
    }

    public final int ON() {
        return R.o.fuy;
    }

    public final boolean a(f fVar, Preference preference) {
        if ("open_sns_pay_pref".equals(preference.igL)) {
            if (this.npH.isChecked() || com.tencent.mm.plugin.luckymoney.sns.c.a.aIj() != 1) {
                oR(120);
                com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
            } else {
                ccJ().a(new com.tencent.mm.plugin.luckymoney.sns.b.a(0, "", ""), true, true);
                oR(117);
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
