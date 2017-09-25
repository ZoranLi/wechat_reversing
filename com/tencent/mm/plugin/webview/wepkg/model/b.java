package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public class b {
    private static b spZ = null;

    class AnonymousClass2 extends c {
        final /* synthetic */ b sqa;
        final /* synthetic */ String sqb;

        AnonymousClass2(b bVar, String str) {
            this.sqa = bVar;
            this.sqb = str;
        }

        public final void m(Message message) {
            final String string = message.getData().getString("used_wepkg_version");
            d.vL().D(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 sqd;

                public final void run() {
                    if (!bg.mA(string)) {
                        return;
                    }
                    if (g.KF(d.KN(this.sqd.sqb))) {
                        com.tencent.mm.plugin.webview.wepkg.a.d.bAp().Kq(this.sqd.sqb);
                        com.tencent.mm.plugin.webview.wepkg.a.b.bAo().Kq(this.sqd.sqb);
                        w.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg success. pkgid:%s", new Object[]{this.sqd.sqb});
                        return;
                    }
                    w.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg fail. pkgid:%s", new Object[]{this.sqd.sqb});
                }
            });
        }
    }

    public static b bAy() {
        if (spZ == null) {
            synchronized (b.class) {
                spZ = new b();
            }
        }
        return spZ;
    }

    public final synchronized void bAz() {
        boolean z = true;
        synchronized (this) {
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("we_pkg_sp", 0);
            if (System.currentTimeMillis() - sharedPreferences.getLong("clean_wepkg_time", 0) <= 86400000) {
                z = false;
            }
            w.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg, allowClean:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                sharedPreferences.edit().putLong("clean_wepkg_time", System.currentTimeMillis()).commit();
                e.post(new Runnable(this) {
                    final /* synthetic */ b sqa;

                    {
                        this.sqa = r1;
                    }

                    public final void run() {
                        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.ou = 2005;
                        if (ab.bJb()) {
                            wepkgCrossProcessTask.PM();
                        } else {
                            WepkgMainProcessService.b(wepkgCrossProcessTask);
                        }
                        List<WepkgVersion> list = wepkgCrossProcessTask.sqs;
                        if (bg.bV(list)) {
                            w.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
                            return;
                        }
                        w.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", new Object[]{Integer.valueOf(list.size())});
                        for (WepkgVersion wepkgVersion : list) {
                            if (wepkgVersion != null) {
                                b bVar = this.sqa;
                                String str = wepkgVersion.sqL;
                                if (!bg.mA(str)) {
                                    c anonymousClass2 = new AnonymousClass2(bVar, str);
                                    Bundle bundle = new Bundle(1);
                                    bundle.putInt("call_cmd_type", 1);
                                    bundle.putString("call_pkg_id", str);
                                    WepkgProcessPreloadService.a(anonymousClass2, bundle);
                                }
                            }
                        }
                    }
                }, "clean_wepkg");
            }
        }
    }
}
