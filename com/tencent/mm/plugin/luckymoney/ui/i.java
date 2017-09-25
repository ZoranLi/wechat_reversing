package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private LayoutInflater Du;
    private Context mContext;
    private List<m> nro = new LinkedList();
    String nuv;
    boolean nuw;
    OnClickListener nux;
    int nuy = 1;
    b nuz = null;

    interface b {
        void a(c cVar, Context context);
    }

    class c {
        ImageView kDl;
        View kHP;
        TextView nrd;
        TextView nsG;
        TextView nsH;
        final /* synthetic */ i nuA;
        TextView nuB;
        TextView nuC;
        ImageView nuD;
        TextView nuE;

        c(i iVar) {
            this.nuA = iVar;
        }
    }

    final class a implements b {
        final /* synthetic */ i nuA;

        a(i iVar) {
            this.nuA = iVar;
        }

        public final void a(c cVar, Context context) {
            int color = context.getResources().getColor(R.e.aUI);
            int color2 = context.getResources().getColor(R.e.aUJ);
            int color3 = context.getResources().getColor(R.e.aUO);
            cVar.kHP.setBackgroundResource(R.e.transparent);
            cVar.kHP.setPadding(0, context.getResources().getDimensionPixelOffset(R.f.aXz), 0, context.getResources().getDimensionPixelOffset(R.f.aXz));
            cVar.nsG.setTextColor(color);
            cVar.nsH.setTextColor(color2);
            cVar.nrd.setTextColor(color);
            cVar.nuB.setTextColor(color);
            cVar.nuC.setTextColor(color3);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return pc(i);
    }

    public i(Context context) {
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
    }

    public final void aP(List<m> list) {
        if (list == null) {
            LinkedList linkedList = new LinkedList();
        } else {
            this.nro = list;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.nro.size();
    }

    private m pc(int i) {
        return (m) this.nro.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = this.Du.inflate(R.i.dhv, viewGroup, false);
            c cVar2 = new c(this);
            cVar2.kHP = view.findViewById(R.h.czn);
            cVar2.kDl = (ImageView) view.findViewById(R.h.cgl);
            cVar2.nsG = (TextView) view.findViewById(R.h.cgo);
            cVar2.nsH = (TextView) view.findViewById(R.h.cgp);
            cVar2.nrd = (TextView) view.findViewById(R.h.cgj);
            cVar2.nuB = (TextView) view.findViewById(R.h.cgk);
            cVar2.nuC = (TextView) view.findViewById(R.h.cgq);
            cVar2.nuD = (ImageView) view.findViewById(R.h.cgm);
            cVar2.nuE = (TextView) view.findViewById(R.h.cgn);
            if (this.nuz != null) {
                this.nuz.a(cVar2, this.mContext);
            }
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        m pc = pc(i);
        n.a(cVar.kDl, pc.nmY, pc.userName);
        if (bg.mz(pc.nmp).equals(this.nuv) && this.nuw) {
            cVar.nuC.setOnClickListener(this.nux);
            cVar.nuC.setVisibility(0);
            cVar.nuB.setVisibility(8);
            cVar.nsH.setVisibility(8);
        } else {
            if (bg.mA(pc.nmZ)) {
                cVar.nuB.setVisibility(8);
            } else {
                n.a(this.mContext, cVar.nuB, pc.nmZ);
                cVar.nuB.setVisibility(0);
            }
            cVar.nsH.setText(n.h(this.mContext, bg.getLong(pc.nmL, 0) * 1000));
            cVar.nsH.setVisibility(0);
            cVar.nuC.setVisibility(8);
        }
        n.a(this.mContext, cVar.nsG, pc.nmX);
        cVar.nrd.setText(this.mContext.getString(R.l.cfX, new Object[]{e.n(((double) pc.nmK) / 100.0d)}));
        if (bg.mA(pc.nna)) {
            cVar.nuD.setVisibility(8);
            cVar.nuE.setVisibility(8);
        } else {
            cVar.nuE.setText(pc.nna);
            if (this.nuy == 2) {
                cVar.nuD.setImageResource(R.g.bgH);
            } else {
                cVar.nuD.setImageResource(R.g.bgu);
            }
            cVar.nuD.setVisibility(0);
            cVar.nuE.setVisibility(0);
        }
        return view;
    }
}
