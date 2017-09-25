package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class m implements t {
    private List<String> sCZ = new ArrayList();
    private volatile boolean sDA = false;
    public Vector<String> sDz = new Vector();

    public m() {
        a.aBG().a(1, (t) this);
    }

    public final void Jl(String str) {
        w.d("MicroMsg.AppSettingService", "appId = " + str);
        if (bg.mA(str)) {
            w.e("MicroMsg.AppSettingService", "add appId is null");
            return;
        }
        if (!this.sDz.contains(str)) {
            this.sDz.add(str);
        }
        aBt();
    }

    public final void bQ(List<String> list) {
        if (list == null || list.size() == 0) {
            w.e("MicroMsg.AppSettingService", "addAll list is null");
            return;
        }
        for (String str : list) {
            if (!(bg.mA(str) || this.sDz.contains(str))) {
                this.sDz.add(str);
            }
        }
        aBt();
    }

    private void aBt() {
        int i = 20;
        if (this.sDA) {
            w.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
        } else if (this.sDz.size() <= 0) {
            w.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
        } else {
            w.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.sDz.size());
            int size = this.sDz.size();
            if (size <= 20) {
                i = size;
            }
            this.sDA = true;
            this.sCZ.addAll(this.sDz.subList(0, i));
            h.vH().gXC.a(new x(1, new ae(this.sCZ)), 0);
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (wVar.getType() == 1) {
            this.sDA = false;
            w.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((ae) wVar).sDR.size());
            this.sDz.removeAll(this.sCZ);
            this.sCZ.clear();
            aBt();
        }
    }
}
