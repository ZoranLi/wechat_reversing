package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import java.nio.charset.Charset;

public final class k {
    public static i g(a aVar) {
        Exception exception;
        i iVar = new i();
        h.vJ();
        String str = (String) h.vI().vr().get(aVar, null);
        if (str == null) {
            w.i("MicroMsg.RedDotUtil", "load: redDotList data empty");
            return iVar;
        }
        i iVar2;
        try {
            iVar2 = (i) new i().aD(str.getBytes(Charset.forName("ISO-8859-1")));
            if (iVar2 == null) {
                try {
                    iVar2 = new i();
                } catch (Exception e) {
                    Exception exception2 = e;
                    iVar = iVar2;
                    exception = exception2;
                    w.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
                    iVar2 = iVar;
                    if (iVar2 == null) {
                        return new i();
                    }
                    return iVar2;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            w.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
            iVar2 = iVar;
            if (iVar2 == null) {
                return iVar2;
            }
            return new i();
        }
        if (iVar2 == null) {
            return new i();
        }
        return iVar2;
    }
}
