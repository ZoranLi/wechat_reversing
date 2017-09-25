package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.e.a.ju;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public final class d extends c<ju> {
    public static volatile String fWY;
    private static volatile long sqf;
    public static volatile long sqg;
    private static Set<String> sqh = new HashSet();

    private static class a implements Runnable {
        private final ju sqj;

        public a(ju juVar) {
            this.sqj = juVar;
        }

        public final void run() {
            d.b(this.sqj);
        }
    }

    public d() {
        this.usg = ju.class.getName().hashCode();
    }

    private boolean a(ju juVar) {
        switch (juVar.fQi.type) {
            case 0:
            case 1:
                String str = "MicroMsg.Wepkg.NotifyGameWebviewOperationListener";
                String str2 = "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s";
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(juVar.fQi.type);
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Integer.valueOf(juVar.hashCode());
                objArr[3] = Long.valueOf(Thread.currentThread().getId());
                objArr[4] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                w.i(str, str2, objArr);
                String str3 = "";
                try {
                    str3 = juVar.fQi.intent.getStringExtra("rawUrl");
                } catch (Exception e) {
                }
                synchronized (this) {
                    if (!bg.mz(fWY).equalsIgnoreCase(str3)) {
                        fWY = str3;
                        sqf = System.currentTimeMillis();
                        sqg = System.currentTimeMillis();
                        if (ab.bJb()) {
                            b.srv = g.sW().sG();
                        }
                        if (!com.tencent.mm.plugin.webview.wepkg.utils.d.KR(str3)) {
                            w.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + b.srv);
                            b(juVar);
                            break;
                        }
                        w.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[]{com.tencent.mm.plugin.webview.wepkg.utils.d.KO(str3)});
                        juVar.fQi.group = com.tencent.mm.a.g.n(bg.mz(str3).getBytes()) + "_" + System.currentTimeMillis();
                        af.f(new a(juVar), 500);
                        c anonymousClass1 = new c(this, juVar) {
                            final /* synthetic */ d sqi;

                            public final void m(Message message) {
                                w.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload complete. total time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - d.sqg)});
                                if (this.sqe != null) {
                                    Object obj = this.sqe.get();
                                    if (obj instanceof ju) {
                                        ju juVar = (ju) obj;
                                        if (juVar != null) {
                                            d.b(juVar);
                                        } else {
                                            w.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "NotifyGameWebviewOperationEvent instance from messager reply is null");
                                        }
                                    }
                                }
                            }
                        };
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("call_cmd_type", 0);
                        bundle.putString("call_raw_url", str3);
                        WepkgProcessPreloadService.a(anonymousClass1, bundle);
                        break;
                    }
                    w.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
                    break;
                }
        }
        return false;
    }

    public static synchronized void b(ju juVar) {
        synchronized (d.class) {
            af.f(new Runnable() {
                public final void run() {
                    w.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[]{Integer.valueOf(1000), d.fWY});
                    d.fWY = "";
                }
            }, 1000);
            if (juVar != null) {
                String str;
                if (!bg.mA(juVar.fQi.group)) {
                    if (sqh.contains(juVar.fQi.group)) {
                        sqh.remove(juVar.fQi.group);
                    } else {
                        sqh.add(juVar.fQi.group);
                    }
                }
                Context context = juVar.fQi.context;
                if (context == null) {
                    context = ab.getContext();
                }
                if (juVar.fQi.intent == null) {
                    juVar.fQi.intent = new Intent();
                }
                juVar.fQi.intent.putExtra("disable_wepkg", b.srv);
                switch (juVar.fQi.type) {
                    case 0:
                        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.game.GameWebViewUI", juVar.fQi.intent);
                        break;
                    case 1:
                        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.TransparentWebViewUI", juVar.fQi.intent);
                        break;
                }
                w.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - sqf)});
                String str2 = "";
                try {
                    str2 = juVar.fQi.intent.getStringExtra("rawUrl");
                    juVar.fQi.context = null;
                    str = str2;
                } catch (Exception e) {
                    str = str2;
                }
                com.tencent.mm.plugin.webview.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.webview.wepkg.utils.d.KO(str), null, -1, r6, null);
            }
        }
    }
}
