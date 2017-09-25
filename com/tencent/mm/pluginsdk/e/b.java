package com.tencent.mm.pluginsdk.e;

import com.tencent.mm.e.a.jk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b extends c<jk> {
    protected ArrayList<String> sBL;

    public abstract void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar);

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        jk jkVar = (jk) bVar;
        if ((jkVar instanceof jk) && jkVar.fPP.fPQ != null && this.sBL.contains(jkVar.fPP.fPQ.getClass().getName())) {
            a(jkVar.fPP.errType, jkVar.fPP.errCode, jkVar.fPP.fPf, jkVar.fPP.fPQ);
        }
        return false;
    }

    public b(int i) {
        super(0);
        this.sBL = new ArrayList(3);
        this.usg = jk.class.getName().hashCode();
    }

    public static void a(String str, b bVar) {
        if (!bVar.sBL.contains(str)) {
            bVar.sBL.add(str);
        }
        a.urY.b(bVar);
        e.LK(str);
    }

    public static void b(String str, b bVar) {
        e.LL(str);
        a.urY.c(bVar);
        if (bVar.sBL.contains(str)) {
            bVar.sBL.remove(str);
        }
    }
}
