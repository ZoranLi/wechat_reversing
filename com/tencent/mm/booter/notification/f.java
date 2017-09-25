package com.tencent.mm.booter.notification;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public e gLJ = new e();

    private static class a {
        public static final f gLK = new f();
    }

    public final boolean a(String str, au auVar, int i, boolean z) {
        if (bg.mA(str)) {
            return false;
        }
        return c.a(str, auVar, i, z);
    }

    public final int a(NotificationItem notificationItem) {
        return this.gLJ.a(notificationItem, null);
    }

    public final void j(int i, String str) {
        ArrayList arrayList;
        w.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", Integer.valueOf(i), str);
        if (i == -1) {
            i = com.tencent.mm.i.f.sR();
        }
        c.dQ(i);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList();
            List sQ = com.tencent.mm.i.f.sQ();
            if (sQ == null) {
                sQ = new ArrayList();
            }
            for (String str2 : r0) {
                a aVar = new a();
                aVar.userName = str2;
                aVar.gLo = com.tencent.mm.i.f.dF(str2);
                arrayList.add(aVar);
            }
        } else {
            a aVar2;
            ArrayList qo = c.qo();
            arrayList = qo == null ? new ArrayList() : qo;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar2 = (a) it.next();
                if (aVar2.userName.equals(str)) {
                    arrayList.remove(aVar2);
                    break;
                }
            }
            aVar2 = null;
            if (aVar2 == null) {
                aVar2 = new a();
            }
            aVar2.userName = str;
            aVar2.gLo = com.tencent.mm.i.f.dF(str);
            if (aVar2.gLo == 0 && arrayList.isEmpty()) {
                c.d(null);
                return;
            } else if (aVar2.gLo > 0) {
                arrayList.add(aVar2);
            }
        }
        c.d(arrayList);
    }
}
