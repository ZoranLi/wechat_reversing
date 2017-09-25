package com.c.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.List;

class n extends b {
    private int aLA;
    private long aLB;
    private boolean aLC;
    private Location aLD;
    private int aLE;
    private float aLF;
    private float aLG;
    private float aLH;
    private int aLI;
    private int aLJ;
    private long aLK;
    private final e aLs = new e(this);
    public final j aLt = new j();
    private final d aLu = new d();
    private final i aLv;
    public final s aLw;
    private long aLx;
    private long aLy;
    private long aLz;

    private static class d {
        private String aLQ;
        private long aLR;
        private String aLS;
        private long aLT;

        public final synchronized String a(String str, long j, boolean z) {
            String str2;
            if (z) {
                if (this.aLQ != null && c(j, this.aLR)) {
                    str = new StringBuilder(String.valueOf(str)).append(this.aLQ).toString();
                    this.aLQ = null;
                }
                str2 = str;
                if (this.aLS != null && c(j, this.aLT)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.aLS).toString();
                    this.aLS = null;
                }
            } else {
                if (this.aLQ != null && c(j, this.aLR)) {
                    str = new StringBuilder(String.valueOf(str)).append(v.aF(this.aLQ)).toString();
                    this.aLQ = null;
                }
                str2 = str;
                if (this.aLS != null && c(j, this.aLT)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(v.aE(this.aLS)).toString();
                    this.aLS = null;
                }
            }
            return str2;
        }

        public final synchronized void b(String str, long j) {
            this.aLQ = str;
            this.aLR = j;
        }

        public final synchronized void c(String str, long j) {
            this.aLS = str;
            this.aLT = j;
        }

        public final synchronized void reset() {
            this.aLQ = null;
            this.aLS = null;
            this.aLR = 0;
            this.aLT = 0;
        }

