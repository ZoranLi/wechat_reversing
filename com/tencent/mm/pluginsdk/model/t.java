package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mm.pluginsdk.model.u.a;

public abstract class t {
    public abstract boolean LN(String str);

    public abstract String Nn();

    public abstract String bCA();

    public abstract a bCB();

    public abstract boolean dt(Context context);

    public boolean v(Context context, Intent intent) {
        return false;
    }

    public String a(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
