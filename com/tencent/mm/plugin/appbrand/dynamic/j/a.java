package com.tencent.mm.plugin.appbrand.dynamic.j;

import com.tencent.mars.cdn.CdnLogic;

public final class a {
    public static int bn(int i, int i2) {
        if (i == 0) {
            switch (i2) {
                case 1:
                    return 10000;
                case 2:
                    return CdnLogic.MediaType_FAVORITE_FILE;
                default:
                    return CdnLogic.MediaType_FAVORITE_VIDEO;
            }
        } else if (i != 1) {
            return Integer.MIN_VALUE;
        } else {
            switch (i2) {
                case 1:
                    return 10100;
                case 2:
                    return 10101;
                default:
                    return 10102;
            }
        }
    }

    public static int hF(int i) {
        switch (i) {
            case 10000:
            case 10100:
                return 1;
            case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
            case 10101:
                return 2;
            default:
                return 0;
        }
    }
}
