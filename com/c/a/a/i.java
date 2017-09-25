package com.c.a.a;

import android.location.Location;

final class i {
    static i aJP;
    double aJQ;
    double aJR;
    float aJS;
    float aJT;
    float aJU;
    float aJV;
    float aJW;
    float aJX;
    boolean aJY = false;

    i() {
    }

    final void a(double d, double d2, float f, float f2, float f3, float f4) {
        double d3;
        float[] fArr = new float[1];
        if (d2 > 179.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d, d2, d, d2 + d3, fArr);
        this.aJX = fArr[0];
        if (d > 89.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d3 + d, d2, d, d2, fArr);
        this.aJW = fArr[0];
        this.aJQ = d;
        this.aJR = d2;
        this.aJS = f2;
        this.aJT = f3;
        this.aJV = f;
        this.aJU = f4;
        this.aJY = true;
    }
}
