package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

enum b {
    WALLET("weapp://wallet/", 1019),
    SEARCH_NATIVE_FEATURE("weapp://search/", MMBitmapFactory.ERROR_IO_FAILED);
    
    final String hRn;
    final int scene;

    private b(String str, int i) {
        this.hRn = str;
        this.scene = i;
    }

    static String Vg() {
        return "";
    }

    static int Vh() {
        return 0;
    }

    static String Vi() {
        return "";
    }
}
