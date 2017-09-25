package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter {
    private final Activity fPi;
    final List<alh> fRK = new ArrayList();
    private final ae handler = new ae();
    private String naR = "";
    final Map<Integer, Integer> qoV = new HashMap();
    final Map<Integer, Integer> qoW = new HashMap();
    int qoX = 0;
    int qoY = 0;
    private final b qoZ;
    private final g qpa;
    final a qpb;

    public interface a {
        void a(dl dlVar);

        void bic();
    }

    static abstract class b {
        OnClickListener qpd = new OnClickListener(this) {
            final /* synthetic */ b qph;

            {
                this.qph = r1;
            }

            public final void onClick(View view) {
                this.qph.qpg = (a) view.getTag();
                this.qph.tJ(this.qph.qpg.position);
            }
        };
        OnClickListener qpe = new OnClickListener(this) {
            final /* synthetic */ b qph;

            {
                this.qph = r1;
            }

            public final void onClick(View view) {
                this.qph.qpg = (a) view.getTag();
                this.qph.tJ(this.qph.qpg.position);
            }
        };
        OnClickListener qpf = new OnClickListener(this) {
            final /* synthetic */ b qph;

            {
                this.qph = r1;
            }

            public final void onClick(View view) {
                this.qph.qpg = (a) view.getTag();
                this.qph.tJ(this.qph.qpg.position);
            }
        };
        public a qpg = new a();

        public static class a {
            public String fVJ;
            public int position;
        }

        public abstract void tJ(int i);
    }

    class c {
        TextView iUO;
        final /* synthetic */ f qpc;
        TextView qpi;
        ImageView qpj;
        ImageView qpk;
        ImageView qpl;
        LinearLayout qpm;
        View qpn;

        c(f fVar) {
            this.qpc = fVar;
        }
    }

    public f(Activity activity, String str, b bVar, a aVar) {
        this.fPi = activity;
        this.naR = str;
        this.qoZ = bVar;
        this.qpb = aVar;
        this.qpa = new g(new com.tencent.mm.plugin.sns.ui.g.a(this) {
            final /* synthetic */ f qpc;

            {
                this.qpc = r1;
            }

            public final void a(List<alh> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, dl dlVar) {
                w.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
                f fVar = this.qpc;
                if (list != null && list.size() > 0) {
                    int intValue;
                    try {
                        fVar.qpb.a((dl) new dl().aD(dlVar.toByteArray()));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ArtistAdapter", e, "", new Object[0]);
                    }
                    w.d("MicroMsg.ArtistAdapter", "copy list info");
                    int size = list.size();
                    fVar.fRK.clear();
                    fVar.qoV.clear();
                    fVar.qoW.clear();
                    for (int i3 = 0; i3 < size; i3++) {
                        alh com_tencent_mm_protocal_c_alh = (alh) list.get(i3);
                        fVar.fRK.add(e.a(com_tencent_mm_protocal_c_alh.mQY, com_tencent_mm_protocal_c_alh.jOc, com_tencent_mm_protocal_c_alh.msN, com_tencent_mm_protocal_c_alh.tPi, com_tencent_mm_protocal_c_alh.tPh, com_tencent_mm_protocal_c_alh.tPj, com_tencent_mm_protocal_c_alh.msk));
                    }
                    for (Integer intValue2 : map.keySet()) {
                        intValue = intValue2.intValue();
                        fVar.qoV.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map.get(Integer.valueOf(intValue))).intValue()));
                    }
                    for (Integer intValue22 : map2.keySet()) {
                        intValue = intValue22.intValue();
                        fVar.qoW.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map2.get(Integer.valueOf(intValue))).intValue()));
                    }
                    list.clear();
                    map.clear();
                    map2.clear();
                    fVar.qoY = i;
                    fVar.qoX = i2;
                    w.d("MicroMsg.ArtistAdapter", "reallyCount " + i + " icount " + i2);
                    fVar.notifyDataSetChanged();
                }
            }

            public final void bib() {
                f fVar = this.qpc;
                if (fVar.qpb != null) {
                    fVar.qpb.bic();
                }
            }
        });
        OK();
    }

    public final void OK() {
        if (this.qpa != null) {
            t.Ic();
            String HY = n.HY();
            w.d("MicroMsg.ArtistAdapter", "packgePath: " + HY);
            this.qpa.dE(this.naR, HY);
        }
    }

    public final int getCount() {
        return this.qoX;
    }

    public final Object getItem(int i) {
        return this.fRK.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c(this);
            view = View.inflate(this.fPi, g.pHn, null);
            cVar.iUO = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFV);
            cVar.qpi = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFW);
            cVar.qpj = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCM);
            cVar.qpk = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCN);
            cVar.qpl = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCO);
            cVar.qpm = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDe);
            cVar.qpn = view.findViewById(com.tencent.mm.plugin.sns.i.f.pDb);
            cVar.qpj.setOnClickListener(this.qoZ.qpd);
            cVar.qpk.setOnClickListener(this.qoZ.qpe);
            cVar.qpl.setOnClickListener(this.qoZ.qpf);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        int intValue = this.qoV.get(Integer.valueOf(i)) != null ? ((Integer) this.qoV.get(Integer.valueOf(i))).intValue() : -1;
        cVar.qpj.setVisibility(8);
        cVar.qpk.setVisibility(8);
        cVar.qpl.setVisibility(8);
        cVar.qpn.setVisibility(8);
        if (cVar.qpc.naR.equals("en")) {
            cVar.iUO.setVisibility(8);
            cVar.qpi.setVisibility(4);
        } else {
            cVar.iUO.setVisibility(4);
            cVar.qpi.setVisibility(8);
        }
        if (intValue >= this.qoY || intValue == -1) {
            view.setLayoutParams(new LayoutParams(-1, 1));
            view.setVisibility(8);
        } else {
            String str = "";
            if (intValue - 1 >= 0) {
                Object obj = ((alh) getItem(intValue - 1)).msk;
            } else {
                String str2 = str;
            }
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setVisibility(0);
            int intValue2 = this.qoW.get(Integer.valueOf(i)) != null ? ((Integer) this.qoW.get(Integer.valueOf(i))).intValue() : 1;
            alh com_tencent_mm_protocal_c_alh = (alh) getItem(intValue);
            if (com_tencent_mm_protocal_c_alh.msk.equals("") || !com_tencent_mm_protocal_c_alh.msk.equals(r4)) {
                if (this.naR.equals("en")) {
                    cVar.qpi.setVisibility(0);
                    cVar.qpi.setText(com_tencent_mm_protocal_c_alh.msk);
                    cVar.qpn.setVisibility(0);
                } else {
                    cVar.iUO.setVisibility(0);
                    cVar.iUO.setText(com_tencent_mm_protocal_c_alh.msk);
                    cVar.qpn.setVisibility(0);
                }
            }
            if (intValue2 > 0) {
                a(intValue, cVar.qpj);
            }
            if (intValue2 >= 2) {
                a(intValue + 1, cVar.qpk);
            }
            if (intValue2 >= 3) {
                a(intValue + 2, cVar.qpl);
            }
        }
        return view;
    }

    private void a(int i, ImageView imageView) {
        alh com_tencent_mm_protocal_c_alh = (alh) getItem(i);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.fVJ = "";
        aVar.position = i;
        imageView.setTag(aVar);
        com.tencent.mm.plugin.sns.model.ae.beI().b(com_tencent_mm_protocal_c_alh, imageView, this.fPi.hashCode(), an.uJM);
    }
}
