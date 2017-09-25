package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class h<T> extends a<T> {
    private boolean aoW = false;
    private ArrayList<Integer> aoX;

    public h(DataHolder dataHolder) {
        super(dataHolder);
    }

    private int bX(int i) {
        if (i >= 0 && i < this.aoX.size()) {
            return ((Integer) this.aoX.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    private void jQ() {
        synchronized (this) {
            if (!this.aoW) {
                int i = this.aoy.aoJ;
                this.aoX = new ArrayList();
                if (i > 0) {
                    this.aoX.add(Integer.valueOf(0));
                    String jP = jP();
                    String b = this.aoy.b(jP, 0, this.aoy.bV(0));
                    int i2 = 1;
                    while (i2 < i) {
                        int bV = this.aoy.bV(i2);
                        String b2 = this.aoy.b(jP, i2, bV);
                        if (b2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + jP + ", at row: " + i2 + ", for window: " + bV);
                        }
                        if (b2.equals(b)) {
                            b2 = b;
                        } else {
                            this.aoX.add(Integer.valueOf(i2));
                        }
                        i2++;
                        b = b2;
                    }
                }
                this.aoW = true;
            }
        }
    }

    public abstract T aj(int i, int i2);

    public final T get(int i) {
        int i2;
        jQ();
        int bX = bX(i);
        if (i < 0 || i == this.aoX.size()) {
            i2 = 0;
        } else {
            i2 = i == this.aoX.size() + -1 ? this.aoy.aoJ - ((Integer) this.aoX.get(i)).intValue() : ((Integer) this.aoX.get(i + 1)).intValue() - ((Integer) this.aoX.get(i)).intValue();
            if (i2 == 1) {
                this.aoy.bV(bX(i));
            }
        }
        return aj(bX, i2);
    }

    public final int getCount() {
        jQ();
        return this.aoX.size();
    }

    public abstract String jP();
}
