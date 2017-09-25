package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.Log.LogCallback;

public final class a extends c {
    public final void execute(e eVar) {
        if (!k.dx("wcdb")) {
            k.b("wcdb", getClass().getClassLoader());
        }
        Log.setLogger(new LogCallback(this) {
            final /* synthetic */ a sBg;

            {
                this.sBg = r1;
            }

            public final void println(int i, String str, String str2) {
                com.tencent.mm.sdk.platformtools.w.a bIO = w.bIO();
                int myPid = Process.myPid();
                int myTid = Process.myTid();
                switch (i) {
                    case 2:
                        bIO.logV(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 3:
                        bIO.logD(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 4:
                        bIO.logI(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 5:
                        bIO.logW(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 6:
                        bIO.logE(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 7:
                        bIO.logF(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final String name() {
        return "boot-db-prepare";
    }
}
