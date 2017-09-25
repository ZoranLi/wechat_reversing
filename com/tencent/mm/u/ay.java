package com.tencent.mm.u;

import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.e.a.ix;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.c;
import java.util.List;
import java.util.Map;

public final class ay {

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ a hll = null;
        final /* synthetic */ List hmM;

        public AnonymousClass3(List list, a aVar) {
            this.hmM = list;
        }

        public final void run() {
            for (String str : this.hmM) {
                Cursor Ar = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ar(str);
                if (Ar != null) {
                    if (Ar.moveToFirst()) {
                        while (!Ar.isAfterLast() && (this.hll == null || !this.hll.zs())) {
                            au auVar = new au();
                            auVar.b(Ar);
                            ay.j(auVar);
                            Ar.moveToNext();
                        }
                    }
                    Ar.close();
                    int Ao = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ao(str);
                    w.v("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(Ao));
                }
            }
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 hmN;

                {
                    this.hmN = r1;
                }

                public final void run() {
                    if (this.hmN.hll != null) {
                        this.hmN.hll.zr();
                    }
                }
            });
        }

        public final String toString() {
            return super.toString() + "|deleteMsgByTalkers";
        }
    }

    public interface a {
        void zr();

        boolean zs();
    }

    public static class b {
        public String hmO;
        public String hmP;
        public String hmQ;
        public String hmR;
        public String hmS;
        public String hmT;
        public String hmU;
        public String hmV;
        public String hmW;
        public String hmX;
        public int hmY;
        public int hmZ;
        public int hna;
        public int hnb;
        public String hnc;
        public int scene = 0;
        public String userId;
    }

    public static String M(String str, String str2) {
        if (bg.mA(str)) {
            return null;
        }
        return !bg.mA(str2) ? str2 + ": " + str : str;
    }

    public static int gh(String str) {
        if (str == null) {
            w.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            return -1;
        } else if (str.length() <= 0) {
            w.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            return -1;
        } else if (str.startsWith("~SEMI_XML~")) {
            w.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                return indexOf;
            }
            w.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            return -1;
        }
    }

    public static String gi(String str) {
        int gh = gh(str);
        if (gh == -1) {
            return null;
        }
        return str.substring(0, gh);
    }

    public static String gj(String str) {
        int gh = gh(str);
        return (gh != -1 && gh + 2 < str.length()) ? str.substring(gh + 2) : str;
    }

    public static long i(au auVar) {
        com.tencent.mm.j.a Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(auVar.field_talker);
        if (Rc == null || ((int) Rc.gTQ) == 0) {
            x xVar = new x(auVar.field_talker);
            xVar.setType(2);
            com.tencent.mm.sdk.b.b ixVar = new ix();
            ixVar.fOJ.fOK = xVar;
            com.tencent.mm.sdk.b.a.urY.m(ixVar);
            ((h) com.tencent.mm.kernel.h.h(h.class)).wR().R(xVar);
        }
        return ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().L(auVar);
    }

    public static boolean fc(int i) {
        switch (i) {
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case JsApiChooseImage.CTRL_INDEX /*29*/:
                return true;
            default:
                return false;
        }
    }

    public static long zn() {
        long currentTimeMillis = System.currentTimeMillis();
        w.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before fix, now is :%s", Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("system_config_prefs", 4);
        int i = sharedPreferences.getInt("client_server_diff_time_enable", 0);
        int i2 = sharedPreferences.getInt("client_server_diff_time_interval", 0);
        if (i <= 0 || i2 <= 0) {
            return currentTimeMillis;
        }
        com.tencent.mm.kernel.h.vJ();
        Object obj = com.tencent.mm.kernel.h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, null);
        if (obj == null) {
            return currentTimeMillis;
        }
        long j = bg.getLong(obj.toString(), 0);
        if (Math.abs(j / 1000) > ((long) i2)) {
            return currentTimeMillis - j;
        }
        return currentTimeMillis;
    }

    public static long gk(String str) {
        long zn = zn();
        w.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", Long.valueOf(zn));
        if (str != null) {
            ce Ai = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ai(str);
            if (Ai != null) {
                w.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", Long.valueOf(Ai.field_msgId), Long.valueOf(zn));
                if (Ai.field_createTime + 1 > zn) {
                    return Ai.field_createTime + 1;
                }
            }
        }
        return zn;
    }

    public static long i(String str, long j) {
        long j2;
        if (str != null) {
            ce Ai = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ai(str);
            if (Ai != null) {
                j2 = Ai.field_createTime + 1;
                return j2 <= j * 1000 ? j2 : j * 1000;
            }
        }
        j2 = 0;
        if (j2 <= j * 1000) {
        }
    }

    public static void j(au auVar) {
        if (auVar != null) {
            int i = auVar.field_type;
            switch (i) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    i = 49;
                    break;
            }
            d aB = c.aB(Integer.valueOf(i));
            if (aB != null) {
                aB.h(auVar);
            }
        }
    }

    public static void v(List<Long> list) {
        if (list.size() != 0) {
            for (Long longValue : list) {
                L(longValue.longValue());
            }
        }
    }

    public static int L(long j) {
        ce cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA(j);
        if (cA.field_msgId != j) {
            return 0;
        }
        j(cA);
        return ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cB(j);
    }

    public static int j(String str, long j) {
        ce x = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().x(str, j);
        if (x.field_msgSvrId != j) {
            return 0;
        }
        j(x);
        return ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().E(str, j);
    }

    public static int gl(String str) {
        return ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ao(str);
    }

    public static int a(final String str, final a aVar) {
        w.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalker %s", str);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new Runnable() {
            final int hmG = m.CTRL_INDEX;
            final int hmH = 30;
            final int hmI = 5;
            int hmJ = 100;

            public final void run() {
                long Nz = bg.Nz();
                ce Ai = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ai(str);
                long j = Ai == null ? Long.MAX_VALUE : Ai.field_createTime;
                long j2 = 0;
                int i = 0;
                long j3;
                do {
                    String str;
                    if (this.hmJ < m.CTRL_INDEX && this.hmJ > 30) {
                        int i2;
                        if (j2 > 500) {
                            i2 = this.hmJ - 5;
                        } else {
                            i2 = this.hmJ + 5;
                        }
                        this.hmJ = i2;
                    }
                    long Nz2 = bg.Nz();
                    Cursor f = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().f(str, this.hmJ, j);
                    long j4 = 0;
                    j3 = 0;
                    while (f.moveToNext() && (aVar == null || !aVar.zs())) {
                        ce auVar = new au();
                        auVar.b(f);
                        if (j4 < auVar.field_createTime) {
                            j4 = auVar.field_createTime;
                        }
                        j2 = 1 + j3;
                        ay.j(auVar);
                        j3 = j2;
                    }
                    f.close();
                    long Nz3 = bg.Nz();
                    if (j4 > 0 && j3 > 0) {
                        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().F(str, j4);
                    }
                    i = (int) (((long) i) + j3);
                    long Nz4 = bg.Nz();
                    j2 = Nz4 - Nz2;
                    String str2 = "MicroMsg.MsgInfoStorageLogic";
                    String str3 = "deleteMsgByTalker:%s iDelMsg:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)";
                    Object[] objArr = new Object[10];
                    objArr[0] = bg.Qj(str);
                    if (aVar == null) {
                        str = "null";
                    } else {
                        str = Boolean.valueOf(aVar.zs());
                    }
                    objArr[1] = str;
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Long.valueOf(j3);
                    objArr[4] = Long.valueOf(j - j4);
                    objArr[5] = Long.valueOf(j);
                    objArr[6] = Long.valueOf(Nz4 - Nz3);
                    objArr[7] = Long.valueOf(Nz4 - Nz2);
                    objArr[8] = Long.valueOf(Nz4 - Nz);
                    objArr[9] = Integer.valueOf(this.hmJ);
                    w.i(str2, str3, objArr);
                } while (j3 > 0);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 hmK;

                    {
                        this.hmK = r1;
                    }

                    public final void run() {
                        if (aVar != null) {
                            aVar.zr();
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|deleteMsgByTalker";
            }
        });
        return 0;
    }

    public static void a(final a aVar) {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new Runnable() {
            public final void run() {
                if (aVar == null || !aVar.zs()) {
                    ((h) com.tencent.mm.kernel.h.h(h.class)).wW().bLC();
                    if (aVar == null || !aVar.zs()) {
                        ay.zp();
                        if (aVar == null || !aVar.zs()) {
                            ay.zq();
                            if (aVar == null || !aVar.zs()) {
                                ay.zo();
                                if (aVar == null || !aVar.zs()) {
                                    List Al = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Al("message");
                                    if (Al != null) {
                                        for (int i = 0; i < Al.size(); i++) {
                                            ay.j((au) Al.get(i));
                                        }
                                    }
                                    ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().An("message");
                                }
                            }
                        }
                    }
                }
                if (aVar != null) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 hmL;

                        {
                            this.hmL = r1;
                        }

                        public final void run() {
                            aVar.zr();
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|deleteAllMsg";
            }
        });
    }

    public static void zo() {
        List Al = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Al("bottlemessage");
        if (Al != null) {
            for (int i = 0; i < Al.size(); i++) {
                j((au) Al.get(i));
            }
        }
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().An("bottlemessage");
    }

    public static void zp() {
        List Al = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Al("qmessage");
        if (Al != null) {
            for (int i = 0; i < Al.size(); i++) {
                j((au) Al.get(i));
            }
        }
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().An("qmessage");
    }

    public static void zq() {
        List Al = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Al("tmessage");
        if (Al != null) {
            for (int i = 0; i < Al.size(); i++) {
                j((au) Al.get(i));
            }
        }
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().An("tmessage");
    }

    public static b gm(String str) {
        if (bg.mA(str)) {
            return null;
        }
        try {
            Map q = bh.q(str, "msgsource");
            if (q == null || q.isEmpty()) {
                return null;
            }
            b bVar = new b();
            bVar.hmO = (String) q.get(".msgsource.bizmsg.msgcluster");
            bVar.hmQ = (String) q.get(".msgsource.kf.kf_worker");
            bVar.hmP = bg.mz((String) q.get(".msgsource.bizmsg.bizclientmsgid"));
            bVar.hmS = bg.mz((String) q.get(".msgsource.enterprise_info.qy_msg_type"));
            bVar.hmT = bg.mz((String) q.get(".msgsource.enterprise_info.bizchat_id"));
            bVar.hmU = bg.mz((String) q.get(".msgsource.enterprise_info.bizchat_ver"));
            bVar.userId = bg.mz((String) q.get(".msgsource.enterprise_info.user_id"));
            bVar.hmV = bg.mz((String) q.get(".msgsource.enterprise_info.user_nickname"));
            bVar.hmW = bg.mz((String) q.get(".msgsource.enterprise_info.sync_from_qy_im"));
            bVar.hmR = (String) q.get(".msgsource.strangerantispamticket.$ticket");
            bVar.scene = bg.getInt((String) q.get(".msgsource.strangerantispamticket.$scene"), 0);
            bVar.hmX = (String) q.get(".msgsource.NotAutoDownloadRange");
            bVar.hmY = bg.getInt((String) q.get(".msgsource.DownloadLimitKbps"), 0);
            bVar.hmZ = bg.getInt((String) q.get(".msgsource.videopreloadlen"), 0);
            bVar.hna = bg.getInt((String) q.get(".msgsource.PreDownload"), 0);
            bVar.hnb = bg.getInt((String) q.get(".msgsource.PreDownloadNetType"), 0);
            bVar.hnc = (String) q.get(".msgsource.NoPreDownloadRange");
            return bVar;
        } catch (Throwable e) {
            w.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", bg.g(e));
            w.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e.getMessage());
            return null;
        }
    }

    public static String gn(String str) {
        b gm = gm(str);
        if (gm == null) {
            return null;
        }
        return gm.hmQ;
    }

    public static void a(au auVar, com.tencent.mm.y.d.a aVar) {
        if (auVar == null || aVar == null || aVar.hst == null) {
            w.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", bg.bJZ());
        } else if (auVar.field_msgSvrId == aVar.hst.tfk) {
            bu buVar = aVar.hst;
            if (auVar.field_isSend == 0 || buVar.tfl != 0) {
                if (auVar.field_msgSeq == 0 && buVar.tfl != 0) {
                    auVar.B((long) buVar.tfl);
                }
                int i = auVar.field_flag;
                if (aVar.hsu) {
                    i |= 2;
                } else {
                    i &= -3;
                }
                if (aVar.hsv) {
                    i |= 1;
                } else {
                    i &= -2;
                }
                if (aVar.hsw) {
                    i |= 4;
                } else {
                    i &= -5;
                }
                auVar.dF(i);
                if (auVar.field_msgId == 0 && aVar.hsu) {
                    auVar.z(a(auVar.field_talker, (long) aVar.hst.ogM, aVar.hsw, (long) aVar.hst.tfl));
                }
            }
        }
    }

    public static int c(com.tencent.mm.y.d.a aVar) {
        int i = 0;
        if (aVar.hsu) {
            i = 2;
        }
        if (aVar.hsv) {
            i |= 1;
        }
        if (aVar.hsw) {
            return i | 4;
        }
        return i;
    }

    public static long a(String str, long j, boolean z, long j2) {
        long j3 = j * 1000;
        long j4 = 0;
        long j5 = -1;
        ce ceVar = null;
        if (str != null) {
            ceVar = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().Ai(str);
            if (ceVar != null) {
                j4 = ceVar.field_createTime;
            }
            j5 = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().AC(str);
        }
        if (j5 == j4) {
            return j3 == j4 ? j3 + 1 : j3;
        } else {
            if (j5 >= j4) {
                w.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3));
                return j3;
            } else if (j3 == j5) {
                return j3 - 1;
            } else {
                if (j3 == j4) {
                    return j3 + 1;
                }
                if (z || j2 == 0 || j3 > j4) {
                    return j3;
                }
                ce z2 = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().z(str, j3);
                if (z2.field_msgSeq == 0 || z2.field_msgSeq == j2) {
                    j5 = j3;
                } else {
                    j5 = z2.field_msgSeq < j2 ? 1 + j3 : j3 - 1;
                    w.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 1 seq[%d, %d] need fix serverMillTime[%d]", Long.valueOf(z2.field_msgSeq), Long.valueOf(j2), Long.valueOf(j5));
                    if (!(j5 != j4 || ceVar == null || ceVar.field_msgSeq == 0)) {
                        j5 = ceVar.field_msgSeq < j2 ? 1 + j4 : j4 - 1;
                        w.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 2 seq[%d, %d] need fix serverMillTime[%d]", Long.valueOf(ceVar.field_msgSeq), Long.valueOf(j2), Long.valueOf(j5));
                    }
                }
                return j5;
            }
        }
    }
}
