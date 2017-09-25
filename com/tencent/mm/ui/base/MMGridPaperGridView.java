package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class MMGridPaperGridView extends GridView {
    private int mCount;
    int mIndex;
    private OnItemClickListener qUq = new OnItemClickListener(this) {
        final /* synthetic */ MMGridPaperGridView vkr;

        {
            this.vkr = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.vkr.vkp == null) {
                w.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
            }
        }
    };
    private int vkj;
    private int vkk;
    private int vkl;
    private int vkm = -1;
    private boolean vkn = false;
    a vko;
    private j vkp;
    private OnItemLongClickListener vkq = new OnItemLongClickListener(this) {
        final /* synthetic */ MMGridPaperGridView vkr;

        {
            this.vkr = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.vkr.vkp == null) {
                w.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
            }
            return false;
        }
    };

    private class a extends BaseAdapter {
        final /* synthetic */ MMGridPaperGridView vkr;

        private a(MMGridPaperGridView mMGridPaperGridView) {
            this.vkr = mMGridPaperGridView;
        }

        public final boolean isEnabled(int i) {
            return this.vkr.vkp != null;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final int getCount() {
            return (this.vkr.mCount < 0 || this.vkr.vkp == null) ? 0 : this.vkr.mCount;
        }

        public final Object getItem(int i) {
            return this.vkr.vkp == null ? null : this.vkr.vkp.getItem(this.vkr.vkl + i);
        }

        public final long getItemId(int i) {
            return this.vkr.vkp == null ? 0 : this.vkr.vkp.getItemId(this.vkr.vkl + i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            long NA = bg.NA();
            String str = "MicroMsg.MMGridPaperGridView";
            String str2 = "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.vkr.mIndex);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(view == null);
            objArr[3] = viewGroup.toString();
            objArr[4] = Boolean.valueOf(this.vkr.vkn);
            w.v(str, str2, objArr);
            if (this.vkr.vkn) {
                view = null;
            }
            View c = this.vkr.vkp == null ? null : this.vkr.vkp.c(this.vkr.vkl + i, view);
            if (c != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (-1 == this.vkr.vkm || this.vkr.vkl + i != this.vkr.vkm) {
                c.setVisibility(0);
            } else {
                c.setVisibility(4);
            }
            w.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", Long.valueOf(bg.aB(NA)), Integer.valueOf(this.vkr.vkm), Integer.valueOf(this.vkr.vkl + i));
            return c;
        }
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, int i2, int i3, j jVar) {
        boolean z = true;
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "index[%d], rows[%d], columns[%d], adapter is null[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        if (jVar != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        this.mIndex = i;
        this.vkj = i2;
        this.vkk = i3;
        this.vkp = jVar;
        this.mCount = this.vkj * this.vkk;
        this.vkl = this.mIndex * this.mCount;
        if (this.vkp != null && this.vkp.getCount() - this.vkl < this.mCount) {
            this.mCount = this.vkp.getCount() - this.vkl;
        }
        if (getAdapter() == null) {
            w.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.vko = new a();
            setAdapter(this.vko);
        }
        setNumColumns(this.vkk);
        setColumnWidth(3);
        setOnItemClickListener(this.qUq);
        setOnItemLongClickListener(this.vkq);
    }
}
