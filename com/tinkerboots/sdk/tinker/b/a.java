package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.e.c;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class a extends com.tencent.tinker.lib.c.a {
    public a(Context context) {
        super(context);
    }

    public final void a(File file, int i, long j) {
        super.a(file, i, j);
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new IdleHandler(this) {
            final /* synthetic */ a xmu;

            {
                this.xmu = r1;
            }

            public final boolean queueIdle() {
                c.hu(this.xmu.context).cgS();
                return false;
            }
        });
    }

    public final void a(Throwable th, int i) {
        super.a(th, i);
    }

    public final void a(String str, String str2, File file, String str3) {
        super.a(str, str2, file, str3);
    }

    public final void a(File file, int i, boolean z) {
        super.a(file, i, z);
        if (i == 1) {
            d dVar = com.tencent.tinker.lib.d.a.hp(this.context).xgv;
            if (dVar.xgA != null && "00000000000000000000000000000000".equals(dVar.xgA)) {
                com.tencent.tinker.lib.e.a.e("Tinker.ServerLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.hG(this.context);
            }
        }
    }
}
