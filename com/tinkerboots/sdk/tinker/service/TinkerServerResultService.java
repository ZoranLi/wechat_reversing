package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tinkerboots.sdk.b.c;
import com.tinkerboots.sdk.tinker.a.a;
import java.io.File;

public class TinkerServerResultService extends DefaultTinkerResultService {
    private static boolean xmv = false;
    private static a xmw = null;

    public final void a(com.tencent.tinker.lib.service.a aVar) {
        if (aVar == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
            return;
        }
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerServerResultService", "receive result: %s", new Object[]{aVar.toString()});
        b.hq(getApplicationContext());
        if (aVar.fHO) {
            com.tencent.tinker.lib.e.a.i("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
            DefaultTinkerResultService.O(new File(aVar.xgi));
            if (!b(aVar)) {
                com.tencent.tinker.lib.e.a.i("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
                return;
            } else if (xmv) {
                com.tencent.tinker.lib.e.a.i("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
                c.b bVar = new c.b(getApplicationContext(), new c.a(this) {
                    final /* synthetic */ TinkerServerResultService xmx;

                    {
                        this.xmx = r1;
                    }

                    public final void QH() {
                        TinkerServerResultService.restartProcess();
                    }
                });
                return;
            } else {
                return;
            }
        }
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
    }

    static void restartProcess() {
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
        Process.killProcess(Process.myPid());
    }
}
