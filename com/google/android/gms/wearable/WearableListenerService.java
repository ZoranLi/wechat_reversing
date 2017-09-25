package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.k;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.n.c;
import java.util.List;

public abstract class WearableListenerService extends Service implements com.google.android.gms.wearable.a.a, com.google.android.gms.wearable.b.a, b, com.google.android.gms.wearable.k.a, n.b, c {
    private volatile int aGd = -1;
    private String aGe;
    private Handler aGf;
    private Object aGg = new Object();
    private boolean aio;
    private IBinder apv;

    private class a extends com.google.android.gms.wearable.internal.w.a {
        boolean aGh = false;
        final /* synthetic */ WearableListenerService aGi;

        a(WearableListenerService wearableListenerService) {
            this.aGi = wearableListenerService;
            this.aGh = wearableListenerService instanceof zzj;
        }

        public final void a(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onDataItemChanged: ").append(this.aGi.aGe).append(": ").append(dataHolder);
            }
            WearableListenerService.b(this.aGi);
            synchronized (this.aGi.aGg) {
                if (this.aGi.aio) {
                    dataHolder.close();
                    return;
                }
                this.aGi.aGf.post(new Runnable(this) {
                    final /* synthetic */ a aGk;

                    public final void run() {
                        e eVar = new e(dataHolder);
                        try {
                            this.aGk.aGi.a(eVar);
                        } finally {
                            eVar.release();
                        }
                    }
                });
            }
        }

        public final void a(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onEntityUpdate: ").append(amsEntityUpdateParcelable);
            }
            if (this.aGh) {
                WearableListenerService.b(this.aGi);
                final zzj com_google_android_gms_wearable_zzj = (zzj) this.aGi;
                synchronized (this.aGi.aGg) {
                    if (this.aGi.aio) {
                        return;
                    }
                    this.aGi.aGf.post(new Runnable(this) {
                        final /* synthetic */ a aGk;

                        public final void run() {
                        }
                    });
                }
            }
        }

        public final void a(final AncsNotificationParcelable ancsNotificationParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onNotificationReceived: ").append(ancsNotificationParcelable);
            }
            if (this.aGh) {
                WearableListenerService.b(this.aGi);
                final zzj com_google_android_gms_wearable_zzj = (zzj) this.aGi;
                synchronized (this.aGi.aGg) {
                    if (this.aGi.aio) {
                        return;
                    }
                    this.aGi.aGf.post(new Runnable(this) {
                        final /* synthetic */ a aGk;

                        public final void run() {
                        }
                    });
                }
            }
        }

        public final void a(final CapabilityInfoParcelable capabilityInfoParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onConnectedCapabilityChanged: ").append(capabilityInfoParcelable);
            }
            WearableListenerService.b(this.aGi);
            synchronized (this.aGi.aGg) {
                if (this.aGi.aio) {
                    return;
                }
                this.aGi.aGf.post(new Runnable(this) {
                    final /* synthetic */ a aGk;

                    public final void run() {
                    }
                });
            }
        }

        public final void a(final ChannelEventParcelable channelEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onChannelEvent: ").append(channelEventParcelable);
            }
            WearableListenerService.b(this.aGi);
            synchronized (this.aGi.aGg) {
                if (this.aGi.aio) {
                    return;
                }
                this.aGi.aGf.post(new Runnable(this) {
                    final /* synthetic */ a aGk;

                    public final void run() {
                        channelEventParcelable.a(this.aGk.aGi);
                    }
                });
            }
        }

        public final void a(final MessageEventParcelable messageEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onMessageReceived: ").append(messageEventParcelable);
            }
            WearableListenerService.b(this.aGi);
            synchronized (this.aGi.aGg) {
                if (this.aGi.aio) {
                    return;
                }
                this.aGi.aGf.post(new Runnable(this) {
                    final /* synthetic */ a aGk;

                    public final void run() {
                        this.aGk.aGi.a(messageEventParcelable);
                    }
                });
            }
        }

        public final void a(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onPeerConnected: ").append(this.aGi.aGe).append(": ").append(nodeParcelable);
            }
            WearableListenerService.b(this.aGi);
            synchronized (this.aGi.aGg) {
                if (this.aGi.aio) {
                    return;
                }
                this.aGi.aGf.post(new Runnable(this) {
                    final /* synthetic */ a aGk;

                    public final void run() {
                        this.aGk.aGi.a(nodeParcelable);
                    }
                });
            }
        }

        public final void b(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onPeerDisconnected: ").append(this.aGi.aGe).append(": ").append(nodeParcelable);
            }
            WearableListenerService.b(this.aGi);
            synchronized (this.aGi.aGg) {
                if (this.aGi.aio) {
                    return;
                }
                this.aGi.aGf.post(new Runnable(this) {
                    final /* synthetic */ a aGk;

                    public final void run() {
                        this.aGk.aGi.b(nodeParcelable);
                    }
                });
            }
        }

        public final void m(final List<NodeParcelable> list) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onConnectedNodes: ").append(this.aGi.aGe).append(": ").append(list);
            }
            WearableListenerService.b(this.aGi);
            synchronized (this.aGi.aGg) {
                if (this.aGi.aio) {
                    return;
                }
                this.aGi.aGf.post(new Runnable(this) {
                    final /* synthetic */ a aGk;

                    public final void run() {
                    }
                });
            }
        }
    }

    static /* synthetic */ void b(WearableListenerService wearableListenerService) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == wearableListenerService.aGd) {
            return;
        }
        if (e.a(wearableListenerService, callingUid, "com.google.android.wearable.app.cn")) {
            if (k.kC().a(wearableListenerService.getPackageManager(), "com.google.android.wearable.app.cn")) {
                wearableListenerService.aGd = callingUid;
                return;
            }
            throw new SecurityException("Caller is not Android Wear.");
        } else if (e.l(wearableListenerService, callingUid)) {
            wearableListenerService.aGd = callingUid;
        } else {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public void a(Channel channel) {
    }

    public void a(Channel channel, int i, int i2) {
    }

    public void a(e eVar) {
    }

    public void a(l lVar) {
    }

    public void a(m mVar) {
    }

    public void b(Channel channel, int i, int i2) {
    }

    public void b(m mVar) {
    }

    public void c(Channel channel, int i, int i2) {
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.apv : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onCreate: ").append(getPackageName());
        }
        this.aGe = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.aGf = new Handler(handlerThread.getLooper());
        this.apv = new a(this);
    }

    public void onDestroy() {
        synchronized (this.aGg) {
            this.aio = true;
            if (this.aGf == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.aGf.getLooper().quit();
        }
        super.onDestroy();
    }
}
