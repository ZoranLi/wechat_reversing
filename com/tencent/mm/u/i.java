package com.tencent.mm.u;

import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public final class i {
    public static boolean er(String str) {
        if (!o.dH(str)) {
            return false;
        }
        long j;
        boolean z;
        aj Rm = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm(str);
        if (Rm == null || Rm.field_lastSeq == 0 || ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().y(str, Rm.field_lastSeq).field_msgId != 0) {
            j = 0;
            z = false;
        } else {
            j = Rm.field_lastSeq;
            z = true;
        }
        if (!z) {
            ce AF = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().AF(str);
            if (!(AF == null || AF.field_msgId == 0)) {
                z = true;
            }
        }
        if (j == 0) {
            j = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().AE(str);
        }
        if (j != 0) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).xC().v(str, j);
        }
        w.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z), Long.valueOf(j));
        return z;
    }

    public static List<Boolean> r(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String er : list) {
            arrayList.add(Boolean.valueOf(er(er)));
        }
        return arrayList;
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3) {
        a(str, list, str2, z, str3, 2);
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3, int i) {
        au auVar = new au();
        auVar.cH(str);
        auVar.setType(10000);
        auVar.z(System.currentTimeMillis());
        auVar.dv(4);
        auVar.dw(i);
        CharSequence stringBuffer = new StringBuffer();
        if (list != null) {
            String xL = m.xL();
            String string = ab.getContext().getString(a.dTc);
            for (String str4 : list) {
                if (!str4.equals(xL)) {
                    com.tencent.mm.j.a Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str4);
                    if (Rc == null || ((int) Rc.gTQ) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + Rc.tL() + "</a>" + string);
                    } else {
                        stringBuffer.append(Rc.tL() + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        auVar.setContent(str2.replace("%s", stringBuffer));
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().L(auVar);
    }
}
