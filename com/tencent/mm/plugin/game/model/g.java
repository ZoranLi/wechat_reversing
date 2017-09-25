package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.plugin.game.c.v;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public class g {
    private static g mpk;
    public ak mpl;

    public static g aAF() {
        if (mpk == null) {
            synchronized (g.class) {
                if (mpk == null) {
                    mpk = new g();
                }
            }
        }
        return mpk;
    }

    public final void OU() {
        c.vL().D(new Runnable(this) {
            final /* synthetic */ g mpm;

            {
                this.mpm = r1;
            }

            public final void run() {
                this.mpm.aq(SubCoreGameCenter.aBF().xQ("pb_game_global_config"));
            }
        });
    }

    public final synchronized void aq(byte[] bArr) {
        if (!bg.bm(bArr)) {
            try {
                this.mpl = new ak();
                this.mpl.aD(bArr);
            } catch (IOException e) {
                this.mpl = null;
                w.e("MicroMsg.GameConfigManager", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final v aAG() {
        v vVar = null;
        if (this.mpl != null) {
            vVar = this.mpl.mtP;
            if (vVar != null) {
                w.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[]{Integer.valueOf(vVar.mtm), vVar.msF});
            }
        } else {
            OU();
        }
        return vVar;
    }
}
