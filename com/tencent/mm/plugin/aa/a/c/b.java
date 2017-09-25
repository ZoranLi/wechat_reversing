package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.a.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a iot;
    public final a iou;

    public class a implements e<d<List, String, Boolean>, c<Boolean, Integer>> {
        final /* synthetic */ b iov;

        public a(b bVar) {
            this.iov = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            int i;
            int i2 = 20;
            c cVar = (c) obj;
            a aVar = this.iov.iot;
            boolean booleanValue = ((Boolean) cVar.get(0)).booleanValue();
            int intValue = ((Integer) cVar.get(1)).intValue();
            if (!booleanValue || aVar.iok <= 0) {
                i = 20;
            } else {
                i = aVar.iok;
                aVar.iok = 0;
                aVar.iop = false;
            }
            if (aVar.ioq == intValue) {
                i2 = i;
            }
            aVar.ioq = intValue;
            w.i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", new Object[]{Integer.valueOf(aVar.iok), Boolean.valueOf(booleanValue)});
            com.tencent.mm.vending.g.b cbB = g.cbB();
            cbB.cbA();
            (aVar.iop ? new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.iok, intValue, aVar.iol, aVar.iom, aVar.ion, aVar.ioo) : new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.iok, intValue)).BC().e(new AnonymousClass1(aVar, cbB));
            return null;
        }

        public final String NN() {
            return "Vending.ANY";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.iot;
    }

    public b() {
        this(new a());
    }

    private b(a aVar) {
        this.iou = new a(this);
        this.iot = aVar;
    }
}
