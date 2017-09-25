package com.tencent.mm.plugin.record.a;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.lk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class s implements am {
    private static HashMap<Integer, c> gJr;
    private l oOI = null;
    private i oOJ = null;
    private p oOK = null;
    private h oOL = null;
    private e oOM = null;
    private q oON = new q();
    private com.tencent.mm.sdk.b.c oOO = new com.tencent.mm.sdk.b.c<lk>(this) {
        final /* synthetic */ s oOP;

        {
            this.oOP = r2;
            this.usg = lk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            lk lkVar = (lk) bVar;
            String str = lkVar.fSn.fQX;
            long j = lkVar.fSn.fEU;
            Iterator it = m.Dp(str).hkm.iterator();
            String str2 = "";
            while (it.hasNext()) {
                str2 = str2 + m.c((rm) it.next(), j) + ":";
            }
            lkVar.fSo.fSp = str2;
            return true;
        }
    };

    private static s aWD() {
        s sVar = (s) ap.yR().gs("plugin.record");
        if (sVar != null) {
            return sVar;
        }
        Object sVar2 = new s();
        ap.yR().a("plugin.record", sVar2);
        return sVar2;
    }

    public static l aWE() {
        h.vG().uQ();
        if (aWD().oOI == null) {
            s aWD = aWD();
            ap.yY();
            aWD.oOI = new l(com.tencent.mm.u.c.wO());
        }
        return aWD().oOI;
    }

    public static i aWF() {
        h.vG().uQ();
        if (aWD().oOJ == null) {
            s aWD = aWD();
            ap.yY();
            aWD.oOJ = new i(com.tencent.mm.u.c.wO());
        }
        return aWD().oOJ;
    }

    public static p aWG() {
        h.vG().uQ();
        if (aWD().oOK == null) {
            aWD().oOK = new p();
        }
        return aWD().oOK;
    }

    public static h aWH() {
        h.vG().uQ();
        if (aWD().oOL == null) {
            aWD().oOL = new h();
        }
        return aWD().oOL;
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
        gJr.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return i.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.d("MicroMsg.SubCoreRecordMsg", "on account post reset");
        a.urY.b(this.oON);
        a.urY.b(this.oOO);
        this.oOM = new e();
        aWF().a(this.oOM);
        ap.yY();
        File file = new File(com.tencent.mm.u.c.xp());
        if (!file.exists() || !file.isDirectory()) {
            w.d("MicroMsg.SubCoreRecordMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.d("MicroMsg.SubCoreRecordMsg", "on account post release");
        a.urY.c(this.oON);
        a.urY.c(this.oOO);
        aWF().b(this.oOM);
        this.oOM = null;
        i.a aVar = aWD().oOK;
        if (aVar != null) {
            aVar.finish();
            ap.vd().b(632, (e) aVar);
            aWF().b(aVar);
        }
        f fVar = aWD().oOL;
        if (fVar != null) {
            fVar.finish();
        }
    }
}
