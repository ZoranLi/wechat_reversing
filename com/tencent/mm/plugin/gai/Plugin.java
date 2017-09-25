package com.tencent.mm.plugin.gai;

import android.content.Context;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;

public class Plugin implements c {

    public interface a {
        void xj(String str);
    }

    public Plugin() {
        w.i("MicroMsg.Plugin.gai", "gai Plugin!");
        if (!ab.getContext().getSharedPreferences(ab.bIX() + "_google_aid", 4).getBoolean("already_report_googleaid", false)) {
            final Context context = ab.getContext();
            final a anonymousClass1 = new a(this) {
                final /* synthetic */ Plugin mdM;

                {
                    this.mdM = r1;
                }

                public final void xj(String str) {
                    ab.getContext().getSharedPreferences(ab.bIX() + "_google_aid", 4).edit().putString("getgoogleaid", str).commit();
                    String deviceID = p.getDeviceID(ab.getContext());
                    String androidId = p.getAndroidId();
                    String rC = p.rC();
                    String string = ab.getContext().getSharedPreferences(ab.bIX(), 0).getString("installreferer", "");
                    w.i("MicroMsg.Plugin.gai", "Advertisement MAT rsakv logID:%d val:%s", new Object[]{Integer.valueOf(11238), String.format("%s,%s,%s,%s,%s,%s", new Object[]{"", deviceID, androidId, rC, str, string})});
                    g.oUh.a(11238, r0, true, true);
                    ab.getContext().getSharedPreferences(ab.bIX() + "_google_aid", 4).edit().putBoolean("already_report_googleaid", true).commit();
                }
            };
            e.post(new Runnable(this) {
                final /* synthetic */ Plugin mdM;

                public final void run() {
                    String str = "";
                    com.google.android.gms.a.a.a.a aVar = null;
                    try {
                        aVar = com.google.android.gms.a.a.a.r(context);
                        w.d("MicroMsg.Plugin.gai", "adInfo: %s", new Object[]{aVar});
                        if (aVar != null) {
                            str = aVar.agM;
                            w.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", new Object[]{str});
                        }
                        if (anonymousClass1 != null) {
                            anonymousClass1.xj(str);
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.Plugin.gai", e, "AdMatReport:: get Ad Id info error %s", new Object[]{e.getMessage()});
                        w.e("MicroMsg.Plugin.gai", "AdMatReport:: get Ad Id info error %s", new Object[]{e.getMessage()});
                        if (anonymousClass1 != null) {
                            anonymousClass1.xj(str);
                        }
                    } catch (Throwable th) {
                        if (aVar != null) {
                            str = aVar.agM;
                            w.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", new Object[]{str});
                        }
                        if (anonymousClass1 != null) {
                            anonymousClass1.xj(str);
                        }
                    }
                }
            }, "Advertisement-MAT-thread");
        }
    }

    public k createApplication() {
        return new com.tencent.mm.plugin.gai.a.a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new com.tencent.mm.plugin.gai.b.a();
    }
}
