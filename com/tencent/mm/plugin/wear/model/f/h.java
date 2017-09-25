package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.protocal.c.bnt;
import com.tencent.mm.u.n;
import java.util.List;

public final class h extends b {
    private long fGM;
    private long fZT;
    private String fZU;
    private List<String> fZV;

    public h(long j, long j2, String str, List<String> list) {
        this.fGM = j;
        this.fZT = j2;
        this.fZU = str;
        this.fZV = list;
    }

    protected final void send() {
        bns com_tencent_mm_protocal_c_bns = new bns();
        com_tencent_mm_protocal_c_bns.umJ = this.fZT;
        com_tencent_mm_protocal_c_bns.umI = this.fGM;
        com_tencent_mm_protocal_c_bns.umK = this.fZU;
        try {
            if (this.fZV != null) {
                for (String split : this.fZV) {
                    String[] split2 = split.split("=");
                    bnt com_tencent_mm_protocal_c_bnt = new bnt();
                    com_tencent_mm_protocal_c_bnt.umH = split2[0];
                    com_tencent_mm_protocal_c_bnt.jOp = split2[1];
                    if (com_tencent_mm_protocal_c_bnt.jOp.startsWith("wxid")) {
                        com_tencent_mm_protocal_c_bnt.jOp = n.eK(com_tencent_mm_protocal_c_bnt.jOp);
                    }
                    com_tencent_mm_protocal_c_bnt.umJ = Long.valueOf(split2[2]).longValue();
                    com_tencent_mm_protocal_c_bns.umL.add(com_tencent_mm_protocal_c_bnt);
                }
            }
            a.bvG();
            r.a(20015, com_tencent_mm_protocal_c_bns.toByteArray(), true);
        } catch (Exception e) {
        }
        if (this.fZT > 0) {
            com.tencent.mm.plugin.wear.model.c.a.iM(true);
        } else {
            com.tencent.mm.plugin.wear.model.c.a.iM(false);
        }
    }

    public final String getName() {
        return "WearLuckyReceiveTask";
    }
}
