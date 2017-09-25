package com.tinkerboots.sdk.b;

import android.content.Context;

public final class b {
    public static Context context;

    public static Context getContext() {
        if (context != null) {
            return context;
        }
        throw new RuntimeException("TinkerClientContext, context is null, please init first");
    }
}
