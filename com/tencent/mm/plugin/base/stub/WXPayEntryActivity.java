package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.kernel.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXPayEntryActivity extends AutoLoginActivity {
    private String jPJ = null;
    private long jPK = 0;

    public void onCreate(Bundle bundle) {
        this.jPK = System.currentTimeMillis();
        s.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
    }

    protected final boolean u(Intent intent) {
        return true;
    }

    protected final void a(b bVar, Intent intent) {
        boolean z = true;
        if (intent == null) {
            finish();
            return;
        }
        w.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = " + bVar);
        switch (bVar) {
            case LOGIN_OK:
                w.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", Boolean.valueOf(a.uP()));
                if (a.uP()) {
                    finish();
                    return;
                }
                break;
            case LOGIN_CANCEL:
                jH(-2);
                w.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + bVar);
                finish();
                return;
            case LOGIN_FAIL:
                jH(-1);
                w.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + bVar);
                finish();
                return;
            default:
                w.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = " + bVar);
                break;
        }
        this.jPJ = s.i(intent, ConstantsAPI.APP_PACKAGE);
        w.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.jPJ);
        if (getIntent() == null || s.ad(getIntent()) == null) {
            z = false;
        } else {
            PayReq payReq = new PayReq();
            payReq.fromBundle(s.ad(getIntent()));
            String str = payReq.appId;
            w.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = " + str);
            if (str == null || str.length() == 0) {
                w.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
                z = false;
            } else {
                f aJ = g.aJ(str, true);
                if (aJ == null) {
                    w.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
                    aJ = new f();
                    aJ.field_appId = str;
                    aJ.field_appName = "";
                    aJ.field_packageName = this.jPJ;
                    aJ.field_status = 0;
                    String aQ = p.aQ(this, this.jPJ);
                    if (aQ != null) {
                        aJ.field_signature = aQ;
                    }
                    if (an.aRr().l(aJ) && bg.mA(aJ.field_openId)) {
                        w.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = " + str);
                        an.aRs().Jl(str);
                    }
                } else if (aJ.field_status == 3) {
                    w.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
                    z = false;
                } else if (!p.b(this, aJ, this.jPJ)) {
                    AutoLoginActivity.a(this, aJ, this.jPJ, 5);
                    w.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
                    z = false;
                }
            }
        }
        if (!z) {
            w.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
        try {
            intent.putExtra("key_scene", 0);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
        }
        Bundle ad = s.ad(intent);
        ad.putLong("wallet_pay_key_check_time", this.jPK);
        e.a((Context) this, ad, z);
        finish();
    }

    private void jH(int i) {
        PayReq payReq = new PayReq();
        payReq.fromBundle(s.ad(getIntent()));
        Options options = new Options();
        options.fromBundle(s.ad(getIntent()));
        PayResp payResp = new PayResp();
        payResp.prepayId = payReq.prepayId;
        payResp.extData = payReq.extData;
        payResp.errCode = i;
        com.tencent.mm.plugin.wallet_index.ui.a.a(this, s.i(getIntent(), ConstantsAPI.APP_PACKAGE), payResp, options);
    }
}
