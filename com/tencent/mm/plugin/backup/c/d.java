package com.tencent.mm.plugin.backup.c;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.backup.a.b.b;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui.BakMoveOldUI;
import com.tencent.mm.plugin.backup.f.b.c;
import com.tencent.mm.plugin.backup.f.i.a;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Iterator;
import java.util.LinkedList;

public final class d implements b, c {
    public static boolean jCT = false;
    public static boolean jEu = false;
    public byte[] bitmapData;
    public com.tencent.mm.plugin.backup.a.b.d jCP;
    public boolean jDR = false;
    public com.tencent.mm.plugin.backup.f.b.b jEg = new com.tencent.mm.plugin.backup.f.b.b(this) {
        final /* synthetic */ d jEA;

        {
            this.jEA = r1;
        }

        public final void aaO() {
            w.i("MicroMsg.BackupMoveServer", "stopCallback ");
            if (com.tencent.mm.plugin.backup.f.b.abr() != null) {
                com.tencent.mm.plugin.backup.f.b.abr().stop();
            }
            b.aaD().aag();
        }
    };
    private final a jEh = new a(this) {
        final /* synthetic */ d jEA;

        {
            this.jEA = r1;
        }

        public final void vM() {
            if (b.aaD().aae().jBu > 0) {
                this.jEA.bx(true);
                b.aaD().aaE().stop();
                b.aaD().aae().jBu = -4;
                this.jEA.a(b.aaD().aae());
            }
        }
    };
    public final j.a jEi = new j.a(this) {
        final /* synthetic */ d jEA;

        {
            this.jEA = r1;
        }

        public final void aaN() {
            this.jEA.a(b.aaD().aae());
        }
    };
    public LinkedList<String> jEn;
    private com.tencent.mm.plugin.backup.b.b jEo;
    private com.tencent.mm.plugin.backup.b.c jEp;
    public long jEq = 0;
    public long jEr = 0;
    public boolean jEs = false;
    public int jEt = 0;
    private boolean jEv = false;
    private int jEw;
    private int jEx;
    private int jEy = 0;
    public e jEz = new e(new e.a(this) {
        final /* synthetic */ d jEA;

        {
            this.jEA = r1;
        }

        public final void a(f fVar, byte[] bArr) {
            if (bArr != null) {
                this.jEA.bitmapData = bArr;
            }
            this.jEA.a(fVar);
        }
    }, b.aaD().aae());

    public final void bx(boolean z) {
        String str;
        w.e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", new Object[]{ah.bJn()});
        if (!z) {
            aaM();
        }
        if (this.jEp != null) {
            this.jEp.jBT = true;
        }
        if (this.jEo != null) {
            this.jEo.cancel();
            this.jEo = null;
        }
        w.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
        if (com.tencent.mm.plugin.backup.f.b.abr() != null) {
            com.tencent.mm.plugin.backup.f.b.abr().stop();
        }
        if (com.tencent.mm.plugin.backup.f.b.abs() != null) {
            com.tencent.mm.plugin.backup.f.b.abs().stop();
        }
        Boolean bool = com.tencent.mm.plugin.backup.g.a.abC().abD().jIK;
        String str2 = "MicroMsg.BackupMoveServer";
        String str3 = "cancel, isTempDb[%s]";
        Object[] objArr = new Object[1];
        if (bool == null) {
            str = "null";
        } else {
            Object obj = bool;
        }
        objArr[0] = str;
        w.i(str2, str3, objArr);
        if (bool != null) {
            com.tencent.mm.plugin.backup.g.a.abC().o(new Runnable(this) {
                final /* synthetic */ d jEA;

                {
                    this.jEA = r1;
                }

                public final void run() {
                    w.i("MicroMsg.BackupMoveServer", "backupChatRunnable backupcloseTempDB end");
                    w.bIP();
                }
            });
        }
    }

