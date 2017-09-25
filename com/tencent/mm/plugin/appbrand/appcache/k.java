package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.c.bjl;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class k implements com.tencent.mm.u.bp.a {
    public static final Map<String, c> izr;

    public interface c {
        void p(Map<String, String> map);
    }

    private static final class a implements c {
        public final void p(Map<String, String> map) {
            if (map.get(".sysmsg.mmbizwxaconfig") != null) {
                int i = bg.getInt((String) map.get(".sysmsg.mmbizwxaconfig.command"), -1);
                final int i2 = bg.getInt((String) map.get(".sysmsg.mmbizwxaconfig.type"), 0);
                final String str = (String) map.get(".sysmsg.mmbizwxaconfig.appid");
                w.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(bg.getInt((String) map.get(".sysmsg.mmbizwxaconfig.configversion"), 0))});
                LinkedList linkedList = new LinkedList();
                bjl com_tencent_mm_protocal_c_bjl = new bjl();
                com_tencent_mm_protocal_c_bjl.version = r1;
                com_tencent_mm_protocal_c_bjl.type = i2;
                linkedList.add(com_tencent_mm_protocal_c_bjl);
                com.tencent.mm.plugin.appbrand.config.k.a(str, linkedList, false);
                com.tencent.mm.plugin.appbrand.config.k.a(str, i2, i, new com.tencent.mm.plugin.appbrand.config.k.c(this) {
                    final /* synthetic */ a izv;

                    public final void nE(String str) {
                        w.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[]{str});
                        com.tencent.mm.plugin.appbrand.ipc.d.f(str, i2, str);
                    }
                }, true);
            }
        }
    }

    private static final class b implements c {
        public final void p(Map<String, String> map) {
            c(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
            int i = 0;
            do {
                i++;
            } while (c(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo" + i, map));
        }

        private boolean c(String str, Map<String, String> map) {
            w.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[]{str});
            if (map.get(str) == null) {
                return false;
            }
            final String str2 = (String) map.get(str + ".AppID");
            String str3 = (String) map.get(str + ".UserName");
            final int i = bg.getInt((String) map.get(str + ".Type"), 1);
            String str4 = (String) map.get(str + ".URL");
            long j = bg.getLong((String) map.get(str + ".StartTime"), bg.Ny());
            w.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[]{str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(bg.getLong((String) map.get(str + ".EndTime"), 7200 + j)), r7, Boolean.valueOf(com.tencent.mm.plugin.appbrand.app.c.PY().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10))});
            if (com.tencent.mm.plugin.appbrand.app.c.PY().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)) {
                final String oo = p.oo(str2);
                if (!(i == 0 || 999 == i)) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ b izy;

                        public final void run() {
                            com.tencent.mm.plugin.appbrand.task.b.an(str2, i);
                            Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.dFE, new Object[]{bg.ap(oo, str2)}), 1).show();
                        }
                    });
                }
            }
            if (999 != i) {
                q.G(str3, false);
            }
            com.tencent.mm.plugin.appbrand.app.c.PW().a(str3, i, false, false, 0, 0);
            return true;
        }
    }

    private static final class d implements c {
        public final void p(Map<String, String> map) {
            if (map.get(".sysmsg.AppPublicLibraryNotify") != null) {
                int i = bg.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
                String str = (String) map.get(".sysmsg.AppPublicLibraryNotify.MD5");
                String str2 = (String) map.get(".sysmsg.AppPublicLibraryNotify.URL");
                int i2 = bg.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
                if (bg.mA(str2) || bg.mA(str) || i <= 0) {
                    w.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[]{str2, str, Integer.valueOf(i)});
                    return;
                }
                w.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
                bpu com_tencent_mm_protocal_c_bpu = new bpu();
                com_tencent_mm_protocal_c_bpu.version = i;
                com_tencent_mm_protocal_c_bpu.fFW = str;
                com_tencent_mm_protocal_c_bpu.url = str2;
                com_tencent_mm_protocal_c_bpu.tWA = i2;
                com.tencent.mm.plugin.appbrand.app.c.PY().a(com_tencent_mm_protocal_c_bpu);
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new b());
        hashMap.put("AppPublicLibraryNotify", new d());
        hashMap.put("mmbizwxaconfig", new a());
        izr = Collections.unmodifiableMap(hashMap);
    }

    public final void a(com.tencent.mm.y.d.a aVar) {
        final String a = n.a(aVar.hst.tff);
        if (bg.mA(a)) {
            w.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
        } else {
            com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable(this) {
                final /* synthetic */ k izt;

                public final void run() {
                    k.nD(a);
                }
            });
        }
    }

    public static void nD(String str) {
        if (com.tencent.mm.plugin.appbrand.app.c.PY() == null) {
            w.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            return;
        }
        Map q = bh.q(str, "sysmsg");
        if (q == null || q.size() <= 0) {
            w.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            return;
        }
        String str2 = (String) q.get(".sysmsg.$type");
        w.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", new Object[]{str2});
        if (!bg.mA(str2)) {
            c cVar = (c) izr.get(str2);
            if (cVar != null) {
                cVar.p(q);
            }
        }
    }
}
