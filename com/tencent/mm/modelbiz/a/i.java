package com.tencent.mm.modelbiz.a;

import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;

public final class i {
    public static void f(int i, String str, String str2) {
        if ("EnterpriseChatStatus".equals(str)) {
            String[] split = str2.split(";");
            String str3 = split[0];
            String str4 = split[1];
            bg.getInt(split[2], 0);
            if (i == 7) {
                aa(str4, str3);
            } else if (i == 8) {
                aa(str4, str3);
            } else if (i == 9) {
                aa(str4, str3);
            }
        }
    }

    private static void aa(String str, String str2) {
        long iy = e.iy(str);
        if (iy == -1) {
            w.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", str);
            return;
        }
        int i = com.tencent.mm.modelbiz.w.DK().U(iy).field_newUnReadCount;
        com.tencent.mm.modelbiz.w.DK().W(iy);
        c aa = com.tencent.mm.modelbiz.w.DJ().aa(iy);
        ae Rm = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm(str2);
        if (Rm == null) {
            w.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", str2);
        } else if (aa.fu(1)) {
            if (Rm.field_unReadMuteCount <= i) {
                Rm.dA(0);
                ((h) com.tencent.mm.kernel.h.h(h.class)).wW().a(Rm, str2);
                ((a) com.tencent.mm.kernel.h.j(a.class)).getNotification().cancelNotification(str2);
                return;
            }
            Rm.dA(Rm.field_unReadMuteCount - i);
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().a(Rm, str2);
        } else if (Rm.field_unReadCount <= i) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Ro(str2);
            ((a) com.tencent.mm.kernel.h.j(a.class)).getNotification().cancelNotification(str2);
        } else {
            Rm.dz(0);
            Rm.dt(Rm.field_unReadCount - i);
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().a(Rm, str2);
        }
    }
}