    public static void a(int i, long j, long j2, int i2) {
        long j3 = 0;
        w.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)});
        if (i == 0) {
            j2 = 0;
        } else {
            j3 = j;
        }
        b.aaD();
        Editor edit = e.aaj().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", i);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", j3);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", j2);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", i2);
        edit.commit();
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupMoveServer";
        String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        w.i(str, str2, objArr);
        if (z && bArr != null && 10011 == i) {
            w.i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", new Object[]{Integer.valueOf(b.aaD().aae().jBu)});
            switch (b.aaD().aae().jBu) {
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -5:
                    b.aaD().aaE().stop();
                    break;
                case -4:
                    bx(true);
                    break;
                case 1:
                    b.aaD().aaE().stop();
                    b.aaD().aae().jBu = -100;
                    a(b.aaD().aae());
                    break;
                case 12:
                case 14:
                    bx(true);
                    b.aaD().aaE().stop();
                    b.aaD().aae().jBu = -4;
                    a(b.aaD().aae());
                    g.oUh.a(485, 24, 1, false);
                    if (!(this.jEp == null || this.jEp.jBX == 0)) {
                        long aA = bg.aA(this.jEp.jBX);
                        w.i("MicroMsg.BackupMoveServer", "summerbak backup transfer disconnect, backupDataSize:%d, backupCostTime:%d", new Object[]{Long.valueOf(this.jEp.jBW), Long.valueOf(aA)});
                        break;
                    }
            }
        }
        if (i == 1) {
            v vVar = (v) h.a(new v(), bArr);
            if (vVar == null) {
                w.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                b.aaD().aae().jBu = -5;
                a(b.aaD().aae());
                return;
            }
            if (bg.mA(b.aaD().jBm)) {
                b.aaD().jBm = vVar.ID;
            }
            if (vVar.ID.equals(b.aaD().jBm)) {
                w.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[]{vVar.ID, Integer.valueOf(vVar.jOa)});
                if (vVar.jOa == 0) {
                    if (!b.aaD().jBn.equals(new String(k.a(vVar.jMQ.sYA, e.aai())))) {
                        com.tencent.mm.plugin.backup.h.w wVar = new com.tencent.mm.plugin.backup.h.w();
                        wVar.jOa = 0;
                        wVar.ID = b.aaD().jBm;
                        wVar.jNB = 1;
                        w.e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
                        try {
                            w.i("MicroMsg.BackupMoveServer", "summerbak send authFailResp.");
                            com.tencent.mm.plugin.backup.f.b.d(wVar.toByteArray(), 2, i2);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
                        }
                        b.aaD().aae().jBu = -5;
                        a(b.aaD().aae());
                    }
                    if (vVar.jOb < com.tencent.mm.plugin.backup.a.c.jAZ) {
                        this.jEv = true;
                        w.i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", new Object[]{Integer.valueOf(vVar.jOb)});
                    } else {
                        this.jEv = false;
                    }
                    w.i("MicroMsg.BackupMoveServer", "summerbak start move, isOldVersion:%b", new Object[]{Boolean.valueOf(this.jEv)});
                    this.jEx = i2;
                    if (jEu || jCT) {
                        if (jEu && jCT && (vVar.jOd & com.tencent.mm.plugin.backup.a.c.jBe) == 0 && (vVar.jOd & com.tencent.mm.plugin.backup.a.c.jBf) == 0) {
                            b.aaD().aae().jBu = -31;
                            a(b.aaD().aae());
                            this.jEy = 1;
                            return;
                        } else if (jEu && (vVar.jOd & com.tencent.mm.plugin.backup.a.c.jBe) == 0) {
                            b.aaD().aae().jBu = -32;
                            a(b.aaD().aae());
                            this.jEy = 2;
                            return;
                        } else if (jCT && (vVar.jOd & com.tencent.mm.plugin.backup.a.c.jBf) == 0) {
                            b.aaD().aae().jBu = -33;
                            a(b.aaD().aae());
                            this.jEy = 3;
                            return;
                        }
                    }
                    cG(false);
                    return;
                } else if (vVar.jOa == 1) {
                    if (!b.aaD().jBo.equals(new String(k.a(vVar.jMQ.sYA, e.aai())))) {
                        w.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                        b.aaD().aae().jBu = -5;
                        a(b.aaD().aae());
                    }
                    w.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
                    if (this.jEv) {
                        g.oUh.a(485, 101, 1, false);
                        com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS();
                        Intent intent = new Intent(ab.getContext(), BakMoveOldUI.class);
                        intent.addFlags(335544320);
                        ab.getContext().startActivity(intent);
                        return;
                    }
                    b.aaD().aae().jBu = 2;
                    a(b.aaD().aae());
                    return;
                } else {
                    return;
                }
            }
            w.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[]{b.aaD().jBm, vVar.ID});
            bx(false);
            b.aaD().aae().jBu = -5;
            a(b.aaD().aae());
        } else if (i == 3) {
            this.jEw = i2;
            if (b.aaD().aaH().jDr) {
                aaP();
            } else {
                this.jEs = true;
            }
        } else if (i == 9) {
            com.tencent.mm.plugin.backup.h.e eVar = (com.tencent.mm.plugin.backup.h.e) h.a(new com.tencent.mm.plugin.backup.h.e(), bArr);
            if (eVar == null) {
                w.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                return;
            }
            str = "MicroMsg.BackupMoveServer";
            String str3 = "summerbak receive heartbeatReq,req:%s ack:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = eVar;
            objArr2[1] = Long.valueOf(eVar != null ? eVar.jHQ : -1);
            w.i(str, str3, objArr2);
            com.tencent.mm.plugin.backup.h.f fVar = (com.tencent.mm.plugin.backup.h.f) h.a(new com.tencent.mm.plugin.backup.h.f(), bArr);
            fVar.jHQ = eVar.jHQ;
            try {
                w.i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
                com.tencent.mm.plugin.backup.f.b.d(fVar.toByteArray(), 10, i2);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            try {
                new com.tencent.mm.plugin.backup.h.f().aD(bArr);
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.BackupMoveServer", e22, "summerbak heartbeatResp parse from buf error.", new Object[0]);
            }
        } else if (i == 5) {
            w.i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
            bx(true);
            b.aaD().aae().jBu = -100;
            a(b.aaD().aae());
        } else if (i == 12) {
            com.tencent.mm.plugin.backup.h.j jVar = (com.tencent.mm.plugin.backup.h.j) h.a(new com.tencent.mm.plugin.backup.h.j(), bArr);
            if (jVar == null) {
                w.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[]{Integer.valueOf(bg.bn(bArr))});
                b.aaD().aae().jBu = -5;
                a(b.aaD().aae());
                return;
            }
            int i3;
            LinkedList b = b(jVar.jNf, jVar.jNg);
            str = "MicroMsg.BackupMoveServer";
            String str4 = "summerbak backup receive requestsession response. backupSessionList:%d ";
            Object[] objArr3 = new Object[1];
            if (b == null) {
                i3 = -1;
            } else {
                i3 = b.size();
            }
            objArr3[0] = Integer.valueOf(i3);
            w.i(str, str4, objArr3);
            if (b == null) {
                w.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
                aaM();
                b.aaD().aae().jBu = -21;
                a(b.aaD().aae());
                return;
            }
            com.tencent.mm.plugin.backup.f.b.a(this.jEh);
            com.tencent.mm.plugin.backup.f.b.abr().start();
            this.jEp = new com.tencent.mm.plugin.backup.b.c(b.aaD(), 2, this);
            this.jEp.jBT = false;
            this.jEp.cE(false);
            this.jEp.a(b, 0, b.aaD().aae().jBx, jCT);
        }
    }

    public final void cG(boolean z) {
        if (z) {
            switch (this.jEy) {
                case 1:
                    jEu = false;
                    jCT = false;
                    this.jEq = 0;
                    this.jEr = 0;
                    break;
                case 2:
                    jEu = false;
                    this.jEq = 0;
                    this.jEr = 0;
                    break;
                case 3:
                    jCT = false;
                    break;
            }
        }
        com.tencent.mm.plugin.backup.h.w wVar = new com.tencent.mm.plugin.backup.h.w();
        wVar.jOa = 0;
        wVar.ID = b.aaD().jBm;
        wVar.jOb = com.tencent.mm.plugin.backup.a.c.jAZ;
        wVar.jNB = 0;
        wVar.jOc = this.jEt;
        wVar.jMQ = new com.tencent.mm.bd.b(k.b(b.aaD().jBo.getBytes(), e.aai()));
        if (bg.getInt(com.tencent.mm.i.g.sV().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            wVar.jOd |= com.tencent.mm.plugin.backup.a.c.jBd;
        }
        wVar.jOd |= com.tencent.mm.plugin.backup.a.c.jBe;
        wVar.jOd |= com.tencent.mm.plugin.backup.a.c.jBf;
        try {
            w.i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
            com.tencent.mm.plugin.backup.f.b.d(wVar.toByteArray(), 2, this.jEx);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        }
    }

    public final void aaP() {
        w.i("MicroMsg.BackupMoveServer", "summerbak receive start request.");
        this.jEs = false;
        if (this.jEv) {
            w.i("MicroMsg.BackupMoveServer", "summerbak start old move");
            e.jg(-21);
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS().bx(true);
            com.tencent.mm.plugin.backup.f.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS());
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS().a(h.r(b.aaD().aaH().aaz()), new PLong(b.aaD().aaH().aaC()), new PInt());
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR().abS().jq(this.jEw);
            return;
        }
        b.aaD().aae().jBu = 12;
        a(b.aaD().aae());
        com.tencent.mm.plugin.backup.g.a.abC().abF();
        if (this.jEn != null) {
            w.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[]{Integer.valueOf(this.jEn.size())});
            o oVar = new o();
            oVar.ID = b.aaD().jBm;
            oVar.jNz = (long) this.jEn.size();
            oVar.jNA = b.aaD().aaH().aaC();
            oVar.jNB = 0;
            oVar.jNC = this.jDR ? com.tencent.mm.plugin.backup.a.c.jAX : com.tencent.mm.plugin.backup.a.c.jAW;
            if (jCT) {
                oVar.jNy = 3;
            }
            m mVar = new m();
            mVar.jNm = p.rB();
            mVar.jNn = Build.MANUFACTURER;
            mVar.jNo = Build.MODEL;
            mVar.jNp = "Android";
            mVar.jNq = VERSION.RELEASE;
            mVar.jNr = com.tencent.mm.protocal.d.sYN;
            mVar.jNs = 0;
            w.i("MicroMsg.BackupMoveServer", "summerbak generalinfo wechatversion:%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.sYN)});
            oVar.jNw = mVar;
            try {
                com.tencent.mm.plugin.backup.f.b.d(oVar.toByteArray(), 4, this.jEw);
                w.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[]{Integer.valueOf(this.jEn.size()), Long.valueOf(this.jEq), Long.valueOf(this.jEr)});
                i iVar = new i();
                iVar.jNf = this.jEn;
                iVar.jNg = new LinkedList();
                Iterator it = this.jEn.iterator();
                while (it.hasNext()) {
                    it.next();
                    iVar.jNg.add(Long.valueOf(r0));
                    iVar.jNg.add(Long.valueOf(r2));
                }
                try {
                    w.i("MicroMsg.BackupMoveServer", "summerbak send request session, chooseConvNames size:%d", new Object[]{Integer.valueOf(this.jEn.size())});
                    com.tencent.mm.plugin.backup.f.b.r(iVar.toByteArray(), 11);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.BackupMoveServer", e, "summerbak BackupRequestSession parse req failed.", new Object[0]);
                }
            } catch (Throwable e2) {
                w.e("MicroMsg.BackupMoveServer", "prase startResp error!!");
                w.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "", new Object[0]);
            }
        }
    }

    private static void aaM() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.aaD().jBm;
        try {
            w.i("MicroMsg.BackupMoveServer", "send cancel req.");
            com.tencent.mm.plugin.backup.f.b.r(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public static String aaQ() {
        return com.tencent.mm.plugin.backup.f.b.abs().abB();
    }

    public final void a(final f fVar) {
        w.i("MicroMsg.BackupMoveServer", "updateBackupMoveRecoverUI state:%d, transferSession:%d, totalSession:%d", new Object[]{Integer.valueOf(fVar.jBu), Integer.valueOf(fVar.jBv), Integer.valueOf(fVar.jBw)});
        b.aaD().aae().b(fVar);
        if (this.jCP != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ d jEA;

                public final void run() {
                    if (this.jEA.jCP != null) {
                        this.jEA.jCP.a(fVar);
                    }
                }
            });
        }
    }

    public final void aaa() {
        bx(false);
    }

    private static LinkedList<com.tencent.mm.plugin.backup.a.g> b(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        long j = 0;
        if (linkedList == null || linkedList2 == null || linkedList.isEmpty() || linkedList.size() * 2 != linkedList2.size()) {
            return null;
        }
        LinkedList<com.tencent.mm.plugin.backup.a.g> linkedList3 = new LinkedList();
        Iterator it = linkedList2.iterator();
        long j2 = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            if (it.hasNext()) {
                j2 = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue();
                }
            }
            linkedList3.add(new com.tencent.mm.plugin.backup.a.g(i, (String) linkedList.get(i), j2, j));
        }
        return linkedList3;
    }
}
