package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class WaitNotify {
    private static final String TAG = "WaitNotify";
    private volatile boolean isWaiting = false;
    private MonitorObject myMonitorObject = new MonitorObject();
    private volatile boolean wasSignalled = false;

    WaitNotify() {
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    public void doWait() {
        Logger.d(TAG, "doWait " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            this.wasSignalled = false;
            while (!this.wasSignalled) {
                try {
                    Logger.d(TAG, "doWait internal " + Thread.currentThread().getName());
                    this.isWaiting = true;
                    this.myMonitorObject.wait();
                    Logger.d(TAG, "doWait wake " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Logger.e(TAG, e.toString());
                }
            }
            this.isWaiting = false;
        }
    }

    public void doNotify() {
        Logger.d(TAG, "doNotify " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            this.wasSignalled = true;
            Logger.d(TAG, "doNotify internal " + Thread.currentThread().getName());
            this.myMonitorObject.notifyAll();
            Logger.d(TAG, "doNotify over " + Thread.currentThread().getName());
        }
    }
}
