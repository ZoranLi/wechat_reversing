package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.e.a.sj;
import com.tencent.mm.e.a.sk;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    public bnp rUt;

    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11002));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        if (i != 11002) {
            return null;
        }
        a.dv(1, 0);
        a.vJ(0);
        b sjVar = new sj();
        sjVar.gaa.gab = ab.getContext().getResources().getStringArray(R.c.aSa);
        sjVar.gaa.fEG = 1;
        com.tencent.mm.sdk.b.a.urY.m(sjVar);
        byte[] aP = com.tencent.mm.plugin.wear.model.a.bvG().rTo.aP(bArr);
        if (aP == null) {
            return null;
        }
        try {
            bnp com_tencent_mm_protocal_c_bnp = new bnp();
            com_tencent_mm_protocal_c_bnp.aD(aP);
            bnq com_tencent_mm_protocal_c_bnq = new bnq();
            int i2 = 20;
            String str = null;
            while (i2 > 0) {
                str = m.xL();
                if (bg.mA(str)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    i2--;
                }
            }
            if (bg.mA(str)) {
                return null;
            }
            com_tencent_mm_protocal_c_bnq.tgG = str;
            str = v.e(ab.getContext().getSharedPreferences(ab.bIX(), 0));
            String bIN = v.bIN();
            if (str.equals("language_default")) {
                com_tencent_mm_protocal_c_bnq.leO = bIN;
            } else {
                com_tencent_mm_protocal_c_bnq.leO = str;
            }
            aP = com.tencent.mm.plugin.wear.model.a.bvG().rTo.aQ(com_tencent_mm_protocal_c_bnq.toByteArray());
            if (aP == null) {
                return null;
            }
            this.rUt = com_tencent_mm_protocal_c_bnp;
            b skVar = new sk();
            skVar.gac.fEG = 9;
            com.tencent.mm.sdk.b.a.urY.a(skVar, Looper.getMainLooper());
            return aP;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.Wear.HttpLoginServer", e2, "", new Object[0]);
            return null;
        }
    }
}
