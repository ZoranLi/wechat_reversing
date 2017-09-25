package com.tencent.mm.plugin.voip.b;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static Map<Integer, String> rod;

    static {
        Map hashMap = new HashMap();
        rod = hashMap;
        hashMap.put(Integer.valueOf(0), "CALLING_STATE_VIDEO_INVITING");
        rod.put(Integer.valueOf(1), "CALLING_STATE_VOICE_INVITING");
        rod.put(Integer.valueOf(2), "CALLING_STATE_VIDEO_WAITTING_ACCEPT");
        rod.put(Integer.valueOf(3), "CALLING_STATE_VOICE_WAITTING_ACCEPT");
        rod.put(Integer.valueOf(4), "CALLING_STATE_VIDEO_CONNECTING");
        rod.put(Integer.valueOf(5), "CALLING_STATE_VOICE_CONNECTING");
        rod.put(Integer.valueOf(6), "CALLING_STATE_VIDEO_TALKING");
        rod.put(Integer.valueOf(7), "CALLING_STATE_VOICE_TALKING");
        rod.put(Integer.valueOf(8), "CALLING_STATE_FINISH");
        rod.put(Integer.valueOf(256), "CALLED_STATE_VIDEO_INVITING");
        rod.put(Integer.valueOf(257), "CALLED_STATE_VOICE_INVITING");
        rod.put(Integer.valueOf(258), "CALLED_STATE_VIDEO_CONNECTING");
        rod.put(Integer.valueOf(259), "CALLED_STATE_VOICE_CONNECTING");
        rod.put(Integer.valueOf(GameJsApiLaunchApplication.CTRL_BYTE), "CALLED_STATE_VIDEO_TALKING");
        rod.put(Integer.valueOf(261), "CALLED_STATE_VOICE_TALKING");
        rod.put(Integer.valueOf(262), "CALLED_STATE_FINISH");
        rod.put(Integer.valueOf(Downloads.RECV_BUFFER_SIZE), "ACTION_NOP");
        rod.put(Integer.valueOf(4097), "ACTION_INVITE_RESPOND");
        rod.put(Integer.valueOf(4098), "ACTION_CANCEL_INVITE");
        rod.put(Integer.valueOf(4099), "ACTION_REJECT_INVITE");
        rod.put(Integer.valueOf(4100), "ACTION_ACCEPT_INVITE");
        rod.put(Integer.valueOf(4101), "ACTION_CLOSE_CAMERA");
        rod.put(Integer.valueOf(4102), "ACTION_CONNECT_SUCC");
        rod.put(Integer.valueOf(4103), "ACTION_SELF_HANGUP");
        rod.put(Integer.valueOf(4104), "ACTION_ANOTHER_HANGUP");
        rod.put(Integer.valueOf(4105), "ACTION_INVITE_TIMEOUT");
        rod.put(Integer.valueOf(4106), "ACTION_SO_SHUTDOWN");
        rod.put(Integer.valueOf(4107), "ACTION_PHONE_COMING");
        rod.put(Integer.valueOf(4108), "ACTION_IGNORE_INVITE");
        rod.put(Integer.valueOf(4109), "ACTION_ON_ERROR");
        rod.put(Integer.valueOf(4110), "ACTION_SESSION_CALLED");
    }

    public static String vf(int i) {
        if (rod.containsKey(Integer.valueOf(i))) {
            return (String) rod.get(Integer.valueOf(i));
        }
        return "no found value";
    }

    public static c vg(int i) {
        c cVar = new c(i);
        cVar.P(256, 4098, 262);
        cVar.P(256, 4099, 262);
        cVar.P(256, 4105, 262);
        cVar.P(256, 4106, 262);
        cVar.P(256, 4107, 262);
        cVar.P(256, 4108, 262);
        cVar.P(256, 4109, 262);
        cVar.P(256, 4100, 258);
        cVar.P(256, 4101, 257);
        cVar.P(257, 4100, 259);
        cVar.P(257, 4098, 262);
        cVar.P(257, 4099, 262);
        cVar.P(257, 4105, 262);
        cVar.P(257, 4106, 262);
        cVar.P(257, 4107, 262);
        cVar.P(257, 4108, 262);
        cVar.P(257, 4109, 262);
        cVar.P(258, 4098, 262);
        cVar.P(258, 4106, 262);
        cVar.P(258, 4107, 262);
        cVar.P(258, 4103, 262);
        cVar.P(258, 4109, 262);
        cVar.P(258, 4102, GameJsApiLaunchApplication.CTRL_BYTE);
        cVar.P(259, 4102, 261);
        cVar.P(259, 4098, 262);
        cVar.P(259, 4106, 262);
        cVar.P(259, 4107, 262);
        cVar.P(259, 4103, 262);
        cVar.P(259, 4109, 262);
        cVar.P(GameJsApiLaunchApplication.CTRL_BYTE, 4101, 261);
        cVar.P(GameJsApiLaunchApplication.CTRL_BYTE, 4103, 262);
        cVar.P(GameJsApiLaunchApplication.CTRL_BYTE, 4104, 262);
        cVar.P(GameJsApiLaunchApplication.CTRL_BYTE, 4106, 262);
        cVar.P(GameJsApiLaunchApplication.CTRL_BYTE, 4107, 262);
        cVar.P(GameJsApiLaunchApplication.CTRL_BYTE, 4109, 262);
        cVar.P(261, 4103, 262);
        cVar.P(261, 4104, 262);
        cVar.P(261, 4106, 262);
        cVar.P(261, 4107, 262);
        cVar.P(261, 4109, 262);
        return cVar;
    }

    public static c vh(int i) {
        c cVar = new c(i);
        cVar.P(0, 4098, 8);
        cVar.P(0, 4106, 8);
        cVar.P(0, 4107, 8);
        cVar.P(0, 4109, 8);
        cVar.P(0, 4097, 2);
        cVar.P(0, 4101, 1);
        cVar.P(1, 4097, 3);
        cVar.P(1, 4098, 8);
        cVar.P(1, 4106, 8);
        cVar.P(1, 4107, 8);
        cVar.P(1, 4109, 8);
        cVar.P(2, 4098, 8);
        cVar.P(2, 4099, 8);
        cVar.P(2, 4105, 8);
        cVar.P(2, 4106, 8);
        cVar.P(2, 4107, 8);
        cVar.P(2, 4109, 8);
        cVar.P(2, 4100, 4);
        cVar.P(2, 4101, 3);
        cVar.P(3, 4100, 5);
        cVar.P(3, 4098, 8);
        cVar.P(3, 4099, 8);
        cVar.P(3, 4105, 8);
        cVar.P(3, 4106, 8);
        cVar.P(3, 4107, 8);
        cVar.P(3, 4109, 8);
        cVar.P(4, 4102, 6);
        cVar.P(4, 4101, 5);
        cVar.P(5, 4102, 7);
        cVar.P(6, 4103, 8);
        cVar.P(6, 4104, 8);
        cVar.P(6, 4106, 8);
        cVar.P(6, 4107, 8);
        cVar.P(6, 4109, 8);
        cVar.P(6, 4101, 7);
        cVar.P(7, 4103, 8);
        cVar.P(7, 4104, 8);
        cVar.P(7, 4106, 8);
        cVar.P(7, 4107, 8);
        cVar.P(7, 4109, 8);
        cVar.P(4, 4098, 8);
        cVar.P(4, 4099, 8);
        cVar.P(4, 4106, 8);
        cVar.P(4, 4107, 8);
        cVar.P(4, 4103, 8);
        cVar.P(4, 4109, 8);
        cVar.P(5, 4098, 8);
        cVar.P(5, 4099, 8);
        cVar.P(5, 4106, 8);
        cVar.P(5, 4107, 8);
        cVar.P(5, 4103, 8);
        cVar.P(5, 4109, 8);
        cVar.P(0, 4110, 4);
        cVar.P(1, 4110, 5);
        return cVar;
    }

    public static boolean vi(int i) {
        return GameJsApiLaunchApplication.CTRL_BYTE == i || 261 == i || 6 == i || 7 == i;
    }

    public static boolean vj(int i) {
        return i == 0 || 2 == i || 4 == i || 6 == i || 256 == i || 258 == i || GameJsApiLaunchApplication.CTRL_BYTE == i;
    }

    public static boolean vk(int i) {
        return 1 == i || i == 0 || 2 == i || 3 == i;
    }

    public static int x(boolean z, boolean z2) {
        if (true == z && true == z2) {
            return 0;
        }
        if (true == z && !z2) {
            return 1;
        }
        if (z || true != z2) {
            return 257;
        }
        return 256;
    }
}
