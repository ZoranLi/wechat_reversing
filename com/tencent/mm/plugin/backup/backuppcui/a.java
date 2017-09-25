package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    static boolean jEQ = false;
    HashSet<Integer> jEP = new HashSet();
    BackupPcChooseUI jGR;

    class a {
        ImageView ipv;
        TextView ipw;
        CheckBox ipy;
        RelativeLayout jES;
        final /* synthetic */ a jGS;

        a(a aVar) {
            this.jGS = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return hO(i);
    }

    public a(BackupPcChooseUI backupPcChooseUI) {
        this.jGR = backupPcChooseUI;
        jEQ = false;
    }

    public final int getCount() {
        LinkedList aay = b.abd().abh().aay();
        if (aay != null) {
            return aay.size();
        }
        return 0;
    }

    private static String hO(int i) {
        LinkedList aay = b.abd().abh().aay();
        return aay.get(i) == null ? null : ((d) aay.get(i)).jBh;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.jGR.getLayoutInflater().inflate(R.i.cVg, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.ipv = (ImageView) view.findViewById(R.h.bqM);
            aVar2.ipw = (TextView) view.findViewById(R.h.cJh);
            aVar2.ipy = (CheckBox) view.findViewById(R.h.cBH);
            aVar2.jES = (RelativeLayout) view.findViewById(R.h.cBI);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jES.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a jGS;

            public final void onClick(View view) {
                if (this.jGS.jEP.contains(Integer.valueOf(i))) {
                    this.jGS.jEP.remove(Integer.valueOf(i));
                } else {
                    this.jGS.jEP.add(Integer.valueOf(i));
                }
                this.jGS.notifyDataSetChanged();
                this.jGS.jGR.a(this.jGS.jEP);
            }
        });
        String hO = hO(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ipv, hO);
        if (o.dH(hO)) {
            aVar.ipw.setText(h.b(this.jGR, n.E(hO, hO), aVar.ipw.getTextSize()));
        } else {
            aVar.ipw.setText(h.b(this.jGR, n.eK(hO), aVar.ipw.getTextSize()));
        }
        if (this.jEP.contains(Integer.valueOf(i))) {
            aVar.ipy.setChecked(true);
        } else {
            aVar.ipy.setChecked(false);
        }
        return view;
    }
}
