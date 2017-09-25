package com.tencent.mm.modelbiz;

import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.x.i;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class g implements e {
    Object hvG = new Object();
    Set<String> hvH = new HashSet();
    public LinkedList<a> hvI = new LinkedList();

    public interface a {
        String Dz();

        void c(LinkedList<bpl> linkedList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.modelbiz.g.a r7) {
        /*
        r6 = this;
        r1 = r6.hvG;
        monitor-enter(r1);
        r0 = r6.hvI;	 Catch:{ all -> 0x0053 }
        r0 = r0.contains(r7);	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0051;
    L_0x000b:
        r0 = r6.hvI;	 Catch:{ all -> 0x0053 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0053 }
    L_0x0011:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x004c;
    L_0x0017:
        r0 = r2.next();	 Catch:{ all -> 0x0053 }
        r0 = (com.tencent.mm.modelbiz.g.a) r0;	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0011;
    L_0x001f:
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r3 = r7.Dz();	 Catch:{ all -> 0x0053 }
        r3 = com.tencent.mm.sdk.platformtools.bg.mz(r3);	 Catch:{ all -> 0x0053 }
        r0 = r0.Dz();	 Catch:{ all -> 0x0053 }
        r0 = com.tencent.mm.sdk.platformtools.bg.mz(r0);	 Catch:{ all -> 0x0053 }
        r0 = r3.equals(r0);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0011;
    L_0x0037:
        r0 = "MicroMsg.BizKFService";
        r2 = "the same callbacker %s, return";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0053 }
        r4 = 0;
        r5 = r7.Dz();	 Catch:{ all -> 0x0053 }
        r3[r4] = r5;	 Catch:{ all -> 0x0053 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);	 Catch:{ all -> 0x0053 }
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
    L_0x004b:
        return;
    L_0x004c:
        r0 = r6.hvI;	 Catch:{ all -> 0x0053 }
        r0.add(r7);	 Catch:{ all -> 0x0053 }
    L_0x0051:
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        goto L_0x004b;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.g.a(com.tencent.mm.modelbiz.g$a):void");
    }

    public final void b(a aVar) {
        synchronized (this.hvG) {
            if (this.hvI.contains(aVar)) {
                this.hvI.remove(aVar);
            }
        }
    }

    public final void U(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", str, str2);
        } else if (this.hvH.contains(str2)) {
            w.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", str2);
        } else {
            this.hvH.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            k uVar = new u(str, linkedList);
            uVar.tag = str2;
            h.vH().gXC.a(uVar, 0);
            w.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", str, str2, Integer.valueOf(this.hvI.size()));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            w.e("MicroMsg.BizKFService", "scene == null");
            b(null);
        } else if (i == 0 && i2 == 0) {
            w.i("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            i Bm = n.Bm();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList3;
            Iterator it;
            bpl com_tencent_mm_protocal_c_bpl;
            com.tencent.mm.x.h hVar;
            if (kVar.getType() == 672) {
                if (((t) kVar).DD() == null) {
                    w.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    b(null);
                    return;
                }
                linkedList3 = ((t) kVar).DD().tMf;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    w.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bpl = (bpl) it.next();
                    linkedList.add(new f(com_tencent_mm_protocal_c_bpl.unQ, ((t) kVar).hwg, com_tencent_mm_protocal_c_bpl.mtf, com_tencent_mm_protocal_c_bpl.tNz, 1, currentTimeMillis));
                    if (Bm != null) {
                        hVar = new com.tencent.mm.x.h();
                        hVar.username = com_tencent_mm_protocal_c_bpl.unQ;
                        hVar.hrA = com_tencent_mm_protocal_c_bpl.mtf;
                        hVar.aV(false);
                        hVar.gkq = 3;
                        Bm.a(hVar);
                        n.Bz().hg(com_tencent_mm_protocal_c_bpl.unQ);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 675) {
                this.hvH.remove(((u) kVar).tag);
                if (((u) kVar).DE() == null) {
                    w.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    b(null);
                    return;
                }
                linkedList3 = ((u) kVar).DE().tMf;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    w.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bpl = (bpl) it.next();
                    w.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", com_tencent_mm_protocal_c_bpl.unQ, ((u) kVar).tag);
                    linkedList.add(new f(com_tencent_mm_protocal_c_bpl.unQ, ((u) kVar).hwg, com_tencent_mm_protocal_c_bpl.mtf, com_tencent_mm_protocal_c_bpl.tNz, ((u) kVar).hwh, currentTimeMillis));
                    if (Bm != null) {
                        hVar = new com.tencent.mm.x.h();
                        hVar.username = com_tencent_mm_protocal_c_bpl.unQ;
                        hVar.hrA = com_tencent_mm_protocal_c_bpl.mtf;
                        hVar.aV(false);
                        hVar.gkq = 3;
                        Bm.a(hVar);
                        n.Bz().hg(com_tencent_mm_protocal_c_bpl.unQ);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 674) {
                if (((s) kVar).DC() == null) {
                    w.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    b(null);
                    return;
                }
                linkedList3 = ((s) kVar).DC().tMf;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    w.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bpl = (bpl) it.next();
                    linkedList.add(new f(com_tencent_mm_protocal_c_bpl.unQ, ((s) kVar).hwg, com_tencent_mm_protocal_c_bpl.mtf, com_tencent_mm_protocal_c_bpl.tNz, 2, currentTimeMillis));
                    if (Bm != null) {
                        hVar = new com.tencent.mm.x.h();
                        hVar.username = com_tencent_mm_protocal_c_bpl.unQ;
                        hVar.hrA = com_tencent_mm_protocal_c_bpl.mtf;
                        hVar.aV(false);
                        hVar.gkq = 3;
                        Bm.a(hVar);
                        n.Bz().hg(com_tencent_mm_protocal_c_bpl.unQ);
                    }
                }
                linkedList2 = linkedList3;
            }
            w.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", Integer.valueOf(w.DG().d(linkedList)));
            b(linkedList2);
        } else {
            w.e("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            b(null);
            if (kVar.getType() == 675) {
                this.hvH.remove(((u) kVar).tag);
            }
        }
    }

    private void b(LinkedList<bpl> linkedList) {
        synchronized (this.hvG) {
            ArrayList arrayList = new ArrayList(this.hvI);
            for (int i = 0; i < arrayList.size(); i++) {
                a aVar = (a) arrayList.get(i);
                if (aVar != null) {
                    aVar.c(linkedList);
                }
            }
        }
    }
}
