package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b extends j {
    private static volatile b iBv = null;

    private b() {
    }

    public static b QQ() {
        if (iBv == null) {
            synchronized (b.class) {
                if (iBv == null) {
                    iBv = new b();
                }
            }
        }
        return iBv;
    }

    public static void release() {
        iBv = null;
    }

    public final void c(final long j, final boolean z) {
        d.vL().D(new Runnable(this) {
            final /* synthetic */ b iBw;

            public final void run() {
                this.iBw.a(3, ((z & g.Ri()) != 0 ? 2 : 0) | 1, j, z);
            }
        });
    }

    public final void a(int i, int i2, long j, boolean z) {
        Object obj = 1;
        if (h.vG().uV()) {
            if (!(1 == i || 3 == i)) {
                obj = null;
            }
            if (obj != null) {
                int i3;
                long longValue = ((Long) h.vI().vr().get(a.uEj, Long.valueOf(-1))).longValue();
                if (z || longValue <= 0) {
                    i3 = Integer.MAX_VALUE;
                } else {
                    i3 = (int) longValue;
                }
                final int i4 = i2;
                final long j2 = j;
                new l(this, i, i2, i3) {
                    final /* synthetic */ b iBw;

                    protected final /* synthetic */ void a(int i, int i2, String str, avp com_tencent_mm_protocal_c_avp, k kVar) {
                        adt com_tencent_mm_protocal_c_adt = (adt) com_tencent_mm_protocal_c_avp;
                        if (h.vG().uV()) {
                            w.i("MicroMsg.AppBrandHistoryLogic", "onCgiBack, errType %d, errCode %d, errMsg %s, resp %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, com_tencent_mm_protocal_c_adt});
                            if (com_tencent_mm_protocal_c_adt != null && i == 0 && i2 == 0) {
                                if ((i4 & 4) > 0 && !c.QV() && (com_tencent_mm_protocal_c_adt.status & 8) > 0) {
                                    c.QW();
                                }
                                h.vI().vr().a(a.uEi, Boolean.valueOf((com_tencent_mm_protocal_c_adt.status & 4) > 0));
                                a.hA(com_tencent_mm_protocal_c_adt.status);
                                if (!bg.bV(com_tencent_mm_protocal_c_adt.tJn)) {
                                    j PW = c.PW();
                                    List<bqb> list = com_tencent_mm_protocal_c_adt.tJn;
                                    com.tencent.mm.sdk.e.c aVar = new a();
                                    List linkedList = new LinkedList();
                                    List linkedList2 = new LinkedList();
                                    long cs = PW.izH.cs(Thread.currentThread().getId());
                                    for (bqb com_tencent_mm_protocal_c_bqb : list) {
                                        if (!bg.mA(com_tencent_mm_protocal_c_bqb.username)) {
                                            aVar.field_brandId = com_tencent_mm_protocal_c_bqb.username;
                                            aVar.field_versionType = com_tencent_mm_protocal_c_bqb.tlI;
                                            aVar.field_scene = 2;
                                            if (PW.iCu.b(aVar, new String[0])) {
                                                aVar.field_updateTime = Math.max((long) com_tencent_mm_protocal_c_bqb.tpx, aVar.field_updateTime);
                                                if (PW.iCu.c(aVar, new String[0])) {
                                                    linkedList2.add(String.valueOf(aVar.field_recordId));
                                                }
                                            } else {
                                                aVar.field_updateTime = (long) com_tencent_mm_protocal_c_bqb.tpx;
                                                if (PW.a(aVar)) {
                                                    linkedList.add(String.valueOf(aVar.field_recordId));
                                                }
                                            }
                                        }
                                    }
                                    PW.izH.aD(cs);
                                    if (!bg.bV(linkedList)) {
                                        PW.a("batch", 2, linkedList);
                                    }
                                    if (!bg.bV(linkedList2)) {
                                        PW.a("batch", 3, linkedList2);
                                    }
                                    if (!bg.bV(com_tencent_mm_protocal_c_adt.tJn)) {
                                        int i3 = ((bqb) com_tencent_mm_protocal_c_adt.tJn.getFirst()).tpx;
                                        Iterator it = com_tencent_mm_protocal_c_adt.tJn.iterator();
                                        int i4 = i3;
                                        while (it.hasNext()) {
                                            i4 = Math.min(i4, ((bqb) it.next()).tpx);
                                        }
                                        if (i4 > 0) {
                                            h.vI().vr().a(a.uEj, Long.valueOf((long) i4));
                                        }
                                    }
                                    h.q(com_tencent_mm_protocal_c_adt.tJn);
                                }
                                g.a(i, i2, (com.tencent.mm.y.b) kVar.hsK);
                            }
                            this.iBw.a("batch", 3, Long.valueOf(j2));
                        }
                    }
                }.BC();
            }
        }
    }

    public static boolean QR() {
        if (h.vG().uV()) {
            return ((Boolean) h.vI().vr().get(a.uEi, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }
}
