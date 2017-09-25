package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;

public class MallProductSelectSkuUI extends MallBaseUI implements a {
    private TextView jhl;
    private m ooV;
    private e opk;
    private c oqU;
    private ListView orA;
    private MallProductSelectAmountView orB = null;
    private i orC = null;
    private f orD;
    private ImageView orw;
    private TextView orx;
    private TextView ory;
    private Button orz;

    protected final int getLayoutId() {
        return R.i.dlh;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.orD = new f(this.uSU.uTo, new f.a(this) {
            final /* synthetic */ MallProductSelectSkuUI orE;

            {
                this.orE = r1;
            }

            public final void n(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    this.orE.ar();
                } else {
                    this.orE.Cz(str);
                }
            }
        });
        com.tencent.mm.plugin.product.a.a.aSQ();
        this.oqU = com.tencent.mm.plugin.product.a.a.aSR();
        this.ooV = this.oqU.ooV;
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
        zi(R.l.ezV);
        this.orw = (ImageView) findViewById(R.h.chW);
        this.jhl = (TextView) findViewById(R.h.cia);
        this.orx = (TextView) findViewById(R.h.chY);
        this.ory = (TextView) findViewById(R.h.chV);
        this.orz = (Button) findViewById(R.h.chX);
        this.orA = (ListView) findViewById(R.h.cid);
        this.orB = (MallProductSelectAmountView) findViewById(R.h.cBA);
        MallProductSelectAmountView mallProductSelectAmountView = this.orB;
        mallProductSelectAmountView.ort = this.oqU.mCount;
        if (mallProductSelectAmountView.aTs()) {
            mallProductSelectAmountView.ioZ.setText(mallProductSelectAmountView.ort);
            if (mallProductSelectAmountView.oru != null) {
                mallProductSelectAmountView.oru.cX(mallProductSelectAmountView.ort);
            }
        }
        this.orC = new i(this);
        if (this.ooV == null || this.ooV.opz == null || this.ooV.opz.opV == null) {
            w.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.orC.orF = this.ooV.opz.opV;
        }
        this.orC.orG = new OnItemClickListener(this) {
            final /* synthetic */ MallProductSelectSkuUI orE;

            {
                this.orE = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e eVar = null;
                Pair pair = (Pair) view.getTag();
                MallProductSelectSkuUI mallProductSelectSkuUI = this.orE;
                c b = this.orE.oqU;
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                w.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
                if (b.oph.containsKey(str) && ((String) b.oph.get(str)).equals(str2)) {
                    b.oph.remove(str);
                    b.ooZ = c.F(b.oph);
                    b.opk = b.opg != null ? (e) b.opg.get(b.ooZ) : null;
                } else {
                    b.oph.put(str, str2);
                    b.ooZ = c.F(b.oph);
                    w.d("MicroMsg.MallProductManager", "getSkuInfoId (" + b.ooZ + ")");
                    if (b.opg != null) {
                        b.opk = (e) b.opg.get(b.ooZ);
                    }
                    mallProductSelectSkuUI.opk = eVar;
                    this.orE.ar();
                }
                b.aTi();
                eVar = b.opk;
                mallProductSelectSkuUI.opk = eVar;
                this.orE.ar();
            }
        };
        this.orA.setAdapter(this.orC);
        this.orB.oru = new MallProductSelectAmountView.a(this) {
            final /* synthetic */ MallProductSelectSkuUI orE;

            {
                this.orE = r1;
            }

            public final void cX(int i) {
                this.orE.oqU.mCount = i;
                this.orE.ory.setVisibility(8);
            }

            public final void cJ(int i, int i2) {
                switch (i2) {
                    case 1:
                        this.orE.ory.setText(R.l.ezT);
                        this.orE.ory.setVisibility(0);
                        return;
                    case 3:
                        this.orE.ory.setText(this.orE.getString(R.l.ezU, new Object[]{Integer.valueOf(i)}));
                        this.orE.ory.setVisibility(0);
                        return;
                    default:
                        return;
                }
            }
        };
        this.orz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSelectSkuUI orE;

            {
                this.orE = r1;
            }

            public final void onClick(View view) {
                f d = this.orE.orD;
                if (d.oqS) {
                    s.makeText(d.oqR, R.l.ezP, 1).show();
                } else if (!d.oqU.aTe()) {
                    String str;
                    c cVar = d.oqU;
                    if (cVar.oph != null && cVar.oph.size() < cVar.opf && cVar.opf > 0) {
                        Iterator it = cVar.ooV.opz.opV.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.product.c.m mVar = (com.tencent.mm.plugin.product.c.m) it.next();
                            if (!cVar.oph.containsKey(mVar.oqh)) {
                                str = mVar.oqi;
                                break;
                            }
                        }
                    }
                    str = null;
                    if (!bg.mA(str)) {
                        s.makeText(d.oqR, d.oqR.getString(R.l.chV, new Object[]{str}), 0).show();
                    }
                } else if (d.oqU.opb != null) {
                    ap.vd().a(new j(d.oqU.aTg(), f.hPi), 0);
                } else {
                    d.b(d.oqR, "address", ".ui.WalletAddAddressUI", 2);
                }
            }
        });
        this.orw.setFocusable(true);
        this.orw.setFocusableInTouchMode(true);
        this.orw.requestFocus();
    }

    private void ar() {
        if (this.ooV != null) {
            if (this.opk == null || this.ooV.opz == null) {
                this.orx.setText(b.m(this.ooV.opz.opM, this.ooV.opz.opN, this.ooV.opz.oga));
            } else {
                this.orx.setText(b.m(this.opk.opo, this.opk.opp, this.ooV.opz.oga));
            }
            if (this.ooV.opz != null) {
                this.jhl.setText(this.ooV.opz.name);
            }
        }
        if (!bg.mA(this.oqU.aSU())) {
            this.orw.setImageBitmap(com.tencent.mm.platformtools.j.a(new c(this.oqU.aSU())));
            com.tencent.mm.platformtools.j.a(this);
        }
        this.ory.setVisibility(8);
        MallProductSelectAmountView mallProductSelectAmountView = this.orB;
        int aTc = this.oqU.aTc();
        int i = this.oqU.ooV.opy;
        if (aTc > i) {
            mallProductSelectAmountView.orr = 3;
            mallProductSelectAmountView.orq = i;
        } else {
            mallProductSelectAmountView.orr = 1;
            mallProductSelectAmountView.orq = aTc;
        }
        mallProductSelectAmountView.aTs();
        if (mallProductSelectAmountView.oru != null) {
            mallProductSelectAmountView.oru.cX(mallProductSelectAmountView.ort);
        }
        this.orC.notifyDataSetChanged();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.orD.onActivityResult(i, i2, intent);
    }

    public final void k(String str, final Bitmap bitmap) {
        w.d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (!bg.mA(this.oqU.aSU())) {
            this.orw.post(new Runnable(this) {
                final /* synthetic */ MallProductSelectSkuUI orE;

                public final void run() {
                    this.orE.orw.setImageBitmap(bitmap);
                }
            });
        }
    }
}
