package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.c.lz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a extends BaseAdapter {
    List<CardInfo> kiF = new ArrayList();
    HashMap<String, Integer> kjD = new HashMap();
    Context mContext;

    public class a {
        public LinearLayout kjE;
        public ImageView kjF;
        public TextView kjG;
        public TextView kjH;
        final /* synthetic */ a kjI;
        public RelativeLayout kjt;
        public ImageView kju;
        public TextView kjv;
        public TextView kjw;
        public TextView kjx;
        public TextView kjz;

        public a(a aVar) {
            this.kjI = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kx(i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kiF.size();
    }

    public final CardInfo kx(int i) {
        return (CardInfo) this.kiF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b kx = kx(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.cWe, null);
            aVar = new a(this);
            aVar.kjt = (RelativeLayout) view.findViewById(R.h.bwF);
            aVar.kjE = (LinearLayout) view.findViewById(R.h.byH);
            aVar.kju = (ImageView) view.findViewById(R.h.bxt);
            aVar.kjv = (TextView) view.findViewById(R.h.bwl);
            aVar.kjw = (TextView) view.findViewById(R.h.bxN);
            aVar.kjx = (TextView) view.findViewById(R.h.subtitle);
            aVar.kjz = (TextView) view.findViewById(R.h.bxP);
            aVar.kjF = (ImageView) view.findViewById(R.h.bxG);
            aVar.kjG = (TextView) view.findViewById(R.h.bwG);
            aVar.kjH = (TextView) view.findViewById(R.h.byu);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (kx.aeU()) {
            aVar.kju.setVisibility(0);
            aVar.kjw.setVisibility(0);
            aVar.kjx.setVisibility(0);
            aVar.kjz.setVisibility(8);
            aVar.kjv.setVisibility(0);
            aVar.kjv.setText(kx.afi().keT);
            if (!kx.aeR()) {
                aVar.kjw.setText(kx.afi().title);
            } else if (kx.afi().toj != null && kx.afi().toj.size() == 1) {
                aVar.kjw.setText(((lz) kx.afi().toj.get(0)).title);
            } else if (kx.afi().toj != null && kx.afi().toj.size() == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((lz) kx.afi().toj.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((lz) kx.afi().toj.get(1)).title);
                aVar.kjw.setText(stringBuilder.toString());
            }
            if (kx.afi().toJ == 1) {
                aVar.kjF.setVisibility(0);
            } else {
                aVar.kjF.setVisibility(8);
            }
            long j = ((CardInfo) kx).field_begin_time;
            if (kx.getEndTime() > 0 && j > 0) {
                aVar.kjx.setText(this.mContext.getString(R.l.dSu, new Object[]{l.aq(j) + "  -  " + l.aq(kx.getEndTime())}));
                aVar.kjx.setVisibility(0);
            } else if (kx.getEndTime() > 0) {
                aVar.kjx.setText(this.mContext.getString(R.l.dSt, new Object[]{l.aq(kx.getEndTime())}));
                aVar.kjx.setVisibility(0);
            } else {
                aVar.kjx.setText("");
                aVar.kjx.setVisibility(8);
            }
            m.a(aVar.kju, kx.afi().kdG, this.mContext.getResources().getDimensionPixelSize(R.f.aYK), R.g.bhq, true);
            if (kx.afi().toH == 1) {
                aVar.kju.setAlpha(255);
                aVar.kjH.setVisibility(8);
                aVar.kjw.setTextColor(this.mContext.getResources().getColor(R.e.aTh));
                aVar.kjv.setTextColor(this.mContext.getResources().getColor(R.e.aTh));
                aVar.kjx.setTextColor(this.mContext.getResources().getColor(R.e.aUf));
            } else {
                aVar.kjH.setText(kx.afi().toI);
                aVar.kju.setAlpha(90);
                aVar.kjH.setVisibility(0);
                aVar.kjw.setTextColor(this.mContext.getResources().getColor(R.e.aUf));
                aVar.kjv.setTextColor(this.mContext.getResources().getColor(R.e.aUf));
                aVar.kjx.setTextColor(this.mContext.getResources().getColor(R.e.aUf));
            }
            int intValue = ((Integer) this.kjD.get(kx.afn())).intValue();
            if (intValue == 1) {
                aVar.kjG.setText("");
                aVar.kjG.setVisibility(8);
            } else {
                aVar.kjG.setText("x" + intValue);
                aVar.kjG.setVisibility(0);
            }
        } else {
            aVar.kju.setVisibility(8);
            aVar.kjw.setVisibility(8);
            aVar.kjv.setVisibility(8);
            aVar.kjx.setVisibility(8);
            aVar.kjH.setVisibility(8);
            aVar.kjG.setVisibility(8);
            aVar.kjz.setVisibility(0);
            aVar.kjt.setBackgroundColor(this.mContext.getResources().getColor(R.e.aTm));
            aVar.kjz.setText(this.mContext.getResources().getString(R.l.dRx));
        }
        return view;
    }
}
