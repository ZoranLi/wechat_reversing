package com.tencent.c.a;

import android.content.Context;
import com.tencent.c.c.b.c;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static com.tencent.c.b.a wQK = null;

    public interface a {
        void e(int i, byte[] bArr);
    }

    public static void a(Context context, a aVar) {
        if (wQK == null) {
            wQK = new com.tencent.c.b.a(context);
        }
        com.tencent.c.b.a aVar2 = wQK;
        List fy = com.tencent.c.e.a.fy(aVar2.mContext);
        if (fy.size() == 0) {
            aVar.e(-10, null);
            return;
        }
        com.tencent.c.c.b.a aVar3 = new com.tencent.c.c.b.a();
        aVar3.wRq = com.tencent.c.b.a.cdE();
        aVar3.wRo = new c();
        aVar3.wRo.wRR = 6;
        aVar3.wRo.wRi = 1;
        aVar3.wRo.requestType = 0;
        aVar3.wRo.wRS = 0;
        aVar3.wRo.wRT = 0;
        aVar3.wRo.wRU = null;
        aVar3.wRo.wRV = 0;
        aVar3.wRo.wRZ = 1;
        aVar3.wRp = new ArrayList();
        for (int i = 0; i < fy.size(); i++) {
            aVar3.wRp.add(com.tencent.c.b.a.a(aVar2.mContext, (a) fy.get(i), i));
        }
        byte[] a = aVar2.wQL.a(aVar3);
        if (a == null) {
            aVar.e(-20, null);
        } else {
            aVar.e(0, a);
        }
    }
}