        public static boolean c(long j, long j2) {
            return Math.abs(j - j2) <= 10000;
        }
    }

    private class e {
        long aLU;
        public boolean aLV = y.aPu;
        final /* synthetic */ n aLW;

        public e(n nVar) {
            this.aLW = nVar;
        }

        final void ai(boolean z) {
            if ((this.aLV ^ z) != 0) {
                this.aLV = !this.aLV;
                this.aLW.aLw.nx();
                this.aLW.aLw.nz();
                this.aLW.aLt.ai(this.aLV);
                this.aLW.nm();
                if (y.aPp) {
                    String str = "vehicle mode: " + (this.aLV ? "enable" : "disable");
                    o.m("filter_input_log_" + y.aPw, str);
                    o.m("filter_output_log_" + y.aPw, str);
                }
            }
        }

        public final void reset() {
            this.aLU = 0;
            this.aLV = y.aPu;
        }
    }

    static class a extends p {
        final int aLL;
        final int aLM;
        final long aLN;
        final double lat;
        final double lng;

        a(double d, double d2, int i, int i2, long j) {
            super(9901);
            this.lat = d;
            this.lng = d2;
            this.aLL = i;
            this.aLM = i2;
            this.aLN = j;
        }
    }

    static class b extends p {
        final boolean aLO;
        final int code;
        final String message;

        private b(int i, String str) {
            super(9902);
            this.code = i;
            this.message = str;
            this.aLO = false;
        }

        b(int i, String str, byte b) {
            this(i, str);
        }
    }

    static class c extends a {
        final long aLP;

        c(long j, long j2) {
            super(Math.max(j, 3000));
            this.aLP = j2;
        }
    }

    n() {
        if (i.aJP == null) {
            i.aJP = new i();
        }
        this.aLv = i.aJP;
        this.aLC = true;
        this.aLw = new s(this);
    }

    private boolean a(long j, int i, double d, double d2, double d3, float f, int i2, float f2) {
        boolean z;
        long j2 = j / 1000;
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        if (this.aLC) {
            this.aLt.a(j2, toRadians, toRadians2, f, this.aLs.aLV, y.aPv);
            this.aLC = false;
            z = true;
        } else {
            z = false;
        }
        a aVar = new a(i, (double) j2, toRadians, toRadians2, d3, (double) f, i2, (double) f2, 0, 0.0d, 0.0d);
        this.aLt.a(aVar);
        if (y.aPp) {
            o.m("filter_input_log_" + y.aPw, aVar.toString());
        }
        return z;
    }

    public final void nm() {
        this.aLC = true;
        this.aLD = null;
        this.aLE = 0;
    }

    final void a(List<ScanResult> list, long j, long j2) {
        long p = aa.p(j);
        boolean z = this.aLy == 0 || j2 - this.aLy >= this.aLx;
        String a = v.a(list, z);
        String a2 = this.aLu.a(a, j2, z);
        if (z) {
            d np = r.np();
            int i = this.aLJ;
            if (a2 != null) {
                long currentTimeMillis;
                if (np.aJi) {
                    if (np.nr()) {
                        currentTimeMillis = System.currentTimeMillis();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (np.aMj != null) {
                            np.aMj.execute(new e(np, a2, currentTimeMillis, elapsedRealtime, i, true));
                        }
                    } else {
                        np.nq();
                    }
                }
                currentTimeMillis = aa.p(System.currentTimeMillis());
                if (np.aMj != null) {
                    np.aMj.execute(new c(np, a2, currentTimeMillis, 0));
                }
            }
        } else {
            r.np().az(v.a(a2, p, "0"));
        }
        if (d.c(j2, this.aLz)) {
            String str;
            if (z) {
                str = null;
            } else {
                str = a;
            }
            if (str == null) {
                str = v.a(list, false);
            }
            String a3 = v.a(str, p, "2");
            s sVar = this.aLw;
            float f = this.aLF;
            float f2 = this.aLG;
            float f3 = this.aLH;
            float f4 = (float) this.aLI;
            int i2 = this.aLA;
            if (sVar.aME != 0.0f) {
                z.b(null).execute(new a(sVar, f, f2, f3, f4, i2, a3));
            }
        }
    }

    void a(x xVar, long j, long j2) {
        this.aLy = xVar.aMy;
        this.aLA = xVar.level;
        this.aLB = xVar.aLN;
        if (xVar.aPa.equals("W")) {
            if (a(j2, 2, xVar.latitude, xVar.longitude, xVar.altitude, xVar.aLh, xVar.aPf, xVar.aLi)) {
                this.aLv.a(xVar.latitude, xVar.longitude, xVar.aLh, this.aLF, this.aLG, this.aLH);
            }
        }
        if (!u.nD().aNx) {
            c(new a(xVar.latitude, xVar.longitude, Float.valueOf(xVar.aLh).intValue(), this.aLA, this.aLB));
        }
    }

    final void a(float f, float f2, int i, float f3, float f4, float f5, long j) {
        Object obj;
        e eVar = this.aLs;
        if (j - eVar.aLU > 5000) {
            eVar.ai(false);
        }
        if (j - this.aLz > 5000) {
            nn();
        }
        this.aLF = f;
        this.aLG = f2;
        this.aLH = f4;
        this.aLI = i;
        this.aLz = j;
        int i2 = f5 > 0.0f ? 1 : 0;
        this.aLJ = i2;
        if (this.aLy != 0 || j - this.aLK >= 30000) {
            boolean z = i2 == 0;
            if (!(z && this.aLs.aLV)) {
                ab.nJ().ah(z);
                k.nl().ah(z);
            }
        }
        double[] dArr = new double[2];
        i iVar = this.aLv;
        double[] dArr2 = new double[]{(double) f, (double) f2};
        if (iVar.aJY) {
            dArr[0] = iVar.aJQ;
            dArr[1] = iVar.aJR;
            dArr[0] = dArr[0] + ((1.0E-5d * (dArr2[1] - ((double) iVar.aJT))) / ((double) iVar.aJW));
            dArr[1] = dArr[1] + ((1.0E-5d * (dArr2[0] - ((double) iVar.aJS))) / ((double) iVar.aJX));
            if (dArr[0] > 90.0d) {
                dArr[0] = 180.0d - dArr[0];
            } else if (dArr[0] < -90.0d) {
                dArr[0] = -180.0d - dArr[0];
            }
            if (dArr[1] > 180.0d) {
                dArr[1] = dArr[1] - 360.0d;
            } else if (dArr[1] < -180.0d) {
                dArr[1] = dArr[1] + 360.0d;
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            double d = dArr[0];
            double d2 = dArr[1];
            iVar = this.aLv;
            float f6 = ((f4 - iVar.aJU) / 10.0f) + iVar.aJV;
            float f7 = 0.0f;
            Location location = new Location("S");
            location.setLatitude(d);
            location.setLongitude(d2);
            if (this.aLD != null) {
                f7 = this.aLD.bearingTo(location);
            }
            this.aLD = location;
            int max = Math.max(0, i - this.aLE);
            this.aLE = i;
            a aVar = new a(3, (double) (j / 1000), Math.toRadians(d), Math.toRadians(d2), 0.0d, (double) f6, 0, (double) f5, max, (double) f3, Math.toRadians((double) f7));
            this.aLt.a(aVar);
            if (y.aPp) {
                o.m("filter_input_log_" + y.aPw, aVar.toString());
            }
            double[] dArr3 = new double[4];
            long j2 = j / 1000;
            double[] dArr4 = new double[2];
            double[] dArr5 = new double[2];
            double[] dArr6 = new double[2];
            double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
            double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
            j jVar = this.aLt;
            d = ((double) j2) - jVar.aKa.aKc;
            double d3 = d * d;
            double[] dArr9 = new double[2];
            dArr4[0] = jVar.aKa.aKL[0] + (jVar.aKa.aKL[2] * d);
            dArr4[1] = (d * jVar.aKa.aKL[3]) + jVar.aKa.aKL[1];
            dArr6[0] = jVar.aKa.aKL[2];
            dArr6[1] = jVar.aKa.aKL[3];
            if (jVar.aKa.aKt) {
                dArr9[0] = dArr4[0] - jVar.aKa.aKu[0];
                dArr9[1] = dArr4[1] - jVar.aKa.aKu[1];
                d = Math.sqrt((dArr9[0] * dArr9[0]) + (dArr9[1] * dArr9[1]));
                d = (d * d) * jVar.aKa.aKO;
            } else {
                d = 0.0d;
            }
            dArr7[0][0] = (jVar.aKa.aKM[0][0] + (jVar.aKa.aKM[2][2] * d3)) + d;
            dArr7[0][1] = jVar.aKa.aKM[0][1] + (jVar.aKa.aKM[2][3] * d3);
            dArr7[1][0] = jVar.aKa.aKM[1][0] + (jVar.aKa.aKM[3][2] * d3);
            dArr7[1][1] = d + ((d3 * jVar.aKa.aKM[3][3]) + jVar.aKa.aKM[1][1]);
            dArr8[0][0] = jVar.aKa.aKM[2][2];
            dArr8[0][1] = jVar.aKa.aKM[2][3];
            dArr8[1][0] = jVar.aKa.aKM[3][2];
            dArr8[1][1] = jVar.aKa.aKM[3][3];
            jVar.a(1, dArr4, dArr5);
            dArr3[0] = Math.toDegrees(dArr5[0]);
            dArr3[1] = Math.toDegrees(dArr5[1]);
            dArr3[2] = Math.sqrt((dArr7[0][0] + dArr7[1][1]) / 2.0d);
            dArr3[3] = Math.sqrt((dArr6[0] * dArr6[0]) + (dArr6[1] * dArr6[1]));
            if (y.aPp) {
                o.m("filter_output_log_" + y.aPw, String.valueOf(j2) + ',' + dArr3[0] + ',' + dArr3[1] + ',' + dArr3[2] + ',' + dArr3[3]);
            }
            d = dArr3[0];
            double d4 = dArr3[1];
            int intValue = Double.valueOf(dArr3[2]).intValue();
            this.aLu.c(!v.c(d, d4) ? "" : "&SD=" + d + ',' + d4 + ',' + 0 + ',' + intValue + ',' + this.aLA + ',' + 0 + ',' + Double.valueOf(dArr3[3]).intValue() + ',' + 0 + ',' + 0 + ',' + 0, j);
            c(new a(d, d4, intValue, this.aLA, this.aLB));
        }
    }

    final void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2) {
        if (i2 > 0) {
            e eVar = this.aLs;
            if (i3 >= 3) {
                if (j2 - eVar.aLU <= 5000) {
                    eVar.ai(true);
                }
                eVar.aLU = j2;
            }
            this.aLu.b(!v.c(d, d2) ? "" : "&GD=" + d + ',' + d2 + ',' + i + ',' + i3 + ',' + i5 + ',' + i2 + ',' + Math.round(f) + ',' + j + ',', j2);
            if (a(j2, 1, d, d2, (double) i, (float) i2, i5, (float) i3)) {
                this.aLv.a(d, d2, (float) i2, this.aLF, this.aLG, this.aLH);
            }
            if (d.c(j2, this.aLz)) {
                this.aLw.a(d, d2, (double) i2, f, (double) this.aLF, (double) this.aLG, (double) this.aLH, j2);
            }
            if (y.aPp) {
                o.m("gps_log_" + y.aPw, String.valueOf(d) + ',' + d2 + ',' + i + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5 + ',' + f + ',' + j);
            }
        }
    }

    void a(int i, String str, long j, long j2) {
        c(new b(i, str, (byte) 0));
        if (i == -4 || i == -5) {
            stop();
        }
    }

    synchronized void a(Handler handler, a aVar) {
        if (aVar instanceof c) {
            aVar = (c) aVar;
        } else {
            aVar = new c(aVar != null ? aVar.aJl : 5000, 9000);
        }
        this.aLx = aVar.aLP;
        nn();
        this.aLw.aMJ = handler;
        this.aLK = SystemClock.elapsedRealtime();
        super.a(handler, aVar);
    }

    final synchronized void stop() {
        this.aLw.nx();
        super.stop();
    }

    private void nn() {
        this.aLv.aJY = false;
        this.aLw.nz();
        this.aLu.reset();
        this.aLs.reset();
        nm();
        this.aLy = 0;
        this.aLz = SystemClock.elapsedRealtime();
        this.aLF = 0.0f;
        this.aLG = 0.0f;
        this.aLH = 0.0f;
        this.aLI = 0;
        this.aLJ = 0;
        this.aLA = 0;
    }

    final a a(a aVar) {
        return new a(0);
    }
}
