package com.tencent.mm.remoteservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private Context context;
    private ServiceConnection mgm = new ServiceConnection(this) {
        final /* synthetic */ d upk;

        {
            this.upk = r1;
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.upk.upj = null;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.upk.upj = a.aa(iBinder);
            for (Runnable run : (Runnable[]) this.upk.upi.toArray(new Runnable[this.upk.upi.size()])) {
                run.run();
            }
            this.upk.upi.clear();
        }
    };
    public List<Runnable> upi = new LinkedList();
    public c upj;

    public d(Context context) {
        this.context = context;
    }

    public final void G(Runnable runnable) {
        new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
        if (isConnected()) {
            runnable.run();
            return;
        }
        this.upi.add(runnable);
        this.context.bindService(new Intent(this.context, RemoteService.class), this.mgm, 1);
    }

    public final boolean isConnected() {
        return this.upj != null && this.upj.asBinder().isBinderAlive();
    }

    public final void release() {
        if (this.upj != null && this.mgm != null) {
            this.context.unbindService(this.mgm);
            this.upj = null;
        }
    }

    final void a(b bVar, String str, Bundle bundle) {
        if (isConnected()) {
            try {
                this.upj.a(bVar.getClass().getName(), str, bundle, bVar);
            } catch (Throwable e) {
                w.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[]{bg.g(e)});
            }
        }
    }
}
