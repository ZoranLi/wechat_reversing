package com.tencent.mm.e.a;

import com.tencent.mm.protocal.c.aiw;
import java.util.List;

public final class ji extends com.tencent.mm.sdk.b.b {
    public a fPD;
    public b fPE;

    public static final class a {
        public int fJA = 0;
        public float fOb = 0.0f;
        public float fPF = 0.0f;
        public int fPG = 0;
        public int fPH = 0;
        public String fPI;
        public String fPJ;
        public boolean fPm = false;
    }

    public static final class b {
        public int fJA = 0;
        public boolean fPK = false;
        public List<aiw> fPL;
        public int fPM = -1;
    }

    public ji() {
        this((byte) 0);
    }

    private ji(byte b) {
        this.fPD = new a();
        this.fPE = new b();
        this.use = false;
        this.nFq = null;
    }
}
