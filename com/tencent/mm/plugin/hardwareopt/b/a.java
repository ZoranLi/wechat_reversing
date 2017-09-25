package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.mm.protocal.c.aew;

public class a {
    private static a mKS = null;
    private aew mKT = null;

    private a() {
    }

    public static a aCX() {
        if (mKS != null) {
            return mKS;
        }
        a aVar;
        synchronized (a.class) {
            if (mKS == null) {
                mKS = new a();
            }
            aVar = mKS;
        }
        return aVar;
    }

    public final aew aCY() {
        if (this.mKT == null) {
            this.mKT = new aew();
        }
        return this.mKT;
    }
}
