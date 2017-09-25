package com.tencent.mm.pluginsdk.ui.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends com.tencent.mm.ui.tools.a.a {
    public int hP = JceStruct.JCE_MAX_STRING_LENGTH;
    private String ptO;
    private a sRM;

    public interface a {
    }

    public a(String str) {
        this.ptO = str;
    }

    public final int bGl() {
        return Ve();
    }

    protected final int Ve() {
        int shouldRemuxing;
        int i = 10485760;
        if (bg.mA(this.ptO)) {
            w.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
        }
        boolean is2G = am.is2G(ab.getContext());
        if (c.mD(this.ptO)) {
            double d;
            String str = this.ptO;
            if (!is2G) {
                i = this.hP;
            }
            if (is2G) {
                d = 60000.0d;
            } else {
                d = (double) this.hP;
            }
            shouldRemuxing = SightVideoJNI.shouldRemuxing(str, 660, 500, i, d, Constants.MAX_BUFFER_SIZE);
        } else {
            if (e.aN(this.ptO) > (is2G ? 10485760 : 20971520)) {
                shouldRemuxing = -1;
            } else {
                shouldRemuxing = 1;
            }
        }
        w.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[]{Integer.valueOf(shouldRemuxing), Boolean.valueOf(r10)});
        switch (shouldRemuxing) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
                return 1;
            case -1:
                return 2;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 0;
            default:
                w.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[]{Integer.valueOf(shouldRemuxing)});
                return 1;
        }
    }

    protected final void bGm() {
        if (this.sRM == null) {
            w.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
        } else {
            Ve();
        }
    }
}
