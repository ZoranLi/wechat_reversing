package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.backup.a.b.b;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    public static boolean jCT = false;
    private static boolean jEu = false;
    private b jBU = new b(this) {
        final /* synthetic */ e jGM;

        {
            this.jGM = r1;
        }

        public final void a(final f fVar) {
            b.abd().aae().b(fVar);
            final Set hashSet = new HashSet();
            hashSet.addAll(this.jGM.jGB);
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass6 jGN;

                public final void run() {
                    for (c a : hashSet) {
                        a.a(fVar);
                    }
                }
            });
            if (this.jGM.jGC != null) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 jGN;

                    public final void run() {
                        if (this.jGN.jGM.jGC != null) {
                            this.jGN.jGM.jGC.ZZ();
                        }
                    }
                });
            }
        }

        public final void aaa() {
            w.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[]{Boolean.valueOf(false)});
            this.jGM.bx(false);
        }
    };
    final com.tencent.mm.y.e jEd = new com.tencent.mm.y.e(this) {
        final /* synthetic */ e jGM;

        {
            this.jGM = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.backup.f.b.b(3, this.jGM.jEd);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[]{str});
                o oVar = ((g) kVar).jHL;
                if (b.abd().jBm.equals(oVar.ID)) {
                    b.abd().aae().jBx = oVar.jNt;
                    w.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[]{Long.valueOf(oVar.jNt)});
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uFB, Boolean.valueOf(false));
                    com.tencent.mm.plugin.backup.f.b.abr().start();
                    e eVar = this.jGM;
                    com.tencent.mm.plugin.backup.f.b.a(11, eVar.jGK);
                    com.tencent.mm.plugin.backup.f.f fVar = new com.tencent.mm.plugin.backup.f.f(eVar.jEn, eVar.jEq, eVar.jEr);
                    w.i("MicroMsg.BackupPcServer", "backupPcSendRequestSession, chooseConvNames size[%d]", new Object[]{Integer.valueOf(eVar.jEn.size())});
                    fVar.abt();
                    return;
                }
                w.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
                com.tencent.mm.plugin.report.service.g.oUh.a(400, 107, 1, false);
                b.abd().aae().jBu = -5;
                this.jGM.c(b.abd().aae());
                return;
            }
            w.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.plugin.report.service.g.oUh.a(400, 107, 1, false);
            b.abd().aae().jBu = -5;
            this.jGM.c(b.abd().aae());
        }
    };
    LinkedList<String> jEn;
    private com.tencent.mm.plugin.backup.b.b jEo;
    public com.tencent.mm.plugin.backup.b.c jEp;
    long jEq = 0;
    long jEr = 0;
    public Set<c> jGB = new HashSet();
    public com.tencent.mm.plugin.backup.a.b.a jGC;
    public boolean jGI = false;
    public boolean jGJ = false;
    final com.tencent.mm.y.e jGK = new com.tencent.mm.y.e(this) {
        final /* synthetic */ e jGM;

        {
            this.jGM = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.backup.f.b.b(11, this.jGM.jGK);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.backup.f.f fVar = (com.tencent.mm.plugin.backup.f.f) kVar;
                LinkedList linkedList = fVar.jHJ.jNf;
                LinkedList linkedList2 = fVar.jHJ.jNg;
                LinkedList linkedList3 = new LinkedList();
                HashSet hashSet = new HashSet();
                Iterator it = linkedList2.iterator();
                long j = 0;
                long j2 = 0;
                for (int i3 = 0; i3 < linkedList.size(); i3++) {
                    if (it.hasNext()) {
                        j = ((Long) it.next()).longValue();
                        if (it.hasNext()) {
                            j2 = ((Long) it.next()).longValue();
                        }
                    }
                    hashSet.add(linkedList.get(i3));
                    linkedList3.add(new com.tencent.mm.plugin.backup.a.g(hashSet.size() - 1, (String) linkedList.get(i3), j, j2));
                }
                w.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[]{Integer.valueOf(linkedList3.size())});
                this.jGM.jEp.a(linkedList3, b.abd().abe().jGx, b.abd().aae().jBx, e.jCT);
                return;
            }
            w.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.plugin.report.service.g.oUh.a(400, 108, 1, false);
            this.jGM.bx(false);
            b.abd().aae().jBu = -5;
            this.jGM.c(b.abd().aae());
        }
    };
    private final com.tencent.mm.plugin.backup.f.b.c jGL = new com.tencent.mm.plugin.backup.f.b.c(this) {
        final /* synthetic */ e jGM;

        {
            this.jGM = r1;
        }

        public final void a(boolean z, int i, byte[] bArr, int i2) {
            String str = "MicroMsg.BackupPcServer";
            String str2 = "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            w.i(str, str2, objArr);
            if (!z || bArr == null) {
                if (1 != b.abd().abe().jGt && 3 != b.abd().abe().jGt) {
                    return;
                }
                if (i == 10) {
                    w.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp");
                    try {
                        new com.tencent.mm.plugin.backup.h.f().aD(bArr);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.BackupPcServer", e, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
                    }
                } else if (i == 5) {
                    w.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
                    this.jGM.bx(true);
                    b.abd().aae().jBu = -100;
                    this.jGM.c(b.abd().aae());
                    this.jGM.jo(5);
                } else if (i == 18) {
                    w.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp");
                }
            } else if (10011 == i) {
                w.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[]{Integer.valueOf(b.abd().aae().jBu)});
                switch (b.abd().aae().jBu) {
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                    case -14:
                    case -5:
                        b.abd().aaE().stop();
                        return;
                    case -4:
                        this.jGM.bx(true);
                        return;
                    case 1:
                    case 11:
                        b.abd().aaE().stop();
                        b.abd().aae().jBu = -100;
                        this.jGM.c(b.abd().aae());
                        return;
                    case 12:
                    case 14:
                        this.jGM.bx(true);
                        b.abd().aaE().stop();
                        b.abd().aae().jBu = -4;
                        this.jGM.c(b.abd().aae());
                        com.tencent.mm.plugin.report.service.g.oUh.a(400, 9, 1, false);
                        this.jGM.jo(3);
                        return;
                    case 15:
                        b.abd().aaE().stop();
                        b.abd().aae().jBu = -100;
                        this.jGM.c(b.abd().aae());
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public final void init() {
        w.i("MicroMsg.BackupPcServer", "init.");
        com.tencent.mm.plugin.backup.f.b.a(this.jGL);
        this.jEp = new com.tencent.mm.plugin.backup.b.c(b.abd(), 1, this.jBU);
        this.jEp.jBT = false;
    }

    public final void bx(boolean z) {
        String str;
        w.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[]{Boolean.valueOf(z), ah.bJn()});
        if (!z) {
            b.abd().abe();
            c.aaM();
            jo(4);
        }
        this.jEp.jBT = true;
        if (this.jEo != null) {
            this.jEo.cancel();
            this.jEo = null;
        }
        if (com.tencent.mm.plugin.backup.f.b.abr() != null) {
            com.tencent.mm.plugin.backup.f.b.abr().stop();
        }
        if (com.tencent.mm.plugin.backup.f.b.abs() != null) {
            com.tencent.mm.plugin.backup.f.b.abs().stop();
        }
        Boolean bool = com.tencent.mm.plugin.backup.g.a.abC().abD().jIK;
        String str2 = "MicroMsg.BackupPcServer";
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
                final /* synthetic */ e jGM;

                {
                    this.jGM = r1;
                }

                public final void run() {
                    w.i("MicroMsg.BackupPcServer", "backupChatRunnable backupcloseTempDB end");
                    w.bIP();
                }
            });
        }
    }

    public final void y(LinkedList<String> linkedList) {
        this.jEn = linkedList;
        b.abd();
        if (b.aaj().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            jEu = true;
        } else {
            jEu = false;
        }
        b.abd();
        this.jEq = b.aaj().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
        b.abd();
        this.jEr = b.aaj().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        b.abd();
        if (b.aaj().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            jCT = true;
        } else {
            jCT = false;
        }
        String str = "MicroMsg.BackupPcServer";
        String str2 = "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Boolean.valueOf(jEu);
        objArr[2] = Boolean.valueOf(jCT);
        objArr[3] = Long.valueOf(this.jEq);
        objArr[4] = Long.valueOf(this.jEr);
        w.i(str, str2, objArr);
        ap.yY();
        com.tencent.mm.u.c.vr().a(a.uFv, Boolean.valueOf(true));
        if (1 == b.abd().abe().jGt) {
            b.abd();
            Editor edit = b.aaj().edit();
            edit.putString("BACKUP_PC_CHOOSE_SESSION", h.a("", ",", (String[]) linkedList.toArray(new String[linkedList.size()])));
            edit.commit();
        }
    }

    public static void b(int i, long j, long j2, int i2) {
        long j3 = 0;
        w.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)});
        if (i == 0) {
            j2 = 0;
        } else {
            j3 = j;
        }
        b.abd();
        Editor edit = b.aaj().edit();
        if (1 == b.abd().abe().jGt) {
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", i);
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", i2);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", j3);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", j2);
        }
        edit.commit();
    }

    public final void aH(long j) {
        int i = 3;
        w.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
        com.tencent.mm.plugin.backup.f.b.a(3, this.jEd);
        g gVar = new g(b.abd().jBm);
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        ap.yY();
        h.a(0, pLong, pLong2, com.tencent.mm.u.c.xv());
        if (!jCT) {
            ap.yY();
            if (((Boolean) com.tencent.mm.u.c.vr().get(a.uFB, Boolean.valueOf(false))).booleanValue()) {
                i = 0;
            } else {
                i = 1;
            }
        }
        m aG = h.aG(pLong2.value);
        gVar.jHK.jNt = 0;
        gVar.jHK.jNu = j;
        gVar.jHK.jNv = 0;
        gVar.jHK.jNw = aG;
        gVar.jHK.jNx = 0;
        gVar.jHK.jNy = i;
        w.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        gVar.abt();
    }

    public final void jo(int i) {
        long j;
        long j2 = 0;
        if (this.jEp != null) {
            if (this.jEp.jBX != 0) {
                j2 = bg.aA(this.jEp.jBX);
            }
            j = j2;
            j2 = this.jEp.jBW;
        } else {
            j = 0;
            j2 = 0;
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(13737, new Object[]{Integer.valueOf(i), Long.valueOf(j2 / AppSupportContentFlag.MMAPP_SUPPORT_XLS), Long.valueOf(j / 1000), Integer.valueOf(1), Integer.valueOf(b.abd().abe().jGx)});
        w.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d], backupCostTime[%d]", new Object[]{Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j)});
    }

    public final void aab() {
        final Set hashSet = new HashSet();
        hashSet.addAll(this.jGB);
        af.v(new Runnable(this) {
            final /* synthetic */ e jGM;

            public final void run() {
                for (c aab : hashSet) {
                    aab.aab();
                }
            }
        });
    }

    public final void c(f fVar) {
        this.jBU.a(fVar);
    }
}
