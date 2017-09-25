package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class h implements ServiceConnection {
    boolean asG = false;
    private final BlockingQueue<IBinder> asH = new LinkedBlockingQueue();

    public final IBinder ky() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.asG) {
            throw new IllegalStateException();
        } else {
            this.asG = true;
            return (IBinder) this.asH.take();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.asH.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
