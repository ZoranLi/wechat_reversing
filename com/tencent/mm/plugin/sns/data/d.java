package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.bba;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public ConcurrentHashMap<String, CharSequence> pQR = new ConcurrentHashMap();

    public final void a(bba com_tencent_mm_protocal_c_bba, CharSequence charSequence) {
        this.pQR.put(com_tencent_mm_protocal_c_bba.ubK + "-" + com_tencent_mm_protocal_c_bba.ubN + "-" + com_tencent_mm_protocal_c_bba.opI, charSequence);
    }
}
