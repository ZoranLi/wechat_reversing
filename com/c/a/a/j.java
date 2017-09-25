package com.c.a.a;

import java.lang.reflect.Array;

final class j {
    private double[] aJZ = new double[4];
    final b aKa = new b();
    private final b aKb = new b();

    protected static class a {
        double aKc;
        double aKd;
        double aKe;
        double[] aKf = new double[2];
        double aKg;
        double aKh;
        int aKi;
        double aKj;
        double aKk;
        int aKl;
        double aKm;
        double aKn;
        double aKo;
        int mType;

        protected a(int i, double d, double d2, double d3, double d4, double d5, int i2, double d6, int i3, double d7, double d8) {
            this.mType = i;
            this.aKc = d;
            this.aKd = d2;
            this.aKe = d3;
            this.aKg = d4;
            this.aKh = d5;
            this.aKi = i2;
            this.aKj = d6;
            this.aKk = 0.0d;
            this.aKl = i3;
            this.aKm = 0.0d;
            this.aKn = d7;
            this.aKo = d8;
        }

        public final String toString() {
            return new StringBuilder(String.valueOf(String.valueOf(this.mType))).append(',').append(this.aKc).append(',').append(this.aKd).append(',').append(this.aKe).append(',').append(this.aKg).append(',').append(this.aKh).append(',').append(this.aKi).append(',').append(this.aKj).append(',').append(this.aKk).append(',').append(this.aKl).append(',').append(this.aKn).append(',').append(this.aKo).toString();
        }
    }

    private static class b {
        public double aKA;
        public double aKB;
        public double aKC;
        public double aKD;
        public double aKE;
        public double aKF;
        public double aKG;
        public double[] aKH = new double[2];
        private boolean aKI;
        public boolean aKJ;
        public boolean aKK;
        public double[] aKL = new double[4];
        public double[][] aKM = ((double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4}));
        public double aKN;
        public double aKO;
        public double aKP;
        public boolean aKQ;
        public double aKR;
        public double aKS;
        public int aKT;
        public int aKU;
        public double aKV;
        public double[] aKW = new double[2];
        public double[] aKX = new double[2];
        public boolean aKY;
        public double aKc;
        public double aKp;
        public boolean aKq;
        public double[] aKr = new double[2];
        public double aKs;
        public boolean aKt;
        public double[] aKu = new double[2];
        public double aKv;
        public int aKw;
        public int aKx;
        public boolean aKy;
        public boolean aKz;

