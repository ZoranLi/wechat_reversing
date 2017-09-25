package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rs;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI extends MMActivity implements e {
    private String appId;
    private String fRu;
    private Dialog ita = null;
    private int ofL;
    private boolean rPZ = false;
    private b rQa;
    private com.tencent.mm.sdk.b.c rQb = new com.tencent.mm.sdk.b.c<rz>(this) {
        final /* synthetic */ WalletBrandUI rQd;

        {
            this.rQd = r2;
            this.usg = rz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rz rzVar = (rz) bVar;
            w.i("MicroMsg.WalletBrandUI", "onPayEnd payResult : " + rzVar.fZv.result);
            this.rQd.setResult(rzVar.fZv.result);
            this.rQd.finish();
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c rQc = new com.tencent.mm.sdk.b.c<rs>(this) {
        final /* synthetic */ WalletBrandUI rQd;

        {
            this.rQd = r2;
            this.usg = rs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (this.rQd.ita != null) {
                this.rQd.ita.dismiss();
                this.rQd.ita = null;
            }
            return true;
        }
    };

    interface b {
        void a(int i, int i2, String str, k kVar);

        int bvw();

        k bvx();
    }

    public class a implements b {
        final /* synthetic */ WalletBrandUI rQd;
        private int rQe = 0;

        public a(WalletBrandUI walletBrandUI) {
            this.rQd = walletBrandUI;
        }

        public final int bvw() {
            return 1563;
        }

        public final k bvx() {
            this.rQd.appId = this.rQd.getIntent().getStringExtra("appId");
            String stringExtra = this.rQd.getIntent().getStringExtra("signtype");
            String stringExtra2 = this.rQd.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = this.rQd.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = this.rQd.getIntent().getStringExtra("packageExt");
            String stringExtra5 = this.rQd.getIntent().getStringExtra("paySignature");
            String stringExtra6 = this.rQd.getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.rQe = this.rQd.getIntent().getIntExtra("result_jump_mode", 0);
            this.rQd.fRu = this.rQd.getIntent().getStringExtra("bizUsername");
            k aVar = new com.tencent.mm.plugin.wallet_index.c.a.a(this.rQd.appId, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra, stringExtra6, this.rQd.fRu, this.rQd.getIntent().getIntExtra("pay_channel", 0));
            ap.vd().a(aVar, 0);
            return aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.wallet_index.c.a.a)) {
                String str2 = ((com.tencent.mm.plugin.wallet_index.c.a.a) kVar).jumpUrl;
                w.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[]{str2});
                String str3 = ((com.tencent.mm.plugin.wallet_index.c.a.a) kVar).rPS;
                Intent intent;
                if (this.rQe == 1) {
                    intent = new Intent();
                    intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, str2);
                    intent.putExtra("jsInjectCode", str3);
                    this.rQd.setResult(-1, intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    if (!bg.mA(str3)) {
                        intent.putExtra("shouldForceViewPort", true);
                        intent.putExtra("view_port_code", str3);
                    }
                    com.tencent.mm.bb.d.b(this.rQd, "webview", ".ui.tools.WebViewUI", intent);
                    this.rQd.setResult(-1);
                }
                this.rQd.finish();
                return;
            }
            w.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            g.a(this.rQd, str, "", new OnClickListener(this) {
                final /* synthetic */ a rQf;

                {
                    this.rQf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rQf.rQd.setResult(0);
                    this.rQf.rQd.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a rQf;

                {
                    this.rQf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rQf.rQd.setResult(0);
                    this.rQf.rQd.finish();
                }
            });
        }
    }

    class c implements b {
        final /* synthetic */ WalletBrandUI rQd;

        c(WalletBrandUI walletBrandUI) {
            this.rQd = walletBrandUI;
        }

        public final k bvx() {
            this.rQd.appId = this.rQd.getIntent().getStringExtra("appId");
            String stringExtra = this.rQd.getIntent().getStringExtra("signtype");
            String stringExtra2 = this.rQd.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = this.rQd.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = this.rQd.getIntent().getStringExtra("packageExt");
            String stringExtra5 = this.rQd.getIntent().getStringExtra("paySignature");
            String stringExtra6 = this.rQd.getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.rQd.fRu = this.rQd.getIntent().getStringExtra("bizUsername");
            k aVar = new com.tencent.mm.plugin.wallet_index.c.b.a(this.rQd.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, this.rQd.fRu, this.rQd.getIntent().getIntExtra("pay_channel", 0));
            ap.vd().a(aVar, 0);
            return aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.wallet_index.c.b.a aVar = (com.tencent.mm.plugin.wallet_index.c.b.a) kVar;
            String str2 = aVar.rPI;
            w.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
            PayInfo payInfo = new PayInfo();
            payInfo.fJH = str2;
            payInfo.appId = this.rQd.appId;
            payInfo.rPJ = aVar.rPJ;
            payInfo.fRv = this.rQd.ofL;
            payInfo.fPf = str;
            payInfo.fRr = this.rQd.getIntent().getIntExtra("pay_channel", 0);
            com.tencent.mm.pluginsdk.wallet.e.a(this.rQd, payInfo, 1);
        }

        public final int bvw() {
            return 1521;
        }
    }

    class d implements b {
        final /* synthetic */ WalletBrandUI rQd;

        d(WalletBrandUI walletBrandUI) {
            this.rQd = walletBrandUI;
        }

        public final k bvx() {
            this.rQd.appId = this.rQd.getIntent().getStringExtra("appId");
            String stringExtra = this.rQd.getIntent().getStringExtra("signtype");
            String stringExtra2 = this.rQd.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = this.rQd.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = this.rQd.getIntent().getStringExtra("packageExt");
            String stringExtra5 = this.rQd.getIntent().getStringExtra("paySignature");
            String stringExtra6 = this.rQd.getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.rQd.fRu = this.rQd.getIntent().getStringExtra("bizUsername");
            k aVar = new com.tencent.mm.plugin.wallet_index.c.a(this.rQd.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, this.rQd.fRu, this.rQd.getIntent().getIntExtra("pay_channel", 0), this.rQd.ofL);
            aVar.lwh = System.currentTimeMillis();
            aVar.gWO = "PayProcess";
            aVar.hPi = this.rQd.ofL;
            ap.vd().a(aVar, 0);
            return aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_index.c.a aVar = (com.tencent.mm.plugin.wallet_index.c.a) kVar;
                String str2 = aVar.rPI;
                w.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
                PayInfo payInfo = new PayInfo();
                payInfo.fJH = str2;
                payInfo.appId = this.rQd.appId;
                payInfo.rPJ = aVar.rPJ;
                payInfo.fRv = this.rQd.ofL;
                payInfo.fPf = str;
                payInfo.fRr = this.rQd.getIntent().getIntExtra("pay_channel", 0);
                payInfo.sYi = aVar.lwh;
                com.tencent.mm.pluginsdk.wallet.e.a(this.rQd, payInfo, 1);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_jsapi_pay_err_code", i2);
            String str3 = "key_jsapi_pay_err_msg";
            if (bg.mA(str)) {
                str = this.rQd.getString(R.l.fgK);
            }
            intent.putExtra(str3, str);
            this.rQd.setResult(5, intent);
            this.rQd.finish();
        }

        public final int bvw() {
            return 398;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        this.ofL = getIntent().getIntExtra("pay_scene", 3);
        o.ccg();
        w.i("MicroMsg.WalletBrandUI", "onCreate");
        int intExtra = getIntent().getIntExtra("pay_for_wallet_type", 1);
        w.i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is " + intExtra);
        if (m.xY()) {
            w.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
            this.rQa = new c(this);
        } else if (intExtra == 2) {
            w.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
            this.rQa = new a(this);
        } else {
            w.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
            this.rQa = new d(this);
        }
        com.tencent.mm.sdk.b.a.urY.b(this.rQb);
        com.tencent.mm.sdk.b.a.urY.b(this.rQc);
        ap.vd().a(this.rQa.bvw(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        ap.vd().b(this.rQa.bvw(), this);
        com.tencent.mm.sdk.b.a.urY.c(this.rQb);
        com.tencent.mm.sdk.b.a.urY.c(this.rQc);
    }

    public void onResume() {
        w.d("MicroMsg.WalletBrandUI", "onResume");
        super.onResume();
        w.i("MicroMsg.WalletBrandUI", "Handler jump");
        if (!this.rPZ) {
            this.rPZ = true;
            final k bvx = this.rQa.bvx();
            if (this.ita != null) {
                this.ita.dismiss();
                this.ita = null;
            }
            this.ita = com.tencent.mm.wallet_core.ui.g.e(this, new OnCancelListener(this) {
                final /* synthetic */ WalletBrandUI rQd;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(bvx);
                    this.rQd.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        if (this.ita != null) {
            this.ita.dismiss();
            this.ita = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() == this.rQa.bvw()) {
            this.rQa.a(i, i2, str, kVar);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + i2 + " requestCode: " + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    w.i("MicroMsg.WalletBrandUI", "get result to callback? " + intent.getStringExtra("test"));
                    break;
            }
        }
        finish();
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
