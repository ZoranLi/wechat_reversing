package com.tencent.mm.u;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.Map;

public final class ba {
    public static int hnq = 0;

    public static void q(String str, boolean z) {
        if (!"bizflag".equals(str)) {
            return;
        }
        if (z) {
            hnq |= 1;
        } else {
            hnq &= -2;
        }
    }

    public static String zy() {
        StringBuilder stringBuilder = new StringBuilder();
        if (hnq != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(hnq);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        return stringBuilder.toString();
    }

    public static int k(au auVar) {
        if (auVar == null) {
            return 0;
        }
        int i;
        Map q = bh.q(auVar.gxF, "msgsource");
        if (q != null) {
            String str = (String) q.get(".msgsource.bizflag");
            if (!bg.mA(str)) {
                i = bg.getInt(str, 0);
                return i;
            }
        }
        i = 0;
        return i;
    }

    public static String zz() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bg.mz(zy()));
        if (stringBuilder.length() <= 0) {
            return null;
        }
        stringBuilder.insert(0, "<msgsource>");
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static String zA() {
        String str = (String) h.vI().vr().get(70, null);
        if (!bg.mA(str)) {
            h.vI().vr().set(70, "");
        }
        w.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append(bg.mz(str));
        if (hnq != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(hnq);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static void gp(String str) {
        w.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", str, "");
    }
}
