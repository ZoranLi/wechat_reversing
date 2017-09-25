package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class l extends o {
    protected boolean ahh;
    protected String ahs;
    protected String aht;
    protected int ahv;
    protected boolean aic;
    protected int aid;
    protected boolean aie;
    protected boolean aif;

    public l(q qVar) {
        super(qVar);
    }

    public final int getLogLevel() {
        ie();
        return this.aid;
    }

    public final String hQ() {
        ie();
        return this.aht;
    }

    public final String hR() {
        ie();
        return this.ahs;
    }

    public final boolean hS() {
        ie();
        return this.aic;
    }

    public final boolean hT() {
        ie();
        return this.aie;
    }

    public final int hU() {
        ie();
        return this.ahv;
    }

    public final boolean hV() {
        ie();
        return this.aif;
    }

    public final boolean hW() {
        ie();
        return this.ahh;
    }

    protected final void hu() {
        ApplicationInfo applicationInfo;
        Context context = this.ahK.mContext;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            f("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            F("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                b bVar = (b) new ak(this.ahK).bL(i);
                if (bVar != null) {
                    String str;
                    int i2;
                    C("Loading global XML config values");
                    if (bVar.ahs != null) {
                        str = bVar.ahs;
                        this.ahs = str;
                        e("XML config - app name", str);
                    }
                    if (bVar.aht != null) {
                        str = bVar.aht;
                        this.aht = str;
                        e("XML config - app version", str);
                    }
                    if (bVar.ahu != null) {
                        str = bVar.ahu.toLowerCase();
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.aid = i2;
                            d("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if (bVar.ahv >= 0) {
                        i2 = bVar.ahv;
                        this.ahv = i2;
                        this.aie = true;
                        e("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (bVar.ahw != -1) {
                        boolean z = bVar.ahw == 1;
                        this.ahh = z;
                        this.aif = true;
                        e("XML config - dry run", Boolean.valueOf(z));
                    }
                }
            }
        }
    }
}
