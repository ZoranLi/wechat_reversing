package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.webview.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;
import com.tencent.mm.plugin.webview.wepkg.model.c;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public class WepkgProcessPreloadService extends Service {
    private static Messenger iJO = new Messenger(spU);
    private static ServiceConnection iJR;
    private static Messenger lxZ;
    private static final Handler mHandler = new Handler(d.vL().nJF.getLooper()) {
        public final void handleMessage(Message message) {
            try {
                Messenger messenger = message.replyTo;
                Message obtain = Message.obtain();
                obtain.what = message.what;
                Bundle data = message.getData();
                switch (data.getInt("call_cmd_type")) {
                    case 0:
                        WepkgProcessPreloadService.a(data.getString("call_raw_url"), messenger, obtain);
                        return;
                    case 1:
                        WepkgProcessPreloadService.b(data.getString("call_pkg_id"), messenger, obtain);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    };
    private static final LinkedList<Message> spR = new LinkedList();
    private static f<Integer, c> spT = new f(10);
    private static final Handler spU = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            c cVar = (c) WepkgProcessPreloadService.spT.remove(Integer.valueOf(message.what));
            if (cVar != null) {
                cVar.m(message);
                return;
            }
            w.e("MicroMsg.Wepkg.WepkgProcessPreloadService", "receive client msg, get null task by id %s", new Object[]{Integer.valueOf(r1)});
        }
    };
    private static final Messenger spV = new Messenger(mHandler);

    static /* synthetic */ void a(String str, final Messenger messenger, final Message message) {
        w.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "preload entrance url:%s", new Object[]{str});
        if (WepkgMainProcessService.Ux()) {
            w.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "preload wepkg");
            g.KC(str);
            a(messenger, message);
            return;
        }
        w.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "prestart WepkgMainProcessService and preload wepkg");
        d.a(str, new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                if ((baseWepkgProcessTask instanceof WepkgCrossProcessTask) && baseWepkgProcessTask.fDU) {
                    final String str = ((WepkgCrossProcessTask) baseWepkgProcessTask).sqv;
                    d.vL().D(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 spY;

                        public final void run() {
                            g.KC(str);
                            WepkgProcessPreloadService.a(messenger, message);
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ void b(String str, Messenger messenger, Message message) {
        String str2 = "";
        if (!(b.sru.KM(str) == null || b.sru.KM(str).sqr == null)) {
            str2 = b.sru.KM(str).sqr.version;
        }
        w.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "pkgid:%s used_version:%s", new Object[]{str, str2});
        Bundle data = message.getData();
        data.putString("used_wepkg_version", str2);
        message.setData(data);
        a(messenger, message);
    }

    static /* synthetic */ void bAx() {
        if (lxZ != null) {
            synchronized (spR) {
                Iterator it = spR.iterator();
                while (it.hasNext()) {
                    l((Message) it.next());
                }
                spR.clear();
            }
        }
    }

    private static final void a(Messenger messenger, Message message) {
        if (messenger != null) {
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                w.e("MicroMsg.Wepkg.WepkgProcessPreloadService", "messenger callback err:%s", new Object[]{e.getMessage()});
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return spV.getBinder();
    }

    public static synchronized void a(c cVar, Bundle bundle) {
        synchronized (WepkgProcessPreloadService.class) {
            spT.put(Integer.valueOf(cVar.hashCode()), cVar);
            Message obtain = Message.obtain();
            obtain.what = cVar.hashCode();
            obtain.setData(bundle);
            l(obtain);
        }
    }

    private static void l(Message message) {
        message.replyTo = iJO;
        if (lxZ == null) {
            if (iJR == null) {
                iJR = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        WepkgProcessPreloadService.lxZ = new Messenger(iBinder);
                        WepkgProcessPreloadService.bAx();
                        w.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "onServiceConnected(%s)", new Object[]{ab.um()});
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        WepkgProcessPreloadService.lxZ = null;
                        w.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "onServiceDisconnected(%s)", new Object[]{ab.um()});
                    }
                };
            }
            w.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "try bind WepkgProcessPreloadService");
            Context context = ab.getContext();
            context.bindService(new Intent(context, WepkgProcessPreloadService.class), iJR, 1);
            synchronized (spR) {
                spR.add(message);
            }
            return;
        }
        try {
            lxZ.send(message);
        } catch (RemoteException e) {
            w.e("MicroMsg.Wepkg.WepkgProcessPreloadService", e.getMessage());
        }
    }
}
