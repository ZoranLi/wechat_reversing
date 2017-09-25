package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.h;

public final class e extends d {
    private Context mContext = null;

    class a {
        TextView jhl;
        TextView kBi;
        TextView nrd;
        TextView nsH;
        final /* synthetic */ e nsZ;
        int wa;

        a(e eVar) {
            this.nsZ = eVar;
        }
    }

    public e(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Du.inflate(R.i.dhp, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.jhl = (TextView) view.findViewById(R.h.cfh);
            aVar2.kBi = (TextView) view.findViewById(R.h.cfe);
            aVar2.nsH = (TextView) view.findViewById(R.h.cff);
            aVar2.nrd = (TextView) view.findViewById(R.h.cfd);
            aVar2.wa = i;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h oZ = oZ(i);
        aVar.jhl.setText(oZ.nmM);
        aVar.nsH.setText(oZ.nmN);
        aVar.nrd.setText(this.mContext.getString(R.l.exh, new Object[]{com.tencent.mm.wallet_core.ui.e.n(((double) oZ.nmo) / 100.0d)}));
        CharSequence string = this.mContext.getString(R.l.eys, new Object[]{Long.valueOf(oZ.nmm), Long.valueOf(oZ.nmO)});
        if (oZ.status == 5) {
            string = this.mContext.getString(R.l.eyt) + " " + string;
        }
        aVar.kBi.setText(string);
        return view;
    }
}
