package com.tencent.mm.performance.b;

import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Iterator;

public final class a extends com.tencent.mm.performance.d.a {
    public static String TYPE = "MemoryAlarmController";
    public long ign;
    public long igo;
    public long igp;
    public long igq;
    public boolean igr;
    public HashSet<a> igs;

    public interface a {
        void a(long j, long j2, long j3);

        void b(long j, long j2, long j3);

        void c(long j, long j2, long j3);
    }

    public a() {
        this.ign = -1;
        this.igo = -1;
        this.igp = -1;
        this.igq = -1;
        this.igr = false;
        this.ign = Runtime.getRuntime().maxMemory();
    }

    private void a(int i, long j, long j2, long j3) {
        synchronized (this.igs) {
            Iterator it = this.igs.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                switch (i) {
                    case 0:
                        aVar.a(j, j2, j3);
                        break;
                    case 1:
                        aVar.b(j, j2, j3);
                        break;
                    case 2:
                        aVar.c(j, j2, j3);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final String Nb() {
        return TYPE;
    }

    public final void Nc() {
        if (this.igr) {
            long totalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long j = totalMemory / this.ign;
            w.d("MicroMsg.WxPerformace", "memoryalarm memory use %d, total %d", Long.valueOf(totalMemory), Long.valueOf(this.ign));
            if (j >= this.igq) {
                a(2, j, this.ign, totalMemory);
            } else if (j >= this.igp) {
                a(1, j, this.ign, totalMemory);
            } else if (j >= this.igo) {
                a(0, j, this.ign, totalMemory);
            }
        }
    }
}
