package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.b.h;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter {
    protected LayoutInflater Du;
    protected Context mContext;
    protected List<h> nro = new LinkedList();

    public /* synthetic */ Object getItem(int i) {
        return oZ(i);
    }

    public d(Context context) {
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
    }

    public final void aP(List<h> list) {
        if (list == null) {
            this.nro = new LinkedList();
        } else {
            this.nro = list;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.nro.size();
    }

    public final void a(h hVar) {
        this.nro.remove(hVar);
    }

    public final h oZ(int i) {
        return (h) this.nro.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
