package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public static void b(String str, long j, long j2, int i) {
        if (j2 != 0) {
            st stVar;
            st Gi = ae.beO().Gi(str);
            if (Gi == null) {
                stVar = new st();
            } else {
                stVar = Gi;
            }
            if (j != 0 || !stVar.tAF.isEmpty()) {
                if (j == 0) {
                    j = ((rk) stVar.tAF.getFirst()).twV;
                }
                rk rkVar = new rk();
                rkVar.twV = j;
                rkVar.twW = j2;
                bfd com_tencent_mm_protocal_c_bfd = new bfd();
                com_tencent_mm_protocal_c_bfd.ufJ = j;
                com_tencent_mm_protocal_c_bfd.ufK = j2;
                com_tencent_mm_protocal_c_bfd.ufL = i;
                rkVar.twX.add(com_tencent_mm_protocal_c_bfd);
                rk rkVar2 = rkVar;
                while (!stVar.tAF.isEmpty()) {
                    rkVar = (rk) stVar.tAF.getFirst();
                    if (r(rkVar2.twW, rkVar.twV) > 0) {
                        w.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + rkVar2.twW + " fault.Max" + rkVar.twV);
                        break;
                    } else {
                        stVar.tAF.removeFirst();
                        rkVar2 = a(rkVar, rkVar2);
                    }
                }
                stVar.tAF.addFirst(rkVar2);
                while (stVar.tAF.size() > 100) {
                    stVar.tAF.removeLast();
                }
                if (stVar.tAF.size() > 0) {
                    w.d("MicroMsg.FaultLogic", "min " + ((rk) stVar.tAF.get(0)).twW + " max " + ((rk) stVar.tAF.get(0)).twV);
                }
                k Gk = ae.beO().Gk(str);
                try {
                    Gk.field_userName = str;
                    Gk.field_faultS = stVar.toByteArray();
                    ae.beO().c(Gk);
                } catch (Exception e) {
                }
                if (stVar.tAF.size() > 1) {
                    w.d("MicroMsg.FaultLogic", "fault size : " + stVar.tAF.size());
                    Iterator it = stVar.tAF.iterator();
                    while (it.hasNext()) {
                        rkVar = (rk) it.next();
                        w.d("MicroMsg.FaultLogic", "min - max " + rkVar.twW + " " + rkVar.twV);
                    }
                }
            }
        }
    }

    private static rk a(rk rkVar, rk rkVar2) {
        rk rkVar3 = new rk();
        if (r(rkVar.twV, rkVar2.twV) > 0) {
            rkVar3.twV = rkVar.twV;
        } else {
            rkVar3.twV = rkVar2.twV;
        }
        if (r(rkVar.twW, rkVar2.twW) < 0) {
            rkVar3.twW = rkVar.twW;
        } else {
            rkVar3.twW = rkVar2.twW;
        }
        LinkedList linkedList = rkVar.twX;
        Iterator it = rkVar2.twX.iterator();
        while (it.hasNext()) {
            bfd com_tencent_mm_protocal_c_bfd = (bfd) it.next();
            if (linkedList.isEmpty()) {
                w.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
                linkedList.addFirst(com_tencent_mm_protocal_c_bfd);
            } else {
                long j = com_tencent_mm_protocal_c_bfd.ufK;
                int size = linkedList.size() - 1;
                while (size >= 0) {
                    if (r(j, ((bfd) linkedList.get(size)).ufJ) <= 0) {
                        break;
                    }
                    size--;
                }
                size = -1;
                j = com_tencent_mm_protocal_c_bfd.ufJ;
                int i = 0;
                while (i < linkedList.size()) {
                    if (r(j, ((bfd) linkedList.get(i)).ufK) >= 0) {
                        break;
                    }
                    i++;
                }
                i = linkedList.size();
                if (size == -1) {
                    linkedList.addFirst(com_tencent_mm_protocal_c_bfd);
                } else if (i == linkedList.size()) {
                    linkedList.addLast(com_tencent_mm_protocal_c_bfd);
                } else {
                    bfd com_tencent_mm_protocal_c_bfd2 = (bfd) linkedList.get(i);
                    if (r(com_tencent_mm_protocal_c_bfd.ufJ, com_tencent_mm_protocal_c_bfd2.ufJ) < 0) {
                        bfd com_tencent_mm_protocal_c_bfd3 = new bfd();
                        com_tencent_mm_protocal_c_bfd3.ufJ = com_tencent_mm_protocal_c_bfd2.ufJ;
                        j = com_tencent_mm_protocal_c_bfd.ufJ;
                        com_tencent_mm_protocal_c_bfd3.ufK = j == Long.MAX_VALUE ? Long.MIN_VALUE : j + 1;
                        com_tencent_mm_protocal_c_bfd3.ufL = com_tencent_mm_protocal_c_bfd2.ufL;
                        linkedList.add(i, com_tencent_mm_protocal_c_bfd3);
                        int i2 = i + 1;
                        i = size + 1;
                        size = i2;
                    } else {
                        int i3 = i;
                        i = size;
                        size = i3;
                    }
                    com_tencent_mm_protocal_c_bfd2 = (bfd) linkedList.get(i);
                    if (r(com_tencent_mm_protocal_c_bfd.ufK, com_tencent_mm_protocal_c_bfd2.ufK) > 0) {
                        bfd com_tencent_mm_protocal_c_bfd4 = new bfd();
                        com_tencent_mm_protocal_c_bfd4.ufK = com_tencent_mm_protocal_c_bfd2.ufK;
                        com_tencent_mm_protocal_c_bfd4.ufJ = dj(com_tencent_mm_protocal_c_bfd.ufK);
                        com_tencent_mm_protocal_c_bfd4.ufL = com_tencent_mm_protocal_c_bfd2.ufL;
                        linkedList.add(i + 1, com_tencent_mm_protocal_c_bfd4);
                    }
                    while (i >= size) {
                        linkedList.remove(i);
                        i--;
                    }
                    linkedList.add(size, com_tencent_mm_protocal_c_bfd);
                    if (linkedList.size() > 100) {
                        long j2 = ((bfd) linkedList.getLast()).ufK;
                        long j3 = ((bfd) linkedList.getLast()).ufJ;
                        int i4 = ((bfd) linkedList.getLast()).ufL;
                        long j4 = j3;
                        while (linkedList.size() >= 100) {
                            int i5;
                            com_tencent_mm_protocal_c_bfd = (bfd) linkedList.removeLast();
                            j3 = com_tencent_mm_protocal_c_bfd.ufJ;
                            if (com_tencent_mm_protocal_c_bfd.ufL < i4) {
                                i5 = com_tencent_mm_protocal_c_bfd.ufL;
                            } else {
                                i5 = i4;
                            }
                            i4 = i5;
                            j4 = j3;
                        }
                        bfd com_tencent_mm_protocal_c_bfd5 = new bfd();
                        com_tencent_mm_protocal_c_bfd5.ufJ = j4;
                        com_tencent_mm_protocal_c_bfd5.ufK = j2;
                        com_tencent_mm_protocal_c_bfd5.ufL = i4;
                        linkedList.addLast(com_tencent_mm_protocal_c_bfd5);
                    }
                }
            }
        }
        rkVar3.twX = linkedList;
        return rkVar3;
    }

    private static long r(long j, long j2) {
        if ((j <= 0 || j2 <= 0) && (j >= 0 || j2 >= 0)) {
            return j < 0 ? 1 : -1;
        } else {
            return j - j2;
        }
    }

    public static long dj(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j - 1;
    }

    public static int a(long j, long j2, String str) {
        LinkedList linkedList = ae.beO().Gi(str).tAF;
        w.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[]{Integer.valueOf(r0.tAF.size())});
        if (linkedList.isEmpty()) {
            return 0;
        }
        rk rkVar = (rk) linkedList.getFirst();
        if (j == 0 || r(rkVar.twW, j) > 0) {
            w.e("MicroMsg.FaultLogic", "has a fault  minId:" + j2 + " fault.min:" + rkVar.twW);
            return 0;
        } else if (j2 == 0 || r(rkVar.twV, j2) >= 0) {
            LinkedList linkedList2 = rkVar.twX;
            if (linkedList2.isEmpty()) {
                return 0;
            }
            Iterator it = linkedList2.iterator();
            int i = Integer.MAX_VALUE;
            while (it.hasNext()) {
                bfd com_tencent_mm_protocal_c_bfd = (bfd) it.next();
                if (j2 == 0 || r(j2, com_tencent_mm_protocal_c_bfd.ufK) >= 0) {
                    if (com_tencent_mm_protocal_c_bfd.ufL < i) {
                        i = com_tencent_mm_protocal_c_bfd.ufL;
                    }
                    if (r(j, com_tencent_mm_protocal_c_bfd.ufK) >= 0) {
                        if (i == Integer.MAX_VALUE) {
                            return 0;
                        }
                        return i;
                    }
                }
            }
            w.i("MicroMsg.FaultLogic", "should not to hear  minId:" + j);
            return 0;
        } else {
            w.e("MicroMsg.FaultLogic", ":" + j2 + " fault.max:" + rkVar.twV);
            return 0;
        }
    }
}
