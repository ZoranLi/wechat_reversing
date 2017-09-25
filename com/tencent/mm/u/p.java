package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class p {
    private static final List<a> hlz = new ArrayList();

    public interface a {
        boolean a(String str, String str2, PInt pInt);
    }

    public static int fM(String str) {
        return a(str, null);
    }

    public static int a(String str, List<String> list) {
        if (h.vG().uV()) {
            int i;
            long NA = bg.NA();
            Cursor o = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().o(str, list);
            long NA2 = bg.NA();
            if (o == null || o.getCount() <= 0) {
                i = 0;
            } else {
                o.moveToFirst();
                i = o.getInt(0);
            }
            if (o != null) {
                o.close();
            }
            w.d("MicroMsg.ConversationLogic", "unreadcheck unRead getTotalUnread %d", Integer.valueOf(i));
            if (i <= 0) {
                i = 0;
            } else {
                Cursor Rv = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rv(str);
                if (Rv == null) {
                    w.w("MicroMsg.ConversationLogic", "cursor is null, return");
                    w.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bg.aB(NA2)));
                } else {
                    Rv.moveToFirst();
                    while (!Rv.isAfterLast()) {
                        int i2;
                        af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(Rv.getString(0));
                        if (Rc == null || Rc.gkz != 0) {
                            i2 = i;
                        } else {
                            i2 = i - Rv.getInt(1);
                            w.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", Rc.field_username, Integer.valueOf(i2));
                        }
                        Rv.moveToNext();
                        i = i2;
                    }
                    w.i("MicroMsg.ConversationLogic", "unreadcheck  result talker count is %d", Integer.valueOf(i));
                    Rv.close();
                    w.i("MicroMsg.ConversationLogic", "unreadcheck get count use %d ms", Long.valueOf(bg.aB(NA2)));
                    i = Math.max(0, i);
                }
            }
            o.close();
            w.i("MicroMsg.ConversationLogic", "get count with black list use %d ms", Long.valueOf(bg.aB(NA)));
            return i;
        }
        w.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
        return 0;
    }

    public static int F(String str, String str2) {
        if (h.vG().uV()) {
            int i;
            Cursor eK = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().eK(str, str2);
            if (eK == null || eK.getCount() <= 0) {
                i = 0;
            } else {
                eK.moveToFirst();
                i = eK.getInt(0);
            }
            if (eK == null) {
                return i;
            }
            eK.close();
            return i;
        }
        w.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
        return 0;
    }

    public static int fN(String str) {
        if (h.vG().uV()) {
            int i;
            long NA = bg.NA();
            Cursor p = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().p(str, null);
            if (p.getCount() > 0) {
                p.moveToFirst();
                i = p.getInt(0);
            } else {
                i = 0;
            }
            p.close();
            if (i <= 0) {
                return 0;
            }
            p = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rv(str);
            if (p == null) {
                w.w("MicroMsg.ConversationLogic", "cursor is null, return");
                w.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bg.aB(NA)));
                return i;
            }
            p.moveToFirst();
            while (!p.isAfterLast()) {
                af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(p.getString(0));
                int i2 = (Rc == null || Rc.gkz != 0) ? i : i - 1;
                p.moveToNext();
                i = i2;
            }
            w.i("MicroMsg.ConversationLogic", "result talker count is %d", Integer.valueOf(i));
            p.close();
            w.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bg.aB(NA)));
            return Math.max(0, i);
        }
        w.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
        return 0;
    }

    public static List<String> s(String str, int i) {
        List<String> list = null;
        if (h.vG().uV()) {
            Cursor cG = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().cG(str, -1);
            if (cG.moveToNext()) {
                ArrayList arrayList = new ArrayList();
                do {
                    w.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", cG.getString(0));
                    arrayList.add(cG.getString(0));
                } while (cG.moveToNext());
                list = arrayList;
            }
            cG.close();
            if (list != null) {
                cG = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rv(str);
                if (cG != null) {
                    cG.moveToFirst();
                    while (!cG.isAfterLast()) {
                        af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(cG.getString(0));
                        if (Rc != null && Rc.gkz == 0) {
                            w.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", Rc.tK());
                            list.remove(Rc.tK());
                        }
                        cG.moveToNext();
                    }
                    cG.close();
                }
            }
        } else {
            w.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
        }
        return list;
    }

    public static int G(String str, String str2) {
        if (bg.mA(str)) {
            return 0;
        }
        if ("notification_messages".equals(str)) {
            return 8;
        }
        if (str2 != null && str2.endsWith("@chatroom")) {
            return 2;
        }
        int i;
        PInt pInt = new PInt();
        synchronized (hlz) {
            int i2 = 0;
            boolean z = false;
            while (i2 < hlz.size()) {
                boolean a;
                a aVar = (a) hlz.get(i2);
                if (aVar != null) {
                    a = aVar.a(str, str2, pInt);
                    if (a) {
                        z = a;
                        i = pInt.value;
                        break;
                    }
                } else {
                    a = z;
                }
                i2++;
                z = a;
            }
            i = 0;
        }
        if (z) {
            return i;
        }
        return 1;
    }

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        synchronized (hlz) {
            hlz.add(aVar);
        }
    }
}
