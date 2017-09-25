package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.bjl;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.protocal.c.ua;
import com.tencent.mm.protocal.c.ub;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.u;
import java.util.Iterator;
import java.util.LinkedList;

public final class k {

    public static class a {
        private static String W(String str, int i) {
            return String.format("%s_%s_local_version", new Object[]{str, Integer.valueOf(i)});
        }

        public static String X(String str, int i) {
            return String.format("%s_%s_server_version", new Object[]{str, Integer.valueOf(i)});
        }

        private static String Y(String str, int i) {
            return String.format("%s_%s_config", new Object[]{str, Integer.valueOf(i)});
        }

        public static void t(String str, int i, int i2) {
            if (com.tencent.mm.plugin.appbrand.app.c.PV() != null) {
                com.tencent.mm.plugin.appbrand.app.c.PV().aL(W(str, i), String.valueOf(i2));
            }
        }

        public static void u(String str, int i, int i2) {
            if (com.tencent.mm.plugin.appbrand.app.c.PV() != null) {
                com.tencent.mm.plugin.appbrand.app.c.PV().aL(X(str, i), String.valueOf(i2));
            }
        }

        public static void e(String str, int i, String str2) {
            if (com.tencent.mm.plugin.appbrand.app.c.PV() != null) {
                com.tencent.mm.plugin.appbrand.app.c.PV().aL(Y(str, i), str2);
            }
        }

        public static int Z(String str, int i) {
            if (com.tencent.mm.plugin.appbrand.app.c.PV() == null) {
                return 0;
            }
            return bg.getInt(com.tencent.mm.plugin.appbrand.app.c.PV().get(W(str, i), "0"), 0);
        }

        public static String aa(String str, int i) {
            if (com.tencent.mm.plugin.appbrand.app.c.PV() == null) {
                return "";
            }
            return com.tencent.mm.plugin.appbrand.app.c.PV().get(Y(str, i), "");
        }
    }

    public interface b {
        void a(int i, int i2, String str, com.tencent.mm.y.b bVar);
    }

    public interface c {
        void nE(String str);
    }

    public static void a(String str, LinkedList<bjl> linkedList) {
        a(str, linkedList, true);
    }

    public static void a(final String str, LinkedList<bjl> linkedList, boolean z) {
        if (bg.mA(str)) {
            w.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
        } else if (linkedList == null || linkedList.size() == 0) {
            w.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bjl com_tencent_mm_protocal_c_bjl = (bjl) it.next();
                w.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bjl.version), Integer.valueOf(com_tencent_mm_protocal_c_bjl.type)});
                int Z = a.Z(str, com_tencent_mm_protocal_c_bjl.type);
                int i = com_tencent_mm_protocal_c_bjl.version;
                a.u(str, com_tencent_mm_protocal_c_bjl.type, i);
                if (i != 0) {
                    if (i > Z) {
                        linkedList2.add(s(str, com_tencent_mm_protocal_c_bjl.type, com_tencent_mm_protocal_c_bjl.version));
                    } else if (i != Z) {
                        w.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[]{Integer.valueOf(Z), Integer.valueOf(i)});
                        if (bg.mA(a.aa(str, com_tencent_mm_protocal_c_bjl.type))) {
                            linkedList2.add(s(str, com_tencent_mm_protocal_c_bjl.type, com_tencent_mm_protocal_c_bjl.version));
                        }
                    } else if (bg.mA(a.aa(str, com_tencent_mm_protocal_c_bjl.type))) {
                        linkedList2.add(s(str, com_tencent_mm_protocal_c_bjl.type, com_tencent_mm_protocal_c_bjl.version));
                    }
                }
            }
            w.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[]{str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size())});
            if (z && linkedList2.size() != 0) {
                w.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[]{str});
                a(linkedList2, new b() {
                    public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                        if (i == 0 && i2 == 0) {
                            ub ubVar = (ub) bVar.hsk.hsr;
                            if (ubVar.tCg == null || ubVar.tCg.size() == 0) {
                                w.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                                return;
                            }
                            w.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[]{Integer.valueOf(ubVar.tCg.size())});
                            Iterator it = ubVar.tCg.iterator();
                            while (it.hasNext()) {
                                cp cpVar = (cp) it.next();
                                w.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{cpVar.tfJ, Integer.valueOf(cpVar.tfI)});
                                if (!bg.mA(cpVar.tfJ)) {
                                    a.t(str, cpVar.jOc, cpVar.tfI);
                                    a.u(str, cpVar.jOc, cpVar.tfI);
                                    a.e(str, cpVar.jOc, cpVar.tfJ);
                                }
                            }
                            return;
                        }
                        w.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    }
                });
            }
        }
    }

    private static tz s(String str, int i, int i2) {
        tz tzVar = new tz();
        tzVar.mtb = str;
        tzVar.jOc = i;
        tzVar.tfI = i2;
        return tzVar;
    }

    public static String a(final String str, int i, int i2, final c cVar, boolean z) {
        if (com.tencent.mm.plugin.appbrand.app.c.PV() == null) {
            return "";
        }
        boolean z2;
        int Z = a.Z(str, i);
        int i3 = com.tencent.mm.plugin.appbrand.app.c.PV() == null ? 0 : bg.getInt(com.tencent.mm.plugin.appbrand.app.c.PV().get(a.X(str, i), "0"), 0);
        String aa = a.aa(str, i);
        if (i3 == 0 || (!bg.mA(aa) && i3 <= Z)) {
            z2 = false;
        } else {
            z2 = true;
        }
        w.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(Z)});
        w.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[]{aa, Boolean.valueOf(z2)});
        if (z2) {
            b anonymousClass2 = new b() {
                public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                    if (i == 0 && i2 == 0) {
                        ub ubVar = (ub) bVar.hsk.hsr;
                        if (ubVar.tCg == null || ubVar.tCg.size() == 0) {
                            w.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                            if (cVar != null) {
                                cVar.nE("");
                                return;
                            }
                            return;
                        }
                        cp cpVar = (cp) ubVar.tCg.get(0);
                        w.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{cpVar.tfJ, Integer.valueOf(cpVar.tfI)});
                        if (!bg.mA(cpVar.tfJ)) {
                            a.t(str, cpVar.jOc, cpVar.tfI);
                            a.u(str, cpVar.jOc, cpVar.tfI);
                            a.e(str, cpVar.jOc, cpVar.tfJ);
                            if (cVar != null) {
                                cVar.nE(cpVar.tfJ);
                                return;
                            }
                            return;
                        } else if (cVar != null) {
                            cVar.nE("");
                            return;
                        } else {
                            return;
                        }
                    }
                    w.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (cVar != null) {
                        cVar.nE("");
                    }
                }
            };
            LinkedList linkedList = new LinkedList();
            tz tzVar = new tz();
            tzVar.mtb = str;
            tzVar.jOc = i;
            tzVar.tfI = i3;
            tzVar.tCe = i2;
            linkedList.add(tzVar);
            a(linkedList, anonymousClass2);
        } else {
            cVar.nE(aa);
        }
        return aa;
    }

    private static void a(LinkedList<tz> linkedList, final b bVar) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 1138;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        aVar.hsn = new ub();
        aVar.hso = 0;
        aVar.hsp = 0;
        com.tencent.mm.bd.a uaVar = new ua();
        uaVar.tCf = linkedList;
        aVar.hsm = uaVar;
        u.a(aVar.BE(), new com.tencent.mm.y.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, com.tencent.mm.y.k kVar) {
                if (bVar != null) {
                    bVar.a(i, i2, str, bVar);
                }
                return 0;
            }
        }, true);
    }
}
