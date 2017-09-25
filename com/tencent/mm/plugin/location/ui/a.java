package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends j {
    private int ncC = 8;
    private ArrayList<String> ncD = new ArrayList();

    class a {
        ImageView hBi;
        TextView ncE;
        final /* synthetic */ a ncF;

        a(a aVar) {
            this.ncF = aVar;
        }
    }

    public final void G(ArrayList<String> arrayList) {
        boolean z;
        this.ncD.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.ncD.add((String) it.next());
        }
        String str = "MicroMsg.MMGridPaperAdapter";
        String str2 = "notifyDataSetChange, notifier is null ? %B";
        Object[] objArr = new Object[1];
        if (this.vki == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        if (this.vki != null) {
            this.vki.bSe();
        }
    }

    public final int getCount() {
        return this.ncD.size();
    }

    public final View c(int i, View view) {
        a aVar = new a(this);
        if (view == null) {
            view = View.inflate(ab.getContext(), R.i.cVa, null);
            aVar.hBi = (ImageView) view.findViewById(R.h.bqL);
            aVar.ncE = (TextView) view.findViewById(R.h.cLl);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = (String) this.ncD.get(i);
        b.a(aVar.hBi, str);
        CharSequence eK = n.eK(str);
        if (eK.length() > this.ncC) {
            eK = eK.subSequence(0, this.ncC + 1) + "...";
        }
        aVar.ncE.setText(eK);
        return view;
    }

    public final Object getItem(int i) {
        return this.ncD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
