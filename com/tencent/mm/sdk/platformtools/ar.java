package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class ar {
    public boolean fRo;
    public Object lock;
    public String name;
    public int priority;
    public LinkedBlockingQueue<a> uuS;
    private int uuT;
    public Vector<b> uuU;
    public ae uuV;

    public interface a {
        boolean Bn();

        boolean Bo();
    }

    final class b extends Thread {
        private int saH;
        final /* synthetic */ ar uuW;

        private b(ar arVar) {
            this.uuW = arVar;
            super(arVar.name);
            this.saH = 60;
            setPriority(arVar.priority);
            arVar.uuU.add(this);
        }

        public final void run() {
            while (this.saH > 0) {
                a aVar;
                synchronized (this.uuW.lock) {
                    try {
                        if (this.uuW.fRo) {
                            this.uuW.lock.wait();
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
                    }
                }
                try {
                    aVar = (a) this.uuW.uuS.poll(2000, TimeUnit.MILLISECONDS);
                } catch (Throwable e2) {
                    w.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e2, "", new Object[0]);
                    aVar = null;
                }
                if (aVar == null) {
                    this.saH--;
                } else {
                    this.saH = 60;
                    if (aVar.Bn()) {
                        this.uuW.uuV.sendMessage(this.uuW.uuV.obtainMessage(0, aVar));
                    }
                }
            }
            this.uuW.uuU.remove(this);
            w.d("QueueWorkerThread.QueueWorkerThread", "dktest Finish queueToReqSize:" + this.uuW.uuS.size() + " ThreadSize:" + this.uuW.uuU.size());
        }
    }

    public ar(int i, String str) {
        this(i, str, 1);
    }

    public ar(int i, String str, int i2) {
        this(i, str, i2, Looper.myLooper());
    }

    public ar(int i, String str, int i2, Looper looper) {
        this.uuS = new LinkedBlockingQueue();
        this.fRo = false;
        this.uuT = 1;
        this.priority = 1;
        this.name = "";
        this.lock = new byte[0];
        this.uuU = new Vector();
        this.uuT = i2;
        this.name = str;
        this.priority = i;
        if (looper == null && Looper.getMainLooper() != null) {
            looper = Looper.getMainLooper();
            w.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
        }
        this.uuV = new ae(this, looper) {
            final /* synthetic */ ar uuW;

            public final void handleMessage(Message message) {
                if (message != null && message.obj != null) {
                    ((a) message.obj).Bo();
                }
            }
        };
    }

    public final int c(a aVar) {
        if (aVar == null) {
            w.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
            return -1;
        }
        try {
            if (!this.uuS.offer(aVar, 1, TimeUnit.MILLISECONDS)) {
                w.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
                return -2;
            } else if (this.uuU.size() != 0 && (this.uuS.size() <= 0 || this.uuT <= this.uuU.size())) {
                return 0;
            } else {
                new b().start();
                return 0;
            }
        } catch (Throwable e) {
            w.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + e.getMessage());
            w.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
            return -3;
        }
    }

    @Deprecated
    public final boolean bJx() {
        if (this.uuU == null || this.uuU.size() == 0) {
            return true;
        }
        return false;
    }

    public final void jU(boolean z) {
        synchronized (this.lock) {
            this.fRo = z;
            if (!z) {
                synchronized (this.lock) {
                    this.lock.notifyAll();
                }
            }
        }
    }
}
