package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.e.a.mb;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class PluginRecovery extends d implements c {
    private com.tencent.mm.sdk.b.c<mb> hOE = new com.tencent.mm.sdk.b.c<mb>(this) {
        final /* synthetic */ PluginRecovery hOG;

        {
            this.hOG = r2;
            this.usg = mb.class.getName().hashCode();
        }

        private static boolean a(mb mbVar) {
            Context context;
            Builder builder;
            switch (mbVar.fTu.action) {
                case 1:
                    context = ab.getContext();
                    builder = new Builder();
                    builder.wQu = WXRecoveryHandleService.class.getName();
                    builder.wQv = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = "0x26050D40";
                    builder.wQq = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
                    builder.mry = WXUtil.fw(context);
                    RecoveryLogic.a(context, builder.cdA(), new RecoveryContext());
                    break;
                case 2:
                    a.If();
                    break;
                case 3:
                    context = ab.getContext();
                    builder = new Builder();
                    builder.wQu = WXRecoveryHandleService.class.getName();
                    builder.wQv = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = "0x26050D40";
                    builder.wQq = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
                    builder.mry = WXUtil.fw(context);
                    RecoveryLogic.a(context, builder.cdA(), new RecoveryContext());
                    break;
            }
            return false;
        }
    };
    private RecoveryLogImpl hOF = new RecoveryLogImpl(this) {
        final /* synthetic */ PluginRecovery hOG;

        {
            this.hOG = r1;
        }

        public final void d(String str, String str2, Object... objArr) {
            w.d(str, str2, objArr);
        }

        public final void v(String str, String str2, Object... objArr) {
            w.v(str, str2, objArr);
        }

        public final void i(String str, String str2, Object... objArr) {
            w.i(str, str2, objArr);
        }

        public final void w(String str, String str2, Object... objArr) {
            w.w(str, str2, objArr);
        }

        public final void e(String str, String str2, Object... objArr) {
            w.e(str, str2, objArr);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            w.printErrStackTrace(str, th, str2, objArr);
        }

        public final void Ie() {
        }
    };
    private BroadcastReceiver tF = new BroadcastReceiver(this) {
        final /* synthetic */ PluginRecovery hOG;

        {
            this.hOG = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            if ("com.tecent.recovery.intent.action.LOG".equals(intent.getAction())) {
                this.hOG.postLog();
            } else if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(intent.getAction())) {
                this.hOG.postReport();
            }
        }
    };

    public void installed() {
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    }

    public void configure(e eVar) {
        RecoveryLog.a(this.hOF);
        if (eVar.ej(":sandbox")) {
            long currentTimeMillis = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tecent.recovery.intent.action.LOG");
            intentFilter.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
            ab.getContext().registerReceiver(this.tF, intentFilter);
            File file = new File(WXConstantsRecovery.wQG);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "version.info");
            if (file2.exists()) {
                file2.delete();
            }
            try {
                FileOp.k(file2.getAbsolutePath(), Integer.toHexString(com.tencent.mm.protocal.d.sYN).getBytes());
            } catch (Exception e) {
            }
            w.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void execute(e eVar) {
    }

    public void onAccountInitialized(f fVar) {
        this.hOE.bIy();
    }

    public void onAccountRelease() {
        this.hOE.dead();
    }

    public void postLog() {
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ PluginRecovery hOG;

            {
                this.hOG = r1;
            }

            public final void run() {
                w.i("MicroMsg.Recovery.PluginRecovery", "postLog");
                a.If();
            }
        }, "RecoveryWriteLogThread");
    }

    public void postReport() {
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ PluginRecovery hOG;

            {
                this.hOG = r1;
            }

            public final void run() {
                w.i("MicroMsg.Recovery.PluginRecovery", "postReport");
                b.Ig();
            }
        }, "RecoveryReportStatusThread");
    }
}
