package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    static boolean jEQ = false;
    BackupMoveChooseUI jEO;
    HashSet<Integer> jEP = new HashSet();

    class a {
        ImageView ipv;
        TextView ipw;
        CheckBox ipy;
        final /* synthetic */ a jER;
        RelativeLayout jES;

        a(a aVar) {
            this.jER = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ji(i);
    }

    public a(BackupMoveChooseUI backupMoveChooseUI) {
        this.jEO = backupMoveChooseUI;
        jEQ = false;
    }

    public final int getCount() {
        LinkedList aay = b.aaD().aaH().aay();
        if (aay != null) {
            return aay.size();
        }
        return 0;
    }

    private static d ji(int i) {
        return (d) b.aaD().aaH().aay().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.jEO.getLayoutInflater().inflate(R.i.cVl, viewGroup, false);
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
            final /* synthetic */ a jER;

            public final void onClick(View view) {
                if (this.jER.jEP.contains(Integer.valueOf(i))) {
                    this.jER.jEP.remove(Integer.valueOf(i));
                } else {
                    this.jER.jEP.add(Integer.valueOf(i));
                }
                this.jER.notifyDataSetChanged();
                this.jER.jEO.a(this.jER.jEP);
            }
        });
        d ji = ji(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ipv, ji.jBh);
        if (o.dH(ji.jBh)) {
            aVar.ipw.setText(h.b(this.jEO, n.E(ji.jBh, ji.jBh), aVar.ipw.getTextSize()));
        } else {
            aVar.ipw.setText(h.b(this.jEO, n.eK(ji.jBh), aVar.ipw.getTextSize()));
        }
        if (this.jEP.contains(Integer.valueOf(i))) {
            aVar.ipy.setChecked(true);
        } else {
            aVar.ipy.setChecked(false);
        }
        return view;
    }

    public static boolean Fg() {
        return jEQ;
    }
}
