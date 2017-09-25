package com.tencent.mm.plugin.fts.a.b;

import com.tencent.mm.plugin.fts.a.a.i;
import java.util.Comparator;

public final class c implements Comparator<i> {
    public static final c maD = new c();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        int i = iVar.hPr - iVar2.hPr;
        if (i != 0) {
            return i;
        }
        i = iVar.maq - iVar2.maq;
        return i == 0 ? iVar.mar.compareTo(iVar2.mar) : i;
    }
}
