package com.tencent.mm.i;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.kernel.a;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.h;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import java.util.List;
import java.util.Map;

public final class f extends a {
    private static String TAG = "MicroMsg.NotificationConfig";

    public static void aF(boolean z) {
        ab.bIY().edit().putBoolean("settings_new_msg_notification", z).commit();
        a.uT().edit().putBoolean("settings_new_msg_notification", z).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", Boolean.valueOf(z));
    }

    public static void aG(boolean z) {
        ab.bIY().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        a.uT().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", Boolean.valueOf(z));
    }

    public static void aH(boolean z) {
        ab.bIY().edit().putBoolean("settings_show_detail", z).commit();
        a.uT().edit().putBoolean("settings_show_detail", z).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", Boolean.valueOf(z));
    }

    public static void aI(boolean z) {
        a.uT().edit().putBoolean("command_notification_status", z).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]is notification by system: %B", Boolean.valueOf(z));
    }

    public static void aJ(boolean z) {
        ab.bIY().edit().putBoolean("settings_sound", z).commit();
        a.uT().edit().putBoolean("settings_sound", z).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", Boolean.valueOf(z));
    }

    public static void aK(boolean z) {
        ab.bIY().edit().putBoolean("settings_shake", z).commit();
        a.uT().edit().putBoolean("settings_shake", z).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", Boolean.valueOf(z));
    }

    public static void dA(String str) {
        a.dA(str);
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", str);
    }

    public static void aL(boolean z) {
        ab.bIY().edit().putBoolean("settings_active_time_full", z).commit();
        a.uT().edit().putBoolean("settings_active_time_full", z).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", Boolean.valueOf(z));
    }

    public static void aA(int i, int i2) {
        SharedPreferences bIY = ab.bIY();
        bIY.edit().putInt("settings_active_begin_time_hour", i).commit();
        bIY.edit().putInt("settings_active_begin_time_min", i2).commit();
        bIY = a.uT();
        bIY.edit().putInt("settings_active_begin_time_hour", i).commit();
        bIY.edit().putInt("settings_active_begin_time_min", i2).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void aB(int i, int i2) {
        SharedPreferences bIY = ab.bIY();
        bIY.edit().putInt("settings_active_end_time_hour", i).commit();
        bIY.edit().putInt("settings_active_end_time_min", i2).commit();
        bIY = a.uT();
        bIY.edit().putInt("settings_active_end_time_hour", i).commit();
        bIY.edit().putInt("settings_active_end_time_min", i2).commit();
        w.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static boolean sM() {
        return c.eN(a.uS());
    }

    public static void et(int i) {
        a.uT().edit().putInt("notification.status.webonline.push.open", i).commit();
    }

    public static boolean sN() {
        return m.eV(a.uT().getInt("notification.status.webonline.push.open", 0));
    }

    public static void sO() {
        SharedPreferences bIY = ab.bIY();
        Editor edit = a.uT().edit();
        edit.putBoolean("settings_new_msg_notification", bIY.getBoolean("settings_new_msg_notification", true));
        edit.putBoolean("settings_new_voip_msg_notification", bIY.getBoolean("settings_new_voip_msg_notification", true));
        edit.putBoolean("settings_show_detail", bIY.getBoolean("settings_show_detail", true));
        edit.putBoolean("settings_sound", bIY.getBoolean("settings_sound", true));
        edit.putString("settings.ringtone", bIY.getString("settings.ringtone", gTd));
        edit.putBoolean("settings_shake", bIY.getBoolean("settings_shake", true));
        edit.putBoolean("settings_active_time_full", bIY.getBoolean("settings_active_time_full", true));
        edit.putInt("settings_active_begin_time_hour", bIY.getInt("settings_active_begin_time_hour", 8));
        edit.putInt("settings_active_begin_time_min", bIY.getInt("settings_active_begin_time_min", 0));
        edit.putInt("settings_active_end_time_hour", bIY.getInt("settings_active_end_time_hour", 23));
        edit.putInt("settings_active_end_time_min", bIY.getInt("settings_active_end_time_min", 0));
        edit.commit();
        w.i(TAG, "notification config copyDefault, newMsgNotification: %B, showDetail: %B, isSound: %B, ringTone: %s, isShake: %B, isActiveTime: %B, begin: %d:%d, end: %d:Td", Boolean.valueOf(r2), Boolean.valueOf(r3), Boolean.valueOf(r4), r5, Boolean.valueOf(r6), Boolean.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r0));
    }

    public static boolean eu(int i) {
        return i == 50 || i == 53;
    }

    public static boolean dD(String str) {
        b rrVar = new rr();
        rrVar.fYI.fJK = 1;
        rrVar.fYI.content = str;
        com.tencent.mm.sdk.b.a.urY.m(rrVar);
        if (rrVar.fYJ.type == 2 || str.equals(au.uJR)) {
            return true;
        }
        return false;
    }

    public static boolean dE(String str) {
        b rrVar = new rr();
        rrVar.fYI.fJK = 1;
        rrVar.fYI.content = str;
        com.tencent.mm.sdk.b.a.urY.m(rrVar);
        if (rrVar.fYJ.type == 3 || str.equals(au.uJQ)) {
            return true;
        }
        return false;
    }

    public static int d(au auVar) {
        int i = o.eV(auVar.field_talker) ? 0 : 3;
        if (!(auVar == null || auVar.field_bizChatId == -1 || !e.dr(auVar.field_talker))) {
            com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(auVar.field_bizChatId);
            if (!aa.DV() && aa.fu(1)) {
                return i;
            }
        }
        String str = auVar.gxF;
        if (bg.mA(str)) {
            return i;
        }
        Map q = bh.q(str, "msgsource");
        if (q == null || q.isEmpty()) {
            return i;
        }
        try {
            int parseInt = Integer.parseInt((String) q.get(".msgsource.tips"));
            if ((parseInt & 1) != 0 || (parseInt & 2) == 0) {
                return parseInt;
            }
            return 0;
        } catch (Exception e) {
            return i;
        }
    }

    public static int sP() {
        if (ap.zb()) {
            return p.fN(o.hlr);
        }
        w.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
        return 0;
    }

    public static List<String> sQ() {
        return p.s(o.hlr, -1);
    }

    public static int sR() {
        if (ap.zb()) {
            return p.fM(o.hlr);
        }
        w.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
        return 0;
    }

    public static int dF(String str) {
        return p.F(str, null);
    }

    public static boolean dG(String str) {
        return x.eO(str);
    }

    public static boolean dH(String str) {
        return str.toLowerCase().endsWith("@chatroom");
    }

    public static int sS() {
        return h.xI();
    }

    public static boolean dI(String str) {
        return o.fJ(str) || (o.dH(str) && !o.fI(str));
    }

    public static int dJ(String str) {
        ap.yY();
        return c.wW().Rz(str);
    }

    public static boolean e(au auVar) {
        if (auVar == null) {
            return false;
        }
        return auVar.RE(m.xL());
    }

    public static boolean sT() {
        ap.yY();
        return ((Boolean) c.vr().get(73217, Boolean.valueOf(true))).booleanValue();
    }

    public static boolean sU() {
        ap.yY();
        return ((Boolean) c.vr().get(73218, Boolean.valueOf(true))).booleanValue();
    }
}
