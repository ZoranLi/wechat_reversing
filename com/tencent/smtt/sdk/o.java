package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;

final class o {
    public boolean wUY;
    public boolean wUZ;
    private Map<String, String> wVa;

    public o() {
        this.wUY = false;
        this.wUZ = false;
        this.wVa = null;
        this.wVa = new HashMap();
    }

    public final synchronized void a(String str, byte b) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            if (b == (byte) 1) {
                str2 = "_begin";
            } else if (b == (byte) 2) {
                str2 = "_end";
            }
            this.wVa.put(str + str2, String.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized boolean aL(int i, String str) {
        boolean z = false;
        synchronized (this) {
            ac cfb = ac.cfb();
            if (cfb.cfc() && str != null) {
                if (str.startsWith("http")) {
                    if ((this.wUZ && this.wUY) || System.currentTimeMillis() % 10 == 0) {
                        this.wUZ = true;
                        this.wUY = true;
                        this.wVa.put("is_first_init_tbs", String.valueOf(this.wUZ));
                        this.wVa.put("is_first_init_x5", String.valueOf(this.wUY));
                        this.wVa.put("x5_webview_id", Integer.toString(i));
                        this.wVa.put("current_url", str);
                        if (QbSdk.wTA != null && QbSdk.wTA.containsKey(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)) {
                            this.wVa.put(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID, QbSdk.wTA.get(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID));
                        }
                        cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i), this.wVa);
                        z = true;
                    } else {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final synchronized void al(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.wVa.put(str, String.valueOf(j));
        }
    }
}
