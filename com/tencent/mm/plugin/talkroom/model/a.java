package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.compatible.d.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class a {
    private static int qXE;
    public static final int qXr;

    static {
        int rl = l.rl();
        qXE = rl;
        qXr = (rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 16000 : 8000;
    }
}
