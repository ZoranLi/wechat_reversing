package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.t;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class f implements com.tencent.mm.y.f {
    boolean fKF = false;
    boolean htv = false;
    boolean jCK = false;
    public HashSet<String> jJL = new HashSet();
    private e jJN;
    boolean jJO = false;
    public List<t> jKq;
    public d jLG;
    public int jLH = 0;
    public List<t> jMa;
    public int jMb = 0;
    public boolean jMc = false;
    public long jMd;
    long jMe;
    int jMf;
    public Object lock = new Object();

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ f jMg;
        final /* synthetic */ int jMi;

        AnonymousClass5(f fVar, int i) {
            this.jMg = fVar;
            this.jMi = i;
        }

        public final void run() {
            int a;
            Throwable e;
            com.tencent.mm.plugin.backup.b.f.reset();
            com.tencent.mm.plugin.backup.b.f.aaw();
            c cVar = new c();
            cVar.begin();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int i = 0;
            for (t tVar : this.jMg.jKq) {
                try {
                    a = this.jMg.a(h.aan() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.d.rD(tVar.ID) + tVar.ID, hashMap, cVar, hashSet);
                    if (a < 0) {
                        cVar.end();
                        w.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                        return;
                    }
                    a += i;
                    try {
                        this.jMg.bF(a, this.jMi);
                        w.i("MicroMsg.RecoverPCServer", "recover has done: %d", new Object[]{Integer.valueOf(a)});
                        i = a;
                    } catch (Exception e2) {
                        e = e2;
                        w.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                        w.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        w.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                        i = a;
                    }
                } catch (Throwable e3) {
                    Throwable th = e3;
                    a = i;
                    e = th;
                    w.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                    w.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    w.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    i = a;
                }
            }
            com.tencent.mm.plugin.backup.g.d.d(hashMap);
            cVar.end();
            this.jMg.bF(100, 100);
            w.i("MicroMsg.RecoverPCServer", "build temDB finish!");
            w.bIP();
            a.abC().n(new Runnable(this) {
                final /* synthetic */ AnonymousClass5 jMj;

                {
                    this.jMj = r1;
                }

                public final void run() {
                    w.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
                    w.bIP();
                    a.acg().ach().jLT = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJg;
                    this.jMj.jMg.jMb = 0;
                    if (this.jMj.jMg.jLG != null) {
                        this.jMj.jMg.jLG.aac();
                    } else {
                        w.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                    }
                    e.acr();
                    new com.tencent.mm.plugin.backup.bakoldlogic.c.a(8).abt();
                    w.i("MicroMsg.RecoverPCServer", "recover ok");
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFB, Boolean.valueOf(true));
                    c aci = a.acg().aci();
                    aci.jLE++;
                    a.acg().ach().jLS = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJp;
                    this.jMj.jMg.cancel();
                    b abE = a.abC().abE();
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator it = abE.jIs.iterator();
                    while (it.hasNext()) {
                        b.a aVar = (b.a) it.next();
                        if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                            stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
                        } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                            stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
                        }
                    }
                    w.d("MicroMsg.RecoverDelayData", "dump delay " + stringBuffer.toString());
                }
            });
        }
    }

    public final void pause() {
        w.i("MicroMsg.RecoverPCServer", "pause");
        this.fKF = true;
    }

    public final void resume() {
        w.i("MicroMsg.RecoverPCServer", "resume");
        this.fKF = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        w.i("MicroMsg.RecoverPCServer", "cancel");
        this.htv = true;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        com.tencent.mm.plugin.backup.f.b.b(7, this.jJN);
        this.jLG = null;
        this.jMc = false;
        this.jCK = false;
        this.jMb = 0;
        this.jMf = 0;
    }

    public final void acv() {
        com.tencent.mm.a.e.d(new File(h.aan()));
        this.jJN = new e(this) {
            final /* synthetic */ f jMg;

            {
                this.jMg = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                w.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", new Object[]{((com.tencent.mm.plugin.backup.bakoldlogic.c.c) kVar).id, Integer.valueOf(i), Integer.valueOf(i2)});
                synchronized (this.jMg.lock) {
                    this.jMg.jJL.remove(r10.id);
                    w.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", new Object[]{Integer.valueOf(this.jMg.jJL.size())});
                    if (this.jMg.jJL.size() <= 10) {
                        this.jMg.lock.notifyAll();
                    }
                }
                f fVar = this.jMg;
                fVar.jLH++;
                if (this.jMg.jLH % com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX == 0) {
                    this.jMg.acx();
                }
                this.jMg.acw();
            }
        };
        com.tencent.mm.plugin.backup.f.b.a(7, this.jJN);
        for (t tVar : this.jMa) {
            if (this.fKF && !this.htv) {
                w.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (this.lock) {
                    try {
                        this.lock.wait();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    }
                }
            }
            if (this.htv) {
                w.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            com.tencent.mm.plugin.backup.bakoldlogic.c.c cVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.c(h.aan(), tVar.ID, 2, tVar.jNW, this, a.acg().jBs);
            synchronized (this.lock) {
                cVar.abt();
                this.jJL.add(tVar.ID);
                w.i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", new Object[]{Integer.valueOf(this.jJL.size())});
                if (this.jJL.size() > 10) {
                    try {
                        this.lock.wait();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                    }
                }
            }
        }
        for (t tVar2 : this.jKq) {
            if (this.fKF && !this.htv) {
                w.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (this.lock) {
                    try {
                        this.lock.wait();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
                    }
                }
            }
            if (this.htv) {
                w.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            cVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.c(h.aan(), tVar2.ID, 1, tVar2.jNW, this, a.acg().jBs);
            synchronized (this.lock) {
                cVar.abt();
                this.jJL.add(tVar2.ID);
                w.i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", new Object[]{Integer.valueOf(this.jJL.size())});
                if (this.jJL.size() > 10) {
                    try {
                        this.lock.wait();
                    } catch (Throwable e222) {
                        w.printErrStackTrace("MicroMsg.RecoverPCServer", e222, "", new Object[0]);
                    }
                }
            }
        }
        this.jJO = true;
        w.i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        acw();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void acw() {
        /*
        r3 = this;
        r0 = r3.jJO;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r3.htv;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = r3.lock;
        monitor-enter(r1);
        r0 = r3.jJL;	 Catch:{ all -> 0x001a }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x005b;
    L_0x0014:
        r0 = r3.htv;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = 1;
        r3.jMc = r0;	 Catch:{ all -> 0x001a }
        r0 = 0;
        r3.jMf = r0;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();	 Catch:{ all -> 0x001a }
        r0 = r0.ach();	 Catch:{ all -> 0x001a }
        r2 = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJo;	 Catch:{ all -> 0x001a }
        r0.jLS = r2;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();	 Catch:{ all -> 0x001a }
        r0 = r0.ach();	 Catch:{ all -> 0x001a }
        r2 = com.tencent.mm.plugin.backup.bakoldlogic.a.c.jJe;	 Catch:{ all -> 0x001a }
        r0.jLT = r2;	 Catch:{ all -> 0x001a }
        r0 = r3.jLG;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x005d;
    L_0x003f:
        r0 = r3.jLG;	 Catch:{ all -> 0x001a }
        r0.abW();	 Catch:{ all -> 0x001a }
    L_0x0044:
        r0 = 7;
        r2 = r3.jJN;	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.f.b.b(r0, r2);	 Catch:{ all -> 0x001a }
        r0 = 0;
        r2 = 0;
        r3.bF(r0, r2);	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.acr();	 Catch:{ all -> 0x001a }
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "checkRecover publicRestAccUinEven";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x001a }
    L_0x005b:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x005d:
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "operatorCallback is null";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x001a }
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.acw():void");
    }

    public static int V(List<t> list) {
        int i = 0;
        for (t tVar : list) {
            try {
                i = ((ei) new ei().aD(com.tencent.mm.a.e.d(h.aan() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.d.rD(tVar.ID) + tVar.ID, 0, -1))).jNe.size() + i;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            }
        }
        return i;
    }

    public final void bF(int i, int i2) {
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        if ((i == 0 && i2 == 0) || i3 > this.jMb) {
            this.jMb = i3;
            if (!(this.fKF || this.htv || this.jLG == null || this.jMb < 0 || this.jMb > 100)) {
                this.jLG.jD(this.jMb);
            }
            ab abVar = new ab();
            abVar.jMP = 13;
            abVar.jOq = 0;
            abVar.jOr = this.jMb;
            try {
                w.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[]{Integer.valueOf(i3)});
                com.tencent.mm.plugin.backup.f.b.r(abVar.toByteArray(), 3);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                w.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            }
        }
    }

    public final int a(String str, HashMap<String, Integer> hashMap, c cVar, HashSet<String> hashSet) {
        long currentTimeMillis = System.currentTimeMillis();
        byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
        try {
            ei eiVar = (ei) new ei().aD(d);
            Iterator it = eiVar.jNe.iterator();
            while (it.hasNext()) {
                eh ehVar = (eh) it.next();
                if (this.fKF && !this.htv) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        }
                    }
                }
                if (this.htv) {
                    w.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    return -1;
                }
                try {
                    com.tencent.mm.plugin.backup.e.a.b.a(ehVar, hashMap, hashSet, new HashMap());
                    this.jLH++;
                    if (this.jLH % 100 == 0) {
                        acx();
                    }
                } catch (Throwable e2) {
                    w.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e2.toString());
                    w.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                }
                com.tencent.mm.plugin.backup.b.f.jh(ehVar.jOc);
                cVar.abQ();
            }
            com.tencent.mm.plugin.backup.b.f.aav();
            w.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            return eiVar.jNe.size();
        } catch (Throwable e3) {
            Throwable th = e3;
            String str2 = "MicroMsg.RecoverPCServer";
            String str3 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = th;
            objArr[2] = Integer.valueOf(d == null ? 0 : d.length);
            w.e(str2, str3, objArr);
            w.printErrStackTrace("MicroMsg.RecoverPCServer", th, "", new Object[0]);
            return 0;
        }
    }

    public final void acx() {
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        w.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[]{Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.jLH)});
    }

    public final void a(int i, int i2, k kVar) {
        this.jMe += (long) i;
        int i3 = this.jMd == 0 ? 0 : (int) ((this.jMe * 100) / this.jMd);
        if (i3 > this.jMf) {
            this.jMf = i3;
            com.tencent.mm.plugin.backup.bakoldlogic.c.c.setProgress(this.jMf);
        }
        if (this.fKF || this.htv || this.jLG == null || this.jMf < 0 || this.jMf > 100) {
            w.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[]{Integer.valueOf(this.jMf)});
        } else {
            this.jLG.jC(this.jMf);
        }
    }
}
