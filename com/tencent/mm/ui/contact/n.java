package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.contact.a.a;
import junit.framework.Assert;

public abstract class n extends BaseAdapter {
    public int scene;
    private SparseArray<a> uyT;
    public l vYf;
    private boolean vYg;
    boolean vYh;

    public abstract a hg(int i);

    public /* synthetic */ Object getItem(int i) {
        return BL(i);
    }

    public n(l lVar, boolean z, int i, boolean z2) {
        this.vYf = lVar;
        this.vYg = z;
        this.uyT = new SparseArray();
        this.scene = i;
        this.vYh = z2;
    }

    public n(l lVar, boolean z, int i) {
        this(lVar, z, i, false);
    }

    public boolean bcP() {
        return this.vYg;
    }

    public final void ly(boolean z) {
        this.vYg = z;
        notifyDataSetChanged();
    }

    public final a BL(int i) {
        if (this.uyT.indexOfKey(i) >= 0) {
            return (a) this.uyT.get(i);
        }
        if (i < 0 || i >= getCount()) {
            w.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
            return null;
        }
        a hg = hg(i);
        if (hg != null) {
            hg.kap = c(hg);
            this.uyT.put(i, hg);
            w.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", Integer.valueOf(hg.knu), Integer.valueOf(i));
            return hg;
        }
        w.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
        return hg;
    }

    protected boolean c(a aVar) {
        return false;
    }

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        if (BL(i) != null) {
            return BL(i).knu;
        }
        w.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a BL = BL(i);
        if (view == null) {
            view = BL.Ob().a(this.vYf.getActivity(), viewGroup);
        }
        a.a aVar = (a.a) view.getTag();
        Assert.assertNotNull(aVar);
        if (!BL.waj) {
            BL.br(this.vYf.getActivity());
            BL.waj = true;
        }
        BL.vYg = bcP();
        BL.Ob().a(this.vYf.getActivity(), aVar, BL, this.vYf.b(BL), this.vYf.a(BL));
        return view;
    }

    public final void clearCache() {
        if (this.uyT != null) {
            this.uyT.clear();
        }
    }

    public void finish() {
        clearCache();
    }

    public boolean BM(int i) {
        return false;
    }
}
