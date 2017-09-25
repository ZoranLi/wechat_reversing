package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a extends c {
    private boolean phz;

    public a(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.phz = z;
        w.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[]{Boolean.valueOf(this.phz)});
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ae aeVar, HashSet<String> hashSet) {
        String str = this.fRM;
        ArrayList arrayList = new ArrayList();
        if (this.phz) {
            arrayList.add(Integer.valueOf(131073));
            arrayList.add(Integer.valueOf(131074));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return ((l) h.j(l.class)).search(9, f.a(str, iArr, aZK(), -1, hashSet, com.tencent.mm.plugin.fts.a.b.b.maC, this, aeVar));
    }

    private int[] aZK() {
        ArrayList arrayList = new ArrayList();
        if (this.phz) {
            arrayList.add(Integer.valueOf(16));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    protected final void a(g gVar, HashSet<String> hashSet) {
        List list = gVar.maj;
        this.mcy.clear();
        com.tencent.mm.plugin.fts.d.i.a aVar = new com.tencent.mm.plugin.fts.d.i.a();
        aVar.hPq = -4;
        aVar.mcO = false;
        aVar.iJD = this.iJD;
        aVar.mcS = 1;
        aVar.mcR = new LinkedList();
        this.mcy.add(aVar);
        if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
            list = d.a(list, com.tencent.mm.plugin.fts.a.c.lZp);
            if (com.tencent.mm.plugin.fts.d.b.aF(list)) {
                aVar = new com.tencent.mm.plugin.fts.d.i.a();
                aVar.hPq = -11;
                aVar.mcR = list;
                aVar.iJD = this.iJD;
                this.mcy.add(aVar);
            }
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.a a(int i, com.tencent.mm.plugin.fts.d.i.a aVar) {
        int i2 = (i - aVar.mcN) - 1;
        com.tencent.mm.plugin.fts.d.a.a aVar2 = null;
        if (i2 < aVar.mcR.size() && i2 >= 0) {
            i iVar = (i) aVar.mcR.get(i2);
            if (iVar.type == 131077 || iVar.type == 131078) {
                aVar2 = new com.tencent.mm.plugin.search.ui.a.h(i);
                aVar2.iJC = iVar;
                aVar2.iJD = aVar.iJD;
                aVar2.phg = true;
            } else {
                com.tencent.mm.plugin.fts.d.a.a aVar3;
                if (iVar.type == 131073 || iVar.type == 131074) {
                    aVar2 = new com.tencent.mm.plugin.search.ui.a.g(i);
                    aVar2.iJC = iVar;
                    aVar2.iJD = aVar.iJD;
                    aVar2.phg = true;
                    aVar3 = aVar2;
                } else {
                    aVar3 = null;
                }
                aVar2 = aVar3;
            }
        } else if (!aVar.mcO && i == 0) {
            aVar2 = new com.tencent.mm.plugin.search.ui.a.a(i);
            aVar2.iJD = this.iJD;
        }
        if (aVar2 != null) {
            aVar2.mdg = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 8192;
    }
}
