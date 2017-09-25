package com.tencent.mm.booter;

import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import java.util.LinkedList;

public final class i {
    public static void run() {
        int i;
        LinkedList linkedList = new LinkedList();
        int a = bg.a((Integer) ap.yW().get(19), 0);
        for (i = 0; i < a; i++) {
            aih com_tencent_mm_protocal_c_aih = new aih();
            com_tencent_mm_protocal_c_aih.oTD = 31;
            com_tencent_mm_protocal_c_aih.oTN = "0";
            linkedList.add(com_tencent_mm_protocal_c_aih);
        }
        a = bg.a((Integer) ap.yW().get(20), 0);
        for (i = 0; i < a; i++) {
            com_tencent_mm_protocal_c_aih = new aih();
            com_tencent_mm_protocal_c_aih.oTD = 31;
            com_tencent_mm_protocal_c_aih.oTN = "1";
            linkedList.add(com_tencent_mm_protocal_c_aih);
        }
        if (linkedList.size() > 0) {
            bm.a(linkedList);
            ap.yW().set(19, Integer.valueOf(0));
            ap.yW().set(20, Integer.valueOf(0));
        }
    }
}
