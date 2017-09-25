package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public final class au implements f {
    private static HashMap<String, b> pXK = new HashMap();
    private static HashMap<String, WeakReference<b>> pXL = new HashMap();

    class a {
        String mediaId;
        long pXM = -1;
        final /* synthetic */ au pXN;

        a(au auVar) {
            this.pXN = auVar;
        }
    }

    class b {
        long endTime = -1;
        boolean mGB = false;
        long pXM = -1;
        final /* synthetic */ au pXN;
        long pXO = -1;
        int pXP = 0;
        int pXQ = 0;
        HashMap<String, a> pXR = new HashMap();
        long startTime = -1;

        b(au auVar) {
            this.pXN = auVar;
        }
    }

    public static void Fu(String str) {
        if (r.ijw) {
            w.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) pXL.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.mGB = true;
            }
        }
    }

    public static void Fv(String str) {
        if (r.ijw) {
            w.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) pXL.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null && bVar != null && bVar.pXM == -1) {
                HashMap hashMap = bVar.pXR;
                if (hashMap != null && hashMap.containsKey(str)) {
                    a aVar = (a) hashMap.get(str);
                    if (aVar != null && aVar.pXM == -1) {
                        aVar.pXM = 1;
                        bVar.pXQ++;
                    }
                }
            }
        }
    }

    public static void Fw(String str) {
        w.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[]{str});
        if (pXK.containsKey(str)) {
            w.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[]{str});
            b bVar = (b) pXK.get(str);
            if (bVar != null && bVar.pXM == -1 && bVar.startTime != -1) {
                bVar.pXM = 1;
                bVar.pXQ = bVar.pXP;
                bVar.endTime = System.currentTimeMillis();
                bVar.pXO = bVar.endTime - bVar.startTime;
                for (a aVar : bVar.pXR.values()) {
                    aVar.pXM = 1;
                }
            }
        }
    }

    public final void a(String str, bfc com_tencent_mm_protocal_c_bfc) {
        if (!pXK.containsKey(str)) {
            if (r.ijw) {
                w.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[]{str});
            }
            if (com_tencent_mm_protocal_c_bfc != null && com_tencent_mm_protocal_c_bfc.ufB != null && com_tencent_mm_protocal_c_bfc.ufB.tsN == 1 && com_tencent_mm_protocal_c_bfc.ufB.tsO != null && com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                b bVar = new b(this);
                bVar.pXP = com_tencent_mm_protocal_c_bfc.ufB.tsO.size();
                bVar.pXQ = 0;
                bVar.pXR = new HashMap();
                Iterator it = com_tencent_mm_protocal_c_bfc.ufB.tsO.iterator();
                while (it.hasNext()) {
                    alh com_tencent_mm_protocal_c_alh = (alh) it.next();
                    a aVar = new a(this);
                    aVar.mediaId = com_tencent_mm_protocal_c_alh.mQY;
                    bVar.pXR.put(com_tencent_mm_protocal_c_alh.mQY, aVar);
                    pXL.put(com_tencent_mm_protocal_c_alh.mQY, new WeakReference(bVar));
                }
                bVar.startTime = System.currentTimeMillis();
                pXK.put(str, bVar);
            } else if (r.ijw) {
                w.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
            }
        }
    }

    public final void EY(String str) {
        if (pXK.containsKey(str)) {
            if (r.ijw) {
                w.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[]{str});
            }
            b bVar = (b) pXK.get(str);
            if (bVar != null && bVar.startTime != -1 && bVar.pXM == -1) {
                bVar.endTime = System.currentTimeMillis();
                bVar.pXO = bVar.endTime - bVar.startTime;
                if (bVar.pXQ == bVar.pXP) {
                    bVar.pXM = 1;
                } else {
                    bVar.pXM = 2;
                }
            }
        }
    }

    public final void bdZ() {
        w.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[]{Integer.valueOf(pXK.size())});
        int bdC = i.bdC();
        for (String str : pXK.keySet()) {
            b bVar = (b) pXK.get(str);
            if (bVar != null && bVar.mGB) {
                if (bVar.pXO == -1 || bVar.pXM == -1 || bVar.startTime == -1) {
                    if (bVar.startTime != -1) {
                        bVar.endTime = System.currentTimeMillis();
                        bVar.pXO = bVar.endTime - bVar.startTime;
                        if (bVar.pXP == bVar.pXQ) {
                            bVar.pXM = 1;
                        } else {
                            bVar.pXM = 2;
                        }
                    }
                }
                w.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", new Object[]{Integer.valueOf(bVar.pXP), Long.valueOf(bVar.pXM), Long.valueOf(bVar.pXO), Integer.valueOf(bVar.pXQ), Integer.valueOf(bdC)});
                g.oUh.i(11600, new Object[]{Integer.valueOf(bVar.pXP), Long.valueOf(bVar.pXM), Long.valueOf(bVar.pXO), Integer.valueOf(bVar.pXQ), Integer.valueOf(bdC)});
            }
        }
        pXK.clear();
        pXL.clear();
    }
}
