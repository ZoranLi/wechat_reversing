package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class WalletUnbindBankCardProxyUI extends WalletBaseUI {
    private Bankcard rxA;
    private Map<String, String> rxB;
    private String rxz;

    public void onCreate(Bundle bundle) {
        Bankcard bankcard = null;
        super.onCreate(bundle);
        Intent intent = getIntent();
        setResult(0);
        if (intent != null) {
            this.rxz = intent.getStringExtra("packageExt");
            if (bg.mA(this.rxz)) {
                w.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
                setResult(1);
                finish();
                return;
            }
            Map hashMap;
            String str = this.rxz;
            if (!bg.mA(str)) {
                String[] split = str.split("&");
                hashMap = new HashMap();
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        String str22;
                        if (!bg.mA(str22)) {
                            int indexOf = str22.indexOf("=");
                            String substring = str22.substring(0, indexOf);
                            str22 = str22.substring(indexOf + 1, str22.length());
                            if (!(bg.mA(substring) || bg.mA(str22))) {
                                hashMap.put(substring, str22);
                            }
                        }
                    }
                    this.rxB = hashMap;
                    if (this.rxB.containsKey("bank_type") || !this.rxB.containsKey("bind_serial")) {
                        w.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.rxz);
                        setResult(1);
                        finish();
                        return;
                    }
                    Cursor a = m.btQ().gUz.a("select * from WalletBankcard where bindSerial = '" + ((String) this.rxB.get("bind_serial")) + "'", null, 2);
                    if (a.moveToNext()) {
                        bankcard = new Bankcard();
                        bankcard.b(a);
                    }
                    a.close();
                    this.rxA = bankcard;
                    if (this.rxA == null) {
                        w.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
                        setResult(0);
                        finish();
                        return;
                    }
                    intent.putExtra("key_is_show_detail", false);
                    intent.putExtra("key_bankcard", this.rxA);
                    intent.putExtra("scene", 1);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, intent.getExtras(), new b.a(this) {
                        final /* synthetic */ WalletUnbindBankCardProxyUI rxC;

                        {
                            this.rxC = r1;
                        }

                        public final Intent j(int i, Bundle bundle) {
                            switch (i) {
                                case -1:
                                    this.rxC.setResult(-1);
                                    break;
                                case 0:
                                    this.rxC.setResult(0);
                                    break;
                                case 1:
                                    this.rxC.setResult(1);
                                    break;
                            }
                            return null;
                        }
                    });
                    return;
                }
            }
            hashMap = null;
            this.rxB = hashMap;
            if (this.rxB.containsKey("bank_type")) {
            }
            w.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.rxz);
            setResult(1);
            finish();
            return;
        }
        w.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onNewIntent(Intent intent) {
        finish();
    }
}
