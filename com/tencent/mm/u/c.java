package com.tencent.mm.u;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.h;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b.d;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static HashMap<Integer, com.tencent.mm.bj.g.c> gJr;
    public bi hkK;
    public bh hkL;
    h hkM;
    com.tencent.mm.u.b.c hkN;
    d hkO;
    ap hkP;
    j hkQ;
    n hkR;
    l hkS;
    com.tencent.mm.u.b.b hkT;

    public interface a {
        void a(c cVar, boolean z);

        void aN(boolean z);

        void xH();
    }

    static class b implements Runnable {
        String fTm;
        String hkV;

        public b(String str, String str2) {
            this.fTm = str;
            this.hkV = str2;
        }

        public final void run() {
            if (!bg.mA(this.fTm) && !bg.mA(this.hkV)) {
                w.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.fTm + " to :" + this.hkV);
                if (f.rZ() && this.hkV.substring(0, e.hgu.length()).equals(e.hgu)) {
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "image/", this.hkV + "image/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "image2/", this.hkV + "image2/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "video/", this.hkV + "video/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "voice/", this.hkV + "voice/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "voice2/", this.hkV + "voice2/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "package/", this.hkV + "package/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "emoji/", this.hkV + "emoji/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "mailapp/", this.hkV + "mailapp/", true);
                    com.tencent.mm.sdk.platformtools.j.p(this.fTm + "brandicon/", this.hkV + "brandicon/", true);
                }
            }
        }
    }

    public c() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.e vI = com.tencent.mm.kernel.h.vI();
        vI.gYa.bI(new com.tencent.mm.bj.g.a(this) {
            final /* synthetic */ c hkU;

            {
                this.hkU = r1;
            }

            public final void vy() {
                com.tencent.mm.kernel.h.vJ();
                if (com.tencent.mm.kernel.h.vG().uV()) {
                    com.tencent.mm.modelstat.l Kh = p.Kh();
                    if (Kh != null) {
                        w.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: " + Kh);
                        long currentTimeMillis = System.currentTimeMillis();
                        Kh.hWZ.jV(true);
                        w.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                }
            }

            public final void vz() {
            }

            public final void vA() {
            }
        });
        com.tencent.mm.kernel.h.vJ();
        vI = com.tencent.mm.kernel.h.vI();
        vI.gXZ.bI(new com.tencent.mm.kernel.api.b(this) {
            final /* synthetic */ c hkU;

            {
                this.hkU = r1;
            }

            public final List<String> collectStoragePaths() {
                Object linkedList = new LinkedList();
                Collections.addAll(linkedList, new String[]{"image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/"});
                return linkedList;
            }
        });
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vI().a(new g(this) {
            final /* synthetic */ c hkU;

            {
                this.hkU = r1;
            }

            public final void aR(boolean z) {
                if (z) {
                    com.tencent.mm.q.c.uk().s(262145, false);
                }
            }

            public final void onDataBaseOpened(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
            }

            public final void vB() {
                ap.yR().aN(f.rZ());
                ap.yX();
            }

            public final void eg(String str) {
                if (f.rZ()) {
                    com.tencent.mm.kernel.h.vJ();
                    if (com.tencent.mm.kernel.h.vI().gYe.equals(e.hgu)) {
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.sdk.f.e.post(new b(com.tencent.mm.kernel.h.vI().cachePath, str), "AccountStorage_moveDataFiles");
                    }
                }
            }

            public final void onDataBaseClosed(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
            }
        });
        com.tencent.mm.kernel.h.vJ();
        vI = com.tencent.mm.kernel.h.vI();
        AnonymousClass7 anonymousClass7 = new com.tencent.mm.kernel.api.a(this) {
            final /* synthetic */ c hkU;

            {
                this.hkU = r1;
            }

            public final HashMap<Integer, com.tencent.mm.bj.g.c> collectDatabaseFactory() {
                w.i("MicroMsg.AccountStorage", "Carl WTF --- collectDatabaseFactory ");
                HashMap<Integer, com.tencent.mm.bj.g.c> hashMap = new HashMap();
                hashMap.putAll(c.gJr);
                hashMap.putAll(ap.yR().zS());
                return hashMap;
            }
        };
        synchronized (vI.gYc) {
            vI.gYc.add(anonymousClass7);
        }
    }

    public static int uH() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG();
        return com.tencent.mm.kernel.a.uH();
    }

    public static String wK() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().gYe;
    }

    public static void vt() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vI().vt();
    }

    public static boolean isSDCardAvailable() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().isSDCardAvailable();
    }

    public static String vn() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().vn();
    }

    public static void wL() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vI().cQ(null);
    }

    public static void a(al alVar) {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.a vG = com.tencent.mm.kernel.h.vG();
        w.i("MMKernel.CoreAccount", "UserStatusChange: add %s", alVar);
        synchronized (vG.gXm) {
            if (!vG.gXm.contains(alVar)) {
                vG.gXm.add(alVar);
            }
        }
    }

    public static void b(al alVar) {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.a vG = com.tencent.mm.kernel.h.vG();
        w.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", alVar);
        synchronized (vG.gXm) {
            vG.gXm.remove(alVar);
        }
    }

    public static void uR() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uR();
    }

    public static boolean wM() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.a.eN(com.tencent.mm.kernel.h.vG().gXk);
    }

    public static boolean eN(int i) {
        return com.tencent.mm.kernel.a.eN(i);
    }

    public static int wN() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vG().gXl;
    }

    public static com.tencent.mm.bj.g wO() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().gYg;
    }

    public static com.tencent.mm.bj.g wP() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().gYh;
    }

    public static SharedPreferences ef(String str) {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().ef(str);
    }

    public static t vr() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().vr();
    }

    public static ba vs() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().vs();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.d wQ() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ();
    }

    public static ar wR() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.g wS() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wS();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.c wT() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX();
    }

    public static o wU() {
        return ((com.tencent.mm.modelbiz.n) com.tencent.mm.kernel.h.h(com.tencent.mm.modelbiz.n.class)).wU();
    }

    public static com.tencent.mm.storage.p wV() {
        return ((com.tencent.mm.modelbiz.n) com.tencent.mm.kernel.h.h(com.tencent.mm.modelbiz.n.class)).wV();
    }

    public static as wW() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW();
    }

    public static com.tencent.mm.plugin.downloader.b.b wX() {
        return ((com.tencent.mm.plugin.downloader.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.downloader.a.a.class)).wX();
    }

    public static at wY() {
        return ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.f wZ() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ();
    }

    public static aa xa() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return ((com.tencent.mm.plugin.chatroom.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa();
    }

    public static String xb() {
        return com.tencent.mm.plugin.n.b.xb();
    }

    public static String xc() {
        return com.tencent.mm.plugin.n.b.xc();
    }

    public static String xd() {
        return com.tencent.mm.plugin.ab.a.xd();
    }

    public static String xe() {
        return q.xe();
    }

    public static String xf() {
        return q.xf();
    }

    public static String xg() {
        return com.tencent.mm.plugin.record.b.xg();
    }

    public static String xh() {
        return u.xh();
    }

    public static String xi() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("emoji/").toString();
    }

    public static String xj() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("mailapp/").toString();
    }

    public static String getAccVideoPath() {
        com.tencent.mm.modelvideo.o.KU();
        return com.tencent.mm.modelvideo.o.getAccVideoPath();
    }

    public static String xk() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("image/shakeTranImg/").toString();
    }

    public static String xl() {
        return com.tencent.mm.plugin.l.a.xl();
    }

    public static String xm() {
        return com.tencent.mm.plugin.w.a.xm();
    }

    public static String xn() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("attachment/").toString();
    }

    public static String xo() {
        return ((com.tencent.mm.modelbiz.n) com.tencent.mm.kernel.h.h(com.tencent.mm.modelbiz.n.class)).xo();
    }

    public static String xp() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("record/").toString();
    }

    public static String xq() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.vJ();
        return stringBuilder.append(com.tencent.mm.kernel.h.vI().gYf).append("draft/").toString();
    }

    public static String getAccSnsPath() {
        return ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    }

    public static String getAccSnsTmpPath() {
        return ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    }

    public static String xr() {
        return com.tencent.mm.plugin.n.b.xr();
    }

    public static String xs() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(xv()).append("voiceremind/").toString();
    }

    public static String xt() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(xv()).append("wenote/").toString();
    }

    public static String vo() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().vo();
    }

    public static String vp() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().vp();
    }

    public static String xu() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().cachePath;
    }

    public static String xv() {
        com.tencent.mm.kernel.h.vJ();
        return com.tencent.mm.kernel.h.vI().gYf;
    }

    public final void xw() {
        StringBuilder stringBuilder = new StringBuilder("mm");
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG();
        String n = com.tencent.mm.a.g.n(stringBuilder.append(com.tencent.mm.kernel.a.uH()).toString().getBytes());
        String str = com.tencent.mm.storage.w.hgq + n + "/";
        String str2 = e.hgu + n + "/";
        for (String str3 : new File(str).list(new FilenameFilter(this) {
            final /* synthetic */ c hkU;

            {
                this.hkU = r1;
            }

            public final boolean accept(File file, String str) {
                return str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("FTS5IndexMicroMsg.db");
            }
        })) {
            String str4 = str2 + str3 + ".dump";
            FileOp.deleteFile(str4);
            FileOp.p(str + str3, str4);
            w.i("MicroMsg.AccountStorage", "Exported: " + str4);
        }
    }

    public static void xx() {
    }

    public static void eD(int i) {
        ap.yR().fl(i);
        if ((i & 16) != 0) {
            ay.a("medianote", null);
            ap.yY();
            wW().Rl("medianote");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return am.gUx;
            }
        });
        gJr.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return h.gUx;
            }
        });
        gJr.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return com.tencent.mm.storage.g.gUx;
            }
        });
        gJr.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return ap.gUx;
            }
        });
        gJr.put(Integer.valueOf("BackupMoveTime".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return j.gUx;
            }
        });
        gJr.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return n.gUx;
            }
        });
        gJr.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new com.tencent.mm.bj.g.c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
    }

    public final com.tencent.mm.u.b.c xy() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.hkN;
    }

    public final d xz() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.hkO;
    }

    public final com.tencent.mm.u.b.b xA() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.hkT;
    }

    public static com.tencent.mm.storage.g xB() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return com.tencent.mm.plugin.d.a.Pj().xB();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.b xC() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).xC();
    }

    public final ap xD() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.hkP;
    }

    public final j xE() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.hkQ;
    }

    public final n xF() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.hkR;
    }

    public final l xG() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.hkS;
    }
}
