package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, Class<? extends AppBrandTaskProxyUI>> iJN;

    public static void a(Context context, String str, String str2, String str3, String str4) {
        AppBrandProcessProxyUI.a(context, AppBrandProcessProxyUI.class, str, str2, str3, str4, null, null, null);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        AppBrandProcessProxyUI.a(context, Sw(), str, str2, str3, str4, onClickListener, onClickListener2, onClickListener3);
    }

    public static <_Req extends ProcessRequest, _Result extends ProcessResult> void a(Context context, _Req _Req, b<_Result> bVar) {
        AppBrandProcessProxyUI.a(context, AppBrandProcessProxyUI.class, _Req, bVar);
    }

    public static <_Req extends ProcessRequest, _Result extends ProcessResult> void b(Context context, _Req _Req, b<_Result> bVar) {
        AppBrandProcessProxyUI.a(context, Sw(), _Req, bVar);
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(":appbrand0", AppBrandTaskProxyUI.class);
        hashMap.put(":appbrand1", AppBrandTaskProxyUI1.class);
        hashMap.put(":appbrand2", AppBrandTaskProxyUI2.class);
        hashMap.put(":appbrand3", AppBrandTaskProxyUI3.class);
        hashMap.put(":appbrand4", AppBrandTaskProxyUI4.class);
        iJN = Collections.unmodifiableMap(hashMap);
    }

    private static Class<? extends AppBrandProcessProxyUI> Sw() {
        Class<? extends AppBrandProcessProxyUI> cls = (Class) iJN.get(ab.um().replaceFirst(ab.getPackageName(), ""));
        Class<? extends AppBrandProcessProxyUI> cls2 = AppBrandProcessProxyUI.class;
        if (cls == null) {
            return cls2;
        }
        return cls;
    }
}
