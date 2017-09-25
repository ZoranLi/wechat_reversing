package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.vending.app.a;

public final class d extends a {
    l ioy = new l();
    e ioz = new e();

    protected final void onCreate() {
        super.onCreate();
        w.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        com.tencent.mm.y.e NW = this.ioy.NW();
        ap.vd().a(1624, NW);
        ap.vd().a(1655, NW);
        NW = this.ioz.NR();
        w.i("MicroMsg.AAOperationData", "init");
        ap.vd().a(1698, NW);
    }

    protected final void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        com.tencent.mm.y.e NW = this.ioy.NW();
        ap.vd().b(1624, NW);
        ap.vd().b(1655, NW);
        NW = this.ioz.NR();
        w.i("MicroMsg.AAOperationData", "uninit");
        ap.vd().b(1698, NW);
    }
}
