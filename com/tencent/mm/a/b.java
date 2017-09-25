package com.tencent.mm.a;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b {
    static ae fuJ;
    File fuG;
    public ReentrantLock fuH = new ReentrantLock();
    public Condition fuI = this.fuH.newCondition();

    public b(final String str) {
        synchronized (b.class) {
            if (fuJ == null) {
                HandlerThread handlerThread = new HandlerThread("I/O Worker");
                handlerThread.start();
                fuJ = new ae(handlerThread.getLooper());
            }
        }
        File file = new File(str);
        if (file.exists()) {
            this.fuG = file;
            return;
        }
        w.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        fuJ.post(new Runnable(this) {
            final /* synthetic */ b fuL;

            public final void run() {
                File file = new File(str);
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.aU(str);
                    w.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        file.createNewFile();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "", new Object[0]);
                        w.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "createNewFile", new Object[0]);
                    }
                    w.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                this.fuL.fuH.lock();
                try {
                    this.fuL.fuG = file;
                    this.fuL.fuI.signal();
                    w.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", file.getAbsoluteFile());
                } finally {
                    this.fuL.fuH.unlock();
                }
            }
        });
    }

    public final File nV() {
        this.fuH.lock();
        while (this.fuG == null) {
            try {
                w.i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.fuI.await();
            } catch (Exception e) {
            } finally {
                this.fuH.unlock();
            }
        }
        return this.fuG;
    }
}
