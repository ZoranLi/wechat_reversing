package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public class WalletPayDeductUI extends MMPreference implements OnClickListener, e {
    private Dialog ita = null;
    protected f jid;
    protected Button liz;
    protected Orders oSJ;
    private String rzA;
    private String rzB;
    private Bankcard rzC;
    private LinearLayout rzD;
    protected boolean rzE = false;
    protected MMSwitchBtn rzv;
    protected ArrayList<Preference> rzw;
    protected TextView rzx;
    private TextView rzy;
    private TextView rzz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jid = this.vrv;
        setResult(0);
        b(new o(this) {
            final /* synthetic */ WalletPayDeductUI rzF;

            {
                this.rzF = r1;
            }

            public final void bsU() {
                this.rzF.setResult(0);
                this.rzF.finish();
            }
        });
        ap.vd().a(385, this);
        KC();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(385, this);
    }

    public final int ON() {
        return -1;
    }

    protected final void KC() {
        zi(R.l.fiz);
        this.rzx = (TextView) this.uSU.ipu.findViewById(R.h.btC);
        this.liz = (Button) this.uSU.ipu.findViewById(R.h.cnY);
        Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.WalletPayDeductUI", "intent is null");
            finish();
            return;
        }
        this.oSJ = (Orders) intent.getParcelableExtra("orders");
        if (this.oSJ == null || this.oSJ.rGj == null) {
            w.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.oSJ);
            finish();
        }
        this.rzE = this.oSJ.rGj.rAl == 1;
        this.rzv = (MMSwitchBtn) findViewById(R.h.checkbox);
        this.rzv.lS(this.rzE);
        this.rzv.wwD = new a(this) {
            final /* synthetic */ WalletPayDeductUI rzF;

            {
                this.rzF = r1;
            }

            public final void bK(boolean z) {
                this.rzF.iv(z);
            }
        };
        this.rzD = (LinearLayout) findViewById(R.h.cqQ);
        ((TextView) findViewById(R.h.bHO)).setText(this.oSJ.rGj.title);
        ((TextView) findViewById(R.h.title)).setText(((Commodity) this.oSJ.rGe.get(0)).desc);
        ((TextView) findViewById(R.h.cIN)).setText(((Commodity) this.oSJ.rGe.get(0)).ofP);
        ((TextView) findViewById(R.h.bPp)).setText(com.tencent.mm.wallet_core.ui.e.UH(this.oSJ.oga));
        ((TextView) findViewById(R.h.bPo)).setText(((Commodity) this.oSJ.rGe.get(0)).kBc);
        TextView textView = (TextView) findViewById(R.h.bQW);
        this.rzy = (TextView) findViewById(R.h.bHP);
        this.rzz = (TextView) findViewById(R.h.brR);
        w.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[]{Integer.valueOf(this.oSJ.rGj.rGE)});
        if (this.oSJ.rGj.rGE == 1) {
            ap.yY();
            this.rzB = (String) c.vr().get(com.tencent.mm.storage.w.a.uDU, "");
            ap.yY();
            this.rzA = (String) c.vr().get(com.tencent.mm.storage.w.a.uDT, "");
            if (bg.mA(this.rzA) || bg.mA(this.rzA)) {
                w.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
                this.ita = g.a(this.uSU.uTo, false, null);
                ap.vd().a(new b(), 0);
            } else {
                this.rzz.setText(this.rzB);
                bsT();
            }
        } else {
            this.rzD.setVisibility(8);
        }
        if (bg.mA(this.oSJ.rGj.rGC)) {
            textView.setVisibility(8);
        } else {
            String string = getString(R.l.ffl);
            CharSequence a = h.a(this, getString(R.l.ffk, new Object[]{string, getString(R.l.ffm)}));
            com.tencent.mm.plugin.wallet_core.ui.f fVar = new com.tencent.mm.plugin.wallet_core.ui.f(this.uSU.uTo);
            CharSequence spannableString = new SpannableString(a);
            spannableString.setSpan(fVar, a.length() - r4.length(), a.length(), 33);
            textView.setTextColor(getResources().getColor(R.e.aUo));
            textView.setText(spannableString);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        }
        this.liz.setOnClickListener(this);
        bG(this.oSJ.rGj.rGD);
        iv(this.rzE);
    }

    private void bsT() {
        com.tencent.mm.plugin.wallet.a.o.bsC();
        af bsD = com.tencent.mm.plugin.wallet.a.o.bsD();
        if (this.rzC == null) {
            this.rzC = bsD.a(null, null, true, true);
        }
        if (this.rzC == null) {
            w.i("MicroMsg.WalletPayDeductUI", "no bank card!");
            finish();
            return;
        }
        CharSequence spannableString = new SpannableString(this.rzC.field_desc);
        com.tencent.mm.plugin.wallet_core.ui.f fVar = new com.tencent.mm.plugin.wallet_core.ui.f(this.uSU.uTo);
        final List it = bsD.it(true);
        fVar.rKS = new com.tencent.mm.plugin.wallet_core.ui.f.a(this) {
            final /* synthetic */ WalletPayDeductUI rzF;

            public final void onClick(View view) {
                com.tencent.mm.plugin.wallet_core.ui.g.a(this.rzF.uSU.uTo, it, null, this.rzF.rzA, this.rzF.rzC, new com.tencent.mm.ui.base.g.a(this) {
                    final /* synthetic */ AnonymousClass3 rzH;

                    {
                        this.rzH = r1;
                    }

                    public final void rO(int i) {
                        this.rzH.rzF.rzC = (Bankcard) it.get(i);
                        this.rzH.rzF.bsT();
                    }
                });
            }
        };
        spannableString.setSpan(fVar, 0, spannableString.length(), 18);
        this.rzy.setText(spannableString);
        this.rzy.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected final void iv(boolean z) {
        int i = 0;
        int i2;
        if (z) {
            findViewById(16908298).setVisibility(0);
            if (this.oSJ.rGj.rGE == 1) {
                this.rzD.setVisibility(0);
            } else {
                this.rzD.setVisibility(8);
            }
            if (this.rzw != null && this.rzw.size() > 0) {
                int size = this.rzw.size();
                for (i2 = 0; i2 < size; i2++) {
                    this.jid.aV(((Preference) this.rzw.get(i2)).igL, false);
                }
                this.jid.notifyDataSetChanged();
            }
            if (m.btS().bum()) {
                this.rzx.setVisibility(8);
                this.liz.setText(R.l.ffq);
            } else {
                this.rzx.setVisibility(0);
                this.rzx.setText(R.l.ffp);
                this.liz.setText(R.l.ffn);
            }
        } else {
            if (this.rzw != null && this.rzw.size() > 0) {
                i2 = this.rzw.size();
                while (i < i2) {
                    this.jid.aV(((Preference) this.rzw.get(i)).igL, true);
                    i++;
                }
            }
            findViewById(16908298).setVisibility(8);
            this.rzD.setVisibility(8);
            this.rzx.setVisibility(8);
            this.liz.setText(R.l.ffo);
        }
        w.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.rzv.wwz);
    }

    private void bG(List<DeductShowInfo> list) {
        if (list == null || list.size() == 0) {
            w.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
        } else if (this.rzw == null) {
            int size = list.size();
            this.rzw = new ArrayList();
            for (int i = 0; i < size; i++) {
                DeductShowInfo deductShowInfo = (DeductShowInfo) list.get(i);
                if (!(deductShowInfo == null || bg.mA(deductShowInfo.name))) {
                    Preference dVar = new d(this);
                    dVar.setTitle(deductShowInfo.name);
                    dVar.mqI = deductShowInfo.value;
                    dVar.mqM = false;
                    int i2 = R.h.cQr;
                    String str = deductShowInfo.url;
                    if (dVar.kHP != null) {
                        dVar.kHP.setTag(i2, str);
                    }
                    dVar.setKey("deduct_info_" + i);
                    this.rzw.add(dVar);
                    this.jid.a(dVar);
                    this.jid.aV(dVar.igL, true);
                }
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.drd;
    }

    public final boolean a(f fVar, Preference preference) {
        Object obj = null;
        if (preference instanceof d) {
            Object tag;
            d dVar = (d) preference;
            int i = R.h.cQr;
            if (dVar.kHP != null) {
                tag = dVar.kHP.getTag(i);
            } else {
                tag = null;
            }
            if (tag != null) {
                obj = tag;
            }
            if (obj != null) {
                String str = (String) obj;
                if (!bg.mA(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
            }
        }
        return false;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.h.cnY) {
            Intent intent = new Intent();
            intent.putExtra("auto_deduct_flag", this.rzv.wwz ? 1 : 0);
            if (this.rzv.wwz && this.rzC != null) {
                intent.putExtra("deduct_bank_type", this.rzC.field_bankcardType);
                intent.putExtra("deduct_bind_serial", this.rzC.field_bindSerial);
                w.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[]{this.rzC.field_bankcardType});
            }
            setResult(-1, intent);
            finish();
        } else if (id == R.h.bQW && !bg.mA(this.oSJ.rGj.rGC)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.oSJ.rGj.rGC);
            intent2.putExtra("showShare", false);
            com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(kVar instanceof b)) {
            w.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
        } else if (i == 0 && i2 == 0) {
            ap.yY();
            this.rzB = (String) c.vr().get(com.tencent.mm.storage.w.a.uDU, getString(R.l.fiw));
            ap.yY();
            this.rzA = (String) c.vr().get(com.tencent.mm.storage.w.a.uDT, getString(R.l.fiy));
            this.rzz.setText(this.rzB);
            bsT();
        }
        if (this.ita != null) {
            this.ita.dismiss();
        }
    }
}
