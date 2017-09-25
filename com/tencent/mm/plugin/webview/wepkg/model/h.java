package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class h {

    static class AnonymousClass10 implements Runnable {
        final /* synthetic */ a sqN;
        final /* synthetic */ WepkgCrossProcessTask sqQ;

        AnonymousClass10(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
            this.sqQ = wepkgCrossProcessTask;
            this.sqN = aVar;
        }

        public final void run() {
            this.sqQ.PM();
            if (this.sqN != null) {
                this.sqN.a(this.sqQ);
            }
        }
    }

    static class AnonymousClass11 implements Runnable {
        final /* synthetic */ a sqN;
        final /* synthetic */ WepkgCrossProcessTask sqQ;

        AnonymousClass11(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.sqN = aVar;
            this.sqQ = wepkgCrossProcessTask;
        }

        public final void run() {
            if (this.sqN != null) {
                this.sqN.a(this.sqQ);
            }
            this.sqQ.SN();
        }
    }

    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ a sqN = null;
        final /* synthetic */ WepkgCrossProcessTask sqP;

        AnonymousClass2(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
            this.sqP = wepkgCrossProcessTask;
        }

        public final void run() {
            this.sqP.PM();
            if (this.sqN != null) {
                this.sqN.a(this.sqP);
            }
        }
    }

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ a sqN = null;
        final /* synthetic */ WepkgCrossProcessTask sqP;

        AnonymousClass3(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.sqP = wepkgCrossProcessTask;
        }

        public final void run() {
            if (this.sqN != null) {
                this.sqN.a(this.sqP);
            }
            this.sqP.SN();
        }
    }

    static class AnonymousClass6 implements Runnable {
        final /* synthetic */ a sqN = null;
        final /* synthetic */ WepkgCrossProcessTask sqQ;

        AnonymousClass6(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
            this.sqQ = wepkgCrossProcessTask;
        }

        public final void run() {
            this.sqQ.PM();
            if (this.sqN != null) {
                this.sqN.a(this.sqQ);
            }
        }
    }

    static class AnonymousClass7 implements Runnable {
        final /* synthetic */ a sqN = null;
        final /* synthetic */ WepkgCrossProcessTask sqQ;

        AnonymousClass7(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
            this.sqQ = wepkgCrossProcessTask;
        }

        public final void run() {
            if (this.sqN != null) {
                this.sqN.a(this.sqQ);
            }
            this.sqQ.SN();
        }
    }

    public static WepkgVersion KH(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = 3001;
        wepkgCrossProcessTask.sqr.sqL = str;
        if (ab.bJb()) {
            wepkgCrossProcessTask.PM();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.sqr == null) {
            return null;
        }
        return wepkgCrossProcessTask.sqr;
    }

    public static WepkgVersion KI(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = 3002;
        wepkgCrossProcessTask.sqr.sqL = str;
        if (ab.bJb()) {
            wepkgCrossProcessTask.PM();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.sqr == null) {
            return null;
        }
        return wepkgCrossProcessTask.sqr;
    }

    public static void a(String str, String str2, boolean z, final a aVar) {
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = 3005;
        wepkgCrossProcessTask.sqr.sqL = str;
        wepkgCrossProcessTask.sqr.iAe = str2;
        wepkgCrossProcessTask.sqr.sri = z;
        if (ab.bJb()) {
            d.vL().D(new Runnable() {
                public final void run() {
                    wepkgCrossProcessTask.PM();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                }
            });
            return;
        }
        wepkgCrossProcessTask.iMD = new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.SN();
            }
        };
        wepkgCrossProcessTask.SM();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, a aVar) {
        final WepkgMainProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask();
        wepkgDownloadProcessTask.fileType = i;
        wepkgDownloadProcessTask.gaF = str;
        wepkgDownloadProcessTask.downloadUrl = str3;
        wepkgDownloadProcessTask.sqx = j;
        wepkgDownloadProcessTask.version = str4;
        wepkgDownloadProcessTask.fFW = str5;
        wepkgDownloadProcessTask.sqy = i2;
        if (ab.bJb()) {
            final int i3 = i;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final long j2 = j;
            final String str9 = str4;
            final String str10 = str5;
            final int i4 = i2;
            final a aVar2 = aVar;
            d.vL().D(new Runnable() {
                public final void run() {
                    WePkgDownloader.bAv().a(i3, bg.mz(str6), bg.mz(str7), bg.mz(str8), j2, bg.mz(str9), bg.mz(str10), i4, new IWepkgUpdateCallback(this) {
                        final /* synthetic */ AnonymousClass12 sqV;

                        {
                            this.sqV = r1;
                        }

                        public final void a(String str, String str2, RetCode retCode) {
                            w.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[]{retCode});
                            wepkgDownloadProcessTask.gaF = str;
                            wepkgDownloadProcessTask.iAe = str2;
                            wepkgDownloadProcessTask.sqz = retCode;
                            if (aVar2 != null) {
                                aVar2.a(wepkgDownloadProcessTask);
                            }
                        }
                    });
                }
            });
            return;
        }
        final a aVar3 = aVar;
        wepkgDownloadProcessTask.iMD = new Runnable() {
            public final void run() {
                if (aVar3 != null) {
                    aVar3.a(wepkgDownloadProcessTask);
                }
                wepkgDownloadProcessTask.SN();
            }
        };
        wepkgDownloadProcessTask.SM();
        WepkgMainProcessService.a(wepkgDownloadProcessTask);
    }

    public static List<WepkgPreloadFile> KJ(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = 4001;
        wepkgCrossProcessTask.sqr.sqL = str;
        if (ab.bJb()) {
            wepkgCrossProcessTask.PM();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        return wepkgCrossProcessTask.squ;
    }

    public static void a(String str, String str2, String str3, final a aVar) {
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = 4002;
        wepkgCrossProcessTask.sqt.sqL = str;
        wepkgCrossProcessTask.sqt.sqw = str2;
        wepkgCrossProcessTask.sqt.filePath = str3;
        wepkgCrossProcessTask.sqt.sqM = false;
        if (ab.bJb()) {
            d.vL().D(new Runnable() {
                public final void run() {
                    wepkgCrossProcessTask.PM();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                }
            });
            return;
        }
        wepkgCrossProcessTask.iMD = new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.SN();
            }
        };
        wepkgCrossProcessTask.SM();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static List<WepkgPreloadFile> KK(String str) {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = 4003;
        wepkgCrossProcessTask.sqr.sqL = str;
        if (ab.bJb()) {
            wepkgCrossProcessTask.PM();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        return wepkgCrossProcessTask.squ;
    }
}
