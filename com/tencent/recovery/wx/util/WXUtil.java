package com.tencent.recovery.wx.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.recovery.util.Util;
import java.util.UUID;

public class WXUtil {
    public static String fw(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString("last_login_uin", "0");
    }

    public static String fx(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        String string = sharedPreferences.getString("login_weixin_username", "");
        if (Util.mA(string)) {
            string = sharedPreferences.getString("login_user_name", "");
        }
        if (Util.mA(string)) {
            return String.valueOf(Util.fs(context));
        }
        return string;
    }

    public static final String Va(String str) {
        if (str.contains("?")) {
            return str + "uuid=" + UUID.randomUUID().toString();
        }
        return str + "?uuid=" + UUID.randomUUID().toString();
    }

    public static final String CR(int i) {
        return "KeyConfigHttpCode[" + i + "]";
    }

    public static final String CS(int i) {
        return "KeyPatchHttpCode[" + i + "]";
    }
}
