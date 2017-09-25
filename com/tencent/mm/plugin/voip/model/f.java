package com.tencent.mm.plugin.voip.model;

import java.util.concurrent.locks.ReentrantLock;

public final class f {
    private static f rgi = new f();
    private ReentrantLock fuH = new ReentrantLock();
    private e rgj;

    private f() {
    }

    public static e bpu() {
        if (rgi.rgj == null) {
            rgi.fuH.lock();
            try {
                if (rgi.rgj == null) {
                    rgi.rgj = new e();
                }
                rgi.fuH.unlock();
            } catch (Throwable th) {
                rgi.fuH.unlock();
            }
        }
        return rgi.rgj;
    }
}
