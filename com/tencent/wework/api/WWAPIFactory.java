package com.tencent.wework.api;

import android.content.Context;

public class WWAPIFactory {
    public static IWWAPI hM(Context context) {
        return new WWAPIImpl(context);
    }
}