        public final void a(b bVar) {
            this.aKp = bVar.aKp;
            this.aKq = bVar.aKq;
            this.aKr = (double[]) bVar.aKr.clone();
            this.aKs = bVar.aKs;
            this.aKt = bVar.aKt;
            this.aKu = (double[]) bVar.aKu.clone();
            this.aKv = bVar.aKv;
            this.aKw = bVar.aKw;
            this.aKx = bVar.aKx;
            this.aKy = bVar.aKy;
            this.aKz = bVar.aKz;
            this.aKA = bVar.aKA;
            this.aKB = bVar.aKB;
            this.aKC = bVar.aKC;
            this.aKD = bVar.aKD;
            this.aKE = bVar.aKE;
            this.aKF = bVar.aKF;
            this.aKG = bVar.aKG;
            this.aKH = (double[]) bVar.aKH.clone();
            this.aKI = bVar.aKI;
            this.aKJ = bVar.aKJ;
            this.aKK = bVar.aKK;
            this.aKc = bVar.aKc;
            this.aKL = (double[]) bVar.aKL.clone();
            this.aKM[0] = (double[]) bVar.aKM[0].clone();
            this.aKM[1] = (double[]) bVar.aKM[1].clone();
            this.aKM[2] = (double[]) bVar.aKM[2].clone();
            this.aKM[3] = (double[]) bVar.aKM[3].clone();
            this.aKN = bVar.aKN;
            this.aKO = bVar.aKO;
            this.aKP = bVar.aKP;
            this.aKQ = bVar.aKQ;
            this.aKR = bVar.aKR;
            this.aKS = bVar.aKS;
            this.aKT = bVar.aKT;
            this.aKU = bVar.aKU;
            this.aKV = bVar.aKV;
            this.aKW = (double[]) bVar.aKW.clone();
            this.aKX = (double[]) bVar.aKX.clone();
            this.aKY = bVar.aKY;
        }
    }

    j() {
    }

    protected final void a(long j, double d, double d2, float f, boolean z, boolean z2) {
        double d3 = (double) j;
        double[] dArr = new double[]{d, d2};
        double d4 = (double) (f * f);
        double[] dArr2 = new double[]{0.0d, 0.0d};
        int i = z ? 3 : 5;
        double[] dArr3 = new double[]{d, d2};
        this.aKa.aKQ = true;
        this.aKa.aKX[0] = 3.0d;
        this.aKa.aKX[1] = 1.2d;
        this.aKa.aKV = 0.5d;
        this.aKa.aKp = 1.2d;
        this.aKa.aKv = 4.0d;
        this.aKa.aKw = 0;
        this.aKa.aKy = true;
        this.aKa.aKx = i;
        this.aKa.aKq = false;
        this.aKa.aKt = false;
        this.aKa.aKE = 40.0d;
        this.aKa.aKF = 0.15707963267948966d;
        this.aKa.aKG = 1.0d;
        this.aKa.aKW[0] = 400.0d;
        this.aKa.aKW[1] = 1.0d;
        this.aKa.aKJ = z2;
        this.aKa.aKK = false;
        this.aKa.aKz = true;
        this.aKa.aKA = 0.3333333333333333d;
        this.aKa.aKB = 5.0d;
        this.aKa.aKC = 0.5d;
        this.aKa.aKD = 1.0d;
        this.aKa.aKR = 0.5d;
        this.aKa.aKS = 1.0d;
        this.aKa.aKT = 0;
        this.aKa.aKU = 2;
        this.aKa.aKY = false;
        this.aKa.aKH[0] = dArr3[0];
        this.aKa.aKH[1] = dArr3[1];
        double[] dArr4 = new double[2];
        a(0, dArr, dArr4);
        this.aKa.aKc = d3;
        this.aKa.aKL[0] = dArr4[0];
        this.aKa.aKL[1] = dArr4[1];
        this.aKa.aKL[2] = dArr2[0];
        this.aKa.aKL[3] = dArr2[1];
        this.aKa.aKN = 0.0d;
        this.aKa.aKO = 1.0d;
        this.aKa.aKP = 1.005d;
        this.aKa.aKM[0][0] = d4;
        this.aKa.aKM[0][1] = 0.0d;
        this.aKa.aKM[0][2] = 0.0d;
        this.aKa.aKM[0][3] = 0.0d;
        this.aKa.aKM[1][0] = 0.0d;
        this.aKa.aKM[1][1] = d4;
        this.aKa.aKM[1][2] = 0.0d;
        this.aKa.aKM[1][3] = 0.0d;
        this.aKa.aKM[2][0] = 0.0d;
        this.aKa.aKM[2][1] = 0.0d;
        this.aKa.aKM[2][2] = 1.0d;
        this.aKa.aKM[2][3] = 0.0d;
        this.aKa.aKM[3][0] = 0.0d;
        this.aKa.aKM[3][1] = 0.0d;
        this.aKa.aKM[3][2] = 0.0d;
        this.aKa.aKM[3][3] = 1.0d;
        ai(z);
    }

    protected final void ai(boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.aKa.aKQ != z2) {
            this.aKa.aKQ = z2;
            if (z2) {
                this.aKa.aKp = this.aKa.aKX[1];
                this.aKa.aKG = this.aKa.aKW[1];
                a(this.aKa.aKc, true);
                return;
            }
            this.aKa.aKp = this.aKa.aKX[0];
            this.aKa.aKG = this.aKa.aKW[0];
            a(this.aKa.aKc, true);
        }
    }

    protected final void a(a aVar) {
        if (aVar.aKh > 0.0d) {
            double d;
            if (this.aKa.aKq) {
                d = aVar.aKc - this.aKa.aKs;
                if (d < -10.0d) {
                    return;
                }
                if (d <= 0.0d) {
                    aVar.aKc = this.aKa.aKs + 0.5d;
                }
            }
            r12 = new double[2];
            a(0, new double[]{aVar.aKd, aVar.aKe}, r12);
            aVar.aKf[0] = r12[0];
            aVar.aKf[1] = r12[1];
            double[][] dArr;
            double[] dArr2;
            double d2;
            double sqrt;
            double d3;
            Object obj;
            int i;
            if (this.aKa.aKQ) {
                if (aVar.mType != 3 || this.aKa.aKq) {
                    double d4;
                    double d5;
                    double[] dArr3;
                    if (aVar.mType == 3) {
                        d4 = aVar.aKc - this.aKa.aKs;
                        if (d4 > 0.0d) {
                            dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                            dArr2 = new double[2];
                            d5 = r12[0] - this.aKa.aKr[0];
                            d2 = r12[1] - this.aKa.aKr[1];
                            if (this.aKa.aKJ) {
                                d5 = (d5 * Math.cos(this.aKa.aKN)) - (Math.sin(this.aKa.aKN) * d2);
                                d2 = (d2 * Math.cos(this.aKa.aKN)) + (Math.sin(this.aKa.aKN) * d5);
                            }
                            sqrt = Math.sqrt((d5 * d5) + (d2 * d2));
                            d3 = sqrt / this.aKa.aKE;
                            d3 *= d3;
                            if (d3 <= 0.0625d) {
                                d3 = 0.0625d;
                            }
                            sqrt *= this.aKa.aKF;
                            sqrt *= sqrt;
                            if (sqrt <= 0.0625d) {
                                sqrt = 0.0625d;
                            }
                            d3 = (d3 + sqrt) / d4;
                            a(new double[]{this.aKa.aKM[2][2], this.aKa.aKM[2][3], this.aKa.aKM[3][2], this.aKa.aKM[3][3]}, this.aJZ);
                            dArr[0][0] = this.aJZ[0];
                            dArr[0][1] = this.aJZ[1];
                            dArr[1][0] = this.aJZ[2];
                            dArr[1][1] = this.aJZ[3];
                            sqrt = (d5 / d4) - this.aKa.aKL[2];
                            double d6 = (d2 / d4) - this.aKa.aKL[3];
                            if (Math.sqrt((((sqrt * d6) * dArr[1][0]) + (((sqrt * sqrt) * dArr[0][0]) + ((sqrt * d6) * dArr[0][1]))) + ((d6 * d6) * dArr[1][1])) > 2.0d) {
                                this.aKa.aKM[2][2] = this.aKa.aKG;
                                this.aKa.aKM[2][3] = 0.0d;
                                this.aKa.aKM[3][2] = 0.0d;
                                this.aKa.aKM[3][3] = this.aKa.aKG;
                                dArr[0][0] = 1.0d / this.aKa.aKG;
                                dArr[0][1] = 0.0d;
                                dArr[1][0] = 0.0d;
                                dArr[1][1] = 1.0d / this.aKa.aKG;
                            }
                            dArr2[0] = (dArr[0][0] * this.aKa.aKL[2]) + (dArr[0][1] * this.aKa.aKL[3]);
                            dArr2[1] = (dArr[1][0] * this.aKa.aKL[2]) + (dArr[1][1] * this.aKa.aKL[3]);
                            dArr3 = dArr[0];
                            dArr3[0] = dArr3[0] + (1.0d / d3);
                            dArr3 = dArr[1];
                            dArr3[1] = dArr3[1] + (1.0d / d3);
                            dArr2[0] = (d5 / (d4 * d3)) + dArr2[0];
                            dArr2[1] = (d2 / (d3 * d4)) + dArr2[1];
                            a(new double[]{dArr[0][0], dArr[0][1], dArr[1][0], dArr[1][1]}, this.aJZ);
                            this.aKa.aKM[2][2] = this.aJZ[0];
                            this.aKa.aKM[2][3] = this.aJZ[1];
                            this.aKa.aKM[3][2] = this.aJZ[2];
                            this.aKa.aKM[3][3] = this.aJZ[3];
                            this.aKa.aKL[2] = (this.aKa.aKM[2][2] * dArr2[0]) + (this.aKa.aKM[2][3] * dArr2[1]);
                            this.aKa.aKL[3] = (this.aKa.aKM[3][2] * dArr2[0]) + (this.aKa.aKM[3][3] * dArr2[1]);
                            a(aVar.aKc, false);
                        }
                    } else {
                        dArr3 = new double[2];
                        double[] dArr4 = new double[2];
                        a(aVar.aKc, false);
                        if (this.aKa.aKz) {
                            Object obj2;
                            if (this.aKa.aKt) {
                                dArr3[0] = this.aKa.aKL[0] - this.aKa.aKu[0];
                                dArr3[1] = this.aKa.aKL[1] - this.aKa.aKu[1];
                                dArr4[0] = r12[0] - this.aKa.aKu[0];
                                dArr4[1] = r12[1] - this.aKa.aKu[1];
                                d5 = Math.sqrt((dArr3[0] * dArr3[0]) + (dArr3[1] * dArr3[1]));
                                d3 = Math.sqrt((dArr4[0] * dArr4[0]) + (dArr4[1] * dArr4[1]));
                                if (d3 > this.aKa.aKB && d5 > this.aKa.aKB) {
                                    d2 = d3 / d5;
                                    d = d3 - d5;
                                    d4 = Math.sqrt(this.aKa.aKM[0][0] + this.aKa.aKM[1][1]);
                                    if (d5 > 3.0d * this.aKa.aKB) {
                                        if (d < 0.0d) {
                                            d = -d;
                                        }
                                        d2 = d / d4;
                                        d = Math.atan2(dArr4[1], dArr4[0]) - Math.atan2(dArr3[1], dArr3[0]);
                                        if (d > 3.141592653589793d) {
                                            d -= 6.283185307179586d;
                                        } else if (d < -3.141592653589793d) {
                                            d += 6.283185307179586d;
                                        }
                                        if (d < 0.0d) {
                                            d = -d;
                                        }
                                        d /= Math.sqrt(this.aKa.aKO);
                                        d = Math.sqrt((d * d) + (d2 * d2));
                                        if (d < this.aKa.aKv) {
                                            this.aKa.aKT = 0;
                                        } else if (d2 < this.aKa.aKv) {
                                            b bVar = this.aKa;
                                            int i2 = bVar.aKT + 1;
                                            bVar.aKT = i2;
                                            if (i2 >= this.aKa.aKU) {
                                                this.aKa.aKT = 0;
                                                d = d2;
                                            }
                                        }
                                        if (d > this.aKa.aKv) {
                                            d2 = d5;
                                            d5 = d3;
                                            obj2 = null;
                                            obj = null;
                                        } else {
                                            d2 = d5;
                                            d5 = d3;
                                            int i3 = 1;
                                            i = 1;
                                        }
                                    } else if (d2 < this.aKa.aKA || 1.0d / d2 < this.aKa.aKA) {
                                        d2 = d5;
                                        d5 = d3;
                                        obj2 = null;
                                        obj = null;
                                    } else {
                                        d2 = d5;
                                        d5 = d3;
                                        obj2 = null;
                                        i = 1;
                                    }
                                } else if ((d3 >= this.aKa.aKB || aVar.mType != 2) && (d3 >= this.aKa.aKB * 0.5d || aVar.mType != 1)) {
                                    d2 = d5;
                                    d5 = d3;
                                    obj2 = null;
                                    i = 1;
                                } else {
                                    d2 = d5;
                                    d5 = d3;
                                    obj2 = null;
                                    obj = null;
                                }
                            } else {
                                obj2 = 1;
                                d2 = 0.0d;
                                obj = 1;
                                d5 = 0.0d;
                            }
                            if (obj != null) {
                                if (this.aKa.aKt) {
                                    if (d5 < d2) {
                                        d = this.aKa.aKC;
                                    } else {
                                        d = this.aKa.aKD;
                                    }
                                    d += (d2 / d5) * (1.0d - d);
                                    r12[0] = this.aKa.aKu[0] + (dArr4[0] * d);
                                    r12[1] = (d * dArr4[1]) + this.aKa.aKu[1];
                                }
                                if (obj2 != null) {
                                    a(r12);
                                } else {
                                    this.aKa.aKu[0] = r12[0];
                                    this.aKa.aKu[1] = r12[1];
                                }
                                this.aKa.aKL[0] = r12[0];
                                this.aKa.aKL[1] = r12[1];
                                this.aKa.aKM[0][0] = aVar.aKh * aVar.aKh;
                                this.aKa.aKM[0][1] = 0.0d;
                                this.aKa.aKM[1][0] = 0.0d;
                                this.aKa.aKM[1][1] = aVar.aKh * aVar.aKh;
                            }
                        } else {
                            this.aKb.a(this.aKa);
                            b(aVar.aKc, false);
                            if (!this.aKb.aKy) {
                                d2 = r12[0] - this.aKb.aKL[0];
                                d5 = r12[1] - this.aKb.aKL[1];
                                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                                d3 = 1.0d / ((this.aKb.aKM[0][0] * this.aKb.aKM[1][1]) - (this.aKb.aKM[0][1] * this.aKb.aKM[1][0]));
                                dArr[0][0] = this.aKb.aKM[1][1] * d3;
                                dArr[1][1] = this.aKb.aKM[0][0] * d3;
                                dArr[0][1] = (-this.aKb.aKM[0][1]) * d3;
                                dArr[1][0] = d3 * (-this.aKb.aKM[1][0]);
                                d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                            } else if (this.aKa.aKt) {
                                d = this.aKa.aKu[0] - this.aKb.aKL[0];
                                d2 = this.aKa.aKu[1] - this.aKb.aKL[1];
                                d5 = this.aKa.aKu[0] - r12[0];
                                d3 = this.aKa.aKu[1] - r12[1];
                                d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                                d = Math.abs(d) / Math.sqrt((this.aKa.aKM[0][0] * this.aKa.aKM[0][0]) + (this.aKa.aKM[1][1] * this.aKa.aKM[1][1]));
                            } else {
                                d = 0.0d;
                            }
                            if (d > this.aKa.aKv) {
                                this.aKb.a(this.aKa);
                                b(aVar.aKc, true);
                                if (this.aKa.aKy) {
                                    d = this.aKa.aKu[0] - this.aKb.aKL[0];
                                    d2 = this.aKa.aKu[1] - this.aKb.aKL[1];
                                    d5 = this.aKa.aKu[0] - r12[0];
                                    d3 = this.aKa.aKu[1] - r12[1];
                                    d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                                    d = Math.abs(d) / Math.sqrt((this.aKb.aKM[0][0] * this.aKb.aKM[0][0]) + (this.aKb.aKM[1][1] * this.aKb.aKM[1][1]));
                                } else {
                                    d2 = r12[0] - this.aKb.aKL[0];
                                    d5 = r12[1] - this.aKb.aKL[1];
                                    dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                                    d3 = 1.0d / ((this.aKb.aKM[0][0] * this.aKb.aKM[1][1]) - (this.aKb.aKM[0][1] * this.aKb.aKM[1][0]));
                                    dArr[0][0] = this.aKb.aKM[1][1] * d3;
                                    dArr[1][1] = this.aKb.aKM[0][0] * d3;
                                    dArr[0][1] = (-this.aKb.aKM[0][1]) * d3;
                                    dArr[1][0] = d3 * (-this.aKb.aKM[1][0]);
                                    d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                                }
                                if (d <= this.aKb.aKv) {
                                    this.aKa.a(this.aKb);
                                    this.aKa.aKw = 0;
                                    a(r12);
                                } else if (this.aKa.aKw < this.aKa.aKx) {
                                    this.aKa.aKw++;
                                } else {
                                    this.aKa.a(this.aKb);
                                    this.aKa.aKw = 0;
                                }
                            } else {
                                this.aKa.a(this.aKb);
                                this.aKa.aKw = 0;
                                a(r12);
                            }
                            this.aKa.aKL[0] = r12[0];
                            this.aKa.aKL[1] = r12[1];
                            this.aKa.aKM[0][0] = aVar.aKh * aVar.aKh;
                            this.aKa.aKM[0][1] = 0.0d;
                            this.aKa.aKM[1][0] = 0.0d;
                            this.aKa.aKM[1][1] = aVar.aKh * aVar.aKh;
                        }
                    }
                }
                if (aVar.mType == 3) {
                    this.aKa.aKr[0] = r12[0];
                    this.aKa.aKr[1] = r12[1];
                    this.aKa.aKs = aVar.aKc;
                    this.aKa.aKq = true;
                }
            } else if (aVar.mType != 3) {
                int i4;
                Object obj3;
                double[] dArr5 = new double[2];
                double[] dArr6 = new double[2];
                double[] dArr7 = new double[2];
                a(aVar.aKc, false);
                if (this.aKa.aKt) {
                    dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                    dArr5[0] = aVar.aKf[0] - this.aKa.aKL[0];
                    dArr5[1] = aVar.aKf[1] - this.aKa.aKL[1];
                    a(new double[]{this.aKa.aKM[0][0], this.aKa.aKM[0][1], this.aKa.aKM[1][0], this.aKa.aKM[1][1]}, this.aJZ);
                    dArr[0][0] = this.aJZ[0];
                    dArr[0][1] = this.aJZ[1];
                    dArr[1][0] = this.aJZ[2];
                    dArr[1][1] = this.aJZ[3];
                    if (Math.sqrt((((dArr5[0] * dArr5[0]) * dArr[0][0]) + (((2.0d * dArr5[0]) * dArr5[1]) * dArr[1][0])) + ((dArr5[1] * dArr5[1]) * dArr[1][1])) > this.aKa.aKv) {
                        b bVar2 = this.aKa;
                        i4 = bVar2.aKw + 1;
                        bVar2.aKw = i4;
                        if (i4 >= this.aKa.aKx) {
                            obj3 = 1;
                            obj = null;
                            this.aKa.aKw = 0;
                        } else {
                            obj3 = null;
                            obj = null;
                        }
                    } else {
                        this.aKa.aKw = 0;
                        obj3 = 1;
                        obj = 1;
                    }
                } else {
                    obj3 = 1;
                    obj = null;
                    this.aKa.aKw = 0;
                }
                if (obj3 == null) {
                    return;
                }
                if (obj == null) {
                    this.aKa.aKL[0] = aVar.aKf[0];
                    this.aKa.aKL[1] = aVar.aKf[1];
                    this.aKa.aKL[2] = 0.0d;
                    this.aKa.aKL[3] = 0.0d;
                    this.aKa.aKM[0][0] = aVar.aKh * aVar.aKh;
                    this.aKa.aKM[0][1] = 0.0d;
                    this.aKa.aKM[0][2] = 0.0d;
                    this.aKa.aKM[0][3] = 0.0d;
                    this.aKa.aKM[1][0] = 0.0d;
                    this.aKa.aKM[1][1] = this.aKa.aKM[0][0];
                    this.aKa.aKM[1][2] = 0.0d;
                    this.aKa.aKM[1][2] = 0.0d;
                    this.aKa.aKM[2][0] = 0.0d;
                    this.aKa.aKM[2][1] = 0.0d;
                    this.aKa.aKM[2][2] = this.aKa.aKG;
                    this.aKa.aKM[2][3] = 0.0d;
                    this.aKa.aKM[3][0] = 0.0d;
                    this.aKa.aKM[3][1] = 0.0d;
                    this.aKa.aKM[3][2] = 0.0d;
                    this.aKa.aKM[3][3] = this.aKa.aKG;
                    this.aKa.aKu[0] = aVar.aKf[0];
                    this.aKa.aKu[1] = aVar.aKf[1];
                    this.aKa.aKt = true;
                    return;
                }
                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
                double[] dArr8 = new double[]{this.aKa.aKL[0] - this.aKa.aKu[0], this.aKa.aKL[1] - this.aKa.aKu[1]};
                dArr7[0] = aVar.aKf[0] - this.aKa.aKu[0];
                dArr7[1] = aVar.aKf[1] - this.aKa.aKu[1];
                d3 = Math.sqrt((dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]));
                sqrt = Math.sqrt((dArr6[1] * dArr6[1]) + (dArr6[0] * dArr6[0]));
                if (d3 < sqrt) {
                    d2 = this.aKa.aKR;
                } else {
                    d2 = this.aKa.aKS;
                }
                if (a(this.aKa.aKM, dArr)) {
                    int i5;
                    double d7 = 1.0d / (aVar.aKh * aVar.aKh);
                    double[] dArr9 = new double[4];
                    if (this.aKa.aKY) {
                        d2 += (sqrt / d3) * (1.0d - d2);
                        dArr8[0] = this.aKa.aKu[0] + (dArr7[0] * d2);
                        dArr8[1] = (d2 * dArr7[1]) + this.aKa.aKu[1];
                    } else {
                        dArr8[0] = (this.aKa.aKL[0] * (1.0d - d2)) + (aVar.aKf[0] * d2);
                        dArr8[1] = (d2 * aVar.aKf[1]) + (this.aKa.aKL[1] * (1.0d - d2));
                    }
                    for (i4 = 0; i4 < 4; i4++) {
                        dArr9[i4] = 0.0d;
                        for (i5 = 0; i5 < 4; i5++) {
                            dArr9[i4] = dArr9[i4] + (dArr[i4][i5] * this.aKa.aKL[i5]);
                        }
                    }
                    dArr2 = dArr[0];
                    dArr2[0] = dArr2[0] + d7;
                    dArr2 = dArr[1];
                    dArr2[1] = dArr2[1] + d7;
                    if (a(dArr, this.aKa.aKM)) {
                        dArr9[0] = dArr9[0] + (dArr8[0] * d7);
                        dArr9[1] = dArr9[1] + (dArr8[1] * d7);
                        for (i5 = 0; i5 < 4; i5++) {
                            this.aKa.aKL[i5] = 0.0d;
                            for (i = 0; i < 4; i++) {
                                dArr5 = this.aKa.aKL;
                                dArr5[i5] = dArr5[i5] + (this.aKa.aKM[i5][i] * dArr9[i]);
                            }
                        }
                        this.aKa.aKu[0] = dArr8[0];
                        this.aKa.aKu[1] = dArr8[1];
                    }
                }
            }
        }
    }

    private void a(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.aKa.aKc;
        double d5 = d4 * d4;
        if (z) {
            this.aKa.aKM[2][2] = this.aKa.aKG;
            this.aKa.aKM[2][3] = 0.0d;
            this.aKa.aKM[3][2] = 0.0d;
            this.aKa.aKM[3][3] = this.aKa.aKG;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                d3 = 0.0d;
                while (d3 < d4) {
                    d3 = 1.0d + d3;
                    d2 = this.aKa.aKp * d2;
                }
            }
            double[] dArr = this.aKa.aKM[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.aKa.aKM[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.aKa.aKM[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.aKa.aKM[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.aKa.aKP;
            }
            b bVar = this.aKa;
            bVar.aKO = d3 * bVar.aKO;
        }
        this.aKa.aKL[0] = this.aKa.aKL[0] + (this.aKa.aKL[2] * d4);
        this.aKa.aKL[1] = this.aKa.aKL[1] + (this.aKa.aKL[3] * d4);
        if (this.aKa.aKQ) {
            this.aKa.aKM[0][0] = this.aKa.aKM[0][0] + (this.aKa.aKM[2][2] * d5);
            this.aKa.aKM[0][1] = this.aKa.aKM[0][1] + (this.aKa.aKM[2][3] * d5);
            this.aKa.aKM[1][0] = this.aKa.aKM[1][0] + (this.aKa.aKM[3][2] * d5);
            this.aKa.aKM[1][1] = this.aKa.aKM[1][1] + (this.aKa.aKM[3][3] * d5);
        } else {
            this.aKa.aKM[0][0] = (this.aKa.aKM[0][0] + ((this.aKa.aKM[0][2] + this.aKa.aKM[2][0]) * d4)) + (this.aKa.aKM[2][2] * d5);
            this.aKa.aKM[1][1] = (this.aKa.aKM[1][1] + ((this.aKa.aKM[1][3] + this.aKa.aKM[3][1]) * d4)) + (this.aKa.aKM[3][3] * d5);
            this.aKa.aKM[0][2] = this.aKa.aKM[0][2] + (this.aKa.aKM[2][2] * d4);
            this.aKa.aKM[2][0] = this.aKa.aKM[2][0] + (this.aKa.aKM[2][2] * d4);
            this.aKa.aKM[1][3] = this.aKa.aKM[1][3] + (this.aKa.aKM[3][3] * d4);
            this.aKa.aKM[3][1] = this.aKa.aKM[3][1] + (this.aKa.aKM[3][3] * d4);
        }
        this.aKa.aKc = d;
    }

    private void b(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.aKb.aKc;
        double d5 = d4 * d4;
        if (z) {
            this.aKb.aKM[2][2] = this.aKb.aKG;
            this.aKb.aKM[2][3] = 0.0d;
            this.aKb.aKM[3][2] = 0.0d;
            this.aKb.aKM[3][3] = this.aKb.aKG;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                d3 = 0.0d;
                while (d3 < d4) {
                    d3 = 1.0d + d3;
                    d2 = this.aKb.aKp * d2;
                }
            }
            double[] dArr = this.aKb.aKM[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.aKb.aKM[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.aKb.aKM[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.aKb.aKM[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.aKb.aKP;
            }
            b bVar = this.aKb;
            bVar.aKO = d3 * bVar.aKO;
        }
        this.aKb.aKL[0] = this.aKb.aKL[0] + (this.aKb.aKL[2] * d4);
        this.aKb.aKL[1] = this.aKb.aKL[1] + (this.aKb.aKL[3] * d4);
        if (this.aKb.aKQ) {
            this.aKb.aKM[0][0] = this.aKb.aKM[0][0] + (this.aKb.aKM[2][2] * d5);
            this.aKb.aKM[0][1] = this.aKb.aKM[0][1] + (this.aKb.aKM[2][3] * d5);
            this.aKb.aKM[1][0] = this.aKb.aKM[1][0] + (this.aKb.aKM[3][2] * d5);
            this.aKb.aKM[1][1] = this.aKb.aKM[1][1] + (this.aKb.aKM[3][3] * d5);
        } else {
            this.aKb.aKM[0][0] = (this.aKb.aKM[0][0] + ((this.aKb.aKM[0][2] + this.aKb.aKM[2][0]) * d4)) + (this.aKb.aKM[2][2] * d5);
            this.aKb.aKM[1][1] = (this.aKb.aKM[1][1] + ((this.aKb.aKM[1][3] + this.aKb.aKM[3][1]) * d4)) + (this.aKb.aKM[3][3] * d5);
            this.aKb.aKM[0][2] = this.aKb.aKM[0][2] + (this.aKb.aKM[2][2] * d4);
            this.aKb.aKM[2][0] = this.aKb.aKM[2][0] + (this.aKb.aKM[2][2] * d4);
            this.aKb.aKM[1][3] = this.aKb.aKM[1][3] + (this.aKb.aKM[3][3] * d4);
            this.aKb.aKM[3][1] = this.aKb.aKM[3][1] + (this.aKb.aKM[3][3] * d4);
        }
        this.aKb.aKc = d;
    }

    private void a(double[] dArr) {
        if (this.aKa.aKJ && this.aKa.aKt) {
            double[] dArr2 = new double[2];
            r1 = new double[2];
            double d = this.aKa.aKV;
            dArr2[0] = this.aKa.aKL[0] - this.aKa.aKu[0];
            dArr2[1] = this.aKa.aKL[1] - this.aKa.aKu[1];
            r1[0] = dArr[0] - this.aKa.aKu[0];
            r1[1] = dArr[1] - this.aKa.aKu[1];
            double sqrt = Math.sqrt((dArr2[0] * dArr2[0]) + (dArr2[1] * dArr2[1]));
            double sqrt2 = Math.sqrt((r1[0] * r1[0]) + (r1[1] * r1[1]));
            if (sqrt > this.aKa.aKB && sqrt2 > this.aKa.aKB) {
                Object obj;
                double atan2 = Math.atan2(r1[1], r1[0]) - Math.atan2(dArr2[1], dArr2[0]);
                if (atan2 > 3.141592653589793d) {
                    atan2 -= 6.283185307179586d;
                } else if (atan2 < -3.141592653589793d) {
                    atan2 += 6.283185307179586d;
                }
                b bVar = this.aKa;
                bVar.aKN = (d * atan2) + bVar.aKN;
                if (atan2 * atan2 > 4.0d * this.aKa.aKO) {
                    obj = 1;
                } else {
                    obj = null;
                }
                d = Math.sqrt(this.aKa.aKM[0][0] + this.aKa.aKM[1][1]);
                if (sqrt >= sqrt2) {
                    sqrt = sqrt2;
                }
                sqrt = d / sqrt;
                if (obj != null) {
                    this.aKa.aKO = sqrt * sqrt;
                } else {
                    this.aKa.aKO = 1.0d / ((1.0d / (sqrt * sqrt)) + (1.0d / this.aKa.aKO));
                }
            }
        }
        this.aKa.aKu[0] = dArr[0];
        this.aKa.aKu[1] = dArr[1];
        this.aKa.aKt = true;
    }

    void a(int i, double[] dArr, double[] dArr2) {
        switch (i) {
            case 0:
                dArr2[0] = ((dArr[1] - this.aKa.aKH[1]) * 6378137.0d) * Math.cos(this.aKa.aKH[0]);
                dArr2[1] = (dArr[0] - this.aKa.aKH[0]) * 6378137.0d;
                return;
            case 1:
                dArr2[0] = (dArr[1] / 6378137.0d) + this.aKa.aKH[0];
                dArr2[1] = (dArr[0] / (Math.cos(this.aKa.aKH[0]) * 6378137.0d)) + this.aKa.aKH[1];
                return;
            default:
                return;
        }
    }

    private static void a(double[] dArr, double[] dArr2) {
        double d = 1.0d / ((dArr[0] * dArr[3]) - (dArr[1] * dArr[2]));
        dArr2[0] = dArr[3] * d;
        dArr2[3] = dArr[0] * d;
        dArr2[1] = (-dArr[1]) * d;
        dArr2[2] = d * (-dArr[2]);
    }

    private static boolean a(double[][] dArr, double[][] dArr2) {
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        dArr3[0][0] = ((((((dArr[1][1] * dArr[2][2]) * dArr[3][3]) - ((dArr[1][1] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][1] * dArr[1][2]) * dArr[3][3])) + ((dArr[2][1] * dArr[1][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[1][2]) * dArr[2][3])) - ((dArr[3][1] * dArr[1][3]) * dArr[2][2]);
        dArr3[1][0] = (((((((-dArr[1][0]) * dArr[2][2]) * dArr[3][3]) + ((dArr[1][0] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][0] * dArr[1][2]) * dArr[3][3])) - ((dArr[2][0] * dArr[1][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[1][2]) * dArr[2][3])) + ((dArr[3][0] * dArr[1][3]) * dArr[2][2]);
        dArr3[2][0] = ((((((dArr[1][0] * dArr[2][1]) * dArr[3][3]) - ((dArr[1][0] * dArr[2][3]) * dArr[3][1])) - ((dArr[2][0] * dArr[1][1]) * dArr[3][3])) + ((dArr[2][0] * dArr[1][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[1][1]) * dArr[2][3])) - ((dArr[3][0] * dArr[1][3]) * dArr[2][1]);
        dArr3[3][0] = (((((((-dArr[1][0]) * dArr[2][1]) * dArr[3][2]) + ((dArr[1][0] * dArr[2][2]) * dArr[3][1])) + ((dArr[2][0] * dArr[1][1]) * dArr[3][2])) - ((dArr[2][0] * dArr[1][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[1][1]) * dArr[2][2])) + ((dArr[3][0] * dArr[1][2]) * dArr[2][1]);
        dArr3[0][1] = (((((((-dArr[0][1]) * dArr[2][2]) * dArr[3][3]) + ((dArr[0][1] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][1] * dArr[0][2]) * dArr[3][3])) - ((dArr[2][1] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][1] * dArr[0][2]) * dArr[2][3])) + ((dArr[3][1] * dArr[0][3]) * dArr[2][2]);
        dArr3[1][1] = ((((((dArr[0][0] * dArr[2][2]) * dArr[3][3]) - ((dArr[0][0] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[3][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[2][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[2][2]);
        dArr3[2][1] = (((((((-dArr[0][0]) * dArr[2][1]) * dArr[3][3]) + ((dArr[0][0] * dArr[2][3]) * dArr[3][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[3][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[2][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[2][1]);
        dArr3[3][1] = ((((((dArr[0][0] * dArr[2][1]) * dArr[3][2]) - ((dArr[0][0] * dArr[2][2]) * dArr[3][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[3][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[2][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[2][1]);
        dArr3[0][2] = ((((((dArr[0][1] * dArr[1][2]) * dArr[3][3]) - ((dArr[0][1] * dArr[1][3]) * dArr[3][2])) - ((dArr[1][1] * dArr[0][2]) * dArr[3][3])) + ((dArr[1][1] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[0][2]) * dArr[1][3])) - ((dArr[3][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][2] = (((((((-dArr[0][0]) * dArr[1][2]) * dArr[3][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[3][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[3][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[1][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][2] = ((((((dArr[0][0] * dArr[1][1]) * dArr[3][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[3][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[3][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[1][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][2] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[3][2]) + ((dArr[0][0] * dArr[1][2]) * dArr[3][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[3][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[1][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[1][1]);
        dArr3[0][3] = (((((((-dArr[0][1]) * dArr[1][2]) * dArr[2][3]) + ((dArr[0][1] * dArr[1][3]) * dArr[2][2])) + ((dArr[1][1] * dArr[0][2]) * dArr[2][3])) - ((dArr[1][1] * dArr[0][3]) * dArr[2][2])) - ((dArr[2][1] * dArr[0][2]) * dArr[1][3])) + ((dArr[2][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][3] = ((((((dArr[0][0] * dArr[1][2]) * dArr[2][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[2][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[2][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[2][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[1][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][3] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[2][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[2][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[2][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[2][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[1][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][3] = ((((((dArr[0][0] * dArr[1][1]) * dArr[2][2]) - ((dArr[0][0] * dArr[1][2]) * dArr[2][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[2][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[2][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[1][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[1][1]);
        double d = (((dArr[0][0] * dArr3[0][0]) + (dArr[0][1] * dArr3[1][0])) + (dArr[0][2] * dArr3[2][0])) + (dArr[0][3] * dArr3[3][0]);
        if (d == 0.0d) {
            return false;
        }
        double d2 = 1.0d / d;
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                dArr2[i][i2] = dArr3[i][i2] * d2;
            }
        }
        return true;
    }
}
