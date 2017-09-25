package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.List;

public abstract class a extends BaseAdapter implements d {
    private int qOg = 0;
    HashMap<Object, Integer> qOh = new HashMap();

    public final boolean hasStableIds() {
        return true;
    }

    protected final void bn(Object obj) {
        HashMap hashMap = this.qOh;
        int i = this.qOg;
        this.qOg = i + 1;
        hashMap.put(obj, Integer.valueOf(i));
    }

    protected final void bD(List<?> list) {
        for (Object bn : list) {
            bn(bn);
        }
    }

    public final long getItemId(int i) {
        if (i < 0 || i >= this.qOh.size()) {
            return -1;
        }
        return (long) ((Integer) this.qOh.get(getItem(i))).intValue();
    }
}
