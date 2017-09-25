package com.tencent.mm.u;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bp implements d {
    private Map<String, List<a>> hol = new HashMap();
    private Map<String, List<a>> hom = new HashMap();
    private Map<String, List<m>> hon = new HashMap();
    public Map<String, l> hoo = new ConcurrentHashMap();

    public interface a {
        void a(com.tencent.mm.y.d.a aVar);
    }

    @Deprecated
    public final void a(String str, a aVar, boolean z) {
        if (!bg.mA(str) && aVar != null) {
            Map map = z ? this.hom : this.hol;
            List list = (List) map.get(str);
            if (list == null) {
                list = new LinkedList();
                map.put(str, list);
            }
            if (!list.contains(aVar)) {
                list.add(aVar);
            }
        }
    }

    @Deprecated
    public final void b(String str, a aVar, boolean z) {
        if (!bg.mA(str) && aVar != null) {
            List list = (List) (z ? this.hom : this.hol).get(str);
            if (list != null) {
                list.remove(aVar);
            }
        }
    }

    public final void a(String str, m mVar) {
        if (!bg.mA(str) && mVar != null) {
            List list;
            synchronized (this.hon) {
                List list2 = (List) this.hon.get(str);
                if (list2 == null) {
                    LinkedList linkedList = new LinkedList();
                    this.hon.put(str, linkedList);
                    list = linkedList;
                } else {
                    list = list2;
                }
            }
            synchronized (list) {
                if (!list.contains(mVar)) {
                    list.add(mVar);
                }
            }
        }
    }

    public final void b(String str, m mVar) {
        if (!bg.mA(str) && mVar != null) {
            List list;
            synchronized (this.hon) {
                list = (List) this.hon.get(str);
            }
            if (list != null) {
                synchronized (list) {
                    list.remove(mVar);
                }
            }
        }
    }

    public final void a(String str, l lVar) {
        if (!bg.mA(str) && lVar != null) {
            if (this.hoo.containsKey(str)) {
                w.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", str, bg.bJZ());
            }
            this.hoo.put(str, lVar);
        }
    }

    public final b b(com.tencent.mm.y.d.a aVar) {
        bu buVar = aVar.hst;
        switch (buVar.mtd) {
            case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                String a = n.a(buVar.tfd);
                n.a(buVar.tff);
                a(a, aVar, false);
                c.oTb.A(10395, String.valueOf(buVar.tfk));
                return null;
            case CdnLogic.MediaType_FAVORITE_VIDEO /*10002*/:
                String a2 = n.a(buVar.tff);
                if (bg.mA(a2)) {
                    w.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                    return null;
                }
                Map map;
                String str;
                if (a2.startsWith("~SEMI_XML~")) {
                    Map PF = aw.PF(a2);
                    if (PF == null) {
                        w.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        return null;
                    }
                    map = PF;
                    str = "brand_service";
                } else {
                    int indexOf = a2.indexOf("<sysmsg");
                    if (indexOf == -1) {
                        w.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        return null;
                    }
                    w.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a2, a2.substring(indexOf));
                    Map q = bh.q(r0, "sysmsg");
                    if (q == null) {
                        w.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                        return null;
                    }
                    map = q;
                    str = (String) q.get(".sysmsg.$type");
                }
                w.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", a2, str);
                if (str != null) {
                    List<m> list;
                    a(str, aVar, true);
                    synchronized (this.hon) {
                        list = (List) this.hon.get(str);
                    }
                    if (list == null || list.isEmpty()) {
                        w.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
                    } else {
                        w.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
                        synchronized (list) {
                            for (m b : list) {
                                b.b(str, map);
                            }
                        }
                    }
                    l lVar = (l) this.hoo.get(str);
                    if (lVar != null) {
                        return lVar.a(str, map, aVar);
                    }
                    w.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", str);
                }
                return null;
            default:
                w.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", Integer.valueOf(buVar.mtd));
                return null;
        }
    }

    @Deprecated
    private void a(String str, com.tencent.mm.y.d.a aVar, boolean z) {
        List<a> list = (List) (z ? this.hom : this.hol).get(str);
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            return;
        }
        w.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (a a : list) {
            a.a(aVar);
        }
    }

    public final void h(au auVar) {
    }
}
