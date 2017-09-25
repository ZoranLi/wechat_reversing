package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView extends GridView {
    public ArrayList<a> vgL = new ArrayList();

    private static class a {
        public Object data;
        public boolean isSelectable;
        public ViewGroup vgM;
        public View view;
    }

    private class b extends FrameLayout {
        final /* synthetic */ HeaderGridView vgN;

        public b(HeaderGridView headerGridView, Context context) {
            this.vgN = headerGridView;
            super(context);
        }

        protected final void onMeasure(int i, int i2) {
            super.onMeasure(MeasureSpec.makeMeasureSpec((this.vgN.getMeasuredWidth() - this.vgN.getPaddingLeft()) - this.vgN.getPaddingRight(), 1073741824), i2);
        }
    }

    private static class c implements Filterable, WrapperListAdapter {
        private final ListAdapter FA;
        public final DataSetObservable mDataSetObservable = new DataSetObservable();
        int mNumColumns = 1;
        ArrayList<a> vgL;
        boolean vgO;
        private final boolean vgP;

        public c(ArrayList<a> arrayList, ListAdapter listAdapter) {
            this.FA = listAdapter;
            this.vgP = listAdapter instanceof Filterable;
            if (arrayList == null) {
                throw new IllegalArgumentException("headerViewInfos cannot be null");
            }
            this.vgL = arrayList;
            this.vgO = aj(this.vgL);
        }

        public final boolean isEmpty() {
            return (this.FA == null || this.FA.isEmpty()) && this.vgL.size() == 0;
        }

        private static boolean aj(ArrayList<a> arrayList) {
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!((a) it.next()).isSelectable) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final int getCount() {
            if (this.FA != null) {
                return (this.vgL.size() * this.mNumColumns) + this.FA.getCount();
            }
            return this.vgL.size() * this.mNumColumns;
        }

        public final boolean areAllItemsEnabled() {
            if (this.FA == null) {
                return true;
            }
            if (this.vgO && this.FA.areAllItemsEnabled()) {
                return true;
            }
            return false;
        }

        public final boolean isEnabled(int i) {
            int size = this.vgL.size() * this.mNumColumns;
            if (i >= size) {
                size = i - size;
                return (this.FA == null || size >= this.FA.getCount()) ? false : this.FA.isEnabled(size);
            } else if (i % this.mNumColumns == 0 && ((a) this.vgL.get(i / this.mNumColumns)).isSelectable) {
                return true;
            } else {
                return false;
            }
        }

        public final Object getItem(int i) {
            int size = this.vgL.size() * this.mNumColumns;
            if (i >= size) {
                size = i - size;
                if (this.FA == null || size >= this.FA.getCount()) {
                    return null;
                }
                return this.FA.getItem(size);
            } else if (i % this.mNumColumns == 0) {
                return ((a) this.vgL.get(i / this.mNumColumns)).data;
            } else {
                return null;
            }
        }

        public final long getItemId(int i) {
            int size = this.vgL.size() * this.mNumColumns;
            if (this.FA != null && i >= size) {
                size = i - size;
                if (size < this.FA.getCount()) {
                    return this.FA.getItemId(size);
                }
            }
            return -1;
        }

        public final boolean hasStableIds() {
            if (this.FA != null) {
                return this.FA.hasStableIds();
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int size = this.vgL.size() * this.mNumColumns;
            if (i < size) {
                View view2 = ((a) this.vgL.get(i / this.mNumColumns)).vgM;
                if (i % this.mNumColumns == 0) {
                    return view2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(view2.getHeight());
                return view;
            }
            size = i - size;
            if (this.FA != null && size < this.FA.getCount()) {
                return this.FA.getView(size, view, viewGroup);
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            return view;
        }

        public final int getItemViewType(int i) {
            int size = this.vgL.size() * this.mNumColumns;
            if (i < size && i % this.mNumColumns != 0) {
                return this.FA != null ? this.FA.getViewTypeCount() : 1;
            } else {
                if (this.FA != null && i >= size) {
                    size = i - size;
                    if (size < this.FA.getCount()) {
                        return this.FA.getItemViewType(size);
                    }
                }
                return -2;
            }
        }

        public final int getViewTypeCount() {
            if (this.FA != null) {
                return this.FA.getViewTypeCount() + 1;
            }
            return 2;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.registerObserver(dataSetObserver);
            if (this.FA != null) {
                this.FA.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            if (this.FA != null) {
                this.FA.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final Filter getFilter() {
            if (this.vgP) {
                return ((Filterable) this.FA).getFilter();
            }
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.FA;
        }
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setClipChildren(false);
    }

    @TargetApi(11)
    public int getNumColumns() {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            return super.getNumColumns();
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            return i;
        }
    }

    public void setClipChildren(boolean z) {
    }

    public final void a(ListAdapter listAdapter) {
        if (this.vgL.size() > 0) {
            ListAdapter cVar = new c(this.vgL, listAdapter);
            if (cVar.mNumColumns != 5) {
                cVar.mNumColumns = 5;
                cVar.mDataSetObservable.notifyChanged();
            }
            super.setAdapter(cVar);
            return;
        }
        super.setAdapter(listAdapter);
    }
}
