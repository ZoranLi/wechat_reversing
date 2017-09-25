package com.c.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u extends d implements SensorEventListener {
    private static final int aNc;
    private static final int aNd;
    private static u aNw;
    private SensorManager aJs = null;
    int[] aNA = new int[6];
    float[] aNB = new float[6];
    float[] aNC = new float[6];
    float[] aND = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    float[][] aNE = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20}));
    final d aNF = new d();
    final f aNG = new f(this);
    final a aNH = new a();
    Sensor aNe;
    Sensor aNf;
    Sensor aNg;
    Sensor aNh;
    Sensor aNi = null;
    private long aNj = 0;
    private boolean aNk = true;
    private float[][] aNl = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    float[][] aNm = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] aNn = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    float[][] aNo = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    float[][] aNp = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    float[][] aNq = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    float[][] aNr = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[] aNs = new float[4];
    private float[][] aNt = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] aNu = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] aNv = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    boolean aNx;
    private c aNy;
    boolean[] aNz = new boolean[6];

    private static class a {
        int aNI = 0;
        float aNJ = 0.0f;
        long aNK = 0;
        float aNL = 0.0f;
        boolean aNM = false;
        long aNN = 0;
        float[] aNO = new float[6];
        float[] aNP = new float[6];
        float[] aNQ = new float[6];
        float[] aNR = new float[6];
        float[] aNS = new float[6];
        float[] aNT = new float[6];
        public float[] aNU = new float[6];
        public float[] aNV = new float[6];
        public float[] aNW = new float[6];
        float aNX = 0.0f;
        float aNY = Float.NEGATIVE_INFINITY;
        float aNZ = Float.POSITIVE_INFINITY;
        public boolean aOa = false;

        public final void reset() {
            this.aNI = 0;
            this.aNJ = 0.0f;
            this.aNK = 0;
            this.aNL = 0.0f;
            this.aNM = false;
            this.aNN = 0;
            this.aNO = new float[6];
            this.aNP = new float[6];
            this.aNQ = new float[6];
            this.aNX = 0.0f;
            this.aNY = Float.NEGATIVE_INFINITY;
            this.aNZ = Float.POSITIVE_INFINITY;
        }
    }

    private static class b {
        public float aOb;
        public float aOc;
        public float aOd;
        public float aOe;
        public float aOf;
        public float aOg;
        public float aOh;
        public float aOi;
        public float aOj;
        public float aOk;
        public float aOl;
        public float[] aOm = new float[6];
        public float[] aOn = new float[6];
        public float[] aOo = new float[6];
        public float[] aOp = new float[6];
        public float[] aOq = new float[6];
        public long time;
    }

    private static class d {
        private float aOA = 0.0f;
        private float aOs = 0.0f;
        private float aOt = 0.0f;
        private float aOu = 0.0f;
        private float aOv = 0.0f;
        private float aOw = 0.0f;
        private float aOx = 0.0f;
        private float aOy = 0.0f;
        private float aOz = 0.0f;
        private int count = 0;

        public final synchronized void reset() {
            this.count = 0;
            this.aOs = 0.0f;
            this.aOt = 0.0f;
            this.aOu = 0.0f;
            this.aOv = 0.0f;
            this.aOw = 0.0f;
            this.aOx = 0.0f;
            this.aOy = 0.0f;
            this.aOz = 0.0f;
            this.aOA = 0.0f;
        }

        public final synchronized void a(float[] fArr, float[] fArr2, float[] fArr3) {
            if (fArr.length >= 3) {
                this.count++;
                this.aOs += fArr[0];
                this.aOt += fArr[1];
                this.aOu += fArr[2];
                this.aOv += fArr2[0];
                this.aOw += fArr2[1];
                this.aOx += fArr2[2];
                this.aOy += fArr3[0];
                this.aOz += fArr3[1];
                this.aOA += fArr3[2];
            }
        }

        public final synchronized b a(float[][] fArr) {
            b bVar;
            synchronized (this) {
                if (this.count <= 0 || fArr.length < 3) {
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.time = SystemClock.elapsedRealtime();
                    for (int i = 0; i <= 5; i++) {
                        bVar.aOm[i] = fArr[i][0];
                        bVar.aOn[i] = fArr[i][1];
                        bVar.aOo[i] = fArr[i][2];
                        bVar.aOp[i] = (float) Math.sin((double) bVar.aOm[i]);
                        bVar.aOq[i] = (float) Math.cos((double) bVar.aOm[i]);
                    }
                    bVar.aOb = this.aOs / ((float) this.count);
                    bVar.aOc = this.aOt / ((float) this.count);
                    bVar.aOd = this.aOu / ((float) this.count);
                    bVar.aOe = this.aOv / ((float) this.count);
                    bVar.aOf = this.aOw / ((float) this.count);
                    bVar.aOg = this.aOx / ((float) this.count);
                    bVar.aOh = this.aOy / ((float) this.count);
                    bVar.aOi = this.aOz / ((float) this.count);
                    bVar.aOj = this.aOA / ((float) this.count);
                    bVar.aOl = (float) Math.sqrt((double) ((bVar.aOb * bVar.aOb) + (bVar.aOc * bVar.aOc)));
                    reset();
                }
            }
            return bVar;
        }
    }

    private class f {
        private ArrayList<b> aOE = new ArrayList();
        private a[] aOF = new a[5];
        private int aOG = 0;
        private float[][] aOH = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
        private float[][] aOI = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
        private float[][] aOJ = ((float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3}));
        private int[] aOK = new int[6];
        private int aOL = 5;
        public int aOM = -1;
        private int aON = 0;
        final /* synthetic */ u aOr;

        private class a {
            public int aOO = 0;
            public float aOP = 0.0f;
            public float aOQ = 0.0f;
            public float aOR = 0.0f;
            public long aOS = 0;
            final /* synthetic */ f aOT;
            public float x = 0.0f;
            public float y = 0.0f;
            public float z = 0.0f;

            protected final /* synthetic */ Object clone() {
                return nH();
            }

            public a(f fVar) {
                this.aOT = fVar;
            }

            protected final a nH() {
                a aVar = new a(this.aOT);
                aVar.x = this.x;
                aVar.y = this.y;
                aVar.z = this.z;
                aVar.aOO = this.aOO;
                aVar.aOP = this.aOP;
                aVar.aOQ = this.aOQ;
                aVar.aOS = this.aOS;
                aVar.aOR = this.aOR;
                return aVar;
            }
        }

        public f(u uVar) {
            this.aOr = uVar;
        }

        public final synchronized void reset() {
            this.aOE.clear();
            this.aOF = new a[5];
            this.aOG = 0;
            this.aOH = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.aOI = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.aOJ = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.aOK = new int[6];
            this.aOL = 5;
        }

        private synchronized boolean nE() {
            boolean z;
            if (this.aOG >= 20) {
                float[] fArr = this.aOH[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aOH[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aOH[2];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aOI[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aOI[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aOI[2];
                fArr[2] = fArr[2] / 20.0f;
                float f = this.aOI[0][2];
                float f2 = this.aOH[0][0] - this.aOH[0][2];
                float f3 = this.aOH[0][2] - this.aOH[0][1];
                float f4 = this.aOI[1][2];
                float f5 = this.aOH[1][0] - this.aOH[1][2];
                float f6 = this.aOH[1][2] - this.aOH[1][1];
                float f7 = this.aOI[2][2];
                float f8 = this.aOH[2][0] - this.aOH[2][2];
                float f9 = this.aOH[2][2] - this.aOH[2][1];
                this.aOJ[0][0] = (f * 0.32999998f) + (0.67f * this.aOJ[0][0]);
                this.aOJ[0][1] = (f2 * 0.32999998f) + (0.67f * this.aOJ[0][1]);
                this.aOJ[0][2] = (f3 * 0.32999998f) + (0.67f * this.aOJ[0][2]);
                this.aOJ[1][0] = (0.67f * this.aOJ[1][0]) + (f4 * 0.32999998f);
                this.aOJ[1][1] = (0.67f * this.aOJ[1][1]) + (0.32999998f * f5);
                this.aOJ[1][2] = (0.67f * this.aOJ[1][2]) + (0.32999998f * f6);
                this.aOJ[2][0] = (0.67f * this.aOJ[2][0]) + (0.32999998f * f7);
                this.aOJ[2][1] = (0.67f * this.aOJ[2][1]) + (0.32999998f * f8);
                this.aOJ[2][2] = (0.67f * this.aOJ[2][2]) + (0.32999998f * f9);
                a(nF());
                this.aOG = 0;
                this.aOH = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                this.aOI = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                if (this.aOE.size() >= 100) {
                    this.aOE.subList(0, 20).clear();
                    this.aOE.trimToSize();
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        }

        private synchronized a nF() {
            a aVar;
            Object obj;
            float abs;
            float abs2;
            float abs3;
            float f;
            int i;
            int i2;
            Object obj2 = this.aON == 0 ? 1 : null;
            if (obj2 != null) {
                this.aOL = ((double) Math.abs(this.aOJ[2][0])) < 9.3d ? 5 : 2;
                this.aOK = new int[6];
                obj = null;
            } else {
                Object obj3 = (Math.abs(this.aOJ[0][0]) < 7.0f || (this.aOJ[1][1] < 2.3f && this.aOJ[1][2] < 2.3f)) ? null : 1;
                if (obj3 != null) {
                    this.aOL = 2;
                    this.aOK = new int[6];
                    obj = obj3;
                } else {
                    int i3;
                    abs = Math.abs(this.aOJ[0][0]);
                    abs2 = Math.abs(this.aOJ[1][0]);
                    abs3 = Math.abs(this.aOJ[2][0]);
                    if (abs > abs2) {
                        if (abs > abs3) {
                            i3 = 0;
                        } else {
                            i3 = 2;
                        }
                    } else if (abs2 > abs3) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    f = 0.0f;
                    int i4 = 0;
                    i = 0;
                    for (i2 = 0; i2 < 3; i2++) {
                        if (i2 != i3) {
                            for (int i5 = 1; i5 < 3; i5++) {
                                if (this.aOJ[i2][i5] > f) {
                                    i4 = i2;
                                    f = this.aOJ[i2][i5];
                                    i = i5;
                                }
                            }
                        }
                    }
                    i3 = ((i4 * 2) + i) - 1;
                    int[] iArr = this.aOK;
                    iArr[i3] = iArr[i3] + 1;
                    i3 = 0;
                    while (i3 <= 5) {
                        if (i3 != this.aOL && this.aOK[i3] > this.aOK[this.aOL]) {
                            this.aOL = i3;
                        }
                        i3++;
                    }
                    obj = obj3;
                }
            }
            if (this.aOM >= 0 && this.aOM <= 5) {
                this.aOL = this.aOM;
            }
            aVar = new a(this);
            aVar = new a(this);
            if (this.aOF[0] != null) {
                aVar.aOS = this.aOF[0].aOS;
                aVar.aOP = this.aOF[0].aOP;
            }
            if (this.aOF[4] != null) {
                aVar.aOS = this.aOF[4].aOS;
                aVar.aOP = this.aOF[4].aOP;
            }
            if (!this.aOE.isEmpty()) {
                b bVar;
                i2 = this.aOE.size();
                float[] fArr = new float[6];
                float[] fArr2 = new float[6];
                Iterator it = this.aOE.iterator();
                abs3 = 0.0f;
                float f2 = 0.0f;
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    f2 += obj == null ? bVar.aOd : bVar.aOg;
                    if (obj == null) {
                        abs2 = bVar.aOl;
                    } else {
                        abs2 = (float) Math.sqrt((double) (((bVar.aOe * bVar.aOe) + (bVar.aOf * bVar.aOf)) + (bVar.aOg * bVar.aOg)));
                        bVar.aOk = abs2;
                    }
                    abs3 += abs2;
                    for (i = 0; i <= 5; i++) {
                        fArr[i] = fArr[i] + bVar.aOp[i];
                        fArr2[i] = fArr2[i] + bVar.aOq[i];
                    }
                }
                float f3 = f2 / ((float) i2);
                float f4 = abs3 / ((float) i2);
                float f5 = obj == null ? f3 : f4;
                float[] fArr3 = new float[]{(float) Math.atan2((double) fArr[0], (double) fArr2[0]), (float) Math.atan2((double) fArr[1], (double) fArr2[1]), (float) Math.atan2((double) fArr[2], (double) fArr2[2]), (float) Math.atan2((double) fArr[3], (double) fArr2[3]), (float) Math.atan2((double) fArr[4], (double) fArr2[4]), (float) Math.atan2((double) fArr[5], (double) fArr2[5])};
                f = obj == null ? f3 : f4;
                abs2 = 0.0f;
                float f6 = obj == null ? 1.2f : 1.0f;
                float f7 = obj2 != null ? 0.08726647f : 0.2617994f;
                Iterator it2 = this.aOE.iterator();
                float f8 = 0.0f;
                float f9 = 0.0f;
                int i6 = 0;
                f2 = f4;
                while (it2.hasNext()) {
                    float f10;
                    bVar = (b) it2.next();
                    float f11 = obj == null ? bVar.aOd : bVar.aOk;
                    abs3 = obj == null ? bVar.aOl : bVar.aOk;
                    if (obj == null) {
                        f10 = f3;
                    } else {
                        f10 = f4;
                    }
                    if (i6 > 0) {
                        float f12;
                        float f13;
                        if (f < f11) {
                            if (obj2 == null) {
                                f = f11 - f10;
                                if (f > 2.0f * f6) {
                                    f12 = f / 2.0f;
                                    f13 = f11;
                                }
                            }
                            f12 = f6;
                            f13 = f11;
                        } else {
                            f12 = f6;
                            f13 = f;
                        }
                        if (f2 < abs3) {
                            f = abs3;
                        } else {
                            f = f2;
                        }
                        if (f11 > f10) {
                            f6 = f12;
                            f2 = f;
                            i6++;
                            f = f13;
                        } else {
                            if (i6 <= 10) {
                                Object obj4 = 1;
                                if (aVar.aOS != 0 && bVar.time - aVar.aOS < 250) {
                                    obj4 = null;
                                }
                                if (obj4 != null && f - f4 < 0.3f) {
                                    obj4 = null;
                                }
                                if (obj4 != null) {
                                    aVar.aOO++;
                                    abs2 += f13;
                                    f2 = (float) Math.atan2((double) (bVar.aOp[this.aOL] + f9), (double) (bVar.aOq[this.aOL] + f8));
                                    abs3 = Math.abs(f2 - fArr3[this.aOL]);
                                    if (abs3 > 3.1415927f) {
                                        abs3 = 6.2831855f - abs3;
                                    }
                                    Object obj5 = abs3 >= f7 ? 1 : null;
                                    abs3 = 1.0f;
                                    if (obj5 != null) {
                                        abs3 = 0.93f;
                                    } else {
                                        f2 = fArr3[this.aOL];
                                    }
                                    f6 = (float) (Math.sin((double) f2) * ((double) abs3));
                                    abs3 = (float) (((double) abs3) * Math.cos((double) f2));
                                    aVar.x += f6;
                                    aVar.y += abs3;
                                    if (bVar.time - aVar.aOS > 250) {
                                        aVar.x -= f6;
                                        aVar.y -= abs3;
                                        aVar.aOO++;
                                    }
                                }
                                aVar.aOS = bVar.time;
                            }
                            abs3 = bVar.aOp[this.aOL];
                            f6 = f12;
                            f8 = bVar.aOq[this.aOL];
                            f9 = abs3;
                            i6 = 0;
                            f2 = f;
                            f = f13;
                        }
                    } else if (f11 <= f10) {
                        abs3 = bVar.aOp[this.aOL];
                        f8 = bVar.aOq[this.aOL];
                        f9 = abs3;
                    } else if (f11 - f10 >= f6) {
                        f2 = abs3;
                        f = f11;
                        i6 = 1;
                    }
                }
                if (aVar.aOO > 0) {
                    abs = obj == null ? 0.0f : 0.08f;
                    abs2 /= (float) aVar.aOO;
                    abs3 = aVar.aOP;
                    abs += ((abs2 - f5) / 15.0f) + 0.537f;
                    if (abs3 != 0.0f) {
                        abs = (abs * 0.67f) + (0.33f * abs3);
                    }
                    aVar.aOP = abs;
                    aVar.x *= aVar.aOP;
                    aVar.y *= aVar.aOP;
                    aVar.aOQ = ((float) aVar.aOO) * aVar.aOP;
                }
            }
            aVar.aOR = aVar.aOQ / ((float) (this.aOE.size() / 20));
            if (this.aOF[0] != null) {
                aVar.x += this.aOF[0].x;
                aVar.y += this.aOF[0].y;
                aVar.z += this.aOF[0].z;
                aVar.aOO += this.aOF[0].aOO;
                aVar.aOQ += this.aOF[0].aOQ;
            }
            if (this.aOF[4] != null && aVar.aOO > 0) {
                this.aOF[4].x = ((this.aOF[4].x + aVar.x) + (aVar.x * aVar.aOP)) / 2.0f;
                this.aOF[4].y = ((this.aOF[4].y + aVar.y) + (aVar.y * aVar.aOP)) / 2.0f;
            }
            return aVar;
        }

        private synchronized void a(a aVar) {
            System.arraycopy(this.aOF, 1, this.aOF, 0, 4);
            if (this.aOF[4] == null || SystemClock.elapsedRealtime() - aVar.aOS <= 1000) {
                this.aOF[4] = aVar;
            } else {
                a aVar2 = this.aOF[4];
                aVar2.x = (aVar2.x + aVar.x) / 2.0f;
                aVar2.y = (aVar2.y + aVar.y) / 2.0f;
                aVar2.z = (aVar2.z + aVar.z) / 2.0f;
                aVar2.aOO = Math.round(((float) (aVar2.aOO + aVar.aOO)) / 2.0f);
                aVar2.aOP = (aVar2.aOP + aVar.aOP) / 2.0f;
                aVar2.aOQ = (aVar2.aOQ + aVar.aOQ) / 2.0f;
                aVar2.aOS = aVar.aOS;
                aVar2.aOR = aVar.aOR;
            }
        }

        public final synchronized void a(b bVar) {
            if (this.aON > 0 && this.aON < 101) {
                this.aON--;
            }
            this.aOE.add(bVar);
            this.aOG++;
            if (bVar.aOe > this.aOH[0][0]) {
                this.aOH[0][0] = bVar.aOe;
            }
            if (bVar.aOe < this.aOH[0][1]) {
                this.aOH[0][1] = bVar.aOe;
            }
            float[] fArr = this.aOH[0];
            fArr[2] = fArr[2] + bVar.aOe;
            if (bVar.aOf > this.aOH[1][0]) {
                this.aOH[1][0] = bVar.aOf;
            }
            if (bVar.aOf < this.aOH[1][1]) {
                this.aOH[1][1] = bVar.aOf;
            }
            fArr = this.aOH[1];
            fArr[2] = fArr[2] + bVar.aOf;
            if (bVar.aOg > this.aOH[2][0]) {
                this.aOH[2][0] = bVar.aOg;
            }
            if (bVar.aOg < this.aOH[2][1]) {
                this.aOH[2][1] = bVar.aOg;
            }
            fArr = this.aOH[2];
            fArr[2] = fArr[2] + bVar.aOg;
            if (bVar.aOh > this.aOI[0][0]) {
                this.aOI[0][0] = bVar.aOh;
            }
            if (bVar.aOh < this.aOI[0][1]) {
                this.aOI[0][1] = bVar.aOh;
            }
            fArr = this.aOI[0];
            fArr[2] = fArr[2] + bVar.aOh;
            if (bVar.aOi > this.aOI[1][0]) {
                this.aOI[1][0] = bVar.aOi;
            }
            if (bVar.aOi < this.aOI[1][1]) {
                this.aOI[1][1] = bVar.aOi;
            }
            fArr = this.aOI[1];
            fArr[2] = fArr[2] + bVar.aOi;
            if (bVar.aOj > this.aOI[2][0]) {
                this.aOI[2][0] = bVar.aOj;
            }
            if (bVar.aOj < this.aOI[2][1]) {
                this.aOI[2][1] = bVar.aOj;
            }
            fArr = this.aOI[2];
            fArr[2] = fArr[2] + bVar.aOj;
            if (nE()) {
                u uVar = this.aOr;
                a nG = uVar.aNG.nG();
                if (nG != null) {
                    uVar.c(new e(nG.x, nG.y, nG.aOO, nG.aOP, nG.aOQ, nG.aOR));
                }
            }
        }

        private synchronized a nG() {
            return this.aOF[4] != null ? this.aOF[4].nH() : null;
        }
    }

    private class c extends e {
        final /* synthetic */ u aOr;

        c(u uVar, Handler handler) {
            this.aOr = uVar;
            super(handler);
        }

        final void ni() {
            u uVar = this.aOr;
            if (!(uVar.aNe == null || uVar.aNf == null || uVar.aNg == null || uVar.aNh == null)) {
                for (int i = 0; i <= 5; i++) {
                    float f;
                    float[] fArr;
                    float[] fArr2;
                    float f2;
                    float f3;
                    float abs;
                    Object obj = null;
                    if (Float.isNaN(uVar.aND[i])) {
                        uVar.aND[i] = uVar.aNp[i][0];
                    } else {
                        f = uVar.aNp[i][0] - uVar.aNq[i][0];
                        if (f < -3.1415927f) {
                            f += 6.2831855f;
                        } else if (f > 3.1415927f) {
                            f -= 6.2831855f;
                        }
                        fArr = uVar.aNE[i];
                        int[] iArr = uVar.aNA;
                        int i2 = iArr[i];
                        iArr[i] = i2 + 1;
                        fArr[i2] = f;
                        if (uVar.aNA[i] == 20) {
                            uVar.aNA[i] = 0;
                            if (!uVar.aNz[i]) {
                                uVar.aNz[i] = true;
                            }
                        }
                        fArr = uVar.aNC;
                        fArr[i] = fArr[i] + f;
                        fArr = uVar.aNB;
                        fArr[i] = f + fArr[i];
                        if (uVar.aNz[i]) {
                            Object obj2;
                            if (Math.abs(uVar.aNB[i]) < 0.08726647f) {
                                if (Math.abs(uVar.aNC[i]) < 0.08726647f) {
                                    f = uVar.aNp[i][0] - uVar.aND[i];
                                    if (f < -3.1415927f) {
                                        f += 6.2831855f;
                                    } else if (f > 3.1415927f) {
                                        f -= 6.2831855f;
                                    }
                                    uVar.aNp[i][0] = (f / 2.0f) + uVar.aND[i];
                                    if (uVar.aNp[i][0] < -3.1415927f) {
                                        uVar.aNp[i][0] = 6.2831855f + uVar.aNp[i][0];
                                    } else if (uVar.aNp[i][0] > 3.1415927f) {
                                        uVar.aNp[i][0] = uVar.aNp[i][0] - 6.2831855f;
                                    }
                                    uVar.aND[i] = uVar.aNp[i][0];
                                    obj2 = 1;
                                    fArr2 = uVar.aNB;
                                    fArr2[i] = fArr2[i] - uVar.aNE[i][uVar.aNA[i]];
                                    obj = obj2;
                                } else {
                                    f = uVar.aNC[i] % 1.5707964f;
                                    float abs2 = Math.abs(f);
                                    if (abs2 < 0.08726647f) {
                                        fArr = uVar.aNC;
                                        fArr[i] = fArr[i] - f;
                                        uVar.aND[i] = (uVar.aND[i] + uVar.aNC[i]) % 6.2831855f;
                                        if (uVar.aND[i] < -3.1415927f) {
                                            uVar.aND[i] = 6.2831855f + uVar.aND[i];
                                        } else if (uVar.aND[i] > 3.1415927f) {
                                            uVar.aND[i] = uVar.aND[i] - 6.2831855f;
                                        }
                                    } else if (abs2 > 1.4835299f) {
                                        if (uVar.aNC[i] > 0.0f) {
                                            uVar.aNC[i] = (uVar.aNC[i] - f) + 1.5707964f;
                                        } else {
                                            uVar.aNC[i] = (uVar.aNC[i] - f) - 1.5707964f;
                                        }
                                        uVar.aND[i] = (uVar.aND[i] + uVar.aNC[i]) % 6.2831855f;
                                        if (uVar.aND[i] < -3.1415927f) {
                                            uVar.aND[i] = 6.2831855f + uVar.aND[i];
                                        } else if (uVar.aND[i] > 3.1415927f) {
                                            uVar.aND[i] = uVar.aND[i] - 6.2831855f;
                                        }
                                    } else {
                                        uVar.aND[i] = uVar.aNp[i][0];
                                    }
                                    uVar.aNC[i] = 0.0f;
                                }
                            }
                            obj2 = null;
                            fArr2 = uVar.aNB;
                            fArr2[i] = fArr2[i] - uVar.aNE[i][uVar.aNA[i]];
                            obj = obj2;
                        }
                    }
                    a aVar = uVar.aNH;
                    float[] fArr3 = uVar.aNp[i];
                    float[] fArr4 = uVar.aNo[i];
                    float[] fArr5 = uVar.aNq[i];
                    if (i == 0 && aVar.aNI != 0) {
                        aVar.aNK++;
                        aVar.aNX = aVar.aNJ / ((float) aVar.aNI);
                        f2 = aVar.aNX - aVar.aNL;
                        f = Math.abs(f2);
                        f3 = aVar.aNL;
                        f = (aVar.aNL == 0.0f || aVar.aNK <= 20 || f <= 1.25f) ? 1.0f : 1.25f / f;
                        aVar.aNL = (f * (f2 / ((float) aVar.aNK))) + f3;
                        aVar.aNM = Math.abs(aVar.aNX - aVar.aNL) >= 1.25f;
                        if (aVar.aNM) {
                            if (aVar.aNN < 1200) {
                                aVar.aNN++;
                            }
                        } else if (aVar.aNN > 0) {
                            aVar.aNN--;
                        }
                        aVar.aNI = 0;
                        aVar.aNJ = 0.0f;
                        if (aVar.aNX < aVar.aNZ) {
                            aVar.aNZ = aVar.aNX;
                        }
                        if (aVar.aNX > aVar.aNY) {
                            aVar.aNY = aVar.aNX;
                        }
                        if (aVar.aNK == 20 && Math.max(aVar.aNY - aVar.aNL, aVar.aNL - aVar.aNZ) > 5.0f) {
                            aVar.reset();
                        }
                    }
                    float[] fArr6;
                    if (aVar.aNK <= 20) {
                        fArr6 = aVar.aNU;
                        fArr2 = aVar.aNV;
                        aVar.aNW[i] = 1.0f;
                        fArr2[i] = 1.0f;
                        fArr6[i] = 1.0f;
                        fArr6 = aVar.aNR;
                        fArr2 = aVar.aNS;
                        aVar.aNT[i] = 0.0f;
                        fArr2[i] = 0.0f;
                        fArr6[i] = 0.0f;
                    } else if (aVar.aNM || aVar.aOa || r1 != null) {
                        fArr6 = aVar.aNR;
                        fArr2 = aVar.aNS;
                        aVar.aNT[i] = 1.0f;
                        fArr2[i] = 1.0f;
                        fArr6[i] = 1.0f;
                        fArr6 = aVar.aNU;
                        fArr2 = aVar.aNV;
                        aVar.aNW[i] = 0.0f;
                        fArr2[i] = 0.0f;
                        fArr6[i] = 0.0f;
                    } else {
                        if (aVar.aNN > 0) {
                            aVar.aNO[i] = fArr5[0];
                            aVar.aNP[i] = fArr5[1];
                            aVar.aNQ[i] = fArr5[2];
                        }
                        f = Math.abs(fArr5[0] - fArr3[0]);
                        if (f > 3.1415927f) {
                            f = 6.2831855f - f;
                        }
                        abs = Math.abs(aVar.aNO[i] - fArr4[0]);
                        if (abs > 3.1415927f) {
                            abs = 6.2831855f - abs;
                        }
                        f2 = Math.max(abs, f);
                        aVar.aNR[i] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.aNR[i]) / 2.0f;
                        aVar.aNU[i] = 1.0f - aVar.aNR[i];
                        f = Math.abs(fArr5[1] - fArr3[1]);
                        if (f > 3.1415927f) {
                            f = 6.2831855f - f;
                        }
                        abs = Math.abs(aVar.aNP[i] - fArr4[1]);
                        if (abs > 3.1415927f) {
                            abs = 6.2831855f - abs;
                        }
                        f2 = Math.max(abs, f);
                        aVar.aNS[i] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.aNS[i]) / 2.0f;
                        aVar.aNV[i] = 1.0f - aVar.aNS[i];
                        f = Math.abs(fArr5[2] - fArr3[2]);
                        if (f > 3.1415927f) {
                            f = 6.2831855f - f;
                        }
                        abs = Math.abs(aVar.aNQ[i] - fArr4[2]);
                        if (abs > 3.1415927f) {
                            abs = 6.2831855f - abs;
                        }
                        float max = Math.max(abs, f);
                        aVar.aNT[i] = ((max != 0.0f ? (((abs - f) / max) + 1.0f) * 0.5f : 1.0f) + aVar.aNT[i]) / 2.0f;
                        aVar.aNW[i] = 1.0f - aVar.aNT[i];
                    }
                    aVar.aNO[i] = fArr4[0];
                    aVar.aNP[i] = fArr4[1];
                    aVar.aNQ[i] = fArr4[2];
                    f = uVar.aNo[i][0] - uVar.aNp[i][0];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    f = (f * uVar.aNH.aNU[i]) + uVar.aNp[i][0];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    uVar.aNq[i][0] = f;
                    f = uVar.aNo[i][1] - uVar.aNp[i][1];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    f = (f * uVar.aNH.aNV[i]) + uVar.aNp[i][1];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    uVar.aNq[i][1] = f;
                    f = uVar.aNo[i][2] - uVar.aNp[i][2];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    f = (f * uVar.aNH.aNW[i]) + uVar.aNp[i][2];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    uVar.aNq[i][2] = f;
                    float[][] fArr7 = uVar.aNm;
                    fArr2 = uVar.aNq[i];
                    fArr = new float[9];
                    fArr3 = new float[9];
                    fArr4 = new float[9];
                    float sin = (float) Math.sin((double) fArr2[1]);
                    f2 = (float) Math.cos((double) fArr2[1]);
                    f3 = (float) Math.sin((double) fArr2[2]);
                    float cos = (float) Math.cos((double) fArr2[2]);
                    float sin2 = (float) Math.sin((double) fArr2[0]);
                    abs = (float) Math.cos((double) fArr2[0]);
                    fArr[0] = 1.0f;
                    fArr[1] = 0.0f;
                    fArr[2] = 0.0f;
                    fArr[3] = 0.0f;
                    fArr[4] = f2;
                    fArr[5] = sin;
                    fArr[6] = 0.0f;
                    fArr[7] = -sin;
                    fArr[8] = f2;
                    fArr3[0] = cos;
                    fArr3[1] = 0.0f;
                    fArr3[2] = f3;
                    fArr3[3] = 0.0f;
                    fArr3[4] = 1.0f;
                    fArr3[5] = 0.0f;
                    fArr3[6] = -f3;
                    fArr3[7] = 0.0f;
                    fArr3[8] = cos;
                    fArr4[0] = abs;
                    fArr4[1] = sin2;
                    fArr4[2] = 0.0f;
                    fArr4[3] = -sin2;
                    fArr4[4] = abs;
                    fArr4[5] = 0.0f;
                    fArr4[6] = 0.0f;
                    fArr4[7] = 0.0f;
                    fArr4[8] = 1.0f;
                    fArr7[i] = u.a(fArr4, u.a(fArr, fArr3));
                    System.arraycopy(uVar.aNq[i], 0, uVar.aNp[i], 0, 3);
                }
            }
            b a = uVar.aNF.a(uVar.aNi != null ? uVar.aNr : uVar.aNq);
            if (a != null) {
                uVar.aNG.a(a);
            }
        }
    }

    static class e extends p {
        final float aLi;
        final float aOB;
        final float aOC;
        final int aOD;
        final float x;
        final float y;

        public e(float f, float f2, int i, float f3, float f4, float f5) {
            super(com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX);
            this.x = f;
            this.y = f2;
            this.aOD = i;
            this.aOB = f3;
            this.aOC = f4;
            this.aLi = f5;
        }
    }

    static {
        int round = Math.round(50000.0f);
        aNc = round;
        aNd = round;
    }

    static u nD() {
        if (aNw == null) {
            aNw = new u();
        }
        return aNw;
    }

    private u() {
    }

    private static void a(float[][] fArr, float[][] fArr2) {
        for (int i = 0; i <= 5; i++) {
            SensorManager.getOrientation(fArr[i], fArr2[i]);
        }
    }

    static float[] a(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[6]), ((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4])) + (fArr[2] * fArr2[7]), ((fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5])) + (fArr[2] * fArr2[8]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3])) + (fArr[5] * fArr2[6]), ((fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4])) + (fArr[5] * fArr2[7]), ((fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5])) + (fArr[5] * fArr2[8]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3])) + (fArr[8] * fArr2[6]), ((fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4])) + (fArr[8] * fArr2[7]), ((fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5])) + (fArr[8] * fArr2[8])};
    }

    final void O(Context context) {
    }

    final void a(Context context, Handler handler, a aVar) {
        if (context == null) {
            try {
                throw new Exception("SensorModule: register with null context");
            } catch (Exception e) {
                this.aNx = false;
                return;
            }
        }
        boolean a;
        for (int i = 0; i <= 5; i++) {
            this.aNm[i][0] = 1.0f;
            this.aNm[i][1] = 0.0f;
            this.aNm[i][2] = 0.0f;
            this.aNm[i][3] = 0.0f;
            this.aNm[i][4] = 1.0f;
            this.aNm[i][5] = 0.0f;
            this.aNm[i][6] = 0.0f;
            this.aNm[i][7] = 0.0f;
            this.aNm[i][8] = 1.0f;
        }
        this.aJs = (SensorManager) context.getSystemService("sensor");
        this.aNe = this.aJs.getDefaultSensor(10);
        this.aNh = this.aJs.getDefaultSensor(9);
        if (!(this.aNe == null || this.aNh == null)) {
            this.aNi = this.aJs.getDefaultSensor(11);
            if (this.aNi != null) {
                a = a(this.aJs, this, aNc, aNd, handler, this.aNe, this.aNh, this.aNi);
            } else {
                this.aNf = this.aJs.getDefaultSensor(4);
                this.aNg = this.aJs.getDefaultSensor(2);
                if (!(this.aNf == null || this.aNg == null)) {
                    a = a(this.aJs, this, aNc, aNd, handler, this.aNe, this.aNh, this.aNf, this.aNg);
                }
            }
            if (a) {
                this.aNx = true;
                this.aNy = new c(this, handler);
                if (this.aNy != null) {
                    this.aNy.b((long) Math.round(50.0f), 1000);
                }
            }
        }
        a = false;
        if (a) {
            this.aNx = true;
            this.aNy = new c(this, handler);
            if (this.aNy != null) {
                this.aNy.b((long) Math.round(50.0f), 1000);
            }
        }
    }

    final void P(Context context) {
        if (this.aNy != null) {
            this.aNy.stop();
        }
        if (this.aJs != null) {
            try {
                this.aJs.unregisterListener(this);
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
        this.aJs = null;
        this.aNi = null;
        this.aNh = null;
        this.aNg = null;
        this.aNf = null;
        this.aNe = null;
        this.aNj = 0;
        this.aNk = true;
        this.aNl = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.aNm = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.aNo = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.aNp = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.aNq = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.aNz = new boolean[6];
        this.aNA = new int[6];
        this.aNB = new float[6];
        this.aNC = new float[6];
        this.aND = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        this.aNE = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20});
        this.aNH.reset();
        this.aNF.reset();
        this.aNG.reset();
    }

    final void ne() {
    }

    final synchronized void a(Handler handler, a aVar) {
        super.a(handler, aVar);
    }

    @TargetApi(19)
    private static boolean a(SensorManager sensorManager, SensorEventListener sensorEventListener, int i, int i2, Handler handler, Sensor... sensorArr) {
        try {
            Object obj = VERSION.SDK_INT >= 19 ? 1 : null;
            int length = sensorArr.length;
            int i3 = 0;
            while (i3 < length) {
                Sensor sensor = sensorArr[i3];
                if (obj != null ? sensorManager.registerListener(sensorEventListener, sensor, i, i2, handler) : sensorManager.registerListener(sensorEventListener, sensor, i, handler)) {
                    i3++;
                } else {
                    sensorManager.unregisterListener(sensorEventListener);
                    return false;
                }
            }
            return true;
        } catch (Error e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private static void a(float[] fArr, float[][] fArr2) {
        fArr2[0][0] = -fArr[1];
        fArr2[0][1] = fArr[0];
        fArr2[0][2] = fArr[2];
        fArr2[1][0] = fArr[1];
        fArr2[1][1] = -fArr[0];
        fArr2[1][2] = fArr[2];
        System.arraycopy(fArr, 0, fArr2[2], 0, 3);
        fArr2[3][0] = -fArr[0];
        fArr2[3][1] = -fArr[1];
        fArr2[3][2] = fArr[2];
        fArr2[4][0] = fArr[0];
        fArr2[4][1] = fArr[2];
        fArr2[4][2] = -fArr[1];
        fArr2[5][0] = fArr[0];
        fArr2[5][1] = -fArr[2];
        fArr2[5][2] = fArr[1];
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        float[] fArr;
        int i2;
        float[][] fArr2;
        switch (sensorEvent.sensor.getType()) {
            case 2:
                a(sensorEvent.values, this.aNu);
                a aVar = this.aNH;
                fArr = sensorEvent.values;
                if (fArr.length >= 3) {
                    aVar.aNI++;
                    aVar.aNJ = (float) (Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2]))) + ((double) aVar.aNJ));
                    return;
                }
                return;
            case 4:
                if (this.aNo[2][0] != 0.0f || this.aNo[2][1] != 0.0f || this.aNo[2][2] != 0.0f) {
                    if (this.aNk) {
                        for (i2 = 0; i2 <= 5; i2++) {
                            this.aNm[i2] = a(this.aNm[i2], this.aNl[i2]);
                        }
                        this.aNk = false;
                    }
                    fArr2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 4});
                    if (this.aNj != 0) {
                        float f = 1.0E-9f * ((float) (sensorEvent.timestamp - this.aNj));
                        a(sensorEvent.values, this.aNt);
                        for (int i3 = 0; i3 <= 5; i3++) {
                            float[] fArr3 = this.aNt[i3];
                            float[] fArr4 = fArr2[i3];
                            float f2 = f / 2.0f;
                            float[] fArr5 = new float[3];
                            float sqrt = (float) Math.sqrt((double) (((fArr3[0] * fArr3[0]) + (fArr3[1] * fArr3[1])) + (fArr3[2] * fArr3[2])));
                            if (sqrt > 1.0E-9f) {
                                fArr5[0] = fArr3[0] / sqrt;
                                fArr5[1] = fArr3[1] / sqrt;
                                fArr5[2] = fArr3[2] / sqrt;
                            }
                            float f3 = sqrt * f2;
                            f2 = (float) Math.sin((double) f3);
                            f3 = (float) Math.cos((double) f3);
                            fArr4[0] = fArr5[0] * f2;
                            fArr4[1] = fArr5[1] * f2;
                            fArr4[2] = f2 * fArr5[2];
                            fArr4[3] = f3;
                        }
                    }
                    this.aNj = sensorEvent.timestamp;
                    while (i <= 5) {
                        fArr = new float[9];
                        try {
                            SensorManager.getRotationMatrixFromVector(fArr, fArr2[i]);
                        } catch (Exception e) {
                        }
                        this.aNm[i] = a(this.aNm[i], fArr);
                        i++;
                    }
                    a(this.aNm, this.aNp);
                    return;
                }
                return;
            case 9:
                a(sensorEvent.values, this.aNv);
                if (this.aNu[2][0] != 0.0f || this.aNu[2][1] != 0.0f || this.aNu[2][2] != 0.0f) {
                    fArr2 = this.aNl;
                    float[][] fArr6 = this.aNv;
                    float[][] fArr7 = this.aNu;
                    i2 = (SensorManager.getRotationMatrix(fArr2[0], null, fArr6[0], fArr7[0]) && SensorManager.getRotationMatrix(fArr2[1], null, fArr6[1], fArr7[1]) && SensorManager.getRotationMatrix(fArr2[2], null, fArr6[2], fArr7[2]) && SensorManager.getRotationMatrix(fArr2[3], null, fArr6[3], fArr7[3]) && SensorManager.getRotationMatrix(fArr2[4], null, fArr6[4], fArr7[4]) && SensorManager.getRotationMatrix(fArr2[5], null, fArr6[5], fArr7[5])) ? 1 : 0;
                    if (i2 != 0) {
                        a(this.aNl, this.aNo);
                        if (this.aNp[2][0] == 0.0f && this.aNp[2][1] == 0.0f && this.aNp[2][2] == 0.0f) {
                            fArr6 = this.aNo;
                            float[][] fArr8 = this.aNp;
                            for (i2 = 0; i2 <= 5; i2++) {
                                System.arraycopy(fArr6[i2], 0, fArr8[i2], 0, 3);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 10:
                fArr = new float[16];
                float[] fArr9 = (this.aNi != null ? this.aNn : this.aNm)[2];
                float[] fArr10 = new float[16];
                if (fArr9.length == 9) {
                    fArr10[0] = fArr9[0];
                    fArr10[1] = fArr9[1];
                    fArr10[2] = fArr9[2];
                    fArr10[3] = 0.0f;
                    fArr10[4] = fArr9[3];
                    fArr10[5] = fArr9[4];
                    fArr10[6] = fArr9[5];
                    fArr10[7] = 0.0f;
                    fArr10[8] = fArr9[6];
                    fArr10[9] = fArr9[7];
                    fArr10[10] = fArr9[8];
                    fArr10[11] = 0.0f;
                    fArr10[12] = 0.0f;
                    fArr10[13] = 0.0f;
                    fArr10[14] = 0.0f;
                    fArr10[15] = 1.0f;
                }
                Matrix.invertM(fArr, 0, fArr10, 0);
                Matrix.multiplyMV(this.aNs, 0, fArr, 0, new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], 0.0f}, 0);
                this.aNF.a(this.aNs, sensorEvent.values, this.aNv[2]);
                return;
            case 11:
                try {
                    SensorManager.getRotationMatrixFromVector(this.aNn[2], sensorEvent.values);
                } catch (IllegalArgumentException e2) {
                    if (sensorEvent.values.length > 3) {
                        SensorManager.getRotationMatrixFromVector(this.aNn[2], new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]});
                    }
                }
                SensorManager.remapCoordinateSystem(this.aNn[2], 2, 129, this.aNn[0]);
                SensorManager.remapCoordinateSystem(this.aNn[2], 130, 1, this.aNn[1]);
                SensorManager.remapCoordinateSystem(this.aNn[2], 129, 130, this.aNn[3]);
                SensorManager.remapCoordinateSystem(this.aNn[2], 129, 3, this.aNn[4]);
                SensorManager.remapCoordinateSystem(this.aNn[2], 1, 3, this.aNn[5]);
                while (i <= 5) {
                    SensorManager.getOrientation(this.aNn[i], this.aNr[i]);
                    i++;
                }
                return;
            default:
                return;
        }
    }
}
