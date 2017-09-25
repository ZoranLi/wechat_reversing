package com.tencent.mm.app;

import android.content.Context;
import com.tencent.recovery.Recovery;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.tinker.loader.app.TinkerApplication;

public class Application extends TinkerApplication {
    static {
        Recovery.eF();
    }

    protected void attachBaseContext(Context context) {
        Recovery.a(this, context);
        if (RecoveryLogic.cdw()) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate() {
        if (!RecoveryLogic.cdw()) {
            super.onCreate();
        }
        Recovery.cds();
    }

    public Application() {
        super(7, "com.tencent.mm.app.MMApplicationLike", "com.tencent.tinker.loader.TinkerLoader", true);
    }
}
