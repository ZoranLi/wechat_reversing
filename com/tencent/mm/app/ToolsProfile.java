package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

public final class ToolsProfile extends e {
    public static final String fwe = (ab.getPackageName() + ":tools");
    public static int fxa = 0;
    private static Locale locale;

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = ToolsProfile.class.getClassLoader();
        a.b(ab.getContext(), true);
        k.bi(fwe);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.urP, ToolsProfile.class.getClassLoader());
        q wVar = new w(c.ao(this.app.getBaseContext()));
        wVar.cR("TOOL");
        r.iik = bg.b(wVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        r.iil = bg.b(wVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.iim = bg.b(wVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.iin = bg.b(wVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.iio = bg.b(wVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.iip = bg.b(wVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.iit = bg.b(wVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        r.iiu = bg.b(wVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        r.iix = bg.b(wVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        r.iiy = bg.b(wVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.iiz = bg.b(wVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.iiA = bg.b(wVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.iiD = bg.b(wVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.iiE = bg.b(wVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bg.a(wVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.iiB = a;
        if (a != 4 && r.iiB > 0) {
            v.uze = r.iiB;
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ToolDebugger", "cdn thread num " + r.iiB);
        }
        r.iiC = bg.b(wVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.xW(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = wVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bg.mA(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.sYI = "android-" + string;
                d.sYK = string;
                b.Pb(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.bIv());
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.sYM).append(" new: ").append(a);
            d.sYM = (long) a;
        } catch (Exception e3) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            wVar.gKC.gJL = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean b = bg.b(wVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean b2 = bg.b(wVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean b3 = bg.b(wVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean b4 = bg.b(wVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(b, b2, b3, b4);
            new StringBuilder("try control report : debugModel[").append(b).append("],kv[").append(b2).append("], clientPref[").append(b3).append("], useraction[").append(b4).append("]");
        } catch (Exception e5) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        r.iiR = bg.ap(wVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + r.iiR);
        r.iiS = bg.ap(wVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + r.iiS);
        r.iiT = bg.b(wVar.cS(".com.tencent.mm.debug.skiploadurlcheck"), false);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + r.iiT);
        r.iiU = bg.b(wVar.cS(".com.tencent.mm.debug.forcex5webview"), false);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + r.iiU);
        a.be(fwe);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b("wechatImgTools", classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int rl = l.rl();
        if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolsProfile", "load wechatsight_v7a, core number: %d ", new Object[]{Integer.valueOf(rl >> 12)});
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
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolsProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.ptx = 1;
            com.tencent.mm.plugin.sight.base.b.ptz = 1;
            com.tencent.mm.plugin.sight.base.b.ptA = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.et(this.app.getBaseContext());
        m.a(this.app);
        if (com.tencent.mm.compatible.util.d.eo(14) && MMApplicationLike.applicationLike != null) {
            MMApplicationLike.applicationLike.getApplication().registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(this) {
                final /* synthetic */ ToolsProfile fxb;

                {
                    this.fxb = r1;
                }

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    ToolsProfile.fxa++;
                }

                public final void onActivityDestroyed(Activity activity) {
                    ToolsProfile.fxa--;
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ToolsProfile", "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[]{Integer.valueOf(ToolsProfile.fxa)});
                    if (ToolsProfile.fxa == 0) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolsProfile", "onActivityDestroyed, tbsNeedReboot = %b", new Object[]{Boolean.valueOf(WebView.getTbsNeedReboot())});
                        if (WebView.getTbsNeedReboot()) {
                            Process.killProcess(Process.myPid());
                        }
                    }
                }

                public final void onActivityPaused(Activity activity) {
                }

                public final void onActivityResumed(Activity activity) {
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityStopped(Activity activity) {
                }
            });
        }
        FileOp.init(false);
        MMBitmapFactory.init();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ToolsProfile", "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Locale et = MMActivity.et(this.app.getBaseContext());
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ToolsProfile", "onConfigurationChanged, locale = " + locale.toString() + ", n = " + et.toString());
        if (!et.equals(locale)) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ToolsProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return fwe;
    }
}
