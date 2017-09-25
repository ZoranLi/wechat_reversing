package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;

public final class l extends i<k> {
    public static final String[] gUx = new String[]{i.a(k.gTP, "RecordMessageInfo")};
    e gUz;

    public l(e eVar) {
        super(eVar, k.gTP, "RecordMessageInfo", null);
        this.gUz = eVar;
    }

    public final void rR(int i) {
        int delete = this.gUz.delete("RecordMessageInfo", "localId=?", new String[]{String.valueOf(i)});
        w.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", Integer.valueOf(i), Integer.valueOf(delete));
    }
}
