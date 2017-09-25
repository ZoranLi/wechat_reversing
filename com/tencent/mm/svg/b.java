package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

final class b {
    private static a<Paint> uMM = new a();
    private static a<float[]> uMN = new a();
    private static a<Matrix> uMO = new a();
    private static a<Path> uMP = new a();
    private static final float[] uMQ = new float[9];

    protected static synchronized void b(Looper looper) {
        synchronized (b.class) {
            uMM.a(looper);
            uMN.a(looper);
            uMO.a(looper);
            uMP.a(looper);
        }
    }

    protected static synchronized Paint a(Looper looper, Paint paint) {
        Paint paint2;
        synchronized (b.class) {
            paint2 = (Paint) uMM.bNS();
            if (paint2 == null) {
                paint2 = new Paint();
            } else {
                paint2.reset();
            }
            if (paint != null) {
                paint2.set(paint);
            }
            uMM.a(looper, paint2);
        }
        return paint2;
    }

    protected static synchronized float[] c(Looper looper) {
        Object obj;
        synchronized (b.class) {
            obj = (float[]) uMN.bNS();
            if (obj == null) {
                obj = new float[9];
            } else {
                System.arraycopy(uMQ, 0, obj, 0, 9);
            }
            uMN.a(looper, obj);
        }
        return obj;
    }

    protected static synchronized Matrix d(Looper looper) {
        Matrix matrix;
        synchronized (b.class) {
            matrix = (Matrix) uMO.bNS();
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            uMO.a(looper, matrix);
        }
        return matrix;
    }

    protected static synchronized Path e(Looper looper) {
        Path path;
        synchronized (b.class) {
            path = (Path) uMP.bNS();
            if (path == null) {
                path = new Path();
            } else {
                path.reset();
            }
            uMP.a(looper, path);
        }
        return path;
    }
}
