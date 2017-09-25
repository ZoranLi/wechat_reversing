package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.wallet_core.ui.e;

public final class c extends d {
    private Context mContext;

    class a {
        ImageView nrW;
        TextView nrd;
        TextView nsG;
        TextView nsH;
        final /* synthetic */ c nsI;

        a(c cVar) {
            this.nsI = cVar;
        }
    }

    public c(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Du.inflate(R.i.dhn, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.nsG = (TextView) view.findViewById(R.h.cfb);
            aVar2.nsH = (TextView) view.findViewById(R.h.cfc);
            aVar2.nrd = (TextView) view.findViewById(R.h.ceX);
            aVar2.nrW = (ImageView) view.findViewById(R.h.ceZ);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h oZ = oZ(i);
        n.a(this.mContext, aVar.nsG, oZ.nmJ);
        aVar.nsH.setText(oZ.nmL);
        aVar.nrd.setText(this.mContext.getString(R.l.cfX, new Object[]{e.n(((double) oZ.nmK) / 100.0d)}));
        if (oZ.nme == 1) {
            aVar.nrW.setImageResource(R.g.bgI);
            aVar.nrW.setVisibility(0);
        } else if (oZ.nme == 2) {
            aVar.nrW.setImageResource(R.g.bgG);
            aVar.nrW.setVisibility(0);
        } else {
            aVar.nrW.setVisibility(8);
        }
        return view;
    }
}
