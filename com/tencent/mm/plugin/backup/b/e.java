package com.tencent.mm.plugin.backup.b;

import android.util.Pair;
import com.tencent.mm.e.a.qg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static boolean jCT = false;
    public boolean htv;
    public final com.tencent.mm.plugin.backup.a.e jBV;
    public final int jBq;
    private boolean jCK = false;
    public final HashMap<String, String> jCL = ap.yY().xG().bKN();
    public HashSet<String> jCM = new HashSet();
    public final int jCN;
    private long jCO = 0;
    public d jCP;
    public b jCQ = ((b) h.h(b.class));
    private c<qg> jCR;
    public boolean jCS = false;
    private HashMap<String, Pair<Long, Long>> jCU;
    private Object lock = new Object();

    public e(com.tencent.mm.plugin.backup.a.e eVar, int i, d dVar, int i2, boolean z, LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        w.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap size[%d], backupMode[%d], totalSession[%d], isQuickBackup[%b]", new Object[]{Integer.valueOf(this.jCL.size()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        this.jBV = eVar;
        this.jBq = i;
        this.jCP = dVar;
        this.jCN = i2;
        jCT = z;
        this.jCU = a(linkedList, linkedList2);
        this.jCM.clear();
    }

    private static HashMap<String, Pair<Long, Long>> a(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        HashMap<String, Pair<Long, Long>> hashMap = new HashMap();
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (longValue == 0) {
                    longValue = Long.MIN_VALUE;
                }
                if (!it.hasNext()) {
                    break;
                }
                long longValue2 = ((Long) it.next()).longValue();
                if (longValue2 == 0) {
                    longValue2 = Long.MAX_VALUE;
                }
                hashMap.put(str, new Pair(Long.valueOf(longValue), Long.valueOf(longValue2)));
            }
        }
        return hashMap;
    }

    public final synchronized void aas() {
        if (this.jCK) {
            w.e("MicroMsg.BackupRecoverMerger", "hasStartMerge , return");
        } else {
            this.jCK = true;
            w.i("MicroMsg.BackupRecoverMerger", "startMerge, call pause sync");
            if (this.jCR == null) {
                this.jCR = new c<qg>(this) {
                    final /* synthetic */ e jCV;

                    {
                        this.jCV = r2;
                        this.usg = qg.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        if (this.jCV.jCQ.bCi().zY()) {
                            this.jCV.aau();
                            w.i("MicroMsg.BackupRecoverMerger", "sync pause and start init tempdb");
                            if (this.jCV.jCP != null) {
                                this.jCV.jCP.cD(true);
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            ap.yY();
                            com.tencent.mm.a.e.d(new File(stringBuilder.append(com.tencent.mm.u.c.vo()).append(".tem").toString()));
                            stringBuilder = new StringBuilder();
                            ap.yY();
                            com.tencent.mm.a.e.d(new File(stringBuilder.append(com.tencent.mm.u.c.vp()).append(".tem").toString()));
                            a.abC().a(new a.a(this) {
                                final /* synthetic */ AnonymousClass1 jCW;

                                {
                                    this.jCW = r1;
                                }

                                public final void run() {
                                    if (this.jCW.jCV.jCP != null) {
                                        this.jCW.jCV.jCP.cD(false);
                                    }
                                    e eVar = this.jCW.jCV;
                                    com.tencent.mm.sdk.a.b.jQ(true);
                                    eVar.jCS = true;
                                    if (eVar.jBq == 1) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFx, Boolean.valueOf(true));
                                    } else if (eVar.jBq == 2) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFA, Boolean.valueOf(true));
                                    }
                                    w.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp start, isMerging[%b], totalSession size[%d], msgListDataIdHashMap size[%d]", new Object[]{Boolean.valueOf(eVar.jCS), Integer.valueOf(eVar.jCN), Integer.valueOf(eVar.jCL.size())});
                                    com.tencent.mm.sdk.f.e.d(new Runnable(eVar) {
                                        final /* synthetic */ e jCV;

                                        {
                                            this.jCV = r1;
                                        }

                                        public final void run() {
                                            f.reset();
                                            f.aaw();
                                            d dVar = new d();
                                            dVar.begin();
                                            HashMap hashMap = new HashMap();
                                            for (String str : this.jCV.jCL.keySet()) {
                                                try {
                                                    this.jCV.a(com.tencent.mm.plugin.backup.a.h.aan() + "backupItem/" + com.tencent.mm.plugin.backup.a.h.rD(str) + str, hashMap, dVar);
                                                    if (this.jCV.htv) {
                                                        dVar.end();
                                                        w.w("MicroMsg.BackupRecoverMerger", "Thread has been canceled msgDataId[%s], transferSessions size[%d], isCancel[%b]", new Object[]{str, Integer.valueOf(this.jCV.jCM.size()), Boolean.valueOf(this.jCV.htv)});
                                                        return;
                                                    }
                                                    if (!this.jCV.jCM.contains(this.jCV.jCL.get(str))) {
                                                        this.jCV.jCM.add(this.jCV.jCL.get(str));
                                                        this.jCV.jBV.aae().w(26, this.jCV.jCM.size() > this.jCV.jCN ? this.jCV.jCN : this.jCV.jCM.size(), this.jCV.jCN);
                                                        this.jCV.a(this.jCV.jBV.aae());
                                                        try {
                                                            Thread.sleep(10);
                                                        } catch (InterruptedException e) {
                                                        }
                                                    }
                                                    w.i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferSessions size[%d]", new Object[]{str, Integer.valueOf(this.jCV.jCM.size())});
                                                } catch (Throwable e2) {
                                                    w.printErrStackTrace("MicroMsg.BackupRecoverMerger", e2, "recoverFromSdcard MMThread.run():", new Object[0]);
                                                }
                                            }
                                            com.tencent.mm.plugin.backup.g.d.d(hashMap);
                                            w.i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferSession:%s totalSession:%d", new Object[]{Integer.valueOf(this.jCV.jCM.size()), Integer.valueOf(this.jCV.jCN)});
                                            dVar.end();
                                            if (com.tencent.mm.sdk.a.b.bIu()) {
                                                this.jCV.jBV.aae().jBv = this.jCV.jCM.size() > this.jCV.jCN ? this.jCV.jCN : this.jCV.jCM.size();
                                            } else {
                                                this.jCV.jBV.aae().jBv = this.jCV.jCN;
                                            }
                                            this.jCV.jBV.aae().jBw = this.jCV.jCN;
                                            w.bIP();
                                            if (this.jCV.jCP != null) {
                                                this.jCV.jCP.cD(true);
                                            }
                                            a.abC().n(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass2 jCX;

                                                {
                                                    this.jCX = r1;
                                                }

                                                public final void run() {
                                                    w.i("MicroMsg.BackupRecoverMerger", "readFromSdcard end");
                                                    w.bIP();
                                                    if (this.jCX.jCV.jCP != null) {
                                                        this.jCX.jCV.jCP.cD(false);
                                                    }
                                                    com.tencent.mm.sdk.a.b.jQ(false);
                                                    this.jCX.jCV.jCQ.bCi().zU();
                                                    this.jCX.jCV.aau();
                                                    w.i("MicroMsg.BackupRecoverMerger", "recover ok and restart sync");
                                                    this.jCX.jCV.jCS = false;
                                                    if (this.jCX.jCV.jBq == 1) {
                                                        ap.yY();
                                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFx, Boolean.valueOf(false));
                                                    } else if (this.jCX.jCV.jBq == 2) {
                                                        ap.yY();
                                                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFA, Boolean.valueOf(false));
                                                    }
                                                    if (this.jCX.jCV.jCP != null) {
                                                        this.jCX.jCV.jCP.aac();
                                                    }
                                                    ap.yY().xF().bKQ();
                                                    ap.yY().xG().bKQ();
                                                    this.jCX.jCV.jBV.aae().w(27, this.jCX.jCV.jCM.size() > this.jCX.jCV.jCN ? this.jCX.jCV.jCN : this.jCX.jCV.jCM.size(), this.jCX.jCV.jCN);
                                                    this.jCX.jCV.a(this.jCX.jCV.jBV.aae());
                                                    this.jCX.jCV.aat();
                                                    this.jCX.jCV.jBV.aag();
                                                }
                                            });
                                        }
                                    }, "RecoverMerger_recoverFromSdcard", 1).start();
                                }
                            }, true, this.jCV.jBq);
                        }
                        return false;
                    }
                };
                com.tencent.mm.sdk.b.a.urY.b(this.jCR);
            }
            this.jCQ.bCi().O(3600000);
            this.jBV.aaf();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r13, java.util.HashMap<java.lang.String, java.lang.Integer> r14, com.tencent.mm.plugin.backup.b.d r15) {
        /*
        r12 = this;
        r4 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r0 = 0;
        r1 = -1;
        r2 = com.tencent.mm.a.e.d(r13, r0, r1);
        r0 = new com.tencent.mm.protocal.c.ei;	 Catch:{ Exception -> 0x003a }
        r0.<init>();	 Catch:{ Exception -> 0x003a }
        r0 = r0.aD(r2);	 Catch:{ Exception -> 0x003a }
        r0 = (com.tencent.mm.protocal.c.ei) r0;	 Catch:{ Exception -> 0x003a }
        r1 = r0.jNe;
        r3 = r1.iterator();
    L_0x001b:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x0118;
    L_0x0021:
        r1 = r3.next();
        r1 = (com.tencent.mm.protocal.c.eh) r1;
        r2 = r12.lock;
        monitor-enter(r2);
        r6 = r12.htv;	 Catch:{ all -> 0x0107 }
        if (r6 == 0) goto L_0x00bb;
    L_0x002e:
        r0 = "MicroMsg.BackupRecoverMerger";
        r1 = "backupImp canceled";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ all -> 0x0107 }
        r0 = -1;
        monitor-exit(r2);	 Catch:{ all -> 0x0107 }
    L_0x0039:
        return r0;
    L_0x003a:
        r0 = move-exception;
        r1 = r0;
        r0 = "";
        r3 = new java.io.File;	 Catch:{ Exception -> 0x013d }
        r3.<init>(r13);	 Catch:{ Exception -> 0x013d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013d }
        r4.<init>();	 Catch:{ Exception -> 0x013d }
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x013d }
        r5 = r3.exists();	 Catch:{ Exception -> 0x013d }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x013d }
        r5 = ",";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x013d }
        r0 = r4.toString();	 Catch:{ Exception -> 0x013d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013d }
        r4.<init>();	 Catch:{ Exception -> 0x013d }
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x013d }
        r5 = r3.canRead();	 Catch:{ Exception -> 0x013d }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x013d }
        r5 = ",";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x013d }
        r0 = r4.toString();	 Catch:{ Exception -> 0x013d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013d }
        r4.<init>();	 Catch:{ Exception -> 0x013d }
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x013d }
        r6 = r3.length();	 Catch:{ Exception -> 0x013d }
        r3 = r4.append(r6);	 Catch:{ Exception -> 0x013d }
        r4 = ".";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x013d }
        r0 = r3.toString();	 Catch:{ Exception -> 0x013d }
    L_0x0098:
        r3 = "MicroMsg.BackupRecoverMerger";
        r4 = "read mmPath errr %s [%s] buflen:%d %s,";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r13;
        r6 = 1;
        r5[r6] = r0;
        r6 = 2;
        if (r2 != 0) goto L_0x00b9;
    L_0x00aa:
        r0 = -1;
    L_0x00ab:
        r0 = java.lang.Integer.valueOf(r0);
        r5[r6] = r0;
        r0 = 3;
        r5[r0] = r1;
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r1, r4, r5);
        r0 = 0;
        goto L_0x0039;
    L_0x00b9:
        r0 = r2.length;
        goto L_0x00ab;
    L_0x00bb:
        r6 = r12.jCO;	 Catch:{ all -> 0x0107 }
        r6 = com.tencent.mm.sdk.platformtools.bg.aA(r6);	 Catch:{ all -> 0x0107 }
        r8 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x00da;
    L_0x00c8:
        r6 = r12.jCQ;	 Catch:{ all -> 0x0107 }
        r6 = r6.bCi();	 Catch:{ all -> 0x0107 }
        r8 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r6.O(r8);	 Catch:{ all -> 0x0107 }
        r6 = com.tencent.mm.sdk.platformtools.bg.Nz();	 Catch:{ all -> 0x0107 }
        r12.jCO = r6;	 Catch:{ all -> 0x0107 }
    L_0x00da:
        monitor-exit(r2);	 Catch:{ all -> 0x0107 }
        r2 = jCT;
        if (r2 == 0) goto L_0x00e4;
    L_0x00df:
        r2 = r1.jOc;
        r6 = 1;
        if (r2 != r6) goto L_0x001b;
    L_0x00e4:
        r2 = 0;
        r6 = r12.jCU;	 Catch:{ Exception -> 0x010a }
        com.tencent.mm.plugin.backup.e.a.b.a(r1, r14, r2, r6);	 Catch:{ Exception -> 0x010a }
    L_0x00ea:
        r1 = r1.jOc;
        com.tencent.mm.plugin.backup.b.f.jh(r1);
        r6 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r8 = r15.hnT;
        r8 = r6 - r8;
        r10 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r1 <= 0) goto L_0x001b;
    L_0x00fd:
        r15.end();
        r15.begin();
        r15.hnT = r6;
        goto L_0x001b;
    L_0x0107:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0107 }
        throw r0;
    L_0x010a:
        r2 = move-exception;
        r6 = "MicroMsg.BackupRecoverMerger";
        r7 = "readFromSdcard recoverMsg err";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r2, r7, r8);
        goto L_0x00ea;
    L_0x0118:
        com.tencent.mm.plugin.backup.b.f.aav();
        r1 = "MicroMsg.BackupRecoverMerger";
        r2 = new java.lang.StringBuilder;
        r3 = "readFromSdcard merge item time:";
        r2.<init>(r3);
        r4 = com.tencent.mm.sdk.platformtools.bg.aA(r4);
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r0 = r0.jNe;
        r0 = r0.size();
        goto L_0x0039;
    L_0x013d:
        r3 = move-exception;
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.b.e.a(java.lang.String, java.util.HashMap, com.tencent.mm.plugin.backup.b.d):int");
    }

    public final void f(final boolean z, final int i) {
        synchronized (this.lock) {
            w.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], isMerging[%b]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.jCS)});
            this.htv = true;
            if (this.jCS) {
                if (this.jCP != null) {
                    this.jCP.cD(true);
                }
                a.abC().n(new Runnable(this) {
                    final /* synthetic */ e jCV;

                    public final void run() {
                        w.i("MicroMsg.BackupRecoverMerger", "cancel recoverFromTempDb end");
                        w.bIP();
                        if (this.jCV.jCP != null) {
                            this.jCV.jCP.cD(false);
                        }
                        com.tencent.mm.sdk.a.b.jQ(false);
                        if (z) {
                            if (this.jCV.jBq == 1) {
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFx, Boolean.valueOf(false));
                            } else if (this.jCV.jBq == 2) {
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFA, Boolean.valueOf(false));
                            }
                            ap.yY().xF().bKQ();
                            ap.yY().xG().bKQ();
                        }
                        this.jCV.jCQ.bCi().zU();
                        this.jCV.aau();
                        w.i("MicroMsg.BackupRecoverMerger", "cancel and restart sync");
                        this.jCV.jCS = false;
                        if (i != 0) {
                            this.jCV.jBV.aae().jBu = i;
                            this.jCV.a(this.jCV.jBV.aae());
                        }
                        this.jCV.aat();
                        this.jCV.jBV.aag();
                    }
                });
            } else {
                if (z) {
                    if (this.jBq == 1) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFx, Boolean.valueOf(false));
                    } else if (this.jBq == 2) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFA, Boolean.valueOf(false));
                    }
                    ap.yY().xF().bKQ();
                    ap.yY().xG().bKQ();
                }
                this.jCQ.bCi().zU();
                aau();
                w.i("MicroMsg.BackupRecoverMerger", "cancel and restart sync");
                this.jCS = false;
                if (i != 0) {
                    this.jBV.aae().jBu = i;
                    a(this.jBV.aae());
                }
                aat();
                this.jBV.aag();
            }
        }
    }

    public final void aat() {
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        this.jCK = false;
    }

    public final void aau() {
        if (this.jCR != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.jCR);
            this.jCR = null;
        }
    }

    public final void a(f fVar) {
        if (this.jCP != null) {
            this.jCP.a(fVar);
        }
    }
}
