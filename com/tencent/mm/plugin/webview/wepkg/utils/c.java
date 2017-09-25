package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.e.a.ss;
import com.tencent.mm.e.a.ss.a;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.webview.wepkg.model.d;
import com.tencent.mm.plugin.webview.wepkg.model.h;
import com.tencent.mm.plugin.webview.wepkg.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public d srx = new d();
    public final com.tencent.mm.sdk.b.c sry = new com.tencent.mm.sdk.b.c<ss>(this) {
        final /* synthetic */ c srz;

        {
            this.srz = r2;
            this.usg = ss.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ss ssVar = (ss) bVar;
            boolean sG = ab.bJb() ? g.sW().sG() : b.srv;
            w.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[]{Integer.valueOf(ssVar.gaE.fEG)});
            switch (ssVar.gaE.fEG) {
                case 0:
                    if (!sG) {
                        d.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 srA;

                            {
                                this.srA = r1;
                            }

                            public final void run() {
                                WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                wepkgCrossProcessTask.ou = MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK;
                                if (ab.bJb()) {
                                    wepkgCrossProcessTask.PM();
                                } else {
                                    WepkgMainProcessService.b(wepkgCrossProcessTask);
                                }
                                WepkgVersion wepkgVersion = wepkgCrossProcessTask.sqr;
                                if (wepkgVersion != null && !bg.mA(wepkgVersion.sqL)) {
                                    i.bAB().aE(wepkgVersion.sqL, true);
                                }
                            }
                        });
                        break;
                    }
                    break;
                case 1:
                    if (!sG) {
                        WepkgVersionManager.cp(ssVar.gaE.gaF, 1);
                        break;
                    }
                    break;
                case 2:
                    if (!sG) {
                        a aVar = ssVar.gaE;
                        com.tencent.mm.plugin.webview.wepkg.a.d bAp = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
                        String str = ssVar.gaE.gaF;
                        if (!bAp.rXW || bg.mA(str)) {
                            sG = false;
                        } else {
                            com.tencent.mm.plugin.webview.wepkg.a.c Kr = bAp.Kr(str);
                            sG = Kr != null && Kr.field_bigPackageReady && Kr.field_preloadFilesReady;
                        }
                        aVar.gaG = sG;
                        break;
                    }
                    break;
                case 3:
                    if (ab.bJb()) {
                        com.tencent.mm.plugin.webview.wepkg.model.b.bAy().bAz();
                        break;
                    }
                    break;
                case 4:
                    if (!sG) {
                        WepkgVersion KI = h.KI(ssVar.gaE.gaF);
                        if (KI != null) {
                            ssVar.gaE.gaH = KI.srl;
                            w.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[]{Integer.valueOf(ssVar.gaE.gaH)});
                            break;
                        }
                    }
                    break;
                case 5:
                    if (!sG && ab.bJb() && bg.az(Long.valueOf(bg.c((Long) com.tencent.mm.kernel.h.vI().vr().get(com.tencent.mm.storage.w.a.uIh, Long.valueOf(0)))).longValue()) > 1800) {
                        com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.uIh, Long.valueOf(bg.Ny()));
                        b ssVar2 = new ss();
                        ssVar2.gaE.fEG = 0;
                        com.tencent.mm.sdk.b.a.urY.m(ssVar2);
                        break;
                    }
                case 6:
                    if (!bg.mA(ssVar.gaE.gaF)) {
                        com.tencent.mm.plugin.webview.wepkg.model.g.KD(ssVar.gaE.gaF);
                        break;
                    }
                    com.tencent.mm.plugin.webview.wepkg.model.g.KD(null);
                    break;
            }
            return false;
        }
    };
}
