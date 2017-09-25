package com.tencent.mm.storage;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

final class ah {
    protected final long uJn = 86400;
    private ag uJo = new ag();

    public ah() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        byte[] d = e.d(stringBuilder.append(h.vI().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!bg.bm(d)) {
            try {
                this.uJo.aD(d);
                if (bLP()) {
                    bLO();
                }
            } catch (Throwable e) {
                w.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                w.e("MicroMsg.DelSvrIdMgr", "exception:%s", bg.g(e));
            }
        }
    }

    private void bLO() {
        try {
            this.uJo.uJj.clear();
            this.uJo.uJi.clear();
            this.uJo.uJh.clear();
            byte[] toByteArray = this.uJo.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            e.b(stringBuilder.append(h.vI().cachePath).append("checkmsgid.ini").toString(), toByteArray, toByteArray.length);
        } catch (Throwable e) {
            w.e("MicroMsg.DelSvrIdMgr", "exception:%s", bg.g(e));
        }
    }

    protected final boolean eA(long j) {
        if (bLP()) {
            bLO();
        }
        return this.uJo.uJk.contains(Long.valueOf(j)) || this.uJo.uJl.contains(Long.valueOf(j)) || this.uJo.uJm.contains(Long.valueOf(j));
    }

    protected final void e(int i, long j, long j2) {
        a(i, j, j2, true);
    }

    protected final void a(int i, long j, long j2, boolean z) {
        if (j != 0) {
            if (z) {
                bLP();
            }
            switch (i - ((int) (j2 / 86400))) {
                case 0:
                    this.uJo.uJk.add(Long.valueOf(j));
                    break;
                case 1:
                    this.uJo.uJl.add(Long.valueOf(j));
                    break;
                case 2:
                    this.uJo.uJm.add(Long.valueOf(j));
                    break;
                default:
                    w.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i - ((int) (j2 / 86400))));
                    break;
            }
            if (z) {
                bLO();
            }
        }
    }

    protected final void i(List<Integer> list, List<Long> list2) {
        w.i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        bLP();
        int Ny = (int) (bg.Ny() / 86400);
        for (int i = 0; i < list.size(); i++) {
            a(Ny, (long) ((Integer) list.get(i)).intValue(), ((Long) list2.get(i)).longValue(), false);
        }
        bLO();
    }

    private boolean bLP() {
        w.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.uJo.uJg), Integer.valueOf(this.uJo.uJk.size()), Integer.valueOf(this.uJo.uJl.size()), Integer.valueOf(this.uJo.uJm.size()));
        int Ny = (int) (bg.Ny() / 86400);
        int i = Ny - this.uJo.uJg;
        this.uJo.uJg = Ny;
        switch (i) {
            case 0:
                return false;
            case 1:
                this.uJo.uJm = this.uJo.uJl;
                this.uJo.uJl = this.uJo.uJk;
                this.uJo.uJk.clear();
                return true;
            case 2:
                this.uJo.uJm = this.uJo.uJk;
                this.uJo.uJl.clear();
                this.uJo.uJk.clear();
                return true;
            default:
                this.uJo.uJm.clear();
                this.uJo.uJl.clear();
                this.uJo.uJk.clear();
                return true;
        }
    }
}
