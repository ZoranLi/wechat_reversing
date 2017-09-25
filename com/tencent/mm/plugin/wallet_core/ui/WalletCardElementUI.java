package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nl;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.y.k;
import com.tenpay.android.jni.Encrypt;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI extends WalletBaseUI implements OnEditorActionListener, a {
    private String countryCode;
    private String hnO;
    private String hnP;
    private String nhX;
    private String nhY;
    private Orders oSJ = null;
    private TextView qFk;
    private c rBh = new c<nl>(this) {
        final /* synthetic */ WalletCardElementUI rKh;

        {
            this.rKh = r2;
            this.usg = nl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nl nlVar = (nl) bVar;
            if (nlVar instanceof nl) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletCardElementUI.a(this.rKh, encrypt.desedeEncode(nlVar.fUB.cardId, randomKey), randomKey, nlVar.fUB.fUC);
                return true;
            }
            w.f("MicroMsg.WalletCardElmentUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    private WalletFormView rBm;
    private TextView rBn;
    private TextView rBo;
    private int rBq = 1;
    private ElementQuery rCX = new ElementQuery();
    private Profession rCY;
    private Profession[] rCb;
    private TextView rJA;
    private TextView rJB;
    private TextView rJC;
    private TextView rJD;
    private TextView rJE;
    private TextView rJF;
    private TextView rJG;
    private WalletFormView rJH;
    private WalletFormView rJI;
    private WalletFormView rJJ;
    private WalletFormView rJK;
    private WalletFormView rJL;
    private WalletFormView rJM;
    private WalletFormView rJN;
    private WalletFormView rJO;
    private WalletFormView rJP;
    private WalletFormView rJQ;
    private WalletFormView rJR;
    private WalletFormView rJS;
    private WalletFormView rJT;
    private WalletFormView rJU;
    private ScrollView rJV;
    private WalletFormView rJW = null;
    private WalletFormView rJX;
    private Map<String, a.a> rJY = null;
    private boolean rJZ = false;
    private WalletFormView rJo;
    private Bankcard rJp = null;
    private TextView rJz;
    private CheckBox rKa;
    private CheckBox rKb;
    private String rKc;
    private boolean rKd;
    private boolean rKe;
    private BaseAdapter rKf = new BaseAdapter(this) {
        final /* synthetic */ WalletCardElementUI rKh;

        {
            this.rKh = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return vB(i);
        }

        public final int getCount() {
            return this.rKh.rCX.btI() != null ? this.rKh.rCX.btI().size() : 0;
        }

        private Integer vB(int i) {
            return (Integer) this.rKh.rCX.btI().get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.rKh, R.i.dqI, null);
            checkedTextView.setText(m.bua().I(this.rKh, vB(i).intValue()));
            if (this.rKh.rBq == vB(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    };
    private OnClickListener rKg = new OnClickListener(this) {
        final /* synthetic */ WalletCardElementUI rKh;

        {
            this.rKh = r1;
        }

        public final void onClick(View view) {
            g.oUh.i(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
            e.e(this.rKh, m.btS().akr());
        }
    };
    private Button rxr;
    private Authen ryN = new Authen();
    a rzJ = null;
    private PayInfo rze = null;

    static /* synthetic */ void a(WalletCardElementUI walletCardElementUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putString("key_bankcard_des", str2);
        bundle.putString("key_bankcard_id", str);
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(walletCardElementUI);
        if (ai != null) {
            ai.a((Activity) walletCardElementUI, WalletConfirmCardIDUI.class, bundle, 3);
        }
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = getLayoutInflater().inflate(R.i.dqH, null);
                ListView listView = (ListView) inflate.findViewById(R.h.bnw);
                listView.setAdapter(this.rKf);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletCardElementUI rKh;

                    {
                        this.rKh = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.rKh.dismissDialog(1);
                        int intValue = ((Integer) this.rKh.rCX.btI().get(i)).intValue();
                        if (this.rKh.rBq != intValue) {
                            this.rKh.rBq = intValue;
                            this.rKh.rJK.setText(((CheckedTextView) view).getText().toString());
                            WalletCardElementUI.a(this.rKh.rBm, this.rKh.rBq);
                            this.rKh.rBm.aWw();
                            this.rKh.ar();
                            this.rKh.vA(this.rKh.rBq);
                        }
                    }
                });
                h.a aVar = new h.a(this);
                aVar.zW(R.l.feo);
                aVar.dd(inflate);
                aVar.d(null);
                return aVar.WJ();
            default:
                return com.tencent.mm.ui.base.g.b(this, getString(R.l.feo), "", true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rCX = (ElementQuery) this.uT.getParcelable("elemt_query");
        this.oSJ = (Orders) this.uT.getParcelable("key_orders");
        this.rze = (PayInfo) this.uT.getParcelable("key_pay_info");
        this.rBq = m.btS().bus();
        this.rJp = (Bankcard) this.uT.getParcelable("key_history_bankcard");
        this.rKd = this.uT.getBoolean("key_need_area", false);
        if (this.rKd || this.rKe) {
            zi(R.l.ffy);
        } else {
            zi(R.l.ffx);
        }
        if (this.rze == null) {
            this.rze = new PayInfo();
        }
        w.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.rze);
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.uT.getParcelable("key_favor_pay_info");
        if (!(this.oSJ == null || favorPayInfo == null)) {
            this.rzJ = b.rJj.a(this.oSJ);
            if (this.rzJ != null) {
                this.rJY = this.rzJ.Ig(this.rzJ.Ik(favorPayInfo.rFm));
            } else {
                w.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        KC();
        this.rJV.pageScroll(33);
        com.tencent.mm.plugin.wallet_core.d.c.b(this, this.uT, 3);
        com.tencent.mm.sdk.b.a.urY.b(this.rBh);
    }

    protected final void KC() {
        this.rJz = (TextView) findViewById(R.h.cQa);
        this.rJX = (WalletFormView) findViewById(R.h.cPY);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rJX);
        this.rJA = (TextView) findViewById(R.h.cPZ);
        this.rBn = (TextView) findViewById(R.h.cQc);
        this.rJo = (WalletFormView) findViewById(R.h.cmm);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.rJo);
        this.rJL = (WalletFormView) findViewById(R.h.ckq);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.rJL);
        this.rJK = (WalletFormView) findViewById(R.h.cQp);
        this.rBm = (WalletFormView) findViewById(R.h.bWA);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.rBm);
        this.rBo = (TextView) findViewById(R.h.cQb);
        this.rJB = (TextView) findViewById(R.h.cPS);
        this.rJH = (WalletFormView) findViewById(R.h.cQg);
        this.rJC = (TextView) findViewById(R.h.cPT);
        this.rJG = (TextView) findViewById(R.h.cPW);
        this.rJD = (TextView) findViewById(R.h.cPV);
        this.rJJ = (WalletFormView) findViewById(R.h.bHB);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.rJJ);
        this.rJI = (WalletFormView) findViewById(R.h.bHJ);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.rJI);
        this.rJE = (TextView) findViewById(R.h.cPU);
        this.qFk = (TextView) findViewById(R.h.cPQ);
        this.rJO = (WalletFormView) findViewById(R.h.bQe);
        this.rJP = (WalletFormView) findViewById(R.h.cav);
        this.rJQ = (WalletFormView) findViewById(R.h.bql);
        this.rJR = (WalletFormView) findViewById(R.h.bnA);
        this.rJS = (WalletFormView) findViewById(R.h.cru);
        this.rJT = (WalletFormView) findViewById(R.h.csk);
        this.rJU = (WalletFormView) findViewById(R.h.bKS);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.rJU);
        this.rJF = (TextView) findViewById(R.h.cPP);
        this.rKa = (CheckBox) findViewById(R.h.bob);
        this.rKb = (CheckBox) findViewById(R.h.bnX);
        this.rxr = (Button) findViewById(R.h.cnY);
        this.rJV = (ScrollView) findViewById(R.h.cRI);
        this.rJM = (WalletFormView) findViewById(R.h.csw);
        this.rJN = (WalletFormView) findViewById(R.h.csv);
        this.rJo.wFY = this;
        this.rJX.wFY = this;
        this.rJK.wFY = this;
        this.rBm.wFY = this;
        this.rJL.wFY = new a(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void gA(boolean z) {
                if (!z) {
                    this.rKh.rJp = null;
                    this.rKh.uT.putParcelable("key_history_bankcard", null);
                }
                this.rKh.OX();
            }
        };
        this.rJJ.wFY = this;
        this.rJI.wFY = this;
        this.rJO.wFY = this;
        this.rJP.wFY = this;
        this.rJQ.wFY = this;
        this.rJR.wFY = this;
        this.rJS.wFY = this;
        this.rJT.wFY = this;
        this.rJU.wFY = this;
        this.rJM.wFY = this;
        this.rJN.wFY = this;
        this.rJo.setOnEditorActionListener(this);
        this.rJX.setOnEditorActionListener(this);
        this.rJK.setOnEditorActionListener(this);
        this.rBm.setOnEditorActionListener(this);
        this.rJL.setOnEditorActionListener(this);
        this.rJJ.setOnEditorActionListener(this);
        this.rJI.setOnEditorActionListener(this);
        this.rJO.setOnEditorActionListener(this);
        this.rJP.setOnEditorActionListener(this);
        this.rJQ.setOnEditorActionListener(this);
        this.rJR.setOnEditorActionListener(this);
        this.rJS.setOnEditorActionListener(this);
        this.rJT.setOnEditorActionListener(this);
        this.rJU.setOnEditorActionListener(this);
        this.rJN.setOnEditorActionListener(this);
        this.rJM.setOnEditorActionListener(this);
        this.rJH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", this.rKh.uT.getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", this.rKh.uT.getInt("key_bind_scene", -1));
                if (!bg.mA(this.rKh.rJH.getText())) {
                    bundle.putString("key_bank_type", this.rKh.rCX.ofd);
                    bundle.putInt("key_bankcard_type", this.rKh.rCX.rES);
                }
                com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this.rKh);
                if (ai != null) {
                    ai.a(this.rKh, WalletCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.rJK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onClick(View view) {
                this.rKh.showDialog(1);
            }
        });
        this.rJN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onClick(View view) {
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
                if (!Bankcard.vw(this.rKh.rCX.rBY)) {
                    putExtra.putExtra("IsRealNameVerifyScene", true);
                    putExtra.putExtra("IsNeedShowSearchBar", true);
                }
                this.rKh.startActivityForResult(putExtra, 4);
            }
        });
        this.rJM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.rKh.uSU.uTo, WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", this.rKh.rCb);
                this.rKh.startActivityForResult(intent, 5);
            }
        });
        this.rKa.setChecked(true);
        this.rKa.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.rKh.OX();
            }
        });
        findViewById(R.h.bnV).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onClick(View view) {
                e.a(this.rKh, this.rKh.rCX.ofd, this.rKh.rCX.mMa, false, this.rKh.rCX.rFk);
            }
        });
        this.rJQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onClick(View view) {
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
                if (Bankcard.vw(this.rKh.rCX.rBY)) {
                    putExtra.putExtra("IsAutoPosition", false);
                } else {
                    putExtra.putExtra("IsRealNameVerifyScene", true);
                    putExtra.putExtra("IsNeedShowSearchBar", true);
                }
                this.rKh.startActivityForResult(putExtra, 2);
            }
        });
        this.rxr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI rKh;

            {
                this.rKh = r1;
            }

            public final void onClick(View view) {
                this.rKh.buP();
            }
        });
        d(this.rJX, 0, false);
        d(this.rBm, 1, false);
        d(this.rJL, 0, false);
        if (this.rCX != null && !bg.mA(this.rCX.rEY)) {
            com.tencent.mm.ui.base.g.a(this, this.rCX.rEY, null, true, null);
            this.rCX = null;
        } else if (this.uT.getInt("key_bind_scene", -1) == 5 && !this.rCX.rFl) {
            com.tencent.mm.ui.base.g.a(this, getString(R.l.flm), null, true, null);
            this.rCX.mMa = null;
        }
        ar();
        OX();
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        if (ai != null && ai.cbS()) {
            Orders orders = (Orders) this.uT.getParcelable("key_orders");
            if (orders == null || orders.rFO != 1) {
                this.rJZ = false;
                return;
            }
            this.rJZ = true;
            this.rJo.setText(e.UJ(orders.rDD));
            this.rJo.setEnabled(false);
            this.rJo.setFocusable(false);
            this.rBq = orders.rFQ;
            this.rJK.setText(m.bua().I(this, this.rBq));
            this.rJK.setEnabled(false);
            this.rBm.setText(orders.rFP);
            this.rBm.setEnabled(false);
            this.rBm.setFocusable(false);
            this.rBn.setText(R.l.fei);
            this.rJL.ccO();
        }
    }

    private void ar() {
        if (this.rCX == null) {
            this.rCX = new ElementQuery();
        }
        if (this.rCX == null || this.rJY == null || !this.rJY.containsKey(this.rCX.ofd)) {
            this.rJG.setVisibility(8);
        } else {
            double d;
            a.a aVar = (a.a) this.rJY.get(this.rCX.ofd);
            if (aVar == null || aVar.rJg == null) {
                d = 0.0d;
            } else {
                d = aVar.rJh;
            }
            this.rJG.setText(getString(R.l.fej, new Object[]{e.o(d)}));
            this.rJG.setVisibility(0);
        }
        com.tencent.mm.wallet_core.a.ai(this);
        Bankcard bankcard = (Bankcard) this.uT.getParcelable("key_bankcard");
        if (!buQ() || bankcard == null) {
            if (bg.mA(this.rCX.mMa)) {
                this.rJH.setText("");
            } else if (!bg.mA(this.rCX.rET)) {
                this.rJH.setText(this.rCX.mMa + " " + this.rCX.rET);
            } else if (2 == this.rCX.rES) {
                this.rJH.setText(this.rCX.mMa + " " + getString(R.l.ffh));
            } else {
                this.rJH.setText(this.rCX.mMa + " " + getString(R.l.ffv));
            }
            a(new boolean[]{false}, new WalletFormView[]{this.rJX}, this.rJz, this.rJA, true);
            a(new boolean[]{true}, new WalletFormView[]{this.rJH}, this.rJB, this.rJC, true);
            this.rJX.j(this.rKg);
            if (m.btS().buq().bug()) {
                this.rJX.oNt.setImageResource(R.k.dAE);
                this.rJX.oNt.setVisibility(0);
            } else {
                this.rJX.oNt.setVisibility(4);
            }
        } else {
            this.rJX.setHint(getString(R.l.few, new Object[]{bankcard.field_bankcardTail}));
            a(new boolean[]{true}, new WalletFormView[]{this.rJX}, this.rJz, this.rJA);
            a(new boolean[]{false}, new WalletFormView[]{this.rJH}, this.rJB, this.rJC);
        }
        if (Bankcard.vw(this.rCX.rBY)) {
            a(new boolean[]{false, false, false}, new WalletFormView[]{this.rJo, this.rJK, this.rBm}, this.rBn, this.rBo);
            this.rJL.setVisibility(8);
            iC(true);
            this.rJN.setVisibility(8);
            this.rJM.setVisibility(8);
            findViewById(R.h.cQe).setVisibility(8);
        } else {
            boolean z = this.rCX.btI() != null && this.rCX.btI().size() > 0;
            if (buQ() || m.btS().buj()) {
                if (bg.mA(m.btS().akr())) {
                    this.rJo.setHint(getString(R.l.feN));
                } else {
                    this.rJo.setHint(getString(R.l.feO, new Object[]{e.UJ(m.btS().akr())}));
                }
                a(new boolean[]{true, z, true}, new WalletFormView[]{this.rJo, this.rJK, this.rBm}, this.rBn, this.rBo);
                this.rJL.setVisibility(0);
            } else {
                boolean[] zArr = new boolean[3];
                zArr[0] = this.rCX.rEL;
                if (z && this.rCX.rEM) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[1] = z;
                zArr[2] = this.rCX.rEM;
                a(zArr, new WalletFormView[]{this.rJo, this.rJK, this.rBm}, this.rBn, this.rBo);
                this.rJL.setVisibility(0);
                w.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.rCX.rEL + " canModifyIdentity:" + this.rCX.rEM);
            }
            if (this.rJp != null) {
                if (!bg.mA(this.rJp.field_mobile)) {
                    a(this.rJL, this.rJp.field_mobile);
                }
                if (!bg.mA(this.rJp.rDH)) {
                    a(this.rJJ, this.rJp.rDH);
                }
                if (!bg.mA(this.rJp.rEe)) {
                    a(this.rJI, this.rJp.rEe);
                }
            }
            if (this.rCX.rEL) {
                this.rBo.setText("");
            } else {
                this.rBo.setText(getString(R.l.fez));
            }
            if (!buQ() || m.btS().bus() <= 0) {
                if (this.rKf.getCount() <= 1) {
                    this.rJK.setClickable(false);
                    this.rJK.setEnabled(false);
                } else {
                    this.rJK.setClickable(true);
                    this.rJK.setEnabled(true);
                }
                List btI = this.rCX.btI();
                if (btI == null || !btI.contains(Integer.valueOf(this.rBq))) {
                    this.rBq = 1;
                }
                this.rJK.setText(m.bua().I(this, this.rBq));
            } else {
                this.rJK.setClickable(false);
                this.rJK.setText(m.bua().I(this, m.btS().bus()));
                this.rJK.setEnabled(false);
                a(this.rBm, this.rBq);
            }
            vA(this.rBq);
            iC(false);
            if (this.rKd) {
                this.rJN.setVisibility(0);
            } else {
                this.rJN.setVisibility(8);
            }
            this.rJM.setVisibility(8);
            if (this.rKd || this.rKe) {
                findViewById(R.h.cQe).setVisibility(0);
            } else {
                findViewById(R.h.cQe).setVisibility(8);
            }
        }
        a(new boolean[]{this.rCX.rEN, this.rCX.rEO}, new WalletFormView[]{this.rJJ, this.rJI}, this.rJD, this.rJE);
        if (this.rJH.getVisibility() == 0) {
            switch (this.rCX.rER) {
                case 1:
                    this.rJC.setVisibility(8);
                    break;
                case 2:
                    this.rJC.setVisibility(8);
                    break;
                case 3:
                    this.rJC.setText(R.l.fem);
                    this.rJC.setVisibility(0);
                    break;
                case 4:
                    this.rJC.setVisibility(8);
                    break;
                default:
                    this.rJC.setVisibility(8);
                    break;
            }
            this.rJC.setTextColor(getResources().getColor(R.e.aVl));
        } else {
            this.rJC.setVisibility(8);
        }
        if (bg.mA(this.rCX.rEW) || !o.eU(this.rCX.rEW) || buQ()) {
            this.rKb.setVisibility(8);
            return;
        }
        this.rKb.setText(this.rCX.rEX);
        this.rKb.setVisibility(0);
    }

    private static void a(WalletFormView walletFormView, String str) {
        if (bg.mA(str)) {
            walletFormView.setVisibility(8);
            return;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
    }

    private void iC(boolean z) {
        int i = 0;
        if (z) {
            int i2;
            this.qFk.setVisibility(this.rCX.rEZ ? 0 : 8);
            WalletFormView walletFormView = this.rJO;
            if (this.rCX.rEZ) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.rJP;
            if (this.rCX.rFa) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.rJQ;
            if (this.rCX.rFb) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.rJR;
            if (this.rCX.rFe) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.rJS;
            if (this.rCX.rFg) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.rJT;
            if (this.rCX.rFf) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            WalletFormView walletFormView2 = this.rJU;
            if (!this.rCX.rFh) {
                i = 8;
            }
            walletFormView2.setVisibility(i);
            this.rJF.setVisibility(4);
            return;
        }
        this.qFk.setVisibility(8);
        this.rJO.setVisibility(8);
        this.rJP.setVisibility(8);
        this.rJQ.setVisibility(8);
        this.rJR.setVisibility(8);
        this.rJS.setVisibility(8);
        this.rJT.setVisibility(8);
        this.rJU.setVisibility(8);
        this.rJF.setVisibility(8);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        int length = zArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                i = 1;
                walletFormViewArr[i2].setVisibility(0);
            } else {
                walletFormViewArr[i2].setVisibility(8);
            }
        }
        if (i != 0) {
            textView.setVisibility(0);
            if (textView2 == null) {
                return;
            }
            if (z) {
                textView2.setVisibility(8);
                return;
            } else {
                textView2.setVisibility(4);
                return;
            }
        }
        textView.setVisibility(8);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        a(zArr, walletFormViewArr, textView, textView2, false);
    }

    private void buP() {
        if (OX()) {
            String text;
            com.tencent.mm.plugin.wallet_core.d.c.bvt();
            if (!bg.mA(this.rCX.rEW)) {
                Bundle bundle = this.uT;
                String str = "key_is_follow_bank_username";
                boolean z = this.rKb.getVisibility() == 0 && this.rKb.isChecked();
                bundle.putBoolean(str, z);
                this.uT.putString("key_bank_username", this.rCX.rEW);
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) this.uT.getParcelable("key_favor_pay_info");
            if (!(this.rCX == null || favorPayInfo == null || this.rzJ == null || this.rJY == null)) {
                if (this.rJY.containsKey(this.rCX.ofd)) {
                    favorPayInfo.rFm = ((a.a) this.rJY.get(this.rCX.ofd)).rJg.ryd;
                } else {
                    favorPayInfo.rFm = this.rzJ.av(favorPayInfo.rFm, false);
                }
                this.uT.putParcelable("key_favor_pay_info", favorPayInfo);
            }
            this.ryN = new Authen();
            if (this.rJp != null) {
                this.ryN.ofe = this.rJp.rEf;
                this.ryN.rDJ = this.rJp.field_bankcardTail;
            }
            String string = this.uT.getString("key_card_id");
            if (this.rJX.getVisibility() == 0) {
                text = this.rJX.getText();
            } else {
                text = string;
            }
            this.ryN.oLz = (PayInfo) this.uT.getParcelable("key_pay_info");
            this.ryN.rDG = text;
            this.ryN.ofd = this.rCX.ofd;
            this.ryN.rDF = this.rBq;
            this.ryN.rDC = this.uT.getString("key_pwd1");
            if (!bg.mA(this.rJJ.getText())) {
                this.ryN.rDH = this.rJJ.getText();
            }
            this.ryN.rBT = this.rJL.getText();
            this.ryN.rDL = this.rJO.getText();
            this.ryN.rDM = this.rJP.getText();
            this.ryN.country = this.rKc;
            this.ryN.gkB = this.nhX;
            this.ryN.gkC = this.nhY;
            this.ryN.hCE = this.rJR.getText();
            this.ryN.mMc = this.rJS.getText();
            this.ryN.itg = this.rJT.getText();
            this.ryN.gku = this.rJU.getText();
            text = e.UK(this.ryN.rBT);
            this.uT.putString("key_mobile", text);
            this.uT.putBoolean("key_is_oversea", this.rCX.rBY == 2);
            this.ryN.rDE = this.rBm.getText();
            this.ryN.rDD = this.rJo.getText();
            this.ryN.rDI = this.rJI.getText();
            favorPayInfo = (FavorPayInfo) this.uT.getParcelable("key_favor_pay_info");
            if (favorPayInfo != null) {
                this.ryN.rDN = favorPayInfo.rFp;
                this.ryN.rDO = favorPayInfo.rFm;
            }
            w.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.ryN.oLz + " elemt.bankcardTag : " + this.rCX.rBY);
            w.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.rCX.rBY);
            Bundle bundle2 = this.uT;
            bundle2.putString("key_mobile", text);
            bundle2.putParcelable("key_authen", this.ryN);
            bundle2.putString("key_bank_phone", this.rCX.rEV);
            bundle2.putString("key_country_code", this.countryCode);
            bundle2.putString("key_province_code", this.hnP);
            bundle2.putString("key_city_code", this.hnO);
            bundle2.putParcelable("key_profession", this.rCY);
            if (ccF().j(this.ryN, this.oSJ)) {
                w.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                w.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.uT;
        w.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.rze);
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.m)) {
            return false;
        }
        w.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.k(this, bundle);
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dqn;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String stringExtra;
            String stringExtra2;
            String stringExtra3;
            switch (i) {
                case 1:
                    this.rCX = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    this.rJp = null;
                    ar();
                    break;
                case 2:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("Country");
                    this.rKc = stringExtra + "|" + stringExtra2;
                    stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bg.mA(intent.getStringExtra("Contact_City"))) {
                        this.nhX = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.nhY = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        this.rJQ.setText(stringExtra + " " + stringExtra4);
                    } else if (bg.mA(intent.getStringExtra("Contact_Province"))) {
                        this.nhY = this.rKc;
                        this.rJQ.setText(stringExtra);
                    } else {
                        this.nhY = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.rJQ.setText(stringExtra + " " + stringExtra3);
                    }
                    if ("US".equals(stringExtra2) || "CA".equals(stringExtra2) || this.rCX.rFf) {
                        this.rJT.setVisibility(0);
                    } else {
                        this.rJT.setVisibility(8);
                    }
                    w.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[]{stringExtra, stringExtra2, stringExtra3, stringExtra4, this.nhY});
                    break;
                case 3:
                    this.rJX.UR(intent.getStringExtra("key_bankcard_id"));
                    break;
                case 4:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("ProviceName");
                    stringExtra3 = intent.getStringExtra("CityName");
                    this.countryCode = intent.getStringExtra("Country");
                    this.hnP = intent.getStringExtra("Contact_Province");
                    this.hnO = intent.getStringExtra("Contact_City");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!bg.mA(stringExtra)) {
                        stringBuilder.append(stringExtra);
                    }
                    if (!bg.mA(stringExtra2)) {
                        stringBuilder.append(" ").append(stringExtra2);
                    }
                    if (!bg.mA(stringExtra3)) {
                        stringBuilder.append(" ").append(stringExtra3);
                    }
                    this.rJN.setText(stringBuilder.toString());
                    break;
                case 5:
                    this.rCY = (Profession) intent.getParcelableExtra("key_select_profession");
                    this.rJM.setText(this.rCY.rDp);
                    break;
            }
            OX();
        }
    }

    private boolean OX() {
        boolean z;
        boolean z2;
        WalletFormView walletFormView = this.rJW;
        this.rJW = null;
        if (this.rJH.dF(null)) {
            z = true;
        } else {
            if (this.rJW == null && walletFormView != this.rJH) {
                this.rJW = this.rJH;
            }
            this.rJC.setText(R.l.fek);
            this.rJC.setTextColor(getResources().getColor(R.e.aVD));
            z = false;
        }
        if (!this.rJo.dF(null)) {
            if (this.rJW == null && walletFormView != this.rJo) {
                this.rJW = this.rJo;
            }
            z = false;
        }
        if (!this.rJX.dF(this.rJA)) {
            if (this.rJW == null && walletFormView != this.rJX) {
                this.rJW = this.rJX;
            }
            z = false;
        }
        if (this.rBm.dF(this.rBo) || this.rJZ) {
            z2 = z;
            z = false;
        } else {
            if (this.rJW == null && walletFormView != this.rBm) {
                this.rJW = this.rBm;
            }
            this.rBo.setText(R.l.cQb);
            this.rBo.setTextColor(getResources().getColor(R.e.aVD));
            z = true;
            z2 = false;
        }
        if (!this.rJL.dF(this.rBo)) {
            if (z) {
                this.rBo.setText(R.l.fet);
                this.rBo.setTextColor(getResources().getColor(R.e.aVD));
            } else {
                this.rBo.setText(R.l.feu);
                this.rBo.setTextColor(getResources().getColor(R.e.aVD));
            }
            if (this.rJW == null && walletFormView != this.rJL) {
                this.rJW = this.rJL;
            }
            z2 = false;
        } else if (z) {
            this.rBo.setVisibility(0);
        }
        if (this.rBo.getVisibility() == 4) {
            if (this.rCX.rEL) {
                this.rBo.setText(getString(R.l.fex));
            } else {
                this.rBo.setText(getString(R.l.fez));
            }
            this.rBo.setTextColor(getResources().getColor(R.e.aUo));
            this.rBo.setVisibility(0);
        }
        if (this.rJJ.dF(this.rJE)) {
            z = false;
        } else {
            if (this.rJW == null && walletFormView != this.rJJ) {
                this.rJW = this.rJJ;
            }
            z = true;
            z2 = false;
        }
        if (!this.rJI.dF(this.rJE)) {
            if (this.rJW == null && walletFormView != this.rJI) {
                this.rJW = this.rJI;
            }
            z2 = false;
        } else if (z) {
            this.rJE.setVisibility(4);
        }
        if (!this.rKa.isChecked()) {
            z2 = false;
        }
        if (!this.rJO.dF(this.rJF)) {
            if (this.rJW == null && walletFormView != this.rJO) {
                this.rJW = this.rJO;
            }
            z2 = false;
        }
        if (!this.rJP.dF(this.rJF)) {
            if (this.rJW == null && walletFormView != this.rJP) {
                this.rJW = this.rJP;
            }
            z2 = false;
        }
        if (!this.rJQ.dF(this.rJF)) {
            if (this.rJW == null && walletFormView != this.rJQ) {
                this.rJW = this.rJQ;
            }
            z2 = false;
        }
        if (!this.rJR.dF(this.rJF)) {
            if (this.rJW == null && walletFormView != this.rJR) {
                this.rJW = this.rJR;
            }
            z2 = false;
        }
        if (!this.rJS.dF(this.rJF)) {
            if (this.rJW == null && walletFormView != this.rJS) {
                this.rJW = this.rJS;
            }
            z2 = false;
        }
        if (!this.rJT.dF(this.rJF)) {
            if (this.rJW == null && walletFormView != this.rJT) {
                this.rJW = this.rJT;
            }
            z2 = false;
        }
        if (!this.rJU.dF(this.rJF)) {
            if (this.rJW == null && walletFormView != this.rJU) {
                this.rJW = this.rJU;
            }
            z2 = false;
        }
        if (this.rKe && !this.rJM.dF(null)) {
            if (this.rJW == null && walletFormView != this.rJM) {
                this.rJW = this.rJM;
            }
            z2 = false;
        }
        if (this.rKd && !this.rJN.dF(null)) {
            if (this.rJW == null && walletFormView != this.rJN) {
                this.rJW = this.rJN;
            }
            z2 = false;
        }
        if (z2) {
            this.rxr.setEnabled(true);
            this.rxr.setClickable(true);
            if (walletFormView != null) {
                walletFormView.setImeOptions(1073741824);
            }
        } else {
            this.rxr.setEnabled(false);
            this.rxr.setClickable(false);
        }
        return z2;
    }

    public final void gA(boolean z) {
        OX();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        w.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.rJW != null) {
                    WalletFormView walletFormView = this.rJW;
                    if (walletFormView.wFX != null ? walletFormView.wFX.isFocusable() : false) {
                        walletFormView = this.rJW;
                        if (walletFormView.wFX != null) {
                            z = walletFormView.wFX.isClickable();
                        }
                        if (z && this.rJW.ccM()) {
                            this.rJW.ccO();
                        }
                    }
                    this.rJW.performClick();
                } else {
                    buP();
                }
                return true;
            default:
                if (this.rJW != null) {
                    return false;
                }
                buP();
                return false;
        }
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.rBh);
        super.onDestroy();
    }

    private static void a(WalletFormView walletFormView, int i) {
        com.tencent.mm.wallet_core.ui.formview.a.b bVar = walletFormView.wGa;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).CN(i);
        }
    }

    private void vA(int i) {
        if (i == 1) {
            d(this.rBm, 1, false);
        } else {
            d(this.rBm, 1, true);
        }
    }

    protected final int Ol() {
        return 1;
    }

    private boolean buQ() {
        return this.uT.getBoolean("key_is_forgot_process", false);
    }
}
