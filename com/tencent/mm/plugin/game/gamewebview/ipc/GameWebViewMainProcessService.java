package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;
import com.tencent.mm.plugin.game.gamewebview.model.e;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GameWebViewMainProcessService extends Service {
    private static ServiceConnection iJR;
    private static final LinkedList<Parcel> iJS = new LinkedList();
    private static Set<Object> iJT = new HashSet();
    private static Map<String, WeakReference<GWMainProcessTask>> iJU = new ConcurrentHashMap();
    private static Handler iJV = new Handler() {
        public final void handleMessage(Message message) {
            GWMainProcessTask d = GameWebViewMainProcessService.c(message.getData(), false);
            GWMainProcessTask xx = GameWebViewMainProcessService.xx(d.iKz);
            if (xx == null) {
                w.e("MicroMsg.GameWebViewMainProcessService", "receive client msg, get null task by id %s", new Object[]{d.iKz});
                return;
            }
            GameWebViewMainProcessService.a(d, xx);
            xx.SK();
        }
    };
    private static Messenger iJW = new Messenger(iJV);
    private static b mjA;
    private final Messenger iJO = new Messenger(this.mHandler);
    private final Handler mHandler = new Handler(this, d.vL().nJF.getLooper()) {
        final /* synthetic */ GameWebViewMainProcessService mjB;

        public final void handleMessage(Message message) {
            GameWebViewMainProcessService.c(message.getData(), true).PM();
        }
    };
    private com.tencent.mm.plugin.game.gamewebview.model.d mjx;
    private e mjy;
    private final a mjz = new a(this) {
        final /* synthetic */ GameWebViewMainProcessService mjB;

        {
            this.mjB = r1;
        }

        public final void u(Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            this.mjB.iJO.send(obtain);
        }

        public final void v(Bundle bundle) {
            GameWebViewMainProcessService.c(bundle, false).PM();
        }
    };

    static /* synthetic */ void SA() {
        Iterator it = iJT.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static /* synthetic */ void Sy() {
        if (mjA != null) {
            synchronized (iJS) {
                Iterator it = iJS.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
                    parcel.setDataPosition(0);
                    bundle.readFromParcel(parcel);
                    t(bundle);
                    parcel.recycle();
                }
                iJS.clear();
            }
        }
    }

    static /* synthetic */ void Sz() {
        Iterator it = iJT.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static /* synthetic */ GWMainProcessTask xx(String str) {
        if (iJU.containsKey(str)) {
            return ((WeakReference) iJU.get(str)).get() == null ? null : (GWMainProcessTask) ((WeakReference) iJU.get(str)).get();
        } else {
            return null;
        }
    }

    public void onCreate() {
        w.i("MicroMsg.GameWebViewMainProcessService", "onCreate");
        if (h.vG().uV()) {
            this.mjx = new com.tencent.mm.plugin.game.gamewebview.model.d();
            f.bwY().a(this.mjx);
        }
        this.mjy = new e();
        com.tencent.mm.plugin.downloader.model.e.akM();
        b.a(this.mjy);
    }

    public void onDestroy() {
        w.i("MicroMsg.GameWebViewMainProcessService", "onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.e.akM();
        b.b(this.mjy);
        if (ap.zb()) {
            f.bwY().b(this.mjx);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mjz;
    }

    public static void a(GWMainProcessTask gWMainProcessTask) {
        iJU.put(gWMainProcessTask.iKz, new WeakReference(gWMainProcessTask));
        t(a(gWMainProcessTask, true));
    }

    public static boolean b(GWMainProcessTask gWMainProcessTask) {
        Bundle a = a(gWMainProcessTask, false);
        if (!s(a)) {
            return false;
        }
        a(c(a, false), gWMainProcessTask);
        gWMainProcessTask.SK();
        return true;
    }

    private static boolean s(Bundle bundle) {
        try {
            mjA.v(bundle);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void t(Bundle bundle) {
        if (mjA == null) {
            Sx();
            synchronized (iJS) {
                LinkedList linkedList = iJS;
                Parcel obtain = Parcel.obtain();
                bundle.writeToParcel(obtain, 0);
                linkedList.add(obtain);
            }
            return;
        }
        try {
            mjA.u(bundle);
        } catch (Exception e) {
            w.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
        }
    }

    private static void Sx() {
        if (iJR == null) {
            iJR = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    GameWebViewMainProcessService.mjA = a.P(iBinder);
                    GameWebViewMainProcessService.Sy();
                    GameWebViewMainProcessService.Sz();
                    w.i("MicroMsg.GameWebViewMainProcessService", "onServiceConnected(%s)", new Object[]{ab.um()});
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    GameWebViewMainProcessService.mjA = null;
                    GameWebViewMainProcessService.SA();
                    GameWebViewMainProcessService.Sx();
                    w.i("MicroMsg.GameWebViewMainProcessService", "onServiceDisconnected(%s)", new Object[]{ab.um()});
                }
            };
        }
        w.i("MicroMsg.GameWebViewMainProcessService", "tryBindService");
        Context context = ab.getContext();
        context.bindService(new Intent(context, GameWebViewMainProcessService.class), iJR, 1);
    }

    private static void a(GWMainProcessTask gWMainProcessTask, GWMainProcessTask gWMainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        gWMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        gWMainProcessTask2.f(obtain);
        obtain.recycle();
    }

    static Bundle a(GWMainProcessTask gWMainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", gWMainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", iJW);
        }
        bundle.putString("task_id", gWMainProcessTask.iKz);
        return bundle;
    }

    private static GWMainProcessTask c(Bundle bundle, boolean z) {
        bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
        GWMainProcessTask gWMainProcessTask = (GWMainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            gWMainProcessTask.iKy = (Messenger) bundle.getParcelable("task_client");
        }
        gWMainProcessTask.iKz = bundle.getString("task_id");
        return gWMainProcessTask;
    }
}
