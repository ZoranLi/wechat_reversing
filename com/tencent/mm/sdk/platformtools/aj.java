package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;

public class aj extends ae {
    private static int usN;
    private final boolean iWB;
    private boolean mStop = false;
    private final int usO;
    private long utw = 0;
    private final a utx;

    public interface a {
        boolean oQ();
    }

    public aj(a aVar, boolean z) {
        this.utx = aVar;
        this.usO = bJp();
        this.iWB = z;
        if (getLooper().getThread().getName().equals("initThread")) {
            w.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bg.bJZ());
        }
    }

    public aj(Looper looper, a aVar, boolean z) {
        super(looper);
        this.utx = aVar;
        this.usO = bJp();
        this.iWB = z;
        if (looper.getThread().getName().equals("initThread")) {
            w.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bg.bJZ());
        }
    }

    private static int bJp() {
        if (usN >= 8192) {
            usN = 0;
        }
        int i = usN + 1;
        usN = i;
        return i;
    }

    protected void finalize() {
        KH();
        super.finalize();
    }

    public void handleMessage(Message message) {
        if (message.what == this.usO && this.utx != null && this.utx.oQ() && this.iWB && !this.mStop) {
            sendEmptyMessageDelayed(this.usO, this.utw);
        }
    }

    public final void KH() {
        removeMessages(this.usO);
        this.mStop = true;
    }

    public final void v(long j, long j2) {
        this.utw = j2;
        KH();
        this.mStop = false;
        sendEmptyMessageDelayed(this.usO, j);
    }

    public final boolean bJq() {
        return this.mStop || !hasMessages(this.usO);
    }

    public String toString() {
        if (this.utx == null) {
            return "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
        }
        return "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.utx.getClass().getName() + "}";
    }
}
