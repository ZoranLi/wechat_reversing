package com.tencent.mm.as;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public final class f {
    public static anb hPJ;

    public static anb Iq() {
        if (hPJ == null) {
            String Io = Io();
            hPJ = new anb();
            Io = ab.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(Io, "");
            if (!bg.mA(Io)) {
                try {
                    hPJ.aD(Base64.decode(Io.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return hPJ;
    }

    private static String Io() {
        return "key_pb_most_search_biz_list" + m.xL();
    }

    public static void jY(String str) {
        if (o.eV(str)) {
            ana com_tencent_mm_protocal_c_ana;
            if (hPJ == null) {
                Iq();
            }
            long currentTimeMillis = System.currentTimeMillis();
            ana com_tencent_mm_protocal_c_ana2 = null;
            int i = 0;
            while (i < hPJ.jNe.size()) {
                com_tencent_mm_protocal_c_ana = (ana) hPJ.jNe.get(i);
                long j = (currentTimeMillis - com_tencent_mm_protocal_c_ana.tRG) / 86400000;
                com_tencent_mm_protocal_c_ana.tRF *= Math.pow(0.98d, (double) j);
                com_tencent_mm_protocal_c_ana.tRG = (j * 86400000) + com_tencent_mm_protocal_c_ana.tRG;
                w.d("MicroMsg.FTS.FTSMostSearchBizLogic", "after update: %.2f %d %s", Double.valueOf(com_tencent_mm_protocal_c_ana.tRF), Long.valueOf(com_tencent_mm_protocal_c_ana.tRG), com_tencent_mm_protocal_c_ana.tgG);
                if (!com_tencent_mm_protocal_c_ana.tgG.equals(str)) {
                    com_tencent_mm_protocal_c_ana = com_tencent_mm_protocal_c_ana2;
                }
                i++;
                com_tencent_mm_protocal_c_ana2 = com_tencent_mm_protocal_c_ana;
            }
            if (com_tencent_mm_protocal_c_ana2 == null) {
                com_tencent_mm_protocal_c_ana = new ana();
                com_tencent_mm_protocal_c_ana.tRF = 1.0d;
                com_tencent_mm_protocal_c_ana.tRG = currentTimeMillis;
                com_tencent_mm_protocal_c_ana.tgG = str;
                hPJ.jNe.add(com_tencent_mm_protocal_c_ana);
                w.i("MicroMsg.FTS.FTSMostSearchBizLogic", "add new use %s", str);
            } else {
                com_tencent_mm_protocal_c_ana2.tRF += 1.0d;
                w.i("MicroMsg.FTS.FTSMostSearchBizLogic", "update use %s %.2f", str, Double.valueOf(com_tencent_mm_protocal_c_ana2.tRF));
            }
            Collections.sort(hPJ.jNe, new Comparator<ana>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    ana com_tencent_mm_protocal_c_ana = (ana) obj;
                    ana com_tencent_mm_protocal_c_ana2 = (ana) obj2;
                    if (com_tencent_mm_protocal_c_ana.tRF > com_tencent_mm_protocal_c_ana2.tRF) {
                        return 1;
                    }
                    return com_tencent_mm_protocal_c_ana.tRF < com_tencent_mm_protocal_c_ana2.tRF ? -1 : 0;
                }
            });
            for (int size = hPJ.jNe.size() - 1; size < hPJ.jNe.size() && hPJ.jNe.size() > 8; size++) {
                if (((ana) hPJ.jNe.get(size)).tRF < 0.5d) {
                    hPJ.jNe.remove(size);
                }
            }
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                sharedPreferences.edit().putString(Io(), Base64.encodeToString(hPJ.toByteArray(), 0)).commit();
                w.i("MicroMsg.FTS.FTSMostSearchBizLogic", "useBiz pbListString %s", r2);
            } catch (IOException e) {
            }
        }
    }
}
