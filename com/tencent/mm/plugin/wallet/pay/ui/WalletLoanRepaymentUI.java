package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.pay.a.b;
import com.tencent.mm.plugin.wallet_core.b.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(7)
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private String desc;
    private String lOq;
    private double oQE;
    private String oga = "CNY";
    protected l ruh;
    private String rzm;
    private String rzn;
    private String rzo;
    private String rzp;
    private String rzq;
    private String rzr;
    private String rzs;
    private String rzt;
    private String token;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.rzr = intent.getStringExtra("appId");
        this.rzm = intent.getStringExtra("timeStamp");
        this.rzn = intent.getStringExtra("nonceStr");
        this.rzo = intent.getStringExtra("packageExt");
        this.rzp = intent.getStringExtra("signtype");
        this.rzq = intent.getStringExtra("paySignature");
        this.rzs = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        hn(580);
        q(new com.tencent.mm.plugin.wallet_core.b.a(this.rzr, this.rzm, this.rzn, this.rzo, this.rzp, this.rzq, this.rzs));
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void HN(String str) {
        b(new b(str), true);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
                this.token = ((com.tencent.mm.plugin.wallet_core.b.a) kVar).aQZ();
                HN(this.token);
                return true;
            } else if (kVar instanceof b) {
                b bVar = (b) kVar;
                this.oga = bVar.oga;
                this.oQE = bVar.oQE;
                this.desc = bVar.desc;
                ac btT = m.btT();
                if (btT.bud()) {
                    Bankcard bue = btT.bue();
                    if (bue == null || !bg.mA(bue.field_forbidWord)) {
                        bsR();
                    } else {
                        a(bue, this.oQE, this.oga);
                    }
                } else {
                    g.a(this, getResources().getString(R.l.fgl), "", getString(R.l.fie), getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ WalletLoanRepaymentUI rzu;

                        {
                            this.rzu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
                            this.rzu.bsS();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletLoanRepaymentUI rzu;

                        {
                            this.rzu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.rzu.aIY()) {
                                this.rzu.finish();
                            }
                        }
                    });
                }
                return true;
            } else if (kVar instanceof j) {
                j jVar = (j) kVar;
                if (jVar.btt()) {
                    w.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.lOq);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", jVar.rBU);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", jVar.rBT);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.ui.j.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", jVar.rBR);
                    intent.putExtra("bind_serial", this.rzt);
                    setResult(-1, intent);
                    finish();
                }
                return true;
            }
        }
        return false;
    }

    private void a(Bankcard bankcard, double d, String str) {
        c anonymousClass1 = new c(this) {
            final /* synthetic */ WalletLoanRepaymentUI rzu;

            {
                this.rzu = r1;
            }

            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                this.rzu.lOq = str;
                this.rzu.k(new j(this.rzu.lOq, this.rzu.token));
            }
        };
        View.OnClickListener anonymousClass2 = new View.OnClickListener(this) {
            final /* synthetic */ WalletLoanRepaymentUI rzu;

            {
                this.rzu = r1;
            }

            public final void onClick(View view) {
                this.rzu.bsR();
                if (this.rzu.ruh != null) {
                    this.rzu.ruh.dismiss();
                }
            }
        };
        OnCancelListener anonymousClass3 = new OnCancelListener(this) {
            final /* synthetic */ WalletLoanRepaymentUI rzu;

            {
                this.rzu = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.rzu.ruh != null) {
                    this.rzu.ruh.cancel();
                    this.rzu.setResult(0);
                    this.rzu.finish();
                }
            }
        };
        this.rzt = bankcard.field_bindSerial;
        this.ruh = l.a(this, this.desc, d, str, bankcard, anonymousClass1, anonymousClass2, anonymousClass3);
    }

    private void bsR() {
        w.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    }

    protected final void bsS() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, bundle, new com.tencent.mm.wallet_core.b.a(this) {
            final /* synthetic */ WalletLoanRepaymentUI rzu;

            {
                this.rzu = r1;
            }

            public final Intent j(int i, Bundle bundle) {
                if (i == -1) {
                    this.rzu.HN(this.rzu.token);
                } else {
                    ac btT = m.btT();
                    if (btT.bud()) {
                        this.rzu.a(btT.bue(), this.rzu.oQE, this.rzu.oga);
                    } else {
                        this.rzu.setResult(0, null);
                    }
                }
                return null;
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        w.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            w.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            HN(this.token);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            w.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.rzt);
            setResult(-1, intent2);
            finish();
        } else {
            w.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            int intExtra = intent.getIntExtra("ret", DownloadResult.CODE_UNDEFINED);
            if (intExtra == -1003) {
                w.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                bsS();
            } else if (intExtra == 0) {
                w.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                a(m.btT().HW(intent.getStringExtra("bindSerial")), this.oQE, this.oga);
            } else {
                w.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
            }
        } else {
            ac btT = m.btT();
            if (btT.bud()) {
                Bankcard bue = btT.bue();
                if (bue == null || !bg.mA(bue.field_forbidWord)) {
                    finish();
                    return;
                } else {
                    a(bue, this.oQE, this.oga);
                    return;
                }
            }
            w.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
        }
    }

    protected final int Ol() {
        return 1;
    }
}
