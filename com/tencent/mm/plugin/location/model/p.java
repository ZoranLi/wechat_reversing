package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.pluginsdk.l.r;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p implements s {
    private List<r> hDb = new LinkedList();
    private ae handler;
    private b ncr;
    private final String path;

    public p() {
        File file = new File(l.aGi());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = l.aGi() + "trackroominfolist.info";
        this.handler = new ae(Looper.getMainLooper());
        if (this.ncr != null) {
            return;
        }
        if (e.aO(this.path)) {
            try {
                this.ncr = (b) new b().aD(e.d(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
                this.ncr = new b();
                return;
            }
        }
        this.ncr = new b();
    }

    public final synchronized void a(r rVar) {
        this.hDb.add(rVar);
    }

    public final synchronized void b(r rVar) {
        this.hDb.remove(rVar);
    }

    public final synchronized LinkedList<String> zq(String str) {
        LinkedList<String> linkedList;
        Iterator it = this.ncr.naL.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.fPA.clone();
                break;
            }
        }
        linkedList = new LinkedList();
        return linkedList;
    }

    public final synchronized a zr(String str) {
        a aVar;
        Iterator it = this.ncr.naL.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                break;
            }
        }
        aVar = null;
        return aVar;
    }

    public final synchronized void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4) {
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        w.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[]{str, Integer.valueOf(linkedList.size()), Double.valueOf(d), Double.valueOf(d2)});
        LinkedList linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator it = this.ncr.naL.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.ncr.naL.remove(aVar);
                } else {
                    aVar.fPA = linkedList2;
                    aVar.naK = str2;
                    aVar.latitude = d;
                    aVar.longitude = d2;
                }
                aGt();
                J(str, str3, str4);
            }
        }
        if (!isEmpty) {
            aVar = new a();
            aVar.username = str;
            aVar.fPA = linkedList2;
            aVar.naK = str2;
            aVar.latitude = d;
            aVar.longitude = d2;
            this.ncr.naL.add(aVar);
        }
        aGt();
        J(str, str3, str4);
    }

    private void J(String str, String str2, String str3) {
        for (final r rVar : this.hDb) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ p ncv;

                public final void run() {
                    rVar.LJ(str4);
                }
            });
        }
    }

    private boolean aGt() {
        w.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[]{Integer.valueOf(this.ncr.naL.size())});
        if (this.ncr.naL.isEmpty()) {
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.ncr.toByteArray();
            e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean zs(String str) {
        return zq(str).size() > 0;
    }

    public final boolean aGu() {
        Iterator it = this.ncr.naL.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            w.d("MicroMsg.TrackRoomListMgr", "info :" + aVar.fPA.size());
            Iterator it2 = aVar.fPA.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                w.d("MicroMsg.TrackRoomListMgr", "member :" + str);
                if (str.equals(m.xL())) {
                    w.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean cH(String str, String str2) {
        return zq(str).contains(str2);
    }

    public final String aGv() {
        if (this.ncr != null) {
            return this.ncr.naM;
        }
        return "";
    }

    public final void zt(String str) {
        if (this.ncr != null) {
            this.ncr.naM = str;
        }
        aGt();
    }
}
