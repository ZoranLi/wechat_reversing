package com.google.android.gms.signin;

import com.google.android.gms.common.api.c.d;

public final class e {
    public static final e aDB = new a().lJ();
    public final boolean aDC;
    public final boolean aDD;
    public final d aDE;
    public final String alT;

    public static final class a {
        private boolean aDF;
        private boolean aDG;
        private String aDH;
        private d aDI;

        public final e lJ() {
            return new e(this.aDF, this.aDG, this.aDH, this.aDI);
        }
    }

    public e(boolean z, boolean z2, String str, d dVar) {
        this.aDC = z;
        this.aDD = z2;
        this.alT = str;
        this.aDE = dVar;
    }
}
