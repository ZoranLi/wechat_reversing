package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public final class a extends h {
    private SparseArray<View> vql = new SparseArray();

    public a(Context context, SharedPreferences sharedPreferences) {
        super(context, sharedPreferences);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        this.vql.put(i, view2);
        return view2;
    }

    public final View a(int i, ListView listView) {
        if (i > listView.getLastVisiblePosition() || i < listView.getFirstVisiblePosition()) {
            return null;
        }
        return (View) this.vql.get(i);
    }
}
