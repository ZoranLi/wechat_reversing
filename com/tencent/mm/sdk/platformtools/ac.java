package com.tencent.mm.sdk.platformtools;

public final class ac {
    public volatile boolean uta;

    public ac() {
        this.uta = false;
    }

    public ac(boolean z) {
        this.uta = z;
    }

    public final void open() {
        synchronized (this) {
            boolean z = this.uta;
            this.uta = true;
            if (!z) {
                notifyAll();
            }
        }
    }

    public final void close() {
        synchronized (this) {
            this.uta = false;
        }
    }

    public final void block() {
        synchronized (this) {
            while (!this.uta) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final boolean bJg() {
        if (500 != 0) {
            boolean z;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 500 + currentTimeMillis;
                while (!this.uta && currentTimeMillis < j) {
                    try {
                        wait(j - currentTimeMillis);
                    } catch (InterruptedException e) {
                    }
                    currentTimeMillis = System.currentTimeMillis();
                }
                z = this.uta;
            }
            return z;
        }
        block();
        return true;
    }

    public final String toString() {
        return "MMConditionVariable[" + hashCode() + "," + this.uta + "]";
    }
}
