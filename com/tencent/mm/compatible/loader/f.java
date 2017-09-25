package com.tencent.mm.compatible.loader;

import android.app.Application;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class f {
    public static e a(Application application, String str) {
        try {
            e eVar = (e) ab.getContext().getClassLoader().loadClass(ab.bIW() + str).newInstance();
            eVar.app = application;
            return eVar;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
            return null;
        }
    }
}
