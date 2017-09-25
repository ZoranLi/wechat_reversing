package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Map;

public final class i {

    public static final class a implements com.tencent.mm.u.bp.a {
        private static final a iCs = new a();

        public static void Rg() {
            ap.getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", iCs, true);
        }

        public static void unregister() {
            ap.getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", iCs, true);
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            if (!bg.mA(a)) {
                d.vL().D(new Runnable(this) {
                    final /* synthetic */ a iCt;

                    public final void run() {
                        a.nR(a);
                    }
                });
            }
        }

        public static void nR(String str) {
            int i = 0;
            w.i("MicroMsg.AppBrandUsagePushingUpdateLogic", "parseThenProcess, accReady %b, received xml %s", new Object[]{Boolean.valueOf(h.vG().uV()), str});
            if (h.vG().uV()) {
                Map q = bh.q(str, "sysmsg");
                if (q != null && q.size() > 0) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    ArrayList arrayList3;
                    int i2;
                    int i3 = bg.getInt((String) q.get(".sysmsg.UpdateWxaUsageListNotify.Type"), 0);
                    int i4 = bg.getInt((String) q.get(".sysmsg.UpdateWxaUsageListNotify.DeleteCount"), 0);
                    if (i4 > 0) {
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        arrayList3 = new ArrayList();
                        int i5 = 0;
                        while (i5 < i4) {
                            String str2 = ".sysmsg.UpdateWxaUsageListNotify.DeleteList.DeleteAppInfo" + (i5 == 0 ? "" : Integer.valueOf(i5));
                            String str3 = (String) q.get(str2 + ".UserName");
                            String str4 = (String) q.get(str2 + ".AppID");
                            i2 = bg.getInt((String) q.get(str2 + ".AppType"), 0);
                            if (!(bg.mA(str3) || bg.mA(str4))) {
                                arrayList.add(str3);
                                arrayList2.add(str4);
                                arrayList3.add(Integer.valueOf(i2));
                            }
                            i5++;
                        }
                    } else {
                        arrayList3 = null;
                        arrayList2 = null;
                        arrayList = null;
                    }
                    switch (i3) {
                        case 1:
                            new l(4, 1, Integer.MAX_VALUE, 30).BC();
                            return;
                        case 2:
                            new l(4, 2, 0, 0).BC();
                            return;
                        case 3:
                            if (!bg.bV(arrayList)) {
                                while (i < arrayList.size()) {
                                    n.h((String) arrayList.get(i), (String) arrayList2.get(i), ((Integer) arrayList3.get(i)).intValue());
                                    i++;
                                }
                                return;
                            }
                            return;
                        case 4:
                            if (!bg.bV(arrayList)) {
                                for (i2 = 0; i2 < arrayList.size(); i2++) {
                                    c.PX().h((String) arrayList.get(i2), ((Integer) arrayList3.get(i2)).intValue(), false);
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
