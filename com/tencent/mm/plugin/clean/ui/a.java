package com.tencent.mm.plugin.clean.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    HashSet<Integer> jEP = new HashSet();
    CleanChattingUI kyV;

    class a {
        ImageView ipv;
        TextView ipw;
        TextView ipx;
        CheckBox ipy;
        RelativeLayout jES;
        final /* synthetic */ a kyW;

        a(a aVar) {
            this.kyW = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kQ(i);
    }

    public a(CleanChattingUI cleanChattingUI) {
        this.kyV = cleanChattingUI;
    }

    public final int getCount() {
        ArrayList abX = d.abX();
        if (abX != null) {
            return abX.size();
        }
        return 0;
    }

    private static b kQ(int i) {
        return (b) d.abX().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.kyV.getLayoutInflater().inflate(R.i.cYT, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.ipv = (ImageView) view.findViewById(R.h.bqM);
            aVar2.ipw = (TextView) view.findViewById(R.h.cJh);
            aVar2.ipx = (TextView) view.findViewById(R.h.bIb);
            aVar2.ipy = (CheckBox) view.findViewById(R.h.cBH);
            aVar2.jES = (RelativeLayout) view.findViewById(R.h.cBI);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jES.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a kyW;

            public final void onClick(View view) {
                if (this.kyW.jEP.contains(Integer.valueOf(i))) {
                    this.kyW.jEP.remove(Integer.valueOf(i));
                } else {
                    this.kyW.jEP.add(Integer.valueOf(i));
                }
                this.kyW.notifyDataSetChanged();
                this.kyW.kyV.a(this.kyW.jEP);
            }
        });
        b kQ = kQ(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ipv, kQ.username);
        aVar.ipw.setText(bg.ay(kQ.fLh));
        if (o.dH(kQ.username)) {
            aVar.ipx.setText(h.b(this.kyV, n.E(kQ.username, kQ.username), aVar.ipx.getTextSize()));
        } else {
            aVar.ipx.setText(h.b(this.kyV, n.eK(kQ.username), aVar.ipx.getTextSize()));
        }
        if (this.jEP.contains(Integer.valueOf(i))) {
            aVar.ipy.setChecked(true);
        } else {
            aVar.ipy.setChecked(false);
        }
        return view;
    }

    public final void ajS() {
        this.jEP.clear();
        this.kyV.a(this.jEP);
    }
}
