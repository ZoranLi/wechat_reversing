package com.tencent.mm.plugin.appbrand.dynamic.core;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public interface MiniJsApiFwContext extends Parcelable {
    WxaPkgWrappingInfo RU();

    WxaPkgWrappingInfo RV();

    int RW();

    int RX();

    byte[] RY();

    int RZ();

    DebuggerInfo Sa();

    WidgetSysConfig Sb();

    String getAppId();

    String getId();
}
