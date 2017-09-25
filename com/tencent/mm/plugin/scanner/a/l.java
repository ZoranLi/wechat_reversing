package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class l {
    public static int oWl = 0;
    public static int oWm = 1;
    public static int oWn = 2;
    public static l oWo = new l();
    private boolean hQa = false;
    public String oWA;
    public StringBuilder oWB = new StringBuilder();
    public int oWC;
    public boolean oWD;
    private long oWp = 0;
    public boolean oWq = false;
    public int oWr = 0;
    private long oWs = 0;
    public int oWt = -1;
    private Point oWu = null;
    public String oWv;
    public String oWw;
    public String oWx;
    public int oWy;
    public int oWz;
    private int retryCount = 0;

    public final void cV(long j) {
        w.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[]{Long.valueOf(j)});
        this.oWp += j;
    }

    public final void aYa() {
        w.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
        this.oWq = true;
    }

    public final void aYb() {
        w.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[]{Integer.valueOf(this.oWr)});
        this.oWr++;
    }

    public final void sd(int i) {
        w.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[]{Integer.valueOf(i)});
        this.oWt = i;
    }

    public final void cL(int i, int i2) {
        w.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.oWu = new Point(i, i2);
    }

    public final void aYc() {
        w.i("MicroMsg.QBarEngineReporter", "addRetryTime, current retry count: %s", new Object[]{Integer.valueOf(this.retryCount)});
        this.retryCount++;
    }

    public final void cW(long j) {
        w.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[]{Long.valueOf(j)});
        this.oWs = j;
    }

    public final void aEK() {
        int i = 0;
        if (this.hQa) {
            w.i("MicroMsg.QBarEngineReporter", "doReport, already report");
            return;
        }
        int i2;
        String str = "MicroMsg.QBarEngineReporter";
        String str2 = "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d";
        Object[] objArr = new Object[16];
        objArr[0] = Integer.valueOf(this.oWr);
        objArr[1] = Long.valueOf(this.oWp);
        objArr[2] = Long.valueOf(this.oWs);
        objArr[3] = Integer.valueOf(this.oWt);
        objArr[4] = this.oWu;
        objArr[5] = Integer.valueOf(this.retryCount);
        objArr[6] = Boolean.valueOf(this.oWq);
        objArr[7] = this.oWv;
        objArr[8] = this.oWw;
        objArr[9] = this.oWx;
        objArr[10] = Integer.valueOf(this.oWy);
        objArr[11] = Integer.valueOf(this.oWz);
        objArr[12] = this.oWA;
        if (bg.mA(this.oWw)) {
            i2 = 0;
        } else {
            i2 = this.oWw.length();
        }
        objArr[13] = Integer.valueOf(i2);
        objArr[14] = this.oWB.toString();
        objArr[15] = Integer.valueOf(this.oWC);
        w.i(str, str2, objArr);
        String str3 = "";
        if (this.oWu != null) {
            str3 = this.oWu.x + "x" + this.oWu.y;
        }
        g gVar = g.oUh;
        objArr = new Object[17];
        objArr[0] = Integer.valueOf(this.oWr);
        objArr[1] = Long.valueOf(this.oWp);
        objArr[2] = Long.valueOf(this.oWs);
        objArr[3] = Integer.valueOf(this.oWt);
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(this.retryCount);
        if (this.oWq) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = this.oWv;
        objArr[8] = "";
        objArr[9] = this.oWx;
        objArr[10] = Integer.valueOf(this.oWy);
        objArr[11] = Integer.valueOf(this.oWz);
        objArr[12] = this.oWA;
        if (bg.mA(this.oWw)) {
            i2 = 0;
        } else {
            i2 = this.oWw.length();
        }
        objArr[13] = Integer.valueOf(i2);
        objArr[14] = this.oWB.toString();
        objArr[15] = Integer.valueOf(this.oWC);
        if (this.oWD) {
            i = 1;
        }
        objArr[16] = Integer.valueOf(i);
        gVar.i(13233, objArr);
        this.hQa = true;
    }

    public final void reset() {
        this.oWp = 0;
        this.oWq = false;
        this.oWr = 0;
        this.oWt = -1;
        this.oWu = null;
        this.retryCount = 0;
        this.oWv = "";
        this.oWw = "";
        this.oWx = "";
        this.oWy = 0;
        this.oWz = 0;
        this.oWA = "";
        this.oWs = 0;
        this.hQa = false;
        this.oWB.delete(0, this.oWB.length());
        this.oWC = 0;
        this.oWD = false;
        w.i("MicroMsg.QBarEngineReporter", "reset");
    }
}
