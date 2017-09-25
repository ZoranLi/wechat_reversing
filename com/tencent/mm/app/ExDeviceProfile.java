package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.r;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.v;

public class ExDeviceProfile extends e {
    public static final String fwe = (ab.getPackageName() + ":exdevice");

    public final void onCreate() {
        w.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
        c ao = c.ao(this.app.getBaseContext());
        a.b(ab.getContext(), true);
        k.bi(fwe);
        k.setupBrokenLibraryHandler();
        r rVar = new r(ao);
        rVar.cR("EXDEVICE");
        com.tencent.mm.platformtools.r.iik = bg.b(rVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        com.tencent.mm.platformtools.r.iil = bg.b(rVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        com.tencent.mm.platformtools.r.iim = bg.b(rVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        com.tencent.mm.platformtools.r.iin = bg.b(rVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        com.tencent.mm.platformtools.r.iio = bg.b(rVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        com.tencent.mm.platformtools.r.iip = bg.b(rVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        com.tencent.mm.platformtools.r.iit = bg.b(rVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        com.tencent.mm.platformtools.r.iiu = bg.b(rVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        com.tencent.mm.platformtools.r.iix = bg.b(rVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        com.tencent.mm.platformtools.r.iiy = bg.b(rVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        com.tencent.mm.platformtools.r.iiz = bg.b(rVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        com.tencent.mm.platformtools.r.iiA = bg.b(rVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        com.tencent.mm.platformtools.r.iiD = bg.b(rVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        com.tencent.mm.platformtools.r.iiE = bg.b(rVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bg.a(rVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        com.tencent.mm.platformtools.r.iiB = a;
        if (a != 4 && com.tencent.mm.platformtools.r.iiB > 0) {
            v.uze = com.tencent.mm.platformtools.r.iiB;
            w.e("MicroMsg.ExdDebugger", "cdn thread num " + com.tencent.mm.platformtools.r.iiB);
        }
        com.tencent.mm.platformtools.r.iiC = bg.b(rVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.xW(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            w.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            String string = rVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bg.mA(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.sYI = "android-" + string;
                d.sYK = string;
                b.Pb(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.bIv());
            }
        } catch (Exception e2) {
            w.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.sYM).append(" new: ").append(a);
            d.sYM = (long) a;
        } catch (Exception e3) {
            w.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            boolean b = bg.b(rVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean b2 = bg.b(rVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean b3 = bg.b(rVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean b4 = bg.b(rVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(b, b2, b3, b4);
            new StringBuilder("try control report : debugModel[").append(b).append("],kv[").append(b2).append("], clientPref[").append(b3).append("], useraction[").append(b4).append("]");
        } catch (Exception e4) {
            w.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        com.tencent.mm.platformtools.r.iiR = bg.ap(rVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        w.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.r.iiR);
        com.tencent.mm.platformtools.r.iiS = bg.ap(rVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        w.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + com.tencent.mm.platformtools.r.iiS);
        com.tencent.mm.platformtools.r.iiT = bg.b(rVar.cS(".com.tencent.mm.debug.skiploadurlcheck"), false);
        w.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.r.iiT);
        m.a(this.app);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        w.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    }

    public String toString() {
        return fwe;
    }
}
