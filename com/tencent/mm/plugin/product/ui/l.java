package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.n.a;
import java.util.List;

public final class l extends BaseAdapter {
    private Context mContext;
    List<a> orQ;

    public final /* synthetic */ Object getItem(int i) {
        return rj(i);
    }

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.orQ != null ? this.orQ.size() : 0;
    }

    private a rj(int i) {
        return (a) this.orQ.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        j.a aVar;
        a rj = rj(i);
        if (view == null || view.getTag() == null) {
            m mVar = new m();
            view = View.inflate(this.mContext, R.i.dli, null);
            mVar.ioX = (TextView) view.findViewById(R.h.cig);
            mVar.jla = (ImageView) view.findViewById(R.h.cif);
            view.setTag(mVar);
            aVar = mVar;
        } else {
            m mVar2 = (m) view.getTag();
        }
        aVar.orR = rj;
        aVar.ioX.setText(rj.title);
        aVar.jla.setImageBitmap(j.a(new c(rj.iconUrl)));
        j.a(aVar);
        return view;
    }
}
