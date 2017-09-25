package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;

public class NoSpaceProfile extends e {
    public static final String fwe = (ab.getPackageName() + ":nospace");

    public final void onCreate() {
        k.b(a.urP, NoSpaceProfile.class.getClassLoader());
        k.bi(fwe);
        k.setupBrokenLibraryHandler();
        bg.et(ab.getContext());
        m.a(this.app);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }
}
