package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.launching.o;
import com.tencent.mm.plugin.appbrand.launching.r;
import com.tencent.mm.protocal.c.adm;
import com.tencent.mm.protocal.c.adn;
import com.tencent.mm.protocal.c.bpi;
import com.tencent.mm.protocal.c.bpj;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.IOException;
import java.util.LinkedList;

public final class c {

    static class AnonymousClass2 implements h<Bundle> {
        final /* synthetic */ f iIB;

        public AnonymousClass2(f fVar) {
            this.iIB = fVar;
        }

        public final /* synthetic */ void ak(Object obj) {
            Bundle bundle = (Bundle) obj;
            if (this.iIB != null) {
                this.iIB.I(bundle.getString("appId"), bundle.getBoolean("result"));
            }
        }
    }

    private static class a implements i<Bundle, WxaPkgWrappingInfo> {
        private a() {
        }

        public final /* synthetic */ Object al(Object obj) {
            return r((Bundle) obj);
        }

        private static WxaPkgWrappingInfo r(Bundle bundle) {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = null;
            String string = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            bundle.getInt("scene");
            String string2 = bundle.getString("searchId");
            com.tencent.mm.plugin.appbrand.appcache.i a;
            String str;
            int i3;
            switch (i) {
                case 10000:
                    return (WxaPkgWrappingInfo) com.tencent.mm.plugin.appbrand.appcache.h.p(string, i, i2).second;
                case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                    if (new r(string, "", "").Ve() != com.tencent.mm.plugin.appbrand.launching.r.a.Ok.ordinal()) {
                        return wxaPkgWrappingInfo;
                    }
                    a = com.tencent.mm.plugin.appbrand.app.c.PY().a(string, i, "downloadURL");
                    if (a == null) {
                        w.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[]{string, Integer.valueOf(i)});
                        return wxaPkgWrappingInfo;
                    }
                    try {
                        return new m(string, i, i2, a.field_downloadURL).Sg();
                    } catch (Exception e) {
                        w.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[]{string, Integer.valueOf(i), e});
                        return wxaPkgWrappingInfo;
                    }
                case 10100:
                case 10101:
                    com.tencent.mm.plugin.appbrand.appcache.i a2 = com.tencent.mm.plugin.appbrand.app.c.PY().a(string, i, "downloadURL");
                    ap.yY();
                    int uH = com.tencent.mm.u.c.uH();
                    com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                    com.tencent.mm.bd.a com_tencent_mm_protocal_c_adm = new adm();
                    com_tencent_mm_protocal_c_adm.fTO = string;
                    com_tencent_mm_protocal_c_adm.tIX = uH;
                    bpi com_tencent_mm_protocal_c_bpi = new bpi();
                    switch (i) {
                        case 10100:
                            com_tencent_mm_protocal_c_bpi.tlI = 1;
                            com_tencent_mm_protocal_c_bpi.unN = 1;
                            break;
                        case 10101:
                            com_tencent_mm_protocal_c_bpi.tlI = 2;
                            com_tencent_mm_protocal_c_bpi.unN = 1;
                            break;
                        default:
                            com_tencent_mm_protocal_c_bpi.tlI = 0;
                            com_tencent_mm_protocal_c_bpi.unN = 0;
                            break;
                    }
                    if (a2 != null) {
                        com_tencent_mm_protocal_c_bpi.fFW = a2.field_versionMd5;
                    } else {
                        com_tencent_mm_protocal_c_bpi.fFW = "";
                    }
                    com_tencent_mm_protocal_c_adm.tIY = new LinkedList();
                    com_tencent_mm_protocal_c_adm.tIY.add(com_tencent_mm_protocal_c_bpi);
                    aVar.hsm = com_tencent_mm_protocal_c_adm;
                    aVar.hsn = new adn();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
                    aVar.hsl = 1186;
                    com.tencent.mm.y.a.a b = com.tencent.mm.plugin.appbrand.e.c.b(aVar.BE());
                    if (b.errType == 0 && b.errCode == 0) {
                        adn com_tencent_mm_protocal_c_adn = (adn) b.fYb;
                        if (!(com_tencent_mm_protocal_c_adn == null || com_tencent_mm_protocal_c_adn.tIY == null || com_tencent_mm_protocal_c_adn.tIY.size() <= 0)) {
                            bpi com_tencent_mm_protocal_c_bpi2 = (bpi) com_tencent_mm_protocal_c_adn.tIY.getFirst();
                            if (com_tencent_mm_protocal_c_bpi2.url != null && com_tencent_mm_protocal_c_bpi2.url.length() > 0) {
                                switch (i) {
                                    case 10000:
                                        com.tencent.mm.plugin.appbrand.app.c.PY().a(string, 10000, com_tencent_mm_protocal_c_bpi2.url, com_tencent_mm_protocal_c_bpi2.fFW, 0, 0);
                                        break;
                                    case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                                        com.tencent.mm.plugin.appbrand.app.c.PY().a(string, CdnLogic.MediaType_FAVORITE_FILE, com_tencent_mm_protocal_c_bpi2.url, com_tencent_mm_protocal_c_bpi2.fFW, 0, 0);
                                        break;
                                    case 10100:
                                        com.tencent.mm.plugin.appbrand.app.c.PY().a(string, 10100, com_tencent_mm_protocal_c_bpi2.url, com_tencent_mm_protocal_c_bpi2.fFW, 0, 0);
                                        break;
                                    case 10101:
                                        com.tencent.mm.plugin.appbrand.app.c.PY().a(string, 10101, com_tencent_mm_protocal_c_bpi2.url, com_tencent_mm_protocal_c_bpi2.fFW, 0, 0);
                                        break;
                                }
                            }
                        }
                    }
                    w.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[]{Integer.valueOf(b.errType), Integer.valueOf(b.errCode), b.fPf, string, Integer.valueOf(i)});
                    return (WxaPkgWrappingInfo) com.tencent.mm.plugin.appbrand.appcache.h.p(string, i, i2).second;
                case 10102:
                    try {
                        str = "";
                        a = com.tencent.mm.plugin.appbrand.app.c.PY().a(string, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i3 = a.field_version;
                        } else {
                            i3 = i2;
                        }
                        return new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, i, i3, com.tencent.mm.plugin.appbrand.dynamic.launching.b.iId, str).Sg();
                    } catch (Exception e2) {
                        w.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[]{e2});
                        return wxaPkgWrappingInfo;
                    }
                default:
                    try {
                        str = "";
                        a = com.tencent.mm.plugin.appbrand.app.c.PY().a(string, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i3 = a.field_version;
                        } else {
                            i3 = i2;
                        }
                        return new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, i, i3, com.tencent.mm.plugin.appbrand.dynamic.launching.b.iIc, str).Sg();
                    } catch (Exception e22) {
                        w.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[]{e22});
                        return wxaPkgWrappingInfo;
                    }
            }
        }
    }

    private static class b implements g<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, h hVar) {
            com.tencent.mm.plugin.appbrand.dynamic.b.a.removeAll();
            w.v("MicroMsg.DynamicPkgUpdater", "clearCache");
        }
    }

    private static class c implements i<Bundle, Bundle> {
        private c() {
        }

        public final /* synthetic */ Object al(Object obj) {
            return l((Bundle) obj);
        }

        private static Bundle l(Bundle bundle) {
            boolean z = true;
            String string = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            int i3 = bundle.getInt("scene");
            int i4 = bundle.getInt("widgetType");
            Bundle bundle2 = new Bundle();
            try {
                f Sf = new com.tencent.mm.plugin.appbrand.dynamic.launching.a(string, i, i2, i3, i4).Sf();
                if (Sf == null) {
                    return bundle2;
                }
                boolean z2;
                if (Sf.field_jsApiInfo != null) {
                    bundle2.putByteArray("jsApiInfo", Sf.field_jsApiInfo.toByteArray());
                }
                if (Sf.field_launchAction != null) {
                    bundle2.putByteArray("launchAction", Sf.field_launchAction.toByteArray());
                }
                if (Sf.field_versionInfo != null) {
                    bundle2.putByteArray("versionInfo", Sf.field_versionInfo.toByteArray());
                }
                h oT = com.tencent.mm.plugin.appbrand.app.c.PU().oT(string);
                DebuggerInfo oE = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.oE(string);
                Parcelable debuggerInfo = new DebuggerInfo();
                if (oT == null || !oT.field_openDebug) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                debuggerInfo.iHJ = z2;
                if (com.tencent.mm.plugin.appbrand.appcache.c.a.fp(i) || (oE != null && oE.iHI)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                debuggerInfo.iHI = z2;
                if (oE == null || !oE.iHK) {
                    z = false;
                }
                debuggerInfo.iHK = z;
                bundle2.putParcelable("debuggerInfo", debuggerInfo);
                AppBrandGlobalSystemConfig Rz = AppBrandGlobalSystemConfig.Rz();
                Parcelable widgetSysConfig = new WidgetSysConfig();
                widgetSysConfig.iEw = Rz.iEw;
                widgetSysConfig.iEx = Rz.iEx;
                widgetSysConfig.iEy = Rz.iEy;
                bundle2.putParcelable("sysConfig", widgetSysConfig);
                return bundle2;
            } catch (Exception e) {
                w.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[]{e});
            }
        }
    }

    private static class d implements i<Bundle, WxaPkgWrappingInfo> {
        private d() {
        }

        public final /* synthetic */ Object al(Object obj) {
            return Sn();
        }

        private static WxaPkgWrappingInfo Sn() {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = null;
            try {
                o oVar = new o();
                wxaPkgWrappingInfo = o.Sg();
            } catch (Throwable e) {
                w.e("MicroMsg.DynamicPkgUpdater", "getLibPkgInfo error : %s", new Object[]{Log.getStackTraceString(e)});
            }
            return wxaPkgWrappingInfo;
        }
    }

    private static class e implements g<Bundle, Bundle> {
        private e() {
        }

        public final /* synthetic */ void a(Object obj, final h hVar) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("appId");
            int i = bundle.getInt("debugType");
            com.tencent.mm.plugin.appbrand.appcache.i a = com.tencent.mm.plugin.appbrand.app.c.PY().a(string, i, "downloadURL");
            String str = a != null ? a.field_downloadURL : null;
            if (a == null) {
                w.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[]{string, Integer.valueOf(i)});
                Bundle bundle2 = new Bundle();
                bundle2.putString("appId", string);
                bundle2.putBoolean("result", false);
                hVar.ak(bundle2);
            } else if (!bg.mA(str)) {
                n.a(string, i, str, new com.tencent.mm.plugin.appbrand.appcache.n.a(this) {
                    final /* synthetic */ e iIC;

                    public final void a(String str, com.tencent.mm.plugin.appbrand.appcache.n.a.b bVar, com.tencent.mm.plugin.appbrand.appcache.n.a.a aVar) {
                        if (hVar != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("appId", str);
                            bundle.putBoolean("result", com.tencent.mm.plugin.appbrand.appcache.n.a.b.OK.equals(bVar));
                            hVar.ak(bundle);
                        }
                    }
                });
            }
        }
    }

    public interface f {
        void I(String str, boolean z);
    }

    public static WxaPkgWrappingInfo d(String str, String str2, int i, int i2) {
        Parcelable bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putString("searchId", str2);
        WxaPkgWrappingInfo oA = com.tencent.mm.plugin.appbrand.dynamic.b.a.oA(v(str, i, i2));
        if (oA == null) {
            oA = (WxaPkgWrappingInfo) com.tencent.mm.ipcinvoker.e.a("com.tencent.mm", bundle, a.class);
            if (oA != null) {
                com.tencent.mm.plugin.appbrand.dynamic.b.a.a(v(str, i, i2), oA);
            }
        }
        return oA;
    }

    public static j a(String str, int i, int i2, int i3, int i4) {
        Parcelable bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putInt("widgetType", i3);
        bundle.putInt("scene", i4);
        Bundle bundle2 = (Bundle) com.tencent.mm.ipcinvoker.e.a("com.tencent.mm", bundle, c.class);
        if (bundle2 == null) {
            return null;
        }
        j jVar = new j();
        jVar.appId = str;
        jVar.iID = (DebuggerInfo) bundle2.getParcelable("debuggerInfo");
        byte[] byteArray = bundle2.getByteArray("jsApiInfo");
        if (byteArray != null) {
            jVar.iIG = new kp();
            try {
                jVar.iIG.aD(byteArray);
            } catch (IOException e) {
                w.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e});
            }
        }
        byteArray = bundle2.getByteArray("launchAction");
        if (byteArray != null) {
            jVar.iIF = new bpj();
            try {
                jVar.iIF.aD(byteArray);
            } catch (IOException e2) {
                w.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e2});
            }
        }
        byteArray = bundle2.getByteArray("versionInfo");
        if (byteArray != null) {
            jVar.iIH = new bpk();
            try {
                jVar.iIH.aD(byteArray);
            } catch (IOException e22) {
                w.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e22});
            }
        }
        jVar.iIE = (WidgetSysConfig) bundle2.getParcelable("sysConfig");
        return jVar;
    }

    private static String v(String str, int i, int i2) {
        return str + "#" + i + "#" + i2;
    }
}
