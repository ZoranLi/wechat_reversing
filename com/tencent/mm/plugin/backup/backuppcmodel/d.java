package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.backup.a.b.a;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.b.a.3;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.n;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d implements com.tencent.mm.plugin.backup.a.b.d {
    long fLh = 0;
    boolean htv = false;
    boolean jCT = false;
    private e jDA;
    LinkedList<String> jDB;
    LinkedList<Long> jDC;
    private HashSet<String> jDG = new HashSet();
    long jDH = 0;
    public Set<c> jGB = new HashSet();
    public a jGC;
    private long jGD = 0;
    private final b.c jGE = new b.c(this) {
        final /* synthetic */ d jGF;

        {
            this.jGF = r1;
        }

        public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
            String str = "MicroMsg.BackupPcRecoverServer";
            String str2 = "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            w.i(str, str2, objArr);
            if (z && 10011 == i) {
                d dVar = this.jGF;
                w.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify local disconnect, backupPcState[%d]", new Object[]{Integer.valueOf(b.abd().aae().jBu)});
                switch (b.abd().aae().jBu) {
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                    case -14:
                    case -13:
                    case -5:
                        b.abd().aaE().stop();
                        return;
                    case -4:
                        dVar.a(true, false, 0);
                        return;
                    case 1:
                    case 21:
                        b.abd().aaE().stop();
                        b.abd().aae().jBu = -100;
                        dVar.a(b.abd().aae());
                        return;
                    case 22:
                    case 23:
                        dVar.a(true, false, -4);
                        b.abd().aaE().stop();
                        g.oUh.a(400, 17, 1, false);
                        dVar.jo(3);
                        return;
                    case 27:
                        b.abd().aaE().stop();
                        b.abd().aae().jBu = -100;
                        dVar.a(b.abd().aae());
                        return;
                    default:
                        return;
                }
            } else if (i == 5) {
                w.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
                this.jGF.a(true, false, -100);
                this.jGF.jo(5);
            } else {
                int i3 = b.abd().abe().jGt;
                if (2 != i3 && 4 != i3) {
                    w.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[]{Integer.valueOf(b.abd().abe().jGt)});
                } else if (i == 10) {
                    f fVar = (f) h.a(new f(), bArr);
                    str2 = "MicroMsg.BackupPcRecoverServer";
                    String str3 = "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Long.valueOf(fVar != null ? fVar.jHQ : -1);
                    w.i(str2, str3, objArr2);
                } else if (i == 18) {
                    com.tencent.mm.plugin.backup.h.c cVar = (com.tencent.mm.plugin.backup.h.c) h.a(new com.tencent.mm.plugin.backup.h.c(), bArr);
                    str = "MicroMsg.BackupPcRecoverServer";
                    str2 = "onBackupPcRecoverServerNotify receive commandResp, command[%d]";
                    objArr = new Object[1];
                    objArr[0] = Integer.valueOf(cVar == null ? -1 : cVar.jMP);
                    w.i(str, str2, objArr);
                } else {
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 jGG;

                        public final void run() {
                            byte[] bArr;
                            String str;
                            if (i == 3) {
                                d dVar = this.jGG.jGF;
                                bArr = bArr;
                                n nVar = (n) h.a(new n(), bArr);
                                if (nVar == null || !b.abd().jBm.equals(nVar.ID)) {
                                    String str2 = "MicroMsg.BackupPcRecoverServer";
                                    String str3 = "startRequestNotify BackupStartRequest parseBuf:%d failed or wrong id[%s,%s]";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Integer.valueOf(bg.bn(bArr));
                                    if (nVar != null) {
                                        str = nVar.ID;
                                    } else {
                                        str = "buf is null";
                                    }
                                    objArr[1] = str;
                                    objArr[2] = b.abd().jBm;
                                    w.e(str2, str3, objArr);
                                    d.l(1, 0);
                                    dVar.a(false, false, -5);
                                    return;
                                }
                                b.abd().aae().jBx = nVar.jNt;
                                if (nVar.jNy == 3) {
                                    dVar.jCT = true;
                                    g.oUh.a(400, 36, 1, false);
                                    w.i("MicroMsg.BackupPcRecoverServer", "isQuickBackup!!!");
                                }
                                long j = nVar.jNx;
                                PLong pLong = new PLong();
                                PLong pLong2 = new PLong();
                                ap.yY();
                                h.a(0, pLong, pLong2, com.tencent.mm.u.c.xv());
                                long j2 = (pLong2.value - ((long) (((double) j) * 0.1d > 5.24288E8d ? 5.24288E8d : ((double) j) * 0.1d))) / 1048576;
                                dVar.jDH = System.currentTimeMillis();
                                w.i("MicroMsg.BackupPcRecoverServer", "startRequestNotify time:%d SessionCount:%d, MsgCount:%d, DataSize:%d validSize:%d", new Object[]{Long.valueOf(dVar.jDH), Long.valueOf(nVar.jNu), Long.valueOf(nVar.jNv), Long.valueOf(j), Long.valueOf(j2)});
                                if (j2 >= j) {
                                    d.l(0, j2);
                                    b.abr().start();
                                    return;
                                }
                                w.e("MicroMsg.BackupPcRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                d.l(2, j2);
                                com.tencent.mm.plugin.backup.b.a aaE = b.abd().aaE();
                                if (aaE.jBE == null) {
                                    aaE.stop();
                                } else {
                                    aaE.jBE.postDelayed(new 3(aaE), 10);
                                }
                                b.abd().aae().jBu = -13;
                                dVar.a(b.abd().aae());
                                g.oUh.a(400, 6, 1, false);
                                g.oUh.i(13736, new Object[]{Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(b.abd().abe().jGx)});
                            } else if (i == 11) {
                                r1 = this.jGG.jGF;
                                i iVar = (i) h.a(new i(), bArr);
                                if (iVar == null) {
                                    w.e("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(r2))});
                                    b.abd().aae().jBu = -21;
                                    r1.a(b.abd().aae());
                                    return;
                                }
                                r1.jDB = iVar.jNf;
                                r1.jDC = iVar.jNg;
                                if (r1.jDC.size() != r1.jDB.size() * 2) {
                                    r1.a(false, false, -21);
                                    return;
                                }
                                b.abd().aae().w(23, 1, r1.jDB.size());
                                r1.a(b.abd().aae());
                                LinkedList linkedList = new LinkedList();
                                LinkedList linkedList2 = new LinkedList();
                                ap.yY().xF().a(r1.jDB, r1.jDC, linkedList, linkedList2);
                                j jVar = new j();
                                jVar.jNf = linkedList;
                                jVar.jNg = linkedList2;
                                b.abs().start();
                                try {
                                    w.i("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[]{Integer.valueOf(r1.jDB.size()), Integer.valueOf(linkedList2.size())});
                                    b.r(jVar.toByteArray(), 12);
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "BackupRequestSessionResponse to buf err.", new Object[0]);
                                }
                            } else if (i == 6) {
                                r1 = this.jGG.jGF;
                                r2 = bArr;
                                int i = i2;
                                x xVar = (x) h.a(new x(), r2);
                                if (xVar == null) {
                                    w.e("MicroMsg.BackupPcRecoverServer", "dataPushNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(r2))});
                                    d.b("", 0, 0, 0, 1, i);
                                    return;
                                }
                                w.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive recoverData id:%s, type:%d, start:%d, end:%d, isCancel:%b", new Object[]{xVar.jOf, Integer.valueOf(xVar.jOg), Integer.valueOf(xVar.jOi), Integer.valueOf(xVar.jOj), Boolean.valueOf(r1.htv)});
                                if (!r1.htv) {
                                    if (!(b.abd().jBs == null || xVar.jMQ == null)) {
                                        xVar.jMQ = new com.tencent.mm.bd.b(AesEcb.aesCryptEcb(xVar.jMQ.sYA, b.abd().jBs, false, xVar.jOj == xVar.jOh));
                                    }
                                    if (xVar.jOg == 1 && xVar.jMQ != null) {
                                        w.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush text dataid:%s, dir:%s", new Object[]{xVar.jOf, h.aan() + "backupItem/" + h.rD(xVar.jOf)});
                                        h.b(str, xVar);
                                        r1.recvSize += (long) xVar.jMQ.sYA.length;
                                    }
                                    if (xVar.jOg == 2) {
                                        w.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush media dataid:%s, dir:%s", new Object[]{xVar.jOf, h.aan() + "backupMeida/" + h.rD(xVar.jOf)});
                                        h.a(str, xVar);
                                        r1.recvSize += (long) xVar.jMQ.sYA.length;
                                    }
                                    w.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", new Object[]{Long.valueOf(r1.recvSize), Long.valueOf(r1.fLh)});
                                    if (r1.fLh < r1.recvSize) {
                                        r1.fLh = r1.recvSize;
                                    }
                                    d.b(xVar.jOf, xVar.jOg, xVar.jOi, xVar.jOj, 0, i);
                                }
                            } else if (i == 13) {
                                af afVar = (af) h.a(new af(), bArr);
                                if (afVar == null) {
                                    w.e("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                                    return;
                                }
                                ag agVar = new ag();
                                agVar.jOx = afVar.jOx;
                                agVar.jOz = afVar.jOz;
                                agVar.jOy = afVar.jOy;
                                agVar.jNb = afVar.jNb;
                                try {
                                    w.i("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify send SvrID resp");
                                    b.r(agVar.toByteArray(), 14);
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "PacketSvrIDResponse to buf err.", new Object[0]);
                                }
                            } else if (i == 15) {
                                this.jGG.jGF.R(bArr);
                            } else if (i == 8) {
                                this.jGG.jGF.S(bArr);
                            }
                        }
                    });
                }
            }
        }
    };
    private Object lock = new Object();
    long recvSize = 0;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ d jGF;
        final /* synthetic */ Set jGH;

        AnonymousClass2(d dVar, Set set) {
            this.jGF = dVar;
            this.jGH = set;
        }

        public final void run() {
            for (c aab : this.jGH) {
                aab.aab();
            }
        }
    }

    public final void init() {
        w.i("MicroMsg.BackupPcRecoverServer", "init");
        b.a(this.jGE);
        this.fLh = 0;
        this.recvSize = 0;
        this.htv = false;
        this.jCT = false;
        this.jDG.clear();
    }

    public static boolean aaI() {
        return ap.yY().xG().bKO();
    }

    public final void aaJ() {
        w.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
        this.jDG.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        w.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), ah.bJn()});
        if (!z) {
            b.abd().abe();
            c.aaM();
            jo(4);
        }
        synchronized (this.lock) {
            this.htv = true;
            if (this.jDA != null) {
                this.jDA.f(z2, i);
                this.jDA = null;
            } else {
                i2 = 1;
            }
        }
        if (!(i2 == 0 || i == 0)) {
            b.abd().aae().jBu = i;
            a(b.abd().aae());
        }
        if (z2) {
            aaJ();
        }
        if (b.abr() != null) {
            b.abr().stop();
        }
        if (b.abs() != null) {
            b.abs().stop();
        }
    }

    public final void jo(int i) {
        long j = 0;
        if (this.jDH != 0) {
            j = bg.aA(this.jDH);
        }
        g.oUh.i(13737, new Object[]{Integer.valueOf(i), Long.valueOf(this.fLh / AppSupportContentFlag.MMAPP_SUPPORT_XLS), Long.valueOf(j / 1000), Integer.valueOf(2), Integer.valueOf(b.abd().abe().jGx)});
        w.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d], recoverCostTime[%d]", new Object[]{Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(this.fLh), Long.valueOf(j)});
    }

    public final void R(byte[] bArr) {
        z zVar = (z) h.a(new z(), bArr);
        if (zVar == null) {
            w.e("MicroMsg.BackupPcRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
            return;
        }
        w.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify receive tagReq, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s, isCancel:%b", new Object[]{zVar.jOo, zVar.jNb, Long.valueOf(zVar.jOm), Long.valueOf(zVar.jOn), zVar.jOp, Boolean.valueOf(this.htv)});
        if (!this.htv) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFw, Boolean.valueOf(true));
            if (ap.yY().xG().QG(zVar.jOo) != null) {
                w.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify the same tag has received, ignore. MsgDataID:%s", new Object[]{zVar.jOo});
            } else {
                com.tencent.mm.sdk.e.c kVar = new k();
                kVar.field_msgListDataId = zVar.jOo;
                kVar.field_sessionName = zVar.jNb;
                w.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(ap.yY().xG().b(kVar)), Long.valueOf(kVar.uxb)});
                kVar = new m();
                kVar.field_sessionName = zVar.jNb;
                kVar.field_startTime = zVar.jOm;
                kVar.field_endTime = zVar.jOn;
                w.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(ap.yY().xF().b(kVar)), Long.valueOf(kVar.uxb)});
            }
            this.jDG.add(zVar.jNb);
            b.abd().aae().w(23, this.jDG.size() < this.jDB.size() ? this.jDG.size() : this.jDB.size(), this.jDB.size());
            a(b.abd().aae());
            aa aaVar = new aa();
            aaVar.jNb = zVar.jNb;
            aaVar.jOm = zVar.jOm;
            aaVar.jOn = zVar.jOn;
            aaVar.jOo = zVar.jOo;
            try {
                w.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify send tag resp");
                b.r(aaVar.toByteArray(), 16);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "SendTagNotify buf to PacketBackupDataTagResponse err.", new Object[0]);
            }
        }
    }

    public final void S(byte[] bArr) {
        w.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify receive finishReq.");
        if (h.a(new com.tencent.mm.plugin.backup.h.d(), bArr) == null) {
            w.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", new Object[]{Integer.valueOf(bg.bn(bArr))});
        }
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFw, Boolean.valueOf(false));
        if (b.abr() != null) {
            b.abr().stop();
        }
        if (b.abs() != null) {
            b.abs().stop();
        }
        b.abd().aae().w(24, this.jDG.size(), this.jDB.size());
        a(b.abd().aae());
        g.oUh.a(400, 19, 1, false);
        this.jGD = System.currentTimeMillis();
        g.oUh.a(400, 20, this.jGD - this.jDH, false);
        g.oUh.a(400, 21, this.fLh, false);
        g.oUh.i(13737, new Object[]{Integer.valueOf(0), Long.valueOf(this.fLh / AppSupportContentFlag.MMAPP_SUPPORT_XLS), Long.valueOf(r8 / 1000), Integer.valueOf(2), Integer.valueOf(b.abd().abe().jGx)});
        w.i("MicroMsg.BackupPcRecoverServer", "recoverFinishNotify recover success. recoverCostTime:%d, recoverStartTime:%d, recoverEndTime:%d, recoverTotalSize:%d", new Object[]{Long.valueOf(r8), Long.valueOf(this.jDH), Long.valueOf(this.jGD), Long.valueOf(this.fLh)});
    }

    static void b(String str, int i, int i2, int i3, int i4, int i5) {
        y yVar = new y();
        yVar.jOf = str;
        yVar.jOg = i;
        yVar.jOi = i2;
        yVar.jOj = i3;
        yVar.jNB = i4;
        try {
            b.d(yVar.toByteArray(), 7, i5);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    static void l(int i, long j) {
        o oVar = new o();
        oVar.ID = b.abd().jBm;
        oVar.jNB = i;
        oVar.jNw = h.aG(j);
        try {
            w.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[]{Integer.valueOf(i)});
            b.r(oVar.toByteArray(), 4);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "buf to BackupStartRequest err.", new Object[0]);
        }
    }

    public final void aas() {
        synchronized (this.lock) {
            if (this.htv) {
                return;
            }
            if (this.jDA != null) {
                this.jDA.f(false, 0);
            }
            if (this.jDG == null || this.jDG.size() <= 0) {
                this.jDG = ap.yY().xG().bKP();
            }
            b.abd().aae().w(26, 1, this.jDG.size());
            a(b.abd().aae());
            if (this.jDB == null) {
                this.jDB = new LinkedList();
            }
            if (this.jDC == null) {
                this.jDC = new LinkedList();
            }
            this.jDA = new e(b.abd(), 1, this, this.jDG.size(), this.jCT, this.jDB, this.jDC);
            this.jDA.aas();
            g.oUh.a(400, 24, 1, false);
        }
    }

    public final void a(final com.tencent.mm.plugin.backup.a.f fVar) {
        b.abd().aae().b(fVar);
        final Set hashSet = new HashSet();
        hashSet.addAll(this.jGB);
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ d jGF;

            public final void run() {
                for (c a : hashSet) {
                    a.a(fVar);
                }
            }
        });
        if (this.jGC != null) {
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ d jGF;

                public final void run() {
                    if (this.jGF.jGC != null) {
                        this.jGF.jGC.ZZ();
                    }
                }
            });
        }
    }

    public final void cD(final boolean z) {
        final Set hashSet = new HashSet();
        hashSet.addAll(this.jGB);
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ d jGF;

            public final void run() {
                for (c cD : hashSet) {
                    cD.cD(z);
                }
            }
        });
    }

    public final void aac() {
        aaJ();
        g.oUh.a(400, 27, 1, false);
        if (b.abr() != null) {
            b.abr().stop();
        }
        if (b.abs() != null) {
            b.abs().stop();
        }
    }
}
