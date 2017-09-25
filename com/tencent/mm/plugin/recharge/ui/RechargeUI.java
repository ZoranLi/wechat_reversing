package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.ui.MallEditText.b;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI extends MMActivity implements com.tencent.mm.platformtools.j.a, b, e {
    protected Dialog ita = null;
    private Button liz = null;
    private TextView oME = null;
    private TextView oMF = null;
    private TextView oMG = null;
    private TextView oMH = null;
    private FrameLayout oMI = null;
    private ImageView oMJ = null;
    private ImageView oMK = null;
    private LinearLayout oML = null;
    private a oMM = null;
    private a oMN = null;
    private MallEditText oMO;
    private TextView oMP;
    private int oMQ;
    private MallRechargeProduct oMR = null;
    private String oMS = null;
    private MallNews oMT = null;
    private boolean oMU = false;
    private boolean oMV = true;
    private Map<String, Integer> oMW = new HashMap();
    private String oMX;
    public String oMY;
    private String oMZ;
    private MallFunction oMp = null;
    public String oNa;
    private boolean oqT = false;
    private c oqW = new c<rz>(this) {
        final /* synthetic */ RechargeUI oNb;

        {
            this.oNb = r2;
            this.usg = rz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rz rzVar = (rz) bVar;
            if (rzVar instanceof rz) {
                if (rzVar.fZv.result != -1) {
                    w.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                } else if (!this.oNb.oqT) {
                    w.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.aWd().a(this.oNb.oMO.aWi());
                    this.oNb.finish();
                    this.oNb.oqT = true;
                }
                return true;
            }
            w.f("MicroMsg.MallRechargeUI", "mismatched event");
            return false;
        }
    };

    private class a extends BaseAdapter {
        private List<MallRechargeProduct> oLh;
        final /* synthetic */ RechargeUI oNb;

        private a(RechargeUI rechargeUI) {
            this.oNb = rechargeUI;
            this.oLh = null;
        }

        public final /* synthetic */ Object getItem(int i) {
            return rQ(i);
        }

        public final void bi(List<MallRechargeProduct> list) {
            this.oLh = list;
            notifyDataSetChanged();
        }

        public final void rP(int i) {
            for (int i2 = 0; i2 < this.oLh.size(); i2++) {
                ((MallRechargeProduct) this.oLh.get(i2)).isDefault = false;
            }
            ((MallRechargeProduct) this.oLh.get(i)).isDefault = true;
        }

        public final int getCount() {
            return this.oLh == null ? 0 : this.oLh.size();
        }

        public final MallRechargeProduct rQ(int i) {
            return (MallRechargeProduct) this.oLh.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            if (rQ(i).isValid()) {
                return super.isEnabled(i);
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.oNb, R.i.dmj, null);
            MallRechargeProduct rQ = rQ(i);
            checkedTextView.setText(rQ.kSV);
            checkedTextView.setEnabled(rQ.isValid());
            if (rQ.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean c(RechargeUI rechargeUI) {
        if (rechargeUI.oMO.aWi().fFq != 0) {
            return true;
        }
        Context context = rechargeUI;
        g.a(context, rechargeUI.getString(R.l.eAl, new Object[]{rechargeUI.oMO.getText().toString()}), "", rechargeUI.getString(R.l.dJe), rechargeUI.getString(R.l.dHQ), new OnClickListener(rechargeUI) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.oNb.m(new com.tencent.mm.plugin.recharge.model.g(this.oNb.oMR, this.oNb.aWo()));
            }
        }, null);
        return false;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                final int color = getResources().getColor(R.e.aWp);
                final int color2 = getResources().getColor(R.e.aWu);
                View inflate = getLayoutInflater().inflate(R.i.dmi, null);
                final TextView textView = (TextView) inflate.findViewById(R.h.cwp);
                final ListView listView = (ListView) inflate.findViewById(R.h.cwt);
                final ListView listView2 = (ListView) inflate.findViewById(R.h.cwx);
                final TextView textView2 = (TextView) inflate.findViewById(R.h.cwq);
                final View findViewById = inflate.findViewById(R.h.cws);
                final TextView textView3 = (TextView) inflate.findViewById(R.h.cwu);
                final View findViewById2 = inflate.findViewById(R.h.cww);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.h.cwI);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(R.f.aXL) * this.oMQ) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listView.setAdapter(this.oMM);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ RechargeUI oNb;

                    {
                        this.oNb = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.oNb.dismissDialog(1);
                        w.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        w.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.oNb.oMR);
                        this.oNb.oMR = this.oNb.oMM.rQ(i);
                        this.oNb.oMM.rP(i);
                        this.oNb.oMM.notifyDataSetChanged();
                        w.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.oNb.oMR);
                        this.oNb.ar();
                    }
                });
                listView2.setAdapter(this.oMN);
                listView2.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ RechargeUI oNb;

                    {
                        this.oNb = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.oNb.dismissDialog(1);
                        w.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        this.oNb.oMR = this.oNb.oMN.rQ(i);
                        this.oNb.oMN.rP(i);
                        this.oNb.oMN.notifyDataSetChanged();
                        this.oNb.oMW.remove(RechargeUI.n(this.oNb.oMR.oLd, this.oNb.oMR.fGa, this.oNb.aWp()));
                        this.oNb.OX();
                        this.oNb.ar();
                    }
                });
                inflate.findViewById(R.h.cwr).setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ RechargeUI oNb;

                    public final void onClick(View view) {
                        findViewById.setVisibility(0);
                        textView2.setTextColor(color2);
                        listView.setVisibility(0);
                        findViewById2.setVisibility(8);
                        textView3.setTextColor(color);
                        listView2.setVisibility(8);
                        if (this.oNb.oMM.getCount() == 0) {
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                });
                final View view = findViewById2;
                final TextView textView4 = textView3;
                final int i2 = color2;
                final ListView listView3 = listView2;
                final View view2 = findViewById;
                final TextView textView5 = textView2;
                final int i3 = color;
                final ListView listView4 = listView;
                final TextView textView6 = textView;
                inflate.findViewById(R.h.cwv).setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ RechargeUI oNb;

                    public final void onClick(View view) {
                        view.setVisibility(0);
                        textView4.setTextColor(i2);
                        listView3.setVisibility(0);
                        view2.setVisibility(8);
                        textView5.setTextColor(i3);
                        listView4.setVisibility(8);
                        if (this.oNb.oMN.getCount() == 0) {
                            textView6.setVisibility(0);
                        } else {
                            textView6.setVisibility(8);
                        }
                    }
                });
                if (this.oMM.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
                aVar.SW(null);
                aVar.dd(inflate);
                aVar.d(null);
                return aVar.WJ();
            default:
                return g.b(this, getString(R.l.eAp), "", true);
        }
    }

    protected final int getLayoutId() {
        return R.i.dml;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.oMp = (MallFunction) intent.getParcelableExtra("key_func_info");
        List parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.oMV = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.oMp == null) {
            w.e("MicroMsg.MallRechargeUI", "function info is null");
            s.makeText(this, "function info is null", 1).show();
            return;
        }
        if (parcelableArrayListExtra == null) {
            w.d("MicroMsg.MallRechargeUI", "function info : " + this.oMp.fXa);
            m(new com.tencent.mm.plugin.recharge.model.e(this.oMp.oKW));
        } else {
            this.oMR = a.bg(parcelableArrayListExtra);
        }
        w.i("MicroMsg.MallRechargeUI", "onCreate()");
        this.oMT = com.tencent.mm.plugin.wallet_core.model.mall.c.buC().Ib(this.oMp.oKW);
        KC();
    }

    protected final void KC() {
        qP(this.oMp.fXa);
        w.v("MicroMsg.MallRechargeUI", "initView");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oNb.aHf();
                this.oNb.finish();
                return true;
            }
        });
        this.oME = (TextView) findViewById(R.h.chI);
        this.oMF = (TextView) findViewById(R.h.ciD);
        this.oMG = (TextView) findViewById(R.h.ciF);
        this.liz = (Button) findViewById(R.h.cnY);
        this.oML = (LinearLayout) findViewById(R.h.chl);
        this.oMH = (TextView) findViewById(R.h.ciE);
        this.oMH.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.oNb.oMZ);
                d.b(this.oNb, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        this.liz.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(View view) {
                if (this.oNb.OX() && RechargeUI.c(this.oNb)) {
                    this.oNb.m(new com.tencent.mm.plugin.recharge.model.g(this.oNb.oMR, this.oNb.aWo()));
                }
            }
        });
        this.oMO = (MallEditText) findViewById(R.h.cho);
        this.oMO.itZ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(View view) {
                if (this.oNb.oMO.oLC) {
                    this.oNb.oMO.b(null);
                    return;
                }
                this.oNb.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
            }
        });
        this.oMP = (TextView) findViewById(R.h.chN);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List c = c(0, parcelableArrayListExtra);
        List c2 = c(2, parcelableArrayListExtra);
        this.oMQ = c.size() > c2.size() ? c.size() : c2.size();
        this.oMM = new a();
        this.oMM.bi(c);
        this.oMN = new a();
        this.oMN.bi(c2);
        this.oML.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(View view) {
                if ((this.oNb.oMM != null && this.oNb.oMM.getCount() > 0) || (this.oNb.oMN != null && this.oNb.oMN.getCount() > 0)) {
                    this.oNb.showDialog(1);
                }
            }
        });
        this.oMI = (FrameLayout) findViewById(R.h.ciA);
        this.oMJ = (ImageView) findViewById(R.h.ciC);
        this.oMK = (ImageView) findViewById(R.h.ciB);
        this.oMK.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.wallet_core.model.mall.c buC = com.tencent.mm.plugin.wallet_core.model.mall.c.buC();
                String str = this.oNb.oMp.oKW;
                w.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
                if (!bg.mA(str) && buC.rIU.containsKey(str)) {
                    MallNews mallNews = (MallNews) buC.rIU.get(str);
                    if ("1".equals(mallNews.rII)) {
                        mallNews.rII = "2";
                        buC.aTl();
                    }
                }
                this.oNb.oMI.setVisibility(8);
            }
        });
        this.oMI.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(View view) {
                if (!bg.mA(this.oNb.oMp.rID.rIM)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.oNb.oMp.rID.rIM);
                    intent.putExtra("geta8key_username", m.xL());
                    d.b(this.oNb, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            }
        });
        this.oMO.oLA = this;
        this.oMO.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RechargeUI oNb;

            {
                this.oNb = r1;
            }

            public final void onClick(View view) {
                this.oNb.oMO.oLB.findFocus();
                if (this.oNb.oMO.aWi().fFq == 2) {
                    this.oNb.oMO.b(null);
                }
                if (bg.mA(this.oNb.oMO.getText().toString())) {
                    this.oNb.oMO.oLB.showDropDown();
                }
                this.oNb.aHj();
            }
        });
        aWj();
        j.a(this);
        ar();
    }

    private void ar() {
        w.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.oMR);
        if (this.oMR != null) {
            CharSequence string;
            this.oMP.setText(this.oMR.kSV);
            TextView textView = this.oMG;
            MallRechargeProduct mallRechargeProduct = this.oMR;
            if (!mallRechargeProduct.isValid()) {
                string = getString(R.l.eAo);
            } else if (mallRechargeProduct.oKY != mallRechargeProduct.oKZ || (aWq() && this.oMR.oLe)) {
                string = "";
            } else {
                string = String.format(getString(R.l.eAq), new Object[]{Float.valueOf(mallRechargeProduct.oKY)});
            }
            textView.setText(string);
        }
        if (this.oMT != null && this.oMp.rID != null && this.oMT.equals(this.oMp.rID) && !"1".equals(this.oMT.rII)) {
            this.oMI.setVisibility(8);
            w.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.oMT.toString());
        } else if (this.oMp.rID == null || bg.mA(this.oMp.rID.rIN)) {
            this.oMI.setVisibility(8);
            w.d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.oMS = this.oMp.rID.rIN;
            this.oMJ.setImageBitmap(j.a(new com.tencent.mm.plugin.recharge.b.a(this.oMS)));
            this.oMI.setVisibility(0);
            w.d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.oMF.setVisibility(4);
        if (!OX()) {
            this.oME.setText("");
        } else if (!(this.oMR == null || aWq())) {
            this.oME.setText(this.oMR.oKX);
            this.oME.setTextColor(getResources().getColor(R.e.aUo));
        }
        String string2 = getString(R.l.eAj);
        if (!TextUtils.isEmpty(this.oMY)) {
            string2 = this.oMY;
        }
        if (!bg.mA(this.oMX)) {
            a(0, string2, new OnMenuItemClickListener(this) {
                final /* synthetic */ RechargeUI oNb;

                {
                    this.oNb = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.oNb.oMX);
                    d.b(this.oNb, "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
            });
        }
        if (bg.mA(this.oMZ)) {
            this.oMH.setVisibility(8);
        } else {
            this.oMH.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.oNa)) {
            this.oMH.setText(this.oNa);
        }
    }

    private static List<MallRechargeProduct> c(int i, List<MallRechargeProduct> list) {
        List<MallRechargeProduct> arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.oLd == i) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        return arrayList;
    }

    private void m(final k kVar) {
        if (kVar.getType() == 497 || kVar.getType() == 1555) {
            ap.vd().a(kVar, 0);
        } else if (this.oMV) {
            if (this.ita == null || !(this.ita == null || this.ita.isShowing())) {
                this.ita = com.tencent.mm.wallet_core.ui.g.a(this.uSU.uTo, true, new OnCancelListener(this) {
                    final /* synthetic */ RechargeUI oNb;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(kVar);
                    }
                });
            }
            ap.vd().a(kVar, 0);
        } else {
            ap.vd().a(kVar, 0);
        }
    }

    private boolean OX() {
        boolean z;
        MallEditText mallEditText = this.oMO;
        if (mallEditText.getVisibility() == 0) {
            if (bg.mA(mallEditText.getText())) {
                w.d("MicroMsg.MallEditText", "View:" + mallEditText.iub + ", editType:" + mallEditText.iuc + " checkInputValid : empty ");
                z = false;
            } else if (!mallEditText.iug) {
                w.d("MicroMsg.MallEditText", "View:" + mallEditText.iub + ", editType:" + mallEditText.iuc + " checkInputValid : illegal ");
                z = false;
            }
            if (z) {
                z = false;
            } else {
                z = true;
            }
            if (z || this.oMR == null || !this.oMR.isValid()) {
                if (!(this.oMU || z || this.oMR == null)) {
                    this.oMR.isValid();
                }
                this.liz.setEnabled(false);
                this.liz.setClickable(false);
                w.d("MicroMsg.MallRechargeUI", "checkInfo : false");
                return false;
            }
            if (aWq() && this.oMR.oLe) {
                m(new com.tencent.mm.plugin.recharge.model.d(this.oMR.oLd, this.oMp.oKW, this.oMR.fGa, this.oMR.appId, aWo(), aWp()));
            }
            aHf();
            this.liz.setEnabled(true);
            this.liz.setClickable(true);
            w.d("MicroMsg.MallRechargeUI", "checkInfo : true");
            return true;
        }
        z = true;
        if (z) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        }
        this.oMR.isValid();
        this.liz.setEnabled(false);
        this.liz.setClickable(false);
        w.d("MicroMsg.MallRechargeUI", "checkInfo : false");
        return false;
    }

    private String aWo() {
        return "mobile=" + com.tencent.mm.plugin.recharge.model.b.Di(this.oMO.getText());
    }

    private String aWp() {
        return com.tencent.mm.plugin.recharge.model.b.Di(this.oMO.getText());
    }

    private static String n(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private boolean aWq() {
        return !this.oMW.containsKey(n(this.oMR.oLd, this.oMR.fGa, aWp()));
    }

    public final void gA(boolean z) {
        if (!z) {
            this.oMW.clear();
            this.oME.setText("");
            this.oMF.setVisibility(4);
        }
        OX();
    }

    public final void aWj() {
        if (bg.mA(this.oMO.getText()) || this.oMO.Pb()) {
            this.oMO.rM(R.g.biX);
        } else {
            this.oMO.rM(R.g.bgg);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i + ", errCode = " + i2);
        if (!(this.ita == null || !this.ita.isShowing() || kVar.getType() == 497)) {
            this.ita.dismiss();
            this.ita = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.recharge.model.e) {
                com.tencent.mm.plugin.recharge.model.e eVar = (com.tencent.mm.plugin.recharge.model.e) kVar;
                List list = eVar.oLj;
                if (list != null) {
                    this.oMR = a.bg(list);
                    w.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.oMR);
                }
                this.oMX = eVar.oLk;
                this.oMY = eVar.oLl;
                this.oMZ = eVar.oLm;
                this.oNa = eVar.oLn;
                w.d("MicroMsg.MallRechargeUI", "mProductList " + list);
                ar();
                List c = c(0, list);
                List c2 = c(2, list);
                this.oMQ = c.size() > c2.size() ? c.size() : c2.size();
                this.oMM.bi(c);
                this.oMN.bi(c2);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                w.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.oMR);
                com.tencent.mm.plugin.recharge.model.d dVar = (com.tencent.mm.plugin.recharge.model.d) kVar;
                if (!(this.oMR == null || this.oMR.fGa == null || dVar.oLg == null || ((!this.oMR.fGa.equals(dVar.oLg.fGa) || !aWp().equals(dVar.isg)) && dVar.oLd == 2))) {
                    MallRechargeProduct.a(dVar.oLg, this.oMR);
                    this.oMR.isDefault = true;
                    this.oMW.put(n(dVar.oLd, dVar.oLg.fGa, dVar.isg), Integer.valueOf(1));
                    ar();
                    this.oMF.setText(str);
                    this.oMF.setVisibility(0);
                    this.oMF.setTextColor(getResources().getColor(R.e.aUe));
                }
                if (dVar.oLd == 2) {
                    if (this.oMR == null || !this.oMR.fGa.equals(dVar.oLi) || !aWp().equals(dVar.isg)) {
                        this.liz.setEnabled(true);
                        this.liz.setClickable(true);
                        this.oMF.setText(null);
                    } else if (((zc) dVar.gUA.hsk.hsr).tAq == 0 && this.oMR.fGa.equals(dVar.oLg.fGa)) {
                        m(new com.tencent.mm.plugin.recharge.model.c(this.oMR.oKW, aWp(), this.oMR.kSV, this.oMR.appId, aWo()));
                    } else {
                        this.liz.setEnabled(false);
                        this.liz.setClickable(false);
                        this.oMF.setText(((zc) dVar.gUA.hsk.hsr).tAr);
                        this.oMF.setVisibility(0);
                        this.oMF.setTextColor(getResources().getColor(R.e.aVD));
                    }
                }
                bh(dVar.oLh);
                w.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.oMR);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).oLz;
                payInfo.fRv = 6;
                payInfo.sYa = 100;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 2);
                com.tencent.mm.sdk.b.a.urY.b(this.oqW);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.c) {
                com.tencent.mm.plugin.recharge.model.c cVar = (com.tencent.mm.plugin.recharge.model.c) kVar;
                if (this.oMR == null || !this.oMR.kSV.equals(cVar.kSV) || !aWp().equals(cVar.fOI)) {
                    this.liz.setEnabled(true);
                    this.liz.setClickable(true);
                    this.oMF.setText(null);
                } else if (((sj) cVar.gUA.hsk.hsr).tAq != 0) {
                    this.liz.setEnabled(false);
                    this.liz.setClickable(false);
                    this.oMF.setText(((sj) cVar.gUA.hsk.hsr).tAr);
                    this.oMF.setVisibility(0);
                    this.oMF.setTextColor(getResources().getColor(R.e.aVD));
                }
            }
        } else if (!(kVar instanceof com.tencent.mm.plugin.recharge.model.c)) {
            if (kVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                if (i2 == 100) {
                    this.liz.setEnabled(true);
                    this.liz.setClickable(true);
                } else {
                    this.liz.setEnabled(false);
                    this.liz.setClickable(false);
                }
                bh(((com.tencent.mm.plugin.recharge.model.d) kVar).oLh);
                this.oMF.setText(str);
                this.oMF.setVisibility(0);
                this.oMF.setTextColor(getResources().getColor(R.e.aVD));
                this.oME.setText(((com.tencent.mm.plugin.recharge.model.d) kVar).oKX);
                this.oME.setTextColor(getResources().getColor(R.e.aVD));
                return;
            }
            if (bg.mA(str)) {
                str = getString(R.l.fkA);
            }
            g.a(this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ RechargeUI oNb;

                {
                    this.oNb = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(496, this);
        ap.vd().a(497, this);
        ap.vd().a(498, this);
        ap.vd().a(1555, this);
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(496, this);
        ap.vd().b(497, this);
        ap.vd().b(498, this);
        ap.vd().b(1555, this);
    }

    private void bh(List<MallRechargeProduct> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.oLd == 2) {
                    if (this.oMR != null && mallRechargeProduct.fGa.equals(this.oMR.fGa)) {
                        mallRechargeProduct.isDefault = true;
                        i = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (i == 0 && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.oMN.bi(arrayList);
            return;
        }
        this.oMN.bi(new ArrayList());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.i.a.aT(this, "android.permission.READ_CONTACTS")) {
                            String str2;
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + query.getString(query.getColumnIndex("_id")), null, null);
                                    if (query2.moveToFirst()) {
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string = query2.getString(columnIndex);
                                            str = query2.getString(columnIndex2);
                                            w.d("MicroMsg.MallRechargeUI", "username : " + str);
                                            if (string != null) {
                                                w.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                string = com.tencent.mm.plugin.recharge.model.b.Di(string);
                                                w.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    string = str2;
                                                }
                                                w.d("MicroMsg.MallRechargeUI", "phoneResult : " + string);
                                            } else {
                                                string = str2;
                                            }
                                            query2.moveToNext();
                                            str2 = string;
                                        }
                                    } else {
                                        str2 = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                        this.oMW.clear();
                                        this.oMO.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                        this.oME.setText("");
                                        this.oMF.setVisibility(4);
                                        OX();
                                        break;
                                    }
                                    showDialog(2);
                                    break;
                                }
                            }
                            str2 = null;
                            query.close();
                            if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                this.oMW.clear();
                                this.oMO.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                this.oME.setText("");
                                this.oMF.setVisibility(4);
                                OX();
                            } else {
                                showDialog(2);
                            }
                            break;
                        }
                        w.e("MicroMsg.MallRechargeUI", "no contact permission");
                        return;
                    }
                    w.e("MicroMsg.MallRechargeUI", "uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.oqT) {
                        w.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.aWd().a(this.oMO.aWi());
                        finish();
                        this.oqT = true;
                        break;
                    }
                }
                w.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.oqW);
        super.onDestroy();
    }

    public final void k(String str, final Bitmap bitmap) {
        if (this.oMS != null && str.equals(this.oMS)) {
            this.oMJ.post(new Runnable(this) {
                final /* synthetic */ RechargeUI oNb;

                public final void run() {
                    this.oNb.oMJ.setImageBitmap(bitmap);
                }
            });
        }
    }

    public final void aHj() {
        w.d("MicroMsg.MallRechargeUI", "showVKB");
        this.oMO.rM(R.g.bgg);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.showSoftInput(currentFocus, 2);
            }
        }
    }

    public final void aHf() {
        w.d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }
}
