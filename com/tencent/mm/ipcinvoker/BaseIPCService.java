package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.b.a.a;
import com.tencent.mm.ipcinvoker.b.b;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseIPCService extends Service {
    private volatile boolean gVu;
    private volatile boolean gVv;
    private a gVw = new a(this) {
        final /* synthetic */ BaseIPCService gVx;

        {
            this.gVx = r1;
        }

        public final void a(final Bundle bundle, String str, final b bVar) {
            if (str == null || str.length() == 0) {
                w.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.");
                return;
            }
            final a aVar = (a) n.b(str, a.class);
            if (aVar == null) {
                w.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", str);
                return;
            }
            if (bundle != null) {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
            }
            m.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 gVA;

                public final void run() {
                    aVar.a(bundle, new c(this) {
                        final /* synthetic */ AnonymousClass1 gVB;

                        {
                            this.gVB = r1;
                        }

                        public final void k(Bundle bundle) {
                            if (bVar != null) {
                                if (bundle != null) {
                                    try {
                                        bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                                    } catch (RemoteException e) {
                                        w.e("IPC.BaseIPCService", "%s", e);
                                        return;
                                    }
                                }
                                bVar.k(bundle);
                            }
                        }
                    });
                }
            });
        }

        public final Bundle d(Bundle bundle, String str) {
            if (str == null || str.length() == 0) {
                w.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.");
                return null;
            }
            k kVar = (k) n.b(str, k.class);
            if (kVar == null) {
                w.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", str);
                return null;
            }
            if (bundle != null) {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
            }
            return kVar.l(bundle);
        }
    };

    public abstract String um();

    public IBinder onBind(Intent intent) {
        w.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", intent, Boolean.valueOf(this.gVu));
        if (this.gVu) {
            w.i("IPC.BaseIPCService", "need to kill self, return null Binder object.");
            return null;
        }
        j uq = j.uq();
        String up = d.up();
        if (!(up == null || up.length() == 0 || this == null)) {
            uq.gVY.put(up, this);
        }
        this.gVv = true;
        return this.gVw;
    }

    public boolean onUnbind(Intent intent) {
        w.i("IPC.BaseIPCService", "onUnbind(%s)", intent);
        boolean onUnbind = super.onUnbind(intent);
        this.gVv = false;
        return onUnbind;
    }

    public final void aO(boolean z) {
        if (!this.gVv || z) {
            w.i("IPC.BaseIPCService", "kill self(%s)", um());
            this.gVu = true;
            b.un().uo();
            b un = b.un();
            w.i("IPC.IPCBridgeManager", "releaseAllIPCBridge");
            if (!un.gVE.isEmpty()) {
                synchronized (un.gVE) {
                    if (un.gVE.isEmpty()) {
                    } else {
                        Set<String> hashSet = new HashSet(un.gVE.keySet());
                        if (!hashSet.isEmpty()) {
                            for (String dR : hashSet) {
                                un.dR(dR);
                            }
                        }
                    }
                }
            }
            stopSelf();
            j uq = j.uq();
            uq.gVY.remove(um());
            m.e(new Runnable(this) {
                final /* synthetic */ BaseIPCService gVx;

                {
                    this.gVx = r1;
                }

                public final void run() {
                    Process.killProcess(Process.myPid());
                }
            });
            return;
        }
        w.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", um());
    }
}
