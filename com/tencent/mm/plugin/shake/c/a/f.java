package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.e.a.od;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
    public List<WeakReference<a>> kcI;
    private String poW;

    public interface a {
        void bba();
    }

    public static class c {
    }

    public static class b extends c {
        protected int poX = 0;
        protected int poY = 0;
        protected String poZ = "";
        protected int ppa = 0;
        protected int ppb = 0;
        protected int ppc = 7;
        protected String ppd = "";
    }

    public static class d extends c {
        protected String ppe;
        protected String ppf;
        protected String ppg;
    }

    public f() {
        this.kcI = new ArrayList();
        this.poW = "";
        this.poW = com.tencent.mm.plugin.shake.c.c.a.bbm();
    }

    public final void d(String str, long j, int i) {
        d dVar = null;
        w.i("MicroMsg.ShakeCardMsgMgr", "msg_id is " + j);
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
            return;
        }
        Map q;
        if (i == 0) {
            b bVar;
            w.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
            q = bh.q(str, "sysmsg");
            if (q != null) {
                b bVar2 = new b();
                String str2 = (String) q.get(".sysmsg.begintime");
                if (TextUtils.isEmpty(str2) || !tb(str2)) {
                    w.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is " + str2);
                    bVar2.poX = 0;
                } else {
                    bVar2.poX = Integer.valueOf(str2).intValue();
                }
                str2 = (String) q.get(".sysmsg.endtime");
                if (TextUtils.isEmpty(str2) || !tb(str2)) {
                    w.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is " + str2);
                    bVar2.poY = 0;
                } else {
                    bVar2.poY = Integer.valueOf(str2).intValue();
                }
                bVar2.poZ = (String) q.get(".sysmsg.entrancename");
                str2 = (String) q.get(".sysmsg.activitytype");
                if (TextUtils.isEmpty(str2) || !tb(str2)) {
                    bVar2.ppa = 1;
                } else {
                    bVar2.ppa = Integer.valueOf(str2).intValue();
                }
                w.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is " + str2);
                str2 = (String) q.get(".sysmsg.flowcontrollevelmin");
                if (TextUtils.isEmpty(str2) || !tb(str2)) {
                    w.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is " + str2);
                    bVar2.ppb = 0;
                } else {
                    bVar2.ppb = Integer.valueOf(str2).intValue();
                }
                bVar2.ppd = (String) q.get(".sysmsg.shakecardentrancetip");
                str2 = (String) q.get(".sysmsg.flowcontrollevelmax");
                if (TextUtils.isEmpty(str2) || !tb(str2)) {
                    w.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is " + str2);
                    bVar2.ppc = 0;
                } else {
                    bVar2.ppc = Integer.valueOf(str2).intValue();
                }
                bVar = bVar2;
            }
            if (bVar == null) {
                w.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
            } else {
                w.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
                if (!com.tencent.mm.plugin.shake.c.c.a.baN()) {
                    w.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
                }
                w.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + bVar.poX + "  endtime:" + bVar.poY + "  flowlevelmin:" + bVar.ppb + "  flowlevelmax:" + bVar.ppc + " entrancename:" + bVar.poZ + " activitytype:" + bVar.ppa);
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzp, Integer.valueOf(bVar.poX));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzq, Integer.valueOf(bVar.poY));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzr, bVar.poZ);
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzv, Integer.valueOf(bVar.ppa));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzs, Integer.valueOf(bVar.ppb));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzt, Integer.valueOf(bVar.ppc));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzu, bVar.ppd);
            }
            baZ();
        } else if (i == 1) {
            w.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
            q = bh.q(str, "sysmsg");
            if (q != null) {
                d dVar2 = new d();
                dVar2.ppe = (String) q.get(".sysmsg.reddotid");
                dVar2.ppf = (String) q.get(".sysmsg.reddotdesc");
                dVar2.ppg = (String) q.get(".sysmsg.reddottext");
                dVar = dVar2;
            }
            if (dVar == null) {
                w.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
            } else {
                w.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + dVar.ppe);
                w.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.poW);
                if (TextUtils.isEmpty(dVar.ppe)) {
                    w.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
                } else if (TextUtils.isEmpty(this.poW)) {
                    w.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
                    com.tencent.mm.q.c.uk().t(262154, true);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzw, dVar.ppe);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzx, dVar.ppf);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzy, dVar.ppg);
                    adZ();
                } else if (!this.poW.equals(dVar.ppe)) {
                    w.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
                    com.tencent.mm.q.c.uk().t(262154, true);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzw, dVar.ppe);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzx, dVar.ppf);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzy, dVar.ppg);
                    adZ();
                } else if (this.poW.equals(dVar.ppe)) {
                    w.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
                }
            }
            baZ();
        }
        com.tencent.mm.plugin.shake.c.c.a.baM();
    }

    private static void baZ() {
        com.tencent.mm.sdk.b.a.urY.m(new od());
    }

    private static boolean tb(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void adZ() {
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bba();
                    }
                }
            }
        }
    }
}
