package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.common.c.d;

public final class j {
    public static boolean Wo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("client_");
    }

    public static int chP() {
        int i = 0;
        try {
            return a.chg().mUm;
        } catch (Exception e) {
            d.k("tagorewang:VoiceGroupUtil", "getActiveRoomId err: ", e);
            return i;
        }
    }

    public static long chQ() {
        try {
            return a.chg().xkb;
        } catch (Exception e) {
            d.k("tagorewang:VoiceGroupUtil", "getActiveRoomKey err: ", e);
            return 0;
        }
    }
}
