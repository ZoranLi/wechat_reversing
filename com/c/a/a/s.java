package com.c.a.a;

import android.location.Location;
import android.os.Handler;
import java.util.ArrayList;

final class s {
    private long aMD;
    float aME;
    private ArrayList<String> aMF = new ArrayList();
    private ArrayList<float[]> aMG = new ArrayList();
    private ArrayList<double[]> aMH = new ArrayList();
    public final d aMI;
    Handler aMJ;

    private class a implements Runnable {
        final int aLM;
        final float aMK;
        final float aML;
        final String aMM;
        final /* synthetic */ s aMN;
        final float x;
        final float y;

        public a(s sVar, float f, float f2, float f3, float f4, int i, String str) {
            this.aMN = sVar;
            this.x = f;
            this.y = f2;
            this.aMK = f3;
            this.aML = f4;
            this.aLM = i;
            this.aMM = str;
        }

        public final void run() {
            this.aMN.a(this.x, this.y, this.aMK, this.aML, this.aLM, this.aMM);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ s aMN;
        final double aMO;
        final double aMP;
        final double aMQ;
        final double aMR;
        final double aMS;
        final double aMT;
        final double lat;
        final double lng;

        public b(s sVar, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            this.aMN = sVar;
            this.lat = d;
            this.lng = d2;
            this.aMO = d3;
            this.aMP = d4;
            this.aMQ = d5;
            this.aMR = d6;
            this.aMS = d7;
            this.aMT = d8;
        }

        public final void run() {
            this.aMN.a(this.lat, this.lng, this.aMO, this.aMP, this.aMQ, this.aMR, this.aMS, this.aMT);
        }
    }

    private class c implements Runnable {
        final /* synthetic */ s aMN;

        public c(s sVar) {
            this.aMN = sVar;
        }

        public final void run() {
            this.aMN.ny();
        }
    }

    private class d implements Runnable {
        private final p aJg;
        final /* synthetic */ s aMN;

        public d(s sVar, p pVar) {
            this.aMN = sVar;
            this.aJg = pVar;
        }

        public final void run() {
            this.aMN.aMI.c(this.aJg);
        }
    }

    private class f implements Runnable {
        final /* synthetic */ s aMN;

        public f(s sVar) {
            this.aMN = sVar;
        }

        public final void run() {
            this.aMN.reset();
        }
    }

    static class e extends p {
        final int aMU;

        e(int i) {
            super(8901);
            this.aMU = i;
        }
    }

    static class g extends p {
        final boolean aMV;

        g(boolean z) {
            super(8902);
            this.aMV = z;
        }
    }

    public s(d dVar) {
        this.aMI = dVar;
    }

    private void d(p pVar) {
        if (this.aMJ != null) {
            this.aMJ.post(new d(this, pVar));
        }
    }

    private static void aC(String str) {
        o.m("post_processing_log_" + y.aPw, str);
    }

    final void nx() {
        z.b(null).execute(new c(this));
    }

    public final synchronized void ny() {
        try {
            aj(true);
        } catch (Exception e) {
        }
    }

    final void nz() {
        this.aMD = 0;
        this.aME = 0.0f;
        z.b(null).execute(new f(this));
    }

    public final synchronized void reset() {
        nA();
        nB();
    }

    private synchronized void nA() {
        this.aMH.clear();
    }

    private synchronized void nB() {
        this.aMF.clear();
        this.aMG.clear();
    }

