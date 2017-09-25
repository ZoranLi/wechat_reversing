package com.tencent.mm.t;

import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;

public final class g {
    public static int g(au auVar) {
        if (!auVar.axO()) {
            return 0;
        }
        a B = a.B(auVar.field_content, auVar.field_reserved);
        if (B == null) {
            return 0;
        }
        return B.type;
    }
}
