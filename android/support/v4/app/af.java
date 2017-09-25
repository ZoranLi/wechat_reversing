package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class af {
    public static final int sK = sR.bn();
    private static final Object sL = new Object();
    private static String sM;
    private static Set<String> sN = new HashSet();
    private static final Object sP = new Object();
    private static h sQ;
    public static final b sR;
    public final Context mContext;
    public final NotificationManager sO = ((NotificationManager) this.mContext.getSystemService("notification"));

    interface b {
        void a(NotificationManager notificationManager, String str, int i);

        void a(NotificationManager notificationManager, String str, int i, Notification notification);

        int bn();
    }

    private static class g {
        final ComponentName sU;
        final IBinder sV;

        public g(ComponentName componentName, IBinder iBinder) {
            this.sU = componentName;
            this.sV = iBinder;
        }
    }

    private static class h implements ServiceConnection, Callback {
        private final Context mContext;
        final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, a> sW = new HashMap();
        private Set<String> sX = new HashSet();

        private static class a {
            public int retryCount = 0;
            public final ComponentName sU;
            public boolean sY = false;
            public r sZ;
            public LinkedList<i> ta = new LinkedList();

            public a(ComponentName componentName) {
                this.sU = componentName;
            }
        }

        public h(Context context) {
            this.mContext = context;
            this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        public final boolean handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 0:
                    Iterator it;
                    i iVar = (i) message.obj;
                    Set i = af.i(this.mContext);
                    if (!i.equals(this.sX)) {
                        this.sX = i;
                        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                        Set<ComponentName> hashSet = new HashSet();
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            if (i.contains(resolveInfo.serviceInfo.packageName)) {
                                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                                if (resolveInfo.serviceInfo.permission != null) {
                                    new StringBuilder("Permission present on component ").append(componentName).append(", not adding listener record.");
                                } else {
                                    hashSet.add(componentName);
                                }
                            }
                        }
                        for (ComponentName componentName2 : hashSet) {
                            if (!this.sW.containsKey(componentName2)) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Adding listener record for ").append(componentName2);
                                }
                                this.sW.put(componentName2, new a(componentName2));
                            }
                        }
                        it = this.sW.entrySet().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            if (!hashSet.contains(entry.getKey())) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Removing listener record for ").append(entry.getKey());
                                }
                                a((a) entry.getValue());
                                it.remove();
                            }
                        }
                    }
                    for (a aVar2 : this.sW.values()) {
                        aVar2.ta.add(iVar);
                        c(aVar2);
                    }
                    return true;
                case 1:
                    g gVar = (g) message.obj;
                    ComponentName componentName3 = gVar.sU;
                    IBinder iBinder = gVar.sV;
                    aVar = (a) this.sW.get(componentName3);
                    if (aVar != null) {
                        aVar.sZ = android.support.v4.app.r.a.a(iBinder);
                        aVar.retryCount = 0;
                        c(aVar);
                    }
                    return true;
                case 2:
                    aVar = (a) this.sW.get((ComponentName) message.obj);
                    if (aVar != null) {
                        a(aVar);
                    }
                    return true;
                case 3:
                    aVar = (a) this.sW.get((ComponentName) message.obj);
                    if (aVar != null) {
                        c(aVar);
                    }
                    return true;
                default:
                    return false;
            }
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Connected to service ").append(componentName);
            }
            this.mHandler.obtainMessage(1, new g(componentName, iBinder)).sendToTarget();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Disconnected from service ").append(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        private void a(a aVar) {
            if (aVar.sY) {
                this.mContext.unbindService(this);
                aVar.sY = false;
            }
            aVar.sZ = null;
        }

        private void b(a aVar) {
            if (!this.mHandler.hasMessages(3, aVar.sU)) {
                aVar.retryCount++;
                if (aVar.retryCount > 6) {
                    new StringBuilder("Giving up on delivering ").append(aVar.ta.size()).append(" tasks to ").append(aVar.sU).append(" after ").append(aVar.retryCount).append(" retries");
                    aVar.ta.clear();
                    return;
                }
                int i = (1 << (aVar.retryCount - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    new StringBuilder("Scheduling retry for ").append(i).append(" ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, aVar.sU), (long) i);
            }
        }

        private void c(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Processing component ").append(aVar.sU).append(", ").append(aVar.ta.size()).append(" queued tasks");
            }
            if (!aVar.ta.isEmpty()) {
                boolean z;
                if (aVar.sY) {
                    z = true;
                } else {
                    aVar.sY = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.sU), this, af.sK);
                    if (aVar.sY) {
                        aVar.retryCount = 0;
                    } else {
                        new StringBuilder("Unable to bind to listener ").append(aVar.sU);
                        this.mContext.unbindService(this);
                    }
                    z = aVar.sY;
                }
                if (!z || aVar.sZ == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    i iVar = (i) aVar.ta.peek();
                    if (iVar == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Sending task ").append(iVar);
                        }
                        iVar.a(aVar.sZ);
                        aVar.ta.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Remote service has died: ").append(aVar.sU);
                        }
                    } catch (RemoteException e2) {
                        new StringBuilder("RemoteException communicating with ").append(aVar.sU);
                    }
                }
                if (!aVar.ta.isEmpty()) {
                    b(aVar);
                }
            }
        }
    }

    private interface i {
        void a(r rVar);
    }

    private static class a implements i {
        final int id;
        final String packageName;
        final boolean sS = false;
        final String tag = null;

        public a(String str, int i, String str2) {
            this.packageName = str;
            this.id = i;
        }

        public final void a(r rVar) {
            if (this.sS) {
                rVar.l(this.packageName);
            } else {
                rVar.b(this.packageName, this.id, this.tag);
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.sS);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static class c implements b {
        c() {
        }

        public void a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }

        public int bn() {
            return 1;
        }
    }

    private static class f implements i {
        final int id;
        final String packageName;
        final Notification sT;
        final String tag = null;

        public f(String str, int i, String str2, Notification notification) {
            this.packageName = str;
            this.id = i;
            this.sT = notification;
        }

        public final void a(r rVar) {
            rVar.a(this.packageName, this.id, this.tag, this.sT);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static class d extends c {
        d() {
        }

        public final void a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(null, i);
        }

        public final void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(null, i, notification);
        }
    }

    static class e extends d {
        e() {
        }

        public final int bn() {
            return 33;
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            sR = new e();
        } else if (VERSION.SDK_INT >= 5) {
            sR = new d();
        } else {
            sR = new c();
        }
    }

    public static af h(Context context) {
        return new af(context);
    }

    private af(Context context) {
        this.mContext = context;
    }

    public static Set<String> i(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(sM))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (sL) {
                sN = hashSet;
                sM = string;
            }
        }
        return sN;
    }

    public final void a(i iVar) {
        synchronized (sP) {
            if (sQ == null) {
                sQ = new h(this.mContext.getApplicationContext());
            }
        }
        sQ.mHandler.obtainMessage(0, iVar).sendToTarget();
    }
}
