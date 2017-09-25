package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class e {
    public String gWO;
    public a gZy = new a();
    public Application gZz;

    public abstract String getPackageName();

    public e(String str, Application application) {
        this.gWO = str;
        this.gZz = application;
    }

    public String toString() {
        return this.gWO != null ? this.gWO : super.toString();
    }

    public final boolean ej(String str) {
        return this.gWO != null && this.gWO.equals(getPackageName() + str);
    }
}
