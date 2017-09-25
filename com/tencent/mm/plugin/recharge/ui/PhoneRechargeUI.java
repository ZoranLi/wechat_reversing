package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.plugin.recharge.model.f;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI extends MMActivity implements a, e {
    private String desc = "";
    private int errCode = 0;
    private String fPf = "";
    protected Dialog ita = null;
    private String ivH = "";
    private View oLZ = null;
    private ArrayList<m> oLp = null;
    private ArrayList<m> oLq = null;
    private d oLr = null;
    private d oLs = null;
    private d oLt = null;
    private d oLu = null;
    private d oLv = null;
    private ImageView oMa = null;
    private TextView oMb = null;
    private MallFormView oMc = null;
    private TextView oMd = null;
    private TextView oMe = null;
    private GridView oMf = null;
    private GridView oMg = null;
    private TextView oMh = null;
    private TextView oMi = null;
    private TextView oMj = null;
    private TextView oMk = null;
    private TextView oMl = null;
    private TextView oMm = null;
    private b oMn = null;
    private b oMo = null;
    private MallFunction oMp = null;
    private String oMq = "";
    private int oMr;
    private String oMs = "";
    private String oMt = "";
    private b oMu = null;
    private l oMv = null;
    private boolean oMw = false;
    private List<String[]> oMx;
    private boolean oqT = false;
    private c oqW = new c<rz>(this) {
        final /* synthetic */ PhoneRechargeUI oMy;

        {
            this.oMy = r2;
            this.usg = rz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rz rzVar = (rz) bVar;
            if (rzVar instanceof rz) {
                if (rzVar.fZv.result != -1) {
                    w.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                } else if (!this.oMy.oqT) {
                    w.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.aWd().a(new com.tencent.mm.plugin.recharge.model.a(this.oMy.oMc.getText(), this.oMy.oMu.oLG != null ? bg.mz(this.oMy.oMu.oLG.name) : "", 0));
                    this.oMy.finish();
                    this.oMy.oqT = true;
                }
                return true;
            }
            w.f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
            return false;
        }
    };

    static /* synthetic */ void Dm(String str) {
        w.i("MicroMsg.PhoneRechargeUI", "do scene: %s", new Object[]{str});
        ap.vd().a(new f(str), 0);
    }

    static /* synthetic */ com.tencent.mm.plugin.recharge.model.a a(PhoneRechargeUI phoneRechargeUI, String str) {
        w.i("MicroMsg.PhoneRechargeUI", "handle phone number: %s", new Object[]{str});
        com.tencent.mm.plugin.recharge.model.a aWf = com.tencent.mm.plugin.recharge.a.a.aWf();
        if (aWf == null || !str.equals(aWf.oKT)) {
            if (phoneRechargeUI.oMx == null || phoneRechargeUI.oMx.isEmpty()) {
                phoneRechargeUI.oMx = com.tencent.mm.pluginsdk.a.dn(phoneRechargeUI.uSU.uTo);
            }
            com.tencent.mm.plugin.recharge.model.a aVar;
            if (phoneRechargeUI.oMx == null || phoneRechargeUI.oMx.isEmpty()) {
                List<com.tencent.mm.plugin.recharge.model.a> aWe = com.tencent.mm.plugin.recharge.a.a.aWd().aWe();
                if (aWe.isEmpty()) {
                    aWf = new com.tencent.mm.plugin.recharge.model.a(str, "", 0);
                    aWf.oKV = com.tencent.mm.plugin.recharge.model.a.oKR;
                    w.i("MicroMsg.PhoneRechargeUI", "empty history");
                    return aWf;
                }
                for (com.tencent.mm.plugin.recharge.model.a aWf2 : aWe) {
                    if (aWf2.oKT.equals(str)) {
                        aVar = new com.tencent.mm.plugin.recharge.model.a(str, aWf2.name, aWf2.oKU, 2);
                        aVar.oKV = com.tencent.mm.plugin.recharge.model.a.oKR;
                        w.i("MicroMsg.PhoneRechargeUI", "find in history");
                        return aVar;
                    }
                }
                aWf2 = new com.tencent.mm.plugin.recharge.model.a(str, phoneRechargeUI.getString(R.l.fjE), 0);
                aWf2.oKV = com.tencent.mm.plugin.recharge.model.a.oKR;
                w.i("MicroMsg.PhoneRechargeUI", "not find in history");
                return aWf2;
            }
            for (String[] strArr : phoneRechargeUI.oMx) {
                String Di = com.tencent.mm.plugin.recharge.model.b.Di(strArr[2]);
                if (str.equals(Di)) {
                    aVar = new com.tencent.mm.plugin.recharge.model.a(Di, strArr[1], 1);
                    aVar.oKV = com.tencent.mm.plugin.recharge.model.a.oKR;
                    w.i("MicroMsg.PhoneRechargeUI", "find in address number");
                    return aVar;
                }
            }
            aWf2 = new com.tencent.mm.plugin.recharge.model.a(str, "", 1);
            aWf2.oKV = com.tencent.mm.plugin.recharge.model.a.oKR;
            w.i("MicroMsg.PhoneRechargeUI", "not in address");
            return aWf2;
        }
        w.i("MicroMsg.PhoneRechargeUI", "find bind mobile");
        return aWf2;
    }

    static /* synthetic */ boolean b(PhoneRechargeUI phoneRechargeUI, final String str) {
        if (phoneRechargeUI.oMu.oLG == null) {
            return true;
        }
        String string;
        com.tencent.mm.plugin.recharge.model.a aVar = phoneRechargeUI.oMu.oLG;
        String text = phoneRechargeUI.oMc.getText();
        if (aVar.fFq == 1 && bg.mA(aVar.name)) {
            string = phoneRechargeUI.getString(R.l.eAl, new Object[]{phoneRechargeUI.oMc.getText(), phoneRechargeUI.getString(R.l.fjH)});
        } else if (aVar.fFq != 0) {
            string = null;
        } else if (bg.mA(aVar.oKU)) {
            string = phoneRechargeUI.getString(R.l.eAl, new Object[]{text, phoneRechargeUI.getString(R.l.fjE)});
        } else {
            string = phoneRechargeUI.getString(R.l.eAm, new Object[]{text});
        }
        if (bg.mA(string)) {
            return true;
        }
        g.a(phoneRechargeUI, string, "", phoneRechargeUI.getString(R.l.eAn), phoneRechargeUI.getString(R.l.dXi), new OnClickListener(phoneRechargeUI) {
            final /* synthetic */ PhoneRechargeUI oMy;

            public final void onClick(DialogInterface dialogInterface, int i) {
                PhoneRechargeUI.c(this.oMy, str);
            }
        }, null);
        return false;
    }

    static /* synthetic */ void c(PhoneRechargeUI phoneRechargeUI, String str) {
        phoneRechargeUI.m(new com.tencent.mm.plugin.recharge.model.g(phoneRechargeUI.ivH, phoneRechargeUI.oMp.oKW, str, "mobile=" + com.tencent.mm.plugin.recharge.model.b.Di(phoneRechargeUI.oMc.getText()) + "&markup=" + (phoneRechargeUI.oMu.oLG != null ? phoneRechargeUI.oMu.oLG.name : "")));
    }

    static /* synthetic */ void e(PhoneRechargeUI phoneRechargeUI, String str) {
        try {
            w.d("MicroMsg.PhoneRechargeUI", "url: %s", new Object[]{str});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            com.tencent.mm.bb.d.b(phoneRechargeUI, "webview", ".ui.tools.WebViewUI", intent);
        } catch (Exception e) {
            w.e("MicroMsg.PhoneRechargeUI", "hy: url decode failed: raw url: %s", new Object[]{str});
        }
    }

    static /* synthetic */ void g(PhoneRechargeUI phoneRechargeUI) {
        if (phoneRechargeUI.oMv != null) {
            ap.yY();
            String str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAr, "");
            Object valueOf = bg.mA(str) ? String.valueOf(phoneRechargeUI.oMv.id) : str + ";" + phoneRechargeUI.oMv.id;
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAr, valueOf);
            ap.yY();
            com.tencent.mm.u.c.vr().jY(true);
        }
    }

    private void aWk() {
        this.ivH = "";
        aWl();
        this.errCode = 0;
        this.fPf = "";
        this.desc = "";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(1571, this);
        ap.vd().a(498, this);
        this.oMp = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        if (this.oMp == null) {
            w.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            s.makeText(this, "function info is null", 1).show();
            finish();
        }
        aWl();
        qP(this.oMp.fXa);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oMy.aHf();
                this.oMy.finish();
                return true;
            }
        });
        this.oLv = new d();
        this.oLv.name = getString(R.l.fjC);
        this.oLv.url = getString(R.l.fjD);
        this.oLZ = findViewById(R.h.crz);
        this.oMa = (ImageView) findViewById(R.h.cnU);
        this.oMb = (TextView) findViewById(R.h.cnV);
        this.oMc = (MallFormView) findViewById(R.h.cwm);
        com.tencent.mm.plugin.recharge.ui.form.c.b(this.oMc);
        this.oMu = new b(this.oMc);
        b bVar = this.oMu;
        w.d(com.tencent.mm.plugin.recharge.ui.form.c.TAG, "hy: setMobileEditTv");
        MallFormView mallFormView = bVar.oNm;
        TextWatcher anonymousClass1 = new TextWatcher(bVar) {
            private int oLJ = 0;
            final /* synthetic */ b oNp;

            {
                this.oNp = r2;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                int selectionStart = this.oNp.oNm.oNs.getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    str = stringBuilder.toString();
                    length = str.length();
                    if (length > this.oLJ) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < this.oLJ && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.oLJ = length;
                }
                String str2 = str;
                int i4 = selectionStart;
                String str3 = str2;
                if (!charSequence2.equals(str3)) {
                    this.oNp.oNm.oNs.setText(str3);
                    if (i4 < this.oLJ) {
                        this.oNp.oNm.oNs.setSelection(i4);
                    } else {
                        this.oNp.oNm.oNs.setSelection(this.oLJ);
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        if (mallFormView.oNs != null) {
            mallFormView.oNs.addTextChangedListener(anonymousClass1);
        }
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) bVar.oNm.oNs;
        bVar.oLF = com.tencent.mm.pluginsdk.a.dn(bVar.oNm.getContext());
        bVar.oNn = new com.tencent.mm.plugin.recharge.ui.form.d(bVar.oNm, bVar.oLF);
        bVar.oNn.oOa = new com.tencent.mm.plugin.recharge.ui.form.d.d(bVar) {
            final /* synthetic */ b oNp;

            {
                this.oNp = r1;
            }
        };
        bVar.oNn.oOb = this;
        bVar.gB(true);
        instantAutoCompleteTextView.oNl = true;
        instantAutoCompleteTextView.setAdapter(bVar.oNn);
        instantAutoCompleteTextView.setOnItemClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass3(bVar, instantAutoCompleteTextView));
        bVar.oNm.setOnFocusChangeListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass4(bVar, instantAutoCompleteTextView));
        instantAutoCompleteTextView.setOnClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass5(bVar, instantAutoCompleteTextView));
        this.oMf = (GridView) findViewById(R.h.cwD);
        this.oMh = (TextView) findViewById(R.h.cwJ);
        this.oMi = (TextView) findViewById(R.h.cwK);
        this.oMj = (TextView) findViewById(R.h.cwl);
        this.oMk = (TextView) findViewById(R.h.cwz);
        this.oMd = (TextView) findViewById(R.h.cwF);
        this.oMe = (TextView) findViewById(R.h.cwH);
        this.oMg = (GridView) findViewById(R.h.cwn);
        this.oMl = (TextView) findViewById(R.h.cwE);
        this.oMm = (TextView) findViewById(R.h.cwG);
        this.oMc.oNv = new MallFormView.a(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final void gA(boolean z) {
                if (z) {
                    this.oMy.aHf();
                    final String Di = com.tencent.mm.plugin.recharge.model.b.Di(this.oMy.oMc.getText());
                    if (Di == null) {
                        w.e("MicroMsg.PhoneRechargeUI", "null phone, return");
                        return;
                    }
                    com.tencent.mm.sdk.f.e.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 oMC;

                        public final void run() {
                            long currentTimeMillis = System.currentTimeMillis();
                            final com.tencent.mm.plugin.recharge.model.a a = PhoneRechargeUI.a(this.oMC.oMy, Di);
                            w.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 oMD;

                                public final void run() {
                                    this.oMD.oMC.oMy.oMu.b(a);
                                    PhoneRechargeUI.Dm(Di);
                                }
                            });
                        }
                    }, "search_matched_mobile");
                    if (this.oMy.oMw) {
                        this.oMy.oMw = false;
                        return;
                    }
                    w.d("MicroMsg.PhoneRechargeUI", "clear focus");
                    this.oMy.oMw = true;
                    return;
                }
                this.oMy.oMc.oNu.setText("");
                this.oMy.oMc.oNu.setTextColor(this.oMy.getResources().getColor(R.e.aVo));
                this.oMy.aWk();
                this.oMy.p(false, false);
                if (bg.mA(this.oMy.oMc.getText())) {
                    ((AutoCompleteTextView) this.oMy.oMc.oNs).showDropDown();
                }
            }
        };
        this.oMc.oNt.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final void onClick(View view) {
                if (this.oMy.getPackageManager().checkPermission("android.permission.READ_CONTACTS", ab.getPackageName()) == 0) {
                    Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
                    if (bg.j(this.oMy, intent)) {
                        this.oMy.startActivityForResult(intent, 1);
                        return;
                    }
                    return;
                }
                g.b(this.oMy, this.oMy.getString(R.l.fjG), "", true);
            }
        });
        this.oMn = new b();
        this.oMn.oLV = new b.a(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final void a(m mVar) {
                if (mVar == null) {
                    w.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
                } else if (PhoneRechargeUI.b(this.oMy, mVar.id)) {
                    PhoneRechargeUI.c(this.oMy, mVar.id);
                }
            }
        };
        this.oMo = new b();
        this.oMo.oLV = new b.a(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final void a(m mVar) {
                if (!bg.mA(mVar.url)) {
                    PhoneRechargeUI.e(this.oMy, this.oMy.Dk(mVar.url));
                } else if (PhoneRechargeUI.b(this.oMy, mVar.id)) {
                    PhoneRechargeUI.c(this.oMy, mVar.id);
                } else {
                    w.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
                }
            }
        };
        this.oMf.setAdapter(this.oMn);
        this.oMg.setAdapter(this.oMo);
        this.oMa.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final void onClick(View view) {
                if (this.oMy.oMv != null) {
                    PhoneRechargeUI.g(this.oMy);
                } else {
                    w.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
                }
                this.oMy.oLZ.setVisibility(8);
            }
        });
        this.oMb.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final void onClick(View view) {
                if (this.oMy.oMv != null && !bg.mA(this.oMy.oMv.url)) {
                    com.tencent.mm.protocal.f.dJ(6, 1);
                    try {
                        PhoneRechargeUI.e(this.oMy, URLDecoder.decode(this.oMy.oMv.url, ProtocolPackage.ServerEncoding));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                    }
                }
            }
        });
        this.oMc.aWu();
        this.oMr = getResources().getColor(R.e.aVo);
        if (!(this.oMu.oLG == null || bg.mA(this.oMu.oLG.name))) {
            this.desc = this.oMu.oLG.name;
        }
        this.oMc.oNs.setHintTextColor(getResources().getColor(R.e.aVy));
        if (bg.mA(this.oMc.getText())) {
            m(new f(""));
        } else {
            m(new f(this.oMc.getText()));
        }
    }

    private String Dk(String str) {
        String str2;
        try {
            str2 = "";
            if (!(this.oMu == null || this.oMu.oLG == null || bg.mA(this.oMu.oLG.name))) {
                str2 = this.oMu.oLG.name;
            }
            if (str2.equals(getString(R.l.fjF))) {
                str2 = "WeChatAccountBindNumber";
            }
            CharSequence text = this.oMc.getText();
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.startsWith("http://") || str.startsWith("https://")) {
                w.i("MicroMsg.PhoneRechargeUI", "new url");
                if (str.indexOf("%7Bphone%7D") > 0) {
                    str = str.replace("%7Bphone%7D", text);
                } else {
                    str = str.replace("{phone}", text);
                }
                if (str.indexOf("%7Bremark%7D") > 0) {
                    return str.replace("%7Bremark%7D", encode);
                }
                return str.replace("{remark}", encode);
            }
            w.i("MicroMsg.PhoneRechargeUI", "old url");
            return URLDecoder.decode(str, ProtocolPackage.ServerEncoding) + String.format("?phone=%s&remark=%s", new Object[]{text, encode});
        } catch (Throwable e) {
            Throwable th = e;
            str2 = str;
            w.printErrStackTrace("MicroMsg.PhoneRechargeUI", th, "", new Object[0]);
            return str2;
        }
    }

    private void l(k kVar) {
        if (this.ita != null && this.ita.isShowing() && kVar.getType() != 497) {
            this.ita.dismiss();
            this.ita = null;
        }
    }

    private void m(final k kVar) {
        if (this.ita == null || !(this.ita == null || this.ita.isShowing())) {
            this.ita = com.tencent.mm.wallet_core.ui.g.a(this.uSU.uTo, true, new OnCancelListener(this) {
                final /* synthetic */ PhoneRechargeUI oMy;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(kVar);
                }
            });
        }
        ap.vd().a(kVar, 0);
    }

    protected void onResume() {
        super.onResume();
        p(false, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1571, this);
        ap.vd().b(498, this);
        com.tencent.mm.sdk.b.a.urY.c(this.oqW);
    }

    private void p(boolean z, boolean z2) {
        boolean z3;
        Iterator it;
        TextView textView;
        CharSequence string;
        MallFunction mallFunction;
        final String str;
        if (this.oMv != null) {
            if (this.oMv != null) {
                ap.yY();
                String str2 = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAr, "");
                if (bg.mA(str2)) {
                    w.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
                    z3 = false;
                } else {
                    String[] split = str2.split(";");
                    if (split != null) {
                        for (String str3 : split) {
                            if (str3 != null && str3.equals(String.valueOf(this.oMv.id))) {
                                w.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                                z3 = true;
                                break;
                            }
                        }
                    }
                    w.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
                    z3 = false;
                }
            } else {
                w.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
                z3 = true;
            }
            if (!z3) {
                this.oLZ.setVisibility(0);
                this.oMb.setText(this.oMv.name);
                w.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
                com.tencent.mm.protocal.f.dJ(6, 0);
                this.oMn.oLU = this.oLp;
                this.oMn.notifyDataSetChanged();
                this.oMo.oLU = this.oLq;
                this.oMo.notifyDataSetChanged();
                if (z) {
                    this.oMl.setVisibility(8);
                } else {
                    it = this.oLp.iterator();
                    while (it.hasNext()) {
                        if (((m) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.oMl.setVisibility(8);
                    } else {
                        this.oMl.setVisibility(0);
                    }
                    it = this.oLq.iterator();
                    while (it.hasNext()) {
                        if (((m) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.oMm.setVisibility(0);
                        if (z2) {
                            a(0, this.oLv.name, new OnMenuItemClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI oMy;

                                {
                                    this.oMy = r1;
                                }

                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    try {
                                        PhoneRechargeUI.e(this.oMy, URLDecoder.decode(this.oMy.oLv.url, ProtocolPackage.ServerEncoding));
                                    } catch (Throwable e) {
                                        w.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                                    }
                                    return false;
                                }
                            });
                        }
                        textView = this.oMd;
                        string = (this.oLp != null || this.oLp.size() <= 0 || bg.mA(((m) this.oLp.get(0)).ryh)) ? getString(R.l.fjA) : ((m) this.oLp.get(0)).ryh;
                        textView.setText(string);
                        textView = this.oMe;
                        string = (this.oLq != null || this.oLq.size() <= 0 || bg.mA(((m) this.oLq.get(0)).ryh)) ? getString(R.l.fjB) : ((m) this.oLq.get(0)).ryh;
                        textView.setText(string);
                        if (this.oLu != null || bg.mA(this.oLu.name) || bg.mA(this.oLu.url)) {
                            this.oMi.setVisibility(8);
                        } else {
                            this.oMi.setVisibility(0);
                            this.oMi.setText(this.oLu.name);
                            this.oMi.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI oMy;

                                {
                                    this.oMy = r1;
                                }

                                public final void onClick(View view) {
                                    w.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.oMy.Dk(this.oMy.oLu.url)});
                                    PhoneRechargeUI.e(this.oMy, r0);
                                }
                            });
                        }
                        if (this.oLr != null || bg.mA(this.oLr.name) || bg.mA(this.oLr.url)) {
                            this.oMh.setVisibility(8);
                        } else {
                            this.oMh.setVisibility(0);
                            this.oMh.setText(this.oLr.name);
                            this.oMh.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI oMy;

                                {
                                    this.oMy = r1;
                                }

                                public final void onClick(View view) {
                                    w.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.oMy.Dk(this.oMy.oLr.url)});
                                    PhoneRechargeUI.e(this.oMy, r0);
                                }
                            });
                        }
                        if (this.oLs != null || bg.mA(this.oLs.name) || bg.mA(this.oLs.url)) {
                            this.oMj.setVisibility(8);
                        } else {
                            this.oMj.setVisibility(0);
                            this.oMj.setText(this.oLs.name);
                            this.oMj.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI oMy;

                                {
                                    this.oMy = r1;
                                }

                                public final void onClick(View view) {
                                    w.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.oMy.Dk(this.oMy.oLs.url)});
                                    PhoneRechargeUI.e(this.oMy, r0);
                                }
                            });
                        }
                        if (this.oLt != null || bg.mA(this.oLt.name) || bg.mA(this.oLt.url)) {
                            this.oMk.setVisibility(8);
                        } else {
                            this.oMk.setVisibility(0);
                            this.oMk.setText(this.oLt.name);
                            this.oMk.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI oMy;

                                {
                                    this.oMy = r1;
                                }

                                public final void onClick(View view) {
                                    w.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.oMy.Dk(this.oMy.oLt.url)});
                                    PhoneRechargeUI.e(this.oMy, r0);
                                }
                            });
                        }
                        mallFunction = this.oMp;
                        if (mallFunction.rID == null && mallFunction.rID.rGH == 1 && !bg.mA(mallFunction.rID.rIS)) {
                            ap.yY();
                            z3 = !((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uDZ, Boolean.valueOf(false))).booleanValue();
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uDZ, Boolean.valueOf(true));
                            w.d("MicroMsg.PhoneRechargeUI", this.oMp.rID.toString());
                            str = this.oMp.rID.rIS;
                            g.a(this.uSU.uTo, getString(R.l.fjK), r.eC(this).inflate(R.i.dmm, null), getString(R.l.fjL), getString(R.l.fjJ), new OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI oMy;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.oMy.Dk(str)});
                                    PhoneRechargeUI.e(this.oMy, r0);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI oMy;

                                {
                                    this.oMy = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                    }
                }
                this.oMm.setVisibility(8);
                if (z2) {
                    a(0, this.oLv.name, /* anonymous class already generated */);
                }
                textView = this.oMd;
                if (this.oLp != null) {
                }
                textView.setText(string);
                textView = this.oMe;
                if (this.oLq != null) {
                }
                textView.setText(string);
                if (this.oLu != null) {
                }
                this.oMi.setVisibility(8);
                if (this.oLr != null) {
                }
                this.oMh.setVisibility(8);
                if (this.oLs != null) {
                }
                this.oMj.setVisibility(8);
                if (this.oLt != null) {
                }
                this.oMk.setVisibility(8);
                mallFunction = this.oMp;
                if (mallFunction.rID == null) {
                }
                z3 = false;
                if (!z3) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uDZ, Boolean.valueOf(true));
                    w.d("MicroMsg.PhoneRechargeUI", this.oMp.rID.toString());
                    str = this.oMp.rID.rIS;
                    g.a(this.uSU.uTo, getString(R.l.fjK), r.eC(this).inflate(R.i.dmm, null), getString(R.l.fjL), getString(R.l.fjJ), /* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
        }
        this.oLZ.setVisibility(8);
        w.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
        this.oMn.oLU = this.oLp;
        this.oMn.notifyDataSetChanged();
        this.oMo.oLU = this.oLq;
        this.oMo.notifyDataSetChanged();
        if (z) {
            it = this.oLp.iterator();
            while (it.hasNext()) {
                if (((m) it.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.oMl.setVisibility(8);
            } else {
                this.oMl.setVisibility(0);
            }
            it = this.oLq.iterator();
            while (it.hasNext()) {
                if (((m) it.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.oMm.setVisibility(0);
                if (z2) {
                    a(0, this.oLv.name, /* anonymous class already generated */);
                }
                textView = this.oMd;
                if (this.oLp != null) {
                }
                textView.setText(string);
                textView = this.oMe;
                if (this.oLq != null) {
                }
                textView.setText(string);
                if (this.oLu != null) {
                }
                this.oMi.setVisibility(8);
                if (this.oLr != null) {
                }
                this.oMh.setVisibility(8);
                if (this.oLs != null) {
                }
                this.oMj.setVisibility(8);
                if (this.oLt != null) {
                }
                this.oMk.setVisibility(8);
                mallFunction = this.oMp;
                if (mallFunction.rID == null) {
                }
                z3 = false;
                if (!z3) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uDZ, Boolean.valueOf(true));
                    w.d("MicroMsg.PhoneRechargeUI", this.oMp.rID.toString());
                    str = this.oMp.rID.rIS;
                    g.a(this.uSU.uTo, getString(R.l.fjK), r.eC(this).inflate(R.i.dmm, null), getString(R.l.fjL), getString(R.l.fjJ), /* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
        }
        this.oMl.setVisibility(8);
        this.oMm.setVisibility(8);
        if (z2) {
            a(0, this.oLv.name, /* anonymous class already generated */);
        }
        textView = this.oMd;
        if (this.oLp != null) {
        }
        textView.setText(string);
        textView = this.oMe;
        if (this.oLq != null) {
        }
        textView.setText(string);
        if (this.oLu != null) {
        }
        this.oMi.setVisibility(8);
        if (this.oLr != null) {
        }
        this.oMh.setVisibility(8);
        if (this.oLs != null) {
        }
        this.oMj.setVisibility(8);
        if (this.oLt != null) {
        }
        this.oMk.setVisibility(8);
        mallFunction = this.oMp;
        if (mallFunction.rID == null) {
        }
        z3 = false;
        if (!z3) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uDZ, Boolean.valueOf(true));
            w.d("MicroMsg.PhoneRechargeUI", this.oMp.rID.toString());
            str = this.oMp.rID.rIS;
            g.a(this.uSU.uTo, getString(R.l.fjK), r.eC(this).inflate(R.i.dmm, null), getString(R.l.fjL), getString(R.l.fjJ), /* anonymous class already generated */, /* anonymous class already generated */);
        }
    }

    private void aWl() {
        this.oLp = new ArrayList();
        m mVar = new m();
        mVar.name = getString(R.l.fjq);
        mVar.status = 0;
        m mVar2 = new m();
        mVar2.name = getString(R.l.fjr);
        mVar2.status = 0;
        m mVar3 = new m();
        mVar3.name = getString(R.l.fjs);
        mVar3.status = 0;
        m mVar4 = new m();
        mVar4.name = getString(R.l.fjt);
        mVar4.status = 0;
        m mVar5 = new m();
        mVar5.name = getString(R.l.fju);
        mVar5.status = 0;
        m mVar6 = new m();
        mVar6.name = getString(R.l.fjv);
        mVar6.status = 0;
        this.oLp.add(mVar);
        this.oLp.add(mVar2);
        this.oLp.add(mVar3);
        this.oLp.add(mVar4);
        this.oLp.add(mVar5);
        this.oLp.add(mVar6);
        this.oLq = new ArrayList();
        mVar = new m();
        mVar.name = getString(R.l.fjw);
        mVar.status = 0;
        mVar2 = new m();
        mVar2.name = getString(R.l.fjx);
        mVar2.status = 0;
        mVar3 = new m();
        mVar3.name = getString(R.l.fjy);
        mVar3.status = 0;
        this.oLq.add(mVar);
        this.oLq.add(mVar2);
        this.oLq.add(mVar3);
    }

    protected final int getLayoutId() {
        return R.i.dkE;
    }

    private void Dl(String str) {
        g.a(this, str, "", false, new OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI oMy;

            {
                this.oMy = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            if (fVar.cmdId != 0) {
                w.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
            } else if (bg.mA(fVar.ota) || fVar.ota.equals(this.oMc.getText())) {
                l(kVar);
                if (fVar.oLo) {
                    w.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                    Dl(fVar.fPf);
                    aWk();
                    return;
                }
                boolean z;
                boolean z2;
                this.ivH = fVar.appId;
                this.oLp = fVar.oLp;
                this.oLr = fVar.oLr;
                this.oLs = fVar.oLs;
                this.oLt = fVar.oLt;
                this.oLu = fVar.oLu;
                this.errCode = fVar.errCode;
                this.fPf = fVar.fPf;
                this.oMq = fVar.desc;
                w.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[]{this.oMq, this.oMc.getText()});
                if (bg.mA(this.oMq)) {
                    this.desc = "";
                    this.oMr = getResources().getColor(R.e.aVo);
                } else if (this.oMu.oLG != null && this.oMu.oLG.oKT.trim().equals(this.oMc.getText())) {
                    this.oMu.oLG.oKU = this.oMq;
                    this.oMu.b(this.oMu.oLG);
                }
                this.oMv = fVar.oLw;
                this.oLq = fVar.oLq;
                for (int size = this.oLq.size() - 1; size >= 0; size--) {
                    m mVar = (m) this.oLq.get(size);
                    if (mVar.name.isEmpty()) {
                        this.oLq.remove(mVar);
                    }
                }
                if (fVar.oLv == null || (fVar.oLv.name.equals(this.oLv.name) && fVar.oLv.url.equals(this.oLv.url))) {
                    z = false;
                } else {
                    w.i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.oLv = fVar.oLv;
                    z = true;
                }
                if (this.oMq.equals("")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                p(z2, z);
                List list = fVar.oLx;
                if (list != null) {
                    w.d("MicroMsg.PhoneRechargeUI", "update record history");
                    com.tencent.mm.plugin.recharge.a.a.aWd().bf(list);
                    if (this.oMu != null) {
                        if (fVar.oLy) {
                            this.oMu.gB(true);
                        } else {
                            this.oMu.gB(false);
                        }
                    }
                }
                this.oMc.postDelayed(new Runnable(this) {
                    final /* synthetic */ PhoneRechargeUI oMy;

                    {
                        this.oMy = r1;
                    }

                    public final void run() {
                        this.oMy.oMc.aWv();
                    }
                }, 300);
            } else {
                w.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[]{fVar.ota, this.oMc.getText()});
            }
        } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
            l(kVar);
            if (i == 0 && i2 == 0) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).oLz;
                payInfo.fRv = 6;
                payInfo.sYa = 100;
                payInfo.kdW = this.oMc.getText();
                payInfo.iBi = this.oMu.oLG != null ? this.oMu.oLG.name : "";
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 2);
                com.tencent.mm.sdk.b.a.urY.b(this.oqW);
                return;
            }
            Dl(str);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.oMw = true;
                    final List arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.i.a.aT(this, "android.permission.READ_CONTACTS")) {
                            try {
                                Cursor query = getContentResolver().query(data, null, null, null, null);
                                if (query != null && query.getCount() > 0) {
                                    query.moveToFirst();
                                    int columnIndex = query.getColumnIndex("has_phone_number");
                                    if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                        String str2;
                                        String string = query.getString(query.getColumnIndex("_id"));
                                        Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                        if (query2.moveToFirst()) {
                                            str2 = null;
                                            while (!query2.isAfterLast()) {
                                                columnIndex = query2.getColumnIndex("data1");
                                                int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                                String string2 = query2.getString(columnIndex);
                                                str2 = query2.getString(columnIndex2);
                                                w.d("MicroMsg.PhoneRechargeUI", "hy: username : " + str2);
                                                if (string2 != null) {
                                                    w.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string2);
                                                    string = com.tencent.mm.plugin.recharge.model.b.Di(string2);
                                                    w.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string);
                                                    if (PhoneNumberUtils.isGlobalPhoneNumber(string) && string.length() == 11) {
                                                        arrayList.add(string);
                                                    }
                                                    w.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : " + string);
                                                }
                                                query2.moveToNext();
                                            }
                                        } else {
                                            str2 = null;
                                        }
                                        if (!query2.isClosed()) {
                                            query2.close();
                                        }
                                        str = str2;
                                    }
                                }
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                if (arrayList.size() <= 1) {
                                    if (arrayList.size() != 1) {
                                        g.b(this, getString(R.l.eAp), "", true);
                                        break;
                                    }
                                    this.oMu.b(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(0), str, 1));
                                    aWm();
                                    break;
                                }
                                h a = g.a(this, getString(R.l.fjI), arrayList, -1, new g.a(this) {
                                    final /* synthetic */ PhoneRechargeUI oMy;

                                    public final void rO(int i) {
                                        w.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[]{Integer.valueOf(i)});
                                        this.oMy.oMu.b(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(i), str, 1));
                                        this.oMy.aWm();
                                    }
                                });
                                if (a != null) {
                                    a.setCanceledOnTouchOutside(true);
                                    break;
                                }
                            } catch (SecurityException e) {
                                w.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[]{e.toString()});
                                g.b(this, getString(R.l.eAr), "", true);
                                break;
                            }
                        }
                        w.e("MicroMsg.PhoneRechargeUI", "no contact permission");
                        return;
                    }
                    w.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.oqT) {
                        w.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.aWd().a(new com.tencent.mm.plugin.recharge.model.a(this.oMc.getText(), this.oMc.oNu.getText().toString(), 0));
                        finish();
                        this.oqT = true;
                        break;
                    }
                }
                w.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void aWm() {
        ap.vd().a(new f(this.oMc.getText()), 0);
    }

    public final void aWn() {
        ap.vd().a(new f("", 1), 0);
    }
}
