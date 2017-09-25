package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.List;

public final class b {

    private static class a {
        List<String> qUn = new ArrayList();

        final String bGy() {
            if (this.qUn == null || this.qUn.size() == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : this.qUn) {
                stringBuffer.append(append);
                stringBuffer.append(";");
            }
            return stringBuffer.toString();
        }

        final void DF(String str) {
            this.qUn = new ArrayList();
            if (str != null && str.length() != 0) {
                for (Object add : str.split(";")) {
                    this.qUn.add(add);
                }
            }
        }
    }

    public static boolean Nj(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            return false;
        }
        t vr = h.vI().vr();
        if (vr == null) {
            w.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a();
        aVar.DF((String) vr.get(69121, null));
        if (!aVar.qUn.contains(str)) {
            aVar.qUn.add(str);
        }
        vr.set(69121, aVar.bGy());
        return true;
    }

    public static boolean Nk(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            return false;
        }
        t vr = h.vI().vr();
        if (vr == null) {
            w.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a();
        aVar.DF((String) vr.get(69121, null));
        if (aVar.qUn.contains(str)) {
            aVar.qUn.remove(str);
        }
        vr.set(69121, aVar.bGy());
        return true;
    }
}
