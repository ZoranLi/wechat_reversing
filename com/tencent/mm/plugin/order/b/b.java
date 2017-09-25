package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "OrderCommonMsgXml")};
    private e gUz;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((a) cVar);
    }

    public final /* bridge */ /* synthetic */ boolean c(c cVar, String[] strArr) {
        return super.c((a) cVar, strArr);
    }

    public b(e eVar) {
        super(eVar, a.gTP, "OrderCommonMsgXml", null);
        this.gUz = eVar;
    }

    public final Cursor Kk() {
        return this.gUz.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
    }

    public final boolean a(a aVar) {
        return super.b(aVar);
    }
}
