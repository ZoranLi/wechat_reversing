package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.v.e;
import com.tencent.mm.plugin.qqmail.b.v.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class t {
    public v oAA = w.aUA();
    public s oAB = null;
    public boolean oAC = false;
    public f oAD = new f(this) {
        final /* synthetic */ t oAF;

        {
            this.oAF = r1;
        }

        public final void G(String str, int i, int i2) {
            if (i == i2) {
                w.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[]{Integer.valueOf(this.oAF.oAz.size())});
                if (this.oAF.oAB != null) {
                    this.oAF.oAB.CS(str);
                }
                if (this.oAF.oAz.size() > 0) {
                    w.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                    this.oAF.b((u) this.oAF.oAz.remove(0));
                    this.oAF.oAA.a(this, this.oAF.oAE);
                    return;
                }
                w.i("MicroMsg.ShareMailQueue", "finished sent all mails");
                this.oAF.oAC = false;
            }
        }
    };
    public e oAE = new e(this) {
        final /* synthetic */ t oAF;

        {
            this.oAF = r1;
        }

        public final void CU(String str) {
            if (this.oAF.oAB != null) {
                s sVar = this.oAF.oAB;
                if (bg.mA(str)) {
                    w.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
                } else {
                    s.CT(str);
                    sVar.CS(str);
                }
            }
            if (this.oAF.oAz.size() > 0) {
                w.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                this.oAF.b((u) this.oAF.oAz.remove(0));
                this.oAF.oAA.a(this.oAF.oAD, this);
                return;
            }
            w.i("MicroMsg.ShareMailQueue", "final job fail");
            this.oAF.oAC = false;
        }
    };
    public ArrayList<u> oAz = new ArrayList();

    public final void a(u uVar) {
        if (ap.zb()) {
            if (this.oAB == null) {
                this.oAB = new s();
            }
            s sVar = this.oAB;
            String str = uVar.ozq;
            if (bg.mA(str)) {
                w.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
            } else {
                q qVar = new q();
                qVar.ozq = str;
                sVar.oAy.nwX.add(qVar);
                sVar.save();
            }
            this.oAz.add(uVar);
            w.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[]{Integer.valueOf(this.oAz.size())});
            if (!this.oAC) {
                w.d("MicroMsg.ShareMailQueue", "start execute");
                if (this.oAz.size() > 0) {
                    this.oAC = true;
                    b((u) this.oAz.remove(0));
                    this.oAA.a(this.oAD, this.oAE);
                }
            }
        }
    }

    public final void b(u uVar) {
        v vVar = this.oAA;
        vVar.oAP.clear();
        vVar.ozV = null;
        vVar.oAR = 0;
        vVar.oAT = null;
        vVar.oAU = null;
        vVar.oAV.clear();
        vVar.oAS.clear();
        vVar.fOu = null;
        vVar.oAO.clear();
        vVar.oAH.clear();
        vVar.oAG = null;
        vVar.ozq = null;
        vVar.oAY = 0;
        vVar.ozT = null;
        vVar.oAI.clear();
        vVar.oAM.clear();
        vVar.oAQ.clear();
        vVar.oAN = null;
        vVar.oAE = null;
        this.oAA.fOu = uVar.fOu;
        this.oAA.ozq = uVar.ozq;
        this.oAA.ozT = uVar.ozT;
        this.oAA.ozU = uVar.ozU;
        this.oAA.oAG = uVar.oAG;
        vVar = this.oAA;
        Map map = uVar.oAH;
        vVar.oAH = new HashMap();
        vVar.oAH.putAll(map);
        vVar = this.oAA;
        map = uVar.oAI;
        vVar.oAI = new LinkedHashMap();
        vVar.oAI.putAll(map);
        vVar = this.oAA;
        map = uVar.oAJ;
        vVar.oAJ = new LinkedHashMap();
        vVar.oAJ.putAll(map);
    }
}
