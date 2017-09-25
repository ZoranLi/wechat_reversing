package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class q {
    private static q jv;
    b jw;
    b jx;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Callback(this) {
        final /* synthetic */ q jy;

        {
            this.jy = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    q qVar = this.jy;
                    b bVar = (b) message.obj;
                    synchronized (qVar.mLock) {
                        if (qVar.jw == bVar || qVar.jx == bVar) {
                            qVar.a(bVar);
                        }
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final Object mLock = new Object();

    interface a {
    }

    private static class b {
        public int duration;
        public final WeakReference<a> jz;

        final boolean f(a aVar) {
            return aVar != null && this.jz.get() == aVar;
        }
    }

    static q am() {
        if (jv == null) {
            jv = new q();
        }
        return jv;
    }

    private q() {
    }

    public final void a(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar)) {
                this.mHandler.removeCallbacksAndMessages(this.jw);
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar)) {
                b(this.jw);
            }
        }
    }

    public final boolean c(a aVar) {
        boolean z;
        synchronized (this.mLock) {
            z = d(aVar) || e(aVar);
        }
        return z;
    }

    final boolean a(b bVar) {
        if (((a) bVar.jz.get()) == null) {
            return false;
        }
        this.mHandler.removeCallbacksAndMessages(bVar);
        return true;
    }

    final boolean d(a aVar) {
        return this.jw != null && this.jw.f(aVar);
    }

    final boolean e(a aVar) {
        return this.jx != null && this.jx.f(aVar);
    }

    final void b(b bVar) {
        if (bVar.duration != -2) {
            int i = 2750;
            if (bVar.duration > 0) {
                i = bVar.duration;
            } else if (bVar.duration == -1) {
                i = 1500;
            }
            this.mHandler.removeCallbacksAndMessages(bVar);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, bVar), (long) i);
        }
    }
}
