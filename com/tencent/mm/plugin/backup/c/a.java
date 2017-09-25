package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    public com.tencent.mm.plugin.backup.b.b jDk;
    public b jDl;
    public long jDm;
    private LinkedList<d> jDn = null;
    private LinkedList<d> jDo = null;
    public LinkedList<d> jDp = null;
    public boolean jDq = false;
    boolean jDr = false;
    private Object lock = new Object();

    public final LinkedList<d> aax() {
        if (this.jDn == null) {
            this.jDn = new LinkedList();
        }
        return this.jDn;
    }

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
        this.jDo = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (com.tencent.mm.plugin.backup.g.a.abC().abD().wT().i(dVar.jBh, j, j2) > 0) {
                this.jDo.add(dVar);
            }
        }
    }

    public final LinkedList<d> aaz() {
        if (this.jDp == null) {
            this.jDp = new LinkedList();
        }
        return this.jDp;
    }

    public final void aaA() {
        this.jDn = null;
        this.jDp = null;
        this.jDo = null;
        this.jDr = false;
        this.jDq = false;
    }

    public final void cancel() {
        synchronized (this.lock) {
            if (this.jDk != null) {
                this.jDk.cancel();
                this.jDk = null;
            }
            e.d(new File(h.aan()));
        }
    }

    public final void aaB() {
        b.aaD();
        SharedPreferences aaj = com.tencent.mm.plugin.backup.a.e.aaj();
        a(aaj.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), aaj.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0), aaj.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0), aax());
    }

    public final void s(LinkedList<d> linkedList) {
        w.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
        this.jDq = true;
        this.jDn = new LinkedList(linkedList);
        this.jDm = w(this.jDn);
        aaB();
        w.i("MicroMsg.BackupMoveChooseServer", "summerbak onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[]{Integer.valueOf(aax().size()), Integer.valueOf(aay().size())});
        if (this.jDl != null) {
            this.jDl.s(aay());
        }
    }

    public final void a(LinkedList<d> linkedList, d dVar, int i) {
        w.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
        this.jDn = linkedList;
        if (this.jDo != null) {
            Iterator it = this.jDo.iterator();
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                if (dVar2.jBh.equals(dVar.jBh)) {
                    dVar2.jBk = dVar.jBk;
                    dVar2.jBl = dVar.jBl;
                    break;
                }
            }
        }
        if (b.aaD().aaF().jEs) {
            w.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.aaD().aae().w(13, i, linkedList.size());
            b.aaD().aaF().a(b.aaD().aae());
        }
        if (this.jDl != null) {
            this.jDl.a(aay(), dVar, i);
        }
    }

    public final void t(LinkedList<d> linkedList) {
        w.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
        this.jDr = true;
        this.jDn = (LinkedList) linkedList.clone();
        aaB();
        if (b.aaD().aaF().jEs) {
            w.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.aaD().aaF().aaP();
        } else if (this.jDl != null) {
            this.jDl.t(linkedList);
        }
    }

    public final long aaC() {
        if (aaz() == null) {
            return 0;
        }
        Iterator it = aaz().iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((d) it.next()).jBk + j;
        }
        return j;
    }
}
