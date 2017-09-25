package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class c extends b implements j {
    public String fRM;
    public List<String> iJD = new LinkedList();
    public HashSet<String> mae = new HashSet();
    private a mah;
    public List<i.a> mcy = Collections.synchronizedList(new LinkedList());

    public abstract a a(ae aeVar, HashSet<String> hashSet);

    public abstract com.tencent.mm.plugin.fts.d.a.a a(int i, i.a aVar);

    public abstract void a(g gVar, HashSet<String> hashSet);

    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final void a(String str, ae aeVar, HashSet<String> hashSet) {
        axV();
        QZ();
        this.fRM = str;
        this.mah = a(aeVar, (HashSet) hashSet);
    }

    public final void axV() {
        if (this.mah != null) {
            ((l) h.j(l.class)).cancelSearchTask(this.mah);
            this.mah = null;
        }
    }

    public final int mS(int i) {
        int size = this.mcy.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            int i4;
            i.a aVar = (i.a) this.mcy.get(i2);
            aVar.mcN = i3;
            if (aVar.mcO) {
                i3++;
            }
            i3 += aVar.mcR.size() + aVar.mcS;
            aVar.mcP = i3;
            if (aVar.mcQ) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return i3;
    }

    public final com.tencent.mm.plugin.fts.d.a.a mT(int i) {
        int size = this.mcy.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.mm.plugin.fts.d.a.a b;
            i.a aVar = (i.a) this.mcy.get(i2);
            if (aVar.mcN == i && aVar.mcO) {
                b = b(i, aVar);
            } else if (aVar.mcP == i && aVar.mcQ) {
                b = new com.tencent.mm.plugin.fts.d.a.c(i);
                b.mdg = aVar.mcP - aVar.mcN;
            } else {
                b = a(i, aVar);
            }
            if (b != null) {
                if (!aVar.mcQ && b.position == aVar.mcP) {
                    b.mdd = true;
                }
                b.mcx = this.mcx;
                b.fRM = this.fRM;
                b.mde = aVar.hPq;
                return b;
            }
        }
        return null;
    }

    public com.tencent.mm.plugin.fts.d.a.b b(int i, i.a aVar) {
        return new com.tencent.mm.plugin.fts.d.a.b(i);
    }

    public final void QZ() {
        this.fRM = null;
        this.mae.clear();
        this.mcy.clear();
    }

    public final void a(g gVar) {
        int i = 0;
        switch (gVar.aMA) {
            case -3:
            case -2:
            case -1:
                w.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(gVar.aMA), gVar.lYe.fRM});
                if (!gVar.lYe.fRM.equals(this.fRM)) {
                    w.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
                    return;
                }
                break;
            case 0:
                w.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[]{Integer.valueOf(getType()), Integer.valueOf(gVar.maj.size())});
                if (this.fRM != null && this.fRM.equals(gVar.lYe.fRM)) {
                    String[] strArr = gVar.mai;
                    List arrayList = new ArrayList();
                    if (strArr != null && strArr.length > 0) {
                        while (i < strArr.length) {
                            arrayList.add(strArr[i]);
                            i++;
                        }
                    }
                    this.iJD = arrayList;
                    this.mae = gVar.lYe.mae;
                    a(gVar, this.mae);
                    break;
                }
                w.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[]{gVar.lYe.fRM, this.fRM});
                return;
            default:
                return;
        }
        this.mcw.a(this, gVar.lYe.fRM);
    }

    public final LinkedList<Integer> axW() {
        LinkedList<Integer> linkedList = new LinkedList();
        int size = this.mcy.size();
        for (int i = 0; i < size; i++) {
            i.a aVar = (i.a) this.mcy.get(i);
            if (aVar.mcN != Integer.MAX_VALUE) {
                linkedList.add(Integer.valueOf(aVar.mcN));
            }
        }
        return linkedList;
    }

    public com.tencent.mm.plugin.fts.d.a.a a(int i, i iVar, List<String> list) {
        return null;
    }
}
