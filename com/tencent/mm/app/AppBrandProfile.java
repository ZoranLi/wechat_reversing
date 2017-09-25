package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;

public class AppBrandProfile extends e {
    protected static String fvD = "";

    public final void onCreate() {
        fvD = ab.um();
        ClassLoader classLoader = AppBrandProfile.class.getClassLoader();
        a.b(ab.getContext(), true);
        k.a(new c(this) {
            final /* synthetic */ AppBrandProfile fvL;

            {
                this.fvL = r1;
            }

            public final void b(Throwable th) {
                g.oUh.a(365, 3, 1, false);
                KVCommCrossProcessReceiver.aXE();
            }
        });
        q pVar = new p(com.tencent.mm.booter.c.ao(this.app.getBaseContext()));
        pVar.cR("APPBRAND" + fvD.replace(ab.getPackageName() + ":appbrand", ""));
        r.iik = bg.b(pVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        r.iil = bg.b(pVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.iim = bg.b(pVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.iin = bg.b(pVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.iio = bg.b(pVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.iip = bg.b(pVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.iit = bg.b(pVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        r.iiu = bg.b(pVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        r.iix = bg.b(pVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        r.iiy = bg.b(pVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.iiz = bg.b(pVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.iiA = bg.b(pVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.iiD = bg.b(pVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.iiE = bg.b(pVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bg.a(pVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.iiB = a;
        if (a != 4 && r.iiB > 0) {
            v.uze = r.iiB;
            w.e("MicroMsg.AppBDebugger", "cdn thread num " + r.iiB);
        }
        r.iiC = bg.b(pVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        r.iiU = bg.b(pVar.cS(".com.tencent.mm.debug.forcex5webview"), false);
        r.iiR = bg.ap(pVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        w.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + r.iiR);
        try {
            a = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.xW(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            w.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            String string = pVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bg.mA(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.sYI = "android-" + string;
                d.sYK = string;
                b.Pb(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.bIv());
            }
        } catch (Exception e2) {
            w.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.sYM).append(" new: ").append(a);
            d.sYM = (long) a;
        } catch (Exception e3) {
            w.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            pVar.gKC.gJL = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            w.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            boolean b = bg.b(pVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean b2 = bg.b(pVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean b3 = bg.b(pVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean b4 = bg.b(pVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(b, b2, b3, b4);
            new StringBuilder("try control report : debugModel[").append(b).append("],kv[").append(b2).append("], clientPref[").append(b3).append("], useraction[").append(b4).append("]");
        } catch (Exception e5) {
            w.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        k.bi(fvD);
        a.be(fvD);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b(com.tencent.mm.sdk.a.urR, classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int rl = l.rl();
        if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            w.i("MicroMsg.AppBrandProfile", "load wechatsight_v7a, core number: %d", new Object[]{Integer.valueOf(rl >> 12)});
            k.b("wechatsight_v7a", classLoader);
            if ((rl >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.b.ptx = 3;
                com.tencent.mm.plugin.sight.base.b.ptz = 3;
                com.tencent.mm.plugin.sight.base.b.ptA = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.b.ptx = 1;
                com.tencent.mm.plugin.sight.base.b.ptz = 1;
                com.tencent.mm.plugin.sight.base.b.ptA = 640000;
            }
        } else {
            w.i("MicroMsg.AppBrandProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.ptx = 1;
            com.tencent.mm.plugin.sight.base.b.ptz = 1;
            com.tencent.mm.plugin.sight.base.b.ptA = 640000;
        }
        a.b(ab.getContext(), true);
        m.a(this.app);
        MMActivity.et(this.app.getBaseContext());
        FileOp.init(false);
        MMBitmapFactory.init();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        w.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", new Object[]{Integer.valueOf(i)});
    }
}
