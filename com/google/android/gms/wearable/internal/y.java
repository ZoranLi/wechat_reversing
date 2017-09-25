package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.wearable.internal.x.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class y<T> {
    private final Map<T, ap<T>> aHl = new HashMap();

    y() {
    }

    public final void a(ao aoVar) {
        synchronized (this.aHl) {
            v fVar = new f();
            for (Entry entry : this.aHl.entrySet()) {
                ap apVar = (ap) entry.getValue();
                if (apVar != null) {
                    apVar.aHH = null;
                    apVar.aHI = null;
                    apVar.aHJ = null;
                    apVar.aHK = null;
                    apVar.aHL = null;
                    apVar.aHM = null;
                    apVar.aHN = null;
                    apVar.aHO = null;
                    if (aoVar.isConnected()) {
                        try {
                            ((x) aoVar.jY()).a(fVar, new RemoveListenerRequest(apVar));
                            if (Log.isLoggable("WearableClient", 2)) {
                                new StringBuilder("disconnect: removed: ").append(entry.getKey()).append("/").append(apVar);
                            }
                        } catch (RemoteException e) {
                            new StringBuilder("disconnect: Didn't remove: ").append(entry.getKey()).append("/").append(apVar);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.aHl.clear();
        }
    }

    public final void u(IBinder iBinder) {
        synchronized (this.aHl) {
            x t = a.t(iBinder);
            v fVar = new f();
            for (Entry entry : this.aHl.entrySet()) {
                ap apVar = (ap) entry.getValue();
                try {
                    t.a(fVar, new AddListenerRequest(apVar));
                    if (Log.isLoggable("WearableClient", 2)) {
                        new StringBuilder("onPostInitHandler: added: ").append(entry.getKey()).append("/").append(apVar);
                    }
                } catch (RemoteException e) {
                    new StringBuilder("onPostInitHandler: Didn't add: ").append(entry.getKey()).append("/").append(apVar);
                }
            }
        }
    }
}
