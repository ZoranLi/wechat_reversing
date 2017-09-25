package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.bfu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public final class c implements a {
    public ArrayList<a> gUN = new ArrayList(1);
    public int kdg = 0;
    public final d[] rbJ = new d[1];
    public Queue<c> rbK = new LinkedList();
    public HashMap<String, Integer> rbL = new HashMap();

    public interface a {
        void a(int i, SparseArray<c> sparseArray);
    }

    private static final class b {
        public static final c rbM = new c();
    }

    public static class c {
        private static int rbP = 0;
        public String aJE;
        public String fWo;
        public String fXI;
        public String fXO;
        public String id;
        public int rbN;
        public String rbO;
        public int ret;
        public int type;

        public c(String str, String str2, int i, String str3) {
            this.fXI = str;
            this.id = str2;
            this.type = i;
            this.aJE = str3;
            if (rbP == Integer.MAX_VALUE) {
                rbP = 0;
            }
            int i2 = rbP + 1;
            rbP = i2;
            this.rbN = i2;
            if (i == 1) {
                i2 = ay.gh(str);
                if (i2 != -1) {
                    String trim = str.substring(0, i2).trim();
                    if (trim != null && trim.length() > 0) {
                        this.rbO = trim;
                        this.fXI = str.substring(i2 + 1).trim();
                    }
                }
            }
        }
    }

    private void b(int i, SparseArray<c> sparseArray) {
        Iterator it = this.gUN.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, sparseArray);
        }
    }

    public final void bou() {
        w.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[]{Integer.valueOf(this.rbK.size())});
        if (this.rbK.size() != 0 && this.kdg <= this.rbJ.length) {
            for (int i = 0; i < this.rbJ.length; i++) {
                if (this.rbJ[i] == null) {
                    this.rbJ[i] = new d(i, this);
                    ap.vd().a(631, this.rbJ[i]);
                }
                if (!this.rbJ[i].rbR) {
                    Object obj;
                    d dVar = this.rbJ[i];
                    Queue queue = this.rbK;
                    if (dVar.rbR) {
                        obj = null;
                    } else {
                        dVar.rbQ = new SparseArray();
                        if (queue.size() == 0) {
                            obj = null;
                        } else {
                            dVar.rbR = true;
                            LinkedList linkedList = new LinkedList();
                            int i2 = 0;
                            while (i2 < 512 && queue.size() > 0) {
                                c cVar = (c) queue.peek();
                                int length = cVar.fXI.getBytes().length;
                                if (i2 == 0 || i2 + length <= 512) {
                                    queue.poll();
                                    bft com_tencent_mm_protocal_c_bft = new bft();
                                    com_tencent_mm_protocal_c_bft.ugh = cVar.rbN;
                                    com_tencent_mm_protocal_c_bft.ugi = cVar.fXI;
                                    if (cVar.type == 1 || o.dH(cVar.aJE)) {
                                        com_tencent_mm_protocal_c_bft.ugj = cVar.aJE;
                                    }
                                    switch (cVar.type) {
                                        case 0:
                                            com_tencent_mm_protocal_c_bft.tdM = 1;
                                            break;
                                        case 1:
                                            com_tencent_mm_protocal_c_bft.tdM = 4;
                                            break;
                                        case 2:
                                            com_tencent_mm_protocal_c_bft.tdM = 2;
                                            break;
                                        case 3:
                                            com_tencent_mm_protocal_c_bft.tdM = 3;
                                            break;
                                    }
                                    w.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[]{Integer.valueOf(cVar.type), Integer.valueOf(com_tencent_mm_protocal_c_bft.tdM), cVar.id});
                                    linkedList.add(com_tencent_mm_protocal_c_bft);
                                    dVar.rbQ.put(cVar.rbN, cVar);
                                }
                                i2 += length;
                            }
                            dVar.rbS = new b(linkedList);
                            ap.vd().a(dVar.rbS, 0);
                            dVar.start = System.currentTimeMillis();
                            dVar.rbU.v(60000, 60000);
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        this.kdg++;
                    }
                }
            }
        }
    }

    public final boolean Hx(String str) {
        return this.rbL.containsKey(str);
    }

    public final void a(int i, SparseArray<c> sparseArray, LinkedList<bfu> linkedList) {
        int i2;
        HashMap hashMap;
        this.kdg--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            w.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                hashMap2.put(((c) sparseArray.valueAt(i2)).id, Integer.valueOf(((c) sparseArray.valueAt(i2)).rbN));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        c cVar;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bfu com_tencent_mm_protocal_c_bfu = (bfu) it.next();
                cVar = (c) sparseArray.get(com_tencent_mm_protocal_c_bfu.ugh);
                String str = com_tencent_mm_protocal_c_bfu.ugk;
                if (cVar.type == 1) {
                    str = ay.M(str, cVar.rbO);
                    cVar.fXI = ay.M(cVar.fXI, cVar.rbO);
                }
                cVar.fXO = str;
                cVar.ret = com_tencent_mm_protocal_c_bfu.thX;
                cVar.fWo = com_tencent_mm_protocal_c_bfu.ugl;
                this.rbL.remove(cVar.id);
                if (hashMap != null) {
                    hashMap.remove(cVar.id);
                }
            }
        } else {
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                cVar = (c) sparseArray.valueAt(i2);
                if (cVar.type == 1) {
                    cVar.fXI = ay.M(cVar.fXI, cVar.rbO);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry key : hashMap.entrySet()) {
                this.rbL.remove(key.getKey());
                w.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[]{key.getKey(), key.getValue()});
            }
        }
        b(i, sparseArray);
        bou();
    }
}
