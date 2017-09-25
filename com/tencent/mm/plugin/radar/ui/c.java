package com.tencent.mm.plugin.radar.ui;

import com.tencent.mm.protocal.c.ati;

public final class c {
    public static String b(ati com_tencent_mm_protocal_c_ati) {
        if (com_tencent_mm_protocal_c_ati.jNj != null) {
            return com_tencent_mm_protocal_c_ati.jNj;
        }
        return com_tencent_mm_protocal_c_ati.twU;
    }

    public static String c(ati com_tencent_mm_protocal_c_ati) {
        if (com_tencent_mm_protocal_c_ati == null) {
            return "";
        }
        if (com_tencent_mm_protocal_c_ati.twU != null) {
            return com_tencent_mm_protocal_c_ati.twU;
        }
        return com_tencent_mm_protocal_c_ati.jNj;
    }
}
