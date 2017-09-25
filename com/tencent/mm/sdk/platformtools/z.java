package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class z {
    public static b gJB;
    private static int usN;
    public static Map<Integer, z> usP = new HashMap();
    private static boolean usR = false;
    public static boolean usS;
    public long hpU = 0;
    private final boolean nJw;
    public long rqq = 0;
    public final int usO;
    private final a usQ;

    public interface a {
        boolean oQ();
    }

    public interface b {
        void cancel();

        void prepare();
    }

    public static void a(b bVar) {
        usR = true;
        gJB = bVar;
    }

    protected final void finalize() {
        KH();
        super.finalize();
    }

    public z(a aVar) {
        Assert.assertTrue("bumper not initialized", usR);
        this.usQ = aVar;
        this.nJw = true;
        if (usN >= 8192) {
            usN = 0;
        }
        int i = usN + 1;
        usN = i;
        this.usO = i;
    }

    public static long bIS() {
        usS = false;
        List linkedList = new LinkedList();
        Set<Integer> hashSet = new HashSet();
        hashSet.addAll(usP.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            long j2;
            z zVar = (z) usP.get(num);
            if (zVar != null) {
                long aB = bg.aB(zVar.hpU);
                if (aB < 0) {
                    aB = 0;
                }
                if (aB > zVar.rqq) {
                    if (zVar.usQ.oQ() && zVar.nJw) {
                        j = zVar.rqq;
                    } else {
                        linkedList.add(num);
                    }
                    zVar.hpU = bg.NA();
                } else if (zVar.rqq - aB < j) {
                    j2 = zVar.rqq - aB;
                    j = j2;
                }
            }
            j2 = j;
            j = j2;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            usP.remove(linkedList.get(i));
        }
        if (!(usS || j != Long.MAX_VALUE || gJB == null)) {
            gJB.cancel();
            w.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public final void KH() {
        usP.remove(Integer.valueOf(this.usO));
    }

    public static boolean et(long j) {
        w.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j);
        long j2 = Long.MAX_VALUE;
        for (Entry value : usP.entrySet()) {
            long j3;
            z zVar = (z) value.getValue();
            if (zVar != null) {
                long aB = bg.aB(zVar.hpU);
                if (aB < 0) {
                    aB = 0;
                }
                if (aB > zVar.rqq) {
                    j2 = zVar.rqq;
                } else if (zVar.rqq - aB < j2) {
                    j3 = zVar.rqq - aB;
                    j2 = j3;
                }
            }
            j3 = j2;
            j2 = j3;
        }
        return j2 > j;
    }
}
