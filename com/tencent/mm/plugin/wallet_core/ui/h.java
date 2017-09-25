package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class h extends i {
    private LayoutInflater Du;
    private View khv;
    private MaxListView rKY = ((MaxListView) this.khv.findViewById(R.h.cQB));
    private TextView rKZ = ((TextView) this.khv.findViewById(R.h.cQz));
    private a rLa = new a(this);
    private b rLb;
    private a rzJ;

    class a extends BaseAdapter {
        final /* synthetic */ h rLc;
        int rLd = -1;
        List<p> rLe = new LinkedList();
        com.tencent.mm.plugin.wallet.a.h rLf = null;
        l<String> rLg = new l<String>(this) {
            final /* synthetic */ a rLh;

            {
                this.rLh = r1;
            }

            public final String a(Vector<com.tencent.mm.plugin.wallet_core.model.l.b> vector, int i) {
                if (vector == null) {
                    w.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
                    return "";
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < vector.size(); i2++) {
                    int i3 = ((com.tencent.mm.plugin.wallet_core.model.l.b) vector.get(i2)).rFJ;
                    if (i2 == i || i3 == com.tencent.mm.plugin.wallet_core.model.l.a.rFF) {
                        stringBuilder.append(((String) ((com.tencent.mm.plugin.wallet_core.model.l.b) vector.get(i2)).rFI) + "-");
                    }
                }
                if (stringBuilder.length() == 0) {
                    return "0";
                }
                if (stringBuilder.length() > 1) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                return stringBuilder.toString();
            }
        };

        public a(h hVar) {
            this.rLc = hVar;
        }

        public final int getCount() {
            return this.rLe.size();
        }

        public final Object getItem(int i) {
            return this.rLe.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            e eVar;
            if (view == null) {
                view = this.rLc.Du.inflate(R.i.dqw, viewGroup, false);
                c cVar2 = new c();
                cVar2.rLi = view.findViewById(R.h.cQo);
                cVar2.jhl = (TextView) view.findViewById(R.h.cQn);
                cVar2.rLk = (TextView) view.findViewById(R.h.cQm);
                cVar2.kBi = (TextView) view.findViewById(R.h.cQl);
                cVar2.rLl = (CheckBox) view.findViewById(R.h.cQk);
                cVar2.rLj = (ImageView) view.findViewById(R.h.cQj);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            p pVar = (p) getItem(i);
            if (i != this.rLd || this.rLd <= 0) {
                cVar.rLi.setVisibility(8);
                cVar.rLj.setVisibility(0);
            } else {
                cVar.rLi.setVisibility(0);
                cVar.rLj.setVisibility(8);
            }
            if (bg.mA(pVar.ryw)) {
                cVar.jhl.setVisibility(8);
            } else {
                cVar.jhl.setText(pVar.ryw);
                cVar.jhl.setVisibility(0);
            }
            String str = pVar.rxJ;
            if (!(this.rLf == null || this.rLf.ryf == null)) {
                List list = this.rLf.ryf;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (str.equals(((e) list.get(i2)).rxJ)) {
                        eVar = (e) list.get(i2);
                        break;
                    }
                }
            }
            eVar = null;
            String str2 = pVar.rxK;
            String str3 = pVar.rxL;
            if (eVar != null) {
                CharSequence charSequence = eVar.rxK;
                CharSequence charSequence2 = eVar.rxL;
            } else {
                Object obj = str3;
                Object obj2 = str2;
            }
            if (bg.mA(charSequence)) {
                cVar.rLk.setVisibility(8);
            } else {
                cVar.rLk.setText(charSequence);
                cVar.rLk.setVisibility(0);
            }
            if (bg.mA(charSequence2)) {
                cVar.kBi.setVisibility(8);
            } else {
                cVar.kBi.setText(charSequence2);
                cVar.kBi.setVisibility(0);
            }
            int i3 = ((com.tencent.mm.plugin.wallet_core.model.l.b) this.rLg.rFB.get(i)).rFJ;
            if (i3 == com.tencent.mm.plugin.wallet_core.model.l.a.rFE) {
                cVar.rLl.setChecked(false);
                cVar.rLl.setEnabled(false);
            } else {
                cVar.rLl.setEnabled(true);
                if (i3 == com.tencent.mm.plugin.wallet_core.model.l.a.rFF) {
                    cVar.rLl.setChecked(true);
                } else {
                    cVar.rLl.setChecked(false);
                }
            }
            return view;
        }
    }

    public interface b {
        void a(FavorPayInfo favorPayInfo);
    }

    static final class c {
        TextView jhl;
        TextView kBi;
        View rLi;
        ImageView rLj;
        TextView rLk;
        CheckBox rLl;

        c() {
        }
    }

    private h(Context context) {
        super(context, R.m.foO);
        this.Du = LayoutInflater.from(context);
        this.khv = LayoutInflater.from(context).inflate(R.i.dqz, null);
        this.rKY.setAdapter(this.rLa);
        this.khv.findViewById(R.h.cQA).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ h rLc;

            {
                this.rLc = r1;
            }

            public final void onClick(View view) {
                this.rLc.buR();
                this.rLc.dismiss();
            }
        });
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.khv);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    public static h a(Context context, Orders orders, String str, b bVar) {
        Dialog hVar = new h(context);
        hVar.setOnCancelListener(null);
        hVar.setCancelable(true);
        hVar.rzJ = b.rJj.a(orders);
        if (hVar.rzJ == null) {
            w.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            hVar.dismiss();
        } else {
            int i;
            Object obj;
            a aVar = hVar.rLa;
            f fVar = aVar.rLc.rzJ.rJd;
            String Im = aVar.rLc.rzJ.Im(str);
            aVar.rLe = aVar.rLc.rzJ.buM();
            aVar.rLf = aVar.rLc.rzJ.Ii(Im);
            aVar.rLd = -1;
            for (i = 0; i < aVar.rLe.size(); i++) {
                if ((((p) aVar.rLe.get(i)).ryA != 0 ? 1 : null) != null) {
                    aVar.rLd = i;
                    break;
                }
            }
            List linkedList = new LinkedList();
            if (aVar.rLe != null) {
                for (i = 0; i < aVar.rLe.size(); i++) {
                    linkedList.add(((p) aVar.rLe.get(i)).rxJ);
                }
                List linkedList2 = new LinkedList();
                if (!(fVar == null || fVar.rxQ == null)) {
                    for (i = 0; i < fVar.rxQ.size(); i++) {
                        String str2 = ((p) fVar.rxQ.get(i)).rxJ;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                    }
                }
                List linkedList3 = new LinkedList();
                if (fVar == null || fVar.rxR == null || fVar.rxR.ryb == null) {
                    w.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    obj = null;
                } else {
                    List list = fVar.rxR.ryb;
                    for (i = 0; i < list.size(); i++) {
                        String str3 = ((com.tencent.mm.plugin.wallet.a.h) list.get(i)).ryd;
                        for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                            if (str3.contains((CharSequence) linkedList2.get(i2))) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            linkedList3.add(str3);
                        }
                    }
                    List linkedList4 = new LinkedList();
                    if (!(bg.mA(Im) || Im.equals("0"))) {
                        String[] split = Im.split("-");
                        if (split != null) {
                            for (Object add : split) {
                                linkedList4.add(add);
                            }
                        } else {
                            w.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            obj = null;
                        }
                    }
                    aVar.rLg.c(linkedList, linkedList4, linkedList3);
                    obj = 1;
                }
            } else {
                w.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                obj = null;
            }
            if (obj == null) {
                w.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                hVar.dismiss();
            } else {
                hVar.rKZ.setText(R.l.ffF);
                hVar.rKY.setOnItemClickListener(new OnItemClickListener(hVar) {
                    final /* synthetic */ h rLc;

                    {
                        this.rLc = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        a b = this.rLc.rLa;
                        l lVar = b.rLg;
                        if (i < lVar.rFB.size()) {
                            int i2 = ((com.tencent.mm.plugin.wallet_core.model.l.b) lVar.rFB.get(i)).rFJ;
                            int i3 = com.tencent.mm.plugin.wallet_core.model.l.a.rFF;
                            switch (com.tencent.mm.plugin.wallet_core.model.l.AnonymousClass1.rFD[i2 - 1]) {
                                case 1:
                                    lVar.dt(i, com.tencent.mm.plugin.wallet_core.model.l.a.rFF);
                                    break;
                                case 2:
                                    lVar.dt(i, com.tencent.mm.plugin.wallet_core.model.l.a.rFG);
                                    break;
                            }
                            lVar.btL();
                        }
                        b.notifyDataSetChanged();
                    }
                });
            }
        }
        hVar.rLb = bVar;
        hVar.show();
        g.a(context, hVar);
        return hVar;
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    private void buR() {
        w.d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.rLa != null) {
            l lVar = this.rLa.rLg;
            this.rLb.a(this.rzJ.Il(lVar.a(lVar.rFB, -1)));
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            buR();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
