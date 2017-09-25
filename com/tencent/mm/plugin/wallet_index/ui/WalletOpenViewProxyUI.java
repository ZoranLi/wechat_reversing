package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletOpenViewProxyUI extends WalletBaseUI {
    private Map<String, String> rQz = new HashMap();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(8);
        String stringExtra = getIntent().getStringExtra("packageExt");
        this.rQz = new HashMap();
        if (!bg.mA(stringExtra)) {
            String[] split = stringExtra.split("&");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (!bg.mA(split[i])) {
                        String[] split2 = split[i].split("=");
                        if (split2.length == 2 && !bg.mA(split2[0])) {
                            this.rQz.put(split2[0], split2[1]);
                        }
                    }
                }
            }
        }
        hn(580);
        hn(385);
        if (getIntent() == null) {
            w.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            return;
        }
        stringExtra = (String) this.rQz.get("openview");
        String stringExtra2 = getIntent().getStringExtra("appId");
        String stringExtra3 = getIntent().getStringExtra("timeStamp");
        String stringExtra4 = getIntent().getStringExtra("nonceStr");
        String stringExtra5 = getIntent().getStringExtra("packageExt");
        String stringExtra6 = getIntent().getStringExtra("paySignature");
        if ("open_wcpay_f2f_receive_detail".equals(stringExtra)) {
            q(new l(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6));
        } else if ("open_wcpay_grouppay_detail".equals(stringExtra)) {
            Iw(stringExtra5);
        } else if ("open_wcpay_lqt_detail".equals(stringExtra)) {
            d.w(this.uSU.uTo, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
            g.oUh.a(663, 18, 1, false);
            setResult(-1);
            finish();
        } else {
            q(new com.tencent.mm.plugin.wallet_core.b.a(stringExtra2, stringExtra3, stringExtra4, stringExtra5, getIntent().getStringExtra("signtype"), stringExtra6, getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 4));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            setResult(0);
            finish();
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
            Iw(getIntent().getStringExtra("packageExt"));
            return true;
        } else if (!(kVar instanceof l)) {
            return false;
        } else {
            Iw(getIntent().getStringExtra("packageExt"));
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ho(580);
        ho(385);
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void Iw(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
        } else {
            String str2 = (String) this.rQz.get("openview");
            if ("open_wcpay_biz_view".equals(str2)) {
                w.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
                d.w(this.uSU.uTo, "mall", ".ui.MallIndexUI");
            } else if ("open_wcpay_balance_view".equals(str2)) {
                w.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
                e.R(this.uSU.uTo, 0);
            } else if ("open_wcpay_order_detail_view".equals(str2)) {
                w.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
                r1 = new Intent();
                r1.putExtra("trans_id", (String) this.rQz.get("trans_id"));
                r1.putExtra("scene", 1);
                if (this.rQz.containsKey("bill_id")) {
                    r1.putExtra("bill_id", (String) this.rQz.get("bill_id"));
                }
                d.b(this.uSU.uTo, "order", ".ui.MallOrderTransactionInfoUI", r1);
            } else if ("open_wcpay_f2f_receive_detail".equals(str2)) {
                w.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
                r1 = new Intent();
                r1.putExtra("key_timestamp", bg.getLong((String) this.rQz.get("fromtimestamp"), 0));
                r1.putExtra("key_from_scene", 1);
                d.b(this.uSU.uTo, "collect", ".ui.CollectBillUI", r1);
                g.oUh.i(13944, new Object[]{Integer.valueOf(2)});
            } else if ("open_wcpay_grouppay_detail".equals(str2)) {
                w.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
                r1 = new Intent();
                r1.putExtra("bill_no", (String) this.rQz.get("billno"));
                r1.putExtra("chatroom", (String) this.rQz.get("groupid"));
                r1.putExtra("key_sign", (String) this.rQz.get("sign"));
                r1.putExtra("key_ver", (String) this.rQz.get("ver"));
                r1.putExtra("enter_scene", 5);
                d.b(this.uSU.uTo, "aa", ".ui.PaylistAAUI", r1);
            } else {
                w.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : " + str2);
            }
        }
        setResult(-1);
        finish();
    }
}
