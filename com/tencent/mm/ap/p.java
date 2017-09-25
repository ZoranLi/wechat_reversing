package com.tencent.mm.ap;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bm;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends c<lc> {
    public p() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return HZ();
    }

    private static boolean HZ() {
        int i;
        boolean z;
        LinkedList linkedList;
        byte[] d;
        Iterator it;
        g gVar;
        aih com_tencent_mm_protocal_c_aih;
        if (h.vG().uV()) {
            h.vG();
            if (!a.uP()) {
                i = 1;
                if (i != 0) {
                    if (bg.az(bg.a((Long) h.vI().vr().get(68097, null), 0)) * 1000 <= 3600000) {
                        i = 1;
                    } else {
                        z = false;
                    }
                    if (i != 0) {
                        linkedList = new LinkedList();
                        d = e.d(h.vI().cachePath + "eggresult.rep", 0, -1);
                        if (d != null) {
                            try {
                                it = ((h) new h().aD(d)).hOi.iterator();
                                while (it.hasNext()) {
                                    gVar = (g) it.next();
                                    if (gVar.hOg != 0) {
                                        com_tencent_mm_protocal_c_aih = new aih();
                                        com_tencent_mm_protocal_c_aih.oTD = 17;
                                        com_tencent_mm_protocal_c_aih.oTN = gVar.hNV + "," + gVar.hOg;
                                        linkedList.add(com_tencent_mm_protocal_c_aih);
                                    }
                                    if (gVar.hOh != 0) {
                                        com_tencent_mm_protocal_c_aih = new aih();
                                        com_tencent_mm_protocal_c_aih.oTD = 18;
                                        com_tencent_mm_protocal_c_aih.oTN = gVar.hNV + "," + gVar.hOh;
                                        linkedList.add(com_tencent_mm_protocal_c_aih);
                                    }
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(h.vI().cachePath + "eggresult.rep");
                            } catch (Throwable e) {
                                w.e("MicroMsg.PostTaskReportEgg", "exception:%s", bg.g(e));
                            }
                            if (!linkedList.isEmpty()) {
                                bm.a(linkedList);
                                h.vI().vr().set(68097, Long.valueOf(bg.Ny()));
                            }
                        }
                        return false;
                    }
                }
                w.d("MicroMsg.PostTaskReportEgg", "report egg done");
                return false;
            }
        }
        z = false;
        if (i != 0) {
            if (bg.az(bg.a((Long) h.vI().vr().get(68097, null), 0)) * 1000 <= 3600000) {
                z = false;
            } else {
                i = 1;
            }
            if (i != 0) {
                linkedList = new LinkedList();
                d = e.d(h.vI().cachePath + "eggresult.rep", 0, -1);
                if (d != null) {
                    it = ((h) new h().aD(d)).hOi.iterator();
                    while (it.hasNext()) {
                        gVar = (g) it.next();
                        if (gVar.hOg != 0) {
                            com_tencent_mm_protocal_c_aih = new aih();
                            com_tencent_mm_protocal_c_aih.oTD = 17;
                            com_tencent_mm_protocal_c_aih.oTN = gVar.hNV + "," + gVar.hOg;
                            linkedList.add(com_tencent_mm_protocal_c_aih);
                        }
                        if (gVar.hOh != 0) {
                            com_tencent_mm_protocal_c_aih = new aih();
                            com_tencent_mm_protocal_c_aih.oTD = 18;
                            com_tencent_mm_protocal_c_aih.oTN = gVar.hNV + "," + gVar.hOh;
                            linkedList.add(com_tencent_mm_protocal_c_aih);
                        }
                    }
                    com.tencent.mm.loader.stub.b.deleteFile(h.vI().cachePath + "eggresult.rep");
                    if (linkedList.isEmpty()) {
                        bm.a(linkedList);
                        h.vI().vr().set(68097, Long.valueOf(bg.Ny()));
                    }
                }
                return false;
            }
        }
        w.d("MicroMsg.PostTaskReportEgg", "report egg done");
        return false;
    }
}
