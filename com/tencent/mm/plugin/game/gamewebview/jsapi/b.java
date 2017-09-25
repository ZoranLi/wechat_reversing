package com.tencent.mm.plugin.game.gamewebview.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public class b {
    private String iKC;
    private Integer mjI;
    private Integer mjJ;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_BYTE in subclasses", true);
    }

    public final String getName() {
        if (bg.mA(this.iKC)) {
            try {
                this.iKC = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                w.e("MicroMsg.GameBaseJsApii", "getName exp = %s", new Object[]{bg.g(e)});
            }
        }
        return this.iKC;
    }

    public final int azi() {
        return bg.a(azj(), -1);
    }

    private Integer azj() {
        if (this.mjI == null) {
            try {
                this.mjI = (Integer) new c(this, "CTRL_BYTE", null).get();
            } catch (Throwable e) {
                w.e("MicroMsg.GameBaseJsApii", "getCtrlByte exp = %s", new Object[]{bg.g(e)});
            }
        }
        return this.mjI;
    }

    public final int azk() {
        return bg.a(azl(), 0);
    }

    private Integer azl() {
        if (this.mjJ == null) {
            try {
                this.mjJ = (Integer) new c(this, "DO_IN_ENV", null).get();
            } catch (Exception e) {
                this.mjJ = null;
            }
        }
        return this.mjJ;
    }
}
