package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends BaseAdapter {
    private Context mContext;
    private c oqU = com.tencent.mm.plugin.product.a.a.aSR();
    LinkedList<m> orF;
    OnItemClickListener orG;

    class a {
        public TextView orH = null;
        public MaxGridView orI = null;
        public j orJ = null;
        final /* synthetic */ i orK;

        a(i iVar) {
            this.orK = iVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return rg(i);
    }

    public i(Context context) {
        this.mContext = context;
        com.tencent.mm.plugin.product.a.a.aSQ();
    }

    public final int getCount() {
        return this.orF != null ? this.orF.size() : 0;
    }

    private m rg(int i) {
        return (m) this.orF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        Pair pair;
        m rg = rg(i);
        if (view == null || view.getTag() == null) {
            aVar = new a(this);
            view = View.inflate(this.mContext, R.i.dlg, null);
            aVar.orH = (TextView) view.findViewById(R.h.cie);
            aVar.orI = (MaxGridView) view.findViewById(R.h.cic);
            aVar.orJ = new j(this.mContext);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.orH.setText(rg.oqi);
        aVar.orI.setOnItemClickListener(this.orG);
        j jVar = aVar.orJ;
        c cVar = this.oqU;
        String str2 = rg.oqh;
        if (cVar.oph.containsKey(str2)) {
            str = (String) cVar.oph.get(str2);
        } else {
            str = null;
        }
        jVar.orL = rg;
        jVar.orM = str;
        Context context = this.mContext;
        LinkedList linkedList = rg.oqj;
        int fromDPToPix = context.getResources().getDisplayMetrics().widthPixels - (com.tencent.mm.bg.a.fromDPToPix(context, 16) * 2);
        TextPaint paint = ((TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.dlf, null)).getPaint();
        float f = 0.0f;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            float measureText = paint.measureText(((h) it.next()).name);
            if (f >= measureText) {
                measureText = f;
            }
            f = measureText;
        }
        int fromDPToPix2 = ((int) f) + (com.tencent.mm.bg.a.fromDPToPix(context, 10) * 2);
        int[] iArr = new int[4];
        int fromDPToPix3 = com.tencent.mm.bg.a.fromDPToPix(context, 12);
        for (int i2 = 0; i2 < 4; i2++) {
            iArr[i2] = (fromDPToPix - (fromDPToPix3 * i2)) / (i2 + 1);
        }
        for (fromDPToPix3 = 4; fromDPToPix3 > 0; fromDPToPix3--) {
            if (fromDPToPix2 < iArr[fromDPToPix3 - 1]) {
                pair = new Pair(Integer.valueOf(fromDPToPix3), Integer.valueOf(iArr[fromDPToPix3 - 1]));
                break;
            }
        }
        pair = new Pair(Integer.valueOf(1), Integer.valueOf(fromDPToPix));
        w.d("MicroMsg.MallProductImageAdapter", rg.oqi + " numColumns = " + pair);
        aVar.orI.setColumnWidth(((Integer) pair.second).intValue());
        aVar.orJ.notifyDataSetChanged();
        aVar.orI.setAdapter(aVar.orJ);
        return view;
    }
}
