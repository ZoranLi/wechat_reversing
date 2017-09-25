package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class s {
    final Map<String, String> ahx;
    final long aiH = 0;
    final String aiI;
    final String aiJ;
    final boolean aiK;
    long aiL;

    public s(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        w.U(str);
        w.U(str2);
        this.aiI = str;
        this.aiJ = str2;
        this.aiK = z;
        this.aiL = j2;
        if (map != null) {
            this.ahx = new HashMap(map);
        } else {
            this.ahx = Collections.emptyMap();
        }
    }
}
