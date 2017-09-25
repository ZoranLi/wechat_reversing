package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import com.tencent.mm.compatible.d.c.a;

final class d implements a {
    d() {
    }

    public static a.a ri() {
        a.a aVar = new a.a();
        try {
            aVar.gPJ = Camera.open();
            aVar.gPG = 0;
            if (aVar.gPJ == null) {
                return null;
            }
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}
