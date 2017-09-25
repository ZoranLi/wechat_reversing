package com.tencent.mm.plugin.h.a.a;

import java.util.Arrays;

public final class c {
    public String aQl = "";
    String jQk = null;
    public e jQl = null;
    public double jQm = 0.0d;

    public final int hashCode() {
        if (this.jQl == null) {
            return 0;
        }
        return Arrays.hashCode(this.jQl.jQq.jQR);
    }

    public final boolean equals(Object obj) {
        if (this.jQl == null || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Arrays.equals(((c) obj).jQl.jQq.jQR, this.jQl.jQq.jQR);
    }
}
