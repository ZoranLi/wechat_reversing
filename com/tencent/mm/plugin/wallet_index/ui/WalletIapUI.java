package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rs;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI extends MMActivity implements e {
    private int count = 1;
    private Dialog jjI;
    private boolean rQg = false;
    private List<String> rQh = new ArrayList();
    private ArrayList<String> rQi = new ArrayList();
    private ArrayList<String> rQj = new ArrayList();
    private b rQk;
    private long rQl = 0;
    private c rQm = new c(this) {
        final /* synthetic */ WalletIapUI rQo;

        {
            this.rQo = r1;
        }

        public final void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.d dVar) {
            w.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + bVar + ", purchase: " + dVar);
            if (this.rQo.rQk instanceof a) {
                if (dVar != null) {
                    o.b(dVar.rPB, dVar.kMS, dVar.rPH, bVar.mKQ, bVar.mMessage);
                } else {
                    a aVar = (a) this.rQo.rQk;
                    o.b(aVar.rQt, aVar.kMS, aVar.rPH, bVar.mKQ, bVar.mMessage);
                }
            }
            if (bVar.isFailure()) {
                w.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + bVar.mKQ + " , errMsg: " + bVar.mMessage);
                Intent intent = new Intent();
                intent.putExtra("key_err_code", bVar.mKQ);
                intent.putExtra("key_err_msg", bVar.mMessage);
                intent.putExtra("key_launch_ts", this.rQo.rQl);
                intent.putExtra("key_gw_error_code", bVar.rPy);
                this.rQo.setResult(-1, intent);
                this.rQo.finish();
            } else if (bVar.bvv()) {
                w.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.rQo.rQk.iL(false);
            } else {
                w.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + dVar.kMS + ",billNo:" + dVar.rPE);
                ap.vd().a(new j(dVar.kMS, this.rQo.rQk.bvy(), this.rQo.count, dVar.rPE, dVar.rPF, dVar.qJM, dVar.rPG, dVar.rPH), 0);
            }
        }
    };
    private c rQn = new c(this) {
        final /* synthetic */ WalletIapUI rQo;

        {
            this.rQo = r1;
        }

        public final void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.d dVar) {
            w.d("MicroMsg.WalletIapUI", "Consume finished: " + bVar + ", purchase: " + dVar);
            if (bVar.isFailure()) {
                w.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
            } else {
                w.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
            }
            Intent intent = new Intent();
            intent.putExtra("key_err_code", bVar.mKQ);
            intent.putExtra("key_err_msg", bVar.mMessage);
            intent.putStringArrayListExtra("key_response_product_ids", this.rQo.rQi);
            intent.putStringArrayListExtra("key_response_series_ids", this.rQo.rQj);
            intent.putExtra("key_launch_ts", this.rQo.rQl);
            this.rQo.setResult(-1, intent);
            this.rQo.finish();
        }
    };

    interface b {
        void a(Activity activity, i iVar, c cVar);

        void a(ArrayList<String> arrayList, c cVar, boolean z);

        int bvy();

        boolean c(int i, int i2, Intent intent);

        void iL(boolean z);

        void onDestroy();
    }

    public interface c {
        void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.d dVar);
    }

    class a implements b {
        BroadcastReceiver iRM = new BroadcastReceiver(this) {
            final /* synthetic */ a rQu;

            {
                this.rQu = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(action)) {
                    this.rQu.rQs = com.tencent.mm.plugin.wallet_index.b.a.a.a(intent, this.rQu.rQp);
                } else if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(action)) {
                    final boolean booleanExtra = intent.getBooleanExtra("is_direct", true);
                    this.rQu.rQr.a(intent, new com.tencent.mm.plugin.wallet_index.b.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 rQv;

                        public final void a(com.tencent.mm.plugin.wallet_index.b.a.b bVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar) {
                            w.d("MicroMsg.WalletIapUI", "Query inventory finished.");
                            if (bVar.isFailure() || cVar == null) {
                                w.w("MicroMsg.WalletIapUI", "Failed to query inventory: " + bVar);
                                return;
                            }
                            w.d("MicroMsg.WalletIapUI", "Query inventory was successful.");
                            this.rQv.rQu.rQs = cVar;
                            this.rQv.rQu.rQo.rQh = new ArrayList(cVar.rPz.keySet());
                            List<com.tencent.mm.plugin.wallet_index.b.a.d> arrayList = new ArrayList(cVar.rPz.values());
                            if (arrayList.size() > 0) {
                                for (com.tencent.mm.plugin.wallet_index.b.a.d dVar : arrayList) {
                                    w.i("MicroMsg.WalletIapUI", "do NetSceneVerifyPurchase. productId:" + dVar.kMS + ",billNo:" + dVar.rPE);
                                    if (dVar.kMS.equals(this.rQv.rQu.kMS)) {
                                        ap.vd().a(new j(dVar.kMS, 3, this.rQv.rQu.rQo.count, dVar.rPE, dVar.rPF, dVar.qJM, this.rQv.rQu.rPG, this.rQv.rQu.rPH), 0);
                                        w.v("MicroMsg.WalletIapUI", "after price:%s , currencyType:%s", new Object[]{this.rQv.rQu.rPH, this.rQv.rQu.rPG});
                                    } else {
                                        ap.vd().a(new j(dVar.kMS, 3, this.rQv.rQu.rQo.count, dVar.rPE, dVar.rPF, dVar.qJM, dVar.rPG, dVar.rPH), 0);
                                    }
                                }
                                return;
                            }
                            com.tencent.mm.plugin.wallet_index.b.a.b vH;
                            w.d("MicroMsg.WalletIapUI", "purchases is null. consume null ");
                            if (booleanExtra) {
                                w.d("MicroMsg.WalletIapUI", "result ok");
                                vH = com.tencent.mm.plugin.wallet_index.b.a.b.vH(0);
                            } else {
                                w.d("MicroMsg.WalletIapUI", "unknown_purchase");
                                vH = com.tencent.mm.plugin.wallet_index.b.a.b.vH(-2002);
                            }
                            if (this.rQv.rQu.rQo.rQn != null) {
                                this.rQv.rQu.rQo.rQn.a(vH, null);
                            }
                        }
                    });
                }
            }
        };
        public String kMS;
        public String rPG;
        public String rPH;
        final /* synthetic */ WalletIapUI rQo;
        public c rQp = null;
        private c rQq = null;
        public com.tencent.mm.plugin.wallet_index.b.a.a rQr;
        public com.tencent.mm.plugin.wallet_index.b.a.c rQs;
        String rQt;

        public a(WalletIapUI walletIapUI) {
            this.rQo = walletIapUI;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
            intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
            walletIapUI.registerReceiver(this.iRM, intentFilter);
            this.rQr = new com.tencent.mm.plugin.wallet_index.b.a.a();
        }

        public final int bvy() {
            return 3;
        }

        public final void a(Activity activity, i iVar, c cVar) {
            this.rQp = cVar;
            this.kMS = iVar.kMS;
            this.rPH = iVar.rPH;
            this.rPG = iVar.rPG;
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
            intent.setPackage("com.tencent.mm");
            intent.putExtra("product_id", this.kMS);
            this.rQt = iVar.cbY();
            String str = "developer_pay_load";
            String str2 = this.rQt;
            String str3 = this.rPH;
            String str4 = this.rPG;
            if (bg.mA(str2)) {
                str2 = "";
            }
            if (bg.mA(str3)) {
                str3 = "";
            }
            if (bg.mA(str4)) {
                str4 = "";
            }
            intent.putExtra(str, str2 + "[#]" + str3 + "[#]" + str4);
            if (activity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
                w.i("MicroMsg.WalletIapUI", "Try to downloading GWallet Moudle!");
                com.tencent.mm.plugin.wallet_index.b.a.b vH = com.tencent.mm.plugin.wallet_index.b.a.b.vH(-2000);
                if (this.rQp != null) {
                    this.rQp.a(vH, null);
                    return;
                }
                return;
            }
            this.rQo.rQl = bg.Nz();
            w.i("MicroMsg.WalletIapUI", "GWallet Found!");
            activity.startActivityForResult(intent, CdnLogic.MediaType_FAVORITE_FILE);
        }

        public final void onDestroy() {
            try {
                this.rQo.unregisterReceiver(this.iRM);
            } catch (IllegalArgumentException e) {
                w.e("MicroMsg.WalletIapUI", e.toString());
            }
            if (!bg.bp(this.rQo)) {
                w.d("MicroMsg.WalletIapUI", "close front UI.");
                Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
                intent.setPackage("com.tencent.mm");
                this.rQo.sendBroadcast(intent);
            }
            w.d("MicroMsg.WalletIapUI", "Destroying helper.");
        }

        private void vI(int i) {
            com.tencent.mm.plugin.wallet_index.b.a.b vH = com.tencent.mm.plugin.wallet_index.b.a.b.vH(i);
            Intent intent = new Intent();
            intent.putExtra("key_err_code", vH.mKQ);
            intent.putExtra("key_err_msg", vH.mMessage);
            intent.putExtra("key_launch_ts", this.rQo.rQl);
            this.rQo.setResult(-1, intent);
            this.rQo.finish();
        }

        public final boolean c(int i, int i2, Intent intent) {
            if (i == CdnLogic.MediaType_FAVORITE_FILE) {
                w.i("MicroMsg.WalletIapUI", "purchase flow!result_code: %d", new Object[]{Integer.valueOf(i2)});
                if (intent != null) {
                    int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                    if (intExtra == -2001 || intExtra == 3) {
                        o.b(this.rQt, this.kMS, this.rPH, intExtra, "");
                        vI(intExtra);
                    } else if (intExtra == -3000) {
                        vI(intExtra);
                    }
                } else {
                    vI(1);
                }
                return true;
            }
            c cVar = this.rQq;
            String str = this.rQt;
            String str2 = this.kMS;
            String str3 = this.rPH;
            int U = com.tencent.mm.plugin.wallet_index.b.a.a.U(intent);
            w.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(U));
            com.tencent.mm.plugin.wallet_index.b.a.b vH = com.tencent.mm.plugin.wallet_index.b.a.b.vH(U);
            o.b(str, str2, str3, U, vH.mMessage);
            if (cVar != null) {
                cVar.a(vH, null);
            }
            return true;
        }

        public final void iL(boolean z) {
            w.d("MicroMsg.WalletIapUI", "restorePurchase. Querying inventory.");
            w.d("MicroMsg.WalletIapUI", "is direct? " + z);
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
            intent.setPackage("com.tencent.mm");
            intent.putExtra("is_direct", z);
            this.rQo.startActivityForResult(intent, CdnLogic.MediaType_FAVORITE_FILE);
        }

        public final void a(ArrayList<String> arrayList, c cVar, boolean z) {
            this.rQq = cVar;
            w.d("MicroMsg.WalletIapUI", "consumePurchase. consume...");
            com.tencent.mm.plugin.wallet_index.b.a.c cVar2 = this.rQs;
            ArrayList arrayList2 = new ArrayList();
            for (String str : arrayList) {
                com.tencent.mm.plugin.wallet_index.b.a.d dVar = (com.tencent.mm.plugin.wallet_index.b.a.d) cVar2.rPz.get(str);
                if (dVar != null) {
                    arrayList2.add(dVar.hEr);
                }
            }
            if (arrayList2.size() > 0) {
                Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
                intent.setPackage("com.tencent.mm");
                intent.putStringArrayListExtra("tokens", arrayList2);
                intent.putExtra("IS_FAILED_CONSUME", z);
                this.rQo.sendBroadcast(intent);
                return;
            }
            com.tencent.mm.plugin.wallet_index.b.a.b vH = com.tencent.mm.plugin.wallet_index.b.a.b.vH(0);
            if (this.rQq != null) {
                this.rQq.a(vH, null);
            }
        }
    }

    class d implements b {
        private String kMS = null;
        private com.tencent.mm.sdk.b.c oqW = new com.tencent.mm.sdk.b.c<rs>(this) {
            final /* synthetic */ d rQx;

            {
                this.rQx = r2;
                this.usg = rs.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (((rs) bVar) instanceof rs) {
                    if (this.rQx.rQo.jjI != null && this.rQx.rQo.jjI.isShowing()) {
                        this.rQx.rQo.jjI.dismiss();
                        this.rQx.rQo.jjI = null;
                    }
                    return true;
                }
                w.f("MicroMsg.WalletIapUI", "mismatched event");
                return false;
            }
        };
        private String rPG = null;
        private String rPH = null;
        final /* synthetic */ WalletIapUI rQo;
        private String rQt = null;
        private c rQw = null;

        public d(WalletIapUI walletIapUI) {
            this.rQo = walletIapUI;
            com.tencent.mm.sdk.b.a.urY.b(this.oqW);
        }

        public final int bvy() {
            return 2;
        }

        public final void a(Activity activity, i iVar, c cVar) {
            String str;
            o.ccg();
            this.rQw = cVar;
            this.kMS = iVar.kMS;
            this.rQt = iVar.cbY();
            this.rPH = iVar.rPH;
            this.rPG = iVar.rPG;
            PayInfo payInfo = new PayInfo();
            arh com_tencent_mm_protocal_c_arh = (arh) iVar.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_arh != null) {
                w.d("MicroMsg.NetScenePreparePurchase", "get TradeToken4TenPay is " + com_tencent_mm_protocal_c_arh.tVI);
                str = com_tencent_mm_protocal_c_arh.tVI;
            } else {
                w.e("MicroMsg.NetScenePreparePurchase", "get TradeToken4TenPay field.");
                str = "";
            }
            payInfo.fJH = str;
            com_tencent_mm_protocal_c_arh = (arh) iVar.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_arh != null) {
                w.d("MicroMsg.NetScenePreparePurchase", "get Partner4TenPay is " + com_tencent_mm_protocal_c_arh.tVJ);
                str = com_tencent_mm_protocal_c_arh.tVJ;
            } else {
                w.e("MicroMsg.NetScenePreparePurchase", "get Partner4TenPay field.");
                str = "";
            }
            payInfo.partnerId = str;
            com_tencent_mm_protocal_c_arh = (arh) iVar.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_arh != null) {
                w.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + com_tencent_mm_protocal_c_arh.tVK);
                str = com_tencent_mm_protocal_c_arh.tVK;
            } else {
                w.e("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay field.");
                str = "";
            }
            payInfo.sYc = str;
            payInfo.fRv = 5;
            com.tencent.mm.pluginsdk.wallet.e.a(activity, payInfo, 1);
        }

        public final boolean c(int i, int i2, Intent intent) {
            w.d("MicroMsg.WalletIapUI", "onPayEnd payResult : " + i2);
            if (this.rQw != null) {
                com.tencent.mm.plugin.wallet_index.b.a.b av;
                if (i2 == -1) {
                    av = com.tencent.mm.plugin.wallet_index.b.a.b.av(0, "");
                } else {
                    av = com.tencent.mm.plugin.wallet_index.b.a.b.av(100000000, "");
                }
                this.rQw.a(av, new com.tencent.mm.plugin.wallet_index.b.a.d(this.kMS, this.rQt, this.rPG, this.rPH));
                this.rQw = null;
            }
            return true;
        }

        public final void onDestroy() {
            com.tencent.mm.sdk.b.a.urY.c(this.oqW);
        }

        public final void iL(boolean z) {
            Intent intent = new Intent();
            intent.putExtra("key_err_code", 0);
            intent.putExtra("key_err_msg", "");
            this.rQo.setResult(-1, intent);
            this.rQo.finish();
        }

        public final void a(ArrayList<String> arrayList, c cVar, boolean z) {
            if (cVar != null) {
                cVar.a(com.tencent.mm.plugin.wallet_index.b.a.b.av(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.d(this.kMS, this.rQt, this.rPG, this.rPH));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.v("MicroMsg.WalletIapUI", "onCreate");
        this.rQl = 0;
        ap.vd().a(422, this);
        ap.vd().a(414, this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            this.jjI = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ WalletIapUI rQo;

                {
                    this.rQo = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.rQo.setResult(0);
                    this.rQo.finish();
                }
            });
        }
        if (getIntent().getBooleanExtra("key_force_google", false) || m.xX()) {
            w.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.rQk = new a(this);
            return;
        }
        w.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
        this.rQk = new d(this);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        w.d("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        w.d("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.rQg) {
            this.rQg = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                w.d("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.rQk.iL(true);
                return;
            }
            String stringExtra = intent.getStringExtra("key_product_id");
            this.rQh.add(stringExtra);
            w.d("MicroMsg.WalletIapUI", "prepare pay product: " + stringExtra);
            String stringExtra2 = intent.getStringExtra("key_price");
            String stringExtra3 = intent.getStringExtra("key_currency_type");
            String stringExtra4 = intent.getStringExtra("key_ext_info");
            this.count = intent.getIntExtra("key_count", 1);
            ap.vd().a(new i(stringExtra, stringExtra2, stringExtra3, this.count, this.rQk.bvy(), stringExtra4), 0);
        }
    }

    protected void onNewIntent(Intent intent) {
        w.d("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        w.d("MicroMsg.WalletIapUI", "onDestroy");
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.rQk != null) {
            this.rQk.c(i, i2, intent);
            w.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            return;
        }
        w.i("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        com.tencent.mm.plugin.wallet_index.b.a.b av = com.tencent.mm.plugin.wallet_index.b.a.b.av(-1, "");
        intent2.putExtra("key_err_code", av.mKQ);
        intent2.putExtra("key_err_msg", av.mMessage);
        intent2.putExtra("key_launch_ts", this.rQl);
        setResult(-1, intent2);
        finish();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletIapUI", "onSceneEnd ErrType:" + i + ", errCode:" + i2 + ",errMsg:" + str);
        com.tencent.mm.plugin.wallet_index.b.a.b av = com.tencent.mm.plugin.wallet_index.b.a.b.av(i2, str);
        int i3 = av.mKQ;
        String str2 = av.mMessage;
        w.i("MicroMsg.WalletIapUI", "onSceneEnd getWeiXinResult errCode:" + i3 + ",errMsg:" + str2);
        Intent intent;
        switch (kVar.getType()) {
            case 414:
                boolean z = false;
                j jVar = (j) kVar;
                String str3 = jVar.kMS;
                this.rQh.remove(str3);
                if (i3 == 0) {
                    w.i("MicroMsg.WalletIapUI", "Verify " + str3 + " OK");
                    this.rQi.add(str3);
                    this.rQj.add(jVar.cbZ());
                } else if (!str3.startsWith("com.tencent.xin.wco")) {
                    w.i("MicroMsg.WalletIapUI", "Verify " + str3 + " fail");
                } else if (jVar.wEf > 0) {
                    this.rQi.add(str3);
                    this.rQj.add(jVar.cbZ());
                    w.i("MicroMsg.WalletIapUI", "Verify " + str3 + " fail and cosume");
                    z = true;
                } else {
                    w.i("MicroMsg.WalletIapUI", "Verify " + str3 + " fail");
                }
                if (this.rQh.isEmpty()) {
                    w.d("MicroMsg.WalletIapUI", "Verify All End... ");
                    if (this.rQi.isEmpty()) {
                        w.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                        intent = new Intent();
                        intent.putExtra("key_err_code", i3);
                        intent.putExtra("key_err_msg", str2);
                        intent.putExtra("key_response_position", 3);
                        intent.putExtra("key_launch_ts", this.rQl);
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    w.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.rQi.size() + ", Consume ...");
                    this.rQk.a(this.rQi, this.rQn, z);
                    return;
                }
                return;
            case 422:
                if (i3 == 0) {
                    w.i("MicroMsg.WalletIapUI", "Prepare OK, LaunchPay...");
                    this.rQk.a((Activity) this, (i) kVar, this.rQm);
                    return;
                }
                w.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                intent = new Intent();
                intent.putExtra("key_err_code", i3);
                intent.putExtra("key_err_msg", str2);
                intent.putExtra("key_response_position", 1);
                setResult(-1, intent);
                finish();
                return;
            default:
                return;
        }
    }

    public void finish() {
        w.i("MicroMsg.WalletIapUI", "finish");
        if (this.jjI != null && this.jjI.isShowing()) {
            this.jjI.dismiss();
            this.jjI = null;
        }
        if (this.rQk != null) {
            this.rQk.onDestroy();
        }
        ap.vd().b(422, this);
        ap.vd().b(414, this);
        super.finish();
    }
}
