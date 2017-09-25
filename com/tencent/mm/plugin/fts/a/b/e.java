package com.tencent.mm.plugin.fts.a.b;

import com.tencent.mm.plugin.fts.a.a.i;
import java.util.Comparator;

public final class e implements Comparator<i> {
    public static final e maF = new e();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        if (iVar2.timestamp < iVar.timestamp) {
            return -1;
        }
        return iVar2.timestamp == iVar.timestamp ? 0 : 1;
    }
}
