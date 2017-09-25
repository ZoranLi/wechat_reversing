package android.support.v7.widget;

final class ag {
    int abF = 0;
    int abG = 0;
    int abH = Integer.MIN_VALUE;
    int abI = 0;
    int abJ = 0;
    boolean abK = false;
    boolean gd = false;
    int wd = Integer.MIN_VALUE;

    ag() {
    }

    public final void ac(int i, int i2) {
        this.abH = i;
        this.wd = i2;
        this.abK = true;
        if (this.gd) {
            if (i2 != Integer.MIN_VALUE) {
                this.abF = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.abG = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.abF = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.abG = i2;
        }
    }
}
