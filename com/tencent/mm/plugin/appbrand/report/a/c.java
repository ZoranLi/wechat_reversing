package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;

public final class c {
    private String fCN;
    public String jgA;
    private long jgB;
    public a jgC;
    public b jgy;
    public int jgz;

    public enum a {
        NEARBY_H5(1),
        EMPTY_PAGE(2),
        LBS_NOT_ALLOW(3);
        
        public final int value;

        private a(int i) {
            this.value = i;
        }
    }

    public enum b {
        DESKTOP_SEARCH(1),
        RESUME_FROM_WEAPP_EXIT(2),
        BOTTOM_ENTRANCE_IN_DESKTOP(3),
        TOP_ENTRANCE_IN_DESKTOP(4);
        
        public final int value;

        private b(int i) {
            this.value = i;
        }
    }

    public final void qg() {
        if (this.jgy != null && this.jgC != null) {
            this.jgB = bg.Nz();
            g.oUh.i(13917, d.g(Integer.valueOf(this.jgy.value), Integer.valueOf(this.jgz), this.jgA, Long.valueOf(this.jgB), this.fCN, Integer.valueOf(this.jgC.value)));
        }
    }
}
