package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public interface c extends a {
    void a(Context context, String str, int i, int i2, String str2, AppBrandStatObject appBrandStatObject);

    void a(Context context, String str, String str2, int i, String str3, String str4);

    void a(Context context, String str, String str2, String str3, int i, String str4);
}
