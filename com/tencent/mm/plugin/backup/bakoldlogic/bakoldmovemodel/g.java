package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui.BakMoveNewUI;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.b.c;
import com.tencent.mm.plugin.backup.h.a;
import com.tencent.mm.plugin.backup.h.ae;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class g implements d, c, e {
    public long fLh = 0;
    public boolean htv = false;
    private long jDI = 0;
    private int jDJ = 0;
    public long jDK = 0;
    private int jDL = 0;
    private long jDM = 0;
    private int jDN = 0;
    public boolean jDO = true;
    public HashSet<String> jDP = new HashSet();
    private int jDQ = 0;
    public boolean jDR = false;
    public boolean jDS = true;
    public boolean jDT = true;
    private long jJW = 0;
    private long jJX = 0;
    public boolean jKg = false;
    public d jKh;
    private k jKp;
    List<String> jKq = new LinkedList();
    public long jKr = 0;
    public long jKs = 0;
    public String jKt = "";
    private d jKu;
    private Object lock = new Object();
    public long recvSize = 0;

    public final void acd() {
        a aVar = new a();
        aVar.ID = a.abR().jBm;
        try {
            b.r(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MoveRecoverServer", e, "sendBuf", new Object[0]);
        }
        acb();
    }

    private void acb() {
        synchronized (this.lock) {
            this.htv = true;
            if (this.jKp != null) {
                this.jKp.cancel();
                this.jKp = null;
            }
            this.jKq.clear();
            com.tencent.mm.a.e.d(new File(h.aan()));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        w.i("MicroMsg.MoveRecoverServer", "onSceneEnd type:%d, [%d, %d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i2), Integer.valueOf(i)});
        if (kVar.getType() == 1) {
            b.b(1, this);
            com.tencent.mm.plugin.report.service.g.oUh.a(103, 9, 1, false);
            if (i2 != 0) {
                w.e("MicroMsg.MoveRecoverServer", "auth failed");
                this.jKg = false;
                return;
            }
            if ((((com.tencent.mm.plugin.backup.bakoldlogic.b.a) kVar).jHi.jOd & com.tencent.mm.plugin.backup.bakoldlogic.a.b.jIX) != 0) {
                z = true;
            }
            this.jDS = z;
            this.jKg = true;
            w.i("MicroMsg.MoveRecoverServer", "auth ok and request bakStart");
            b.a(3, (e) this);
            com.tencent.mm.a.e.d(new File(h.aan()));
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
            this.jKr = pLong3.value - pLong.value;
            this.jKs = pLong2.value;
            new com.tencent.mm.plugin.backup.bakoldlogic.b.b(a.abR().jBm).abt();
        } else if (kVar.getType() == 3) {
            b.b(3, this);
            w.i("MicroMsg.MoveRecoverServer", "receive startrequest response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.backup.bakoldlogic.b.b bVar = (com.tencent.mm.plugin.backup.bakoldlogic.b.b) kVar;
                if (a.abR().jBm.equals(bVar.jHL.ID)) {
                    this.jKq.clear();
                    this.fLh = bVar.jHL.jNA;
                    this.jDI = bVar.jHL.jNz;
                    this.jDQ = bVar.jHL.jNC;
                    w.i("MicroMsg.MoveRecoverServer", "move recover total:%d, convDataSize:%d, and wait old mobile's pushData", new Object[]{Long.valueOf(bVar.jHL.jNz), Long.valueOf(bVar.jHL.jNA)});
                    if (this.jDT && this.jDS) {
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                        int i3 = (this.jDR || this.jDQ == 1) ? 16 : 17;
                        gVar.a(103, (long) i3, 1, false);
                    }
                    if (this.jKs < bVar.jHL.jNA && this.jKr < bVar.jHL.jNA) {
                        jr(30050035);
                        acd();
                        onError(10012, bVar.jHL.jNA + "," + (this.jKs == 0 ? bVar.jHL.jNA - this.jKr : bVar.jHL.jNA - this.jKs));
                        return;
                    }
                    return;
                }
                w.e("MicroMsg.MoveRecoverServer", "start response not the same id");
                onError(i, "start response not the same id.");
                return;
            }
            w.e("MicroMsg.MoveRecoverServer", "start request failed, errMsg:" + str);
            onError(i, "start request failed");
        }
    }

    public final void a(boolean z, String str, String str2, int i) {
        final Intent intent = new Intent(ab.getContext(), BakMoveNewUI.class);
        intent.putExtra("need_auth", z);
        intent.putExtra("WifiName", str);
        intent.putExtra("ip", str2);
        w.i("MicroMsg.MoveRecoverServer", "need_auth:%b, wifiName %s, ip:%s, port:%d", new Object[]{Boolean.valueOf(z), str, str2, Integer.valueOf(i)});
        intent.addFlags(335544320);
        af.v(new Runnable(this) {
            final /* synthetic */ g jKv;

            public final void run() {
                ab.getContext().startActivity(intent);
            }
        });
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        int i3;
        String str = "MicroMsg.MoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        if (bArr == null) {
            i3 = 0;
        } else {
            i3 = bArr.length;
        }
        objArr[3] = Integer.valueOf(i3);
        w.i(str, str2, objArr);
        if (z) {
            onError(i, "");
        }
        if (!this.jKg) {
            w.w("MicroMsg.MoveRecoverServer", "statusOK not ok, drop this notify");
        } else if (i == 6) {
            if (this.jDO) {
                this.jDM = System.currentTimeMillis();
                this.jDO = false;
            }
            this.jDK += (long) bArr.length;
            ae aeVar = new ae();
            x xVar = new x();
            try {
                xVar.aD(bArr);
                w.i("MicroMsg.MoveRecoverServer", "reveive recoverData id:%s, type:%d, start:%d, end:%d", new Object[]{xVar.jOf, Integer.valueOf(xVar.jOg), Integer.valueOf(xVar.jOi), Integer.valueOf(xVar.jOj)});
                long currentTimeMillis = System.currentTimeMillis();
                if (xVar.jOg == 1 && xVar.jMQ != null) {
                    this.jKq.add(xVar.jOf);
                    b(h.aan() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.d.rD(xVar.jOf), xVar);
                    this.recvSize += (long) xVar.jMQ.sYA.length;
                }
                this.jDJ = (int) ((System.currentTimeMillis() - currentTimeMillis) + ((long) this.jDJ));
                currentTimeMillis = System.currentTimeMillis();
                if (xVar.jOg == 2) {
                    b(h.aan() + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.d.rD(xVar.jOf), xVar);
                    this.recvSize += (long) xVar.jMQ.sYA.length;
                    this.jDP.add(xVar.jOf);
                }
                this.jDL = (int) ((System.currentTimeMillis() - currentTimeMillis) + ((long) this.jDL));
                w.i("MicroMsg.MoveRecoverServer", "onNotify recvSize/convDataSize: %d, %d", new Object[]{Long.valueOf(this.recvSize), Long.valueOf(this.fLh)});
                if (this.fLh < this.recvSize) {
                    this.fLh = this.recvSize;
                }
                b(this.recvSize, this.fLh, 0);
                aeVar.jOf = xVar.jOf;
                aeVar.jOg = xVar.jOg;
                aeVar.jOi = xVar.jOi;
                aeVar.jOj = xVar.jOj;
                aeVar.jNB = 0;
            } catch (Throwable e) {
                aeVar.jOf = "";
                aeVar.jOg = 0;
                aeVar.jOi = 0;
                aeVar.jOj = 0;
                aeVar.jNB = 1;
                w.printErrStackTrace("MicroMsg.MoveRecoverServer", e, "BACKUP_DATA_PUSH:", new Object[0]);
            }
            try {
                b.d(aeVar.toByteArray(), 7, i2);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MoveRecoverServer", e2, "BACKUP_DATA_RESPONSE:", new Object[0]);
            }
        } else {
            if (i == 8) {
                this.jDN = (int) (System.currentTimeMillis() - this.jDM);
                this.jKu = new d();
                try {
                    this.jKu.aD(bArr);
                    w.i("MicroMsg.MoveRecoverServer", "NewBakMoveInfoKvstat, Client receive Server data, ServerSessionCount:%d, ServerMessageCount:%d, ServerFileCount:%d, CalculateSize:%d, ServerDataPushSize:%d, ServerReadDBTotalTime:%d, ServerReadFileTotalTime:%d, ServerCostTotalTime:%d, ServerVersion:%x", new Object[]{Integer.valueOf(this.jKu.jMS), Integer.valueOf(this.jKu.jMT), Integer.valueOf(this.jKu.jMU), Integer.valueOf(this.jKu.jMV), Integer.valueOf(this.jKu.jMW), Integer.valueOf(this.jKu.jMX), Integer.valueOf(this.jKu.jMY), Integer.valueOf(this.jKu.jMZ), Integer.valueOf(this.jKu.jNa)});
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.MoveRecoverServer", e22, "COMMAND_FINISH:", new Object[0]);
                }
                long aB = bg.aB(this.jJX) / 1000;
                if (aB == 0) {
                    aB = 1;
                }
                long j = this.fLh / aB;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                objArr = new Object[6];
                objArr[0] = Integer.valueOf(1);
                boolean z2 = com.tencent.mm.plugin.backup.bakoldlogic.a.d.abN() || this.jKt.endsWith(".1");
                objArr[1] = Boolean.valueOf(z2);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(this.recvSize);
                objArr[4] = Long.valueOf(this.fLh);
                objArr[5] = Integer.valueOf(0);
                gVar.i(11789, objArr);
                com.tencent.mm.plugin.report.service.g.oUh.a(103, 20, 1, false);
                gVar = com.tencent.mm.plugin.report.service.g.oUh;
                i3 = (this.jDR || this.jDQ == 1) ? 19 : 18;
                gVar.a(103, (long) i3, 1, false);
                com.tencent.mm.plugin.report.service.g.oUh.a(103, 14, this.recvSize / AppSupportContentFlag.MMAPP_SUPPORT_XLS, false);
                gVar = com.tencent.mm.plugin.report.service.g.oUh;
                i3 = (this.jDR || this.jDQ == 1) ? 22 : 21;
                gVar.a(103, (long) i3, j / AppSupportContentFlag.MMAPP_SUPPORT_XLS, false);
                this.jJX = 0;
                abW();
                synchronized (this.lock) {
                    if (this.htv) {
                        return;
                    }
                    if (this.jKp != null) {
                        this.jKp.cancel();
                    }
                    w.i("MicroMsg.MoveRecoverServer", "summerbak digestList size: %d", new Object[]{Integer.valueOf(this.jKq.size())});
                    this.jKp = new k(this.jKq, (int) this.jDI);
                    this.jKp.jJM = this;
                    this.jKp.ace();
                }
            }
            if (i == 5) {
                a.abR().abU().jr(30050107);
                acb();
            }
        }
    }

    private static void b(String str, x xVar) {
        long j = 0;
        File file = new File(str + xVar.jOf);
        long length = file.exists() ? file.length() : 0;
        com.tencent.mm.a.e.a(str, xVar.jOf, xVar.jMQ.sYA);
        File file2 = new File(str + xVar.jOf);
        if (file2.exists()) {
            j = file2.length();
        }
        if (length == j) {
            w.e("MicroMsg.MoveRecoverServer", "append failed and try again:%s", new Object[]{str + xVar.jOf});
            com.tencent.mm.a.e.a(str, xVar.jOf, xVar.jMQ.sYA);
        }
    }

    public final void onError(int i, String str) {
        boolean z;
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(0);
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.d.abN() || this.jKt.endsWith(".1")) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Long.valueOf(this.recvSize);
        objArr[4] = Long.valueOf(this.fLh);
        objArr[5] = Integer.valueOf(i);
        gVar.i(11789, objArr);
        if (this.jKh != null) {
            this.jKh.onError(i, str);
        }
    }

    public final void b(long j, long j2, int i) {
        if (this.jJW == 0 || bg.aB(this.jJW) >= 100) {
            long j3;
            this.jJW = bg.NA();
            if (this.jJX == 0) {
                this.jJX = bg.NA();
            }
            if (j > j2) {
                j3 = j2;
            } else {
                j3 = j;
            }
            int i2 = ((int) (((this.jJW - this.jJX) * (j2 - j3)) / j3)) / 1000;
            if (this.jKh != null) {
                this.jKh.b(j3, j2, i2);
            }
        }
    }

    public final void bE(int i, int i2) {
        if (this.jKh != null) {
            this.jKh.bE(i, i2);
        }
    }

    public final void abW() {
        if (this.jKh != null) {
            this.jKh.abW();
        }
    }

    public final void aac() {
        com.tencent.mm.plugin.report.service.g.oUh.a(103, 6, 1, false);
        jr(30059999);
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uFB, Boolean.valueOf(true));
        w.i("MicroMsg.MoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (this.jKh != null) {
            this.jKh.aac();
        }
    }

    public final void jr(int i) {
        int i2 = 1;
        if (this.jDT && this.jDS && this.jKu != null && this.jKp != null) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            Object[] objArr = new Object[19];
            objArr[0] = Integer.valueOf(this.jKu.jMS);
            objArr[1] = Integer.valueOf(this.jKu.jMT);
            objArr[2] = Integer.valueOf(this.jKu.jMU);
            objArr[3] = Integer.valueOf(this.jKu.jMV);
            objArr[4] = Integer.valueOf(this.jKu.jMW);
            objArr[5] = Integer.valueOf(this.jKu.jMX);
            objArr[6] = Integer.valueOf(this.jKu.jMY);
            objArr[7] = Integer.valueOf(this.jKu.jMZ);
            objArr[8] = Integer.valueOf(this.jKp.jKB);
            objArr[9] = Integer.valueOf(this.jKp.jKA);
            objArr[10] = Integer.valueOf(this.jDP.size());
            objArr[11] = Integer.valueOf(this.jDJ);
            objArr[12] = Integer.valueOf(this.jKp.jKC);
            objArr[13] = Integer.valueOf(this.jDL);
            objArr[14] = Integer.valueOf(this.jDN);
            objArr[15] = Integer.valueOf((int) (this.jDK / AppSupportContentFlag.MMAPP_SUPPORT_XLS));
            objArr[16] = Integer.valueOf(i);
            objArr[17] = Integer.valueOf(this.jKu.jNa);
            objArr[18] = Integer.valueOf(this.jDR ? 1 : this.jDQ);
            gVar.i(13287, objArr);
            String str = "MicroMsg.MoveRecoverServer";
            String str2 = "NewBakMoveInfoKvstat, Client, ServerSessionCount:%d, ServerMessageCount:%d, ServerFileCount:%d, CalculateSize:%d, ServerDataPushSize:%d, ServerReadDBTotalTime:%d, ServerReadFileTotalTime:%d, ServerCostTotalTime:%d, ClientSessionCount:%d, ClientMessageCount:%d, ClientFileCount:%d, ClientWriteTmpFileTotalTime:%d, ClientWriteDBTotalTime:%d, ClientWriteFileTotalTime:%d, ClientCostTotalTime:%d, ClientDataPushSize:%d, ErrorCode:%d, ServerVersion:%x, m_networkState:%d";
            Object[] objArr2 = new Object[19];
            objArr2[0] = Integer.valueOf(this.jKu.jMS);
            objArr2[1] = Integer.valueOf(this.jKu.jMT);
            objArr2[2] = Integer.valueOf(this.jKu.jMU);
            objArr2[3] = Integer.valueOf(this.jKu.jMV);
            objArr2[4] = Integer.valueOf(this.jKu.jMW);
            objArr2[5] = Integer.valueOf(this.jKu.jMX);
            objArr2[6] = Integer.valueOf(this.jKu.jMY);
            objArr2[7] = Integer.valueOf(this.jKu.jMZ);
            objArr2[8] = Integer.valueOf(this.jKp.jKB);
            objArr2[9] = Integer.valueOf(this.jKp.jKA);
            objArr2[10] = Integer.valueOf(this.jDP.size());
            objArr2[11] = Integer.valueOf(this.jDJ);
            objArr2[12] = Integer.valueOf(this.jKp.jKC);
            objArr2[13] = Integer.valueOf(this.jDL);
            objArr2[14] = Integer.valueOf(this.jDN);
            objArr2[15] = Integer.valueOf((int) (this.jDK / AppSupportContentFlag.MMAPP_SUPPORT_XLS));
            objArr2[16] = Integer.valueOf(i);
            objArr2[17] = Integer.valueOf(this.jKu.jNa);
            if (!this.jDR) {
                i2 = this.jDQ;
            }
            objArr2[18] = Integer.valueOf(i2);
            w.i(str, str2, objArr2);
        }
    }
}
