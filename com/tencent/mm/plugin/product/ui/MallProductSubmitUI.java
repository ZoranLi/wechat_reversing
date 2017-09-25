package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MallProductSubmitUI extends MallBaseUI implements a {
    private TextView jhl;
    private Button liz;
    private e opk;
    private c oqU;
    private f orD;
    private RelativeLayout orT;
    private TextView orU;
    private TextView orV;
    private MallProductItemView orW;
    private MallProductItemView orX;
    private TextView orY;
    private TextView orZ;
    private ImageView orw;
    private TextView orx;
    private TextView osa;
    private TextView osb;
    private ListView osc;
    private a osd;

    protected final int getLayoutId() {
        return R.i.dlk;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.orD = new f(this.uSU.uTo, new f.a(this) {
            final /* synthetic */ MallProductSubmitUI ose;

            {
                this.ose = r1;
            }

            public final void n(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    this.ose.ar();
                } else {
                    this.ose.Cz(str);
                }
            }
        });
        com.tencent.mm.plugin.product.a.a.aSQ();
        this.oqU = com.tencent.mm.plugin.product.a.a.aSR();
        this.opk = this.oqU.opk;
        KC();
        ar();
    }

    public void onStart() {
        this.orD.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.orD.onStop();
        super.onStop();
    }

    protected final void KC() {
        zi(R.l.eAh);
        this.orT = (RelativeLayout) findViewById(R.h.cil);
        this.orU = (TextView) findViewById(R.h.cin);
        this.orV = (TextView) findViewById(R.h.cim);
        this.orW = (MallProductItemView) findViewById(R.h.cio);
        this.orX = (MallProductItemView) findViewById(R.h.ciq);
        this.orw = (ImageView) findViewById(R.h.cip);
        this.jhl = (TextView) findViewById(R.h.cix);
        this.orY = (TextView) findViewById(R.h.cir);
        this.orx = (TextView) findViewById(R.h.civ);
        this.orZ = (TextView) findViewById(R.h.ciu);
        this.osa = (TextView) findViewById(R.h.cit);
        this.osb = (TextView) findViewById(R.h.ciy);
        this.osc = (ListView) findViewById(R.h.cis);
        this.osd = new a(this);
        this.osc.setAdapter(this.osd);
        this.osc.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallProductSubmitUI ose;

            {
                this.ose = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 1:
                        if (bVar.oqA instanceof String) {
                            this.ose.oqU.ope = (String) bVar.oqA;
                            break;
                        }
                        break;
                    case 2:
                        m mVar = this.ose.oqU.ooV;
                        if (mVar.opz.opO != null && mVar.opz.opO.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = mVar.opz.opO.iterator();
                            while (it.hasNext()) {
                                arrayList.add((String) it.next());
                            }
                            bVar.oqA = arrayList;
                            break;
                        }
                }
                this.ose.osd.a(this.ose, view, i);
            }
        });
        this.liz = (Button) findViewById(R.h.ciw);
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI ose;

            {
                this.ose = r1;
            }

            public final void onClick(View view) {
                f d = this.ose.orD;
                if (d.oqU.aTf()) {
                    int i;
                    if (d.oqU.aSW() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        n vd = ap.vd();
                        bal aTh = d.oqU.aTh();
                        d.oqU.getAppId();
                        vd.a(new k(aTh), 0);
                        return;
                    }
                    ap.vd().a(new l(d.oqU.aTh(), d.oqU.getAppId()), 0);
                }
            }
        });
        this.orT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI ose;

            {
                this.ose = r1;
            }

            public final void onClick(View view) {
                f d = this.ose.orD;
                Intent intent = new Intent();
                intent.putExtra("launch_from_webview", true);
                d.a(d.oqR, "address", ".ui.WalletSelectAddrUI", intent, 1, false);
            }
        });
        this.orW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI ose;

            {
                this.ose = r1;
            }

            public final void onClick(View view) {
                this.ose.showDialog(1);
            }
        });
        this.orX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI ose;

            {
                this.ose = r1;
            }

            public final void onClick(View view) {
                f d = this.ose.orD;
                d.oqR.startActivityForResult(new Intent(d.oqR, MallProductReceiptUI.class), 4);
            }
        });
        MallProductItemView mallProductItemView = this.orX;
        boolean z = (this.oqU.aST().oqQ & 2) > 0;
        w.d("MicroMsg.MallProductConfig", "hasReceipt, ret = " + z);
        mallProductItemView.setVisibility(z ? 0 : 8);
        if (this.oqU.aST().aTp()) {
            this.orW.setEnabled(false);
            this.orW.setClickable(false);
            this.orW.CB(getString(R.l.eAg));
        }
    }

    private void ar() {
        m mVar = this.oqU.ooV;
        if (this.opk != null) {
            this.orx.setText(b.m(this.opk.opo, this.opk.opo, mVar.opz.oga) + " x " + this.oqU.mCount);
        } else {
            this.orx.setText(b.m(mVar.opz.opM, mVar.opz.opN, mVar.opz.oga));
        }
        if (!bg.mA(this.oqU.aSU())) {
            this.orw.setImageBitmap(j.a(new c(this.oqU.aSU())));
            j.a(this);
        }
        this.jhl.setText(mVar.opz.name);
        this.orY.setText(this.oqU.aSV());
        aue aSY = this.oqU.aSY();
        if (aSY == null || bg.mA(aSY.mtg)) {
            this.orX.CB("");
        } else {
            this.orX.CB(aSY.mtg);
        }
        String str = "";
        if (!this.oqU.aST().aTp()) {
            qe qeVar = this.oqU.opa;
            if (qeVar != null) {
                this.orW.setEnabled(true);
                this.orW.setClickable(true);
                this.orW.CB(b.a(this, qeVar));
                str = getString(R.l.eAe, new Object[]{b.c((double) qeVar.tmm, qeVar.tvh)});
                this.orV.setVisibility(8);
            } else {
                this.orW.setEnabled(false);
                this.orW.setClickable(false);
                this.orW.CB(getString(R.l.eAf));
                this.orV.setVisibility(0);
            }
        }
        String str2 = "";
        if (this.oqU.aSX() > 0) {
            bg.mA(str);
            str2 = getString(R.l.eAd, new Object[]{b.c((double) r3, mVar.opz.oga)});
        }
        List N = this.oqU.N((Activity) this);
        if (N.size() > 0) {
            this.osc.setVisibility(0);
            this.osd.aZ(N);
            this.osd.notifyDataSetChanged();
        } else {
            this.osc.setVisibility(8);
        }
        if (this.oqU.opb != null) {
            this.orU.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[]{r3.jNj, r3.tfs, r3.hAE, r3.hAF, r3.mtg})));
        }
        if (bg.mA(str + str2)) {
            this.osa.setVisibility(0);
            this.orZ.setVisibility(8);
        } else {
            this.orZ.setText(getString(R.l.eAc, new Object[]{str}));
            this.osa.setVisibility(8);
            this.orZ.setVisibility(0);
        }
        this.osb.setText(b.c((double) this.oqU.aSW(), mVar.opz.oga));
        this.liz.setEnabled(this.oqU.aTf());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.orD.onActivityResult(i, i2, intent);
    }

    public final void k(String str, final Bitmap bitmap) {
        w.d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (!bg.mA(this.oqU.aSU())) {
            this.orw.post(new Runnable(this) {
                final /* synthetic */ MallProductSubmitUI ose;

                public final void run() {
                    this.ose.orw.setImageBitmap(bitmap);
                }
            });
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                List<qe> list = this.oqU.opi;
                if (list != null) {
                    List arrayList = new ArrayList();
                    for (qe a : list) {
                        arrayList.add(b.a(this, a));
                    }
                    String string = getString(R.l.cio);
                    OnItemClickListener anonymousClass8 = new OnItemClickListener(this) {
                        final /* synthetic */ MallProductSubmitUI ose;

                        {
                            this.ose = r1;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            this.ose.dismissDialog(1);
                            this.ose.oqU.rd(i);
                            this.ose.ar();
                        }
                    };
                    ListAdapter aVar = new a(this);
                    ListView listView = (ListView) View.inflate(this, R.i.diA, null);
                    listView.setOnItemClickListener(new com.tencent.mm.plugin.product.ui.d.AnonymousClass1(anonymousClass8, aVar));
                    aVar.oqK = arrayList;
                    aVar.oqL = 0;
                    listView.setAdapter(aVar);
                    h.a aVar2 = new h.a(this);
                    aVar2.SW(string);
                    aVar2.dd(listView);
                    aVar2.d(null);
                    Dialog WJ = aVar2.WJ();
                    WJ.show();
                    return WJ;
                }
                break;
        }
        return super.onCreateDialog(i);
    }
}
