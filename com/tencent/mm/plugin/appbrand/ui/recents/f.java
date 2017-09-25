package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.c;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;

final class f extends c<Object> {
    f(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        super(arrayList, arrayList2);
    }

    public final boolean bw(int i, int i2) {
        if (!this.jiG.get(i).getClass().equals(this.jiH.get(i2).getClass())) {
            return false;
        }
        if (!(this.jiG.get(i) instanceof e)) {
            return false;
        }
        e eVar = (e) this.jiG.get(i);
        e eVar2 = (e) this.jiH.get(i2);
        return eVar.appId.equals(eVar2.appId) && eVar.izM == eVar2.izM && eVar.fCJ.equals(eVar2.fCJ);
    }

    public final boolean bx(int i, int i2) {
        if (!(this.jiG.get(i) instanceof e)) {
            return false;
        }
        e eVar = (e) this.jiG.get(i);
        e eVar2 = (e) this.jiH.get(i2);
        if (eVar.appId.equals(eVar2.appId) && eVar.fCJ.equals(eVar2.fCJ) && eVar.izM == eVar2.izM && eVar.iCc == eVar2.iCc && bg.mz(eVar.iCa).equals(eVar2.iCa) && bg.mz(eVar.appName).equals(eVar2.appName)) {
            return true;
        }
        return false;
    }

    public final Object by(int i, int i2) {
        if (i >= this.jiG.size()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.jiG.get(i) instanceof e) {
            e eVar = (e) this.jiG.get(i);
            e eVar2 = (e) this.jiH.get(i2);
            if (eVar.iCb != eVar2.iCb) {
                bundle.putLong("running_flag", eVar2.iCb);
            }
            if (eVar.iCc != eVar2.iCc) {
                bundle.putBoolean("star", eVar2.iCc);
            }
            if (eVar.izM != eVar2.izM) {
                bundle.putInt("debug_type", eVar2.izM);
            }
            if (!bg.mz(eVar.iCa).equals(eVar2.iCa)) {
                bundle.putString("icon", eVar2.iCa);
            }
            if (!bg.mz(eVar.appName).equals(eVar2.appName)) {
                bundle.putString("nick_name", eVar2.appName);
            }
        }
        return bundle.size() <= 0 ? null : bundle;
    }
}
