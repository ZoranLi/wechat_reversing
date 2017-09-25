package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

final class ad implements b {
    private int aid = 2;
    private boolean ajF;

    ad() {
    }

    public final int getLogLevel() {
        return this.aid;
    }

    public final void setLogLevel(int i) {
        this.aid = i;
        if (!this.ajF) {
            aj.ajQ.get();
            new StringBuilder("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append((String) aj.ajQ.get()).append(" DEBUG");
            this.ajF = true;
        }
    }
}
