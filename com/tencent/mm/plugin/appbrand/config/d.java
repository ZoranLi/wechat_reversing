package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;

public final class d extends c<bb> {
    public d() {
        this.usg = bb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bb bbVar = (bb) bVar;
        if (bbVar.fEA.fEB == 38) {
            int i = bbVar.fEA.fEC;
            int i2 = bbVar.fEA.fED;
            String str = bbVar.fEA.filePath;
            if (!bg.mA(str) || e.aO(str)) {
                boolean z;
                String RA = RA();
                if (e.aO(RA)) {
                    String aV = g.aV(str);
                    z = (bg.mA(aV) || aV.equals(g.aV(RA))) ? false : true;
                } else {
                    z = true;
                }
                if (z) {
                    AppBrandGlobalSystemConfig.Rx();
                    j.ex(str, RA);
                    com.tencent.mm.pluginsdk.k.a.b.b.c.sFE.R(38, i, i2);
                }
            }
        }
        return true;
    }

    static String RA() {
        File file = new File(com.tencent.mm.compatible.util.e.hgr.replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "AppService.conf").getAbsolutePath();
    }
}
