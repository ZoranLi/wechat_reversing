package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    private static Map<Long, Long> oTP;
    private static a oTQ = new a();
    private static int oTR = -1;
    private static boolean oTS = false;

    public static void a(long j, String str, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvData(j, str, z);
                return;
            } catch (Throwable e) {
                w.e("MicroMsg.KVEasyReport", "localReport :%s", bg.g(e));
                return;
            }
        }
        SmcLogic.writeKvData(j, str, z);
    }

    public static void a(long j, byte[] bArr, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvPbData(j, bArr, z);
                return;
            } catch (Throwable e) {
                w.e("MicroMsg.KVEasyReport", "localReport :%s", bg.g(e));
                return;
            }
        }
        SmcLogic.writeKvPbData(j, bArr, z);
    }

    public static void b(long j, long j2, long j3, boolean z) {
        long j4 = j2;
        long j5 = j;
        do {
            SmcLogic.reportIDKey(j5, j4, j3, z);
            if (oTS) {
                if (oTP == null) {
                    aXG();
                }
                j5 = bg.a((Long) oTP.get(Long.valueOf(j5)), 0);
            } else {
                return;
            }
        } while (j5 > 0);
    }

    public static void c(ArrayList<IDKey> arrayList, boolean z) {
        if (arrayList != null) {
            SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
        }
    }

    public static void gE(boolean z) {
        w.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", Boolean.valueOf(oTS), Boolean.valueOf(z), bg.bJZ());
        oTS = z;
    }

    public static synchronized void aXG() {
        synchronized (d.class) {
            if (oTP == null) {
                oTP = new HashMap(20);
            }
            aez aXx = a.aXx();
            if (!(aXx == null || aXx.tKh == oTR)) {
                oTR = aXx.tKh;
                oTP.clear();
                LinkedList linkedList = aXx.tKi;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        amz com_tencent_mm_protocal_c_amz = (amz) it.next();
                        oTP.put(new Long((long) com_tencent_mm_protocal_c_amz.tRD), new Long((long) com_tencent_mm_protocal_c_amz.tRE));
                    }
                }
            }
            w.i("MicroMsg.KVEasyReport", "summerhv reloadHeavyUserIDMap heavyUserIDMap[%d][%d][%s], stack[%s]", Integer.valueOf(oTR), Integer.valueOf(oTP.size()), oTP, bg.bJZ());
        }
    }
}
