package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(7)
public class WalletResetPwdAdapterUI extends WalletBaseUI {
    protected String gLD = null;
    protected boolean oQZ = false;
    protected com.tencent.mm.plugin.wallet.a oRa = null;
    protected String rBF = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(8);
        this.rBF = getIntent().getStringExtra("reset_pwd_token");
        w.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", new Object[]{this.rBF});
        hn(580);
        if (getIntent() == null) {
            w.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            return;
        }
        k aVar = new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 3);
        aVar.gWO = "RemittanceProcess";
        q(aVar);
    }

    protected void onNewIntent(Intent intent) {
        w.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
        } else if (intExtra == 2) {
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        } else {
            setResult(0);
            finish();
        }
    }

    public void onDestroy() {
        ho(580);
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.oQZ) {
            w.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
            return;
        }
        w.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            setResult(DownloadResult.CODE_UNDEFINED);
            g.bl(this, str);
            finish();
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a)) {
            return false;
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("kreq_token", this.rBF);
            com.tencent.mm.wallet_core.a.a(this, c.class, bundle, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }
}
