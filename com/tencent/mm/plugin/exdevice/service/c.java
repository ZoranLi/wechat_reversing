package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements ServiceConnection {
    public a lgD;
    public volatile boolean lgE;
    private List<Runnable> lgF = new LinkedList();

    public static abstract class a {
        public int fHD;

        public abstract void onServiceConnected();

        public a(int i) {
            this.fHD = i;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List arrayList;
        w.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        x xVar = new x(com.tencent.mm.plugin.exdevice.service.h.a.H(iBinder));
        u.a(xVar);
        ab.bJe();
        xVar.a(com.tencent.mm.plugin.exdevice.b.a.aoN());
        xVar.b(com.tencent.mm.plugin.exdevice.model.a.aoY());
        if (!xVar.a(ad.apF())) {
            w.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.lgD != null) {
            this.lgD.onServiceConnected();
        }
        this.lgE = true;
        synchronized (this.lgF) {
            arrayList = new ArrayList(this.lgF);
            this.lgF.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Runnable runnable = (Runnable) arrayList.get(i);
            if (runnable != null) {
                runnable.run();
            }
        }
        arrayList.clear();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        w.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.lgE = false;
        u.a(null);
        ab.bJe();
        if (!ap.za() || ap.uP()) {
            w.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
        } else {
            bT(ab.getContext());
        }
    }

    public final void bT(Context context) {
        if (!d.bU(context)) {
            w.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
        } else if (context.bindService(new Intent(context, ExDeviceService.class), this, 1)) {
            w.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
        } else {
            w.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
        }
    }

    public final boolean s(Runnable runnable) {
        if (this.lgE) {
            runnable.run();
        } else {
            synchronized (this.lgF) {
                this.lgF.add(runnable);
            }
        }
        return true;
    }
}
