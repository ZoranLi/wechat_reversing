package com.tencent.mm.ui.widget.celltextview.a;

import android.util.LruCache;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.ui.widget.celltextview.c.d;
import com.tencent.mm.ui.widget.celltextview.c.e;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b {
    private static b wym;
    private static Object wyo = new Object();
    public LruCache<a, a> wyn = new LruCache(m.CTRL_INDEX);

    private b() {
    }

    public static b caU() {
        if (wym == null) {
            synchronized (wyo) {
                if (wym == null) {
                    wym = new b();
                }
            }
        }
        return wym;
    }

    public final void a(CharSequence charSequence, float f, float f2, LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> linkedList, ArrayList<d> arrayList, ArrayList<e> arrayList2) {
        a aVar = new a(charSequence == null ? "" : charSequence.toString(), f, f2);
        if (linkedList != null) {
            if (aVar.wyd == null) {
                aVar.wyd = new LinkedList();
            }
            aVar.wyd.addAll(linkedList);
        }
        if (arrayList != null) {
            if (aVar.wyj == null) {
                aVar.wyj = new ArrayList();
            }
            aVar.wyj.addAll(arrayList);
        }
        aVar.al(arrayList2);
        this.wyn.put(aVar, aVar);
    }
}
