package com.tencent.mm.pluginsdk.e;

import com.tencent.mm.e.a.ip;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a extends c<ip> {
    protected ArrayList<String> sBL;

    public abstract void j(b bVar);

    public a() {
        this.sBL = new ArrayList(3);
        this.usg = ip.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ip ipVar = (ip) bVar;
        if ((ipVar instanceof ip) && ipVar.fOq.fOr != null && this.sBL.contains(ipVar.fOq.fOr.getClass().getName())) {
            j(ipVar.fOq.fOr);
        }
        return false;
    }

    public static void a(String str, a aVar) {
        if (!aVar.sBL.contains(str)) {
            aVar.sBL.add(str);
        }
        com.tencent.mm.sdk.b.a.urY.b(aVar);
        e.LK(str);
    }

    public static void b(String str, a aVar) {
        e.LL(str);
        com.tencent.mm.sdk.b.a.urY.c(aVar);
        if (aVar.sBL.contains(str)) {
            aVar.sBL.remove(str);
        }
    }
}
