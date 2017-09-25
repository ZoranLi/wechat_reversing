package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.Iterator;

final class d {
    final boolean fFU;

    d(boolean z) {
        this.fFU = z;
    }

    final ArrayList<e> m(ArrayList<e> arrayList) {
        if (!this.fFU || bg.bV(arrayList)) {
            return arrayList;
        }
        ArrayList<e> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (!eVar.iCc) {
                arrayList2.add(eVar);
            }
        }
        return arrayList2;
    }
}
