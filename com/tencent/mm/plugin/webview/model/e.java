package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.protocal.c.agb;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public int rWA = 0;
    public long rWB = 0;
    public int rWw = 20480;
    public int rWx = 30720;
    public int rWy = 51200;
    public final List<aig> rWz = new LinkedList();

    private static final class a {
        public static final e rWC = new e();
    }

    public static void bL(List<agb> list) {
        if (!bg.bV(list)) {
            for (agb com_tencent_mm_protocal_c_agb : list) {
                f.bxb().rWu.q(Integer.valueOf(com_tencent_mm_protocal_c_agb.tLf), Long.valueOf(bg.Ny() + ((long) com_tencent_mm_protocal_c_agb.tLg)));
            }
            f.bxb().bwe();
        }
    }
}
