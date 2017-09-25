package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.ai.l;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public volatile af rWp = new af("WebviewWorkerThread");
    public ai rWq;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String rWr;
        final /* synthetic */ d rWs;
        final /* synthetic */ a rWt;

        public AnonymousClass1(a aVar, String str, d dVar) {
            this.rWt = aVar;
            this.rWr = str;
            this.rWs = dVar;
        }

        public final void run() {
            Map q = bh.q(this.rWr, "DNSAdvanceRelateDomain");
            LinkedList linkedList = new LinkedList();
            if (q != null && q.size() > 0) {
                String str;
                int i = 0;
                while (i < q.size()) {
                    str = (String) q.get(".DNSAdvanceRelateDomain.RelateDomain" + (i == 0 ? "" : Integer.valueOf(i)) + ".$domain");
                    if (bg.mA(str)) {
                        w.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                    if (!linkedList.contains(str)) {
                        linkedList.add(str);
                    }
                    i++;
                }
                int i2 = 0;
                while (true) {
                    String str2 = (String) q.get(".DNSAdvanceRelateDomain.RelateDomain" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".Relate");
                    str = (String) q.get(".DNSAdvanceRelateDomain.RelateDomain.Relate" + (i2 == 0 ? "" : Integer.valueOf(i2)));
                    if (bg.mA(str2) && bg.mA(str)) {
                        break;
                    }
                    if (!(bg.mA(str2) || linkedList.contains(str2))) {
                        linkedList.add(str2);
                    }
                    if (!(bg.mA(str) || linkedList.contains(str))) {
                        linkedList.add(str);
                    }
                    i2++;
                }
                w.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", new Object[]{Integer.valueOf(i2)});
                l bww = this.rWt.rWq.bww();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    InetAddress inetAddress;
                    long currentTimeMillis;
                    str = (String) it.next();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    InetAddress inetAddress2 = null;
                    try {
                        inetAddress2 = InetAddress.getByName(str);
                        w.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", new Object[]{str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                        inetAddress = inetAddress2;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    } catch (Exception e) {
                        w.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", new Object[]{e.getMessage()});
                        inetAddress = inetAddress2;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    }
                    try {
                        bww.jgm = currentTimeMillis;
                        bww.url = str;
                        if (inetAddress != null) {
                            bww.fHO = true;
                        } else {
                            bww.fHO = false;
                        }
                        d dVar = this.rWs;
                        if (dVar != null) {
                            w.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", new Object[]{Integer.valueOf(ai.bwu()), Long.valueOf(bww.jgm), bww.url, Boolean.valueOf(bww.fHO)});
                            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, Integer.valueOf(1), Long.valueOf(bww.jgm), Integer.valueOf(am.getNetType(ab.getContext())), bww.url, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ai.mlK), Integer.valueOf(ai.rXu), Integer.valueOf(bww.gaA), bww.rXD);
                            if (!bww.fHO) {
                                g.oUh.a(32, 12, 1, true);
                            }
                            g.oUh.a(32, 1, 1, true);
                            g.oUh.a(32, 5, bww.jgm, true);
                        }
                    } catch (Exception e2) {
                        w.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", new Object[]{e2.getMessage()});
                        return;
                    }
                }
            }
        }
    }

    public a(ai aiVar) {
        this.rWq = aiVar;
    }

    public final af vL() {
        if (this.rWp == null) {
            this.rWp = new af("WebviewWorkerThread");
        }
        return this.rWp;
    }
}
