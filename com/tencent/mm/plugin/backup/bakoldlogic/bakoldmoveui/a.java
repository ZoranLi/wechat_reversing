package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    HashSet<Integer> jEP = new HashSet();
    BakMoveChooseUI jKP;

    class a {
        ImageView ipv;
        TextView ipw;
        TextView ipx;
        CheckBox ipy;
        RelativeLayout jES;
        final /* synthetic */ a jKQ;

        a(a aVar) {
            this.jKQ = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return jt(i);
    }

    public a(BakMoveChooseUI bakMoveChooseUI) {
        this.jKP = bakMoveChooseUI;
    }

    public final int getCount() {
        ArrayList abX = e.abX();
        if (abX != null) {
            return abX.size();
        }
        return 0;
    }

    private static com.tencent.mm.plugin.backup.bakoldlogic.a.a jt(int i) {
        return (com.tencent.mm.plugin.backup.bakoldlogic.a.a) e.abX().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.jKP.getLayoutInflater().inflate(R.i.cVl, viewGroup, false);
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
            final /* synthetic */ a jKQ;

            public final void onClick(View view) {
                if (this.jKQ.jEP.contains(Integer.valueOf(i))) {
                    this.jKQ.jEP.remove(Integer.valueOf(i));
                } else {
                    this.jKQ.jEP.add(Integer.valueOf(i));
                }
                this.jKQ.notifyDataSetChanged();
                this.jKQ.jKP.a(this.jKQ.jEP);
            }
        });
        com.tencent.mm.plugin.backup.bakoldlogic.a.a jt = jt(i);
        b.a(aVar.ipv, jt.jBh);
        aVar.ipw.setText(bg.ay(jt.jBk));
        if (o.dH(jt.jBh)) {
            aVar.ipx.setText(h.b(this.jKP, n.E(jt.jBh, jt.jBh), aVar.ipx.getTextSize()));
        } else {
            aVar.ipx.setText(h.b(this.jKP, n.eK(jt.jBh), aVar.ipx.getTextSize()));
        }
        if (this.jEP.contains(Integer.valueOf(i))) {
            aVar.ipy.setChecked(true);
        } else {
            aVar.ipy.setChecked(false);
        }
        return view;
    }
}
