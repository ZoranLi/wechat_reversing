package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Serializable, Iterable<a> {
    LinkedList<a> gLL;

    public static class a implements Serializable {
        public long fGM = -1;
        public boolean gLG = false;
        public int gLM;
        public int gLN = 0;
        public int gLo;
        public String userName = "";

        public a(int i, long j, String str, int i2, boolean z, int i3) {
            a(i, j, str, i2, z, i3);
        }

        public a(int i, boolean z) {
            this.gLM = i;
            this.gLG = z;
        }

        public final void a(int i, long j, String str, int i2, boolean z, int i3) {
            this.gLM = i;
            this.fGM = j;
            this.userName = str;
            this.gLo = i2;
            this.gLG = z;
            this.gLN = i3;
        }

        public final String toString() {
            return this.userName + " id:" + this.fGM + " unReadCount:" + this.gLo + "　notificationId:" + this.gLM;
        }
    }

    public final String toString() {
        Iterator it = this.gLL.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + ((a) it.next()).toString() + ";  ";
        }
        return str;
    }

    public final synchronized void restore() {
        try {
            this.gLL = (LinkedList) c.df(com.tencent.mm.i.a.sj().getString("com.tencent.preference.notification.key.queue", ""));
            if (this.gLL == null) {
                this.gLL = new LinkedList();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
            if (this.gLL == null) {
                this.gLL = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.gLL == null) {
                this.gLL = new LinkedList();
            }
        }
        w.i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", Integer.valueOf(this.gLL.size()), toString());
    }

    private synchronized void save() {
        if (this.gLL != null) {
            w.d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", Integer.valueOf(this.gLL.size()));
            if (this.gLL.isEmpty()) {
                com.tencent.mm.i.a.sj().edit().putString("com.tencent.preference.notification.key.queue", "").apply();
                w.i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", Integer.valueOf(this.gLL.size()), toString());
            } else {
                try {
                    com.tencent.mm.i.a.sj().edit().putString("com.tencent.preference.notification.key.queue", c.a(new LinkedList(this.gLL))).apply();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
                }
                w.i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", Integer.valueOf(this.gLL.size()), toString());
            }
        }
    }

    public final synchronized void b(NotificationItem notificationItem) {
        Object obj = 1;
        synchronized (this) {
            if (notificationItem != null) {
                if (this.gLL == null) {
                    restore();
                }
                aO(notificationItem.id);
                if (!notificationItem.gLG || u.mA(notificationItem.gLD)) {
                    this.gLL.add(new a(notificationItem.id, notificationItem.gLG));
                    w.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                } else {
                    Iterator it = this.gLL.iterator();
                    while (it.hasNext()) {
                        Object obj2;
                        a aVar = (a) it.next();
                        if (aVar.userName.equals(notificationItem.gLD)) {
                            aVar.a(notificationItem.id, notificationItem.gLE, notificationItem.gLD, notificationItem.gLF, notificationItem.gLG, notificationItem.gLH);
                            obj2 = null;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.gLL.add(new a(notificationItem.id, notificationItem.gLE, notificationItem.gLD, notificationItem.gLF, notificationItem.gLG, notificationItem.gLH));
                        w.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                    }
                }
                save();
            }
        }
    }

    public final synchronized List<Integer> dS(int i) {
        List<Integer> arrayList;
        if (this.gLL == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!((aVar.gLN & i) == 0 || arrayList.contains(Integer.valueOf(aVar.gLM)))) {
                arrayList.add(Integer.valueOf(aVar.gLM));
            }
        }
        return arrayList;
    }

    public final synchronized boolean aO(int i) {
        boolean z;
        if (i == -1) {
            z = false;
        } else {
            if (this.gLL == null) {
                restore();
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.gLL.iterator();
            Object obj = null;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.gLM != i) {
                    linkedList.add(aVar);
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.gLL = linkedList;
                save();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean dd(String str) {
        boolean z;
        w.i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", str);
        if (u.mA(str)) {
            z = false;
        } else {
            if (this.gLL == null) {
                restore();
            }
            Iterator it = this.gLL.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (str.equals(aVar.userName)) {
                    this.gLL.remove(aVar);
                    save();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final Iterator<a> iterator() {
        if (this.gLL == null) {
            restore();
        }
        return this.gLL.iterator();
    }
}
