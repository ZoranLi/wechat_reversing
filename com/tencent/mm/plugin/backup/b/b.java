package com.tencent.mm.plugin.backup.b;

import android.database.Cursor;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.LinkedList;

public final class b {
    public boolean jBL = false;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b jBO;
        final /* synthetic */ b jBP;
        final /* synthetic */ LinkedList jBQ;
        final /* synthetic */ d jBR;
        final /* synthetic */ int jBS;

        public AnonymousClass3(b bVar, b bVar2, LinkedList linkedList, d dVar, int i) {
            this.jBO = bVar;
            this.jBP = bVar2;
            this.jBQ = linkedList;
            this.jBR = dVar;
            this.jBS = i;
        }

        public final void run() {
            if (!this.jBO.jBL && this.jBP != null) {
                this.jBP.a(this.jBQ, this.jBR, this.jBS);
            }
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ b jBO;
        final /* synthetic */ b jBP;
        final /* synthetic */ LinkedList jBQ;

        public AnonymousClass4(b bVar, b bVar2, LinkedList linkedList) {
            this.jBO = bVar;
            this.jBP = bVar2;
            this.jBQ = linkedList;
        }

        public final void run() {
            if (!this.jBO.jBL && this.jBP != null) {
                this.jBP.t(this.jBQ);
            }
        }
    }

    public interface a {
        void s(LinkedList<d> linkedList);
    }

    public interface b extends a {
        void a(LinkedList<d> linkedList, d dVar, int i);

        void t(LinkedList<d> linkedList);
    }

    public final void cancel() {
        w.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[]{bg.bJZ()});
        this.jBL = true;
    }

    public final void a(final a aVar) {
        w.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
        long Nz = bg.Nz();
        final LinkedList linkedList = new LinkedList();
        Cursor c = com.tencent.mm.plugin.backup.g.a.abC().abD().wW().c(o.hlr, h.aap(), "*");
        if (c.getCount() == 0) {
            if (aVar != null) {
                af.v(new Runnable(this) {
                    final /* synthetic */ b jBO;

                    public final void run() {
                        if (aVar != null) {
                            aVar.s(linkedList);
                        }
                    }
                });
            }
            w.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
            c.close();
            return;
        }
        c.moveToFirst();
        w.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[]{Integer.valueOf(c.getCount())});
        while (!this.jBL) {
            aj aeVar = new ae();
            aeVar.b(c);
            if (!bg.mA(aeVar.field_username)) {
                if (com.tencent.mm.plugin.backup.g.a.abC().abD().wT().Ax(aeVar.field_username) <= 0) {
                    w.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[]{aeVar.field_username});
                } else {
                    ap.yY();
                    if (x.yC(c.wR().Rc(aeVar.field_username).field_verifyFlag)) {
                        w.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[]{aeVar.field_username, Integer.valueOf(r5)});
                    } else {
                        d dVar = new d();
                        dVar.jBh = aeVar.field_username;
                        dVar.jBi = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().AC(aeVar.field_username);
                        dVar.jBj = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().AD(aeVar.field_username);
                        w.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[]{dVar.jBh, Integer.valueOf(r5), Long.valueOf(dVar.jBi), Long.valueOf(dVar.jBj)});
                        linkedList.add(dVar);
                    }
                }
            }
            if (!c.moveToNext()) {
                c.close();
                if (!(this.jBL || aVar == null)) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ b jBO;

                        public final void run() {
                            if (!this.jBO.jBL && aVar != null) {
                                aVar.s(linkedList);
                            }
                        }
                    });
                }
                w.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[]{Long.valueOf(bg.aA(Nz))});
                return;
            }
        }
        w.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        c.close();
    }

    public final boolean a(d dVar, String str, long j) {
        if (dVar == null) {
            return false;
        }
        Cursor Ar = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().Ar(dVar.jBh);
        w.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[]{dVar.jBh, Integer.valueOf(Ar.getCount())});
        if (Ar.moveToFirst()) {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            while (!Ar.isAfterLast()) {
                if (this.jBL) {
                    w.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
                    Ar.close();
                    return true;
                }
                au auVar = new au();
                auVar.b(Ar);
                try {
                    com.tencent.mm.plugin.backup.e.a.a.a(auVar, true, str, pLong, null, null, false, false, j);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.BackupCalculator", e, "packedMsg", new Object[0]);
                }
                pLong2.value++;
                Ar.moveToNext();
            }
            dVar.jBk = pLong.value;
            dVar.jBl = pLong2.value;
            w.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[]{dVar.jBh, Long.valueOf(dVar.jBk), Long.valueOf(dVar.jBl)});
        }
        Ar.close();
        return false;
    }
}
