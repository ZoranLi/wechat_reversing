package com.tencent.mm.plugin.appbrand.ipc;

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
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService extends Service {
    private static c iJQ;
    private static ServiceConnection iJR;
    private static final LinkedList<Parcel> iJS = new LinkedList();
    private static Set<a> iJT = new HashSet();
    private static Map<String, WeakReference<MainProcessTask>> iJU = new ConcurrentHashMap();
    private static Handler iJV = new Handler() {
        public final void handleMessage(Message message) {
            MainProcessTask b = AppBrandMainProcessService.a(message.getData(), false);
            MainProcessTask oX = AppBrandMainProcessService.oX(b.iKz);
            if (oX == null) {
                w.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[]{b.iKz});
                return;
            }
            AppBrandMainProcessService.a(b, oX);
            oX.SK();
        }
    };
    private static Messenger iJW = new Messenger(iJV);
    private final Messenger iJO = new Messenger(this.mHandler);
    private final com.tencent.mm.plugin.appbrand.ipc.c.a iJP = new com.tencent.mm.plugin.appbrand.ipc.c.a(this) {
        final /* synthetic */ AppBrandMainProcessService iJX;

        {
            this.iJX = r1;
        }

        public final void u(Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            this.iJX.iJO.send(obtain);
        }

        public final void v(Bundle bundle) {
            AppBrandMainProcessService.a(bundle, false).PM();
        }
    };
    private final Handler mHandler = new Handler(this, d.vL().nJF.getLooper()) {
        final /* synthetic */ AppBrandMainProcessService iJX;

        public final void handleMessage(Message message) {
            AppBrandMainProcessService.a(message.getData(), true).PM();
        }
    };

    public static class a {
        public void onServiceConnected() {
        }

        public void PC() {
        }
    }

    static /* synthetic */ void SA() {
        for (a PC : iJT) {
            PC.PC();
        }
    }

    static /* synthetic */ void Sy() {
        if (iJQ != null) {
            synchronized (iJS) {
                Iterator it = iJS.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(MainProcessTask.class.getClassLoader());
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
        for (a onServiceConnected : iJT) {
            onServiceConnected.onServiceConnected();
        }
    }

    static /* synthetic */ MainProcessTask oX(String str) {
        if (iJU.containsKey(str)) {
            return ((WeakReference) iJU.get(str)).get() == null ? null : (MainProcessTask) ((WeakReference) iJU.get(str)).get();
        } else {
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.iJP;
    }

    public static void a(MainProcessTask mainProcessTask) {
        iJU.put(mainProcessTask.iKz, new WeakReference(mainProcessTask));
        t(a(mainProcessTask, true));
    }

    public static boolean b(MainProcessTask mainProcessTask) {
        Bundle a = a(mainProcessTask, false);
        if (!s(a)) {
            return false;
        }
        a(a(a, false), mainProcessTask);
        mainProcessTask.SK();
        return true;
    }

    private static boolean s(Bundle bundle) {
        try {
            iJQ.v(bundle);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void t(Bundle bundle) {
        if (iJQ == null) {
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
            iJQ.u(bundle);
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
        }
    }

    private static void Sx() {
        if (iJR == null) {
            iJR = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppBrandMainProcessService.iJQ = com.tencent.mm.plugin.appbrand.ipc.c.a.G(iBinder);
                    AppBrandMainProcessService.Sy();
                    AppBrandMainProcessService.Sz();
                    w.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[]{ab.um()});
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    AppBrandMainProcessService.iJQ = null;
                    AppBrandMainProcessService.SA();
                    AppBrandMainProcessService.Sx();
                    w.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[]{ab.um()});
                }
            };
        }
        w.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
        Context context = ab.getContext();
        context.bindService(new Intent(context, AppBrandMainProcessService.class), iJR, 1);
    }

    public static void a(a aVar) {
        iJT.add(aVar);
    }

    public static void b(a aVar) {
        iJT.remove(aVar);
    }

    private static void a(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        mainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mainProcessTask2.f(obtain);
        obtain.recycle();
    }

    static Bundle a(MainProcessTask mainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", mainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", iJW);
        }
        bundle.putString("task_id", mainProcessTask.iKz);
        return bundle;
    }

    private static MainProcessTask a(Bundle bundle, boolean z) {
        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
        MainProcessTask mainProcessTask = (MainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            mainProcessTask.iKy = (Messenger) bundle.getParcelable("task_client");
        }
        mainProcessTask.iKz = bundle.getString("task_id");
        return mainProcessTask;
    }
}
