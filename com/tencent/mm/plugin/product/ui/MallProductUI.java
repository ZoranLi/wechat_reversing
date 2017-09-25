package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.f;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MallProductUI extends MallBaseUI implements j.a {
    private TextView kBi;
    private Button liz;
    protected c oqU;
    private HtmlTextView oqz;
    private f orD;
    private TextView orx;
    private ListView osc;
    private a osd;
    private LinearLayout osf;
    private LinearLayout osg;
    private ImageView osh;
    private TextView osi;
    private HtmlTextView osj;
    private RelativeLayout osk;
    private ListView osl;
    private k osm = null;
    private Button osn;

    static /* synthetic */ void d(MallProductUI mallProductUI) {
        List list = mallProductUI.oqU.ooW;
        if (list != null && list.size() > 0) {
            mallProductUI.osm.orN = list;
        }
    }

    protected final int getLayoutId() {
        return R.i.dll;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            return;
        }
        KC();
        com.tencent.mm.plugin.product.a.a.aSQ();
        this.oqU = com.tencent.mm.plugin.product.a.a.aSR();
        this.orD = new f(this.uSU.uTo, new f.a(this) {
            final /* synthetic */ MallProductUI oso;

            {
                this.oso = r1;
            }

            public final void n(int i, int i2, String str) {
                if (i == 0 && i2 == 0) {
                    this.oso.ar();
                    if (this.oso.liz != null) {
                        this.oso.liz.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 osp;

                            {
                                this.osp = r1;
                            }

                            public final void run() {
                                ScrollView scrollView = (ScrollView) this.osp.oso.findViewById(R.h.ciz);
                                if (scrollView != null) {
                                    scrollView.pageScroll(33);
                                }
                            }
                        }, 200);
                    }
                } else if (i2 == -10010003) {
                    this.oso.re(0);
                    this.oso.osf.setVisibility(8);
                    this.oso.osg.setVisibility(0);
                    MallProductUI.d(this.oso);
                } else {
                    this.oso.Cz(str);
                }
            }
        });
        f fVar = this.orD;
        ap.vL().a(new com.tencent.mm.plugin.product.ui.f.AnonymousClass1(fVar, getIntent(), new m()));
        fVar.oqS = true;
        b lnVar = new ln();
        lnVar.fSx.errCode = -1;
        lnVar.nFq = new com.tencent.mm.plugin.product.ui.f.AnonymousClass2(fVar, lnVar);
        com.tencent.mm.sdk.b.a.urY.a(lnVar, Looper.getMainLooper());
    }

    protected void onResume() {
        super.onResume();
        this.orD.onStart();
    }

    protected void onPause() {
        this.orD.onStop();
        super.onPause();
    }

    protected final void KC() {
        zi(R.l.eAi);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallProductUI oso;

            {
                this.oso = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f e = this.oso.orD;
                if (!bg.mA(e.oqU.ooX)) {
                    ap.vd().a(new f(e.oqU.aTg(), e.oqU.ooX), 0);
                }
                e.oqU.clear();
                this.oso.finish();
                return true;
            }
        });
        this.osf = (LinearLayout) findViewById(R.h.chO);
        this.osg = (LinearLayout) findViewById(R.h.cij);
        this.osh = (ImageView) findViewById(R.h.chM);
        this.kBi = (TextView) findViewById(R.h.chI);
        this.orx = (TextView) findViewById(R.h.chR);
        this.osi = (TextView) findViewById(R.h.chP);
        this.osi.getPaint().setFlags(16);
        this.osk = (RelativeLayout) findViewById(R.h.chK);
        this.oqz = (HtmlTextView) findViewById(R.h.chJ);
        this.osj = (HtmlTextView) findViewById(R.h.chQ);
        this.osc = (ListView) findViewById(R.h.chH);
        this.osd = new a(this);
        this.osc.setAdapter(this.osd);
        this.osc.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallProductUI oso;

            {
                this.oso = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 2:
                        m mVar = this.oso.oqU.ooV;
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
                this.oso.osd.a(this.oso, view, i);
            }
        });
        this.osn = (Button) findViewById(R.h.cib);
        this.osn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductUI oso;

            {
                this.oso = r1;
            }

            public final void onClick(View view) {
                f e = this.oso.orD;
                e.Q(e.oqR, e.oqU.aSZ());
            }
        });
        this.osl = (ListView) findViewById(R.h.cik);
        this.osm = new k(this);
        this.osm.orG = new OnItemClickListener(this) {
            final /* synthetic */ MallProductUI oso;

            {
                this.oso = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m mVar = (m) view.getTag();
                f e = this.oso.orD;
                if (mVar != null && mVar.orR != null) {
                    n.a aVar = mVar.orR;
                    w.i("MicroMsg.MallProductUI", "goProductUI type : " + aVar.type);
                    Intent intent;
                    switch (aVar.type) {
                        case 0:
                            intent = new Intent();
                            intent.putExtra("rawUrl", aVar.url);
                            d.b(e.oqR, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                            return;
                        case 1:
                            String replace = aVar.data.replace("product_id=", "");
                            intent = new Intent();
                            intent.putExtra("key_product_id", replace);
                            intent.putExtra("key_product_scene", 6);
                            d.b(e.oqR, "mall", ".product.ui.MallProductUI", intent);
                            e.oqR.finish();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.osl.setAdapter(this.osm);
        this.liz = (Button) findViewById(R.h.chL);
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductUI oso;

            {
                this.oso = r1;
            }

            public final void onClick(View view) {
                f e = this.oso.orD;
                if (e.oqU.aTd()) {
                    e.oqR.startActivity(new Intent(e.oqR, MallProductSelectSkuUI.class));
                    g.oUh.i(11008, new Object[]{e.oqU.aSZ(), e.oqU.ooV.opv, Integer.valueOf(f.hPi), Integer.valueOf(1)});
                    return;
                }
                s.makeText(e.oqR, R.l.ezP, 1).show();
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallProductUI oso;

            {
                this.oso = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray = this.oso.getResources().getStringArray(R.c.aSh);
                List arrayList = new ArrayList();
                for (Object add : stringArray) {
                    arrayList.add(add);
                }
                boolean z = (this.oso.oqU.aST().oqP & 1) > 0;
                w.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = " + z);
                if (z) {
                    arrayList.add(this.oso.getString(R.l.ezX));
                }
                com.tencent.mm.ui.base.g.a(this.oso.uSU.uTo, null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass7 osq;

                    {
                        this.osq = r1;
                    }

                    public final void hq(int i) {
                        f e;
                        String aTj;
                        Intent intent;
                        switch (i) {
                            case 0:
                                e = this.osq.oso.orD;
                                aTj = e.oqU.aTj();
                                intent = new Intent();
                                intent.putExtra("Retr_Msg_content", aTj);
                                intent.putExtra("Retr_Msg_Type", 2);
                                if (!bg.mA(e.oqU.ooV.aTm())) {
                                    intent.putExtra("Retr_Msg_thumb_path", e.oqU.aTa());
                                }
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                intent.putExtra("Retr_Msg_Type", 2);
                                d.a(e.oqR, ".ui.transmit.MsgRetransmitUI", intent);
                                if (f.hPi == 4) {
                                    g.oUh.i(10651, new Object[]{Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0)});
                                    return;
                                }
                                return;
                            case 1:
                                e = this.osq.oso.orD;
                                m mVar = e.oqU.ooV;
                                intent = new Intent();
                                intent.putExtra("KContentObjDesc", e.oqU.aTk());
                                intent.putExtra("Ksnsupload_title", mVar.opz.name);
                                intent.putExtra("Ksnsupload_link", e.oqU.aTb());
                                intent.putExtra("Ksnsupload_imgurl", e.oqU.ooV.aTm());
                                if (!bg.mA(e.oqU.ooV.aTm())) {
                                    intent.putExtra("KsnsUpload_imgPath", e.oqU.aTa());
                                }
                                intent.putExtra("Ksnsupload_type", 6);
                                intent.putExtra("KUploadProduct_UserData", e.oqU.a(mVar));
                                intent.putExtra("KUploadProduct_subType", mVar.opw);
                                aTj = q.fQ("scan_product");
                                q.yC().n(aTj, true).l("prePublishId", "scan_product");
                                intent.putExtra("reportSessionId", aTj);
                                d.b(e.oqR, "sns", ".ui.En_c4f742e5", intent);
                                if (f.hPi == 4) {
                                    g.oUh.i(10651, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0)});
                                    return;
                                }
                                return;
                            case 2:
                                this.osq.oso.orD.aTq();
                                return;
                            case 3:
                                e = this.osq.oso.orD;
                                e.P(e.oqR, e.oqU.aSZ());
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        ks(false);
        this.osh.setFocusable(true);
        this.osh.setFocusableInTouchMode(true);
        this.osh.requestFocus();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        w.v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
    }

    protected final void ar() {
        m mVar = this.oqU.ooV;
        if (mVar == null) {
            ks(false);
            return;
        }
        ks(true);
        re(0);
        this.osf.setVisibility(0);
        this.osg.setVisibility(8);
        if (mVar.opz != null) {
            this.kBi.setText(mVar.opz.name);
            this.orx.setText(com.tencent.mm.plugin.product.b.b.m(mVar.opz.opM, mVar.opz.opN, mVar.opz.oga));
            this.osi.setText(com.tencent.mm.plugin.product.b.b.c((double) mVar.opz.opL, mVar.opz.oga));
        }
        if (this.oqU.aTc() <= 0) {
            this.liz.setEnabled(false);
            this.liz.setText(R.l.ezZ);
        } else if (this.oqU.ooV.opy <= 0) {
            this.liz.setEnabled(false);
            this.liz.setText(R.l.ezY);
        } else {
            this.liz.setEnabled(true);
            if (bg.mA(mVar.opE)) {
                this.liz.setText(R.l.chL);
            } else {
                this.liz.setText(mVar.opE);
            }
        }
        if (mVar.opz == null || mVar.opz.opW == null || mVar.opz.opW.size() <= 0) {
            this.osc.setVisibility(8);
        } else {
            this.osc.setVisibility(0);
            this.osd.aZ(mVar.opz.opW);
            this.osd.notifyDataSetChanged();
        }
        if (mVar.opz == null || bg.mA(mVar.opz.opP)) {
            this.osk.setVisibility(8);
            this.oqz.setVisibility(8);
        } else {
            this.osk.setVisibility(0);
            this.oqz.setVisibility(0);
            this.oqz.setText(mVar.opz.opP);
        }
        if (bg.mA(mVar.opF)) {
            this.osj.setVisibility(8);
        } else {
            this.osj.setVisibility(0);
            this.osj.setText(mVar.opF);
        }
        ks(true);
        if (!bg.mA(this.oqU.opd)) {
            this.osh.setImageBitmap(j.a(new c(this.oqU.opd)));
            j.a(this);
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        if (str != null && str.equals(this.oqU.opd)) {
            this.osh.post(new Runnable(this) {
                final /* synthetic */ MallProductUI oso;

                public final void run() {
                    this.oso.osh.setImageBitmap(bitmap);
                }
            });
        }
    }
}
