package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter implements b {
    private e wju;
    private List<b> wjv;

    private final class a extends DataSetObserver {
        final /* synthetic */ f wjw;

        private a(f fVar) {
            this.wjw = fVar;
        }

        public final void onChanged() {
            this.wjw.wjv = this.wjw.a(this.wjw.wju);
            this.wjw.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            this.wjw.wjv = this.wjw.a(this.wjw.wju);
            this.wjw.notifyDataSetInvalidated();
        }
    }

    private class b {
        int mCount = 0;
        final /* synthetic */ f wjw;
        int wjx;

        public b(f fVar, int i) {
            this.wjw = fVar;
            this.wjx = i;
        }
    }

    public f(e eVar) {
        this.wju = eVar;
        eVar.registerDataSetObserver(new a());
        this.wjv = a(eVar);
    }

    public final int getCount() {
        return this.wju.getCount();
    }

    public final int BU(int i) {
        try {
            return ((b) this.wjv.get(i)).mCount;
        } catch (IndexOutOfBoundsException e) {
            e.toString();
            return 0;
        }
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return this.wju.a(((b) this.wjv.get(i)).wjx, view, viewGroup);
    }

    public final Object getItem(int i) {
        return this.wju.getItem(i);
    }

    public final long getItemId(int i) {
        return this.wju.getItemId(i);
    }

    public final int bZk() {
        return this.wjv.size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.wju.getView(i, view, viewGroup);
    }

    protected final List<b> a(e eVar) {
        Map hashMap = new HashMap();
        List<b> arrayList = new ArrayList();
        for (int i = 0; i < eVar.getCount(); i++) {
            long kS = eVar.kS(i);
            b bVar = (b) hashMap.get(Long.valueOf(kS));
            if (bVar == null) {
                bVar = new b(this, i);
                arrayList.add(bVar);
            }
            bVar.mCount++;
            hashMap.put(Long.valueOf(kS), bVar);
        }
        return arrayList;
    }
}
