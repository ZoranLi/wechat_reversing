package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.balance.a.c;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import java.util.ArrayList;

@a(3)
public class WalletBalanceSaveUI extends WalletBaseUI {
    private final int ipO = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 270);
    protected WalletFormView kBW;
    private View khv;
    protected Button liz;
    public double oRf;
    private ArrayList<Bankcard> ruj;
    protected Bankcard ruk;
    private String rul;
    public WalletFormView run;

    static /* synthetic */ void d(WalletBalanceSaveUI walletBalanceSaveUI) {
        if (walletBalanceSaveUI.khv != null) {
            final int i;
            int[] iArr = new int[2];
            walletBalanceSaveUI.liz.getLocationInWindow(iArr);
            int dP = (com.tencent.mm.bg.a.dP(walletBalanceSaveUI) - i) - com.tencent.mm.bg.a.fromDPToPix(walletBalanceSaveUI, 30);
            w.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + walletBalanceSaveUI.liz.getHeight()), Integer.valueOf(com.tencent.mm.bg.a.dP(walletBalanceSaveUI)), Integer.valueOf(dP), Integer.valueOf(walletBalanceSaveUI.ipO)});
            if (dP > 0 && dP < walletBalanceSaveUI.ipO) {
                i = walletBalanceSaveUI.ipO - dP;
                w.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(i)});
                walletBalanceSaveUI.khv.post(new Runnable(walletBalanceSaveUI) {
                    final /* synthetic */ WalletBalanceSaveUI ruW;

                    public final void run() {
                        this.ruW.khv.scrollBy(0, i);
                    }
                });
            }
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof c) {
                boolean a;
                c cVar = (c) kVar;
                if ("1".equals(cVar.fZb)) {
                    w.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    String str2 = cVar.fZc;
                    str2 = cVar.fZd;
                    String str3 = cVar.fZe;
                    aIY();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 0);
                } else if ("2".equals(cVar.fZb)) {
                    w.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, cVar.fZc, cVar.fZf, cVar.fZd, cVar.fZe, aIY(), null);
                } else {
                    w.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + cVar.fZb);
                    a = false;
                }
                if (!a) {
                    e.a(this, this.ruk == null ? "" : this.ruk.field_bindSerial, ((c) kVar).fLT, "", 11, 1);
                }
            } else if (kVar instanceof m) {
                bsh();
                ar();
            }
        }
        return false;
    }

    private void bsh() {
        int i;
        o.bsC();
        af bsD = o.bsD();
        this.ruj = bsD.buy();
        this.ruk = bsD.a(this.ruj, null, false, true);
        if (this.ruk != null && bg.mA(this.ruk.field_forbidWord)) {
            this.ruk = null;
            i = 0;
            while (i < this.ruj.size()) {
                if (this.ruj.get(i) != null && bg.mA(((Bankcard) this.ruj.get(i)).field_forbidWord)) {
                    this.ruk = (Bankcard) this.ruj.get(i);
                    break;
                }
                i++;
            }
        }
        if (!(this.ruk == null || bg.mA(this.ruk.field_forbidWord))) {
            this.ruk = null;
        }
        ArrayList arrayList = this.ruj;
        if (arrayList != null) {
            for (i = 0; i < arrayList.size(); i++) {
                w.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[]{Integer.valueOf(i), ((Bankcard) arrayList.get(i)).field_forbidWord});
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dqa;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.tencent.mm.u.m.xY()) {
            b(new m(null, 3), false);
        }
        bsh();
        this.rul = getString(R.l.fdI);
        KC();
        ar();
        com.tencent.mm.wallet_core.c.o.ev(3, 0);
    }

    protected final void KC() {
        zi(R.l.fdL);
        this.khv = findViewById(R.h.czD);
        this.kBW = (WalletFormView) findViewById(R.h.cla);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.kBW);
        this.kBW.jhl.setText(s.ccn());
        d(this.kBW, 2, false);
        this.liz = (Button) findViewById(R.h.cnY);
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceSaveUI ruW;

            {
                this.ruW = r1;
            }

            public final void onClick(View view) {
                this.ruW.oRf = bg.getDouble(this.ruW.kBW.getText(), 0.0d);
                if (this.ruW.oRf <= 0.0d || !this.ruW.kBW.Pb()) {
                    com.tencent.mm.ui.base.s.makeText(this.ruW.uSU.uTo, R.l.fdK, 0).show();
                } else {
                    this.ruW.bsq();
                }
            }
        });
        this.run = (WalletFormView) findViewById(R.h.brF);
        if (this.run != null) {
            com.tencent.mm.wallet_core.ui.formview.a.g(this.run);
            this.run.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceSaveUI ruW;

                {
                    this.ruW = r1;
                }

                public final void onClick(View view) {
                    Context context = this.ruW.uSU.uTo;
                    g.a(context, this.ruW.ruj, this.ruW.rul, context.getString(R.l.fdM), this.ruW.ruk, new com.tencent.mm.ui.base.g.a(this) {
                        final /* synthetic */ AnonymousClass2 ruX;

                        {
                            this.ruX = r1;
                        }

                        public final void rO(int i) {
                            if (this.ruX.ruW.ruj == null || i < 0 || i >= this.ruX.ruW.ruj.size()) {
                                this.ruX.ruW.ruk = null;
                            } else {
                                this.ruX.ruW.ruk = (Bankcard) this.ruX.ruW.ruj.get(i);
                            }
                            if (!(this.ruX.ruW.ruk == null || bg.mA(this.ruX.ruW.ruk.field_forbidWord))) {
                                com.tencent.mm.ui.base.g.a(this.ruX.ruW.uSU.uTo, "", this.ruX.ruW.getString(R.l.fdJ), this.ruX.ruW.getString(R.l.dHT), new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 ruY;

                                    {
                                        this.ruY = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                this.ruX.ruW.ruk = null;
                            }
                            this.ruX.ruW.ar();
                        }
                    });
                }
            });
        }
        this.npY = new com.tencent.mm.wallet_core.ui.a(this) {
            final /* synthetic */ WalletBalanceSaveUI ruW;

            {
                this.ruW = r1;
            }

            public final void gC(boolean z) {
                if (z) {
                    WalletBalanceSaveUI.d(this.ruW);
                } else {
                    this.ruW.khv.scrollTo(0, 0);
                }
            }
        };
    }

    private void ar() {
        if (this.run == null) {
            return;
        }
        if (this.ruk != null) {
            this.run.setText(getString(R.l.fdG, new Object[]{this.ruk.field_bankName, this.ruk.field_bankcardTail}));
            this.run.tC(this.ruk.field_bankcardTypeName);
            String str = this.ruk.field_avail_save_wording;
            if (this.run.oNu == null) {
                w.e("MicroMsg.WalletBalanceSaveUI", "why layout is null !!!???");
                return;
            } else if (bg.mA(str)) {
                w.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                this.run.oNu.setText("");
                return;
            } else {
                this.run.oNu.setText(this.ruk.field_avail_save_wording);
                return;
            }
        }
        this.run.setText(this.rul);
        if (this.run.oNu != null) {
            this.run.oNu.setText("");
        }
        this.run.tC(getString(R.l.fdF));
    }

    public void bsq() {
        if (this.ruk != null) {
            k(new c(this.oRf, "CNY", this.ruk.field_bindSerial, this.ruk.field_bankcardType));
        } else {
            k(new c(this.oRf, "CNY", "", ""));
        }
    }

    protected final int Ol() {
        return 1;
    }
}
