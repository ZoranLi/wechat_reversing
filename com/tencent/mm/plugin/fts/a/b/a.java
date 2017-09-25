package com.tencent.mm.plugin.fts.a.b;

import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.Comparator;

public final class a implements Comparator<i> {
    public static final a maB = new a();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        int i = iVar2.lZT - iVar.lZT;
        if (i != 0) {
            return i;
        }
        if (iVar2.lZT >= 50 && iVar.lZT >= 50) {
            i = d.b(c.lZu, iVar.hPr, iVar2.hPr);
            if (i != 0) {
                return i;
            }
        }
        i = iVar2.maA - iVar.maA;
        if (i != 0) {
            return i;
        }
        if (iVar2.timestamp > iVar.timestamp) {
            return 1;
        }
        return iVar2.timestamp < iVar.timestamp ? -1 : 0;
    }
}
