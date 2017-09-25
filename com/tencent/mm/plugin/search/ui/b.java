package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.w;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    private int count;
    String fRM;
    private OnScrollListener kzc;
    private c pfj;
    private SparseArray<com.tencent.mm.plugin.fts.d.a.a> pfk = new SparseArray();
    long pfl;
    a pfm;

    public interface a {
        void M(int i, boolean z);
    }

    protected abstract boolean a(com.tencent.mm.plugin.fts.d.a.a aVar);

    protected abstract void aZo();

    protected abstract com.tencent.mm.plugin.fts.d.a.a mT(int i);

    public /* synthetic */ Object getItem(int i) {
        return so(i);
    }

    public final Context getContext() {
        return this.pfj.getContext();
    }

    public b(c cVar) {
        w.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.pfj = cVar;
    }

    protected final void sn(int i) {
        w.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[]{Integer.valueOf(i)});
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i) {
        if (so(i) != null) {
            return so(i).knu;
        }
        w.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        return -1;
    }

    public int getViewTypeCount() {
        return 18;
    }

    private com.tencent.mm.plugin.fts.d.a.a so(int i) {
        if (this.pfk.indexOfKey(i) >= 0) {
            return (com.tencent.mm.plugin.fts.d.a.a) this.pfk.get(i);
        }
        com.tencent.mm.plugin.fts.d.a.a aVar = null;
        if (i >= 0 && i < getCount()) {
            aVar = mT(i);
        }
        if (aVar == null) {
            w.e("MicroMsg.FTS.FTSBaseAdapter", "getItem Occur error ! position = %d | count=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(getCount())});
            return aVar;
        }
        this.pfk.put(i, aVar);
        return aVar;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.fts.d.a.a so = so(i);
        if (view == null) {
            view = so.Sr().a(getContext(), viewGroup);
        }
        com.tencent.mm.plugin.fts.d.a.a.a aVar = (com.tencent.mm.plugin.fts.d.a.a.a) view.getTag();
        if (!so.mdc) {
            so.a(getContext(), aVar, new Object[0]);
            so.mdc = true;
        }
        so.Sr().a(getContext(), aVar, so);
        return view;
    }

    public final void DX(String str) {
        stopSearch();
        this.pfl = System.currentTimeMillis();
        this.fRM = str;
        w.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[]{str});
        aZo();
    }

    public void stopSearch() {
        this.count = 0;
        this.fRM = "";
        clearCache();
        notifyDataSetChanged();
    }

    public void finish() {
        stopSearch();
    }

    protected void clearCache() {
        this.pfk.clear();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kzc != null) {
            this.kzc.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kzc != null) {
            this.kzc.onScroll(absListView, i, i2, i3);
        }
    }

    protected final void L(int i, boolean z) {
        if (this.pfm != null) {
            this.pfm.M(i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.pfj.aHf();
        if (i < getCount()) {
            com.tencent.mm.plugin.fts.d.a.a so = so(i);
            so.Sr().a(getContext(), so);
            a(so);
            this.pfj.b(so);
        }
    }

    protected final int aZt() {
        int i = 0;
        int i2 = 0;
        while (i < getCount()) {
            if (so(i).mdm) {
                i2++;
            }
            i++;
        }
        return i2;
    }
}
