package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class bg extends i<bf> implements a {
    public static final String[] gUx = new String[]{i.a(bf.gTP, "VoiceTransText")};
    public e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return a((bf) cVar);
    }

    public bg(e eVar) {
        this(eVar, bf.gTP, "VoiceTransText");
    }

    private bg(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final boolean a(bf bfVar) {
        if (bfVar == null) {
            return false;
        }
        if (this.gUz.replace("VoiceTransText", "msgId", bfVar.pv()) >= 0) {
            return true;
        }
        return false;
    }

    public final bf Sb(String str) {
        if (com.tencent.mm.sdk.platformtools.bg.mA(str)) {
            return null;
        }
        bf bfVar = new bf();
        Cursor a = this.gUz.a("VoiceTransText", null, "cmsgId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bfVar.b(a);
        }
        a.close();
        return bfVar;
    }
}
