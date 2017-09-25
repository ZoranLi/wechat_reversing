package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class WalletCardImportUI extends WalletBaseUI implements OnEditorActionListener, a {
    private static final String[] rKi = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private ae mHandler = new ae();
    private String nhX;
    private String nhY;
    private Dialog oL = null;
    private Orders oSJ = null;
    private WalletFormView rBm;
    private int rBq = 1;
    private ElementQuery rCX = new ElementQuery();
    private WalletFormView rJH;
    private WalletFormView rJI;
    private WalletFormView rJJ;
    private WalletFormView rJK;
    private WalletFormView rJL;
    private WalletFormView rJO;
    private WalletFormView rJP;
    private WalletFormView rJQ;
    private WalletFormView rJR;
    private WalletFormView rJS;
    private WalletFormView rJT;
    private WalletFormView rJU;
    private WalletFormView rJW = null;
    private WalletFormView rJX;
    private WalletFormView rJo;
    private CheckBox rKb;
    private String rKc;
    private TextView rKj;
    private MMScrollView rKk;
    private Bankcard rKl = null;
    private CheckBox rKm;
    private BaseAdapter rKn = new BaseAdapter(this) {
        final /* synthetic */ WalletCardImportUI rKo;

        {
            this.rKo = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return vB(i);
        }

        public final int getCount() {
            return this.rKo.rCX.btI() != null ? this.rKo.rCX.btI().size() : 0;
        }

        private Integer vB(int i) {
            return (Integer) this.rKo.rCX.btI().get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.rKo, R.i.dqI, null);
            checkedTextView.setText(m.bua().I(this.rKo, vB(i).intValue()));
            if (this.rKo.rBq == vB(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            checkedTextView.setBackgroundResource(R.g.beo);
            return checkedTextView;
        }
    };
    private Button rxr;
    private Authen ryN = new Authen();
    private PayInfo rze = null;

    static /* synthetic */ void c(WalletFormView walletFormView, int i) {
        b bVar = walletFormView.wGa;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).CN(i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ffx);
        this.rCX = (ElementQuery) this.uT.getParcelable("elemt_query");
        this.oSJ = (Orders) this.uT.getParcelable("key_orders");
        this.rze = (PayInfo) this.uT.getParcelable("key_pay_info");
        this.rKl = (Bankcard) this.uT.getParcelable("key_import_bankcard");
        if (this.rze == null) {
            this.rze = new PayInfo();
        }
        w.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.rze);
        KC();
        this.rKk.pageScroll(33);
        c.b(this, this.uT, 3);
    }

    protected final void KC() {
        this.rJX = (WalletFormView) findViewById(R.h.cPY);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rJX);
        this.rJL = (WalletFormView) findViewById(R.h.ckq);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.rJL);
        this.rJo = (WalletFormView) findViewById(R.h.cmm);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.rJo);
        this.rJK = (WalletFormView) findViewById(R.h.cQp);
        this.rBm = (WalletFormView) findViewById(R.h.bWA);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.rBm);
        this.rJH = (WalletFormView) findViewById(R.h.cQg);
        this.rJJ = (WalletFormView) findViewById(R.h.bHB);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.rJJ);
        this.rJI = (WalletFormView) findViewById(R.h.bHJ);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.rJI);
        this.rKj = (TextView) findViewById(R.h.cRx);
        this.rJO = (WalletFormView) findViewById(R.h.bQe);
        this.rJP = (WalletFormView) findViewById(R.h.cav);
        this.rJQ = (WalletFormView) findViewById(R.h.bql);
        this.rJR = (WalletFormView) findViewById(R.h.bnA);
        this.rJS = (WalletFormView) findViewById(R.h.cru);
        this.rJT = (WalletFormView) findViewById(R.h.csk);
        this.rJU = (WalletFormView) findViewById(R.h.bKS);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.rJU);
        this.rKm = (CheckBox) findViewById(R.h.bob);
        this.rKb = (CheckBox) findViewById(R.h.bnX);
        this.rxr = (Button) findViewById(R.h.cnY);
        this.rKk = (MMScrollView) findViewById(R.h.cRI);
        Object obj = this.rKk;
        obj.a(obj, obj);
        this.rKk.wFl = new MMScrollView.a(this) {
            final /* synthetic */ WalletCardImportUI rKo;

            {
                this.rKo = r1;
            }

            public final void iD(boolean z) {
                final int i = z ? 8 : 0;
                w.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : " + z);
                this.rKo.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 rKq;

                    public final void run() {
                        if (i != this.rKq.rKo.rKj.getVisibility()) {
                            this.rKq.rKo.rKj.setVisibility(i);
                        }
                    }
                });
            }
        };
        this.rJo.wFY = this;
        this.rJX.wFY = this;
        this.rJK.wFY = this;
        this.rBm.wFY = this;
        this.rJL.wFY = this;
        this.rJJ.wFY = this;
        this.rJI.wFY = this;
        this.rJO.wFY = this;
        this.rJP.wFY = this;
        this.rJQ.wFY = this;
        this.rJR.wFY = this;
        this.rJS.wFY = this;
        this.rJT.wFY = this;
        this.rJU.wFY = this;
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
        this.rJH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI rKo;

            {
                this.rKo = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", this.rKo.uT.getInt("key_support_bankcard", 3));
                bundle.putString("key_bank_type", this.rKo.rCX.ofd);
                bundle.putInt("key_bankcard_type", this.rKo.rCX.rES);
                com.tencent.mm.wallet_core.a.ai(this.rKo).a(this.rKo, WalletCardSelectUI.class, bundle, 1);
            }
        });
        this.rJK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI rKo;

            {
                this.rKo = r1;
            }

            public final void onClick(View view) {
                this.rKo.showDialog(1);
            }
        });
        this.rKm.setChecked(true);
        this.rKm.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletCardImportUI rKo;

            {
                this.rKo = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.rKo.OX();
            }
        });
        this.rKb.setChecked(true);
        findViewById(R.h.bnV).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI rKo;

            {
                this.rKo = r1;
            }

            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.rKo.getString(R.l.fef));
                linkedList2.add(Integer.valueOf(0));
                if (this.rKo.rCX != null && this.rKo.rCX.rFk) {
                    linkedList.add(this.rKo.getString(R.l.fee));
                    linkedList2.add(Integer.valueOf(1));
                }
                g.a(this.rKo, "", linkedList, linkedList2, "", new d(this) {
                    final /* synthetic */ AnonymousClass5 rKr;

                    {
                        this.rKr = r1;
                    }

                    public final void bN(int i, int i2) {
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", this.rKr.rKo.getString(R.l.fda, new Object[]{v.bIN()}));
                                break;
                            case 1:
                                if (this.rKr.rKo.rCX != null) {
                                    intent.putExtra("rawUrl", this.rKr.rKo.getString(R.l.fcZ, new Object[]{v.bIN(), this.rKr.rKo.rCX.ofd}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bb.d.b(this.rKr.rKo.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
        });
        this.rJQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI rKo;

            {
                this.rKo = r1;
            }

            public final void onClick(View view) {
                this.rKo.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
            }
        });
        this.rxr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI rKo;

            {
                this.rKo = r1;
            }

            public final void onClick(View view) {
                this.rKo.buP();
            }
        });
        ar();
        OX();
    }

    private void ar() {
        WalletFormView walletFormView = null;
        if (this.rKl != null) {
            WalletFormView walletFormView2;
            findViewById(R.h.cQf).setVisibility(0);
            if (bg.mA(this.uT.getString("key_bank_username"))) {
                this.rKb.setVisibility(8);
            } else {
                CharSequence string = this.uT.getString("key_recommand_desc");
                if (bg.mA(string)) {
                    this.rKb.setText(getString(R.l.fev, new Object[]{this.rKl.field_bankName}));
                } else {
                    this.rKb.setText(string);
                }
                this.rKb.setVisibility(0);
            }
            this.rJO.setVisibility(8);
            this.rJP.setVisibility(8);
            this.rJQ.setVisibility(8);
            this.rJR.setVisibility(8);
            this.rJS.setVisibility(8);
            this.rJT.setVisibility(8);
            this.rJU.setVisibility(8);
            if (bg.mA(this.rKl.field_bankcardTail) || !b(this.rJX, this.rKl.rEd)) {
                this.rJX.setVisibility(8);
                walletFormView2 = null;
            } else {
                walletFormView2 = this.rJX;
                walletFormView = this.rJX;
            }
            String string2;
            if (this.rKl.btC()) {
                string2 = getString(R.l.ffh);
            } else {
                string2 = getString(R.l.ffv);
            }
            if (bg.mA(this.rKl.field_bankName) || !b(this.rJH, this.rKl.field_bankName + " " + r2)) {
                this.rJH.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.rJH;
                }
                walletFormView = this.rJH;
            }
            if (b(this.rJo, this.rKl.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.rJo;
                }
                walletFormView = this.rJo;
            }
            if (b(this.rJK, m.bua().I(this.uSU.uTo, this.rKl.rDF))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.rJK;
                }
                walletFormView = this.rJK;
            }
            if (b(this.rBm, this.rKl.rEc)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.rBm;
                }
                walletFormView = this.rBm;
            }
            if (b(this.rJL, this.rKl.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.rJL;
                }
                walletFormView = this.rJL;
            }
            if (b(this.rJJ, this.rKl.rDH)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.rJJ;
                }
                walletFormView = this.rJJ;
            }
            if (b(this.rJI, this.rKl.rEe)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.rJI;
                }
                walletFormView = this.rJI;
            }
            walletFormView2.setBackgroundResource(R.g.beo);
            walletFormView.setBackgroundResource(R.g.beo);
            if (m.btS().buj()) {
                this.rxr.setText(R.l.feC);
            } else {
                this.rxr.setText(R.l.feA);
            }
        }
    }

    private static boolean b(WalletFormView walletFormView, String str) {
        if (bg.mA(str)) {
            walletFormView.setVisibility(8);
            return false;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        return true;
    }

    private void buP() {
        if (OX()) {
            c.bvt();
            this.ryN = new Authen();
            this.uT.putBoolean("key_is_follow_bank_username", this.rKb.isChecked());
            if (this.rKl == null || bg.mA(this.rKl.rEn)) {
                String text;
                boolean z;
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
                this.uT.putString("key_mobile", e.UK(this.ryN.rBT));
                Bundle bundle = this.uT;
                String str = "key_is_oversea";
                if (this.rCX.rBY == 2) {
                    z = true;
                } else {
                    z = false;
                }
                bundle.putBoolean(str, z);
                this.ryN.rDE = this.rBm.getText();
                this.ryN.rDD = this.rJo.getText();
                this.ryN.rDI = this.rJI.getText();
                w.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.ryN.oLz + " elemt.bankcardTag : " + this.rCX.rBY);
            } else {
                this.ryN.rws = this.rKl.rEn;
                this.ryN.ofe = this.rKl.field_bindSerial;
                this.ryN.ofd = this.rKl.field_bankcardType;
                this.ryN.rDF = this.rKl.rDF;
                this.ryN.rDC = this.uT.getString("key_pwd1");
                this.ryN.token = this.uT.getString("kreq_token");
            }
            com.tencent.mm.wallet_core.a.ai(this);
            if (ccF().j(this.ryN, this.oSJ)) {
                w.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                w.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.uT;
        w.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.rze);
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.m)) {
            return false;
        }
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, bundle);
        g.bl(this, getString(R.l.fdO));
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dqo;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.rCX = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    ar();
                    break;
                case 2:
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("Country");
                    this.rKc = stringExtra + "|" + stringExtra2;
                    String stringExtra3 = intent.getStringExtra("ProviceName");
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
                    if (!"US".equals(stringExtra2) && !"CA".equals(stringExtra2) && !this.rCX.rFf) {
                        this.rJT.setVisibility(8);
                        break;
                    } else {
                        this.rJT.setVisibility(0);
                        break;
                    }
                    break;
            }
            OX();
        }
    }

    private boolean OX() {
        boolean z;
        if (this.rKm.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.rxr.setEnabled(true);
            this.rxr.setClickable(true);
        } else {
            this.rxr.setEnabled(false);
            this.rxr.setClickable(false);
        }
        return z;
    }

    public final void gA(boolean z) {
        OX();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        w.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.rJW == null) {
                    buP();
                } else if (this.rJW.isEnabled() && !this.rJW.isClickable() && this.rJW.ccM()) {
                    this.rJW.ccO();
                } else {
                    this.rJW.performClick();
                }
                return true;
            default:
                if (this.rJW == null) {
                    buP();
                }
                return false;
        }
    }

    public void onDestroy() {
        if (this.oL != null && this.oL.isShowing()) {
            this.oL.dismiss();
            this.oL = null;
        }
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                Dialog iVar = new i(this, R.m.foF);
                iVar.setContentView(R.i.dqH);
                ListView listView = (ListView) iVar.findViewById(R.h.bnw);
                listView.setAdapter(this.rKn);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletCardImportUI rKo;

                    {
                        this.rKo = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.rKo.dismissDialog(1);
                        int intValue = ((Integer) this.rKo.rCX.btI().get(i)).intValue();
                        if (this.rKo.rBq != intValue) {
                            this.rKo.rBq = intValue;
                            this.rKo.rJK.setText(((CheckedTextView) view).getText().toString());
                            WalletCardImportUI.c(this.rKo.rBm, this.rKo.rBq);
                            this.rKo.rBm.aWw();
                            this.rKo.ar();
                        }
                    }
                });
                return iVar;
            default:
                return super.onCreateDialog(i);
        }
    }
}
