package com.tencent.mm.plugin.appbrand.widget.d;

public final class f {
    public final double x;
    public final double y;

    public f(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.x == ((f) obj).x && this.y == ((f) obj).y;
        } else {
            return false;
        }
    }

    public final String toString() {
        return "Point{x=" + this.x + ", y=" + this.y + '}';
    }
}
