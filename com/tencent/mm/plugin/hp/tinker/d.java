package com.tencent.mm.plugin.hp.tinker;

import android.os.Build.VERSION;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tinker.lib.a.b;
import com.tencent.tinker.lib.b.f;
import com.tencent.tinker.lib.c.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

public final class d {
    private static boolean mLI = false;

    public static void a(ApplicationLike applicationLike) {
        long j;
        Throwable e;
        c cVar;
        com.tencent.tinker.lib.c.d eVar;
        Class cls;
        a aVar;
        w.i("Tinker.TinkerPatchManager", "try installing tinker");
        if (mLI) {
            w.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
            return;
        }
        a.a aVar2;
        b bVar;
        boolean bIu;
        com.tinkerboots.sdk.a.a.b fVar;
        long uX;
        try {
            uX = ((long) com.tencent.mm.kernel.a.uX()) & 4294967295L;
            try {
                w.i("Tinker.TinkerPatchManager", "uin is %s", new Object[]{bg.Qj(String.valueOf(uX))});
                j = uX;
            } catch (Exception e2) {
                e = e2;
                w.printErrStackTrace("Tinker.TinkerPatchManager", e, "tinker patch manager get uin failed.", new Object[0]);
                j = uX;
                aVar2 = new a.a(applicationLike);
                cVar = new c(applicationLike.getApplication());
                if (aVar2.xgq != null) {
                    throw new TinkerRuntimeException("loadReporter is already set.");
                }
                aVar2.xgq = cVar;
                eVar = new e(applicationLike.getApplication());
                if (aVar2.xgr != null) {
                    throw new TinkerRuntimeException("patchReporter is already set.");
                }
                aVar2.xgr = eVar;
                bVar = new b(applicationLike.getApplication());
                if (aVar2.xgp != null) {
                    throw new TinkerRuntimeException("listener is already set.");
                }
                aVar2.xgp = bVar;
                cls = TinkerPatchResultService.class;
                if (aVar2.xmm != null) {
                    throw new TinkerRuntimeException("resultServiceClass is already set.");
                }
                aVar2.xmm = cls;
                if (aVar2.xgq == null) {
                    aVar2.xgq = new com.tinkerboots.sdk.tinker.b.a(aVar2.context);
                }
                if (aVar2.xgr == null) {
                    aVar2.xgr = new com.tinkerboots.sdk.tinker.b.c(aVar2.context);
                }
                if (aVar2.xgp == null) {
                    aVar2.xgp = new com.tinkerboots.sdk.tinker.b.b(aVar2.context);
                }
                if (aVar2.xml == null) {
                    aVar2.xml = new f();
                }
                if (aVar2.xmm == null) {
                    aVar2.xmm = TinkerServerResultService.class;
                }
                if (aVar2.xmn == null) {
                    aVar2.xmn = new com.tinkerboots.sdk.a.a.a();
                }
                aVar = new a(aVar2.context, aVar2.applicationLike, aVar2.xgq, aVar2.xgr, aVar2.xgp, aVar2.xml, aVar2.xmm, aVar2.xmn);
                if (a.xmg != null) {
                    throw new TinkerRuntimeException("TinkerClient instance is already set.");
                }
                a.xmg = aVar;
                aVar = a.chU().El(g.cs(ab.getContext()));
                bIu = com.tencent.mm.sdk.a.b.bIu();
                if (aVar.xmi != null) {
                }
                com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                aVar = a.xmg;
                aVar = aVar.fo(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).fo("code-version", e.CLIENT_VERSION).fo("code-reversion", e.REV).fo(TencentLocation.NETWORK_PROVIDER, String.valueOf(am.isWifi(ab.getContext()) ? 3 : 2)).fo("sdk", String.valueOf(VERSION.SDK_INT)).fo("os-name", com.tencent.mm.protocal.d.sYJ).fo("device-brand", com.tencent.mm.protocal.d.sYG).fo("device-name", com.tencent.mm.protocal.d.sYL);
                fVar = new f();
                if (aVar.xmi != null) {
                }
                com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                w.i("Tinker.TinkerPatchManager", "try installing end");
                mLI = true;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            uX = 0;
            e = th;
            w.printErrStackTrace("Tinker.TinkerPatchManager", e, "tinker patch manager get uin failed.", new Object[0]);
            j = uX;
            aVar2 = new a.a(applicationLike);
            cVar = new c(applicationLike.getApplication());
            if (aVar2.xgq != null) {
                aVar2.xgq = cVar;
                eVar = new e(applicationLike.getApplication());
                if (aVar2.xgr != null) {
                    aVar2.xgr = eVar;
                    bVar = new b(applicationLike.getApplication());
                    if (aVar2.xgp != null) {
                        aVar2.xgp = bVar;
                        cls = TinkerPatchResultService.class;
                        if (aVar2.xmm != null) {
                            aVar2.xmm = cls;
                            if (aVar2.xgq == null) {
                                aVar2.xgq = new com.tinkerboots.sdk.tinker.b.a(aVar2.context);
                            }
                            if (aVar2.xgr == null) {
                                aVar2.xgr = new com.tinkerboots.sdk.tinker.b.c(aVar2.context);
                            }
                            if (aVar2.xgp == null) {
                                aVar2.xgp = new com.tinkerboots.sdk.tinker.b.b(aVar2.context);
                            }
                            if (aVar2.xml == null) {
                                aVar2.xml = new f();
                            }
                            if (aVar2.xmm == null) {
                                aVar2.xmm = TinkerServerResultService.class;
                            }
                            if (aVar2.xmn == null) {
                                aVar2.xmn = new com.tinkerboots.sdk.a.a.a();
                            }
                            aVar = new a(aVar2.context, aVar2.applicationLike, aVar2.xgq, aVar2.xgr, aVar2.xgp, aVar2.xml, aVar2.xmm, aVar2.xmn);
                            if (a.xmg != null) {
                                a.xmg = aVar;
                                aVar = a.chU().El(g.cs(ab.getContext()));
                                bIu = com.tencent.mm.sdk.a.b.bIu();
                                if (aVar.xmi != null) {
                                }
                                com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                                aVar = a.xmg;
                                if (am.isWifi(ab.getContext())) {
                                }
                                aVar = aVar.fo(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).fo("code-version", e.CLIENT_VERSION).fo("code-reversion", e.REV).fo(TencentLocation.NETWORK_PROVIDER, String.valueOf(am.isWifi(ab.getContext()) ? 3 : 2)).fo("sdk", String.valueOf(VERSION.SDK_INT)).fo("os-name", com.tencent.mm.protocal.d.sYJ).fo("device-brand", com.tencent.mm.protocal.d.sYG).fo("device-name", com.tencent.mm.protocal.d.sYL);
                                fVar = new f();
                                if (aVar.xmi != null) {
                                }
                                com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
                                w.i("Tinker.TinkerPatchManager", "try installing end");
                                mLI = true;
                            }
                            throw new TinkerRuntimeException("TinkerClient instance is already set.");
                        }
                        throw new TinkerRuntimeException("resultServiceClass is already set.");
                    }
                    throw new TinkerRuntimeException("listener is already set.");
                }
                throw new TinkerRuntimeException("patchReporter is already set.");
            }
            throw new TinkerRuntimeException("loadReporter is already set.");
        }
        aVar2 = new a.a(applicationLike);
        cVar = new c(applicationLike.getApplication());
        if (aVar2.xgq != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        }
        aVar2.xgq = cVar;
        eVar = new e(applicationLike.getApplication());
        if (aVar2.xgr != null) {
            throw new TinkerRuntimeException("patchReporter is already set.");
        }
        aVar2.xgr = eVar;
        bVar = new b(applicationLike.getApplication());
        if (aVar2.xgp != null) {
            throw new TinkerRuntimeException("listener is already set.");
        }
        aVar2.xgp = bVar;
        cls = TinkerPatchResultService.class;
        if (aVar2.xmm != null) {
            throw new TinkerRuntimeException("resultServiceClass is already set.");
        }
        aVar2.xmm = cls;
        if (aVar2.xgq == null) {
            aVar2.xgq = new com.tinkerboots.sdk.tinker.b.a(aVar2.context);
        }
        if (aVar2.xgr == null) {
            aVar2.xgr = new com.tinkerboots.sdk.tinker.b.c(aVar2.context);
        }
        if (aVar2.xgp == null) {
            aVar2.xgp = new com.tinkerboots.sdk.tinker.b.b(aVar2.context);
        }
        if (aVar2.xml == null) {
            aVar2.xml = new f();
        }
        if (aVar2.xmm == null) {
            aVar2.xmm = TinkerServerResultService.class;
        }
        if (aVar2.xmn == null) {
            aVar2.xmn = new com.tinkerboots.sdk.a.a.a();
        }
        aVar = new a(aVar2.context, aVar2.applicationLike, aVar2.xgq, aVar2.xgr, aVar2.xgp, aVar2.xml, aVar2.xmm, aVar2.xmn);
        if (a.xmg != null) {
            throw new TinkerRuntimeException("TinkerClient instance is already set.");
        }
        a.xmg = aVar;
        aVar = a.chU().El(g.cs(ab.getContext()));
        bIu = com.tencent.mm.sdk.a.b.bIu();
        if (aVar.xmi != null || aVar.xmh == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            aVar = a.xmg;
        } else {
            com.tencent.tinker.lib.e.a.i("Tinker.TinkerClient", "set debugger to %b", new Object[]{Boolean.valueOf(bIu)});
            aVar.xmi.xmr = bIu;
            aVar = a.xmg;
        }
        if (am.isWifi(ab.getContext())) {
        }
        aVar = aVar.fo(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)).fo("code-version", e.CLIENT_VERSION).fo("code-reversion", e.REV).fo(TencentLocation.NETWORK_PROVIDER, String.valueOf(am.isWifi(ab.getContext()) ? 3 : 2)).fo("sdk", String.valueOf(VERSION.SDK_INT)).fo("os-name", com.tencent.mm.protocal.d.sYJ).fo("device-brand", com.tencent.mm.protocal.d.sYG).fo("device-name", com.tencent.mm.protocal.d.sYL);
        fVar = new f();
        if (aVar.xmi != null || aVar.xmh == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
        } else {
            com.tencent.tinker.lib.e.a.i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", new Object[]{Integer.valueOf(fVar.hashCode())});
            aVar.xmi.xmn = fVar;
        }
        w.i("Tinker.TinkerPatchManager", "try installing end");
        mLI = true;
    }

    public static void aDk() {
        com.tencent.tinker.lib.e.a.a(new com.tencent.tinker.lib.e.a.a() {
            public final void i(String str, String str2, Object... objArr) {
                w.i(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                w.w(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                w.d(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                w.e(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                w.printErrStackTrace(str, th, str2, objArr);
            }
        });
    }

    public static void aDl() {
        if (mLI) {
            com.tencent.tinker.lib.d.a.hp(MMApplicationLike.getTinkerApplicationLike().getApplication()).aDl();
            return;
        }
        throw new RuntimeException("cleanPatch but tinker is not installed");
    }

    public static void yo(String str) {
        if (mLI) {
            com.tencent.tinker.lib.d.c.bJ(MMApplicationLike.getTinkerApplicationLike().getApplication(), str);
            return;
        }
        throw new RuntimeException("upgrade patch but tinker is not installed");
    }
}
