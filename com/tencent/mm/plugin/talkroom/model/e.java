package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.plugin.talkroom.a.a;
import com.tencent.mm.plugin.talkroom.a.b;
import com.tencent.mm.pluginsdk.l.m;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements n {
    private ae handler;
    private final String path;
    private b qXQ;
    private HashSet<m> qXR = new HashSet();

    public e() {
        File file = new File(b.bnD());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = b.bnD() + "talkroomMemberList.info";
        this.handler = new ae(Looper.getMainLooper());
        if (this.qXQ != null) {
            return;
        }
        if (com.tencent.mm.a.e.aO(this.path)) {
            try {
                this.qXQ = (b) new b().aD(com.tencent.mm.a.e.d(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
                this.qXQ = new b();
                return;
            }
        }
        this.qXQ = new b();
    }

    public final synchronized void a(m mVar) {
        this.qXR.add(mVar);
    }

    public final synchronized void b(m mVar) {
        this.qXR.remove(mVar);
    }

    public final synchronized boolean Hr(String str) {
        boolean z;
        Iterator it = this.qXQ.qXD.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str) && aVar.nXW == 0) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public final synchronized boolean bnI() {
        boolean z;
        Iterator it = this.qXQ.qXD.iterator();
        loop0:
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.nXW == 0) {
                Iterator it2 = aVar.fPA.iterator();
                while (it2.hasNext()) {
                    if (com.tencent.mm.u.m.xL().equals(((beu) it2.next()).jNj)) {
                        z = true;
                        break loop0;
                    }
                }
                continue;
            }
        }
        z = false;
        return z;
    }

    public final synchronized LinkedList<beu> Hs(String str) {
        LinkedList<beu> linkedList;
        Iterator it = this.qXQ.qXD.iterator();
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

    public final synchronized void a(String str, LinkedList<beu> linkedList, String str2, String str3, int i) {
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        w.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[]{str, Integer.valueOf(linkedList.size())});
        LinkedList linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator it = this.qXQ.qXD.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.qXQ.qXD.remove(aVar);
                } else {
                    aVar.fPA = linkedList2;
                    aVar.nXW = i;
                }
                aGt();
                J(str, str2, str3);
            }
        }
        if (!isEmpty) {
            aVar = new a();
            aVar.username = str;
            aVar.fPA = linkedList2;
            aVar.nXW = i;
            this.qXQ.qXD.add(aVar);
        }
        aGt();
        J(str, str2, str3);
    }

    private void J(String str, String str2, String str3) {
        Iterator it = this.qXR.iterator();
        while (it.hasNext()) {
            final m mVar = (m) it.next();
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ e qXT;

                public final void run() {
                    mVar.B(str4, str5, str6);
                }
            });
        }
    }

    private boolean aGt() {
        if (this.qXQ.qXD.isEmpty()) {
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.qXQ.toByteArray();
            com.tencent.mm.a.e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
            return false;
        }
    }
}