    private synchronized void aj(boolean z) {
        if (!(this.aMG.isEmpty() || this.aMH.isEmpty())) {
            int size = z ? this.aMH.size() : this.aMH.size() - 1;
            int size2 = this.aMG.size();
            if (size > 1) {
                int i = 0;
                int i2 = 1;
                while (i2 < size) {
                    int i3;
                    double[] dArr = (double[]) this.aMH.get(i2 - 1);
                    double[] dArr2 = (double[]) this.aMH.get(i2);
                    float[] fArr = new float[1];
                    Location.distanceBetween(dArr[0], dArr[1], dArr[0], (dArr[1] <= 179.0d ? 1.0E-5d : -1.0E-5d) + dArr[1], fArr);
                    double d = (double) fArr[0];
                    Location.distanceBetween(dArr[0], dArr[1], (dArr[0] <= 89.0d ? 1.0E-5d : -1.0E-5d) + dArr[0], dArr[1], fArr);
                    double d2 = (double) fArr[0];
                    double d3 = dArr2[0] - dArr[0];
                    double d4 = dArr2[1] - dArr[1];
                    if (d4 > 180.0d) {
                        d4 -= 360.0d;
                    } else if (d4 < -180.0d) {
                        d4 += 360.0d;
                    }
                    d4 = (d4 / 1.0E-5d) * d;
                    d3 = (d3 / 1.0E-5d) * d2;
                    double d5 = dArr2[4] - dArr[4];
                    double d6 = dArr2[5] - dArr[5];
                    double sqrt = Math.sqrt(((d4 * d4) + (d3 * d3)) / ((d5 * d5) + (d6 * d6)));
                    if (sqrt < ((double) (1.0f / y.aPz)) || sqrt > ((double) y.aPz)) {
                        int i4 = i;
                        while (i4 < size2 && ((double) ((float[]) this.aMG.get(i4))[2]) <= dArr2[6]) {
                            i4++;
                        }
                        i3 = i4;
                    } else {
                        float f;
                        float f2;
                        float f3;
                        int i5;
                        Object obj;
                        int i6;
                        boolean z2;
                        d4 = Math.atan2(d3, d4) - Math.atan2(d6, d5);
                        d3 = Math.cos(d4);
                        double[] dArr3 = new double[]{d3, -Math.sin(d4), d5, d3};
                        if (sqrt < 1.0d) {
                            d4 = sqrt;
                        } else {
                            d4 = 1.0d / sqrt;
                        }
                        double d7 = d4 * 10.0d;
                        double abs = 1.0d + Math.abs(d5);
                        StringBuilder stringBuilder = new StringBuilder();
                        float f4 = 0.0f;
                        if (y.aPp) {
                            aC("ref_point," + dArr[0] + ',' + dArr[1] + ',' + dArr[2] + ',' + dArr[8]);
                            f = 0.0f;
                            f2 = 0.0f;
                            f3 = 0.0f;
                            i5 = 0;
                            obj = 1;
                            i6 = i;
                        } else {
                            f = 0.0f;
                            f2 = 0.0f;
                            f3 = 0.0f;
                            i5 = 0;
                            int i7 = 1;
                            i6 = i;
                        }
                        while (i6 < size2) {
                            float[] fArr2 = (float[]) this.aMG.get(i6);
                            if (((double) fArr2[2]) > dArr2[6]) {
                                break;
                            }
                            float f5;
                            Object obj2;
                            fArr2[3] = Double.valueOf(Math.max(6.0d, Math.min((Math.abs((((double) fArr2[2]) - dArr[6]) / d7) * abs) + dArr[2], (Math.abs((((double) fArr2[2]) - dArr2[6]) / d7) * abs) + dArr2[2]))).floatValue();
                            double[] dArr4 = new double[]{((double) fArr2[0]) - dArr[4], ((double) fArr2[1]) - dArr[5]};
                            double[] dArr5 = new double[]{dArr4[0] * sqrt, dArr4[1] * sqrt};
                            dArr4 = new double[]{(dArr5[0] * dArr3[0]) + (dArr5[1] * dArr3[1]), (dArr5[0] * dArr3[2]) + (dArr5[1] * dArr3[3])};
                            dArr5 = new double[]{dArr4[0] + 0.0d, dArr4[1] + 0.0d};
                            double[] dArr6 = new double[]{((1.0E-5d * dArr5[1]) / d2) + dArr[0], ((1.0E-5d * dArr5[0]) / d) + dArr[1]};
                            if (dArr6[0] > 90.0d) {
                                dArr6[0] = 180.0d - dArr6[0];
                            } else if (dArr6[0] < -90.0d) {
                                dArr6[0] = -180.0d - dArr6[0];
                            }
                            if (dArr6[1] > 180.0d) {
                                dArr6[1] = dArr6[1] - 360.0d;
                            } else if (dArr6[1] < -180.0d) {
                                dArr6[1] = dArr6[1] + 360.0d;
                            }
                            if (y.aPp) {
                                aC("scan_point," + dArr6[0] + ',' + dArr6[1] + ',' + fArr2[3]);
                            }
                            String str = (String) this.aMF.get(i6);
                            int round = Math.round(fArr2[3]);
                            if (round > i5) {
                                i5 = round;
                            }
                            int round2 = Math.round(fArr2[4]);
                            if (str != null) {
                                try {
                                    stringBuilder.append(str);
                                    double d8 = dArr6[0];
                                    double d9 = dArr6[1];
                                    str = "";
                                    if (v.c(d8, d9)) {
                                        str = "|MD," + d8 + ',' + d9 + ',' + round + ',' + round2 + ',' + str;
                                    } else {
                                        str = "";
                                    }
                                    stringBuilder.append(str);
                                } catch (Error e) {
                                }
                            }
                            if (obj != null) {
                                f = fArr2[5];
                                f5 = fArr2[2];
                                obj2 = null;
                            } else {
                                obj2 = obj;
                                f5 = f;
                                f = f2;
                            }
                            f3 = fArr2[5];
                            f2 = f;
                            i6++;
                            f = f5;
                            obj = obj2;
                            f4 = fArr2[2];
                        }
                        if (y.aPp) {
                            aC("ref_point," + dArr2[0] + ',' + dArr2[1] + ',' + dArr2[2] + ',' + dArr2[8]);
                        }
                        if (((float) i5) <= y.aPx) {
                            float f6 = f3 - f2;
                            f4 -= f;
                            if (f6 > 0.0f && (((double) f4) * sqrt) / ((double) f6) <= ((double) y.aPy)) {
                                r.np().az(stringBuilder.toString());
                                z2 = true;
                                if (y.aPp) {
                                    aC(z2 ? "buffered" : "discarded");
                                }
                                d(new g(z2));
                                i3 = i6;
                            }
                        }
                        z2 = false;
                        if (y.aPp) {
                            if (z2) {
                            }
                            aC(z2 ? "buffered" : "discarded");
                        }
                        d(new g(z2));
                        i3 = i6;
                    }
                    i2++;
                    i = i3;
                }
                this.aMF.subList(0, i).clear();
                this.aMF.trimToSize();
                this.aMG.subList(0, i).clear();
                this.aMG.trimToSize();
                this.aMH.subList(0, size - 1).clear();
                this.aMH.trimToSize();
            }
        }
    }

