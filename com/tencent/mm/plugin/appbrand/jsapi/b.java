package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public abstract class b {
    private String iKC;
    private Integer iKD;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_INDEX in subclasses", true);
    }

    public final String getName() {
        if (bg.mA(this.iKC)) {
            try {
                this.iKC = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[]{bg.g(e)});
            }
        }
        return this.iKC;
    }

    public final int SO() {
        return bg.a(SP(), -1);
    }

    private Integer SP() {
        if (this.iKD == null) {
            try {
                this.iKD = (Integer) new c(this, "CTRL_INDEX", null).get();
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.BaseJsApi", "getCtrlIndex exp = %s", new Object[]{bg.g(e)});
            }
        }
        return this.iKD;
    }
}
