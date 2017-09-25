package com.tencent.e.a;

import com.tencent.e.d;
import com.tencent.e.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public HashMap<String, Object> xjp = new HashMap();
    public Object xjq = new Object();
    c xjr;

    public final void a(d dVar, String[] strArr) {
        if (dVar != null && strArr != null) {
            synchronized (this.xjq) {
                for (Object obj : strArr) {
                    if (obj != null) {
                        Object obj2 = this.xjp.get(obj);
                        if (obj2 == null) {
                            this.xjp.put(obj, dVar);
                        } else if (obj2 instanceof d) {
                            d dVar2 = (d) obj2;
                            if (dVar2 == dVar) {
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(dVar2);
                            linkedList.add(dVar);
                            this.xjp.put(obj, linkedList);
                        } else if (obj2 instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj2;
                            if (linkedList2.indexOf(dVar) >= 0) {
                                return;
                            }
                            linkedList2.add(dVar);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public final void b(String str, int i, Object obj) {
        LinkedList linkedList = null;
        d dVar = this.xjr;
        e chc = dVar.chc();
        if (chc == null) {
            chc = dVar.chb();
        } else {
            chc.reset();
        }
        e eVar = (e) chc;
        eVar.fPp = str;
        eVar.xjt = i;
        eVar.arg1 = 0;
        eVar.arg2 = 0;
        eVar.obj = obj;
        if (eVar != null && eVar.fPp != null) {
            d dVar2;
            System.currentTimeMillis();
            String str2 = eVar.fPp;
            synchronized (this.xjq) {
                Object obj2 = this.xjp.get(str2);
                if (obj2 != null) {
                    if (obj2 instanceof d) {
                        dVar2 = (d) obj2;
                    } else if (obj2 instanceof List) {
                        linkedList = (LinkedList) ((LinkedList) obj2).clone();
                        obj2 = null;
                    }
                }
                dVar2 = null;
            }
            if (dVar2 != null) {
                dVar2.dl(str2, eVar.xjt);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).dl(str2, eVar.xjt);
                }
            }
            dVar = this.xjr;
            synchronized (dVar.mLock) {
                if (dVar.puT < dVar.xjb.length) {
                    dVar.xjb[dVar.puT] = eVar;
                    dVar.puT++;
                }
            }
        }
    }
}
