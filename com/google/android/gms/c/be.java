package com.google.android.gms.c;

import java.io.IOException;

public abstract class be {
    protected volatile int aCJ = -1;

    public static final <T extends be> T a(T t, byte[] bArr, int i) {
        try {
            aw awVar = new aw(bArr, 0, i);
            t.a(awVar);
            awVar.ce(0);
            return t;
        } catch (bd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] c(be beVar) {
        byte[] bArr = new byte[beVar.lH()];
        try {
            ax b = ax.b(bArr, 0, bArr.length);
            beVar.a(b);
            if (b.aCx.remaining() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public abstract be a(aw awVar);

    public void a(ax axVar) {
    }

    public /* synthetic */ Object clone() {
        return lw();
    }

    protected int kK() {
        return 0;
    }

    public final int lG() {
        if (this.aCJ < 0) {
            lH();
        }
        return this.aCJ;
    }

    public final int lH() {
        int kK = kK();
        this.aCJ = kK;
        return kK;
    }

    public be lw() {
        return (be) super.clone();
    }

    public String toString() {
        return bf.d(this);
    }
}
