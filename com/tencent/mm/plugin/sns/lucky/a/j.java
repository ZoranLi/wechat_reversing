package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import java.util.Map;

public final class j implements a {
    public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";

    public final void a(d.a aVar) {
        w.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
        b.mN(74);
        if (aVar == null || aVar.hst == null) {
            w.e(TAG, "onPreAddMessage cmdAM is null");
            return;
        }
        i iVar = new i();
        String a = n.a(aVar.hst.tff);
        iVar.jGf = new StringBuffer();
        Map q = bh.q(a, "sysmsg");
        iVar.pSc.clear();
        if (q == null) {
            w.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[]{a});
            b.mN(75);
        } else {
            int i = 0;
            while (true) {
                String str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr = new Object[2];
                objArr[0] = i == 0 ? "" : String.valueOf(i);
                objArr[1] = "BeginTime";
                long PZ = bg.PZ((String) q.get(String.format(str, objArr)));
                iVar.jGf.append("BeginTime:" + PZ + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = i == 0 ? "" : String.valueOf(i);
                objArr2[1] = "EndTime";
                long PZ2 = bg.PZ((String) q.get(String.format(str, objArr2)));
                iVar.jGf.append("EndTime:" + PZ2 + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr3 = new Object[2];
                objArr3[0] = i == 0 ? "" : String.valueOf(i);
                objArr3[1] = "ActionID";
                str = bg.ap((String) q.get(String.format(str, objArr3)), "");
                iVar.jGf.append("ActionID:" + str + ";");
                if (bg.mA(str)) {
                    break;
                }
                String str2 = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr4 = new Object[2];
                objArr4[0] = i == 0 ? "" : String.valueOf(i);
                objArr4[1] = "TipsMessage";
                String ap = bg.ap((String) q.get(String.format(str2, objArr4)), "");
                iVar.jGf.append("TipsMessage:" + ap + ";\n");
                h hVar = new h();
                hVar.pRZ = str;
                hVar.pRp = PZ;
                hVar.jOn = PZ2;
                hVar.pSa = ap;
                iVar.pSc.add(hVar);
                i++;
            }
            if (iVar.pSc.size() == 0) {
                b.mN(76);
            }
        }
        w.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + iVar.jGf.toString());
        h.vJ();
        h.vI().vr().a(com.tencent.mm.storage.w.a.uCZ, a);
        h.vJ();
        h.vI().vr().jY(true);
    }
}
