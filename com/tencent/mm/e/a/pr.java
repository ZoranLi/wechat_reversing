package com.tencent.mm.e.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;

public final class pr extends com.tencent.mm.sdk.b.b {
    public a fWB;
    public b fWC;

    public static final class a {
        public String appId;
        public Context context;
        public String fCN;
        public Bundle fFu;
        public String fKS;
        public String fWD;
        public int fWE;
        public int fWF;
        public String fWG;
        public boolean fWH;
        public boolean fWI = true;
        public LaunchParamsOptional fWJ = new LaunchParamsOptional();
        public int fWK;
        public int fWL;
        public String fWM;
        public int scene;
        public String userName;
    }

    public static final class b {
        public boolean fWN;
        public String fWO;
    }

    public pr() {
        this((byte) 0);
    }

    private pr(byte b) {
        this.fWB = new a();
        this.fWC = new b();
        this.use = false;
        this.nFq = null;
    }
}
