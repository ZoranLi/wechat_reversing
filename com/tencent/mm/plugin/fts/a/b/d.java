package com.tencent.mm.plugin.fts.a.b;

import com.tencent.mm.plugin.fts.a.a.i;
import java.util.Comparator;

public final class d implements Comparator<i> {
    public static final d maE = new d();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        if (iVar.timestamp > iVar2.timestamp) {
            return -1;
        }
        if (iVar.timestamp < iVar2.timestamp) {
            return 1;
        }
        if (iVar.hPr < iVar2.hPr) {
            return 1;
        }
        return iVar.hPr <= iVar2.hPr ? 0 : -1;
    }
}
