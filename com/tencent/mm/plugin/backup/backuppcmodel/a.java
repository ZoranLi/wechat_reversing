package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements com.tencent.mm.plugin.backup.b.b.a {
    public long jDm;
    private LinkedList<d> jDn = null;
    private LinkedList<d> jDo = null;
    private LinkedList<d> jDp = null;
    public boolean jDq = false;
    public b jEo;
    public boolean jGk = false;
    public com.tencent.mm.plugin.backup.b.b.a jGl;
    private Object lock = new Object();

    private static long w(LinkedList<d> linkedList) {
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((d) linkedList.get(0)).jBi;
            Iterator it = linkedList.iterator();
            j = j2;
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (j > dVar.jBi) {
                    j2 = dVar.jBi;
                } else {
                    j2 = j;
                }
                j = j2;
            }
        }
        return j;
    }

    public final LinkedList<d> aax() {
        if (this.jDn == null) {
            this.jDn = new LinkedList();
        }
        return this.jDn;
    }

    public final LinkedList<d> aay() {
        if (this.jDo == null) {
            this.jDo = new LinkedList();
        }
        return this.jDo;
    }

    public final void a(int i, long j, long j2, LinkedList<d> linkedList) {
        if (i == 0) {
            this.jDo = new LinkedList(linkedList);
            return;
        }
        if (this.jDo == null) {
            this.jDo = new LinkedList();
        } else {
            this.jDo.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (com.tencent.mm.plugin.backup.g.a.abC().abD().wT().i(dVar.jBh, j, j2) > 0) {
                this.jDo.add(dVar);
            }
        }
    }

    public final void x(LinkedList<d> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            this.jDp = new LinkedList();
            return;
        }
        this.jDp = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        this.jDp.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
    }

    private LinkedList<d> aaz() {
        if (this.jDp == null) {
            this.jDp = new LinkedList();
        }
        return this.jDp;
    }

    public final void cI(boolean z) {
        w.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[]{Boolean.valueOf(z)});
        this.jGk = z;
        com.tencent.mm.plugin.backup.g.a.abC().abF();
        e.post(new Runnable(this) {
            final /* synthetic */ a jGm;

            {
                this.jGm = r1;
            }

            public final void run() {
                if (this.jGm.jEo != null) {
                    this.jGm.jEo.cancel();
                }
                this.jGm.jEo = new b();
                this.jGm.jEo.a(this.jGm);
            }
        }, "BackupPcChooseServer.calculateToChoose");
    }

    public final void s(LinkedList<d> linkedList) {
        String str = "MicroMsg.BackupPcChooseServer";
        String str2 = "onCalcuConvFinish, conv size[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        w.i(str, str2, objArr);
        this.jDq = true;
        if (linkedList == null || linkedList.size() == 0) {
            if (this.jGl != null) {
                this.jGl.s(linkedList);
            }
            if (this.jGk) {
                b.abd().abf().jEp.aaq();
                b.abd().aaE().stop();
                b.abd().aae().jBu = -23;
                b.abd().abf().c(b.abd().aae());
                return;
            }
            return;
        }
        this.jDn = new LinkedList(linkedList);
        this.jDm = w(this.jDn);
        b.abd();
        SharedPreferences aaj = b.aaj();
        a(aaj.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), aaj.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0), aaj.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0), aax());
        w.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(aay().size())});
        if (this.jGk) {
            x(aay());
            b.abd().abf().y(h.r(aaz()));
            b.abd().abf().aH((long) aaz().size());
        }
        if (this.jGl != null) {
            this.jGl.s(aay());
        }
    }

    public final void aaA() {
        this.jDn = null;
        this.jDp = null;
        this.jDo = null;
        this.jDq = false;
    }

    public final void cancel() {
        w.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[]{bg.bJZ()});
        synchronized (this.lock) {
            if (this.jEo != null) {
                this.jEo.cancel();
                this.jEo = null;
            }
            com.tencent.mm.a.e.d(new File(h.aan()));
            this.jDq = false;
        }
    }
}
