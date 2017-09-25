package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bi.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class h extends BaseAdapter {
    private List<String> ipK;
    private Context mContext;
    private List<String> sNq;

    private static class a {
        public ImageView ipv;
        public TextView kzl;
    }

    public h(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.ipK = list2;
        this.sNq = list;
    }

    public final int getCount() {
        return this.ipK.size();
    }

    public final Object getItem(int i) {
        return this.ipK.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a cT;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.cXk, null);
            cT = cT(view);
        } else {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                cT = cT(view);
            } else {
                cT = aVar;
            }
        }
        int size = this.ipK.size() % 4;
        if (i >= 0 && i < this.ipK.size() && i < this.sNq.size()) {
            cT.ipv.setVisibility(0);
            cT.kzl.setVisibility(0);
            b.a(cT.ipv, (String) this.sNq.get(i));
            cT.kzl.setText((CharSequence) this.ipK.get(i));
            cT.kzl.setText(g.bKH().d(this.mContext, (CharSequence) this.ipK.get(i), cT.kzl.getTextSize()));
            if (this.ipK.size() <= 12 || i < this.ipK.size() - size) {
                cT.kzl.setPadding(0, 0, 0, 0);
            } else {
                cT.kzl.setPadding(0, 0, 0, com.tencent.mm.bg.a.T(this.mContext, R.f.aWU));
            }
        }
        return view;
    }

    private static a cT(View view) {
        a aVar = new a();
        aVar.ipv = (ImageView) view.findViewById(R.h.bzh);
        aVar.kzl = (TextView) view.findViewById(R.h.bzk);
        view.setTag(aVar);
        return aVar;
    }
}
