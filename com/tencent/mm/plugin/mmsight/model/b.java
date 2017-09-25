package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.sdk.platformtools.bg;

public final class b {
    long igb = 0;
    long nBx = bg.NA();
    long nBy = bg.NA();
    private String tag = "default";
    long value = 0;

    public b(String str) {
        this.tag = str;
    }

    public final void cG(long j) {
        if (this.igb == 0) {
            this.nBx = bg.NA();
        }
        this.value += j;
        this.igb++;
        this.nBy = bg.NA();
    }

    public final String getValue() {
        String str = "";
        if (this.igb == 0) {
            return "";
        }
        double d = ((double) (this.nBy - this.nBx)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[]{str, this.tag, Long.valueOf(this.igb), Double.valueOf(d), Double.valueOf((((double) this.value) * 1.0d) / ((double) this.igb)), Double.valueOf((((double) this.igb) * 1.0d) / d), Double.valueOf((1.0d * ((double) this.value)) / d), Long.valueOf(this.nBx), Long.valueOf(this.nBy), Long.valueOf(this.nBy - this.nBx)});
    }

    public final String aKJ() {
        if (this.igb == 0) {
            return "";
        }
        double d = ((double) (this.nBy - this.nBx)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return ((1.0d * ((double) this.igb)) / d);
    }

    public final void reset() {
        this.value = 0;
        this.igb = 0;
    }
}
