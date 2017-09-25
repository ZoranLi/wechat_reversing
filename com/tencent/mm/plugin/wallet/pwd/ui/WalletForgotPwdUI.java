package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nl;
import com.tencent.mm.e.a.rt;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.b.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.jni.Encrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private ListView iuu;
    private List<ElementQuery> rAZ = new LinkedList();
    private Bankcard rBa;
    private a rBb;
    private LinearLayout rBc;
    private WalletFormView rBd;
    private WalletFormView rBe;
    private int rBf = 1;
    private boolean rBg = false;
    c rBh = new c<nl>(this) {
        final /* synthetic */ WalletForgotPwdUI rBi;

        {
            this.rBi = r2;
            this.usg = nl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nl nlVar = (nl) bVar;
            if (nlVar instanceof nl) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletForgotPwdUI.a(this.rBi, encrypt.desedeEncode(nlVar.fUB.cardId, randomKey), randomKey, nlVar.fUB.fUC);
                return true;
            }
            w.f("MicroMsg.WalletForgotPwdUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    private ArrayList<Bankcard> rwS = new ArrayList();
    c rxp = new c<rt>(this) {
        final /* synthetic */ WalletForgotPwdUI rBi;

        {
            this.rBi = r2;
            this.usg = rt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.rBi.finish();
            return false;
        }
    };
    private Button rxr;

    public class a extends BaseAdapter {
        private Context context;
        List<Bankcard> hoO = new ArrayList();
        final /* synthetic */ WalletForgotPwdUI rBi;

        public final /* synthetic */ Object getItem(int i) {
            return vs(i);
        }

        public a(WalletForgotPwdUI walletForgotPwdUI, Context context) {
            this.rBi = walletForgotPwdUI;
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = (WalletFormView) View.inflate(this.context, R.i.dqb, null);
            } else {
                WalletFormView walletFormView = (WalletFormView) view;
            }
            final Bankcard vs = vs(i);
            if (vs != null) {
                view.setText(((Bankcard) this.hoO.get(i)).field_desc);
            }
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a rBj;

                public final void onClick(View view) {
                    this.rBj.rBi.rBa = vs;
                    this.rBj.rBi.rBg = false;
                    this.rBj.rBi.btn();
                }
            });
            return view;
        }

        public final int getCount() {
            return this.hoO.size();
        }

        private Bankcard vs(int i) {
            if (i < 0 || i > this.hoO.size() - 1) {
                return null;
            }
            return (Bankcard) this.hoO.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(walletForgotPwdUI);
        if (ai != null) {
            ai.a((Activity) walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
    }

    static /* synthetic */ void c(WalletForgotPwdUI walletForgotPwdUI) {
        if (!"1".equals(m.btO().buL().field_reset_passwd_flag)) {
            w.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
        } else if (bg.mA(m.btO().buL().field_find_passwd_url)) {
            w.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(R.h.bRa)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(R.h.btu)).setOnClickListener(new OnClickListener(walletForgotPwdUI) {
                final /* synthetic */ WalletForgotPwdUI rBi;

                {
                    this.rBi = r1;
                }

                public final void onClick(View view) {
                    this.rBi.rBg = true;
                    this.rBi.btn();
                }
            });
        } else {
            w.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(R.h.bRb)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(R.h.bRc);
            f fVar = new f(walletForgotPwdUI);
            fVar.rKS = new com.tencent.mm.plugin.wallet_core.ui.f.a(walletForgotPwdUI) {
                final /* synthetic */ WalletForgotPwdUI rBi;

                {
                    this.rBi = r1;
                }

                public final void onClick(View view) {
                    this.rBi.rBg = true;
                    this.rBi.btn();
                }
            };
            String string = walletForgotPwdUI.getString(R.l.fhB);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(fVar, string.length() - 12, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.fhT);
        if (!this.uT.getBoolean("key_is_force_bind", false)) {
            k(new com.tencent.mm.plugin.wallet_core.b.m(null, 6));
            re(4);
        }
        KC();
        com.tencent.mm.sdk.b.a.urY.b(this.rBh);
        com.tencent.mm.sdk.b.a.urY.b(this.rxp);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.rBh);
        com.tencent.mm.sdk.b.a.urY.c(this.rxp);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        update();
    }

    private void update() {
        o.bsC();
        this.rwS = o.bsD().buw();
        if (this.rwS == null || this.rwS.size() == 0 || this.uT.getBoolean("key_is_force_bind", false)) {
            w.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[]{Boolean.valueOf(this.uT.getBoolean("key_is_force_bind", false))});
            this.rwS = new ArrayList();
            this.rBc.setVisibility(0);
            this.iuu.setVisibility(8);
            zi(R.l.ffx);
            ((TextView) findViewById(R.h.cQC)).setText(getString(R.l.fhD));
            WalletFormView walletFormView = this.rBe;
            o.bsC();
            walletFormView.setText(e.UL(o.bsD().akr()));
            return;
        }
        w.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
        if (com.tencent.mm.wallet_core.a.ai(this) != null) {
            q(new k());
        }
        this.rBc.setVisibility(8);
        this.rxr.setVisibility(8);
        findViewById(R.h.cli).setVisibility(0);
        this.rBb = new a(this, this);
        this.iuu.setAdapter(this.rBb);
        this.rBb.hoO = this.rwS;
        this.rBb.notifyDataSetChanged();
    }

    public void KC() {
        this.iuu = (ListView) findViewById(R.h.cDq);
        this.rBc = (LinearLayout) findViewById(R.h.bQZ);
        this.rBe = (WalletFormView) findViewById(R.h.cmm);
        this.rBd = (WalletFormView) findViewById(R.h.bwS);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rBd);
        if (this.uT.getBoolean("key_is_paymanager", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.rBe);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.rBe);
        }
        this.rBe.wFY = this;
        this.rBd.wFY = this;
        this.rxr = (Button) findViewById(R.h.cnY);
        this.rxr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletForgotPwdUI rBi;

            {
                this.rBi = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(11353, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                this.rBi.btn();
            }
        });
        this.rBg = false;
        o.bsC();
        this.rwS = o.bsD().buw();
        update();
        findViewById(R.h.cli).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletForgotPwdUI rBi;

            {
                this.rBi = r1;
            }

            public final void onClick(View view) {
                e.m(this.rBi, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
            }
        });
        OX();
        a(this.rBd, 0, false, false);
        this.rBd.j(new OnClickListener(this) {
            final /* synthetic */ WalletForgotPwdUI rBi;

            {
                this.rBi = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
                MMActivity mMActivity = this.rBi;
                o.bsC();
                e.e(mMActivity, o.bsD().akr());
            }
        });
        this.rBd.oNt.setImageResource(R.k.dAE);
        this.rBd.oNt.setVisibility(0);
    }

    private void btm() {
        this.uT.remove("elemt_query");
        this.uT.remove("key_bankcard");
        this.uT.remove("bank_name");
        this.uT.remove("key_card_id");
    }

    private void btn() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", this.uT.getBoolean("key_is_reset_with_new_card", false));
        btm();
        if (this.rBa == null && !this.rBg) {
            k(new k(null, this.rBd.getText(), null));
        } else if (this.rBg) {
            ae buL = m.btO().buL();
            if (bg.mA(buL.field_find_passwd_url)) {
                bundle.putBoolean("key_is_force_bind", true);
                bundle.putBoolean("key_is_reset_with_new_card", true);
                if (ccE() != null) {
                    ccE().a((Activity) this, 0, bundle);
                    return;
                }
                return;
            }
            w.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
            e.m(this, buL.field_find_passwd_url, false);
        } else {
            com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
            bundle.putParcelable("key_bankcard", this.rBa);
            ElementQuery elementQuery = new ElementQuery();
            for (Parcelable parcelable : this.rAZ) {
                w.i("MicroMsg.WalletForgotPwdUI", "helios:::" + parcelable.ofd);
                if (!bg.mA(parcelable.ofd) && !bg.mA(this.rBa.field_bankcardType) && parcelable.ofd.trim().equals(this.rBa.field_bankcardType.trim())) {
                    break;
                }
            }
            Object obj = elementQuery;
            bundle.putParcelable("elemt_query", parcelable);
            if (ai != null) {
                ai.a((Activity) this, 0, bundle);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dqC;
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[]{Integer.valueOf(i2), str, kVar});
        if (i == 0 && i2 == 0) {
            String str2;
            if (kVar instanceof k) {
                k kVar2 = (k) kVar;
                Bundle bundle = new Bundle();
                if (bg.mA(kVar2.kcJ)) {
                    this.rAZ = kVar2.rBV;
                    w.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
                    return true;
                } else if (kVar2.rBW != null) {
                    if (kVar2.rBW.isError()) {
                        w.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
                        com.tencent.mm.ui.base.g.h(this, R.l.fdN, R.l.dIO);
                        return true;
                    }
                    int i3;
                    str2 = "MicroMsg.WalletForgotPwdUI";
                    String str3 = "scene case 3 bankcards size %d";
                    Object[] objArr = new Object[1];
                    if (this.rwS == null) {
                        i3 = 0;
                    } else {
                        i3 = this.rwS.size();
                    }
                    objArr[0] = Integer.valueOf(i3);
                    w.i(str2, str3, objArr);
                    if (this.rwS == null || this.rwS.size() == 0) {
                        btm();
                        bundle.putString("bank_name", kVar2.rBW.mMa);
                        bundle.putParcelable("elemt_query", kVar2.rBW);
                        bundle.putString("key_card_id", this.rBd.getText());
                        com.tencent.mm.wallet_core.a.k(this, bundle);
                        return true;
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) {
                String str4 = "MicroMsg.WalletForgotPwdUI";
                str2 = "scene case queryBound adapter is null ? %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(this.rBb == null);
                w.i(str4, str2, objArr2);
                if (this.rBb != null) {
                    ArrayList arrayList = null;
                    if (m.btS() != null) {
                        arrayList = m.btS().buw();
                    }
                    com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
                    if (ai != null) {
                        ai.cbP();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Bankcard bankcard = (Bankcard) it.next();
                            if (bankcard.field_bankcardTag == 1) {
                                arrayList2.add(bankcard);
                            } else if (bankcard.field_bankcardTag == 2) {
                                arrayList3.add(bankcard);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.rwS = arrayList2;
                        } else {
                            this.rwS = arrayList3;
                        }
                    }
                    str4 = "MicroMsg.WalletForgotPwdUI";
                    str2 = "scene case queryBound adapter update bankcardsize:  %d";
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(this.rwS == null ? 0 : this.rwS.size());
                    w.i(str4, str2, objArr3);
                    this.rBb.hoO = this.rwS;
                    new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ WalletForgotPwdUI rBi;

                        {
                            this.rBi = r1;
                        }

                        public final void run() {
                            this.rBi.rBb.notifyDataSetChanged();
                            WalletForgotPwdUI.c(this.rBi);
                        }
                    });
                }
            }
        }
        return false;
    }

    public final boolean aJc() {
        return true;
    }

    private boolean OX() {
        if (this.iuu.getVisibility() == 0 || (this.rBe.Pb() && this.rBd.Pb())) {
            this.rxr.setEnabled(true);
            this.rxr.setClickable(true);
            return true;
        }
        this.rxr.setEnabled(false);
        this.rxr.setClickable(false);
        return false;
    }

    public final void gA(boolean z) {
        OX();
    }

    protected boolean bsP() {
        return true;
    }

    protected final int Ol() {
        return 1;
    }

    public final boolean aIY() {
        if ((this.rwS == null || this.rwS.size() == 0) && !bg.mA(m.btO().buL().field_find_passwd_url)) {
            return true;
        }
        return false;
    }

    protected final boolean aJb() {
        re(aIY() ? 4 : 0);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && 1 == i) {
            this.rBd.UR(intent.getStringExtra("key_bankcard_id"));
            btn();
        }
    }
}
