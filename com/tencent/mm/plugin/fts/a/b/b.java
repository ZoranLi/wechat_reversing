package com.tencent.mm.plugin.fts.a.b;

import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Comparator;

public final class b implements Comparator<i> {
    public static final b maC = new b();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        int i = iVar2.lZT - iVar.lZT;
        if (i != 0) {
            return i;
        }
        i = d.a(c.lZp, iVar.type, iVar2.type);
        if (i != 0) {
            return i;
        }
        i = d.b(c.lZu, iVar.hPr, iVar2.hPr);
        if (i != 0) {
            return i;
        }
        i = iVar.maq - iVar2.maq;
        if (i != 0) {
            return i;
        }
        if (iVar.hPr != 11 && iVar.hPr != 17 && iVar.hPr != 18) {
            return bg.ap(iVar.mar, "").compareToIgnoreCase(iVar2.mar);
        }
        if (bg.mA(iVar.maz)) {
            iVar.maz = d.wX(iVar.lZO);
            iVar.maz = iVar.maz.toLowerCase();
            if (!g(iVar.maz.charAt(0))) {
                iVar.maz = "~" + iVar.maz;
            }
        }
        if (bg.mA(iVar2.maz)) {
            iVar2.maz = d.wX(iVar2.lZO);
            iVar2.maz = iVar2.maz.toLowerCase();
            if (!g(iVar2.maz.charAt(0))) {
                iVar2.maz = "~" + iVar2.maz;
            }
        }
        return iVar.maz.compareToIgnoreCase(iVar2.maz);
    }

    private static boolean g(char c) {
        return c >= 'a' && c <= 'z';
    }
}
