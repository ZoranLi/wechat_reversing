package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.sdk.platformtools.ab;

public class TMAssistantProfile extends e {
    public static final String fwe = (ab.getPackageName() + ":TMAssistantDownloadSDKService");

    public final void onCreate() {
        a.b(ab.getContext(), true);
        k.bi(fwe);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.urP, TMAssistantProfile.class.getClassLoader());
        m.a(this.app);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return fwe;
    }
}
