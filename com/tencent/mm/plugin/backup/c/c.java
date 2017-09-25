package com.tencent.mm.plugin.backup.c;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.n;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements d, com.tencent.mm.plugin.backup.f.b.c {
    public static int hqX = 0;
    public static boolean jEa = false;
    public long fLh = 0;
    String fwJ;
    public boolean htv = false;
    public d jCP;
    public boolean jCT = false;
    private e jDA;
    LinkedList<String> jDB;
    LinkedList<Long> jDC;
    private LinkedList<String> jDD;
    private LinkedList<Long> jDE;
    public com.tencent.mm.plugin.backup.a.b.a jDF;
    HashSet<String> jDG = new HashSet();
    public long jDH = 0;
    public long jDI = 0;
    int jDJ = 0;
    long jDK = 0;
    int jDL = 0;
    long jDM = 0;
    int jDN = 0;
    boolean jDO = true;
    HashSet<String> jDP = new HashSet();
    public int jDQ = 0;
    public boolean jDR = false;
    public boolean jDS = true;
    public boolean jDT = true;
    public boolean jDU = false;
    boolean jDV = false;
    public String jDW;
    String jDX;
    int jDY;
    public aj jDZ;
    public final com.tencent.mm.y.e jEb = new com.tencent.mm.y.e(this) {
        final /* synthetic */ c jEj;

        {
            this.jEj = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ap.vd().b(595, this.jEj.jEb);
            if (i == 0 && i2 == 0) {
                xa aby = ((com.tencent.mm.plugin.backup.f.e) kVar).aby();
                ap.yY();
                if (bg.mz((String) com.tencent.mm.u.c.vr().get(2, null)).equals(aby.thU)) {
                    String str2;
                    b.aaD().jBm = aby.ID;
                    b.aaD().jBn = aby.tib;
                    b.aaD().jBo = aby.tic;
                    b.a(this.jEj.jEg);
                    b.aaD().aaf();
                    b.a(b.aaD().aaG());
                    b.a(b.aaD().aaE());
                    b.jg(2);
                    b.a(this.jEj.jEi);
                    b.a(this.jEj.jEh);
                    int i3 = 0;
                    if (aby.thR > 0) {
                        me meVar = (me) aby.thS.getFirst();
                        String str3 = meVar.tsr;
                        i3 = ((Integer) meVar.tss.getFirst()).intValue();
                        str2 = str3;
                    } else {
                        w.e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
                        str2 = null;
                    }
                    c cVar = this.jEj;
                    cVar.jDW = aby.thV;
                    cVar.jDX = str2;
                    cVar.jDY = i3;
                    w.i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[]{Integer.valueOf(aby.jOc), Integer.valueOf(aby.tdM), aby.thV, str2, Integer.valueOf(i3)});
                    com.tencent.mm.plugin.backup.a.e.jg(22);
                    b.aaD().aae().jBu = 1;
                    Intent className = new Intent().setClassName(ab.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "backup_move_notification");
                    ab.getContext().startActivity(className);
                    g.oUh.a(485, 41, 1, false);
                    c.jEa = false;
                    w.i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[]{str2, aby.thV, h.bH(ab.getContext())});
                    c.hqX = 2;
                    this.jEj.av(str2, i3);
                    return;
                }
                w.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
                b.aaD().aae().jBu = -5;
                this.jEj.a(b.aaD().aae());
                return;
            }
            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 4 && i2 == -2011) {
                w.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
            }
            b.aaD().aae().jBu = -5;
            this.jEj.a(b.aaD().aae());
        }
    };
    public final com.tencent.mm.y.e jEc = new com.tencent.mm.y.e(this) {
        final /* synthetic */ c jEj;

        {
            this.jEj = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            c.jEa = true;
            g.oUh.a(485, 42, 1, false);
            b.b(1, this.jEj.jEc);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.BackupMoveRecoverServer", "summerbak auth success");
                com.tencent.mm.plugin.backup.f.a aVar = (com.tencent.mm.plugin.backup.f.a) kVar;
                if (aVar.jHi.jOb < com.tencent.mm.plugin.backup.a.c.jAZ) {
                    w.i("MicroMsg.BackupMoveRecoverServer", "summerbak start old move, version:%d", new Object[]{Integer.valueOf(aVar.jHi.jOb)});
                    g.oUh.a(485, 102, 1, false);
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().jBm = b.aaD().jBm;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().jBn = b.aaD().jBn;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().jBo = b.aaD().jBo;
                    com.tencent.mm.plugin.backup.a.e.jg(-22);
                    b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abU());
                    b.aaD().aae().jBu = 3;
                    this.jEj.a(b.aaD().aae());
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abU().a(false, this.jEj.jDW, this.jEj.jDX, this.jEj.jDY);
                    com.tencent.mm.y.e abU = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abU();
                    abU.jDS = aVar.abq();
                    abU.jKg = true;
                    w.i("MicroMsg.MoveRecoverServer", "auth ok and request bakStart");
                    b.a(3, abU);
                    com.tencent.mm.plugin.backup.g.a.abC().abF();
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    PLong pLong3 = new PLong();
                    ap.yY();
                    int aN = com.tencent.mm.a.e.aN(com.tencent.mm.u.c.vo());
                    ap.yY();
                    pLong.value = (long) (aN + com.tencent.mm.a.e.aN(com.tencent.mm.u.c.vp()));
                    long j = pLong.value;
                    ap.yY();
                    com.tencent.mm.plugin.backup.bakoldlogic.a.d.a(j, pLong2, pLong3, com.tencent.mm.u.c.xv());
                    abU.jKr = pLong3.value - pLong.value;
                    abU.jKs = pLong2.value;
                    new com.tencent.mm.plugin.backup.bakoldlogic.b.b(com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().jBm).abt();
                    return;
                }
                int i3 = aVar.jHi.jOc;
                this.jEj.jDS = aVar.abq();
                w.i("MicroMsg.BackupMoveRecoverServer", "summerbak start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[]{Integer.valueOf(aVar.jHi.jOb), Integer.valueOf(i3), Boolean.valueOf(this.jEj.jDS)});
                if (i3 == com.tencent.mm.plugin.backup.a.c.jBa) {
                    this.jEj.aaJ();
                    this.jEj.jDU = false;
                    w.i("MicroMsg.BackupMoveRecoverServer", "summerbak is Normal move.");
                } else if (i3 == com.tencent.mm.plugin.backup.a.c.jBb) {
                    this.jEj.jDU = true;
                    w.i("MicroMsg.BackupMoveRecoverServer", "summerbak is Resume Move!!!.");
                }
                c cVar = this.jEj;
                w.i("MicroMsg.BackupMoveRecoverServer", "move recover init");
                cVar.fLh = 0;
                cVar.recvSize = 0;
                cVar.htv = false;
                cVar.jDG.clear();
                cVar.jDO = true;
                cVar.jDK = 0;
                cVar.jDP.clear();
                b.a(3, this.jEj.jEd);
                new com.tencent.mm.plugin.backup.f.g(b.aaD().jBm).abt();
                b.aaD().aae().jBu = 22;
                this.jEj.a(b.aaD().aae());
                return;
            }
            w.e("MicroMsg.BackupMoveRecoverServer", "summerbak auth failed");
            b.aaD().aae().jBu = -5;
            this.jEj.a(b.aaD().aae());
        }
    };
    public final com.tencent.mm.y.e jEd = new com.tencent.mm.y.e(this) {
        final /* synthetic */ c jEj;

        {
            this.jEj = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            b.b(3, this.jEj.jEd);
            w.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.backup.f.g gVar = (com.tencent.mm.plugin.backup.f.g) kVar;
                o oVar = gVar.jHL;
                if (b.aaD().jBm.equals(oVar.ID)) {
                    double d;
                    b.aaD().aae().jBx = oVar.jNt;
                    this.jEj.fwJ = gVar.jHL.jNw.jNm;
                    this.jEj.fLh = gVar.jHL.jNA;
                    this.jEj.jDI = gVar.jHL.jNz;
                    this.jEj.jDQ = gVar.jHL.jNC;
                    w.i("MicroMsg.BackupMoveRecoverServer", "move recover total:%d, convDataSize:%d, and wait old mobile's pushData", new Object[]{Long.valueOf(gVar.jHL.jNz), Long.valueOf(gVar.jHL.jNA)});
                    if (this.jEj.jDT && this.jEj.jDS) {
                        g gVar2 = g.oUh;
                        int i3 = (this.jEj.jDR || this.jEj.jDQ == 1) ? 66 : 65;
                        gVar2.a(485, (long) i3, 1, false);
                    }
                    if ((gVar.jHL.jNy == 3 ? 1 : null) != null) {
                        this.jEj.jCT = true;
                        w.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
                    } else {
                        this.jEj.jCT = false;
                    }
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    ap.yY();
                    h.a(0, pLong, pLong2, com.tencent.mm.u.c.xv());
                    long j = this.jEj.fLh;
                    if (((double) this.jEj.fLh) * 0.1d > 5.24288E8d) {
                        d = 5.24288E8d;
                    } else {
                        d = ((double) this.jEj.fLh) * 0.1d;
                    }
                    long j2 = ((long) d) + j;
                    this.jEj.jEe = j2;
                    if (pLong2.value < j2) {
                        w.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[]{Long.valueOf(pLong2.value), Long.valueOf(j2), Long.valueOf(this.jEj.fLh)});
                        b.aaD().aaE().stop();
                        b.aaD().aae().jBu = -13;
                        this.jEj.a(b.aaD().aae());
                        g.oUh.a(485, 5, 1, false);
                        return;
                    }
                    this.jEj.jDH = bg.Nz();
                    return;
                }
                w.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
                b.aaD().aae().jBu = -5;
                this.jEj.a(b.aaD().aae());
                return;
            }
            w.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:" + str);
            b.aaD().aae().jBu = -5;
            this.jEj.a(b.aaD().aae());
        }
    };
    public long jEe;
    int jEf;
    b.b jEg = new b.b(this) {
        final /* synthetic */ c jEj;

        {
            this.jEj = r1;
        }

        public final void aaO() {
            w.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
            if (b.abr() != null) {
                b.abr().stop();
            }
            b.aaD().aag();
        }
    };
    public final com.tencent.mm.plugin.backup.f.i.a jEh = new com.tencent.mm.plugin.backup.f.i.a(this) {
        final /* synthetic */ c jEj;

        {
            this.jEj = r1;
        }

        public final void vM() {
            if (b.aaD().aae().jBu > 0) {
                this.jEj.a(true, false, -4);
                b.aaD().aaE().stop();
            }
        }
    };
    public final com.tencent.mm.plugin.backup.f.j.a jEi = new com.tencent.mm.plugin.backup.f.j.a(this) {
        final /* synthetic */ c jEj;

        {
            this.jEj = r1;
        }

        public final void aaN() {
            this.jEj.a(b.aaD().aae());
        }
    };
    private Object lock = new Object();
    long recvSize = 0;

    private class a {
        byte[] buf;
        int hTw;
        boolean iXc = false;
        final /* synthetic */ c jEj;
        int type;

        a(c cVar, boolean z, int i, int i2, byte[] bArr) {
            this.jEj = cVar;
            this.hTw = i;
            this.type = i2;
            this.buf = (byte[]) bArr.clone();
        }
    }

    public static boolean aaI() {
        return ap.yY().xG().bKO();
    }

    public final void aaJ() {
        w.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
        this.jDG.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        w.i("MicroMsg.BackupMoveRecoverServer", "summerbak backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), ah.bJn()});
        if (!z) {
            aaM();
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
            b.aaD().aae().jBu = i;
            a(b.aaD().aae());
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
        b.aaD().aaE().jBF = null;
    }

    public final void av(String str, int i) {
        boolean z = true;
        b.aaD().aaE().connect(str, i);
        b.a(1, this.jEc);
        try {
            if (bg.getInt(com.tencent.mm.i.g.sV().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                z = false;
            }
            this.jDT = z;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "getInt", new Object[0]);
        }
        com.tencent.mm.plugin.backup.f.a aVar = new com.tencent.mm.plugin.backup.f.a(b.aaD().jBn, b.aaD().jBo, com.tencent.mm.plugin.backup.a.e.aai(), b.aaD().jBm, com.tencent.mm.plugin.backup.a.c.jAZ, 22);
        aVar.cK(this.jDT);
        aVar.abt();
        w.i("MicroMsg.BackupMoveRecoverServer", "summerbak tryConnect start connect timehandler.");
        if (this.jDZ == null) {
            this.jDZ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ c jEj;

                {
                    this.jEj = r1;
                }

                public final boolean oQ() {
                    if (!c.jEa) {
                        w.e("MicroMsg.BackupMoveRecoverServer", "summerbak try connect overtime failed.");
                        if (this.jEj.jDZ != null) {
                            this.jEj.jDZ.KH();
                        }
                        this.jEj.aaK();
                    }
                    return true;
                }
            }, false);
        }
        this.jDZ.v(3000, 3000);
    }

    public final void aaK() {
        String str = this.jDW;
        String str2 = this.jDX;
        String bH = h.bH(ab.getContext());
        w.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[]{bH, str, str2, Integer.valueOf(hqX)});
        if (bH == null || bH.equals("")) {
            g.oUh.a(485, 1, 1, false);
            b.aaD().aae().jBu = -1;
            a(b.aaD().aae());
        } else if (str == null || !str.equals(bH)) {
            g.oUh.a(485, 2, 1, false);
            b.aaD().aae().jBu = -2;
            a(b.aaD().aae());
        } else if (!h.rA(str2)) {
            g.oUh.a(485, 3, 1, false);
            b.aaD().aae().jBu = -3;
            a(b.aaD().aae());
        } else if (hqX <= 0) {
            b.aaD().aae().jBu = -5;
            a(b.aaD().aae());
            g.oUh.a(485, 4, 1, false);
        } else {
            hqX--;
            av(this.jDX, this.jDY);
        }
    }

    public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
        String str = "MicroMsg.BackupMoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        w.i(str, str2, objArr);
        if (z && 10011 == i) {
            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", new Object[]{Integer.valueOf(b.aaD().aae().jBu)});
            switch (b.aaD().aae().jBu) {
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -14:
                case -13:
                case -5:
                    b.aaD().aaE().stop();
                    return;
                case -4:
                    a(true, false, 0);
                    return;
                case 1:
                    b.aaD().aaE().stop();
                    if (jEa) {
                        b.aaD().aae().jBu = -4;
                        a(b.aaD().aae());
                        return;
                    }
                    if (this.jDZ != null) {
                        w.i("MicroMsg.BackupMoveRecoverServer", "stop backupConnectTimerHandler.");
                        this.jDZ.KH();
                    }
                    aaK();
                    return;
                case 22:
                case 23:
                    a(true, false, -4);
                    b.aaD().aaE().stop();
                    g.oUh.a(485, 43, 1, false);
                    long j = 0;
                    if (this.jDH != 0) {
                        j = bg.aA(this.jDH);
                    }
                    w.i("MicroMsg.BackupMoveRecoverServer", "summerbak recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[]{Long.valueOf(this.fLh), Long.valueOf(j)});
                    return;
                default:
                    return;
            }
        } else if (i == 9) {
            com.tencent.mm.plugin.backup.h.e eVar = (com.tencent.mm.plugin.backup.h.e) h.a(new com.tencent.mm.plugin.backup.h.e(), bArr);
            if (eVar == null) {
                w.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                return;
            }
            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", new Object[]{eVar, Long.valueOf(eVar.jHQ)});
            f fVar = new f();
            fVar.jHQ = eVar.jHQ;
            try {
                w.i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
                b.d(fVar.toByteArray(), 10, i2);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            f fVar2 = (f) h.a(new f(), bArr);
            str2 = "MicroMsg.BackupMoveRecoverServer";
            String str3 = "summerbak receive heartbeat response, resp:%s ack:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = fVar2;
            objArr2[1] = Long.valueOf(fVar2 != null ? fVar2.jHQ : -1);
            w.i(str2, str3, objArr2);
        } else {
            if (i == 5) {
                a(true, false, -100);
            }
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ c jEj;

                public final void run() {
                    c cVar;
                    byte[] bArr;
                    int i;
                    if (i == 11) {
                        cVar = this.jEj;
                        bArr = bArr;
                        i = i2;
                        if (b.aaD().aae().jBu == -13) {
                            w.e("MicroMsg.BackupMoveRecoverServer", "receive requestSession request, but no enough space for recover, quit.");
                            return;
                        }
                        i iVar = (i) h.a(new i(), bArr);
                        if (iVar == null) {
                            w.e("MicroMsg.BackupMoveRecoverServer", "requestSessionListNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                            b.aaD().aae().jBu = -21;
                            cVar.a(b.aaD().aae());
                            return;
                        }
                        w.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive requestSession request, SessionName size:%d, TimeInterval size:%d", new Object[]{Integer.valueOf(iVar.jNf.size()), Integer.valueOf(iVar.jNg.size())});
                        cVar.jDB = iVar.jNf;
                        cVar.jDC = iVar.jNg;
                        if (cVar.jDC.size() != cVar.jDB.size() * 2) {
                            c.aaM();
                            b.aaD().aae().jBu = -21;
                            cVar.a(b.aaD().aae());
                            return;
                        }
                        cVar.jEf = i;
                        if (cVar.jDU) {
                            cVar.cF(cVar.jDV);
                            return;
                        }
                        long j;
                        j xE = ap.yY().xE();
                        String str = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + cVar.fwJ + "\"";
                        w.d("MicroMsg.BackupMoveTimeStorage", "getCountByDevice:" + str);
                        Cursor rawQuery = xE.gUz.rawQuery(str, null);
                        if (rawQuery == null) {
                            w.e("MicroMsg.BackupMoveTimeStorage", "getCountByDevice failed, deviceid:%s", new Object[]{r3});
                            j = 0;
                        } else {
                            j = (long) rawQuery.getCount();
                            rawQuery.close();
                        }
                        if (j > 0) {
                            b.aaD().aae().jBu = 52;
                            cVar.a(b.aaD().aae());
                            return;
                        }
                        cVar.cF(true);
                    } else if (i == 6) {
                        c cVar2 = this.jEj;
                        byte[] bArr2 = bArr;
                        int i2 = i2;
                        if (cVar2.jDO) {
                            cVar2.jDM = bg.Nz();
                            cVar2.jDO = false;
                        }
                        cVar2.jDK += (long) bArr2.length;
                        x xVar = (x) h.a(new x(), bArr2);
                        if (xVar == null) {
                            w.e("MicroMsg.BackupMoveRecoverServer", "dataPushNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr2))});
                            c.b("", 0, 0, 0, 1, i2);
                            return;
                        }
                        w.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recoverData id:%s, type:%d, start:%d, end:%d", new Object[]{xVar.jOf, Integer.valueOf(xVar.jOg), Integer.valueOf(xVar.jOi), Integer.valueOf(xVar.jOj)});
                        long Nz = bg.Nz();
                        if (xVar.jOg == 1 && xVar.jMQ != null) {
                            w.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify text dataid:%s, dir:%s", new Object[]{xVar.jOf, h.aan() + "backupItem/" + h.rD(xVar.jOf)});
                            h.b(r2, xVar);
                            cVar2.recvSize += (long) xVar.jMQ.sYA.length;
                        }
                        cVar2.jDJ = (int) (bg.aA(Nz) + ((long) cVar2.jDJ));
                        Nz = bg.Nz();
                        if (xVar.jOg == 2) {
                            w.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify datapush media dataid:%s, dir:%s", new Object[]{xVar.jOf, h.aan() + "backupMeida/" + h.rD(xVar.jOf)});
                            h.a(r2, xVar);
                            cVar2.recvSize += (long) xVar.jMQ.sYA.length;
                            cVar2.jDP.add(xVar.jOf);
                        }
                        cVar2.jDL = (int) (bg.aA(Nz) + ((long) cVar2.jDL));
                        w.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", new Object[]{Long.valueOf(cVar2.recvSize), Long.valueOf(cVar2.fLh)});
                        if (cVar2.fLh < cVar2.recvSize) {
                            cVar2.fLh = cVar2.recvSize;
                        }
                        c.b(xVar.jOf, xVar.jOg, xVar.jOi, xVar.jOj, 0, i2);
                    } else if (i == 13) {
                        c.P(bArr);
                    } else if (i == 15) {
                        cVar = this.jEj;
                        bArr = bArr;
                        i = i2;
                        z zVar = (z) h.a(new z(), bArr);
                        if (zVar == null) {
                            w.e("MicroMsg.BackupMoveRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                            return;
                        }
                        w.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive tag, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s", new Object[]{zVar.jOo, zVar.jNb, Long.valueOf(zVar.jOm), Long.valueOf(zVar.jOn), zVar.jOp});
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFz, Boolean.valueOf(true));
                        if (ap.yY().xG().QG(zVar.jOo) != null) {
                            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak the same tag has received, ignore. MsgDataID:%s", new Object[]{zVar.jOo});
                        } else {
                            com.tencent.mm.sdk.e.c kVar = new com.tencent.mm.storage.k();
                            kVar.field_msgListDataId = zVar.jOo;
                            kVar.field_sessionName = zVar.jNb;
                            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(ap.yY().xG().b(kVar)), Long.valueOf(kVar.uxb)});
                            kVar = new m();
                            kVar.field_sessionName = zVar.jNb;
                            kVar.field_startTime = zVar.jOm;
                            kVar.field_endTime = zVar.jOn;
                            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(ap.yY().xF().b(kVar)), Long.valueOf(kVar.uxb)});
                        }
                        cVar.jDG.add(zVar.jNb);
                        b.aaD().aae().w(23, cVar.jDG.size() < cVar.jDB.size() ? cVar.jDG.size() : cVar.jDB.size(), cVar.jDB.size());
                        cVar.a(b.aaD().aae());
                        aa aaVar = new aa();
                        aaVar.jNb = zVar.jNb;
                        aaVar.jOm = zVar.jOm;
                        aaVar.jOn = zVar.jOn;
                        aaVar.jOo = zVar.jOo;
                        try {
                            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak send tag resp");
                            b.d(aaVar.toByteArray(), 16, i);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to PacketBackupDataTagResponse err.", new Object[0]);
                        }
                    } else if (i == 8) {
                        c cVar3 = this.jEj;
                        if (((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)) == null) {
                            w.e("MicroMsg.BackupMoveRecoverServer", "recoverFinishNotify BackupFinishRequest parse failed buf:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                            return;
                        }
                        w.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive finish request. NewBakMoveInfoKvstat, Client receive Server data, ServerSessionCount:%d, ServerMessageCount:%d, ServerFileCount:%d, CalculateSize:%d, ServerDataPushSize:%d, ServerReadDBTotalTime:%d, ServerReadFileTotalTime:%d, ServerCostTotalTime:%d, ServerVersion:%x", new Object[]{Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMS), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMT), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMU), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMV), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMW), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMX), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMY), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jMZ), Integer.valueOf(((com.tencent.mm.plugin.backup.h.d) h.a(new com.tencent.mm.plugin.backup.h.d(), bArr)).jNa)});
                        cVar3.jDN = (int) bg.aA(cVar3.jDM);
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFz, Boolean.valueOf(false));
                        b.aaD().aaE().jBF = null;
                        if (b.abr() != null) {
                            b.abr().stop();
                        }
                        if (b.abs() != null) {
                            b.abs().stop();
                        }
                        b.aaD().aae().w(24, cVar3.jDG.size(), cVar3.jDB.size());
                        cVar3.a(b.aaD().aae());
                        long aA = bg.aA(cVar3.jDH);
                        long j2 = aA != 0 ? cVar3.fLh / aA : 0;
                        g.oUh.a(485, 45, 1, false);
                        g gVar = g.oUh;
                        int i3 = (cVar3.jDR || cVar3.jDQ == 1) ? 68 : 67;
                        gVar.a(485, (long) i3, 1, false);
                        g.oUh.a(485, 61, aA / 1000, false);
                        g.oUh.a(485, 62, cVar3.fLh / AppSupportContentFlag.MMAPP_SUPPORT_XLS, false);
                        gVar = g.oUh;
                        i3 = (cVar3.jDR || cVar3.jDQ == 1) ? 70 : 69;
                        gVar.a(485, (long) i3, j2 / AppSupportContentFlag.MMAPP_SUPPORT_XLS, false);
                        w.i("MicroMsg.BackupMoveRecoverServer", "recoverFinishNotify recover success. recoverCostTime[%d], recoverTotalSize[%d]", new Object[]{Long.valueOf(aA), Long.valueOf(cVar3.fLh)});
                    }
                }
            });
        }
    }

    public final void cF(boolean z) {
        this.jDV = z;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        b.aaD().aaE().jBF = new com.tencent.mm.plugin.backup.b.a.a(this) {
            final /* synthetic */ c jEj;

            public final void a(int i, int i2, byte[] bArr) {
                while (!this.jEj.htv) {
                    try {
                        if (linkedBlockingQueue.offer(new a(this.jEj, false, i, i2, bArr), 500, TimeUnit.MILLISECONDS)) {
                            break;
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.BackupMoveRecoverServer", "onBackupMoveRecoverDatapushCallback e:%s", new Object[]{e.getMessage()});
                    }
                }
                w.i("MicroMsg.BackupMoveRecoverServer", "summerbak offer datapushQueue, datapushQueue size:%d", new Object[]{Integer.valueOf(linkedBlockingQueue.size())});
            }
        };
        com.tencent.mm.sdk.f.e.b(new Runnable(this) {
            final /* synthetic */ c jEj;

            public final void run() {
                while (!this.jEj.htv) {
                    a aVar;
                    try {
                        aVar = (a) linkedBlockingQueue.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        aVar = null;
                    }
                    w.d("MicroMsg.BackupMoveRecoverServer", "datapushQueue size:%d, startNext receiveData:%s", new Object[]{Integer.valueOf(linkedBlockingQueue.size()), aVar});
                    if (aVar != null) {
                        this.jEj.a(aVar.iXc, aVar.type, aVar.buf, aVar.hTw);
                    }
                }
            }
        }, "onNotifyWorker").start();
        this.jDD = new LinkedList();
        this.jDE = new LinkedList();
        ap.yY().xF().a(this.jDB, this.jDC, this.jDD, this.jDE);
        if (!(this.jCT || z)) {
            LinkedList linkedList = this.jDD;
            LinkedList linkedList2 = this.jDE;
            this.jDD = new LinkedList();
            this.jDE = new LinkedList();
            ap.yY().xE().a(this.fwJ, linkedList, linkedList2, this.jDD, this.jDE);
        }
        com.tencent.mm.plugin.backup.h.j jVar = new com.tencent.mm.plugin.backup.h.j();
        jVar.jNf = this.jDD;
        jVar.jNg = this.jDE;
        try {
            w.i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[]{Integer.valueOf(this.jDB.size()), Integer.valueOf(jVar.jNg.size())});
            b.d(jVar.toByteArray(), 12, this.jEf);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupRequestSessionResponse err.", new Object[0]);
        }
        b.abs().start();
        b.aaD().aae().w(23, 1, this.jDB.size());
        a(b.aaD().aae());
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
            w.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    public static void P(byte[] bArr) {
        af afVar = (af) h.a(new af(), bArr);
        if (afVar == null) {
            w.e("MicroMsg.BackupMoveRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
            return;
        }
        ag agVar = new ag();
        agVar.jOx = afVar.jOx;
        agVar.jOz = afVar.jOz;
        agVar.jOy = afVar.jOy;
        agVar.jNb = afVar.jNb;
        try {
            w.i("MicroMsg.BackupMoveRecoverServer", "send SvrID resp");
            b.r(agVar.toByteArray(), 14);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to PacketSvrIDResponse err.", new Object[0]);
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
            b.aaD().aae().w(26, 1, this.jDG.size());
            a(b.aaD().aae());
            this.jDA = new e(b.aaD(), 22, this, this.jDG.size(), false, new LinkedList(), new LinkedList());
            this.jDA.aas();
            g.oUh.a(485, 46, 1, false);
        }
    }

    public static String aaL() {
        return b.abs().abB();
    }

    static void aaM() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.aaD().jBm;
        try {
            w.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
            b.r(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public final void a(final com.tencent.mm.plugin.backup.a.f fVar) {
        if (this.jCP != null) {
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ c jEj;

                public final void run() {
                    if (this.jEj.jCP != null) {
                        this.jEj.jCP.a(fVar);
                    }
                }
            });
        }
        if (this.jDF != null) {
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ c jEj;

                public final void run() {
                    if (this.jEj.jDF != null) {
                        this.jEj.jDF.ZZ();
                    }
                }
            });
        }
    }

    public final void cD(final boolean z) {
        if (this.jCP != null) {
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ c jEj;

                public final void run() {
                    if (this.jEj.jCP != null) {
                        this.jEj.jCP.cD(z);
                    }
                }
            });
        }
    }

    public final void aac() {
        g.oUh.a(485, 49, 1, false);
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFB, Boolean.valueOf(true));
        w.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (!this.jCT) {
            n xF = ap.yY().xF();
            LinkedList linkedList = new LinkedList();
            Cursor Kk = xF.Kk();
            if (Kk == null) {
                w.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
            } else {
                while (Kk.moveToNext()) {
                    m mVar = new m();
                    mVar.b(Kk);
                    linkedList.add(mVar);
                }
                Kk.close();
            }
            if (linkedList.size() <= 0) {
                w.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
            } else {
                w.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
                ap.yY().xE().d(this.fwJ, linkedList);
            }
        }
        aaJ();
        if (b.abr() != null) {
            b.abr().stop();
        }
        if (b.abs() != null) {
            b.abs().stop();
        }
    }
}
