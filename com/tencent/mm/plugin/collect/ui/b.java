package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.b.c;
import com.tencent.mm.plugin.collect.b.f;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    List<f> kBf = new ArrayList();
    private Context mContext;

    private static class a {
        TextView kBg;
        WalletTextView kBh;
        TextView kBi;
        TextView kBj;

        public a(View view) {
            this.kBg = (TextView) view.findViewById(R.h.bDp);
            this.kBj = (TextView) view.findViewById(R.h.bDo);
            this.kBh = (WalletTextView) view.findViewById(R.h.bDu);
            this.kBi = (TextView) view.findViewById(R.h.bDq);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kW(i);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kBf.size();
    }

    public final f kW(int i) {
        return (f) this.kBf.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = r.eC(this.mContext).inflate(R.i.cZb, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        f kW = kW(i);
        aVar.kBg.setText(c.a(this.mContext, kW.kAw, kW.type));
        aVar.kBh.setText(c.kV(kW.kAy));
        aVar.kBi.setText(this.mContext.getString(R.l.dWz, new Object[]{Integer.valueOf(kW.kAx)}));
        return view;
    }

    public final void ai(List<f> list) {
        this.kBf.clear();
        this.kBf.addAll(list);
        notifyDataSetChanged();
    }

    public final void aj(List<f> list) {
        this.kBf.addAll(list);
        notifyDataSetChanged();
    }
}
