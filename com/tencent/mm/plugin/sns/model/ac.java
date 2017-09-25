package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.g.d;
import com.tencent.mm.plugin.sns.g.e;
import com.tencent.mm.plugin.sns.g.f;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ac {
    String gKJ = "";
    private d pVm;
    private List<Integer> pVn = new Vector();
    private Map<String, Integer> pVo = new HashMap();
    private List<Integer> pVp = new Vector();
    private Map<Integer, Integer> pVq = new HashMap();
    private String path;

    public static boolean Fg(String str) {
        if (str != null && str.startsWith("_AD_TAG_")) {
            return true;
        }
        return false;
    }

    public ac(String str) {
        this.path = str;
        if (!beo()) {
            this.pVm = new d();
        }
        this.pVn.clear();
        this.pVo.clear();
    }

    public final synchronized void bem() {
        if (!ai(this.pVm.qaG)) {
            if (!ai(this.pVm.qaH) && !ai(this.pVm.qaI) && !ai(this.pVm.qaJ)) {
                f fVar;
                long j;
                while (!this.pVm.qaK.isEmpty()) {
                    fVar = (f) this.pVm.qaK.getFirst();
                    if (bg.az((long) fVar.qaN) <= 21600) {
                        j = fVar.qaP;
                        h.vJ();
                        h.vH().gXC.a(new q(j, 1), 0);
                        break;
                    }
                    this.pVm.qaK.removeFirst();
                }
                while (!this.pVm.qaL.isEmpty()) {
                    fVar = (f) this.pVm.qaL.getFirst();
                    if (bg.az((long) fVar.qaN) <= 21600) {
                        j = fVar.qaP;
                        h.vJ();
                        h.vH().gXC.a(new q(j, 5), 0);
                        break;
                    }
                    this.pVm.qaL.removeFirst();
                }
            }
        }
    }

    private static boolean ai(LinkedList<e> linkedList) {
        while (!linkedList.isEmpty()) {
            e eVar = (e) linkedList.getFirst();
            if (bg.az((long) eVar.qaN) > 21600) {
                linkedList.removeFirst();
            } else {
                if (Fg(eVar.qaM)) {
                    h.vJ();
                    h.vH().gXC.a(new j(eVar.pTK, eVar.qaM, eVar.qaO), 0);
                } else {
                    h.vJ();
                    h.vH().gXC.a(new n(eVar.pTK, eVar.qaM), 0);
                }
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean dr(long j) {
        boolean z;
        Iterator it = this.pVm.qaK.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).qaP == j) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void ds(long j) {
        f fVar = new f();
        fVar.qaP = j;
        fVar.qaN = (int) bg.Ny();
        this.pVm.qaK.add(fVar);
        ben();
    }

    final synchronized void dt(long j) {
        Object obj;
        Iterator it = this.pVm.qaK.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.qaP == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.pVm.qaK.remove(obj);
        }
        ben();
    }

    private static boolean a(LinkedList<bba> linkedList, String str, int i) {
        if (bg.mA(str)) {
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bba com_tencent_mm_protocal_c_bba = (bba) it.next();
            if (str.equals(com_tencent_mm_protocal_c_bba.opI) && i == com_tencent_mm_protocal_c_bba.ogM) {
                return true;
            }
        }
        return false;
    }

    public final synchronized bbk c(bbk com_tencent_mm_protocal_c_bbk) {
        if (bg.mA(this.gKJ)) {
            this.gKJ = m.xL();
        }
        if (!(this.pVm.qaG.size() == 0 && this.pVm.qaH.size() == 0)) {
            e eVar;
            bba com_tencent_mm_protocal_c_bba;
            long j = com_tencent_mm_protocal_c_bbk.tmx;
            Iterator it = this.pVm.qaG.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                bba a = a(eVar.pTK);
                if (eVar.pTK.tmx == j && !a(com_tencent_mm_protocal_c_bbk.ucn, a.opI, a.ogM)) {
                    com_tencent_mm_protocal_c_bbk.ucn.add(a);
                    com_tencent_mm_protocal_c_bbk.ucl++;
                }
            }
            Iterator it2 = com_tencent_mm_protocal_c_bbk.ucn.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_bba = (bba) it2.next();
                if (com_tencent_mm_protocal_c_bba.tgG.equals(this.gKJ)) {
                    Object obj = null;
                    Iterator it3 = this.pVm.qaL.iterator();
                    while (it3.hasNext()) {
                        Object obj2;
                        if (((f) it3.next()).qaP == j) {
                            com_tencent_mm_protocal_c_bbk.ucn.remove(com_tencent_mm_protocal_c_bba);
                            com_tencent_mm_protocal_c_bbk.ucl--;
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        break;
                    }
                }
            }
            it = this.pVm.qaH.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                if (eVar.pTK.tmx == j) {
                    com_tencent_mm_protocal_c_bba = a(eVar.pTK);
                    if (!a(com_tencent_mm_protocal_c_bbk.ucq, com_tencent_mm_protocal_c_bba.opI, com_tencent_mm_protocal_c_bba.ogM)) {
                        com_tencent_mm_protocal_c_bbk.ucq.add(com_tencent_mm_protocal_c_bba);
                        com_tencent_mm_protocal_c_bbk.uco++;
                    }
                }
            }
        }
        return com_tencent_mm_protocal_c_bbk;
    }

    public static bba a(bav com_tencent_mm_protocal_c_bav) {
        bau com_tencent_mm_protocal_c_bau = com_tencent_mm_protocal_c_bav.ubR;
        bau com_tencent_mm_protocal_c_bau2 = com_tencent_mm_protocal_c_bav.ubS;
        bba com_tencent_mm_protocal_c_bba = new bba();
        com_tencent_mm_protocal_c_bba.opI = com_tencent_mm_protocal_c_bau.opI;
        com_tencent_mm_protocal_c_bba.ogM = com_tencent_mm_protocal_c_bau.ogM;
        com_tencent_mm_protocal_c_bba.tNz = com_tencent_mm_protocal_c_bau.ubH;
        com_tencent_mm_protocal_c_bba.tfW = com_tencent_mm_protocal_c_bau.tfW;
        com_tencent_mm_protocal_c_bba.jOc = com_tencent_mm_protocal_c_bau.jOc;
        com_tencent_mm_protocal_c_bba.tgG = com_tencent_mm_protocal_c_bau.tWt;
        com_tencent_mm_protocal_c_bba.ubK = com_tencent_mm_protocal_c_bau.ubK;
        com_tencent_mm_protocal_c_bba.ubN = com_tencent_mm_protocal_c_bau.ubN;
        com_tencent_mm_protocal_c_bba.ubP = com_tencent_mm_protocal_c_bau.ubP;
        com_tencent_mm_protocal_c_bba.uce = com_tencent_mm_protocal_c_bau2.tWt;
        com_tencent_mm_protocal_c_bba.ubM = com_tencent_mm_protocal_c_bau2.ubM;
        com_tencent_mm_protocal_c_bba.ubJ = com_tencent_mm_protocal_c_bau2.ubJ;
        return com_tencent_mm_protocal_c_bba;
    }

    public final boolean a(String str, bav com_tencent_mm_protocal_c_bav) {
        return a(str, com_tencent_mm_protocal_c_bav, "");
    }

    public final synchronized boolean a(String str, bav com_tencent_mm_protocal_c_bav, String str2) {
        boolean z = true;
        synchronized (this) {
            e eVar = new e();
            eVar.qaM = str;
            eVar.pTK = com_tencent_mm_protocal_c_bav;
            eVar.qaN = (int) bg.Ny();
            eVar.qaO = str2;
            switch (com_tencent_mm_protocal_c_bav.ubR.jOc) {
                case 1:
                    this.pVm.qaG.add(eVar);
                    if (dv(com_tencent_mm_protocal_c_bav.tmx)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.pVm.qaH.add(eVar);
                    break;
                case 3:
                    this.pVm.qaI.add(eVar);
                    break;
                case 5:
                    this.pVm.qaJ.add(eVar);
                    break;
                case 7:
                    this.pVm.qaG.add(eVar);
                    if (dv(com_tencent_mm_protocal_c_bav.tmx)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                    this.pVm.qaH.add(eVar);
                    break;
            }
            if (!ben()) {
                w.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
        }
        return z;
    }

    public final void c(long j, int i, String str) {
        ai.bfd();
        d(j, i, str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void d(long r2, int r4, java.lang.String r5) {
        /*
        r1 = this;
        monitor-enter(r1);
        switch(r4) {
            case 1: goto L_0x0009;
            case 2: goto L_0x0014;
            case 3: goto L_0x002c;
            case 4: goto L_0x0004;
            case 5: goto L_0x0034;
            case 6: goto L_0x0004;
            case 7: goto L_0x001c;
            case 8: goto L_0x0024;
            default: goto L_0x0004;
        };
    L_0x0004:
        r1.ben();	 Catch:{ all -> 0x0011 }
        monitor-exit(r1);
        return;
    L_0x0009:
        r0 = r1.pVm;	 Catch:{ all -> 0x0011 }
        r0 = r0.qaG;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0014:
        r0 = r1.pVm;	 Catch:{ all -> 0x0011 }
        r0 = r0.qaH;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x001c:
        r0 = r1.pVm;	 Catch:{ all -> 0x0011 }
        r0 = r0.qaG;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0024:
        r0 = r1.pVm;	 Catch:{ all -> 0x0011 }
        r0 = r0.qaH;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x002c:
        r0 = r1.pVm;	 Catch:{ all -> 0x0011 }
        r0 = r0.qaI;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0034:
        r0 = r1.pVm;	 Catch:{ all -> 0x0011 }
        r0 = r0.qaJ;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.ac.d(long, int, java.lang.String):void");
    }

    private static void a(long j, LinkedList<e> linkedList, String str) {
        a(j, linkedList, str, false);
    }

    private static boolean a(long j, LinkedList<e> linkedList, String str, boolean z) {
        Object obj;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obj = (e) it.next();
            if (obj.pTK.tmx == j && (z || obj.qaM.equals(str))) {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        linkedList.remove(obj);
        return true;
    }

    public final synchronized boolean du(long j) {
        boolean z = true;
        synchronized (this) {
            f fVar = new f();
            fVar.qaP = j;
            fVar.qaN = (int) bg.Ny();
            this.pVm.qaL.add(fVar);
            ben();
            if (a(j, this.pVm.qaG, "", true)) {
                z = false;
            }
        }
        return z;
    }

    final synchronized boolean dv(long j) {
        boolean z;
        Object obj;
        Iterator it = this.pVm.qaL.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.qaP == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.pVm.qaL.remove(obj);
            z = true;
        } else {
            z = false;
        }
        ben();
        return z;
    }

    private synchronized boolean ben() {
        boolean z = false;
        synchronized (this) {
            try {
                byte[] toByteArray = this.pVm.toByteArray();
                if (FileOp.b(this.path, toByteArray, toByteArray.length) == 0) {
                    z = true;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "listToFile failed: " + this.path, new Object[0]);
                FileOp.deleteFile(this.path);
            }
        }
        return z;
    }

    private synchronized boolean beo() {
        boolean z;
        byte[] c = FileOp.c(this.path, 0, -1);
        if (c == null) {
            z = false;
        } else {
            try {
                this.pVm = (d) new d().aD(c);
                z = true;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "", new Object[0]);
                FileOp.deleteFile(this.path);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean sW(int i) {
        return this.pVn.contains(Integer.valueOf(i));
    }

    public final synchronized boolean sX(int i) {
        boolean z;
        if (this.pVn.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.pVn.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean sY(int i) {
        this.pVn.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean isDownloading(String str) {
        return this.pVo.containsKey(str);
    }

    public final synchronized boolean Fh(String str) {
        boolean z = false;
        synchronized (this) {
            if (!this.pVo.containsKey(str)) {
                this.pVo.put(str, Integer.valueOf(0));
                z = true;
            }
        }
        return z;
    }

    public final synchronized boolean Fi(String str) {
        this.pVo.remove(str);
        return true;
    }

    public final synchronized int bep() {
        return this.pVo.size();
    }

    public final synchronized boolean sZ(int i) {
        boolean z;
        if (this.pVp.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.pVp.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean ta(int i) {
        this.pVp.remove(Integer.valueOf(i));
        this.pVq.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean cS(int i, int i2) {
        this.pVq.put(Integer.valueOf(i), Integer.valueOf(i2));
        return true;
    }

    public final synchronized boolean tb(int i) {
        this.pVq.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized int tc(int i) {
        int intValue;
        if (this.pVq.containsKey(Integer.valueOf(i))) {
            intValue = ((Integer) this.pVq.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        return intValue;
    }
}
