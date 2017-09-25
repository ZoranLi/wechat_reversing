package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rs;
import com.tencent.mm.e.a.ry;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.e.a.sg;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.a.b.d;
import com.tencent.mm.plugin.wallet.pay.a.b.e;
import com.tencent.mm.plugin.wallet.pay.a.b.f;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.n;
import com.tencent.mm.wallet_core.f.a.i;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUI extends WalletBaseUI implements com.tencent.mm.plugin.wallet.pay.ui.a.a {
    private static boolean rzI = false;
    public String lOK = null;
    public int mCount = 0;
    protected com.tencent.mm.plugin.wallet.a oRe = null;
    private String oRy;
    public Orders oSJ = null;
    private TextView rAa;
    protected LinearLayout rAb;
    protected a rAc;
    private long rAd = 0;
    private TextView rAe;
    private LinearLayout rAf;
    private boolean rAg = true;
    private boolean rAh = false;
    private boolean rAi = false;
    private boolean rAj = false;
    private boolean rAk = false;
    private int rAl = -1;
    private boolean rAm = false;
    private boolean rAn = false;
    private e rAo;
    private boolean rAp = false;
    private boolean rAq = false;
    private long rAr = 0;
    public l ruh;
    public ArrayList<Bankcard> ruj = null;
    public Bankcard ruk = null;
    private c ryU = null;
    protected com.tencent.mm.plugin.wallet_core.ui.a rzJ = null;
    private boolean rzK = false;
    private boolean rzL = false;
    public boolean rzM = false;
    protected boolean rzN = false;
    protected String rzO = "";
    protected boolean rzP = false;
    public Bundle rzQ = null;
    protected boolean rzR = false;
    protected TextView rzS;
    protected TextView rzT;
    private TextView rzU;
    protected TextView rzV;
    protected TextView rzW;
    protected TextView rzX;
    protected ImageView rzY;
    private TextView rzZ;
    public Button rzb;
    public PayInfo rze = null;
    public FavorPayInfo rzg = null;
    private a rzh;
    com.tencent.mm.plugin.wallet_core.ui.c rzi;
    private com.tencent.mm.sdk.b.c rzj = new com.tencent.mm.sdk.b.c<sg>(this) {
        final /* synthetic */ WalletPayUI rAs;

        {
            this.rAs = r2;
            this.usg = sg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w.i("MicroMsg.WalletPayUI", "WalletRealNameResultNotifyMoreEvent %s", new Object[]{Integer.valueOf(((sg) bVar).fZM.result)});
            if (((sg) bVar).fZM.result == -1) {
                this.rAs.rAp = true;
                this.rAs.rAq = true;
                this.rAs.bsW();
            }
            return false;
        }
    };

    protected class a {
        final /* synthetic */ WalletPayUI rAs;

        protected a(WalletPayUI walletPayUI) {
            this.rAs = walletPayUI;
        }

        public final void notifyDataSetChanged() {
            this.rAs.rAb.removeAllViews();
            int i = this.rAs.mCount == 0 ? 0 : this.rAs.rzP ? this.rAs.mCount : 1;
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            for (int i2 = 0; i2 < i; i2++) {
                String string;
                Object tL;
                View inflate = ((LayoutInflater) this.rAs.getSystemService("layout_inflater")).inflate(R.i.dre, null);
                TextView textView = (TextView) inflate.findViewById(R.h.cQP);
                TextView textView2 = (TextView) inflate.findViewById(R.h.cRh);
                Commodity commodity = (Commodity) this.rAs.oSJ.rGe.get(i2);
                String str = "";
                if (this.rAs.rze != null && (this.rAs.rze.fRv == 32 || this.rAs.rze.fRv == 33 || this.rAs.rze.fRv == 31)) {
                    string = this.rAs.rze.sYe.getString("extinfo_key_1", "");
                    if (bg.mA(string)) {
                        w.e("MicroMsg.WalletPayUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    } else {
                        ap.yY();
                        x Ra = com.tencent.mm.u.c.wR().Ra(string);
                        if (Ra != null) {
                            tL = Ra.tL();
                        } else {
                            w.e("MicroMsg.WalletPayUI", "can not found contact for user::" + string);
                            string = str;
                        }
                        if (commodity == null) {
                            if (!bg.mA(tL)) {
                                textView2.setText(tL);
                                textView2.setVisibility(0);
                                ((TextView) inflate.findViewById(R.h.cRi)).setVisibility(0);
                            } else if (bg.mA(commodity.ofP)) {
                                textView2.setText(commodity.ofP);
                                textView2.setVisibility(0);
                                ((TextView) inflate.findViewById(R.h.cRi)).setVisibility(0);
                            } else {
                                ((TextView) inflate.findViewById(R.h.cRi)).setVisibility(8);
                                textView2.setVisibility(8);
                            }
                            if (bg.mA(commodity.desc)) {
                                textView.setText(commodity.desc);
                                textView.setVisibility(8);
                                ((TextView) inflate.findViewById(R.h.cQR)).setVisibility(8);
                            } else {
                                ((TextView) inflate.findViewById(R.h.cQR)).setVisibility(8);
                                textView.setVisibility(8);
                            }
                            if (bg.mA(tL) || !bg.mA(commodity.ofP)) {
                                inflate.setVisibility(0);
                            } else {
                                inflate.setVisibility(8);
                            }
                        }
                        inflate.setLayoutParams(layoutParams);
                        inflate.measure(-2, -2);
                        this.rAs.rAb.addView(inflate);
                    }
                }
                string = str;
                if (commodity == null) {
                    if (!bg.mA(tL)) {
                        textView2.setText(tL);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(R.h.cRi)).setVisibility(0);
                    } else if (bg.mA(commodity.ofP)) {
                        ((TextView) inflate.findViewById(R.h.cRi)).setVisibility(8);
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(commodity.ofP);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(R.h.cRi)).setVisibility(0);
                    }
                    if (bg.mA(commodity.desc)) {
                        ((TextView) inflate.findViewById(R.h.cQR)).setVisibility(8);
                        textView.setVisibility(8);
                    } else {
                        textView.setText(commodity.desc);
                        textView.setVisibility(8);
                        ((TextView) inflate.findViewById(R.h.cQR)).setVisibility(8);
                    }
                    if (bg.mA(tL)) {
                    }
                    inflate.setVisibility(0);
                }
                inflate.setLayoutParams(layoutParams);
                inflate.measure(-2, -2);
                this.rAs.rAb.addView(inflate);
            }
        }
    }

    static /* synthetic */ void d(WalletPayUI walletPayUI) {
        Bundle bundle = new Bundle();
        if (walletPayUI.oSJ != null) {
            bundle.putString("key_reqKey", walletPayUI.oSJ.fJH);
            if (walletPayUI.oSJ.rGe != null && walletPayUI.oSJ.rGe.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) walletPayUI.oSJ.rGe.get(0)).fTA);
            }
            bundle.putLong("key_SessionId", walletPayUI.rAd);
        }
        if (walletPayUI.rze != null) {
            bundle.putInt("key_scene", walletPayUI.rze.fRv);
        }
        if (walletPayUI.rze == null || walletPayUI.rze.fRv != 11) {
            bundle.putInt("key_bind_scene", 0);
        } else {
            bundle.putInt("key_bind_scene", 13);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putBoolean("key_is_oversea", !walletPayUI.btb());
        com.tencent.mm.wallet_core.a.a(walletPayUI, com.tencent.mm.plugin.wallet.pay.a.class, bundle, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (rzI) {
            w.w("MicroMsg.WalletPayUI", "has Undestory WalletPayUI!");
            finish();
        }
        rzI = true;
        if (ap.zb()) {
            getWindow().getDecorView().postDelayed(new Runnable(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void run() {
                    w.i("MicroMsg.WalletPayUI", "auto reset create flag");
                    WalletPayUI.rzI = false;
                }
            }, 600);
            this.rAr = bg.Nz();
            com.tencent.mm.sdk.b.a.urY.b(this.rzj);
            h.h(this, 5);
            this.oRe = com.tencent.mm.plugin.wallet.a.S(getIntent());
            zi(R.l.fiN);
            this.rze = bth();
            this.rzN = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
            this.rzO = bg.ap(getIntent().getStringExtra("key_force_use_bind_serail"), "");
            this.oRy = getIntent().getStringExtra("key_receiver_true_name");
            if (this.rze == null || this.rze.sYi == 0) {
                this.rAd = System.currentTimeMillis();
            } else {
                this.rAd = this.rze.sYi;
            }
            if (bsV()) {
                w.i("MicroMsg.WalletPayUI", "hy: pay end on create. finish");
                finish();
                return;
            }
            w.d("MicroMsg.WalletPayUI", "PayInfo = " + this.rze);
            if (this.rze == null || bg.mA(this.rze.fJH)) {
                String string;
                if (this.rze == null || bg.mA(this.rze.fPf)) {
                    string = getString(R.l.fiI);
                } else {
                    string = this.rze.fPf;
                }
                g.a(this, string, null, false, new OnClickListener(this) {
                    final /* synthetic */ WalletPayUI rAs;

                    {
                        this.rAs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rAs.finish();
                    }
                });
            } else {
                bsW();
            }
            KC();
            return;
        }
        w.e("MicroMsg.WalletPayUI", "hy: account not ready. finish now");
        finish();
    }

    private boolean bsV() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            w.i("MicroMsg.WalletPayUI", "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                w.d("MicroMsg.WalletPayUI", "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                w.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                w.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                c(-1, getIntent());
                this.rzL = true;
                return true;
            }
            w.d("MicroMsg.WalletPayUI", "pay cancel");
            c(0, getIntent());
            this.rzL = false;
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            w.i("MicroMsg.WalletPayUI", "hy: pay not end");
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    return true;
                default:
                    return false;
            }
        }
    }

    public void onDestroy() {
        if (this.rzh != null) {
            this.rzh.bsK();
            this.rzh.release();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.rzj);
        this.rzi = null;
        rzI = false;
        super.onDestroy();
    }

    public void bsW() {
        k kVar;
        int i = 2;
        com.tencent.mm.plugin.report.service.g.oUh.i(11850, new Object[]{Integer.valueOf(2), Integer.valueOf(this.rze.fRv)});
        if (this.rze.fRv == 11) {
            i = 3;
        }
        PayInfo payInfo = this.rze;
        if (payInfo == null || bg.mA(payInfo.fJH)) {
            w.i("MicroMsg.CgiManager", "no payInfo or reqKey");
            kVar = null;
        } else {
            String str = payInfo.fJH;
            w.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[]{str});
            w.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
            kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.b.a(payInfo, i) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.b.g(payInfo, i) : str.startsWith("sns_ff_") ? new com.tencent.mm.plugin.wallet.pay.a.b.b(payInfo, i) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.b.c(payInfo, i) : str.startsWith("sns_") ? new f(payInfo, i) : str.startsWith("offline_") ? new d(payInfo, i) : new e(payInfo, i);
        }
        if (kVar != null) {
            boolean z;
            kVar.gWO = "PayProcess";
            kVar.lwh = this.rAd;
            if (this.rze.fRv == 6 && this.rze.sYa == 100) {
                kVar.hPi = 100;
            } else {
                kVar.hPi = this.rze.fRv;
            }
            if (this.rze.sYb) {
                z = true;
            } else {
                z = false;
            }
            super.ccG();
            this.wFr.a(kVar, true, z);
        }
    }

    public void onResume() {
        w.i("MicroMsg.WalletPayUI", "hy: onResume isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.rAp)});
        if (!this.wFr.aHU()) {
            if (this.ruk == null) {
                o.bsC();
                this.ruk = o.bsD().a(null, null, bsL(), false);
            } else {
                o.bsC();
                this.ruk = o.bsD().a(null, this.ruk.field_bindSerial, bsL(), false);
            }
        }
        if (this.rAq) {
            w.i("MicroMsg.WalletPayUI", "onResume isResumePassFinish");
            this.rAq = false;
        } else if (this.rzM && this.uSU.ipu.getVisibility() != 0 && (this.ruh == null || !this.ruh.isShowing())) {
            w.i("MicroMsg.WalletPayUI", "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.rzi != null) {
            this.rzi.buN();
        }
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.drg;
    }

    public void finish() {
        ccB();
        if (this.rzL) {
            if (!(this.rze == null || this.rze.fRv != 42 || this.oSJ == null || this.oSJ.rGe.isEmpty())) {
                getIntent().putExtra("key_trans_id", ((Commodity) this.oSJ.rGe.get(0)).fTA);
            }
            c(-1, getIntent());
            setResult(-1, getIntent());
        } else {
            if (!(this.rze == null || this.rze.fRv != 8 || this.oSJ == null)) {
                this.rze.sYm = 0;
                b(com.tencent.mm.plugin.wallet.pay.a.a.a(bta(), this.oSJ, true), false);
                if (this.rze.sYe != null) {
                    long j = this.rze.sYe.getLong("extinfo_key_9");
                    com.tencent.mm.plugin.report.service.g.oUh.i(13956, new Object[]{Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - j)});
                }
            }
            c(0, getIntent());
            setResult(0);
        }
        super.finish();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.ruh == null || this.rze == null || !this.rze.mqD) {
            aHf();
            showDialog(1000);
        } else {
            finish();
        }
        return true;
    }

    public void onNewIntent(Intent intent) {
        boolean z;
        boolean z2 = true;
        w.v("MicroMsg.WalletPayUI", "onNewIntent");
        setIntent(intent);
        if (!bsV()) {
            w.w("MicroMsg.WalletPayUI", "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            c(0, getIntent());
            this.rzL = false;
        }
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z = false;
        } else {
            this.rAh = true;
            z = true;
        }
        if (z) {
            w.i("MicroMsg.WalletPayUI", "isFromBindCard is true");
            bsW();
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z2 = false;
        } else {
            this.rAi = true;
        }
        if (z2) {
            w.i("MicroMsg.WalletPayUI", "isFromRealNameVerify is true");
            finish();
        } else {
            w.e("MicroMsg.WalletPayUI", "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
    }

    private void c(int i, Intent intent) {
        b rzVar = new rz();
        rzVar.fZv.context = this;
        rzVar.fZv.intent = intent;
        rzVar.fZv.result = i;
        rzVar.fZv.fJH = this.rze == null ? "" : this.rze.fJH;
        com.tencent.mm.sdk.b.a.urY.m(rzVar);
    }

    protected final void KC() {
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.cRI);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.rzb = (Button) findViewById(R.h.cRv);
        this.rzb.setClickable(false);
        this.rzb.setEnabled(false);
        this.rzS = (TextView) findViewById(R.h.cRm);
        this.rzT = (TextView) findViewById(R.h.cRl);
        this.rzV = (TextView) findViewById(R.h.cQV);
        this.rAa = (TextView) findViewById(R.h.cQT);
        this.rzU = (TextView) findViewById(R.h.cRb);
        this.rzZ = (TextView) findViewById(R.h.cRs);
        this.rzU.getPaint().setFlags(16);
        this.rzW = (TextView) findViewById(R.h.cRw);
        this.rzX = (TextView) findViewById(R.h.cRt);
        this.rzX.setOnClickListener(new n(this) {
            final /* synthetic */ WalletPayUI rAs;

            {
                this.rAs = r1;
            }

            public final void aII() {
                this.rAs.b(false, 0, "");
            }
        });
        this.rzY = (ImageView) findViewById(R.h.cQQ);
        this.rzY.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletPayUI rAs;

            {
                this.rAs = r1;
            }

            public final void onClick(View view) {
                if (this.rAs.rzP) {
                    this.rAs.rzY.setImageResource(R.g.bih);
                    this.rAs.rzP = false;
                } else {
                    this.rAs.rzY.setImageResource(R.g.bii);
                    this.rAs.rzP = true;
                }
                this.rAs.rAc.notifyDataSetChanged();
            }
        });
        this.rAb = (LinearLayout) findViewById(R.h.cQY);
        this.rAc = new a(this);
        this.rzb.setOnClickListener(new n(this) {
            final /* synthetic */ WalletPayUI rAs;

            {
                this.rAs = r1;
            }

            public final void aII() {
                this.rAs.btc();
            }
        });
        this.rzb.setText(R.l.fic);
        this.rAe = (TextView) findViewById(R.h.cro);
        this.rAf = (LinearLayout) findViewById(R.h.crn);
        ar();
    }

    public final void ar() {
        boolean z;
        LinearLayout linearLayout;
        if (!(this.oSJ == null || this.oSJ.rGe == null || this.oSJ.rGe.size() <= 0)) {
            this.rzS.setText(com.tencent.mm.wallet_core.ui.e.n(this.oSJ.rFM));
            this.rzV.setText(com.tencent.mm.wallet_core.ui.e.UH(this.oSJ.oga));
            this.rAc.notifyDataSetChanged();
            if (this.oSJ.rGe.size() > 1) {
                this.rzY.setVisibility(0);
                this.rzT.setText(getString(R.l.fiO, new Object[]{((Commodity) this.oSJ.rGe.get(0)).desc, this.oSJ.rGe.size()}));
            } else {
                this.rzT.setText(((Commodity) this.oSJ.rGe.get(0)).desc);
                this.rzY.setVisibility(8);
            }
            this.rzP = false;
            int i = this.oSJ.rFO;
        }
        this.rzW.setVisibility(8);
        this.rzX.setVisibility(8);
        this.rAe.setVisibility(8);
        this.rAf.setVisibility(8);
        this.rzb.setText(R.l.fic);
        if (this.ruk == null || !this.ruk.btA()) {
            o.bsC();
            if (o.bsD().buj()) {
                bsX();
            }
        } else if (bg.mA(this.ruk.field_forbidWord)) {
            o.bsC();
            if (o.bsD().bun()) {
                bsX();
            }
        } else {
            this.rzW.setText(this.ruk.field_forbidWord);
            this.rzW.setVisibility(4);
            this.rzX.setVisibility(8);
            o.bsC();
            if (o.bsD().bun()) {
                bsX();
            }
        }
        o.bsC();
        if (!o.bsD().bun()) {
            o.bsC();
            if (!o.bsD().buj()) {
                z = false;
                linearLayout = (LinearLayout) findViewById(R.h.cQU);
                if (z || this.rzg == null || this.rzJ == null || !this.rzK || this.oSJ == null) {
                    linearLayout.setVisibility(8);
                } else {
                    bsZ();
                    this.rAa.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletPayUI rAs;

                        {
                            this.rAs = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.wallet_core.ui.h.a(this.rAs.uSU.uTo, this.rAs.oSJ, this.rAs.rzg.rFm, new com.tencent.mm.plugin.wallet_core.ui.h.b(this) {
                                final /* synthetic */ AnonymousClass27 rAw;

                                {
                                    this.rAw = r1;
                                }

                                public final void a(FavorPayInfo favorPayInfo) {
                                    int i = 1;
                                    this.rAw.rAs.rzg = favorPayInfo;
                                    if (this.rAw.rAs.rzg != null) {
                                        if (this.rAw.rAs.ruk == null || com.tencent.mm.plugin.wallet_core.ui.a.a(this.rAw.rAs.rzg, this.rAw.rAs.ruk)) {
                                            this.rAw.rAs.rzX.setVisibility(8);
                                            this.rAw.rAs.rzb.setOnClickListener(new View.OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass1 rAx;

                                                {
                                                    this.rAx = r1;
                                                }

                                                public final void onClick(View view) {
                                                    w.i("MicroMsg.WalletPayUI", "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                                                    this.rAx.rAw.rAs.b(false, 0, "");
                                                }
                                            });
                                        } else {
                                            com.tencent.mm.plugin.wallet.a.h Ii = this.rAw.rAs.rzJ.Ii(this.rAw.rAs.rzg.rFm);
                                            if (Ii != null && this.rAw.rAs.ruk.btA()) {
                                                o.bsC();
                                                Bankcard bankcard = o.bsD().ruN;
                                                double d = Ii.rxO;
                                                if (bankcard != null && bankcard.rEh < d) {
                                                    w.i("MicroMsg.WalletPayUI", "balance not meet");
                                                    this.rAw.rAs.rzX.setVisibility(8);
                                                    this.rAw.rAs.rzb.setOnClickListener(new View.OnClickListener(this) {
                                                        final /* synthetic */ AnonymousClass1 rAx;

                                                        {
                                                            this.rAx = r1;
                                                        }

                                                        public final void onClick(View view) {
                                                            w.i("MicroMsg.WalletPayUI", "Balance amount not meet, after favor selection! payWithNewBankcard");
                                                            this.rAx.rAw.rAs.b(false, 0, "");
                                                        }
                                                    });
                                                }
                                            }
                                            i = 0;
                                        }
                                        if (i == 0) {
                                            this.rAw.rAs.rzW.setVisibility(8);
                                            this.rAw.rAs.rzX.setVisibility(0);
                                            this.rAw.rAs.rzb.setOnClickListener(new View.OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass1 rAx;

                                                {
                                                    this.rAx = r1;
                                                }

                                                public final void onClick(View view) {
                                                    this.rAx.rAw.rAs.btc();
                                                }
                                            });
                                        }
                                        this.rAw.rAs.bsZ();
                                    }
                                }
                            });
                        }
                    });
                    linearLayout.setVisibility(0);
                }
                if (this.oSJ != null || this.ruj == null || this.rze == null) {
                    this.rzb.setClickable(false);
                    this.rzb.setEnabled(false);
                } else {
                    this.rzb.setClickable(true);
                    this.rzb.setEnabled(true);
                }
                if (this.oSJ == null) {
                    this.rzX.setVisibility(8);
                }
            }
        }
        z = true;
        linearLayout = (LinearLayout) findViewById(R.h.cQU);
        if (z) {
        }
        linearLayout.setVisibility(8);
        if (this.oSJ != null) {
        }
        this.rzb.setClickable(false);
        this.rzb.setEnabled(false);
        if (this.oSJ == null) {
            this.rzX.setVisibility(8);
        }
    }

    private void bsX() {
        if (this.oSJ == null) {
            w.e("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor mOrders is null");
            return;
        }
        this.rzX.setVisibility(8);
        this.rzW.setVisibility(8);
        this.rzb.setText(R.l.fic);
        this.rAe.setVisibility(0);
        this.rAf.setVisibility(0);
        View findViewById = this.rAf.findViewById(R.h.brL);
        View findViewById2 = this.rAf.findViewById(R.h.bnq);
        if ("CFT".equals(this.oSJ.rGa)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        final CheckedTextView checkedTextView = (CheckedTextView) this.rAf.findViewById(R.h.brH);
        final CheckedTextView checkedTextView2 = (CheckedTextView) this.rAf.findViewById(R.h.bnp);
        findViewById.setEnabled(true);
        boolean z;
        if (this.oSJ == null || this.oSJ.rGe == null || this.oSJ.rGe.size() <= 0) {
            z = false;
        } else if (this.oSJ.rFO == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.ruk == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                public final void onClick(View view) {
                    checkedTextView.setChecked(true);
                    checkedTextView2.setChecked(false);
                    this.rAs.rAg = false;
                    this.rAs.bsY();
                }
            });
        }
        findViewById2.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletPayUI rAs;

            public final void onClick(View view) {
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                this.rAs.rAg = true;
                this.rAs.bsY();
            }
        });
        this.rAg = true;
        checkedTextView.setChecked(false);
        checkedTextView2.setChecked(true);
        w.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.oSJ.rGg);
        if (this.oSJ.rGg == 1) {
            this.rAf.findViewById(R.h.bJB).setVisibility(0);
            ((TextView) this.rAf.findViewById(R.h.bJA)).setText(this.oSJ.rGh);
            if (TextUtils.isEmpty(this.oSJ.rGi)) {
                ((TextView) this.rAf.findViewById(R.h.bPh)).setText("");
            } else {
                ((TextView) this.rAf.findViewById(R.h.bPh)).setText(" (" + this.oSJ.rGi + ")");
            }
            if (!(this.ruk == null || !this.ruk.btA() || TextUtils.isEmpty(this.ruk.field_forbidWord))) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.rAf.findViewById(R.h.brP)).setText(this.ruk.field_forbidWord);
            }
        } else {
            this.rAf.findViewById(R.h.bJB).setVisibility(8);
            if (this.ruk != null && this.ruk.btA() && !TextUtils.isEmpty(this.ruk.field_forbidWord)) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.rAf.findViewById(R.h.brP)).setText(this.ruk.field_forbidWord);
            } else if (this.ruk != null && this.ruk.btA() && TextUtils.isEmpty(this.ruk.field_forbidWord) && !r2) {
                checkedTextView.setChecked(true);
                checkedTextView2.setChecked(false);
                this.rAg = false;
            }
        }
        bsY();
    }

    private void bsY() {
        if (this.rAg) {
            this.rzb.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(View view) {
                    if (this.rAs.oSJ.rGg == 1) {
                        WalletPayUI.d(this.rAs);
                        return;
                    }
                    w.i("MicroMsg.WalletPayUI", "SimpleReg , assigned userinfo pay! payWithNewBankcard");
                    this.rAs.b(false, 0, "");
                }
            });
        } else {
            this.rzb.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(View view) {
                    this.rAs.btc();
                }
            });
        }
    }

    public final void bsZ() {
        double d;
        int i;
        com.tencent.mm.plugin.wallet.a.h Ii = this.rzJ.Ii(this.rzg.rFm);
        List buM = this.rzJ.buM();
        com.tencent.mm.plugin.wallet.a.f fVar = this.rzJ.rJd;
        CharSequence charSequence = "";
        if (Ii != null) {
            d = Ii.rxW;
            if (d > 0.0d) {
                String str = Ii.rxY;
                if (bg.mA(Ii.rxZ)) {
                    Object obj = str;
                    i = 1;
                } else {
                    charSequence = str + "," + Ii.rxZ;
                    i = 1;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
            d = 0.0d;
        }
        if (i == 0 && buM.size() > 0) {
            charSequence = charSequence + this.uSU.uTo.getString(R.l.fjf);
        }
        if (d <= 0.0d || fVar == null || fVar.rxS != 0) {
            this.rzS.setText(com.tencent.mm.wallet_core.ui.e.n(this.oSJ.rFM));
            this.rzV.setText(com.tencent.mm.wallet_core.ui.e.UH(this.oSJ.oga));
            this.rzU.setVisibility(8);
        } else {
            if (Ii != null) {
                this.rzS.setText(com.tencent.mm.wallet_core.ui.e.n(Ii.rxV));
            }
            this.rzV.setText(com.tencent.mm.wallet_core.ui.e.UH(this.oSJ.oga));
            this.rzU.setText(com.tencent.mm.wallet_core.ui.e.d(this.oSJ.rFM, this.oSJ.oga));
            this.rzU.setVisibility(0);
        }
        if (!bg.mA(charSequence)) {
            this.rAa.setText(charSequence);
        }
    }

    public final Authen bta() {
        Authen authen = new Authen();
        if (btb()) {
            authen.fRW = 3;
        } else {
            authen.fRW = 6;
        }
        if (!bg.mA(this.lOK)) {
            authen.rDC = this.lOK;
        }
        if (this.ruk != null) {
            authen.ofe = this.ruk.field_bindSerial;
            authen.ofd = this.ruk.field_bankcardType;
        }
        if (this.rzg != null) {
            authen.rDO = this.rzg.rFm;
            authen.rDN = this.rzg.rFp;
        }
        authen.oLz = this.rze;
        return authen;
    }

    public final boolean btb() {
        if (this.ruk == null || this.oSJ == null || this.oSJ.rBY != 3) {
            if (this.oSJ == null || Bankcard.vw(this.oSJ.rBY)) {
                return false;
            }
            return true;
        } else if (this.ruk.btD()) {
            return true;
        } else {
            return false;
        }
    }

    protected final void btc() {
        iw(true);
    }

    protected final void iw(boolean z) {
        if (z) {
            boolean z2;
            if (this.oSJ != null && this.oSJ.rFW) {
                ap.yY();
                if (((Boolean) com.tencent.mm.u.c.vr().get(196614, Boolean.valueOf(true))).booleanValue()) {
                    View inflate = getLayoutInflater().inflate(R.i.drf, null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cIR);
                    TextView textView = (TextView) inflate.findViewById(R.h.cnc);
                    textView.setText(Html.fromHtml(String.format(getResources().getString(R.l.fiJ), new Object[]{getResources().getString(R.l.fdd)})));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) inflate.findViewById(R.h.cIS)).setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletPayUI rAs;

                        public final void onClick(View view) {
                            checkBox.setChecked(!checkBox.isChecked());
                        }
                    });
                    final com.tencent.mm.ui.base.h a = g.a(this, getString(R.l.fiK), inflate, getString(R.l.feQ), getString(R.l.epq), new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI rAs;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (checkBox.isChecked()) {
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(196614, Boolean.valueOf(false));
                            }
                            this.rAs.iw(false);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI rAs;

                        {
                            this.rAs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rAs.finish();
                        }
                    });
                    a.setCancelable(false);
                    checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                        final /* synthetic */ WalletPayUI rAs;

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            Button button = a.getButton(-2);
                            if (z) {
                                button.setEnabled(false);
                            } else {
                                button.setEnabled(true);
                            }
                        }
                    });
                    z2 = false;
                    if (!z2) {
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return;
            }
        }
        if (this.rAo != null) {
            w.i("MicroMsg.WalletPayUI", "need real name,stop");
            e eVar = this.rAo;
            if ("1".equals(eVar.fZb)) {
                w.i("MicroMsg.WalletPayUI", "need realname verify");
                this.rAj = true;
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                String str = eVar.fZc;
                str = eVar.fZd;
                String str2 = eVar.fZe;
                aIY();
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, this.rze != null ? this.rze.fRv : 0);
                return;
            } else if ("2".equals(eVar.fZb)) {
                w.i("MicroMsg.WalletPayUI", "need upload credit");
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, eVar.fZc, eVar.fZf, eVar.fZd, eVar.fZe, aIY(), null);
                return;
            } else {
                w.i("MicroMsg.WalletPayUI", "realnameGuideFlag =  " + eVar.fZb);
                return;
            }
        }
        if (this.ryU != null) {
            if (this.ryU.ryG == 1 && !bg.mA(this.ryU.nnP) && !bg.mA(this.ryU.nnQ) && !bg.mA(this.ryU.ryH)) {
                g.a(this.uSU.uTo, this.ryU.ryH, "", this.ryU.nnQ, this.ryU.nnP, false, new OnClickListener(this) {
                    final /* synthetic */ WalletPayUI rAs;

                    {
                        this.rAs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.WalletPayUI", "click continue pay");
                        this.rAs.btd();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ WalletPayUI rAs;

                    {
                        this.rAs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.WalletPayUI", "click cancel pay");
                        this.rAs.finish();
                    }
                });
                return;
            } else if (!(this.ryU.ryG != 2 || bg.mA(this.ryU.ryH) || bg.mA(this.ryU.ryI))) {
                w.i("MicroMsg.WalletPayUI", "pay has been blocked");
                g.a(this.uSU.uTo, this.ryU.ryH, "", this.ryU.ryI, false, new OnClickListener(this) {
                    final /* synthetic */ WalletPayUI rAs;

                    {
                        this.rAs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rAs.finish();
                    }
                });
                return;
            }
        }
        btd();
    }

    private void btd() {
        com.tencent.mm.plugin.report.service.g.oUh.i(13958, new Object[]{Integer.valueOf(1)});
        if (this.rze != null && 8 == this.rze.fRv) {
            com.tencent.mm.plugin.report.service.g.oUh.i(13955, new Object[]{Integer.valueOf(2)});
            if (this.rze.sYe != null) {
                long j = this.rze.sYe.getLong("extinfo_key_9");
                com.tencent.mm.plugin.report.service.g.oUh.i(13956, new Object[]{Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - j)});
            }
        }
        if (this.rzN) {
            w.i("MicroMsg.WalletPayUI", "hy: start do pay with force use given bankcard");
            if (bg.mA(this.rzO)) {
                b(false, 0, "");
                return;
            }
            this.ruk = btf();
            bsO();
            return;
        }
        String ap = bg.ap(getIntent().getStringExtra("key_is_use_default_card"), "");
        if (!bg.mA(ap)) {
            this.ruk = HO(ap);
        }
        if (this.ruk != null) {
            int a = this.ruk.a(this.oSJ.rBY, this.oSJ);
            if (this.oRe != null) {
                this.oRe.au(CdnLogic.MediaType_FAVORITE_VIDEO, "");
            }
            if (a != 0) {
                w.i("MicroMsg.WalletPayUI", "main bankcard(" + a + ") is useless! jump to select bankcard!");
                c(false, a, "");
                return;
            }
            o.bsC();
            if (o.bsD().bun()) {
                w.i("MicroMsg.WalletPayUI", "payWithoutPassword");
                ix(true);
                com.tencent.mm.plugin.wallet_core.d.c.bvt();
                return;
            }
            w.i("MicroMsg.WalletPayUI", "has useful bankcard ! payWithOldBankcard");
            bsO();
        } else if (this.ruj == null || this.ruj.size() <= 0) {
            w.i("MicroMsg.WalletPayUI", "default bankcard not found! payWithNewBankcard");
            b(false, 0, "");
        } else {
            w.i("MicroMsg.WalletPayUI", " no last pay bankcard ! jump to select bankcard!");
            c(false, 8, "");
        }
    }

    public void bsO() {
        if (OX()) {
            boolean z;
            w.d("MicroMsg.WalletPayUI", "pay with old bankcard!");
            if (this.rzN) {
                z = false;
            } else {
                z = true;
            }
            this.ruh = l.a(this, z, this.oSJ, this.rzg, this.ruk, this.rze, this.oRy, new l.c(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    this.rAs.aHf();
                    this.rAs.rzg = favorPayInfo;
                    if (this.rAs.rzg == null || !z) {
                        this.rAs.lOK = str;
                        this.rAs.ix(false);
                        com.tencent.mm.plugin.wallet_core.d.c.bvt();
                        this.rAs.rzi = null;
                        return;
                    }
                    this.rAs.V(-100, true);
                }
            }, new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(View view) {
                    this.rAs.rzg = (FavorPayInfo) view.getTag();
                    if (this.rAs.rzg != null) {
                        this.rAs.rzg.rFq = "";
                    }
                    this.rAs.c(false, 0, "");
                    this.rAs.ruh.dismiss();
                    this.rAs.lOK = null;
                    this.rAs.ruh = null;
                    this.rAs.rzi = null;
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.rAs.lOK = null;
                    this.rAs.ruh = null;
                    if (this.rAs.aIY()) {
                        this.rAs.finish();
                    }
                    this.rAs.rzi = null;
                }
            });
            this.rzi = this.ruh;
        }
    }

    public final void b(boolean z, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        o.bsC();
        w.d("MicroMsg.WalletPayUI", stringBuilder.append(o.bsD().bum()).append(", need confirm ? ").append(z).toString());
        if (z) {
            String H;
            if (bg.mA(str)) {
                H = Bankcard.H(this, i);
            } else {
                H = str;
            }
            g.a(this, H, "", getString(R.l.fie), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rAs.bte();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.rAs.aIY()) {
                        this.rAs.finish();
                    }
                }
            });
            return;
        }
        bte();
    }

    public final void c(boolean z, final int i, String str) {
        w.d("MicroMsg.WalletPayUI", "pay with select bankcard! need confirm ? " + z);
        if (z) {
            String H;
            if (bg.mA(str)) {
                H = Bankcard.H(this, i);
            } else {
                H = str;
            }
            g.a(this, H, "", getString(R.l.fiu), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rAs.V(i, false);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.rAs.aIY()) {
                        this.rAs.finish();
                    }
                }
            });
            return;
        }
        V(i, false);
    }

    protected final void bte() {
        Bundle extras = getIntent().getExtras();
        String str = "key_pay_flag";
        o.bsC();
        extras.putInt(str, o.bsD().bum() ? 2 : 1);
        extras.putParcelable("key_orders", this.oSJ);
        extras.putParcelable("key_pay_info", this.rze);
        extras.putParcelable("key_favor_pay_info", this.rzg);
        G(extras);
    }

    protected final void V(int i, boolean z) {
        com.tencent.mm.plugin.report.service.g.oUh.i(13958, new Object[]{Integer.valueOf(2)});
        com.tencent.mm.plugin.report.service.g.oUh.i(13955, new Object[]{Integer.valueOf(4)});
        Bundle bundle = this.uT;
        bundle.putInt("key_main_bankcard_state", i);
        bundle.putParcelable("key_orders", this.oSJ);
        bundle.putParcelable("key_pay_info", this.rze);
        bundle.putParcelable("key_authen", bta());
        bundle.putString("key_pwd1", this.lOK);
        bundle.putInt("key_pay_flag", 3);
        bundle.putInt("key_err_code", -1004);
        bundle.putParcelable("key_favor_pay_info", this.rzg);
        bundle.putBoolean("key_is_filter_bank_type", z);
        if (this.ruk != null) {
            bundle.putString("key_is_cur_bankcard_bind_serial", this.ruk.field_bindSerial);
        }
        G(bundle);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletPayUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        Bundle bundle;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                com.tencent.mm.plugin.report.service.g gVar;
                Object[] objArr;
                long j;
                e eVar = (e) kVar;
                if ("1".equals(eVar.fZb) || "2".equals(eVar.fZb)) {
                    this.rAo = eVar;
                } else {
                    this.rAo = null;
                }
                this.ryU = eVar.ryU;
                this.rAm = true;
                this.oSJ = ((e) kVar).oSJ;
                this.mCount = this.oSJ != null ? this.oSJ.rGe.size() : 0;
                w.d("MicroMsg.WalletPayUI", "get mOrders! bankcardTag : " + (this.oSJ != null ? Integer.valueOf(this.oSJ.rBY) : ""));
                OX();
                if (!(this.oSJ == null || this.oSJ.rGf == null)) {
                    this.rzJ = com.tencent.mm.plugin.wallet_core.ui.b.rJj.a(this.oSJ);
                    if (this.rzJ != null) {
                        if (this.rzJ.buM().size() > 0) {
                            this.rzK = true;
                        }
                        this.rzg = this.rzJ.Il(this.oSJ.rGf.rxP);
                        this.rzg.rFm = this.rzJ.Im(this.rzg.rFm);
                    }
                }
                if (!(this.oSJ == null || this.ruj == null || this.rze == null)) {
                    com.tencent.mm.plugin.wallet_core.d.c.b(this.rze, this.oSJ);
                    gVar = com.tencent.mm.plugin.report.service.g.oUh;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.rze.fRv);
                    objArr[1] = Integer.valueOf(0);
                    o.bsC();
                    objArr[2] = Integer.valueOf(o.bsD().bum() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.oSJ.rFM * 100.0d));
                    objArr[4] = this.oSJ.oga;
                    gVar.i(10690, objArr);
                }
                if (!(this.oSJ == null || this.oSJ.rGe == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.oSJ.rGe) {
                        linkedList.add(commodity.fTA);
                    }
                    if (linkedList.size() > 0) {
                        b ryVar = new ry();
                        ryVar.fZs.fZu = linkedList;
                        com.tencent.mm.sdk.b.a.urY.m(ryVar);
                        if (this.oRe != null) {
                            this.oRe.au(CdnLogic.MediaType_FAVORITE_FILE, (String) linkedList.get(0));
                        }
                    }
                }
                o.bsC();
                this.ruj = o.bsD().it(bsL());
                o.bsC();
                this.ruk = o.bsD().a(null, null, bsL(), false);
                String ap = bg.ap(getIntent().getStringExtra("key_is_use_default_card"), "");
                if (!bg.mA(ap)) {
                    this.ruk = HO(ap);
                }
                this.rzb.setClickable(true);
                if (bg.mA(m.btS().rIw)) {
                    this.rzZ.setVisibility(8);
                    this.rzZ.setText("");
                } else {
                    this.rzZ.setVisibility(0);
                    this.rzZ.setText(m.btS().rIw);
                }
                if (!(this.oSJ == null || this.ruj == null || this.rze == null)) {
                    com.tencent.mm.plugin.wallet_core.d.c.b(this.rze, this.oSJ);
                    gVar = com.tencent.mm.plugin.report.service.g.oUh;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.rze.fRv);
                    objArr[1] = Integer.valueOf(0);
                    o.bsC();
                    objArr[2] = Integer.valueOf(o.bsD().bum() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.oSJ.rFM * 100.0d));
                    objArr[4] = this.oSJ.oga;
                    gVar.i(10690, objArr);
                }
                if (this.rAh) {
                    V(0, false);
                }
                if (bth().sYe == null) {
                    j = 0;
                } else {
                    j = bth().sYe.getLong("wallet_pay_key_check_time");
                }
                if (j > 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(641, 4, 1, true);
                    com.tencent.mm.plugin.report.service.g.oUh.a(641, 5, bg.aA(j), true);
                }
                if (this.rAr > 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(641, 7, 1, true);
                    com.tencent.mm.plugin.report.service.g.oUh.a(641, 8, bg.aA(this.rAr), true);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                i iVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                bundle = this.uT;
                bundle.putParcelable("key_pay_info", this.rze);
                bundle.putParcelable("key_bankcard", this.ruk);
                bundle.putString("key_bank_type", this.ruk.field_bankcardType);
                if (!bg.mA(this.lOK)) {
                    bundle.putString("key_pwd1", this.lOK);
                }
                bundle.putString("kreq_token", iVar.token);
                bundle.putParcelable("key_authen", iVar.ryN);
                bundle.putBoolean("key_need_verify_sms", !iVar.ryL);
                if (bg.mA(iVar.ryO)) {
                    bundle.putString("key_mobile", this.ruk.field_mobile);
                } else {
                    bundle.putString("key_mobile", iVar.ryO);
                }
                bundle.putString("key_QADNA_URL", iVar.ryP);
                if (iVar.rzL) {
                    if (this.oRe != null) {
                        this.oRe.au(10003, "");
                        com.tencent.mm.plugin.wallet.a aVar = this.oRe;
                        com.tencent.mm.plugin.report.service.g.oUh.i(13455, new Object[]{aVar.rtt, Long.valueOf(System.currentTimeMillis()), aVar.rtu});
                    }
                    bundle.putParcelable("key_orders", iVar.ryM);
                    if (this.rze != null) {
                        w.i("MicroMsg.WalletPayUI", "payscene %d", new Object[]{Integer.valueOf(this.rze.fRv)});
                        if (8 == this.rze.fRv) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uEO, Boolean.valueOf(true));
                        }
                    }
                } else {
                    bundle.putParcelable("key_orders", this.oSJ);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("pwd", this.lOK);
                com.tencent.mm.pluginsdk.l.a.sBC.a(iVar.bsH(), true, bundle2);
                bundle.putInt("key_pay_flag", 3);
                Parcelable parcelable = iVar.ocy;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
                G(bundle);
                return true;
            }
            ar();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            bundle = new Bundle();
            bundle.putString("pwd", this.lOK);
            com.tencent.mm.pluginsdk.l.a.sBC.a(this.rze.sYf == 1, false, bundle);
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    this.rzQ = this.uT;
                    this.rzQ.putParcelable("key_pay_info", this.rze);
                    this.rzQ.putParcelable("key_bankcard", this.ruk);
                    if (!bg.mA(this.lOK)) {
                        this.rzQ.putString("key_pwd1", this.lOK);
                    }
                    this.rzQ.putString("kreq_token", bVar.token);
                    this.rzQ.putParcelable("key_authen", bVar.ryN);
                    this.rzQ.putBoolean("key_need_verify_sms", !bVar.ryL);
                    this.rzQ.putString("key_mobile", this.ruk.field_mobile);
                    this.rzQ.putInt("key_err_code", i2);
                    this.rzQ.putParcelable("key_orders", this.oSJ);
                    if (bg.mA(str)) {
                        string = getString(R.l.fiM, new Object[]{this.ruk.field_desc, this.ruk.field_mobile});
                    } else {
                        string = str;
                    }
                    g.a(this, string, "", getString(R.l.fiL), getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI rAs;

                        {
                            this.rAs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rAs.rzQ.putInt("key_pay_flag", 3);
                            this.rAs.G(this.rAs.rzQ);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI rAs;

                        {
                            this.rAs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.rAs.aIY()) {
                                this.rAs.finish();
                            }
                        }
                    });
                    return true;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (!(this.ruk == null || this.oSJ == null)) {
                        this.ruk.rEg = this.oSJ.fJH;
                        if (this.ruj == null || this.ruj.size() <= 1) {
                            b(true, 4, str);
                        } else {
                            c(true, 4, str);
                        }
                        return true;
                    }
                    break;
                case 100000:
                case 100001:
                case 100102:
                    this.rze.sYh = i2;
                    bsO();
                    return true;
                case 100100:
                case 100101:
                    this.rze.sYh = i2;
                    boolean z = false;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.rzh == null) {
                        this.rzh = new a(this, this);
                    }
                    this.rzh.a(z, this.rze.fLS, this.rze.fJH);
                    w.i("MicroMsg.WalletPayUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof e) {
            this.rAm = true;
            btg();
            if (i2 == 416) {
                w.e("MicroMsg.WalletPayUI", "errCode is 416 need real name verify!");
                this.rAj = true;
                bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle, this.rze != null ? this.rze.fRv : 0);
            }
            w.i("MicroMsg.WalletPayUI", "errCode is %d , not need real name verify!", new Object[]{Integer.valueOf(i2)});
        }
        return false;
    }

    public final boolean aJc() {
        return false;
    }

    public final boolean OX() {
        if (this.oSJ == null || this.oSJ.rGe == null || this.oSJ.rGe.size() <= 0) {
            w.w("MicroMsg.WalletPayUI", "mOrders info is Illegal!");
            g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rAs.finish();
                }
            });
            return false;
        } else if (!this.rzN || bg.mA(this.rzO) || btf() != null) {
            return true;
        } else {
            w.w("MicroMsg.WalletPayUI", "hy: should use given bankcard, but resolved as null. show error msg and quit");
            g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI rAs;

                {
                    this.rAs = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rAs.finish();
                }
            });
            return false;
        }
    }

    private Bankcard btf() {
        o.bsC();
        ArrayList it = o.bsD().it(true);
        if (it.size() != 0) {
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                Bankcard bankcard = (Bankcard) it2.next();
                if (bg.mz(this.rzO).equals(bankcard.field_bindSerial)) {
                    w.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    private static Bankcard HO(String str) {
        o.bsC();
        ArrayList it = o.bsD().it(true);
        if (it.size() != 0) {
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                Bankcard bankcard = (Bankcard) it2.next();
                if (bg.mz(str).equals(bankcard.field_bindSerial)) {
                    w.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.WalletPayUI", "onAcvityResult requestCode:" + i + ", resultCode:" + i2);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (intent != null) {
                        this.rAl = intent.getIntExtra("auto_deduct_flag", -1);
                        this.oSJ.rGj.rAl = this.rAl;
                        bth().sYj = this.rAl;
                        if (this.rAl == 1) {
                            bth().sYk = intent.getStringExtra("deduct_bank_type");
                            bth().sYl = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.rAk = true;
                    aJb();
                } else {
                    finish();
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(13958, new Object[]{Integer.valueOf(3)});
                return;
            default:
                return;
        }
    }

    protected final boolean aJb() {
        w.i("MicroMsg.WalletPayUI", "onProgressFinish isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.rAp)});
        com.tencent.mm.sdk.b.a.urY.m(new rs());
        boolean z = (this.oSJ == null || this.oSJ.rGj == null || this.rAk) ? false : true;
        if (!z) {
            btg();
        }
        if (this.rAp) {
            iw(true);
            return true;
        } else if (this.rAj) {
            return true;
        } else {
            if (z) {
                Intent intent = new Intent(this, WalletPayDeductUI.class);
                intent.putExtra("orders", this.oSJ);
                startActivityForResult(intent, 0);
                return true;
            } else if (this.uSU.ipu.getVisibility() == 0) {
                if (!(this.uSU.ipu.getVisibility() != 0 || this.oSJ == null || this.oSJ.rGj == null || !this.rzb.isEnabled() || this.rAn)) {
                    this.rzb.performClick();
                    this.rAn = true;
                }
                return false;
            } else if (this.rzR || !OX()) {
                return true;
            } else {
                iw(true);
                this.rzR = true;
                return true;
            }
        }
    }

    public final boolean aIY() {
        if (this.rAm) {
            String str = "MicroMsg.WalletPayUI";
            String str2 = "case 1 %s,";
            Object[] objArr = new Object[1];
            boolean z = bth() == null || !bth().mqD;
            objArr[0] = Boolean.valueOf(z);
            w.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 2 %s,";
            objArr = new Object[1];
            o.bsC();
            if (o.bsD().bum()) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            w.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 3 mBankcardList %s, mDefaultBankcard %s";
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.ruj == null ? 0 : this.ruj.size());
            objArr[1] = this.ruk == null ? "" : this.ruk.field_forbidWord;
            w.d(str, str2, objArr);
            if (bth() == null || !bth().mqD) {
                w.i("MicroMsg.WalletPayUI", "get isTransparent1");
                return false;
            }
            o.bsC();
            if (!o.bsD().bum()) {
                w.i("MicroMsg.WalletPayUI", "get isTransparent2");
                return false;
            } else if (this.ruj == null || (this.ruj.size() != 0 && (this.ruk == null || bg.mA(this.ruk.field_forbidWord)))) {
                w.i("MicroMsg.WalletPayUI", "get isTransparent4");
                return true;
            } else {
                str = "MicroMsg.WalletPayUI";
                str2 = "get isTransparent3 1 %s 2 %s";
                objArr = new Object[2];
                z = this.ruj != null && this.ruj.size() == 0;
                objArr[0] = Boolean.valueOf(z);
                z = (this.ruk == null || bg.mA(this.ruk.field_forbidWord)) ? false : true;
                objArr[1] = Boolean.valueOf(z);
                w.i(str, str2, objArr);
                return false;
            }
        }
        w.i("MicroMsg.WalletPayUI", "get isTransparent5");
        return true;
    }

    private void btg() {
        if (aIY()) {
            re(4);
        } else {
            re(0);
        }
    }

    protected final boolean bsP() {
        return true;
    }

    public final void qU(int i) {
        if (i == 0) {
            if (aIY()) {
                finish();
            }
        } else if (i == 1) {
            bsO();
        }
    }

    public void ix(boolean z) {
        k a = com.tencent.mm.plugin.wallet.pay.a.a.a(bta(), this.oSJ, z);
        if (this.oSJ != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.oSJ.fJH);
            if (this.oSJ.rGe != null && this.oSJ.rGe.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.oSJ.rGe.get(0)).fTA);
            }
            bundle.putLong("key_SessionId", this.rAd);
            a.gWO = "PayProcess";
            a.uT = bundle;
        }
        if (this.rze != null) {
            if (this.rze.fRv == 6 && this.rze.sYa == 100) {
                a.hPi = 100;
            } else {
                a.hPi = this.rze.fRv;
            }
        }
        k(a);
        if (this.rze != null && 8 == this.rze.fRv && this.rze.sYe != null) {
            long j = this.rze.sYe.getLong("extinfo_key_9");
            com.tencent.mm.plugin.report.service.g.oUh.i(13956, new Object[]{Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - j)});
        }
    }

    public final boolean bsL() {
        return (this.rze == null || this.rze.fRv == 11) ? false : true;
    }

    public final PayInfo bth() {
        if (this.rze == null) {
            this.rze = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        return this.rze;
    }

    protected final int Ol() {
        return 1;
    }

    public void G(Bundle bundle) {
        boolean z;
        this.rzM = true;
        if (this.oSJ != null) {
            bundle.putInt("key_support_bankcard", this.oSJ.rBY);
            bundle.putString("key_reqKey", this.oSJ.fJH);
            if (this.oSJ.rGe != null && this.oSJ.rGe.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.oSJ.rGe.get(0)).fTA);
            }
            bundle.putLong("key_SessionId", this.rAd);
        }
        if (this.rze != null) {
            bundle.putInt("key_scene", this.rze.fRv);
        }
        String str = "key_is_oversea";
        if (btb()) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean(str, z);
        bundle.putInt("is_deduct_open", this.rAl);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, bundle, null);
    }

    public final void c(boolean z, String str, String str2) {
        w.i("MicroMsg.WalletPayUI", "onGenFinish callback");
        if (z) {
            w.i("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is true");
            this.rze.fLU = str;
            this.rze.fLV = str2;
            ix(false);
            com.tencent.mm.plugin.wallet_core.d.c.bvt();
            return;
        }
        w.e("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is false");
        ix(false);
        com.tencent.mm.plugin.wallet_core.d.c.bvt();
    }

    public void onPause() {
        super.onPause();
        if (this.rzi != null) {
            this.rzi.buO();
        }
    }
}
