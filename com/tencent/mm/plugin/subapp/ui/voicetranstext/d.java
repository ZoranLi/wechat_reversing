package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.bjo;

public final class d {
    public static bjo ar(int i, String str) {
        bjo com_tencent_mm_protocal_c_bjo = new bjo();
        switch (i) {
            case 0:
                com_tencent_mm_protocal_c_bjo.tgO = 8000;
                com_tencent_mm_protocal_c_bjo.tgP = 16;
                com_tencent_mm_protocal_c_bjo.tgM = 5;
                com_tencent_mm_protocal_c_bjo.tgN = 5;
                break;
            case 1:
                com_tencent_mm_protocal_c_bjo.tgO = 16000;
                com_tencent_mm_protocal_c_bjo.tgP = 16;
                com_tencent_mm_protocal_c_bjo.tgM = 4;
                com_tencent_mm_protocal_c_bjo.tgN = 4;
                break;
            case 4:
                com_tencent_mm_protocal_c_bjo.tgO = 16000;
                b lV = q.lV(str);
                if (lV != null) {
                    int SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(((h) lV).bd(0, 1).buf);
                    if (SilkGetEncSampleRate >= 8000) {
                        com_tencent_mm_protocal_c_bjo.tgO = SilkGetEncSampleRate;
                    }
                }
                com_tencent_mm_protocal_c_bjo.tgP = 16;
                com_tencent_mm_protocal_c_bjo.tgM = 6;
                com_tencent_mm_protocal_c_bjo.tgN = 6;
                break;
            default:
                com_tencent_mm_protocal_c_bjo.tgO = 0;
                com_tencent_mm_protocal_c_bjo.tgP = 0;
                com_tencent_mm_protocal_c_bjo.tgM = 0;
                com_tencent_mm_protocal_c_bjo.tgN = 0;
                break;
        }
        return com_tencent_mm_protocal_c_bjo;
    }
}
