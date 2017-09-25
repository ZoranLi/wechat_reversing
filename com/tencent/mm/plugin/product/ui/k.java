package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.b.n;
import java.util.List;

public final class k extends BaseAdapter {
    private Context mContext;
    OnItemClickListener orG;
    List<n> orN;

    class a {
        public TextView orH = null;
        public MaxGridView orI = null;
        public l orO = null;
        final /* synthetic */ k orP;

        a(k kVar) {
            this.orP = kVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ri(i);
    }

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.orN != null ? this.orN.size() : 0;
    }

    private n ri(int i) {
        return (n) this.orN.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        n ri = ri(i);
        if (view == null || view.getTag() == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.mContext, R.i.dlj, null);
            aVar2.orH = (TextView) view.findViewById(R.h.cii);
            aVar2.orI = (MaxGridView) view.findViewById(R.h.cih);
            aVar2.orO = new l(this.mContext);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.orH.setText(ri.name);
        aVar.orI.setOnItemClickListener(this.orG);
        aVar.orO.orQ = ri.opG;
        aVar.orO.notifyDataSetChanged();
        aVar.orI.setAdapter(aVar.orO);
        return view;
    }
}
