package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public final class h extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<String> opn = null;
    private List<String> orh = null;
    Filter ori = new Filter(this) {
        final /* synthetic */ h orj;

        {
            this.orj = r1;
        }

        protected final synchronized void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.orj.opn = (List) filterResults.values;
            this.orj.notifyDataSetChanged();
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            ArrayList arrayList = new ArrayList();
            for (String str : this.orj.orh) {
                if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                    arrayList.add(str);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }
    };

    class a {
        TextView oqM;
        final /* synthetic */ h orj;

        a(h hVar) {
            this.orj = hVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return hO(i);
    }

    public h(Context context) {
        this.mContext = context;
        this.orh = com.tencent.mm.plugin.product.a.a.aSQ().aSS().opn;
    }

    public final int getCount() {
        return this.opn != null ? this.opn.size() : 0;
    }

    private String hO(int i) {
        return (String) this.opn.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = LayoutInflater.from(this.mContext).inflate(17367043, null);
            aVar2.oqM = (TextView) view.findViewById(16908308);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.oqM.setText(hO(i));
        return view;
    }

    public final Filter getFilter() {
        return this.ori;
    }
}
