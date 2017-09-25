package com.tencent.mm.plugin.appbrand.config;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;

public final class s {
    public String appId;
    public String fFa;
    public String hvv;
    public List<WxaEntryInfo> iFN;
    public List<Pair<String, String>> iFX;
    public int iGc;
    public String iGg;
    private String iGh = null;
    public String signature;
    public String username;

    public final String RM() {
        if (bg.mA(this.iGh) && !bg.bV(this.iFX)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            for (Pair pair : this.iFX) {
                str = bg.mA((String) pair.second) ? (String) pair.first : (String) pair.second;
                if (!bg.mA(str)) {
                    stringBuilder.append("、");
                    stringBuilder.append(str);
                }
            }
            str = stringBuilder.toString();
            if (!bg.mA(str)) {
                str = str.replaceFirst("、", "");
            }
            this.iGh = str;
        }
        return bg.mz(this.iGh);
    }
}
