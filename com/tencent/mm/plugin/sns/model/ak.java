package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class ak<K, O> {
    private int maxSize;
    Map<K, b<O>> pWX = null;
    private a pWY = null;

    public interface a {
        boolean bj(Object obj);
    }

    public class b<OO> {
        public OO obj;
        final /* synthetic */ ak pWZ;
        public Long pXa;

        public b(ak akVar, OO oo) {
            this.pWZ = akVar;
            this.obj = oo;
            bfi();
        }

        public final void bfi() {
            this.pXa = Long.valueOf(System.currentTimeMillis());
        }
    }

    public ak(int i, a aVar) {
        this.maxSize = i;
        this.pWX = new HashMap();
        this.pWY = aVar;
    }

    public final void bfh() {
        if (this.pWX.size() > this.maxSize) {
            Object arrayList = new ArrayList(this.pWX.entrySet());
            Collections.sort(arrayList, new Comparator<Entry<K, b<O>>>(this) {
                final /* synthetic */ ak pWZ;

                {
                    this.pWZ = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((b) ((Entry) obj).getValue()).pXa.compareTo(((b) ((Entry) obj2).getValue()).pXa);
                }
            });
            int size = this.pWX.size() - this.maxSize;
            if (size > 0) {
                Iterator it = arrayList.iterator();
                int i = size;
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (this.pWY.bj(entry.getKey())) {
                        w.d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                        size = i - 1;
                    } else {
                        size = i;
                    }
                    if (size > 0) {
                        i = size;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
