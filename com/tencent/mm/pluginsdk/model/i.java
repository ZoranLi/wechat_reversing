package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.u.ap;
import java.util.Map;

public final class i implements t {
    public static boolean sCl = false;
    private static i sCm;
    public a sCn;

    public interface a {
        void a(l lVar);
    }

    public static class b {
        public String sCo;
    }

    private i() {
    }

    public static i bCD() {
        if (sCm == null) {
            sCm = new i();
        }
        return sCm;
    }

    public final void bCE() {
        if (ap.zb()) {
            an.aBG().a(14, (t) this);
            sCl = true;
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (ap.zb()) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (wVar == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (wVar.getType()) {
                    case 14:
                        if (ab.getContext() == null || com.tencent.mm.plugin.w.a.a.a.aRv() == null) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                            return;
                        }
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", Integer.valueOf(i), Integer.valueOf(i2));
                        l lVar = (l) wVar;
                        if (this.sCn != null) {
                            this.sCn.a(lVar);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static b LR(String str) {
        if (str == null) {
            return null;
        }
        Map q = bh.q(str, "PersonalAppSetting");
        if (q == null) {
            return null;
        }
        String str2 = (String) q.get(".PersonalAppSetting.OpenID");
        if (bg.mA(str2)) {
            return null;
        }
        b bVar = new b();
        bVar.sCo = str2;
        return bVar;
    }
}
