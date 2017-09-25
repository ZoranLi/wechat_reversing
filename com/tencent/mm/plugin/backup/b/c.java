package com.tencent.mm.plugin.backup.b;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.d;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class c {
    public boolean jBT = false;
    public com.tencent.mm.plugin.backup.a.b.b jBU;
    public e jBV;
    public long jBW = 0;
    public long jBX = 0;
    private int jBq;

    private class a {
        final /* synthetic */ c jCc;
        volatile AtomicLong jCe = new AtomicLong(0);
        ac jCf = new ac(true);
        ac jCg = new ac(true);

        public a(c cVar) {
            this.jCc = cVar;
        }
    }

    private class b {
        public String TAG;
        public String aIO;
        public String fJL;
        public long jBi;
        public long jBj;
        public int jBz;
        final /* synthetic */ c jCc;
        public LinkedBlockingQueue<Runnable> jCh;
        public a jCi;
        long jCj;
        public String jCk;
        public Vector<String> jCl;
        Vector<eh> jCm;
        public HashMap<Long, com.tencent.mm.plugin.backup.e.a.c> jCn;
        public long jCo;
        public boolean jCp;
        private final com.tencent.mm.plugin.backup.f.c.b jCq;
        private final Runnable jCr;
        public final Runnable jCs;

        public final String toString() {
            return this.TAG;
        }

        public b(c cVar, a aVar, g gVar) {
            String E;
            this.jCc = cVar;
            this.TAG = "";
            this.jCh = new LinkedBlockingQueue();
            this.jCi = null;
            this.jBi = 0;
            this.jBj = 0;
            this.jCj = 0;
            this.jCk = "";
            this.jCl = new Vector();
            this.jCm = new Vector();
            this.jCn = new HashMap();
            this.jCo = 0;
            this.jCp = false;
            this.jCq = new com.tencent.mm.plugin.backup.f.c.b(this) {
                final /* synthetic */ b jCt;

                {
                    this.jCt = r1;
                }

                public final void c(boolean z, String str, int i) {
                    a aVar = this.jCt.jCi;
                    long j = (long) i;
                    aVar.jCe.addAndGet(0 - j);
                    if (aVar.jCe.get() < 8388608) {
                        aVar.jCf.open();
                    }
                    if (aVar.jCe.get() < 16777216) {
                        aVar.jCg.open();
                    }
                    String str2 = "MicroMsg.BackupPackAndSend";
                    String str3 = "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]";
                    Object[] objArr = new Object[6];
                    objArr[0] = Long.valueOf(j);
                    objArr[1] = Long.valueOf(aVar.jCe.get());
                    objArr[2] = Boolean.valueOf(aVar.jCe.get() >= 8388608);
                    objArr[3] = Boolean.valueOf(aVar.jCe.get() >= 16777216);
                    objArr[4] = Boolean.valueOf(aVar.jCf.uta);
                    objArr[5] = Boolean.valueOf(aVar.jCg.uta);
                    w.v(str2, str3, objArr);
                    this.jCt.jCc.jBW += (long) i;
                    w.i(this.jCt.TAG, "OnfinishIdCallback size:%d finishid:%b [%s] ", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), str});
                }
            };
            this.jCr = new Runnable(this) {
                final /* synthetic */ b jCt;

                {
                    this.jCt = r1;
                }

                public final String toString() {
                    return this.jCt.TAG + ".reqBigFile";
                }

                public final void run() {
                    boolean z = true;
                    Assert.assertTrue(toString() + ", check running. ", this.jCt.jCp);
                    w.i(this.jCt.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[]{Integer.valueOf(this.jCt.jCn.size()), Long.valueOf(bg.aA(this.jCt.jCo)), ah.bJn()});
                    String str = "BigFileMap should not Empty";
                    if (this.jCt.jCn.isEmpty()) {
                        z = false;
                    }
                    Assert.assertTrue(str, z);
                    new h(this.jCt.fJL, this.jCt.jCn, new com.tencent.mm.plugin.backup.f.h.a(this) {
                        final /* synthetic */ AnonymousClass3 jCx;

                        {
                            this.jCx = r1;
                        }

                        public final void v(final LinkedList<Long> linkedList) {
                            com.tencent.mm.sdk.f.e.b(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 jCz;

                                public final void run() {
                                    int i = 0;
                                    while (linkedList != null && i < linkedList.size()) {
                                        Long l = (Long) linkedList.get(i);
                                        com.tencent.mm.plugin.backup.e.a.c cVar = (com.tencent.mm.plugin.backup.e.a.c) this.jCz.jCx.jCt.jCn.get(l);
                                        String str = this.jCz.jCx.jCt.TAG;
                                        String str2 = "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s";
                                        Object[] objArr = new Object[5];
                                        objArr[0] = Integer.valueOf(i);
                                        objArr[1] = Integer.valueOf(linkedList.size());
                                        objArr[2] = l;
                                        objArr[3] = cVar == null ? "null" : cVar.jFG.mediaId;
                                        objArr[4] = cVar == null ? "null" : cVar.jFG.path;
                                        w.i(str, str2, objArr);
                                        if (cVar != null) {
                                            this.jCz.jCx.jCt.jCl.add(cVar.jFG.mediaId);
                                            this.jCz.jCx.jCt.g(cVar.jFG.mediaId, cVar.jFG.path, true);
                                        }
                                        i++;
                                    }
                                    this.jCz.jCx.jCt.jCh.offer(this.jCz.jCx.jCt.jCs);
                                }
                            }, "AddBigFileToQueue").start();
                        }
                    }).abt();
                }
            };
            this.jCs = new Runnable(this) {
                final /* synthetic */ b jCt;

                {
                    this.jCt = r1;
                }

                public final String toString() {
                    return this.jCt.TAG + ".sendTag";
                }

                public final void run() {
                    Assert.assertTrue(toString() + ", check running. ", this.jCt.jCp);
                    switch (e.aah()) {
                        case 1:
                            w.i(this.jCt.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[]{Integer.valueOf(this.jCt.jCc.jBV.aae().jBv), Long.valueOf(this.jCt.jBi), Long.valueOf(this.jCt.jBj), Integer.valueOf(this.jCt.jCl.size()), this.jCt.aIO, this.jCt.jCk, Long.valueOf(bg.aA(this.jCt.jCo))});
                            if (this.jCt.jCc.jBV.aae().jBv < this.jCt.jBz + 1) {
                                this.jCt.jCc.jBV.aae().jBv = this.jCt.jBz + 1;
                                this.jCt.jCc.jBU.a(this.jCt.jCc.jBV.aae());
                                break;
                            }
                            break;
                        case 21:
                        case 22:
                            w.i(this.jCt.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[]{Integer.valueOf(this.jCt.jCc.jBV.aae().jBv), Long.valueOf(this.jCt.jBi), Long.valueOf(this.jCt.jBj), Integer.valueOf(this.jCt.jCl.size()), this.jCt.aIO, this.jCt.jCk, Long.valueOf(bg.aA(this.jCt.jCo))});
                            if (this.jCt.jCc.jBV.aae().jBv < this.jCt.jBz + 1) {
                                this.jCt.jCc.jBV.aae().jBv = this.jCt.jBz + 1;
                                this.jCt.jCc.jBU.a(this.jCt.jCc.jBV.aae());
                                break;
                            }
                            break;
                    }
                    final boolean z = this.jCt.jBz == this.jCt.jCc.jBV.aae().jBw + -1;
                    final ac acVar = new ac(!z);
                    new d(this.jCt.fJL, this.jCt.jBi, this.jCt.jBj, this.jCt.jCk, this.jCt.aIO, new LinkedList(this.jCt.jCl), new com.tencent.mm.y.e(this) {
                        final /* synthetic */ AnonymousClass4 jCC;

                        public final void a(int i, int i2, String str, k kVar) {
                            w.i(this.jCC.jCt.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[]{Boolean.valueOf(z), acVar, Integer.valueOf(i), Integer.valueOf(i2), str, this.jCC.jCt.jCk, ((d) kVar).jHH.jOo});
                            if (z && this.jCC.jCt.jCk.equals(r0)) {
                                acVar.open();
                            }
                        }
                    }).abt();
                    if (z) {
                        w.w(this.jCt.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[]{Integer.valueOf(this.jCt.jBz), Integer.valueOf(this.jCt.jCc.jBV.aae().jBw - 1)});
                        acVar.block();
                    }
                    this.jCt.jCp = false;
                }
            };
            this.jCo = bg.Nz();
            this.jCi = aVar;
            this.fJL = gVar.jBy;
            this.jBz = gVar.jBz;
            if (o.dH(this.fJL)) {
                E = n.E(this.fJL, this.fJL);
            } else {
                E = n.eK(this.fJL);
            }
            this.aIO = E;
            this.TAG = "MicroMsg.BackupPackAndSend.tag" + (this.jCp ? "S." : "W.") + this.jBz + "." + this.aIO;
            w.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[]{Integer.valueOf(this.jBz), this.aIO, this.fJL, ah.bJn()});
        }

        public final boolean a(eh ehVar, long j, long j2, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.e.a.c> hashMap) {
            this.jCm.add(ehVar);
            this.jCj = (j > 0 ? j : 0) + this.jCj;
            if (this.jBi == 0) {
                this.jBi = j2;
            }
            this.jBj = j2;
            this.jCn.putAll(hashMap);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                g(uVar.mediaId, uVar.path, false);
            }
            w.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[]{Long.valueOf(this.jBi), Long.valueOf(this.jBj), Long.valueOf(j), Long.valueOf(this.jCj), Integer.valueOf(this.jCm.size()), Integer.valueOf(linkedList.size()), Long.valueOf(bg.aA(this.jCo))});
            if (this.jCj <= 83886080 && this.jCm.size() <= 80) {
                return false;
            }
            aar();
            return true;
        }

        public final void aar() {
            this.jCk = "MSG_" + this.jCm.size() + "_" + this.fJL + "_" + bg.Nz();
            w.i(this.TAG, "setTagEnd msgtime[%d,%d] size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[]{Long.valueOf(this.jBi), Long.valueOf(this.jBj), Long.valueOf(this.jCj), Integer.valueOf(this.jCm.size()), Integer.valueOf(this.jCn.size()), this.jCk, Long.valueOf(bg.aA(this.jCo))});
            if (this.jCm.size() > 0) {
                g(this.jCk, null, false);
                if (this.jCn.isEmpty()) {
                    this.jCh.offer(this.jCs);
                    return;
                } else {
                    this.jCh.offer(this.jCr);
                    return;
                }
            }
            w.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[]{Integer.valueOf(this.jCm.size()), Integer.valueOf(this.jCl.size()), Integer.valueOf(this.jCn.size())});
            Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.jCm.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.jCl.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, BigFileList should empyt", this.jCn.isEmpty());
            this.jCh.offer(this.jCs);
        }

        public final void g(String str, String str2, boolean z) {
            boolean z2 = true;
            com.tencent.mm.plugin.backup.f.c.c anonymousClass2 = new com.tencent.mm.plugin.backup.f.c.c(this) {
                final /* synthetic */ b jCt;

                {
                    this.jCt = r1;
                }

                public final void a(com.tencent.mm.plugin.backup.f.c cVar) {
                    final com.tencent.mm.plugin.backup.f.c cVar2;
                    final long Nz = bg.Nz();
                    a aVar = this.jCt.jCi;
                    long abx = (long) cVar.abx();
                    boolean z = this.jCt.jCp;
                    String str = "MicroMsg.BackupPackAndSend";
                    String str2 = "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]";
                    Object[] objArr = new Object[5];
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Long.valueOf(abx);
                    objArr[2] = Long.valueOf(aVar.jCe.get());
                    objArr[3] = Boolean.valueOf(aVar.jCe.get() >= 8388608);
                    objArr[4] = Boolean.valueOf(aVar.jCe.get() >= 16777216);
                    w.v(str, str2, objArr);
                    if (aVar.jCe.get() + abx >= 8388608) {
                        aVar.jCf.close();
                    }
                    if (aVar.jCe.get() >= 16777216) {
                        aVar.jCg.close();
                    }
                    long Nz2 = bg.Nz();
                    while (!aVar.jCc.jBT) {
                        if (aVar.jCe.get() < (z ? 16777216 : 8388608)) {
                            aVar.jCe.addAndGet(abx);
                            str = "MicroMsg.BackupPackAndSend";
                            String str3 = "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]";
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = Long.valueOf(bg.aA(Nz2));
                            objArr2[1] = Boolean.valueOf(z);
                            objArr2[2] = Long.valueOf(abx);
                            objArr2[3] = Long.valueOf(aVar.jCe.get());
                            objArr2[4] = Boolean.valueOf(aVar.jCe.get() >= 8388608);
                            objArr2[5] = Boolean.valueOf(aVar.jCe.get() >= 16777216);
                            w.v(str, str3, objArr2);
                            cVar2 = cVar;
                            this.jCt.jCh.offer(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 jCw;

                                public final String toString() {
                                    return this.jCw.jCt.TAG + ".sendFile";
                                }

                                public final void run() {
                                    Assert.assertTrue(toString() + ", check running. ", this.jCw.jCt.jCp);
                                    long Nz = bg.Nz();
                                    cVar2.abt();
                                    long Nz2 = bg.Nz();
                                    w.i(this.jCw.jCt.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[]{Integer.valueOf(cVar2.abx()), Long.valueOf(Nz2 - Nz), Long.valueOf(Nz2 - Nz), cVar2.jHw.jOf});
                                }
                            });
                        }
                        (z ? aVar.jCg : aVar.jCf).bJg();
                    }
                    cVar2 = cVar;
                    this.jCt.jCh.offer(/* anonymous class already generated */);
                }
            };
            w.i(this.TAG, "postSendFile BIG:%b  baklst:%d Id:%s path:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.jCm.size()), str, str2});
            if (TextUtils.isEmpty(str2)) {
                String str3 = "chatMsgList should not empty";
                if (this.jCm.isEmpty()) {
                    z2 = false;
                }
                Assert.assertTrue(str3, z2);
                if (str != null) {
                    com.tencent.mm.plugin.backup.f.c.a(this.jCq, anonymousClass2, str, new LinkedList(this.jCm), this.jCc.jBV.jBs);
                    return;
                }
                return;
            }
            this.jCl.add(str);
            if (str != null) {
                com.tencent.mm.plugin.backup.f.c.a(this.jCq, anonymousClass2, str, str2, this.jCc.jBV.jBs);
            }
        }
    }

    private class c {
        public LinkedBlockingQueue<Object> jCD = new LinkedBlockingQueue();
        public ac jCE = new ac();
        public b jCF = null;
        private Runnable jCG = new Runnable(this) {
            final /* synthetic */ c jCH;

            {
                this.jCH = r1;
            }

            public final void run() {
                while (!this.jCH.jCc.jBT) {
                    ac acVar = null;
                    try {
                        acVar = this.jCH.jCD.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                    }
                    w.d("MicroMsg.BackupPackAndSend", "TagQueue(%d)startNext obj:%s", new Object[]{Integer.valueOf(this.jCH.jCD.size()), acVar});
                    if (acVar != null) {
                        if (acVar == this.jCH.jCE) {
                            this.jCH.jCE.open();
                            return;
                        }
                        b bVar = (b) acVar;
                        bVar.jCp = true;
                        bVar.TAG = "MicroMsg.BackupPackAndSend.tag" + (bVar.jCp ? "S." : "W.") + bVar.jBz + "." + bVar.aIO;
                        while (!this.jCH.jCc.jBT) {
                            Runnable runnable = null;
                            try {
                                runnable = (Runnable) bVar.jCh.poll(500, TimeUnit.MILLISECONDS);
                            } catch (Exception e2) {
                            }
                            if (runnable != null) {
                                long Nz = bg.Nz();
                                runnable.run();
                                String str = "MicroMsg.BackupPackAndSend";
                                String str2 = "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s,%s]";
                                Object[] objArr = new Object[7];
                                objArr[0] = Integer.valueOf(bVar.jCh.size());
                                long j = this.jCH.jCi.jCe.get();
                                String str3 = "[%s,%s,%s]";
                                Object[] objArr2 = new Object[3];
                                objArr2[0] = Long.valueOf(j);
                                objArr2[1] = Integer.valueOf(j >= 8388608 ? 1 : 0);
                                objArr2[2] = Integer.valueOf(j >= 16777216 ? 1 : 0);
                                objArr[1] = String.format(str3, objArr2);
                                objArr[2] = Long.valueOf(bg.aA(Nz));
                                objArr[3] = runnable;
                                objArr[4] = bVar;
                                objArr[5] = this.jCH.jCF;
                                objArr[6] = this.jCH.jCF != null ? Integer.valueOf(this.jCH.jCF.jCh.size()) : "null";
                                w.d(str, str2, objArr);
                                if (!bVar.jCp) {
                                    break;
                                }
                            }
                        }
                        System.gc();
                    }
                }
            }
        };
        final /* synthetic */ c jCc;
        public a jCi = new a(this.jCc);

        public c(c cVar) {
            this.jCc = cVar;
            com.tencent.mm.sdk.f.e.b(this.jCG, "TagWorker").start();
        }
    }

    public c(e eVar, int i, com.tencent.mm.plugin.backup.a.b.b bVar) {
        this.jBV = eVar;
        this.jBq = i;
        this.jBU = bVar;
    }

    public final void cE(boolean z) {
        w.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
        if (this.jBq == 1) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFv, Boolean.valueOf(false));
        } else if (this.jBq == 2) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFy, Boolean.valueOf(false));
        }
        Editor edit = e.aaj().edit();
        edit.putString("BACKUP_PC_CHOOSE_SESSION", null);
        if (z) {
            if (this.jBq == 1) {
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
            } else if (this.jBq == 2) {
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            }
        }
        edit.commit();
    }

    public final void aaq() {
        w.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
        com.tencent.mm.plugin.backup.h.d dVar = new com.tencent.mm.plugin.backup.h.d();
        dVar.ID = this.jBV.jBm;
        try {
            com.tencent.mm.plugin.backup.f.b.r(dVar.toByteArray(), 8);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "BackupFinishRequest to buf err.", new Object[0]);
        }
    }

    public final void a(LinkedList<g> linkedList, int i, long j, boolean z) {
        String str = "MicroMsg.BackupPackAndSend";
        String str2 = "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Long.valueOf(j);
        objArr[2] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        final LinkedList<g> linkedList2 = linkedList;
        final long j2 = j;
        final boolean z2 = z;
        final int i2 = i;
        com.tencent.mm.sdk.f.e.d(new Runnable(this) {
            final /* synthetic */ c jCc;

            public final void run() {
                if (linkedList2 == null) {
                    w.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
                    if (this.jCc.jBU != null) {
                        this.jCc.jBU.aaa();
                        this.jCc.jBV.aae().jBu = -21;
                        this.jCc.jBU.a(this.jCc.jBV.aae());
                        return;
                    }
                    return;
                }
                com.tencent.mm.plugin.backup.f.b.abs().start();
                this.jCc.jBV.aae().w(14, 1, c.u(linkedList2));
                this.jCc.jBU.a(this.jCc.jBV.aae());
                String str = (String) com.tencent.mm.plugin.backup.g.a.abC().abD().vr().get(2, null);
                long Nz = bg.Nz();
                this.jCc.jBX = Nz;
                c cVar = new c(this.jCc);
                for (int i = 0; i < linkedList2.size(); i++) {
                    this.jCc.a((g) linkedList2.get(i), cVar, str, j2, z2);
                    if (this.jCc.jBT) {
                        break;
                    }
                }
                if (this.jCc.jBT) {
                    w.e("MicroMsg.BackupPackAndSend", "backupChatRunnable canceled!");
                    return;
                }
                String str2;
                long Nz2 = bg.Nz();
                long Nz3 = bg.Nz();
                cVar.jCD.offer(cVar.jCE);
                cVar.jCE.block();
                w.i("MicroMsg.BackupPackAndSend", "TagQueue waitFinish Finish Now:%d", new Object[]{Long.valueOf(bg.aA(Nz3))});
                Assert.assertTrue(cVar.jCD.isEmpty());
                w.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish cancel[%b], Session[%d], loopTime[%d], waitSendTime:%d", new Object[]{Boolean.valueOf(this.jCc.jBT), Integer.valueOf(linkedList2.size()), Long.valueOf(bg.aA(Nz)), Long.valueOf(bg.aA(Nz2))});
                this.jCc.aaq();
                this.jCc.jBV.aae().w(15, c.u(linkedList2), c.u(linkedList2));
                this.jCc.jBU.a(this.jCc.jBV.aae());
                this.jCc.cE(true);
                if (com.tencent.mm.plugin.backup.f.b.abr() != null) {
                    com.tencent.mm.plugin.backup.f.b.abr().stop();
                }
                if (com.tencent.mm.plugin.backup.f.b.abs() != null) {
                    com.tencent.mm.plugin.backup.f.b.abs().stop();
                }
                if (e.aah() == 1) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(400, 12, bg.aA(Nz), false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(400, 11, 1, false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(400, 13, this.jCc.jBW, false);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13737, new Object[]{Integer.valueOf(0), Long.valueOf(this.jCc.jBW / AppSupportContentFlag.MMAPP_SUPPORT_XLS), Long.valueOf(bg.aA(Nz) / 1000), Integer.valueOf(1), Integer.valueOf(i2)});
                }
                w.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d], backupEndTime[%d]", new Object[]{Long.valueOf(this.jCc.jBW), Long.valueOf(bg.aA(Nz)), Long.valueOf(Nz), Long.valueOf(bg.Nz())});
                Boolean bool = com.tencent.mm.plugin.backup.g.a.abC().abD().jIK;
                String str3 = "MicroMsg.BackupPackAndSend";
                str = "backupChatRunnable send finish, isTempDb[%s]";
                Object[] objArr = new Object[1];
                if (bool == null) {
                    str2 = "null";
                } else {
                    Object obj = bool;
                }
                objArr[0] = str2;
                w.i(str3, str, objArr);
                if (bool != null) {
                    com.tencent.mm.plugin.backup.g.a.abC().o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 jCd;

                        {
                            this.jCd = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupcloseTempDB end");
                            w.bIP();
                        }
                    });
                }
            }
        }, "backupPackThread", 10).start();
    }

    public static int u(LinkedList<g> linkedList) {
        HashSet hashSet = new HashSet();
        if (linkedList == null) {
            return 0;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hashSet.add(((g) it.next()).jBy);
        }
        return hashSet.size();
    }

    public final boolean a(g gVar, c cVar, String str, long j, boolean z) {
        int i;
        long Nz;
        long Nz2;
        eh a;
        Throwable e;
        int i2;
        long Nz3;
        aj Rm = com.tencent.mm.plugin.backup.g.a.abC().abD().wW().Rm(gVar.jBy);
        w.i("MicroMsg.BackupPackAndSend", "backupChatMsg index[%d], convName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[]{Integer.valueOf(gVar.jBz), gVar.jBy, Long.valueOf(gVar.startTime), Long.valueOf(gVar.endTime), Integer.valueOf(Rm != null ? Rm.field_unReadCount : 0)});
        long Nz4 = bg.Nz();
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
        int i4 = r2;
        long j4 = 0;
        while (true) {
            LinkedList linkedList = new LinkedList();
            long Nz5 = j4 - bg.Nz();
            Cursor a2 = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().a(gVar.jBy, gVar.startTime, gVar.endTime, i3);
            i = i3;
            while (a2.moveToNext()) {
                i++;
                if (this.jBT) {
                    a2.close();
                    return false;
                }
                ce auVar = new au();
                auVar.b(a2);
                if (!z || auVar.field_type == 1) {
                    linkedList.add(auVar);
                }
            }
            a2.close();
            Nz = Nz5 + bg.Nz();
            if (linkedList.size() == 0) {
                break;
            }
            int i5 = 0;
            int i6 = i4;
            long j5 = j3;
            j3 = j2;
            while (i5 < linkedList.size()) {
                LinkedBlockingQueue linkedBlockingQueue;
                b bVar;
                au auVar2 = (au) linkedList.get(i5);
                PLong pLong = new PLong();
                LinkedList linkedList2 = new LinkedList();
                HashMap hashMap = new HashMap();
                try {
                    Nz2 = j5 - bg.Nz();
                    try {
                        a = com.tencent.mm.plugin.backup.e.a.a.a(auVar2, false, str, pLong, linkedList2, hashMap, i6 > 0, false, j);
                    } catch (Exception e2) {
                        e = e2;
                        a = null;
                        j2 = Nz2;
                        w.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupChatMsg packedMsg", new Object[0]);
                        Nz2 = j2;
                        w.i("MicroMsg.BackupPackAndSend", "backupChatMsg bakitem[%s], mediaList[%d], addupSize[%d], bigfile[%d], msgSvrId[%d], type[%d], creatTime[%d], talker[%s]", new Object[]{a, Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(hashMap.size()), Long.valueOf(auVar2.field_msgSvrId), Integer.valueOf(auVar2.field_type), Long.valueOf(auVar2.field_createTime), auVar2.field_talker});
                        if (a == null) {
                            i2 = i6 - 1;
                            Nz3 = j3 - bg.Nz();
                            j2 = pLong.value;
                            j3 = auVar2.field_createTime;
                            if (cVar.jCF == null) {
                                linkedBlockingQueue = cVar.jCD;
                                bVar = new b(cVar.jCc, cVar.jCi, gVar);
                                cVar.jCF = bVar;
                                linkedBlockingQueue.offer(bVar);
                            }
                            if (cVar.jCF.a(a, j2, j3, linkedList2, hashMap)) {
                                cVar.jCF = null;
                            }
                            j3 = Nz3 + bg.Nz();
                            i6 = i2;
                        }
                        i5++;
                        j5 = Nz2;
                    }
                    try {
                        Nz2 = bg.Nz() + Nz2;
                    } catch (Exception e3) {
                        e = e3;
                        j2 = Nz2;
                        w.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupChatMsg packedMsg", new Object[0]);
                        Nz2 = j2;
                        w.i("MicroMsg.BackupPackAndSend", "backupChatMsg bakitem[%s], mediaList[%d], addupSize[%d], bigfile[%d], msgSvrId[%d], type[%d], creatTime[%d], talker[%s]", new Object[]{a, Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(hashMap.size()), Long.valueOf(auVar2.field_msgSvrId), Integer.valueOf(auVar2.field_type), Long.valueOf(auVar2.field_createTime), auVar2.field_talker});
                        if (a == null) {
                            i2 = i6 - 1;
                            Nz3 = j3 - bg.Nz();
                            j2 = pLong.value;
                            j3 = auVar2.field_createTime;
                            if (cVar.jCF == null) {
                                linkedBlockingQueue = cVar.jCD;
                                bVar = new b(cVar.jCc, cVar.jCi, gVar);
                                cVar.jCF = bVar;
                                linkedBlockingQueue.offer(bVar);
                            }
                            if (cVar.jCF.a(a, j2, j3, linkedList2, hashMap)) {
                                cVar.jCF = null;
                            }
                            j3 = Nz3 + bg.Nz();
                            i6 = i2;
                        }
                        i5++;
                        j5 = Nz2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    j2 = j5;
                    a = null;
                    w.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupChatMsg packedMsg", new Object[0]);
                    Nz2 = j2;
                    w.i("MicroMsg.BackupPackAndSend", "backupChatMsg bakitem[%s], mediaList[%d], addupSize[%d], bigfile[%d], msgSvrId[%d], type[%d], creatTime[%d], talker[%s]", new Object[]{a, Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(hashMap.size()), Long.valueOf(auVar2.field_msgSvrId), Integer.valueOf(auVar2.field_type), Long.valueOf(auVar2.field_createTime), auVar2.field_talker});
                    if (a == null) {
                        i2 = i6 - 1;
                        Nz3 = j3 - bg.Nz();
                        j2 = pLong.value;
                        j3 = auVar2.field_createTime;
                        if (cVar.jCF == null) {
                            linkedBlockingQueue = cVar.jCD;
                            bVar = new b(cVar.jCc, cVar.jCi, gVar);
                            cVar.jCF = bVar;
                            linkedBlockingQueue.offer(bVar);
                        }
                        if (cVar.jCF.a(a, j2, j3, linkedList2, hashMap)) {
                            cVar.jCF = null;
                        }
                        j3 = Nz3 + bg.Nz();
                        i6 = i2;
                    }
                    i5++;
                    j5 = Nz2;
                }
                w.i("MicroMsg.BackupPackAndSend", "backupChatMsg bakitem[%s], mediaList[%d], addupSize[%d], bigfile[%d], msgSvrId[%d], type[%d], creatTime[%d], talker[%s]", new Object[]{a, Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(hashMap.size()), Long.valueOf(auVar2.field_msgSvrId), Integer.valueOf(auVar2.field_type), Long.valueOf(auVar2.field_createTime), auVar2.field_talker});
                if (a == null) {
                    i2 = i6 - 1;
                    Nz3 = j3 - bg.Nz();
                    j2 = pLong.value;
                    j3 = auVar2.field_createTime;
                    if (cVar.jCF == null) {
                        linkedBlockingQueue = cVar.jCD;
                        bVar = new b(cVar.jCc, cVar.jCi, gVar);
                        cVar.jCF = bVar;
                        linkedBlockingQueue.offer(bVar);
                    }
                    if (cVar.jCF.a(a, j2, j3, linkedList2, hashMap)) {
                        cVar.jCF = null;
                    }
                    j3 = Nz3 + bg.Nz();
                    i6 = i2;
                }
                i5++;
                j5 = Nz2;
            }
            j2 = j3;
            j4 = Nz;
            j3 = j5;
            i3 = i;
            i4 = i6;
        }
        j4 = j2 - bg.Nz();
        if (cVar.jCF == null) {
            LinkedBlockingQueue linkedBlockingQueue2 = cVar.jCD;
            b bVar2 = new b(cVar.jCc, cVar.jCi, gVar);
            cVar.jCF = bVar2;
            linkedBlockingQueue2.offer(bVar2);
        }
        cVar.jCF.aar();
        cVar.jCF = null;
        j4 += bg.Nz();
        w.i("MicroMsg.BackupPackAndSend", "backupChatMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[]{Integer.valueOf(gVar.jBz), gVar.jBy, Integer.valueOf(i), Long.valueOf(bg.aA(Nz4)), Long.valueOf(Nz), Long.valueOf(j3), Long.valueOf(j4)});
        return true;
    }
}
