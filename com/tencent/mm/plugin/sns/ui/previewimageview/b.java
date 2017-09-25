package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends a {
    ArrayList<Object> eh = new ArrayList();
    Context mContext;
    int qOi;

    protected b(Context context, int i) {
        this.mContext = context;
        this.qOi = 4;
    }

    public void bE(List<?> list) {
        clear();
        bD(list);
        this.eh.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        this.qOh.clear();
        this.eh.clear();
        notifyDataSetChanged();
    }

    public final void add(Object obj) {
        bn(obj);
        this.eh.add(obj);
        notifyDataSetChanged();
    }

    public final void add(int i, Object obj) {
        bn(obj);
        this.eh.add(i, obj);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.eh.size();
    }

    public Object getItem(int i) {
        return this.eh.get(i);
    }

    public final int getColumnCount() {
        return this.qOi;
    }

    public void de(int i, int i2) {
        if (i2 < getCount()) {
            List list = this.eh;
            list.add(i2, list.remove(i));
            notifyDataSetChanged();
        }
    }

    public boolean uj(int i) {
        return true;
    }

    public boolean uk(int i) {
        return true;
    }
}
