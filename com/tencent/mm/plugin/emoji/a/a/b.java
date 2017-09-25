package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public static void a(c cVar, a aVar) {
        if (m.xX() && cVar != null && cVar.size() > 0 && aVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!(fVar == null || fVar.kJa == f.a.kJj)) {
                    pn pnVar = fVar.kJb;
                    boolean b = e.b(pnVar);
                    boolean a = e.a(pnVar);
                    if (!(b || a)) {
                        arrayList.add(pnVar.tgW);
                        ak tX = cVar.tX(pnVar.tgW);
                        if (tX != null) {
                            tX.uJt = 11;
                        }
                    }
                }
            }
            Context context = ab.getContext();
            if (arrayList.size() > 0) {
                h.a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), aVar);
            }
        }
    }

    public static void a(ArrayList<p> arrayList, c cVar) {
        if (m.xX() && cVar != null && arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (pVar != null) {
                    ak tX = cVar.tX(pVar.fGa);
                    if (tX != null) {
                        int i;
                        if (pVar.sCE == 10232) {
                            tX.uJv = pVar.sCB;
                            tX.uJt = 12;
                            i = tX.uJr;
                            if (!(ll(i) || lm(i))) {
                                tX.yD(4);
                            }
                        } else {
                            tX.uJt = 10;
                            tX.uJu = pVar.sCE;
                            i = tX.uJr;
                            if (!(ll(i) || lm(i))) {
                                if ((i == 3 ? 1 : null) == null) {
                                    tX.yD(10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean ll(int i) {
        return i == 7;
    }

    private static boolean lm(int i) {
        return i == 6;
    }
}
