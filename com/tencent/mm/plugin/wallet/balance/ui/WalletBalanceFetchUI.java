package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.balance.a.b;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

@a(3)
public class WalletBalanceFetchUI extends WalletBaseUI implements WalletFormView.a {
    private String fJH = null;
    private final int ipO = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 270);
    private View khv;
    private Button liz;
    private double oRf;
    private DecimalFormat ruA = new DecimalFormat("0.00");
    private boolean ruB = false;
    private boolean ruC = false;
    private boolean ruD = false;
    private boolean ruE = false;
    private boolean ruF = false;
    private ArrayList<Bankcard> ruj;
    private Bankcard ruk;
    private String rul;
    private WalletFormView rum;
    private WalletFormView run;
    private View ruo;
    private TextView rup;
    private TextView ruq;
    private TextView rur;
    private TextView rus;
    private TextView rut;
    private int ruu = 0;
    private int ruv = 0;
    private int ruw = 0;
    private double rux = 0.0d;
    private int ruy = -1;
    private int ruz = 0;

    static /* synthetic */ void c(WalletBalanceFetchUI walletBalanceFetchUI) {
        walletBalanceFetchUI.oRf = bg.getDouble(walletBalanceFetchUI.rum.getText(), 0.0d);
        String str = "";
        if (walletBalanceFetchUI.ruk != null) {
            str = walletBalanceFetchUI.ruk.field_bankcardType;
        }
        if (walletBalanceFetchUI.ruk != null && !bg.mA(walletBalanceFetchUI.ruk.field_forbidWord)) {
            s.makeText(walletBalanceFetchUI.uSU.uTo, walletBalanceFetchUI.ruk.field_forbidWord, 0).show();
        } else if (walletBalanceFetchUI.oRf <= 0.0d || !walletBalanceFetchUI.rum.Pb()) {
            s.makeText(walletBalanceFetchUI.uSU.uTo, R.l.fdK, 0).show();
        } else {
            double d = walletBalanceFetchUI.oRf;
            o.bsC();
            if (d > o.bsD().ruN.rEh) {
                s.makeText(walletBalanceFetchUI.uSU.uTo, R.l.fdq, 0).show();
                return;
            }
            d = walletBalanceFetchUI.oRf;
            o.bsC();
            if (d > o.bsD().ruN.rEj) {
                s.makeText(walletBalanceFetchUI.uSU.uTo, R.l.fdr, 0).show();
            } else {
                walletBalanceFetchUI.k(new b(walletBalanceFetchUI.oRf, "CNY", str, walletBalanceFetchUI.ruz));
            }
        }
    }

    static /* synthetic */ void d(WalletBalanceFetchUI walletBalanceFetchUI) {
        double d;
        String str;
        if (!(walletBalanceFetchUI.ruk == null || walletBalanceFetchUI.ruu == 0 || ((walletBalanceFetchUI.ruu == 1 && walletBalanceFetchUI.ruk.field_fetch_charge_rate <= 0.0d) || (walletBalanceFetchUI.ruu == 1 && walletBalanceFetchUI.ruk.field_fetch_charge_rate > 0.0d && walletBalanceFetchUI.ruv == 0)))) {
            d = walletBalanceFetchUI.rux;
            o.bsC();
            if (d < o.bsD().ruN.rEj) {
                if (walletBalanceFetchUI.ruk != null) {
                    o.bsC();
                    d = o.bsD().ruN.rEj - walletBalanceFetchUI.ruk.field_full_fetch_charge_fee;
                } else {
                    o.bsC();
                    d = o.bsD().ruN.rEj;
                }
                if (walletBalanceFetchUI.ruw != 1) {
                    w.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
                    walletBalanceFetchUI.ruz = 1;
                    if (walletBalanceFetchUI.ruk != null || bg.mA(walletBalanceFetchUI.ruk.field_forbidWord)) {
                        str = "";
                        if (walletBalanceFetchUI.ruk != null) {
                            str = walletBalanceFetchUI.ruk.field_bankcardType;
                        }
                        walletBalanceFetchUI.k(new b(walletBalanceFetchUI.oRf, "CNY", str, walletBalanceFetchUI.ruz));
                    }
                    s.makeText(walletBalanceFetchUI.uSU.uTo, walletBalanceFetchUI.ruk.field_forbidWord, 0).show();
                    return;
                }
                walletBalanceFetchUI.rum.setText(walletBalanceFetchUI.ruA.format(d));
                walletBalanceFetchUI.bsi();
                walletBalanceFetchUI.ruz = 1;
                w.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
                return;
            }
        }
        o.bsC();
        d = o.bsD().ruN.rEj;
        if (walletBalanceFetchUI.ruw != 1) {
            walletBalanceFetchUI.rum.setText(walletBalanceFetchUI.ruA.format(d));
            walletBalanceFetchUI.bsi();
            walletBalanceFetchUI.ruz = 1;
            w.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
            return;
        }
        w.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
        walletBalanceFetchUI.ruz = 1;
        if (walletBalanceFetchUI.ruk != null) {
        }
        str = "";
        if (walletBalanceFetchUI.ruk != null) {
            str = walletBalanceFetchUI.ruk.field_bankcardType;
        }
        walletBalanceFetchUI.k(new b(walletBalanceFetchUI.oRf, "CNY", str, walletBalanceFetchUI.ruz));
    }

    static /* synthetic */ void f(WalletBalanceFetchUI walletBalanceFetchUI) {
        if (walletBalanceFetchUI.khv != null) {
            final int i;
            int[] iArr = new int[2];
            walletBalanceFetchUI.liz.getLocationInWindow(iArr);
            int dP = (com.tencent.mm.bg.a.dP(walletBalanceFetchUI) - i) - com.tencent.mm.bg.a.fromDPToPix(walletBalanceFetchUI, 30);
            w.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + walletBalanceFetchUI.liz.getHeight()), Integer.valueOf(com.tencent.mm.bg.a.dP(walletBalanceFetchUI)), Integer.valueOf(dP), Integer.valueOf(walletBalanceFetchUI.ipO)});
            if (dP > 0 && dP < walletBalanceFetchUI.ipO) {
                i = walletBalanceFetchUI.ipO - dP;
                w.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(i)});
                walletBalanceFetchUI.khv.post(new Runnable(walletBalanceFetchUI) {
                    final /* synthetic */ WalletBalanceFetchUI ruG;

                    public final void run() {
                        this.ruG.khv.scrollBy(0, i);
                    }
                });
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dpX;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T(getIntent());
        bsh();
        this.rul = getString(R.l.fdH);
        KC();
        ar();
        com.tencent.mm.wallet_core.c.o.ev(4, 0);
    }

    public void onDestroy() {
        this.run.wFZ = null;
        super.onDestroy();
    }

    private void bsh() {
        o.bsC();
        af bsD = o.bsD();
        if (this.ruB) {
            int i;
            Bankcard bankcard;
            Bankcard bankcard2;
            w.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.ruj != null && this.ruj.size() > 0) {
                arrayList.addAll(this.ruj);
            }
            this.ruj = bsD.buy();
            if (this.ruj != null && this.ruj.size() > 0) {
                arrayList2.addAll(this.ruj);
            }
            if (arrayList.size() > 0 && arrayList2.size() > 0) {
                Collection arrayList3 = new ArrayList();
                for (i = 0; i < arrayList.size(); i++) {
                    bankcard = (Bankcard) arrayList.get(i);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        bankcard2 = (Bankcard) arrayList2.get(i2);
                        if (!(bankcard == null || bankcard2 == null || !bankcard.field_bindSerial.equals(bankcard2.field_bindSerial))) {
                            arrayList3.add(bankcard2);
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    arrayList2.removeAll(arrayList3);
                }
                if (arrayList2.size() > 0) {
                    bankcard = (Bankcard) arrayList2.get(0);
                    if (bankcard != null) {
                        bankcard2 = bsD.a(this.ruj, null, false, true);
                    } else {
                        bankcard2 = bankcard;
                    }
                    i = 0;
                    while (this.ruj != null && i < this.ruj.size()) {
                        bankcard = (Bankcard) this.ruj.get(i);
                        if (bankcard2 == null && bankcard != null && bankcard2.field_bindSerial.equals(bankcard.field_bindSerial)) {
                            this.ruy = i;
                            break;
                        }
                        i++;
                    }
                    this.ruk = bankcard2;
                    this.ruB = false;
                }
            }
            bankcard = null;
            if (bankcard != null) {
                bankcard2 = bankcard;
            } else {
                bankcard2 = bsD.a(this.ruj, null, false, true);
            }
            i = 0;
            while (this.ruj != null) {
                bankcard = (Bankcard) this.ruj.get(i);
                if (bankcard2 == null) {
                }
                i++;
            }
            this.ruk = bankcard2;
            this.ruB = false;
        } else {
            this.ruj = bsD.buy();
            this.ruk = bsD.a(this.ruj, null, false, true);
        }
        if (bsD.rIo != null) {
            this.ruu = bsD.rIo.ruu;
            this.ruv = bsD.rIo.ruv;
            this.rux = bsD.rIo.rux;
            this.ruw = bsD.rIo.ruw;
        } else {
            w.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
        w.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.ruu + " is_cal_charge:" + this.ruv + " min_charge_fee:" + this.rux + " is_full_fetch_direct:" + this.ruw);
    }

    protected final void KC() {
        zi(R.l.fds);
        a(0, R.g.blV, new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e.m(this.ruG.uSU.uTo, "http://kf.qq.com/touch/product/wechatwallet_app.html?platform=15&scene_id=kf4", false);
                return true;
            }
        });
        this.khv = findViewById(R.h.bPw);
        this.run = (WalletFormView) findViewById(R.h.brF);
        this.run.wFZ = new com.tencent.mm.wallet_core.ui.formview.a.a(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final boolean a(WalletFormView walletFormView, MotionEvent motionEvent) {
                return false;
            }

            public final void bsk() {
                this.ruG.ar();
            }
        };
        com.tencent.mm.wallet_core.ui.formview.a.g(this.run);
        OnClickListener anonymousClass11 = new OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_scene_select_bankcard_mode_ui", 0);
                intent.putExtra("key_select_index", this.ruG.ruy);
                intent.setClass(this.ruG, WalletSelectBankcardModeUI.class);
                this.ruG.startActivityForResult(intent, 1);
            }
        };
        this.ruo = findViewById(R.h.brG);
        this.ruo.setOnClickListener(anonymousClass11);
        this.run.setOnClickListener(anonymousClass11);
        this.rum = (WalletFormView) findViewById(R.h.brI);
        d(this.rum, 2, false);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.rum);
        this.rum.wFY = this;
        this.liz = (Button) findViewById(R.h.cnY);
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final void onClick(View view) {
                WalletBalanceFetchUI.c(this.ruG);
            }
        });
        this.liz.setEnabled(false);
        this.rup = (TextView) findViewById(R.h.cPd);
        this.ruq = (TextView) findViewById(R.h.brK);
        this.rur = (TextView) findViewById(R.h.brJ);
        this.rus = (TextView) findViewById(R.h.bPv);
        this.rut = (TextView) findViewById(R.h.bPu);
        this.rut.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final void onClick(View view) {
                WalletBalanceFetchUI.d(this.ruG);
            }
        });
        this.rum.a(new TextWatcher(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                obj.length();
                int lastIndexOf = obj.lastIndexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (lastIndexOf != indexOf) {
                    editable.delete(lastIndexOf, length);
                }
                this.ruG.bsi();
            }
        });
        this.npY = new com.tencent.mm.wallet_core.ui.a(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final void gC(boolean z) {
                if (z) {
                    WalletBalanceFetchUI.f(this.ruG);
                } else {
                    this.ruG.khv.scrollTo(0, 0);
                }
            }
        };
        final com.tencent.mm.sdk.b.b ruVar = new ru();
        ruVar.fYM.fYO = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            public final void run() {
                if (bg.mA(ruVar.fYN.fYP)) {
                    w.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
                } else {
                    e.a(this.ruG.rup, ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
    }

    public void onResume() {
        bsj();
        super.onResume();
    }

    private void ar() {
        if (this.rum.jhl != null) {
            this.rum.jhl.setText(String.format(getString(R.l.eLh), new Object[]{com.tencent.mm.wallet_core.c.s.ccn()}));
        } else {
            w.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
        }
        if (this.ruk != null) {
            this.run.setText(this.ruk.field_desc);
            this.run.setVisibility(0);
            if (this.run.oNu == null) {
                w.i("MicroMsg.WalletBalanceFetchUI", "mBankcardEHV.getTipsTv() is null");
            } else if (this.ruu != 1 || this.ruk.field_fetch_charge_rate <= 0.0d) {
                this.run.oNu.setText("");
                this.run.oNu.setVisibility(8);
            } else {
                if (TextUtils.isEmpty(this.ruk.field_fetch_charge_info)) {
                    this.run.oNu.setText(getString(R.l.fdk) + (this.ruk.field_fetch_charge_rate * 100.0d) + "%");
                } else {
                    this.run.oNu.setText(this.ruk.field_fetch_charge_info);
                }
                this.run.oNu.setVisibility(0);
            }
            if (bg.mA(this.ruk.field_fetchArriveTimeWording)) {
                this.rur.setText("");
                this.rur.setVisibility(8);
            } else {
                this.rur.setText(this.ruk.field_fetchArriveTimeWording);
                this.rur.setVisibility(0);
            }
        } else {
            this.run.setText(this.rul);
            if (this.run.oNu != null) {
                this.run.oNu.setText("");
                this.run.oNu.setVisibility(8);
            }
            this.rur.setVisibility(8);
        }
        o.bsC();
        CharSequence charSequence = o.bsD().ruN.rEl;
        if (bg.mA(charSequence)) {
            this.ruq.setVisibility(8);
        } else {
            this.ruq.setVisibility(0);
            this.ruq.setText(charSequence);
        }
        bsi();
    }

    private void bsi() {
        this.oRf = bg.getDouble(this.rum.getText(), 0.0d);
        if (this.oRf > 0.0d) {
            this.liz.setEnabled(true);
        } else {
            this.liz.setEnabled(false);
        }
        double d = this.oRf;
        o.bsC();
        if (!(d == o.bsD().ruN.rEj || this.ruk == null)) {
            d = this.oRf;
            o.bsC();
            if (d != o.bsD().ruN.rEj - this.ruk.field_full_fetch_charge_fee) {
                this.ruz = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        double d2 = this.oRf;
        o.bsC();
        if (d2 > o.bsD().ruN.rEh) {
            this.rut.setVisibility(8);
            this.rus.setTextColor(getResources().getColor(R.e.aVD));
            stringBuilder.append(getString(R.l.fdt));
        } else {
            String str;
            if (!(this.ruk == null || this.ruu == 0 || ((this.ruu == 1 && this.ruk.field_fetch_charge_rate <= 0.0d) || (this.ruu == 1 && this.ruk.field_fetch_charge_rate > 0.0d && this.ruv == 0)))) {
                d2 = this.rux;
                o.bsC();
                if (d2 < o.bsD().ruN.rEj) {
                    if (this.ruu == 1 && this.ruk.field_fetch_charge_rate > 0.0d && this.ruv == 1 && (this.oRf <= 0.0d || !this.rum.Pb())) {
                        this.rut.setVisibility(0);
                        this.rus.setTextColor(getResources().getColor(R.e.aUo));
                        o.bsC();
                        str = o.bsD().ruN.rEm;
                        if (bg.mA(str)) {
                            w.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                            o.bsC();
                            d2 = o.bsD().ruN.rEj;
                            stringBuilder.append(getString(R.l.fdn, new Object[]{e.d(d2, "CNY")}));
                        } else {
                            stringBuilder.append(str);
                        }
                        stringBuilder.append("，");
                    } else if (this.ruu == 1 && this.ruk.field_fetch_charge_rate > 0.0d && this.ruv == 1) {
                        this.rut.setVisibility(8);
                        this.rus.setTextColor(getResources().getColor(R.e.aUo));
                        d2 = this.oRf;
                        o.bsC();
                        if (d2 != o.bsD().ruN.rEj - this.ruk.field_full_fetch_charge_fee || this.ruk.field_full_fetch_charge_fee <= 0.0d) {
                            int i = R.l.fdg;
                            Object[] objArr = new Object[1];
                            double d3 = this.oRf;
                            o.bsC();
                            af bsD = o.bsD();
                            objArr[0] = e.d(Math.max(((double) Math.round(((d3 - bsD.rIo.oQw) * this.ruk.field_fetch_charge_rate) * 100.0d)) / 100.0d, bsD.rIo.rux), "CNY");
                            stringBuilder.append(getString(i, objArr));
                        } else {
                            stringBuilder.append(getString(R.l.fdg, new Object[]{e.d(this.ruk.field_full_fetch_charge_fee, "CNY")}));
                        }
                    }
                }
            }
            this.rut.setVisibility(0);
            this.rus.setTextColor(getResources().getColor(R.e.aUo));
            o.bsC();
            str = o.bsD().ruN.rEm;
            if (bg.mA(str)) {
                w.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                o.bsC();
                d2 = o.bsD().ruN.rEj;
                stringBuilder.append(getString(R.l.fdn, new Object[]{e.d(d2, "CNY")}));
            } else {
                stringBuilder.append(str);
            }
            stringBuilder.append("，");
        }
        this.rus.setText(stringBuilder.toString());
    }

    private void a(b bVar) {
        if (bg.mA(this.fJH)) {
            w.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
            return;
        }
        Parcelable payInfo = new PayInfo();
        payInfo.fJH = this.fJH;
        payInfo.fRv = 21;
        this.uT.putParcelable("key_pay_info", payInfo);
        payInfo = new Orders();
        payInfo.rFM = bVar.oQE - bVar.oQs;
        payInfo.rFN = bVar.oQE - bVar.oQs;
        payInfo.rGe.add(new Commodity());
        payInfo.oQs = bVar.oQs;
        this.uT.putParcelable("key_orders", payInfo);
        this.uT.putParcelable("key_bankcard", this.ruk);
        if (ccE() == null) {
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.b.class, this.uT, null);
            return;
        }
        ccF().j(this.uT);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            boolean a;
            if (kVar instanceof b) {
                b bVar = (b) kVar;
                this.ruC = false;
                if (!this.ruF) {
                    this.ruD = false;
                }
                this.ruE = false;
                this.ruF = false;
                if ("1".equals(bVar.fZb)) {
                    w.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    String str2 = bVar.fZc;
                    str2 = bVar.fZd;
                    str2 = bVar.fZe;
                    aIY();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 0);
                } else if ("2".equals(bVar.fZb)) {
                    w.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, bVar.fZc, bVar.fZf, bVar.fZd, bVar.fZe, aIY(), null);
                } else {
                    w.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + bVar.fZb);
                    a = false;
                }
                if (!(a || b(bVar))) {
                    this.fJH = bVar.fLT;
                    a(bVar);
                }
            } else if (kVar instanceof m) {
                bsh();
                ar();
                if (this.ruu != 0) {
                    w.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.ruu);
                } else {
                    ap.yY();
                    a = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uDE, Boolean.valueOf(false))).booleanValue();
                    o.bsC();
                    com.tencent.mm.plugin.wallet_core.model.b bVar2 = o.bsD().rIo;
                    if (!(bVar2 == null || a)) {
                        double d = bVar2.oQw;
                        g.a(this, getString(R.l.fiB, new Object[]{e.o(d)}), getString(R.l.fiC), getString(R.l.dHw), getString(R.l.fiD), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ WalletBalanceFetchUI ruG;

                            {
                                this.ruG = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ WalletBalanceFetchUI ruG;

                            {
                                this.ruG = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.ruG.getString(R.l.ffI));
                                intent.putExtra("showShare", false);
                                d.b(this.ruG, "webview", ".ui.tools.WebViewUI", intent);
                                dialogInterface.dismiss();
                            }
                        }, R.e.aWu);
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uDE, Boolean.valueOf(true));
                    }
                }
            }
        } else if (kVar instanceof b) {
            bsj();
        }
        return false;
    }

    public final void gA(boolean z) {
        this.rum.dF(null);
    }

    protected final int Ol() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 != -1 || intent == null) {
            w.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
        } else {
            int intExtra = intent.getIntExtra("key_select_index", -1);
            int i3 = this.ruy;
            this.ruy = intExtra;
            w.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is " + intExtra);
            if (this.ruj == null || intExtra < 0 || intExtra >= this.ruj.size()) {
                if (this.ruj == null || intExtra < 0 || intExtra > this.ruj.size()) {
                    this.ruk = null;
                } else {
                    this.ruy = i3;
                }
                Bundle bundle = new Bundle();
                Parcelable parcelable = (PayInfo) this.uT.get("key_pay_info");
                if (parcelable == null) {
                    parcelable = new PayInfo();
                    parcelable.fJH = this.fJH;
                    parcelable.fRv = 21;
                }
                if (parcelable != null) {
                    bundle.putParcelable("key_pay_info", parcelable);
                }
                bundle.putInt("key_scene", 21);
                bundle.putInt("key_bind_scene", 0);
                bundle.putBoolean("key_need_bind_response", true);
                bundle.putInt("key_bind_scene", 0);
                bundle.putBoolean("key_is_bind_bankcard", true);
                bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.rtw);
                com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.a.class, bundle, null);
            } else {
                this.ruk = (Bankcard) this.ruj.get(intExtra);
            }
            ar();
        }
    }

    private boolean b(final b bVar) {
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.b bVar2;
        if (this.ruC) {
            z = false;
        } else if (bVar.rty) {
            this.ruC = true;
            g.a(this, false, bVar.rtz, "", getString(R.l.dHT), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletBalanceFetchUI ruG;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (!this.ruG.b(bVar)) {
                        this.ruG.fJH = bVar.fLT;
                        this.ruG.a(bVar);
                    }
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletBalanceFetchUI ruG;

                {
                    this.ruG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.ruG.bsj();
                }
            });
            z = true;
        } else {
            z = false;
        }
        if (!(z || this.ruD)) {
            bVar2 = bVar.rtA;
            if (bVar2 == null || (TextUtils.isEmpty(bVar2.rDT) && (bVar2.rDU == null || bVar2.rDU.size() <= 0))) {
                z = false;
            } else {
                this.ruD = true;
                com.tencent.mm.plugin.wallet_core.ui.g.a(this, bVar2, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletBalanceFetchUI ruG;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (!this.ruG.b(bVar)) {
                            this.ruG.fJH = bVar.fLT;
                            this.ruG.a(bVar);
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletBalanceFetchUI ruG;

                    {
                        this.ruG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.ruG.bsj();
                    }
                });
                z = true;
            }
        }
        if (z || this.ruE) {
            return z;
        }
        bVar2 = bVar.rtB;
        if (bVar2 == null || (TextUtils.isEmpty(bVar2.rDT) && (bVar2.rDU == null || bVar2.rDU.size() <= 0))) {
            return false;
        }
        this.ruE = true;
        com.tencent.mm.plugin.wallet_core.ui.g.a(this, bVar2, true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                String str = "";
                if (this.ruG.ruk != null) {
                    str = this.ruG.ruk.field_bankcardType;
                }
                this.ruG.ruz = 1;
                this.ruG.ruF = true;
                this.ruG.k(new b(this.ruG.oRf, "CNY", str, this.ruG.ruz));
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI ruG;

            {
                this.ruG = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.ruG.bsj();
            }
        });
        return true;
    }

    private void bsj() {
        this.ruC = false;
        this.ruD = false;
        this.ruE = false;
        this.ruF = false;
    }

    protected void onNewIntent(Intent intent) {
        bsj();
        T(intent);
    }

    private void T(Intent intent) {
        boolean z = false;
        if (intent != null && intent.getBooleanExtra("intent_bind_end", false)) {
            z = true;
        }
        this.ruB = z;
        if (this.ruB) {
            w.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
            PayInfo payInfo = (PayInfo) this.uT.get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.fJH = this.fJH;
                payInfo.fRv = 21;
            }
            q(new m(payInfo == null ? null : payInfo.fJH, 4));
            return;
        }
        q(new m(null, 4));
        w.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card fail or from create call");
    }
}
