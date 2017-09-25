package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;

public final class j {
    private static String sWC = null;
    private static final String[] sWD = new String[]{"", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use"};

    public static void mN(int i) {
        dJ(i, 0);
    }

    public static void dJ(int i, int i2) {
        if (i <= 0 || i > 7) {
            w.e("MicroMsg.TBSReporter", "report invalid scene = %d", Integer.valueOf(i));
            return;
        }
        w.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", Integer.valueOf(i), sWD[i], Integer.valueOf(i2));
        Context context = ab.getContext();
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        String dF = dF(context);
        g.oUh.a(11633, false, true, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(tbsCoreVersion), Integer.valueOf(tbsSDKVersion), dF, Integer.valueOf(i2));
    }

    private static String dF(Context context) {
        if (sWC != null) {
            return sWC;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(ab.getPackageName(), FileUtils.S_IWUSR);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String string = applicationInfo.metaData.getString("com.tencent.mtt.TBS_CODE");
                if (!bg.mA(string)) {
                    sWC = string;
                    return string;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", e.getMessage());
        }
        return null;
    }
}
