package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class m {
    private static final Object aqT = new Object();
    private static m aqU;

    public static m B(Context context) {
        synchronized (aqT) {
            if (aqU == null) {
                aqU = new n(context.getApplicationContext());
            }
        }
        return aqU;
    }

    public abstract boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean a(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void b(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void b(String str, String str2, ServiceConnection serviceConnection, String str3);
}
