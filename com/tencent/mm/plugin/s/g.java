package com.tencent.mm.plugin.s;

import android.os.Build;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bg;

public final class g {
    private static final String[] nzs = new String[]{"SonyC6602"};
    private static PBool nzt = null;
    private boolean kmK;
    public long nze = 0;
    public long nzf = 0;
    public long nzg = -1;
    public long nzh = 0;
    public long nzi = 0;
    public long nzj = 0;
    public long nzk = 0;
    public long nzl = 10;
    public boolean nzm = true;
    public boolean nzn = true;
    public boolean nzo = false;
    public boolean nzp = false;
    boolean nzq = false;
    boolean nzr = false;

    public g(boolean z) {
        this.kmK = z;
    }

    public final String aKs() {
        return hashCode();
    }

    public final void AK(String str) {
        if (this.nzm) {
            com.tencent.mm.plugin.report.service.g.oUh.a(354, 152, 1, false);
            com.tencent.mm.plugin.report.service.g.oUh.i(13836, Integer.valueOf(500), Long.valueOf(bg.Ny()), str);
        }
    }

    public final void AL(String str) {
        if (this.nzm) {
            com.tencent.mm.plugin.report.service.g.oUh.a(354, 153, 1, false);
            com.tencent.mm.plugin.report.service.g.oUh.i(13836, Integer.valueOf(501), Long.valueOf(bg.Ny()), str);
        }
    }

    public final void aKt() {
        if (this.nzm) {
            com.tencent.mm.plugin.report.service.g.oUh.a(354, 155, 1, false);
            com.tencent.mm.plugin.report.service.g.oUh.i(13836, Integer.valueOf(503), Long.valueOf(bg.Ny()), "");
        }
    }

    public static boolean aKu() {
        boolean z = false;
        if (nzt == null) {
            String str = Build.BRAND + Build.MODEL;
            if (!bg.mA(str)) {
                for (String eB : nzs) {
                    if (bg.eB(str, eB)) {
                        z = true;
                        break;
                    }
                }
            }
            PBool pBool = new PBool();
            nzt = pBool;
            pBool.value = z;
        }
        return nzt.value;
    }
}
