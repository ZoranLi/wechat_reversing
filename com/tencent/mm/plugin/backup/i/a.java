package com.tencent.mm.plugin.backup.i;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.aa;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.iy;
import com.tencent.mm.e.a.iz;
import com.tencent.mm.e.a.x;
import com.tencent.mm.e.a.y;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.v.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import java.util.HashMap;
import java.util.LinkedList;

public final class a implements am {
    private static a jOA;
    private static boolean jOB = false;
    private c jOC = new c<aa>(this) {
        final /* synthetic */ a jOH;

        {
            this.jOH = r2;
            this.usg = aa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            aa aaVar = (aa) bVar;
            if (aaVar != null && (aaVar instanceof aa)) {
                Context context = (Context) aaVar.fDh.fDi;
                c.jE(-1).i(new Object[]{context});
                w.i("MicroMsg.BackupCore", "receive BackupUSBStopActionEvent.");
            }
            return false;
        }
    };
    private c jOD = new c<x>(this) {
        final /* synthetic */ a jOH;

        {
            this.jOH = r2;
            this.usg = x.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x xVar = (x) bVar;
            if (xVar != null && (xVar instanceof x)) {
                w.i("MicroMsg.BackupCore", "receive BackupGetA8keyRedirectEvent.");
                String str = xVar.fDe.url;
                c.jE(2).i(new Object[]{str});
            }
            return false;
        }
    };
    private c jOE = new c<iz>(this) {
        final /* synthetic */ a jOH;

        {
            this.jOH = r2;
            this.usg = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final iz izVar = (iz) bVar;
            if (!(izVar == null || !(izVar instanceof iz) || izVar.fOP == null)) {
                w.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent.");
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jOJ;

                    public final void run() {
                        iz izVar = izVar;
                        w.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[]{Boolean.valueOf(izVar.fOP.fOS)});
                        if (izVar.fOP.fOS) {
                            g.oUh.a(466, 13, 1, false);
                            return;
                        }
                        byte[] bArr = izVar.fOP.fOQ;
                        int i = izVar.fOP.fOR;
                        if (e.nOy == null) {
                            e.nOy = new e();
                        }
                        e eVar = e.nOy;
                        w.i("MicroMsg.MsgSynchronizeServer", "msg synchronize start, loginDevice[%d]", new Object[]{Integer.valueOf(i)});
                        g.oUh.a(466, 0, 1, false);
                        eVar.nOE = bg.Nz();
                        eVar.nOA = bArr;
                        eVar.fOR = i;
                        com.tencent.mm.plugin.backup.g.a.abC().abF();
                        eVar.nOz.nOs = eVar;
                        eVar.nOz.nOr = false;
                        com.tencent.mm.plugin.v.c cVar = eVar.nOz;
                        long currentTimeMillis = System.currentTimeMillis();
                        LinkedList linkedList = new LinkedList();
                        Cursor c = com.tencent.mm.plugin.backup.g.a.abC().abD().wW().c(o.hlr, h.aap(), "*");
                        if (c.getCount() == 0) {
                            w.i("MicroMsg.MsgSynchronizePack", "empty conversation!");
                            c.close();
                        } else {
                            c.moveToFirst();
                            w.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count:%d", new Object[]{Integer.valueOf(c.getCount())});
                            while (!cVar.nOr) {
                                aj aeVar = new ae();
                                aeVar.b(c);
                                if (!bg.mA(aeVar.field_username)) {
                                    w.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s msgCnt:%d", new Object[]{aeVar.field_username, Integer.valueOf(com.tencent.mm.plugin.backup.g.a.abC().abD().wT().Ax(aeVar.field_username))});
                                    if (com.tencent.mm.plugin.backup.g.a.abC().abD().wT().Ax(aeVar.field_username) > 0) {
                                        linkedList.add(new com.tencent.mm.plugin.v.c.a(aeVar.field_username));
                                    }
                                }
                                if (!c.moveToNext()) {
                                    c.close();
                                    w.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + (System.currentTimeMillis() - currentTimeMillis));
                                    break;
                                }
                            }
                            c.close();
                        }
                        w.i("MicroMsg.MsgSynchronizeServer", "calculateConversationList finish. conversationList size:%d", new Object[]{Integer.valueOf(linkedList.size())});
                        if (linkedList.size() == 0) {
                            String str;
                            Boolean bool = com.tencent.mm.plugin.backup.g.a.abC().abD().jIK;
                            String str2 = "MicroMsg.MsgSynchronizeServer";
                            String str3 = "No conversation to synchronize isTempDb[%s]";
                            Object[] objArr = new Object[1];
                            if (bool == null) {
                                str = "null";
                            } else {
                                Object obj = bool;
                            }
                            objArr[0] = str;
                            w.e(str2, str3, objArr);
                            if (bool != null) {
                                com.tencent.mm.plugin.backup.g.a.abC().o(new com.tencent.mm.plugin.v.e.AnonymousClass1(eVar));
                            }
                            long aA = bg.aA(eVar.nOE);
                            g.oUh.a(466, 1, 1, false);
                            g.oUh.a(466, 5, 0, false);
                            g.oUh.a(466, 7, aA, false);
                            g.oUh.a(466, 11, 0, false);
                            g.oUh.a(466, 12, 0, false);
                            g.oUh.i(14108, new Object[]{Integer.valueOf(0), Long.valueOf(aA), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i)});
                        } else if (com.tencent.mm.plugin.v.b.nOq < 0) {
                            eVar.nOz.b(linkedList, (long) com.tencent.mm.plugin.v.b.nOq);
                        } else {
                            eVar.nOz.b(linkedList, bg.aA((long) ((((com.tencent.mm.plugin.v.b.nOq * 24) * 60) * 60) * 1000)));
                        }
                    }
                });
            }
            return false;
        }
    };
    private c jOF = new c<iy>(this) {
        final /* synthetic */ a jOH;

        {
            this.jOH = r2;
            this.usg = iy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iy iyVar = (iy) bVar;
            if (iyVar != null && (iyVar instanceof iy)) {
                w.i("MicroMsg.BackupCore", "receive MsgSynchronizeABTestEvent.");
                com.tencent.mm.plugin.v.b.aMq();
                iyVar.fOL.fOM = com.tencent.mm.plugin.v.b.nOk;
                iyVar.fOL.fON = com.tencent.mm.plugin.v.b.nOl;
                iyVar.fOL.fOO = com.tencent.mm.plugin.v.b.nOm;
            }
            return false;
        }
    };
    private com.tencent.mm.u.bp.a jOG = new com.tencent.mm.u.bp.a(this) {
        final /* synthetic */ a jOH;

        {
            this.jOH = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            w.i("MicroMsg.BackupCore.BackupToPc", "backupcore onrecieveMsg");
            g.oUh.a(400, 0, 1, false);
            String str = (String) bh.q(n.a(aVar.hst.tff), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
            if (bg.mA(str)) {
                w.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
            }
            ab.getContext().startService(bg.y(ab.getContext(), new Intent().setClassName(ab.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService")).putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, str).putExtra("isFromWifi", true));
        }
    };

    public a() {
        w.i("MicroMsg.BackupCore", "BackupCore init");
    }

    public static a acC() {
        if (jOA == null) {
            jOA = new a();
        }
        return jOA;
    }

    public static void reset() {
        if (com.tencent.mm.plugin.backup.a.e.aal()) {
            jOB = true;
            return;
        }
        jOA = null;
        com.tencent.mm.plugin.backup.a.a.ZX();
        com.tencent.mm.plugin.backup.a.e.aam();
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        b acD = b.acD();
        w.i("MicroMsg.BackupEventListener", "init addListener");
        acD.jOK = new c<com.tencent.mm.e.a.w>(acD) {
            final /* synthetic */ b jON;

            {
                this.jON = r2;
                this.usg = com.tencent.mm.e.a.w.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                a.reset();
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(acD.jOK);
        acD.jOL = new c<y>(acD) {
            final /* synthetic */ b jON;

            {
                this.jON = r2;
                this.usg = y.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                boolean z = ((y) bVar).fDf.fDg;
                c.jE(1).i(new Object[]{Boolean.valueOf(z)});
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(acD.jOL);
        acD.iyu = new c<ad>(acD) {
            final /* synthetic */ b jON;

            {
                this.jON = r2;
                this.usg = ad.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                ad adVar = (ad) bVar;
                w.i("MicroMsg.BackupEventListener", "receive BannerOnInitEvent.");
                com.tencent.mm.sdk.b.b aeVar = new com.tencent.mm.e.a.ae();
                aeVar.fDk.fDm = new a(adVar.fDj.activity);
                com.tencent.mm.sdk.b.a.urY.m(aeVar);
                aeVar = new com.tencent.mm.e.a.ae();
                aeVar.fDk.fDm = new com.tencent.mm.plugin.backup.backupui.a(adVar.fDj.activity);
                com.tencent.mm.sdk.b.a.urY.m(aeVar);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(acD.iyu);
        ap.getSysCmdMsgExtension().a("MMBakChatNotify", this.jOG, true);
        com.tencent.mm.sdk.b.a.urY.a(this.jOC);
        com.tencent.mm.sdk.b.a.urY.a(this.jOD);
        com.tencent.mm.sdk.b.a.urY.a(this.jOE);
        com.tencent.mm.sdk.b.a.urY.a(this.jOF);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        b acD = b.acD();
        com.tencent.mm.sdk.b.a.urY.c(acD.jOK);
        com.tencent.mm.sdk.b.a.urY.c(acD.jOL);
        com.tencent.mm.sdk.b.a.urY.c(acD.iyu);
        ap.getSysCmdMsgExtension().b("MMBakChatNotify", this.jOG, true);
        com.tencent.mm.sdk.b.a.urY.c(this.jOC);
        com.tencent.mm.sdk.b.a.urY.c(this.jOD);
        com.tencent.mm.sdk.b.a.urY.c(this.jOE);
        com.tencent.mm.sdk.b.a.urY.c(this.jOF);
    }
}
