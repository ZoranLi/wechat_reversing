package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.f.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.i;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.Set;

public final class c {
    static int hqX = 2;
    public static boolean jEa = false;
    public aj jDZ;
    public final e jEb = new e(this) {
        final /* synthetic */ c jGA;

        {
            this.jGA = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ap.vd().b(595, this.jGA.jEb);
            if (i == 0 && i2 == 0) {
                xa aby = ((com.tencent.mm.plugin.backup.f.e) kVar).aby();
                ap.yY();
                if (!bg.mz((String) com.tencent.mm.u.c.vr().get(2, null)).equals(aby.thU)) {
                    w.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
                    b.abd().aae().jBu = -5;
                    b.abd().abf().c(b.abd().aae());
                    g.oUh.a(400, 102, 1, false);
                    return;
                } else if (aby.thS == null || aby.thS.size() <= 0 || aby.thS.getFirst() == null) {
                    r2 = "MicroMsg.BackupPcProcessMgr";
                    String str2 = "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aby.thR);
                    objArr[1] = aby.thS == null ? "null" : aby.thS.size();
                    w.e(r2, str2, objArr);
                    b.abd().aae().jBu = -5;
                    b.abd().abf().c(b.abd().aae());
                    g.oUh.a(400, 103, 1, false);
                    return;
                } else {
                    me meVar = (me) aby.thS.getFirst();
                    r2 = meVar.tsr;
                    int intValue = ((Integer) meVar.tss.getFirst()).intValue();
                    c cVar = this.jGA;
                    cVar.jGu = aby.thV;
                    cVar.jGv = r2;
                    cVar.jGw = intValue;
                    w.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[]{Integer.valueOf(aby.jOc), Integer.valueOf(aby.tdM), aby.thV, r2, Integer.valueOf(intValue)});
                    b.abd().jBm = aby.ID;
                    b.abd().jBn = aby.tib;
                    b.abd().jBo = aby.tic;
                    b.abd().jBs = aby.thF.tZp.sYA;
                    c cVar2 = this.jGA;
                    b.jg(1);
                    b.abd().aaf();
                    b.a(cVar2.jEg);
                    b.a(cVar2.jGz);
                    b.a(b.abd().aaE());
                    b.a(cVar2.jEi);
                    b.a(cVar2.jEh);
                    b.abd().aae().jBu = 1;
                    Intent className = new Intent().setClassName(ab.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    ab.getContext().startActivity(className);
                    c.jEa = false;
                    w.i("MicroMsg.BackupPcProcessMgr", "startConnectPc, PC ip:%s, PC wifi:%s, Phone wifi:%s", new Object[]{cVar2.jGv, cVar2.jGu, h.bH(ab.getContext())});
                    c.hqX = 2;
                    cVar2.abi();
                    return;
                }
            }
            w.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            g.oUh.a(400, 101, 1, false);
            if (i == 4 && i2 == -2011) {
                w.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
            }
            b.abd().aae().jBu = -5;
            b.abd().abf().c(b.abd().aae());
        }
    };
    public final e jEc = new e(this) {
        final /* synthetic */ c jGA;

        {
            this.jGA = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            c.jEa = true;
            g.oUh.i(13736, new Object[]{Integer.valueOf(0), this.jGA.jGu, h.bH(ab.getContext()), Integer.valueOf(0), Integer.valueOf(b.abd().abe().jGx)});
            b.b(1, this.jGA.jEc);
            if (i == 0 && i2 == 0) {
                a aVar = (a) kVar;
                w.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b]", new Object[]{Boolean.valueOf((aVar.jHi.jOd & com.tencent.mm.plugin.backup.a.c.jBe) != 0), Boolean.valueOf((aVar.jHi.jOd & com.tencent.mm.plugin.backup.a.c.jBf) != 0)});
                b.abd().abf().jGI = r0;
                b.abd().abf().jGJ = r1;
                return;
            }
            w.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            switch (i2) {
                case -3:
                    g.oUh.a(400, 105, 1, false);
                    break;
                case -1:
                    g.oUh.a(400, 104, 1, false);
                    break;
                default:
                    g.oUh.a(400, 106, 1, false);
                    break;
            }
            g.oUh.i(13737, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jGA.jGx)});
            b.abd().aae().jBu = -5;
            b.abd().abf().c(b.abd().aae());
        }
    };
    b.b jEg = new b.b(this) {
        final /* synthetic */ c jGA;

        {
            this.jGA = r1;
        }

        public final void aaO() {
            w.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
            if (b.abr() != null) {
                b.abr().stop();
            }
            b.abd().aag();
        }
    };
    final i.a jEh = new i.a(this) {
        final /* synthetic */ c jGA;

        {
            this.jGA = r1;
        }

        public final void vM() {
            if (b.abd().aae().jBu > 0) {
                b.abd().aaE().stop();
                if (1 == this.jGA.jGt) {
                    b.abd().abf().bx(true);
                    b.abd().abf().jo(18);
                    b.abd().aae().jBu = -4;
                    b.abd().abf().c(b.abd().aae());
                } else if (2 == this.jGA.jGt) {
                    b.abd().abg().a(true, false, -4);
                    b.abd().abg().jo(18);
                }
            }
        }
    };
    final j.a jEi = new j.a(this) {
        final /* synthetic */ c jGA;

        {
            this.jGA = r1;
        }

        public final void aaN() {
            f aae = b.abd().aae();
            if (aae.jBu == 14) {
                b.abd().abf().c(aae);
            } else if (aae.jBu == 23) {
                b.abd().abg().a(aae);
            }
        }
    };
    public int jGt = 0;
    public String jGu;
    String jGv;
    int jGw;
    public int jGx;
    public boolean jGy = true;
    final com.tencent.mm.plugin.backup.f.b.c jGz = new com.tencent.mm.plugin.backup.f.b.c(this) {
        final /* synthetic */ c jGA;

        {
            this.jGA = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(boolean r10, int r11, byte[] r12, int r13) {
            /*
            r9 = this;
            r1 = "MicroMsg.BackupPcProcessMgr";
            r2 = "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]";
            r0 = 4;
            r3 = new java.lang.Object[r0];
            r0 = 0;
            r4 = java.lang.Boolean.valueOf(r10);
            r3[r0] = r4;
            r0 = 1;
            r4 = java.lang.Integer.valueOf(r11);
            r3[r0] = r4;
            r0 = 2;
            r4 = java.lang.Integer.valueOf(r13);
            r3[r0] = r4;
            r4 = 3;
            if (r12 != 0) goto L_0x0054;
        L_0x0021:
            r0 = -1;
        L_0x0022:
            r0 = java.lang.Integer.valueOf(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
            if (r10 == 0) goto L_0x00ac;
        L_0x002d:
            if (r12 == 0) goto L_0x00ac;
        L_0x002f:
            r0 = 10011; // 0x271b float:1.4028E-41 double:4.946E-320;
            if (r0 != r11) goto L_0x0053;
        L_0x0033:
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r0 = r0.aae();
            r0 = r0.jBu;
            r1 = "MicroMsg.BackupPcProcessMgr";
            r2 = "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]";
            r3 = 1;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = java.lang.Integer.valueOf(r0);
            r3[r4] = r5;
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
            switch(r0) {
                case -100: goto L_0x00a0;
                case -21: goto L_0x00a0;
                case -14: goto L_0x00a0;
                case -5: goto L_0x00a0;
                case 1: goto L_0x0056;
                default: goto L_0x0053;
            };
        L_0x0053:
            return;
        L_0x0054:
            r0 = r12.length;
            goto L_0x0022;
        L_0x0056:
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.c.jEa;
            if (r0 != 0) goto L_0x0076;
        L_0x005a:
            r0 = r9.jGA;
            r0 = r0.jDZ;
            if (r0 == 0) goto L_0x0070;
        L_0x0060:
            r0 = "MicroMsg.BackupPcProcessMgr";
            r1 = "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            r0 = r9.jGA;
            r0 = r0.jDZ;
            r0.KH();
        L_0x0070:
            r0 = r9.jGA;
            r0.aaK();
            goto L_0x0053;
        L_0x0076:
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r0 = r0.aaE();
            r0.stop();
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r0 = r0.aae();
            r1 = -4;
            r0.jBu = r1;
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r0 = r0.abf();
            r1 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r1 = r1.aae();
            r0.c(r1);
            goto L_0x0053;
        L_0x00a0:
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r0 = r0.aaE();
            r0.stop();
            goto L_0x0053;
        L_0x00ac:
            r0 = 17;
            if (r11 != r0) goto L_0x00d2;
        L_0x00b0:
            r0 = new com.tencent.mm.plugin.backup.h.b;
            r0.<init>();
            r0.aD(r12);	 Catch:{ Exception -> 0x0141 }
            r1 = "MicroMsg.BackupPcProcessMgr";
            r2 = "onBackupPcProcessMgrNotify receive commandReq, command[%d]";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0141 }
            r4 = 0;
            r5 = r0.jMP;	 Catch:{ Exception -> 0x0141 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0141 }
            r3[r4] = r5;	 Catch:{ Exception -> 0x0141 }
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x0141 }
            r0 = r0.jMP;	 Catch:{ Exception -> 0x0141 }
            switch(r0) {
                case 1: goto L_0x013a;
                case 2: goto L_0x00d2;
                case 3: goto L_0x020a;
                case 4: goto L_0x00d2;
                case 5: goto L_0x014f;
                case 6: goto L_0x00d2;
                case 7: goto L_0x0212;
                default: goto L_0x00d2;
            };
        L_0x00d2:
            r0 = 5;
            if (r11 != r0) goto L_0x0053;
        L_0x00d5:
            r0 = "MicroMsg.BackupPcProcessMgr";
            r1 = "onBackupPcProcessMgrNotify receive cancelReq";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            r0 = com.tencent.mm.plugin.report.service.g.oUh;
            r1 = 13737; // 0x35a9 float:1.925E-41 double:6.787E-320;
            r2 = 5;
            r2 = new java.lang.Object[r2];
            r3 = 0;
            r4 = 5;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            r3 = 1;
            r4 = 0;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            r3 = 2;
            r4 = 0;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            r3 = 3;
            r4 = 0;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            r3 = 4;
            r4 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r4 = r4.abe();
            r4 = r4.jGx;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            r0.i(r1, r2);
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r0 = r0.aae();
            r1 = -100;
            r0.jBu = r1;
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r0 = r0.abf();
            r1 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();
            r1 = r1.aae();
            r0.c(r1);
            goto L_0x0053;
        L_0x013a:
            r0 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r1 = 1;
            r0.jk(r1);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
        L_0x0141:
            r0 = move-exception;
            r1 = "MicroMsg.BackupPcProcessMgr";
            r2 = "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.";
            r3 = 0;
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
            goto L_0x00d2;
        L_0x014f:
            com.tencent.mm.u.ap.yY();	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.u.c.vr();	 Catch:{ Exception -> 0x0141 }
            r1 = com.tencent.mm.storage.w.a.uFv;	 Catch:{ Exception -> 0x0141 }
            r2 = 0;
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0141 }
            r0 = r0.get(r1, r2);	 Catch:{ Exception -> 0x0141 }
            r0 = (java.lang.Boolean) r0;	 Catch:{ Exception -> 0x0141 }
            r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0141 }
            if (r0 != 0) goto L_0x017a;
        L_0x0169:
            r0 = "MicroMsg.BackupPcProcessMgr";
            r1 = "onBackupPcProcessMgrNotify not backuping, start new backup.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ Exception -> 0x0141 }
            r0 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r1 = 5;
            r0.jk(r1);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
        L_0x017a:
            com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.aaj();	 Catch:{ Exception -> 0x0141 }
            r1 = "BACKUP_PC_CHOOSE_SESSION";
            r2 = 0;
            r0 = r0.getString(r1, r2);	 Catch:{ Exception -> 0x0141 }
            if (r0 != 0) goto L_0x019c;
        L_0x018b:
            r0 = "MicroMsg.BackupPcProcessMgr";
            r1 = "onBackupPcProcessMgrNotify sessionString is null, start new backup.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ Exception -> 0x0141 }
            r0 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r1 = 5;
            r0.jk(r1);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
        L_0x019c:
            r1 = "MicroMsg.BackupPcProcessMgr";
            r2 = "onBackupPcProcessMgrNotify start continue Backup.";
            com.tencent.mm.sdk.platformtools.w.i(r1, r2);	 Catch:{ Exception -> 0x0141 }
            r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ Exception -> 0x0141 }
            r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
            r4 = 29;
            r6 = 1;
            r8 = 0;
            r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0141 }
            r1 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r2 = 3;
            r1.jGt = r2;	 Catch:{ Exception -> 0x0141 }
            r1 = new java.util.LinkedList;	 Catch:{ Exception -> 0x0141 }
            r2 = ",";
            r0 = com.tencent.mm.plugin.backup.a.h.bl(r0, r2);	 Catch:{ Exception -> 0x0141 }
            r0 = java.util.Arrays.asList(r0);	 Catch:{ Exception -> 0x0141 }
            r1.<init>(r0);	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0 = r0.abf();	 Catch:{ Exception -> 0x0141 }
            r0.init();	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0 = r0.abf();	 Catch:{ Exception -> 0x0141 }
            r0.y(r1);	 Catch:{ Exception -> 0x0141 }
            r0 = 5;
            com.tencent.mm.plugin.backup.backuppcmodel.c.jn(r0);	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0 = r0.abf();	 Catch:{ Exception -> 0x0141 }
            r0.aab();	 Catch:{ Exception -> 0x0141 }
            r0 = 6;
            com.tencent.mm.plugin.backup.backuppcmodel.c.jm(r0);	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0 = r0.abf();	 Catch:{ Exception -> 0x0141 }
            r1 = com.tencent.mm.plugin.backup.g.a.abC();	 Catch:{ Exception -> 0x0141 }
            r1.abF();	 Catch:{ Exception -> 0x0141 }
            r1 = r0.jEn;	 Catch:{ Exception -> 0x0141 }
            r1 = r1.size();	 Catch:{ Exception -> 0x0141 }
            r2 = (long) r1;	 Catch:{ Exception -> 0x0141 }
            r0.aH(r2);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
        L_0x020a:
            r0 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r1 = 3;
            r0.jl(r1);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
        L_0x0212:
            com.tencent.mm.u.ap.yY();	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.u.c.vr();	 Catch:{ Exception -> 0x0141 }
            r1 = com.tencent.mm.storage.w.a.uFw;	 Catch:{ Exception -> 0x0141 }
            r2 = 0;
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0141 }
            r0 = r0.get(r1, r2);	 Catch:{ Exception -> 0x0141 }
            r0 = (java.lang.Boolean) r0;	 Catch:{ Exception -> 0x0141 }
            r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0141 }
            if (r0 != 0) goto L_0x023d;
        L_0x022c:
            r0 = "MicroMsg.BackupPcProcessMgr";
            r1 = "onBackupPcProcessMgrNotify not recovering, start new recover.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ Exception -> 0x0141 }
            r0 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r1 = 7;
            r0.jl(r1);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
        L_0x023d:
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0.abg();	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.d.aaI();	 Catch:{ Exception -> 0x0141 }
            if (r0 != 0) goto L_0x025b;
        L_0x024a:
            r0 = "MicroMsg.BackupPcProcessMgr";
            r1 = "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ Exception -> 0x0141 }
            r0 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r1 = 7;
            r0.jl(r1);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
        L_0x025b:
            r0 = "MicroMsg.BackupPcProcessMgr";
            r1 = "onBackupPcProcessMgrNotify continue Recover.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);	 Catch:{ Exception -> 0x0141 }
            r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ Exception -> 0x0141 }
            r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
            r4 = 30;
            r6 = 1;
            r8 = 0;
            r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0141 }
            r0 = r9.jGA;	 Catch:{ Exception -> 0x0141 }
            r1 = 4;
            r0.jGt = r1;	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0 = r0.abg();	 Catch:{ Exception -> 0x0141 }
            r0.init();	 Catch:{ Exception -> 0x0141 }
            r0 = 7;
            com.tencent.mm.plugin.backup.backuppcmodel.c.jn(r0);	 Catch:{ Exception -> 0x0141 }
            r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.abd();	 Catch:{ Exception -> 0x0141 }
            r0 = r0.abf();	 Catch:{ Exception -> 0x0141 }
            r0.aab();	 Catch:{ Exception -> 0x0141 }
            r0 = 8;
            com.tencent.mm.plugin.backup.backuppcmodel.c.jm(r0);	 Catch:{ Exception -> 0x0141 }
            goto L_0x00d2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.backuppcmodel.c.4.a(boolean, int, byte[], int):void");
        }
    };

    final void abi() {
        b.abd().aaE().connect(this.jGv, this.jGw);
        b.a(1, this.jEc);
        a aVar = new a(b.abd().jBn, b.abd().jBo, com.tencent.mm.plugin.backup.a.e.aai(), b.abd().jBm, 0, 1);
        aVar.cK(true);
        aVar.abt();
        w.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
        if (this.jDZ == null) {
            this.jDZ = new aj(new aj.a(this) {
                final /* synthetic */ c jGA;

                {
                    this.jGA = r1;
                }

                public final boolean oQ() {
                    if (!c.jEa) {
                        w.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
                        if (this.jGA.jDZ != null) {
                            this.jGA.jDZ.KH();
                        }
                        this.jGA.aaK();
                    }
                    return true;
                }
            }, false);
        }
        this.jDZ.v(3000, 3000);
    }

    public final void aaK() {
        String str = this.jGu;
        String str2 = this.jGv;
        String bH = h.bH(ab.getContext());
        b.abd().aaE().stop();
        w.e("MicroMsg.BackupPcProcessMgr", "tryConnectFailed thisWifiName:%s, pcWifiName:%s, pcIpAddress:%s, tryCount:%d", new Object[]{bH, str, str2, Integer.valueOf(hqX)});
        if (bH == null || bH.equals("")) {
            g.oUh.a(400, 1, 1, false);
            g.oUh.i(13736, new Object[]{Integer.valueOf(1), str, bH, Integer.valueOf(0), Integer.valueOf(b.abd().abe().jGx)});
            b.abd().aae().jBu = -1;
            b.abd().abf().c(b.abd().aae());
        } else if (str == null || !str.equals(bH)) {
            g.oUh.a(400, 2, 1, false);
            g.oUh.i(13736, new Object[]{Integer.valueOf(2), str, bH, Integer.valueOf(0), Integer.valueOf(b.abd().abe().jGx)});
            b.abd().aae().jBu = -2;
            b.abd().abf().c(b.abd().aae());
        } else if (!h.rA(str2)) {
            g.oUh.a(400, 3, 1, false);
            g.oUh.i(13736, new Object[]{Integer.valueOf(3), str, bH, Integer.valueOf(0), Integer.valueOf(b.abd().abe().jGx)});
            b.abd().aae().jBu = -3;
            b.abd().abf().c(b.abd().aae());
        } else if (hqX <= 0) {
            g.oUh.a(400, 63, 1, false);
            g.oUh.i(13736, new Object[]{Integer.valueOf(6), str, bH, Integer.valueOf(0), Integer.valueOf(b.abd().abe().jGx)});
            b.abd().aae().jBu = -5;
            b.abd().abf().c(b.abd().aae());
        } else {
            hqX--;
            abi();
        }
    }

    public static String abj() {
        if (b.abs() == null) {
            return "0B";
        }
        return b.abs().abB();
    }

    public final void jk(int i) {
        w.i("MicroMsg.BackupPcProcessMgr", "newBackup, command[%d]", new Object[]{Integer.valueOf(i)});
        this.jGt = 1;
        b.abd().jBp = null;
        b.abd().abf().init();
        e abf = b.abd().abf();
        w.i("MicroMsg.BackupPcServer", "clearContinueBackupData.");
        abf.jEp.cE(false);
        jn(i);
        b.abd().abf().aab();
    }

    public final void jl(int i) {
        w.i("MicroMsg.BackupPcProcessMgr", "newRecover, command[%d]", new Object[]{Integer.valueOf(i)});
        this.jGt = 2;
        b.abd().jBp = null;
        b.abd().abg().init();
        b.abd().abg().aaJ();
        jn(i);
        d abg = b.abd().abg();
        Set hashSet = new HashSet();
        hashSet.addAll(abg.jGB);
        af.v(new com.tencent.mm.plugin.backup.backuppcmodel.d.AnonymousClass2(abg, hashSet));
    }

    public static void jm(int i) {
        w.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
        bVar.jMP = i;
        try {
            b.r(bVar.toByteArray(), 17);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandRequest to buf err.", new Object[0]);
        }
    }

    public static void jn(int i) {
        w.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.backup.h.c cVar = new com.tencent.mm.plugin.backup.h.c();
        cVar.jMP = i;
        try {
            b.r(cVar.toByteArray(), 18);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandResponse to buf err.", new Object[0]);
        }
    }

    public static void aaM() {
        w.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.abd().jBm;
        try {
            b.r(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCancelRequest to buf err.", new Object[0]);
        }
    }
}
