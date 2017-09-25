package com.tencent.mm.app;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.console.Shell;
import com.tencent.mm.e.a.gf;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.v;

public final class PusherProfile extends e {
    public static final String fwe = (ab.getPackageName() + ":push");
    private Shell fwV = new Shell();

    public final void onCreate() {
        Context context = ab.getContext();
        AppLogic.setCallBack(new AppCallBack(ab.getContext()));
        k.b(a.urO, PusherProfile.class.getClassLoader());
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        q tVar = new t(c.ao(context));
        tVar.cR("PUSH");
        r.iik = bg.b(tVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        r.iil = bg.b(tVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.iim = bg.b(tVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.iin = bg.b(tVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.iio = bg.b(tVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.iip = bg.b(tVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.iit = bg.b(tVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        r.iiu = bg.b(tVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        r.iix = bg.b(tVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        r.iiy = bg.b(tVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.iiz = bg.b(tVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.iiA = bg.b(tVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.iiD = bg.b(tVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.iiE = bg.b(tVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bg.a(tVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.iiB = a;
        if (a != 4 && r.iiB > 0) {
            v.uze = r.iiB;
            w.e("MicroMsg.PushDebugger", "cdn thread num " + r.iiB);
        }
        r.iiC = bg.b(tVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        r.iiH = bg.b(tVar.cS(".com.tencent.mm.debug.test.skip_getdns"), false);
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.xW(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            w.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            String string = tVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bg.mA(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.sYI = "android-" + string;
                d.sYK = string;
                b.Pb(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.bIv());
            }
        } catch (Exception e2) {
            w.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.sYM).append(" new: ").append(a);
            d.sYM = (long) a;
        } catch (Exception e3) {
            w.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            tVar.gKC.gJL = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            w.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            boolean b = bg.b(tVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean b2 = bg.b(tVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean b3 = bg.b(tVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean b4 = bg.b(tVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(b, b2, b3, b4);
            new StringBuilder("try control report : debugModel[").append(b).append("],kv[").append(b2).append("], clientPref[").append(b3).append("], useraction[").append(b4).append("]");
        } catch (Exception e5) {
            w.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        a.be(fwe);
        o.onCreate(false);
        com.tencent.mm.bb.d.a("gcm", null, null);
        com.tencent.mm.bb.d.o("gcm", null);
        com.tencent.mm.sdk.b.a.urY.b(new com.tencent.mm.sdk.b.c<gf>(this) {
            final /* synthetic */ PusherProfile fwW;

            {
                this.fwW = r2;
                this.usg = gf.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                String str = "gcm";
                String str2 = "GCMDoSyncEvent Notify Now Always should be MM_NEWSYNC_DEFAULT_SELECTOR  & SCENE_SYNC_GCM  atapter == null[%b]";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(z.MQ() == null);
                w.i(str, str2, objArr);
                if (z.MQ() != null) {
                    z.MQ().onPush(2147480001, new byte[0]);
                } else {
                    z.bA(true);
                }
                return true;
            }
        });
        bg.et(ab.getContext());
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return fwe;
    }
}
