package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsApiFramework;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsApiFwContext;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsBridge;
import com.tencent.mm.plugin.appbrand.dynamic.performance.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ae;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class a {
    public String iDc;
    public String iGi;
    public g iGj;

    class AnonymousClass1 implements com.tencent.mm.ipcinvoker.c {
        final /* synthetic */ String fxR;
        final /* synthetic */ String iGk;
        final /* synthetic */ Bundle iGl;
        final /* synthetic */ a iGm;
        final /* synthetic */ String uF;

        public AnonymousClass1(a aVar, String str, String str2, String str3, Bundle bundle) {
            this.iGm = aVar;
            this.iGk = str;
            this.uF = str2;
            this.fxR = str3;
            this.iGl = bundle;
        }

        public final void k(Bundle bundle) {
            if (this.iGk.equals(this.iGm.iGi)) {
                int i = bundle.getInt("op");
                if (i == 0) {
                    this.iGm.iGj.Po();
                } else if (i == 1) {
                    g.oUh.a(635, 0, 1, false);
                    MiniJsApiFwContext miniJsApiFwContext = (MiniJsApiFwContext) bundle.getParcelable("fwContext");
                    if (!bundle.getBoolean("success", false) || miniJsApiFwContext == null) {
                        w.i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", new Object[]{this.uF});
                        this.iGm.iGj.hD(1);
                        g.oUh.a(635, 2, 1, false);
                    } else if (miniJsApiFwContext.RZ() != 1) {
                        w.i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", new Object[]{this.uF});
                        this.iGm.iGj.hD(2);
                        g.oUh.a(635, 2, 1, false);
                    } else {
                        com.tencent.mm.plugin.appbrand.dynamic.core.g.a(this.uF, miniJsApiFwContext);
                        this.iGm.iGj.d(this.uF, this.fxR, this.iGl);
                        g.oUh.a(635, 1, 1, false);
                    }
                }
            }
        }
    }

    class AnonymousClass2 implements com.tencent.mm.ipcinvoker.c {
        final /* synthetic */ a iGm;
        final /* synthetic */ String uF;

        public AnonymousClass2(a aVar, String str) {
            this.iGm = aVar;
            this.uF = str;
        }

        public final void k(Bundle bundle) {
            com.tencent.mm.plugin.appbrand.dynamic.core.g.oD(this.uF);
        }
    }

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            final String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            final String string2 = bundle.getString("appId");
            final Bundle bundle2 = bundle.getBundle("extData");
            final c oy = d.RP().oy(string);
            if (oy == null) {
                w.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
                return;
            }
            b.l(new Runnable(this) {
                final /* synthetic */ a iGo;

                public final void run() {
                    long j;
                    String str;
                    c cVar = oy;
                    String str2 = string;
                    String str3 = string2;
                    Bundle bundle = bundle2;
                    Assert.assertNotNull(str2);
                    if (!(str2.equals(cVar.iDc) || cVar.iGz == null)) {
                        cVar.Po();
                        cVar.aaI = false;
                        cVar.iGz = null;
                    }
                    cVar.iDc = str2;
                    cVar.appId = str3;
                    String str4 = "";
                    if (bundle != null) {
                        String string = bundle.getString("cache_key", "");
                        cVar.hPj = bundle.getString("query");
                        cVar.mUrl = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        cVar.iGw = bundle.getInt("widget_type");
                        cVar.iGy = bundle.getString("search_id");
                        cVar.iCS = bundle.getString("__session_id");
                        long j2 = bundle.getLong("__on_bind_nano_time");
                        if (!bg.mA(cVar.iCS)) {
                            com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
                        }
                        j = j2;
                        str = string;
                    } else {
                        j = 0;
                        str = str4;
                    }
                    w.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s, %s)", new Object[]{str2, str3, str});
                    Object obj = 1;
                    cVar.iGx = com.tencent.mm.plugin.appbrand.dynamic.i.d.oS(str2);
                    if (cVar.iGx == null) {
                        cVar.iGx = new com.tencent.mm.plugin.appbrand.dynamic.i.a();
                        obj = null;
                    }
                    Object obj2 = cVar.iGw == 1 ? null : obj;
                    cVar.iGx.field_id = str2;
                    cVar.iGx.field_cacheKey = str;
                    cVar.iGx.field_appId = str3;
                    if (cVar.iGz == null) {
                        MiniJsBridge miniJsBridge;
                        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.aQ(cVar.iCS, "before_init_js_engine");
                        Context context = cVar.mContext;
                        string = cVar.iDc;
                        MiniJsApiFwContext oC = com.tencent.mm.plugin.appbrand.dynamic.core.g.oC(string);
                        if (oC == null) {
                            w.w("MicroMsg.MiniJsApiFramework", "FwContext is null(id : %s)", new Object[]{string});
                            miniJsBridge = null;
                        } else {
                            boolean z;
                            com.tencent.mm.plugin.appbrand.d bVar;
                            w.i("MicroMsg.MiniJsApiFramework", "initJsBridge(%s)", new Object[]{string});
                            MiniJsBridge miniJsBridge2 = new MiniJsBridge();
                            miniJsBridge2.iHF = new com.tencent.mm.plugin.appbrand.dynamic.core.f(context, miniJsBridge2, new com.tencent.mm.plugin.appbrand.dynamic.h.a(string, oC.RY()));
                            miniJsBridge2.iHH = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.Se();
                            if (oC.Sa().iHJ) {
                                w.i("MicroMsg.MiniJsApiFramework", "debug(%s) mode opened, use WebView  JavaScript Engine.", new Object[]{oC.getId()});
                                z = false;
                            } else {
                                z = ae.gH(ab.getContext()) && (QbSdk.getTbsVersion(context) >= 43114 ? 1 : null) != null;
                                SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                boolean contains = sharedPreferences.contains("switch_x5_jscore");
                                boolean z2 = sharedPreferences.getBoolean("switch_x5_jscore", true);
                                sharedPreferences.edit().putBoolean("x5_jscore_enabled", z).commit();
                                if (contains) {
                                    z = z2;
                                }
                            }
                            if (z) {
                                bVar = new com.tencent.mm.plugin.appbrand.dynamic.e.b(ab.getContext(), miniJsBridge2, "WeixinJSCore");
                                g.oUh.a(639, 2, 1, false);
                                w.i("MicroMsg.MiniJsApiFramework", "Using X5 Javascript Engine");
                            } else {
                                bVar = new com.tencent.mm.plugin.appbrand.dynamic.e.a(ab.getContext(), miniJsBridge2, "WeixinJSCore", "https://servicewechat.com/app-widget#" + oC.getId());
                                g.oUh.a(639, 1, 1, false);
                                w.i("MicroMsg.MiniJsApiFramework", "Using WebView Based Javascript Engine");
                            }
                            g.oUh.a(639, 0, 1, false);
                            JSONObject jSONObject = new JSONObject();
                            MiniJsApiFramework.b(jSONObject, "platform", "android");
                            MiniJsApiFramework.b(jSONObject, "debug", Boolean.valueOf(oC.Sa().iHI));
                            MiniJsApiFramework.b(jSONObject, "drawMinInterval", Integer.valueOf(oC.Sb().iEy));
                            MiniJsApiFramework.b(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.sYN));
                            bVar.evaluateJavascript(String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{jSONObject.toString(), ""}), null);
                            w.v("MicroMsg.MiniJsApiFramework", "injectConfig(%s)", new Object[]{oC.getId()});
                            string = com.tencent.mm.plugin.appbrand.dynamic.i.g.aT(oC.getId(), "WAWidget.js");
                            String convertStreamToString = bg.mA(string) ? com.tencent.mm.plugin.appbrand.dynamic.i.g.convertStreamToString(com.tencent.mm.plugin.appbrand.appcache.e.openRead("WAWidget.js")) : string;
                            if (bg.mA(convertStreamToString)) {
                                w.e("MicroMsg.MiniJsApiFramework", "get Null Or Nil widget js");
                            }
                            g.oUh.a(636, 0, 1, false);
                            com.tencent.mm.plugin.appbrand.m.g.a(bVar, convertStreamToString, new com.tencent.mm.plugin.appbrand.m.g.a() {
                                public final void PK() {
                                    g.oUh.a(636, 1, 1, false);
                                }

                                public final void nu(String str) {
                                    g.oUh.a(636, 2, 1, false);
                                    w.e("MicroMsg.MiniJsApiFramework", "Inject SDK widget Script Failed: %s", new Object[]{str});
                                }
                            });
                            w.v("MicroMsg.MiniJsApiFramework", "injectWAWidget(%s)", new Object[]{oC.getId()});
                            convertStreamToString = com.tencent.mm.plugin.appbrand.dynamic.i.g.aT(oC.getId(), "widget.js");
                            if (bg.mA(convertStreamToString)) {
                                w.e("MicroMsg.MiniJsApiFramework", "get Null Or Nil widget js");
                            }
                            g.oUh.a(636, 3, 1, false);
                            com.tencent.mm.plugin.appbrand.m.g.a(bVar, convertStreamToString, new com.tencent.mm.plugin.appbrand.m.g.a() {
                                public final void PK() {
                                    g.oUh.a(636, 4, 1, false);
                                }

                                public final void nu(String str) {
                                    g.oUh.a(636, 5, 1, false);
                                    w.e("MicroMsg.MiniJsApiFramework", "Inject External widget Script Failed: %s", new Object[]{str});
                                }
                            });
                            w.v("MicroMsg.MiniJsApiFramework", "injectWidget(%s)", new Object[]{oC.getId()});
                            if (miniJsBridge2.ixt != null) {
                                w.e("MicroMsg.MiniJsBridge", "can not initialize again.");
                            } else {
                                miniJsBridge2.ixt = bVar;
                            }
                            miniJsBridge = miniJsBridge2;
                        }
                        cVar.iGz = miniJsBridge;
                        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.aQ(cVar.iCS, "after_init_js_engine");
                        cVar.iGz.iDc = cVar.iDc;
                        if (bundle != null) {
                            cVar.q(bundle.getBundle("__env_args"));
                        }
                        cVar.iGz.onStart();
                        if (cVar.iGA) {
                            cVar.iGz.b(new com.tencent.mm.plugin.appbrand.dynamic.f.d());
                        } else {
                            cVar.iGz.c(new com.tencent.mm.plugin.appbrand.dynamic.f.e());
                        }
                        MiniJsBridge miniJsBridge3 = cVar.iGz;
                        string = "";
                        str = "";
                        str3 = "";
                        Map map = null;
                        int i = 0;
                        int i2 = 0;
                        if (bundle != null) {
                            i = bundle.getInt("view_init_width");
                            i2 = bundle.getInt("view_init_height");
                            string = bundle.getString("cache_key", "");
                            str = bundle.getString("msg_title", "");
                            str2 = bundle.getString("msg_path", "");
                            str3 = o.qW(str2);
                            map = o.qX(str2);
                        }
                        com.tencent.mm.plugin.appbrand.dynamic.core.c aVar = new com.tencent.mm.plugin.appbrand.dynamic.f.a();
                        aVar.iHY = string;
                        aVar.title = str;
                        aVar.path = str3;
                        aVar.iHX = map;
                        aVar.iHZ = i;
                        aVar.iIa = i2;
                        miniJsBridge3.a(aVar);
                        if (j > 0) {
                            j2 = (System.nanoTime() - j) / 1000000;
                            int i3 = 7;
                            if (j2 <= 50) {
                                i3 = 0;
                            } else if (j2 <= 100) {
                                i3 = 1;
                            } else if (j2 <= 200) {
                                i3 = 2;
                            } else if (j2 <= 300) {
                                i3 = 3;
                            } else if (j2 <= 400) {
                                i3 = 4;
                            } else if (j2 <= 500) {
                                i3 = 5;
                            } else if (j2 <= 600) {
                                i3 = 6;
                            }
                            g.oUh.a(677, (long) i3, 1, false);
                        }
                        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.aQ(cVar.iCS, "init_finish");
                        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.print(cVar.iCS);
                    } else {
                        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oJ(cVar.iCS);
                        if (bundle != null) {
                            cVar.q(bundle.getBundle("__env_args"));
                        }
                        cVar.iGz.onStart();
                        if (cVar.iGA) {
                            cVar.iGz.b(new com.tencent.mm.plugin.appbrand.dynamic.f.d());
                        } else {
                            cVar.iGz.c(new com.tencent.mm.plugin.appbrand.dynamic.f.e());
                        }
                    }
                    cVar.aaI = true;
                    if (obj2 != null) {
                        c.a(cVar.iGz, cVar.iGx);
                    }
                    cVar.RO();
                }
            });
        }
    }

    private static class b implements com.tencent.mm.ipcinvoker.a {
        private b() {
        }

        public final void a(Bundle bundle, final com.tencent.mm.ipcinvoker.c cVar) {
            c cVar2 = null;
            final String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            d RP = d.RP();
            if (bg.mA(string)) {
                w.w("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy from manager failed, key is null or nil.");
            } else {
                c cVar3 = (c) RP.iGI.remove(string);
                String str = "MicroMsg.DynamicPageViewIPCProxyManager";
                String str2 = "remove IPCProxy success.(key : %s, ref : %s)";
                Object[] objArr = new Object[2];
                objArr[0] = string;
                objArr[1] = cVar3 != null ? Integer.valueOf(cVar3.hashCode()) : null;
                w.d(str, str2, objArr);
                if (cVar3 != null) {
                    cVar2 = cVar3;
                }
            }
            if (cVar2 == null) {
                w.e("MicroMsg.IPCInvoke_Detach", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            } else {
                b.l(new Runnable(this) {
                    final /* synthetic */ b iGp;

                    public final void run() {
                        c cVar = cVar2;
                        w.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", new Object[]{cVar.iDc});
                        cVar.aaI = false;
                        cVar.Po();
                        cVar.iGz = null;
                        cVar.iGx = null;
                        cVar.iDc = null;
                        cVar.iCS = null;
                        com.tencent.mm.plugin.appbrand.dynamic.core.g.oD(string);
                        cVar.k(null);
                    }
                });
            }
        }
    }

    private static class c implements com.tencent.mm.ipcinvoker.a {
        private c() {
        }

        public final void a(Bundle bundle, final com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("wxaPkgType");
            int i2 = bundle.getInt("pkgVersion");
            int i3 = bundle.getInt("scene");
            String string3 = bundle.getString("searchId");
            int i4 = bundle.getInt("widgetType");
            if (d.RP().oy(string) == null) {
                c cVar2 = new c(ab.getContext());
                d RP = d.RP();
                if (bg.mA(string)) {
                    w.w("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy into manager failed, key is null or nil.");
                } else {
                    if (((c) RP.iGI.put(string, cVar2)) != null) {
                        w.i("MicroMsg.DynamicPageViewIPCProxyManager", "add a new IPCProxy and remove old one with key : %s.", new Object[]{string});
                    }
                    w.d("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy success.(%s)", new Object[]{string});
                }
            }
            b.k(new com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsApiFramework.AnonymousClass1(string, com.tencent.mm.plugin.appbrand.dynamic.j.a.bn(i4, i), i2, string2, i4, i3, new com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsApiFramework.a(this) {
                final /* synthetic */ c iGq;

                public final void aN(String str, String str2) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 0);
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                    bundle.putString("appId", str2);
                    cVar.k(bundle);
                }

                public final void a(String str, String str2, boolean z, MiniJsApiFwContext miniJsApiFwContext) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 1);
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                    bundle.putString("appId", str2);
                    bundle.putBoolean("success", z);
                    if (miniJsApiFwContext != null) {
                        bundle.putParcelable("fwContext", miniJsApiFwContext);
                        com.tencent.mm.plugin.appbrand.dynamic.core.g.a(str, miniJsApiFwContext);
                    }
                    cVar.k(bundle);
                }
            }, string3));
        }
    }

    private static class d implements com.tencent.mm.ipcinvoker.a {
        private d() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            final c oy = d.RP().oy(bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
            if (oy == null) {
                w.e("MicroMsg.IPCInvoke_OnPause", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{r0});
                return;
            }
            b.l(new Runnable(this) {
                final /* synthetic */ d iGr;

                public final void run() {
                    oy.onPause();
                }
            });
        }
    }

    private static class e implements com.tencent.mm.ipcinvoker.a {
        private e() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            final c oy = d.RP().oy(bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
            if (oy == null) {
                w.e("MicroMsg.IPCInvoke_OnResume", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{r0});
                return;
            }
            b.l(new Runnable(this) {
                final /* synthetic */ e iGs;

                public final void run() {
                    oy.onResume();
                }
            });
        }
    }

    private static class f implements com.tencent.mm.ipcinvoker.a {
        private f() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            Bundle bundle2 = bundle.getBundle("__env_args");
            if (bundle2 == null) {
                w.i("MicroMsg.IPCInvoke_UpdateEnvArgs", "envArgs is null.");
                return;
            }
            c oy = d.RP().oy(string);
            if (oy == null) {
                w.e("MicroMsg.IPCInvoke_UpdateEnvArgs", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
                return;
            }
            oy.q(bundle2);
        }
    }

    public a(g gVar) {
        this.iGj = gVar;
    }
}
