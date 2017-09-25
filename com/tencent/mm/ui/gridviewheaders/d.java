package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public final class d extends BaseAdapter implements b {
    private DataSetObserver Br = new DataSetObserver(this) {
        final /* synthetic */ d wjt;

        {
            this.wjt = r1;
        }

        public final void onChanged() {
            this.wjt.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            this.wjt.notifyDataSetInvalidated();
        }
    };
    private ListAdapter wjs;

    public d(ListAdapter listAdapter) {
        this.wjs = listAdapter;
        listAdapter.registerDataSetObserver(this.Br);
    }

    public final int getCount() {
        return this.wjs.getCount();
    }

    public final Object getItem(int i) {
        return this.wjs.getItem(i);
    }

    public final long getItemId(int i) {
        return this.wjs.getItemId(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.wjs.getView(i, view, viewGroup);
    }

    public final int BU(int i) {
        return 0;
    }

    public final int bZk() {
        return 0;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
