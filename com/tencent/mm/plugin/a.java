package com.tencent.mm.plugin;

import com.tencent.mm.modelstat.p;
import com.tencent.mm.u.l;

public final class a extends l {
    private static a imu;

    public static synchronized a NH() {
        a aVar;
        synchronized (a.class) {
            if (imu == null) {
                imu = new a();
            }
            aVar = imu;
        }
        return aVar;
    }

    private a() {
        super(p.class);
    }
}
