package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class n extends m implements Callback {
    public final Context aiF;
    public final HashMap<a, b> aqV = new HashMap();
    public final com.google.android.gms.common.stats.b aqW;
    private final long aqX;
    private final Handler mHandler;

    private static final class a {
        private final String aqY;
        private final String aqZ;
        private final ComponentName ara;

        public a(ComponentName componentName) {
            this.aqY = null;
            this.aqZ = null;
            this.ara = (ComponentName) w.Z(componentName);
        }

        public a(String str, String str2) {
            this.aqY = w.U(str);
            this.aqZ = w.U(str2);
            this.ara = null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return v.d(this.aqY, aVar.aqY) && v.d(this.ara, aVar.ara);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.aqY, this.ara});
        }

        public final Intent kd() {
            return this.aqY != null ? new Intent(this.aqY).setPackage(this.aqZ) : new Intent().setComponent(this.ara);
        }

        public final String toString() {
            return this.aqY == null ? this.ara.flattenToString() : this.aqY;
        }
    }

    private final class b {
        public IBinder apv;
        public ComponentName ara;
        final a arb = new a(this);
        public final Set<ServiceConnection> arc = new HashSet();
        boolean ard;
        public final a are;
        final /* synthetic */ n arf;
        public int mState = 2;

        public class a implements ServiceConnection {
            final /* synthetic */ b arg;

            public a(b bVar) {
                this.arg = bVar;
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.arg.arf.aqV) {
                    this.arg.apv = iBinder;
                    this.arg.ara = componentName;
                    for (ServiceConnection onServiceConnected : this.arg.arc) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.arg.mState = 1;
                }
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.arg.arf.aqV) {
                    this.arg.apv = null;
                    this.arg.ara = componentName;
                    for (ServiceConnection onServiceDisconnected : this.arg.arc) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.arg.mState = 2;
                }
            }
        }

        public b(n nVar, a aVar) {
            this.arf = nVar;
            this.are = aVar;
        }

        public final void R(String str) {
            this.ard = this.arf.aqW.a(this.arf.aiF, str, this.are.kd(), this.arb, 129);
            if (this.ard) {
                this.mState = 3;
                return;
            }
            try {
                this.arf.aqW.a(this.arf.aiF, this.arb);
            } catch (IllegalArgumentException e) {
            }
        }

        public final void a(ServiceConnection serviceConnection, String str) {
            this.arf.aqW.a(this.arf.aiF, serviceConnection, str, this.are.kd(), 3);
            this.arc.add(serviceConnection);
        }

        public final boolean a(ServiceConnection serviceConnection) {
            return this.arc.contains(serviceConnection);
        }

        public final boolean ke() {
            return this.arc.isEmpty();
        }
    }

    n(Context context) {
        this.aiF = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.aqW = com.google.android.gms.common.stats.b.kw();
        this.aqX = 5000;
    }

    private void a(a aVar, ServiceConnection serviceConnection) {
        w.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aqV) {
            b bVar = (b) this.aqV.get(aVar);
            if (bVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + aVar);
            } else if (bVar.a(serviceConnection)) {
                bVar.arf.aqW.a(bVar.arf.aiF, serviceConnection, null, null, 4);
                bVar.arc.remove(serviceConnection);
                if (bVar.ke()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, bVar), this.aqX);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + aVar);
            }
        }
    }

    private boolean a(a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        w.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aqV) {
            b bVar = (b) this.aqV.get(aVar);
            if (bVar != null) {
                this.mHandler.removeMessages(0, bVar);
                if (!bVar.a(serviceConnection)) {
                    bVar.a(serviceConnection, str);
                    switch (bVar.mState) {
                        case 1:
                            serviceConnection.onServiceConnected(bVar.ara, bVar.apv);
                            break;
                        case 2:
                            bVar.R(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + aVar);
            }
            bVar = new b(this, aVar);
            bVar.a(serviceConnection, str);
            bVar.R(str);
            this.aqV.put(aVar, bVar);
            z = bVar.ard;
        }
        return z;
    }

    public final boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new a(componentName), serviceConnection, str);
    }

    public final boolean a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return a(new a(str, str2), serviceConnection, str3);
    }

    public final void b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        a(new a(componentName), serviceConnection);
    }

    public final void b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        a(new a(str, str2), serviceConnection);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b bVar = (b) message.obj;
                synchronized (this.aqV) {
                    if (bVar.ke()) {
                        if (bVar.ard) {
                            bVar.arf.aqW.a(bVar.arf.aiF, bVar.arb);
                            bVar.ard = false;
                            bVar.mState = 2;
                        }
                        this.aqV.remove(bVar.are);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
