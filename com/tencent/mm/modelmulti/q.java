package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ao;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class q implements am {
    private b hMm;

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        Object obj = HA().hMm;
        if (obj != null) {
            ap.yY().xD().a(obj, ap.vL().nJF.getLooper());
            ap.vL().D(new Runnable(obj) {
                final /* synthetic */ b hJN;

                {
                    this.hJN = r1;
                }

                public final void run() {
                    Cursor Kk = ap.yY().xD().Kk();
                    if (Kk != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        if (Kk.moveToFirst()) {
                            while (!Kk.isAfterLast()) {
                                ao aoVar = new ao();
                                aoVar.b(Kk);
                                if (aoVar.field_originSvrId != 0) {
                                    if (currentTimeMillis > 604800000 + (aoVar.field_createTime * 1000)) {
                                        arrayList.add(aoVar);
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d] but expired and delete", Long.valueOf(aoVar.field_originSvrId));
                                    } else {
                                        w.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d]", Long.valueOf(aoVar.field_originSvrId));
                                        this.hJN.hJM.put(Long.valueOf(aoVar.field_originSvrId), aoVar);
                                    }
                                }
                                Kk.moveToNext();
                            }
                        }
                        Kk.close();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ao aoVar2 = (ao) it.next();
                            ap.yY().xD().b(aoVar2, false, "");
                        }
                    }
                }
            });
        }
    }

    public static r Hy() {
        return ((b) h.h(b.class)).Hy();
    }

    public static b Hz() {
        h.vG().uQ();
        if (HA().hMm == null) {
            HA().hMm = new b();
        }
        return HA().hMm;
    }

    private static q HA() {
        q qVar = (q) ap.yR().gs(q.class.getName());
        if (qVar != null) {
            return qVar;
        }
        Object qVar2 = new q();
        ap.yR().a(q.class.getName(), qVar2);
        return qVar2;
    }

    public final void onAccountRelease() {
        a aVar = HA().hMm;
        if (aVar != null) {
            w.i("MicroMsg.GetChatRoomMsgService", "clear clearList.size:%d needGetInfosMap.size:%d respList.size:%d, currentListener:%s", Integer.valueOf(aVar.hJK.size()), Integer.valueOf(aVar.hJJ.size()), Integer.valueOf(aVar.hDH.size()), aVar.hJL);
            aVar.hDL.KH();
            aVar.hDM.KH();
            aVar.hJK.clear();
            aVar.hJJ.clear();
            aVar.hDH.clear();
            aVar.hJL = null;
            aVar.hqI = false;
            ap.yY().xD().f(aVar);
        }
    }
}
