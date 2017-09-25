package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.sdk.platformtools.bg;

public final class n {
    public static boolean alN() {
        if ((g.sV().getInt("EmotionRewardOption", 0) & 1) == 1) {
            return false;
        }
        return true;
    }

    public static int alO() {
        return bg.getInt(g.sV().getValue("CustomEmojiMaxSize"), ck.CTRL_INDEX);
    }

    public static String alP() {
        return g.sV().getValue("EmotionPanelConfigName");
    }
}
