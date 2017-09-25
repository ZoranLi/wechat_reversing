package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.nl;
import com.tencent.mm.e.a.rt;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.k;
import com.tenpay.android.jni.Encrypt;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private int hPi = -1;
    c rBh = new c<nl>(this) {
        final /* synthetic */ WalletBankcardIdUI rJt;

        {
            this.rJt = r2;
            this.usg = nl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nl nlVar = (nl) bVar;
            if (nlVar instanceof nl) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletBankcardIdUI.a(this.rJt, encrypt.desedeEncode(nlVar.fUB.cardId, randomKey), randomKey, nlVar.fUB.fUC);
                this.rJt.finish();
                return true;
            }
            w.f("Micromsg.WalletInputCardIDUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    protected WalletFormView rJn;
    protected WalletFormView rJo;
    private Bankcard rJp;
    private a rJq;
    private boolean rJr = false;
    private boolean rJs;
    c rxp = new c<rt>(this) {
        final /* synthetic */ WalletBankcardIdUI rJt;

        {
            this.rJt = r2;
            this.usg = rt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.rJt.finish();
            return false;
        }
    };
    private Button rxr;

    private static class a extends BaseAdapter {
        private LayoutInflater Du = null;
        private Context mContext = null;
        List<p> rJu = new LinkedList();

        class a {
            ImageView rJv;
            TextView rJw;
            TextView rJx;
            final /* synthetic */ a rJy;
            TextView ruR;

            a(a aVar) {
                this.rJy = aVar;
            }
        }

        public a(Context context, List<p> list) {
            this.Du = LayoutInflater.from(context);
            this.rJu = list;
            this.mContext = context;
        }

        public final int getCount() {
            if (this.rJu == null) {
                return 0;
            }
            return this.rJu.size();
        }

        public final Object getItem(int i) {
            return this.rJu.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.Du.inflate(R.i.dqm, viewGroup, false);
                aVar = new a(this);
                aVar.rJv = (ImageView) view.findViewById(R.h.cPK);
                aVar.ruR = (TextView) view.findViewById(R.h.cPJ);
                aVar.rJw = (TextView) view.findViewById(R.h.cPM);
                aVar.rJx = (TextView) view.findViewById(R.h.cPL);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            p pVar = (p) getItem(i);
            if (bg.mA(pVar.ofY)) {
                aVar.ruR.setVisibility(8);
            } else {
                aVar.ruR.setText(pVar.ofY);
                aVar.ruR.setVisibility(0);
            }
            if (bg.mA(pVar.ryw)) {
                aVar.rJw.setVisibility(8);
            } else {
                aVar.rJw.setText(pVar.ryw);
                aVar.rJw.setVisibility(0);
            }
            if (bg.mA(pVar.rxK)) {
                aVar.rJx.setVisibility(8);
            } else {
                aVar.rJx.setText(pVar.rxK);
                aVar.rJx.setVisibility(0);
            }
            String str = pVar.ryC;
            w.v("Micromsg.WalletInputCardIDUI", "bankType:" + pVar.ryB + ", logurl:" + str);
            aVar.rJv.setImageBitmap(null);
            if (!bg.mA(str)) {
                com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
                n.GX();
                aVar2.hJg = null;
                aVar2.hIO = e.hgu;
                aVar2.hIN = com.tencent.mm.plugin.wallet_core.c.b.CA(str);
                aVar2.hIL = true;
                aVar2.hJh = true;
                n.GW().a(str, aVar.rJv, aVar2.Hg());
            }
            return view;
        }
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI) {
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.uSU.uTo.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(R.i.dfE, null);
        textView.setText(walletBankcardIdUI.getString(R.l.feL));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(R.f.aXt);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        g.a(walletBankcardIdUI.uSU.uTo, walletBankcardIdUI.getString(R.l.feK), walletBankcardIdUI.getString(R.l.eOW), textView, new OnClickListener(walletBankcardIdUI) {
            final /* synthetic */ WalletBankcardIdUI rJt;

            {
                this.rJt = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(walletBankcardIdUI);
        if (ai != null) {
            ai.b(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
    }

    protected final int getLayoutId() {
        return R.i.dqg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.fgi);
        KC();
        com.tencent.mm.sdk.b.a.urY.b(this.rxp);
        com.tencent.mm.sdk.b.a.urY.b(this.rBh);
        this.hPi = this.uT.getInt("key_bind_scene");
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.rxp);
        com.tencent.mm.sdk.b.a.urY.c(this.rBh);
        super.onDestroy();
    }

    protected final void KC() {
        this.rxr = (Button) findViewById(R.h.cnY);
        this.rJn = (WalletFormView) findViewById(R.h.bxR);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rJn);
        this.rJo = (WalletFormView) findViewById(R.h.cmm);
        if (this.uT.getBoolean("key_bind_show_change_card", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.rJo);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.rJo);
        }
        this.rJn.wFY = this;
        this.rxr.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletBankcardIdUI rJt;

            {
                this.rJt = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11353, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                this.rJt.btn();
            }
        });
        com.tencent.mm.wallet_core.b ccE = ccE();
        if (ccE != null) {
            this.rJs = ccE.lHw.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.rJs = false;
        }
        if (this.rJs) {
            zi(R.l.fjp);
        } else {
            zi(R.l.fgi);
        }
        TextView textView = (TextView) findViewById(R.h.bXM);
        if (m.btS().buj() || m.btS().bun()) {
            f fVar = new f(this);
            fVar.rKS = new com.tencent.mm.plugin.wallet_core.ui.f.a(this) {
                final /* synthetic */ WalletBankcardIdUI rJt;

                {
                    this.rJt = r1;
                }

                public final void onClick(View view) {
                    w.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
                    WalletBankcardIdUI.a(this.rJt);
                }
            };
            String string = getString(R.l.fgg);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(fVar, string.length() - 6, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setVisibility(0);
            CharSequence string2 = this.uT.getString("key_custom_bind_tips");
            if (!bg.mA(string2)) {
                textView.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.uT.getParcelable("key_favor_pay_info");
        Orders orders = (Orders) this.uT.getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            a a = b.rJj.a(orders);
            TextView textView2 = (TextView) findViewById(R.h.cPX);
            if (a != null) {
                List Ih = a.Ih(a.Ik(favorPayInfo.rFm));
                if (Ih.size() > 0) {
                    this.rJq = new a(this.uSU.uTo, Ih);
                    textView2.setText(R.l.fge);
                    textView2.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletBankcardIdUI rJt;

                        {
                            this.rJt = r1;
                        }

                        public final void onClick(View view) {
                            this.rJt.showDialog(1);
                        }
                    });
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                w.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView2.setVisibility(8);
            }
        }
        af btS = m.btS();
        if (!btS.bum() || btS.akr() == null || bg.mA(btS.akr().trim()) || !btS.bur()) {
            this.rJo.setVisibility(8);
            this.rJn.setHint(getString(R.l.fgh));
        } else {
            this.rJo.setVisibility(0);
            this.rJo.setText(btS.akr());
            this.rJn.setHint(getString(R.l.feI));
            this.rJo.setClickable(false);
            this.rJo.setEnabled(false);
        }
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAm, null);
        if (!bg.mA(str)) {
            this.rJn.setHint(str);
        }
        this.rJp = (Bankcard) this.uT.getParcelable("key_history_bankcard");
        if (this.rJp != null) {
            this.rJn.setText(this.rJp.rEd);
            this.rJn.a(new TextWatcher(this) {
                final /* synthetic */ WalletBankcardIdUI rJt;

                {
                    this.rJt = r1;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (this.rJt.rJn.Pb() && !this.rJt.rJr) {
                        this.rJt.rJr = true;
                        this.rJt.rJn.aWw();
                    }
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
        }
        OX();
        com.tencent.mm.plugin.wallet_core.d.c.b(this, this.uT, 2);
        d(this.rJn, 0, false);
        this.rJn.j(new View.OnClickListener(this) {
            final /* synthetic */ WalletBankcardIdUI rJt;

            {
                this.rJt = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
                com.tencent.mm.wallet_core.ui.e.e(this.rJt, m.btS().akr());
            }
        });
        if (m.btS().buq().bug()) {
            this.rJn.oNt.setVisibility(0);
            this.rJn.oNt.setImageResource(R.k.dAE);
        }
    }

    protected final void btn() {
        if (ccE() == null) {
            w.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            return;
        }
        String string = ccE().lHw.getString("kreq_token");
        int i = this.uT.getInt("entry_scene", -1);
        if (this.rJp != null) {
            k kVar = new com.tencent.mm.plugin.wallet_core.b.k(bsF(), null, (PayInfo) this.uT.getParcelable("key_pay_info"), string, this.hPi, i);
            kVar.rBX = this.rJp.field_bankcardType;
            this.uT.putParcelable("key_history_bankcard", this.rJp);
            k(kVar);
        } else if (OX()) {
            k(new com.tencent.mm.plugin.wallet_core.b.k(bsF(), this.rJn.getText(), (PayInfo) this.uT.getParcelable("key_pay_info"), string, this.hPi, i));
        } else {
            g.h(this, R.l.fgL, R.l.dIO);
        }
    }

    protected Dialog onCreateDialog(int i) {
        if (i == 1) {
            View inflate = getLayoutInflater().inflate(R.i.dqH, null);
            ((ListView) inflate.findViewById(R.h.bnw)).setAdapter(this.rJq);
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
            aVar.zW(R.l.fgd);
            aVar.dd(inflate);
            aVar.d(null);
            aVar.zZ(R.l.esq);
            return aVar.WJ();
        } else if (!this.rJs || i != 1000) {
            return super.onCreateDialog(i);
        } else {
            int b;
            String string = getString(R.l.fgf);
            com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
            if (ai != null) {
                b = ai.b(this, 1);
            } else {
                b = -1;
            }
            if (b != -1) {
                string = getString(b);
            }
            return g.a(this, true, string, "", getString(R.l.dJe), getString(R.l.dHQ), new OnClickListener(this) {
                final /* synthetic */ WalletBankcardIdUI rJt;

                {
                    this.rJt = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((com.tencent.mm.plugin.wallet_core.id_verify.a) this.rJt.ccE()).c(this.rJt, 0);
                    this.rJt.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletBankcardIdUI rJt;

                {
                    this.rJt = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    View findFocus = this.rJt.uSU.ipu == null ? null : this.rJt.uSU.ipu.findFocus();
                    if (findFocus != null && (findFocus instanceof EditText)) {
                        this.rJt.aHj();
                    }
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        w.d("Micromsg.WalletInputCardIDUI", " errCode: " + i2 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k) {
                com.tencent.mm.plugin.wallet_core.b.k kVar2 = (com.tencent.mm.plugin.wallet_core.b.k) kVar;
                bundle.putBoolean("key_need_area", kVar2.btu());
                bundle.putBoolean("key_need_profession", kVar2.btv());
                bundle.putParcelableArray("key_profession_list", kVar2.rCb);
                if (kVar2.rBW == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.rJn.getText());
                    com.tencent.mm.wallet_core.a.k(this, bundle);
                } else if (kVar2.rBW.rEQ && kVar2.rBW.isError()) {
                    g.h(this, R.l.fdN, R.l.dIO);
                    return true;
                } else {
                    bundle.putString("bank_name", kVar2.rBW.mMa);
                    bundle.putParcelable("elemt_query", kVar2.rBW);
                    bundle.putString("key_card_id", this.rJn.getText());
                    com.tencent.mm.wallet_core.a.k(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.rJn.getText());
            com.tencent.mm.wallet_core.a.k(this, bundle);
            return true;
        }
        return false;
    }

    private boolean OX() {
        if (this.rJn.dF(null)) {
            this.rxr.setEnabled(true);
            this.rxr.setClickable(true);
            return true;
        }
        this.rxr.setEnabled(false);
        this.rxr.setClickable(false);
        return false;
    }

    public final void gA(boolean z) {
        if (!z) {
            this.rJp = null;
            this.uT.putParcelable("key_history_bankcard", null);
        }
        OX();
    }

    protected final boolean bsP() {
        return true;
    }

    protected final int Ol() {
        return 1;
    }
}
