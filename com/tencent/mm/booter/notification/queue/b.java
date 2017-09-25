package com.tencent.mm.booter.notification.queue;

import android.os.Build.VERSION;
import android.support.v4.app.af;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements Iterable<NotificationItem> {
    public NotificationQueue gLP = new NotificationQueue();
    public a gLQ = new a();
    public int mark = -1;

    private static final class a {
        public static final b gLR = new b();
    }

    public static final b qr() {
        return a.gLR;
    }

    public b() {
        restore();
    }

    public final void restore() {
        this.gLP.restore();
        this.gLQ.restore();
    }

    public final int size() {
        NotificationQueue notificationQueue = this.gLP;
        if (notificationQueue.gLO == null) {
            notificationQueue.restore();
        }
        return notificationQueue.gLO.size();
    }

    public final NotificationItem qs() {
        for (int i = 0; i < size(); i++) {
            NotificationQueue notificationQueue = this.gLP;
            if (notificationQueue.gLO == null) {
                notificationQueue.restore();
            }
            NotificationItem notificationItem = (NotificationItem) notificationQueue.gLO.get(i);
            if (notificationItem.gLG) {
                if (this.gLQ.aO(notificationItem.id)) {
                    w.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", notificationItem.toString());
                }
                this.gLP.c(notificationItem);
                return notificationItem;
            }
        }
        return null;
    }

    public final void remove(int i) {
        this.gLQ.aO(i);
        NotificationItem dT = this.gLP.dT(i);
        if (dT != null) {
            dT.clear();
        }
    }

    public final Queue<Integer> qt() {
        Queue<Integer> linkedList = new LinkedList();
        for (int i = 4097; i < 4102; i++) {
            linkedList.add(Integer.valueOf(i));
        }
        linkedList.addAll(qu());
        return linkedList;
    }

    private Queue<Integer> qu() {
        Queue<Integer> linkedList = new LinkedList();
        Queue<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.gLP;
        if (notificationQueue.gLO == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.gLO);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.gLG) {
                linkedList.add(Integer.valueOf(notificationItem.id));
                w.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(notificationItem.id));
            }
        }
        linkedList2.clear();
        Queue<com.tencent.mm.booter.notification.queue.a.a> linkedList3 = new LinkedList();
        a aVar = this.gLQ;
        if (aVar.gLL == null) {
            aVar.restore();
        }
        linkedList3.addAll(aVar.gLL);
        for (com.tencent.mm.booter.notification.queue.a.a aVar2 : linkedList3) {
            if (aVar2.gLG) {
                linkedList.add(Integer.valueOf(aVar2.gLM));
                w.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(aVar2.gLM));
            }
        }
        linkedList3.clear();
        return linkedList;
    }

    public final int getId(String str) {
        if (u.mA(str)) {
            return -1;
        }
        Iterator it = this.gLQ.iterator();
        while (it.hasNext()) {
            com.tencent.mm.booter.notification.queue.a.a aVar = (com.tencent.mm.booter.notification.queue.a.a) it.next();
            if (aVar.userName.equals(str)) {
                return aVar.gLM;
            }
        }
        return -1;
    }

    public final void cancel(int i) {
        a(af.h(ab.getContext()), i);
    }

    public final void a(af afVar, int i) {
        af.sR.a(afVar.sO, null, i);
        if (VERSION.SDK_INT <= 19) {
            afVar.a(new a(afVar.mContext.getPackageName(), i, null));
        }
        remove(i);
    }

    public final int de(String str) {
        int id = getId(str);
        return id > 0 ? id : az(true);
    }

    public final int az(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.gLQ.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + ((com.tencent.mm.booter.notification.queue.a.a) it.next()).gLM + ",";
        }
        int i = z ? 4097 : 4102;
        while (str.contains(String.valueOf(i))) {
            i++;
        }
        if (i >= 4102 && z) {
            i = 4097;
        }
        w.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z));
        return i;
    }

    public final Iterator<NotificationItem> iterator() {
        NotificationQueue notificationQueue = this.gLP;
        if (notificationQueue.gLO == null) {
            notificationQueue.restore();
        }
        return notificationQueue.gLO.iterator();
    }
}
