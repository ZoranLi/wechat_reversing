package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.bg;

public final class u {
    private static volatile u sCM = null;

    public static class a {
        public int sCN;
        public int sCO;
        public String sCP;
        public int sCQ;
        public String sCR;
    }

    private u() {
    }

    public static u bCJ() {
        if (sCM == null) {
            synchronized (u.class) {
                if (sCM == null) {
                    sCM = new u();
                }
            }
        }
        return sCM;
    }

    public static t t(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return new x();
            case 2:
                return new a(bundle);
            default:
                return new q();
        }
    }

    public static int wW(int i) {
        switch (i) {
            case 0:
                return bg.getInt(g.sW().z("QQBroswer", "RecommendCount"), 5);
            case 1:
                return Integer.MAX_VALUE;
            default:
                return 5;
        }
    }

    public static void wX(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.oUh.i(10998, Integer.valueOf(0));
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.oUh.i(11091, Integer.valueOf(0));
                return;
            default:
                return;
        }
    }

    public static void wY(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.oUh.i(10998, Integer.valueOf(1));
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.oUh.i(11091, Integer.valueOf(1));
                return;
            default:
                return;
        }
    }

    public static void wZ(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.oUh.i(10998, Integer.valueOf(3));
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.oUh.i(11091, Integer.valueOf(3));
                return;
            default:
                return;
        }
    }

    public static void xa(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.oUh.i(10998, Integer.valueOf(2));
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.oUh.i(11091, Integer.valueOf(2));
                return;
            default:
                return;
        }
    }
}
