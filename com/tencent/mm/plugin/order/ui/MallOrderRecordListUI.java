package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI extends WalletBaseUI {
    public MMLoadMoreListView kwZ;
    public boolean kxr = false;
    public Dialog lOO = null;
    public int mCount = 0;
    public ae mHandler = null;
    public boolean nrj = true;
    public a ohR = null;
    public List<i> ohS = new ArrayList();
    protected String ohT = null;
    public boolean ohU = false;
    protected Map<String, String> ohV = new HashMap();
    public int wa = 0;

    protected class a extends BaseAdapter {
        final /* synthetic */ MallOrderRecordListUI ohW;

        protected a(MallOrderRecordListUI mallOrderRecordListUI) {
            this.ohW = mallOrderRecordListUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return qY(i);
        }

        public final int getCount() {
            return this.ohW.ohS.size();
        }

        private i qY(int i) {
            return (i) this.ohW.ohS.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            Object obj;
            String cI;
            int i2;
            if (view == null) {
                view = View.inflate(this.ohW, R.i.dib, null);
                bVar = new b(this.ohW);
                bVar.ohY = (TextView) view.findViewById(R.h.cqa);
                bVar.oia = (TextView) view.findViewById(R.h.cpZ);
                bVar.ohZ = (TextView) view.findViewById(R.h.cpY);
                bVar.oib = (TextView) view.findViewById(R.h.cpW);
                bVar.oid = view.findViewById(R.h.cpT);
                bVar.oie = (TextView) view.findViewById(R.h.cpV);
                bVar.oif = (TextView) view.findViewById(R.h.cpU);
                bVar.oic = (TextView) view.findViewById(R.h.cpX);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            i qY = qY(i);
            if (i == 0) {
                i qY2 = qY(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(((long) qY2.ogM) * 1000);
                obj = 1;
                cI = MallOrderRecordListUI.cH(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
            } else {
                i qY3 = qY(i);
                i qY4 = qY(i - 1);
                if (qY3.ogM > 0 && qY4.ogM > 0) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(((long) qY4.ogM) * 1000);
                    GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar3.setTimeInMillis(((long) qY3.ogM) * 1000);
                    if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                        i2 = 1;
                        cI = MallOrderRecordListUI.cH(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                    }
                }
                obj = null;
                cI = null;
            }
            if (obj != null) {
                bVar.oie.setText(new SimpleDateFormat(this.ohW.getString(R.l.emg, new Object[]{""})).format(new Date(((long) qY(i).ogM) * 1000)));
                if (!(bg.mA(cI) || bg.mA((String) this.ohW.ohV.get(cI)))) {
                    bVar.oif.setText((CharSequence) this.ohW.ohV.get(cI));
                }
                bVar.oid.setVisibility(0);
            } else {
                bVar.oid.setVisibility(8);
            }
            bVar.ohY.setText(qY.ogL);
            bVar.ohZ.setText(qY.ogN);
            i2 = this.ohW.uSU.uTo.getResources().getColor(R.e.aUV);
            if (!bg.mA(qY.ogZ)) {
                try {
                    i2 = Color.parseColor(qY.ogZ);
                } catch (Exception e) {
                    w.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bg.mz(qY.ogZ));
                }
            }
            bVar.ohZ.setTextColor(i2);
            bVar.oia.setText(this.ohW.qX(qY.ogM));
            i2 = this.ohW.uSU.uTo.getResources().getColor(R.e.aUW);
            if (!bg.mA(qY.oha)) {
                try {
                    i2 = Color.parseColor(qY.oha);
                } catch (Exception e2) {
                    w.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bg.mz(qY.oha));
                }
            }
            if (qY.ogK != qY.ohb) {
                Object d = e.d(qY.ogK / 100.0d, qY.ogP);
                CharSequence spannableString = new SpannableString(d);
                spannableString.setSpan(new StrikethroughSpan(), 0, d.length(), 33);
                bVar.oib.setText(spannableString);
            } else {
                bVar.oib.setText("");
            }
            bVar.oic.setTextColor(i2);
            bVar.oic.setText(e.d(qY.ohb / 100.0d, qY.ogP));
            return view;
        }
    }

    private class b {
        final /* synthetic */ MallOrderRecordListUI ohW;
        TextView ohY;
        TextView ohZ;
        TextView oia;
        TextView oib;
        TextView oic;
        View oid;
        TextView oie;
        TextView oif;

        public b(MallOrderRecordListUI mallOrderRecordListUI) {
            this.ohW = mallOrderRecordListUI;
        }
    }

    protected final int getLayoutId() {
        return R.i.dia;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ae();
        aRK();
        KC();
        this.wa = 0;
        this.ohT = null;
    }

    public void aRK() {
        hn(388);
        hn(389);
    }

    public void aRL() {
        ho(388);
        ho(389);
    }

    public void onResume() {
        super.onResume();
        if (this.ohR != null) {
            this.ohR.notifyDataSetChanged();
        }
    }

    public void db(String str, String str2) {
        k(new g(str, str2, 1));
    }

    public void aRM() {
        k(new com.tencent.mm.plugin.order.model.e(this.wa, this.ohT));
    }

    protected final void KC() {
        if (com.tencent.mm.wallet_core.a.ai(this) instanceof com.tencent.mm.plugin.order.a.a) {
            this.kxr = true;
            aRM();
        }
        zi(R.l.ezy);
        this.kwZ = (MMLoadMoreListView) findViewById(R.h.chE);
        this.ohR = new a(this);
        this.kwZ.setAdapter(this.ohR);
        this.kwZ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallOrderRecordListUI ohW;

            {
                this.ohW = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Activity activity = this.ohW;
                if (i < activity.ohS.size()) {
                    i iVar = (i) activity.ohS.get(i);
                    if (iVar != null) {
                        Bundle bundle = activity.uT;
                        bundle.putString("key_trans_id", iVar.ogJ);
                        bundle.putInt("key_pay_type", iVar.ogR);
                        bundle.putString("bill_id", iVar.ohc);
                        com.tencent.mm.wallet_core.a.k(activity, bundle);
                    }
                }
                e.CM(26);
            }
        });
        this.kwZ.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ MallOrderRecordListUI ohW;

            {
                this.ohW = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (i < this.ohW.ohS.size()) {
                    com.tencent.mm.ui.base.g.a(this.ohW, this.ohW.getResources().getString(R.l.fhz), null, this.ohW.getResources().getString(R.l.dGB), new c(this) {
                        final /* synthetic */ AnonymousClass2 ohX;

                        public final void hq(int i) {
                            switch (i) {
                                case 0:
                                    i iVar = (i) this.ohX.ohW.ohS.get(i);
                                    if (iVar != null) {
                                        this.ohX.ohW.db(iVar.ogJ, iVar.ohc);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                return true;
            }
        });
        this.kwZ.vkV = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ MallOrderRecordListUI ohW;

            {
                this.ohW = r1;
            }

            public final void ajC() {
                if (!this.ohW.kxr) {
                    this.ohW.kxr = true;
                    MallOrderRecordListUI mallOrderRecordListUI = this.ohW;
                    mallOrderRecordListUI.wa += 10;
                    this.ohW.aRM();
                }
            }
        };
        final com.tencent.mm.sdk.b.b ruVar = new ru();
        ruVar.fYM.fYO = "6";
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ MallOrderRecordListUI ohW;

            public final void run() {
                if (bg.mA(ruVar.fYN.fYP)) {
                    w.i("MicroMsg.WalletOrderListUI", "no bulletin data");
                } else {
                    e.a((TextView) this.ohW.findViewById(R.h.bsx), ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
        com.tencent.mm.plugin.order.a.b.aRw().adZ();
        this.ohR.notifyDataSetChanged();
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
        Object[] objArr = new Object[1];
        com.tencent.mm.plugin.order.a.b.aRw();
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.order.a.b.aRz().aRE());
        gVar.i(11036, objArr);
    }

    public final void aX(List<i> list) {
        if (list != null && list.size() != 0) {
            if (this.ohS == null) {
                this.ohS = new ArrayList();
            }
            for (int i = 0; i < list.size(); i++) {
                i iVar = (i) list.get(i);
                if (!Cs(iVar.ogJ)) {
                    this.ohS.add(iVar);
                }
            }
        }
    }

    private boolean Cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.ohS.size(); i++) {
            i iVar = (i) this.ohS.get(i);
            if (iVar != null && str.equals(iVar.ogJ)) {
                return true;
            }
        }
        return false;
    }

    public void onDestroy() {
        aRL();
        super.onDestroy();
    }

    public String qX(int i) {
        return e.CL(i);
    }

    public final void aY(List<d> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                d dVar = (d) list.get(i);
                if (dVar != null) {
                    this.ohV.put(cH(dVar.year, dVar.month), dVar.ogD);
                }
            }
        }
    }

    private static String cH(int i, int i2) {
        return i + "-" + i2;
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.order.model.e) {
            if (this.lOO != null) {
                this.lOO.dismiss();
                this.lOO = null;
            }
            com.tencent.mm.plugin.order.model.e eVar = (com.tencent.mm.plugin.order.model.e) kVar;
            this.ohT = eVar.ogG;
            aX(eVar.ogE);
            aY(eVar.ogF);
            this.mCount = this.ohS.size();
            this.nrj = eVar.kAx > this.mCount;
            this.ohR.notifyDataSetChanged();
            w.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            w.d("MicroMsg.WalletOrderListUI", "orders list total record: " + eVar.kAx);
            w.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.nrj);
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ MallOrderRecordListUI ohW;

                {
                    this.ohW = r1;
                }

                public final void run() {
                    if (this.ohW.nrj) {
                        w.v("MicroMsg.WalletOrderListUI", "has more");
                        if (!this.ohW.ohU) {
                            this.ohW.kwZ.bSh();
                            this.ohW.kwZ.setAdapter(this.ohW.ohR);
                            this.ohW.ohU = true;
                        }
                    } else {
                        w.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                        this.ohW.kwZ.bSi();
                    }
                    this.ohW.ohR.notifyDataSetChanged();
                }
            });
            this.kxr = false;
        } else if (kVar instanceof g) {
            if (this.lOO != null) {
                this.lOO.dismiss();
                this.lOO = null;
            }
            g gVar = (g) kVar;
            if (gVar.aRF() == 2) {
                if (this.ohS != null) {
                    this.ohS.clear();
                }
                this.mCount = 0;
                this.nrj = false;
                this.kwZ.bSi();
            } else {
                String aRG = gVar.aRG();
                w.d("MicroMsg.WalletOrderListUI", "delete transId:" + aRG);
                if (!bg.mA(aRG)) {
                    for (i iVar : this.ohS) {
                        if (aRG.equals(iVar.ogJ)) {
                            this.ohS.remove(iVar);
                            this.mCount = this.ohS.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ MallOrderRecordListUI ohW;

                {
                    this.ohW = r1;
                }

                public final void run() {
                    this.ohW.ohR.notifyDataSetChanged();
                }
            });
        }
        if (this.mCount > 0 || this.ohS.size() != 0) {
            ks(true);
            findViewById(R.h.bLY).setVisibility(8);
        } else {
            ks(false);
            findViewById(R.h.bLY).setVisibility(0);
        }
        return true;
    }
}
