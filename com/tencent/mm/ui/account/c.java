package com.tencent.mm.ui.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private Context mContext;
    private final Object mLock = new Object();
    private List<String> oEo;
    private ArrayList<String> oEq;
    private a uXg;
    private String uXh;

    private class a extends Filter {
        final /* synthetic */ c uXi;

        private a(c cVar) {
            this.uXi = cVar;
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            int i = 0;
            FilterResults filterResults = new FilterResults();
            if (this.uXi.oEq == null) {
                synchronized (this.uXi.mLock) {
                    this.uXi.oEq = new ArrayList(this.uXi.oEo);
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (this.uXi.mLock) {
                    ArrayList arrayList = new ArrayList(this.uXi.oEq);
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }
            } else {
                String str;
                ArrayList a;
                int size;
                ArrayList arrayList2;
                String toLowerCase = charSequence.toString().toLowerCase();
                String str2 = "";
                if (this.uXi.uXh != null && this.uXi.uXh.length() > 0) {
                    String[] split = toLowerCase.split(this.uXi.uXh);
                    if (split != null && split.length > 1) {
                        str2 = split[0] + this.uXi.uXh;
                        toLowerCase = split[1];
                        str = str2;
                        str2 = toLowerCase;
                        a = this.uXi.oEq;
                        size = a.size();
                        arrayList2 = new ArrayList(size);
                        while (i < size) {
                            toLowerCase = (String) a.get(i);
                            if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                                arrayList2.add(str + toLowerCase);
                            }
                            i++;
                        }
                        filterResults.values = arrayList2;
                        filterResults.count = arrayList2.size();
                    }
                }
                str = str2;
                str2 = toLowerCase;
                a = this.uXi.oEq;
                size = a.size();
                arrayList2 = new ArrayList(size);
                while (i < size) {
                    toLowerCase = (String) a.get(i);
                    if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                        arrayList2.add(str + toLowerCase);
                    }
                    i++;
                }
                filterResults.values = arrayList2;
                filterResults.count = arrayList2.size();
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.uXi.oEo = (List) filterResults.values;
            if (filterResults.count > 0) {
                this.uXi.notifyDataSetChanged();
            } else {
                this.uXi.notifyDataSetInvalidated();
            }
        }
    }

    static class b {
        public TextView itE;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return hO(i);
    }

    public c(Context context, String[] strArr, String str) {
        this.mContext = context;
        this.oEo = Arrays.asList(strArr);
        this.uXh = str;
    }

    public final int getCount() {
        return this.oEo.size();
    }

    private String hO(int i) {
        return (String) this.oEo.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.cUZ, null);
            b bVar2 = new b();
            bVar2.itE = (TextView) view.findViewById(R.h.cHM);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.itE.setText(hO(i));
        view.setBackgroundResource(R.g.beo);
        return view;
    }

    public final Filter getFilter() {
        if (this.uXg == null) {
            this.uXg = new a();
        }
        return this.uXg;
    }
}
