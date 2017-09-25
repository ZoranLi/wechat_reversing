package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mars.cdn.CdnLogic;

public interface c {
    public static final int[] iyB = new int[]{0, CdnLogic.MediaType_FAVORITE_VIDEO, 10102};
    public static final int[] iyC = new int[]{1, 2, 999, 10000, CdnLogic.MediaType_FAVORITE_FILE, 10100, 10101};

    public enum a {
        ;

        public static boolean hv(int i) {
            return com.tencent.mm.compatible.loader.a.b(c.iyB, i);
        }

        public static boolean fp(int i) {
            return com.tencent.mm.compatible.loader.a.b(c.iyC, i);
        }
    }
}
