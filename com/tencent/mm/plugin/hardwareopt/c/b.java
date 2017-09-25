package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a<Boolean, aew> {
    private boolean mKU = false;

    public final /* synthetic */ Object call(Object obj) {
        aew com_tencent_mm_protocal_c_aew = (aew) obj;
        long longValue = ((Long) h.vI().vr().get(w.a.uIC, Long.valueOf(-1))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[]{Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - longValue)});
        if (!this.mKU && currentTimeMillis - longValue < 86400000) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
            return Boolean.valueOf(false);
        } else if (!this.mKU && (com_tencent_mm_protocal_c_aew == null || com_tencent_mm_protocal_c_aew.tJY == null)) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
            g.oUh.a(661, 1, 1, false);
            return Boolean.valueOf(false);
        } else if (this.mKU || !bg.mA(com_tencent_mm_protocal_c_aew.tJY.imei)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
            g gVar = g.oUh;
            Object[] objArr = new Object[40];
            objArr[0] = com_tencent_mm_protocal_c_aew.tJY.imei;
            objArr[1] = com_tencent_mm_protocal_c_aew.tJY.tix;
            objArr[2] = com_tencent_mm_protocal_c_aew.tJY.tiy;
            objArr[3] = com_tencent_mm_protocal_c_aew.tJY.tiz;
            objArr[4] = com_tencent_mm_protocal_c_aew.tJZ.tnn;
            objArr[5] = com_tencent_mm_protocal_c_aew.tJZ.tnl;
            objArr[6] = com_tencent_mm_protocal_c_aew.tJZ.tiy;
            objArr[7] = com_tencent_mm_protocal_c_aew.tJZ.tno;
            objArr[8] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tJZ.tnm);
            objArr[9] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKa.tQo);
            objArr[10] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKa.tQp);
            objArr[11] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKb.ueW);
            objArr[12] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKb.ueX ? 1 : 0);
            objArr[13] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKf.tAI ? 1 : 0);
            objArr[14] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKf.tAJ ? 1 : 0);
            objArr[15] = com_tencent_mm_protocal_c_aew.tKc.tZB;
            objArr[16] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKc.density);
            objArr[17] = com_tencent_mm_protocal_c_aew.tKd.tsc;
            objArr[18] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzS ? 1 : 0);
            objArr[19] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzT ? 1 : 0);
            objArr[20] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzU ? 1 : 0);
            objArr[21] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzV ? 1 : 0);
            objArr[22] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzW ? 1 : 0);
            objArr[23] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzX ? 1 : 0);
            objArr[24] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzY ? 1 : 0);
            objArr[25] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAj ? 1 : 0);
            objArr[26] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tzZ ? 1 : 0);
            objArr[27] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAa ? 1 : 0);
            objArr[28] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAb ? 1 : 0);
            objArr[29] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAc ? 1 : 0);
            objArr[30] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAd ? 1 : 0);
            objArr[31] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAe ? 1 : 0);
            objArr[32] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAf ? 1 : 0);
            objArr[33] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAg ? 1 : 0);
            objArr[34] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAh ? 1 : 0);
            objArr[35] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKe.tAi ? 1 : 0);
            objArr[36] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKa.tQr);
            objArr[37] = Integer.valueOf(com_tencent_mm_protocal_c_aew.tKa.tQq);
            objArr[38] = com_tencent_mm_protocal_c_aew.tKd.tsd;
            objArr[39] = V(com_tencent_mm_protocal_c_aew.tKd.tse);
            gVar.i(14552, objArr);
            h.vI().vr().a(w.a.uIC, Long.valueOf(currentTimeMillis));
            g.oUh.a(661, 0, 1, false);
            return Boolean.valueOf(true);
        } else {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
            g.oUh.a(661, 2, 1, false);
            return Boolean.valueOf(false);
        }
    }

    public b(boolean z) {
        this.mKU = z;
    }

    private static String V(LinkedList<als> linkedList) {
        JSONArray jSONArray = new JSONArray();
        if (linkedList != null) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    als com_tencent_mm_protocal_c_als = (als) it.next();
                    if (!(com_tencent_mm_protocal_c_als == null || bg.mA(com_tencent_mm_protocal_c_als.nzA))) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("mimeName", com_tencent_mm_protocal_c_als.nzA);
                        JSONArray jSONArray2 = new JSONArray();
                        if (com_tencent_mm_protocal_c_als.tQy != null) {
                            Iterator it2 = com_tencent_mm_protocal_c_als.tQy.iterator();
                            while (it2.hasNext()) {
                                jSONArray2.put((String) it2.next());
                            }
                        }
                        jSONObject.put("codecName", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", e, "hy: error when build up json", new Object[0]);
                return "";
            }
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
        return "";
    }
}
