package com.tencent.mm.plugin.sport.b;

import android.content.Context;
import android.os.RemoteException;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.c.a;
import com.tencent.mm.plugin.sport.c.e;
import com.tencent.mm.plugin.sport.c.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class c implements b {
    public final void bml() {
        a deviceStepManager = ((PluginSport) h.j(PluginSport.class)).getDeviceStepManager();
        w.i("MicroMsg.Sport.DeviceStepManager", "uploadDeviceStep");
        deviceStepManager.bmr();
        deviceStepManager.dQ(deviceStepManager.bmq());
    }

    public final void a(String str, String str2, int i, int i2, int i3, String str3) {
        h.vd().a(new e(str, str2, i, i2, i3, str3, 1), 0);
    }

    public final boolean cR(Context context) {
        return k.cR(context);
    }

    public final boolean bmm() {
        return k.bmm();
    }

    public final void E(int i, long j) {
        com.tencent.mm.plugin.sport.c.h.H(i, j);
    }

    public final void bmn() {
        if (ab.bJb()) {
            ((PluginSport) h.j(PluginSport.class)).getSportFileStorage().reset();
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) h.j(PluginSport.class)).getDeviceStepManager().qRo;
            if (aVar != null) {
                try {
                    aVar.bmk();
                } catch (RemoteException e) {
                }
            }
            new File(a.qRi).delete();
        }
    }
}
