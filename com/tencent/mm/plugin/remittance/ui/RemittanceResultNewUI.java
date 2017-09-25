package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceResultNewUI extends RemittanceResultUI {
    private PayInfo oLz;
    private int oRh;
    private Orders oSJ;
    private String oSK;
    private boolean oSL;
    private TextView oSM;
    private ViewGroup oSN;
    private TextView oSO;
    private WalletTextView oSP;
    private ViewGroup oSQ;
    private ViewGroup oSR;
    private ViewGroup oSS;
    private TextView oST;
    private TextView oSU;
    private WalletTextView oSV;
    private Button oSW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.eo(21)) {
            if (d.eo(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        if (cO().cP() != null) {
            cO().cP().hide();
        }
        this.oSJ = (Orders) this.uT.getParcelable("key_orders");
        this.oLz = (PayInfo) this.uT.getParcelable("key_pay_info");
        if (this.oLz == null) {
            w.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        if (this.oLz.sYe != null) {
            this.oSL = this.oLz.sYe.getBoolean("extinfo_key_4");
            str = this.oLz.sYe.getString("extinfo_key_1");
        }
        this.oRh = this.oLz.fRv;
        this.oSK = str;
        w.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[]{Integer.valueOf(r1)});
        KC();
        if (this.oRh == 31) {
            str = "";
            if (this.oSJ.rGe.size() > 0) {
                str = ((Commodity) this.oSJ.rGe.get(0)).fTA;
            }
            w.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[]{str});
            b.aWZ().aXc().di(str, this.oSK);
        }
        x.a((PayInfo) this.uT.getParcelable("key_pay_info"), this.oSJ);
    }

    protected final int getLayoutId() {
        return R.i.dmG;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aXu();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void KC() {
        boolean z = false;
        b(null);
        bPS();
        kq(false);
        this.oSM = (TextView) findViewById(R.h.cqP);
        this.oSN = (ViewGroup) findViewById(R.h.bNC);
        this.oSO = (TextView) findViewById(R.h.bNy);
        this.oSP = (WalletTextView) findViewById(R.h.bNx);
        this.oSQ = (ViewGroup) findViewById(R.h.bNA);
        this.oSR = (ViewGroup) findViewById(R.h.bNB);
        this.oSS = (ViewGroup) findViewById(R.h.coz);
        this.oST = (TextView) findViewById(R.h.coy);
        this.oSU = (TextView) findViewById(R.h.cow);
        this.oSV = (WalletTextView) findViewById(R.h.cov);
        this.oSW = (Button) findViewById(R.h.cJF);
        this.oSW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RemittanceResultNewUI oSX;

            {
                this.oSX = r1;
            }

            public final void onClick(View view) {
                this.oSX.aXu();
            }
        });
        String eK = e.eK(this.oSK);
        if (this.oRh == 31 || this.oRh == 5) {
            this.oSU.setText(e.UG(this.oSJ.oga));
            this.oSV.setText(e.n(this.oSJ.rFM));
            if (this.oRh == 31) {
                CharSequence string = getString(R.l.cys, new Object[]{eK});
                if (bg.mA(string)) {
                    this.oST.setVisibility(8);
                } else {
                    this.oST.setText(h.b(this, string, this.oST.getTextSize()));
                }
            } else {
                boolean z2;
                if (this.oLz.sYe == null || !this.oLz.sYe.getBoolean("extinfo_key_10")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                w.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[]{Boolean.valueOf(z2)});
                if (z2) {
                    this.oST.setText(getString(R.l.eLg));
                } else if (!(this.oSJ.rGe == null || this.oSJ.rGe.get(0) == null || TextUtils.isEmpty(((Commodity) this.oSJ.rGe.get(0)).ofP))) {
                    this.oST.setText(((Commodity) this.oSJ.rGe.get(0)).ofP);
                }
            }
            this.oSS.setVisibility(0);
            if (this.oSJ.oQs > 0.0d) {
                aXt();
                ((MarginLayoutParams) this.oSQ.getLayoutParams()).topMargin = com.tencent.mm.bg.a.fromDPToPix(this, 20);
                this.oSQ.setVisibility(0);
                this.oSR.setVisibility(0);
            }
        } else {
            this.oSO.setText(e.UG(this.oSJ.oga));
            this.oSP.setText(e.n(this.oSJ.rFM));
            this.oSR.removeAllViews();
            if (this.oRh == 32 || this.oRh == 33) {
                CharSequence charSequence;
                TextView textView;
                String str = "";
                if (this.oLz.sYe != null) {
                    str = this.oLz.sYe.getString("extinfo_key_2");
                }
                if (eK != null && eK.length() > 10) {
                    eK = eK.substring(0, 10) + "...";
                }
                if (bg.mA(str)) {
                    Object obj = eK;
                } else {
                    charSequence = eK + "(" + e.UJ(str) + ")";
                }
                w.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.i.dcb, this.oSR, false);
                ImageView imageView = (ImageView) viewGroup.findViewById(R.h.bqM);
                TextView textView2 = (TextView) viewGroup.findViewById(R.h.bIb);
                ((TextView) viewGroup.findViewById(R.h.cJh)).setText(getString(R.l.eLp));
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, this.oSK, 0.5f, false);
                textView2.setText(charSequence);
                this.oSR.addView(viewGroup);
                w.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
                charSequence = this.oLz.sYe.getString("extinfo_key_3");
                CharSequence string2 = this.oLz.sYe.getString("extinfo_key_8");
                if (!bg.mA(charSequence)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(R.i.dcb, this.oSR, false);
                    textView = (TextView) viewGroup.findViewById(R.h.cJh);
                    imageView = (ImageView) viewGroup.findViewById(R.h.bqM);
                    textView2 = (TextView) viewGroup.findViewById(R.h.bIb);
                    if (bg.mA(string2)) {
                        textView.setText(getString(R.l.dWB));
                    } else {
                        textView.setText(string2);
                    }
                    imageView.setVisibility(8);
                    textView2.setText(charSequence);
                    this.oSR.addView(viewGroup);
                }
                w.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
                charSequence = this.oLz.sYe.getString("extinfo_key_6");
                string2 = this.oLz.sYe.getString("extinfo_key_7");
                if (!bg.mA(string2)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(R.i.dcb, this.oSR, false);
                    textView = (TextView) viewGroup.findViewById(R.h.cJh);
                    imageView = (ImageView) viewGroup.findViewById(R.h.bqM);
                    textView2 = (TextView) viewGroup.findViewById(R.h.bIb);
                    if (bg.mA(charSequence)) {
                        textView.setText(getString(R.l.dWA));
                    } else {
                        textView.setText(charSequence);
                    }
                    imageView.setVisibility(8);
                    textView2.setText(string2);
                    this.oSR.addView(viewGroup);
                }
                aXt();
                this.oSQ.setVisibility(0);
                this.oSR.setVisibility(0);
            }
            this.oSN.setVisibility(0);
        }
        ap.yY();
        Object obj2 = c.vr().get(com.tencent.mm.storage.w.a.uBh, Boolean.valueOf(false));
        if (obj2 != null) {
            z = ((Boolean) obj2).booleanValue();
        }
        if (z) {
            w.i("MicroMsg.RemittanceResultNewUI", "has show the finger print auth guide!");
            return;
        }
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        Bundle bundle = new Bundle();
        if (ai != null) {
            bundle = ai.lHw;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            w.i("MicroMsg.RemittanceResultNewUI", "pwd is empty, not show the finger print auth guide!");
        } else {
            ai.a(this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void aXt() {
        boolean z = true;
        if (this.oSJ != null) {
            String str = "MicroMsg.RemittanceResultNewUI";
            String str2 = "need set charge fee: %s";
            Object[] objArr = new Object[1];
            if (this.oSJ.oQs <= 0.0d) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.i(str, str2, objArr);
            if (this.oSJ.oQs > 0.0d) {
                CharSequence string = getString(R.l.eLw);
                CharSequence d = e.d(this.oSJ.oQs, this.oSJ.oga);
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.i.dcb, this.oSR, false);
                ImageView imageView = (ImageView) viewGroup.findViewById(R.h.bqM);
                TextView textView = (TextView) viewGroup.findViewById(R.h.bIb);
                ((TextView) viewGroup.findViewById(R.h.cJh)).setText(string);
                imageView.setVisibility(8);
                textView.setText(d);
                this.oSR.addView(viewGroup);
            }
        }
    }

    private void aXu() {
        w.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
        if (this.uT.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.uT.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceResultNewUI oSX;

                    {
                        this.oSX = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oSX.aXv();
                    }
                });
                this.uT.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        aXv();
    }

    private void aXv() {
        w.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
        ccE().d(this, this.uT);
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ RemittanceResultNewUI oSX;

            {
                this.oSX = r1;
            }

            public final void run() {
                if (this.oSX.oRh == 33 || this.oSX.oRh == 32) {
                    this.oSX.finish();
                } else if (bg.mA(this.oSX.oSK) || this.oSX.oSL) {
                    this.oSX.finish();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", this.oSX.oSK);
                    intent.putExtra("finish_direct", false);
                    com.tencent.mm.bb.d.a(this.oSX, ".ui.chatting.En_5b8fbb1e", intent);
                }
            }
        }, 100);
    }

    public final void re(int i) {
        this.uSU.ipu.setVisibility(i);
    }

    protected final boolean aXw() {
        return false;
    }
}
