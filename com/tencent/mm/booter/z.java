package com.tencent.mm.booter;

import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import java.util.Locale;

public final class z {
    public static z gKE = new z();
    public s gKF = new s(w.hgq + "staytime.cfg");
    public a gKG;
    public long gKH;
    public long gKI;
    public String gKJ;
    public long gKK = -1;
    public int gKL = 20;
    public int gKM = 24;
    public int gKN = 30;
    public int gKO = 10800;
    public boolean hasInit = false;

    class a {
        public int fCK;
        public String gKP;
        public int gKQ;
        public int gKR;
        public long gKS;
        public int gKT;
        final /* synthetic */ z gKU;
        public long time;
        public int type;

        public a(z zVar) {
            this.gKU = zVar;
        }

        public final String toString() {
            return String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s|", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.gKQ), Integer.valueOf(this.fCK), Integer.valueOf(this.gKR), Long.valueOf(this.gKS), Integer.valueOf(this.gKT), this.gKP});
        }
    }

    private z() {
    }

    public final void cY(String str) {
        if (str == null || this.gKG == null) {
            boolean z;
            String str2 = "MicroMsg.StayTimeReport";
            String str3 = "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (this.gKG == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.w.i(str2, str3, objArr);
        } else if (str.equals(this.gKG.gKP)) {
            a aVar = this.gKG;
            aVar.time += u.aB(this.gKH) / 1000;
            this.gKF.set(5, ((String) this.gKF.get(5, "")) + this.gKG.toString());
            long j = this.gKF.getLong(4, 0);
            int yA = this.gKF.yA(6) + 1;
            this.gKF.setInt(6, yA);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", this.gKG.gKP, Integer.valueOf(this.gKG.type), Long.valueOf(this.gKG.time), Integer.valueOf(this.gKG.gKT), Integer.valueOf(yA));
            if (u.az(j) > ((long) this.gKO) || yA > this.gKN) {
                yA = 1;
            } else {
                yA = 0;
            }
            if (yA != 0) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.StayTimeReport", "report %d: %s", Integer.valueOf(13062), ((String) this.gKF.get(5, "")) + "," + j + "," + u.Ny());
                g.oUh.A(13062, r0);
                this.gKF.setInt(6, 0);
                this.gKF.set(5, "");
            }
            this.gKG = null;
        } else {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", str, this.gKG.gKP);
        }
    }
}
