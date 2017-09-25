package com.tencent.mm.i;

import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public class a {
    public static final String gTd = null;
    private static SharedPreferences gTe = null;
    private static SharedPreferences gTf = null;
    private static String gTg = gTd;

    public static SharedPreferences sj() {
        SharedPreferences MH = z.MH();
        gTf = MH;
        return MH;
    }

    public static boolean sk() {
        return com.tencent.mm.kernel.a.uT().getBoolean("command_notification_status", false);
    }

    public static boolean sl() {
        return com.tencent.mm.kernel.a.uT().getBoolean("settings_new_msg_notification", true);
    }

    public static boolean sm() {
        return com.tencent.mm.kernel.a.uT().getBoolean("settings_new_voip_msg_notification", true);
    }

    public static boolean sn() {
        return com.tencent.mm.kernel.a.uT().getBoolean("settings_show_detail", true);
    }

    public static boolean so() {
        return com.tencent.mm.kernel.a.uT().getBoolean("settings_sound", true);
    }

    public static String sp() {
        String string = com.tencent.mm.kernel.a.uT().getString("settings.ringtone", gTd);
        if (!(string == gTd || string.equals(gTg))) {
            RingtoneManager ringtoneManager = new RingtoneManager(ab.getContext());
            ringtoneManager.setType(2);
            if (ringtoneManager.getRingtonePosition(Uri.parse(string)) < 0) {
                string = gTd;
                dA(string);
                w.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
            }
            gTg = string;
        }
        return string;
    }

    static void dA(String str) {
        ab.bIY().edit().putString("settings.ringtone", str).commit();
        com.tencent.mm.kernel.a.uT().edit().putString("settings.ringtone", str).commit();
    }

    public static boolean sq() {
        return com.tencent.mm.kernel.a.uT().getBoolean("settings_shake", true);
    }

    public static boolean sr() {
        return com.tencent.mm.kernel.a.uT().getBoolean("settings_active_time_full", true);
    }

    public static int ss() {
        return com.tencent.mm.kernel.a.uT().getInt("settings_active_begin_time_hour", 8);
    }

    public static int st() {
        return com.tencent.mm.kernel.a.uT().getInt("settings_active_end_time_hour", 23);
    }

    public static int su() {
        return com.tencent.mm.kernel.a.uT().getInt("settings_active_begin_time_min", 0);
    }

    public static int sv() {
        return com.tencent.mm.kernel.a.uT().getInt("settings_active_end_time_min", 0);
    }

    public static boolean az(int i, int i2) {
        if (sr()) {
            return true;
        }
        int ss = ss();
        int su = su();
        int st = st();
        int sv = sv();
        if (ss == st && su == sv) {
            return false;
        }
        if (ss != st || su >= sv) {
            if (st > ss) {
                if (i > ss && i < st) {
                    return true;
                }
                if (i == ss && i2 > su) {
                    return true;
                }
                if (i != st || i2 >= sv) {
                    return false;
                }
                return true;
            } else if (st >= ss && (ss != st || su <= sv)) {
                return true;
            } else {
                if (i > ss && i <= 23) {
                    return true;
                }
                if (i == ss && i2 > su) {
                    return true;
                }
                if (i == st && i2 < sv) {
                    return true;
                }
                if (i <= 0 || i >= st) {
                    return false;
                }
                return true;
            }
        } else if (i != ss || i2 <= su || i2 >= sv) {
            return false;
        } else {
            return true;
        }
    }
}
