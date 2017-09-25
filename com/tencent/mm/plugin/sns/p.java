package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.rg;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p extends c<rg> {
    public p() {
        this.usg = rg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        rg rgVar = (rg) bVar;
        if (rgVar instanceof rg) {
            if (rgVar.fYj.fYl instanceof u) {
                u uVar = (u) rgVar.fYj.fYl;
                int i2 = uVar.pUD;
                LinkedList linkedList = uVar.pUC;
                rgVar.fYk.state = i2;
                if (i2 == 2) {
                    if (linkedList != null && linkedList.size() > 0) {
                        ae.beQ().dJ(7);
                    }
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bce com_tencent_mm_protocal_c_bce = (bce) it.next();
                            if (com_tencent_mm_protocal_c_bce.udq == 7) {
                                s sVar = new s();
                                u.a(sVar, com_tencent_mm_protocal_c_bce);
                                ae.beQ().a(sVar);
                            }
                        }
                    }
                }
                if (i2 != 1) {
                    s dI = ae.beQ().dI(7);
                    rg.b bVar2 = rgVar.fYk;
                    List linkedList2 = new LinkedList();
                    if (dI.field_memberList != null) {
                        String[] split = dI.field_memberList.split(",");
                        int length = split.length;
                        while (i < length) {
                            linkedList2.add(split[i]);
                            i++;
                        }
                    }
                    bVar2.fYm = linkedList2;
                }
            }
            return true;
        }
        w.f("MicroMsg.UpdateSnsTagListListener", "mismatched event");
        return false;
    }
}
