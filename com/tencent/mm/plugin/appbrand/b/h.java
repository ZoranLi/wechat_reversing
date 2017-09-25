package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.vending.j.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum h {
    ;

    static void q(LinkedList<bqb> linkedList) {
        Collection hashSet = new HashSet();
        List linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bqb com_tencent_mm_protocal_c_bqb = (bqb) it.next();
            if (!bg.mA(com_tencent_mm_protocal_c_bqb.username)) {
                hashSet.add(com_tencent_mm_protocal_c_bqb.username);
                linkedList2.add(a.u(com_tencent_mm_protocal_c_bqb.username, Integer.valueOf(com_tencent_mm_protocal_c_bqb.tlI)));
            }
        }
        List arrayList = new ArrayList(hashSet.size());
        arrayList.addAll(hashSet);
        q.R(arrayList);
    }
}
