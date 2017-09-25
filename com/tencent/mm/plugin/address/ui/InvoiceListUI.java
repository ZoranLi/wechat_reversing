package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI extends MMActivity implements e {
    private TextView itG = null;
    private boolean itR = false;
    private boolean iuA = false;
    private b ius;
    private a iut;
    private ListView iuu;
    private com.tencent.mm.plugin.address.b.b.a iuv = null;
    private Object iuw = new Object();
    private TextView iux = null;
    private LinkedList<b> iuy = new LinkedList();
    private boolean iuz = false;

    public class a extends BaseAdapter {
        private final Context context;
        List<b> hoO = new ArrayList();
        final /* synthetic */ InvoiceListUI iuB;

        class a {
            TextView iuD;
            ImageView iuE;
            TextView iuF;
            final /* synthetic */ a iuG;

            a(a aVar) {
                this.iuG = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return hr(i);
        }

        public a(InvoiceListUI invoiceListUI, Context context) {
            this.iuB = invoiceListUI;
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a aVar2 = new a(this);
            if (view == null) {
                view = View.inflate(this.context, R.i.dpU, null);
                aVar2.iuE = (ImageView) view.findViewById(R.h.bCf);
                aVar2.iuD = (TextView) view.findViewById(R.h.bnx);
                aVar2.iuF = (TextView) view.findViewById(R.h.bnE);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            b hr = hr(i);
            if (hr.type != null && hr.type.equals("0")) {
                aVar.iuD.setText(R.l.etm);
                aVar.iuF.setText(hr.title);
            } else if (hr.type != null && hr.type.equals("1")) {
                aVar.iuD.setText(R.l.eto);
                aVar.iuF.setText(hr.mLX);
            }
            if (this.iuB.itR && this.iuB.ius != null && this.iuB.ius.mLW == hr.mLW) {
                aVar.iuE.setImageResource(R.k.dze);
            } else {
                aVar.iuE.setImageBitmap(null);
            }
            return view;
        }

        public final int getCount() {
            return this.hoO.size();
        }

        private b hr(int i) {
            return (b) this.hoO.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void a(InvoiceListUI invoiceListUI) {
        g.oUh.i(14199, new Object[]{Integer.valueOf(2)});
        invoiceListUI.hp(0);
    }

    static /* synthetic */ void b(InvoiceListUI invoiceListUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (bVar.type != null && bVar.type.equals("0")) {
                if (!TextUtils.isEmpty(bVar.title)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.bYL));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.title);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.mLY)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.bYK));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.mLY);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.mMe)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.bYx));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.mMe);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.mMc)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.bYC));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.mMc);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.mMa)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.bYu));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.mMa);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.mLZ)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.bYv));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.mLZ);
                    stringBuilder.append(" \n");
                }
            } else if (!(bVar.type == null || !bVar.type.equals("1") || TextUtils.isEmpty(bVar.mLX))) {
                stringBuilder.append(invoiceListUI.getString(R.l.bYL));
                stringBuilder.append("：");
                stringBuilder.append(bVar.mLX);
                stringBuilder.append(" \n");
            }
            try {
                d.I(invoiceListUI.uSU.uTo, stringBuilder.toString());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.InvoiceListUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.itR = intent.getBooleanExtra("launch_from_webview", false);
        this.iuz = intent.getBooleanExtra("launch_from_appbrand", false);
        if (this.itR || this.iuz) {
            this.itR = true;
        }
        if (this.itR) {
            ap.yY();
            boolean booleanValue = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uEG, Boolean.valueOf(true))).booleanValue();
            w.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog " + booleanValue);
            if (booleanValue) {
                w.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
                com.tencent.mm.ui.base.g.a(this, getString(R.l.ett), getString(R.l.etu), getString(R.l.dAN), false, new OnClickListener(this) {
                    final /* synthetic */ InvoiceListUI iuB;

                    {
                        this.iuB = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
                        dialogInterface.dismiss();
                    }
                });
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uEG, Boolean.valueOf(false));
            }
        }
        zi(R.l.eTc);
        ap.vd().a(1194, this);
        ap.vd().a(1191, this);
        KC();
        Pd();
    }

    public void onDestroy() {
        ap.vd().b(1194, this);
        ap.vd().b(1191, this);
        super.onDestroy();
    }

    public void onResume() {
        ap.vd().a(new com.tencent.mm.plugin.address.model.b(), 0);
        super.onResume();
    }

    private void Pd() {
        synchronized (this.iuw) {
            com.tencent.mm.plugin.address.a.a.OR();
            this.iuy = com.tencent.mm.plugin.address.a.a.OS().isX.mLV;
            this.iut.hoO = this.iuy;
            this.iuy.size();
            this.iut.notifyDataSetChanged();
        }
    }

    public final void KC() {
        this.iux = (TextView) findViewById(R.h.bXu);
        if (this.iux != null) {
            this.iux.setVisibility(8);
        }
        if (this.itR) {
            this.itG = (TextView) findViewById(R.h.bZZ);
            if (this.itG != null) {
                this.itG.setVisibility(0);
            }
        } else {
            this.itG = (TextView) findViewById(R.h.bZZ);
            if (this.itG != null) {
                this.itG.setVisibility(8);
            }
        }
        this.iux.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ InvoiceListUI iuB;

            {
                this.iuB = r1;
            }

            public final void onClick(View view) {
                InvoiceListUI.a(this.iuB);
            }
        });
        this.iuu = (ListView) findViewById(R.h.cDr);
        this.iut = new a(this, this);
        this.iuu.setAdapter(this.iut);
        this.iuu.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ InvoiceListUI iuB;

            {
                this.iuB = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.d("MicroMsg.InvoiceListUI", "select pos " + i);
                synchronized (this.iuB.iuw) {
                    if (i < this.iuB.iuy.size()) {
                        this.iuB.ius = (b) this.iuB.iuy.get(i);
                        if (!this.iuB.itR && this.iuB.ius != null) {
                            this.iuB.hp(this.iuB.ius.mLW);
                        } else if (!(this.iuB.ius == null || this.iuB.ius.mLW == 0)) {
                            Intent intent = new Intent();
                            intent.putExtra("choose_invoice_title_info", com.tencent.mm.plugin.address.e.e.a(this.iuB.ius));
                            this.iuB.setResult(-1, intent);
                            this.iuB.finish();
                        }
                    }
                }
                this.iuB.iut.notifyDataSetChanged();
            }
        });
        this.iuu.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ InvoiceListUI iuB;

            {
                this.iuB = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                com.tencent.mm.ui.base.g.a(this.iuB.uSU.uTo, null, this.iuB.getResources().getStringArray(R.c.aSc), null, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass3 iuC;

                    public final void hq(int i) {
                        b bVar;
                        synchronized (this.iuC.iuB.iuw) {
                            if (i < this.iuC.iuB.iuy.size()) {
                                bVar = (b) this.iuC.iuB.iuy.get(i);
                            } else {
                                bVar = null;
                            }
                        }
                        if (bVar != null) {
                            switch (i) {
                                case 0:
                                    this.iuC.iuB.hp(bVar.mLW);
                                    return;
                                case 1:
                                    k aVar = new com.tencent.mm.plugin.address.model.a(bVar.mLW);
                                    this.iuC.iuB.ius = null;
                                    ap.vd().a(aVar, 0);
                                    return;
                                case 2:
                                    InvoiceListUI.b(this.iuC.iuB, bVar);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                return true;
            }
        });
        this.iut.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InvoiceListUI iuB;

            {
                this.iuB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iuB.setResult(0);
                this.iuB.finish();
                return true;
            }
        });
        a(0, R.l.eSb, R.k.dsI, new OnMenuItemClickListener(this) {
            final /* synthetic */ InvoiceListUI iuB;

            {
                this.iuB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                InvoiceListUI.a(this.iuB);
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dfT;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return;
        }
        if (kVar.getType() == 1191) {
            Pd();
            if (this.itR) {
                com.tencent.mm.plugin.address.a.a.OR();
                if (com.tencent.mm.plugin.address.a.a.OS().isX.mLV.size() == 0 && !this.iuA) {
                    Intent intent = new Intent();
                    intent.setClass(this, AddInvoiceUI.class);
                    intent.putExtra("launch_from_webview", true);
                    startActivityForResult(intent, 1);
                }
            }
        } else if (kVar.getType() == 1194) {
            ap.vd().a(new com.tencent.mm.plugin.address.model.b(), 0);
            this.iuA = true;
        }
    }

    private void hp(int i) {
        Intent intent = new Intent();
        if (i != 0) {
            intent.setClass(this, QrcodeInvoiceUI.class);
            intent.putExtra("invoice_id", i);
        } else {
            intent.setClass(this, AddInvoiceUI.class);
            intent.putExtra("launch_from_invoicelist_webview", this.itR);
            intent.putExtra("invoice_id", i);
        }
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    w.e("MicroMsg.InvoiceUtil", "intent is null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.type = intent.getStringExtra(Columns.TYPE);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        bVar.title = intent.getStringExtra("title");
                        bVar.mLY = intent.getStringExtra("tax_number");
                        bVar.mMe = intent.getStringExtra("company_address");
                        bVar.mMc = intent.getStringExtra("telephone");
                        bVar.mMa = intent.getStringExtra("bank_name");
                        bVar.mLZ = intent.getStringExtra("bank_account");
                    } else {
                        bVar.mLX = intent.getStringExtra("title");
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("choose_invoice_title_info", com.tencent.mm.plugin.address.e.e.a(bVar));
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
