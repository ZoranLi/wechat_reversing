package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.h;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.f.a.l;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private com.tencent.mm.plugin.ad.a iNH = null;
    private Orders oSJ;
    private boolean rOA = false;
    private g rOB = new g();
    private com.tencent.mm.wallet_core.c.f.a rOC = new com.tencent.mm.wallet_core.c.f.a(this) {
        final /* synthetic */ WalletVerifyCodeUI rOD;

        {
            this.rOD = r1;
        }

        public final void bvr() {
            this.rOD.bvq();
        }
    };
    public int rOs = 60000;
    public WalletFormView rOt = null;
    private Button rOu;
    private String rOv;
    private String rOw;
    private boolean rOx = false;
    private a rOy = null;
    private TextView rOz;
    private Button rxr;
    private Authen rxw;
    private PayInfo rze;

    class a extends CountDownTimer {
        final /* synthetic */ WalletVerifyCodeUI rOD;

        public a(WalletVerifyCodeUI walletVerifyCodeUI, long j) {
            this.rOD = walletVerifyCodeUI;
            super(j, 1000);
        }

        public final void onTick(long j) {
            this.rOD.rOu.setText(this.rOD.getString(R.l.fkO) + "(" + (j / 1000) + ")");
        }

        public final void onFinish() {
            this.rOD.rOu.setClickable(true);
            this.rOD.rOu.setEnabled(true);
            this.rOD.rOu.setText(this.rOD.getString(R.l.fkO));
        }
    }

    static /* synthetic */ boolean a(WalletVerifyCodeUI walletVerifyCodeUI, com.tencent.mm.wallet_core.c.f.a aVar) {
        if (walletVerifyCodeUI.rOA) {
            w.i("MicroMsg.WalletVertifyCodeUI", "isCertInstalled passed");
            return false;
        }
        g gVar = walletVerifyCodeUI.rOB;
        boolean z = gVar.btG() && gVar.rEH == 0;
        if (z) {
            w.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall %s", new Object[]{aVar});
            if (bg.mA(walletVerifyCodeUI.rOt.getText())) {
                w.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall sms error %s", new Object[]{aVar});
                return false;
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.k(new f(walletVerifyCodeUI.rOt.getText(), walletVerifyCodeUI.bsF(), aVar, true));
            return true;
        } else if (walletVerifyCodeUI.rOB.btG()) {
            w.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isNeedInstall %s", new Object[]{aVar});
            com.tencent.mm.plugin.report.service.g.oUh.i(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.k(new f(walletVerifyCodeUI.rOt.getText(), walletVerifyCodeUI.bsF(), aVar, false));
            return true;
        } else {
            w.i("MicroMsg.WalletVertifyCodeUI", "no need installcert");
            return false;
        }
    }

    static /* synthetic */ void c(WalletVerifyCodeUI walletVerifyCodeUI) {
        if (walletVerifyCodeUI.rOw == null) {
            walletVerifyCodeUI.rOw = "";
        }
        CharSequence format = String.format(m.xY() ? walletVerifyCodeUI.getString(R.l.fkH) : walletVerifyCodeUI.getString(R.l.fkG), new Object[]{walletVerifyCodeUI.rOw});
        LayoutInflater layoutInflater = (LayoutInflater) walletVerifyCodeUI.uSU.uTo.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(R.i.dfE, null);
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(R.f.aXt);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setText(format);
        com.tencent.mm.ui.base.g.a(walletVerifyCodeUI.uSU.uTo, walletVerifyCodeUI.getString(R.l.fkI), walletVerifyCodeUI.getString(R.l.eOW), textView, new OnClickListener(walletVerifyCodeUI) {
            final /* synthetic */ WalletVerifyCodeUI rOD;

            {
                this.rOD = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public void onCreate(Bundle bundle) {
        int i = 2;
        super.onCreate(bundle);
        zi(R.l.fkP);
        this.rze = (PayInfo) this.uT.getParcelable("key_pay_info");
        this.oSJ = (Orders) this.uT.getParcelable("key_orders");
        this.rOw = this.uT.getString("key_bank_phone");
        this.iNH = new com.tencent.mm.plugin.ad.a(this);
        this.iNH.pyE = getResources().getStringArray(R.c.aSu);
        this.iNH.pyC = new com.tencent.mm.plugin.ad.a.a(this) {
            final /* synthetic */ WalletVerifyCodeUI rOD;

            {
                this.rOD = r1;
            }

            public final void pl(String str) {
                this.rOD.rOt.setText(str);
            }
        };
        this.iNH.start();
        this.rOB = new g(this.uT);
        this.rOx = false;
        bvo();
        KC();
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
        Object[] objArr = new Object[2];
        int i2 = (this.rze == null || this.rze.fRv == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.rOx) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.i(10706, objArr);
        c.bvt();
        c.b(this, this.uT, 4);
        if (this.rOB.btF()) {
            com.tencent.mm.plugin.report.service.g.oUh.i(13731, new Object[]{Integer.valueOf(5)});
            this.uT.putBoolean("key_block_bind_new_card", true);
            if (!bg.mA(this.rOB.rEI.title)) {
                qP(this.rOB.rEI.title);
            }
            findViewById(R.h.byT).setVisibility(8);
            ((TextView) findViewById(R.h.byU)).setText(this.rOB.rEI.wDR);
            if (this.rOz != null) {
                String bvn = bvn();
                this.rOz.setText(bg.i(this.rOB.rEI.wDS, new Object[]{bvn}));
                this.rOz.setGravity(1);
            }
            if (!(this.rxr == null || bg.mA(this.rOB.rEI.wDT))) {
                this.rxr.setText(this.rOB.rEI.wDT);
            }
        } else {
            findViewById(R.h.byT).setVisibility(8);
        }
        this.wFr.hn(1580);
    }

    private String bvn() {
        String ap = bg.ap(this.uT.getString("key_mobile"), "");
        if (bg.mA(ap)) {
            Bankcard bankcard = (Bankcard) this.uT.getParcelable("key_bankcard");
            if (bankcard != null) {
                return bankcard.field_mobile;
            }
        }
        return ap;
    }

    public void bvo() {
    }

    public void bvp() {
        int i = 2;
        w.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
        Object[] objArr = new Object[2];
        int i2 = (this.rze == null || this.rze.fRv == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.rOx) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.i(10706, objArr);
        this.rOx = true;
        this.rOu.setClickable(false);
        this.rOu.setEnabled(false);
        if (this.rOy != null) {
            this.rOy.cancel();
            this.rOy = null;
        }
        a aVar = new a(this, (long) this.rOs);
        this.rOy = aVar;
        aVar.start();
        if (this.iNH != null) {
            this.iNH.start();
        }
        if (!ccF().p(this.rOv) && !lX(false)) {
            this.rxw = (Authen) this.uT.getParcelable("key_authen");
            if (this.rxw == null) {
                w.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
            } else {
                c.bvt();
            }
        }
    }

    protected final void KC() {
        String str;
        CharSequence qK;
        a aVar;
        TextView textView;
        final Bankcard bankcard;
        boolean z;
        boolean z2;
        PayInfo payInfo;
        int i;
        b ai = com.tencent.mm.wallet_core.a.ai(this);
        this.rOz = (TextView) findViewById(R.h.btB);
        String bvn = bvn();
        if (bg.mA(bvn)) {
            Bankcard bankcard2 = (Bankcard) this.uT.getParcelable("key_bankcard");
            if (bankcard2 != null) {
                str = bankcard2.field_mobile;
                this.uT.putString("key_mobile", str);
                qK = qK(0);
                if (bg.J(qK)) {
                    this.rOz.setText(qK);
                    this.rOz.setGravity(3);
                } else {
                    TextView textView2 = this.rOz;
                    if (m.xY()) {
                        bvn = getString(R.l.fkC);
                    } else {
                        bvn = getString(R.l.fkD);
                    }
                    textView2.setText(String.format(bvn, new Object[]{str}));
                    this.rOz.setGravity(3);
                }
                this.rOt = (WalletFormView) findViewById(R.h.btq);
                this.rOt.wFY = this;
                this.rOu = (Button) findViewById(R.h.bVm);
                this.rOu.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI rOD;

                    {
                        this.rOD = r1;
                    }

                    public final void onClick(View view) {
                        this.rOD.bvp();
                    }
                });
                this.rOu.setClickable(false);
                this.rOu.setEnabled(false);
                if (this.rOy != null) {
                    this.rOy.cancel();
                    this.rOy = null;
                }
                aVar = new a(this, (long) this.rOs);
                this.rOy = aVar;
                aVar.start();
                this.rxr = (Button) findViewById(R.h.btn);
                this.rxr.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI rOD;

                    {
                        this.rOD = r1;
                    }

                    public final void onClick(View view) {
                        if (!WalletVerifyCodeUI.a(this.rOD, this.rOD.rOC)) {
                            this.rOD.bvq();
                        }
                    }
                });
                textView = (TextView) findViewById(R.h.btA);
                bankcard = (Bankcard) this.uT.getParcelable("key_bankcard");
                z = this.uT.getBoolean("key_is_changing_balance_phone_num");
                z2 = this.uT.getBoolean("key_need_show_switch_phone", false);
                if (z || z2) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
                if (payInfo == null) {
                    i = payInfo.fRv;
                } else {
                    i = 0;
                }
                if (z2) {
                    textView.setText(R.l.fkK);
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI rOD;

                        public final void onClick(View view) {
                            boolean z = true;
                            w.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                            w.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
                            Bundle bundle = this.rOD.uT;
                            bundle.putInt("key_err_code", 417);
                            bundle.putBoolean("key_need_show_switch_phone", true);
                            String str = "key_isbalance";
                            if (!(bankcard == null || bankcard.btA())) {
                                z = false;
                            }
                            bundle.putBoolean(str, z);
                            com.tencent.mm.wallet_core.a.k(this.rOD, bundle);
                            this.rOD.finish();
                        }
                    });
                } else if (ai != null || !ai.cbT() || r2 == 11 || r2 == 21) {
                    textView.setText(m.xY() ? getString(R.l.fkF) : getString(R.l.fkE));
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI rOD;

                        {
                            this.rOD = r1;
                        }

                        public final void onClick(View view) {
                            WalletVerifyCodeUI.c(this.rOD);
                        }
                    });
                } else if (bankcard.btA() || bankcard.btB()) {
                    textView.setText(R.l.fkK);
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI rOD;

                        public final void onClick(View view) {
                            boolean z = false;
                            w.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                            w.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
                            if (this.rOD.rOB != null && this.rOD.rOB.btF()) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(13731, new Object[]{Integer.valueOf(9)});
                            }
                            Bundle bundle = this.rOD.uT;
                            bundle.putInt("key_err_code", 417);
                            bundle.putBoolean("key_need_show_switch_phone", true);
                            String str = "key_isbalance";
                            if (bankcard == null || bankcard.btA()) {
                                z = true;
                            }
                            bundle.putBoolean(str, z);
                            com.tencent.mm.wallet_core.a.k(this.rOD, bundle);
                            this.rOD.finish();
                        }
                    });
                } else {
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI rOD;

                        public final void onClick(View view) {
                            com.tencent.mm.ui.base.g.a(this.rOD, this.rOD.getString(R.l.fiM, new Object[]{bankcard.field_desc, bankcard.field_mobile}), "", this.rOD.getString(R.l.fiL), this.rOD.getString(R.l.dGs), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass8 rOE;

                                {
                                    this.rOE = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
                                    Bundle bundle = this.rOE.rOD.uT;
                                    bundle.putInt("key_err_code", 408);
                                    com.tencent.mm.wallet_core.a.k(this.rOE.rOD, bundle);
                                    this.rOE.rOD.finish();
                                }
                            }, null);
                        }
                    });
                }
                this.rOt.requestFocus();
                a(0, R.g.blV, new OnMenuItemClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI rOD;

                    {
                        this.rOD = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        String string = this.rOD.uT.getString("key_QADNA_URL");
                        if (bg.mA(string)) {
                            e.m(this.rOD.uSU.uTo, "https://kf.qq.com/touch/sappfaq/160830qY7NJJ1608307ZJzqy.html", false);
                        } else {
                            e.m(this.rOD.uSU.uTo, string, false);
                        }
                        return true;
                    }
                });
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI rOD;

                    {
                        this.rOD = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.rOD.aHf();
                        if (this.rOD.bsP()) {
                            this.rOD.showDialog(1000);
                        } else {
                            this.rOD.finish();
                        }
                        return false;
                    }
                });
            }
        }
        str = bvn;
        qK = qK(0);
        if (bg.J(qK)) {
            TextView textView22 = this.rOz;
            if (m.xY()) {
                bvn = getString(R.l.fkC);
            } else {
                bvn = getString(R.l.fkD);
            }
            textView22.setText(String.format(bvn, new Object[]{str}));
            this.rOz.setGravity(3);
        } else {
            this.rOz.setText(qK);
            this.rOz.setGravity(3);
        }
        this.rOt = (WalletFormView) findViewById(R.h.btq);
        this.rOt.wFY = this;
        this.rOu = (Button) findViewById(R.h.bVm);
        this.rOu.setOnClickListener(/* anonymous class already generated */);
        this.rOu.setClickable(false);
        this.rOu.setEnabled(false);
        if (this.rOy != null) {
            this.rOy.cancel();
            this.rOy = null;
        }
        aVar = new a(this, (long) this.rOs);
        this.rOy = aVar;
        aVar.start();
        this.rxr = (Button) findViewById(R.h.btn);
        this.rxr.setOnClickListener(/* anonymous class already generated */);
        textView = (TextView) findViewById(R.h.btA);
        bankcard = (Bankcard) this.uT.getParcelable("key_bankcard");
        z = this.uT.getBoolean("key_is_changing_balance_phone_num");
        z2 = this.uT.getBoolean("key_need_show_switch_phone", false);
        if (z) {
        }
        textView.setVisibility(0);
        payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
        if (payInfo == null) {
            i = 0;
        } else {
            i = payInfo.fRv;
        }
        if (z2) {
            textView.setText(R.l.fkK);
            textView.setOnClickListener(/* anonymous class already generated */);
        } else {
            if (ai != null) {
            }
            if (m.xY()) {
            }
            textView.setText(m.xY() ? getString(R.l.fkF) : getString(R.l.fkE));
            textView.setOnClickListener(/* anonymous class already generated */);
        }
        this.rOt.requestFocus();
        a(0, R.g.blV, /* anonymous class already generated */);
        b(/* anonymous class already generated */);
    }

    public void bvq() {
        Bundle bundle = this.uT;
        String string = this.uT.getString("key_pwd1");
        this.rOv = this.rOt.getText();
        n nVar = new n();
        nVar.rHx = string;
        nVar.oLz = this.rze;
        nVar.rHy = this.rOv;
        nVar.token = bg.ap(this.uT.getString("kreq_token"), "");
        Bankcard bankcard = (Bankcard) bundle.getParcelable("key_bankcard");
        if (bankcard != null) {
            nVar.ofd = bankcard.field_bankcardType;
            nVar.ofe = bankcard.field_bindSerial;
            nVar.rDK = bg.ap(bankcard.field_arrive_type, "");
        } else {
            nVar.ofd = this.uT.getString("key_bank_type");
        }
        w.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + nVar.oLz + " mVerifyCode: " + this.rOv);
        bundle.putString("key_verify_code", this.rOv);
        com.tencent.mm.wallet_core.a.ai(this);
        w.i("MicroMsg.WalletVertifyCodeUI", "do verify result : " + ccF().j(this.rOv, nVar));
    }

    public boolean d(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + i2 + " errMsg :" + str);
        if (!(kVar instanceof f)) {
            if (i == 0 && i2 == 0) {
                boolean z;
                b ai = com.tencent.mm.wallet_core.a.ai(this);
                if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) {
                    this.uT.putBoolean("intent_bind_end", true);
                    com.tencent.mm.ui.base.g.bl(this, getString(R.l.fdO));
                    w.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
                    z = true;
                } else {
                    if (!(kVar instanceof l)) {
                        if (ai.e(this, null)) {
                            q(new com.tencent.mm.plugin.wallet_core.b.m(bsF()));
                            w.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
                        } else {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (kVar instanceof h) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10707, new Object[]{Integer.valueOf(2), Integer.valueOf(c.bvu())});
                }
                if (this.rxw != null && (kVar instanceof com.tencent.mm.wallet_core.f.a.h)) {
                    String aQZ = ((com.tencent.mm.wallet_core.f.a.h) kVar).aQZ();
                    if (!bg.mA(aQZ)) {
                        this.uT.putString("kreq_token", aQZ);
                    }
                }
                if (z) {
                    w.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
                    com.tencent.mm.wallet_core.a.k(this, this.uT);
                    finish();
                    return true;
                }
            }
            return false;
        } else if (i2 == 0 || !((f) kVar).fVM) {
            return true;
        } else {
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, str, null, false, new OnClickListener(this) {
                final /* synthetic */ WalletVerifyCodeUI rOD;

                {
                    this.rOD = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
    }

    protected final int getLayoutId() {
        return R.i.drz;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.iNH != null) {
            this.iNH.stop();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void gA(boolean z) {
        if (this.rOt.dF(null)) {
            this.rxr.setEnabled(true);
            this.rxr.setClickable(true);
            return;
        }
        this.rxr.setEnabled(false);
        this.rxr.setClickable(false);
    }

    public void onDestroy() {
        if (this.iNH != null) {
            this.iNH.stop();
        }
        this.wFr.ho(1580);
        super.onDestroy();
    }

    public boolean bsP() {
        if (this.rze == null || !this.rze.mqD) {
            return super.bsP();
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.WalletVertifyCodeUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.WalletVertifyCodeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.iNH != null) {
                    this.iNH.start();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean i(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[]{Integer.valueOf(i2), kVar});
        if ((kVar instanceof f) && i2 == 0) {
            this.rOA = true;
            s.makeText(this, R.l.fhN, 0).show();
            w.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
        }
        return true;
    }
}
