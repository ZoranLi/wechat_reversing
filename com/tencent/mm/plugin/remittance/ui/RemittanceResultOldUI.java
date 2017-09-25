package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
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
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

@a(19)
public class RemittanceResultOldUI extends RemittanceResultUI {
    private int oRh;
    private Orders oSJ;
    private String oSK;
    private boolean oSL;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dmH;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oSJ = (Orders) this.uT.getParcelable("key_orders");
        KC();
        if (this.oRh == 31) {
            String str = "";
            if (this.oSJ.rGe.size() > 0) {
                str = ((Commodity) this.oSJ.rGe.get(0)).fTA;
            }
            w.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[]{str});
            b.aWZ().aXc().di(str, this.oSK);
        }
        x.a((PayInfo) this.uT.getParcelable("key_pay_info"), this.oSJ);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aXu();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void KC() {
        int i = 1;
        boolean z = false;
        qP(getString(R.l.eLz));
        b(null);
        bPS();
        kq(false);
        TextView textView = (TextView) findViewById(R.h.cyq);
        if (this.oSJ != null) {
            textView.setText(e.d(this.oSJ.rFM, this.oSJ.oga));
        }
        PayInfo payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
        if (payInfo == null) {
            w.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        if (payInfo.sYe != null) {
            this.oSL = payInfo.sYe.getBoolean("extinfo_key_4");
            str = payInfo.sYe.getString("extinfo_key_1");
        }
        int i2 = payInfo.fRv;
        this.oRh = i2;
        this.oSK = str;
        str = e.eK(str);
        if (i2 == 31) {
            textView = (TextView) findViewById(R.h.cys);
            CharSequence string = getString(R.l.cys, new Object[]{str});
            if (bg.mA(string)) {
                textView.setVisibility(8);
            } else {
                textView.setText(h.b(this, string, textView.getTextSize()));
                textView.setVisibility(0);
            }
            findViewById(R.h.cyj).setVisibility(8);
            if (this.oSJ.oQs > 0.0d) {
                ((TextView) findViewById(R.h.byY)).setText(getResources().getString(R.l.eLx, new Object[]{e.d(this.oSJ.oQs, this.oSJ.oga)}));
                findViewById(R.h.byZ).setVisibility(0);
            }
        } else {
            String str2 = "";
            if (payInfo.sYe != null) {
                str2 = payInfo.sYe.getString("extinfo_key_2");
            }
            if (i2 == 32 || i2 == 33) {
                str2 = str;
            } else if (bg.mA(str2)) {
                str2 = str + getString(R.l.eLC);
            } else {
                str2 = str + "（" + e.UJ(str2) + "）";
            }
            TextView textView2 = (TextView) findViewById(R.h.cys);
            if (bg.mA(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(h.b(this, getString(R.l.eLy, new Object[]{str2}), textView2.getTextSize()));
                textView2.setVisibility(0);
            }
            if (i2 == 33 || i2 == 32) {
                View findViewById = findViewById(R.h.cyo);
                textView2 = (TextView) findViewById(R.h.cyp);
                TextView textView3 = (TextView) findViewById(R.h.cyn);
                CharSequence string2 = payInfo.sYe.getString("extinfo_key_3");
                CharSequence string3 = payInfo.sYe.getString("extinfo_key_8");
                if (bg.mA(string2)) {
                    findViewById.setVisibility(8);
                    boolean z2 = false;
                } else {
                    textView3.setText(h.b(this, string2, textView3.getTextSize()));
                    findViewById.setVisibility(0);
                    if (bg.mA(string3)) {
                        i2 = 1;
                    } else {
                        textView2.setText(string3);
                        i2 = 1;
                    }
                }
                View findViewById2 = findViewById(R.h.cyl);
                textView2 = (TextView) findViewById(R.h.cym);
                textView3 = (TextView) findViewById(R.h.cyk);
                string3 = payInfo.sYe.getString("extinfo_key_6");
                CharSequence string4 = payInfo.sYe.getString("extinfo_key_7");
                if (bg.mA(string4)) {
                    findViewById2.setVisibility(8);
                    i = 0;
                } else {
                    textView3.setText(h.b(this, string4, textView3.getTextSize()));
                    textView3.setVisibility(0);
                    if (!bg.mA(string3)) {
                        textView2.setText(h.b(this, string3, textView2.getTextSize()));
                    }
                }
                if (i2 == 0 && r4 == 0) {
                    findViewById(R.h.cyj).setVisibility(8);
                }
            } else if (!(i2 != 5 || this.oSJ.rGe == null || this.oSJ.rGe.get(0) == null || TextUtils.isEmpty(((Commodity) this.oSJ.rGe.get(0)).ofP))) {
                textView2.setText(((Commodity) this.oSJ.rGe.get(0)).ofP);
            }
        }
        ((Button) findViewById(R.h.cyr)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RemittanceResultOldUI oSY;

            {
                this.oSY = r1;
            }

            public final void onClick(View view) {
                this.oSY.aXu();
            }
        });
        ap.yY();
        Object obj = c.vr().get(com.tencent.mm.storage.w.a.uBh, Boolean.valueOf(false));
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            w.i("MicroMsg.RemittanceResultOldUI", "has show the finger print auth guide!");
            return;
        }
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        Bundle bundle = new Bundle();
        if (ai != null) {
            bundle = ai.lHw;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            w.i("MicroMsg.RemittanceResultOldUI", "pwd is empty, not show the finger print auth guide!");
        } else {
            ai.a(this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void aXu() {
        if (this.uT.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.uT.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceResultOldUI oSY;

                    {
                        this.oSY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oSY.aXv();
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
        ccE().d(this, this.uT);
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ RemittanceResultOldUI oSY;

            {
                this.oSY = r1;
            }

            public final void run() {
                if (this.oSY.oRh == 33 || this.oSY.oRh == 32) {
                    this.oSY.finish();
                } else if (bg.mA(this.oSY.oSK) || this.oSY.oSL) {
                    this.oSY.finish();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", this.oSY.oSK);
                    intent.putExtra("finish_direct", false);
                    d.a(this.oSY, ".ui.chatting.En_5b8fbb1e", intent);
                }
            }
        }, 100);
    }

    protected final boolean aXw() {
        return false;
    }
}
