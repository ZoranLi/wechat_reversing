package com.google.android.gms.c;

import java.util.Arrays;

final class bg {
    final byte[] aCK;
    final int tag;

    bg(int i, byte[] bArr) {
        this.tag = i;
        this.aCK = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bg)) {
            return false;
        }
        bg bgVar = (bg) obj;
        return this.tag == bgVar.tag && Arrays.equals(this.aCK, bgVar.aCK);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.aCK);
    }
}
