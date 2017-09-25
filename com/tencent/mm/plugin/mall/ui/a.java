package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.x;

public final class a {
    private static int nvv = 39;
    private static int nvw = 40;
    private static int nvx = 95;
    private static int nvy = 0;
    private static int nvz = 0;

    public static void c(MMActivity mMActivity) {
        int height;
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(mMActivity, nvv);
        int fromDPToPix2 = com.tencent.mm.bg.a.fromDPToPix(mMActivity, nvw);
        int i = x.eG(mMActivity).y;
        if (x.eF(mMActivity)) {
            i -= x.eE(mMActivity);
        }
        if (mMActivity.cO().cP() != null) {
            height = mMActivity.cO().cP().getHeight();
        } else {
            height = 0;
        }
        int fromDPToPix3 = com.tencent.mm.bg.a.fromDPToPix(mMActivity, nvx);
        nvy = Math.round(((float) (((i - (fromDPToPix * 2)) - fromDPToPix2) - height)) / 5.0f);
        w.i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", new Object[]{Integer.valueOf(nvy), Integer.valueOf(fromDPToPix3)});
        if (nvy < fromDPToPix3) {
            nvy = fromDPToPix3;
        }
        nvz = Math.round(((float) (nvy * 4)) / 3.0f);
        w.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[]{Integer.valueOf(nvy), Integer.valueOf(nvz)});
    }

    public static int aIR() {
        return nvy;
    }

    public static int aIS() {
        return nvz;
    }

    public static int aIT() {
        return com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), nvv);
    }
}
