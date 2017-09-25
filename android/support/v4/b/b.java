package android.support.v4.b;

import android.graphics.Color;

public final class b {
    private static final ThreadLocal<double[]> tK = new ThreadLocal();

    public static int i(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - (((255 - alpha) * (255 - alpha2)) / 255);
        return Color.argb(i3, b(Color.red(i), alpha2, Color.red(i2), alpha, i3), b(Color.green(i), alpha2, Color.green(i2), alpha, i3), b(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    private static int b(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int j(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
