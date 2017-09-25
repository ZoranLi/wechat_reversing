package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.Queue;

public final class j {
    public a jEi;
    public long jHU = 0;
    public long jHV;
    public long jHW;
    public long jHX;
    public Queue<Long> jHY = new LinkedList();
    private aj jHZ = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ j jIa;

        {
            this.jIa = r1;
        }

        public final boolean oQ() {
            long currentTimeMillis = System.currentTimeMillis() - this.jIa.jHX;
            if (currentTimeMillis != 0) {
                this.jIa.jHV = (this.jIa.jHW / currentTimeMillis) * 1000;
                this.jIa.jHY.offer(Long.valueOf(this.jIa.jHV));
                this.jIa.jHV = (((this.jIa.jHU * 10) - ((Long) this.jIa.jHY.poll()).longValue()) + this.jIa.jHV) / 10;
                this.jIa.jHV = this.jIa.jHV > 0 ? this.jIa.jHV : 0;
                this.jIa.jHU = this.jIa.jHV;
                this.jIa.jHW = 0;
                this.jIa.jHX = System.currentTimeMillis();
                this.jIa.jEi.aaN();
            }
            return true;
        }
    }, true);

    public interface a {
        void aaN();
    }

    public j(a aVar) {
        this.jEi = aVar;
    }

    public final String abB() {
        String b;
        long j = this.jHV;
        if ((j >> 30) > 0) {
            b = bg.b(j, 100.0d);
        } else if ((j >> 20) > 0) {
            b = bg.a(j, 100.0d);
        } else if ((j >> 9) > 0) {
            b = Math.round((float) (j / AppSupportContentFlag.MMAPP_SUPPORT_XLS)) + " KB";
        } else {
            b = j + " B";
        }
        w.i("MicroMsg.SpeedCalculator", "getBackupPcSpeed :%s", new Object[]{b});
        return b;
    }

    public final void start() {
        w.i("MicroMsg.SpeedCalculator", "start backup get speed handler.");
        this.jHX = System.currentTimeMillis();
        this.jHW = 0;
        this.jHU = 0;
        this.jHY.clear();
        for (int i = 0; i < 10; i++) {
            this.jHY.offer(Long.valueOf(0));
        }
        this.jHZ.v(1000, 1000);
    }

    public final void stop() {
        w.i("MicroMsg.SpeedCalculator", "stop backup get speed handler.");
        this.jHZ.KH();
    }
}
