package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mm.a.o;
import com.tencent.mm.ap.k;
import com.tencent.mm.e.a.jd;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI extends MMActivity implements com.tencent.mm.plugin.address.c.a {
    private boolean itR = false;
    private ListView iuu;
    private Object iuw = new Object();
    private List<b> ivn = new LinkedList();
    private b ivo;
    private a ivp;
    private com.tencent.mm.plugin.address.c.b ivq = null;
    private View ivr;
    private TextView ivs = null;
    private o ivt;
    private boolean ivu = false;
    private h ivv = null;

    public class a extends BaseAdapter {
        private final Context context;
        List<b> hoO = new ArrayList();
        final /* synthetic */ WalletSelectAddrUI ivw;

        class a {
            TextView iuD;
            ImageView iuE;
            TextView iuF;
            final /* synthetic */ a ivB;

            a(a aVar) {
                this.ivB = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return ht(i);
        }

        public a(WalletSelectAddrUI walletSelectAddrUI, Context context) {
            this.ivw = walletSelectAddrUI;
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
            b ht = ht(i);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(ht.its)) {
                stringBuilder.append(ht.its);
            }
            if (!TextUtils.isEmpty(ht.itt)) {
                stringBuilder.append(" ");
                stringBuilder.append(ht.itt);
            }
            if (!TextUtils.isEmpty(ht.itu)) {
                stringBuilder.append(" ");
                stringBuilder.append(ht.itu);
            }
            if (!TextUtils.isEmpty(ht.itw)) {
                stringBuilder.append(" ");
                stringBuilder.append(ht.itw);
            }
            aVar.iuD.setText(stringBuilder.toString());
            aVar.iuF.setText(ht.itx + "，" + ht.ity);
            if (this.ivw.itR && this.ivw.ivo != null && this.ivw.ivo.id == ht.id) {
                aVar.iuE.setImageResource(R.k.dze);
            } else {
                aVar.iuE.setImageBitmap(null);
            }
            return view;
        }

        public final int getCount() {
            return this.hoO.size();
        }

        private b ht(int i) {
            return (b) this.hoO.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI) {
        ap.yY();
        String mz = bg.mz((String) c.vr().get(46, null));
        ap.yY();
        String mz2 = bg.mz((String) c.vr().get(72, null));
        if (bg.mA(mz) && bg.mA(mz2)) {
            walletSelectAddrUI.Pi();
        } else {
            walletSelectAddrUI.ax(mz, mz2);
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(bVar.itx)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.bnD));
                stringBuilder.append("：");
                stringBuilder.append(bVar.itx);
                stringBuilder.append(" \n");
            }
            if (!TextUtils.isEmpty(bVar.ity)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.bnF));
                stringBuilder.append("：");
                stringBuilder.append(bVar.ity);
                stringBuilder.append(" \n");
            }
            stringBuilder.append(walletSelectAddrUI.getString(R.l.dCN));
            stringBuilder.append("：");
            if (!TextUtils.isEmpty(bVar.its)) {
                stringBuilder.append(bVar.its);
            }
            if (!TextUtils.isEmpty(bVar.itt)) {
                stringBuilder.append(bVar.itt);
            }
            if (!TextUtils.isEmpty(bVar.itu)) {
                stringBuilder.append(bVar.itu);
            }
            if (!TextUtils.isEmpty(bVar.itw)) {
                stringBuilder.append(bVar.itw);
            }
            if (!TextUtils.isEmpty(bVar.itv)) {
                stringBuilder.append(" \n");
                stringBuilder.append(walletSelectAddrUI.getString(R.l.dCK));
                stringBuilder.append("：");
                stringBuilder.append(bVar.itv);
            }
            try {
                d.I(walletSelectAddrUI.uSU.uTo, stringBuilder.toString());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WalletSelectAddrUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ivq = new com.tencent.mm.plugin.address.c.b(this, this);
        Intent intent = getIntent();
        this.ivu = intent.getBooleanExtra("launch_from_appbrand", false);
        if (intent.getBooleanExtra("launch_from_webview", false) || this.ivu) {
            this.itR = true;
            this.uSU.ipu.setVisibility(8);
            if (this.ivu) {
                getWindow().setBackgroundDrawableResource(R.e.aVj);
            }
            w.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
            ap.yY();
            if (((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uEF, Boolean.valueOf(true))).booleanValue()) {
                w.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                g.a(this, getString(R.l.dCO), getString(R.l.dCP), getString(R.l.dAN), new OnClickListener(this) {
                    final /* synthetic */ WalletSelectAddrUI ivw;

                    {
                        this.ivw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uEF, Boolean.valueOf(false));
            }
        }
        zi(R.l.dCN);
        this.ivq.hn(417);
        this.ivq.hn(416);
        this.ivq.hn(419);
        this.ivq.hn(582);
        this.ivq.g(new e(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2));
        ap.yY();
        this.ivt = new o(bg.a((Integer) c.vr().get(9, null), 0));
        KC();
        ap.yY();
        if (c.isSDCardAvailable()) {
            ap.vd().a(new k(12), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.ivq.ho(417);
        this.ivq.ho(416);
        this.ivq.ho(419);
        this.ivq.ho(582);
    }

    public void onResume() {
        super.onResume();
        Pd();
    }

    private void Pd() {
        synchronized (this.iuw) {
            com.tencent.mm.plugin.address.a.a.OR();
            this.ivn = com.tencent.mm.plugin.address.a.a.OT().iti.itq;
            this.ivp.hoO = this.ivn;
            this.ivn.size();
            this.ivr.setVisibility(8);
            this.ivp.notifyDataSetChanged();
        }
    }

    public final void KC() {
        this.ivs = (TextView) findViewById(R.h.bXt);
        this.ivs.setVisibility(8);
        this.ivs.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI ivw;

            {
                this.ivw = r1;
            }

            public final void onClick(View view) {
                g.a(this.ivw, true, this.ivw.getString(R.l.ezr, new Object[]{this.ivw.ivt.toString()}), "", this.ivw.getString(R.l.ezs), this.ivw.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 ivx;

                    {
                        this.ivx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletSelectAddrUI.b(this.ivx.ivw);
                    }
                }, null);
            }
        });
        this.iuu = (ListView) findViewById(R.h.cDo);
        this.ivp = new a(this, this);
        this.ivr = findViewById(R.h.bno);
        this.ivr.findViewById(R.h.bnx).setVisibility(8);
        ((TextView) this.ivr.findViewById(R.h.bnE)).setText(R.l.dCl);
        this.iuu.setAdapter(this.ivp);
        this.iuu.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI ivw;

            {
                this.ivw = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.d("MicroMsg.WalletSelectAddrUI", "select pos " + i);
                synchronized (this.ivw.iuw) {
                    if (i < this.ivw.ivn.size()) {
                        this.ivw.ivo = (b) this.ivw.ivn.get(i);
                        if (!this.ivw.itR && this.ivw.ivo != null) {
                            this.ivw.hs(this.ivw.ivo.id);
                        } else if (!(this.ivw.ivo == null || this.ivw.ivo.id == 0)) {
                            this.ivw.ivq.g(new com.tencent.mm.plugin.address.model.g(this.ivw.ivo.id));
                        }
                    }
                }
                this.ivw.ivp.notifyDataSetChanged();
            }
        });
        this.iuu.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI ivw;

            {
                this.ivw = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                g.a(this.ivw.uSU.uTo, null, this.ivw.getResources().getStringArray(R.c.aSr), null, new g.c(this) {
                    final /* synthetic */ AnonymousClass5 ivy;

                    public final void hq(int i) {
                        b bVar;
                        synchronized (this.ivy.ivw.iuw) {
                            if (i < this.ivy.ivw.ivn.size()) {
                                bVar = (b) this.ivy.ivw.ivn.get(i);
                            } else {
                                bVar = null;
                            }
                        }
                        if (bVar != null) {
                            switch (i) {
                                case 0:
                                    this.ivy.ivw.hs(bVar.id);
                                    return;
                                case 1:
                                    com.tencent.mm.y.k fVar = new f(bVar.id);
                                    this.ivy.ivw.ivo = null;
                                    this.ivy.ivw.ivq.g(fVar);
                                    return;
                                case 2:
                                    WalletSelectAddrUI.b(this.ivy.ivw, bVar);
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
        Pd();
        this.ivr.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI ivw;

            {
                this.ivw = r1;
            }

            public final void onClick(View view) {
                this.ivw.hs(0);
            }
        });
        this.ivp.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI ivw;

            {
                this.ivw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ivw.setResult(0);
                this.ivw.finish();
                return true;
            }
        });
        a(0, R.l.dCn, R.k.dsI, new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletSelectAddrUI ivw;

            {
                this.ivw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ivw.hs(0);
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dpV;
    }

    public final void e(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        this.ivq.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 417) {
                if (((e) kVar).itb) {
                    Pd();
                    this.uSU.ipu.setVisibility(0);
                    if (this.itR && this.ivn.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
            } else if (kVar.getType() == 416) {
                f fVar = (f) kVar;
                com.tencent.mm.plugin.address.a.a.OR();
                b hm = com.tencent.mm.plugin.address.a.a.OT().hm(fVar.itc);
                if (hm != null) {
                    com.tencent.mm.plugin.address.a.a.OR();
                    w.d("MicroMsg.WalletSelectAddrUI", "delte addr " + com.tencent.mm.plugin.address.a.a.OT().a(hm));
                }
                Pd();
            } else if (kVar.getType() == 419) {
                if (this.ivo != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.ivo));
                    finish();
                }
            } else if (kVar.getType() == 582) {
                String string = getString(R.l.ezt);
                switch (((com.tencent.mm.plugin.address.model.d) kVar).status) {
                    case 0:
                        ap.yY();
                        c.vr().set(196657, Boolean.valueOf(true));
                        this.ivs.setVisibility(8);
                        Pd();
                        this.uSU.ipu.setVisibility(0);
                        string = getString(R.l.ezv);
                        break;
                    case 1:
                    case 2:
                        ap.yY();
                        c.vr().set(196657, Boolean.valueOf(true));
                        this.ivs.setVisibility(8);
                        string = getString(R.l.ezu);
                        break;
                    case 3:
                        Pi();
                        return;
                }
                if (this.ivv != null) {
                    this.ivv.dismiss();
                }
                this.ivv = g.a(this, string, null, true, null);
            }
        } else if (kVar.getType() == 419 && i2 == -3103) {
            g.a(this, true, str, "", getString(R.l.dCr), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ WalletSelectAddrUI ivw;

                {
                    this.ivw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.ivw.hs(this.ivw.ivo.id);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletSelectAddrUI ivw;

                {
                    this.ivw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    private void ax(String str, String str2) {
        this.ivq.g(new com.tencent.mm.plugin.address.model.d(str, str2, this.ivt));
    }

    private void Pi() {
        final com.tencent.mm.sdk.b.b jdVar = new jd();
        jdVar.fPg.fPi = this;
        jdVar.fPg.fPj = new Runnable(this) {
            final /* synthetic */ WalletSelectAddrUI ivw;

            public final void run() {
                this.ivw.iuu.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 ivA;

                    {
                        this.ivA = r1;
                    }

                    public final void run() {
                        if (jdVar.fPh.fFj) {
                            ap.yY();
                            String mz = bg.mz((String) c.vr().get(46, null));
                            ap.yY();
                            this.ivA.ivw.ax(mz, bg.mz((String) c.vr().get(72, null)));
                        }
                    }
                });
            }
        };
        com.tencent.mm.sdk.b.a.urY.a(jdVar, Looper.myLooper());
    }

    private void hs(int i) {
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i);
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    w.e("MicroMsg.AddrUtil", "intent == null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.itz = intent.getStringExtra("nationalCode");
                    bVar.itx = intent.getStringExtra("userName");
                    bVar.ity = intent.getStringExtra("telNumber");
                    bVar.itv = intent.getStringExtra("addressPostalCode");
                    bVar.its = intent.getStringExtra("proviceFirstStageName");
                    bVar.itt = intent.getStringExtra("addressCitySecondStageName");
                    bVar.itu = intent.getStringExtra("addressCountiesThirdStageName");
                    bVar.itw = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
