package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;

public final class b extends a {
    com.tencent.mm.plugin.nearlife.b.a nYc;
    private com.tencent.mm.plugin.nearlife.b.a nYd = new com.tencent.mm.plugin.nearlife.b.a("", new aix());
    String nYe;
    private HashMap<String, Integer> nYf = new HashMap();

    class a {
        TextView ioX;
        TextView mVE;
        TextView mVG;
        String nWY;
        com.tencent.mm.plugin.nearlife.b.a nYg;
        LinearLayout nYh;
        ImageView nYi;
        final /* synthetic */ b nYj;
        int position;
        int type;

        a(b bVar) {
            this.nYj = bVar;
        }
    }

    public b(Context context, OnClickListener onClickListener, String str, boolean z) {
        super(context, onClickListener, str, z);
        this.nYd.fDC = context.getString(R.l.eCF);
        this.nYf.put(this.nYd.nWY, Integer.valueOf(2));
        if (!z) {
            a(this.nYd, 0);
            notifyDataSetChanged();
        }
    }

    public final com.tencent.mm.plugin.nearlife.b.a cZ(String str, String str2) {
        if (this.nYc == null) {
            this.nYc = new com.tencent.mm.plugin.nearlife.b.a("", new aix());
            this.nYc.nWY = "City";
            this.nYf.put(this.nYc.nWY, Integer.valueOf(1));
            a(this.nYc, 1);
        }
        this.nYc.fDC = str;
        this.nYc.nif = str2;
        notifyDataSetChanged();
        return this.nYc;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int intValue;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.mContext, R.i.djS, null);
            aVar.ioX = (TextView) view.findViewById(R.h.cbh);
            aVar.mVE = (TextView) view.findViewById(R.h.cbg);
            aVar.mVG = (TextView) view.findViewById(R.h.cbf);
            aVar.nYh = (LinearLayout) view.findViewById(R.h.czq);
            aVar.nYi = (ImageView) view.findViewById(R.h.cBT);
            aVar.nYh.setOnClickListener(this.lJz);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.nearlife.b.a qs = qs(i);
        if (this.nYf.containsKey(qs.nWY)) {
            intValue = ((Integer) this.nYf.get(qs.nWY)).intValue();
        } else {
            intValue = 0;
        }
        aVar.nYi.setVisibility(8);
        aVar.type = intValue;
        aVar.nYg = qs;
        if (!bg.mA(this.nYe) && this.nYe.equals(qs.nWY)) {
            aVar.nYi.setVisibility(0);
        }
        switch (intValue) {
            case 0:
                aVar.ioX.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.mVG.setVisibility(0);
                break;
            case 1:
                aVar.ioX.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.mVG.setVisibility(8);
                break;
            case 2:
                aVar.mVG.setVisibility(8);
                aVar.ioX.setTextColor(this.mContext.getResources().getColor(R.e.aVS));
                if (bg.mA(this.nYe)) {
                    aVar.nYi.setVisibility(0);
                    break;
                }
                break;
        }
        aVar.position = i;
        aVar.nWY = qs.nWY;
        if (this.nXp) {
            aVar.ioX.setText(zG(qs.fDC));
            aVar.mVG.setText(zG(a.aV(qs.nXd)));
        } else {
            aVar.ioX.setText(qs.fDC);
            aVar.mVG.setText(a.aV(qs.nXd));
        }
        aVar.mVE.setVisibility(8);
        return view;
    }

    private Spannable zG(String str) {
        return d.a(str, this.nXl);
    }
}
