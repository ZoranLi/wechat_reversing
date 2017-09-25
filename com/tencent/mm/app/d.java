package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.r;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.s;
import com.tencent.mm.u.br;
import com.tencent.mm.y.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public final class d implements ServiceConnection {
    private static boolean fvP = false;
    private static Object lock = new Object();
    public ReentrantLock fvQ = new ReentrantLock();
    private boolean fvR = false;
    public IBinder fvS = null;
    private Runnable fvT = new Runnable(this) {
        final /* synthetic */ d fvU;
        private int fvX = 0;

        {
            this.fvU = r2;
        }

        public final void run() {
            int i = 0;
            try {
                this.fvU.fvQ.lock();
                boolean z = this.fvU.fvS != null && this.fvU.fvS.isBinderAlive();
                w.i("MicroMsg.CoreServiceConnection", "mZombieWaker run serviceBinder: %s, binderAlive: %b", this.fvU.fvS, Boolean.valueOf(z));
                if (z) {
                    w.w("MicroMsg.CoreServiceConnection", "mZombieWaker run binderAlive return directly.");
                    return;
                }
                this.fvU.fvQ.unlock();
                w.e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", new Object[]{Integer.valueOf(this.fvX)}));
                if (this.fvX == 1) {
                    int bh = d.bh("com.tencent.mm:push");
                    if (bh != -1) {
                        w.i("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", new Object[]{Integer.valueOf(bh)}));
                        w.bIP();
                        Process.killProcess(bh);
                    } else {
                        w.i("MicroMsg.CoreServiceConnection", "Push Process not found.");
                    }
                }
                Context context = ab.getContext();
                Intent intent = new Intent(context, CoreService.class);
                try {
                    w.i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                    context.unbindService(this.fvU);
                } catch (Exception e) {
                } finally {
                    context.stopService(intent);
                    i = this.fvU;
                    context.bindService(intent, i, 1);
                    context.startService(intent);
                }
                if (this.fvX == 1) {
                    this.fvX = i;
                } else {
                    this.fvX++;
                }
                af.f(this, 10000);
                w.i("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", new Object[]{Integer.valueOf(this.fvX)}));
            } finally {
                this.fvU.fvQ.unlock();
            }
        }
    };

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        w.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        synchronized (lock) {
            w.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
            af.I(this.fvT);
            fvP = false;
        }
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            b.r("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        try {
            this.fvQ.lock();
            this.fvR = false;
            this.fvS = iBinder;
            e pVar = new p(a.B(iBinder));
            try {
                pVar.htq.a(new r.a(this) {
                    final /* synthetic */ d fvU;

                    {
                        this.fvU = r1;
                    }

                    public final boolean oc() {
                        return true;
                    }
                });
            } catch (Throwable e) {
                w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e));
            }
            try {
                pVar.htq.a(new g.a(this) {
                    final /* synthetic */ d fvU;

                    {
                        this.fvU = r1;
                    }

                    public final void cR(final int i) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 fvW;

                            public final void run() {
                                if (com.tencent.mm.kernel.b.vb() != null) {
                                    com.tencent.mm.kernel.b.vb().ey(i);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable e2) {
                w.e("MicroMsg.RDispatcher", "exception:%s", bg.g(e2));
            }
            h.vJ();
            com.tencent.mm.kernel.b vH = h.vH();
            w.w("MMKernel.CoreNetwork", "setting up remote dispatcher " + pVar);
            vH.gXB.b(pVar);
            try {
                if (pVar.Cd() != null) {
                    pVar.Cd().c(vH.gXE);
                }
            } catch (Throwable e22) {
                w.e("MMKernel.CoreNetwork", "exception:%s", bg.g(e22));
            }
            pVar.a(new com.tencent.mm.protocal.ab.a(vH) {
                final /* synthetic */ b gXG;
                private byte[] gXJ;

                {
                    this.gXG = r1;
                }

                public final byte[] vf() {
                    if (!h.vG().uV()) {
                        return null;
                    }
                    com.tencent.mm.protocal.aa.a aVar = new com.tencent.mm.protocal.aa.a();
                    h.vJ();
                    h.vG();
                    aVar.uin = a.uH();
                    h.vJ();
                    aVar.hKD = bg.PT((String) h.vI().vr().get(8195, null));
                    aVar.netType = com.tencent.mm.protocal.a.getNetType(ab.getContext());
                    aVar.sZE = com.tencent.mm.protocal.a.bGY();
                    try {
                        byte[] zh = aVar.zh();
                        this.gXJ = aVar.gXJ;
                        return zh;
                    } catch (Throwable e) {
                        w.e("MMKernel.CoreNetwork", "exception:%s", bg.g(e));
                        return null;
                    }
                }

                public final int w(byte[] bArr) {
                    int i = 0;
                    com.tencent.mm.protocal.aa.b bVar = new com.tencent.mm.protocal.aa.b();
                    try {
                        bVar.y(bArr);
                        return (int) bVar.taj;
                    } catch (Throwable e) {
                        w.e("MMKernel.CoreNetwork", "exception:%s", bg.g(e));
                        return i;
                    }
                }

                public final byte[] vg() {
                    return this.gXJ;
                }
            });
            c Cc = pVar.Cc();
            if (Cc == null) {
                w.f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
                vH.gXC.reset();
                vH.gXC.BU();
            } else {
                String str;
                b.a(new com.tencent.mm.sdk.a.a(vH) {
                    final /* synthetic */ b gXG;

                    {
                        this.gXG = r1;
                    }

                    public final void ed(String str) {
                        w.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", str);
                        h.vJ();
                        if (h.vK() != null) {
                            h.vJ();
                            br vK = h.vK();
                            vK.aJi = true;
                            for (com.tencent.mm.u.br.a aVar : vK.hop) {
                                if (aVar != null) {
                                    aVar.Aa();
                                }
                            }
                            vK.aJi = false;
                        }
                        h.vJ();
                        if (h.vI() != null) {
                            h.vJ();
                            h.vI().cQ(str);
                        }
                    }
                });
                h.vJ();
                s sVar = h.vI().gXW;
                Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + bg.bJZ(), sVar != null);
                int yA = sVar.yA(47);
                String str2 = (String) sVar.get(2);
                String str3 = (String) sVar.get(3);
                String str4 = (String) sVar.get(25);
                String str5 = (String) sVar.get(24);
                n.a et = n.et((String) sVar.get(6), (String) sVar.get(7));
                w.d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", str5, str4, str2, str3, str, r6, Integer.valueOf(yA));
                Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + bg.bJZ(), true);
                pVar.a(false, str2, str3, et.sZI, et.sZJ, et.sZK, et.sZL, str5, str4);
                pVar.bc((yA & 1) == 0);
                h.vJ();
                h.vG();
                Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + bg.bJZ(), Cc != null);
                if (h.vG().uV() && h.vG().gXp) {
                    vH.gXC.d(pVar);
                    com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a(vH) {
                        final /* synthetic */ b gXG;

                        {
                            this.gXG = r1;
                        }

                        public final e vh() {
                            try {
                                return this.gXG.gXC.hsZ;
                            } catch (Throwable th) {
                                w.e("MMKernel.CoreNetwork", "%s", bg.g(th));
                                return null;
                            }
                        }
                    });
                    w.i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d], acc init[%b]", Integer.valueOf(com.tencent.mm.kernel.a.uH()), Integer.valueOf(Cc.uH()), Boolean.valueOf(h.vG().uV()));
                    if (com.tencent.mm.kernel.a.uH() != Cc.uH()) {
                        w.w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + Cc.uH());
                        str = "setAutoAuth, getConfigStg() is null, stack = " + bg.bJZ();
                        h.vJ();
                        Assert.assertTrue(str, h.vI().vr() != null);
                        h.vJ();
                        String str6 = (String) h.vI().vr().get(2, null);
                        Cc.i(new byte[0], com.tencent.mm.kernel.a.uH());
                        Cc.setUsername(str6);
                    }
                } else {
                    w.w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b isInitializedNotifyAllDone:%b", Boolean.valueOf(h.vG().uV()), Boolean.valueOf(h.vG().gXp));
                    com.tencent.mm.plugin.report.c.oTb.a(148, h.vG().uV() ? 44 : 43, 1, false);
                    Cc.reset();
                    pVar.reset();
                    vH.gXC.d(pVar);
                    com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a(vH) {
                        final /* synthetic */ b gXG;

                        {
                            this.gXG = r1;
                        }

                        public final e vh() {
                            try {
                                return this.gXG.gXC.hsZ;
                            } catch (Throwable th) {
                                w.e("MMKernel.CoreNetwork", "%s", bg.g(th));
                                return null;
                            }
                        }
                    });
                    if (com.tencent.mm.kernel.a.uH() != Cc.uH()) {
                        com.tencent.mm.plugin.report.c.oTb.a(148, 45, 1, false);
                        w.w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d, acc init %b %b", Integer.valueOf(Cc.uH()), Integer.valueOf(com.tencent.mm.kernel.a.uH()), Boolean.valueOf(h.vG().uV()), Boolean.valueOf(h.vG().gXp));
                        Cc.dj(com.tencent.mm.kernel.a.uH());
                    } else {
                        w.i("MMKernel.CoreNetwork", "acc info uin same with acc stg", Integer.valueOf(Cc.uH()), Integer.valueOf(com.tencent.mm.kernel.a.uH()));
                    }
                }
            }
            if (com.tencent.mm.u.a.wI()) {
                try {
                    h.vJ();
                    if (h.vG().gXj != null) {
                        h.vJ();
                        if (h.vH().gXC.hsZ != null) {
                            h.vJ();
                            com.tencent.mm.u.a aVar = h.vG().gXj;
                            h.vJ();
                            c Cc2 = h.vH().gXC.hsZ.Cc();
                            long Nz = bg.Nz();
                            if (Cc2 == null) {
                                w.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                                com.tencent.mm.plugin.report.c.oTb.a(226, 6, 1, false);
                            } else {
                                w.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", Boolean.valueOf(Cc2.BY()), Integer.valueOf(aVar.wH()));
                                if (Cc2.BY()) {
                                    if (aVar.wH() > 0) {
                                        com.tencent.mm.plugin.report.c.oTb.a(226, 7, 1, false);
                                        w.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                                        aVar.hkG = null;
                                    } else {
                                        w.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                                        com.tencent.mm.plugin.report.c.oTb.a(226, 8, 1, false);
                                    }
                                    aVar.hkG = Cc2.Cb();
                                    com.tencent.mm.plugin.report.c.oTb.a(226, aVar.wH() > 0 ? 9 : 10, 1, false);
                                } else if (aVar.wH() <= 0) {
                                    com.tencent.mm.plugin.report.c.oTb.a(226, 11, 1, false);
                                    w.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", aVar.toString());
                                } else {
                                    int A = Cc2.A(aVar.hkG);
                                    w.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", Integer.valueOf(A), Long.valueOf(bg.aA(Nz)), Integer.valueOf(aVar.wH()));
                                    if (A != 0) {
                                        w.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(A));
                                        aVar.hkG = null;
                                    } else {
                                        aVar.hkH = 0;
                                    }
                                    com.tencent.mm.plugin.report.c.oTb.a(226, (long) (A + 20), 1, false);
                                }
                            }
                        }
                    }
                    r4 = new Object[2];
                    h.vJ();
                    r4[0] = h.vG().gXj;
                    h.vJ();
                    r4[1] = h.vH().gXC.hsZ;
                    w.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", r4);
                } catch (Throwable th) {
                    w.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", bg.g(th));
                }
            }
            if (h.vG().uV()) {
                h.vJ();
                if (h.vH().gXC != null) {
                    h.vJ();
                    if (h.vH().gXC.hsZ != null) {
                        h.vJ();
                        h.vH().gXC.hsZ.ba(true);
                    }
                }
            }
        } finally {
            this.fvQ.unlock();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        w.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        try {
            this.fvQ.lock();
            this.fvR = false;
            this.fvS = null;
            h.vG();
            if (!com.tencent.mm.kernel.a.uU() || com.tencent.mm.kernel.a.uP()) {
                h.vJ();
                h.vH().gXC.BU();
                h.vJ();
                h.vH().gXC.reset();
                return;
            }
            h.vJ();
            h.vH().gXC.BT();
            ad(ab.getContext());
        } finally {
            this.fvQ.unlock();
        }
    }

    public final void ad(Context context) {
        boolean z = false;
        try {
            this.fvQ.lock();
            if (this.fvS != null && this.fvS.isBinderAlive()) {
                z = true;
            }
            w.i("MicroMsg.CoreServiceConnection", "enter bindCore, isBinding: %b, binderAlive: %b", Boolean.valueOf(this.fvR), Boolean.valueOf(z));
            if (this.fvR || z) {
                w.w("MicroMsg.CoreServiceConnection", "bindCore reenter, isBinding: %b, binderAlive: %b, return directly.", Boolean.valueOf(this.fvR), Boolean.valueOf(z));
                return;
            }
            this.fvQ.unlock();
            if (com.tencent.mm.booter.b.r(context, "noop")) {
                Intent intent = new Intent(context, CoreService.class);
                w.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                if (context.bindService(intent, this, 1)) {
                    try {
                        this.fvQ.lock();
                        this.fvR = true;
                        synchronized (lock) {
                            if (!fvP) {
                                fvP = true;
                                w.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                af.f(this.fvT, 10000);
                            }
                        }
                        return;
                    } finally {
                        this.fvQ.unlock();
                    }
                } else {
                    w.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                    return;
                }
            }
            w.i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
        } finally {
            this.fvQ.unlock();
        }
    }

    public static int bh(String str) {
        Throwable th;
        Throwable th2;
        int i = -1;
        BufferedReader bufferedReader = null;
        for (File file : new File("/proc").listFiles()) {
            BufferedReader bufferedReader2;
            try {
                i = bg.getInt(file.getName(), -1);
                try {
                    File file2 = new File(file, "cmdline");
                    if (file2.canRead()) {
                        bufferedReader2 = new BufferedReader(new FileReader(file2));
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null && readLine.startsWith(str)) {
                                if (readLine.length() == str.length()) {
                                    w.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", str, Integer.valueOf(i));
                                    try {
                                        bufferedReader2.close();
                                        break;
                                    } catch (Throwable th3) {
                                    }
                                } else {
                                    char charAt = readLine.charAt(str.length());
                                    if (charAt <= ' ' || charAt >= '') {
                                        w.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", str, Integer.valueOf(i));
                                        try {
                                            bufferedReader2.close();
                                            break;
                                        } catch (Throwable th4) {
                                        }
                                    }
                                }
                            }
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th5) {
                            }
                            bufferedReader = null;
                        } catch (Throwable th6) {
                            th2 = th6;
                        }
                    } else if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th7) {
                        }
                        bufferedReader = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    w.printErrStackTrace("MicroMsg.CoreServiceConnection", th, "read cmdline.", new Object[0]);
                    w.bIP();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        bufferedReader = null;
                    }
                }
            } catch (Throwable th9) {
                w.printErrStackTrace("MicroMsg.CoreServiceConnection", th9, "", new Object[0]);
            }
        }
        return i;
        throw th2;
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
            } catch (Throwable th10) {
            }
        }
        throw th2;
    }
}
