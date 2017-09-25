package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.brandservice.ui.base.a.a;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    public SparseArray<a> kbC;
    public Runnable kbD;
    protected Context mContext;

    public abstract a ke(int i);

    public abstract Object[] kf(int i);

    public /* synthetic */ Object getItem(int i) {
        return kh(i);
    }

    public b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.kbC = new SparseArray();
        this.kbD = new Runnable(this) {
            final /* synthetic */ b kbE;

            {
                this.kbE = r1;
            }

            public final void run() {
                this.kbE.notifyDataSetChanged();
            }
        };
    }

    public int getCount() {
        return this.kbC.size();
    }

    public int getItemViewType(int i) {
        if (kh(i) != null) {
            return kh(i).type;
        }
        w.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        return 0;
    }

    public int getViewTypeCount() {
        return 7;
    }

    public a kh(int i) {
        if (i < 0 || i > getCount()) {
            w.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[]{Integer.valueOf(i)});
            return null;
        }
        a aVar = (a) this.kbC.get(i);
        if (aVar != null) {
            return aVar;
        }
        aVar = ke(i);
        this.kbC.put(i, aVar);
        return aVar;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        a kh = kh(i);
        if (kh == null) {
            w.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.plugin.brandservice.ui.base.a.b aed = kh.aed();
            if (aed == null) {
                w.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                a aee;
                if (view == null) {
                    view = aed.b(this.mContext, view);
                    aee = kh.aee();
                    aed.a(view, aee);
                    view.setTag(aee);
                } else {
                    aee = (a) view.getTag();
                }
                Object[] kf = kf(i);
                Assert.assertNotNull(aee);
                if (!kh.kbB) {
                    kh.a(this.mContext, aee, kf);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                aed.a(this.mContext, aee, kh);
                long currentTimeMillis4 = System.currentTimeMillis();
                w.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3)});
            }
        }
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a kh = kh(i);
        if (kh != null) {
            com.tencent.mm.plugin.brandservice.ui.base.a.b aed = kh.aed();
            if (aed != null && aed.a(this.mContext, kh, kf(i))) {
            }
        }
    }
}
