package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rt;
import com.tencent.mm.e.a.rv;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(7)
public class WalletBindUI extends WalletBaseUI {
    private PayInfo oLz = new PayInfo();
    private boolean rxk = false;
    private String rxl;
    private int rxm = -1;
    private com.tencent.mm.plugin.wallet_core.b.a rxn = null;
    private boolean rxo = false;
    c rxp = new c<rt>(this) {
        final /* synthetic */ WalletBindUI rxq;

        {
            this.rxq = r2;
            this.usg = rt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.rxq.finish();
            return false;
        }
    };
    private String token = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hn(580);
        b rvVar = new rv();
        rvVar.nFq = new Runnable(this) {
            final /* synthetic */ WalletBindUI rxq;

            {
                this.rxq = r1;
            }

            public final void run() {
                if (!this.rxq.rxo) {
                    this.rxq.bsx();
                }
                this.rxq.rxo = true;
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(rvVar);
        com.tencent.mm.sdk.b.a.urY.b(this.rxp);
        o.ev(6, 0);
    }

    private void bsx() {
        this.rxl = getIntent().getStringExtra("key_import_key");
        this.rxm = getIntent().getIntExtra("key_bind_scene", -1);
        this.oLz.fRw = this.rxm;
        this.uT.putParcelable("key_pay_info", this.oLz);
        if (this.rxm == 2) {
            if (bg.mA(this.rxl)) {
                uC("");
                return;
            }
            w.d("MicroMsg.WalletBindUI", "importKey " + this.rxl);
            q(new com.tencent.mm.plugin.wallet.bind.a.c(this.rxl, this.oLz));
        } else if (this.rxm == 4) {
            n.CH(4);
            if (getIntent() == null) {
                uC("");
                return;
            }
            this.rxn = new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL));
            q(this.rxn);
        } else if (this.rxm == 6) {
            bsz();
        } else {
            bsy();
        }
    }

    private void bsy() {
        w.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bg.bJZ().toString());
        Bundle bundle = this.uT;
        bundle.putParcelable("key_pay_info", this.oLz);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        com.tencent.mm.plugin.wallet.a.o.bsC();
        if (com.tencent.mm.plugin.wallet.a.o.bsD().bul()) {
            w.i("MicroMsg.WalletBindUI", "user status invalid");
            q(new m(null));
            return;
        }
        com.tencent.mm.plugin.wallet.a.o.bsC();
        if (com.tencent.mm.plugin.wallet.a.o.bsD().bum()) {
            w.i("MicroMsg.WalletBindUI", "user status reg");
            this.rxk = true;
            this.oLz.fRw = this.rxm;
            bundle.putInt("key_bind_scene", this.oLz.fRw);
            if (!bg.mA(this.token)) {
                bundle.putString("kreq_token", this.token);
            }
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.a.b.class, bundle, null);
            return;
        }
        w.i("MicroMsg.WalletBindUI", "user status unreg");
        this.rxk = true;
        if (this.rxm >= 0) {
            this.oLz.fRw = this.rxm;
        } else {
            this.oLz.fRw = 1;
        }
        bundle.putInt("key_bind_scene", this.oLz.fRw);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.a.b.class, bundle, null);
    }

    private void bsz() {
        com.tencent.mm.plugin.wallet.a.o.bsC();
        if (com.tencent.mm.plugin.wallet.a.o.bsD().bul()) {
            q(new m(null));
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!bg.mA(str) && split.length >= 2) {
            String str2 = null;
            str = null;
            for (String str3 : split) {
                if (str3.startsWith("bankType=")) {
                    str2 = str3.replace("bankType=", "");
                } else if (str3.startsWith("bankName=")) {
                    str = str3.replace("bankName=", "");
                }
            }
            if (!(bg.mA(str) || bg.mA(str2))) {
                com.tencent.mm.plugin.wallet.a.o.bsC();
                if (com.tencent.mm.plugin.wallet.a.o.bsD().HX(str2)) {
                    Bundle bundle = new Bundle();
                    Object bankcard = new Bankcard();
                    bankcard.field_bankName = str;
                    bankcard.field_bankcardType = str2;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", bundle, null);
                    return;
                }
            }
        }
        finish();
    }

    public void onResume() {
        if (this.rxk) {
            finish();
        }
        super.onResume();
    }

    public void onDestroy() {
        ho(580);
        com.tencent.mm.sdk.b.a.urY.c(this.rxp);
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            this.rxk = true;
        }
        if (i != 0 || i2 != 0) {
            uC(str);
            return true;
        } else if (kVar instanceof m) {
            if (this.rxm == 6) {
                bsz();
            } else {
                bsx();
            }
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            com.tencent.mm.plugin.wallet.bind.a.c cVar = (com.tencent.mm.plugin.wallet.bind.a.c) kVar;
            Bundle bundle = this.uT;
            bundle.putBoolean("key_is_import_bind", true);
            if (cVar.ruj == null || cVar.ruj.size() <= 0) {
                if (bg.mA(str)) {
                    str = getString(R.l.fea);
                }
                g.a(this, str, null, false, new OnClickListener(this) {
                    final /* synthetic */ WalletBindUI rxq;

                    {
                        this.rxq = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rxq.finish();
                    }
                });
            } else {
                Bankcard bankcard = (Bankcard) cVar.ruj.get(0);
                if (bankcard.rEo) {
                    g.a(this, R.l.feB, 0, false, new OnClickListener(this) {
                        final /* synthetic */ WalletBindUI rxq;

                        {
                            this.rxq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rxq.finish();
                        }
                    });
                } else {
                    bundle.putBoolean("key_need_bind_response", true);
                    bundle.putString("kreq_token", cVar.token);
                    bundle.putString("key_bank_username", cVar.rwq);
                    bundle.putString("key_recommand_desc", cVar.rwr);
                    bundle.putParcelable("key_import_bankcard", bankcard);
                    this.rxk = true;
                    bundle.putInt("key_bind_scene", 2);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.a.b.class, bundle, new com.tencent.mm.wallet_core.b.a(this) {
                        final /* synthetic */ WalletBindUI rxq;

                        {
                            this.rxq = r1;
                        }

                        public final Intent j(int i, Bundle bundle) {
                            return new Intent(this.rxq.uSU.uTo, WalletBankcardManageUI.class);
                        }
                    });
                }
            }
            return true;
        } else {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
                if (this.rxn == null || !this.rxn.equals(kVar)) {
                    n.ccf();
                } else {
                    this.token = ((com.tencent.mm.plugin.wallet_core.b.a) kVar).aQZ();
                    bsy();
                    return true;
                }
            }
            return false;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.rxk);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.rxk = bundle.getBoolean("key_is_jump", false);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean aJc() {
        return false;
    }

    protected void onNewIntent(Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            finish();
            return;
        }
        super.onNewIntent(intent);
        w.v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            w.i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
        } else {
            w.d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
        }
        finish();
    }

    private void uC(String str) {
        if (bg.mA(str)) {
            str = getString(R.l.fkA);
        }
        g.a(this, str, null, false, new OnClickListener(this) {
            final /* synthetic */ WalletBindUI rxq;

            {
                this.rxq = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.rxq.finish();
            }
        });
    }

    protected final int Ol() {
        return 1;
    }
}
