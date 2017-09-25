package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

final class ag extends Handler implements com.tencent.mm.sdk.platformtools.ak.a {
    private String toStringResult = null;
    private Looper utk = getLooper();
    private Callback utl;
    a utm;

    public interface a {
        void handleMessage(Message message);

        void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f);

        void onTaskAdded(Runnable runnable, ak akVar);

        void onTaskRunEnd(Runnable runnable, ak akVar);
    }

    ag(a aVar) {
        this.utm = aVar;
    }

    ag(Looper looper, a aVar) {
        super(looper);
        this.utm = aVar;
    }

    ag(Callback callback, a aVar) {
        super(callback);
        this.utl = callback;
        this.utm = aVar;
    }

    ag(Looper looper, Callback callback, a aVar) {
        super(looper, callback);
        this.utl = callback;
        this.utm = aVar;
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        if (callback == null) {
            return super.sendMessageAtTime(message, j);
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        ak akVar = new ak(this.utk.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            akVar.utC = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), akVar);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (getLooper() == null || getLooper().getThread().isAlive()) {
            if (this.utm != null) {
                this.utm.onTaskAdded(callback, akVar);
            }
            boolean sendMessageAtTime = super.sendMessageAtTime(obtain, j);
            if (sendMessageAtTime || this.utm == null) {
                return sendMessageAtTime;
            }
            this.utm.onTaskRunEnd(callback, akVar);
            return sendMessageAtTime;
        }
        w.w("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName());
        return false;
    }

    public final void dispatchMessage(Message message) {
        if (message.getCallback() == null && this.utl == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.utm != null) {
                this.utm.onLog(message, null, this.utk.getThread(), System.currentTimeMillis() - currentTimeMillis, Debug.threadCpuTimeNanos() - threadCpuTimeNanos, -1.0f);
                return;
            }
            return;
        }
        super.dispatchMessage(message);
    }

    public final void handleMessage(Message message) {
        if (this.utm != null) {
            this.utm.handleMessage(message);
        }
    }

    public final String toString() {
        if (this.toStringResult == null) {
            this.toStringResult = "MMInnerHandler{listener = " + this.utm + "}";
        }
        return this.toStringResult;
    }

    public final void a(Runnable runnable, ak akVar) {
        if (this.utm != null) {
            this.utm.onTaskRunEnd(runnable, akVar);
        }
    }

    public final void a(Runnable runnable, Thread thread, long j, long j2, float f) {
        if (this.utm != null) {
            this.utm.onLog(null, runnable, thread, j, j2, f);
        }
    }
}
