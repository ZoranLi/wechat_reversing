package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(7)
public class WalletRealNameProcessProxyUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        hn(580);
        Bundle bundle2 = this.uT;
        if (bundle2 != null) {
            i = bundle2.getInt("realname_scene", 0);
        } else {
            i = 0;
        }
        if (i == 0) {
            i = getIntent().getIntExtra("realname_scene", 0);
        }
        if (i == 1) {
            w.i("MicroMsg.WalletRealNameProcessProxyUI", "from jsapi, do NetSceneCheckPayJsapi");
            if (getIntent() == null) {
                String str = "";
                if (bg.mA(str)) {
                    str = getString(R.l.fkA);
                }
                g.a(this, str, null, false, new OnClickListener(this) {
                    final /* synthetic */ WalletRealNameProcessProxyUI rCQ;

                    {
                        this.rCQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rCQ.setResult(1);
                        this.rCQ.finish();
                    }
                });
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            int i2 = 8;
            if (this.uT.getInt("realname_scene") == 2) {
                i2 = 12;
            }
            q(new com.tencent.mm.plugin.wallet_core.b.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, i2));
            return;
        }
        H(bundle2);
    }

    public void onResume() {
        super.onResume();
    }

    private void H(Bundle bundle) {
        w.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI");
        if (bundle == null) {
            w.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI, param is null");
            bundle = new Bundle();
        }
        bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle.putString("realname_verify_process_jump_activity", ".id_verify.WalletRealNameProcessProxyUI");
        bundle.putBoolean("process_finish_stay_orgpage", false);
        com.tencent.mm.wallet_core.a.a(this, a.class, bundle);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
            w.e("MicroMsg.WalletRealNameProcessProxyUI", "NetSceneCheckPayJsapi resp,errType = " + i + ",errCode=" + i2);
            if (i == 0 && i2 == 0) {
                H(this.uT);
                return true;
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.WalletRealNameProcessProxyUI", "onNewIntent");
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            setResult(0);
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    setResult(-1);
                    break;
            }
            setResult(0);
        }
        finish();
    }

    public final boolean aIY() {
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        ho(580);
    }
}
