package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.e.a.ss;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public class i {
    private static volatile i sqW = null;

    public static i bAB() {
        if (sqW == null) {
            synchronized (i.class) {
                if (sqW == null) {
                    sqW = new i();
                }
            }
        }
        return sqW;
    }

    public final void aE(final String str, final boolean z) {
        if (bg.mA(str)) {
            i(z, str);
            return;
        }
        final a anonymousClass1 = new a(this) {
            final /* synthetic */ i sqY;

            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                if (this.zk instanceof String) {
                    i iVar = this.sqY;
                    String str = (String) this.zk;
                    boolean z = z;
                    if (bg.mA(str)) {
                        i.i(z, str);
                        return;
                    }
                    w.i("MicroMsg.Wepkg.WepkgUpdater", "update preload files. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
                    List KJ = h.KJ(str);
                    if (!bg.bV(KJ)) {
                        w.i("MicroMsg.Wepkg.WepkgUpdater", "pkgid:%s, %s preload files need to download", new Object[]{str, Integer.valueOf(KJ.size())});
                    }
                    iVar.a(str, KJ, z);
                    return;
                }
                i.i(z, str);
            }
        };
        anonymousClass1.zk = str;
        w.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
        if (bg.mA(str)) {
            i(z, str);
            return;
        }
        w.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
        WepkgVersion KH = h.KH(str);
        if (KH == null) {
            i(z, str);
        } else if (KH.sri) {
            anonymousClass1.a(null);
        } else {
            h.a(1, KH.sqL, "", KH.downloadUrl, (long) KH.srg, KH.version, KH.fFW, KH.sqy, new a(this) {
                final /* synthetic */ i sqY;

                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    if (baseWepkgProcessTask instanceof WepkgDownloadProcessTask) {
                        WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                        if (wepkgDownloadProcessTask.sqz != RetCode.OK || bg.mA(wepkgDownloadProcessTask.gaF) || bg.mA(wepkgDownloadProcessTask.iAe)) {
                            i.i(z, str);
                            return;
                        } else {
                            h.a(wepkgDownloadProcessTask.gaF, wepkgDownloadProcessTask.iAe, true, anonymousClass1);
                            return;
                        }
                    }
                    i.i(z, str);
                }
            });
        }
    }

    public final void a(final String str, List<WepkgPreloadFile> list, boolean z) {
        try {
            if (bg.bV(list)) {
                w.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
                if (bg.mA(str)) {
                    i(z, str);
                    return;
                }
                if (bg.bV(h.KJ(str))) {
                    WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.ou = 3006;
                    wepkgCrossProcessTask.sqr.sqL = str;
                    wepkgCrossProcessTask.sqr.srj = true;
                    if (ab.bJb()) {
                        wepkgCrossProcessTask.PM();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask);
                    }
                    WepkgVersion KH = h.KH(str);
                    if (!(KH == null || KH.iam == 0)) {
                        a.b("downloadCompleteTime", "", KH.sqL, KH.version, -1, System.currentTimeMillis() - (KH.iam * 1000), null);
                        wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.ou = 3007;
                        wepkgCrossProcessTask.sqr.sqL = str;
                        if (ab.bJb()) {
                            wepkgCrossProcessTask.PM();
                        } else {
                            WepkgMainProcessService.b(wepkgCrossProcessTask);
                        }
                    }
                    i(z, str);
                    w.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
                    return;
                }
                w.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[]{Integer.valueOf(h.KJ(str).size())});
                i(z, str);
                return;
            }
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) list.remove(0);
            if (wepkgPreloadFile != null) {
                w.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[]{wepkgPreloadFile.sqL, wepkgPreloadFile.version, wepkgPreloadFile.sqw});
                final List<WepkgPreloadFile> list2 = list;
                final boolean z2 = z;
                a anonymousClass3 = new a(this) {
                    final /* synthetic */ i sqY;

                    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                        if ((this.zk instanceof WepkgPreloadFile) && (baseWepkgProcessTask instanceof WepkgDownloadProcessTask)) {
                            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.zk;
                            if (wepkgDownloadProcessTask.sqz != RetCode.OK || bg.mA(wepkgDownloadProcessTask.iAe)) {
                                w.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[]{wepkgDownloadProcessTask.sqz});
                                this.sqY.a(str, list2, z2);
                                return;
                            }
                            String str = wepkgPreloadFile.sqL;
                            String str2 = wepkgPreloadFile.sqw;
                            String str3 = wepkgDownloadProcessTask.iAe;
                            WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                            wepkgCrossProcessTask.ou = 4002;
                            wepkgCrossProcessTask.sqt.sqL = str;
                            wepkgCrossProcessTask.sqt.sqw = str2;
                            wepkgCrossProcessTask.sqt.filePath = str3;
                            wepkgCrossProcessTask.sqt.sqM = true;
                            if (ab.bJb()) {
                                wepkgCrossProcessTask.PM();
                            } else {
                                WepkgMainProcessService.b(wepkgCrossProcessTask);
                            }
                            boolean z = wepkgCrossProcessTask.fDU;
                            this.sqY.a(str, list2, z2);
                            return;
                        }
                        w.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
                        this.sqY.a(str, list2, z2);
                    }
                };
                anonymousClass3.zk = wepkgPreloadFile;
                h.a(2, wepkgPreloadFile.sqL, wepkgPreloadFile.sqw, wepkgPreloadFile.downloadUrl, (long) wepkgPreloadFile.size, wepkgPreloadFile.version, wepkgPreloadFile.fFW, wepkgPreloadFile.sqy, anonymousClass3);
                return;
            }
            w.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
            a(str, list, z);
        } catch (Exception e) {
            w.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[]{e.getMessage()});
        }
    }

    public static void i(boolean z, String str) {
        if (z) {
            b ssVar = new ss();
            ssVar.gaE.fEG = 0;
            com.tencent.mm.sdk.b.a.urY.m(ssVar);
        }
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = 2006;
        wepkgCrossProcessTask.sqr.sqL = str;
        if (ab.bJb()) {
            wepkgCrossProcessTask.PM();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        g.KE(str);
    }
}
