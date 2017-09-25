package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelmulti.n.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class e implements m, c {
    private int laN = 0;
    public final b mLp;
    private long mLq;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ e mLr;
        final /* synthetic */ Context val$context;

        public AnonymousClass2(e eVar, Context context) {
            this.mLr = eVar;
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            g.af(this.val$context, this.mLr.mLp.mLQ);
            if (this.mLr.mLp.mLM.intValue() == 3) {
                com.tencent.mm.plugin.report.service.g.oUh.a(614, 57, 1, false);
            }
        }
    }

    class AnonymousClass3 implements a {
        final /* synthetic */ e mLr;
        final /* synthetic */ com.tencent.tinker.lib.d.a mLs;
        final /* synthetic */ Context val$context;

        public AnonymousClass3(e eVar, Context context, com.tencent.tinker.lib.d.a aVar) {
            this.mLr = eVar;
            this.val$context = context;
            this.mLs = aVar;
        }

        public final void bj(boolean z) {
            if (!z) {
                com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
                ShareTinkerInternals.hG(this.val$context);
                this.mLs.aDl();
                Process.killProcess(Process.myPid());
            }
        }
    }

    public e(b bVar) {
        this.mLp = bVar;
        com.tencent.mm.sdk.f.e.a(this);
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.a(this);
    }

    public final void aDh() {
        if (!h.getExternalStorageState().equals("mounted")) {
            w.e("Tinker.SyncResponseProcessor", "no sdcard.");
            com.tencent.mm.plugin.report.service.g.oUh.a(614, 50, 1, false);
        } else if (f.G((long) this.mLp.fileSize)) {
            com.tencent.mm.plugin.report.service.g.oUh.a(614, 2, 1, false);
            if (this.mLp.mLM.intValue() == 3 && this.laN == 1) {
                com.tencent.mm.plugin.report.service.g.oUh.a(614, 56, 1, false);
            }
            com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
            aVar.tL(this.mLp.mLO);
            aVar.tN(this.mLp.mLQ);
            aVar.tO(this.mLp.mLP);
            aVar.dn(false);
            aVar.dp(true);
            aVar.la(0);
            aVar.do(false);
            this.mLq = com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa);
            w.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[]{Long.valueOf(this.mLq)});
            if (this.laN == 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(614, 2, 1, false);
                if (am.isWifi(ab.getContext())) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(614, 7, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(614, 8, 1, false);
                }
            }
        } else {
            w.e("Tinker.SyncResponseProcessor", "sdcard is full.");
            com.tencent.mm.plugin.report.service.g.oUh.a(614, 51, 1, false);
        }
    }

    public final void x(Runnable runnable) {
        if (runnable instanceof com.tencent.mm.plugin.hp.d.a) {
            com.tencent.mm.plugin.hp.d.a aVar = (com.tencent.mm.plugin.hp.d.a) runnable;
            com.tencent.tinker.lib.e.a.d("Tinker.SyncResponseProcessor", "hotpatch download url=%s, file=%s, failed=%b", new Object[]{aVar.url, aVar.ihX, Boolean.valueOf(aVar.hrm)});
            if (aVar.hrm) {
                if (this.laN == 0) {
                    b.nZ(2);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(614, 6, 1, false);
                }
                if (this.laN < 2) {
                    w.i("Tinker.SyncResponseProcessor", "retry download! mRetryTime:%d", new Object[]{Integer.valueOf(this.laN)});
                    aDh();
                    com.tencent.mm.plugin.report.service.g.oUh.a(614, 4, 1, false);
                    this.laN++;
                    return;
                }
                return;
            }
            b.nY(2);
            Context context = ab.getContext();
            File file = new File(aVar.ihX);
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            if (this.mLp.mLM.intValue() != 2 || shareSecurityCheck.aa(file)) {
                File[] listFiles = com.tencent.mm.plugin.hp.d.c.ct(context).listFiles();
                if (listFiles != null) {
                    String name = file.getName();
                    for (File file2 : listFiles) {
                        if (!file2.getName().equals(name)) {
                            SharePatchFileUtil.W(file2);
                        }
                    }
                }
                switch (this.mLp.mLM.intValue()) {
                    case 1:
                        w.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                        break;
                    case 2:
                        com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
                        com.tencent.tinker.lib.d.c.bJ(context, file.getAbsolutePath());
                        break;
                    case 3:
                        String aDs = this.mLp.aDs();
                        if (bg.mA(aDs)) {
                            if (bg.mA(this.mLp.aDr())) {
                                aDs = context.getString(R.l.eZe);
                            } else {
                                aDs = this.mLp.aDr();
                            }
                        }
                        com.tencent.mm.plugin.hp.a.a.c(context, file.getAbsolutePath(), this.mLp.mLR, aDs, this.mLp.mLQ);
                        break;
                }
                g.ag(context, this.mLp.aDt());
                return;
            }
            com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
            b.nZ(2);
            com.tencent.mm.plugin.report.service.g.oUh.a(614, 31, 1, false);
        }
    }

    public final void onTaskStarted(long j, String str) {
    }

    public final void c(long j, String str, boolean z) {
        w.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[]{Long.valueOf(j), str, Boolean.valueOf(z)});
        if (this.mLq != j) {
            w.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[]{Long.valueOf(this.mLq), Long.valueOf(j)});
            return;
        }
        b.nY(2);
        Context context = ab.getContext();
        File file = new File(str);
        ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
        if (this.mLp.mLM.intValue() != 2 || shareSecurityCheck.aa(file)) {
            File[] listFiles = com.tencent.mm.plugin.hp.d.c.ct(context).listFiles();
            if (listFiles != null) {
                String name = file.getName();
                for (File file2 : listFiles) {
                    if (!file2.getName().equals(name)) {
                        SharePatchFileUtil.W(file2);
                    }
                }
            }
            switch (this.mLp.mLM.intValue()) {
                case 1:
                    w.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                    break;
                case 2:
                    com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
                    com.tencent.tinker.lib.d.c.bJ(context, file.getAbsolutePath());
                    break;
                case 3:
                    String aDs = this.mLp.aDs();
                    if (bg.mA(aDs)) {
                        if (bg.mA(this.mLp.aDr())) {
                            aDs = context.getString(R.l.eZe);
                        } else {
                            aDs = this.mLp.aDr();
                        }
                    }
                    com.tencent.mm.plugin.hp.a.a.c(context, file.getAbsolutePath(), this.mLp.mLR, aDs, this.mLp.mLQ);
                    break;
            }
            g.ag(context, this.mLp.aDt());
            return;
        }
        com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
        b.nZ(2);
        com.tencent.mm.plugin.report.service.g.oUh.a(614, 31, 1, false);
        if (this.mLp.mLM.intValue() == 3) {
            com.tencent.mm.plugin.report.service.g.oUh.a(614, 54, 1, false);
        }
    }

    public final void d(long j, int i, boolean z) {
        if (this.mLq != j) {
            w.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[]{Long.valueOf(this.mLq), Long.valueOf(j)});
            return;
        }
        if (this.laN == 0) {
            b.nZ(2);
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.a(614, 6, 1, false);
        }
        if (this.laN < 2) {
            w.i("Tinker.SyncResponseProcessor", "retry download! mRetryTime:%d", new Object[]{Integer.valueOf(this.laN)});
            aDh();
            com.tencent.mm.plugin.report.service.g.oUh.a(614, 4, 1, false);
            this.laN++;
        }
    }

    public final void onTaskRemoved(long j) {
    }

    public final void onTaskPaused(long j) {
    }

    public final void bg(long j) {
    }

    public final void j(long j, String str) {
    }
}
