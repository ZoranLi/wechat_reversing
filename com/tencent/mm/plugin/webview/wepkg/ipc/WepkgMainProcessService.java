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
import android.os.Parcel;
import com.tencent.mm.plugin.webview.wepkg.ipc.a.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WepkgMainProcessService extends Service {
    private static ServiceConnection iJR;
    private static Map<Integer, WeakReference<WepkgMainProcessTask>> iJU = new ConcurrentHashMap();
    private static Handler iJV = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            int i = message.what;
            WepkgMainProcessTask Z = WepkgMainProcessService.Y(message.getData());
            WepkgMainProcessTask wM = WepkgMainProcessService.wM(i);
            if (wM == null) {
                w.e("MicroMsg.Wepkg.WepkgMainProcessService", "receive client msg, get null task by id %s", new Object[]{Integer.valueOf(i)});
                return;
            }
            WepkgMainProcessService.a(Z, wM);
            wM.SK();
        }
    };
    private static Messenger iJW = new Messenger(iJV);
    private static a spQ;
    private static final LinkedList<Message> spR = new LinkedList();
    private final Messenger iJO = new Messenger(this.mHandler);
    private final Handler mHandler = new Handler(this, d.vL().nJF.getLooper()) {
        final /* synthetic */ WepkgMainProcessService spS;

        public final void handleMessage(Message message) {
            WepkgMainProcessTask Z = WepkgMainProcessService.Y(message.getData());
            Messenger messenger = message.replyTo;
            int i = message.what;
            Z.iKy = messenger;
            Z.mTaskId = i;
            Z.PM();
        }
    };
    private final a spP = new a(this) {
        final /* synthetic */ WepkgMainProcessService spS;

        {
            this.spS = r1;
        }

        public final void k(Message message) {
            this.spS.iJO.send(message);
        }

        public final void v(Bundle bundle) {
            WepkgMainProcessService.Y(bundle).PM();
        }
    };

    static /* synthetic */ void Sy() {
        if (spQ != null) {
            synchronized (spR) {
                Iterator it = spR.iterator();
                while (it.hasNext()) {
                    l((Message) it.next());
                }
                spR.clear();
            }
        }
    }

    static /* synthetic */ WepkgMainProcessTask wM(int i) {
        if (iJU.containsKey(Integer.valueOf(i))) {
            return ((WeakReference) iJU.get(Integer.valueOf(i))).get() == null ? null : (WepkgMainProcessTask) ((WeakReference) iJU.get(Integer.valueOf(i))).get();
        } else {
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.spP;
    }

    public static void a(WepkgMainProcessTask wepkgMainProcessTask) {
        iJU.put(Integer.valueOf(wepkgMainProcessTask.hashCode()), new WeakReference(wepkgMainProcessTask));
        Message obtain = Message.obtain();
        obtain.what = wepkgMainProcessTask.hashCode();
        obtain.replyTo = iJW;
        obtain.setData(c(wepkgMainProcessTask));
        l(obtain);
    }

    public static boolean b(WepkgMainProcessTask wepkgMainProcessTask) {
        Bundle c = c(wepkgMainProcessTask);
        if (!s(c)) {
            return false;
        }
        a(Y(c), wepkgMainProcessTask);
        wepkgMainProcessTask.SK();
        return true;
    }

    private static boolean s(Bundle bundle) {
        try {
            spQ.v(bundle);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void l(Message message) {
        message.replyTo = iJW;
        if (spQ == null) {
            Sx();
            synchronized (spR) {
                spR.add(message);
            }
            return;
        }
        try {
            spQ.k(message);
        } catch (Exception e) {
            w.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
        }
    }

    private static void Sx() {
        if (iJR == null) {
            iJR = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    WepkgMainProcessService.spQ = a.X(iBinder);
                    WepkgMainProcessService.Sy();
                    w.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceConnected(%s)", new Object[]{ab.um()});
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    WepkgMainProcessService.spQ = null;
                    WepkgMainProcessService.Sx();
                    w.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceDisconnected(%s)", new Object[]{ab.um()});
                }
            };
        }
        w.i("MicroMsg.Wepkg.WepkgMainProcessService", "tryBindService");
        Context context = ab.getContext();
        context.bindService(new Intent(context, WepkgMainProcessService.class), iJR, 1);
    }

    public static boolean Ux() {
        if (spQ != null) {
            return true;
        }
        return false;
    }

    static Bundle c(WepkgMainProcessTask wepkgMainProcessTask) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("task_object", wepkgMainProcessTask);
        return bundle;
    }

    private static WepkgMainProcessTask Y(Bundle bundle) {
        bundle.setClassLoader(WepkgMainProcessTask.class.getClassLoader());
        return (WepkgMainProcessTask) bundle.getParcelable("task_object");
    }

    private static void a(WepkgMainProcessTask wepkgMainProcessTask, WepkgMainProcessTask wepkgMainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        wepkgMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        wepkgMainProcessTask2.f(obtain);
        obtain.recycle();
    }
}
