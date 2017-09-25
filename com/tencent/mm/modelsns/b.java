package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static boolean hRa = false;
    private static AtomicInteger hTD = new AtomicInteger(0);
    public StringBuffer hTA = new StringBuffer();
    public StringBuffer hTB = new StringBuffer();
    public StringBuffer hTC = new StringBuffer();
    public Object hTt = null;
    public int hTu = 1;
    public long hTv;
    public int hTw;
    public int hTx;
    public int hTy;
    public StringBuffer hTz = new StringBuffer();
    public int opType = 0;

    public static b gz(int i) {
        return new b(i, 1);
    }

    public static b gA(int i) {
        return new b(i, 4);
    }

    public final boolean JA() {
        int i = c.hTF;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            if (this.opType >= 501 && this.opType <= 700) {
                return true;
            }
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
        }
        if (i == 2 && this.opType >= 701 && this.opType <= 1000) {
            return true;
        }
        if (i == 3 && this.opType >= 501 && this.opType <= 700) {
            return true;
        }
        if (i == 4) {
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
            if (this.opType >= 501 && this.opType <= 700) {
                return true;
            }
        }
        return false;
    }

    public b(int i, int i2) {
        this.opType = i;
        this.hTy = i2;
        if (JA()) {
            this.hTv = System.currentTimeMillis();
            if (am.isWifi(ab.getContext())) {
                this.hTx = 4;
            } else if (am.is4G(ab.getContext())) {
                this.hTx = 3;
            } else if (am.is3G(ab.getContext())) {
                this.hTx = 2;
            } else if (am.is2G(ab.getContext())) {
                this.hTx = 1;
            } else {
                this.hTx = 0;
            }
            this.hTw = hTD.incrementAndGet();
        }
    }

    public final boolean gB(int i) {
        this.hTt = Integer.valueOf(i);
        return true;
    }

    public final void update() {
        if (JA()) {
            this.hTv = System.currentTimeMillis();
            this.hTw = hTD.incrementAndGet();
        }
    }

    public final b kG(String str) {
        if (JA()) {
            if (this.hTz.length() != 0) {
                this.hTz.append("||" + str);
            } else if (bg.mA(str)) {
                this.hTz.append(" ");
            } else {
                this.hTz.append(str);
            }
        }
        return this;
    }

    public final b gC(int i) {
        return kG(String.valueOf(i));
    }

    public final b kH(String str) {
        if (JA()) {
            if (this.hTA.length() == 0) {
                this.hTA.append(str);
            } else {
                this.hTA.append("||" + str);
            }
        }
        return this;
    }

    public final b JB() {
        this.hTA = new StringBuffer();
        return this;
    }

    public final b JC() {
        this.hTz = new StringBuffer();
        return this;
    }

    public final b kI(String str) {
        if (JA()) {
            if (this.hTB.length() == 0) {
                this.hTB.append(str);
            } else {
                this.hTB.append("||" + str);
            }
        }
        return this;
    }

    public final b bp(boolean z) {
        return kG(z ? "1" : "0");
    }

    public final b gD(int i) {
        if (JA()) {
            if (this.hTA.length() == 0) {
                this.hTA.append(i);
            } else {
                this.hTA.append("||" + i);
            }
        }
        return this;
    }

    public static void JD() {
        w.i("MicroMsg.StatisticsOplog", "wait op");
    }

    public final boolean JE() {
        if (!JA()) {
            return false;
        }
        e.post(new Runnable(this) {
            final /* synthetic */ b hTE;

            {
                this.hTE = r1;
            }

            public final void run() {
                b bVar = this.hTE;
                d dVar = new d();
                dVar.n("\n\nmodel", bVar.hTu + ",");
                dVar.n("opType", bVar.opType + ",");
                dVar.n("timeStamp", bVar.hTv + ",");
                dVar.n("seq", bVar.hTw + ",");
                dVar.n("netWork", bVar.hTx + ",");
                dVar.n("page", bVar.hTy + ",");
                dVar.n("StatusDesc1", bVar.hTz.toString() + ",");
                dVar.n("DataFlowSourceInfo", bVar.hTA.toString() + ",");
                dVar.n("DataFlowResultInfo", bVar.hTB.toString() + ",");
                dVar.n("StatusDesc2", bVar.hTC.toString() + ", ");
                dVar.hTH.append("bindkey: " + bVar.hTt);
                w.d("MicroMsg.StatisticsOplog", "report logbuffer: " + dVar.JG());
                c.oTb.i(12645, dVar);
            }
        }, "StatisticsOplog");
        return true;
    }

    public final byte[] Cf() {
        bdf com_tencent_mm_protocal_c_bdf = new bdf();
        com_tencent_mm_protocal_c_bdf.opType = this.opType;
        com_tencent_mm_protocal_c_bdf.hTy = this.hTy;
        com_tencent_mm_protocal_c_bdf.hTu = this.hTu;
        com_tencent_mm_protocal_c_bdf.hTv = this.hTv;
        com_tencent_mm_protocal_c_bdf.hTw = this.hTw;
        com_tencent_mm_protocal_c_bdf.hTx = this.hTx;
        com_tencent_mm_protocal_c_bdf.uev = this.hTz.toString();
        com_tencent_mm_protocal_c_bdf.uew = this.hTC.toString();
        com_tencent_mm_protocal_c_bdf.uex = this.hTA.toString();
        com_tencent_mm_protocal_c_bdf.uey = this.hTB.toString();
        try {
            return com_tencent_mm_protocal_c_bdf.toByteArray();
        } catch (Exception e) {
            w.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }

    public final void b(Intent intent, String str) {
        byte[] Cf = Cf();
        if (Cf != null) {
            intent.putExtra(str, Cf);
        }
    }

    public static b p(Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        return byteArray == null ? null : C(byteArray);
    }

    public static b o(Intent intent) {
        return c(intent, "intent_key_StatisticsOplog");
    }

    public static b c(Intent intent, String str) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return C(byteArrayExtra);
    }

    private static b C(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        bdf com_tencent_mm_protocal_c_bdf = new bdf();
        try {
            com_tencent_mm_protocal_c_bdf.aD(bArr);
            b bVar = new b(com_tencent_mm_protocal_c_bdf.opType, com_tencent_mm_protocal_c_bdf.hTy);
            bVar.hTu = com_tencent_mm_protocal_c_bdf.hTu;
            bVar.hTv = com_tencent_mm_protocal_c_bdf.hTv;
            bVar.hTw = com_tencent_mm_protocal_c_bdf.hTw;
            bVar.hTx = com_tencent_mm_protocal_c_bdf.hTx;
            bVar.hTz = new StringBuffer(com_tencent_mm_protocal_c_bdf.uev);
            bVar.hTC = new StringBuffer(com_tencent_mm_protocal_c_bdf.uew);
            bVar.hTA = new StringBuffer(com_tencent_mm_protocal_c_bdf.uex);
            bVar.hTB = new StringBuffer(com_tencent_mm_protocal_c_bdf.uey);
            return bVar;
        } catch (Exception e) {
            w.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }
}
