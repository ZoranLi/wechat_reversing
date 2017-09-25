package com.tencent.mm.i;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public static int sw() {
        return bg.getInt(g.sV().getValue("InputLimitSessionTextMsg"), 8192) * 2;
    }

    public static int sx() {
        return bg.getInt(g.sV().getValue("InputLimitSNSObjectText"), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) * 2;
    }

    public static int sy() {
        return bg.getInt(g.sV().getValue("SnsCommentMaxSize"), 1000) * 2;
    }

    public static int sz() {
        return bg.getInt(g.sV().getValue("InputLimitFavText"), 100000) * 2;
    }

    public static int sA() {
        return bg.getInt(g.sV().getValue("InputLimitSendEmotionBufSize"), 1048576);
    }

    public static int sB() {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        try {
            i = bg.getInt(g.sV().getValue("InputLimitSendEmotionWidth"), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } catch (Exception e) {
            w.h("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", e);
        }
        return i;
    }

    public static int sC() {
        int i = 5242880;
        try {
            i = bg.getInt(g.sV().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
        } catch (Exception e) {
            w.h("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", e);
        }
        return i;
    }

    public static int sD() {
        return bg.getInt(g.sV().getValue("InputLimitFavImageSize"), 26214400);
    }

    public static String sE() {
        return g.sV().getValue("InputLimitForbiddenChar");
    }
}