    public final synchronized void a(float f, float f2, float f3, float f4, int i, String str) {
        this.aMF.add(str);
        this.aMG.add(new float[]{f, f2, f3, null, (float) i, f4});
        if (this.aMF.size() > 256) {
            this.aMF.subList(0, 1).clear();
            this.aMF.trimToSize();
            if (this.aMG.size() > 256) {
                this.aMG.subList(0, 1).clear();
                this.aMG.trimToSize();
            }
        }
    }

    final boolean a(double d, double d2, double d3, float f, double d4, double d5, double d6, long j) {
        if (f < y.aPA) {
            return false;
        }
        if (j - this.aMD < 1000 && f <= this.aME) {
            return false;
        }
        z b = z.b(null);
        b.execute(new b(this, d, d2, d3, (double) f, d4, d5, d6, (double) j));
        this.aMD = j;
        this.aME = f;
        return true;
    }

    public final synchronized void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        Object obj;
        int size = this.aMH.size();
        int size2 = this.aMF.size();
        if (size <= 0) {
            this.aMH.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
            obj = 1;
        } else {
            Object obj2 = (double[]) this.aMH.get(size - 1);
            float[] fArr;
            if (d8 - obj2[8] >= 30000.0d) {
                fArr = new float[1];
                Location.distanceBetween(obj2[0], obj2[1], d, d2, fArr);
                if (fArr[0] >= 30.0f) {
                    this.aMH.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
                    obj = 1;
                    if (size >= 8) {
                        this.aMH.subList(0, 1).clear();
                        this.aMH.trimToSize();
                    }
                    try {
                        aj(false);
                    } catch (Exception e) {
                    }
                }
            } else if (d4 >= obj2[3]) {
                fArr = new float[]{30.0f};
                if (size > 1) {
                    double[] dArr = (double[]) this.aMH.get(size - 2);
                    Location.distanceBetween(dArr[0], dArr[1], d, d2, fArr);
                }
                if (fArr[0] >= 30.0f) {
                    System.arraycopy(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8}, 0, obj2, 0, obj2.length);
                    obj = 1;
                }
            }
            obj = null;
        }
        if (obj != null) {
            int size3 = this.aMH.size();
            d(new e(size3));
            if (size3 == 1) {
                nB();
            }
        }
    }
}
