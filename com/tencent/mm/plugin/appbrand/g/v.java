package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.ck;

enum v {
    APP_LAUNCH("appLaunch"),
    NAVIGATE_TO(az.NAME),
    NAVIGATE_BACK(ax.NAME),
    REDIRECT_TO(bk.NAME),
    RE_LAUNCH("reLaunch"),
    AUTO_RE_LAUNCH("autoReLaunch"),
    SWITCH_TAB(ck.NAME);
    
    private final String type;

    private v(String str) {
        this.type = str;
    }

    public final String toString() {
        return this.type;
    }
}
