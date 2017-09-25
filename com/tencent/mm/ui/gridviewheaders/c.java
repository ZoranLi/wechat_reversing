package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter {
    private static boolean wiM;
    private DataSetObserver Br = new DataSetObserver(this) {
        final /* synthetic */ c wiR;

        {
            this.wiR = r1;
        }

        public final void onChanged() {
            int i = 0;
            c cVar = this.wiR;
            cVar.mCount = 0;
            int bZk = cVar.wiN.bZk();
            if (bZk == 0) {
                cVar.mCount = cVar.wiN.getCount();
            } else {
                while (i < bZk) {
                    cVar.mCount += cVar.wiN.BU(i) + cVar.mNumColumns;
                    i++;
                }
            }
            this.wiR.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            this.wiR.wiP.clear();
            this.wiR.notifyDataSetInvalidated();
        }
    };
    private final Context mContext;
    int mCount;
    int mNumColumns = 1;
    final b wiN;
    private GridHeadersGridView wiO;
    private final List<View> wiP = new ArrayList();
    private View[] wiQ;

    protected class a extends View {
        final /* synthetic */ c wiR;

        public a(c cVar, Context context) {
            this.wiR = cVar;
            super(context);
        }
    }

    protected class b extends FrameLayout {
        final /* synthetic */ c wiR;
        int wiS;
        int wiT;

        public b(c cVar, Context context) {
            this.wiR = cVar;
            super(context);
        }

        protected final void onMeasure(int i, int i2) {
            View view = (View) getTag();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(generateDefaultLayoutParams());
            }
            if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
                view.measure(MeasureSpec.makeMeasureSpec(this.wiT, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
            }
            setMeasuredDimension(MeasureSpec.getSize(i), view.getMeasuredHeight());
        }

        protected final LayoutParams generateDefaultLayoutParams() {
            return new LayoutParams(-1, -1);
        }
    }

    protected class c {
        protected int kC;
        final /* synthetic */ c wiR;
        protected int wiU;

        protected c(c cVar, int i, int i2) {
            this.wiR = cVar;
            this.kC = i;
            this.wiU = i2;
        }
    }

    protected class d extends FrameLayout {
        int kC;
        int mNumColumns;
        View[] wiQ;
        final /* synthetic */ c wiR;
        private boolean wiV;

        public d(c cVar, Context context) {
            this.wiR = cVar;
            super(context);
        }

        public final Object getTag() {
            return getChildAt(0).getTag();
        }

        public final Object getTag(int i) {
            return getChildAt(0).getTag(i);
        }

        public final void setTag(int i, Object obj) {
            getChildAt(0).setTag(i, obj);
        }

        public final void setTag(Object obj) {
            getChildAt(0).setTag(obj);
        }

        protected final LayoutParams generateDefaultLayoutParams() {
            return new LayoutParams(-1, -1);
        }

        protected final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.mNumColumns != 1 && this.wiR.wiQ != null) {
                if (this.kC % this.mNumColumns == 0 && !this.wiV) {
                    this.wiV = true;
                    for (View measure : this.wiQ) {
                        measure.measure(i, i2);
                    }
                    this.wiV = false;
                }
                int measuredHeight = getMeasuredHeight();
                int i3 = measuredHeight;
                for (View view : this.wiQ) {
                    if (view != null) {
                        i3 = Math.max(i3, view.getMeasuredHeight());
                    }
                }
                if (i3 != measuredHeight) {
                    super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
                }
            }
        }
    }

    public c(Context context, GridHeadersGridView gridHeadersGridView, b bVar) {
        this.mContext = context;
        this.wiN = bVar;
        this.wiO = gridHeadersGridView;
        bVar.registerDataSetObserver(this.Br);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        int i = 0;
        this.mCount = 0;
        int bZk = this.wiN.bZk();
        if (bZk == 0) {
            return this.wiN.getCount();
        }
        while (i < bZk) {
            this.mCount += (this.wiN.BU(i) + BW(i)) + this.mNumColumns;
            i++;
        }
        return this.mCount;
    }

    public final Object getItem(int i) {
        c BX = BX(i);
        if (BX.kC == -1 || BX.kC == -2) {
            return null;
        }
        return this.wiN.getItem(BX.kC);
    }

    public final long getItemId(int i) {
        c BX = BX(i);
        if (BX.kC == -2) {
            return -1;
        }
        if (BX.kC == -1) {
            return -2;
        }
        return this.wiN.getItemId(BX.kC);
    }

    public final int getItemViewType(int i) {
        c BX = BX(i);
        if (BX.kC == -2) {
            return 1;
        }
        if (BX.kC == -1) {
            return 0;
        }
        int itemViewType = this.wiN.getItemViewType(BX.kC);
        return itemViewType != -1 ? itemViewType + 2 : itemViewType;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        View bVar;
        if (view instanceof d) {
            view = (d) view;
            childAt = view.getChildAt(0);
        } else {
            childAt = view;
            view = null;
        }
        c BX = BX(i);
        if (BX.kC == -2) {
            bVar = new b(this, this.mContext);
            bVar.wiT = this.wiO.getWidth();
            ((b) bVar).wiS = BX.wiU;
            bVar.setTag(this.wiN.a(BX.wiU, (View) bVar.getTag(), viewGroup));
        } else if (BX.kC == -1) {
            childAt = (a) childAt;
            if (childAt == null) {
                childAt = new a(this, this.mContext);
            }
            bVar = childAt;
        } else {
            bVar = this.wiN.getView(BX.kC, childAt, viewGroup);
        }
        if (view == null) {
            view = new d(this, this.mContext);
        }
        view.removeAllViews();
        view.addView(bVar);
        view.kC = i;
        view.mNumColumns = this.mNumColumns;
        this.wiQ[i % this.mNumColumns] = view;
        if (i % this.mNumColumns == 0) {
            wiM = true;
            for (int i2 = 1; i2 < this.wiQ.length; i2++) {
                this.wiQ[i2] = getView(i + i2, null, viewGroup);
            }
            wiM = false;
        }
        view.wiQ = this.wiQ;
        if (!wiM && (i % this.mNumColumns == this.mNumColumns - 1 || i == getCount() - 1)) {
            BV(this.mNumColumns);
        }
        return view;
    }

    public final int getViewTypeCount() {
        return this.wiN.getViewTypeCount() + 2;
    }

    public final boolean hasStableIds() {
        return this.wiN.hasStableIds();
    }

    public final boolean isEmpty() {
        return this.wiN.isEmpty();
    }

    public final boolean isEnabled(int i) {
        c BX = BX(i);
        if (BX.kC == -1 || BX.kC == -2) {
            return false;
        }
        return this.wiN.isEnabled(BX.kC);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.wiN.registerDataSetObserver(dataSetObserver);
    }

    public final void setNumColumns(int i) {
        this.mNumColumns = i;
        BV(i);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.wiN.unregisterDataSetObserver(dataSetObserver);
    }

    private void BV(int i) {
        this.wiQ = new View[i];
        Arrays.fill(this.wiQ, null);
    }

    private int BW(int i) {
        int BU = this.wiN.BU(i) % this.mNumColumns;
        return BU == 0 ? 0 : this.mNumColumns - BU;
    }

    protected final long kS(int i) {
        return (long) BX(i).wiU;
    }

    protected final View a(int i, View view, ViewGroup viewGroup) {
        if (this.wiN.bZk() == 0) {
            return null;
        }
        return this.wiN.a(BX(i).wiU, view, viewGroup);
    }

    protected final c BX(int i) {
        int i2 = 0;
        int bZk = this.wiN.bZk();
        if (bZk != 0) {
            int i3 = i;
            while (i2 < bZk) {
                int BU = this.wiN.BU(i2);
                if (i3 == 0) {
                    return new c(this, -2, i2);
                }
                i3 -= this.mNumColumns;
                if (i3 < 0) {
                    return new c(this, -1, i2);
                }
                int i4 = i - this.mNumColumns;
                if (i3 < BU) {
                    return new c(this, i4, i2);
                }
                int BW = BW(i2);
                i = i4 - BW;
                i2++;
                i3 -= BU + BW;
            }
            return new c(this, -1, i2);
        } else if (i >= this.wiN.getCount()) {
            return new c(this, -1, 0);
        } else {
            return new c(this, i, 0);
        }
    }
}
