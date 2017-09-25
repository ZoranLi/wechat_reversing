package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.List;

public final class m {
    private static final ThreadLocal<HashMap<String, Long>> pSd = new ThreadLocal();

    public static boolean ET(String str) {
        com.tencent.mm.plugin.sns.storage.m Gg = ae.beL().Gg(str);
        return a(Gg, ai.n(Gg));
    }

    public static boolean h(com.tencent.mm.plugin.sns.storage.m mVar) {
        return a(mVar, ai.n(mVar));
    }

    public static boolean a(com.tencent.mm.plugin.sns.storage.m mVar, bbk com_tencent_mm_protocal_c_bbk) {
        ali bhq = mVar.bhq();
        if (mVar.field_type != 21) {
            return true;
        }
        if (bhq.fZG == 1) {
            return true;
        }
        if (com.tencent.mm.u.m.xL().equals(mVar.field_userName)) {
            return true;
        }
        if (com_tencent_mm_protocal_c_bbk.ucB != null) {
            List<bbg> list = com_tencent_mm_protocal_c_bbk.ucB.ude;
            if (list == null || list.size() == 0) {
                return false;
            }
            String xL = com.tencent.mm.u.m.xL();
            for (bbg com_tencent_mm_protocal_c_bbg : list) {
                if (xL.equals(com_tencent_mm_protocal_c_bbg.tgG)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int i(com.tencent.mm.plugin.sns.storage.m mVar) {
        if (mVar == null) {
            return 0;
        }
        bbk n = ai.n(mVar);
        if (n == null) {
            return 0;
        }
        bbz com_tencent_mm_protocal_c_bbz = n.ucB;
        return (com_tencent_mm_protocal_c_bbz == null || com_tencent_mm_protocal_c_bbz.ude.size() == 0) ? 0 : com_tencent_mm_protocal_c_bbz.ude.size();
    }

    public static long j(com.tencent.mm.plugin.sns.storage.m mVar) {
        return b(mVar, null);
    }

    public static long b(com.tencent.mm.plugin.sns.storage.m mVar, bbk com_tencent_mm_protocal_c_bbk) {
        long j = 0;
        if (mVar == null) {
            return 0;
        }
        if (com_tencent_mm_protocal_c_bbk == null) {
            com_tencent_mm_protocal_c_bbk = ai.n(mVar);
        }
        if (com_tencent_mm_protocal_c_bbk == null) {
            return 0;
        }
        bbz com_tencent_mm_protocal_c_bbz = com_tencent_mm_protocal_c_bbk.ucB;
        if (com_tencent_mm_protocal_c_bbz == null) {
            return 0;
        }
        List<bbg> list = com_tencent_mm_protocal_c_bbz.ude;
        if (list == null) {
            return 0;
        }
        String str = mVar.qnj;
        if (bg.mA(str)) {
            Object obj = g.n(mVar.field_content) + g.n(mVar.field_attrBuf);
        } else {
            String str2 = str;
        }
        HashMap hashMap = (HashMap) pSd.get();
        if (hashMap != null && hashMap.containsKey(obj)) {
            return ((Long) hashMap.get(obj)).longValue();
        }
        for (bbg com_tencent_mm_protocal_c_bbg : list) {
            aex com_tencent_mm_protocal_c_aex = new aex();
            try {
                com_tencent_mm_protocal_c_aex.aD(n.a(com_tencent_mm_protocal_c_bbg.ubO));
            } catch (Exception e) {
                w.e("MicrMsg.SnsLuckyUtil", e.getMessage() + "hbBuffer is error");
            }
            j += com_tencent_mm_protocal_c_aex.fZT;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(obj, Long.valueOf(j));
        pSd.set(hashMap);
        return j;
    }
}
